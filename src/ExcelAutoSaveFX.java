import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.Variant;

import java.io.File;

public class ExcelAutoSaveFX extends Application {

    @Override
    public void start(Stage primaryStage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Choose Excel File");
        fileChooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("Excel Files", "*.xlsx")
        );

        File selectedFile = fileChooser.showOpenDialog(primaryStage);

        if (selectedFile != null) {
            boolean success = openAndSaveWithExcel(selectedFile.getAbsolutePath());
            if (success) {
                showAlert("Success", "Excel file saved using Microsoft Excel.");
            } else {
                showAlert("Error", "Failed to process Excel file.");
            }
        } else {
            showAlert("Canceled", "No file was selected.");
        }
    }

    
    private boolean openAndSaveWithExcel(String filePath) {
        ActiveXComponent excel = new ActiveXComponent("Excel.Application");
        try {
            excel.setProperty("Visible", new Variant(false)); // Background
            Dispatch workbooks = excel.getProperty("Workbooks").toDispatch();
            Dispatch workbook = Dispatch.call(workbooks, "Open", filePath).toDispatch();

            // Simulate Excel Save
            Dispatch.call(workbook, "Save");

            // Close workbook and quit Excel
            Dispatch.call(workbook, "Close", false);
            excel.invoke("Quit");

            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            excel.safeRelease();
        }
    }

    private void showAlert(String title, String content) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(content);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
