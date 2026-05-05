import javafx.application.Application;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelDataTransfer extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        transferData("C:\\Users\\Ahmed.ElKady\\Desktop\\Ahmed.xlsx");
    }

    public void transferData(String filePath) {
        try (FileInputStream fileInputStream = new FileInputStream(filePath);
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet sheet1 = workbook.getSheet("Sheet1");
            Sheet sheet2 = workbook.getSheet("Sheet2");

            int rowCount = sheet1.getLastRowNum();
            int tableCount = 0;  // Used to track the table number in sheet2

            for (Row row : sheet2) {
                if (isTableStart(row)) {
                    // Logic to identify the start of each table in Sheet2
                    tableCount++;
                    // Assuming table starts from the current row, proceed to copy rows
                }

                if (tableCount > 0) {
                    // Copy the row to Sheet1
                    Row newRow = sheet1.createRow(++rowCount);
                    copyRow(row, newRow);
                }
            }

            // Save the changes
            try (FileOutputStream outputStream = new FileOutputStream(filePath)) {
                workbook.write(outputStream);
            }

            System.out.println("Data transfer complete!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isTableStart(Row row) {
        // Implement logic to determine if the current row is the start of a new table
        // This may involve checking for specific header values or formatting
        return false;
    }

    private void copyRow(Row fromRow, Row toRow) {
        for (Cell cell : fromRow) {
            Cell newCell = toRow.createCell(cell.getColumnIndex());
            switch (cell.getCellType()) {
                case STRING:
                    newCell.setCellValue(cell.getStringCellValue());
                    break;
                case NUMERIC:
                    newCell.setCellValue(cell.getNumericCellValue());
                    break;
                case BOOLEAN:
                    newCell.setCellValue(cell.getBooleanCellValue());
                    break;
                case FORMULA:
                    newCell.setCellFormula(cell.getCellFormula());
                    break;
                default:
                    break;
            }
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
