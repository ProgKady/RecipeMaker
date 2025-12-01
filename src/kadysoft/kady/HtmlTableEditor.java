package kadysoft.kady;

import com.github.difflib.DiffUtils;
import com.github.difflib.patch.Patch;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.*;





public class HtmlTableEditor extends Application {
    private TextArea editorArea;
    private String originalContent;
    private File selectedFile;
    private String historyFilePath;
    private Stage primaryStage;

    
    
    
    
    
    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        BorderPane root = new BorderPane();
        root.setPadding(new Insets(10));
        HBox toolbar = new HBox(10);
        toolbar.setPadding(new Insets(10));
        toolbar.setStyle("-fx-background-color: #ffffff; -fx-border-color: #d0d0d0; -fx-border-width: 0 0 1 0;");
        Button openButton = new Button("Open File");
        openButton.setOnAction(e -> openFile());
        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> saveFile());
        Button viewHistoryButton = new Button("View History");
        viewHistoryButton.setOnAction(e -> viewHistory());
        toolbar.getChildren().addAll(openButton, saveButton, viewHistoryButton);
        editorArea = new TextArea();
        editorArea.setWrapText(true);
        root.setTop(toolbar);
        root.setCenter(editorArea);
        Scene scene = new Scene(root, 900, 600);
        stage.setTitle("HTML Table Editor");
        stage.setScene(scene);
        stage.show();
    }

    
    
    
    
    
    
    
    private void openFile() {
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", "*.html"));
        selectedFile = chooser.showOpenDialog(primaryStage);
        if (selectedFile != null) {
            historyFilePath = selectedFile.getPath() + ".history.json";
            try {
                originalContent = new String(Files.readAllBytes(Paths.get(selectedFile.getPath())));
                editorArea.setText(originalContent);
            } catch (IOException ex) {
                showAlert("Error loading file: " + ex.getMessage());
            }
        }
    }

    
    
    
    
    
    
    private void saveFile() {
        if (selectedFile == null) return;
        String newContent = editorArea.getText();
        List<Map<String, Object>> detailedChanges = computeChanges(originalContent, newContent);

        if (!detailedChanges.isEmpty()) {
            saveToHistory(detailedChanges);
            try (FileWriter writer = new FileWriter(selectedFile)) {
                writer.write(newContent);
                originalContent = newContent;
                showAlert("Saved successfully. " + detailedChanges.size() + " change(s) recorded.");
            } catch (IOException ex) {
                showAlert("Error saving file: " + ex.getMessage());
            }
        } else {
            showAlert("No changes detected.");
        }
    }

    
    
    
    
    
    
    

    private List<Map<String, Object>> computeChanges(String oldContent, String newContent) {
        List<Map<String, Object>> changes = new ArrayList<>();

        Document oldDoc = Jsoup.parse(oldContent);
        Document newDoc = Jsoup.parse(newContent);

        Elements oldTables = oldDoc.select("table");
        Elements newTables = newDoc.select("table");

        int minTables = Math.min(oldTables.size(), newTables.size());

        for (int t = 0; t < minTables; t++) {
            Element oldTable = oldTables.get(t);
            Element newTable = newTables.get(t);

            Elements oldRows = oldTable.select("tr");
            Elements newRows = newTable.select("tr");
            int minRows = Math.min(oldRows.size(), newRows.size());

            for (int i = 0; i < minRows; i++) {
                Elements oldCells = oldRows.get(i).select("td, th");
                Elements newCells = newRows.get(i).select("td, th");
                int minCells = Math.min(oldCells.size(), newCells.size());

                for (int j = 0; j < minCells; j++) {
                    String oldVal = oldCells.get(j).text().trim();
                    String newVal = newCells.get(j).text().trim();
                    if (!Objects.equals(oldVal, newVal)) {
                        Map<String, Object> change = new HashMap<>();
                        change.put("type", "cell-change");
                        change.put("table", t + 1);
                        change.put("row", i + 1);
                        change.put("column", j + 1);
                        change.put("oldValue", oldVal);
                        change.put("newValue", newVal);
                        changes.add(change);
                    }
                }

                if (oldCells.size() != newCells.size()) {
                    Map<String, Object> change = new HashMap<>();
                    change.put("type", "cell-count-change");
                    change.put("table", t + 1);
                    change.put("row", i + 1);
                    change.put("oldCount", oldCells.size());
                    change.put("newCount", newCells.size());
                    changes.add(change);
                }
            }

            if (oldRows.size() != newRows.size()) {
                Map<String, Object> change = new HashMap<>();
                change.put("type", "row-count-change");
                change.put("table", t + 1);
                change.put("oldCount", oldRows.size());
                change.put("newCount", newRows.size());
                changes.add(change);
            }
        }

        // نصوص أخرى خارج الجدول (للكمال)
        Patch<String> patch = DiffUtils.diff(
                Arrays.asList(oldContent.split("\n")),
                Arrays.asList(newContent.split("\n"))
        );
        patch.getDeltas().forEach(delta -> {
            Map<String, Object> change = new HashMap<>();
            change.put("type", "text-change");
            change.put("oldValue", delta.getSource().toString());
            change.put("newValue", delta.getTarget().toString());
            changes.add(change);
        });

        return changes;
    }

    
    
    
    
    
    
    
    private void saveToHistory(List<Map<String, Object>> detailedChanges) {
        List<Map<String, Object>> history = loadHistory();
        Map<String, Object> entry = new HashMap<>();
        entry.put("timestamp", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        entry.put("changes", detailedChanges);
        history.add(entry);

        try (FileWriter writer = new FileWriter(historyFilePath)) {
            new Gson().toJson(history, writer);
        } catch (IOException ex) {
            showAlert("Error saving history: " + ex.getMessage());
        }
    }

    
    
    
    
    
    
    
    private List<Map<String, Object>> loadHistory() {
        if (historyFilePath == null || !new File(historyFilePath).exists()) return new ArrayList<>();
        try (Reader reader = new FileReader(historyFilePath)) {
            return new Gson().fromJson(reader, new TypeToken<List<Map<String, Object>>>() {}.getType());
        } catch (IOException ex) {
            showAlert("Error loading history: " + ex.getMessage());
            return new ArrayList<>();
        }
    }

    
    
    
    
    
    

    private void viewHistory() {
        if (historyFilePath == null) {
            showAlert("No file selected.");
            return;
        }
        List<Map<String, Object>> history = loadHistory();
        if (history.isEmpty()) {
            showAlert("No history available.");
            return;
        }

        Stage historyStage = new Stage();
        historyStage.setTitle("File Edit History");

        VBox mainLayout = new VBox(10);
        mainLayout.setPadding(new Insets(10));

        ComboBox<String> historySelector = new ComboBox<>();
        for (Map<String, Object> entry : history) {
            historySelector.getItems().add((String) entry.get("timestamp"));
        }

        TableView<Map<String, Object>> table = new TableView<>();
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        TableColumn<Map<String, Object>, String> typeCol = new TableColumn<>("Type");
        typeCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(String.valueOf(data.getValue().get("type"))));

        TableColumn<Map<String, Object>, String> tableCol = new TableColumn<>("Table");
        tableCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(
                data.getValue().get("table") == null ? "" : String.valueOf(data.getValue().get("table"))));

        TableColumn<Map<String, Object>, String> rowCol = new TableColumn<>("Row");
        rowCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(
                data.getValue().get("row") == null ? "" : String.valueOf(data.getValue().get("row"))));

        TableColumn<Map<String, Object>, String> colCol = new TableColumn<>("Column");
        colCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(
                data.getValue().get("column") == null ? "" : String.valueOf(data.getValue().get("column"))));

        TableColumn<Map<String, Object>, String> oldValCol = new TableColumn<>("Old Value");
        oldValCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(
                String.valueOf(data.getValue().getOrDefault("oldValue", ""))));
        oldValCol.setCellFactory(col -> coloredCell("#ffdddd", "#a00000"));

        TableColumn<Map<String, Object>, String> newValCol = new TableColumn<>("New Value");
        newValCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(
                String.valueOf(data.getValue().getOrDefault("newValue", ""))));
        newValCol.setCellFactory(col -> coloredCell("#ddffdd", "#006600"));

        table.getColumns().addAll(typeCol, tableCol, rowCol, colCol, oldValCol, newValCol);

        historySelector.setOnAction(e -> {
            String ts = historySelector.getValue();
            table.getItems().clear();
            for (Map<String, Object> entry : history) {
                if (entry.get("timestamp").equals(ts)) {
                    List<Map<String, Object>> changes = (List<Map<String, Object>>) entry.get("changes");
                    table.getItems().addAll(changes);
                    break;
                }
            }
        });

        Label lbl = new Label("Select timestamp to view changes:");
        mainLayout.getChildren().addAll(lbl, historySelector, table);

        Scene scene = new Scene(mainLayout, 900, 500);
        historyStage.setScene(scene);
        historyStage.show();
    }

    
    
    
    
    
    
    
    private TableCell<Map<String, Object>, String> coloredCell(String bg, String textColor) {
        return new TableCell<Map<String, Object>, String>() {
            @Override
            protected void updateItem(String item, boolean empty) {
                super.updateItem(item, empty);
                if (empty || item == null || item.isEmpty()) {
                    setText(null);
                    setStyle("");
                } else {
                    setText(item);
                    setStyle("-fx-background-color: " + bg + "; -fx-text-fill: " + textColor + ";");
                }
            }
        };
    }

    
    
    
    
    
    
    
    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }
    
    
    
    
    

    
    
    public static void main(String[] args) {
        launch(args);
    }
    
    
    
    
    
}
