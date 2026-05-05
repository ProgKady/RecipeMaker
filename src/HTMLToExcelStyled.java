import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class HTMLToExcelStyled extends Application {

    @Override
    public void start(Stage stage) {
        
        
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open HTML File");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", "*.ks", "*.ks"));
        File htmlFile = fileChooser.showOpenDialog(stage);

        if (htmlFile == null) return;

        try {
            // Read HTML content
            String htmlContent = new String(java.nio.file.Files.readAllBytes(htmlFile.toPath()), "UTF-8");

            // Save as .xls (but with HTML content)
            FileChooser saveChooser = new FileChooser();
            saveChooser.setTitle("Save as Excel File");
            saveChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", "*.xls"));
            File saveFile = saveChooser.showSaveDialog(stage);

            if (saveFile != null) {
                try (PrintWriter out = new PrintWriter(saveFile, "UTF-8")) {
                    out.println(htmlContent);
                }
                System.out.println("Saved as Excel (HTML-based) file with formatting.");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        
    }
    

    public static void main(String[] args) {
        launch(args);
    }
}