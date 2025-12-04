package kadysoft.kady;



import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class HistoryCheckerController implements Initializable {

    
    
    @FXML
    private JFXTextArea list,rora;

    @FXML
    private Text text;
    
    
    @FXML
    private JFXButton fix;
    
    Connection conn = null;
  
  ResultSet rs = null;
  
  PreparedStatement pst = null;
  
  public static String historyyfileepathh;
  
  
    @FXML
    private Hyperlink status;
  
   public static String stonny,finall;
   
   public static String wq;
   public static String ew;
   
   
   public static double sto,sumz,ally;
   public static File fdsa;
     
      
   
   private List<Map<String, Object>> loadHistory() {
        if (historyyfileepathh == null || !new File(historyyfileepathh).exists()) return new ArrayList<>();
        try (Reader reader = new FileReader(historyyfileepathh)) {
            return new Gson().fromJson(reader, new TypeToken<List<Map<String, Object>>>() {}.getType());
        } catch (IOException ex) {
            return new ArrayList<>();
        }
    }
   
   
   private javafx.scene.control.TableCell<Map<String, Object>, String> coloredCell(String bg, String textColor) {
        return new javafx.scene.control.TableCell<Map<String, Object>, String>() {
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
   
      
      private void viewHistory() {
    if (historyyfileepathh == null) {
        //return;
        status.setVisible(true);
        status.setText("No history found for this recipe.");
    }
    
    if (!fdsa.exists()) {
        //return;
        status.setVisible(true);
        status.setText("No history found for this recipe.");
    }

    List<Map<String, Object>> history = loadHistory();
    if (history.isEmpty()) {
        return;
    }

    Stage historyStage = new Stage();
    VBox mainLayout = new VBox(10);
    mainLayout.setPadding(new Insets(10));
    mainLayout.setFillWidth(true);

    BorderPane ddds = new BorderPane();

    ComboBox<String> historySelector = new ComboBox<>();
    for (Map<String, Object> entry : history) {
        historySelector.getItems().add((String) entry.get("timestamp"));
    }

    TableView<Map<String, Object>> table = new TableView<>();
    table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

    TableColumn<Map<String, Object>, String> typeCol = new TableColumn<>("Type");
    typeCol.setCellValueFactory(data -> 
        new javafx.beans.property.SimpleStringProperty(String.valueOf(data.getValue().get("type")))
    );

    TableColumn<Map<String, Object>, String> tableCol = new TableColumn<>("Table");
    tableCol.setCellValueFactory(data -> 
        new javafx.beans.property.SimpleStringProperty(
            data.getValue().get("table") == null ? "" : String.valueOf(data.getValue().get("table"))
        )
    );

    TableColumn<Map<String, Object>, String> rowCol = new TableColumn<>("Row");
    rowCol.setCellValueFactory(data -> 
        new javafx.beans.property.SimpleStringProperty(
            data.getValue().get("row") == null ? "" : String.valueOf(data.getValue().get("row"))
        )
    );

    TableColumn<Map<String, Object>, String> colCol = new TableColumn<>("Column");
    colCol.setCellValueFactory(data -> 
        new javafx.beans.property.SimpleStringProperty(
            data.getValue().get("column") == null ? "" : String.valueOf(data.getValue().get("column"))
        )
    );

    TableColumn<Map<String, Object>, String> oldValCol = new TableColumn<>("Old Value");
    oldValCol.setCellValueFactory(data -> 
        new javafx.beans.property.SimpleStringProperty(
            String.valueOf(data.getValue().getOrDefault("oldValue", ""))
        )
    );
    oldValCol.setCellFactory(col -> coloredCell("#ffdddd", "#a00000"));

    TableColumn<Map<String, Object>, String> newValCol = new TableColumn<>("New Value");
    newValCol.setCellValueFactory(data -> 
        new javafx.beans.property.SimpleStringProperty(
            String.valueOf(data.getValue().getOrDefault("newValue", ""))
        )
    );
    newValCol.setCellFactory(col -> coloredCell("#ddffdd", "#006600"));

    table.getColumns().addAll(typeCol, tableCol, rowCol, colCol, oldValCol, newValCol);

    // ✅ فلترة الصفوف بحيث تظهر فقط اللي فيها row و column مش فاضيين
    historySelector.setOnAction(e -> {
        String ts = historySelector.getValue();
        table.getItems().clear();
        for (Map<String, Object> entry : history) {
            if (entry.get("timestamp").equals(ts)) {
                List<Map<String, Object>> changes = (List<Map<String, Object>>) entry.get("changes");
                for (Map<String, Object> change : changes) {
                    String rowVal = String.valueOf(change.getOrDefault("row", "")).trim();
                    String colVal = String.valueOf(change.getOrDefault("column", "")).trim();
                    // يعرض فقط لو row و column مش فاضيين
                    if (!rowVal.isEmpty() && !colVal.isEmpty()) {
                        table.getItems().add(change);
                    }
                }
                break;
            }
        }
    });

    ddds.setCenter(table);
    ddds.setTop(historySelector);

    Scene scene = new Scene(ddds, 900, 500);
    scene.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
    historyStage.setTitle("Recipe Editing History");
    historyStage.setMaximized(true);
    historyStage.setScene(scene);
    historyStage.show();
}
    
    
@FXML
void fixaction(ActionEvent event) throws FileNotFoundException, IOException {

    if (list.getText().isEmpty()) {
        status.setVisible(true);
        status.setText("Please add one recipe for checking first");
        text.setVisible(false); // اخفاء النص
        return; // مهم: ارجع هنا عشان ما يكملش الكود
    }  

    String namo = list.getText();
    String[] pathParts = namo.split("\\\\");   
    if (pathParts.length < 6) {
        status.setVisible(true);
        status.setText("Invalid recipe path");
        text.setVisible(false);
        return;
    }

    String recipenami = pathParts[5].replaceAll(".ks", "").replaceAll(".html", "");
    String modelooo = pathParts[4];

    wq = modelooo;
    ew = recipenami;
    historyyfileepathh = NewDir.file_dirrrr+"\\Recipes_History\\"+wq+"."+ew+".history.json";
    fdsa = new File(historyyfileepathh);

    if (!fdsa.exists()) {
        status.setVisible(true);
        status.setText("No history found for this recipe.");
        text.setVisible(false);
        return; // لا تدخل viewHistory()
    }

    // كل شيء تمام، إخفاء status
    status.setVisible(false);
    text.setVisible(true);

    viewHistory();
    list.clear();
}

    

    
    @FXML
    void folderactionrecipe(ActionEvent event) throws IOException {

        String hisfolder = NewDir.file_dirrrr+"\\Recipes";
        Desktop gdsa=Desktop.getDesktop();
        gdsa.open(new File (hisfolder));

    }
    
    
    @FXML
    void folderaction(ActionEvent event) throws IOException {

        String hisfolder = NewDir.file_dirrrr+"\\Recipes_History";
        Desktop gdsa=Desktop.getDesktop();
        gdsa.open(new File (hisfolder));

    }
    

    @FXML
    void dragdropaction(DragEvent event) {
        text.setVisible(false);
        list.clear();
        list.appendText(event.getDragboard().getFiles().stream().map(File::getAbsolutePath).collect(Collectors.joining("\n")));
        event.setDropCompleted(true);
    }

    @FXML
    void dragoveraction(DragEvent event) {
        if (event.getDragboard().hasFiles()) {
            event.acceptTransferModes(TransferMode.LINK);
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
