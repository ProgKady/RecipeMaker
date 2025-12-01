import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.print.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class HTMLPrintPreviewApp extends Application {

    private WebView webView;
    private ComboBox<Paper> paperSizeBox;
    private ComboBox<PageOrientation> orientationBox;
    private Slider zoomSlider;
    private Spinner<Integer> marginSpinner;

    private String originalContent = null; // To keep original HTML content for CSS injection

    @Override
    public void start(Stage stage) {
        stage.setTitle("HTML Print Preview - JavaFX");

        webView = new WebView();
        WebEngine engine = webView.getEngine();

        // Controls
        Button openBtn = new Button("Open HTML");
        openBtn.setOnAction(e -> {
            FileChooser chooser = new FileChooser();
            chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", "*.html", "*.htm"));
            File file = chooser.showOpenDialog(stage);
            if (file != null) {
                engine.load(file.toURI().toString());
                engine.documentProperty().addListener((obs, oldDoc, newDoc) -> {
                    if (newDoc != null) {
                        // Save original content when loaded (async)
                        engine.executeScript("document.documentElement.outerHTML").toString();
                        // We use a small delay to fetch content after load:
                        engine.getLoadWorker().stateProperty().addListener((obsLoad, oldState, newState) -> {
                            switch (newState) {
                                case SUCCEEDED:
                                    originalContent = (String) engine.executeScript("document.documentElement.outerHTML");
                                    updatePrintPreview();
                                    break;
                            }
                        });
                    }
                });
            }
        });

        Button printBtn = new Button("Print");
        printBtn.setOnAction(e -> print(stage));

        paperSizeBox = new ComboBox<>();
        paperSizeBox.getItems().addAll(Paper.A4, Paper.A5, Paper.A3);
        paperSizeBox.setValue(Paper.A4);

        orientationBox = new ComboBox<>();
        orientationBox.getItems().addAll(PageOrientation.PORTRAIT, PageOrientation.LANDSCAPE);
        orientationBox.setValue(PageOrientation.PORTRAIT);

        zoomSlider = new Slider(0.5, 2.0, 1.0);
        zoomSlider.setShowTickLabels(true);
        zoomSlider.setShowTickMarks(true);
        zoomSlider.setMajorTickUnit(0.5);
        zoomSlider.setMinorTickCount(4);

        marginSpinner = new Spinner<>(0, 100, 10);
        marginSpinner.setEditable(true);

        // Listeners to update preview on changes
        paperSizeBox.setOnAction(e -> updatePrintPreview());
        orientationBox.setOnAction(e -> updatePrintPreview());
        marginSpinner.valueProperty().addListener((obs, oldVal, newVal) -> updatePrintPreview());
        zoomSlider.valueProperty().addListener((obs, oldVal, newVal) -> webView.setZoom(newVal.doubleValue()));

        ToolBar toolbar = new ToolBar(
                openBtn,
                new Label("Paper:"), paperSizeBox,
                new Label("Orientation:"), orientationBox,
                new Label("Zoom:"), zoomSlider,
                new Label("Margin (mm):"), marginSpinner,
                printBtn
        );

        BorderPane root = new BorderPane();
        root.setTop(toolbar);
        root.setCenter(webView);

        Scene scene = new Scene(root, 1200, 800);

        // Optional: add your dark theme if you have one
        // scene.getStylesheets().add(getClass().getResource("dark-theme.css").toExternalForm());

        stage.setScene(scene);
        stage.show();
    }

    private void updatePrintPreview() {
        if (originalContent == null || originalContent.isEmpty()) {
            return; // nothing loaded yet
        }

        Paper paper = paperSizeBox.getValue();
        PageOrientation orientation = orientationBox.getValue();
        int marginMM = marginSpinner.getValue();

        // Convert mm to pixels (approximate, 96 dpi)
        double marginPx = marginMM * 96.0 / 25.4;

        // Paper size in points (1 pt = 1/72 inch)
        double widthInches = paper.getWidth() / 72.0;
        double heightInches = paper.getHeight() / 72.0;

        // Convert inches to pixels (96 dpi)
        double widthPx = widthInches * 96;
        double heightPx = heightInches * 96;

        // Swap for landscape
        if (orientation == PageOrientation.LANDSCAPE) {
            double temp = widthPx;
            widthPx = heightPx;
            heightPx = temp;
        }

        // Build CSS to simulate print page and margins
        String css = String.format(
                "<style>" +
                        "body { " +
                        "width: %.0fpx; " +
                        "height: %.0fpx; " +
                        "margin: %.0fpx; " +
                        "box-sizing: border-box; " +
                        "background: white; " +
                        "overflow: hidden; " +
                        "}" +
                        "html { background: #888888; }" +
                        "</style>", widthPx, heightPx, marginPx);

        // Insert CSS inside <head> or create head if missing
        String modifiedContent;

        if (originalContent.toLowerCase().contains("<head>")) {
            modifiedContent = originalContent.replaceFirst("(?i)(<head[^>]*>)", "$1" + css);
        } else {
            // no head tag, add one
            modifiedContent = "<head>" + css + "</head>" + originalContent;
        }

        webView.getEngine().loadContent(modifiedContent);
    }

    private void print(Stage stage) {
        Printer printer = Printer.getDefaultPrinter();
        if (printer == null) {
            showAlert("No printer found.");
            return;
        }

        PrinterJob job = PrinterJob.createPrinterJob(printer);
        if (job == null) {
            showAlert("Could not create printer job.");
            return;
        }

        PageLayout layout = printer.createPageLayout(
                paperSizeBox.getValue(),
                orientationBox.getValue(),
                marginSpinner.getValue(), marginSpinner.getValue(),
                marginSpinner.getValue(), marginSpinner.getValue()
        );

        job.getJobSettings().setPageLayout(layout);

        boolean proceed = job.showPrintDialog(stage);
        if (proceed) {
            try {
                webView.getEngine().print(job);
                job.endJob();
            } catch (Exception e) {
                showAlert("Print failed: " + e.getMessage());
            }
        } else {
            showAlert("Print job was cancelled.");
        }
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.WARNING, msg, ButtonType.OK);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch();
    }
}
