import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.beans.property.SimpleStringProperty;

public class ExcelViewerApp extends Application {

    private TableView<List<String>> tableView = new TableView<>();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Excel Viewer");

        // Configure FileChooser to load Excel files
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", "*.xlsx", "*.xls"));

        // Load and display Excel file
        File file = fileChooser.showOpenDialog(primaryStage);
        if (file != null) {
            loadExcelFile(file);
        }

        Scene scene = new Scene(tableView, 800, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadExcelFile(File file) {
        try (FileInputStream fis = new FileInputStream(file)) {
            Workbook workbook = WorkbookFactory.create(fis);
            Sheet sheet = workbook.getSheetAt(0); // Read the first sheet

            // Set up columns based on header row
            Row headerRow = sheet.getRow(0);
            if (headerRow != null) {
                for (Cell headerCell : headerRow) {
                    TableColumn<List<String>, String> column = new TableColumn<>(headerCell.getStringCellValue());
                    int columnIndex = headerCell.getColumnIndex();
                    column.setCellValueFactory(data -> {
                        List<String> row = data.getValue();
                        return columnIndex < row.size() ? new SimpleStringProperty(row.get(columnIndex)) : new SimpleStringProperty("");
                    });
                    tableView.getColumns().add(column);
                }
            }

            // Populate data rows
            for (int i = 1; i <= sheet.getLastRowNum(); i++) { // Start from 1 to skip header
                Row row = sheet.getRow(i);
                List<String> rowData = new ArrayList<>();
                for (int j = 0; j < headerRow.getLastCellNum(); j++) {
                    Cell cell = row.getCell(j);
                    rowData.add(getCellValueAsString(cell));
                }
                tableView.getItems().add(rowData);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getCellValueAsString(Cell cell) {
        if (cell == null) return "";
        switch (cell.getCellType()) {
            case STRING:
                return cell.getStringCellValue();
            case NUMERIC:
                if (DateUtil.isCellDateFormatted(cell)) {
                    return cell.getDateCellValue().toString();
                } else {
                    return String.valueOf(cell.getNumericCellValue());
                }
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case FORMULA:
                return cell.getCellFormula();
            default:
                return "";
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
