package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
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
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.ResourceBundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.MILLISECONDS;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TablePosition;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JEditorPane;
import javax.swing.JOptionPane;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.table.TableFilter;

public class ViewerController_1  <T extends Comparable<T>>  implements Initializable {
  Connection conn = null;
  
  ResultSet rs = null;
  
  PreparedStatement pst = null;
  
  ToggleGroup tg;
  
  @FXML
  private TableView table;
  
  @FXML
  private Hyperlink link;
  
  @FXML
  private JFXRadioButton date;
 
  
  @FXML
  private JFXRadioButton stage;
  
  @FXML
    private JFXButton openrecipesfolder;

    @FXML
    private JFXButton editorprint;
  
  @FXML
  private JFXRadioButton model;
  
  @FXML
  private JFXRadioButton name;
  
  @FXML
  private JFXButton getallbtn;
  
  @FXML
  private Label adslabel,tablee,image;
  
  @FXML
  private ImageView adsimage;
  
  @FXML
  private Rectangle rectangle;
  
  @FXML
    private WebView marque;
  
  @FXML
  private JFXTextArea coode;
  
  
  @FXML
  private JFXButton seepilot;
  
  public static String ho,min,exittime;
  
 
  
  
   @FXML
    void tableeaction(MouseEvent event) throws FileNotFoundException, UnsupportedEncodingException, IOException, InterruptedException {

         
        String wsa=link.getText();
        
        if (!wsa.contains(".ks")) {
            
        //Noti to choose one first
        Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
        ImageView imgview = new ImageView();
        imgview.setImage(img);
        Notifications noti = Notifications.create();
        noti.title("Error");
        noti.text("I can't find the recipe, please choose one first.");
        noti.graphic(imgview);
        noti.position(Pos.CENTER);
        noti.show();
            
        }
        
        else {
      String pathy = link.getText().replace("\\","\\\\").replace("Z:","X:").replace("X:","X:").replace("V:","X:").replace("W:","X:");
      File op = new File(pathy);
      
      if (!op.exists()) {
        Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
        ImageView imgview = new ImageView();
        imgview.setImage(img);
        Notifications noti = Notifications.create();
        noti.title("Error");
        noti.text("I can't find the recipe, maybe KADINIO has deleted or encrypted it.");
        noti.graphic(imgview);
        noti.position(Pos.CENTER);
        noti.show();
        
        
      } else {
        
          File on1=new File (System.getProperty("user.home")+"\\Hehehe");
          if (!on1.exists()) {
              on1.mkdir();
          }
          else {
              
          }
          File tw2o=new File (System.getProperty("user.home")+"\\Hehehe\\Roro.html");
          if (!tw2o.exists()) {
              tw2o.createNewFile();
          }
          else {
              
          }
          
          
          
               
    coode.clear();
    InputStream inputinstream=new FileInputStream(pathy);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    String lo;
    while ((lo=bi.readLine())!=null) {
        
        coode.appendText("\n"+lo
       .replace("ﬦ","A")
       .replace("ﬧ","B")
       .replace("ﬨ","C")
       .replace("﬩","D")
       .replace("שׁ","E")    
       .replace("שׂ","F")        
       .replace("שּׁ","G")         
       .replace("שּׂ","H")         
       .replace("אַ","I")         
       .replace("אָ","J")         
       .replace("אּ","K")         
       .replace("בּ","L")         
       .replace("גּ","M")         
       .replace("דּ","N")         
       .replace("הּ","O")         
       .replace("וּ","P")         
       .replace("זּ","Q")         
       .replace("טּ","R")         
       .replace("יּ","S")         
       .replace("ךּ","T")         
       .replace("כּ","U")         
       .replace("לּ","V")
       .replace("מּ","W")         
       .replace("נּ","X")         
       .replace("סּ","Y")         
       .replace("ףּ","Z")         
       .replace("פּ","0")         
       .replace("צּ","1")         
       .replace("קּ","2")         
       .replace("רּ","3")         
       .replace("שּ","4")         
       .replace("תּ","5")         
       .replace("וֹ","6")         
       .replace("בֿ","7")         
       .replace("כֿ","8")
       .replace("פֿ","9")
       .replace("&NBSP;","")        
                
               
      ); 


    }
    bi.close();
    String gf=coode.getText();
    OutputStream instreamm=new FileOutputStream(tw2o);
    PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    pwe.println(gf);
    pwe.println("<style>\n" +
"        body {\n" +
"            user-select: none;\n" +
"            -webkit-user-select: none;\n" +
"            -moz-user-select: none;\n" +
"            -ms-user-select: none;\n" +
"        }\n" +
"    </style>"
            
          +"<script>\n" +
"        document.addEventListener('dragstart', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"\n" +
"        document.addEventListener('drop', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"\n" +
"        document.addEventListener('contextmenu', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"    </script>"  
            
            + "<script>\n" +
"  \n" +
"  window.addEventListener(`contextmenu`, (e) => {\n" +
"    e.preventDefault();\n" +
"});\n" +
"  \n" +
"  </script>"
             + ""
            + "\n<meta charset=\"UTF-8\"/>\n<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"/>\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />"
            + ""
            + "<script>\n" +
"            \n" +
"            document.addEventListener('keydown', event => {\n" +
"  console.log(`User pressed: ${event.key}`);\n" +
"  event.preventDefault();\n" +
"  return false;\n" +
"});\n" +
"            \n" +
"            </script>"
            
       +"<script>\n" +
"        document.addEventListener('keydown', function (event) {\n" +
"            // Disable specific keys or key combinations\n" +
"            event.preventDefault();\n" +
"        });\n" +
"    </script>");
    pwe.close();
    coode.clear();
   
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          
        WebView webviewt=new WebView ();
        webviewt.setContextMenuEnabled(false);
        webviewt.setMinSize(1800, 800);
        //webviewt.setMinSize(500, 300);
        //File tw2oo=new File (System.getProperty("user.home")+"\\Hehehe\\Roro.ks");
        String lkd=System.getProperty("user.home")+"\\Hehehe\\Roro.html";
        //Desktop dd=Desktop.getDesktop();
        //dd.open(tw2oo);
        //String wewe=lkd.replace(".ks", ".html");
        URI uris = Paths.get(lkd).toAbsolutePath().toUri();
        webviewt.getEngine().load(uris.toString());
        Alert alol = new Alert(Alert.AlertType.INFORMATION);
        alol.setTitle("Preview a recipe");
        alol.setGraphic(webviewt);
        alol.setResizable(false);
        DialogPane dialogPane = alol.getDialogPane();
        dialogPane.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
        alol.showAndWait();
        
//        File nm=new File (System.getProperty("user.home")+"\\Hehehe\\Roro.ks");
//        if (pathy.contains(".ks")) {
//          //  nm.delete();
//        }
//        else {
//            
//        }
           
    Thread.sleep(3000);
    tw2o.delete();
        
        
      }
         
    } 
        
        
        
    }
  
  
  
  
  @FXML
    void imageaction(MouseEvent event) throws IOException, InterruptedException {

         
        String wsa=link.getText();
        
        if (!wsa.contains(".ks")) {
            
        //Noti to choose one first
        Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
        ImageView imgview = new ImageView();
        imgview.setImage(img);
        Notifications noti = Notifications.create();
        noti.title("Error");
        noti.text("I can't find the recipe, please choose one first.");
        noti.graphic(imgview);
        noti.position(Pos.CENTER);
        noti.show();
            
        }
        
        else {
      
      String pathy = link.getText().replace("\\","\\\\").replace("Z:","X:").replace("X:","X:").replace("V:","X:").replace("W:","X:");
      File op = new File(pathy);
      
      if (!op.exists()) {
        Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
        ImageView imgview = new ImageView();
        imgview.setImage(img);
        Notifications noti = Notifications.create();
        noti.title("Error");
        noti.text("I can't find the recipe, maybe KADINIO has deleted or encrypted it.");
        noti.graphic(imgview);
        noti.position(Pos.CENTER);
        noti.show();
        
        
      } else {
        
          File on1=new File (System.getProperty("user.home")+"\\Hehehe");
          if (!on1.exists()) {
              on1.mkdir();
          }
          else {
              
          }
               
    coode.clear();
    InputStream inputinstream=new FileInputStream(pathy);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    String lo;
    while ((lo=bi.readLine())!=null) {
        
        coode.appendText("\n"+lo
       .replace("ﬦ","A")
       .replace("ﬧ","B")
       .replace("ﬨ","C")
       .replace("﬩","D")
       .replace("שׁ","E")    
       .replace("שׂ","F")        
       .replace("שּׁ","G")         
       .replace("שּׂ","H")         
       .replace("אַ","I")         
       .replace("אָ","J")         
       .replace("אּ","K")         
       .replace("בּ","L")         
       .replace("גּ","M")         
       .replace("דּ","N")         
       .replace("הּ","O")         
       .replace("וּ","P")         
       .replace("זּ","Q")         
       .replace("טּ","R")         
       .replace("יּ","S")         
       .replace("ךּ","T")         
       .replace("כּ","U")         
       .replace("לּ","V")
       .replace("מּ","W")         
       .replace("נּ","X")         
       .replace("סּ","Y")         
       .replace("ףּ","Z")         
       .replace("פּ","0")         
       .replace("צּ","1")         
       .replace("קּ","2")         
       .replace("רּ","3")         
       .replace("שּ","4")         
       .replace("תּ","5")         
       .replace("וֹ","6")         
       .replace("בֿ","7")         
       .replace("כֿ","8")
       .replace("פֿ","9")
       .replace("&NBSP;","")        
                
               
      ); 


    }
    bi.close();
    String gf=coode.getText();
    
    String html = gf;
    int width = 5000, height = 3000;
    BufferedImage image = GraphicsEnvironment.getLocalGraphicsEnvironment()
    .getDefaultScreenDevice().getDefaultConfiguration()
    .createCompatibleImage(width, height);
    Graphics graphics = image.createGraphics();
    JEditorPane jep = new JEditorPane("text/html", html);
    jep.setSize(width, height);
    jep.print(graphics);
    ImageIO.write(image, "png", new File(System.getProperty("user.home")+"\\Hehehe\\Recipe.png"));
    File  dds=new File (System.getProperty("user.home")+"\\Hehehe\\Recipe.png");
    Desktop nsdf=Desktop.getDesktop();
    nsdf.open(dds);
    coode.clear();
   
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         
           
    Thread.sleep(10000);
    dds.delete();
        
        
      }
        }
        
        
        
        
        
    }
  
  
  
  
  
  
  
  @FXML
  void seepilotaction(ActionEvent event) throws IOException {
      
      
   DirectoryViewer hhii=new DirectoryViewer ();
   hhii.start(new Stage());
   
  }
  
  
  
  
  
  /////////////////////////////////////////START/////////////////////////////////////////////
  
  
  
   private void generateFinalHtml(String bodyContent, String headerText, int fromPage, int toPage, String lotnumber, String exittimee) {
        
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm:ss a");
            String currentTime = formatter.format(LocalDateTime.now());
            
            

            StringBuilder html = new StringBuilder();
            html.append("<html><head><style>")
                .append("@media print {")
                .append("  body { margin: 0; }")
                .append("  .page { page-break-after: always; break-after: page; }")
                .append("}")
                .append("body { font-family: Arial, sans-serif; margin: 0; padding: 0; }")
                .append(".page { width: 210mm; height: 297mm; padding: 20mm; box-sizing: border-box; }")
                .append(".header { font-weight: bold; font-size: 16pt; margin-bottom: 20px; }")
                .append("</style></head><body>");

            for (int i = fromPage; i <= toPage; i++) {
                
    html.append("<html>")
    .append("<head>")
    .append("<style>")
    .append(".page { padding: 20px; font-family: Arial, sans-serif; }")
    .append(".header-box {")
        .append("border: 2px solid #444;")
        .append("padding: 15px;")
        .append("border-radius: 10px;")
        .append("background-color: #f9f9f9;")
        .append("margin-bottom: 20px;")
        .append("display: flex;")
        .append("flex-wrap: wrap;")
        .append("gap: 10px;")
    .append("}")
    .append(".info-item {")
        .append("background-color: #e0e0e0;")
        .append("padding: 10px 15px;")
        .append("border-radius: 8px;")
        .append("box-shadow: 1px 1px 5px rgba(0, 0, 0, 0.1);")
        .append("font-size: 14px;")
    .append("}")
    .append("</style>")
    .append("</head>")
    .append("<body>")

    .append("<div class='page'>")
        .append("<div class='header-box'>")
            //.append("<div class='info-item'><strong>Header:</strong> ").append(headerText).append("</div>")
            .append("<div class='info-item'><strong>Machine:</strong> ").append(i).append("</div>")
            .append("<div class='info-item'><strong>Entry Time:</strong> ").append(currentTime).append("</div>")
            .append("<div class='info-item'><strong>Exit Time:</strong> ").append(exittimee).append("</div>")
            .append("<div class='info-item'><strong>LOT Number:</strong> ").append(lotnumber).append("</div>")
        .append("</div>")

        .append(bodyContent)

    .append("</div>")

    .append("</body>")
    .append("</html>");

                
                
//                html.append("<div class='page'>")
//                    .append("<div class='header'>")
//                    .append(headerText).append(" | Machine: ").append(i)
//                    .append(" | ").append("Entry Time: "+currentTime)
//                    .append(" | ").append("Exit Time: "+exittimee)    
//                    .append(" | ").append("LOT Number: "+lotnumber)    
//                    .append("</div>")
//                    .append(bodyContent)
//                    .append("</div>");
            }

            html.append("</body></html>");

            File file = File.createTempFile("html_print_pages_", ".html");
            try (FileWriter writer = new FileWriter(file)) {
                writer.write(html.toString());
            }

            String chromePath = "C:\\Program Files\\Google\\Chrome\\Application\\chrome.exe"; // Change if needed
            new ProcessBuilder(chromePath, file.getAbsolutePath()).start();

        } catch (IOException e) {
            showAlert("Error", "Failed to generate or open the HTML file.");
            e.printStackTrace();
        }
    }
  
  
  private String readFile(File file) throws IOException {
      
      InputStream inputinstream=new FileInputStream(file);
      BufferedReader reader=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
      
        //BufferedReader reader = new BufferedReader(new FileReader(file));
        StringBuilder content = new StringBuilder();
        String line;
        while((line = reader.readLine()) != null){
        content.append(line.replace("ﬦ","A")
       .replace("ﬧ","B")
       .replace("ﬨ","C")
       .replace("﬩","D")
       .replace("שׁ","E")    
       .replace("שׂ","F")        
       .replace("שּׁ","G")         
       .replace("שּׂ","H")         
       .replace("אַ","I")         
       .replace("אָ","J")         
       .replace("אּ","K")         
       .replace("בּ","L")         
       .replace("גּ","M")         
       .replace("דּ","N")         
       .replace("הּ","O")         
       .replace("וּ","P")         
       .replace("זּ","Q")         
       .replace("טּ","R")         
       .replace("יּ","S")         
       .replace("ךּ","T")         
       .replace("כּ","U")         
       .replace("לּ","V")
       .replace("מּ","W")         
       .replace("נּ","X")         
       .replace("סּ","Y")         
       .replace("ףּ","Z")         
       .replace("פּ","0")         
       .replace("צּ","1")         
       .replace("קּ","2")         
       .replace("רּ","3")         
       .replace("שּ","4")         
       .replace("תּ","5")         
       .replace("וֹ","6")         
       .replace("בֿ","7")         
       .replace("כֿ","8")
       .replace("פֿ","9")
       .replace("&NBSP;","")).append("\n");
        }
        reader.close();
        return content.toString();
    }

    private void showAlert(String title, String message){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
  
  
  @FXML
    void editorprintaction(ActionEvent event) throws FileNotFoundException, IOException {
        
        
        
        
        //Alert 
        
        //Radio Button Selected Or Not
        
      
            File selectedHtmlFile;
        
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Select Kadysoft File");
            fileChooser.getExtensionFilters().add(
            new FileChooser.ExtensionFilter("KADYSOFT Files", "*.ks")
            );
            File file = fileChooser.showOpenDialog(null);
            if (file != null) {
                selectedHtmlFile = file;
                
                
        ////////////////////////////////////////////////////////////////
                
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.setTitle("Info & Range");
        TextField headerField = new TextField("Everything is powered by Kadysoft Ltd.");
        headerField.setDisable(true);
        //headerField.setPromptText("Enter header text (bold)");
        
        TextField exitt = new TextField("04:00:00 PM");
        exitt.setPromptText("Enter Exit Time: ");
        
        TextField fromField = new TextField();
        fromField.setPromptText("Machines From");
        TextField toField = new TextField();
        toField.setPromptText("Machines To");
        
        TextField lotnum = new TextField();
        lotnum.setPromptText("LOT Number");
        
        VBox vbox = new VBox(10,
            new Label("Enter header (bold text): "), headerField,
            new Label("Enter machines range (e.g., 1 - 10): "),
            new HBox(10, new Label("From:"), fromField, new Label("To:"), toField,
            new Label("LOT Number: "),lotnum),new Label("Enter Exit Time: "), exitt
        );
        vbox.setStyle("-fx-padding: 10;");
        dialog.getDialogPane().setContent(vbox);
        dialog.getDialogPane().getButtonTypes().addAll(ButtonType.OK, ButtonType.CANCEL);
        dialog.showAndWait().ifPresent(type -> {
            if (type == ButtonType.OK) {
                String headerText = headerField.getText().trim();
                String fromStr = fromField.getText().trim();
                String toStr = toField.getText().trim();
                String lotnumber = lotnum.getText().trim();
                String exittimee=exitt.getText().trim();
                if (headerText.isEmpty() || fromStr.isEmpty() || toStr.isEmpty()) {
                    showAlert("Error", "All fields are required.");
                    return;
                }

                try {
                    int from = Integer.parseInt(fromStr);
                    int to = Integer.parseInt(toStr);
                    if (from > to || from < 1) {
                        showAlert("Error", "Invalid page range.");
                        return;
                    }
                    String content = readFile(selectedHtmlFile);
                    
                    ///////////////////////////////////////////////////////////FGHFFGHF////////////////////////////////////////////////
                    
//                       //Time Query
//                       
//                       
//            DateTimeFormatter formatterr = DateTimeFormatter.ofPattern("hh"); //Hour
//            String currentTimee = formatterr.format(LocalDateTime.now());
//            ho=currentTimee;
//            System.out.println(ho);
//            
//            DateTimeFormatter formatterrr = DateTimeFormatter.ofPattern("mm"); //Minutes
//            String currentTimeee = formatterrr.format(LocalDateTime.now());
//            min=currentTimeee;
//            System.out.println(min);
//                 
//        String path = selectedHtmlFile.getAbsolutePath().toString();
//        String[] parts = path.split("\\\\");
//        String modo = parts[parts.length - 2];
//        String wasshh = parts[parts.length - 1];
//        String wassh = wasshh.replace(".ks","");
//        
//        System.out.println(modo);
//        System.out.println(wassh);
//        
//        String timo;
//
//       
//double totalTime = 0;
//boolean found1 = false;
//boolean found2 = false;
//boolean found3 = false;
//
//// Query for Shot 1
//String queryShot1 = "SELECT * FROM Timer WHERE Name LIKE ? AND Model LIKE ? AND Shot LIKE ?";
//pst = conn.prepareStatement(queryShot1);
//pst.setString(1, "%" + wassh + "%");
//pst.setString(2, "%" + modo + "%");
//pst.setString(3, "%1%");
//rs = pst.executeQuery();
//while (rs.next()) {
//    found1 = true;
//    found3 = true;
//    String proc = rs.getString("Time_In_Hour_Updated");
//    if (proc.equals("Hasnot_Updated_Yet")) {
//        proc = rs.getString("Time_In_Hour");
//    }
//    totalTime += Double.parseDouble(proc);
//}
//
//// Query for Shot 2
//String queryShot22 = "SELECT * FROM Timer WHERE Name LIKE ? AND Model LIKE ? AND Shot LIKE ?";
//pst = conn.prepareStatement(queryShot22);
//pst.setString(1, "%" + wassh + "%");
//pst.setString(2, "%" + modo + "%");
//pst.setString(3, "%2%");
//rs = pst.executeQuery();
//while (rs.next()) {
//    found2 = true;
//    found3 = true;
//    String proc = rs.getString("Time_In_Hour_Updated");
//    if (proc.equals("Hasnot_Updated_Yet")) {
//        proc = rs.getString("Time_In_Hour");
//    }
//    totalTime += Double.parseDouble(proc);
//}
//
//if (found1 && found2) {
//    System.out.println("Shot 1 and 2 found. Total time: " + totalTime);
//} else if (found1) {
//    System.out.println("Only Shot 1 found. Time: " + totalTime);
//} else if (found2) {
//    System.out.println("Only Shot 2 found. Time: " + totalTime);
//} else {
//    System.out.println("No shots found.");
//}
//
//timo = String.valueOf(totalTime); // Store final time as string
//
//double d1=Double.parseDouble(timo);
//double d2=Double.parseDouble(ho);
//double d3=d1+d2;
//double d4=Math.ceil(d3);
//int d5=(int) d4;
//String exttime=Integer.toString(d5);
//exittime=exttime;
//
//    if (found3==false) {
//       
//double totalTimee = 0;
//boolean foundShot1 = false;
//boolean foundShot2 = false;
//boolean foundShot3 = false;
//
//// Array of shot numbers
//int[] shots = {1, 2, 3};
//
//for (int shot : shots) {
//    String query = "SELECT Time_In_Hour_Updated, Time_In_Hour FROM Timer_Three_Shots WHERE Name LIKE ? AND Model LIKE ? AND Shot LIKE ?";
//    pst = conn.prepareStatement(query);
//    pst.setString(1, "%" + wassh + "%");
//    pst.setString(2, "%" + modo + "%");
//    pst.setString(3, "%" + shot + "%");
//    rs = pst.executeQuery();
//
//    while (rs.next()) {
//        String time = rs.getString("Time_In_Hour_Updated");
//        if (time.equals("Hasnot_Updated_Yet")) {
//            time = rs.getString("Time_In_Hour");
//        }
//        totalTimee += Double.parseDouble(time);
//
//        // Mark which shot was found
//        if (shot == 1) foundShot1 = true;
//        if (shot == 2) foundShot2 = true;
//        if (shot == 3) foundShot3 = true;
//    }
//}
//
//// Display result
//if (foundShot1 || foundShot2 || foundShot3) {
//    System.out.println("Total Time from existing shots: " + totalTimee);
//    if (foundShot1) System.out.println("Shot 1 included.");
//    if (foundShot2) System.out.println("Shot 2 included.");
//    if (foundShot3) System.out.println("Shot 3 included.");
//} else {
//    System.out.println("No shots found.");
//}
//
//timo = String.valueOf(totalTimee); // Final time value as String
//
//double d11=Double.parseDouble(timo);
//double d22=Double.parseDouble(ho);
//double d33=d11+d22;
//double d44=Math.ceil(d33);
//int d55=(int) d44;
//String exttimee=Integer.toString(d55);
//exittime=exttimee;
//System.out.println(exittime);    
//    
//    } 
//
//    
//String exittimee=exittime+":"+min+"";


                    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                    
                    generateFinalHtml(content, headerText, from, to, lotnumber, exittimee);
                } catch (NumberFormatException | IOException ex) {
                    showAlert("Error", "Invalid number input or file error.");
                    ex.printStackTrace();
                }
            }
        });
                
        ////////////////////////////////////////////////////////////////
            }
        
        
        
        
        
        
//        
//        
//    FileChooser fcho = new FileChooser();
//    String go = NewDir.file_dir;
//    fcho.setInitialDirectory(new File(go));
//    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
//    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
//    fcho.setTitle("Kady Choose");
//    File f = fcho.showOpenDialog((Window)null);
//    String pathy = f.getAbsolutePath().toString();
//    InputStream inputinstream=new FileInputStream(pathy);
//    BufferedReader buf=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
//    
//    OutputStream instreamm=new FileOutputStream("D:\\Editor\\index.html");
//    PrintWriter pw = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
//    
//    
//    pw.append("<html lang=\"ar\">\n<head><title>Kadysoft Ltd - Ahmed Elkady.</title>\n<meta charset=\"UTF-8\"/>\n<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"/>\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />"
//            + ""
//            
//            
//                 
//            + "<style>\n" +
//"        body {\n" +
//"            user-select: none;\n" +
//"            -webkit-user-select: none;\n" +
//"            -moz-user-select: none;\n" +
//"            -ms-user-select: none;\n" +
//"        }\n" +
//"    </style>"
//            
//          +"<script>\n" +
//"        document.addEventListener('dragstart', function(event) {\n" +
//"            event.preventDefault();\n" +
//"        });\n" +
//"\n" +
//"        document.addEventListener('drop', function(event) {\n" +
//"            event.preventDefault();\n" +
//"        });\n" +
//"\n" +
//"        document.addEventListener('contextmenu', function(event) {\n" +
//"            event.preventDefault();\n" +
//"        });\n" +
//"    </script>"  
//            
//            + "<script>\n" +
//"  \n" +
//"  window.addEventListener(`contextmenu`, (e) => {\n" +
//"    e.preventDefault();\n" +
//"});\n" +
//"  \n" +
//"  </script>"
//             + ""
//            + "\n<meta charset=\"UTF-8\"/>\n<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"/>\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />"
//            + ""
//            + "<script>\n" +
//"            \n" +
//"            document.addEventListener('keydown', event => {\n" +
//"  console.log(`User pressed: ${event.key}`);\n" +
//"  event.preventDefault();\n" +
//"  return false;\n" +
//"});\n" +
//"            \n" +
//"            </script>"
//            
//       +"<script>\n" +
//"        document.addEventListener('keydown', function (event) {\n" +
//"            // Disable specific keys or key combinations\n" +
//"            event.preventDefault();\n" +
//"        });\n" +
//"    </script>"     
//            
//            
//            
//            
//            + "<script>\n" +
//"            \n" +
//"            document.addEventListener('keydown', event => {\n" +
//"  console.log(`User pressed: ${event.key}`);\n" +
//"  event.preventDefault();\n" +
//"  return false;\n" +
//"});\n" +
//"            \n" +
//"            </script>"
//            + ""
//            + "\n\t\t<title></title>\n\t\t<link rel=\"stylesheet\" href=\"./app.css\" />\n\t\t<link rel=\"stylesheet\" href=\"./build/jodit.min.css\" />\n\t\t<script src=\"./build/jodit.js\"></script>\n\t</head>\n\t<body>\n\t\t<style>\n\t\t\t#box {\n\t\t\t\tpadding: 100px;\n\t\t\t\tmargin: 20px;\n\t\t\t\tposition: relative;\n\t\t\t\theight: 500px;\n\t\t\t}\n\n\t\t\t@media (max-width: 480px) {\n\t\t\t\t#box {\n\t\t\t\t\tpadding: 0;\n\t\t\t\t}\n\t\t\t}\n\t\t</style>\n\t\t<div id=\"box\">\n\t\t\t<textarea id=\"editor\">\n\n\n\n\n");
//    String line;
//    while ((line = buf.readLine()) != null)  
//    pw.append(line 
//            
//            
//              .replace("ﬦ","A")
//       .replace("ﬧ","B")
//       .replace("ﬨ","C")
//       .replace("﬩","D")
//       .replace("שׁ","E")    
//       .replace("שׂ","F")        
//       .replace("שּׁ","G")         
//       .replace("שּׂ","H")         
//       .replace("אַ","I")         
//       .replace("אָ","J")         
//       .replace("אּ","K")         
//       .replace("בּ","L")         
//       .replace("גּ","M")         
//       .replace("דּ","N")         
//       .replace("הּ","O")         
//       .replace("וּ","P")         
//       .replace("זּ","Q")         
//       .replace("טּ","R")         
//       .replace("יּ","S")         
//       .replace("ךּ","T")         
//       .replace("כּ","U")         
//       .replace("לּ","V")
//       .replace("מּ","W")         
//       .replace("נּ","X")         
//       .replace("סּ","Y")         
//       .replace("ףּ","Z")         
//       .replace("פּ","0")         
//       .replace("צּ","1")         
//       .replace("קּ","2")         
//       .replace("רּ","3")         
//       .replace("שּ","4")         
//       .replace("תּ","5")         
//       .replace("וֹ","6")         
//       .replace("בֿ","7")         
//       .replace("כֿ","8")
//       .replace("פֿ","9")
//       .replace("&NBSP;","")
//            
//            
//            
//            + "\n");   
//    pw.append("\n\n\n</textarea>\n\t\t</div>\n\t\t<script>\n\t\t\tconst editor = Jodit.make('#editor' ,{\n\t\t\t\tuploader: {\n\t\t\t\t\t\n\t\t\t\t},\n\t\t\t\tfilebrowser: {\n\t\t\t\t\tajax: {\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t});\n\t\t</script>\n\t</body>\n</html>"); 
//    pw.close();
//    buf.close();
//    Desktop desk = Desktop.getDesktop();
//    desk.open(new File("D:\\Editor\\index.html"));   
//    
//    
    
    
    
    
    
    
    
    
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    void openrecipesfolderaction(ActionEvent event) throws IOException {

      Desktop desk=Desktop.getDesktop();
      desk.open(new File (NewDir.file_dir));
        
    }
    
    
    
  
//  @FXML
//  void contentaction(KeyEvent event) {
//    if (this.date.isSelected()) {
//      this.table.getColumns().clear();
//      ObservableList<ObservableList> data = FXCollections.observableArrayList();
//      try {
//        String sql = "select * from Creation where Date=?";
//        this.pst = this.conn.prepareStatement(sql);
//        this.pst.setString(1, this.content.getText());
//        this.rs = this.pst.executeQuery();
//        for (int i = 0; i < this.rs.getMetaData().getColumnCount(); i++) {
//          final int j = i;
//          TableColumn<Object, Object> col = new TableColumn<>(this.rs.getMetaData().getColumnName(i + 1));
//          col.setCellValueFactory((Callback)new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
//                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
//                  return new SimpleStringProperty(((ObservableList<String>)param.getValue()).get(j).toString());
//                }
//              });
//          this.table.getColumns().addAll(new Object[] { col });
//        } 
//        while (this.rs.next()) {
//          ObservableList<String> row = FXCollections.observableArrayList();
//          for (int j = 1; j <= this.rs.getMetaData().getColumnCount(); j++)
//            row.add(this.rs.getString(j)); 
//          data.add(row);
//        } 
//        this.table.setItems(data);
//      } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, e);
//      } finally {
//        try {
//          this.rs.close();
//          this.pst.close();
//        } catch (Exception exception) {}
//      } 
//    } else if (this.name.isSelected()) {
//      this.table.getColumns().clear();
//      ObservableList<ObservableList> data = FXCollections.observableArrayList();
//      try {
//        String sql = "select * from Creation where Name=?";
//        this.pst = this.conn.prepareStatement(sql);
//        this.pst.setString(1, this.content.getText());
//        this.rs = this.pst.executeQuery();
//        for (int i = 0; i < this.rs.getMetaData().getColumnCount(); i++) {
//          final int j = i;
//          TableColumn<Object, Object> col = new TableColumn<>(this.rs.getMetaData().getColumnName(i + 1));
//          col.setCellValueFactory((Callback)new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
//                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
//                  return new SimpleStringProperty(((ObservableList<String>)param.getValue()).get(j).toString());
//                }
//              });
//          this.table.getColumns().addAll(new Object[] { col });
//        } 
//        while (this.rs.next()) {
//          ObservableList<String> row = FXCollections.observableArrayList();
//          for (int j = 1; j <= this.rs.getMetaData().getColumnCount(); j++)
//            row.add(this.rs.getString(j)); 
//          data.add(row);
//        } 
//        this.table.setItems(data);
//      } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, e);
//      } finally {
//        try {
//          this.rs.close();
//          this.pst.close();
//        } catch (Exception exception) {}
//      } 
//    } else if (this.model.isSelected()) {
//      this.table.getColumns().clear();
//      ObservableList<ObservableList> data = FXCollections.observableArrayList();
//      try {
//        String sql = "select * from Creation where Model=?";
//        this.pst = this.conn.prepareStatement(sql);
//        this.pst.setString(1, this.content.getText());
//        this.rs = this.pst.executeQuery();
//        for (int i = 0; i < this.rs.getMetaData().getColumnCount(); i++) {
//          final int j = i;
//          TableColumn<Object, Object> col = new TableColumn<>(this.rs.getMetaData().getColumnName(i + 1));
//          col.setCellValueFactory((Callback)new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
//                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
//                  return new SimpleStringProperty(((ObservableList<String>)param.getValue()).get(j).toString());
//                }
//              });
//          this.table.getColumns().addAll(new Object[] { col });
//        } 
//        while (this.rs.next()) {
//          ObservableList<String> row = FXCollections.observableArrayList();
//          for (int j = 1; j <= this.rs.getMetaData().getColumnCount(); j++)
//            row.add(this.rs.getString(j)); 
//          data.add(row);
//        } 
//        this.table.setItems(data);
//      } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, e);
//      } finally {
//        try {
//          this.rs.close();
//          this.pst.close();
//        } catch (Exception exception) {}
//      } 
//    } else if (this.stage.isSelected()) {
//      this.table.getColumns().clear();
//      ObservableList<ObservableList> data = FXCollections.observableArrayList();
//      try {
//        String sql = "select * from Creation where Stage=?";
//        this.pst = this.conn.prepareStatement(sql);
//        this.pst.setString(1, this.content.getText());
//        this.rs = this.pst.executeQuery();
//        for (int i = 0; i < this.rs.getMetaData().getColumnCount(); i++) {
//          final int j = i;
//          TableColumn<Object, Object> col = new TableColumn<>(this.rs.getMetaData().getColumnName(i + 1));
//          col.setCellValueFactory((Callback)new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
//                public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
//                  return new SimpleStringProperty(((ObservableList<String>)param.getValue()).get(j).toString());
//                }
//              });
//          this.table.getColumns().addAll(new Object[] { col });
//        } 
//        while (this.rs.next()) {
//          ObservableList<String> row = FXCollections.observableArrayList();
//          for (int j = 1; j<=rs.getMetaData().getColumnCount(); j++) 
//            row.add(this.rs.getString(j)); 
//          data.add(row);
//        } 
//        this.table.setItems(data);
//      } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, e);
//      } finally {
//        try {
//          this.rs.close();
//          this.pst.close();
//        } catch (Exception exception) {}
//      } 
//    } else {
//      Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
//      ImageView imgview = new ImageView();
//      imgview.setImage(img);
//      Notifications noti = Notifications.create();
//      noti.title("Error");
//      noti.text("Please Choose One Filter Type.");
//      noti.graphic(imgview);
//      noti.position(Pos.CENTER);
//      noti.show();
//    } 
//  }
//  
  @FXML
  void getallaction(ActionEvent event) {
    this.table.getColumns().clear();
    ObservableList<ObservableList> data = FXCollections.observableArrayList();
    try {
      String sql = "select * from Creation";
      this.pst = this.conn.prepareStatement(sql);
      this.rs = this.pst.executeQuery();
      for (int i = 0; i < this.rs.getMetaData().getColumnCount(); i++) {
        final int j = i;
        TableColumn<Object, Object> col = new TableColumn<>(this.rs.getMetaData().getColumnName(i + 1));
        col.setCellValueFactory((Callback)new Callback<TableColumn.CellDataFeatures<ObservableList, String>, ObservableValue<String>>() {
              public ObservableValue<String> call(TableColumn.CellDataFeatures<ObservableList, String> param) {
                return new SimpleStringProperty(((ObservableList<String>)param.getValue()).get(j).toString());
              }
            });
        this.table.getColumns().addAll(new Object[] { col });
      } 
      while (this.rs.next()) {
        ObservableList<String> row = FXCollections.observableArrayList();
        for (int j = 1; j <= this.rs.getMetaData().getColumnCount(); j++)
          row.add(this.rs.getString(j)); 
        data.add(row);
      } 
      this.table.setItems(data);
    } catch (Exception e) {
      JOptionPane.showMessageDialog(null, e);
    } finally {
      try {
        this.rs.close();
        this.pst.close();
      } catch (Exception exception) {}
    }
    
      TableFilter filter = new TableFilter(table);
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  @FXML
  void linkaction(ActionEvent event) throws IOException, InterruptedException {
      
      
    String linkval = this.link.getText();
    if (linkval.equals("T & C Garments")) {
      Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
      ImageView imgview = new ImageView();
      imgview.setImage(img);
      Notifications noti = Notifications.create();
      noti.title("Error");
      noti.text("Hyperlink doesn't contain path to any Recipe.");
      noti.graphic(imgview);
      noti.position(Pos.CENTER);
      noti.show();
      
      
    } else if (!linkval.contains("Recipe_System\\Recipes")) {
      Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
      ImageView imgview = new ImageView();
      imgview.setImage(img);
      Notifications noti = Notifications.create();
      noti.title("Error");
      noti.text("Hyperlink doesn't contain path to any Recipe.");
      noti.graphic(imgview);
      noti.position(Pos.CENTER);
      noti.show();
      
      
    } else {
      //String path = this.link.getText();
      String pathy = link.getText().replace("\\","\\\\").replace("Z:","X:").replace("X:","X:").replace("V:","X:").replace("W:","X:");
      File op = new File(pathy);
      
      if (!op.exists()) {
        Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
        ImageView imgview = new ImageView();
        imgview.setImage(img);
        Notifications noti = Notifications.create();
        noti.title("Error");
        noti.text("I can't find the recipe, maybe the admin has deleted it.");
        noti.graphic(imgview);
        noti.position(Pos.CENTER);
        noti.show();
        
        
      } else {
          
          
          
        //Desktop desk = Desktop.getDesktop();
        //desk.open(new File(pathy));
        //////////////////////////////////////Web View Alert ///////////////////////////////
        WebView webview=new WebView ();
        webview.setMinSize(1800, 800);
        //ScrollPane sp=new ScrollPane();
        //sp.setMinSize(1200, 600);
        //sp.setContent(webview);
        //webview.setContextMenuEnabled(true);
        //webview.setDisable(true);
        
        String newpathyy=pathy.replace(".ks", ".html");
        File hf=new File(newpathyy);
        hf.createNewFile();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
    coode.clear();
    InputStream inputinstream=new FileInputStream(pathy);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    String lo;
    while ((lo=bi.readLine())!=null) {
        
        coode.appendText("\n"+lo
       .replace("ﬦ","A")
       .replace("ﬧ","B")
       .replace("ﬨ","C")
       .replace("﬩","D")
       .replace("שׁ","E")    
       .replace("שׂ","F")        
       .replace("שּׁ","G")         
       .replace("שּׂ","H")         
       .replace("אַ","I")         
       .replace("אָ","J")         
       .replace("אּ","K")         
       .replace("בּ","L")         
       .replace("גּ","M")         
       .replace("דּ","N")         
       .replace("הּ","O")         
       .replace("וּ","P")         
       .replace("זּ","Q")         
       .replace("טּ","R")         
       .replace("יּ","S")         
       .replace("ךּ","T")         
       .replace("כּ","U")         
       .replace("לּ","V")
       .replace("מּ","W")         
       .replace("נּ","X")         
       .replace("סּ","Y")         
       .replace("ףּ","Z")         
       .replace("פּ","0")         
       .replace("צּ","1")         
       .replace("קּ","2")         
       .replace("רּ","3")         
       .replace("שּ","4")         
       .replace("תּ","5")         
       .replace("וֹ","6")         
       .replace("בֿ","7")         
       .replace("כֿ","8")
       .replace("פֿ","9")
       .replace("&NBSP;","")        
                
               
      ); 


    }
    bi.close();
    String gf=coode.getText();
    OutputStream instreamm=new FileOutputStream(newpathyy);
    PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    pwe.println(gf);
    pwe.println("<script>\n" +
"  \n" +
"  window.addEventListener(`contextmenu`, (e) => {\n" +
"    e.preventDefault();\n" +
"});\n" +
"  \n" +
"  </script>");
    
    pwe.println("<script>\n" +
"            \n" +
"            document.addEventListener('keydown', event => {\n" +
"  console.log(`User pressed: ${event.key}`);\n" +
"  event.preventDefault();\n" +
"  return false;\n" +
"});\n" +
"            \n" +
"            </script>");
    
    pwe.close();
    coode.clear();
   
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        URI uri = Paths.get(newpathyy).toAbsolutePath().toUri();
        webview.getEngine().load(uri.toString());
        Alert alo = new Alert(Alert.AlertType.INFORMATION);
        alo.setTitle("Preview a recipe");
        alo.setGraphic(webview);
        alo.setResizable(false);
        DialogPane dialogPane = alo.getDialogPane();
        dialogPane.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
        alo.showAndWait();
        File nm=new File (newpathyy);
        if (pathy.contains(".ks")) {
            nm.delete();
        }
        else {
            
        }
        
        
    Thread.sleep(3000);
    
    hf.delete();
        
        
        //nm.delete();
        ////////////////////////////////////////////////////////////////////////////////////
        
      }
      
      
    } 
  }
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  @FXML
  void tableaction(MouseEvent event) {
    TablePosition pos = (TablePosition) this.table.getSelectionModel().getSelectedCells().get(0);
    int idd = ((Integer)this.table.getSelectionModel().getSelectedIndices().get(0)).intValue();
    int iddd = idd + 1;
    String idddd = Integer.toString(iddd);
    String h = pos.getTableColumn().getCellData(pos.getRow()).toString();
    String colname = pos.getTableColumn().getText();
    this.link.setText(h);
    
   // link.fire();
    
  }
  
public void initialize(URL url, ResourceBundle rb) {
    
    
    
//    
//     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
//       
//        
//      try {
//          
//        Calendar calendar = Calendar.getInstance();
//          
//        BufferedReader bufred=new BufferedReader (new FileReader (NewDir.file_dirrr+"\\ADS\\Azan_Time.kady"));
//        int s_h=Integer.parseInt(bufred.readLine().replace("Start_Hour=",""));
//        int s_m=Integer.parseInt(bufred.readLine().replace("Start_Minute=",""));
//        int s_s=Integer.parseInt(bufred.readLine().replace("Start_Second=",""));
//        int typa=Integer.parseInt(bufred.readLine().replace("Start_AM_PM=",""));
//        
//        int e_h=Integer.parseInt(bufred.readLine().replace("End_Hour=",""));
//        int e_m=Integer.parseInt(bufred.readLine().replace("End_Minute=",""));
//        int typaa=Integer.parseInt(bufred.readLine().replace("End_AM_PM=",""));
//        
//        calendar.set(Calendar.HOUR, s_h);
//        System.out.println(s_h);
//        calendar.set(Calendar.MINUTE,s_m);
//        System.out.println(s_m);
//        calendar.set(Calendar.SECOND,s_s);
//        System.out.println(s_s);
//        if (typa==0) {
//            calendar.set(Calendar.AM_PM, Calendar.AM);   //AM=0, PM=1.
//            System.out.println(typa+" AM");
//        }
//        else {
//            calendar.set(Calendar.AM_PM, Calendar.PM);   //AM=0, PM=1.
//            System.out.println(typa+" PM");
//        }
//        
//        Long currentTime = new Date().getTime();
//        
//        if (calendar.getTime().getTime() < currentTime) {
//            calendar.add(Calendar.DATE, 1);
//        }
//
//        long startScheduler = calendar.getTime().getTime() - currentTime;
//
//        calendar.set(Calendar.HOUR, e_h);
//        System.out.println(e_h);
//        calendar.set(Calendar.MINUTE,e_m);
//        System.out.println(e_m);
//        
//        if (typaa==0) {
//            calendar.set(Calendar.AM_PM, Calendar.AM);   //AM=0, PM=1.
//            System.out.println(typaa+" AM");
//        }
//        else {
//            calendar.set(Calendar.AM_PM, Calendar.PM);   //AM=0, PM=1.
//            System.out.println(typaa+" PM");
//       }
//       
//        long stopScheduler = calendar.getTime().getTime() - currentTime;
//        
//        bufred.close();
//
//        Runnable task = new Runnable() {
//
//            @Override
//            public void run() {
//
//                try {
//                    BufferedReader bnf=new BufferedReader (new FileReader (NewDir.file_dirrr+"\\ADS\\Azan_Noti.kady"));
//                    String cont=bnf.readLine();
//                    bnf.close();
//                    
//
//                    
//                } catch (FileNotFoundException ex) {
//                    Logger.getLogger(ViewerController_1.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IOException ex) {
//                    Logger.getLogger(ViewerController_1.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                
//               
//                try {
//                     javax.sound.sampled.Clip clip;
//                     clip = AudioSystem.getClip();
//                     clip.open(AudioSystem.getAudioInputStream(new File(NewDir.file_dirrr+"\\ADS\\Azan_File.wav")));
//                     clip.start();
//                } catch (LineUnavailableException ex) {
//                    Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (UnsupportedAudioFileException ex) {
//                    Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (IOException ex) {
//                    Logger.getLogger(Task.class.getName()).log(Level.SEVERE, null, ex);
//                }
//       
//                
//            }
//        };
//
//        final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
//        scheduler.scheduleAtFixedRate(task, startScheduler, stopScheduler, MILLISECONDS);
//        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 
//        
//
//} catch (FileNotFoundException ex) {
//          Logger.getLogger(ViewerController_1.class.getName()).log(Level.SEVERE, null, ex);
//      } catch (IOException ex) {
//          Logger.getLogger(ViewerController_1.class.getName()).log(Level.SEVERE, null, ex);
//      }
//
//    
//    
      
      
      
    
    
    
    
    
    
    
    
    
    
    

editorprint.setGraphic(new ImageView (new Image(getClass().getResourceAsStream("printicon.png"))));
      
rectangle.setArcWidth(30.0);   // Corner radius
rectangle.setArcHeight(30.0);
ImagePattern pattern = new ImagePattern(
new Image("file:"+NewDir.file_dirrr+"\\ADS\\adsimage.png", 1200, 120, false, false) // Resizing
);
rectangle.setFill(pattern);
rectangle.setEffect(new DropShadow(20, Color.BLACK));  // Shadow


      /////////////////////////////////////////////////////////////////////////////////////////////////////////
      try {
//          Path imageFile = Paths.get(NewDir.file_dirrr+"\\ADS\\adsimage.png");
//          adsimage.setImage(new Image(imageFile.toUri().toURL().toExternalForm()));
          BufferedReader buff=new BufferedReader (new FileReader (NewDir.file_dirrr+"\\ADS\\adslabel.txt"));
          adslabel.setText(buff.readLine());
          buff.close();
          
          BufferedReader buff1=new BufferedReader (new FileReader (NewDir.file_dirrr+"\\ADS\\backgroundcolor.txt"));
          BufferedReader buff2=new BufferedReader (new FileReader (NewDir.file_dirrr+"\\ADS\\fontcolor.txt"));
          BufferedReader buff3=new BufferedReader (new FileReader (NewDir.file_dirrr+"\\ADS\\fontfamily.txt"));
          BufferedReader buff4=new BufferedReader (new FileReader (NewDir.file_dirrr+"\\ADS\\fontsize.txt"));
          
          adslabel.setStyle("-fx-background-color:"+buff1.readLine()+";-fx-text-fill:"+buff2.readLine()+";-fx-font-family:"+buff3.readLine()+";-fx-font-weight:bold;-fx-background-radius:3em;-fx-font-size:"+buff4.readLine()+";");
          
          buff1.close();
          buff2.close();
          buff3.close();
          buff4.close();
          
          coode.clear();
          
//          BufferedReader buff5=new BufferedReader (new FileReader (NewDir.file_dirrr+"\\ADS\\marquecoode.txt"));
//          String lineee;
//          while ((lineee=buff5.readLine())!=null) {
//              coode.appendText(lineee+"\n");
//          }
//          buff5.close();
          
          
//          InputStream instream=new FileInputStream(NewDir.file_dirrr+"\\ADS\\marquecoode.txt");
//          BufferedReader buff55 = new BufferedReader(new InputStreamReader (instream,"UTF-8"));
//          String lineee;
//          while ((lineee=buff55.readLine())!=null) {
//              coode.appendText(lineee+"\n");
//          }
//          buff55.close();
          
          
          
      } catch (MalformedURLException ex) {
          Logger.getLogger(ViewerController_1.class.getName()).log(Level.SEVERE, null, ex);
      } catch (FileNotFoundException ex) {
          Logger.getLogger(ViewerController_1.class.getName()).log(Level.SEVERE, null, ex);
      } catch (IOException ex) {
          Logger.getLogger(ViewerController_1.class.getName()).log(Level.SEVERE, null, ex);
      }
      //////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      
     // adsimage.setImage(new Image (NewDir.file_dirrr+"\\ADS\\adsimage.png"));
    //adsimage.setImage(new Image (getClass().getResourceAsStream("adsimage.png")));
    
    //System.out.println(NewDir.file_dirrr+"\\ADS\\adsimage.png");
      
    Toolkit tool = Toolkit.getDefaultToolkit();
    tool.setLockingKeyState(20, true);
    this.tg = new ToggleGroup();
    this.date.setToggleGroup(this.tg);
    this.stage.setToggleGroup(this.tg);
    this.name.setToggleGroup(this.tg);
    this.model.setToggleGroup(this.tg);
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String timeString = sdf.format(d);
    String value1 = dateString;
   // this.content.setText(timeString);
    this.conn = db.java_db();
    
    
    
//        final HourService hservice = new HourService();
//        hservice.setCalendarInstance(Calendar.getInstance());
//        hservice.setOnSucceeded(new EventHandler<WorkerStateEvent>() { // Anonymous
//
//            @Override
//            public void handle(WorkerStateEvent t) {   
//                hservice.restart();
//            }
//        });
//        hservice.start();
    
        
   getallbtn.fire();
   marque.getEngine().setJavaScriptEnabled(true);
   
   URI uri = Paths.get(NewDir.file_dirrr+"\\ADS\\marquecoode.html").toAbsolutePath().toUri();
   marque.getEngine().load(uri.toString());
   
//   marque.getEngine().loadContent(coode.getText());
    



  table.setRowFactory(tv -> {
    TableRow<ObservableList<String>> row = new TableRow<>();
    row.setOnMouseClicked(event -> {
        if (!row.isEmpty() && event.getClickCount() == 2) {
            ObservableList<String> rowData = row.getItem();
            if (rowData.size() > 5) {  // column 6 is index 5
                String filePath = rowData.get(5);
                try {
                   
                    
                    
                           
        String wsa=filePath;
        
        if (!wsa.contains(".ks")) {
            
        //Noti to choose one first
        Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
        ImageView imgview = new ImageView();
        imgview.setImage(img);
        Notifications noti = Notifications.create();
        noti.title("Error");
        noti.text("I can't find the recipe, please choose one first.");
        noti.graphic(imgview);
        noti.position(Pos.CENTER);
        noti.show();
            
        }
        
        else {
      String pathy = filePath.replace("\\","\\\\").replace("Z:","X:").replace("X:","X:").replace("V:","X:").replace("W:","X:");
      File op = new File(pathy);
      
      if (!op.exists()) {
        Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
        ImageView imgview = new ImageView();
        imgview.setImage(img);
        Notifications noti = Notifications.create();
        noti.title("Error");
        noti.text("I can't find the recipe, maybe KADINIO has deleted or encrypted it.");
        noti.graphic(imgview);
        noti.position(Pos.CENTER);
        noti.show();
        
        
      } else {
        
          File on1=new File (System.getProperty("user.home")+"\\Hehehe");
          if (!on1.exists()) {
              on1.mkdir();
          }
          else {
              
          }
          File tw2o=new File (System.getProperty("user.home")+"\\Hehehe\\Roro.html");
          if (!tw2o.exists()) {
              tw2o.createNewFile();
          }
          else {
              
          }
          
          
          
               
    coode.clear();
    InputStream inputinstream=new FileInputStream(pathy);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    String lo;
    while ((lo=bi.readLine())!=null) {
        
        coode.appendText("\n"+lo
       .replace("ﬦ","A")
       .replace("ﬧ","B")
       .replace("ﬨ","C")
       .replace("﬩","D")
       .replace("שׁ","E")    
       .replace("שׂ","F")        
       .replace("שּׁ","G")         
       .replace("שּׂ","H")         
       .replace("אַ","I")         
       .replace("אָ","J")         
       .replace("אּ","K")         
       .replace("בּ","L")         
       .replace("גּ","M")         
       .replace("דּ","N")         
       .replace("הּ","O")         
       .replace("וּ","P")         
       .replace("זּ","Q")         
       .replace("טּ","R")         
       .replace("יּ","S")         
       .replace("ךּ","T")         
       .replace("כּ","U")         
       .replace("לּ","V")
       .replace("מּ","W")         
       .replace("נּ","X")         
       .replace("סּ","Y")         
       .replace("ףּ","Z")         
       .replace("פּ","0")         
       .replace("צּ","1")         
       .replace("קּ","2")         
       .replace("רּ","3")         
       .replace("שּ","4")         
       .replace("תּ","5")         
       .replace("וֹ","6")         
       .replace("בֿ","7")         
       .replace("כֿ","8")
       .replace("פֿ","9")
       .replace("&NBSP;","")        
                
               
      ); 


    }
    bi.close();
    String gf=coode.getText();
    OutputStream instreamm=new FileOutputStream(tw2o);
    PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    pwe.println(gf);
    pwe.println("<style>\n" +
"        body {\n" +
"            user-select: none;\n" +
"            -webkit-user-select: none;\n" +
"            -moz-user-select: none;\n" +
"            -ms-user-select: none;\n" +
"        }\n" +
"    </style>"
            
          +"<script>\n" +
"        document.addEventListener('dragstart', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"\n" +
"        document.addEventListener('drop', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"\n" +
"        document.addEventListener('contextmenu', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"    </script>"  
            
            + "<script>\n" +
"  \n" +
"  window.addEventListener(`contextmenu`, (e) => {\n" +
"    e.preventDefault();\n" +
"});\n" +
"  \n" +
"  </script>"
             + ""
            + "\n<meta charset=\"UTF-8\"/>\n<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"/>\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />"
            + ""
            + "<script>\n" +
"            \n" +
"            document.addEventListener('keydown', event => {\n" +
"  console.log(`User pressed: ${event.key}`);\n" +
"  event.preventDefault();\n" +
"  return false;\n" +
"});\n" +
"            \n" +
"            </script>"
            
       +"<script>\n" +
"        document.addEventListener('keydown', function (event) {\n" +
"            // Disable specific keys or key combinations\n" +
"            event.preventDefault();\n" +
"        });\n" +
"    </script>");
    pwe.close();
    coode.clear();
   
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          
        WebView webviewt=new WebView ();
        webviewt.setContextMenuEnabled(false);
        webviewt.setMinSize(1800, 800);
        //webviewt.setMinSize(500, 300);
        //File tw2oo=new File (System.getProperty("user.home")+"\\Hehehe\\Roro.ks");
        String lkd=System.getProperty("user.home")+"\\Hehehe\\Roro.html";
        //Desktop dd=Desktop.getDesktop();
        //dd.open(tw2oo);
        //String wewe=lkd.replace(".ks", ".html");
        URI uris = Paths.get(lkd).toAbsolutePath().toUri();
        webviewt.getEngine().load(uris.toString());
        Alert alol = new Alert(Alert.AlertType.INFORMATION);
        alol.setTitle("Preview a recipe");
        alol.setGraphic(webviewt);
        alol.setResizable(false);
        DialogPane dialogPane = alol.getDialogPane();
        dialogPane.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
        alol.showAndWait();
        
//        File nm=new File (System.getProperty("user.home")+"\\Hehehe\\Roro.ks");
//        if (pathy.contains(".ks")) {
//          //  nm.delete();
//        }
//        else {
//            
//        }
           
    Thread.sleep(3000);
    tw2o.delete();
        
        
      }
         
    } 
      
                    
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    });
    return row;
});





  }
}


////////////////////////////////////////////////////////////////////////////////

//   class HourService extends Service<Date>
//    {
//
//        private Calendar calendar;
//
//        public final void setCalendarInstance(Calendar c)
//        {
//            calendar = c;
//        }
//
//
//        @Override
//        protected Task<Date> createTask() {
//
//            return new Task<Date>() {
//
//                protected Date call() throws IOException
//                {
//                    BufferedReader buffr=new BufferedReader (new FileReader (NewDir.file_dirrr+"\\ADS\\time.txt"));
//                    String timey=buffr.readLine();
//                    int secondsdelay = Integer.parseInt(timey);  //READ FROM FILE
//                    buffr.close();
//                    Date timeStarted = calendar.getTime();
//                    Date timeEnd = new Date(timeStarted.getTime() + 1000 * secondsdelay );//* 60 * 60);
//                    while( timeEnd.after(calendar.getTime()) )
//                    {
//                        try {
//                            Thread.sleep(500);
//                            calendar = Calendar.getInstance();
//                        } catch (InterruptedException e) {
//                            if (isCancelled()) {
//                                updateMessage("Cancelled");
//                                break;
//                            }
//                        }
//                    }
//                    //Close program here
//                    System.exit(0);
//                    return timeEnd;
//
//                }
//            };
//        }
//    }
////////////////////////////////////////////////////////////////////////////////
