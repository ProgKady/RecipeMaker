//package kadysoft.kady;
//import javafx.application.Application;
//import javafx.application.Platform;
//import javafx.geometry.Insets;
//import javafx.geometry.Pos;
//import javafx.scene.Scene;
//import javafx.scene.control.*;
//import javafx.scene.input.KeyCode;
//import javafx.scene.layout.*;
//import javafx.scene.text.Font;
//import javafx.stage.FileChooser;
//import javafx.stage.Modality;
//import javafx.stage.Stage;
//
//import java.io.*;
//import java.lang.management.ManagementFactory;
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.nio.charset.StandardCharsets;
//import java.text.SimpleDateFormat;
//import java.util.*;
//import java.util.concurrent.*;
//import com.sun.management.OperatingSystemMXBean;
//
///**
// * LocalAIStudio.java
// * JavaFX single-file MVP for running local LLM server (Windows).
// * - Modern UI
// * - Start/Stop llama.cpp server from Java
// * - Chat UI (send prompt -> http POST to local server)
// * - Settings window (exec path, model path, port, temperature, max_tokens)
// * - Save conversations to JSON
// * - CPU/GPU/Memory status (GPU via nvidia-smi if available)
// *
// * Notes:
// * - Requires JavaFX on Java 8 (add JavaFX libs to classpath).
// * - Adjust server start command arguments if your server binary differs.
// */
//public class LocalAIStudio extends Application {
//
//    // UI components
//    private Label modelLabel;
//    private Label serverStatusLabel;
//    private TextArea chatArea;
//    private TextField inputField;
//    private TextArea consoleArea;
//    private Label sysStatsLabel;
//    private ToggleButton darkModeToggle;
//
//    // State
//    private File modelFile = null;
//    private File serverExe = null;
//    private Process serverProcess = null;
//    private ScheduledExecutorService statsExecutor;
//    private int serverPort = 8080;
//    private double temperature = 0.7;
//    private int maxTokens = 200;
//    private List<Map<String, String>> conversation = Collections.synchronizedList(new ArrayList<>());
//
//    @Override
//    public void start(Stage primaryStage) {
//        primaryStage.setTitle("Local AI Studio - JavaFX (Modern)");
//
//        // Top bar
//        HBox topBar = buildTopBar(primaryStage);
//
//        // Sidebar
//        VBox sidebar = buildSidebar(primaryStage);
//
//        // Chat area
//        BorderPane mainPane = buildMainChatArea(primaryStage);
//
//        // Console & Stats bottom
//        VBox bottomBox = buildBottomBox();
//
//        BorderPane root = new BorderPane();
//        root.setTop(topBar);
//        root.setLeft(sidebar);
//        root.setCenter(mainPane);
//        root.setBottom(bottomBox);
//
//        Scene scene = new Scene(root, 1100, 700);
//
//        applyLightTheme(scene); // default Modern Light
//
//        primaryStage.setScene(scene);
//        primaryStage.show();
//
//        // start periodic stats updater
//        statsExecutor = Executors.newSingleThreadScheduledExecutor();
//        statsExecutor.scheduleAtFixedRate(this::updateSystemStats, 0, 2, TimeUnit.SECONDS);
//    }
//
//    private HBox buildTopBar(Stage stage) {
//        HBox top = new HBox();
//        top.setPadding(new Insets(10));
//        top.setSpacing(10);
//        top.setStyle("-fx-background-color: linear-gradient(to right, #f5f7fa, #e8eefc);");
//
//        Label title = new Label("Local AI Studio");
//        title.setFont(Font.font("Montserrat", 20));
//
//        serverStatusLabel = new Label("Server: stopped");
//        serverStatusLabel.setStyle("-fx-font-weight: bold;");
//
//        Region spacer = new Region();
//        HBox.setHgrow(spacer, Priority.ALWAYS);
//
//        darkModeToggle = new ToggleButton("Dark");
//        darkModeToggle.setOnAction(e -> {
//            if (darkModeToggle.isSelected()) applyDarkTheme(stage.getScene());
//            else applyLightTheme(stage.getScene());
//        });
//
//        Button settingsBtn = new Button("Settings");
//        settingsBtn.setOnAction(e -> openSettingsWindow(stage));
//
//        top.getChildren().addAll(title, serverStatusLabel, spacer, darkModeToggle, settingsBtn);
//        top.setAlignment(Pos.CENTER_LEFT);
//        return top;
//    }
//
//    private VBox buildSidebar(Stage stage) {
//        VBox side = new VBox(12);
//        side.setPadding(new Insets(18));
//        side.setPrefWidth(260);
//        side.setStyle("-fx-background-color: #ffffff; -fx-border-color: #e0e0e0;");
//
//        Label managerTitle = new Label("Model Manager");
//        managerTitle.setFont(Font.font("Poppins", 16));
//
//        Button selectModelBtn = new Button("Select Model (.gguf)");
//        selectModelBtn.setMaxWidth(Double.MAX_VALUE);
//        selectModelBtn.setOnAction(e -> {
//            FileChooser fc = new FileChooser();
//            fc.setTitle("Choose Model File (.gguf)");
//            File f = fc.showOpenDialog(stage);
//            if (f != null) {
//                modelFile = f;
//                modelLabel.setText("Model: " + f.getName());
//                logConsole("Model selected: " + f.getAbsolutePath());
//            }
//        });
//
//        modelLabel = new Label("Model: None");
//        modelLabel.setWrapText(true);
//
//        Button selectExeBtn = new Button("Select Server Executable");
//        selectExeBtn.setMaxWidth(Double.MAX_VALUE);
//        selectExeBtn.setOnAction(e -> {
//            FileChooser fc = new FileChooser();
//            fc.setTitle("Choose Server Executable (llama.cpp build)");
//            File f = fc.showOpenDialog(stage);
//            if (f != null) {
//                serverExe = f;
//                logConsole("Server executable: " + f.getAbsolutePath());
//            }
//        });
//
//        Button startServerBtn = new Button("Start Server");
//        startServerBtn.setMaxWidth(Double.MAX_VALUE);
//        startServerBtn.setOnAction(e -> {
//            if (serverProcess == null) {
//                if (serverExe == null) {
//                    logConsole("Choose a server executable first (Settings or Select).");
//                    return;
//                }
//                if (modelFile == null) {
//                    logConsole("Choose a model file first.");
//                    return;
//                }
//                startServerProcess();
//            } else {
//                logConsole("Server already running.");
//            }
//        });
//
//        Button stopServerBtn = new Button("Stop Server");
//        stopServerBtn.setMaxWidth(Double.MAX_VALUE);
//        stopServerBtn.setOnAction(e -> stopServerProcess());
//
//        Button saveChatBtn = new Button("Save Conversation JSON");
//        saveChatBtn.setMaxWidth(Double.MAX_VALUE);
//        saveChatBtn.setOnAction(e -> saveConversationToFile(stage));
//
//        side.getChildren().addAll(managerTitle, selectModelBtn, modelLabel, selectExeBtn, startServerBtn, stopServerBtn, new Separator(), saveChatBtn);
//        return side;
//    }
//
//    private BorderPane buildMainChatArea(Stage stage) {
//        BorderPane center = new BorderPane();
//        center.setPadding(new Insets(16));
//
//        chatArea = new TextArea();
//        chatArea.setEditable(false);
//        chatArea.setWrapText(true);
//
//        HBox inputBox = new HBox(8);
//        inputBox.setPadding(new Insets(10));
//        inputField = new TextField();
//        inputField.setPromptText("Type your prompt here...");
//        inputField.setPrefWidth(700);
//
//        Button sendBtn = new Button("Send");
//        sendBtn.setDefaultButton(true);
//        sendBtn.setOnAction(e -> sendMessageToServer());
//
//        inputField.setOnKeyPressed(k -> {
//            if (k.getCode() == KeyCode.ENTER && !k.isShiftDown()) {
//                sendMessageToServer();
//                k.consume();
//            }
//        });
//
//        inputBox.getChildren().addAll(inputField, sendBtn);
//        inputBox.setAlignment(Pos.CENTER_LEFT);
//
//        center.setCenter(chatArea);
//        center.setBottom(inputBox);
//        return center;
//    }
//
//    private VBox buildBottomBox() {
//        VBox box = new VBox(8);
//        box.setPadding(new Insets(8));
//        box.setStyle("-fx-background-color: #fafafa; -fx-border-color: #e6e6e6;");
//
//        sysStatsLabel = new Label("System: initializing...");
//        consoleArea = new TextArea();
//        consoleArea.setEditable(false);
//        consoleArea.setPrefRowCount(5);
//
//        box.getChildren().addAll(sysStatsLabel, new Label("Console:"), consoleArea);
//        return box;
//    }
//
//    private void openSettingsWindow(Stage owner) {
//        Stage s = new Stage();
//        s.initModality(Modality.APPLICATION_MODAL);
//        s.initOwner(owner);
//        s.setTitle("Settings");
//
//        GridPane grid = new GridPane();
//        grid.setPadding(new Insets(12));
//        grid.setHgap(10);
//        grid.setVgap(10);
//
//        Label exeLabel = new Label("Server Executable:");
//        TextField exeField = new TextField();
//        exeField.setPrefWidth(420);
//        if (serverExe != null) exeField.setText(serverExe.getAbsolutePath());
//
//        Button exeBrowse = new Button("Browse");
//        exeBrowse.setOnAction(e -> {
//            FileChooser fc = new FileChooser();
//            File f = fc.showOpenDialog(owner);
//            if (f != null) exeField.setText(f.getAbsolutePath());
//        });
//
//        Label modelLbl = new Label("Model Path:");
//        TextField modelField = new TextField();
//        if (modelFile != null) modelField.setText(modelFile.getAbsolutePath());
//        Button modelBrowse = new Button("Browse");
//        modelBrowse.setOnAction(e -> {
//            FileChooser fc = new FileChooser();
//            File f = fc.showOpenDialog(owner);
//            if (f != null) modelField.setText(f.getAbsolutePath());
//        });
//
//        Label portLbl = new Label("Server Port:");
//        TextField portField = new TextField(String.valueOf(serverPort));
//
//        Label tempLbl = new Label("Temperature:");
//        TextField tempField = new TextField(String.valueOf(temperature));
//
//        Label maxTokLbl = new Label("Max Tokens:");
//        TextField maxTokField = new TextField(String.valueOf(maxTokens));
//
//        Button saveBtn = new Button("Save");
//        saveBtn.setOnAction(e -> {
//            // save settings
//            String exePath = exeField.getText().trim();
//            if (!exePath.isEmpty()) serverExe = new File(exePath);
//
//            String mPath = modelField.getText().trim();
//            if (!mPath.isEmpty()) modelFile = new File(mPath);
//
//            try {
//                serverPort = Integer.parseInt(portField.getText().trim());
//            } catch (Exception ex) {
//                logConsole("Invalid port number. Using previous value: " + serverPort);
//            }
//            try {
//                temperature = Double.parseDouble(tempField.getText().trim());
//            } catch (Exception ex) {
//                logConsole("Invalid temperature. Using previous value: " + temperature);
//            }
//            try {
//                maxTokens = Integer.parseInt(maxTokField.getText().trim());
//            } catch (Exception ex) {
//                logConsole("Invalid max tokens. Using previous value: " + maxTokens);
//            }
//
//            if (modelFile != null) modelLabel.setText("Model: " + modelFile.getName());
//            logConsole("Settings saved.");
//            s.close();
//        });
//
//        grid.add(exeLabel, 0, 0); grid.add(exeField, 1, 0); grid.add(exeBrowse, 2, 0);
//        grid.add(modelLbl, 0, 1); grid.add(modelField, 1, 1); grid.add(modelBrowse, 2, 1);
//        grid.add(portLbl, 0, 2); grid.add(portField, 1, 2);
//        grid.add(tempLbl, 0, 3); grid.add(tempField, 1, 3);
//        grid.add(maxTokLbl, 0, 4); grid.add(maxTokField, 1, 4);
//        grid.add(saveBtn, 1, 5);
//
//        Scene sc = new Scene(grid, 700, 260);
//        s.setScene(sc);
//        s.show();
//    }
//
//    private void startServerProcess() {
//        if (serverExe == null || !serverExe.exists()) {
//            logConsole("Server executable not set or not found.");
//            return;
//        }
//        if (modelFile == null || !modelFile.exists()) {
//            logConsole("Model file not set or not found.");
//            return;
//        }
//
//        try {
//            List<String> cmd = new ArrayList<>();
//            cmd.add(serverExe.getAbsolutePath());
//            cmd.add("--model");
//            cmd.add(modelFile.getAbsolutePath());
//            cmd.add("--port");
//            cmd.add(String.valueOf(serverPort));
//            // add any other args you need (adjust to your server build)
//            ProcessBuilder pb = new ProcessBuilder(cmd);
//            pb.redirectErrorStream(true);
//
//            serverProcess = pb.start();
//            serverStatusLabel.setText("Server: starting...");
//            logConsole("Starting server: " + String.join(" ", cmd));
//
//            // read process stdout asynchronously
//            Executors.newSingleThreadExecutor().submit(() -> {
//                try (BufferedReader br = new BufferedReader(new InputStreamReader(serverProcess.getInputStream()))) {
//                    String line;
//                    while ((line = br.readLine()) != null) {
//                        String ln = line;
//                        Platform.runLater(() -> logConsole("[server] " + ln));
//                    }
//                } catch (IOException ioe) {
//                    Platform.runLater(() -> logConsole("Server output read error: " + ioe.getMessage()));
//                }
//            });
//
//            // wait briefly then check alive
//            Executors.newSingleThreadScheduledExecutor().schedule(() -> {
//                if (serverProcess.isAlive()) {
//                    Platform.runLater(() -> {
//                        serverStatusLabel.setText("Server: running on port " + serverPort);
//                        logConsole("Server is running.");
//                    });
//                } else {
//                    Platform.runLater(() -> {
//                        serverStatusLabel.setText("Server: stopped");
//                        logConsole("Server failed to start.");
//                    });
//                }
//            }, 1, TimeUnit.SECONDS);
//
//        } catch (Exception ex) {
//            logConsole("Failed to start server: " + ex.getMessage());
//            serverProcess = null;
//            serverStatusLabel.setText("Server: stopped");
//        }
//    }
//
//    private void stopServerProcess() {
//        if (serverProcess != null) {
//            serverProcess.destroy();
//            logConsole("Stopping server...");
//            serverProcess = null;
//            serverStatusLabel.setText("Server: stopped");
//        } else {
//            logConsole("Server is not running.");
//        }
//    }
//
//    private void sendMessageToServer() {
//        String prompt = inputField.getText().trim();
//        if (prompt.isEmpty()) return;
//        inputField.clear();
//
//        appendChat("You", prompt);
//        // Add to conversation
//        Map<String, String> msg = new HashMap<>();
//        msg.put("role", "user");
//        msg.put("text", prompt);
//        msg.put("time", now());
//        conversation.add(msg);
//
//        // send in background
//        Executors.newSingleThreadExecutor().submit(() -> {
//            String reply = callLocalModel(prompt);
//            Platform.runLater(() -> {
//                appendChat("AI", reply);
//                Map<String, String> r = new HashMap<>();
//                r.put("role", "assistant");
//                r.put("text", reply);
//                r.put("time", now());
//                conversation.add(r);
//            });
//        });
//    }
//
//    private String callLocalModel(String prompt) {
//        try {
//            URL url = new URL("http://127.0.0.1:" + serverPort + "/v1/generate");
//            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//            conn.setConnectTimeout(6000);
//            conn.setReadTimeout(60000);
//            conn.setRequestMethod("POST");
//            conn.setRequestProperty("Content-Type", "application/json");
//            conn.setDoOutput(true);
//
//            // Simple JSON payload - adjust if your server expects different schema
//            String json = "{\"prompt\":\"" + escapeJson(prompt) + "\",\"max_tokens\":" + maxTokens + ",\"temperature\":" + temperature + "}";
//
//            try (OutputStream os = conn.getOutputStream()) {
//                os.write(json.getBytes(StandardCharsets.UTF_8));
//                os.flush();
//            }
//
//            int code = conn.getResponseCode();
//            InputStream is = (code >= 200 && code < 300) ? conn.getInputStream() : conn.getErrorStream();
//            BufferedReader br = new BufferedReader(new InputStreamReader(is, StandardCharsets.UTF_8));
//            StringBuilder sb = new StringBuilder();
//            String line;
//            while ((line = br.readLine()) != null) sb.append(line).append("\n");
//            br.close();
//
//            String resp = sb.toString().trim();
//            if (resp.isEmpty()) resp = "(empty response)";
//            return resp;
//        } catch (Exception e) {
//            logConsole("Error calling local model: " + e.getMessage());
//            return "Error connecting to local model. Make sure the server is running on port " + serverPort;
//        }
//    }
//
//    private void appendChat(String who, String text) {
//        chatArea.appendText("[" + who + " - " + now() + "]\n");
//        chatArea.appendText(text + "\n\n");
//    }
//
//    private void saveConversationToFile(Stage stage) {
//        if (conversation.isEmpty()) {
//            logConsole("No messages to save.");
//            return;
//        }
//        FileChooser fc = new FileChooser();
//        fc.setTitle("Save Conversation");
//        fc.setInitialFileName("conversation_" + new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date()) + ".json");
//        File f = fc.showSaveDialog(stage);
//        if (f == null) return;
//
//        try (Writer w = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(f), StandardCharsets.UTF_8))) {
//            String json = conversationToJson();
//            w.write(json);
//            logConsole("Conversation saved to: " + f.getAbsolutePath());
//        } catch (Exception ex) {
//            logConsole("Failed to save conversation: " + ex.getMessage());
//        }
//    }
//
//    private String conversationToJson() {
//        StringBuilder sb = new StringBuilder();
//        sb.append("{\n  \"conversation\": [\n");
//        boolean first = true;
//        synchronized (conversation) {
//            for (Map<String, String> m : conversation) {
//                if (!first) sb.append(",\n");
//                first = false;
//                sb.append("    {\n");
//                sb.append("      \"role\": \"").append(escapeJson(m.get("role"))).append("\",\n");
//                sb.append("      \"time\": \"").append(escapeJson(m.get("time"))).append("\",\n");
//                sb.append("      \"text\": \"").append(escapeJson(m.get("text"))).append("\"\n");
//                sb.append("    }");
//            }
//        }
//        sb.append("\n  ]\n}");
//        return sb.toString();
//    }
//
//    private void logConsole(String text) {
//        Platform.runLater(() -> {
//            consoleArea.appendText("[" + now() + "] " + text + "\n");
//        });
//    }
//
//    private void updateSystemStats() {
//        try {
//            StringBuilder sb = new StringBuilder();
//
//            // CPU & memory via com.sun.management.OperatingSystemMXBean
//            OperatingSystemMXBean osBean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
//            double cpuLoad = osBean.getSystemCpuLoad(); // 0.0 - 1.0 (may return -1)
//            long totalMem = osBean.getTotalPhysicalMemorySize();
//            long freeMem = osBean.getFreePhysicalMemorySize();
//            long usedMem = totalMem - freeMem;
//
//            String cpuStr = (cpuLoad >= 0) ? String.format("CPU: %.0f%%", cpuLoad * 100) : "CPU: N/A";
//            String memStr = String.format("Memory: %s / %s",
//                    humanReadableBytes(usedMem), humanReadableBytes(totalMem));
//
//            sb.append(cpuStr).append(" | ").append(memStr);
//
//            // GPU via nvidia-smi (if available)
//            try {
//                ProcessBuilder pb = new ProcessBuilder("nvidia-smi", "--query-gpu=memory.total,memory.used", "--format=csv,noheader,nounits");
//                pb.redirectErrorStream(true);
//                Process p = pb.start();
//                BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
//                String line = br.readLine();
//                if (line != null && !line.trim().isEmpty()) {
//                    // example output: "4096 MiB, 123 MiB"
//                    String[] parts = line.split(",");
//                    if (parts.length >= 2) {
//                        String tot = parts[0].replaceAll("[^0-9]", "").trim();
//                        String used = parts[1].replaceAll("[^0-9]", "").trim();
//                        sb.append(" | GPU: ").append(used).append(" MB / ").append(tot).append(" MB");
//                    }
//                }
//                br.close();
//            } catch (IOException ignored) {
//                // nvidia-smi not present � skip
//            }
//
//            final String stats = sb.toString();
//            Platform.runLater(() -> sysStatsLabel.setText(stats));
//        } catch (Throwable t) {
//            // ignore stats errors
//        }
//    }
//
//    private static String humanReadableBytes(long bytes) {
//        double b = bytes;
//        String[] units = {"B","KB","MB","GB","TB"};
//        int i = 0;
//        while (b >= 1024 && i < units.length - 1) {
//            b /= 1024; i++;
//        }
//        return String.format("%.1f %s", b, units[i]);
//    }
//
//    private static String escapeJson(String s) {
//        if (s == null) return "";
//        return s.replace("\\","\\\\").replace("\"","\\\"").replace("\n","\\n").replace("\r","\\r");
//    }
//
//    private static String now() {
//        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
//    }
//
//    private void applyDarkTheme(Scene scene) {
//        scene.getRoot().setStyle("-fx-font-family: 'Segoe UI'; -fx-base: #2b2b2b; -fx-background: #1f1f1f; -fx-text-fill: #eaeaea;");
//        scene.getStylesheets().clear();
//        scene.getRoot().setStyle("-fx-background-color: linear-gradient(to bottom, #111217, #1b1f2a); -fx-text-fill: #e8e8e8;");
//    }
//
//    private void applyLightTheme(Scene scene) {
//        scene.getRoot().setStyle("-fx-font-family: 'Segoe UI'; -fx-base: #ffffff; -fx-background: #f9fbff; -fx-text-fill: #111;");
//        scene.getStylesheets().clear();
//    }
//
//    @Override
//    public void stop() throws Exception {
//        if (statsExecutor != null) statsExecutor.shutdownNow();
//        stopServerProcess();
//        super.stop();
//    }
//
//    public static void main(String[] args) {
//        launch(args);
//    }
//}
