


//AIzaSyAcStaDojy1Bi7soLpDtmuJK3GbzLnpWfU



package kadysoft.kady;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.FileChooser;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.ResourceBundle;

public class ChatGPTController implements Initializable {

    @FXML
    private JFXTextField message;

    @FXML
    private JFXTextArea answer;

    @FXML
    private JFXButton askbtn, clear, browseBtn;

    @FXML
    private JFXSpinner loading;

    private static final String API_KEY = "AIzaSyAcStaDojy1Bi7soLpDtmuJK3GbzLnpWfU"; // Replace with your actual API key
    private static final String ENDPOINT_URL = "https://generativelanguage.googleapis.com/v1/models/gemini-1.5-flash:generateContent?key=" + API_KEY;

    private File selectedImage; // Store the selected image file

    @FXML
    void clearaction(ActionEvent event) {
        message.clear();
        answer.clear();
        selectedImage = null;
    }

    @FXML
    void askbtnaction(ActionEvent event) {
        loading.setVisible(true);
        answer.appendText("\nProcessing...\n");

        Task<Void> task = new Task<Void>() {
            @Override
            protected Void call() {
                try {
                    if (selectedImage != null) {
                        sendImageRequest(selectedImage);
                    } else if (!message.getText().trim().isEmpty()) {
                        sendTextRequest(message.getText().trim());
                    } else {
                        appendToAnswer("\n⚠️ Please enter a message or select an image.\n");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    appendToAnswer("\n⚠️ Error: " + e.getMessage() + "\n");
                }
                return null;
            }
        };

        task.setOnSucceeded(event1 -> {
            loading.setVisible(false);
            message.clear();
        });

        new Thread(task).start();
    }

    @FXML
    void browseImage(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg", "*.png"));
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            selectedImage = file;
            appendToAnswer("\n📷 Selected Image: " + file.getName() + "\n");
        }
    }

    private void sendTextRequest(String userInput) {
        try {
            JsonObject requestJson = new JsonObject();
            JsonArray contentsArray = new JsonArray();
            JsonObject contentObject = new JsonObject();
            JsonArray partsArray = new JsonArray();
            JsonObject partObject = new JsonObject();

            partObject.addProperty("text", userInput);
            partsArray.add(partObject);
            contentObject.add("parts", partsArray);
            contentsArray.add(contentObject);
            requestJson.add("contents", contentsArray);

            sendApiRequest(requestJson);
        } catch (Exception e) {
            e.printStackTrace();
            appendToAnswer("\n⚠️ Error: " + e.getMessage() + "\n");
        }
    }

    private void sendImageRequest(File imageFile) {
    try {
        byte[] fileContent = Files.readAllBytes(Paths.get(imageFile.getAbsolutePath()));
        String base64Image = Base64.getEncoder().encodeToString(fileContent);

        JsonObject requestJson = new JsonObject();
        JsonArray contentsArray = new JsonArray();
        JsonObject contentObject = new JsonObject();
        JsonArray partsArray = new JsonArray();
        
        // Add text prompt
        JsonObject textPart = new JsonObject();
        textPart.addProperty("text", "Extract the text from this image.");

        // Add image part
        JsonObject imagePart = new JsonObject();
        JsonObject inlineData = new JsonObject();
        inlineData.addProperty("mime_type", "image/jpeg");
        inlineData.addProperty("data", base64Image);
        imagePart.add("inline_data", inlineData);

        // Combine text and image
        partsArray.add(textPart);
        partsArray.add(imagePart);
        contentObject.add("parts", partsArray);
        contentsArray.add(contentObject);
        requestJson.add("contents", contentsArray);

        sendApiRequest(requestJson);
    } catch (IOException e) {
        e.printStackTrace();
        appendToAnswer("\n⚠️ Error: " + e.getMessage() + "\n");
    }
}


    private void sendApiRequest(JsonObject requestJson) {
        try {
            URL url = new URL(ENDPOINT_URL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setDoOutput(true);

            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(requestJson.toString().getBytes());
            }

            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == 200) {
                StringBuilder response = new StringBuilder();
                try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                    }
                }
                parseApiResponse(response.toString());
            } else {
                handleErrorResponse(con);
            }

        } catch (IOException e) {
            e.printStackTrace();
            appendToAnswer("\n⚠️ Network error: " + e.getMessage() + "\n");
        }
    }

    private void parseApiResponse(String jsonResponse) {
        try {
            JsonObject jsonObject = JsonParser.parseString(jsonResponse).getAsJsonObject();
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
                                    String aiResponse = textPart.get("text").getAsString();
                                    appendToAnswer("\nAI: " + aiResponse + "\n");
                                    return;
                                }
                            }
                        }
                    }
                }
            }
            appendToAnswer("\n⚠️ No valid response from AI. Please try again.\n");
        } catch (Exception e) {
            e.printStackTrace();
            appendToAnswer("\n⚠️ Error parsing response: " + e.getMessage() + "\n");
        }
    }

    private void handleErrorResponse(HttpURLConnection con) {
        try {
            StringBuilder errorResponse = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getErrorStream()))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    errorResponse.append(inputLine);
                }
            }
            appendToAnswer("\n⚠️ API error: " + errorResponse + "\n");
        } catch (IOException e) {
            e.printStackTrace();
            appendToAnswer("\n⚠️ Error handling response: " + e.getMessage() + "\n");
        }
    }

    private void appendToAnswer(String text) {
        javafx.application.Platform.runLater(() -> answer.appendText(text));
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loading.setVisible(false);
    }
}
