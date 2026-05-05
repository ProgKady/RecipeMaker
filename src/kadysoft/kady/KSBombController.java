
//AIzaSyAcStaDojy1Bi7soLpDtmuJK3GbzLnpWfU

package kadysoft.kady;


import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.image.BufferedImage;
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
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.controlsfx.control.Notifications;

public class KSBombController implements Initializable {


   @FXML
    private JFXTextArea answer;

    @FXML
    private JFXButton browseBtn;

    @FXML
    private JFXButton askbtn;

    @FXML
    private JFXSpinner loading;

    @FXML
    private ImageView imageview;

    @FXML
    private JFXTextArea message;

    @FXML
    private JFXButton clearall;

    @FXML
    private JFXButton exportdata;

 
    static {
        String dllPath = readDllPathFromFile("Open_CV.kady");
        if (dllPath != null) {
            System.load(dllPath);
        } else {
        }
    }
    
    
    // 🔹 Read the DLL path from a config file
    private static String readDllPathFromFile(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.readLine().trim();
           
        } catch (IOException e) {
            System.err.println("⚠️ Error reading DLL path: " + e.getMessage());
            return null;
        }
    }
    
    public static String useb,drib,imoo,keyy,keyyy,imglink,opencv;
    public static  File selectedImage; // Store the selected image file
    
      @FXML
    void exportdataaction(ActionEvent event) {

        
        // Open File Chooser to select an existing Excel file
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select an Excel File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", "*.xlsx"));
        File selectedFile = fileChooser.showOpenDialog(null);

        if (selectedFile != null) {
           
            String inputText = answer.getText();
            List<String[]> extractedData = extractData(inputText);
            appendToExcel(selectedFile, extractedData);
        
        }
       
    }
    
    
    // Method to extract data without regex
    private static List<String[]> extractData(String text) {
        List<String[]> data = new ArrayList<>();
        String textt=text.replace("**","");
        String[] lines = textt.split("\n");

        String name = "", address = "", idNumber = "";

        for (String line : lines) {
            line = line.trim();

            if (line.startsWith("Name is")) {
                name = line.substring(8).trim();
            } else if (line.startsWith("Address is")) {
                address = line.substring(11).trim();
            } else if (line.startsWith("ID Number is")) {
                idNumber = line.substring(12).trim();

                if (idNumber.equalsIgnoreCase("Unclear in image")) {
                    idNumber = "";
                }

                // Add extracted record to list
                data.add(new String[]{name, address, idNumber});

                // Reset variables for next entry
                name = "";
                address = "";
                idNumber = "";
            }
        }
        return data;
    }
    
   // Method to append extracted data to an existing Excel file
    private static void appendToExcel(File file, List<String[]> data) {
        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            // Select first sheet
            Sheet sheet = workbook.getSheetAt(0);

            // Find the last row
            int lastRowNum = sheet.getLastRowNum() + 1;

            // Append new data
            for (String[] rowData : data) {
                Row row = sheet.createRow(lastRowNum++);
                for (int i = 0; i < rowData.length; i++) {
                    row.createCell(i).setCellValue(rowData[i]);
                }
            }

            // Save the updated workbook
            try (FileOutputStream fos = new FileOutputStream(file)) {
                workbook.write(fos);
            }

            System.out.println("✅ Data successfully appended to " + file.getName());
            Notifications noti = Notifications.create();
            noti.title("Great!");
            noti.text("✅ Data successfully appended to " + file.getName());
            noti.position(Pos.CENTER);
            noti.hideAfter(Duration.seconds(3));
            noti.showInformation();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   
    @FXML
    void clearallaction(ActionEvent event) {

        message.clear();
        answer.clear();
        File ff=new File ("");
        Image image = new Image(ff.toURI().toString());
        imageview.setImage(image);
        
        
    }

  
    private static String API_KEY; // Replace with your actual API key
    private static String ENDPOINT_URL;

  

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
            //message.clear();
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
            Image image = new Image(file.toURI().toString());
            imageview.setImage(image);
            askbtn.fire();
            
        }
    }
    
@FXML
void asksbtnaction(ActionEvent event) {
    DirectoryChooser directoryChooser = new DirectoryChooser();
    File folder = directoryChooser.showDialog(null);

    if (folder == null || !folder.isDirectory()) {
        appendToAnswerr("\n⚠️ Please select a valid folder first.\n");
        return;
    }

    File[] imageFiles = folder.listFiles((dir, name) -> 
        name.toLowerCase().endsWith(".jpg") || 
        name.toLowerCase().endsWith(".jpeg") || 
        name.toLowerCase().endsWith(".png"));

    if (imageFiles == null || imageFiles.length == 0) {
        appendToAnswerr("\n🚫 No images found in the selected folder.\n");
        return;
    }

    loading.setVisible(true);
    appendToAnswerr("\nProcessing images...\n");

    Task<Void> task = new Task<Void>() {
        @Override
        protected Void call() {
            try {
                for (File file : imageFiles) {
                    selectedImage = file;

                    // Update UI with the current image
                    Platform.runLater(() -> {
                        appendToAnswerr("\n📷 Processing: " + file.getName() + "\n");
                        imageview.setImage(new Image(file.toURI().toString()));
                    });

                    // Extract text and append it
                    String extractedText = sendImageRequestt(file);
                    
                    // Append extracted text to answer area
                    Platform.runLater(() -> appendToAnswerr("📝 Extracted Text:\n" + extractedText + "\n"));

                    Thread.sleep(500); // Optional delay to simulate processing time
                }
            } catch (Exception e) {
                e.printStackTrace();
                Platform.runLater(() -> appendToAnswerr("\n⚠️ Error: " + e.getMessage()));
            }
            return null;
        }
    };

    task.setOnSucceeded(event1 -> {
        loading.setVisible(false);
        appendToAnswerr("\n✅ All images processed.\n");
    });

    new Thread(task).start();
}


// Append text to answer in JavaFX thread
private void appendToAnswerr(String text) {
    Platform.runLater(() -> answer.appendText(text));   
}

// ⬇️ Modified API Call to Return Extracted Text ⬇️
private String sendImageRequestt(File imageFile) {
    try {
        byte[] fileContent = Files.readAllBytes(Paths.get(imageFile.getAbsolutePath()));
        String base64Image = Base64.getEncoder().encodeToString(fileContent);

        JsonObject requestJson = new JsonObject();
        JsonArray contentsArray = new JsonArray();
        JsonObject contentObject = new JsonObject();
        JsonArray partsArray = new JsonArray();
        
        // Add text prompt
        JsonObject textPart = new JsonObject();
        textPart.addProperty("text", message.getText());

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

        return sendApiRequestt(requestJson);  // Return extracted text
    } catch (IOException e) {
        e.printStackTrace();
        appendToAnswerr("\n⚠️ Error: " + e.getMessage() + "\n");
        return "";
    }
}

// ⬇️ Modified API Call to Return Extracted Text ⬇️
private String sendApiRequestt(JsonObject requestJson) {
    try {
        URL url = new URL(ENDPOINT_URL);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("POST");
        con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
        con.setDoOutput(true);

        try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
            wr.write(requestJson.toString().getBytes());
        }

        int responseCode = con.getResponseCode();
        if (responseCode == 200) {
            StringBuilder response = new StringBuilder();
            try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"))) {
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
            }
            return parseApiResponsee(response.toString()); // Extracted text returned
        } else {
            handleErrorResponse(con);
            return "⚠️ Error Processing Image";
        }

    } catch (IOException e) {
        e.printStackTrace();
        appendToAnswerr("\n⚠️ Network error: " + e.getMessage() + "\n");
        return "⚠️ Network Error";
    }
}


 
private String parseApiResponsee(String jsonResponse) {
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
                                return textPart.get("text").getAsString(); // ✅ Return extracted text
                            }
                        }
                    }
                }
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
        return "⚠️ Error parsing response: " + e.getMessage();
    }
    return "⚠️ No valid response from AI. Please try again.";
}



private void sendTextRequestt(String userInput) {
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

            sendApiRequestt(requestJson);
        } catch (Exception e) {
            e.printStackTrace();
            appendToAnswerr("\n⚠️ Error: " + e.getMessage() + "\n");
        }
    }




///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


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
        textPart.addProperty("text", message.getText());

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
            con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
            con.setDoOutput(true);
            //con.setRequestProperty("Content-Type", "application/json");
            

            try (DataOutputStream wr = new DataOutputStream(con.getOutputStream())) {
                wr.write(requestJson.toString().getBytes());
            }

            int responseCode = con.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            if (responseCode == 200) {
                StringBuilder response = new StringBuilder();
                try (BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream(),"UTF-8"))) {
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
                                     //byte[] bytes = aiResponse.getBytes(StandardCharsets.ISO_8859_1);
                                     //String fixedText = new String(bytes, StandardCharsets.UTF_8);
                                     appendToAnswer("\n"+aiResponse + "\n");
                                  
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
       
        
//        byte[] bytes = text.getBytes(StandardCharsets.ISO_8859_1);
//        String fixedText = new String(bytes, StandardCharsets.UTF_8);
        answer.clear();
        javafx.application.Platform.runLater(() -> answer.appendText(text));
        
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        loading.setVisible(false);
        
        System.setProperty("file.encoding", "UTF-8");
        
        answer.setStyle("-fx-font-family: 'Arial';"); // Use Arabic-supported font

        
  
        try {
          BufferedReader buf = new BufferedReader(new FileReader("Key.kady"));
          keyy=buf.readLine().replace("X:",drib+":");
          buf.close();   
          } catch (IOException ex) {}
        
        
         try {
          BufferedReader buf = new BufferedReader(new FileReader(keyy));
          keyyy=buf.readLine();
          buf.close();   
          } catch (IOException ex) {}
         
         try {
          BufferedReader buf = new BufferedReader(new FileReader("Open_CV.kady"));
          opencv=buf.readLine();
          buf.close();   
          } catch (IOException ex) {}
        
         
        
          System.load(opencv);
 
        
         API_KEY=keyyy;
         ENDPOINT_URL = "https://generativelanguage.googleapis.com/v1/models/gemini-1.5-flash:generateContent?key=" + API_KEY;
         
        
        
    }
}
