import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class RecipeParserApp extends Application {

    TableView<WashStep> tableView = new TableView<>();
    TextArea codeArea = new TextArea();
    List<WashStep> steps = new ArrayList<>();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        stage.setTitle("Recipe to ELiAR Code Generator");

        // Buttons
        Button uploadBtn = new Button("Upload HTML");
        Button generateBtn = new Button("Generate Code");
        Button saveBtn = new Button("Save Program");

        HBox buttonBar = new HBox(10, uploadBtn, generateBtn, saveBtn);

        // TableView Columns
        TableColumn<WashStep, String> actionCol = new TableColumn<>("Action");
        actionCol.setCellValueFactory(data -> data.getValue().actionProperty());

        TableColumn<WashStep, Integer> timeCol = new TableColumn<>("Time");
        timeCol.setCellValueFactory(data -> data.getValue().timeProperty().asObject());

        TableColumn<WashStep, Integer> tempCol = new TableColumn<>("Temp");
        tempCol.setCellValueFactory(data -> data.getValue().tempProperty().asObject());

        TableColumn<WashStep, Integer> litersCol = new TableColumn<>("Liters");
        litersCol.setCellValueFactory(data -> data.getValue().litersProperty().asObject());

        TableColumn<WashStep, String> chemCol = new TableColumn<>("Chemical");
        chemCol.setCellValueFactory(data -> data.getValue().chemicalProperty());

        tableView.getColumns().addAll(actionCol, timeCol, tempCol, litersCol, chemCol);

        VBox root = new VBox(10, buttonBar, tableView, codeArea);
        root.setPadding(new javafx.geometry.Insets(10));

        // Button Actions
        uploadBtn.setOnAction(e -> loadHTML(stage));
        generateBtn.setOnAction(e -> generateCode());
        saveBtn.setOnAction(e -> saveCode(stage));

        Scene scene = new Scene(root, 900, 600);
        stage.setScene(scene);
        stage.show();
    }

    private void loadHTML(Stage stage) {
        try {
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", "*.html"));
            File file = fc.showOpenDialog(stage);
            if (file == null) return;

            Document doc = Jsoup.parse(file, "UTF-8");
            Elements rows = doc.select("table tr");
            steps.clear();
            tableView.getItems().clear();

            for (Element row : rows) {
                Elements cols = row.select("td");
                if (cols.size() >= 10) {
                    String action = cols.get(1).text().trim();
                    if (action.isEmpty()) continue; // skip empty rows
                    int time = parseInt(cols.get(2).text());
                    int temp = parseInt(cols.get(3).text());
                    int liters = parseInt(cols.get(4).text());
                    String chemical = cols.get(9).text().trim(); // Chemical Name
                    WashStep step = new WashStep(action, time, temp, liters, chemical);
                    steps.add(step);
                }
            }

            tableView.getItems().addAll(steps);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private void generateCode() {
        StringBuilder sb = new StringBuilder();
        sb.append("998\n");
        int phase = 1;
        for (WashStep step : steps) {
            // Add Drain before Rinse
            if (step.getAction().equalsIgnoreCase("RINSE")) {
                sb.append(String.format("5 F=1 P=%d IO= SP=0.00 TEMP=0.00 LITERS=0.00\n", phase++));
            }

            int command = getCommand(step.getAction());
            sb.append(String.format("%d F=1 P=%d IO=%s SP=%.2f TEMP=%.2f LITERS=%.2f\n",
                    command, phase++, step.getChemical().isEmpty() ? step.getAction() : step.getChemical(),
                    (double) step.getTime(), (double) step.getTemp(), (double) step.getLiters()));
        }
        sb.append("999");
        codeArea.setText(sb.toString());
    }

    private void saveCode(Stage stage) {
        try {
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files", "*.txt"));
            File file = fc.showSaveDialog(stage);
            if (file == null) return;

            FileWriter writer = new FileWriter(file);
            writer.write(codeArea.getText());
            writer.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private int getCommand(String action) {
        switch (action.toUpperCase()) {
            case "RINSE":
            case "DESIZE":
            case "ENZYME":
                return 14;
            case "EXTRACT":
                return 13;
            case "DRAIN":
                return 5;
            case "WAIT":
                return 6;
            default:
                return 6; // default to Wait for unknown actions
        }
    }

    private int parseInt(String text) {
        try {
            return Integer.parseInt(text);
        } catch (Exception e) {
            return 0;
        }
    }
}
