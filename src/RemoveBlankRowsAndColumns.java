import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.util.CellRangeAddress;

public class RemoveBlankRowsAndColumns {
    public static void main(String[] args) throws IOException {
        // Load the Excel file
        FileInputStream fileInputStream = new FileInputStream(new File("lcw.xlsx"));
        Workbook workbook = new XSSFWorkbook(fileInputStream);

        // Iterate through sheets
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet originalSheet = workbook.getSheetAt(i);

            // Create a new sheet for the table data
            Sheet newSheet = workbook.createSheet(originalSheet.getSheetName() + "_cleaned");

            // Copy table data and all details (including merged cells, styles, row heights, column widths)
            copyTableData(originalSheet, newSheet);

            // Remove the original sheet
            int sheetIndex = workbook.getSheetIndex(originalSheet);
            workbook.removeSheetAt(sheetIndex);
        }

        // Save the updated file
        FileOutputStream fileOutputStream = new FileOutputStream(new File("yourfile_cleaned.xlsx"));
        workbook.write(fileOutputStream);
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();
    }

    private static void copyTableData(Sheet originalSheet, Sheet newSheet) {
        // Copy row heights and data
        for (int i = 0; i <= originalSheet.getLastRowNum(); i++) {
            Row originalRow = originalSheet.getRow(i);
            if (originalRow != null) {
                Row newRow = newSheet.createRow(i);
                newRow.setHeight(originalRow.getHeight()); // Copy row height

                // Copy cells from original row to new row
                for (int j = 0; j < originalRow.getPhysicalNumberOfCells(); j++) {
                    Cell originalCell = originalRow.getCell(j);
                    if (originalCell != null && originalCell.getCellType() != CellType.BLANK) {
                        Cell newCell = newRow.createCell(j);
                        copyCell(originalCell, newCell, originalSheet.getWorkbook());
                    }
                }
            }
        }

        // Copy column widths
        for (int i = 0; i < originalSheet.getRow(0).getPhysicalNumberOfCells(); i++) {
            newSheet.setColumnWidth(i, originalSheet.getColumnWidth(i));  // Copy column width (without scaling)
        }

        // Copy merged regions (if any)
        for (int i = 0; i < originalSheet.getNumMergedRegions(); i++) {
            CellRangeAddress cellRange = originalSheet.getMergedRegion(i);
            newSheet.addMergedRegion(cellRange);
        }
    }

    private static void copyCell(Cell originalCell, Cell newCell, Workbook workbook) {
        
        switch (originalCell.getCellType()) {
            case STRING:
                newCell.setCellValue(originalCell.getStringCellValue());
                break;
            case NUMERIC:
                newCell.setCellValue(originalCell.getNumericCellValue());
                break;
            case BOOLEAN:
                newCell.setCellValue(originalCell.getBooleanCellValue());
                break;
            case FORMULA:
                newCell.setCellFormula(originalCell.getCellFormula());
                break;
            case BLANK:
                newCell.setCellValue("");
                break;
            default:
                break;
        }

        // Copy cell style (fonts, colors, borders, etc.)
        CellStyle newCellStyle = workbook.createCellStyle();
        newCellStyle.cloneStyleFrom(originalCell.getCellStyle());
        newCell.setCellStyle(newCellStyle);
    }
}
