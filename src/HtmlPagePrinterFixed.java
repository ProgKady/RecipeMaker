import javafx.application.Application;
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.stage.FileChooser;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class HtmlPagePrinterFixed extends Application {

    private File selectedHtmlFile;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("HTML Page Printer");

        Label label = new Label("Step 1: Choose an HTML file:");
        Button chooseButton = new Button("Choose HTML File");
        Label selectedLabel = new Label();
        Button generateButton = new Button("Step 2: Enter Info & Generate");
        generateButton.setDisable(true);

        chooseButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select HTML File");
            fileChooser.getExtensionFilters().add(
                new FileChooser.ExtensionFilter("KADYSOFT Files", "*.ks")
            );
            File file = fileChooser.showOpenDialog(primaryStage);
            if (file != null) {
                selectedHtmlFile = file;
                selectedLabel.setText("Selected: " + file.getName());
                generateButton.setDisable(false);
            }
        });

        generateButton.setOnAction(e -> showDataAndPageRangeDialog());

        VBox layout = new VBox(10, label, chooseButton, selectedLabel, generateButton);
        layout.setStyle("-fx-padding: 20; -fx-font-size: 14;");
        primaryStage.setScene(new Scene(layout, 500, 200));
        primaryStage.show();
    }

    private void showDataAndPageRangeDialog() {
        
        
        
        
        
        
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Page Info & Range");
        TextField headerField = new TextField();
        headerField.setPromptText("Enter header text (bold)");
        TextField fromField = new TextField();
        fromField.setPromptText("From Page");
        TextField toField = new TextField();
        toField.setPromptText("To Page");
        VBox vbox = new VBox(10,
            new Label("Enter header (bold text):"), headerField,
            new Label("Enter machines range (e.g., 1 - 10):"),
            new HBox(10, new Label("From:"), fromField, new Label("To:"), toField)
        );
        vbox.setStyle("-fx-padding: 10;");
        dialog.getDialogPane().setContent(vbox);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        dialog.showAndWait().ifPresent(type -> {
            if (type == ButtonType.OK) {
                String headerText = headerField.getText().trim();
                String fromStr = fromField.getText().trim();
                String toStr = toField.getText().trim();
                if (headerText.isEmpty() || fromStr.isEmpty() || toStr.isEmpty()) {
                    showAlert("Error", "All fields are required.");
                    return;
                }

                try {
                    int from = Integer.parseInt(fromStr);
                    int to = Integer.parseInt(toStr);
                    if (from > to || from < 1) {
                        showAlert("Error", "Invalid page range.");
                        return;
                    }
                    String content = readFile(selectedHtmlFile);
                    generateFinalHtml(content, headerText, from, to);
                } catch (NumberFormatException | IOException ex) {
                    showAlert("Error", "Invalid number input or file error.");
                    ex.printStackTrace();
                }
            }
        });
        
        
        
        
        
    }
    
    

    private void generateFinalHtml(String bodyContent, String headerText, int fromPage, int toPage) {
        
        
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMM-yyyy hh:mm a");
            String currentTime = formatter.format(LocalDateTime.now());

            StringBuilder html = new StringBuilder();
            html.append("<html><head><style>")
                .append("@media print {")
                .append("  body { margin: 0; }")
                .append("  .page { page-break-after: always; break-after: page; }")
                .append("}")
                .append("body { font-family: Arial, sans-serif; margin: 0; padding: 0; }")
                .append(".page { width: 210mm; height: 297mm; padding: 20mm; box-sizing: border-box; }")
                .append(".header { font-weight: bold; font-size: 16pt; margin-bottom: 20px; }")
                .append("</style></head><body>");

            for (int i = fromPage; i <= toPage; i++) {
                html.append("<div class='page'>")
                    .append("<div class='header'>")
                    .append(headerText).append(" | Machine: ").append(i)
                    .append(" | ").append(currentTime)
                    .append("</div>")
                    .append(bodyContent)
                    .append("</div>");
            }

            html.append("</body></html>");

            File file = File.createTempFile("html_print_pages_", ".html");
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(html.toString());
            }

            String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"; // Change if needed
            new ProcessBuilder(chromePath, file.getAbsolutePath()).start();

        } catch (IOException e) {
            showAlert("Error", "Failed to generate or open the HTML file.");
            e.printStackTrace();
        }
    }

    
    
    
    
    
    private String readFile(File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder content = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
            content.append(line).append("\n");
        }
        reader.close();
        return content.toString();
    }

    private void showAlert(String title, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
