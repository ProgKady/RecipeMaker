

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.*;  // Keep only Apache POI's Cell import
import org.apache.poi.xssf.usermodel.*;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class ExcelToHtmlConverter extends Application {

    @Override
    public void start(Stage primaryStage) {
        TextArea outputArea = new TextArea();
        outputArea.setPromptText("Generated HTML will appear here...");
        outputArea.setEditable(false);

        Button uploadButton = new Button("Upload Excel File");

        VBox layout = new VBox(10, uploadButton, new Label("HTML Output:"), outputArea);
        layout.setPadding(new Insets(15));

        uploadButton.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", "*.xlsx"));
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                try (FileInputStream fis = new FileInputStream(selectedFile);
                     Workbook workbook = new XSSFWorkbook(fis)) {

                    Sheet sheet = workbook.getSheetAt(0);
                    String htmlTable = convertExcelToHtml(sheet);
                    outputArea.setText(htmlTable);

                } catch (IOException e) {
                    outputArea.setText("Error reading Excel file: " + e.getMessage());
                }
            }
        });

        Scene scene = new Scene(layout, 800, 600);
        primaryStage.setTitle("Excel to HTML Table Converter");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String convertExcelToHtml(Sheet sheet) {
        StringBuilder htmlBuilder = new StringBuilder();
        htmlBuilder.append("<table border='1' style='border-collapse:collapse;'>\n");

        for (Row row : sheet) {
            if (row == null) continue;
            htmlBuilder.append("  <tr>\n");
            Iterator<org.apache.poi.ss.usermodel.Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()) {
                org.apache.poi.ss.usermodel.Cell cell = cellIterator.next();
                if (cell == null) continue;

                CellStyle style = cell.getCellStyle();
                Workbook workbook = sheet.getWorkbook();
                Font font = workbook.getFontAt(style.getFontIndexAsInt());

                String bgColor = getColorFromStyle(style);
                String textColor = getColorFromFont(font);
                String alignment = getAlignmentFromStyle(style);
                String fontStyle = getFontStyles(font);
                String cellValue = getCellValue(cell);

                htmlBuilder.append(String.format(
                        "    <td style='background-color:%s; color:%s; %s %s'>%s</td>\n",
                        bgColor, textColor, alignment, fontStyle, cellValue
                ));
            }
            htmlBuilder.append("  </tr>\n");
        }
        htmlBuilder.append("</table>");
        return htmlBuilder.toString();
    }

    private String getColorFromStyle(CellStyle style) {
        if (style instanceof XSSFCellStyle) {
            XSSFColor xssfColor = ((XSSFCellStyle) style).getFillForegroundColorColor();
            if (xssfColor != null && xssfColor.getARGBHex() != null) {
                return "#" + xssfColor.getARGBHex().substring(2);
            }
        }
        return "#ffffff";
    }

    private String getColorFromFont(Font font) {
        if (font instanceof XSSFFont) {
            XSSFFont xssfFont = (XSSFFont) font;
            if (xssfFont.getXSSFColor() != null && xssfFont.getXSSFColor().getARGBHex() != null) {
                return "#" + xssfFont.getXSSFColor().getARGBHex().substring(2);
            }
        }
        return "#000000";
    }

    private String getAlignmentFromStyle(CellStyle style) {
        HorizontalAlignment alignment = style.getAlignment();
        if (alignment != null) {
            switch (alignment) {
                case CENTER: return "text-align:center;";
                case LEFT:   return "text-align:left;";
                case RIGHT:  return "text-align:right;";
            }
        }
        return "";
    }

    private String getFontStyles(Font font) {
        StringBuilder fontStyle = new StringBuilder();
        if (font.getBold()) fontStyle.append("font-weight:bold;");
        fontStyle.append("font-size:").append(font.getFontHeightInPoints()).append("pt;");
        return fontStyle.toString();
    }

    private String getCellValue(org.apache.poi.ss.usermodel.Cell cell) {
        if (cell == null) return "";

        // Use getCellType() from Apache POI 5.x
        switch (cell.getCellType()) {
            case STRING:  
                return cell.getStringCellValue();
            case NUMERIC: 
                double numericValue = cell.getNumericCellValue();
                // Check if it's an integer (e.g., 10.0 should be 10)
                if (numericValue % 1 == 0) {
                    return String.valueOf((int) numericValue); // Cast to int if it's a whole number
                } else {
                    return String.valueOf(numericValue); // Keep as double if it has decimal places
                }
            case FORMULA: 
                try {
                    double formulaValue = cell.getNumericCellValue();
                    if (formulaValue % 1 == 0) {
                        return String.valueOf((int) formulaValue);
                    } else {
                        return String.valueOf(formulaValue);
                    }
                } catch (Exception e) {
                    return cell.getCellFormula();
                }
            case BLANK:   
                return "";
            default:      
                return "";
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
