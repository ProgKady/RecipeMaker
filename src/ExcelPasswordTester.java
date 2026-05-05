

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.poifs.crypt.EncryptionInfo;
import org.apache.poi.poifs.crypt.Decryptor;

import java.io.File;
import java.io.FileInputStream;
import java.util.Scanner;

public class ExcelPasswordTester extends Application {

    private TextField excelFilePathField = new TextField();
    private TextField dictionaryFilePathField = new TextField();
    private TextArea resultArea = new TextArea();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Excel Password Tester");

        // Excel file selection
        Button excelFileButton = new Button("Select Excel File");
        excelFileButton.setOnAction(e -> selectFile(excelFilePathField, "Select Excel File"));

        // Dictionary file selection
        Button dictionaryFileButton = new Button("Select Dictionary File");
        dictionaryFileButton.setOnAction(e -> selectFile(dictionaryFilePathField, "Select Dictionary File"));

        // Start testing button
        Button startButton = new Button("Start Testing");
        startButton.setOnAction(e -> startPasswordTest());

        // Layout setup
        VBox layout = new VBox(10);
        layout.getChildren().addAll(
                new Label("Excel File:"), excelFilePathField, excelFileButton,
                new Label("Dictionary File:"), dictionaryFilePathField, dictionaryFileButton,
                startButton, new Label("Results:"), resultArea
        );

        Scene scene = new Scene(layout, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void selectFile(TextField textField, String title) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle(title);
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            textField.setText(file.getAbsolutePath());
        }
    }

    private void startPasswordTest() {
        String excelFilePath = excelFilePathField.getText();
        String dictionaryFilePath = dictionaryFilePathField.getText();

        if (excelFilePath.isEmpty() || dictionaryFilePath.isEmpty()) {
            resultArea.setText("Please select both files.");
            return;
        }

        try {
            File excelFile = new File(excelFilePath);
            File dictionaryFile = new File(dictionaryFilePath);

            try (Scanner scanner = new Scanner(dictionaryFile)) {
                while (scanner.hasNextLine()) {
                    String password = scanner.nextLine().trim();
                    if (testExcelPassword(excelFile, password)) {
                        resultArea.setText("Password found: " + password);
                        return;
                    } else {
                        resultArea.appendText("Tried: " + password + " - Failed\n");
                    }
                }
            }

            resultArea.appendText("Password not found in dictionary.");
        } catch (Exception e) {
            resultArea.setText("Error: " + e.getMessage());
        }
    }

    private boolean testExcelPassword(File excelFile, String password) {
        try (FileInputStream fis = new FileInputStream(excelFile)) {
            POIFSFileSystem fileSystem = new POIFSFileSystem(fis);
            EncryptionInfo info = new EncryptionInfo(fileSystem);
            Decryptor decryptor = Decryptor.getInstance(info);

            if (decryptor.verifyPassword(password)) {
                return true;
            }
        } catch (Exception ignored) {
        }
        return false;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
