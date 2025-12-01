import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.print.PrinterJob;

import java.io.*;
import java.nio.file.Files;

public class HTMLPrinterApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        VBox root = new VBox();
        Scene scene = new Scene(root, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.setTitle("HTML File Printer");

        // Button to trigger file selection and printing
        javafx.scene.control.Button printButton = new javafx.scene.control.Button("Select HTML File and Print");
        root.getChildren().add(printButton);

        printButton.setOnAction(event -> {
            // Step 1: Choose HTML file
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", "*.html"));
            File selectedFile = fileChooser.showOpenDialog(primaryStage);

            if (selectedFile != null) {
                try {
                    // Step 2: Prompt for header text
                    TextInputDialog dialog = new TextInputDialog();
                    dialog.setTitle("Header Input");
                    dialog.setHeaderText("Enter Header for Printed Page");
                    dialog.setContentText("Header:");
                    String headerText = dialog.showAndWait().orElse("Default Header");

                    // Step 3: Read HTML content
                    String htmlContent = new String(Files.readAllBytes(selectedFile.toPath()));

                    // Step 4: Create WebView to render HTML
                    WebView webView = new WebView();
                    String finalHtml = "<html><body><h1>" + headerText + "</h1><hr>" + htmlContent + "</body></html>";
                    webView.getEngine().loadContent(finalHtml);

                    // Step 5: Print the WebView content
                    PrinterJob printerJob = PrinterJob.createPrinterJob();
                    if (printerJob != null && printerJob.showPrintDialog(primaryStage)) {
                        webView.getEngine().print(printerJob);
                        printerJob.endJob();
                    } else {
                        System.out.println("Printing cancelled or failed.");
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("Error reading HTML file.");
                }
            }
        });

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}