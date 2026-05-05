package kadysoft.kady;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.util.Base64;

public class GeminiOCRApp extends Application {

    private TextField apiKeyField;
    private TextField imagePathField;
    private TextArea outputArea;
    private String encodedImage = null;  // Stores Base64-encoded image

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Gemini OCR - Extract Text from Image");

        // UI Components
        apiKeyField = new TextField();
        apiKeyField.setPromptText("Enter your Gemini API Key");

        Button selectImageBtn = new Button("Select Image");
        imagePathField = new TextField();
        imagePathField.setPromptText("No image selected");
        imagePathField.setEditable(false);

        Button processBtn = new Button("Extract Text");
        outputArea = new TextArea();
        outputArea.setPromptText("Extracted text will appear here...");
        outputArea.setWrapText(true);
        outputArea.setEditable(false);

        // Layout
        VBox layout = new VBox(10, apiKeyField, selectImageBtn, imagePathField, processBtn, outputArea);
        layout.setPadding(new Insets(20));

        // Event Handlers
        selectImageBtn.setOnAction(e -> selectImage(primaryStage));
        processBtn.setOnAction(e -> processImage());

        // Show Scene
        Scene scene = new Scene(layout, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void selectImage(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images", "*.png", "*.jpg", "*.jpeg"));
        File selectedFile = fileChooser.showOpenDialog(stage);

        if (selectedFile != null) {
            try {
                encodedImage = encodeImageToBase64(selectedFile);
                imagePathField.setText(selectedFile.getAbsolutePath());
            } catch (IOException e) {
                outputArea.setText("?? Error encoding image: " + e.getMessage());
            }
        }
    }

    private String encodeImageToBase64(File imageFile) throws IOException {
        byte[] imageBytes = Files.readAllBytes(imageFile.toPath());
        return Base64.getEncoder().encodeToString(imageBytes);
    }

    private void processImage() {
        String apiKey = apiKeyField.getText().trim();
        if (apiKey.isEmpty()) {
            outputArea.setText("?? Please enter your API key.");
            return;
        }
        if (encodedImage == null) {
            outputArea.setText("?? Please select an image first.");
            return;
        }

        outputArea.setText("? Processing image...");
        Task<String> task = new Task<String>() {
            @Override
            protected String call() {
                return sendApiRequest(apiKey, encodedImage);
            }
        };

        task.setOnSucceeded(event -> outputArea.setText(task.getValue()));
        new Thread(task).start();
    }

  
    private String sendApiRequest(String apiKey, String base64Image) {
    try {
        String apiUrl = "https://generativelanguage.googleapis.com/v1/models/gemini-pro:generateContent?key=" + apiKey;

        // Create JSON Request
        JsonObject requestJson = new JsonObject();
        JsonArray contentsArray = new JsonArray();
        JsonArray partsArray = new JsonArray();

        // Add text instruction (to tell Gemini what to do)
        JsonObject textPart = new JsonObject();
        textPart.addProperty("text", "Extract the text from this image.");
        partsArray.add(textPart);

        // Add image part
        JsonObject imagePart = new JsonObject();
        imagePart.addProperty("mimeType", "image/jpeg");
        imagePart.addProperty("data", base64Image);
        partsArray.add(imagePart);

        JsonObject contentObject = new JsonObject();
        contentObject.add("parts", partsArray);
        contentsArray.add(contentObject);
        requestJson.add("contents", contentsArray);

        // Send API Request
        URL url = new URL(apiUrl);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json");
        con.setDoOutput(true);

        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
            wr.write(requestJson.toString().getBytes());
        }

        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            return parseApiResponse(new BufferedReader(new InputStreamReader(con.getInputStream())));
        } else {
            return "⚠️ API Error: " + responseCode + " - " + parseApiResponse(new BufferedReader(new InputStreamReader(con.getErrorStream())));
        }

    } catch (IOException e) {
        return "⚠️ Network error: " + e.getMessage();
    }
}

    
    

    private String parseApiResponse(BufferedReader reader) throws IOException {
        StringBuilder response = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        try {
            JsonObject jsonObject = JsonParser.parseString(response.toString()).getAsJsonObject();
            if (jsonObject.has("candidates")) {
                JsonArray candidatesArray = jsonObject.getAsJsonArray("candidates");
                if (!candidatesArray.isEmpty()) {
                    JsonObject candidateObject = candidatesArray.get(0).getAsJsonObject();
                    if (candidateObject.has("content")) {
                        JsonObject contentObject = candidateObject.getAsJsonObject("content");
                        if (contentObject.has("parts")) {
                            JsonArray partsArray = contentObject.getAsJsonArray("parts");
                            if (!partsArray.isEmpty()) {
                                JsonObject textPart = partsArray.get(0).getAsJsonObject();
                                if (textPart.has("text")) {
                                    return textPart.get("text").getAsString();
                                }
                            }
                        }
                    }
                }
            }
            return "?? No text found in the image.";
        } catch (Exception e) {
            return "?? Error parsing response: " + e.getMessage();
        }
    }
}
