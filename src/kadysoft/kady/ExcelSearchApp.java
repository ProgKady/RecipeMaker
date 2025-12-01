package kadysoft.kady;



import com.jfoenix.controls.*;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;

public class ExcelSearchApp extends Application {

    private JFXTextField styleNumberField;
    private JFXTextArea resultArea;
    private File selectedFile;

    @Override
    public void start(Stage primaryStage) {
        // Cupertino Light Theme Colors
        String bgColor = "#FFFFFF";
        String accentColor = "#007AFF"; // iOS Blue
        String textColor = "#000000";
        String inputBg = "#F2F2F7"; // Cupertino background gray

        Label titleLabel = new Label("🔍 Excel Style Number Search");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold; -fx-text-fill: " + textColor + ";");

        JFXButton chooseFileButton = new JFXButton("Choose Excel File");
        chooseFileButton.setStyle(
                "-fx-background-color: " + accentColor + ";" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 8;"
        );

        styleNumberField = new JFXTextField();
        styleNumberField.setPromptText("Enter Style Number");
        styleNumberField.setStyle(
                "-fx-background-color: " + inputBg + ";" +
                "-fx-prompt-text-fill: gray;" +
                "-fx-text-fill: " + textColor + ";" +
                "-fx-background-radius: 8;"
        );

        JFXButton searchButton = new JFXButton("Search");
        searchButton.setStyle(
                "-fx-background-color: " + accentColor + ";" +
                "-fx-text-fill: white;" +
                "-fx-background-radius: 8;"
        );

        resultArea = new JFXTextArea();
        resultArea.setEditable(false);
        resultArea.setPromptText("Search results will appear here...");
        resultArea.setPrefHeight(300);
        resultArea.setStyle(
                "-fx-control-inner-background: " + inputBg + ";" +
                "-fx-text-fill: " + textColor + ";" +
                "-fx-prompt-text-fill: gray;" +
                "-fx-background-radius: 8;"
        );

        LocalDate today = LocalDate.now();
        int fullYear = today.getYear();
        int yearTwoDigits = fullYear % 100;
        int month = today.getMonthValue();

        String link = "W:\\T&C   ORDERS " + yearTwoDigits + "\\WH - " + fullYear + "\\WH - " + month + "-" + fullYear + ".xlsx";
        resultArea.setText("Selected file: " + link);
        selectedFile = new File(link);

        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", "*.xlsx"));

        chooseFileButton.setOnAction((ActionEvent event) -> {
            selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                resultArea.setText("Selected file: " + selectedFile.getAbsolutePath());
            } else {
                resultArea.setText("No file selected.");
            }
        });

        searchButton.setOnAction((ActionEvent event) -> {
            if (selectedFile == null) {
                resultArea.setText("Please select an Excel file first.");
                return;
            }
            String styleNumber = styleNumberField.getText().trim();
            if (styleNumber.isEmpty()) {
                resultArea.setText("Please enter a style number.");
                return;
            }
            searchExcelFile(selectedFile, styleNumber);
        });

        VBox layout = new VBox(10, titleLabel, chooseFileButton, styleNumberField, searchButton, resultArea);
        layout.setPadding(new Insets(20));
        layout.setAlignment(Pos.TOP_LEFT);
        layout.setStyle("-fx-background-color: " + bgColor + ";");

        Scene scene = new Scene(layout, 620, 460);
        primaryStage.setTitle("Excel Style Number Search (Cupertino)");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void searchExcelFile(File file, String styleNumber) {
        StringBuilder results = new StringBuilder();
        try (FileInputStream fis = new FileInputStream(file);
             Workbook workbook = new XSSFWorkbook(fis)) {

            boolean found = false;
            for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
                Sheet sheet = workbook.getSheetAt(i);
                results.append("Searching in sheet: ").append(sheet.getSheetName()).append("\n");

                for (Row row : sheet) {
                    for (Cell cell : row) {
                        String cellValue = getCellValueAsString(cell);
                        if (cellValue != null && cellValue.equalsIgnoreCase(styleNumber)) {
                            found = true;
                            Cell targetCell = row.getCell(10, Row.MissingCellPolicy.RETURN_BLANK_AS_NULL);
                            String column5Value = getCellValueAsString(targetCell);
                            results.append("Found at Row ").append(row.getRowNum() + 1)
                                    .append(", Column ").append(cell.getColumnIndex() + 1)
                                    .append(" -> Column 5 Value: ").append(column5Value != null ? column5Value : "Empty").append("\n");
                        }
                    }
                }
                results.append("\n");
            }

            if (!found) {
                results.append("Style number '").append(styleNumber).append("' not found.");
            }

        } catch (IOException e) {
            results.append("Error reading the Excel file: ").append(e.getMessage());
        }

        resultArea.setText(results.toString());
    }

    private String getCellValueAsString(Cell cell) {
        if (cell == null) return null;
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue().trim();
            case NUMERIC:
                return DateUtil.isCellDateFormatted(cell)
                        ? cell.getDateCellValue().toString()
                        : String.format("%.0f", cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                switch (cell.getCachedFormulaResultType()) {
                    case STRING: return cell.getRichStringCellValue().getString();
                    case NUMERIC: return String.format("%.0f", cell.getNumericCellValue());
                    case BOOLEAN: return String.valueOf(cell.getBooleanCellValue());
                }
        }
        return null;
    }

//    public static void main(String[] args) {
//        launch(args);
//    }
}
