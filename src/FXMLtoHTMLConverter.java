import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.geometry.Insets;

import java.io.*;
import java.util.*;

public class FXMLtoHTMLConverter extends Application {

    private TextField filePathField;
    private Label statusLabel;
    private File selectedFile;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("FXML to HTML Converter");

        Label label = new Label("Select FXML file:");
        filePathField = new TextField();
        filePathField.setEditable(false);
        Button browseBtn = new Button("Browse...");
        Button convertBtn = new Button("Convert");
        statusLabel = new Label();

        HBox fileRow = new HBox(10, filePathField, browseBtn);
        VBox root = new VBox(10, label, fileRow, convertBtn, statusLabel);
        root.setPadding(new Insets(15));

        browseBtn.setOnAction(e -> chooseFile(primaryStage));
        convertBtn.setOnAction(e -> convertFXMLtoHTML());

        primaryStage.setScene(new Scene(root, 500, 200));
        primaryStage.show();
    }

    private void chooseFile(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open FXML File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("FXML Files", "*.fxml"));
        File file = fileChooser.showOpenDialog(stage);
        if (file != null) {
            selectedFile = file;
            filePathField.setText(file.getAbsolutePath());
            statusLabel.setText("File selected.");
        }
    }

    private void convertFXMLtoHTML() {
        if (selectedFile == null) {
            statusLabel.setText("Please select an FXML file first.");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(selectedFile))) {
            StringBuilder html = new StringBuilder();
            html.append("<!DOCTYPE html>\n<html>\n<head>\n<link rel=\"stylesheet\" href=\"style.css\">\n</head>\n<body>\n");

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                // Panes
                if (line.startsWith("<VBox")) html.append("<div class=\"vbox\">\n");
                else if (line.startsWith("<HBox")) html.append("<div class=\"hbox\">\n");
                else if (line.startsWith("<StackPane")) html.append("<div class=\"stackpane\">\n");
                else if (line.startsWith("<AnchorPane")) html.append("<div class=\"anchorpane\">\n");
                else if (line.startsWith("<GridPane")) html.append("<div class=\"gridpane\">\n");
                else if (line.startsWith("<FlowPane")) html.append("<div class=\"flowpane\">\n");
                else if (line.startsWith("<BorderPane")) html.append("<div class=\"borderpane\">\n");

                else if (line.startsWith("</VBox>") || line.startsWith("</HBox>") ||
                        line.startsWith("</StackPane>") || line.startsWith("</AnchorPane>") ||
                        line.startsWith("</GridPane>") || line.startsWith("</FlowPane>") ||
                        line.startsWith("</BorderPane>")) {
                    html.append("</div>\n");
                }

                // Controls
                else if (line.startsWith("<Label")) html.append("  <label>").append(getText(line)).append("</label>\n");
                else if (line.startsWith("<Button")) html.append("  <button>").append(getText(line)).append("</button>\n");
                else if (line.startsWith("<TextField")) html.append("  <input type=\"text\" placeholder=\"").append(getPromptText(line)).append("\" />\n");
                else if (line.startsWith("<TextArea")) html.append("  <textarea rows=\"4\" cols=\"30\">").append(getPromptText(line)).append("</textarea>\n");
                else if (line.startsWith("<CheckBox")) html.append("  <input type=\"checkbox\"> ").append(getText(line)).append("<br/>\n");
                else if (line.startsWith("<RadioButton")) html.append("  <input type=\"radio\" name=\"group\"> ").append(getText(line)).append("<br/>\n");
                else if (line.startsWith("<ComboBox")) html.append("  <select><option>ComboBox</option></select>\n");
                else if (line.startsWith("<ListView")) html.append("  <ul><li>Item 1</li><li>Item 2</li></ul>\n");
                else if (line.startsWith("<TableView")) html.append("  <table><tr><th>Table</th></tr><tr><td>Data</td></tr></table>\n");
                else if (line.startsWith("<ImageView")) html.append("  <img src=\"image.png\" alt=\"ImageView\" width=\"100\" />\n");
                else if (line.startsWith("<Slider")) html.append("  <input type=\"range\" min=\"0\" max=\"100\" />\n");
            }

            html.append("</body>\n</html>");

            writeFile("output.html", html.toString());
            writeFile("style.css", generateCSS());

            statusLabel.setText("Conversion complete! Files saved.");
        } catch (IOException e) {
            statusLabel.setText("Error: " + e.getMessage());
        }
    }

    private String getText(String line) {
        return getAttributeValue(line, "text");
    }

    private String getPromptText(String line) {
        return getAttributeValue(line, "promptText");
    }

    private String getAttributeValue(String line, String attr) {
        int i = line.indexOf(attr + "=\"");
        if (i == -1) return "";
        int start = i + attr.length() + 2;
        int end = line.indexOf("\"", start);
        return end > start ? line.substring(start, end) : "";
    }

    private void writeFile(String filename, String content) throws IOException {
        try (PrintWriter writer = new PrintWriter(filename)) {
            writer.print(content);
        }
    }

    private String generateCSS() {
        return
            ".vbox { display: flex; flex-direction: column; gap: 10px; margin-bottom: 20px; }\n" +
            ".hbox { display: flex; flex-direction: row; gap: 10px; margin-bottom: 20px; }\n" +
            ".stackpane, .anchorpane, .gridpane, .flowpane, .borderpane { padding: 10px; border: 1px dashed #ccc; margin-bottom: 20px; }\n" +
            "label, button, input, textarea, select { font-family: Arial; font-size: 14px; }\n" +
            "table { border: 1px solid #ccc; border-collapse: collapse; }\n" +
            "table td, table th { border: 1px solid #ccc; padding: 5px; }\n";
    }
}
