package kadysoft.kady;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Base64;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.PauseTransition;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class SettingsController implements Initializable {


    
    
     @FXML
    private JFXTextField db_field;

    @FXML
    private ComboBox<String> db_tables_box;

    @FXML
    private JFXTextArea log_area;

    @FXML
    private TableView<ObservableList<String>> table;

    @FXML
    private JFXTextField tf1;

    @FXML
    private JFXTextField tf2;

    @FXML
    private JFXTextField tf3;

    @FXML
    private JFXTextField tf4;

    @FXML
    private JFXTextField tf5;

    @FXML
    private JFXTextField tf6;

    @FXML
    private JFXTextField tf7;
    
    @FXML
    private JFXTextField tf8;

    @FXML
    private JFXTextField tf9;

    @FXML
    private JFXTextField tf10;

    @FXML
    private JFXTextField tf11;

    @FXML
    private JFXButton save;
    
    
    
    
    
    
    @FXML
    void browse1action(ActionEvent event) {

      DirectoryChooser fcho = new DirectoryChooser();
      fcho.setTitle("Kady Choose");
      File f = fcho.showDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      tf1.setText(dirpathe);
        
    }

    
    
    
    @FXML
    void browse2action(ActionEvent event) {

        
      DirectoryChooser fcho = new DirectoryChooser();
      fcho.setTitle("Kady Choose");
      File f = fcho.showDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      tf2.setText(dirpathe);
        
    }

    
    
    
    @FXML
    void browse3action(ActionEvent event) {

      DirectoryChooser fcho = new DirectoryChooser();
      fcho.setTitle("Kady Choose");
      File f = fcho.showDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      tf3.setText(dirpathe);
        
        
    }
    
    
    
    
    

    @FXML
    void browse4action(ActionEvent event) {

        
      DirectoryChooser fcho = new DirectoryChooser();
      fcho.setTitle("Kady Choose");
      File f = fcho.showDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      tf4.setText(dirpathe);
        
        
    }

    
    
    
    
    
    
    @FXML
    void browse5action(ActionEvent event) {

        
      DirectoryChooser fcho = new DirectoryChooser();
      fcho.setTitle("Kady Choose");
      File f = fcho.showDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      tf5.setText(dirpathe);
        
        
    }

    
    
    
    
    
    @FXML
    void browse6action(ActionEvent event) {

        
        
      DirectoryChooser fcho = new DirectoryChooser();
      fcho.setTitle("Kady Choose");
      File f = fcho.showDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      tf6.setText(dirpathe);
        
        
    }

    
    
    
    
    
    
    @FXML
    void browse7action(ActionEvent event) {

        
        
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Font Files", new String[]{"*.ttf"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      tf7.setText(dirpathe);
        
        
    }

    
    @FXML
    void browse8action(ActionEvent event) {

        
        
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[]{"*.kady"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      tf8.setText(dirpathe);
        
        
    }

    
    @FXML
    void browse9action(ActionEvent event) {

        
        
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[]{"*.html"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      tf9.setText(dirpathe);
        
        
    }

    
    @FXML
    void browse10action(ActionEvent event) {

        
        
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[]{"*.html"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      tf10.setText(dirpathe);
        
        
    }

    
    @FXML
    void browse11action(ActionEvent event) {

        
        
      DirectoryChooser fcho = new DirectoryChooser();
      fcho.setTitle("Kady Choose");
      File f = fcho.showDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      tf11.setText(dirpathe.replace("\\",""));
        
        
    }
    
    
    @FXML
    void create_dbaction(ActionEvent event) {

        
        try {
            // قراءة الـ base64 من ملف خارجي
            String base64 = readFileToString("lib\\db_base64.txt").trim();
            byte[] dbBytes = Base64.getDecoder().decode(base64);
            String outputPath = System.getProperty("user.home")+"\\Desktop\\Recipe_System_DB.db";
            try (FileOutputStream fos = new FileOutputStream(outputPath)) {
                fos.write(dbBytes);
            }
            
            Notifications noti = Notifications.create();
            noti.title("Great!");
            noti.text("I created the DataBase Successfully at "+outputPath);
            noti.position(Pos.CENTER);
            noti.hideAfter(Duration.seconds(3));
            noti.showInformation();
            
        } catch (Exception e) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("We can't continue, the DataBase wasn't created.");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(3));
        noti.showError();
            e.printStackTrace();
        }
        
        
    }

    
        private static String readFileToString(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }
    
    
    
    
    
    @FXML
    void db_browseaction(ActionEvent event) {

        
        
      FileChooser fcho = new FileChooser();
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Sqlite Files", new String[]{"*.db"}));
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Sqlite Files", new String[]{"*.sqlite"}));
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Sqlite Files", new String[]{"*.sqlite3"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String dirpathe = f.getAbsolutePath().toString();
      db_field.setText(dirpathe);
        
        
        
    }

    
    
    
    
    
    
    
    @FXML
    void db_tablesaction(ActionEvent event) throws ClassNotFoundException, SQLException {

        
        
        
        loadTables();
        
        
        
        
    }

    
    
    
    
    
    
    
    @FXML
    void discardction(ActionEvent event) {

        
    Stage jk = (Stage)this.save.getScene().getWindow();
    jk.close();
    
        
    }
    
    
    
    
    
    
    
    

    @FXML
    void saveaction(ActionEvent event) throws IOException {

        
        
        
        //Save Data about DB and Times
        
        String dbb=db_field.getText();
        String recdb=tf1.getText();
        String recipepathth=tf2.getText();
        String tim=tf3.getText();
        String secc=tf4.getText();
        String mach=tf5.getText();
        String whh=tf6.getText();
        String wherh=tf7.getText();
        
        String secc1=tf8.getText();
        String mach2=tf9.getText();
        String whh3=tf10.getText();
        String wherh4=tf11.getText();
        
        String settingsfile="lib\\setto.cfg";
        PrintWriter pp=new PrintWriter (new FileWriter (settingsfile));
        pp.println("DataBase="+dbb);
        
        pp.println("Recipes="+recdb);
        pp.println("Mod_Recipes="+recipepathth);
        pp.println("Models="+tim);
        pp.println("Recipe_System="+secc);
        pp.println("New_Recipes="+mach);
        pp.println("Signs="+whh);
        pp.println("Fonts="+wherh);
        
        pp.println("Themes="+secc1);
        pp.println("Main_Editor="+mach2);
        pp.println("Secondry_Editor="+whh3);
        pp.print("Orders_Path="+wherh4);
        
        //Continue Saving
        
        pp.close();
        
        Notifications noti = Notifications.create();
        noti.title("Successful");
        noti.text("We have updated the settings successfully.");
        noti.hideAfter(Duration.seconds(3));
        noti.position(Pos.CENTER);
        noti.showInformation();
        
       gitCommands ();
        
        
          ////////////////////////Audit//////////////////////////
      
  
      ///////////////////////////////////////////////////////
          
      // Example: wait 3 seconds then run code
PauseTransition pauset = new PauseTransition(Duration.seconds(2));
pauset.setOnFinished(eventy -> {
    
    Stage jk = (Stage)this.save.getScene().getWindow();
    jk.close();
    
});
pauset.play();
      

        
    }
    
    
    
    

        public static void gitCommands ()   {
        
        Platform.runLater( () -> {
        
        try {
            
            String path = Main.class.getProtectionDomain()
            .getCodeSource().getLocation().toURI().getPath();
            String decodedPath = URLDecoder.decode(path, StandardCharsets.UTF_8.name());
            File file = new File(decodedPath);
            String dir = file.isFile() ? file.getParent() : file.getPath();
            String repoPath = dir+"\\lib";
            String drive = Paths.get(repoPath).getRoot().toString();
            if (dir.length() > 2 && dir.charAt(1) == ':') {
            String driveLetter = dir.substring(0, 2);
    
            }
            
            
            // المسار المطلوب تنفيذه فيه أوامر Git
            
            // تشغيل الأوامر بالترتيب
            runCommand("",drive);
            runCommand("git add .", repoPath);
            runCommand("git commit -m \"Update some data\"", repoPath);
            runCommand("git push", repoPath);

        Notifications noti = Notifications.create();
        noti.title("Successful");
        noti.text("✔ Git operations completed successfully!");
        noti.position(Pos.CENTER);
        noti.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        });
        
    }
    
    
    public static void runCommand(String command, String workingDir) throws Exception {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
        builder.directory(new java.io.File(workingDir));
        builder.redirectErrorStream(true);
        Process process = builder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        process.waitFor();
    }
    
    
    
    
    
    
    
    @FXML
    void test_dbaction(ActionEvent event) {

        
        
        
        try {
         Class.forName("org.sqlite.JDBC");
         Connection conn = DriverManager.getConnection("jdbc:sqlite:"+db_field.getText());
         if (conn != null) {
         log_area.clear();
         log_area.appendText("\nSystem DataBase Connected Successfully.\n");
         }
         } catch (Exception var1) {
         log_area.clear();
         log_area.appendText("\nConnection Failed!\n");
         }
        
        
        
        
    }
    
    
private void loadTables() throws ClassNotFoundException, SQLException {
    Class.forName("org.sqlite.JDBC");
    try (Connection conn = DriverManager.getConnection("jdbc:sqlite:" + db_field.getText())) {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT name FROM sqlite_master WHERE type='table'");

        db_tables_box.getItems().clear();

        while (rs.next()) {
            String tableName = rs.getString("name");
            if (tableName.equalsIgnoreCase("Audit") || tableName.equalsIgnoreCase("Users")) {
                continue;
            }
            db_tables_box.getItems().add(tableName);
        }

        // ────────────── مهم جداً ──────────────
        // نضع الـ listener مرة واحدة فقط خارج اللوب
        db_tables_box.setOnAction(event -> {
            String selectedTable = db_tables_box.getValue();
            if (selectedTable != null) {
                System.out.println("تم اختيار الجدول: " + selectedTable);
                try {
                    loadTableData(selectedTable);
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(SettingsController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        // اختيار أول جدول تلقائياً (اختياري)
        if (!db_tables_box.getItems().isEmpty()) {
            db_tables_box.getSelectionModel().selectFirst();
            // أو يمكنك ترك المستخدم يختار بنفسه
        }

    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}  
    
    
    private void loadTableData(String tableName) throws ClassNotFoundException {
        table.getColumns().clear();
        table.getItems().clear();

        Class.forName("org.sqlite.JDBC");
    try {
        Connection conn = DriverManager.getConnection("jdbc:sqlite:"+db_field.getText());
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM " + tableName);

            int columnCount = rs.getMetaData().getColumnCount();

            // Dynamically create columns
            for (int col = 1; col <= columnCount; col++) {
                final int columnIndex = col - 1;
                String columnName = rs.getMetaData().getColumnName(col);

                TableColumn<ObservableList<String>, String> tableColumn =
                        new TableColumn<>(columnName);

                tableColumn.setCellValueFactory(data ->
                        new SimpleStringProperty(data.getValue().get(columnIndex)));

                // Make cells editable
                tableColumn.setCellFactory(TextFieldTableCell.forTableColumn());
                tableColumn.setOnEditCommit(event -> {
                    String newValue = event.getNewValue();
                    ObservableList<String> row = event.getRowValue();
                    row.set(columnIndex, newValue);

                    // Update DB
                    //updateCell(tableName, row, columnName, newValue);
                });

                table.getColumns().add(tableColumn);
            }

            // Load data
            ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();
            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                for (int i = 1; i <= columnCount; i++) {
                    row.add(rs.getString(i));
                }
                data.add(row);
            }
            table.setItems(data);

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    
////////////////////////////////////////////////////////////////////////////////////////////////////////   
        public static String getValueByKey(String filePath, String key) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.contains("=")) {
                    continue;
                }
                String[] parts = line.split("=", 2);
                String currentKey = parts[0].trim();
                if (currentKey.equals(key)) {
                    return parts[1].trim();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; 
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        
   db_field.setText(getValueByKey("lib\\setto.cfg", "DataBase"));
   
   tf1.setText(getValueByKey("lib\\setto.cfg", "Recipes"));
   tf2.setText(getValueByKey("lib\\setto.cfg", "Mod_Recipes"));
   tf3.setText(getValueByKey("lib\\setto.cfg", "Models"));
   tf4.setText(getValueByKey("lib\\setto.cfg", "Recipe_System"));
   tf5.setText(getValueByKey("lib\\setto.cfg", "New_Recipes"));
   tf6.setText(getValueByKey("lib\\setto.cfg", "Signs"));
   tf7.setText(getValueByKey("lib\\setto.cfg", "Fonts"));
   
   tf8.setText(getValueByKey("lib\\setto.cfg", "Themes"));
   tf9.setText(getValueByKey("lib\\setto.cfg", "Main_Editor"));
   tf10.setText(getValueByKey("lib\\setto.cfg", "Secondry_Editor"));
   tf11.setText(getValueByKey("lib\\setto.cfg", "Orders_Path"));
   
        
        
        
        try {
            String fontPath = tf7.getText(); // غيّر المسار حسب مكان الخط عندك
            javafx.scene.text.Font cairoSemiBold = javafx.scene.text.Font.loadFont(new FileInputStream(fontPath), 15);
        } catch (FileNotFoundException ex) {
          
        }
        
        
        
    
        
        
    }    
    
}
