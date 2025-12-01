package kadysoft.kady;





import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class ExcelMacroSimulator extends Application {

    private final TableView<String[]> table = new TableView<>();
    private final int ROWS = 70;
    private final int COLS = 4;
    private final String[] COL_HEADERS = {"A", "B", "C", "D"};
    private final Label f2Label = new Label("F2 = ");

    @Override
    public void start(Stage stage) {
        // Table setup
        table.setEditable(true);
        for (int col = 0; col < COLS; col++) {
            final int colIndex = col;
            TableColumn<String[], String> column = new TableColumn<>(COL_HEADERS[col]);
            column.setCellValueFactory(cellData -> new javafx.beans.property.SimpleStringProperty(
                    cellData.getValue()[colIndex]
            ));
            column.setCellFactory(TextFieldTableCell.forTableColumn());
            column.setOnEditCommit(event -> {
                event.getRowValue()[colIndex] = event.getNewValue();
            });
            column.setPrefWidth(100);
            table.getColumns().add(column);
        }

        // Fill rows
        for (int row = 0; row < ROWS; row++) {
            String[] rowData = new String[COLS];
            for (int i = 0; i < COLS; i++) rowData[i] = "";
            table.getItems().add(rowData);
        }

        // Buttons
        Button cleanButton = new Button("🧹 Clean Sheet");
        cleanButton.setOnAction(e -> cleanSheet());

        Button formatButton = new Button("🎨 Format Borders");
        formatButton.setOnAction(e -> formatBorders());

        f2Label.setText("F2 = 0");
        f2Label.setFont(new Font("Arial", 16));
        f2Label.setTextFill(Color.LIGHTGREEN);

        HBox controls = new HBox(10, cleanButton, formatButton, f2Label);
        controls.setPadding(new Insets(10));
        controls.setStyle("-fx-background-color: #2e2e2e;");

        VBox root = new VBox(10, controls, table);
        root.setPadding(new Insets(10));
        root.setStyle("-fx-background-color: #1e1e1e;");

        table.setStyle("-fx-control-inner-background: #2e2e2e; -fx-table-cell-border-color: gray;");
        table.setFixedCellSize(25);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        Scene scene = new Scene(root, 500, 600);
        stage.setTitle("Excel Macro Simulator (JavaFX)");
        stage.setScene(scene);
        stage.show();
    }

    private void cleanSheet() {
        // Clear A2:D56 (i.e., rows 0-54)
        for (int row = 0; row < 55; row++) {
            String[] rowData = table.getItems().get(row);
            for (int col = 0; col < COLS; col++) {
                rowData[col] = "";
            }
        }
        table.refresh();
        f2Label.setText("F2 = 0");
    }

    private void formatBorders() {
        // Simulated visual feedback – here we just print a message
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText("Formatted A2:D71 with dotted borders and alignment.");
        alert.setTitle("Formatting Applied");
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
