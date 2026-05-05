import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import javafx.application.Application;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ExcelCleaner extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Step 1: Open JavaFX file chooser to select an input .xlsx file
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select an Excel File to Clean");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", "*.xlsx"));
        File inputFile = fileChooser.showOpenDialog(primaryStage);

        if (inputFile == null) {
            System.out.println("No file selected. Exiting...");
            stop();
            return;
        }

        String desktopPath = System.getProperty("user.home") + "/Desktop/cleaned_data.xlsx";

        try {
            // Step 2: Read the input Excel file
            FileInputStream fis = new FileInputStream(inputFile);
            Workbook inputWorkbook = new XSSFWorkbook(fis);
            Sheet inputSheet = inputWorkbook.getSheetAt(0);

            // Step 3: Parse and clean the data while preserving styles
            List<Object[]> cleanedData = new ArrayList<>(); // Store data and styles
            int maxColumns = 0;

            // Find the last column with data across all rows
            for (Row row : inputSheet) {
                int lastCellNum = row.getLastCellNum();
                if (lastCellNum > maxColumns) {
                    maxColumns = lastCellNum;
                }
            }

            // Process each row, keeping data and styles up to the last column with data
            for (Row row : inputSheet) {
                if (row.getPhysicalNumberOfCells() == 0) continue; // Skip empty rows
                Object[] rowData = new Object[maxColumns * 2]; // Store value and style
                for (int i = 0; i < maxColumns; i++) {
                    Cell cell = row.getCell(i);
                    rowData[i * 2] = (cell != null && !cell.toString().trim().isEmpty()) ? cell.toString().replace(".0","") : ""; // Value
                    rowData[i * 2 + 1] = (cell != null) ? cell.getCellStyle() : null; // Style
                }
                cleanedData.add(rowData);
            }

            inputWorkbook.close();
            fis.close();

            // Step 4: Create a new workbook and write cleaned data with formatting
            Workbook outputWorkbook = new XSSFWorkbook();
            Sheet outputSheet = outputWorkbook.createSheet("Cleaned Data");

            // Create a font with size 14
            Font uniformFont = outputWorkbook.createFont();
            uniformFont.setFontHeightInPoints((short) 14); // Font size 14

            int rowNum = 0;
            for (Object[] rowData : cleanedData) {
                Row newRow = outputSheet.createRow(rowNum++);
                for (int i = 0; i < maxColumns; i++) {
                    Cell newCell = newRow.createCell(i);
                    String cellValue = (String) rowData[i * 2];
                    CellStyle originalStyle = (CellStyle) rowData[i * 2 + 1];

                    // Set the cell value
                    newCell.setCellValue(cellValue);

                    // Apply formatting
                    CellStyle newStyle = outputWorkbook.createCellStyle();
                    if (originalStyle != null) {
                        newStyle.cloneStyleFrom(originalStyle); // Copy alignment, borders, etc.
                    }
                    newStyle.setFont(uniformFont); // Set font size to 14, overriding original font
                    newCell.setCellStyle(newStyle);
                }
            }

            // Step 5: Pack columns to fit data (auto-size)
            for (int i = 0; i < maxColumns; i++) {
                outputSheet.autoSizeColumn(i);
            }

            // Step 6: Save to desktop
            try (FileOutputStream fos = new FileOutputStream(desktopPath)) {
                outputWorkbook.write(fos);
            }
            outputWorkbook.close();

            System.out.println("Cleaned Excel file saved to: " + desktopPath);

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error processing the file: " + e.getMessage());
        }

        // Close the application
        stop();
    }

    @Override
    public void stop() {
        System.exit(0); // Ensure the application exits cleanly
    }

    public static void main(String[] args) {
        launch(args); // Launch the JavaFX application
    }
}