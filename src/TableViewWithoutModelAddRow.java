

import javafx.application.Application;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TableViewWithoutModelAddRow extends Application {

    private TableView<ObservableList<String>> table;
    private ObservableList<ObservableList<String>> data;

    @Override
    public void start(Stage stage) {
        // Create a TableView
        table = new TableView<>();

        // Create an ObservableList for the table data
        data = FXCollections.observableArrayList();

        // Adding initial rows as ObservableList<String>
        //ObservableList<String> row1 = FXCollections.observableArrayList("John", "Doe");
        //ObservableList<String> row2 = FXCollections.observableArrayList("Jane", "Smith");
        //data.addAll(row1, row2);

        // Define the columns
        TableColumn<ObservableList<String>, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().get(0)));

        TableColumn<ObservableList<String>, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(cellData -> new ReadOnlyStringWrapper(cellData.getValue().get(1)));

        // Add columns to the table
        table.getColumns().addAll(firstNameCol, lastNameCol);

        // Set the data into the table
        table.setItems(data);

        // Create text fields to input new row data
        TextField firstNameInput = new TextField();
        firstNameInput.setPromptText("First Name");
        
        TextField lastNameInput = new TextField();
        lastNameInput.setPromptText("Last Name");

        // Add a Button to add a new row
        Button addButton = new Button("Add Row");
        addButton.setOnAction(e -> addRow(firstNameInput.getText(), lastNameInput.getText())
        
        );

        VBox vbox = new VBox();
        vbox.getChildren().addAll(table, firstNameInput, lastNameInput, addButton);

        Scene scene = new Scene(vbox);
        stage.setScene(scene);
        stage.setTitle("Add Row to TableView Without Model Class");
        stage.show();
    }

   
    private void addRow(String firstName, String lastName) {
        if (!firstName.isEmpty() && !lastName.isEmpty()) {
            // Create a new ObservableList<String> for the new row
            ObservableList<String> newRow = FXCollections.observableArrayList(firstName, lastName);
            
            // Add the new row to the data list
            data.add(newRow);
        } else {
            // Handle empty inputs, if needed (e.g., show an error message)
            System.out.println("Both first name and last name must be filled.");
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
