package kadysoft.kady;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXToolbar;
import com.jfoenix.controls.JFXTextField;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.ComboBoxTableCell;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.control.table.TableFilter;

import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class ModernExcelEditor extends Application {

    private TableView<ObservableList<String>> tableView = new TableView<>();
    private ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
    private ObservableList<String> columnNames = FXCollections.observableArrayList();
    private String databaseUrl = "jdbc:sqlite:X:/Recipe_System/Database/Recipe_System_DB.db"; // Path to your SQLite DB
    private TableFilter<ObservableList<String>> tableFilter;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Modern Excel-like Editor with Auto Save and Filters");

        // Create modern UI elements using JFoenix
        JFXToolbar toolbar = new JFXToolbar();
Label titleLabel = new Label("Modern Excel-like Editor");
titleLabel.setStyle("-fx-font-size: 18px; -fx-text-fill: white;");

JFXButton settingsButton = new JFXButton("Settings");
settingsButton.setStyle("-fx-background-color: #1976d2; -fx-text-fill: white;");

toolbar.setLeft(titleLabel);
toolbar.setRight(settingsButton);
toolbar.setStyle("-fx-background-color: #2b2b2b;");


        JFXButton addRowButton = new JFXButton("Add Row");
        addRowButton.setOnAction(e -> addRow());
        addRowButton.setStyle("-fx-background-color: #388e3c; -fx-text-fill: white;");

        JFXButton deleteRowButton = new JFXButton("Delete Row");
        deleteRowButton.setOnAction(e -> deleteSelectedRow());
        deleteRowButton.setStyle("-fx-background-color: #d32f2f; -fx-text-fill: white;");

        VBox buttonBox = new VBox(10, addRowButton, deleteRowButton);
        buttonBox.setStyle("-fx-padding: 10; -fx-background-color: #f5f5f5;");

        // Load data into TableView
        loadDataFromDatabase();

        // Add filter to table
        tableFilter = new TableFilter<>(tableView);

        BorderPane root = new BorderPane();
        root.setTop(toolbar);
        root.setCenter(tableView);
        root.setRight(buttonBox);

        Scene scene = new Scene(root, 1200, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void loadDataFromDatabase() {
        try {
            // Load SQLite driver
            Class.forName("org.sqlite.JDBC");

            try (Connection conn = DriverManager.getConnection(databaseUrl);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery("SELECT * FROM Timor")) {

                // Clear existing data
                tableView.getColumns().clear();
                data.clear();
                columnNames.clear();

                // Define ComboBox columns
                Set<Integer> comboBoxColumns = new HashSet<>();
                comboBoxColumns.add(1); // Adjust as needed

                // Load column names and create TableColumns
                for (int i = 0; i < rs.getMetaData().getColumnCount(); i++) {
                    final int colIndex = i;
                    String colName = rs.getMetaData().getColumnName(i + 1);
                    columnNames.add(colName);

                    TableColumn<ObservableList<String>, String> column = new TableColumn<>(colName);
                    column.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().get(colIndex)));

                    if (comboBoxColumns.contains(colIndex)) {
                        column.setCellFactory(ComboBoxTableCell.forTableColumn("Option 1", "Option 2", "Option 3"));
                    } else {
                        column.setCellFactory(TextFieldTableCell.forTableColumn());
                    }

                    // Auto-save changes on edit commit
                    column.setOnEditCommit(event -> {
                        ObservableList<String> row = event.getRowValue();
                        row.set(colIndex, event.getNewValue());
                        autoSave(row);
                    });

                    tableView.getColumns().add(column);
                }

                // Load rows into the TableView
                while (rs.next()) {
                    ObservableList<String> row = FXCollections.observableArrayList();
                    for (int i = 1; i <= rs.getMetaData().getColumnCount(); i++) {
                        row.add(rs.getString(i));
                    }
                    data.add(row);
                }
                tableView.setItems(data);
                tableView.setEditable(true);

            }
        } catch (ClassNotFoundException e) {
            showAlert("Error", "SQLite JDBC driver not found.");
        } catch (SQLException e) {
            showAlert("Error", "Failed to load data from the database: " + e.getMessage());
        }
    }

   private void autoSave(ObservableList<String> row) {
    boolean isNewRow = row.get(0) == null || row.get(0).isEmpty(); // Check if ID is empty
    String query = isNewRow ? buildInsertQuery(row) : buildUpdateQuery(row);

    try (Connection conn = DriverManager.getConnection(databaseUrl);
         PreparedStatement stmt = conn.prepareStatement(query)) {
        System.out.println("Executing SQL: " + query); // Log the query
        stmt.executeUpdate();
    } catch (SQLException e) {
        System.err.println("Error executing SQL: " + query); // Log the query
        e.printStackTrace(); // Print full error stack trace
        showAlert("Error", "Auto-save failed: " + e.getMessage());
    }
}


private String buildInsertQuery(ObservableList<String> row) {
    StringBuilder columns = new StringBuilder();
    StringBuilder values = new StringBuilder();

    for (int i = 0; i < columnNames.size(); i++) {
        columns.append(columnNames.get(i)).append(", ");
        String value = row.get(i) == null ? "" : row.get(i).replace("'", "''");
        values.append("'").append(value).append("', ");
    }
    columns.setLength(columns.length() - 2); // Remove trailing comma
    values.setLength(values.length() - 2); // Remove trailing comma

    String query = String.format("INSERT INTO Timor (%s) VALUES (%s)", columns, values);
    System.out.println("Generated INSERT Query: " + query); // Log query
    return query;
}




    private String buildUpdateQuery(ObservableList<String> row) {
    StringBuilder query = new StringBuilder("UPDATE Timor SET ");
    for (int i = 1; i < columnNames.size(); i++) { // Start at index 1 if ID is at index 0
        String value = row.get(i) == null ? "" : row.get(i).replace("'", "''");
        query.append(columnNames.get(i)).append(" = '").append(value).append("', ");
    }
    query.setLength(query.length() - 2); // Remove trailing comma
    query.append(" WHERE id = ").append(row.get(0)); // Assuming first column is the unique ID

    System.out.println("Generated UPDATE Query: " + query); // Log query
    return query.toString();
}



    private void addRow() {
        ObservableList<String> newRow = FXCollections.observableArrayList();
        for (int i = 0; i < columnNames.size(); i++) {
            newRow.add(""); // Add empty cells
        }
        data.add(newRow);
        autoSave(newRow); // Auto-save the new row
    }

    private void deleteSelectedRow() {
        ObservableList<String> selectedRow = tableView.getSelectionModel().getSelectedItem();
        if (selectedRow != null) {
            data.remove(selectedRow);
            try (Connection conn = DriverManager.getConnection(databaseUrl);
                 Statement stmt = conn.createStatement()) {
                stmt.executeUpdate("DELETE FROM Timor WHERE id = " + selectedRow.get(0)); // Assuming first column is ID
            } catch (SQLException e) {
                showAlert("Error", "Failed to delete row: " + e.getMessage());
            }
        } else {
            showAlert("Warning", "No row selected to delete.");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
