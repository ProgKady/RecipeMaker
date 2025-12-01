
//org.apache.poi.ss.usermodel.



import javafx.application.Application;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.util.ZipSecureFile;

import java.io.*;
import java.util.Iterator;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;

public class ExcelCleanerApp extends Application {

    private Label statusLabel = new Label("Select an Excel file to clean.");
    private ProgressBar progressBar = new ProgressBar(0);

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Button btnChoose = new Button("Choose Excel File");
        btnChoose.setOnAction(e -> chooseAndCleanExcel(primaryStage));

        progressBar.setPrefWidth(350);
        progressBar.setVisible(false);

        VBox root = new VBox(10, btnChoose, progressBar, statusLabel);
        root.setPadding(new Insets(15));
        root.setStyle("-fx-background-color: #2b2b2b;");  // dark background

        // Dark theme for controls
        btnChoose.setStyle("-fx-background-color: #3c3f41; -fx-text-fill: white;");
        statusLabel.setStyle("-fx-text-fill: #cccccc;");
        progressBar.setStyle("-fx-accent: #0096c9;");

        Scene scene = new Scene(root, 500, 180);
        primaryStage.setTitle("Excel Cleaner - Kadysoft Ltd.");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void chooseAndCleanExcel(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Excel File");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Excel Files", "*.xls", "*.xlsx")
        );
        File inputFile = fileChooser.showOpenDialog(stage);

        if (inputFile != null) {
            progressBar.setProgress(0);
            progressBar.setVisible(true);
            statusLabel.setText("Cleaning file...");

            Task<Void> task = new Task<Void>() {
                @Override
                protected Void call() throws Exception {
                    ZipSecureFile.setMinInflateRatio(0.0);

                    try (InputStream fis = new FileInputStream(inputFile);
                         Workbook workbook = inputFile.getName().toLowerCase().endsWith(".xls") ?
                                 new HSSFWorkbook(fis) : new XSSFWorkbook(fis)) {

                        int sheetsCount = workbook.getNumberOfSheets();

                        for (int i = 0; i < sheetsCount; i++) {
                            Sheet sheet = workbook.getSheetAt(i);

                            removeEmptyRows(sheet);
                            clearStylesAndApplyFormatting(sheet, workbook);

                            updateProgress(i + 1, sheetsCount);
                        }

                        File outputFile = new File(inputFile.getParentFile(), "cleaned_" + inputFile.getName());
                        try (OutputStream fos = new FileOutputStream(outputFile)) {
                            workbook.write(fos);
                        }
                        Platform.runLater(() -> {
                            statusLabel.setText("File cleaned and saved to:\n" + outputFile.getAbsolutePath());
                            progressBar.setVisible(false);
                            Notifications noti = Notifications.create();
                            noti.title("Successful");
                            noti.text("File cleaned and saved to:\n" + outputFile.getAbsolutePath());
                            noti.position(Pos.CENTER);
                            noti.showInformation();
                        });
                    } catch (Exception ex) {
                        Platform.runLater(() -> {
                            statusLabel.setText("Error: " + ex.getMessage());
                            progressBar.setVisible(false);
                        });
                        ex.printStackTrace();
                    }
                    return null;
                }
            };

            progressBar.progressProperty().bind(task.progressProperty());
            new Thread(task).start();

        } else {
            statusLabel.setText("No file selected.");
            progressBar.setVisible(false);
        }
    }

    private void removeEmptyRows(Sheet sheet) {
        for (int i = sheet.getLastRowNum(); i >= 0; i--) {
            Row row = sheet.getRow(i);
            if (isRowEmpty(row)) {
                if (row != null) {
                    sheet.removeRow(row);
                }
            }
        }
    }

    private boolean isRowEmpty(Row row) {
        if (row == null) return true;
        Iterator<org.apache.poi.ss.usermodel.Cell> it = row.cellIterator();
        while (it.hasNext()) {
            org.apache.poi.ss.usermodel.Cell cell = it.next();
            if (cell.getCellType() != CellType.BLANK && !cell.toString().trim().isEmpty()) {
                return false;
            }
        }
        return true;
    }

    private void clearStylesAndApplyFormatting(Sheet sheet, Workbook workbook) {
        int firstRowNum = sheet.getFirstRowNum();

        Font boldFont = workbook.createFont();
        boldFont.setBold(true);

        CellStyle style = workbook.createCellStyle();
        style.setFont(boldFont);
        style.setBorderTop(BorderStyle.THIN);
        style.setBorderBottom(BorderStyle.THIN);
        style.setBorderLeft(BorderStyle.THIN);
        style.setBorderRight(BorderStyle.THIN);

        for (Row row : sheet) {
            int rowNum = row.getRowNum();
            if (rowNum == firstRowNum) continue;  // skip first row

            for (int c = 0; c < row.getLastCellNum(); c++) {
                org.apache.poi.ss.usermodel.Cell cell = row.getCell(c, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                cell.setCellStyle(workbook.getCellStyleAt(0)); // reset style
                cell.setCellStyle(style);                     // set bold + border
            }
        }
    }
}
