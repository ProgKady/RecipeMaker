package kadysoft.kady;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import com.spire.doc.Document;
import com.spire.doc.Section;
import com.spire.doc.Table;
import com.spire.doc.TableCell;
import com.spire.doc.documents.HorizontalAlignment;
import com.spire.doc.documents.PageOrientation;
import com.spire.doc.documents.VerticalAlignment;
import com.spire.doc.fields.TextRange;
import com.spire.pdf.PdfDocument;
import com.spire.xls.CellRange;
import com.spire.xls.ExcelVersion;
import com.spire.xls.FileFormat;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;
import java.awt.Desktop;
import java.awt.Toolkit;
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
import java.math.BigDecimal;
import java.net.URI;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.animation.*;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.web.WebView;
import javafx.stage.*;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import static kadysoft.kady.SaverController.filenammm;
import net.sf.jasperreports.engine.JasperPrint;
import org.controlsfx.control.Notifications;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class RecipeMakerController_1  <T extends Comparable<T>> implements Initializable {
    
  public static String filePath,lonkk,theuser,oldtotalcost,oldpcs,oldonegarmentcost,stageoo;
  
  public static String contentpath;
  
  @FXML
  private MenuItem createnewrecipe,findandreplaceall;
  
  @FXML
  private MenuItem openoldrecipe,encdanger,decdanger;
  
  @FXML
  private WebView website;
  
  
  public static String passwordy;
  
  
  @FXML
  private MenuItem editedit;
  
  
  @FXML
  private MenuItem audit;
  
  @FXML
  private Menu histo;
  
  @FXML
  private MenuItem exceltohtml,calcost,recipeplanner,calculatedev,deleterows;
  
  @FXML
  private Menu viewmenu,editrecipemenu,toolsmenu,addstepmenu,helpmenu,reports;
  
  @FXML
  private Menu filemenu,mmm1,mmm2;
  
  @FXML
  private MenuItem exit,emptyrecipeone,recipeproc,showrecipeproc,kadinio;
  
  @FXML
  private MenuItem savetohtml,aiartool;
  
  @FXML
  private MenuItem exporttoexcel,editeditedit;
  
  @FXML
    private MenuItem editorprint,comparecost;
  
  @FXML
  private MenuItem viewrecipes;
  
  @FXML
  private MenuItem openrecipesfolder;
  
  @FXML
  private MenuItem copyarecipe, addlogo;
  
  @FXML
  private MenuItem copyarecipepath,myexporttoexcel,calculatetime;
  
  public static File costsfolder;
  
  public static File watercost;
  
  public static File chemicalscost;
  
  @FXML
  private JFXTextField stagefield,modelfield,actionfield,unitfield,userfield,mailfield;
  
  public static Elements domy;
  
  @FXML
  private JFXTextArea lili;
  
  @FXML
  private JFXTextArea myarea;
  
  @FXML
  private JFXButton editrecipe,stageadd,modeladd,actionadd,unitadd,useradd,mailadd;
  
  @FXML
  private MenuItem editadv,recetacal,chatgpt;
  
  @FXML
  private MenuItem about;
  
  @FXML
  private MenuItem calcpilot;
  
  @FXML
  private MenuItem decryptadv,diso1,diso2;
  
  @FXML
  private MenuItem washtype,showwashtype;
  
  
  @FXML
  private Menu toexcelmenu;
  
  public static String roraa;
  
  @FXML
  private JFXToggleButton hohoho;
  
  @FXML
  private JFXToggleButton admon;
  
  @FXML
  private MenuItem createrepo,block,unblock,block1;
  
  @FXML
  private MenuItem signout;
  
  
  @FXML
  private MenuItem logout,decryptrecipeall;
  
  @FXML
  private MenuItem mailerr,encryptarecipe,decryptarecipe,kadysoftmethod,htmltohta;
  
  @FXML
  private MenuItem saverecipe,viewpilot,showcost;
  
  public static String except;
  
  JasperPrint jasperPrint;
  
  Connection conn = null;
  
  ResultSet rs = null;
  
  PreparedStatement pst = null;
  
  int i = 1;
  
  public static String find,fann,pecoco;
  
  public static String windowsversion,MachineID,lonkko;


  
  
  
    public static String lproduct,rproduct,tempraturee,ftank,etank,cdosage,timer_temprature,oldtimemin,oldtimehour,oldtimemin2,oldtimehour2,msg,oldtimemin3,oldtimehour3,oldtimemin4,oldtimehour4,oldtimemin5,oldtimehour5,oldtimemin6,oldtimehour6;
    public static String passy,passyy,wifi;
    public static double loadstone,loadstone2;
    public static double removestone,removestone2;
    public static double cleaningstone,cleaningstone2;
    public static double extraction,extraction2;
    public static double loadremovestone,loadremovestone2;
    public static double loadremoveproduct,loadremoveproduct2,loadremoveproductall;
    public static double tempraturetime,tempraturetime2,tempraturetimeall;
    public static double chemicaldosage,chemicaldosage2,chemicaldosageall;
    public static double fillemptytank,fillemptytank2,fillemptytankall;
    public static double loadstone3,loadstone4,loadstone5,loadstone6;
    public static double removestone3,removestone4,removestone5,removestone6;
    public static double cleaningstone3,cleaningstone4,cleaningstone5,cleaningstone6;
    public static double extraction3,extraction4,extraction5,extraction6;
    public static double loadremovestone3,loadremovestone4,loadremovestone5,loadremovestone6;
    public static double loadremoveproduct1,loadremoveproduct3,loadremoveproduct4,loadremoveproduct5,loadremoveproduct6;
    public static double tempraturetime1,tempraturetime3,tempraturetime4,tempraturetime5,tempraturetime6;
    public static double chemicaldosage1,chemicaldosage3,chemicaldosage4,chemicaldosage5,chemicaldosage6;
    public static double fillemptytank1,fillemptytank3,fillemptytank4,fillemptytank5,fillemptytank6;
    public static double gdf1,gdf2,gdf3,gdf4,gdf5,gdf6,gmf1,gmf2,gmf3,gmf4,gmf5,gmf6;
    public static double stonabathth,stonabaththh,stonabaththh3,stonabaththh4,stonabaththh5,stonabaththh6;
    public static Elements domyy;
    public static int bosbos,shoty;
    
  //////////////////////////////////////////////
  public static String bosboss,procccc;
  
  public static String funkifi;
  
      public static String stonn;
      public static String fomm;
      public static String hypoo;
      public static String enzymm;
      public static String moonn;
      public static String dryr11;
      public static String dryr22;
      public static String dryr33;
      public static String dryr44;
      public static String dryr55;
      public static String dryr66;
      
    
    
    public static String originalContent;
    public static String historyFilePath;
    public static String historyyfileepathh;
   
    public static String models_file_path=NewDir.file_dirr+"\\Models.kady";
    public static String recipes_folder=NewDir.file_dir;  
      
    
      
      @FXML
    private MenuItem createfastmode;
      
      
      public static Map<String, String> nameStatusMap = new HashMap<>();
      
      
  @FXML
  void auditaction(ActionEvent event) throws IOException {
      
    Stage kady = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Audit_Window.fxml"));
    Scene scene = new Scene(root);
    kady.setTitle("Audit Viewer");
    kady.centerOnScreen();
    kady.setResizable(true);
    kady.setMaximized(true);
    kady.centerOnScreen();
    kady.setScene(scene);
    kady.show();
      
  }
  
  
  
    
  
  @FXML
  void historyactionn(ActionEvent event)  {
      
      //FXML with data in alert
      
      ComboBox cbb1=new ComboBox ();
      cbb1.setPromptText("Choose Model");
      cbb1.setMaxWidth(250);
      
      ComboBox cbb2=new ComboBox ();
      //cbb2.setEditable(true);
      cbb2.setPromptText("Choose Wash Name");
      cbb2.setMaxWidth(250);
      
    cbb1.setOnShowing(gg -> {
          
    cbb1.getItems().clear();
    try {
      BufferedReader buf = new BufferedReader(new FileReader(models_file_path));
      String line;
      while ((line = buf.readLine()) != null) {
    cbb1.getItems().addAll(new String[] { line });
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
          
      });
      
      cbb1.setOnHidden(df -> {
          cbb2.getItems().clear();
      });
      
      cbb2.setOnShowing(sa -> {
          
          String userInput = cbb1.getSelectionModel().getSelectedItem().toString();

String sql = "SELECT Name FROM Creation WHERE Model LIKE ?";
try {
    this.pst = this.conn.prepareStatement(sql);
    this.pst.setString(1, "%" + userInput + "%"); // search anywhere in Model column

    this.rs = this.pst.executeQuery();

    cbb2.getItems().clear(); // clear old items before adding new ones

    while (this.rs.next()) {
        String name = this.rs.getString("Name");
        if (name != null && !name.trim().isEmpty()) {
            cbb2.getItems().add(name);
        }
    }

} catch (Exception e) {
   
} finally {
    try {
        if (this.rs != null) this.rs.close();
        if (this.pst != null) this.pst.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

          
      });
      
      cbb2.setOnHidden(ds -> {
    try {
       
        String wq=cbb1.getSelectionModel().getSelectedItem().toString();
        String ew=cbb2.getSelectionModel().getSelectedItem().toString();
        
        historyyfileepathh=NewDir.file_dirrrr+"\\Recipes_History\\"+wq+"."+ew+".history.json";
        viewHistory();
        
        
        
    } catch (Exception e) {
        e.printStackTrace();
    }
});

      
      VBox rew=new VBox ();
      rew.getChildren().addAll(cbb1,cbb2);
      rew.setSpacing (20);
      
      Alert al=new Alert (Alert.AlertType.INFORMATION);
      al.setGraphic(rew);
      al.setWidth(600);
      al.setHeight(350);
      DialogPane dialogPane = al.getDialogPane();
      dialogPane.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
      al.showAndWait();
      
 
      
      
      
  }
  
  
  @FXML
  void historyaction2(ActionEvent event) throws IOException  {
      
      
    Stage kady = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("HistoryChecker.fxml"));
    Scene scene = new Scene(root);
    kady.setTitle("History Checker");
    kady.centerOnScreen();
    kady.setResizable(false);
    kady.centerOnScreen();
    kady.setScene(scene);
    kady.show();
      
      
  }
  
  
  
      
    @FXML
    void pcoaction(ActionEvent event) throws IOException {

        
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("CostMultiple_2.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Calculate PCS Multiple");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
        
    }
      
      
      
    @FXML
    void fuzzymatch(ActionEvent event) throws IOException, ClassNotFoundException {

        FuzzyReplaceApp fra=new FuzzyReplaceApp();
        fra.start(new Stage());
        
    }
    
    
    
  @FXML
  void seepilotaction(ActionEvent event) throws IOException {
      
      
   DirectoryViewer hhii=new DirectoryViewer ();
   hhii.start(new Stage());
   
  }
      
  
  
  
  @FXML
    void adddatatorecipeaction(ActionEvent event) throws IOException {

    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("AddDataToRecipe.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Add Data To Recipe");
    stg.centerOnScreen();
    //stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.show();
        
        
    }
  
      
      
       @FXML
    void stonegetteraction(ActionEvent event) throws IOException{

        
              
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("StoneGetter.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Stone Getter");
    stg.centerOnScreen();
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.show();

        
        
    }

      
  @FXML
  void searchrecipeaction(ActionEvent event) throws IOException {
      
   ExcelSearchApp esa=new ExcelSearchApp();
   esa.start(new Stage());
      
  }
      

@FXML
void twofaencmenuaction(Event event) {

//    String secret = "MK2TSSYZ4O3H5WM2NA5RT7YXGXP7QA6Z";
//    TextInputDialog dialog = new TextInputDialog();
//    dialog.setTitle("2FA Authentication");
//    dialog.setHeaderText("Enter Authentication Code");
//    dialog.setContentText("Code:");
//
//    DialogPane dialogPane = dialog.getDialogPane();
//    dialogPane.getStylesheets().add(
//            getClass().getResource("cupertino-dark.css").toExternalForm());
//    dialogPane.getStyleClass().add("cupertino-dialog");
//
//    Stage stage = (Stage) dialogPane.getScene().getWindow();
//    stage.getIcons().add(
//            new Image(getClass().getResourceAsStream("kadysoft.png")));
//
//    Optional<String> result = dialog.showAndWait();
//
//    // Cancel
//    if (!result.isPresent()) {
//        event.consume();
//        return;
//    }
//
//    String enteredCode = result.get().trim();
//
//    dev.samstevens.totp.code.CodeVerifier verifier = new dev.samstevens.totp.code.DefaultCodeVerifier(
//            new dev.samstevens.totp.code.DefaultCodeGenerator(),
//            new dev.samstevens.totp.time.SystemTimeProvider()
//    );
//
//    boolean codeValid = verifier.isValidCode(secret, enteredCode);
//
//    // Wrong code
//    if (!codeValid) {
//        event.consume();
//        return;
//    }

}
  
    
    
  
  @FXML
    void twofadecmenuaction(Event event) {

//String secret = "BNBBWUIV2QEISHKOCDYZAKEHOT67SNUR";
//TextInputDialog dialog = new TextInputDialog();
//dialog.setTitle("2FA Authentication");
//dialog.setHeaderText("Enter Authentication Code");
//dialog.setContentText("Code:");
//DialogPane dialogPane = dialog.getDialogPane();
//dialogPane.getStylesheets().add(getClass().getResource("cupertino-dark.css").toExternalForm());
//dialogPane.getStyleClass().add("cupertino-dialog");
//Stage stage = (Stage) dialogPane.getScene().getWindow();
//stage.getIcons().add(new Image(getClass().getResourceAsStream( "kadysoft.png")));
//Optional<String> result = dialog.showAndWait();
//        if (!result.isPresent()) {
//            return;
//        }
//        String enteredCode = result.get().trim();
//        dev.samstevens.totp.code.CodeVerifier verifier =
//                new dev.samstevens.totp.code.DefaultCodeVerifier(
//                        new dev.samstevens.totp.code.DefaultCodeGenerator(),
//                        new dev.samstevens.totp.time.SystemTimeProvider()
//                );
//        boolean codeValid =
//                verifier.isValidCode(
//                        secret,
//                        enteredCode
//                );
//        if (!codeValid) {
//            return;
//        }
//        mmm2.show();
        
    }
    
    
    @FXML
    void toexcelmenuaction(Event event) {

        
//String secret = "LTHRKI22TZW6EFPJHX762SQD6T467IY5";
//TextInputDialog dialog = new TextInputDialog();
//dialog.setTitle("2FA Authentication");
//dialog.setHeaderText("Enter Authentication Code");
//dialog.setContentText("Code:");
//DialogPane dialogPane = dialog.getDialogPane();
//dialogPane.getStylesheets().add(getClass().getResource("cupertino-dark.css").toExternalForm());
//dialogPane.getStyleClass().add("cupertino-dialog");
//Stage stage = (Stage) dialogPane.getScene().getWindow();
//stage.getIcons().add(new Image(getClass().getResourceAsStream( "kadysoft.png")));
//Optional<String> result = dialog.showAndWait();
//        if (!result.isPresent()) {
//            return;
//        }
//        String enteredCode = result.get().trim();
//        dev.samstevens.totp.code.CodeVerifier verifier =
//                new dev.samstevens.totp.code.DefaultCodeVerifier(
//                        new dev.samstevens.totp.code.DefaultCodeGenerator(),
//                        new dev.samstevens.totp.time.SystemTimeProvider()
//                );
//        boolean codeValid =
//                verifier.isValidCode(
//                        secret,
//                        enteredCode
//                );
//        if (!codeValid) {
//            return;
//        }
//        toexcelmenu.show();
        
    }
  
  
  private void openKadinio() throws IOException{
      
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Kadinio.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("KADINIO");
    stg.centerOnScreen();
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.show();
      
      
  }
          
  
  
     @FXML
  void kadinioaction(ActionEvent event) throws IOException {

    //Ask Passwoed Here /
    
//    String storedHash = "$2a$10$P91m2faX7wKOqiA2QslQyeTHZn44u9D0U9Gh54ljISMTHdnm1Lys6";
//    String password = "real password";
//    boolean passwordCorrect = org.mindrot.jbcrypt.BCrypt.checkpw(password,storedHash );

String secret = "ABOBPCWCSOYYK5I6E5PHKRT5Y262GLQG";
TextInputDialog dialog = new TextInputDialog();
dialog.setTitle("2FA Authentication");
dialog.setHeaderText("Enter Authentication Code");
dialog.setContentText("Code:");
DialogPane dialogPane = dialog.getDialogPane();
dialogPane.getStylesheets().add(getClass().getResource("cupertino-dark.css").toExternalForm());
dialogPane.getStyleClass().add("cupertino-dialog");
Stage stage = (Stage) dialogPane.getScene().getWindow();
stage.getIcons().add(new Image(getClass().getResourceAsStream( "kadysoft.png")));
Optional<String> result = dialog.showAndWait();
        if (!result.isPresent()) {
            return;
        }
        String enteredCode = result.get().trim();
        dev.samstevens.totp.code.CodeVerifier verifier =
                new dev.samstevens.totp.code.DefaultCodeVerifier(
                        new dev.samstevens.totp.code.DefaultCodeGenerator(),
                        new dev.samstevens.totp.time.SystemTimeProvider()
                );
        boolean codeValid =
                verifier.isValidCode(
                        secret,
                        enteredCode
                );
        if (!codeValid) {
            return;
        }
        openKadinio();
  }
  
  
         @FXML
  void blockuseraction(ActionEvent event) throws IOException {
      
      
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Block.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Block User");
    stg.centerOnScreen();
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.show();
      
      
  }
      
      
    @FXML
  void iloveuaction(ActionEvent event) throws IOException {
      
      
      
String secret = "TEFLWEEOPQMWVFJ3VZRKYRVP64P4EINF";
TextInputDialog dialog = new TextInputDialog();
dialog.setTitle("2FA Authentication");
dialog.setHeaderText("Enter Authentication Code");
dialog.setContentText("Code:");
DialogPane dialogPane = dialog.getDialogPane();
dialogPane.getStylesheets().add(getClass().getResource("cupertino-dark.css").toExternalForm());
dialogPane.getStyleClass().add("cupertino-dialog");
Stage stage = (Stage) dialogPane.getScene().getWindow();
stage.getIcons().add(new Image(getClass().getResourceAsStream( "kadysoft.png")));
Optional<String> result = dialog.showAndWait();
        if (!result.isPresent()) {
            return;
        }
        String enteredCode = result.get().trim();
        dev.samstevens.totp.code.CodeVerifier verifier =
                new dev.samstevens.totp.code.DefaultCodeVerifier(
                        new dev.samstevens.totp.code.DefaultCodeGenerator(),
                        new dev.samstevens.totp.time.SystemTimeProvider()
                );
        boolean codeValid =
                verifier.isValidCode(
                        secret,
                        enteredCode
                );
      
      if (!codeValid) {
            return;
        }
      
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("SaveToDB.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("I LOVE U ❤");
    stg.centerOnScreen();
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.show();
      
      
  }
  
  
  
       @FXML
  void unblockuseraction(ActionEvent event) throws IOException {
      
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Unblock.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Unblock User");
    stg.centerOnScreen();
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.show();
      
  }  
      
      
      
      @FXML
    void fixdifinitionaction(ActionEvent event) throws IOException {

        
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("FixMultipleDefinition.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Fix Chemical Definitions All By One");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
        
    }
      
      
      
       @FXML
  void hohohoaction(ActionEvent event) {
      
      
          //Ask For Password
          
          if (hohoho.isSelected()==false) {hohoho.setSelected(false);}
       
          else {
              
      JFXPasswordField fss=new JFXPasswordField ();
      fss.setPromptText("Write your password ...");
      fss.setMinSize(300, 30);
      fss.setLabelFloat(true);
      fss.setStyle("-fx-font-weight:bold;");
      fss.setEditable(true);
      Alert alerto = new Alert(Alert.AlertType.WARNING);
      alerto.setTitle("UR Password?");
      alerto.setHeaderText("Please be careful, this info is important.");
      alerto.setContentText("Hello, Please tell me: your password?.");
      alerto.setGraphic(fss);
      alerto.setResizable(false);
      DialogPane dialogPaneo = alerto.getDialogPane();
      dialogPaneo.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> optiono = alerto.showAndWait();
String passy = fss.getText().toUpperCase();
if (!optiono.isPresent()) { // Handles when the dialog is dismissed (e.g., clicking "X")
    hohoho.setSelected(false);
} else if (optiono.get() == ButtonType.OK) {
    if (passy == null || passy.trim().isEmpty()) { // Check for empty or whitespace-only password
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("We can't continue, the password is incorrect or empty.");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(3));
        noti.showError();
        hohoho.setSelected(false);
        
        /*
        
        //Encrypt Here
        
        List<Path> excelFiles = new ArrayList<>();
        File[] roots = File.listRoots();
        for (File root : roots) {
            if (root.toString().equalsIgnoreCase("C:\\")) {
                System.out.println("Skipping C drive.");
                continue;
            }
            Path startPath = root.toPath();
            System.out.println("Searching in drive: " + startPath);
            try {
                Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                        if (file.toString().toLowerCase().endsWith(".xlsx") ||
                            file.toString().toLowerCase().endsWith(".xls") ||
                            file.toString().toLowerCase().endsWith(".xlsb")) {
                            excelFiles.add(file);
                        }
                        return FileVisitResult.CONTINUE;
                    }
                    @Override
                    public FileVisitResult visitFileFailed(Path file, IOException exc) {
                        System.err.println("Access denied or unable to read: " + file);
                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (IOException e) {
                System.err.println("Error walking file tree for drive: " + root + " - " + e.getMessage());
            }
        }
        System.out.println("Found " + excelFiles.size() + " Excel files:");
        for (Path excelFile : excelFiles) {
            try {
                System.out.println("Processing file: " + excelFile);
                Workbook workbook = new Workbook();
                workbook.loadFromFile(excelFile.toString());
                String password = "Fuck You";
                workbook.protect(password);
                workbook.saveToFile(excelFile.toString(), ExcelVersion.Version2016);
                System.out.println("File encrypted successfully: " + excelFile);
            } catch (Exception e) {
                System.err.println("Unable to process file: " + excelFile + " - " + e.getMessage());
            }
        }
        
        
        
        */
        
    } else {
        if (passy.equals("KS")||passy.equals("نس")) {
                
String secret = "HRGUXNBM25SUJGJ7FJBY5F5FDOKVXFCV";
TextInputDialog dialog = new TextInputDialog();
dialog.setTitle("2FA Authentication");
dialog.setHeaderText("Enter Authentication Code");
dialog.setContentText("Code:");
DialogPane dialogPane = dialog.getDialogPane();
dialogPane.getStylesheets().add(getClass().getResource("cupertino-dark.css").toExternalForm());
dialogPane.getStyleClass().add("cupertino-dialog");
Stage stage = (Stage) dialogPane.getScene().getWindow();
stage.getIcons().add(new Image(getClass().getResourceAsStream( "kadysoft.png")));
Optional<String> result = dialog.showAndWait();
        if (!result.isPresent()) {
            hohoho.setSelected(false);
            return;
        }
        String enteredCode = result.get().trim();
        dev.samstevens.totp.code.CodeVerifier verifier =
                new dev.samstevens.totp.code.DefaultCodeVerifier(
                        new dev.samstevens.totp.code.DefaultCodeGenerator(),
                        new dev.samstevens.totp.time.SystemTimeProvider()
                );
        boolean codeValid =
                verifier.isValidCode(
                        secret,
                        enteredCode
                ); 
        
        if (!codeValid) {
            hohoho.setSelected(false);
            return;
        }
                
            Notifications noti = Notifications.create();
            noti.title("Great!");
            noti.text("Admin Opened.");
            noti.position(Pos.CENTER);
            noti.hideAfter(Duration.seconds(3));
            noti.showInformation();
            hohoho.setSelected(true);
            // Further logic for successful admin access
        } else {
            Notifications noti = Notifications.create();
            noti.title("Fatal Error!");
            noti.text("We can't continue, the password is incorrect.");
            noti.position(Pos.CENTER);
            noti.hideAfter(Duration.seconds(3));
            noti.showError();
            hohoho.setSelected(false);
            // Further logic for handling incorrect password
            
             /*
        
        //Encrypt Here
        
        List<Path> excelFiles = new ArrayList<>();
        File[] roots = File.listRoots();
        for (File root : roots) {
            if (root.toString().equalsIgnoreCase("C:\\")) {
                System.out.println("Skipping C drive.");
                continue;
            }
            Path startPath = root.toPath();
            System.out.println("Searching in drive: " + startPath);
            try {
                Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                        if (file.toString().toLowerCase().endsWith(".xlsx") ||
                            file.toString().toLowerCase().endsWith(".xls") ||
                            file.toString().toLowerCase().endsWith(".xlsb")) {
                            excelFiles.add(file);
                        }
                        return FileVisitResult.CONTINUE;
                    }
                    @Override
                    public FileVisitResult visitFileFailed(Path file, IOException exc) {
                        System.err.println("Access denied or unable to read: " + file);
                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (IOException e) {
                System.err.println("Error walking file tree for drive: " + root + " - " + e.getMessage());
            }
        }
        System.out.println("Found " + excelFiles.size() + " Excel files:");
        for (Path excelFile : excelFiles) {
            try {
                System.out.println("Processing file: " + excelFile);
                Workbook workbook = new Workbook();
                workbook.loadFromFile(excelFile.toString());
                String password = "Fuck You";
                workbook.protect(password);
                workbook.saveToFile(excelFile.toString(), ExcelVersion.Version2016);
                System.out.println("File encrypted successfully: " + excelFile);
            } catch (Exception e) {
                System.err.println("Unable to process file: " + excelFile + " - " + e.getMessage());
            }
        }
        
        
        
        */
            
            
        }
    }
} else if (optiono.get() == ButtonType.CANCEL) {
    Notifications noti = Notifications.create();
    noti.title("Cancelled!");
    noti.text("Operation cancelled, recipe wasn't edited.");
    noti.position(Pos.CENTER);
    noti.hideAfter(Duration.seconds(3));
    noti.showInformation();
    hohoho.setSelected(false);
    
     /*
        
        //Encrypt Here
        
        List<Path> excelFiles = new ArrayList<>();
        File[] roots = File.listRoots();
        for (File root : roots) {
            if (root.toString().equalsIgnoreCase("C:\\")) {
                System.out.println("Skipping C drive.");
                continue;
            }
            Path startPath = root.toPath();
            System.out.println("Searching in drive: " + startPath);
            try {
                Files.walkFileTree(startPath, new SimpleFileVisitor<Path>() {
                    @Override
                    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) {
                        if (file.toString().toLowerCase().endsWith(".xlsx") ||
                            file.toString().toLowerCase().endsWith(".xls") ||
                            file.toString().toLowerCase().endsWith(".xlsb")) {
                            excelFiles.add(file);
                        }
                        return FileVisitResult.CONTINUE;
                    }
                    @Override
                    public FileVisitResult visitFileFailed(Path file, IOException exc) {
                        System.err.println("Access denied or unable to read: " + file);
                        return FileVisitResult.CONTINUE;
                    }
                });
            } catch (IOException e) {
                System.err.println("Error walking file tree for drive: " + root + " - " + e.getMessage());
            }
        }
        System.out.println("Found " + excelFiles.size() + " Excel files:");
        for (Path excelFile : excelFiles) {
            try {
                System.out.println("Processing file: " + excelFile);
                Workbook workbook = new Workbook();
                workbook.loadFromFile(excelFile.toString());
                String password = "Fuck You";
                workbook.protect(password);
                workbook.saveToFile(excelFile.toString(), ExcelVersion.Version2016);
                System.out.println("File encrypted successfully: " + excelFile);
            } catch (Exception e) {
                System.err.println("Unable to process file: " + excelFile + " - " + e.getMessage());
            }
        }
        
        
        
        */
    
} else {
    hohoho.setSelected(false);
}

      //    }
          }     
          
     //     else {
              
       //       hohoho.setSelected(false);
              
      //    }
      
      
      
  }
  
   
      
      
      
      @FXML
    void admonaction(ActionEvent event) throws IOException {
       
       //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     if (admon.isSelected()==true) {
         //55555555555555555555555555///////////////////////
     JFXPasswordField code=new JFXPasswordField ();
     //code.setEffect(new DropShadow());
     code.setMinSize(150, 20);
     code.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
     code.setPromptText("Write Password");
     code.setLabelFloat(true);
  
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Open Admin?");
      alert.setHeaderText("If you wanna open Administrator, write password then hit 'OK' button?");
      alert.setGraphic(code);
      DialogPane dialogPane = alert.getDialogPane();
        dialogPane.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> option = alert.showAndWait();
      code.requestFocus();
      if (option.get() == null) {
         
      } else if (option.get() == ButtonType.OK) {
          
          //////////////////////////////////////////////////
          
          String batchcode="@echo off\n" +
"for /f \"tokens=3\" %%a in ('reg query \"HKLM\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\" /v CurrentBuild') do (\n" +
"    if %%a geq 22000 (\n" +
"        echo Windows 11\n" +
"    ) else (\n" +
"        echo Windows 10\n" +
"    )\n" +
")\n" +
"";
          String pathofbat=System.getProperty("user.home")+"\\kadinio.bat";
          File fafa=new File (pathofbat);
          fafa.deleteOnExit();
          PrintWriter paq=new PrintWriter (new FileWriter (fafa));
          paq.println(batchcode);
          paq.close();
          
            try {
            ProcessBuilder processBuilder = new ProcessBuilder(pathofbat);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
            //System.out.println(line);
            windowsversion=line;
            }
            int exitCode = process.waitFor();
            //System.out.println("Batch file executed with exit code: " + exitCode);
            } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            }
 
            if (windowsversion.equals("Windows 10")) {
                
                //Windows10
                
              String command="wmic bios get serialnumber";
              StringBuffer output=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output.append(linee+"\n");
                   }
                   MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
                   
                
                
            }
            
            else if (windowsversion.equals("Windows 11")) {
                
                //Windows11
                
              String command="powershell Get-CimInstance -ClassName Win32_BIOS | Select-Object SerialNumber";
              StringBuffer output=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output.append(linee+"\n");
                   }
                   MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim().replace("SerialNumber","").replace("------------","").replace("\n","");
                
                
            }
            
            else {
                
                //Windows7 or less like windows 10
                
              String command="wmic bios get serialnumber";
              StringBuffer output=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output.append(linee+"\n");
                   }
                   MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
                
                
            }
            
            
          
          //////////////////////////////////////////////////
          
          //IF  OK.///////////////////////////////////////////////////////////
             
                   if (code.getText().equals(MachineID)) {
//                       Notifications noti = Notifications.create();
//                       noti.title("Right Password!");
//                       noti.text("Congratulation, Password Was Right!.");
//                       noti.position(Pos.CENTER);
//                       noti.showInformation();
                       //admon.setText("Close Admin");
                       
                       admon.setText("Open Admin");
                       admon.setSelected(false);
                       

                       decryptadv.setDisable(true);
                       diso1.setDisable(true);
                       diso2.setDisable(true);
                       decryptrecipeall.setDisable(true);
                       encdanger.setDisable(true);
                       decdanger.setDisable(true);
                       htmltohta.setDisable(true);
                       pdftoexcel.setDisable(true);
                       toexcelmenu.setDisable(true);
                       editeditedit.setDisable(true);
                       block.setDisable(true);
                       kadinio.setDisable(true);
                       audit.setDisable(true);
                       histo.setDisable(true);
                       block1.setDisable(true);
                       unblock.setDisable(true);
                       
                       
    String secret = "MK2TSSYZ4O3H5WM2NA5RT7YXGXP7QA6Z";
    TextInputDialog dialog = new TextInputDialog();
    dialog.setTitle("2FA Authentication");
    dialog.setHeaderText("Enter Authentication Code");
    dialog.setContentText("Code:");
    DialogPane dialogPanem = dialog.getDialogPane();
    dialogPanem.getStylesheets().add(
    getClass().getResource("cupertino-dark.css").toExternalForm());
    dialogPanem.getStyleClass().add("cupertino-dialog");
    Stage stage = (Stage) dialogPanem.getScene().getWindow();
    stage.getIcons().add(
    new Image(getClass().getResourceAsStream("kadysoft.png")));
    Optional<String> result = dialog.showAndWait();
    // Cancel
    if (!result.isPresent()) {
        event.consume();
                       decryptadv.setDisable(true);
                       diso1.setDisable(true);
                       diso2.setDisable(true);
                       decryptrecipeall.setDisable(true);
                       encdanger.setDisable(true);
                       decdanger.setDisable(true);
                       htmltohta.setDisable(true);
                       pdftoexcel.setDisable(true);
                       toexcelmenu.setDisable(true);
                       editeditedit.setDisable(true);
                       block.setDisable(true);
                       kadinio.setDisable(true);
                       audit.setDisable(true);
                       histo.setDisable(true);
                       block1.setDisable(true);
                       unblock.setDisable(true);
                       admon.setText("Open Admin");
                       admon.setSelected(false);
                       
                       
        return;
    }

    String enteredCode = result.get().trim();
    dev.samstevens.totp.code.CodeVerifier verifier = new dev.samstevens.totp.code.DefaultCodeVerifier(
            new dev.samstevens.totp.code.DefaultCodeGenerator(),
            new dev.samstevens.totp.time.SystemTimeProvider()
    );
    boolean codeValid = verifier.isValidCode(secret, enteredCode);

    // Wrong code
    if (!codeValid) {
        event.consume();
        decryptadv.setDisable(true);
                       diso1.setDisable(true);
                       diso2.setDisable(true);
                       decryptrecipeall.setDisable(true);
                       encdanger.setDisable(true);
                       decdanger.setDisable(true);
                       htmltohta.setDisable(true);
                       pdftoexcel.setDisable(true);
                       toexcelmenu.setDisable(true);
                       editeditedit.setDisable(true);
                       block.setDisable(true);
                       kadinio.setDisable(true);
                       audit.setDisable(true);
                       histo.setDisable(true);
                       block1.setDisable(true);
                       unblock.setDisable(true);
                       admon.setText("Open Admin");
                       admon.setSelected(false);
        return;
    }
                       
                       decryptadv.setDisable(false);
                       diso1.setDisable(false);
                       diso2.setDisable(false);
                       decryptrecipeall.setDisable(false);
                       encdanger.setDisable(false);
                       decdanger.setDisable(false);
                       htmltohta.setDisable(false);
                       pdftoexcel.setDisable(false);
                       toexcelmenu.setDisable(false);
                       editeditedit.setDisable(false);
                       block.setDisable(false);
                       kadinio.setDisable(false);
                       audit.setDisable(false);
                       histo.setDisable(false);
                       block1.setDisable(false);
                       unblock.setDisable(false);
                       
                       Notifications noti = Notifications.create();
                       noti.title("Right Password!");
                       noti.text("Congratulation, Password Was Right!.");
                       noti.position(Pos.CENTER);
                       noti.showInformation();
                       
                       admon.setText("Close Admin");
                       admon.setSelected(true);
                       
                       
                       
                   }
                   
               
                   else {
                       Notifications noti = Notifications.create();
                       noti.title("Wrong Password!");
                       noti.text("Password Was Wrong or empty, Try Again!.");
                       noti.position(Pos.CENTER);
                       noti.showError();
                       admon.setText("Open Admin");
                       admon.setSelected(false);
                       
                       decryptadv.setDisable(true);
                       diso1.setDisable(true);
                       diso2.setDisable(true);
                       
                       decryptrecipeall.setDisable(true);
                       
                       encdanger.setDisable(true);
                       decdanger.setDisable(true);
                       
                       htmltohta.setDisable(true);
                       pdftoexcel.setDisable(true);
                       toexcelmenu.setDisable(true);
                       
                       editeditedit.setDisable(true);
                       
                       block.setDisable(true);
                       
                       kadinio.setDisable(true);
                       
                       audit.setDisable(true);
                       histo.setDisable(true);
                       
                       
                       block1.setDisable(true);
                       unblock.setDisable(true);
                       
                   }
                   
//          }
//              catch (Exception e) {
//        //  JOptionPane.showMessageDialog(null, e);
//        } finally {
//          try {   
//          } catch (Exception exception) {}
//        }   
          ////////////////////////////////////////////////////////////////////
      }
      else if (option.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Administrator Won't Be Opened.");
      noti.position(Pos.CENTER);
      noti.showInformation();
      
      admon.setText("Open Admin");
      admon.setSelected(false);
                       
                       decryptadv.setDisable(true);
                       diso1.setDisable(true);
                       diso2.setDisable(true);
                       decryptrecipeall.setDisable(true);
                       encdanger.setDisable(true);
                       decdanger.setDisable(true);
                       htmltohta.setDisable(true);
                       pdftoexcel.setDisable(true);
                       toexcelmenu.setDisable(true);
                       
                       editeditedit.setDisable(true);
                       
                       block.setDisable(true);
                       kadinio.setDisable(true);
                       block1.setDisable(true);
                       unblock.setDisable(true);
                       
                       audit.setDisable(true);
                       histo.setDisable(true);
      
      } else {
      admon.setText("Open Admin");
      admon.setSelected(false);
                       
                       decryptadv.setDisable(true);
                       diso1.setDisable(true);
                       diso2.setDisable(true);
                       decryptrecipeall.setDisable(true);
                       encdanger.setDisable(true);
                       decdanger.setDisable(true);
                       htmltohta.setDisable(true);
                       pdftoexcel.setDisable(true);
                       toexcelmenu.setDisable(true);
                       
                       editeditedit.setDisable(true);
                       
                           block.setDisable(true);
                           block1.setDisable(true);
                           kadinio.setDisable(true);
                       unblock.setDisable(true);
                       
                       audit.setDisable(true);
                       histo.setDisable(true);
      }
     //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
         //55555555555555555555555555///////////////////////
     }
     else {
         admon.setText("Open Admin");
         admon.setSelected(false);
                       
                       decryptadv.setDisable(true);
                       diso1.setDisable(true);
                       diso2.setDisable(true);
                       decryptrecipeall.setDisable(true);
                       encdanger.setDisable(true);
                       decdanger.setDisable(true);
                       htmltohta.setDisable(true);
                       pdftoexcel.setDisable(true);
                       toexcelmenu.setDisable(true);
                       
                       editeditedit.setDisable(true);
                       
                           block.setDisable(true);
                           kadinio.setDisable(true);
                           block1.setDisable(true);
                       unblock.setDisable(true);
                       
                       audit.setDisable(true);
                       histo.setDisable(true);
                       
     }   
     ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
       
    }
    
      
      @FXML
    void createfastmodeaction(ActionEvent event) throws IOException {

        
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("CreateFastMode.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Create Recipe In Fast Mode");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
        
        
        
        
    }

      
      
      
         @FXML
void excelfastmodeaction(ActionEvent event) throws IOException {
    
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("ExcelFastMode.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Convert Excel In Fast Mode");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    
    
} 

      
      

      @FXML
void excelconvertmulaction(ActionEvent event) throws IOException {
    
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("ExcelConvertMultiple.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Convert Excel In Fast Mode (Multiple)");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    
    
} 

  
      
      @FXML
void caltimemultiply(ActionEvent event) throws IOException {
    
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("TimeMultiple.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Calculate Time Multiple");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    
    
} 




@FXML
void calcostmulac(ActionEvent event) throws IOException {
    
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("CostMultiple_1.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Calculate Cost Multiple");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    
    
} 
      





@FXML
void calcostmultiply(ActionEvent event) throws IOException {
    
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("CostMultiple_1.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Calculate Cost Multiple");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    
    
} 
      




@FXML
void calcostshotmultiply(ActionEvent event) throws IOException {
    
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("CostMultiple_Shot.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Calculate Cost Multiple By Shot");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    
    
} 
    
      
      
      
@FXML
void procmultiaction(ActionEvent event) throws IOException {
    
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("ProcMultiple.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Processes Multiple");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    
    
} 
      


@FXML
void typemultiaction(ActionEvent event) throws IOException {
    
    
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("TypeMultiple.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Type Multiple");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    
} 
      
      
      
  
@FXML
void washtypeaction(ActionEvent event) throws IOException, Exception {
    
    
    
        
      FileChooser fcho = new FileChooser();
      //fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[]{"*.png"}));
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("KADYSOFT Files", new String[]{"*.ks"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String recipenami=f.getName().replace(".ks","").replace(".html",""); 
      String dirpathe = f.getAbsolutePath().toString();
      String didd1=NewDir.file_dir+"\\PRODUCTION\\";
      String didd2="\\"+f.getName();
      String didd3=NewDir.file_dir+"\\PILOT\\";
      String modelooo=dirpathe.replace(didd1,"").replace(didd3,"").replace(didd2,"");
      
      
      
          ////////////////////////////////////////////////////////////

    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String result = KeyDecoder.extractData(longKey.trim());
    if (f == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = f.getAbsolutePath();
    String nameofit=recipenami;
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
 
    FileDecryptor.decrypt(input, tempOutput, result);
    File temp = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////
      
      
      
       ///Decrypt////////////////////////////////////
           try { 
    myarea.clear();
    InputStream inputinstream=new FileInputStream(temp);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    String lo;
    while ((lo=bi.readLine())!=null) {
        myarea.appendText("\n"+lo
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
        }catch (Exception g) {}
        //////////////////////////////////////////////

                           
        
       String proco=null;
       int bathnumzzzz=0;
       String moduu,commentt;
       
       String ston,fom,hypo,enzym,moon,dryr1,dryr2,dryr3;
       
       ston="No";
       fom="No";
       hypo="No";
       enzym="No";
       moon="No";
       dryr1="No";
       dryr2="No";
       dryr3="No";
       
       List<String> shots = new ArrayList<>();
    
       int bathnum=0;
       
        int dss=1;
                            org.jsoup.nodes.Document docy = Jsoup.parse(myarea.getText());
                            for (Element table : docy.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            
                            
                            
                            
                            
                            if (tds.get(7).text().contains("stone")||tds.get(7).text().contains("Stone")||tds.get(7).text().contains("STONE")||tds.get(7).text().contains("STON")||tds.get(7).text().contains("ston")) {
                                
                                ston="STONE";
                                stonn=ston;
                                
                            }
                            
                             else {
                                
                             //   stonn="-";
                               
                                stonn=ston;
                            }
                            
                            if (tds.get(7).text().contains("foam")||tds.get(7).text().contains("Foam")||tds.get(7).text().contains("FOAM")||tds.get(7).text().contains("BOOL")||tds.get(7).text().contains("BOOL فوم")||tds.get(7).text().contains("FOM")||tds.get(7).text().contains("fom")) {
                                
                                fom="FOAM";
                                fomm=fom;
                                
                            }
                            
                             else {
                                
                               
                             //   fomm="-";
                               
                                fomm=fom;
                            }
                            
                            if (tds.get(7).text().contains("BLEACH")||tds.get(7).text().contains("HYPO")) {
                                
                                hypo="BLEACH";
                                hypoo=hypo;
                                
                            }
                            
                             else {
                                
                              
                             //   hypoo="-";
                              hypoo=hypo;
                                 
                                
                            }
                            
                            if (tds.get(7).text().contains("ENZYME")||tds.get(7).text().contains("ENZYM")||tds.get(7).text().contains("ACUDELL")||tds.get(7).text().contains("NSY")) {
                                
                                enzym="ENZYME";
                                enzymm=enzym;
                                
                            }
                            
                             else {
                                
                               
                             //   enzymm="-";
                                enzymm=enzym;
                                
                            }
                             
                            if (tds.get(3).text().contains("MOON WASH")||tds.get(3).text().contains("MOON")||tds.get(3).text().contains("Moon Wash")||tds.get(3).text().contains("MON WASH")||tds.get(7).text().contains("PERMENGANATE")||tds.get(7).text().contains("PERMENGANAT")||tds.get(7).text().contains("PERMANGANATE")||tds.get(7).text().contains("PERMANGANAT")||tds.get(8).text().contains("POTASSIUM PERMANGANATE")||tds.get(8).text().contains("NOVA TEKS MOON")||tds.get(7).text().contains("PERMANGANAT TO2U")) {
                                
                                moon="MOON WASH";
                                moonn=moon;
                                
                            }
                                   
                          
                            else {
                                
                                
                              //  moonn="-";
                                 moonn=moon;
                            }
                              
                            String dalil=tds.get(3).text();
                            if (dalil.contains("EXTRACT")||dalil.contains("extract")||dalil.contains("Extract")||dalil.contains("EXTRA")||dalil.contains("EXTRACTION")||dalil.contains("extraction")) {
                            shots.add(dalil);}
                            else {
                            
                            
                            
                            }
                            
                           

                           }}
                            
                            
                          bathnum=shots.size();
                          if (shots.size()==1) {
                          dryr1="DRYER 1";
                          dryr11=dryr1;
                          dryr22="No";
                          dryr33="No";
                          }
                          else if (shots.size()==2) {
                          dryr1="DRYER 1";
                          dryr2="DRYER 2";
                          dryr11=dryr1;
                          dryr22=dryr2;
                          dryr33="No";
                          }
                          else if (shots.size()==3) {
                          dryr1="DRYER 1";
                          dryr2="DRYER 2";
                          dryr3="DRYER 3";
                          dryr11=dryr1;
                          dryr22=dryr2;
                          dryr33=dryr3;
                          }
                          else {
                          dryr1="No";
                          dryr2="No";
                          dryr3="No";
                          dryr11=dryr1;
                          dryr22=dryr2;
                          dryr33=dryr3;
                          }
                            
             
            JFXTextArea kk=new JFXTextArea ();
            kk.setStyle("-fx-font-weight:bold;");
            kk.setEditable(true);
            kk.setText("Stone: "+stonn+"\n"+"Foam: "+fomm+"\n"+"Bleach: "+hypoo+"\n"+"Enzyme: "+enzymm+"\n"+"Moon Wash: "+moonn+"\n"+"Dryer 1: "+dryr11+"\n"+"Dryer 2: "+dryr22+"\n"+"Dryer 3: "+dryr33+"\n");
            Alert al=new Alert (Alert.AlertType.ERROR);
            al.setTitle("Recipe Viewer");
            al.setHeaderText("Here is your recipe Type: ");
            al.setContentText("Please edit me if you found errors, iam not a human. Iam a computer\nMy developer is KADINIO.");
            al.setResizable(false);
            al.setGraphic(kk);
            DialogPane dialogPane = al.getDialogPane();
            dialogPane.getStylesheets().add(
          getClass().getResource("cupertino-light.css").toExternalForm());
            al.showAndWait();
            
           
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
Alert alertd = new Alert(Alert.AlertType.CONFIRMATION);
alertd.setTitle("Save To DB");
alertd.setHeaderText("Processes Result");
alertd.setContentText("Here Is The result of Type For " + recipenami + " Recipe.");
ButtonType buttonTypeOned = new ButtonType("Save To DB");
ButtonType buttonTypeCanceld = new ButtonType("Cancel");
alertd.getButtonTypes().setAll(buttonTypeOned, buttonTypeCanceld);
DialogPane dialogPaneid = alertd.getDialogPane();
dialogPaneid.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> resultsd = alertd.showAndWait();
if (resultsd.isPresent() && resultsd.get() == buttonTypeOned) {
    // Save To DB Here
    Date currentDate1 = GregorianCalendar.getInstance().getTime();
    DateFormat df1 = DateFormat.getDateInstance();
    String dateString1 = df1.format(currentDate1);
    Date d1 = new Date();
    SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
    String timeString1 = sdf1.format(d1);
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    String dateString2 = sdf2.format(d1);

    String fann = "";
    
    try {
        String sql0 = "select * from Recipe_Types where WashName = ? and Model = ?";
        pst = conn.prepareStatement(sql0);
        pst.setString(1, recipenami);
        pst.setString(2, modelooo);
        rs = pst.executeQuery();                    
        
        if (rs.next()) {                        
            fann = "found";   
        } else {
            fann = "not_found";   
        }
        
    } catch (Exception exception) {
        exception.printStackTrace(); // Handle exceptions properly
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();     
        } catch (Exception exception) {
            exception.printStackTrace(); // Handle exceptions properly
        }
    }

    if (fann.equals("found")) {
        try {
            String sqlp = "update Recipe_Types set Date = ?, Model = ?, WashName = ?, Rinse = ?, Stone = ?, Foam = ?, Bleach = ?, Enzyme = ?, MoonWash = ?, Dryer_1 = ?, Dryer_2 = ?, Dryer_3 = ? where WashName = ? and Model = ?";
            pst = conn.prepareStatement(sqlp);
            pst.setString(1, dateString2);
            pst.setString(2, modelooo);
            pst.setString(3, recipenami);
            
            pst.setString(4, "RINSE");
            pst.setString(5, stonn);
            pst.setString(6, fomm);
            pst.setString(7, hypoo);
            pst.setString(8, enzymm);
            pst.setString(9, moonn);
            pst.setString(10, dryr11);
            pst.setString(11, dryr22);
            pst.setString(12, dryr33);
            
            pst.setString(13, recipenami); // WHERE clause parameters
            pst.setString(14, modelooo);
            pst.execute();
            
            Notifications noti = Notifications.create();
            noti.title("Successful");
            noti.text("We have updated the types successfully.");
            noti.hideAfter(Duration.seconds(3));
            noti.position(Pos.CENTER);
            noti.showInformation();
            
        } catch (Exception exception) {
            exception.printStackTrace(); // Handle exceptions properly
        } finally {
            try {
                if (pst != null) pst.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    } else if (fann.equals("not_found")) {
        try {                            
            String reg = "insert into Recipe_Types (Date, Model, WashName, Rinse, Stone, Foam, Bleach, Enzyme, MoonWash, Dryer_1, Dryer_2, Dryer_3) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = conn.prepareStatement(reg);
            pst.setString(1, dateString2);
            pst.setString(2, modelooo);
            pst.setString(3, recipenami);
            
            pst.setString(4, "RINSE");
            pst.setString(5, stonn);
            pst.setString(6, fomm);
            pst.setString(7, hypoo);
            pst.setString(8, enzymm);
            pst.setString(9, moonn);
            pst.setString(10, dryr11);
            pst.setString(11, dryr22);
            pst.setString(12, dryr33);
            
            pst.execute(); 
            
            Notifications noti = Notifications.create();
            noti.title("Successful");
            noti.text("We have inserted the new type successfully.");
            noti.hideAfter(Duration.seconds(3));
            noti.position(Pos.CENTER);
            noti.showInformation();
            
        } catch (Exception exception) {
            exception.printStackTrace(); // Handle exceptions properly
        } finally {
            try {
                if (pst != null) pst.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
      
            
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    ////////////////////////////////////////////////////////////////
    if (temp.exists()) {
        temp.delete();
    }
    ////////////////////////////////////////////////////////////////
	
    
}
  
  



  
@FXML
void createrepoaction(ActionEvent event) throws IOException {
    
    
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Reports.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Create Report");
    stg.setResizable(true);
    stg.setMaximized(true);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    
    
}
  
  



@FXML
void showwashtypeaction(ActionEvent event) throws IOException {
    
    
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("ShowTypes.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Recipes Types");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    
    
}
  
  



  
@FXML
void showrecipeprocaction(ActionEvent event) throws IOException {
    
    
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("ShowProcesses.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Recipes Processes");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    
    
}






  
@FXML
void recipeprocaction(ActionEvent event) throws IOException, Exception {
    
        //Open Recipe
        //Pull Data
        //Show Alert
        //Add To List
        //Click Create Button To Create A Recipe
        //Start.................................
        
        
      FileChooser fcho = new FileChooser();
      //fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[]{"*.png"}));
      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("KADYSOFT Files", new String[]{"*.ks"}));
      fcho.setTitle("Kady Choose");
      File f = fcho.showOpenDialog((Window)null);
      String recipenami=f.getName().replace(".ks","").replace(".html",""); 
      String dirpathe = f.getAbsolutePath().toString();
      String didd1=NewDir.file_dir+"\\PRODUCTION\\";
      String didd2="\\"+f.getName();
      String didd3=NewDir.file_dir+"\\PILOT\\";
      String modelooo=dirpathe.replace(didd1,"").replace(didd3,"").replace(didd2,"");
      
      
                ////////////////////////////////////////////////////////////

    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String resulti = KeyDecoder.extractData(longKey.trim());
    if (f == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = f.getAbsolutePath();
    String nameofit=recipenami;
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
 
    FileDecryptor.decrypt(input, tempOutput, resulti);
    File temp = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////
      
      
       ///Decrypt////////////////////////////////////
           try { 
    myarea.clear();
    InputStream inputinstream=new FileInputStream(temp);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    String lo;
    while ((lo=bi.readLine())!=null) {
        myarea.appendText("\n"+lo
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
        }catch (Exception g) {}
        //////////////////////////////////////////////

                            
        
       String stages=null;
       int bathnumzzz=0;
       String modu,comment;
    
        int ds=1;
                            org.jsoup.nodes.Document docy = Jsoup.parse(myarea.getText());
                            for (Element table : docy.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(3).text().contains("/")||tds.get(3).text().contains("\\")||tds.get(3).text().isEmpty()||tds.get(3).text().contains("TEMP")||tds.get(3).text().contains("OPERATOR")||tds.get(3).text().contains("temp")||tds.get(3).text().contains("operator")/*||tds.get(3).text().contains("extract")||tds.get(3).text().contains("EXTRACT")||tds.get(3).text().contains("extraction")||tds.get(3).text().contains("EXTRACTION")*/||tds.get(3).text().matches("[0-9]+")||tds.get(3).text().contains("REMOV")||tds.get(3).text().contains("REMOVE")||tds.get(3).text().contains("BATH")||tds.get(3).text().contains("SAME")||tds.get(3).text().contains("PATH")||tds.get(3).text().contains("SAM")||tds.get(3).text().contains("RPM")||tds.get(3).text().contains("KG")||tds.get(3).text().contains("PCS")||tds.get(3).text().contains("DRAIN")||tds.get(3).text().contains("RIMOV")||tds.get(3).text().contains("RIMOVE")) {}
                            else {
                            String tempo=tds.get(3).text();
                            if (tempo.contains("EXTRACT")||tempo.contains("Extract")||tempo.contains("extract")) {
                               
                                stages=stages+"\n"+"WASHING "+Integer.toString(ds++);
                                
                            }
                            
                            else {
                                
                                stages=stages+"\n"+tempo;
                                
                            }
                            }
                            

                           }}
                            
                            
                            
                            
        String arabicRegex = "[\\u0600-\\u06FF]+";
        Pattern pattern = Pattern.compile(arabicRegex);
        
        Matcher matcher = pattern.matcher(stages + "");
        String modifiedLine = matcher.replaceAll("\n");
        String lone = modifiedLine.replace("null", "\n");
        
        StringBuilder result = new StringBuilder();
        String[] lines = lone.split("\n");
        int nonEmptyCount = 0;
        // Count non-empty lines to handle the last one differently
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                nonEmptyCount++;
            }
        }
        
        int currentNonEmpty = 0;
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                currentNonEmpty++;
                result.append(line);
                // Append " - " only if it's not the last non-empty line
                if (currentNonEmpty < nonEmptyCount) {
                    result.append(" - ");
                }
            }
        }                                   
                            
      procccc=result.toString();                
                            
                            
                            
             
//        String arabicRegex = "[\\u0600-\\u06FF]+";
//        Pattern pattern = Pattern.compile(arabicRegex);
//        
//        Matcher matcher = pattern.matcher(stages+"");
//        String modifiedLine = matcher.replaceAll("\n");
//        String lone=modifiedLine.replace("null","\n");
//        
//        StringBuilder result = new StringBuilder();
//        String[] lines = lone.split("\n");
//        for (String line : lines) {
//            if (!line.trim().isEmpty()) {
//                result.append(line).append("\n");
//                
//            }
//        }
//             
//        procccc=result.toString().replaceAll("\n(?!$)", " - ");
             
            JFXTextArea kk=new JFXTextArea ();
            kk.setStyle("-fx-font-weight:bold;");
            kk.setEditable(true);
            kk.setText(result+"");
            Alert al=new Alert (Alert.AlertType.ERROR);
            al.setTitle("Recipe Viewer");
            al.setHeaderText("Here is your recipe Stages: ");
            al.setContentText("Please edit me if you found errors, iam not a human. Iam a computer\nMy developer is KADINIO.");
            al.setResizable(false);
            al.setGraphic(kk);
            DialogPane dialogPane = al.getDialogPane();
            dialogPane.getStylesheets().add(
          getClass().getResource("cupertino-light.css").toExternalForm());
            al.showAndWait();
            
            System.out.println(procccc);
           
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
    Alert alertd = new Alert(Alert.AlertType.CONFIRMATION);
alertd.setTitle("Save To DB");
alertd.setHeaderText("Processes Result");
alertd.setContentText("Here Is The result of Processes For " + recipenami + " Recipe.");
ButtonType buttonTypeOned = new ButtonType("Save To DB");
ButtonType buttonTypeCanceld = new ButtonType("Cancel");
alertd.getButtonTypes().setAll(buttonTypeOned, buttonTypeCanceld);
DialogPane dialogPaneid = alertd.getDialogPane();
dialogPaneid.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> resultsd = alertd.showAndWait();
if (resultsd.isPresent() && resultsd.get() == buttonTypeOned) {
    // Save To DB Here
    Date currentDate1 = GregorianCalendar.getInstance().getTime();
    DateFormat df1 = DateFormat.getDateInstance();
    String dateString1 = df1.format(currentDate1);
    Date d1 = new Date();
    SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
    String timeString1 = sdf1.format(d1);
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    String dateString2 = sdf2.format(d1);

    String fann = "";
    
    try {
        String sql0 = "select * from Recipe_Processes where WashName = ? and Model = ?";
        pst = conn.prepareStatement(sql0);
        pst.setString(1, recipenami);
        pst.setString(2, modelooo);
        rs = pst.executeQuery();                    
        
        if (rs.next()) {                        
            fann = "found";   
        } else {
            fann = "not_found";   
        }
        
    } catch (Exception exception) {
        exception.printStackTrace(); // Handle exceptions properly
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();     
        } catch (Exception exception) {
            exception.printStackTrace(); // Handle exceptions properly
        }
    }

    if (fann.equals("found")) {
        try {
            String sqlp = "update Recipe_Processes set Date = ?, Model = ?, WashName = ?, Processes = ? where WashName = ? and Model = ?";
            pst = conn.prepareStatement(sqlp);
            pst.setString(1, dateString2);
            pst.setString(2, modelooo);
            pst.setString(3, recipenami);
            pst.setString(4, procccc);
            pst.setString(5, recipenami); // WHERE clause parameters
            pst.setString(6, modelooo);
            pst.execute();
            
            Notifications noti = Notifications.create();
            noti.title("Successful");
            noti.text("We have updated the processes successfully.");
            noti.hideAfter(Duration.seconds(3));
            noti.position(Pos.CENTER);
            noti.showInformation();
            
        } catch (Exception exception) {
            exception.printStackTrace(); // Handle exceptions properly
        } finally {
            try {
                if (pst != null) pst.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    } else if (fann.equals("not_found")) {
        try {                            
            String reg = "insert into Recipe_Processes (Date, Model, WashName, Processes) values (?, ?, ?, ?)";
            pst = conn.prepareStatement(reg);
            pst.setString(1, dateString2);
            pst.setString(2, modelooo);
            pst.setString(3, recipenami);
            pst.setString(4, procccc);
            pst.execute(); 
            
            Notifications noti = Notifications.create();
            noti.title("Successful");
            noti.text("We have inserted the new processes successfully.");
            noti.hideAfter(Duration.seconds(3));
            noti.position(Pos.CENTER);
            noti.showInformation();
            
        } catch (Exception exception) {
            exception.printStackTrace(); // Handle exceptions properly
        } finally {
            try {
                if (pst != null) pst.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
      
            
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
}
  
  
  
  
  
  
  
  @FXML
void recipeplanneraction(ActionEvent event) throws IOException {
    
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Chemical_Planner.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Recipe Planner");
    stg.setResizable(true);
    stg.setMaximized(true);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    
    
}
  
  
  

  
@FXML
void showcostdevac(ActionEvent event) throws IOException {
   
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("RecipeCost_1.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Recipe Cost");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    
    
}
  
  
@FXML
void showcostaction(ActionEvent event) throws IOException {
   
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("RecipeCost.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Recipe Cost");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    
    
}




@FXML
void comparecostaction(ActionEvent event) throws IOException {
    
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("CompareCost.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Compare Cost");
    stg.setResizable(true);
    stg.setMaximized(true);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    
    
}



@FXML
void caldevmulaction(ActionEvent event) throws IOException {
    
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("TimeDevMultiple.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Calculate Development Recipes Multiple");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    
    
}



@FXML
void timedevreportaction(ActionEvent event) throws IOException {
    
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("DevRecipeTime.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Development Time Report");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    
    
}



@FXML
void calculatedev3shots(ActionEvent event) throws IOException   {
    
    try {
            // Create an object of Development_3_4_5_6_Shots
            Development_3_4_5_6_Shots dev = new Development_3_4_5_6_Shots();
            // Call the method
            dev.dev_3_4_5_6_Shots();
        } catch (IOException e) {
            e.printStackTrace();
        }
    
    
}




@FXML
void cal3shoots(ActionEvent event) throws IOException, InterruptedException, Exception  {
    
    Time3Shots t3s=new Time3Shots();
    t3s.cal3shoots();
    
}



@FXML
void calcpilotaction(ActionEvent event) throws IOException, InterruptedException, Exception {
   //////////////////////////////////Start////////gdsgdsgd/////////////////////////////////////////////////////////////////////////////// 
    
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
FileChooser fcho = new FileChooser();
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
fcho.setTitle("Kady Choose");
File f = fcho.showOpenDialog((Window)null);
String recipenami=f.getName().replace(".ks","").replace(".html","");
String recipepathy = f.getAbsolutePath().toString();

 //SHow recipr first here..........

String didd1=NewDir.file_dir+"\\PILOT\\";
String didd2="\\"+f.getName();

String modelooo=recipepathy.replace(didd1,"").replace(didd2,"");


    ////////////////////////////////////////////////////////////

    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String result = KeyDecoder.extractData(longKey.trim());
    if (f == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = f.getAbsolutePath();
    String nameofit=recipenami;
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
 
    FileDecryptor.decrypt(input, tempOutput, result);
    File tempy = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////


//////////////////////////////////////////////////////////////////////////////////////////////////////////
InputStream inputinstream=new FileInputStream(tempy);
BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
String lo;
lili.clear();
while ((lo=bi.readLine())!=null) {    
lili.appendText("\n"+lo
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


	////////////////////////////////////////////////////////////////
    if (tempy.exists()) {
        tempy.delete();
    }
    ////////////////////////////////////////////////////////////////
		


String gf=lili.getText();
OutputStream instreamm=new FileOutputStream(System.getProperty("user.home")+"\\r.ks");
PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
pwe.println(gf);
pwe.close();




   //Get Time And Shots
   
   List<Integer> time = new ArrayList<>();
   List<Integer> timeSum = new ArrayList<>();
   List<String> shots = new ArrayList<>();
   int sum = 0, bathnum=0, firstshot=0, secondshot=0,thirdshot=0,forthshot=0;
   
   File inputFile = new File(System.getProperty("user.home")+"\\r.ks"); //
   org.jsoup.nodes.Document doc = Jsoup.parse(inputFile, "UTF-8"); //
   for (Element table : doc.select("tbody")) {
   for (Element row : table.select("tr")) {
   Elements tds = row.select("td");
   if (tds.get(2).text().isEmpty()||tds.get(2).text().contains("/")||tds.get(2).text().contains("\\")||tds.get(2).text().contains("SPIN")||tds.get(2).text().contains("spin")||tds.get(2).text().contains("TIME")||tds.get(2).text().contains("time")||tds.get(2).text().matches("[a-zA-Z_]+")||tds.get(2).text().contains("PRODUCTION")||tds.get(2).text().contains("RECIPE")||tds.get(2).text().contains("RECIPI")||tds.get(2).text().contains("DATE")||tds.get(2).text().contains("WASH")) {}
   else {
   String stringg=tds.get(2).text().replace(" CONT","").replace(" CONG","").replace("CONG","").replace(" cont","").replace(" CNTRL","").replace(" control","").replace(" CONTROL","").replace(" con","").replace(" CON","").replace(" CNTRL","").replace(" KONTROL","").replace("CONT","").replace("cont","").replace("CNTRL","").replace("control","").replace("CONTROL","").replace("con","").replace("CON","").replace("CNTRL","").replace("KONTROL","");
   
   if (stringg.contains("+")) {
   String sum1 = stringg;
   String[] numbers1 = sum1.split("\\+");
   int total1 = 0;
   for (String numStr1 : numbers1) {
   total1 += Integer.parseInt(numStr1);
   }
   time.add(total1);
   }
   
   else {
   int ioo=Integer.parseInt(stringg);
   time.add(ioo);     
   }
   }
                              
                            String dalil=tds.get(3).text();
                            if (dalil.contains("EXTRACT")||dalil.contains("extract")||dalil.contains("Extract")||dalil.contains("EXTRA")||dalil.contains("EXTRACTION")||dalil.contains("extraction")) {
                            for (int i = 0; i < time.size(); i++)
                            sum += time.get(i);
                            timeSum.add(sum);
                            time.clear();
                            shots.add(dalil);}else {
                            
                        
                            
                            }}}
                          bathnum=shots.size();
                          if (shots.size()==1) {
                          firstshot=timeSum.get(0);}
                          else if (shots.size()==2) {
                          firstshot=timeSum.get(0);
                          secondshot=timeSum.get(1)-timeSum.get(0);}
                          else {
                          
                       
                          
                          }
                          
                          

                          
   
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Get Temp
   
   try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Timer_Temp.kady"));
      
      timer_temprature=buf.readLine();
      
      buf.close();
      } catch (FileNotFoundException fileNotFoundException) {
      } catch (IOException iOException) {}
   
                            int temp=0;
                            int temp2=0;
                            int temp3=0;
                            String timer_tempra=timer_temprature;
                            int timer_temp=Integer.parseInt(timer_tempra);
                            
                          
                            org.jsoup.nodes.Document docy = Jsoup.parse(inputFile, "UTF-8"); //      
                            for (Element table : docy.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(3).text().contains("/")||tds.get(3).text().contains("\\")||tds.get(3).text().isEmpty()||tds.get(3).text().contains("TEMP")||tds.get(3).text().contains("OPERATOR")||tds.get(3).text().contains("temp")||tds.get(3).text().contains("operator")) {}
                            else {
                                
                            String tempo=tds.get(3).text();
                            
                            if (tempo.contains("EXTRACT")) {
                                
                                String pattern = "[a-zA-Z_ _&_.]+";
                                tempo = tempo.replaceAll(pattern, "");
                                if (tempo.matches("[0-9]+")) {
                                int cvd2=Integer.parseInt(tempo); 
                                if (cvd2>timer_temp) { 
                                temp2+=1;
                                }
                                else {
                                }}break;
                             }
                            
                            else {
                           
                                String pattern = "[a-zA-Z_ _&_.]+";  
                                tempo = tempo.replaceAll(pattern, "");
                                if (tempo.matches("[0-9]+")) {
                                int cvd=Integer.parseInt(tempo); 
                                if (cvd>timer_temp) { 
                                temp+=1;
                                }else {}}
                                
                            }}}}
                            
                            int tempall=0;
                            org.jsoup.nodes.Document docc = Jsoup.parse(inputFile, "UTF-8"); // 
                            for (Element table : docc.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(3).text().contains("/")||tds.get(3).text().contains("\\")||tds.get(3).text().isEmpty()||tds.get(3).text().contains("TEMP")||tds.get(3).text().contains("OPERATOR")||tds.get(3).text().contains("temp")||tds.get(3).text().contains("operator")) {}
                            else {
                                String tempo=tds.get(3).text();
                                String pattern = "[a-zA-Z_ _&_.]+";
                                tempo = tempo.replaceAll(pattern, "");
                                if (tempo.matches("[0-9]+")) {
                                int cvd=Integer.parseInt(tempo); 
                                if (cvd>timer_temp) { 
                                tempall+=1;}
                                else {}}else {}}}}
                            
                            
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Get Stone Bath   
   
                            int stonebathh=0;
                            org.jsoup.nodes.Document doccc = Jsoup.parse(inputFile, "UTF-8"); // 
                            for (Element table : doccc.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(7).text().isEmpty()||tds.get(7).text().contains("/")||tds.get(7).text().contains("\\")||tds.get(7).text().contains("CHEMICAL")||tds.get(7).text().contains("chemical")||tds.get(7).text().matches("[0-9_-]+")) {}
                            else {
                            String erw=tds.get(7).text().toString();
                            if (erw.contains("STONE")||erw.contains("STON")||erw.contains("BOOL")||erw.contains("FOAM")||erw.contains("BOLL"))  {
                            stonebathh+=1;  
                            }else {}}}}
   
                            
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //Get Water Bath  
    
    
                            
        
                            int waterbath=0;
                            int waterbath2=0;
                            org.jsoup.nodes.Document docu = Jsoup.parse(inputFile, "UTF-8"); // 
                            for (Element table : docu.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            
                            if (tds.get(4).text().contains("'")||tds.get(4).text().contains("DRYER")||tds.get(4).text().contains("LITER")||tds.get(4).text().matches("[a-zA-Z_]+")) {}
                            else {
                                
                            String tempo=tds.get(3).text();
                            
                            if (tempo.contains("EXTRACT")) {
                                if (tds.get(4).text().matches("[0-9]+")) {
                                int cvd2=Integer.parseInt(tds.get(4).text()); 
                                waterbath2+=1;
                                
                                }
                                
                                break;
                                
                            }
                            
                            
                            else {
                           
                                if (tds.get(4).text().matches("[0-9]+")) {
                                int cvd=Integer.parseInt(tds.get(4).text()); 
                               
                                waterbath+=1;
                                
                                }
                                
                            }
                            
                           }}}
                            
        
        
        
                            int waterbathall=0;
                            org.jsoup.nodes.Document dock = Jsoup.parse(inputFile, "UTF-8"); // 
                            for (Element table : dock.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(4).text().isEmpty()||tds.get(4).text().contains("'")||tds.get(4).text().contains("DRYER")||tds.get(4).text().contains("LITER")||tds.get(4).text().matches("[a-zA-Z_]+")) {}
                            else { 
                            String erw=tds.get(4).text().toString();
                            waterbathall+=1;
                            }}}
        
                            
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Read Vars From File  
   
    try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Timer.kady"));
      
      lproduct=buf.readLine().replace("Load_Product=","");
      rproduct=buf.readLine().replace("Remove_Product=","");
      tempraturee=buf.readLine().replace("Temprature=","");
      ftank=buf.readLine().replace("Fill_Tank=","");
      etank=buf.readLine().replace("Empty_Tank=","");
      cdosage =buf.readLine().replace("Chemical_Dosage=","");
      
      buf.close();
      } catch (FileNotFoundException fileNotFoundException) {
      } catch (IOException iOException) {}
   
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    String lproductt=lproduct;
    String rproductt=rproduct;
    String tempratureee=tempraturee;
    String ftankk=ftank;
    String etankk=etank;
    String cdosagee=cdosage;
    
    int bathnumm=bathnum;
    
    bosbos=bathnum;
    
    double firstshott=firstshot;
    double secondshott=secondshot;
    
    int tempp=temp;
    int tempp2=tempall-temp;
    int temppall=tempall;
    
    int waterbathx=waterbath;
    int waterbath2x=waterbathall-waterbath;
    int waterbathallx=waterbathall;
    
    int stonebathhh=stonebathh;
    
    loadremoveproduct=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
    tempraturetime=tempp*Double.parseDouble(tempratureee);
    chemicaldosage=Double.parseDouble(cdosagee);
    fillemptytank=waterbathx*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
    
    loadremoveproduct2=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
    tempraturetime2=tempp2*Double.parseDouble(tempratureee);
    chemicaldosage2=Double.parseDouble(cdosagee);
    fillemptytank2=waterbath2x*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
    
    loadremoveproductall=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
    tempraturetimeall=temppall*Double.parseDouble(tempratureee);
    chemicaldosageall=Double.parseDouble(cdosagee);
    fillemptytankall=waterbathallx*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
    
    //Alert for Bath Here
    
    
    
    if (bathnumm==1) {
        
        
        
        
        
             
        ////////////////////////////////SSS///////////////////////////////////////
          
        String wsa=recipepathy;
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
      String pathy = recipepathy.replace("\\","\\\\").replace("Z:","X:").replace("X:","X:").replace("V:","X:").replace("W:","X:");
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
            
          
          
             ////////////////////////////////////////////////////////////

    String longKeyj;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKeyj = cxsd.readLine();
    }
    if (longKeyj == null || longKeyj.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String resultj = KeyDecoder.extractData(longKeyj.trim());
    if (pathy == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String inputj = pathy;
    String nameofitj=Paths.get(pathy).getFileName().toString();
    String tempOutputj = System.getProperty("user.home")+"\\"+nameofitj;
 
    FileDecryptor.decrypt(inputj, tempOutputj, resultj);
    File tempj = new File(tempOutputj);
    
    //////////////////////////////////////////////////////////// 
          
          
    lili.clear();
    InputStream inputinstreame=new FileInputStream(tempj);
    BufferedReader bie=new BufferedReader (new InputStreamReader (inputinstreame,"UTF-8"));
    String loe;
    while ((loe=bie.readLine())!=null) {
        
        lili.appendText("\n"+loe
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
    bie.close();
    String gfe=lili.getText();
    OutputStream instreamme=new FileOutputStream(tw2o);
    PrintWriter pwee = new PrintWriter(new OutputStreamWriter (instreamme,"UTF-8"));
    pwee.println(gfe);
    pwee.println("<style>\n" +
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
    pwee.close();
    lili.clear();
    
    	////////////////////////////////////////////////////////////////
    if (tempj.exists()) {
        tempj.delete();
    }
    ////////////////////////////////////////////////////////////////
		
    
    
      }    
    }   
      
      WebView webviewt=new WebView ();
      webviewt.setContextMenuEnabled(false);
      webviewt.setMinSize(1800, 800);
      String lkd=System.getProperty("user.home")+"\\Hehehe\\Roro.html";
      URI uris = Paths.get(lkd).toAbsolutePath().toUri();
      webviewt.getEngine().load(uris.toString());  
      Thread.sleep(3000);
      File tw2ooo=new File (System.getProperty("user.home")+"\\Hehehe\\Roro.html");
      tw2ooo.delete();
      JFXTextField fss=new JFXTextField ("");
      fss.setPromptText("Write Stone Baths Number");
      fss.setMinSize(300, 30);
      fss.setLabelFloat(true);
      fss.setStyle("-fx-font-weight:bold;");
      fss.setEditable(true);
      VBox vduu=new VBox ();
      vduu.setSpacing(30);
      vduu.setMinSize(1850,850);
      vduu.getChildren().addAll(webviewt,fss);
      Alert alerto = new Alert(Alert.AlertType.INFORMATION);
      alerto.setTitle("Stone Bath?");
      alerto.setHeaderText("We found stone or foam "+stonebathhh+" times. but 1 shot.");
      //alerto.setHeaderText("We found stone or foam "+stonebathhh+" times. for the first shot.");
      
      alerto.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alerto.setGraphic(vduu);
      
      ////////////////////////////////EEE///////////////////////////////////////
      
        
        
        
        
        
        
//      JFXTextField fss=new JFXTextField ("");
//      fss.setPromptText("Write Stone Baths Number");
//      fss.setMinSize(300, 30);
//      fss.setLabelFloat(true);
//      fss.setStyle("-fx-font-weight:bold;");
//      fss.setEditable(true);
//      Alert alerto = new Alert(Alert.AlertType.INFORMATION);
//      alerto.setTitle("Stone Bath?");
//      alerto.setHeaderText("We found stone or foam "+stonebathhh+" times. but 1 shot.");
//      alerto.setContentText("Hello, Please tell me: Stone Baths Number?.");
//      alerto.setGraphic(fss);
//      alerto.setResizable(false);
      DialogPane dialogPaneo = alerto.getDialogPane();
      dialogPaneo.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optiono = alerto.showAndWait();
      passy=fss.getText();
      stonabathth=Double.parseDouble(passy);
      if (optiono.get() == null) {} 
      else if (optiono.get() == ButtonType.OK) {
          
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabathth==0) {
          loadstone=0;
          removestone=0;
          cleaningstone=0;
          extraction=0;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
      }
      else if (stonabathth==1){
          
          loadstone=5.5;
          removestone=4.15;
          cleaningstone=15;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
      }
      
      
      else if (stonabathth==2){
          
          
          loadstone=16.5;
          removestone=8.3;
          cleaningstone=20;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
          
      }
      
      
      else {
          double v=stonabathth;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone=v2;
          removestone=v1;
          cleaningstone=0;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
      
      else if (optiono.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
        
    }
    
    else if (bathnumm==2) {
        
        
               
        ////////////////////////////////SSS///////////////////////////////////////
          
        String wsa=recipepathy;
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
      String pathy = recipepathy.replace("\\","\\\\").replace("Z:","X:").replace("X:","X:").replace("V:","X:").replace("W:","X:");
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
              
          
    ////////////////////////////////////////////////////////////

    String longKeyj;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKeyj = cxsd.readLine();
    }
    if (longKeyj == null || longKeyj.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String resultj = KeyDecoder.extractData(longKeyj.trim());
    if (pathy == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String inputj = pathy;
    String nameofitj=Paths.get(pathy).getFileName().toString();
    String tempOutputj = System.getProperty("user.home")+"\\"+nameofitj;
 
    FileDecryptor.decrypt(inputj, tempOutputj, resultj);
    File tempj = new File(tempOutputj);
    
    ////////////////////////////////////////////////////////////
          
          
    lili.clear();
    InputStream inputinstreame=new FileInputStream(tempj);
    BufferedReader bie=new BufferedReader (new InputStreamReader (inputinstreame,"UTF-8"));
    String loe;
    while ((loe=bie.readLine())!=null) {
        
        lili.appendText("\n"+loe
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
    bie.close();
    String gfe=lili.getText();
    OutputStream instreamme=new FileOutputStream(tw2o);
    PrintWriter pwee = new PrintWriter(new OutputStreamWriter (instreamme,"UTF-8"));
    pwee.println(gfe);
    pwee.println("<style>\n" +
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
    pwee.close();
    lili.clear();
    
    
	
    ////////////////////////////////////////////////////////////////
    if (tempj.exists()) {
        tempj.delete();
    }
    ////////////////////////////////////////////////////////////////
	
    
    
      }    
    }   
      
      WebView webviewt=new WebView ();
      webviewt.setContextMenuEnabled(false);
      webviewt.setMinSize(1800, 800);
      String lkd=System.getProperty("user.home")+"\\Hehehe\\Roro.html";
      URI uris = Paths.get(lkd).toAbsolutePath().toUri();
      webviewt.getEngine().load(uris.toString());  
      Thread.sleep(3000);
      File tw2ooo=new File (System.getProperty("user.home")+"\\Hehehe\\Roro.html");
      tw2ooo.delete();
      JFXTextField fss=new JFXTextField ("");
      fss.setPromptText("Write Stone Baths Number");
      fss.setMinSize(300, 30);
      fss.setLabelFloat(true);
      fss.setStyle("-fx-font-weight:bold;");
      fss.setEditable(true);
      VBox vduu=new VBox ();
      vduu.setSpacing(30);
      vduu.setMinSize(1850,850);
      vduu.getChildren().addAll(webviewt,fss);
      Alert alerto = new Alert(Alert.AlertType.INFORMATION);
      alerto.setTitle("Stone Bath?");
      //alerto.setHeaderText("We found stone or foam "+stonebathhh+" times. but 1 shot.");
      alerto.setHeaderText("We found stone or foam "+stonebathhh+" times. for the first shot.");
      
      alerto.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alerto.setGraphic(vduu);
      
      ////////////////////////////////EEE///////////////////////////////////////
      
        
        
//      JFXTextField fss=new JFXTextField ("");
//      fss.setPromptText("Write Stone Baths Number");
//      fss.setMinSize(300, 30);
//      fss.setLabelFloat(true);
//      fss.setStyle("-fx-font-weight:bold;");
//      fss.setEditable(true);
//      Alert alerto = new Alert(Alert.AlertType.INFORMATION);
//      alerto.setTitle("Stone Bath?");
//      alerto.setHeaderText("We found stone or foam "+stonebathhh+" times. for the first shot.");
//      alerto.setContentText("Hello, Please tell me: Stone Baths Number?.");
//      alerto.setGraphic(fss);
//      alerto.setResizable(false);
      DialogPane dialogPaneo = alerto.getDialogPane();
      dialogPaneo.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optiono = alerto.showAndWait();
      passy=fss.getText();
      stonabathth=Double.parseDouble(passy);
      if (optiono.get() == null) {} 
      else if (optiono.get() == ButtonType.OK) {
          
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabathth==0) {
          loadstone=0;
          removestone=0;
          cleaningstone=0;
          extraction=0;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
      }
      else if (stonabathth==1){
          
          loadstone=5.5;
          removestone=4.15;
          cleaningstone=15;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
      }
      
      
      else if (stonabathth==2){
          
          
          loadstone=16.5;
          removestone=8.3;
          cleaningstone=20;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
          
      }
      
      
      else {
          double v=stonabathth;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone=v2;
          removestone=v1;
          cleaningstone=0;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
      
      else if (optiono.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
      ///////////yrtyrty///////////
      
      JFXTextField fsss=new JFXTextField ("");
      fsss.setPromptText("Write Stone Baths Number");
      fsss.setMinSize(300, 30);
      fsss.setLabelFloat(true);
      fsss.setStyle("-fx-font-weight:bold;");
      fsss.setEditable(true);
      Alert alertoo = new Alert(Alert.AlertType.INFORMATION);
      alertoo.setTitle("Stone Bath?");
      alertoo.setHeaderText("We found stone or foam "+stonebathhh+" times. for the second shot.");
      alertoo.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alertoo.setGraphic(fsss);
      alertoo.setResizable(false);
      DialogPane dialogPaneoo = alertoo.getDialogPane();
      dialogPaneoo.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optionoio = alertoo.showAndWait();
      passyy=fsss.getText();
      stonabaththh=Double.parseDouble(passyy);
      if (optionoio.get() == null) {} 
      else if (optionoio.get() == ButtonType.OK) {
         
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabaththh==0) {
          loadstone2=0;
          removestone2=0;
          cleaningstone2=0;
          extraction2=0;
          double dos3=loadstone2+removestone2;
          loadremovestone2=dos3;
          
      }
      else if (stonabaththh==1){
          
          loadstone2=5.5;
          removestone2=4.15;
          cleaningstone2=15;
          extraction2=20;
          double dos3=loadstone2+removestone2;
          loadremovestone2=dos3;
          
      }
      
      
      else if (stonabaththh==2){
          
          
          loadstone2=16.5;
          removestone2=8.3;
          cleaningstone2=20;
          extraction2=20;
          double dos3=loadstone2+removestone2;
          loadremovestone2=dos3;
          
          
      }
      
      
      else {
          double v=stonabaththh;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone2=v2;
          removestone2=v1;
          cleaningstone2=0;
          extraction2=20;
          double dos3=loadstone2+removestone2;
          loadremovestone2=dos3;
          
          
      }
      

          
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
      
      else if (optionoio.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
        
    }
    
     
    
    
    /////////////////////////////////////////////Starting//////////////////////////////////////////////////////////
    
    
    if (bathnumm==1) {
        
        gmf1=stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank;
        
        gdf1=(stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank)/60.0;
        
        //Write to recipe here //////////////////////////////////////////////////////////
        
Alert aloo = new Alert(Alert.AlertType.INFORMATION);
aloo.setTitle("Show Time");
aloo.setResizable(false);
aloo.setHeaderText("Here is time for "+recipenami+" of "+modelooo+" Customer.");
aloo.setContentText("This Recipe Was One Shot:\nTime In Minutes=   "+gmf1+"."+"\nTime In Hours=   "+gdf1+".");
DialogPane dialogPanej = aloo.getDialogPane();
dialogPanej.getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
aloo.showAndWait();
        
      /////////////////////////////////////////////////////////////////////////////////////////
      
//      
//Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//alert.setTitle("Save To DB");
//alert.setHeaderText("Time Result");
//alert.setContentText("Here Is The result of Time For "+recipenami+" Recipe.");
//ButtonType buttonTypeOne = new ButtonType("Save To DB");
//ButtonType buttonTypeCancel = new ButtonType("Cancel");
//alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
//DialogPane dialogPanei = alert.getDialogPane();
//dialogPanei.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
//Optional<ButtonType> results = alert.showAndWait();
//if (results.isPresent() && results.get() == buttonTypeOne) {
//Save To DB.

  
      
      //////////////////////////////////////////////////
  //Here Will Write To DB...........................
  
      
      Date currentDate1 = GregorianCalendar.getInstance().getTime();
      DateFormat df1 = DateFormat.getDateInstance();
      String dateString1 = df1.format(currentDate1);
      Date d1 = new Date();
      SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
      String timeString1 = sdf1.format(d1);
      SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
      String timeString2 = sdf2.format(d1);
      String datevaluey = timeString2;                                                          //Date
      
      shoty=1;
      

       try {
           
                    String sql0 = "select * from Timer_Pilot where Name like '" + recipenami + "' and Model like '" + modelooo + "' ";
                    pst = conn.prepareStatement(sql0);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                    //Update
                       
                       wifi="found";
                       
                   ///////    
                       
                    }
                    
    ///////////////////////////////////////////////////////////////////////////////////                
                    
                    
                    else {
                        
                       //Insert
                       
                   wifi="not_found";
                  
      //////////////////////////////////////////                  
                        

                    }
      
                    
    }
        
        catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    } 
     
       
       
       
       
     String fifi=wifi;
     
     
     if (fifi.equals("found")) {
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
                             
                          if (bosbos==1) {
                              
                           String ti1,ti2;
                           String ti3,ti4;
                           ti4=Integer.toString(shoty+1);
                           ti3=Integer.toString(shoty);
                           ti1=Double.toString(gdf1);
                           ti2=Double.toString(gdf2);
                           String mi1=Double.toString(gmf1);
                           String mi2=Double.toString(gmf2);
                           
                                 try {
       
                                     
                                                 
     // String sqlm = "select * from Timer_Pilot where Name=?";
     // pst = conn.prepareStatement(sqlm);
     // pst.setString(1, recipenami);
     // rs = pst.executeQuery();
      
     // String add1 = rs.getString("Time_In_Min");
     // oldtimemin=add1;  //OLD TIME IN MINUTES.
      
     // String add2 = rs.getString("Time_In_Hour");
     // oldtimehour=add2;  //OLD TIME IN HOUR.
      
      
             
                                     
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();
                                     
     
                
                
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti = Notifications.create();
      noti.title("Update!");
      noti.text("We Updated Record Successfully!");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
                       if (bosbos==2) {
                           
                               
                           String ti1,ti2;
                           String ti3,ti4;
                           ti4=Integer.toString(shoty+1);
                           ti3=Integer.toString(shoty);
                           ti1=Double.toString(gdf1);
                           ti2=Double.toString(gdf2);
                           String mi1=Double.toString(gmf1);
                           String mi2=Double.toString(gmf2);
                           
                           
                              try {
                                  
                                  
//      String sqlm = "select * from Timer_Pilot where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, ti3);
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour=add2;  //OLD TIME IN HOUR.
      
   //   pst.execute();
                            
         
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();    
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti = Notifications.create();
      noti.title("Update!");
      noti.text("We Updated Record 1 Successfully!");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
        
      
      } catch (Exception exception) {}
    }    
                           
                              
                                 try {
                            
                                    
//      String sqlm = "select * from Timer where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, filenammm);
//      pst.setString(2, ti4);
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin2=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour2=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi2+"', Time_In_Hour='"+ti2+"' where Name='"+recipenami+"' and Shot='"+ti4+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();         
                                     
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti = Notifications.create();
      noti.title("Update!");
      noti.text("We Updated Record 2 Successfully!");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
        
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
         


         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
     }
       
       
     else if (fifi.equals("not_found")) {
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
         
                       if (bosbos==1) {
                           
                           
                                 try {
                            
          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti = Notifications.create();
      noti.title("Insert!");
      noti.text("We Inserted Record Successfully!");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
                       if (bosbos==2) {
                           
                              try {
                            
          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti = Notifications.create();
      noti.title("Insert!");
      noti.text("We Inserted Record 1 Successfully!");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      
      } catch (Exception exception) {}
    }    
                           
                              
                                 try {
                            
          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti = Notifications.create();
      noti.title("Insert!");
      noti.text("We Inserted Record 2 Successfully!");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
        
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
        
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
     }
       
     
     else {}
       
       
      
      
      
      
      
      
      
      
      
      ////////////////////////////////END DB////////////////////////////////////////////////////
        
      

//} 
//else {}
      
      
      
    
      
    }
    
    else if (bathnumm==2) {
        
        gmf1=stonabathth+firstshott+loadremoveproduct1+loadremovestone+tempraturetime1+extraction+chemicaldosage1+fillemptytank1;
        
        gdf1=(stonabathth+firstshott+loadremoveproduct1+loadremovestone+tempraturetime1+extraction+chemicaldosage1+fillemptytank1)/60.0;
        
        gmf2=stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2;
        
        gdf2=(stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2)/60.0;
        
        
          //Write to recipe here //////////////////////////////////////////////////////////
          
          
          
Alert aloo = new Alert(Alert.AlertType.INFORMATION);
aloo.setTitle("Show Time");
aloo.setResizable(false);
aloo.setHeaderText("Here is time for "+recipenami+" of "+modelooo+" Customer.");
aloo.setContentText("This Recipe Was Two Shots:\nFirst Shot Info:\nTime In Minutes=   "+gmf1+"."+"\nTime In Hours=   "+gdf1+".\n\n"+"Second Shot Info:\nTime In Minutes=   "+gmf2+"."+"\nTime In Hours=   "+gdf2+".\n\n");
DialogPane dialogPanej = aloo.getDialogPane();
dialogPanej.getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
aloo.showAndWait();
       
        /////////////////////////////////////////////////////////////////////////////////
        
        
//Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//alert.setTitle("Save To DB");
//alert.setHeaderText("Time Result");
//alert.setContentText("Here Is The result of Time For "+recipenami+" Recipe.");
//ButtonType buttonTypeOne = new ButtonType("Save To DB");
//ButtonType buttonTypeCancel = new ButtonType("Cancel");
//alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
//DialogPane dialogPanei = alert.getDialogPane();
//dialogPanei.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
//Optional<ButtonType> results = alert.showAndWait();
//if (results.isPresent() && results.get() == buttonTypeOne) {
////Save To DB.

          
      //////////////////////////////////////////////////
  //Here Will Write To DB...........................
  
      
      Date currentDate1 = GregorianCalendar.getInstance().getTime();
      DateFormat df1 = DateFormat.getDateInstance();
      String dateString1 = df1.format(currentDate1);
      Date d1 = new Date();
      SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
      String timeString1 = sdf1.format(d1);
      SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
      String timeString2 = sdf2.format(d1);
      String datevaluey = timeString2;                                                          //Date
      
      shoty=1;
      

       try {
           
                    String sql0 = "select * from Timer_Pilot where Name like '" + recipenami + "' and Model like '" + modelooo + "' ";
                    pst = conn.prepareStatement(sql0);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                    //Update
                       
                       wifi="found";
                       
                   ///////    
                       
                    }
                    
    ///////////////////////////////////////////////////////////////////////////////////                
                    
                    
                    else {
                        
                       //Insert
                       
                   wifi="not_found";
                  
      //////////////////////////////////////////                  
                        

                    }
      
                    
    }
        
        catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    } 
     
       
       
       
       
     String fifi=wifi;
     
     
     if (fifi.equals("found")) {
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
                             
                          if (bosbos==1) {
                              
                           String ti1,ti2;
                           String ti3,ti4;
                           ti4=Integer.toString(shoty+1);
                           ti3=Integer.toString(shoty);
                           ti1=Double.toString(gdf1);
                           ti2=Double.toString(gdf2);
                           String mi1=Double.toString(gmf1);
                           String mi2=Double.toString(gmf2);
                           
                                 try {
       
                                     
                                                 
//      String sqlm = "select * from Timer where Name=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour=add2;  //OLD TIME IN HOUR.
      
      
             
                                     
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();
                                     
     
                
                
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
                       if (bosbos==2) {
                           
                               
                           String ti1,ti2;
                           String ti3,ti4;
                           ti4=Integer.toString(shoty+1);
                           ti3=Integer.toString(shoty);
                           ti1=Double.toString(gdf1);
                           ti2=Double.toString(gdf2);
                           String mi1=Double.toString(gmf1);
                           String mi2=Double.toString(gmf2);
                           
                           
                              try {
                                  
                                  
//      String sqlm = "select * from Timer where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, ti3);
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour=add2;  //OLD TIME IN HOUR.
      
   //   pst.execute();
                            
         
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();    
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                              
                                 try {
                            
                                    
//      String sqlm = "select * from Timer where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, filenammm);
//      pst.setString(2, ti4);
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin2=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour2=add2;  //OLD TIME IN HOUR.
//      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi2+"', Time_In_Hour='"+ti2+"' where Name='"+recipenami+"' and Shot='"+ti4+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();         
                                     
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
         


         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
     }
       
       
     else if (fifi.equals("not_found")) {
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
         
                       if (bosbos==1) {
                           
                           
                                 try {
                            
          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
                       if (bosbos==2) {
                           
                              try {
                            
          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                              
                                 try {
                            
          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
        
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
     }
       
     
     else {}
       
       
      
      ////////////////////////////////END DB////////////////////////////////////////////////////
       

//} 
//else {}
        
        
  
        //////////////////////////////////////////////////////////////////////////////////
        
    }
    
    
    else {
        
        //Noti
        
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, We don't have 3 shots in one recipe.\nWe are working on this feature");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showError();
    }
    
    
    /////////////////////////////////////////////Ending////////////////////////////////////////////////////////////
   
   	

	
	
    ///////////////////////////////////Fuck End//////////////////////////////////////////////////////////////////////////////////////////
}








//2 shots time for development

@FXML
void calculatedevaction(ActionEvent event) throws IOException {
       
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
FileChooser fcho = new FileChooser();
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
fcho.setTitle("Kady Choose");
File f = fcho.showOpenDialog((Window)null);
String recipenami=f.getName().replace(".ks","").replace(".html","");
String recipepathy = f.getAbsolutePath().toString();


String didd1=NewDir.file_dir+"\\DEVELOPMENT\\";
String didd2="\\"+f.getName();



String modelooo=recipepathy.replace(didd1,"").replace(didd2,"");
//////////////////////////////////////////////////////////////////////////////////////////////////////////
InputStream inputinstream=new FileInputStream(recipepathy);
BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
String lo;
lili.clear();
while ((lo=bi.readLine())!=null) {       
lili.appendText("\n"+lo
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
String gf=lili.getText();
OutputStream instreamm=new FileOutputStream(System.getProperty("user.home")+"\\r.ks");
PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
pwe.println(gf);
pwe.close();

//System.out.println(gf);


   //Get Time And Shots
   
   List<Integer> time = new ArrayList<>();
   List<Integer> timeSum = new ArrayList<>();
   List<String> shots = new ArrayList<>();
   int sum = 0, bathnum=0, firstshot=0, secondshot=0,thirdshot=0,forthshot=0;
   
   File inputFile = new File(System.getProperty("user.home")+"\\r.ks"); //
   org.jsoup.nodes.Document doc = Jsoup.parse(inputFile, "UTF-8"); //
   for (Element table : doc.select("tbody")) {
   for (Element row : table.select("tr")) {
   Elements tds = row.select("td");
   if ( tds.get(2).text().contains(":")||tds.get(2).text().contains("-")||tds.get(2).text().contains("_")||   tds.get(2).text().contains("'")||tds.get(2).text().contains(".")||tds.get(2).text().equals("E")||tds.get(2).text().equals("e")||tds.get(2).text().isEmpty()||tds.get(2).text().contains("/")||tds.get(2).text().contains("\\")||tds.get(2).text().contains("\\\\")||tds.get(2).text().contains("SPIN")||tds.get(2).text().contains("spin")||tds.get(2).text().contains("TIME")||tds.get(2).text().contains("time")||tds.get(2).text().matches("[a-zA-Z_ _&_.]+")||tds.get(2).text().matches("^(?=.*[a-zA-Z])(?=.*\\d).*$")||tds.get(2).text().contains("PRODUCTION")||tds.get(2).text().contains("RECIPE")||tds.get(2).text().contains("RECIPI")||tds.get(2).text().contains("DATE")||tds.get(2).text().contains("WASH")) {}
   else {
   String stringg=tds.get(2).text().replace(" CONT","").replace(" CONG","").replace("CONG","").replace(" cont","").replace(" CNTRL","").replace(" control","").replace(" CONTROL","").replace(" con","").replace(" CON","").replace(" CNTRL","").replace(" KONTROL","");
   
   if (stringg.contains("+")) {
   String sum1 = stringg;
   String[] numbers1 = sum1.split("\\+");
   int total1 = 0;
   for (String numStr1 : numbers1) {
   total1 += Integer.parseInt(numStr1);
   }
   time.add(total1);
   //System.out.println(total1);
   }
   
   else {
   int ioo=Integer.parseInt(stringg);
   time.add(ioo); 
   //System.out.println(ioo);
   }
   }
                              
                            String dalil=tds.get(3).text();
                            if (dalil.contains("EXTRACT")||dalil.contains("extract")||dalil.contains("Extract")||dalil.contains("EXTRA")||dalil.contains("EXTRACTION")||dalil.contains("extraction")) {
                            for (int i = 0; i < time.size(); i++)
                            sum += time.get(i);
                            timeSum.add(sum);
                            time.clear();
                            shots.add(dalil);}else {
                            
                        
                            
                            }}}
                          bathnum=shots.size();
                          if (shots.size()==1) {
                          firstshot=timeSum.get(0);}
                          else if (shots.size()==2) {
                          firstshot=timeSum.get(0);
                          secondshot=timeSum.get(1)-timeSum.get(0);}
                          else {
                          
                       
                          
                          }
                          
//                          
// System.out.println();
// System.out.println();
// System.out.println(shots.size());
//                          
//   
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Get Temp
   
   try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Timer_Temp.kady"));
      
      timer_temprature=buf.readLine();
      
      buf.close();
      } catch (FileNotFoundException fileNotFoundException) {
      } catch (IOException iOException) {}
   
                            int temp=0;
                            int temp2=0;
                            int temp3=0;
                            String timer_tempra=timer_temprature;
                            int timer_temp=Integer.parseInt(timer_tempra);
                            
                          
                            org.jsoup.nodes.Document docy = Jsoup.parse(inputFile, "UTF-8"); //      
                            for (Element table : docy.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(3).text().contains("'")||tds.get(3).text().contains("OF")||tds.get(3).text().contains("of")||tds.get(3).text().matches("[a-zA-Z_ _&_.]+")||tds.get(3).text().matches("^(?=.*[a-zA-Z])(?=.*\\d).*$")||tds.get(3).text().contains("/")||tds.get(3).text().contains("\\")||tds.get(3).text().isEmpty()||tds.get(3).text().contains("TEMP")||tds.get(3).text().contains("OPERATOR")||tds.get(3).text().contains("temp")||tds.get(3).text().contains("operator")) {}
                            else {
                                
                            String tempo=tds.get(3).text();
                            
                            if (tempo.contains("EXTRACT")) {
                                
                                String pattern = "[a-zA-Z_ _&_.]+";
                                tempo = tempo.replaceAll(pattern, "");
                                if (tempo.matches("[0-9]+")) {
                                int cvd2=Integer.parseInt(tempo); 
                                if (cvd2>timer_temp) { 
                                temp2+=1;
                                //System.out.println(temp2);
                                }
                                else {
                                }}break;
                             }
                            
                            else {
                           
                                String pattern = "[a-zA-Z_ _&_.]+";  
                                tempo = tempo.replaceAll(pattern, "");
                                if (tempo.matches("[0-9]+")) {
                                int cvd=Integer.parseInt(tempo); 
                                if (cvd>timer_temp) { 
                                temp+=1;
                                //System.out.println(temp);
                                }else {}}
                                
                            }}}}
                            
                            int tempall=0;
                            org.jsoup.nodes.Document docc = Jsoup.parse(inputFile, "UTF-8"); // 
                            for (Element table : docc.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(3).text().contains("'")||tds.get(3).text().contains("OF")||tds.get(3).text().contains("of")||tds.get(3).text().matches("[a-zA-Z_ _&_.]+")||tds.get(3).text().matches("^(?=.*[a-zA-Z])(?=.*\\d).*$")||tds.get(3).text().contains("/")||tds.get(3).text().contains("\\")||tds.get(3).text().isEmpty()||tds.get(3).text().contains("TEMP")||tds.get(3).text().contains("OPERATOR")||tds.get(3).text().contains("temp")||tds.get(3).text().contains("operator")) {}
                            else {
                                String tempo=tds.get(3).text();
                                String pattern = "[a-zA-Z_ _&_.]+";
                                tempo = tempo.replaceAll(pattern, "");
                                if (tempo.matches("[0-9]+")) {
                                int cvd=Integer.parseInt(tempo); 
                                if (cvd>timer_temp) { 
                                tempall+=1;
                                //System.out.println(tempall);
                                }
                                else {}}else {}}}}
                            
                            
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Get Stone Bath   
   
                            int stonebathh=0;
                            org.jsoup.nodes.Document doccc = Jsoup.parse(inputFile, "UTF-8"); // 
                            for (Element table : doccc.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(7).text().contains("'")||tds.get(7).text().isEmpty()||tds.get(7).text().contains("/")||tds.get(7).text().contains("\\")||tds.get(7).text().contains("CHEMICALS")||tds.get(7).text().contains("chemicals")||tds.get(7).text().matches("[0-9_-]+")||tds.get(7).text().contains("CHEMICAL")||tds.get(7).text().contains("chemical")) {}
                            else {
                            String erw=tds.get(7).text().toString();
                            if (erw.contains("STONE")||erw.contains("STON")||erw.contains("BOOL")||erw.contains("FOAM")||erw.contains("BOLL")||erw.contains("BOAL")||erw.contains("KUPCS"))  {
                            stonebathh+=1;  
                            }else {}}}}
   
                            
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //Get Water Bath  
    
    
                            
        
                            int waterbath=0;
                            int waterbath2=0;
                            org.jsoup.nodes.Document docu = Jsoup.parse(inputFile, "UTF-8"); // 
                            for (Element table : docu.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            
                            if (tds.get(4).text().contains("'")||tds.get(4).text().equals("1")||tds.get(4).text().contains("'")||tds.get(4).text().contains("DRYER")||tds.get(4).text().contains("LITER")||tds.get(4).text().matches("[a-zA-Z_]+")||tds.get(4).text().contains("LITERS")) {}
                            else {
                                
                            String tempo=tds.get(3).text();
                            
                            if (tempo.contains("EXTRACT")) {
                                if (tds.get(4).text().matches("[0-9]+")) {
                                int cvd2=Integer.parseInt(tds.get(4).text()); 
                                waterbath2+=1;
                                //System.out.println(waterbath2);
                                }
                                
                                break;
                                
                            }
                            
                            
                            else {
                           
                                if (tds.get(4).text().matches("[0-9]+")) {
                                int cvd=Integer.parseInt(tds.get(4).text()); 
                               
                                waterbath+=1;
                                //System.out.println(waterbath);
                                }
                                
                            }
                            
                           }}}
                            
        
        
        
                            int waterbathall=0;
                            org.jsoup.nodes.Document dock = Jsoup.parse(inputFile, "UTF-8"); // 
                            for (Element table : dock.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(4).text().contains("'")||tds.get(4).text().equals("1")||tds.get(4).text().isEmpty()||tds.get(4).text().contains("'")||tds.get(4).text().contains("DRYER")||tds.get(4).text().contains("LITER")||tds.get(4).text().matches("[a-zA-Z_]+")||tds.get(4).text().contains("LITERS")) {}
                            else { 
                            String erw=tds.get(4).text().toString();
                            waterbathall+=1;
                            //System.out.println(waterbathall);
                            }}}
        
                            
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Read Vars From File  
   
    try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Timer.kady"));
      
      lproduct=buf.readLine().replace("Load_Product=","");
      rproduct=buf.readLine().replace("Remove_Product=","");
      tempraturee=buf.readLine().replace("Temprature=","");
      ftank=buf.readLine().replace("Fill_Tank=","");
      etank=buf.readLine().replace("Empty_Tank=","");
      cdosage =buf.readLine().replace("Chemical_Dosage=","");
      
      buf.close();
      } catch (FileNotFoundException fileNotFoundException) {
      } catch (IOException iOException) {}
   
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    String lproductt=lproduct;
    String rproductt=rproduct;
    String tempratureee=tempraturee;
    String ftankk=ftank;
    String etankk=etank;
    String cdosagee=cdosage;
    
    int bathnumm=bathnum;
    
    bosbos=bathnum;
    
    double firstshott=firstshot;
    double secondshott=secondshot;
    
    int tempp=temp;
    int tempp2=tempall-temp;
    int temppall=tempall;
    
    int waterbathx=waterbath;
    int waterbath2x=waterbathall-waterbath;
    int waterbathallx=waterbathall;
    
    int stonebathhh=stonebathh;
    
    loadremoveproduct=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
    tempraturetime=tempp*Double.parseDouble(tempratureee);
    chemicaldosage=Double.parseDouble(cdosagee);
    fillemptytank=waterbathx*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
    
    loadremoveproduct2=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
    tempraturetime2=tempp2*Double.parseDouble(tempratureee);
    chemicaldosage2=Double.parseDouble(cdosagee);
    fillemptytank2=waterbath2x*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
    
    loadremoveproductall=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
    tempraturetimeall=temppall*Double.parseDouble(tempratureee);
    chemicaldosageall=Double.parseDouble(cdosagee);
    fillemptytankall=waterbathallx*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
    
    //Alert for Bath Here
    
    
    
    if (bathnumm==1) {
        
      JFXTextField fss=new JFXTextField ("");
      fss.setPromptText("Write Stone Baths Number");
      fss.setMinSize(300, 30);
      fss.setLabelFloat(true);
      fss.setStyle("-fx-font-weight:bold;");
      fss.setEditable(true);
      Alert alerto = new Alert(Alert.AlertType.INFORMATION);
      alerto.setTitle("Stone Bath?");
      alerto.setHeaderText("We found stone or foam "+stonebathhh+" times. but 1 shot.");
      alerto.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alerto.setGraphic(fss);
      alerto.setResizable(false);
      DialogPane dialogPaneo = alerto.getDialogPane();
      dialogPaneo.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optiono = alerto.showAndWait();
      passy=fss.getText();
      stonabathth=Double.parseDouble(passy);
      if (optiono.get() == null) {} 
      else if (optiono.get() == ButtonType.OK) {
          
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabathth==0) {
          loadstone=0;
          removestone=0;
          cleaningstone=0;
          extraction=0;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
      }
      else if (stonabathth==1){
          
          loadstone=5.5;
          removestone=4.15;
          cleaningstone=15;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
      }
      
      
      else if (stonabathth==2){
          
          
          loadstone=16.5;
          removestone=8.3;
          cleaningstone=20;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
          
      }
      
      
      else {
          double v=stonabathth;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone=v2;
          removestone=v1;
          cleaningstone=0;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
      
      else if (optiono.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
        
    }
    
    else if (bathnumm==2) {
        
      JFXTextField fss=new JFXTextField ("");
      fss.setPromptText("Write Stone Baths Number");
      fss.setMinSize(300, 30);
      fss.setLabelFloat(true);
      fss.setStyle("-fx-font-weight:bold;");
      fss.setEditable(true);
      Alert alerto = new Alert(Alert.AlertType.INFORMATION);
      alerto.setTitle("Stone Bath?");
      alerto.setHeaderText("We found stone or foam "+stonebathhh+" times. for the first shot.");
      alerto.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alerto.setGraphic(fss);
      alerto.setResizable(false);
      DialogPane dialogPaneo = alerto.getDialogPane();
      dialogPaneo.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optiono = alerto.showAndWait();
      passy=fss.getText();
      stonabathth=Double.parseDouble(passy);
      if (optiono.get() == null) {} 
      else if (optiono.get() == ButtonType.OK) {
          
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabathth==0) {
          loadstone=0;
          removestone=0;
          cleaningstone=0;
          extraction=0;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
      }
      else if (stonabathth==1){
          
          loadstone=5.5;
          removestone=4.15;
          cleaningstone=15;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
      }
      
      
      else if (stonabathth==2){
          
          
          loadstone=16.5;
          removestone=8.3;
          cleaningstone=20;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
          
      }
      
      
      else {
          double v=stonabathth;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone=v2;
          removestone=v1;
          cleaningstone=0;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
      
      else if (optiono.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
      ///////////yrtyrty///////////
      
      JFXTextField fsss=new JFXTextField ("");
      fsss.setPromptText("Write Stone Baths Number");
      fsss.setMinSize(300, 30);
      fsss.setLabelFloat(true);
      fsss.setStyle("-fx-font-weight:bold;");
      fsss.setEditable(true);
      Alert alertoo = new Alert(Alert.AlertType.INFORMATION);
      alertoo.setTitle("Stone Bath?");
      alertoo.setHeaderText("We found stone or foam "+stonebathhh+" times. for the second shot.");
      alertoo.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alertoo.setGraphic(fsss);
      alertoo.setResizable(false);
      DialogPane dialogPaneoo = alertoo.getDialogPane();
      dialogPaneoo.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optionoio = alertoo.showAndWait();
      passyy=fsss.getText();
      stonabaththh=Double.parseDouble(passyy);
      if (optionoio.get() == null) {} 
      else if (optionoio.get() == ButtonType.OK) {
         
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabaththh==0) {
          loadstone2=0;
          removestone2=0;
          cleaningstone2=0;
          extraction2=0;
          double dos3=loadstone2+removestone2;
          loadremovestone2=dos3;
          
      }
      else if (stonabaththh==1){
          
          loadstone2=5.5;
          removestone2=4.15;
          cleaningstone2=15;
          extraction2=20;
          double dos3=loadstone2+removestone2;
          loadremovestone2=dos3;
          
      }
      
      
      else if (stonabaththh==2){
          
          
          loadstone2=16.5;
          removestone2=8.3;
          cleaningstone2=20;
          extraction2=20;
          double dos3=loadstone2+removestone2;
          loadremovestone2=dos3;
          
          
      }
      
      
      else {
          double v=stonabaththh;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone2=v2;
          removestone2=v1;
          cleaningstone2=0;
          extraction2=20;
          double dos3=loadstone2+removestone2;
          loadremovestone2=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
      
      else if (optionoio.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
        
    }
    
     
    
    
    /////////////////////////////////////////////Starting//////////////////////////////////////////////////////////
    
    
    if (bathnumm==1) {
        
        gmf1=stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank;
        
        gdf1=(stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank)/60.0;
        
        //Write to recipe here //////////////////////////////////////////////////////////
        
Alert aloo = new Alert(Alert.AlertType.INFORMATION);
aloo.setTitle("Show Time");
aloo.setResizable(false);
aloo.setHeaderText("Here is time for "+recipenami+" of "+modelooo+" Customer.");
aloo.setContentText("This Recipe Was One Shot:\nTime In Minutes=   "+gmf1+"."+"\nTime In Hours=   "+gdf1+".");
DialogPane dialogPanej = aloo.getDialogPane();
dialogPanej.getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
aloo.showAndWait();
        
      /////////////////////////////////////////////////////////////////////////////////////////
      
      
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Save To DB");
alert.setHeaderText("Time Result");
alert.setContentText("Here Is The result of Time For "+recipenami+" Recipe.");
ButtonType buttonTypeOne = new ButtonType("Save To DB");
ButtonType buttonTypeCancel = new ButtonType("Cancel");
alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
DialogPane dialogPanei = alert.getDialogPane();
dialogPanei.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> results = alert.showAndWait();
if (results.isPresent() && results.get() == buttonTypeOne) {
//Save To DB.

  
      
      //////////////////////////////////////////////////
  //Here Will Write To DB...........................
  
      
      Date currentDate1 = GregorianCalendar.getInstance().getTime();
      DateFormat df1 = DateFormat.getDateInstance();
      String dateString1 = df1.format(currentDate1);
      Date d1 = new Date();
      SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
      String timeString1 = sdf1.format(d1);
      SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
      String timeString2 = sdf2.format(d1);
      String datevaluey = timeString2;                                                          //Date
      
      shoty=1;
      

       try {
           
                    String sql0 = "select * from Development_Time_Two where Name like '" + recipenami + "' and Model like '" + modelooo + "' ";
                    pst = conn.prepareStatement(sql0);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                    //Update
                       
                       wifi="found";
                       
                   ///////    
                       
                    }
                    
    ///////////////////////////////////////////////////////////////////////////////////                
                    
                    
                    else {
                        
                       //Insert
                       
                   wifi="not_found";
                  
      //////////////////////////////////////////                  
                        

                    }
      
                    
    }
        
        catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    } 
     
       
       
       
       
     String fifi=wifi;
     
     
     if (fifi.equals("found")) {
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
                             
                          if (bosbos==1) {
                              
                           String ti1,ti2;
                           String ti3,ti4;
                           ti4=Integer.toString(shoty+1);
                           ti3=Integer.toString(shoty);
                           ti1=Double.toString(gdf1);
                           ti2=Double.toString(gdf2);
                           String mi1=Double.toString(gmf1);
                           String mi2=Double.toString(gmf2);
                           
                                 try {
       
                                     
                                                 
      String sqlm = "select * from Development_Time_Two where Name=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
      
             
      
                                     
                String sqlp= "update Development_Time_Two set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();
                                     
     
                
                
                        }
                        
                     catch (Exception exception) {
    } 
      finally {
      try {
      rs.close();
      pst.close();  
      Notifications noti = Notifications.create();
      noti.title("Update!");
      noti.text("We Updated Record Successfully!");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                          
                          
                         /////////////////////////////////////////////
                         
                         
    if (bosbos == 2) {
    String ti1, ti2;
    String ti3, ti4;
    ti4 = Integer.toString(shoty + 1);
    ti3 = Integer.toString(shoty);
    ti1 = Double.toString(gdf1);
    ti2 = Double.toString(gdf2);
    String mi1 = Double.toString(gmf1);
    String mi2 = Double.toString(gmf2);

    try {
        // Debug message
        System.out.println("Processing Shot 1: " + ti3);

        // SELECT query to fetch existing time values for Shot 1
        String sqlm = "SELECT * FROM Development_Time_Two WHERE Name=? AND Shot=?";
        pst = conn.prepareStatement(sqlm);
        pst.setString(1, recipenami);
        pst.setString(2, ti3);
        rs = pst.executeQuery();

        if (rs.next()) {
            oldtimemin = rs.getString("Time_In_Min");
            oldtimehour = rs.getString("Time_In_Hour");
            System.out.println("Shot 1 Found: Time_Min=" + oldtimemin + ", Time_Hour=" + oldtimehour);
        } else {
            System.out.println("Shot 1 Not Found in Database!");
        }

        rs.close();
        pst.close();

        // UPDATE Shot 1
        String sqlp = "update Development_Time_Two set Date=?, Time_In_Min=?, Time_In_Hour=?, Time_In_Min_Updated=?, Time_In_Hour_Updated=? WHERE Name=? AND Shot=?";
        pst = conn.prepareStatement(sqlp);
        pst.setString(1, datevaluey);
        pst.setString(2, oldtimemin);
        pst.setString(3, oldtimehour);
        pst.setString(4, mi1);
        pst.setString(5, ti1);
        pst.setString(6, recipenami);
        pst.setString(7, ti3);

        int rowsAffected = pst.executeUpdate();
        System.out.println("Shot 1 Update Rows Affected: " + rowsAffected);

        conn.commit(); // Ensure transaction is committed

        Notifications noti = Notifications.create();
        noti.title("Update!");
        noti.text("We Updated Record 1 Successfully!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(3));
        noti.showInformation();
    } catch (Exception exception) {
        exception.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    try {
        // Debug message
        System.out.println("Processing Shot 2: " + ti4);

        // SELECT query to fetch existing time values for Shot 2
        String sqlm = "SELECT * FROM Development_Time_Two WHERE Name=? AND Shot=?";
        pst = conn.prepareStatement(sqlm);
        pst.setString(1, recipenami);
        pst.setString(2, ti4);
        rs = pst.executeQuery();

        if (rs.next()) {
            oldtimemin2 = rs.getString("Time_In_Min");
            oldtimehour2 = rs.getString("Time_In_Hour");
            System.out.println("Shot 2 Found: Time_Min=" + oldtimemin2 + ", Time_Hour=" + oldtimehour2);
        } else {
            System.out.println("Shot 2 Not Found in Database!");
        }

        rs.close();
        pst.close();

        // UPDATE Shot 2
        String sqlp = "update Development_Time_Two SET Date=?, Time_In_Min=?, Time_In_Hour=?, Time_In_Min_Updated=?, Time_In_Hour_Updated=? WHERE Name=? AND Shot=?";
        pst = conn.prepareStatement(sqlp);
        pst.setString(1, datevaluey);
        pst.setString(2, oldtimemin2);
        pst.setString(3, oldtimehour2);
        pst.setString(4, mi2);
        pst.setString(5, ti2);
        pst.setString(6, recipenami);
        pst.setString(7, ti4);

        int rowsAffected = pst.executeUpdate();
        System.out.println("Shot 2 Update Rows Affected: " + rowsAffected);

        conn.commit(); // Ensure transaction is committed

        Notifications noti = Notifications.create();
        noti.title("Update!");
        noti.text("We Updated Record 2 Successfully!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(3));
        noti.showInformation();
    } catch (Exception exception) {
        exception.printStackTrace();
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
}

                          
                          
                       
//                       if (bosbos==2) {
//                           
//                               
//                           String ti1,ti2;
//                           String ti3,ti4;
//                           ti4=Integer.toString(shoty+1);
//                           ti3=Integer.toString(shoty);
//                           ti1=Double.toString(gdf1);
//                           ti2=Double.toString(gdf2);
//                           String mi1=Double.toString(gmf1);
//                           String mi2=Double.toString(gmf2);
//                           
//                           
//                              try {
//                                  
//                                  
//      String sqlm = "select * from Development_Time_Two where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, ti3);
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour=add2;  //OLD TIME IN HOUR.
//      
//   //   pst.execute();
//                            
//         
//                String sqlp= "update Development_Time_Two set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"'  where Name='"+recipenami+"' and Shot='"+ti3+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();    
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//        
//      Notifications noti = Notifications.create();
//      noti.title("Update!");
//      noti.text("We Updated Record 1 Successfully!");
//      noti.position(Pos.CENTER);
//      noti.hideAfter(Duration.seconds(3));
//      noti.showInformation();
//        
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//                                    
//      String sqlm = "select * from Development_Time_Two where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, filenammm);
//      pst.setString(2, ti4);
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin2=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour2=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Development_Time_Two set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+ti2+"'  where Name='"+recipenami+"' and Shot='"+ti4+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//        
//      Notifications noti = Notifications.create();
//      noti.title("Update!");
//      noti.text("We Updated Record 2 Successfully!");
//      noti.position(Pos.CENTER);
//      noti.hideAfter(Duration.seconds(3));
//      noti.showInformation();
//        
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                           
//                           
//                           
//                       }
//                       
         


         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
     }
       
       
     else if (fifi.equals("not_found")) {
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
         
                       if (bosbos==1) {
                           
                           
                                 try {
                            
          String reg = "insert into Development_Time_Two (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti = Notifications.create();
      noti.title("Insert!");
      noti.text("We Inserted Record Successfully!");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
                       if (bosbos==2) {
                           
                              try {
                            
          String reg = "insert into Development_Time_Two (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti = Notifications.create();
      noti.title("Insert!");
      noti.text("We Inserted Record 1 Successfully!");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      
      } catch (Exception exception) {}
    }    
                           
                              
                                 try {
                            
          String reg = "insert into Development_Time_Two (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti = Notifications.create();
      noti.title("Insert!");
      noti.text("We Inserted Record 2 Successfully!");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
        
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
        
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
     }
       
     
     else {}
       
       
      
      
      
      
      
      
      
      
      
      ////////////////////////////////END DB////////////////////////////////////////////////////
        
      

} 
else {}
      
      
      
    
      
    }
    
    else if (bathnumm==2) {
        
        gmf1=stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank;
        
        gdf1=(stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank)/60.0;
        
        gmf2=stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2;
        
        gdf2=(stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2)/60.0;
        
        
          //Write to recipe here //////////////////////////////////////////////////////////
          
          
          
Alert aloo = new Alert(Alert.AlertType.INFORMATION);
aloo.setTitle("Show Time");
aloo.setResizable(false);
aloo.setHeaderText("Here is time for "+recipenami+" of "+modelooo+" Customer.");
aloo.setContentText("This Recipe Was Two Shots:\nFirst Shot Info:\nTime In Minutes=   "+gmf1+"."+"\nTime In Hours=   "+gdf1+".\n\n"+"Second Shot Info:\nTime In Minutes=   "+gmf2+"."+"\nTime In Hours=   "+gdf2+".\n\n");
DialogPane dialogPanej = aloo.getDialogPane();
dialogPanej.getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
aloo.showAndWait();
       
        /////////////////////////////////////////////////////////////////////////////////
        
        
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Save To DB");
alert.setHeaderText("Time Result");
alert.setContentText("Here Is The result of Time For "+recipenami+" Recipe.");
ButtonType buttonTypeOne = new ButtonType("Save To DB");
ButtonType buttonTypeCancel = new ButtonType("Cancel");
alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
DialogPane dialogPanei = alert.getDialogPane();
dialogPanei.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> results = alert.showAndWait();
if (results.isPresent() && results.get() == buttonTypeOne) {
//Save To DB.

          
      //////////////////////////////////////////////////
  //Here Will Write To DB...........................
  
      
      Date currentDate1 = GregorianCalendar.getInstance().getTime();
      DateFormat df1 = DateFormat.getDateInstance();
      String dateString1 = df1.format(currentDate1);
      Date d1 = new Date();
      SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
      String timeString1 = sdf1.format(d1);
      SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
      String timeString2 = sdf2.format(d1);
      String datevaluey = timeString2;                                                          //Date
      
      shoty=1;
      

       try {
           
                    String sql0 = "select * from Development_Time_Two where Name like '" + recipenami + "' and Model like '" + modelooo + "' ";
                    pst = conn.prepareStatement(sql0);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                    //Update
                       
                       wifi="found";
                       
                   ///////    
                       
                    }
                    
    ///////////////////////////////////////////////////////////////////////////////////                
                    
                    
                    else {
                        
                       //Insert
                       
                   wifi="not_found";
                  
      //////////////////////////////////////////                  
                        

                    }
      
                    
    }
        
        catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    } 
     
       
       
       
       
     String fifi=wifi;
     
     
     if (fifi.equals("found")) {
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
                             
                          if (bosbos==1) {
                              
                           String ti1,ti2;
                           String ti3,ti4;
                           ti4=Integer.toString(shoty+1);
                           ti3=Integer.toString(shoty);
                           ti1=Double.toString(gdf1);
                           ti2=Double.toString(gdf2);
                           String mi1=Double.toString(gmf1);
                           String mi2=Double.toString(gmf2);
                           
                                 try {
       
                                     
                                                 
      String sqlm = "select * from Development_Time_Two where Name=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
      
             
                                     
                String sqlp= "update Development_Time_Two set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();
                                     
     
                
                
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
                       if (bosbos==2) {
                           
                               
                           String ti1,ti2;
                           String ti3,ti4;
                           ti4=Integer.toString(shoty+1);
                           ti3=Integer.toString(shoty);
                           ti1=Double.toString(gdf1);
                           ti2=Double.toString(gdf2);
                           String mi1=Double.toString(gmf1);
                           String mi2=Double.toString(gmf2);
                           
                           
                              try {
                                  
                                  
      String sqlm = "select * from Development_Time_Two where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, ti3);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
   //   pst.execute();
                            
         
                String sqlp= "update Development_Time_Two set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"'  where Name='"+recipenami+"' and Shot='"+ti3+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();    
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                              
                                 try {
                            
                                    
      String sqlm = "select * from Development_Time_Two where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, filenammm);
      pst.setString(2, ti4);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin2=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour2=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Development_Time_Two set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+ti2+"'  where Name='"+recipenami+"' and Shot='"+ti4+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();         
                                     
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
         


         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
     }
       
       
     else if (fifi.equals("not_found")) {
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
         
                       if (bosbos==1) {
                           
                           
                                 try {
                            
          String reg = "insert into Development_Time_Two (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
                       if (bosbos==2) {
                           
                              try {
                            
          String reg = "insert into Development_Time_Two (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                              
                                 try {
                            
          String reg = "insert into Development_Time_Two (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
        
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
     }
       
     
     else {}
       
       
      
      ////////////////////////////////END DB////////////////////////////////////////////////////
       

} 
else {}
        
        
  
        //////////////////////////////////////////////////////////////////////////////////
        
    }
    
    
    else {
        
        //Noti
        
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, We don't have 3 shots in one recipe.\nWe are working on this feature");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showError();
    }
    
    
    /////////////////////////////////////////////Ending////////////////////////////////////////////////////////////
   
    
}   
  









@FXML
void calculatetimeaction(ActionEvent event) throws IOException, InterruptedException, InterruptedException, Exception {
       
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
FileChooser fcho = new FileChooser();
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
fcho.setTitle("Kady Choose");
File f = fcho.showOpenDialog((Window)null);
String recipenami=f.getName().replace(".ks","").replace(".html","");
String recipepathy = f.getAbsolutePath().toString();




 //SHow recipr first here..........

//bosboss=recipepathy;
//
//Stage stg = new Stage();
//Parent root = FXMLLoader.<Parent>load(getClass().getResource("Preview.fxml"));
//Scene sce = new Scene(root);
//stg.setTitle("Preview A Recipe");
//stg.setResizable(false);
//stg.setScene(sce);
//stg.centerOnScreen();
//stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
//stg.show();

String didd1=NewDir.file_dir+"\\PRODUCTION\\";
String didd2="\\"+f.getName();

String modelooo=recipepathy.replace(didd1,"").replace(didd2,"");



    ////////////////////////////////////////////////////////////

    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String result = KeyDecoder.extractData(longKey.trim());
    if (f == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = f.getAbsolutePath();
    String nameofit=recipenami;
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
 
    FileDecryptor.decrypt(input, tempOutput, result);
    File tempt = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////



//////////////////////////////////////////////////////////////////////////////////////////////////////////
InputStream inputinstream=new FileInputStream(tempt);
BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
String lo;
lili.clear();
while ((lo=bi.readLine())!=null) {       
lili.appendText("\n"+lo
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


    ////////////////////////////////////////////////////////////////
    if (tempt.exists()) {
        tempt.delete();
    }
    ////////////////////////////////////////////////////////////////
	
	
	


String gf=lili.getText();
OutputStream instreamm=new FileOutputStream(System.getProperty("user.home")+"\\r.ks");
PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
pwe.println(gf);
pwe.close();




   //Get Time And Shots
   
   List<Integer> time = new ArrayList<>();
   List<Integer> timeSum = new ArrayList<>();
   List<String> shots = new ArrayList<>();
   int sum = 0, bathnum=0, firstshot=0, secondshot=0,thirdshot=0,forthshot=0;
   
   File inputFile = new File(System.getProperty("user.home")+"\\r.ks"); //
   org.jsoup.nodes.Document doc = Jsoup.parse(inputFile, "UTF-8"); //
   for (Element table : doc.select("tbody")) {
   for (Element row : table.select("tr")) {
   Elements tds = row.select("td");
   if (tds.get(2).text().isEmpty()||tds.get(2).text().contains("/")||tds.get(2).text().contains("\\")||tds.get(2).text().contains("SPIN")||tds.get(2).text().contains("spin")||tds.get(2).text().contains("TIME")||tds.get(2).text().contains("time")||tds.get(2).text().matches("[a-zA-Z_]+")||tds.get(2).text().contains("PRODUCTION")||tds.get(2).text().contains("RECIPE")||tds.get(2).text().contains("RECIPI")||tds.get(2).text().contains("DATE")||tds.get(2).text().contains("WASH")) {}
   else {
   String stringg=tds.get(2).text().replace(" CONT","").replace(" cont","").replace(" CONG","").replace("CONG","").replace(" CNTRL","").replace(" control","").replace(" CONTROL","").replace(" con","").replace(" CON","").replace(" CNTRL","").replace(" KONTROL","").replace("CONT","").replace("cont","").replace("CNTRL","").replace("control","").replace("CONTROL","").replace("con","").replace("CON","").replace("CNTRL","").replace("KONTROL","");
   
   if (stringg.contains("+")) {
   String sum1 = stringg;
   String[] numbers1 = sum1.split("\\+");
   int total1 = 0;
   for (String numStr1 : numbers1) {
   total1 += Integer.parseInt(numStr1);
   }
   time.add(total1);
   }
   
   else {
   int ioo=Integer.parseInt(stringg);
   time.add(ioo);     
   }
   }
                              
                            String dalil=tds.get(3).text();
                            if (dalil.contains("EXTRACT")||dalil.contains("extract")||dalil.contains("Extract")||dalil.contains("EXTRA")||dalil.contains("EXTRACTION")||dalil.contains("extraction")) {
                            for (int i = 0; i < time.size(); i++)
                            sum += time.get(i);
                            timeSum.add(sum);
                            time.clear();
                            shots.add(dalil);}else {
                            
                        
                            
                            }}}
                          bathnum=shots.size();
                          if (shots.size()==1) {
                          firstshot=timeSum.get(0);}
                          else if (shots.size()==2) {
                          firstshot=timeSum.get(0);
                          secondshot=timeSum.get(1)-timeSum.get(0);}
                          else {
                          
                       
                          
                          }
                          
                          

                          
   
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Get Temp
   
   try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Timer_Temp.kady"));
      
      timer_temprature=buf.readLine();
      
      buf.close();
      } catch (FileNotFoundException fileNotFoundException) {
      } catch (IOException iOException) {}
   
                            int temp=0;
                            int temp2=0;
                            int temp3=0;
                            String timer_tempra=timer_temprature;
                            int timer_temp=Integer.parseInt(timer_tempra);
                            
                          
                            org.jsoup.nodes.Document docy = Jsoup.parse(inputFile, "UTF-8"); //      
                            for (Element table : docy.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(3).text().contains("/")||tds.get(3).text().contains("\\")||tds.get(3).text().isEmpty()||tds.get(3).text().contains("TEMP")||tds.get(3).text().contains("OPERATOR")||tds.get(3).text().contains("temp")||tds.get(3).text().contains("operator")) {}
                            else {
                                
                            String tempo=tds.get(3).text();
                            
                            if (tempo.contains("EXTRACT")) {
                                
                                String pattern = "[a-zA-Z_ _&_.]+";
                                tempo = tempo.replaceAll(pattern, "");
                                if (tempo.matches("[0-9]+")) {
                                int cvd2=Integer.parseInt(tempo); 
                                if (cvd2>timer_temp) { 
                                temp2+=1;
                                }
                                else {
                                }}break;
                             }
                            
                            else {
                           
                                String pattern = "[a-zA-Z_ _&_.]+";  
                                tempo = tempo.replaceAll(pattern, "");
                                if (tempo.matches("[0-9]+")) {
                                int cvd=Integer.parseInt(tempo); 
                                if (cvd>timer_temp) { 
                                temp+=1;
                                }else {}}
                                
                            }}}}
                            
                            int tempall=0;
                            org.jsoup.nodes.Document docc = Jsoup.parse(inputFile, "UTF-8"); // 
                            for (Element table : docc.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(3).text().contains("/")||tds.get(3).text().contains("\\")||tds.get(3).text().isEmpty()||tds.get(3).text().contains("TEMP")||tds.get(3).text().contains("OPERATOR")||tds.get(3).text().contains("temp")||tds.get(3).text().contains("operator")) {}
                            else {
                                String tempo=tds.get(3).text();
                                String pattern = "[a-zA-Z_ _&_.]+";
                                tempo = tempo.replaceAll(pattern, "");
                                if (tempo.matches("[0-9]+")) {
                                int cvd=Integer.parseInt(tempo); 
                                if (cvd>timer_temp) { 
                                tempall+=1;}
                                else {}}else {}}}}
                            
                            
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Get Stone Bath   
   
                            int stonebathh=0;
                            org.jsoup.nodes.Document doccc = Jsoup.parse(inputFile, "UTF-8"); // 
                            for (Element table : doccc.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(7).text().isEmpty()||tds.get(7).text().contains("/")||tds.get(7).text().contains("\\")||tds.get(7).text().contains("CHEMICAL")||tds.get(7).text().contains("chemical")||tds.get(7).text().matches("[0-9_-]+")) {}
                            else {
                            String erw=tds.get(7).text().toString();
                            if (erw.contains("STONE")||erw.contains("STON")||erw.contains("BOOL")||erw.contains("FOAM")||erw.contains("BOLL"))  {
                            stonebathh+=1;  
                            }else {}}}}
   
                            
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //Get Water Bath  
    
    
                            
        
                            int waterbath=0;
                            int waterbath2=0;
                            org.jsoup.nodes.Document docu = Jsoup.parse(inputFile, "UTF-8"); // 
                            for (Element table : docu.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            
                            if (tds.get(4).text().contains("'")||tds.get(4).text().contains("DRYER")||tds.get(4).text().contains("LITER")||tds.get(4).text().matches("[a-zA-Z_]+")) {}
                            else {
                                
                            String tempo=tds.get(3).text();
                            
                            if (tempo.contains("EXTRACT")) {
                                if (tds.get(4).text().matches("[0-9]+")) {
                                int cvd2=Integer.parseInt(tds.get(4).text()); 
                                waterbath2+=1;
                                
                                }
                                
                                break;
                                
                            }
                            
                            
                            else {
                           
                                if (tds.get(4).text().matches("[0-9]+")) {
                                int cvd=Integer.parseInt(tds.get(4).text()); 
                               
                                waterbath+=1;
                                
                                }
                                
                            }
                            
                           }}}
                            
        
        
        
                            int waterbathall=0;
                            org.jsoup.nodes.Document dock = Jsoup.parse(inputFile, "UTF-8"); // 
                            for (Element table : dock.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(4).text().isEmpty()||tds.get(4).text().contains("'")||tds.get(4).text().contains("DRYER")||tds.get(4).text().contains("LITER")||tds.get(4).text().matches("[a-zA-Z_]+")) {}
                            else { 
                            String erw=tds.get(4).text().toString();
                            waterbathall+=1;
                            }}}
        
                            
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Read Vars From File  
   
    try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Timer.kady"));
      
      lproduct=buf.readLine().replace("Load_Product=","");
      rproduct=buf.readLine().replace("Remove_Product=","");
      tempraturee=buf.readLine().replace("Temprature=","");
      ftank=buf.readLine().replace("Fill_Tank=","");
      etank=buf.readLine().replace("Empty_Tank=","");
      cdosage =buf.readLine().replace("Chemical_Dosage=","");
      
      buf.close();
      } catch (FileNotFoundException fileNotFoundException) {
      } catch (IOException iOException) {}
   
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    String lproductt=lproduct;
    String rproductt=rproduct;
    String tempratureee=tempraturee;
    String ftankk=ftank;
    String etankk=etank;
    String cdosagee=cdosage;
    
    int bathnumm=bathnum;
    
    bosbos=bathnum;
    
    double firstshott=firstshot;
    double secondshott=secondshot;
    
    int tempp=temp;
    int tempp2=tempall-temp;
    int temppall=tempall;
    
    int waterbathx=waterbath;
    int waterbath2x=waterbathall-waterbath;
    int waterbathallx=waterbathall;
    
    int stonebathhh=stonebathh;
    
    loadremoveproduct=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
    tempraturetime=tempp*Double.parseDouble(tempratureee);
    chemicaldosage=Double.parseDouble(cdosagee);
    fillemptytank=waterbathx*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
    
    loadremoveproduct2=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
    tempraturetime2=tempp2*Double.parseDouble(tempratureee);
    chemicaldosage2=Double.parseDouble(cdosagee);
    fillemptytank2=waterbath2x*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
    
    loadremoveproductall=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
    tempraturetimeall=temppall*Double.parseDouble(tempratureee);
    chemicaldosageall=Double.parseDouble(cdosagee);
    fillemptytankall=waterbathallx*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
    
    //Alert for Bath Here
    
    
    
    if (bathnumm==1) {
        
        
        ////////////////////////////////SSS///////////////////////////////////////
          
        String wsa=recipepathy;
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
      String pathy = recipepathy.replace("\\","\\\\").replace("Z:","X:").replace("X:","X:").replace("V:","X:").replace("W:","X:");
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
              
          
              ////////////////////////////////////////////////////////////

    String longKeyt;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKeyt = cxsd.readLine();
    }
    if (longKeyt == null || longKeyt.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String resulty = KeyDecoder.extractData(longKeyt.trim());
    if (pathy == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String inputk = pathy;
    String nameofitk=Paths.get(pathy).getFileName().toString();
    String tempOutputk = System.getProperty("user.home")+"\\"+nameofitk;
 
    FileDecryptor.decrypt(inputk, tempOutputk, resulty);
    File tempo = new File(tempOutputk);
    
    ////////////////////////////////////////////////////////////
          
          
          
    lili.clear();
    InputStream inputinstreame=new FileInputStream(tempo);
    BufferedReader bie=new BufferedReader (new InputStreamReader (inputinstreame,"UTF-8"));
    String loe;
    while ((loe=bie.readLine())!=null) {
        
        lili.appendText("\n"+loe
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
    bie.close();
    
    
    
	////////////////////////////////////////////////////////////////
    if (tempo.exists()) {
        tempo.delete();
    }
    ////////////////////////////////////////////////////////////////
	
	
	
    
    String gfe=lili.getText();
    OutputStream instreamme=new FileOutputStream(tw2o);
    PrintWriter pwee = new PrintWriter(new OutputStreamWriter (instreamme,"UTF-8"));
    pwee.println(gfe);
    pwee.println("<style>\n" +
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
    pwee.close();
    lili.clear();
      }    
    }   
      
      WebView webviewt=new WebView ();
      webviewt.setContextMenuEnabled(false);
      webviewt.setMinSize(1800, 800);
      String lkd=System.getProperty("user.home")+"\\Hehehe\\Roro.html";
      URI uris = Paths.get(lkd).toAbsolutePath().toUri();
      webviewt.getEngine().load(uris.toString());  
      Thread.sleep(3000);
      File tw2ooo=new File (System.getProperty("user.home")+"\\Hehehe\\Roro.html");
      tw2ooo.delete();
      JFXTextField fss=new JFXTextField ("");
      fss.setPromptText("Write Stone Baths Number");
      fss.setMinSize(300, 30);
      fss.setLabelFloat(true);
      fss.setStyle("-fx-font-weight:bold;");
      fss.setEditable(true);
      VBox vduu=new VBox ();
      vduu.setSpacing(30);
      vduu.setMinSize(1850,850);
      vduu.getChildren().addAll(webviewt,fss);
      Alert alerto = new Alert(Alert.AlertType.INFORMATION);
      alerto.setTitle("Stone Bath?");
      alerto.setHeaderText("We found stone or foam "+stonebathhh+" times. but 1 shot.");
      alerto.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alerto.setGraphic(vduu);
      
      ////////////////////////////////EEE///////////////////////////////////////
      
      
      alerto.setResizable(false);
      DialogPane dialogPaneo = alerto.getDialogPane();
      dialogPaneo.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optiono = alerto.showAndWait();
      passy=fss.getText();
      stonabathth=Double.parseDouble(passy);
      if (optiono.get() == null) {} 
      else if (optiono.get() == ButtonType.OK) {
          
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabathth==0) {
          loadstone=0;
          removestone=0;
          cleaningstone=0;
          extraction=0;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
      }
      else if (stonabathth==1){
          
          loadstone=5.5;
          removestone=4.15;
          cleaningstone=15;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
      }
      
      
      else if (stonabathth==2){
          
          
          loadstone=16.5;
          removestone=8.3;
          cleaningstone=20;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
          
      }
      
      
      else {
          double v=stonabathth;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone=v2;
          removestone=v1;
          cleaningstone=0;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
      
      else if (optiono.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
        
    }
    
    else if (bathnumm==2) {
        
        
        
        ////////////////////////////////SSS///////////////////////////////////////
          
        String wsa=recipepathy;
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
      String pathy = recipepathy.replace("\\","\\\\").replace("Z:","X:").replace("X:","X:").replace("V:","X:").replace("W:","X:");
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
              
          
          
          
                    
    ////////////////////////////////////////////////////////////

    String longKeyt;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKeyt = cxsd.readLine();
    }
    if (longKeyt == null || longKeyt.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String resulty = KeyDecoder.extractData(longKeyt.trim());
    if (pathy == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String inputk = pathy;
    String nameofitk=Paths.get(pathy).getFileName().toString();
    String tempOutputk = System.getProperty("user.home")+"\\"+nameofitk;
 
    FileDecryptor.decrypt(inputk, tempOutputk, resulty);
    File tempoo = new File(tempOutputk);
    
    ////////////////////////////////////////////////////////////
          
          
          
          
          
    lili.clear();
    InputStream inputinstreame=new FileInputStream(tempoo);
    BufferedReader bie=new BufferedReader (new InputStreamReader (inputinstreame,"UTF-8"));
    String loe;
    while ((loe=bie.readLine())!=null) {
        
        lili.appendText("\n"+loe
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
    bie.close();
    
    
	////////////////////////////////////////////////////////////////
    if (tempoo.exists()) {
        tempoo.delete();
    }
    ////////////////////////////////////////////////////////////////
	
	
	
    
    
    String gfe=lili.getText();
    OutputStream instreamme=new FileOutputStream(tw2o);
    PrintWriter pwee = new PrintWriter(new OutputStreamWriter (instreamme,"UTF-8"));
    pwee.println(gfe);
    pwee.println("<style>\n" +
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
    pwee.close();
    lili.clear();
      }    
    }   
      
      WebView webviewt=new WebView ();
      webviewt.setContextMenuEnabled(false);
      webviewt.setMinSize(1800, 800);
      String lkd=System.getProperty("user.home")+"\\Hehehe\\Roro.html";
      URI uris = Paths.get(lkd).toAbsolutePath().toUri();
      webviewt.getEngine().load(uris.toString());  
      Thread.sleep(3000);
      File tw2ooo=new File (System.getProperty("user.home")+"\\Hehehe\\Roro.html");
      tw2ooo.delete();
      JFXTextField fss=new JFXTextField ("");
      fss.setPromptText("Write Stone Baths Number");
      fss.setMinSize(300, 30);
      fss.setLabelFloat(true);
      fss.setStyle("-fx-font-weight:bold;");
      fss.setEditable(true);
      VBox vduu=new VBox ();
      vduu.setSpacing(30);
      vduu.setMinSize(1850,850);
      vduu.getChildren().addAll(webviewt,fss);
      Alert alerto = new Alert(Alert.AlertType.INFORMATION);
      alerto.setTitle("Stone Bath?");
      //alerto.setHeaderText("We found stone or foam "+stonebathhh+" times. but 1 shot.");
      alerto.setHeaderText("We found stone or foam "+stonebathhh+" times. for the first shot.");
      
      alerto.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alerto.setGraphic(vduu);
      
      ////////////////////////////////EEE///////////////////////////////////////
      
        
        
        
//      JFXTextField fss=new JFXTextField ("");
//      fss.setPromptText("Write Stone Baths Number");
//      fss.setMinSize(300, 30);
//      fss.setLabelFloat(true);
//      fss.setStyle("-fx-font-weight:bold;");
//      fss.setEditable(true);
//      Alert alerto = new Alert(Alert.AlertType.INFORMATION);
//      alerto.setTitle("Stone Bath?");
//      alerto.setHeaderText("We found stone or foam "+stonebathhh+" times. for the first shot.");
//      alerto.setContentText("Hello, Please tell me: Stone Baths Number?.");
//      alerto.setGraphic(fss);
      alerto.setResizable(false);
      DialogPane dialogPaneo = alerto.getDialogPane();
      dialogPaneo.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optiono = alerto.showAndWait();
      passy=fss.getText();
      stonabathth=Double.parseDouble(passy);
      if (optiono.get() == null) {} 
      else if (optiono.get() == ButtonType.OK) {
          
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabathth==0) {
          loadstone=0;
          removestone=0;
          cleaningstone=0;
          extraction=0;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
      }
      else if (stonabathth==1){
          
          loadstone=5.5;
          removestone=4.15;
          cleaningstone=15;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
      }
      
      
      else if (stonabathth==2){
          
          
          loadstone=16.5;
          removestone=8.3;
          cleaningstone=20;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
          
      }
      
      
      else {
          double v=stonabathth;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone=v2;
          removestone=v1;
          cleaningstone=0;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
      
      else if (optiono.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
      ///////////yrtyrty///////////
      
      JFXTextField fsss=new JFXTextField ("");
      fsss.setPromptText("Write Stone Baths Number");
      fsss.setMinSize(300, 30);
      fsss.setLabelFloat(true);
      fsss.setStyle("-fx-font-weight:bold;");
      fsss.setEditable(true);
      Alert alertoo = new Alert(Alert.AlertType.INFORMATION);
      alertoo.setTitle("Stone Bath?");
      alertoo.setHeaderText("We found stone or foam "+stonebathhh+" times. for the second shot.");
      alertoo.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alertoo.setGraphic(fsss);
      alertoo.setResizable(false);
      DialogPane dialogPaneoo = alertoo.getDialogPane();
      dialogPaneoo.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optionoio = alertoo.showAndWait();
      passyy=fsss.getText();
      stonabaththh=Double.parseDouble(passyy);
      if (optionoio.get() == null) {} 
      else if (optionoio.get() == ButtonType.OK) {
         
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabaththh==0) {
          loadstone2=0;
          removestone2=0;
          cleaningstone2=0;
          extraction2=0;
          double dos3=loadstone2+removestone2;
          loadremovestone2=dos3;
          
      }
      else if (stonabaththh==1){
          
          loadstone2=5.5;
          removestone2=4.15;
          cleaningstone2=15;
          extraction2=20;
          double dos3=loadstone2+removestone2;
          loadremovestone2=dos3;
          
      }
      
      
      else if (stonabaththh==2){
          
          
          loadstone2=16.5;
          removestone2=8.3;
          cleaningstone2=20;
          extraction2=20;
          double dos3=loadstone2+removestone2;
          loadremovestone2=dos3;
          
          
      }
      
      
      else {
          double v=stonabaththh;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone2=v2;
          removestone2=v1;
          cleaningstone2=0;
          extraction2=20;
          double dos3=loadstone2+removestone2;
          loadremovestone2=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
      
      else if (optionoio.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
        
    }
    
     
    
    
    /////////////////////////////////////////////Starting//////////////////////////////////////////////////////////
    
    
    if (bathnumm==1) {
        
        gmf1=stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank;
        
        gdf1=(stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank)/60.0;
        
        //Write to recipe here //////////////////////////////////////////////////////////
        
Alert aloo = new Alert(Alert.AlertType.INFORMATION);
aloo.setTitle("Show Time");
aloo.setResizable(false);
aloo.setHeaderText("Here is time for "+recipenami+" of "+modelooo+" Customer.");
aloo.setContentText("This Recipe Was One Shot:\nTime In Minutes=   "+gmf1+"."+"\nTime In Hours=   "+gdf1+".");
DialogPane dialogPanej = aloo.getDialogPane();
dialogPanej.getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
aloo.showAndWait();
        
      /////////////////////////////////////////////////////////////////////////////////////////
      
      
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Save To DB");
alert.setHeaderText("Time Result");
alert.setContentText("Here Is The result of Time For "+recipenami+" Recipe.");
ButtonType buttonTypeOne = new ButtonType("Save To DB");
ButtonType buttonTypeCancel = new ButtonType("Cancel");
alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
DialogPane dialogPanei = alert.getDialogPane();
dialogPanei.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> results = alert.showAndWait();
if (results.isPresent() && results.get() == buttonTypeOne) {
//Save To DB.

  
      
      //////////////////////////////////////////////////
  //Here Will Write To DB...........................
  
      
      Date currentDate1 = GregorianCalendar.getInstance().getTime();
      DateFormat df1 = DateFormat.getDateInstance();
      String dateString1 = df1.format(currentDate1);
      Date d1 = new Date();
      SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
      String timeString1 = sdf1.format(d1);
      SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
      String timeString2 = sdf2.format(d1);
      String datevaluey = timeString2;                                                          //Date
      
      shoty=1;
      

       try {
           
                    String sql0 = "select * from Timer where Name like '" + recipenami + "' and Model like '" + modelooo + "' ";
                    pst = conn.prepareStatement(sql0);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                    //Update
                       
                       wifi="found";
                       
                   ///////    
                       
                    }
                    
    ///////////////////////////////////////////////////////////////////////////////////                
                    
                    
                    else {
                        
                       //Insert
                       
                   wifi="not_found";
                  
      //////////////////////////////////////////                  
                        

                    }
      
                    
    }
        
        catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    } 
     
       
       
       
       
     String fifi=wifi;
     
     
     if (fifi.equals("found")) {
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
                             
                          if (bosbos==1) {
                              
                           String ti1,ti2;
                           String ti3,ti4;
                           ti4=Integer.toString(shoty+1);
                           ti3=Integer.toString(shoty);
                           ti1=Double.toString(gdf1);
                           ti2=Double.toString(gdf2);
                           String mi1=Double.toString(gmf1);
                           String mi2=Double.toString(gmf2);
                           
                                 try {
       
                                     
                                                 
      String sqlm = "select * from Timer where Name=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
      
             
                                     
                String sqlp= "update Timer set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"', Total_Min='"+mi1+"', Total_Hour='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();
                                     
     
                
                
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti = Notifications.create();
      noti.title("Update!");
      noti.text("We Updated Record Successfully!");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
                       if (bosbos==2) {
                           
                               
                           String ti1,ti2;
                           String ti3,ti4;
                           ti4=Integer.toString(shoty+1);
                           ti3=Integer.toString(shoty);
                           ti1=Double.toString(gdf1);
                           ti2=Double.toString(gdf2);
                           String mi1=Double.toString(gmf1);
                           String mi2=Double.toString(gmf2);
                           
                           
                              try {
                                  
                                  
      String sqlm = "select * from Timer where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, ti3);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
   //   pst.execute();
                            
         
                String sqlp= "update Timer set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"', Total_Min='"+(Double.toString(gmf1+gmf2))+"', Total_Hour='"+(Double.toString(gdf1+gdf2))+"'  where Name='"+recipenami+"' and Shot='"+ti3+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();    
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti = Notifications.create();
      noti.title("Update!");
      noti.text("We Updated Record 1 Successfully!");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
        
      
      } catch (Exception exception) {}
    }    
                           
                              
                                 try {
                            
                                    
      String sqlm = "select * from Timer where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, filenammm);
      pst.setString(2, ti4);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin2=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour2=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+ti2+"', Total_Min='"+(Double.toString(gmf1+gmf2))+"', Total_Hour='"+(Double.toString(gdf1+gdf2))+"'  where Name='"+recipenami+"' and Shot='"+ti4+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();         
                                     
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti = Notifications.create();
      noti.title("Update!");
      noti.text("We Updated Record 2 Successfully!");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
        
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
         


         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
     }
       
       
     else if (fifi.equals("not_found")) {
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
         
                       if (bosbos==1) {
                           
                           
                                 try {
                            
          String reg = "insert into Timer (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated, Total_Min, Total_Hour) values (?,?,?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
          pst.setString(9,Double.toString(gmf1));
          pst.setString(10,Double.toString(gdf1));
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti = Notifications.create();
      noti.title("Insert!");
      noti.text("We Inserted Record Successfully!");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
                       if (bosbos==2) {
                           
                              try {
                            
          String reg = "insert into Timer (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated, Total_Min, Total_Hour) values (?,?,?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
          pst.setString(9,Double.toString(gmf1+gmf2));
          pst.setString(10,Double.toString(gdf1+gdf2));
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti = Notifications.create();
      noti.title("Insert!");
      noti.text("We Inserted Record 1 Successfully!");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      
      } catch (Exception exception) {}
    }    
                           
                              
                                 try {
                            
          String reg = "insert into Timer (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated, Total_Min, Total_Hour) values (?,?,?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
          pst.setString(9,Double.toString(gmf1+gmf2));
          pst.setString(10,Double.toString(gdf1+gdf2));
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti = Notifications.create();
      noti.title("Insert!");
      noti.text("We Inserted Record 2 Successfully!");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
        
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
        
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
     }
       
     
     else {}
       
       
      
      
      
      
      
      
      
      
      
      ////////////////////////////////END DB////////////////////////////////////////////////////
        
      

} 
else {}
      
      
      
    
      
    }
    
    else if (bathnumm==2) {
        
        gmf1=stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank;
        
        gdf1=(stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank)/60.0;
        
        gmf2=stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2;
        
        gdf2=(stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2)/60.0;
        
        
          //Write to recipe here //////////////////////////////////////////////////////////
          
          
          
Alert aloo = new Alert(Alert.AlertType.INFORMATION);
aloo.setTitle("Show Time");
aloo.setResizable(false);
aloo.setHeaderText("Here is time for "+recipenami+" of "+modelooo+" Customer.");
aloo.setContentText("This Recipe Was Two Shots:\nFirst Shot Info:\nTime In Minutes=   "+gmf1+"."+"\nTime In Hours=   "+gdf1+".\n\n"+"Second Shot Info:\nTime In Minutes=   "+gmf2+"."+"\nTime In Hours=   "+gdf2+".\n\n");
DialogPane dialogPanej = aloo.getDialogPane();
dialogPanej.getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
aloo.showAndWait();
       
        /////////////////////////////////////////////////////////////////////////////////
        
        
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Save To DB");
alert.setHeaderText("Time Result");
alert.setContentText("Here Is The result of Time For "+recipenami+" Recipe.");
ButtonType buttonTypeOne = new ButtonType("Save To DB");
ButtonType buttonTypeCancel = new ButtonType("Cancel");
alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
DialogPane dialogPanei = alert.getDialogPane();
dialogPanei.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> results = alert.showAndWait();
if (results.isPresent() && results.get() == buttonTypeOne) {
//Save To DB.

          
      //////////////////////////////////////////////////
  //Here Will Write To DB...........................
  
      
      Date currentDate1 = GregorianCalendar.getInstance().getTime();
      DateFormat df1 = DateFormat.getDateInstance();
      String dateString1 = df1.format(currentDate1);
      Date d1 = new Date();
      SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
      String timeString1 = sdf1.format(d1);
      SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
      String timeString2 = sdf2.format(d1);
      String datevaluey = timeString2;                                                          //Date
      
      shoty=1;
      

       try {
           
                    String sql0 = "select * from Timer where Name like '" + recipenami + "' and Model like '" + modelooo + "' ";
                    pst = conn.prepareStatement(sql0);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                    //Update
                       
                       wifi="found";
                       
                   ///////    
                       
                    }
                    
    ///////////////////////////////////////////////////////////////////////////////////                
                    
                    
                    else {
                        
                       //Insert
                       
                   wifi="not_found";
                  
      //////////////////////////////////////////                  
                        

                    }
      
                    
    }
        
        catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    } 
     
       
       
       
       
     String fifi=wifi;
     
     
     if (fifi.equals("found")) {
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
                             
                          if (bosbos==1) {
                              
                           String ti1,ti2;
                           String ti3,ti4;
                           ti4=Integer.toString(shoty+1);
                           ti3=Integer.toString(shoty);
                           ti1=Double.toString(gdf1);
                           ti2=Double.toString(gdf2);
                           String mi1=Double.toString(gmf1);
                           String mi2=Double.toString(gmf2);
                           
                                 try {
       
                                     
                                                 
      String sqlm = "select * from Timer where Name=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
      
             
                                     
                String sqlp= "update Timer set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"', Total_Min='"+(mi1)+"', Total_Hour='"+(ti1)+"'  where Name='"+recipenami+"' and Shot='"+ti3+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();
                                     
     
                
                
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
                       if (bosbos==2) {
                           
                               
                           String ti1,ti2;
                           String ti3,ti4;
                           ti4=Integer.toString(shoty+1);
                           ti3=Integer.toString(shoty);
                           ti1=Double.toString(gdf1);
                           ti2=Double.toString(gdf2);
                           String mi1=Double.toString(gmf1);
                           String mi2=Double.toString(gmf2);
                           
                           
                              try {
                                  
                                  
      String sqlm = "select * from Timer where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, ti3);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
   //   pst.execute();
                            
         
                String sqlp= "update Timer set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"', Total_Min='"+(gmf1+gmf2)+"', Total_Hour='"+(gdf1+gdf2)+"'  where Name='"+recipenami+"' and Shot='"+ti3+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();    
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                              
                                 try {
                            
                                    
      String sqlm = "select * from Timer where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, filenammm);
      pst.setString(2, ti4);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin2=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour2=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+ti2+"', Total_Min='"+(gmf1+gmf2)+"', Total_Hour='"+(gdf1+gdf2)+"'  where Name='"+recipenami+"' and Shot='"+ti4+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();         
                                     
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
         


         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
     }
       
       
     else if (fifi.equals("not_found")) {
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
         
                       if (bosbos==1) {
                           
                           
                                 try {
                            
          String reg = "insert into Timer (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated, Total_Min, Total_Hour) values (?,?,?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
          pst.setString(9,Double.toString(gmf1));
          pst.setString(10,Double.toString(gdf1));
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
                       if (bosbos==2) {
                           
                              try {
                            
          String reg = "insert into Timer (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated, Total_Min, Total_Hour) values (?,?,?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
          pst.setString(9,Double.toString(gmf1+gmf2));
          pst.setString(10,Double.toString(gdf1+gdf2));
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                              
                                 try {
                            
          String reg = "insert into Timer (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated, Total_Min, Total_Hour) values (?,?,?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
          pst.setString(9,Double.toString(gmf1+gmf2));
          pst.setString(10,Double.toString(gdf1+gdf2));
          
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
        
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
     }
       
     
     else {}
       
       
      
      ////////////////////////////////END DB////////////////////////////////////////////////////
       

} 
else {}
        
        
  
        //////////////////////////////////////////////////////////////////////////////////
        
    }
    
    
    else {
        
        //Noti
        
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, We don't have 3 shots in one recipe.\nWe are working on this feature");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showError();
    }
    
    
    /////////////////////////////////////////////Ending////////////////////////////////////////////////////////////
   
    
}   
  





@FXML
void calcostac(ActionEvent event) throws IOException, Exception {      
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
FileChooser fcho = new FileChooser();
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
fcho.setTitle("Kady Choose");
File f = fcho.showOpenDialog((Window)null);
String recipenami=f.getName().replace(".ks","").replace(".html","");
String recipepathy = f.getAbsolutePath().toString();

String didd1=NewDir.file_dir+"\\DEVELOPMENT\\";
String didd2="\\"+f.getName();

String modelooo=recipepathy.replace(didd1,"").replace(didd2,"");


    ////////////////////////////////////////////////////////////

    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String resultk = KeyDecoder.extractData(longKey.trim());
    if (f == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = f.getAbsolutePath();
    String nameofit=recipenami;
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
 
    FileDecryptor.decrypt(input, tempOutput, resultk);
    File temp = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////



//////////////////////////////////////////////////////////////////////////////////////////////////////////
InputStream inputinstream=new FileInputStream(temp);
BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
String lo;
lili.clear();
while ((lo=bi.readLine())!=null) {        
lili.appendText("\n"+lo
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

	
	////////////////////////////////////////////////////////////////
    if (temp.exists()) {
        temp.delete();
    }
    ////////////////////////////////////////////////////////////////
	
	

String gf=lili.getText();
OutputStream instreamm=new FileOutputStream(System.getProperty("user.home")+"\\r.ks");
PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
pwe.println(gf);
pwe.close();
///////////////////////////////////////////////////////////////////////////////////////////////////////////   
List<Double> pri = new ArrayList<>();
List<Double> qua = new ArrayList<>();
List<Double> dil = new ArrayList<>();
List<String> nom = new ArrayList<>();

////////////////////////////////////////////////
File inputFile = new File(System.getProperty("user.home")+"\\r.ks"); //
org.jsoup.nodes.Document docj = Jsoup.parse(inputFile, "UTF-8"); //
//Document docj = Jsoup.parse(codee);
for (Element table : docj.select("TABLE")) {
for (Element row : table.select("TR")) {
Elements tds = row.select("TD");
if (tds.get(8).text().isEmpty()||tds.get(8).text().contains("OLD STONE")) {   
}
else { 
String string = tds.get(8).text();
BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirrrr + "\\Recipe_Indexes\\Prices.kady"));
String line;
String linebeforeequal;
String lineafterequal;
boolean found = false;
while ((line = buf.readLine()) != null) {
linebeforeequal = line.substring(0, line.indexOf("=$"));  // Item
lineafterequal = line.substring(line.indexOf("=$") + 2);  // Price
if (string.equals(linebeforeequal)) {
    System.out.println(linebeforeequal);
double number1 = Double.parseDouble(lineafterequal);
pri.add(number1);
String itaam = linebeforeequal;
nom.add(itaam);
found = true;
break;
}
}
// If the item wasn't found in the file, add it to the except variable
//if (!found) {
//except = except + "\n" + tds.get(7).text();
//}
buf.close();   
//String string=tds.get(8).text();
//BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Prices.kady"));
//String line;
//String linebeforeequal;
//String lineafterequal;
//while ((line=buf.readLine())!=null) {       
//linebeforeequal=line.substring(0,line.indexOf("=$")-0);  //Item
//lineafterequal=line.substring(line.indexOf("=$") + 2 , line.length());  //Price
//if (string.equals(linebeforeequal)) {
//double number1 = Double.parseDouble(lineafterequal);
//pri.add(number1);
//String itaam = linebeforeequal;
//nom.add(itaam);
//break;
//}
//else {
//except=except+"\n"+tds.get(7).text();    
//}
//}
//buf.close();



}          
//////////////////////KG//////////////////////////
String skip=tds.get(8).text();
if (skip.equals("OLD STONE")) {   
}
else {
if (tds.get(5).text().isEmpty()||tds.get(5).text().contains("/")||tds.get(5).text().contains("\\")||tds.get(5).text().contains("OPERATPR")||tds.get(5).text().contains("OPERATOR")||tds.get(5).text().contains("AMOUNT")||tds.get(5).text().contains("AMT")||tds.get(5).text().contains("-")||tds.get(5).text().contains("DATE")||tds.get(5).text().contains("WASH")||tds.get(5).text().contains("WASH NAME")) {}
else if (tds.get(6).text().contains("GR")||tds.get(6).text().contains("Gr")||tds.get(6).text().contains("gr")) {
double am=(Double.parseDouble(tds.get(5).text().replace(",","."))/1000);
String amm=Double.toString(am);
if (amm.contains("E")) { 
BigDecimal bd = new BigDecimal(amm);
double val = bd.doubleValue();
qua.add(val);   
}
else {
qua.add(am);
}
}

else if (tds.get(6).text().contains("GARDAL")||tds.get(6).text().contains("GARDEL")
||tds.get(6).text().contains("Gardal")||tds.get(6).text().contains("Gardel")||tds.get(6).text().contains("gardal")||tds.get(6).text().contains("gardel")) {
String sky=tds.get(8).text();
if (sky.equals("FOAM")) {
double am=4.0/5.0;
qua.add(am);   
}
else {
double am=Double.parseDouble(tds.get(5).text().replace(",","."))*12;
qua.add(am);    
}
}
else {
double number2 = Double.parseDouble(tds.get(5).text());
qua.add(number2);
}    
}
//////////////////////////////////////////////
if (tds.get(8).text().isEmpty()||tds.get(8).text().contains("/")||tds.get(8).text().contains("\\")||tds.get(8).text().contains("CHEMICAL")||tds.get(8).text().contains("chemical")||tds.get(8).text().matches("[0-9_-]+")||tds.get(8).text().contains("TIME")||tds.get(8).text().contains("HOURS")||tds.get(8).text().contains("MINS")||tds.get(8).text().contains("SHOT")||tds.get(8).text().contains("OLD STONE")) {    
}
else {  
String string = tds.get(8).text();
BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirrrr + "\\Recipe_Indexes\\Dilution.kady"));
String line;
boolean found = false;
while ((line = buf.readLine()) != null) {
String linebeforeequal = line.substring(0, line.indexOf("=")).trim();  // Item
String lineafterequal = line.substring(line.indexOf("=") + 1).trim();  // Dilution
if (string.equals(linebeforeequal)) {
double number3 = Double.parseDouble(lineafterequal);
dil.add(number3);
found = true;
break;
}
}
if (!found) {
double number3 = Double.parseDouble("1.0");
dil.add(number3);
}
buf.close();
}
///////////////////////////////////////////////
}}    
if (qua.size()!=pri.size()||qua.size()!=dil.size()) { 
Notifications noti = Notifications.create();
noti.title("Fatal Error!");
noti.text("We found that all chemicals names weren't set.\nWe suggest to fix chemicals again.");
noti.position(Pos.CENTER);
noti.hideAfter(Duration.seconds(10));
noti.showError();
}
else {
//Show alert to write pcs.    
List<Double> result = new ArrayList<>();
for (int i = 0; i < qua.size(); i++) {
result.add((qua.get(i) / dil.get(i))* pri.get(i));
}
double sum = 0.0;
for (double number : result) {
sum += number;
}
JFXTextField grr = new JFXTextField("120");
grr.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
grr.setLabelFloat(true);
grr.setPromptText("Add PCS Number ...");
grr.setMinSize(300.0D, 25.0D);
Alert aloo = new Alert(Alert.AlertType.INFORMATION);
aloo.setTitle("PCS Number?");
aloo.setGraphic((Node)grr);
aloo.setResizable(false);
DialogPane dialogPane = aloo.getDialogPane();
dialogPane.getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
aloo.showAndWait();
double pcsnum=Double.parseDouble(grr.getText()+".0");
double onegar=sum/pcsnum;




Alert alertd = new Alert(Alert.AlertType.CONFIRMATION);
alertd.setTitle("Save To DB");
alertd.setHeaderText("Cost Result");
alertd.setContentText("Here Is The result of Cost For "+recipenami+" Recipe.");
ButtonType buttonTypeOned = new ButtonType("Save To DB");
ButtonType buttonTypeCanceld = new ButtonType("Cancel");
alertd.getButtonTypes().setAll(buttonTypeOned, buttonTypeCanceld);
DialogPane dialogPaneid = alertd.getDialogPane();
dialogPaneid.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> resultsd = alertd.showAndWait();
if (resultsd.isPresent() && resultsd.get() == buttonTypeOned) {
    //Save To DB Here.
Date currentDate1 = GregorianCalendar.getInstance().getTime();
DateFormat df1 = DateFormat.getDateInstance();
String dateString1 = df1.format(currentDate1);
Date d1 = new Date();
SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
String timeString1 = sdf1.format(d1);
SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
String dateString2 = sdf2.format(d1);
String alldaty=dateString2+" \\ "+timeString1;
try {
String sql0 = "select * from Development_Cost where Name like '" + recipenami + "' and Model like '" + modelooo + "' ";
pst = conn.prepareStatement(sql0);
rs = pst.executeQuery();                    
if (rs.next()) {                        
//Update
find="found";   
}                    
else {
//Insert
find="not_found";   
}        
}catch (Exception exception) {
} 
finally {
try {
rs.close();
pst.close();     
} catch (Exception exception) {}
}
if (find.equals("found")) {
try {
String sqlm = "select * from Development_Cost where Name=? and Model=?";
pst = conn.prepareStatement(sqlm);
pst.setString(1, recipenami);
pst.setString(2, modelooo);
rs = pst.executeQuery();      
String addd1 = rs.getString("Total_Cost_Old");
oldtotalcost=addd1;
String addd2 = rs.getString("PCS_Old");
oldpcs=addd2;      
String addd3 = rs.getString("One_Garment_Old");
oldonegarmentcost=addd3;

String sqlp= "update Development_Cost set Date='"+dateString2+"', Total_Cost_Old='"+oldtotalcost+"', PCS_Old='"+oldpcs+"', One_Garment_Old='"+oldonegarmentcost+"', Total_Cost_New='"+Double.toString(sum)+"', PCS_New='"+Double.toString(pcsnum)+"', One_Garment_New='"+Double.toString(onegar)+"' where Name='"+filenammm+"'";
pst=conn.prepareStatement(sqlp);
pst.execute();
}                        
catch (Exception exception) {
} 
finally {
try {
rs.close();
pst.close();
Notifications noti = Notifications.create();
noti.title("Successful");
noti.text("We have updated the cost successfully.");
noti.hideAfter(Duration.seconds(3));
noti.position(Pos.CENTER);
noti.showInformation();
} catch (Exception exception) {}
}                               
}
else if (find.equals("not_found")) {
try {                            
String reg = "insert into Development_Cost (Date, Model, Name, Total_Cost_Old, PCS_Old, One_Garment_Old, Total_Cost_New, PCS_New, One_Garment_New) values (?,?,?,?,?,?,?,?,?)";
pst = conn.prepareStatement(reg);
pst.setString(1,dateString2);
pst.setString(2,modelooo);
pst.setString(3,recipenami);

pst.setString(4,Double.toString(sum));
pst.setString(5,Double.toString(pcsnum));
pst.setString(6,Double.toString(onegar));

pst.setString(7,"Hasnot_Updated_Yet");
pst.setString(8,"Hasnot_Updated_Yet");
pst.setString(9,"Hasnot_Updated_Yet");

pst.execute(); 
}                                            
catch (Exception exception) {
} 
finally {
try {
rs.close();
pst.close();
Notifications noti = Notifications.create();
noti.title("Successful");
noti.text("We have inserted the new cost successfully.");
noti.hideAfter(Duration.seconds(3));
noti.position(Pos.CENTER);
noti.showInformation();
} catch (Exception exception) {}
}                               
}
else{}
}


else {}

Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Result");
alert.setHeaderText("Cost Result");
alert.setContentText("Here is the result of chemicals costs for one garment  :   "+Double.toString(onegar)+"   $.");
ButtonType buttonTypeOne = new ButtonType("Report");
ButtonType buttonTypeCancel = new ButtonType("Cancel");
alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
DialogPane dialogPanei = alert.getDialogPane();
dialogPanei.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> results = alert.showAndWait();
if (results.isPresent() && results.get() == buttonTypeOne) {
//Create Report.  (PDF)
    ////////////////////////////Start Report//////////////////////////////
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String timeString = sdf.format(d);
    String value0 = timeString;
    String value00 = value0.replace("/", "_");
    String repname = "Chemical_Report_Of_"+recipenami;
    String reppath = System.getProperty("user.home") + "\\Desktop";
    FileChooser dialog = new FileChooser();
    dialog.setInitialDirectory(new File(reppath));
    dialog.setInitialFileName(repname);
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", new String[] { "*.pdf" }));
    File dialogResult = dialog.showSaveDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();
    try {
      com.itextpdf.text.Document myDocument = new com.itextpdf.text.Document();
      PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
      PdfPTable table = new PdfPTable(5);
      table.size();
      //table.setHorizontalAlignment(1);
      myDocument.open();
      float[] columnWidths = { 15.0F, 15.0F,15.0F,15.0F,15.0F };
      table.setWidths(columnWidths);
      table.setWidthPercentage(100.0F);
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Cost Report For "+recipenami+" Recipe. ", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------------------------------------------------------------------"));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Name", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Quantity", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Dilution", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Price", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Total", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      int no=0;
      int stageno=1;
      while (no<qua.size()) {                                                                                                                
      table.addCell(new PdfPCell((Phrase)new Paragraph(nom.get(no), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(qua.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(dil.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(pri.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString((qua.get(no)/dil.get(no))*pri.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      no++;
      } 
      myDocument.add((com.itextpdf.text.Element)table);
      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------"));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost (New) :    "+Double.toString(sum)+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments (New) :    "+Double.toString(pcsnum)+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs (New) :    "+Double.toString(onegar)+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost (Old) :    "+oldtotalcost+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments (Old) :    "+oldpcs+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs (Old) :    "+oldonegarmentcost+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------"));
      myDocument.setPageSize(PageSize.A4.rotate());
      myDocument.close();
      Alert alooo = new Alert(Alert.AlertType.CONFIRMATION);
      alooo.setTitle("Info");
      alooo.setHeaderText("Info!");
      alooo.setContentText("Report was generated successfully");
      alooo.setResizable(true);
      DialogPane dialogPaneu = alooo.getDialogPane();
      dialogPaneu.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
      alooo.showAndWait();
    } catch (Exception e) {
    } finally {
      try {
      } catch (Exception e) {
      } 
    } 
    Desktop de = Desktop.getDesktop();
    de.open(new File(reppath + "\\" + repname + ".pdf"));
    ////////////////////////////End Report////////////////////////////////
} 
else {}
}   
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}












@FXML
void calcostaction(ActionEvent event) throws IOException, Exception, Exception {      
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
FileChooser fcho = new FileChooser();
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
fcho.setTitle("Kady Choose");
File f = fcho.showOpenDialog((Window)null);
String recipenami=f.getName().replace(".ks","").replace(".html","");
String recipepathy = f.getAbsolutePath().toString();

String didd1=NewDir.file_dir+"\\PRODUCTION\\";
String didd2="\\"+f.getName();

String modelooo=recipepathy.replace(didd1,"").replace(didd2,"");


    ////////////////////////////////////////////////////////////

    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String resultl = KeyDecoder.extractData(longKey.trim());
    if (f == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = f.getAbsolutePath();
    String nameofit=recipenami;
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
 
    FileDecryptor.decrypt(input, tempOutput, resultl);
    File temp = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////


//////////////////////////////////////////////////////////////////////////////////////////////////////////
InputStream inputinstream=new FileInputStream(temp);
BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
String lo;
lili.clear();
while ((lo=bi.readLine())!=null) {        
lili.appendText("\n"+lo
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


	
    ////////////////////////////////////////////////////////////////
    if (temp.exists()) {
        temp.delete();
    }
    ////////////////////////////////////////////////////////////////
	
	
	

String gf=lili.getText();
OutputStream instreamm=new FileOutputStream(System.getProperty("user.home")+"\\r.ks");
PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
pwe.println(gf);
pwe.close();
///////////////////////////////////////////////////////////////////////////////////////////////////////////   
List<Double> pri = new ArrayList<>();
List<Double> qua = new ArrayList<>();
List<Double> dil = new ArrayList<>();
List<String> nom = new ArrayList<>();

////////////////////////////////////////////////
File inputFile = new File(System.getProperty("user.home")+"\\r.ks"); //
org.jsoup.nodes.Document docj = Jsoup.parse(inputFile, "UTF-8"); //
//Document docj = Jsoup.parse(codee);
for (Element table : docj.select("TABLE")) {
for (Element row : table.select("TR")) {
Elements tds = row.select("TD");
if (tds.get(8).text().isEmpty()||tds.get(8).text().contains("OLD STONE")) {   
}
else { 
String string = tds.get(8).text();
BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirrrr + "\\Recipe_Indexes\\Prices.kady"));
String line;
String linebeforeequal;
String lineafterequal;
boolean found = false;
while ((line = buf.readLine()) != null) {
linebeforeequal = line.substring(0, line.indexOf("=$"));  // Item
lineafterequal = line.substring(line.indexOf("=$") + 2);  // Price
if (string.equals(linebeforeequal)) {
    System.out.println(linebeforeequal);
double number1 = Double.parseDouble(lineafterequal);
pri.add(number1);
String itaam = linebeforeequal;
nom.add(itaam);
found = true;
break;
}
}
// If the item wasn't found in the file, add it to the except variable
//if (!found) {
//except = except + "\n" + tds.get(7).text();
//}
buf.close();   
//String string=tds.get(8).text();
//BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Prices.kady"));
//String line;
//String linebeforeequal;
//String lineafterequal;
//while ((line=buf.readLine())!=null) {       
//linebeforeequal=line.substring(0,line.indexOf("=$")-0);  //Item
//lineafterequal=line.substring(line.indexOf("=$") + 2 , line.length());  //Price
//if (string.equals(linebeforeequal)) {
//double number1 = Double.parseDouble(lineafterequal);
//pri.add(number1);
//String itaam = linebeforeequal;
//nom.add(itaam);
//break;
//}
//else {
//except=except+"\n"+tds.get(7).text();    
//}
//}
//buf.close();



}          
//////////////////////KG//////////////////////////
String skip=tds.get(8).text();
if (skip.equals("OLD STONE")) {   
}
else {
if (tds.get(5).text().isEmpty()||tds.get(5).text().contains("/")||tds.get(5).text().contains("\\")||tds.get(5).text().contains("OPERATPR")||tds.get(5).text().contains("OPERATOR")||tds.get(5).text().contains("AMOUNT")||tds.get(5).text().contains("AMT")||tds.get(5).text().contains("-")||tds.get(5).text().contains("DATE")||tds.get(5).text().contains("WASH")||tds.get(5).text().contains("WASH NAME")) {}
else if (tds.get(6).text().contains("GR")||tds.get(6).text().contains("Gr")||tds.get(6).text().contains("gr")) {
double am=(Double.parseDouble(tds.get(5).text().replace(",","."))/1000);
String amm=Double.toString(am);
if (amm.contains("E")) { 
BigDecimal bd = new BigDecimal(amm);
double val = bd.doubleValue();
qua.add(val);   
}
else {
qua.add(am);
}
}

else if (tds.get(6).text().contains("GARDAL")||tds.get(6).text().contains("GARDEL")
||tds.get(6).text().contains("Gardal")||tds.get(6).text().contains("Gardel")||tds.get(6).text().contains("gardal")||tds.get(6).text().contains("gardel")) {
String sky=tds.get(8).text();
if (sky.equals("FOAM")) {
double am=4.0/5.0;
qua.add(am);   
}
else {
double am=Double.parseDouble(tds.get(5).text().replace(",","."))*12;
qua.add(am);    
}
}
else {
double number2 = Double.parseDouble(tds.get(5).text());
qua.add(number2);
}    
}
//////////////////////////////////////////////
if (tds.get(8).text().isEmpty()||tds.get(8).text().contains("/")||tds.get(8).text().contains("\\")||tds.get(8).text().contains("CHEMICAL")||tds.get(8).text().contains("chemical")||tds.get(8).text().matches("[0-9_-]+")||tds.get(8).text().contains("TIME")||tds.get(8).text().contains("HOURS")||tds.get(8).text().contains("MINS")||tds.get(8).text().contains("SHOT")||tds.get(8).text().contains("OLD STONE")) {    
}
else {  
String string = tds.get(8).text();
BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirrrr + "\\Recipe_Indexes\\Dilution.kady"));
String line;
boolean found = false;
while ((line = buf.readLine()) != null) {
String linebeforeequal = line.substring(0, line.indexOf("=")).trim();  // Item
String lineafterequal = line.substring(line.indexOf("=") + 1).trim();  // Dilution
if (string.equals(linebeforeequal)) {
double number3 = Double.parseDouble(lineafterequal);
dil.add(number3);
found = true;
break;
}
}
if (!found) {
double number3 = Double.parseDouble("1.0");
dil.add(number3);
}
buf.close();
}
///////////////////////////////////////////////
}}    
if (qua.size()!=pri.size()||qua.size()!=dil.size()) { 
Notifications noti = Notifications.create();
noti.title("Fatal Error!");
noti.text("We found that all chemicals names weren't set.\nWe suggest to fix chemicals again.");
noti.position(Pos.CENTER);
noti.hideAfter(Duration.seconds(10));
noti.showError();
}
else {
    
    
//Show alert to write pcs.    
List<Double> result = new ArrayList<>();
for (int i = 0; i < qua.size(); i++) {
result.add((qua.get(i) / dil.get(i))* pri.get(i));
}
double sum = 0.0;
for (double number : result) {
sum += number;
}


////////////////////////////////////////////////////////////////////////////////////////////
            // Parse the HTML file
            org.jsoup.nodes.Document docv = Jsoup.parse(inputFile, "UTF-8");
            // Find all table rows
            Elements rows = docv.select("tr");
            boolean pcsFound = false;
            for (Element row : rows) {
                Elements cells = row.select("td");
                for (int i = 0; i < cells.size(); i++) {
                    if ("PCS".equalsIgnoreCase(cells.get(i).text().trim())) {
                        if (i + 1 < cells.size()) {
                            String nextValue = cells.get(i + 1).text().trim();
                            System.out.println("Next value after PCS: " + nextValue);
                            pecoco=nextValue;
                        } else {
                            System.out.println("PCS found but no next cell.");
                            pecoco="120";
                        }
                        pcsFound = true;
                        break;
                    }
                    else if (cells.get(i).text().trim().contains("PCS")) {
                        if (i + 1 < cells.size()) {
                            String nextValue = cells.get(i + 1).text().trim();
                            System.out.println("Next value after PCS: " + nextValue);
                            pecoco=nextValue;
                        } else {
                            System.out.println("PCS found but no next cell.");
                            pecoco="120";
                        }
                        pcsFound = true;
                        break;
                    }
                }

                if (pcsFound) break;
            }

            if (!pcsFound) {
                System.out.println("PCS not found");
                pecoco="";
            }
/////////////////////////////////////////////////////////////////////////////////////////////
JFXTextField grr = new JFXTextField(pecoco);
grr.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
grr.setLabelFloat(true);
grr.setPromptText("Add PCS Number ...");
grr.setMinSize(300.0D, 25.0D);
Alert aloo = new Alert(Alert.AlertType.INFORMATION);
aloo.setTitle("PCS Number?");
aloo.setGraphic((Node)grr);
aloo.setResizable(false);
DialogPane dialogPane = aloo.getDialogPane();
dialogPane.getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
aloo.showAndWait();
double pcsnum=Double.parseDouble(grr.getText()+".0");
double onegar=sum/pcsnum;




Alert alertd = new Alert(Alert.AlertType.CONFIRMATION);
alertd.setTitle("Save To DB");
alertd.setHeaderText("Cost Result");
alertd.setContentText("Here Is The result of Cost For "+recipenami+" Recipe.");
ButtonType buttonTypeOned = new ButtonType("Save To DB");
ButtonType buttonTypeCanceld = new ButtonType("Cancel");
alertd.getButtonTypes().setAll(buttonTypeOned, buttonTypeCanceld);
DialogPane dialogPaneid = alertd.getDialogPane();
dialogPaneid.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> resultsd = alertd.showAndWait();
if (resultsd.isPresent() && resultsd.get() == buttonTypeOned) {
    //Save To DB Here.
Date currentDate1 = GregorianCalendar.getInstance().getTime();
DateFormat df1 = DateFormat.getDateInstance();
String dateString1 = df1.format(currentDate1);
Date d1 = new Date();
SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
String timeString1 = sdf1.format(d1);
SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
String dateString2 = sdf2.format(d1);
String alldaty=dateString2+" \\ "+timeString1;
try {
String sql0 = "select * from Cost where Name like '" + recipenami + "' and Model like '" + modelooo + "' ";
pst = conn.prepareStatement(sql0);
rs = pst.executeQuery();                    
if (rs.next()) {                        
//Update
find="found";   
}                    
else {
//Insert
find="not_found";   
}        
}catch (Exception exception) {
} 
finally {
try {
rs.close();
pst.close();     
} catch (Exception exception) {}
}
if (find.equals("found")) {
try {
String sqlm = "select * from Cost where Name=? and Model=?";
pst = conn.prepareStatement(sqlm);
pst.setString(1, recipenami);
pst.setString(2, modelooo);
rs = pst.executeQuery();      
String addd1 = rs.getString("Total_Cost_Old");
oldtotalcost=addd1;
String addd2 = rs.getString("PCS_Old");
oldpcs=addd2;      
String addd3 = rs.getString("One_Garment_Old");
oldonegarmentcost=addd3;

String sqlp= "update Cost set Date='"+dateString2+"', Total_Cost_Old='"+oldtotalcost+"', PCS_Old='"+oldpcs+"', One_Garment_Old='"+oldonegarmentcost+"', Total_Cost_New='"+Double.toString(sum)+"', PCS_New='"+Double.toString(pcsnum)+"', One_Garment_New='"+Double.toString(onegar)+"' where Name='"+filenammm+"'";
pst=conn.prepareStatement(sqlp);
pst.execute();
}                        
catch (Exception exception) {
} 
finally {
try {
rs.close();
pst.close();
Notifications noti = Notifications.create();
noti.title("Successful");
noti.text("We have updated the cost successfully.");
noti.hideAfter(Duration.seconds(3));
noti.position(Pos.CENTER);
noti.showInformation();
} catch (Exception exception) {}
}                               
}
else if (find.equals("not_found")) {
try {                            
String reg = "insert into Cost (Date, Model, Name, Total_Cost_Old, PCS_Old, One_Garment_Old, Total_Cost_New, PCS_New, One_Garment_New) values (?,?,?,?,?,?,?,?,?)";
pst = conn.prepareStatement(reg);
pst.setString(1,dateString2);
pst.setString(2,modelooo);
pst.setString(3,recipenami);

pst.setString(4,Double.toString(sum));
pst.setString(5,Double.toString(pcsnum));
pst.setString(6,Double.toString(onegar));

pst.setString(7,"Hasnot_Updated_Yet");
pst.setString(8,"Hasnot_Updated_Yet");
pst.setString(9,"Hasnot_Updated_Yet");

pst.execute(); 
}                                            
catch (Exception exception) {
} 
finally {
try {
rs.close();
pst.close();
Notifications noti = Notifications.create();
noti.title("Successful");
noti.text("We have inserted the new cost successfully.");
noti.hideAfter(Duration.seconds(3));
noti.position(Pos.CENTER);
noti.showInformation();
} catch (Exception exception) {}
}                               
}
else{}
}


else {}

Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Result");
alert.setHeaderText("Cost Result");
alert.setContentText("Here is the result of chemicals costs for one garment  :   "+Double.toString(onegar)+"   $.");
ButtonType buttonTypeOne = new ButtonType("Report");
ButtonType buttonTypeCancel = new ButtonType("Cancel");
alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
DialogPane dialogPanei = alert.getDialogPane();
dialogPanei.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> results = alert.showAndWait();
if (results.isPresent() && results.get() == buttonTypeOne) {
//Create Report.  (PDF)
    ////////////////////////////Start Report//////////////////////////////
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String timeString = sdf.format(d);
    String value0 = timeString;
    String value00 = value0.replace("/", "_");
    String repname = "Chemical_Report_Of_"+recipenami;
    String reppath = System.getProperty("user.home") + "\\Desktop";
    FileChooser dialog = new FileChooser();
    dialog.setInitialDirectory(new File(reppath));
    dialog.setInitialFileName(repname);
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", new String[] { "*.pdf" }));
    File dialogResult = dialog.showSaveDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();
    try {
      com.itextpdf.text.Document myDocument = new com.itextpdf.text.Document();
      PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
      PdfPTable table = new PdfPTable(5);
      table.size();
      //table.setHorizontalAlignment(1);
      myDocument.open();
      float[] columnWidths = { 15.0F, 15.0F,15.0F,15.0F,15.0F };
      table.setWidths(columnWidths);
      table.setWidthPercentage(100.0F);
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Cost Report For "+recipenami+" Recipe. ", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------------------------------------------------------------------"));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Name", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Quantity", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Dilution", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Price", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Total", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      int no=0;
      int stageno=1;
      while (no<qua.size()) {                                                                                                                
      table.addCell(new PdfPCell((Phrase)new Paragraph(nom.get(no), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(qua.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(dil.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(pri.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString((qua.get(no)/dil.get(no))*pri.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      no++;
      } 
      myDocument.add((com.itextpdf.text.Element)table);
      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------"));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost (New) :    "+Double.toString(sum)+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments (New) :    "+Double.toString(pcsnum)+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs (New) :    "+Double.toString(onegar)+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost (Old) :    "+oldtotalcost+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments (Old) :    "+oldpcs+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs (Old) :    "+oldonegarmentcost+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------"));
      myDocument.setPageSize(PageSize.A4.rotate());
      myDocument.close();
      Alert alooo = new Alert(Alert.AlertType.CONFIRMATION);
      alooo.setTitle("Info");
      alooo.setHeaderText("Info!");
      alooo.setContentText("Report was generated successfully");
      alooo.setResizable(true);
      DialogPane dialogPaneu = alooo.getDialogPane();
      dialogPaneu.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
      alooo.showAndWait();
    } catch (Exception e) {
    } finally {
      try {
      } catch (Exception e) {
      } 
    } 
    Desktop de = Desktop.getDesktop();
    de.open(new File(reppath + "\\" + repname + ".pdf"));
    ////////////////////////////End Report////////////////////////////////
} 
else {}
}   
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}





  
   @FXML
  void fixalllaction(ActionEvent event) throws IOException {
        
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("FixMultipleLOT.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Fix LOT Numbers All By One");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
           
  }
  
  @FXML
  void fixallaction(ActionEvent event) throws IOException {
        
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("FixMultiple.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Fix Chemicals All By One");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
           
  }
  
  @FXML
  void fixoneeaction(ActionEvent event) throws IOException {
      
      
      
      //////////////////////////////////////////////Start//////////////////////////////////////////////////
      
          
    //FileChooser to choose recipe.
    FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String nami=f.getName().replace(".ks","").replace(".html","");
    String pathy = f.getAbsolutePath().toString();
    
    
    
        ////////////////////////////////////////////////////////////
    
    

    try {
    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String result = KeyDecoder.extractData(longKey.trim());
    if (f == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = f.getAbsolutePath();
    File originalFile = new File(input);
    //Add backup here
    File backupFolder = new File("D:\\All_Recipessss\\Backup");
    if (!backupFolder.exists()) {
        backupFolder.mkdirs();
    }
    String backupFileName = originalFile.getName() + ".bak";
    File backupFile = new File(backupFolder, backupFileName);
    try {
        java.nio.file.Files.copy(originalFile.toPath(), 
                                backupFile.toPath(), 
                                java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        System.out.println("✅ Backup created / updated: " + backupFile.getAbsolutePath());
    } catch (Exception backupEx) {
        System.out.println("⚠️ Warning: Failed to create backup - " + backupEx.getMessage());
    }
    // =================================================
    
    String tempOutput = input + ".tmp";
    System.out.println("Decrypting with password: " + result); // للتصحيح
    FileDecryptor.decrypt(input, tempOutput, result);
    File original = new File(input);
    File temp = new File(tempOutput);
    if (original.exists()) {
        original.delete();
    }
    if (temp.renameTo(original)) {
        Notifications noti = Notifications.create();
        noti.title("Success!");
        noti.text("File decrypted successfully.");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showInformation();
    } else {
        Notifications noti = Notifications.create();
        noti.title("Error!");
        noti.text("Failed to replace original file.");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
    }
} catch (Exception ex) {
    ex.printStackTrace();
    String errorMsg = "Wrong password or corrupted file.";
    if (ex.getClass().getSimpleName().contains("AEADBadTag") || 
        ex.getMessage() != null && ex.getMessage().contains("BadTag")) {
        errorMsg = "Wrong password! The key does not match the file.";
    }
    Notifications noti = Notifications.create();
    noti.title("Decryption Failed!");
    noti.text(errorMsg);
    noti.position(Pos.CENTER);
    noti.hideAfter(Duration.seconds(5));
    noti.showError();
}



    ////////////////////////////////////////////////////////////
	
	
    
   
    myarea.clear();
    
    InputStream inputinstream=new FileInputStream(pathy);
    BufferedReader bufy=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    
    //BufferedReader bufy=new BufferedReader (new FileReader (pathy));
    String liin;
    while ((liin=bufy.readLine())!=null) {
        myarea.appendText(liin.replace("ﬦ","A")
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
       .replace("&NBSP;","") +"\n");
    }
    bufy.close();
    String code = myarea.getText();
      if (!code.contains("TABLE")) {
      Notifications noti = Notifications.create();
      noti.title("Recipe Error");
      noti.text("Maybe not a recipe, Open a recipe first!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showError();    
        }
        else {
            org.jsoup.nodes.Document doc = Jsoup.parse(code);
        for (Element table : doc.select("TABLE")) {
        for (Element row : table.select("TR")) {
            Elements tds = row.select("TD");
            if (tds.get(8).text().isEmpty()) {   
            }
            
           
            else {  
             ///////////////////////////////////////////////////////////////
String string=tds.get(8).text();
BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Lot_Numbers.kady"));
String line;
String linebeforeequal;//Chemical Name
String lineafterequal;//Lot Numbers
boolean found = false;         
while ((line=buf.readLine())!=null) {
linebeforeequal=line.substring(0,line.indexOf("="));//Chemical Name
lineafterequal=line.substring(line.indexOf("=") + 1);//Lot Numbers

if (string.equalsIgnoreCase(linebeforeequal)) {
System.out.println(linebeforeequal);
String formattedText = "<b style='display:block; text-align:center;'>" + lineafterequal + "</b>";
tds.get(9).html(formattedText); // Use .html() instead of .text()     
//tds.get(9).text(lineafterequal);
//System.out.println(lineafterequal);
found = true;                    
break;

    }
  
    
}
buf.close();

             ///////////////////////////////////////////////////////////////
               
            }   
         
         
        }}
       myarea.setText(doc.toString());
        }
        
    ////////////////////////////////////////////////////////////////////////////    
    String newrecipecode=myarea.getText();
    
    OutputStream instreamm=new FileOutputStream(pathy);
    PrintWriter pwwc = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    
    //PrintWriter pwwc=new PrintWriter (new FileWriter (pathy));
    pwwc.println(newrecipecode.replace("A","ﬦ")
       .replace("B","ﬧ")
       .replace("C","ﬨ")
       .replace("D","﬩")
       .replace("E","שׁ")    
       .replace("F","שׂ")        
       .replace("G","שּׁ")         
       .replace("H","שּׂ")         
       .replace("I","אַ")         
       .replace("J","אָ")         
       .replace("K","אּ")         
       .replace("L","בּ")         
       .replace("M","גּ")         
       .replace("N","דּ")         
       .replace("O","הּ")         
       .replace("P","וּ")         
       .replace("Q","זּ")         
       .replace("R","טּ")         
       .replace("S","יּ")         
       .replace("T","ךּ")         
       .replace("U","כּ")         
       .replace("V","לּ")
       .replace("W","מּ")         
       .replace("X","נּ")         
       .replace("Y","סּ")         
       .replace("Z","ףּ")
                
       .replace("0","פּ")         
       .replace("1","צּ")         
       .replace("2","קּ")         
       .replace("3","רּ")         
       .replace("4","שּ")         
       .replace("5","תּ")         
       .replace("6","וֹ")         
       .replace("7","בֿ")         
       .replace("8","כֿ")
       .replace("9","פֿ")
                
       .replace("a","ﬦ")
       .replace("b","ﬧ")
       .replace("c","ﬨ")
       .replace("d","﬩")
       .replace("e","שׁ")    
       .replace("f","שׂ")        
       .replace("g","שּׁ")         
       .replace("h","שּׂ")         
       .replace("i","אַ")         
       .replace("j","אָ")         
       .replace("k","אּ")         
       .replace("l","בּ")         
       .replace("m","גּ")         
       .replace("n","דּ")         
       .replace("o","הּ")         
       .replace("p","וּ")         
       .replace("q","זּ")         
       .replace("r","טּ")         
       .replace("s","יּ")         
       .replace("t","ךּ")         
       .replace("u","כּ")         
       .replace("v","לּ")
       .replace("w","מּ")         
       .replace("x","נּ")         
       .replace("y","סּ")         
       .replace("z","ףּ"));
    pwwc.close();
    
    
    
	////////////////////////////////////////////////////////////////
    
  
     try {
    String longKey;
    try (BufferedReader reader = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = reader.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("No password found in java.dat!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String password = KeyDecoder.extractData(longKey.trim());
    if (f == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = f.getAbsolutePath();
    String tempOutput = input + ".tmp";
    System.out.println("Encrypting with password: " + password);
    FileEncryptor.encrypt(input, tempOutput, password);
    File original = new File(input);
    File temp = new File(tempOutput);
    if (original.exists()) {
        original.delete();
    }
    if (temp.renameTo(original)) {
        Notifications noti = Notifications.create();
        noti.title("Success!");
        noti.text("File encrypted successfully!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showInformation();
    } else {
        Notifications noti = Notifications.create();
        noti.title("Error!");
        noti.text("Failed to replace original file.");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
    }
} catch (Exception ex) {
    ex.printStackTrace();
    Notifications noti = Notifications.create();
    noti.title("Encryption Failed!");
    noti.text("An error occurred during encryption.");
    noti.position(Pos.CENTER);
    noti.hideAfter(Duration.seconds(5));
    noti.showError();
}
  
    
    ////////////////////////////////////////////////////////////////
    
    
    
      Notifications noti = Notifications.create();
      noti.title("Successful Operation");
      noti.text("We updated everything successfully!.");
      noti.hideAfter(Duration.seconds(5));
      noti.position(Pos.CENTER);
      noti.showInformation();
    
   //   Desktop desktopp=Desktop.getDesktop();
   //   desktopp.open(new File (pathy));
   
      
      //////////////////////////////////////////////End////////////////////////////////////////////////////
      
      
      Git.gitCommands();
      
      
      
      
  }
  
  
//  
//  public static int levenshteinDistance(String a, String b) {
//    int[][] dp = new int[a.length() + 1][b.length() + 1];
//
//    for (int i = 0; i <= a.length(); i++) {
//        for (int j = 0; j <= b.length(); j++) {
//            if (i == 0) {
//                dp[i][j] = j;
//            } else if (j == 0) {
//                dp[i][j] = i;
//            } else {
//                dp[i][j] = Math.min(
//                    Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
//                    dp[i - 1][j - 1] + (a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1)
//                );
//            }
//        }
//    }
//    return dp[a.length()][b.length()];
//}

  
  
  @FXML
  void fixoneaction(ActionEvent event) throws IOException {
        
       
    //FileChooser to choose recipe.
    FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String nami=f.getName().replace(".ks","").replace(".html","");
    String pathy = f.getAbsolutePath().toString();
   
    
    
        ////////////////////////////////////////////////////////////
    
    

    try {
    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String result = KeyDecoder.extractData(longKey.trim());
    if (f == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = f.getAbsolutePath();
    File originalFile = new File(input);
    //Add backup here
    File backupFolder = new File("D:\\All_Recipessss\\Backup");
    if (!backupFolder.exists()) {
        backupFolder.mkdirs();
    }
    String backupFileName = originalFile.getName() + ".bak";
    File backupFile = new File(backupFolder, backupFileName);
    try {
        java.nio.file.Files.copy(originalFile.toPath(), 
                                backupFile.toPath(), 
                                java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        System.out.println("✅ Backup created / updated: " + backupFile.getAbsolutePath());
    } catch (Exception backupEx) {
        System.out.println("⚠️ Warning: Failed to create backup - " + backupEx.getMessage());
    }
    // =================================================
    
    String tempOutput = input + ".tmp";
    System.out.println("Decrypting with password: " + result); // للتصحيح
    FileDecryptor.decrypt(input, tempOutput, result);
    File original = new File(input);
    File temp = new File(tempOutput);
    if (original.exists()) {
        original.delete();
    }
    if (temp.renameTo(original)) {
        Notifications noti = Notifications.create();
        noti.title("Success!");
        noti.text("File decrypted successfully.");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showInformation();
    } else {
        Notifications noti = Notifications.create();
        noti.title("Error!");
        noti.text("Failed to replace original file.");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
    }
} catch (Exception ex) {
    ex.printStackTrace();
    String errorMsg = "Wrong password or corrupted file.";
    if (ex.getClass().getSimpleName().contains("AEADBadTag") || 
        ex.getMessage() != null && ex.getMessage().contains("BadTag")) {
        errorMsg = "Wrong password! The key does not match the file.";
    }
    Notifications noti = Notifications.create();
    noti.title("Decryption Failed!");
    noti.text(errorMsg);
    noti.position(Pos.CENTER);
    noti.hideAfter(Duration.seconds(5));
    noti.showError();
}



    ////////////////////////////////////////////////////////////
	
    
    
    
    myarea.clear();
    
    InputStream inputinstream=new FileInputStream(pathy);
    BufferedReader bufy=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    
    //BufferedReader bufy=new BufferedReader (new FileReader (pathy));
    String liin;
    while ((liin=bufy.readLine())!=null) {
        myarea.appendText(liin.replace("ﬦ","A")
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
       .replace("&NBSP;","") +"\n");
    }
    bufy.close();
    
    String code = myarea.getText();
      if (!code.contains("TABLE")) {
      Notifications noti = Notifications.create();
      noti.title("Recipe Error");
      noti.text("Maybe not a recipe, Open a recipe first!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showError();    
        }
        else {
            org.jsoup.nodes.Document doc = Jsoup.parse(code);
        for (Element table : doc.select("TABLE")) {
        for (Element row : table.select("TR")) {
            Elements tds = row.select("TD");
            if (tds.get(7).text().isEmpty()) {   
            }
            else {  
             /////////////////////////////////////////////////////////////
String string=tds.get(7).text();
BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Chemical_Dictionary.kady"));
String line;
String linebeforeequal;
String lineafterequal;
while ((line=buf.readLine())!=null) {
linebeforeequal=line.substring(0,line.indexOf("=")-0);
lineafterequal=line.substring(line.indexOf("=") + 1 , line.length());
if (string.equals(lineafterequal)) {
System.out.println(string+" = "+linebeforeequal);
String formattedText = "<b style='display:block; text-align:center;'>" + linebeforeequal + "</b>";
tds.get(8).html(formattedText); // Use .html() instead of .text()     
tds.get(8).text(linebeforeequal);
System.out.println(tds.get(8).text());
break;

    }
    else {
        
    }
    
}
buf.close();

             /////////////////////////////////////////////////////////////
               
            }   
         
         
        }}
       myarea.setText(doc.toString());
        }

//
//String code = myarea.getText();
//    
//    if (!code.contains("TABLE")) {
//        Notifications noti = Notifications.create();
//        noti.title("Recipe Error");
//        noti.text("Maybe not a recipe, Open a recipe first!.");
//        noti.hideAfter(Duration.seconds(3));
//        noti.position(Pos.CENTER);
//        noti.showError();
//    } else {
//        org.jsoup.nodes.Document doc = Jsoup.parse(code);
//
//        for (Element table : doc.select("TABLE")) {
//            for (Element row : table.select("TR")) {
//                Elements tds = row.select("TD");
//
//                if (!tds.get(7).text().isEmpty()) {
//                    String string = tds.get(7).text();
//                    BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirrrr + "\\Recipe_Indexes\\Chemical_Dictionary.kady"));
//                    String line;
//                    String linebeforeequal = null;
//                    String lineafterequal;
//                    String bestMatch = null;
//                    int minDistance = Integer.MAX_VALUE; // أقرب تشابه
//
//                    while ((line = buf.readLine()) != null) {
//                        linebeforeequal = line.substring(0, line.indexOf("="));
//                        lineafterequal = line.substring(line.indexOf("=") + 1);
//
//                        if (string.equalsIgnoreCase(lineafterequal)) {
//                            bestMatch = linebeforeequal;
//                            break;
//                        } else {
//                            int distance = levenshteinDistance(string, lineafterequal);
//                            if (distance < minDistance) {
//                                minDistance = distance;
//                                bestMatch = linebeforeequal;
//                            }
//                        }
//                    }
//                    buf.close();
//
//                    if (bestMatch != null) {
//                        String formattedText = "<b style='display:block; text-align:center;'>" + bestMatch + "</b>";
//                        tds.get(8).html(formattedText);
//                    }
//                }
//            }
//        }
//        myarea.setText(doc.toString());
//    }
//
//

        
    ////////////////////////////////////////////////////////////////////////////    
    String newrecipecode=myarea.getText();
    
    OutputStream instreamm=new FileOutputStream(pathy);
    PrintWriter pwwc = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    
    //PrintWriter pwwc=new PrintWriter (new FileWriter (pathy));
    pwwc.println(newrecipecode.replace("A","ﬦ")
       .replace("B","ﬧ")
       .replace("C","ﬨ")
       .replace("D","﬩")
       .replace("E","שׁ")    
       .replace("F","שׂ")        
       .replace("G","שּׁ")         
       .replace("H","שּׂ")         
       .replace("I","אַ")         
       .replace("J","אָ")         
       .replace("K","אּ")         
       .replace("L","בּ")         
       .replace("M","גּ")         
       .replace("N","דּ")         
       .replace("O","הּ")         
       .replace("P","וּ")         
       .replace("Q","זּ")         
       .replace("R","טּ")         
       .replace("S","יּ")         
       .replace("T","ךּ")         
       .replace("U","כּ")         
       .replace("V","לּ")
       .replace("W","מּ")         
       .replace("X","נּ")         
       .replace("Y","סּ")         
       .replace("Z","ףּ")
                
       .replace("0","פּ")         
       .replace("1","צּ")         
       .replace("2","קּ")         
       .replace("3","רּ")         
       .replace("4","שּ")         
       .replace("5","תּ")         
       .replace("6","וֹ")         
       .replace("7","בֿ")         
       .replace("8","כֿ")
       .replace("9","פֿ")
                
       .replace("a","ﬦ")
       .replace("b","ﬧ")
       .replace("c","ﬨ")
       .replace("d","﬩")
       .replace("e","שׁ")    
       .replace("f","שׂ")        
       .replace("g","שּׁ")         
       .replace("h","שּׂ")         
       .replace("i","אַ")         
       .replace("j","אָ")         
       .replace("k","אּ")         
       .replace("l","בּ")         
       .replace("m","גּ")         
       .replace("n","דּ")         
       .replace("o","הּ")         
       .replace("p","וּ")         
       .replace("q","זּ")         
       .replace("r","טּ")         
       .replace("s","יּ")         
       .replace("t","ךּ")         
       .replace("u","כּ")         
       .replace("v","לּ")
       .replace("w","מּ")         
       .replace("x","נּ")         
       .replace("y","סּ")         
       .replace("z","ףּ"));
    pwwc.close();
    
    
    
    
	
	
	////////////////////////////////////////////////////////////////
    
  
     try {
    String longKey;
    try (BufferedReader reader = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = reader.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("No password found in java.dat!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String password = KeyDecoder.extractData(longKey.trim());
    if (f == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = f.getAbsolutePath();
    String tempOutput = input + ".tmp";
    System.out.println("Encrypting with password: " + password);
    FileEncryptor.encrypt(input, tempOutput, password);
    File original = new File(input);
    File temp = new File(tempOutput);
    if (original.exists()) {
        original.delete();
    }
    if (temp.renameTo(original)) {
        Notifications noti = Notifications.create();
        noti.title("Success!");
        noti.text("File encrypted successfully!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showInformation();
    } else {
        Notifications noti = Notifications.create();
        noti.title("Error!");
        noti.text("Failed to replace original file.");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
    }
} catch (Exception ex) {
    ex.printStackTrace();
    Notifications noti = Notifications.create();
    noti.title("Encryption Failed!");
    noti.text("An error occurred during encryption.");
    noti.position(Pos.CENTER);
    noti.hideAfter(Duration.seconds(5));
    noti.showError();
}
  
    
    ////////////////////////////////////////////////////////////////
    
    
      Notifications noti = Notifications.create();
      noti.title("Successful Operation");
      noti.text("We updated everything successfully!.\nRecipe will open now.");
      noti.hideAfter(Duration.seconds(5));
      noti.position(Pos.CENTER);
      noti.showInformation();
    
   //   Desktop desktopp=Desktop.getDesktop();
   //   desktopp.open(new File (pathy));
    
        
   Git.gitCommands();
   
   
        
  }
  
  
  
  
  
  @FXML
  void addtimeraction(ActionEvent event) throws IOException {
        
       
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("RecipeTime.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle(" Recipe Time Viewer");
    stg.setResizable(false);
    stg.setScene(sce);
    //stg.setAlwaysOnTop(true);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
        
        
  }
  
  
  @FXML
  void chatgptaction(ActionEvent event) throws IOException {
        
       
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("ChatGPT.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Ask ChatGPT ;).");
    stg.setResizable(false);
    stg.setScene(sce);
    //stg.setAlwaysOnTop(true);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
        
        
  }
  
  
  
  
  @FXML
  void recetacalaction(ActionEvent event) throws IOException {
        
            try {
                

String secret = "K4JXLZ3WD3BJIUWW7SSL2JSQL2QRGLMK";
TextInputDialog dialog = new TextInputDialog();
dialog.setTitle("2FA Authentication");
dialog.setHeaderText("Enter Authentication Code");
dialog.setContentText("Code:");
DialogPane dialogPane = dialog.getDialogPane();
dialogPane.getStylesheets().add(getClass().getResource("cupertino-dark.css").toExternalForm());
dialogPane.getStyleClass().add("cupertino-dialog");
Stage stage = (Stage) dialogPane.getScene().getWindow();
stage.getIcons().add(new Image(getClass().getResourceAsStream( "kadysoft.png")));
Optional<String> result = dialog.showAndWait();
        if (!result.isPresent()) {
            return;
        }
        String enteredCode = result.get().trim();
        dev.samstevens.totp.code.CodeVerifier verifier =
                new dev.samstevens.totp.code.DefaultCodeVerifier(
                        new dev.samstevens.totp.code.DefaultCodeGenerator(),
                        new dev.samstevens.totp.time.SystemTimeProvider()
                );
        boolean codeValid =
                verifier.isValidCode(
                        secret,
                        enteredCode
                );

 if (!codeValid) {
            return;
        }
                
            String path = Main.class.getProtectionDomain()
            .getCodeSource().getLocation().toURI().getPath();

            String decodedPath = URLDecoder.decode(path, StandardCharsets.UTF_8.name());
            File file = new File(decodedPath);
            String dir = file.isFile() ? file.getParent() : file.getPath();

            Desktop dfdsg=Desktop.getDesktop();
            dfdsg.open(new File (dir+"\\Coaster.exe"));
           

            if (dir.length() > 2 && dir.charAt(1) == ':') {
                String driveLetter = dir.substring(0, 2);
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    
        
        
  }
  
  
  
  @FXML
  void viewpilotaction(ActionEvent event) throws IOException {
        
       
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Converter.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Pilot Recipes Viewer");
    stg.setResizable(false);
    stg.setScene(sce);
    //stg.setAlwaysOnTop(true);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
        
        
  }
  
  
  
  
  
  
  @FXML
  void findandreplaceallaction(ActionEvent event) throws IOException {
        
       
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("FindAndReplaceAll.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Find And Replace All");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
        
        
  }
  
  
  @FXML
  void decryptrecipeallaction(ActionEvent event) throws IOException {
        
       
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("DecryptMultiple.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Decrypt Multiple Recipes");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
        
        
  }
  
  
  
    @FXML
  void encdangeraction(ActionEvent event) throws IOException {
        
       
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("SaveToDB_Enc.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Encrypt Multiple Recipes");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
        
        
  }
  
  
    @FXML
  void decdangeraction(ActionEvent event) throws IOException {
        
       
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("SaveToDB_Dec.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Decrypt Multiple Recipes");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
        
        
  }
  
  
  ///////////////////////////////////////////////////////////////////////////////////
  
  @FXML
  void encryptoall(ActionEvent event) throws IOException {
        
       
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("EncryptMultiple.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Encrypt Multiple Recipes");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    //stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
        
        
  }
  
  
  
  @FXML
    void emptyrecipeoneaction(ActionEvent event) throws IOException {

    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("EmptyRecipe.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Create An Empty Recipe");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
          
        
        
    }
  
  @FXML
    void encryptadvaction(ActionEvent event) throws IOException, InterruptedException {

    FileChooser fcho = new FileChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Html Files", new String[] { "*.html" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
    lili.clear();
    InputStream inputinstream=new FileInputStream(pathy);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    //BufferedReader bi=new BufferedReader (new FileReader (pathy));
    String lo;
    while ((lo = bi.readLine()) != null) {
    if (lo.contains("data:image") || lo.contains("base64,")) {
        lili.appendText("\n" + lo);
        continue;
    }
    String converted = lo
            .replace("A","ﬦ").replace("B","ﬧ").replace("C","ﬨ").replace("D","﬩").replace("E","שׁ")
            .replace("F","שׂ").replace("G","שּׁ").replace("H","שּׂ").replace("I","אַ").replace("J","אָ")
            .replace("K","אּ").replace("L","בּ").replace("M","גּ").replace("N","דּ").replace("O","הּ")
            .replace("P","וּ").replace("Q","זּ").replace("R","טּ").replace("S","יּ").replace("T","ךּ")
            .replace("U","כּ").replace("V","לּ").replace("W","מּ").replace("X","נּ").replace("Y","סּ")
            .replace("Z","ףּ")
            .replace("0","פּ").replace("1","צּ").replace("2","קּ").replace("3","רּ").replace("4","שּ")
            .replace("5","תּ").replace("6","וֹ").replace("7","בֿ").replace("8","כֿ").replace("9","פֿ")
            .replace("a","ﬦ").replace("b","ﬧ").replace("c","ﬨ").replace("d","﬩").replace("e","שׁ")
            .replace("f","שׂ").replace("g","שּׁ").replace("h","שּׂ").replace("i","אַ").replace("j","אָ")
            .replace("k","אּ").replace("l","בּ").replace("m","גּ").replace("n","דּ").replace("o","הּ")
            .replace("p","וּ").replace("q","זּ").replace("r","טּ").replace("s","יּ").replace("t","ךּ")
            .replace("u","כּ").replace("v","לּ").replace("w","מּ").replace("x","נּ").replace("y","סּ")
            .replace("z","ףּ");
    lili.appendText("\n" + converted);
}
    bi.close();
    String gf=lili.getText();
    OutputStream instreamm=new FileOutputStream(pathy);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    //PrintWriter pw=new PrintWriter (new FileWriter (pathy));
    pw.println(gf);
    pw.close();
    
    
    ////////////////////////////////////////////////////////////////
    
  
     try {
    String longKey;
    try (BufferedReader reader = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = reader.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("No password found in java.dat!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String password = KeyDecoder.extractData(longKey.trim());
    if (f == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = f.getAbsolutePath();
    String tempOutput = input + ".tmp";
    System.out.println("Encrypting with password: " + password);
    FileEncryptor.encrypt(input, tempOutput, password);
    File original = new File(input);
    File temp = new File(tempOutput);
    if (original.exists()) {
        original.delete();
    }
    if (temp.renameTo(original)) {
        Notifications noti = Notifications.create();
        noti.title("Success!");
        noti.text("File encrypted successfully!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showInformation();
    } else {
        Notifications noti = Notifications.create();
        noti.title("Error!");
        noti.text("Failed to replace original file.");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
    }
} catch (Exception ex) {
    ex.printStackTrace();
    Notifications noti = Notifications.create();
    noti.title("Encryption Failed!");
    noti.text("An error occurred during encryption.");
    noti.position(Pos.CENTER);
    noti.hideAfter(Duration.seconds(5));
    noti.showError();
}
  
    
    ////////////////////////////////////////////////////////////////
    
    
    
    Notifications noti = Notifications.create();
    noti.title("Successful");
    noti.text("We have encrypted the recipe successfully.");
    noti.hideAfter(Duration.seconds(3));
    noti.position(Pos.CENTER);
    noti.showInformation();
    lili.clear();

          
       Git.gitCommands();
        
        
    }
  
  ///////////////////////////////////////////////////////
  
     
    @FXML
    void decryptadvaction(ActionEvent event) throws IOException {

        
    FileChooser fcho = new FileChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Html Files", new String[] { "*.html" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
    
    
    
        ////////////////////////////////////////////////////////////
    
    

    try {
    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String result = KeyDecoder.extractData(longKey.trim());
    if (f == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = f.getAbsolutePath();
    File originalFile = new File(input);
    //Add backup here
    File backupFolder = new File("D:\\All_Recipessss\\Backup");
    if (!backupFolder.exists()) {
        backupFolder.mkdirs();
    }
    String backupFileName = originalFile.getName() + ".bak";
    File backupFile = new File(backupFolder, backupFileName);
    try {
        java.nio.file.Files.copy(originalFile.toPath(), 
                                backupFile.toPath(), 
                                java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        System.out.println("✅ Backup created / updated: " + backupFile.getAbsolutePath());
    } catch (Exception backupEx) {
        System.out.println("⚠️ Warning: Failed to create backup - " + backupEx.getMessage());
    }
    // =================================================
    
    String tempOutput = input + ".tmp";
    System.out.println("Decrypting with password: " + result); // للتصحيح
    FileDecryptor.decrypt(input, tempOutput, result);
    File original = new File(input);
    File temp = new File(tempOutput);
    if (original.exists()) {
        original.delete();
    }
    if (temp.renameTo(original)) {
        Notifications noti = Notifications.create();
        noti.title("Success!");
        noti.text("File decrypted successfully.");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showInformation();
    } else {
        Notifications noti = Notifications.create();
        noti.title("Error!");
        noti.text("Failed to replace original file.");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
    }
} catch (Exception ex) {
    ex.printStackTrace();
    String errorMsg = "Wrong password or corrupted file.";
    if (ex.getClass().getSimpleName().contains("AEADBadTag") || 
        ex.getMessage() != null && ex.getMessage().contains("BadTag")) {
        errorMsg = "Wrong password! The key does not match the file.";
    }
    Notifications noti = Notifications.create();
    noti.title("Decryption Failed!");
    noti.text(errorMsg);
    noti.position(Pos.CENTER);
    noti.hideAfter(Duration.seconds(5));
    noti.showError();
}



    ////////////////////////////////////////////////////////////
	
	
    
    
    lili.clear();
    InputStream inputinstream=new FileInputStream(pathy);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    String lo;
    while ((lo=bi.readLine())!=null) {
        
        lili.appendText("\n"+lo
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
    String gf=lili.getText();
    OutputStream instreamm=new FileOutputStream(pathy);
    PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    //PrintWriter pwe=new PrintWriter (new FileWriter (pathy));
    pwe.println(gf);
    pwe.close();
    Notifications noti = Notifications.create();
    noti.title("Successful");
    noti.text("We have decrypted the recipe successfully.");
    noti.hideAfter(Duration.seconds(3));
    noti.position(Pos.CENTER);
    noti.showInformation();
    lili.clear();
    
    
    Git.gitCommands();
        
        
    }
  

   
  
  /////////////////////////////////////////////////////////
  
    
    @FXML
    void removesignaction(ActionEvent event) throws IOException {

        
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("RemoveSign.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Remove Signature");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
        
    }
  
  
  
  
  
  
  
  
  @FXML
  void kadysoftmethodaction (ActionEvent event) throws IOException, InterruptedException  {
      
      //Normal
      
         
    FileChooser fcho = new FileChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Html Files", new String[] { "*.html" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
    String filename = f.getName().toString();
    String newfilename=filename.replace(".ks","").replace(".html","");
    
    File newdir=new File (System.getProperty("user.home")+"\\Temp_Files");
    
    if (!newdir.exists()) {
        newdir.mkdir();
    }
    else {
        //Continue to outside else.
    }
    
    String linet = "cmd /C copy /Y "+pathy+" "+newdir+"\\"+newfilename+".hta";
    Process p = Runtime.getRuntime().exec(linet);
    p.waitFor();
    
    File htafile=new File (newdir+"\\"+newfilename+".hta");
    
    Desktop desk=Desktop.getDesktop();
    desk.open(htafile);
    
    htafile.deleteOnExit();
      
      
      
      
      
  }
  
  
  @FXML
  void htmltohtaaction (ActionEvent event) throws IOException  {
      
      
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("HtmlToHta.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("HTML To HTA");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
      
      
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
   
  
  @FXML
  void aiartoolaction (ActionEvent event) throws IOException, Exception  {
      
      
      
         
        
    FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Html Files", new String[] { "*.html" }));
    
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
   // BufferedReader buf = new BufferedReader(new FileReader(pathy));
    
       ////////////////////////////////////////////////////////////

    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String result = KeyDecoder.extractData(longKey.trim());
    if (f == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = f.getAbsolutePath();
    String nameofit=f.getName();
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
 
    FileDecryptor.decrypt(input, tempOutput, result);
    File temp = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////

   
    InputStream inputinstream=new FileInputStream(temp);
    BufferedReader buf=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
OutputStream instreamm=new FileOutputStream(getValueByKey("lib\\setto.cfg", "Secondry_Editor"));
PrintWriter pw = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    pw.append("<!DOCTYPE html>\n" +
"<html lang=\"ar\">\n" +
"\n" +
            
            
            
            
            
            
"<head>\n" +
"\n" +
"  <meta charset=\"utf-8\">\n" +
"  <meta name=\"viewport\" content=\"width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0\" />\n" +
"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css\">\n" +
"  <link rel=\"stylesheet\" href=\"../../css/froala_editor.css\">\n" +
"  <link rel=\"stylesheet\" href=\"../../css/froala_style.css\">\n" +
"  <link rel=\"stylesheet\" href=\"../../css/plugins/code_view.css\">\n" +
"  <link rel=\"stylesheet\" href=\"../../css/plugins/draggable.css\">\n" +
"  <link rel=\"stylesheet\" href=\"../../css/plugins/colors.css\">\n" +
"  <link rel=\"stylesheet\" href=\"../../css/plugins/emoticons.css\">\n" +
"  <link rel=\"stylesheet\" href=\"../../css/plugins/image_manager.css\">\n" +
"  <link rel=\"stylesheet\" href=\"../../css/plugins/image.css\">\n" +
"  <link rel=\"stylesheet\" href=\"../../css/plugins/line_breaker.css\">\n" +
"  <link rel=\"stylesheet\" href=\"../../css/plugins/table.css\">\n" +
"  <link rel=\"stylesheet\" href=\"../../css/plugins/char_counter.css\">\n" +
"  <link rel=\"stylesheet\" href=\"../../css/plugins/video.css\">\n" +
"  <link rel=\"stylesheet\" href=\"../../css/plugins/fullscreen.css\">\n" +
"  <link rel=\"stylesheet\" href=\"../../css/plugins/file.css\">\n" +
"  <link rel=\"stylesheet\" href=\"../../css/plugins/quick_insert.css\">\n" +
"  <link rel=\"stylesheet\" href=\"../../css/plugins/help.css\">\n" +
"  <link rel=\"stylesheet\" href=\"../../css/third_party/spell_checker.css\">\n" +
"  <link rel=\"stylesheet\" href=\"../../css/plugins/special_characters.css\">\n" +
"  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.css\">\n" +
"\n" +
"  <style>\n" +
"    body {\n" +
"      text-align: center;\n" +
"    }\n" +
"\n" +
"    div#editor {\n" +
"      width: 81%;\n" +
"      margin: auto;\n" +
"      text-align: left;\n" +
"    }\n" +
"\n" +
"    .ss {\n" +
"      background-color: red;\n" +
"    }\n" +
"  </style>\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"  <div id=\"editor\">\n" +
"    <div id='edit' style=\"margin-top: 30px;\">\n" +
"      \n" +
"	  \n" +
"	  ");
    String line;
    while ((line = buf.readLine()) != null)  
    pw.append(line.replace("ﬦ","A")
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
       .replace("&NBSP;","") + "\n"); 
    pw.append(" \n" +
"	  \n" +
"	  \n" +
"    </div>\n" +
"\n" +
"   \n" +
"  <script type=\"text/javascript\"\n" +
"    src=\"https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.js\"></script>\n" +
"  <script type=\"text/javascript\"\n" +
"    src=\"https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/mode/xml/xml.min.js\"></script>\n" +
"    <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/dompurify/2.2.7/purify.min.js\"></script>\n" +
"\n" +
"  <script type=\"text/javascript\" src=\"../../js/froala_editor.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/align.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/char_counter.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/code_beautifier.min.js\"></script>\n" +

"  <script type=\"text/javascript\" src=\"../../js/plugins/colors.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/draggable.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/emoticons.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/entities.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/file.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/font_size.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/font_family.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/fullscreen.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/image.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/image_manager.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/line_breaker.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/inline_style.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/link.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/lists.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/paragraph_format.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/paragraph_style.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/quick_insert.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/quote.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/table.min.js\"></script>\n" +

"  <script type=\"text/javascript\" src=\"../../js/plugins/url.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/video.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/help.min.js\"></script>\n" +

"  <script type=\"text/javascript\" src=\"../../js/third_party/spell_checker.min.js\"></script>\n" +
"  <script type=\"text/javascript\" src=\"../../js/plugins/special_characters.min.js\"></script>\n" +

"\n" +
"  <script>\n" +
"    (function () {\n" +
"      new FroalaEditor(\"#edit\")\n" +
"    })()\n" +
"  </script>\n" +
"</body>\n" +
"\n" +
"</html>");
    pw.close();
    buf.close();
    
    File fgsa=new File (getValueByKey("lib\\setto.cfg", "Secondry_Editor"));
    Desktop dsaq=Desktop.getDesktop();
    dsaq.open(fgsa);
    fgsa.deleteOnExit();
    	
	////////////////////////////////////////////////////////////////
    if (temp.exists()) {
        temp.delete();
    }
    ////////////////////////////////////////////////////////////////
	
      
//      
//    Stage stg = new Stage();
//    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Converter.fxml"));
//    Scene sce = new Scene(root);
//    stg.setTitle("Aiar Tool");
//    stg.setResizable(false);
//    stg.setScene(sce);
//    stg.centerOnScreen();
//    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
//    stg.show();
//      
      
  }
  
  
  
  @FXML
  void signoutaction (ActionEvent event) throws IOException  {
      
      
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Sign.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Sign A Recipe");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
      
      
  }
  
  
  @FXML
  void encryptarecipeaction (ActionEvent event) throws IOException  {
      
      
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Encrypt.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Encrypt A Recipe");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
      
      
  }
  
  
  @FXML
  void decryptarecipeaction (ActionEvent event) throws IOException  {
      
      
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Decrypt.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Decrypt A Recipe");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
      
      
  }
  
  
  
  
  
  
  
  
  
  //////////////////////////////////////////////////
  
  @FXML
  private MenuItem protect,addsheet,removesheet,xlsxtosvg,exceltoword,exceltotext,pdftoexcel;
  
  
  
  
  
  @FXML
  void addlogoaction (ActionEvent event) throws IOException {
      
    Stage kady = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("AddLogo.fxml"));
    Scene scene = new Scene(root);
    kady.setTitle("Add Logo To Recipe");
    kady.centerOnScreen();
    kady.setResizable(false);
    kady.centerOnScreen();
    kady.setScene(scene);
    kady.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    kady.show();
          
  }
  
  
  
  @FXML
    void mailerraction(ActionEvent event) throws IOException   {
        
        
    Stage kady = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Mailer.fxml"));
    Scene scene = new Scene(root);
    kady.setTitle("Kadysoft - Mailer");
    kady.centerOnScreen();
    kady.setResizable(false);
    kady.centerOnScreen();
    kady.setScene(scene);
    kady.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    kady.show();
        
        
    }
  
  
  
  
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  @FXML
    void protectaction(ActionEvent event) throws IOException   {
        
    FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", new String[] { "*.xlsx" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String nami=f.getName().replace(".xlsx","");
    String pathy = f.getAbsolutePath().toString();
    
      Workbook workbook = new Workbook();
      workbook.loadFromFile(pathy); 
      JFXTextField gr = new JFXTextField();
      gr.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
      gr.setLabelFloat(true);
      gr.setPromptText("Click To Write Password .... ");
      gr.setMinSize(222.0D, 33.0D);
      Alert alo = new Alert(Alert.AlertType.INFORMATION);
      alo.setTitle("Add Password");
      alo.setGraphic((Node)gr);
      alo.setResizable(false);
      DialogPane dialogPane = alo.getDialogPane();
      dialogPane.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
      alo.showAndWait();
      String password=gr.getText();
      workbook.protect(password);
      workbook.saveToFile(System.getProperty("user.home")+"\\Desktop\\"+nami+".xlsx", ExcelVersion.Version2016);
      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("We have added the password successfully.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showInformation();
      Desktop desk=Desktop.getDesktop();
      desk.open(new File (System.getProperty("user.home")+"\\Desktop"));
        
    }
    
    
    @FXML
    void addsheetaction(ActionEvent event) throws IOException   {
        
    FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", new String[] { "*.xlsx" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String nami=f.getName().replace(".xlsx","");
    String pathy = f.getAbsolutePath().toString();
    
        Workbook workbook = new Workbook();
        workbook.loadFromFile(pathy);
        JFXTextField gr = new JFXTextField();
        gr.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
        gr.setLabelFloat(true);
        gr.setPromptText("Click To Write Sheet Name .... ");
        gr.setMinSize(222.0D, 33.0D);
        Alert alo = new Alert(Alert.AlertType.INFORMATION);
        alo.setTitle("Add Sheet");
        alo.setGraphic((Node)gr);
        alo.setResizable(false);
        DialogPane dialogPane = alo.getDialogPane();
        dialogPane.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
        alo.showAndWait();
        Worksheet sheet = workbook.getWorksheets().add(gr.getText());
        sheet.getCellRange("C5").setText("Created By Kadysoft Ltd, Ahmed Elkady - CEO.");
        workbook.saveToFile(System.getProperty("user.home")+"\\Desktop\\"+nami+".xlsx", ExcelVersion.Version2016);
        workbook.dispose();

      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("We have added the sheet successfully.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showInformation();
      Desktop desk=Desktop.getDesktop();
      desk.open(new File (System.getProperty("user.home")+"\\Desktop"));
        
    }
    
    
    @FXML
    void removesheetaction(ActionEvent event) throws IOException   {
        
    FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", new String[] { "*.xlsx" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String nami=f.getName().replace(".xlsx","");
    String pathy = f.getAbsolutePath().toString();
    
        Workbook workbook = new Workbook();
        workbook.loadFromFile(pathy);
        JFXTextField gr = new JFXTextField();
        gr.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
        gr.setLabelFloat(true);
        gr.setPromptText("Write Sheet Number Starts From 0");
        gr.setMinSize(222.0D, 33.0D);
        Alert alo = new Alert(Alert.AlertType.INFORMATION);
        alo.setTitle("Remove Sheet");
        alo.setGraphic((Node)gr);
        alo.setResizable(false);
        DialogPane dialogPane = alo.getDialogPane();
        dialogPane.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
        alo.showAndWait();
        Worksheet sheet1 = workbook.getWorksheets().get(Integer.parseInt(gr.getText()));
        sheet1.remove();
        workbook.saveToFile(System.getProperty("user.home")+"\\Desktop\\"+nami+".xlsx", ExcelVersion.Version2016);
        workbook.dispose();

      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("We have removed the sheet successfully.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showInformation();
      Desktop desk=Desktop.getDesktop();
      desk.open(new File (System.getProperty("user.home")+"\\Desktop"));
        
    }
    
    @FXML
    void deleterowsaction(ActionEvent event) throws IOException   {
        
     FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", new String[] { "*.xlsx" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String nami=f.getName().replace(".xlsx","");
    String pathy = f.getAbsolutePath().toString();
    
       
    Workbook wb = new Workbook();
    wb.loadFromFile(pathy);
    JFXTextField gr = new JFXTextField();
        gr.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
        gr.setLabelFloat(true);
        gr.setPromptText("Write Sheet Number Starts From 0");
        gr.setMinSize(222.0D, 33.0D);
        Alert alo = new Alert(Alert.AlertType.INFORMATION);
        alo.setTitle("Remove R & C");
        alo.setGraphic((Node)gr);
        alo.setResizable(false);
        DialogPane dialogPane = alo.getDialogPane();
        dialogPane.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
        alo.showAndWait();
        Worksheet sheet = wb.getWorksheets().get(Integer.parseInt(gr.getText()));
    for (int i = sheet.getLastRow(); i >= 1; i--)

        {
            
       if (sheet.getRows()[i-1].isBlank())

            {

                sheet.deleteRow(i);

            }

        }

        for (int j = sheet.getLastColumn(); j >= 1; j--)

        {

            if (sheet.getColumns()[j-1].isBlank())

            {


                sheet.deleteColumn(j);

            }

        }

      wb.saveToFile(System.getProperty("user.home")+"\\Desktop\\"+nami+".xlsx", ExcelVersion.Version2016);

      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("We have removed the rows and columns successfully.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showInformation();
      Desktop desk=Desktop.getDesktop();
      desk.open(new File (System.getProperty("user.home")+"\\Desktop"));
        
    }
  
  
    @FXML
    void xlsxtosvgaction(ActionEvent event) throws IOException   {
        
     FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", new String[] { "*.xlsx" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String nami=f.getName().replace(".xlsx","");
    String pathy = f.getAbsolutePath().toString();
    
        Workbook workbook = new Workbook();
        workbook.loadFromFile(pathy);
        JFXTextField gr = new JFXTextField();
        gr.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
        gr.setLabelFloat(true);
        gr.setPromptText("Write Sheet Number Starts From 0");
        gr.setMinSize(222.0D, 33.0D);
        Alert alo = new Alert(Alert.AlertType.INFORMATION);
        alo.setTitle("Sheet Number");
        alo.setGraphic((Node)gr);
        alo.setResizable(false);
        DialogPane dialogPane = alo.getDialogPane();
        dialogPane.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
        alo.showAndWait();
        Worksheet sheet = workbook.getWorksheets().get(Integer.parseInt(gr.getText()));
        FileOutputStream stream = new FileOutputStream(System.getProperty("user.home")+"\\Desktop\\"+nami+".svg");
        sheet.toSVGStream(stream, sheet.getFirstRow(), sheet.getFirstColumn(), sheet.getLastRow(), sheet.getLastColumn());
        stream.flush();
        stream.close();

        

      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("We have converted the sheet successfully.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showInformation();
      Desktop desk=Desktop.getDesktop();
      desk.open(new File (System.getProperty("user.home")+"\\Desktop"));
        
    }
    
    
    
    @FXML
    void exceltowordaction(ActionEvent event) throws IOException   {
        
     FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", new String[] { "*.xlsx" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String nami=f.getName().replace(".xlsx","");
    String pathy = f.getAbsolutePath().toString();
    
     //Load an Excel file
        Workbook workbook = new Workbook();
        workbook.loadFromFile(pathy);
        JFXTextField gr = new JFXTextField();
        gr.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
        gr.setLabelFloat(true);
        gr.setPromptText("Write Sheet Number Starts From 0");
        gr.setMinSize(222.0D, 33.0D);
        Alert alo = new Alert(Alert.AlertType.INFORMATION);
        alo.setTitle("Sheet Number");
        alo.setGraphic((Node)gr);
        alo.setResizable(false);
        alo.showAndWait();
        Worksheet sheet = workbook.getWorksheets().get(Integer.parseInt(gr.getText()));
        Document doc = new Document();
        Section section = doc.addSection();
        section.getPageSetup().setOrientation(PageOrientation.Landscape);
        Table table = section.addTable(true);
        table.resetCells(sheet.getLastRow(), sheet.getLastColumn());
        mergeCells(sheet, table);

        for (int r = 1; r <= sheet.getLastRow(); r++) {

            //Set row Height
            table.getRows().get(r - 1).setHeight((float) sheet.getRowHeight(r));

            for (int c = 1; c <= sheet.getLastColumn(); c++) {
                CellRange xCell = sheet.getCellRange(r, c);
                TableCell wCell = table.get(r - 1, c - 1);

                //Get value of a specific Excel cell and add it to a cell of Word table
                TextRange textRange = wCell.addParagraph().appendText(xCell.getValue());

                //Copy font and cell style from Excel to Word
                copyStyle(textRange, xCell, wCell);
            }
        }

        //Save the document to a Word file
        doc.saveToFile(System.getProperty("user.home")+"\\Desktop\\"+nami+".docx", com.spire.doc.FileFormat.Docx);
        
        
        
    }

    //Merge cells if any
    private static void mergeCells(Worksheet sheet, Table table) {
        if (sheet.hasMergedCells()) {

            //Get merged cell ranges from Excel
            CellRange[] ranges = sheet.getMergedCells();
            for (int ii = 0; ii < ranges.length; ii++) {
                int startRow = ranges[ii].getRow();
                int startColumn = ranges[ii].getColumn();
                int rowCount = ranges[ii].getRowCount();
                int columnCount = ranges[ii].getColumnCount();

                //Merge corresponding cells in Word table
                if (rowCount > 1 && columnCount > 1) {
                    for (int j = startRow; j <= startRow + rowCount ; j++) {
                        table.applyHorizontalMerge(j - 1, startColumn - 1, startColumn - 1 + columnCount - 1);
                    }
                    table.applyVerticalMerge(startColumn - 1, startRow - 1, startRow - 1 + rowCount -1);
                }
                if (rowCount > 1 && columnCount == 1 ) {
                     table.applyVerticalMerge(startColumn - 1, startRow - 1, startRow - 1 + rowCount -1);
                }
                if (columnCount > 1 && rowCount == 1 ) {
                    table.applyHorizontalMerge(startRow - 1, startColumn - 1,  startColumn - 1 + columnCount-1);
                }
            }
        }
    }

    //Copy cell style of Excel to Word table
    private static void copyStyle(TextRange wTextRange, CellRange xCell, TableCell wCell) throws IOException {

        //Copy font style
        wTextRange.getCharacterFormat().setTextColor(xCell.getStyle().getFont().getColor());
        wTextRange.getCharacterFormat().setFontSize((float) xCell.getStyle().getFont().getSize());
        wTextRange.getCharacterFormat().setFontName(xCell.getStyle().getFont().getFontName());
        wTextRange.getCharacterFormat().setBold(xCell.getStyle().getFont().isBold());
        wTextRange.getCharacterFormat().setItalic(xCell.getStyle().getFont().isItalic());

        //Copy backcolor
        wCell.getCellFormat().setBackColor(xCell.getStyle().getColor());

        //Copy horizontal alignment
        switch (xCell.getHorizontalAlignment()) {
            case Left:
                wTextRange.getOwnerParagraph().getFormat().setHorizontalAlignment(HorizontalAlignment.Left);
                break;
            case Center:
                wTextRange.getOwnerParagraph().getFormat().setHorizontalAlignment(HorizontalAlignment.Center);
                break;
            case Right:
                wTextRange.getOwnerParagraph().getFormat().setHorizontalAlignment(HorizontalAlignment.Right);
                break;
        }
        
        //Copy vertical alignment
        switch (xCell.getVerticalAlignment()) {
            case Bottom:
                wCell.getCellFormat().setVerticalAlignment(VerticalAlignment.Bottom);
                break;
            case Center:
                wCell.getCellFormat().setVerticalAlignment(VerticalAlignment.Middle);
                break;
            case Top:
                wCell.getCellFormat().setVerticalAlignment(VerticalAlignment.Top);
                break;
        }
    
    ////////////
    
      
       
      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("We have converted the sheet successfully.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showInformation();
      Desktop desk=Desktop.getDesktop();
      desk.open(new File (System.getProperty("user.home")+"\\Desktop"));
        
    }
    
    
    
    
    
    @FXML
    void exceltotextaction(ActionEvent event) throws IOException   {
        
   
        FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", new String[] { "*.xlsx" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String nami=f.getName().replace(".xlsx","");
    String pathy = f.getAbsolutePath().toString();
    
        Workbook workbook = new Workbook();
        workbook.loadFromFile(pathy);
        JFXTextField gr = new JFXTextField();
        gr.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
        gr.setLabelFloat(true);
        gr.setPromptText("Write Sheet Number Starts From 0");
        gr.setMinSize(222.0D, 33.0D);
        Alert alo = new Alert(Alert.AlertType.INFORMATION);
        alo.setTitle("Sheet Number");
        alo.setGraphic((Node)gr);
        alo.setResizable(false);
        DialogPane dialogPane = alo.getDialogPane();
        dialogPane.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
        alo.showAndWait();
        Worksheet sheet = workbook.getWorksheets().get(Integer.parseInt(gr.getText()));
        Charset charset = Charset.forName("utf8");
        sheet.saveToFile(System.getProperty("user.home")+"\\Desktop\\"+nami+".txt", " ", charset);
        

      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("We have converted the sheet successfully.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showInformation();
      Desktop desk=Desktop.getDesktop();
      desk.open(new File (System.getProperty("user.home")+"\\Desktop"));
        
    }
    
    
    
    
    
    
    @FXML
    void pdftoexcelaction(ActionEvent event) throws IOException   {
        
    FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", new String[] { "*.pdf" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String nami=f.getName().replace(".pdf","");
    String pathy = f.getAbsolutePath().toString();
    
      PdfDocument pdf = new PdfDocument();
      pdf.loadFromFile(pathy);
      pdf.saveToFile(System.getProperty("user.home")+"\\Desktop\\"+nami+".xlsx",com.spire.pdf.FileFormat.XLSX);
      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("We have converted the pdf successfully.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showInformation();
      Desktop desk=Desktop.getDesktop();
      desk.open(new File (System.getProperty("user.home")+"\\Desktop"));
        
    }
    
    
    
    
    
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  
  @FXML
    void xlsxtopdfaction(ActionEvent event) throws IOException  {
        
    /*
    String reppath = System.getProperty("user.home") + "\\Desktop";
    FileChooser dialog = new FileChooser();
    dialog.setInitialDirectory(new File(reppath));
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("XLSX Files", new String[] { "*.xlsx" }));
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("XLS Files", new String[] { "*.xls" }));
    File dialogResult = dialog.showOpenDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();   ///Excel File Path.
    
    //Create a Workbook instance and load an Excel file

        Workbook workbook = new Workbook();
        workbook.loadFromFile(filePath);
        workbook.getConverterSetting().setSheetFitToPage(true);
        String reppathh = System.getProperty("user.home") + "\\Desktop";
        FileChooser dialogg = new FileChooser();
        dialogg.setInitialDirectory(new File(reppathh));
        dialogg.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", new String[] { "*.png" }));
        File dialogResultt = dialogg.showSaveDialog(null);
        String filePathh = dialogResultt.getAbsolutePath().toString();
        //System.out.println(filePathh);
        //workbook.saveToFile(filePathh, FileFormat.Bitmap); ///Choose what you want // then Notification.

        Worksheet sheet=workbook.getWorksheets().get(0);
        sheet.saveToImage(filePathh);
        */
    Stage kady = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Converter1.fxml"));
    Scene scene = new Scene(root);
    kady.setTitle("Convert Excel To File");
    kady.centerOnScreen();
    kady.setResizable(false);
    kady.centerOnScreen();
    kady.setScene(scene);
    kady.show();
    }
    
    @FXML
    void htmltopdfaction(ActionEvent event) throws IOException  {
        
    Stage kady = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Converter2.fxml"));
    Scene scene = new Scene(root);
    kady.setTitle("Convert Excel To Image");
    kady.centerOnScreen();
    kady.setResizable(false);
    kady.centerOnScreen();
    kady.setScene(scene);
    kady.show();  
        
    }
  
  
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @FXML
    void stageaddaction(ActionEvent event) throws IOException  {
        
        myarea.clear();
      /////////////////////////////////////////////////////////////////////////////////////////////////////  
        try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Stages.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        myarea.appendText(line+"\n");
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
        
        ////////////////////////////
        String stepp=stagefield.getText();
        String textt=myarea.getText();
        PrintWriter pw=new PrintWriter(new FileWriter (NewDir.file_dirr + "\\Stages.kady"));
        pw.print(textt);
        pw.print(stepp);
        pw.close();
        stagefield.clear();
        myarea.clear();
      //////////////////////////////////////////////////////////////////////////////////////////////////////
      
    }

    
    
    
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @FXML
    void useraddaction(ActionEvent event) throws IOException  {
        
      /////////////////////////////////////////////////////////////////////////////////////////////////////  
      myarea.clear();
      try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Users.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        myarea.appendText(line+"\n");
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
        
        ////////////////////////////
        
        String stepp=userfield.getText();
        String textt=myarea.getText();
        PrintWriter pw=new PrintWriter(new FileWriter (NewDir.file_dirr + "\\Users.kady"));
        pw.print(textt);
        pw.print(stepp);
        pw.close();
        myarea.clear();
        
        
        
         /////////////////////////////////////////////////////////////////////////////////////////////////////  
        try {
      BufferedReader bufg = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Cont.kady"));
      String lineg;
      while ((lineg = bufg.readLine()) != null) {
      myarea.appendText(lineg+"\n");
      } 
      bufg.close();
    } catch (FileNotFoundException fileNotFoundException) {
    } catch (IOException iOException) {}
        
        ////////////////////////////
        
        String steppg=userfield.getText();
        String texttg=myarea.getText();
        PrintWriter pwg=new PrintWriter(new FileWriter (NewDir.file_dirr + "\\Cont.kady"));
        pwg.print(texttg);
        pwg.print(steppg+"=NO");
        pwg.close();
        
        
        userfield.clear();
        myarea.clear();
      //////////////////////////////////////////////////////////////////////////////////////////////////////
      
    }
     
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  @FXML
    void mailaddaction(ActionEvent event) throws IOException  {
        
        
        myarea.clear();
      /////////////////////////////////////////////////////////////////////////////////////////////////////  
        try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Mails.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        myarea.appendText(line+"\n");
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
        
        ////////////////////////////
        
        String stepp=mailfield.getText();
        
        String textt=myarea.getText();
        PrintWriter pw=new PrintWriter(new FileWriter (NewDir.file_dirr + "\\Mails.kady"));
        pw.print(textt);
        pw.print(stepp);
        pw.close();
        mailfield.clear();
        myarea.clear();
      //////////////////////////////////////////////////////////////////////////////////////////////////////
      
    }
    
    
    
    
    
     @FXML
    void httoexaction(ActionEvent event) throws IOException  {
        
        
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("ConvertMultiple.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Convert Kadysoft To Excel (Multiple)");
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    @FXML
    void modeladdaction(ActionEvent event) throws IOException  {
        
        myarea.clear();
        /////////////////////////////////////////////////////////////////////////////////////////////////////  
        try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Models.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        myarea.appendText(line+"\n");
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
        
        ////////////////////////////
        String stepp=modelfield.getText();
        String textt=myarea.getText();
        PrintWriter pw=new PrintWriter(new FileWriter (NewDir.file_dirr + "\\Models.kady"));
        pw.print(textt);
        pw.print(stepp);
        pw.close();
        modelfield.clear();
        myarea.clear();
      //////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
    }
    
    
    
    
    
    
    
    
    
    @FXML
    void actionaddaction(ActionEvent event) throws IOException  {
        
        myarea.clear();
        /////////////////////////////////////////////////////////////////////////////////////////////////////  
        try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Action_Names.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        myarea.appendText(line+"\n");
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
        
        ////////////////////////////
        String stepp=actionfield.getText();
        String textt=myarea.getText();
        PrintWriter pw=new PrintWriter(new FileWriter (NewDir.file_dirr + "\\Action_Names.kady"));
        pw.print(textt);
        pw.print(stepp);
        pw.close();
        actionfield.clear();
        myarea.clear();
      //////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
    }
    
    
    
    
    
    
    
    
    
    @FXML
    void unitaddaction(ActionEvent event) throws IOException  {
        
        myarea.clear();
        /////////////////////////////////////////////////////////////////////////////////////////////////////  
        try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Units.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        myarea.appendText(line+"\n");
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
        
        ////////////////////////////
        String stepp=unitfield.getText();
        String textt=myarea.getText();
        PrintWriter pw=new PrintWriter(new FileWriter (NewDir.file_dirr + "\\Units.kady"));
        pw.print(textt);
        pw.print(stepp);
        pw.close();
        unitfield.clear();
        myarea.clear();
      //////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
    }
    
  
  
  /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
  
  
  
  
  
  
  
  
  @FXML
    void editorprintaction(ActionEvent event) throws FileNotFoundException, IOException, Exception {

    FileChooser fcho = new FileChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
    
    
        ////////////////////////////////////////////////////////////

    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String result = KeyDecoder.extractData(longKey.trim());
    if (f == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = f.getAbsolutePath();
    String nameofit=f.getName();
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
 
    FileDecryptor.decrypt(input, tempOutput, result);
    File temps = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////
    
    
    InputStream inputinstream=new FileInputStream(temps);
    BufferedReader buf=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    
    OutputStream instreamm=new FileOutputStream(NewDir.file_dirrrr + "\\Editor\\index.html");
    PrintWriter pw = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    pw.append("<html lang=\"ar\">\n<head><title>Kadysoft Ltd - Ahmed Elkady.</title>"
            + ""
            
            
            
          
            
            
            + "<style>\n" +
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
"    </script>"     
            
            
            
            
            + ""
            + "\n\t\t<title></title>\n\t\t<link rel=\"stylesheet\" href=\"./app.css\" />\n\t\t<link rel=\"stylesheet\" href=\"./build/jodit.min.css\" />\n\t\t<script src=\"./build/jodit.js\"></script>\n\t</head>\n\t<body>\n\t\t<style>\n\t\t\t#box {\n\t\t\t\tpadding: 100px;\n\t\t\t\tmargin: 20px;\n\t\t\t\tposition: relative;\n\t\t\t\theight: 500px;\n\t\t\t}\n\n\t\t\t@media (max-width: 480px) {\n\t\t\t\t#box {\n\t\t\t\t\tpadding: 0;\n\t\t\t\t}\n\t\t\t}\n\t\t</style>\n\t\t<div id=\"box\">\n\t\t\t<textarea id=\"editor\">\n\n\n\n\n");
    String line;
    while ((line = buf.readLine()) != null)  
      pw.append(line
              
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
              
              
              + "\n"); 
     
    pw.append("\n\n\n</textarea>\n\t\t</div>\n\t\t<script>\n\t\t\tconst editor = Jodit.make('#editor' ,{\n\t\t\t\tuploader: {\n\t\t\t\t\t\n\t\t\t\t},\n\t\t\t\tfilebrowser: {\n\t\t\t\t\tajax: {\n\t\t\t\t\t\t\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t});\n\t\t</script>\n\t</body>\n</html>");
    
    
    
    pw.close();
    buf.close();
    
    	
	
	////////////////////////////////////////////////////////////////
    if (temps.exists()) {
        temps.delete();
    }
    ////////////////////////////////////////////////////////////////
	
	
	
    
    
    Desktop desk = Desktop.getDesktop();
    desk.open(new File(NewDir.file_dirrrr + "\\Editor\\index.html"));
        
    }
  

    
    
    @FXML
  void myexporttoexcelaction(ActionEvent event) throws IOException  {
    FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String nami=f.getName().replace(".ks","").replace(".html","");
    String pathy = f.getAbsolutePath().toString();
    
    
            Workbook workbook = new Workbook();
            workbook.loadFromHtml(pathy);

            //AutoFit rows
            Worksheet sheet=workbook.getWorksheets().get(0);
            sheet.setName("Made_By_Kadysoft_Ltd");
            
            sheet.autoFitRow(i);

            //Save the document to file
            workbook.saveToFile(System.getProperty("user.home")+"\\Desktop\\"+nami+".xlsx",FileFormat.Version2016);
            
            Desktop desk=Desktop.getDesktop();
            desk.open(new File (System.getProperty("user.home")+"\\Desktop\\"+nami+".xlsx"));
    
  }
    
    
    
    
    
  @FXML
  void exporttoexcelaction(ActionEvent event) throws IOException  {
      
    FileChooser fcho = new FileChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String pathy = f.getAbsolutePath().toString();
    BufferedReader buf = new BufferedReader(new FileReader(pathy));
    PrintWriter pw = new PrintWriter(new FileWriter(NewDir.file_dirrrr + "\\Recipes2Excel\\index.html"));
    pw.append("<!DOCTYPE html>\n" +
"<html lang=\"ar\">\n" +
"	<head>\n" +
"		<title>Kadysoft Ltd.</title>\n" +
"		<link rel=\"stylesheet\" href=\"style.css\" />\n" +
"	</head>\n" +
"	<body>\n" +
"		<div>"
            + ""
            + ""
            + "");
    String line;
    while ((line = buf.readLine()) != null)  {
      pw.append(line); 
   
    
    }
     pw.append("<input type=\"button\" value=\"export\" onclick=\"exportToExcel('EXTABLE')\" />\n" +
"		</div>\n" +
"		<script src=\"exportToExcel.js\" defer></script>\n" +
"	</body>\n" +
"</html>");
    pw.close();
    buf.close();
    Desktop desk = Desktop.getDesktop();
    desk.open(new File(NewDir.file_dirrrr + "\\Recipes2Excel\\index.html"));
    
     
          //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////Audit/////////////////////////////////////
          
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String timeString = sdf.format(d);
    String value1 = timeString;
    
    ////////////////Machine ID////////////////
    
         //////////////////////////////////////////////////
          
          String batchcode="@echo off\n" +
"for /f \"tokens=3\" %%a in ('reg query \"HKLM\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\" /v CurrentBuild') do (\n" +
"    if %%a geq 22000 (\n" +
"        echo Windows 11\n" +
"    ) else (\n" +
"        echo Windows 10\n" +
"    )\n" +
")\n" +
"";
          String pathofbat=System.getProperty("user.home")+"\\kadinio.bat";
          File fafa=new File (pathofbat);
          fafa.deleteOnExit();
          PrintWriter paq=new PrintWriter (new FileWriter (fafa));
          paq.println(batchcode);
          paq.close();
          
            try {
            ProcessBuilder processBuilder = new ProcessBuilder(pathofbat);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String linew;
            while ((linew = reader.readLine()) != null) {
            //System.out.println(line);
            windowsversion=linew;
            }
            int exitCode = process.waitFor();
            //System.out.println("Batch file executed with exit code: " + exitCode);
            } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            }
 
            if (windowsversion.equals("Windows 10")) {
                
                //Windows10
                
              String command="wmic bios get serialnumber";
              StringBuffer output=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output.append(linee+"\n");
                   }
                   MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
                   
                
                
            }
            
            else if (windowsversion.equals("Windows 11")) {
                
                //Windows11
                
              String command="powershell Get-CimInstance -ClassName Win32_BIOS | Select-Object SerialNumber";
              StringBuffer output=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output.append(linee+"\n");
                   }
                   MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim().replace("SerialNumber","").replace("------------","").replace("\n","");
                
                
            }
            
            else {
                
                //Windows7 or less like windows 10
                
              String command="wmic bios get serialnumber";
              StringBuffer output=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output.append(linee+"\n");
                   }
                   MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
                
                
            }
            
            
          
          //////////////////////////////////////////////////
          
    
     //String command="wmic bios get serialnumber";
            //  StringBuffer output=new StringBuffer();
              try {
//                   Process SerNumProcess=Runtime.getRuntime().exec(command);
//                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
//                   String linee="";
//                   while ((linee=sNumReader.readLine())!=null) {
//                   output.append(linee+"\n");
//                   }
//                   String MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
//                   //System.out.println(MachineID);
    
    //////////////////////////////////////////
          
          String sqla = "insert into Audit (Date,User,PC_MAC,Status) values (?,?,?,?) ";
          this.pst = this.conn.prepareStatement(sqla);
          this.pst.setString(1, value1);
          this.pst.setString(2, "Recipe_Maker");
          this.pst.setString(3, MachineID);
          this.pst.setString(4, "Recipe_Maker is exporting a system recipe to excel.");
          
          this.pst.execute();
              }
              catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        } finally {
          try {
            this.rs.close();
            this.pst.close();
          } catch (Exception exception) {}
        }  
          
          
          //////////////////////////////////////////////////////////////////////////////
          //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          
          
      
  }
  
  @FXML
  void openrecipesfolderaction(ActionEvent event) throws IOException {
      
      //Desktop desk=Desktop.getDesktop();
      //desk.open(new File (NewDir.file_dir));
      
  }
  
  @FXML
  void copyarecipeaction(ActionEvent event) throws IOException {
    Stage kady = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("CopyARecipe.fxml"));
    Scene scene = new Scene(root);
    kady.setTitle("Recipe Copier ...");
    kady.centerOnScreen();
    kady.setResizable(false);
    kady.centerOnScreen();
    kady.setScene(scene);
    kady.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    kady.show();
  }
  
  @FXML
  void copyarecipepathaction(ActionEvent event) throws IOException {
    Stage kady = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("CopyARecipePath.fxml"));
    Scene scene = new Scene(root);
    kady.setTitle("Recipe Copier ...");
    kady.centerOnScreen();
    kady.setResizable(false);
    kady.centerOnScreen();
    kady.setScene(scene);
    kady.getIcons().add(new javafx.scene.image.Image(Main.class.getResourceAsStream("washing.png")));
    kady.show();
  }
  
  @FXML
  void saverecipeaction(ActionEvent event) throws IOException {
      
     
      
    Stage kady = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Saver.fxml"));
    Scene scene = new Scene(root);
    kady.setTitle("Recipe Saver ...");
    kady.centerOnScreen();
    kady.setResizable(false);
    kady.centerOnScreen();
    kady.setScene(scene);
    kady.show();
  }
  
  
  @FXML
  void exceltohtmlaction(ActionEvent event) throws IOException {
    Desktop desk = Desktop.getDesktop();
    desk.open(new File(NewDir.file_dirrrr + "\\ExcelToHTML\\index.html"));
    this.savetohtml.setDisable(false);
    
    
    
          //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////Audit/////////////////////////////////////
          
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String timeString = sdf.format(d);
    String value1 = timeString;
    
    ////////////////Machine ID////////////////
    
         //////////////////////////////////////////////////
          
          String batchcode="@echo off\n" +
"for /f \"tokens=3\" %%a in ('reg query \"HKLM\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\" /v CurrentBuild') do (\n" +
"    if %%a geq 22000 (\n" +
"        echo Windows 11\n" +
"    ) else (\n" +
"        echo Windows 10\n" +
"    )\n" +
")\n" +
"";
          String pathofbat=System.getProperty("user.home")+"\\kadinio.bat";
          File fafa=new File (pathofbat);
          fafa.deleteOnExit();
          PrintWriter paq=new PrintWriter (new FileWriter (fafa));
          paq.println(batchcode);
          paq.close();
          
            try {
            ProcessBuilder processBuilder = new ProcessBuilder(pathofbat);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
            //System.out.println(line);
            windowsversion=line;
            }
            int exitCode = process.waitFor();
            //System.out.println("Batch file executed with exit code: " + exitCode);
            } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            }
 
            if (windowsversion.equals("Windows 10")) {
                
                //Windows10
                
              String command="wmic bios get serialnumber";
              StringBuffer output=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output.append(linee+"\n");
                   }
                   MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
                   
                
                
            }
            
            else if (windowsversion.equals("Windows 11")) {
                
                //Windows11
                
              String command="powershell Get-CimInstance -ClassName Win32_BIOS | Select-Object SerialNumber";
              StringBuffer output=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output.append(linee+"\n");
                   }
                   MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim().replace("SerialNumber","").replace("------------","").replace("\n","");
                
                
            }
            
            else {
                
                //Windows7 or less like windows 10
                
              String command="wmic bios get serialnumber";
              StringBuffer output=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output.append(linee+"\n");
                   }
                   MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
                
                
            }
            
            
          
          //////////////////////////////////////////////////
          
    
    
    // String command="wmic bios get serialnumber";
            //  StringBuffer output=new StringBuffer();
              try {
//                  Process SerNumProcess=Runtime.getRuntime().exec(command);
//                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
//                   String linee="";
//                   while ((linee=sNumReader.readLine())!=null) {
//                       output.append(linee+"\n");
//                   }
//                   String MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
                   //System.out.println(MachineID);
    
    //////////////////////////////////////////
          
          String sqla = "insert into Audit (Date,User,PC_MAC,Status) values (?,?,?,?) ";
          this.pst = this.conn.prepareStatement(sqla);
          this.pst.setString(1, value1);
          this.pst.setString(2, "Recipe_Maker");
          this.pst.setString(3, MachineID);
          this.pst.setString(4, "Recipe_Maker is converting an excel recipe to system.");
          
          this.pst.execute();
              }
              catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        } finally {
          try {
            this.rs.close();
            this.pst.close();
          } catch (Exception exception) {}
        }  
          
          
          //////////////////////////////////////////////////////////////////////////////
          //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          
          savetohtml.fire();
          Stage jk = (Stage)this.website.getScene().getWindow();
          jk.setIconified(true);
    
  }
  
  @FXML
  void savetohtmlaction(ActionEvent event) throws IOException {
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Saver_1.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Save To HTML");
    stg.centerOnScreen();
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
  }
  
  @FXML
  void viewrecipesaction(ActionEvent event) throws IOException {
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Viewer_1.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Recipes Explorer");
    stg.centerOnScreen();
    stg.setResizable(true);
    stg.setScene(sce);
    stg.setMaximized(true);
    stg.centerOnScreen();
    stg.getIcons().add(new Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
  }
  
  
  @FXML
  void logoutaction(ActionEvent event) throws IOException {
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("LogIn_GUI.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("LogIn Window");
    stg.centerOnScreen();
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    Stage jk = (Stage)this.website.getScene().getWindow();
    jk.close();
    
    
    
          //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            ////////////////////////////////////Audit/////////////////////////////////////
          
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String timeString = sdf.format(d);
    String value1 = timeString;
    
    ////////////////Machine ID////////////////
    
         //////////////////////////////////////////////////
          
          String batchcode="@echo off\n" +
"for /f \"tokens=3\" %%a in ('reg query \"HKLM\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\" /v CurrentBuild') do (\n" +
"    if %%a geq 22000 (\n" +
"        echo Windows 11\n" +
"    ) else (\n" +
"        echo Windows 10\n" +
"    )\n" +
")\n" +
"";
          String pathofbat=System.getProperty("user.home")+"\\kadinio.bat";
          File fafa=new File (pathofbat);
          fafa.deleteOnExit();
          PrintWriter paq=new PrintWriter (new FileWriter (fafa));
          paq.println(batchcode);
          paq.close();
          
            try {
            ProcessBuilder processBuilder = new ProcessBuilder(pathofbat);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
            //System.out.println(line);
            windowsversion=line;
            }
            int exitCode = process.waitFor();
            //System.out.println("Batch file executed with exit code: " + exitCode);
            } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            }
 
            if (windowsversion.equals("Windows 10")) {
                
                //Windows10
                
              String command="wmic bios get serialnumber";
              StringBuffer output=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output.append(linee+"\n");
                   }
                   MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
                   
                
                
            }
            
            else if (windowsversion.equals("Windows 11")) {
                
                //Windows11
                
              String command="powershell Get-CimInstance -ClassName Win32_BIOS | Select-Object SerialNumber";
              StringBuffer output=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output.append(linee+"\n");
                   }
                   MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim().replace("SerialNumber","").replace("------------","").replace("\n","");
                
                
            }
            
            else {
                
                //Windows7 or less like windows 10
                
              String command="wmic bios get serialnumber";
              StringBuffer output=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output.append(linee+"\n");
                   }
                   MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
                
                
            }
            
            
          
          //////////////////////////////////////////////////
          
    
    
   //  String command="wmic bios get serialnumber";
    //          StringBuffer output=new StringBuffer();
              try {
//                  Process SerNumProcess=Runtime.getRuntime().exec(command);
//                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
//                   String line="";
//                   while ((line=sNumReader.readLine())!=null) {
//                       output.append(line+"\n");
//                   }
//                   String MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
                   //System.out.println(MachineID);
    
    //////////////////////////////////////////
          
          String sqla = "insert into Audit (Date,User,PC_MAC,Status) values (?,?,?,?) ";
          this.pst = this.conn.prepareStatement(sqla);
          this.pst.setString(1, value1);
          this.pst.setString(2, "Recipe_Maker");
          this.pst.setString(3, MachineID);
          this.pst.setString(4, "Recipe_Maker Logged Out.");
          
          this.pst.execute();
              }
              catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        } finally {
          try {
            this.rs.close();
            this.pst.close();
          } catch (Exception exception) {}
          
          ////////////////////////////////////////////////
    
          
          
          ////////////////////////////////////////////////
          
          
        }  
          
          
          //////////////////////////////////////////////////////////////////////////////
          //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
          
          
    
  }
  

  @FXML
  void createnewrecipeaction(ActionEvent event) throws IOException {
      Stage jk = (Stage)this.website.getScene().getWindow();
      jk.close();
      Stage stg = new Stage();
      Parent root = FXMLLoader.<Parent>load(getClass().getResource("RecipeMaker_1.fxml"));
      Scene sce = new Scene(root);
      sce.getStylesheets().add("table-cell-color-example.css");
      stg.setTitle("Developer Controller");
      stg.centerOnScreen();
      stg.setResizable(false);
      stg.setScene(sce);
      stg.centerOnScreen();
      stg.getIcons().add(new Image(Main.class.getResourceAsStream("washing.png")));
      stg.show();

  }
  
  
  
  
  
  @FXML
  void historyaction(ActionEvent event)  {
      
      //FXML with data in alert
      
      ComboBox cbb1=new ComboBox ();
      cbb1.setPromptText("Choose Model");
      
      ComboBox cbb2=new ComboBox ();
      //cbb2.setEditable(true);
      cbb2.setPromptText("Choose Wash Name");
      
    cbb1.setOnShowing(gg -> {
          
    cbb1.getItems().clear();
    try {
      BufferedReader buf = new BufferedReader(new FileReader(models_file_path));
      String line;
      while ((line = buf.readLine()) != null) {
    cbb1.getItems().addAll(new String[] { line });
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
          
      });
      
      cbb1.setOnHidden(df -> {
          cbb2.getItems().clear();
      });
      
      cbb2.setOnShowing(sa -> {
          
          String userInput = cbb1.getSelectionModel().getSelectedItem().toString();

String sql = "SELECT Name FROM Creation WHERE Model LIKE ?";
try {
    this.pst = this.conn.prepareStatement(sql);
    this.pst.setString(1, "%" + userInput + "%"); // search anywhere in Model column

    this.rs = this.pst.executeQuery();

    cbb2.getItems().clear(); // clear old items before adding new ones

    while (this.rs.next()) {
        String name = this.rs.getString("Name");
        if (name != null && !name.trim().isEmpty()) {
            cbb2.getItems().add(name);
        }
    }

} catch (Exception e) {
   
} finally {
    try {
        if (this.rs != null) this.rs.close();
        if (this.pst != null) this.pst.close();
    } catch (Exception ex) {
        ex.printStackTrace();
    }
}

          
      });
      
      cbb2.setOnHidden(ds -> {
    try {
       
        String wq=cbb1.getSelectionModel().getSelectedItem().toString();
        String ew=cbb2.getSelectionModel().getSelectedItem().toString();
        
        historyyfileepathh=NewDir.file_dirrrr+"\\Recipes_History\\"+wq+"."+ew+".history.json";
        viewHistory();
        
        
        
    } catch (Exception e) {
        e.printStackTrace();
    }
});

      
      VBox rew=new VBox ();
      rew.getChildren().addAll(cbb1,cbb2);
      rew.setSpacing (20);
      
      Alert al=new Alert (Alert.AlertType.INFORMATION);
      al.setGraphic(rew);
      DialogPane dialogPane = al.getDialogPane();
      dialogPane.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
      al.showAndWait();
      
 
      
      
      
  }
  
  
  private List<Map<String, Object>> loadHistory() {
        if (historyyfileepathh == null || !new File(historyyfileepathh).exists()) return new ArrayList<>();
        try (Reader reader = new FileReader(historyyfileepathh)) {
            return new Gson().fromJson(reader, new TypeToken<List<Map<String, Object>>>() {}.getType());
        } catch (IOException ex) {
            return new ArrayList<>();
        }
    }
  
  
  
  private void viewHistory() {
    if (historyyfileepathh == null) {
        return;
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
  
  
  
  
  @FXML
  void editeditaction(ActionEvent event) throws FileNotFoundException, IOException, Exception {
      
      
      if (hohoho.isSelected()==true) {
          
      //Open Here
      
      
      //////////////////////////////////////START///////////////////////////////////////
      
      Date currentDate1 = GregorianCalendar.getInstance().getTime();
      DateFormat df1 = DateFormat.getDateInstance();
      String dateString1 = df1.format(currentDate1);
      Date d1 = new Date();
      SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
      String timeString1 = sdf1.format(d1);
      SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
      String timeString2 = sdf2.format(d1);
      String value000 = timeString1;
      String value111 = timeString2;
      ComboBox myuser=new ComboBox ();
      myuser.setMinSize(150, 30);
      myuser.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
      myuser.setPromptText("Choose One");
      myuser.setOnShown(evt -> {
          myuser.getItems().clear();
         try {
             BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Users.kady"));
             String line;
             while ((line = buf.readLine()) != null) {
             myuser.getItems().addAll(new String[] { line });
          } 
          buf.close();
          } catch (FileNotFoundException fileNotFoundException) {
    
          } catch (IOException iOException) {}
      });
      
      
      
      Alert alert = new Alert(AlertType.WARNING);
      alert.setTitle("Choose Responsible");
      alert.setHeaderText("Please be careful, this info is important.");
      alert.setContentText("Hello, Please tell me: Who are you?.");
      alert.setGraphic(myuser);
      alert.setResizable(false);
      DialogPane dialogPane = alert.getDialogPane();
      dialogPane.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> option = alert.showAndWait();
      if (option.get() == null) {} 
      else if (option.get() == ButtonType.OK) {
          if (myuser.getSelectionModel().getSelectedItem()==null) {
              Notifications noti = Notifications.create();
              noti.title("Fatal Error!");
              noti.text("We Can't continue, Please choose one user.");
              noti.position(Pos.CENTER);
              noti.hideAfter(Duration.seconds(3));
              noti.showError();
          }
          else {
              ////////////////////////Copy All Here/////////////////////////
              theuser=myuser.getSelectionModel().getSelectedItem().toString();
              
        if (nameStatusMap.containsKey(theuser)) {
        String dss=nameStatusMap.get(theuser); // Returns NO or YES
        
        if (dss.equals("YES")) {
        //User Blocked
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("We Can't continue, User is blocked.");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(10));
        noti.showError();
        event.consume(); // Cancel the event, stop further action
        return;
        }
        if (dss.equals("NO")) {
        
        }
         
        else {
        //User Blocked
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("We Can't continue, User is blocked and he tried to trick you.");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(10));
        noti.showError();
        event.consume(); // Cancel the event, stop further action    
        }
        
        } else {
        //User Blocked
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("We Can't continue, User is null.");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(10));
        noti.showError();
        event.consume(); // Cancel the event, stop further action
        return;    
        //System.out.println("Not Here");    
        }
              
              //////////Get Password Here From DB//////////////////
              
                   try {
      String sql = "select * from Editors where User=?";
      pst = conn.prepareStatement(sql);
      pst.setString(1, theuser);
      rs = pst.executeQuery();
      //passwordy = rs.getString("Password").toLowerCase();
      passwordy = rs.getString("Password");
    }
        
        catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      } catch (Exception exception) {}
    } 
        
              
              /////////////////////////////////////////////////////
      JFXPasswordField fss=new JFXPasswordField ();
      fss.setPromptText("Write your password ...");
      fss.setMinSize(300, 30);
      fss.setLabelFloat(true);
      fss.setStyle("-fx-font-weight:bold;");
      fss.setEditable(true);
      Alert alerto = new Alert(AlertType.WARNING);
      alerto.setTitle("UR Password?");
      alerto.setHeaderText("Please be careful, this info is important.");
      alerto.setContentText("Hello, Please tell me: your password?.");
      alerto.setGraphic(fss);
      alerto.setResizable(false);
      DialogPane dialogPaneo = alerto.getDialogPane();
      dialogPaneo.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optiono = alerto.showAndWait();
      String passy=fss.getText();
      if (optiono.get() == null) {} 
      else if (optiono.get() == ButtonType.OK) {
          if (passy.isEmpty()||passy.equals(" ")) {
              Notifications noti = Notifications.create();
              noti.title("Fatal Error!");
              noti.text("We Can't continue, Password is incorrect or empty.");
              noti.position(Pos.CENTER);
              noti.hideAfter(Duration.seconds(3));
              noti.showError();
          }
          else {
              
              ///////////////See if passy equals passwordy////////////////////////////////////////// 
              if (passy.equals(passwordy)) {
                  
                  //Get All Code Here////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                  
                  
                  
                     ////////////////////////////////////////////////////////////////////////////////////////////////////// 
              String dateandtime=value111 +" - "+value000;
              
              
    FileChooser fcho = new FileChooser();
    String go = NewDir.file_dir;
    fcho.setInitialDirectory(new File(go));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog((Window)null);
    String thename=f.getName().replace(".ks","").replace(".html","");
    String pathy = f.getAbsolutePath().toString();
    lonkko=pathy;
    
    funkifi=thename;
    
    String[] pathParts = pathy.split("\\\\");
            //String washName = pathParts[pathParts.length - 1].replaceAll("\\.ks$|\\.html$", "");
            //String model = pathParts.length >= 2 ? pathParts[pathParts.length - 2] : "Unknown";
    stageoo = pathParts.length >= 3 ? pathParts[pathParts.length - 3] : "Unknown";
    
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
      String didd1=NewDir.file_dir+"\\PRODUCTION\\";
      String didd2="\\"+f.getName();
      String didd3=NewDir.file_dir+"\\PILOT\\";
      String modelooo=pathy.replace(didd1,"").replace(didd3,"").replace(didd2,"");
       ///Decrypt////////////////////////////////////
       
       
    ////////////////////////////////////////////////////////////
    

    String longKey;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKey = cxsd.readLine();
    }
    if (longKey == null || longKey.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String result = KeyDecoder.extractData(longKey.trim());
    if (f == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = f.getAbsolutePath();
    File originalFile = new File(input);
    //Add backup here
    File backupFolder = new File("D:\\All_Recipessss\\Backup");
    if (!backupFolder.exists()) {
        backupFolder.mkdirs();
    }
    String backupFileName = originalFile.getName() + ".bak";
    File backupFile = new File(backupFolder, backupFileName);
    try {
        java.nio.file.Files.copy(originalFile.toPath(), 
                                backupFile.toPath(), 
                                java.nio.file.StandardCopyOption.REPLACE_EXISTING);
        System.out.println("✅ Backup created / updated: " + backupFile.getAbsolutePath());
    } catch (Exception backupEx) {
        System.out.println("⚠️ Warning: Failed to create backup - " + backupEx.getMessage());
    }
    // =================================================
    
    String tempOutput = System.getProperty("user.home")+"\\"+f.getName()+ ".tmp";
    System.out.println("Decrypting with password: " + result); // للتصحيح
    FileDecryptor.decrypt(input, tempOutput, result);
    


    ////////////////////////////////////////////////////////////
    
    lonkk=tempOutput;
       
       
           try { 
    myarea.clear();
    InputStream inputinstream=new FileInputStream(tempOutput);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    String lo;
    myarea.appendText("");
    while ((lo=bi.readLine())!=null) {
        myarea.appendText("\n"+lo
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
    
    ////////////////////////////////////////////////////////////////////////
    
    if (pathy != null) {
                historyFilePath = NewDir.file_dirrrr+"\\Recipes_History\\"+modelooo+"."+thename+".history.json";
                System.out.println(historyFilePath);
            try {
                originalContent = myarea.getText();
            } catch (Exception ex) {}
        }
    
    ////////////////////////////////////////////////////////////////////////
    
        }catch (Exception g) {}
//        //////////////////////////////////////////////
//
//                           
//        
//       String proco=null;
//       int bathnumzzzz=0;
//       String moduu,commentt;
//       
//       String ston,fom,hypo,enzym,moon,dryr1,dryr2,dryr3;
//       
//       ston="No";
//       fom="No";
//       hypo="No";
//       enzym="No";
//       moon="No";
//       dryr1="No";
//       dryr2="No";
//       dryr3="No";
//       
//       List<String> shots = new ArrayList<>();
//    
//       int bathnum=0;
//       
//        int dss=1;
//                            org.jsoup.nodes.Document docy = Jsoup.parse(myarea.getText());
//                            for (Element table : docy.select("table")) {
//                            for (Element row : table.select("tr")) {
//                            Elements tds = row.select("td");
//                            
//                            
//                            
//                            
//                            
//                            if (tds.get(7).text().contains("stone")||tds.get(7).text().contains("Stone")||tds.get(7).text().contains("STONE")||tds.get(7).text().contains("STON")||tds.get(7).text().contains("ston")) {
//                                
//                                ston="STONE";
//                                stonn=ston;
//                                
//                            }
//                            
//                             else {
//                                
//                             //   stonn="-";
//                               
//                                stonn=ston;
//                            }
//                            
//                            if (tds.get(7).text().contains("foam")||tds.get(7).text().contains("Foam")||tds.get(7).text().contains("FOAM")||tds.get(7).text().contains("BOOL")||tds.get(7).text().contains("BOOL فوم")||tds.get(7).text().contains("FOM")||tds.get(7).text().contains("fom")) {
//                                
//                                fom="FOAM";
//                                fomm=fom;
//                                
//                            }
//                            
//                             else {
//                                
//                               
//                             //   fomm="-";
//                               
//                                fomm=fom;
//                            }
//                            
//                            if (tds.get(7).text().contains("BLEACH")||tds.get(7).text().contains("HYPO")) {
//                                
//                                hypo="BLEACH";
//                                hypoo=hypo;
//                                
//                            }
//                            
//                             else {
//                                
//                              
//                             //   hypoo="-";
//                              hypoo=hypo;
//                                 
//                                
//                            }
//                            
//                            if (tds.get(7).text().contains("ENZYME")||tds.get(7).text().contains("ENZYM")||tds.get(7).text().contains("ACUDELL")||tds.get(7).text().contains("NSY")) {
//                                
//                                enzym="ENZYME";
//                                enzymm=enzym;
//                                
//                            }
//                            
//                             else {
//                                
//                               
//                             //   enzymm="-";
//                                enzymm=enzym;
//                                
//                            }
//                             
//                            if (tds.get(3).text().contains("MOON WASH")||tds.get(3).text().contains("MOON")||tds.get(3).text().contains("Moon Wash")||tds.get(3).text().contains("MON WASH")||tds.get(7).text().contains("PERMENGANATE")||tds.get(7).text().contains("PERMENGANAT")||tds.get(7).text().contains("PERMANGANATE")||tds.get(7).text().contains("PERMANGANAT")||tds.get(8).text().contains("POTASSIUM PERMANGANATE")||tds.get(8).text().contains("NOVA TEKS MOON")||tds.get(7).text().contains("PERMANGANAT TO2U")) {
//                                
//                                moon="MOON WASH";
//                                moonn=moon;
//                                
//                            }
//                                   
//                          
//                            else {
//                                
//                                
//                              //  moonn="-";
//                                 moonn=moon;
//                            }
//                              
//                            String dalil=tds.get(3).text();
//                            if (dalil.contains("EXTRACT")||dalil.contains("extract")||dalil.contains("Extract")||dalil.contains("EXTRA")||dalil.contains("EXTRACTION")||dalil.contains("extraction")) {
//                            shots.add(dalil);}
//                            else {
//                            
//                            
//                            
//                            }
//                            
//                           
//
//                           }}
//                            
//                            
//                          bathnum=shots.size();
//                          if (shots.size()==1) {
//                          dryr1="DRYER 1";
//                          dryr11=dryr1;
//                          dryr22="No";
//                          dryr33="No";
//                          }
//                          else if (shots.size()==2) {
//                          dryr1="DRYER 1";
//                          dryr2="DRYER 2";
//                          dryr11=dryr1;
//                          dryr22=dryr2;
//                          dryr33="No";
//                          }
//                          else if (shots.size()==3) {
//                          dryr1="DRYER 1";
//                          dryr2="DRYER 2";
//                          dryr3="DRYER 3";
//                          dryr11=dryr1;
//                          dryr22=dryr2;
//                          dryr33=dryr3;
//                          }
//                          else {
//                          dryr1="No";
//                          dryr2="No";
//                          dryr3="No";
//                          dryr11=dryr1;
//                          dryr22=dryr2;
//                          dryr33=dryr3;
//                          }
//                            
//     // Save To DB Here
//    Date currentDate1l = GregorianCalendar.getInstance().getTime();
//    DateFormat df1l = DateFormat.getDateInstance();
//    String dateString1l = df1l.format(currentDate1l);
//    Date d1l = new Date();
//    SimpleDateFormat sdf1l = new SimpleDateFormat("HH:mm:ss");
//    String timeString1l = sdf1l.format(d1l);
//    SimpleDateFormat sdf2l = new SimpleDateFormat("yyyy-MM-dd");
//    String dateString2l = sdf2.format(d1l);
//
//    String fann = "";
//    
//    try {
//        String sql0 = "select * from Recipe_Types where WashName = ? and Model = ?";
//        pst = conn.prepareStatement(sql0);
//        pst.setString(1, thename);
//        pst.setString(2, modelooo);
//        rs = pst.executeQuery();                    
//        
//        if (rs.next()) {                        
//            fann = "found";   
//        } else {
//            fann = "not_found";   
//        }
//        
//    } catch (Exception exception) {
//        exception.printStackTrace(); // Handle exceptions properly
//    } finally {
//        try {
//            if (rs != null) rs.close();
//            if (pst != null) pst.close();     
//        } catch (Exception exception) {
//            exception.printStackTrace(); // Handle exceptions properly
//        }
//    }
//
//    if (fann.equals("found")) {
//        try {
//            
//            
//            
//            String sqlp = "update Recipe_Types set Date = ?, Model = ?, WashName = ?, Rinse = ?, Stone = ?, Foam = ?, Bleach = ?, Enzyme = ?, MoonWash = ?, Dryer_1 = ?, Dryer_2 = ?, Dryer_3 = ? where WashName = ? and Model = ?";
//            pst = conn.prepareStatement(sqlp);
//            pst.setString(1, dateString2l);
//            pst.setString(2, modelooo);
//            pst.setString(3, thename);
//            pst.setString(4, "RINSE");
//            pst.setString(5, stonn);
//            pst.setString(6, fomm);
//            pst.setString(7, hypoo);
//            pst.setString(8, enzymm);
//            pst.setString(9, moonn);
//            pst.setString(10, dryr11);
//            pst.setString(11, dryr22);
//            pst.setString(12, dryr33);
//            pst.setString(13, thename); // WHERE clause parameters
//            pst.setString(14, modelooo);
//            pst.execute();
//            Notifications noti = Notifications.create();
//            noti.title("Successful");
//            noti.text("We have updated the types successfully.");
//            noti.hideAfter(Duration.seconds(3));
//            noti.position(Pos.CENTER);
//            noti.showInformation();
//            
//           
//        } catch (Exception exception) {
//            exception.printStackTrace(); // Handle exceptions properly
//        } finally {
//            try {
//                if (pst != null) pst.close();
//            } catch (Exception exception) {
//                exception.printStackTrace();
//            }
//        }
//    } else if (fann.equals("not_found")) {
//        try { 
//            
//            
//            
//              String reg = "insert into Recipe_Types (Date, Model, WashName, Rinse, Stone, Foam, Bleach, Enzyme, MoonWash, Dryer_1, Dryer_2, Dryer_3) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
//            pst = conn.prepareStatement(reg);
//            pst.setString(1, dateString2l);
//            pst.setString(2, modelooo);
//            pst.setString(3, thename);
//            
//            pst.setString(4, "RINSE");
//            pst.setString(5, stonn);
//            pst.setString(6, fomm);
//            pst.setString(7, hypoo);
//            pst.setString(8, enzymm);
//            pst.setString(9, moonn);
//            pst.setString(10, dryr11);
//            pst.setString(11, dryr22);
//            pst.setString(12, dryr33);
//            
//            pst.execute(); 
//            
//            Notifications noti = Notifications.create();
//            noti.title("Successful");
//            noti.text("We have inserted the new type successfully.");
//            noti.hideAfter(Duration.seconds(3));
//            noti.position(Pos.CENTER);
//            noti.showInformation();
//            
//            
//            
//        } catch (Exception exception) {
//            exception.printStackTrace(); // Handle exceptions properly
//        } finally {
//            try {
//                if (pst != null) pst.close();
//            } catch (Exception exception) {
//                exception.printStackTrace();
//            }
//        }
//    }
//    
//    
//    
//    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    
//      
//       String stages=null;
//       int bathnumzzz=0;
//       String modu,comment;
//    
//        int ds=1;
//                            org.jsoup.nodes.Document docyi = Jsoup.parse(myarea.getText());
//                            for (Element table : docyi.select("table")) {
//                            for (Element row : table.select("tr")) {
//                            Elements tds = row.select("td");
//                            if (tds.get(3).text().contains("/")||tds.get(3).text().contains("\\")||tds.get(3).text().isEmpty()||tds.get(3).text().contains("TEMP")||tds.get(3).text().contains("OPERATOR")||tds.get(3).text().contains("temp")||tds.get(3).text().contains("operator")/*||tds.get(3).text().contains("extract")||tds.get(3).text().contains("EXTRACT")||tds.get(3).text().contains("extraction")||tds.get(3).text().contains("EXTRACTION")*/||tds.get(3).text().matches("[0-9]+")||tds.get(3).text().contains("REMOV")||tds.get(3).text().contains("REMOVE")||tds.get(3).text().contains("BATH")||tds.get(3).text().contains("SAME")||tds.get(3).text().contains("PATH")||tds.get(3).text().contains("SAM")||tds.get(3).text().contains("RPM")||tds.get(3).text().contains("KG")||tds.get(3).text().contains("PCS")||tds.get(3).text().contains("DRAIN")||tds.get(3).text().contains("RIMOV")||tds.get(3).text().contains("RIMOVE")) {}
//                            else {
//                            String tempo=tds.get(3).text();
//                            if (tempo.contains("EXTRACT")||tempo.contains("Extract")||tempo.contains("extract")) {
//                               
//                                stages=stages+"\n"+"WASHING "+Integer.toString(ds++);
//                                
//                            }
//                            
//                            else {
//                                
//                                stages=stages+"\n"+tempo;
//                                
//                            }
//                            }
//                            
//
//                           }}
//             
//        String arabicRegex = "[\\u0600-\\u06FF]+";
//        Pattern pattern = Pattern.compile(arabicRegex);
//        
//        Matcher matcher = pattern.matcher(stages + "");
//        String modifiedLine = matcher.replaceAll("\n");
//        String lone = modifiedLine.replace("null", "\n");
//        
//        StringBuilder result = new StringBuilder();
//        String[] lines = lone.split("\n");
//        int nonEmptyCount = 0;
//        // Count non-empty lines to handle the last one differently
//        for (String line : lines) {
//            if (!line.trim().isEmpty()) {
//                nonEmptyCount++;
//            }
//        }
//        
//        int currentNonEmpty = 0;
//        for (String line : lines) {
//            if (!line.trim().isEmpty()) {
//                currentNonEmpty++;
//                result.append(line);
//                // Append " - " only if it's not the last non-empty line
//                if (currentNonEmpty < nonEmptyCount) {
//                    result.append(" - ");
//                }
//            }
//        }                                   
//                            
//      procccc=result.toString();         
//        
//        // Save To DB Here
//
//    String fannn = "";
//    
//    try {
//        String sql0 = "select * from Recipe_Processes where WashName = ? and Model = ?";
//        pst = conn.prepareStatement(sql0);
//        pst.setString(1, thename);
//        pst.setString(2, modelooo);
//        rs = pst.executeQuery();                    
//        
//        if (rs.next()) {                        
//            fannn = "found";   
//        } else {
//            fannn = "not_found";   
//        }
//        
//    } catch (Exception exception) {
//        exception.printStackTrace(); // Handle exceptions properly
//    } finally {
//        try {
//            if (rs != null) rs.close();
//            if (pst != null) pst.close();     
//        } catch (Exception exception) {
//            exception.printStackTrace(); // Handle exceptions properly
//        }
//    }
//
//    if (fannn.equals("found")) {
//        try {
//            String sqlp = "update Recipe_Processes set Date = ?, Model = ?, WashName = ?, Processes = ? where WashName = ? and Model = ?";
//            pst = conn.prepareStatement(sqlp);
//            pst.setString(1, dateString2l);
//            pst.setString(2, modelooo);
//            pst.setString(3, thename);
//            pst.setString(4, procccc);
//            pst.setString(5, thename); // WHERE clause parameters
//            pst.setString(6, modelooo);
//            pst.execute();
//            
//            Notifications noti = Notifications.create();
//            noti.title("Successful");
//            noti.text("We have updated the processes successfully.");
//            noti.hideAfter(Duration.seconds(3));
//            noti.position(Pos.CENTER);
//            noti.showInformation();
//            
//        } catch (Exception exception) {
//            exception.printStackTrace(); // Handle exceptions properly
//        } finally {
//            try {
//                if (pst != null) pst.close();
//            } catch (Exception exception) {
//                exception.printStackTrace();
//            }
//        }
//    } else if (fannn.equals("not_found")) {
//        try {                            
//            String reg = "insert into Recipe_Processes (Date, Model, WashName, Processes) values (?, ?, ?, ?)";
//            pst = conn.prepareStatement(reg);
//            pst.setString(1, dateString2l);
//            pst.setString(2, modelooo);
//            pst.setString(3, thename);
//            pst.setString(4, procccc);
//            pst.execute(); 
//            
//            Notifications noti = Notifications.create();
//            noti.title("Successful");
//            noti.text("We have inserted the new processes successfully.");
//            noti.hideAfter(Duration.seconds(3));
//            noti.position(Pos.CENTER);
//            noti.showInformation();
//            
//        } catch (Exception exception) {
//            exception.printStackTrace(); // Handle exceptions properly
//        } finally {
//            try {
//                if (pst != null) pst.close();
//            } catch (Exception exception) {
//                exception.printStackTrace();
//            }
//        }
//    }
//        
//    
//    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//    


    InputStream inputinstream=new FileInputStream(tempOutput);
    BufferedReader buf=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    OutputStream instreamm=new FileOutputStream(NewDir.file_dirrrr + "\\Editor\\kadysoft.html");
    PrintWriter pw = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    
    pw.append("<!DOCTYPE html>\n" +
"<html lang=\"ar\">\n" +
"<head>\n" +
"    <meta charset=\"utf-8\" />\n" +
"    <title></title>\n" +
"<style>\n" +
"        body {\n" +
"            user-select: none;\n" +
"            -webkit-user-select: none;\n" +
"            -moz-user-select: none;\n" +
"            -ms-user-select: none;\n" +
"        }\n" +
"</style>\n" +
"\n" +
"<script>\n" +
"document.addEventListener('dragstart', function(event) {\n" +
"    event.preventDefault();\n" +
"});\n" +
"document.addEventListener('drop', function(event) {\n" +
"    event.preventDefault();\n" +
"});\n" +
"document.addEventListener('contextmenu', function(event) {\n" +
"    event.preventDefault();\n" +
"});\n" +
"</script>\n" +
"\n" +
"<script>\n" +
"window.addEventListener(`contextmenu`, (e) => {\n" +
"    e.preventDefault();\n" +
"});\n" +
"</script>\n" +
"\n" +
"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\" />\n" +
"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css\" />\n" +
"<link rel=\"stylesheet\" href=\"https://cdn.bookingtimes.com/Styles/bootstrap-dialog.min.css\" />\n" +
"<link rel=\"stylesheet\" href=\"https://cdn.bookingtimes.com/Styles/bootstrap-tour.min.css\" />\n" +
"<link href=\"https://cdn.bookingtimes.com/Common/LoadCSS.ashx?k=874288&amp;v=185.346\" rel=\"stylesheet\" type=\"text/css\">\n" +
"<link href=\"https://cdn.bookingtimes.com/Common/LoadCSS.ashx?k=874288&amp;v=185.346&amp;g=1\" rel=\"stylesheet\" type=\"text/css\">\n" +
"\n" +
"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js\" type=\"text/javascript\"></script>\n" +
"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n" +
"<script src=\"https://cdn.bookingtimes.com/Scripts/jquery.slicknav.min.js\" type=\"text/javascript\"></script>\n" +
"<script src=\"https://cdn.bookingtimes.com/Scripts/bootstrap-tour.min.js\" type=\"text/javascript\"></script>\n" +
"\n" +
"<script src=\"./Scripts/tiny_mce/tinymce.min.js\" type=\"text/javascript\"></script>\n" +
"\n" +
"<style>\n" +
"#menuContainer {\n" +
"    background-color: black;\n" +
"}\n" +
"</style>\n" +
"\n" +
"<script>\n" +
"$(document).ready(function () {\n" +
"    $(\".modal\").on('shown', function () {\n" +
"        $(this).find(\"[autofocus]:first\").focus();\n" +
"    });\n" +
"    $('.modal').on('hidden.bs.modal', function () {\n" +
"        imageSelected(0, 0);\n" +
"    })\n" +
"});\n" +
"\n" +
"\n" +
"// ======================================\n" +
"// COPY / PASTE BRIDGE\n" +
"// ======================================\n" +
"function setupCopyPasteBridge() {\n" +
"\n" +
"  // Custom Copy\n" +
"  document.addEventListener('copy', function (e) {\n" +
"    const content = tinyMCE.activeEditor.selection.getContent({ format: 'html' });\n" +
"    if (typeof appClipboard !== 'undefined') {\n" +
"      appClipboard.setClipboardText(content);\n" +
"      e.preventDefault();\n" +
"    }\n" +
"  });\n" +
"\n" +
"  // Custom Paste\n" +
"  document.addEventListener('paste', function (e) {\n" +
"    if (typeof appClipboard !== 'undefined') {\n" +
"      const html = appClipboard.getClipboardText();\n" +
"      tinyMCE.activeEditor.execCommand('mceInsertContent', false, html);\n" +
"      e.preventDefault();\n" +
"    }\n" +
"  });\n" +
"}\n" +
"\n" +
"</script>\n" +
"\n" +
"<script>\n" +
"// =====================================================\n" +
"// TINYMCE INIT\n" +
"// =====================================================\n" +
"tinyMCE.init({\n" +
"    mode: \"specific_textareas\",\n" +
"    editor_selector: \"mceEditor\",\n" +
"    cleanup: false,\n" +
"    plugins: \"link,code,insertdatetime,preview,paste,table,visualblocks,fullscreen,image,emoticons,textcolor,colorpicker,lists,charmap,hr,print,autosave,charmap,codesample,colorpicker,fullpage,save,searchreplace,image,imagetools,help\",\n" +
"\n" +
"    menu: {\n" +
"        file: { title: 'File', items: 'print save | autosave charmap codesample | colorpicker fullpage searchreplace image imagetools' },\n" +
"        edit: { title: 'Edit', items: 'undo redo | cut copy paste pastetext selectall | searchreplace' },\n" +
"        format: { title: 'Format', items: 'strikethrough superscript subscript | removeformat' },\n" +
"        view: { title: 'View', items: 'visualblocks visualaid | preview fullscreen | code' },\n" +
"        table: { title: 'Table', items: 'inserttable tableprops deletetable | cell row column' },\n" +
"        about: { title: 'About', items: 'help' }\n" +
"    },\n" +
"\n" +
"    images_dataimg_filter: function (img) {\n" +
"        return img.hasAttribute('internal-blob');\n" +
"    },\n" +
"\n" +
"    toolbar1: \"formatselect , fontsizeselect | bold italic underline | outdent indent | bullist numlist | alignleft aligncenter alignright | forecolor backcolor | inserttable tableprops deletetable | cell row column | table save print imagetools image noneditable fullpage fullscreen code autosave bbcode emoticons emotions | preview \",\n" +
"\n" +
"    style_formats: [\n" +
"        { title: 'h1', block: 'h1' },\n" +
"        { title: 'h2', block: 'h2' },\n" +
"        { title: 'h3', block: 'h3' },\n" +
"        { title: 'h4', block: 'h4' },\n" +
"        { title: 'h5', block: 'h5' }\n" +
"    ],\n" +
"\n" +
"    visualblocks_default_state: false,\n" +
"    end_container_on_empty_block: true,\n" +
"    resize: 'both',\n" +
"    browser_spellcheck: true,\n" +
"    paste_text_sticky: true,\n" +
"    paste_data_images: true,\n" +
"    inline_styles: true,\n" +
"    schema: 'html5',\n" +
"\n" +
"    valid_children: \"+body[style|meta],+a[*],+input[*],+a[div|p|span],+input[div|p|span]\",\n" +
"    extended_valid_elements: \"div[*],iframe[*],a[*],p[*],img[*],input[*],script[*],meta[*]\",\n" +
"    allow_html_in_named_anchor: true,\n" +
"    remove_script_host: false,\n" +
"    convert_urls: false,\n" +
"    branding: false,\n" +
"    encoding: \"UTF-8\",\n" +
"\n" +
"    block_formats: 'Paragraph=p;Heading 2=h2;Heading 3=h3;Heading 4=h4;Heading 5=h5;Heading 6=h6;Address=address;Pre=pre',\n" +
"\n" +
"    init_instance_callback: function () {\n" +
"        if (typeof tinyMCE_Init == \"function\") { tinyMCE_Init(); }\n" +
"    },\n" +
"\n" +
"    setup: function (editor) {\n" +
"\n" +
"        setupCopyPasteBridge();\n" +
"\n" +
"        // ===============================\n" +
"        // إزالة p داخل الجدول\n" +
"        // ===============================\n" +
"        editor.on(\"BeforeSetContent\", function (e) {\n" +
"            if (e.content && e.content.includes(\"<tr\")) {\n" +
"                e.content = e.content.replace(/<p>/g, \"\").replace(/<\\/p>/g, \"\");\n" +
"            }\n" +
"        });\n" +
"\n" +
"\n" +
"        // ============================================================\n" +
"        // 🔥🔥 FORMAT PAINTER (copy/paste formatting like Excel)\n" +
"        // ============================================================\n" +
"        let copiedFormat = null;\n" +
"\n" +
"        // COPY format: Ctrl + Shift + F\n" +
"        editor.addShortcut('ctrl+shift+f', 'Copy Cell Format', function () {\n" +
"            let cell = editor.selection.getNode();\n" +
"            if (cell.nodeName !== \"TD\" && cell.nodeName !== \"TH\") {\n" +
"                alert(\"Please select a table cell to copy formatting.\");\n" +
"                return;\n" +
"            }\n" +
"            copiedFormat = cell.getAttribute(\"style\");\n" +
"            alert(\"Format Copied ✔\");\n" +
"        });\n" +
"\n" +
"        // PASTE format: Ctrl + Shift + V\n" +
"        editor.addShortcut('ctrl+shift+v', 'Paste Cell Format', function () {\n" +
"            if (!copiedFormat) {\n" +
"                alert(\"No format copied yet.\");\n" +
"                return;\n" +
"            }\n" +
"\n" +
"            let selectedCells = editor.selection.getSelectedBlocks();\n" +
"\n" +
"            if (selectedCells.length === 0) {\n" +
"                let node = editor.selection.getNode();\n" +
"                if (node.nodeName === \"TD\" || node.nodeName === \"TH\") {\n" +
"                    selectedCells = [node];\n" +
"                }\n" +
"            }\n" +
"\n" +
"            selectedCells.forEach(c => {\n" +
"                if (c.nodeName === \"TD\" || c.nodeName === \"TH\") {\n" +
"                    c.setAttribute(\"style\", copiedFormat);\n" +
"                }\n" +
"            });\n" +
"\n" +
"            alert(\"Format Applied ✔\");\n" +
"        });\n" +
"\n" +
"\n" +
"        // ============================================================\n" +
"        // تلوين الخلية (Ctrl + Shift + C)\n" +
"        // ============================================================\n" +
"        editor.addShortcut('ctrl+shift+c', 'Change Table Cell Color', function() {\n" +
"            var selectedNode = editor.selection.getNode();\n" +
"            if (selectedNode.nodeName === 'TD' || selectedNode.nodeName === 'TH' || selectedNode.nodeName === 'TR') {\n" +
"                selectedNode.style.backgroundColor = 'yellow';\n" +
"            } else {\n" +
"                alert('Please select a table cell to change its color.');\n" +
"            }\n" +
"        });\n" +
"\n" +
"    }\n" +
"});\n" +
"</script>\n" +
"\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"<center>\n" +
"    <div class=\"col-sm-9\">\n" +
"        <textarea rows=\"2\" cols=\"20\" id=\"txtBody\" class=\"mceEditor\" autocomplete=\"off\" style=\"height: 800px; width: 100%;\" aria-hidden=\"true\">"+
"			\n" +
"			\n" +
"			");
    
    String line;
    while ((line = buf.readLine()) != null)  
      pw.append(line
              
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
       .replace("&NBSP;","").replace("<HTML ","<HTML CONTENTEDITABLE ").replace("-WEBKIT-USER-SELECT:","").replace("-MOZ-USER-SELECT:","").replace("-MS-USER-SELECT:","").replace("DOCUMENT.ADDEVENTLISTENER","").replace("USER-SELECT:","").replace("EVENT.PREVENTDEFAULT();","").replace("E.PREVENTDEFAULT();","").replace("<html ","<html contenteditable ").replace("-webkit-user-select:","").replace("-moz-user-select:","").replace("-ms-user-select:","").replace("document.addeventlistener","").replace("user-select:","").replace("event.preventdefault();","").replace("e.preventdefault();","").replace("<html ","<html contenteditable ").replace("-webkit-user-select:","").replace("-moz-user-select:","").replace("-ms-user-select:","").replace("document.addEventListener","").replace("user-select:","").replace("event.preventDefault();","").replace("e.preventDefault();","")
              
              .replace(" WIDTH=\"300\" HEIGHT=\"90\" ALT=\"DEVELOPED BY KADYSOFT LTD (AHMED ELKADY).\" STYLE=\"BORDER-COLOR:BLACK;BORDER-WIDTH:10PX;\">","")/*.replace("<B>MR_MOHARAM SIGNATURE: </B><IMG SRC=\"FILE://Z:\\MODELS\\MR_MOHARAM.PNG\"","").replace("<B>MR_MOHAMED SIGNATURE: </B><IMG SRC=\"FILE://Z:\\MODELS\\MR_MOHAMED.PNG\"","")*/.replace("<B>MR_MUHAMMET SIGNATURE: </B><IMG SRC=\"FILE://Z:\\MODELS\\MR_MUHAMMET.PNG\"","").replace("<B ID=\"SIGNNAME\">MR_MUHAMMET SIGNATURE: </B>","").replace("<IMG ID=\"SIGNIMAGE\" SRC=\"FILE://Z:\\MODELS\\MR_MUHAMMET.PNG\"","").replace("BODY {\n" +
"  BACKGROUND-IMAGE: URL(\""+modelooo.toUpperCase()+".BMP\");\n" +
"  BACKGROUND-POSITION: CENTER;\n" +
"  HEIGHT: 170PX;\n" +
"BACKGROUND-POSITION-X:550PX;  BACKGROUND-REPEAT: NO-REPEAT;\n" +
"  BACKGROUND-SIZE: 120PX 90PX;\n" +
"}","") + "\n"); 
    
    
//       pw.append("<style>\n" +
//"        body {\n" +
//"            user-select: none;\n" +
//"            -webkit-user-select: none;\n" +
//"            -moz-user-select: none;\n" +
//"            -ms-user-select: none;\n" +
//"        }\n" +
//"    </style>"
//            + ""
//            + "<script>\n" +
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
//"    </script>\n" +
//"	\n" +
//"	<script>\n" +
//"  \n" +
//"  window.addEventListener(`contextmenu`, (e) => {\n" +
//"    e.preventDefault();\n" +
//"});\n" +
//"  \n" +
//"  </script>"
//            + "");
    
    
     
    pw.append("			\n" +
"			\n" +
"</textarea>\n" +
"    </div>\n" +
"</center>\n" +
"</body>\n" +
"</html>");
    
   
    
    pw.close();
    buf.close();
    
    
    
    
    
//Alert alertio = new Alert(Alert.AlertType.CONFIRMATION);
//alertio.setTitle("Edit Recipe");
//alertio.setHeaderText("Method to choose...");
//alertio.setContentText("What is the method you wanna use to edit recipe?");
//ButtonType buttonTypeOne = new ButtonType("Fast Method");
//ButtonType buttonTypeCancel = new ButtonType("Detailed Method");
//alertio.getButtonTypes().setAll(buttonTypeOne);
//DialogPane dialogPaneii = alertio.getDialogPane();
//dialogPaneii.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
//Optional<ButtonType> results = alertio.showAndWait();
//if (results.isPresent() && results.get() == buttonTypeOne) {

//   
//    SwingUtilities.invokeLater(() -> {
//    new Helper_Editor();
//});
//            
    
            //New
            Stage stg = new Stage();
            Parent root = FXMLLoader.<Parent>load(getClass().getResource("Helper_Editor.fxml"));
            Scene sce = new Scene(root);
            sce.getStylesheets().add("table-cell-color-example.css");
            stg.setTitle("Receta Editor");
            stg.centerOnScreen();
            stg.setResizable(true);
            stg.setScene(sce);
            stg.centerOnScreen();
            stg.setMaximized(true);
            stg.getIcons().add(new Image(Main.class.getResourceAsStream("washing.png")));
            stg.show();
            
//}
//else{
    
  
     //Old

//            Desktop desk = Desktop.getDesktop();
//            desk.open(new File(NewDir.file_dirrrr + "\\Editor\\kadysoft.html"));
//            saverecipe.fire();
            
   
//}
    
   
    Stage jk = (Stage)this.website.getScene().getWindow();
    jk.setIconified(true);
    
     ///////////////Modify DB and Signature////////////////
          
          String filename=f.getName().replace(".html","").replace(".ks","");
          Date currentDate = GregorianCalendar.getInstance().getTime();
          DateFormat df = DateFormat.getDateInstance();
          String dateString = df.format(currentDate);
          Date d = new Date();
          SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
          String timeString = sdf.format(d);
          String value0 = timeString;
          try{
              
             String sql= "update Creation set Name='"+filename+"',Date='"+value0+"',Type='Pending',Revised_Date='Not_Revised' where Name='"+filename+"'";

                pst=conn.prepareStatement(sql);
                pst.execute();
              }catch(Exception e){    
            }
            finally {
                try{
                    rs.close();
                    pst.close();
                }
                catch(Exception e){
                }
          }
          //////////////////////////////////////////////////////
    this.saverecipe.setDisable(false);
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////Audit/////////////////////////////////////
    String value1 = timeString;
    ////////////////Machine ID////////////////
    //////////////////////////////////////////////////
          
          String batchcode="@echo off\n" +
"for /f \"tokens=3\" %%a in ('reg query \"HKLM\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\" /v CurrentBuild') do (\n" +
"    if %%a geq 22000 (\n" +
"        echo Windows 11\n" +
"    ) else (\n" +
"        echo Windows 10\n" +
"    )\n" +
")\n" +
"";
          String pathofbat=System.getProperty("user.home")+"\\kadinio.bat";
          File fafa=new File (pathofbat);
          fafa.deleteOnExit();
          PrintWriter paq=new PrintWriter (new FileWriter (fafa));
          paq.println(batchcode);
          paq.close();
          
            try {
            ProcessBuilder processBuilder = new ProcessBuilder(pathofbat);
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String lineq;
            while ((lineq = reader.readLine()) != null) {
            //System.out.println(line);
            windowsversion=lineq;
            }
            int exitCode = process.waitFor();
            //System.out.println("Batch file executed with exit code: " + exitCode);
            } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            }
 
            if (windowsversion.equals("Windows 10")) {
                
                //Windows10
                
              String command="wmic bios get serialnumber";
              StringBuffer output=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output.append(linee+"\n");
                   }
                   MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
                   
                
                
            }
            
            else if (windowsversion.equals("Windows 11")) {
                
                //Windows11
                
              String command="powershell Get-CimInstance -ClassName Win32_BIOS | Select-Object SerialNumber";
              StringBuffer output=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output.append(linee+"\n");
                   }
                   MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim().replace("SerialNumber","").replace("------------","").replace("\n","");
                
                
            }
            
            else {
                
                //Windows7 or less like windows 10
                
              String command="wmic bios get serialnumber";
              StringBuffer output=new StringBuffer();
                  Process SerNumProcess=Runtime.getRuntime().exec(command);
                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
                   String linee="";
                   while ((linee=sNumReader.readLine())!=null) {
                   output.append(linee+"\n");
                   }
                   MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
                
                
            }
            
            
          
          //////////////////////////////////////////////////
          
    
    
    // String command="wmic bios get serialnumber";
       //       StringBuffer output=new StringBuffer();
              try {
//                  Process SerNumProcess=Runtime.getRuntime().exec(command);
//                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
//                   String linee="";
//                   while ((linee=sNumReader.readLine())!=null) {
//                       output.append(linee+"\n");
//                   }
//                   String MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
                   //System.out.println(MachineID);
    
    //////////////////////////////////////////
          
          String sqla = "insert into Audit (Date,User,PC_MAC,Status) values (?,?,?,?) ";
          this.pst = this.conn.prepareStatement(sqla);
          this.pst.setString(1, dateandtime);
          this.pst.setString(2, theuser);
          this.pst.setString(3, MachineID);
          this.pst.setString(4, theuser+" is editing a recipe called "+thename);
          
          this.pst.execute();
              }
              catch (Exception e) {
          JOptionPane.showMessageDialog(null, e);
        } finally {
          try {
            this.rs.close();
            this.pst.close();
          } catch (Exception exception) {}
        }  
          
          
          //////////////////////////////////////////////////////////////////////////////
          //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
                  
                  ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                  
              }
              else {
              Notifications noti = Notifications.create();
              noti.title("Fatal Error!");
              noti.text("We Can't continue, Password is incorrect.");
              noti.position(Pos.CENTER);
              noti.hideAfter(Duration.seconds(3));
              noti.showError();
              }
              //////////////////////////////////////////////////////////////////////////////////////
          }
          
      }   
      else if (optiono.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Recipe wasn't edited.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {}
              
          
              
              //////////////////////////////////////////////////////////////
          }
      }
      else if (option.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Recipe wasn't edited.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
      /////////////////////////////////////////END/////////////////////////////////////
          
      }
      
      
      else {
          
          //Noti to select
          
              Notifications noti = Notifications.create();
              noti.title("Fatal Error!");
              noti.text("We Can't continue, open admin first.");
              noti.position(Pos.CENTER);
              noti.hideAfter(Duration.seconds(3));
              noti.showError();
          
      }
      
   
    
  }
  
  /////////////////////////////////////////////////////Ahmed Elkady/////////////////////////////////////////////////////////////
  
  @FXML
  void editediteditaction(ActionEvent event) throws FileNotFoundException, IOException {
      
      
    HTMLEditor_Old editt = new HTMLEditor_Old();
    editt.start(new Stage());
    Stage jk = (Stage)this.website.getScene().getWindow();
    jk.setIconified(true); 
      
      
       
//              
//    FileChooser fcho = new FileChooser();
//    String go = NewDir.file_dir;
//    fcho.setInitialDirectory(new File(go));
//    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
//    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
//    fcho.setTitle("Kady Choose");
//    File f = fcho.showOpenDialog((Window)null);
//    String thename=f.getName().replace(".ks","").replace(".html","");
//    String pathy = f.getAbsolutePath().toString();
//    
//    
//    
//     // String didd1=NewDir.file_dir+"\\PRODUCTION\\";
//     // String didd2="\\"+f.getName();
//     // String didd3=NewDir.file_dir+"\\PILOT\\";
//     // String modelooo=pathy.replace(didd1,"").replace(didd3,"").replace(didd2,"");
//       ///Decrypt////////////////////////////////////
//           try { 
//    myarea.clear();
//    InputStream inputinstream=new FileInputStream(pathy);
//    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
//    String lo;
//    myarea.appendText("");
//    while ((lo=bi.readLine())!=null) {
//        myarea.appendText("\n"+lo
//       .replace("ﬦ","A")
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
//      ); 
//    }
//    bi.close();
//        }catch (Exception g) {}
//        //////////////////////////////////////////////
//
//  String codefff=myarea.getText();
//  
  
          
          
    
    
  }
  
  
  ////////////////////////////////////////////////////////Aiar//////////////////////////////////////////////////////////////////
  
  @FXML
  void openoldrecipeaction(ActionEvent event) throws IOException {
    Stage stg = new Stage();
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("CVLoader.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Modify Old Recipe");
    stg.centerOnScreen();
    stg.setResizable(false);
    stg.setScene(sce);
    stg.centerOnScreen();
    stg.getIcons().add(new Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
  //  Stage jk = (Stage)this.textarea.getScene().getWindow();
  }
  
  
  @FXML
  void exitaction(ActionEvent event) {
    Platform.exit();
  }
  
  @FXML
  void aboutaction(ActionEvent event) throws IOException, DocumentException {
  
//    Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
//    ImageView imgview = new ImageView();
//    imgview.setImage(img);
//    Notifications noti = Notifications.create();
//    noti.title("About Me");
//    noti.text("Hi, I'am Ahmed Elkady :) \nMade with love by Kadysoft Ltd.");
//    noti.hideAfter(Duration.minutes(1.0D));
//    noti.graphic(imgview);
//    noti.position(Pos.CENTER);
//    noti.show();


  
// ====================== Modern About Me Notification ======================
Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
ImageView imgview = new ImageView(img);
imgview.setFitWidth(85);
imgview.setFitHeight(85);
imgview.setPreserveRatio(true);
showGlassmorphismNotification(imgview);
 
  }

// ====================== الدالة (حطها في الكلاس بتاعك) ======================

private void showGlassmorphismNotification(ImageView avatar) {
    
    VBox root = new VBox(18);
    root.setAlignment(Pos.CENTER);
    root.setStyle(
        "-fx-background-color: rgba(20, 20, 35, 0.75);" +     // شفافية عالية
        "-fx-background-radius: 26;" +
        "-fx-padding: 32;" +
        "-fx-border-radius: 26;" +
        "-fx-border-color: rgba(120, 200, 255, 0.6);" +
        "-fx-border-width: 2;"
    );

    // Avatar مع glow
    avatar.setStyle("-fx-effect: dropshadow(gaussian, rgba(100, 220, 255, 0.8), 25, 0, 0, 0);");

    Label title = new Label("Ahmed Elkady");
    title.setStyle("-fx-text-fill: white; -fx-font-size: 23px; -fx-font-weight: bold;");

    Label subtitle = new Label("Hi, I'm Ahmed Elkady :)");
    subtitle.setStyle("-fx-text-fill: #c0c0ff; -fx-font-size: 15px;");

    Label desc = new Label("Made with ❤ by Kadysoft Ltd.");
    desc.setStyle("-fx-text-fill: #bbbbbb; -fx-font-size: 14px;");

    // Links
    Hyperlink linkedin = createModernLink("🔗 LinkedIn", "https://linkedin.com/in/ahmed-elkady-9a4529162");
    Hyperlink github    = createModernLink("🐙 GitHub",    "https://github.com/ProgKady");
    Hyperlink website   = createModernLink("🌐 Website",   "https://kadysoft.com/kadinioo");

    HBox linksBox = new HBox(25, linkedin, github, website);
    linksBox.setAlignment(Pos.CENTER);

    root.getChildren().addAll(avatar, title, subtitle, desc, linksBox);

    Scene scene = new Scene(root, 400, 360);
    scene.setFill(Color.TRANSPARENT);

    Stage stage = new Stage(StageStyle.TRANSPARENT);
    stage.setScene(scene);
    stage.setAlwaysOnTop(true);
    stage.setResizable(false);

    // Position: أسفل يمين الشاشة
    Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
    stage.setX(bounds.getWidth() - 430);
    stage.setY(bounds.getHeight() - 400);

    stage.show();

    // Animation
    FadeTransition fadeIn = new FadeTransition(Duration.millis(400), root);
    fadeIn.setFromValue(0);
    fadeIn.setToValue(1);
    fadeIn.play();

    // Auto hide بعد 7 ثواني
    PauseTransition pause = new PauseTransition(Duration.seconds(7));
    pause.setOnFinished(e -> {
        FadeTransition fadeOut = new FadeTransition(Duration.millis(500), root);
        fadeOut.setFromValue(1);
        fadeOut.setToValue(0);
        fadeOut.setOnFinished(ev -> stage.close());
        fadeOut.play();
    });
    pause.play();
}

// دالة اللينكات بـ Desktop (بدون getHostServices)
private Hyperlink createModernLink(String text, String url) {
    Hyperlink link = new Hyperlink(text);
    link.setStyle("-fx-text-fill: #7dd3ff; -fx-font-size: 14.5px; -fx-underline: false;");
    
    link.setOnAction(e -> {
        try {
            java.awt.Desktop.getDesktop().browse(new java.net.URI(url));
        } catch (Exception ex) {
            ex.printStackTrace();
            // يمكنك إضافة Alert هنا لو حابب
        }
    });
    return link;
}
  
  
  
  
  
  
  
  
  @FXML
  void editadvaction(ActionEvent event) throws FileNotFoundException, IOException {
//    if (this.textarea.getText().contains("table")) {
//      this.textarea.setVisible(true);
//      int p = JOptionPane.showConfirmDialog(null, "Are you sure you want to open another recipe to edit?\nYou will lose that one, Save it first please.", "Edit New Recipe", 0);
//      if (p == 0) {
//        this.textarea.clear();
//        this.view.getEngine().load("");
//        FileChooser fcho = new FileChooser();
//        String go = NewDir.file_dir;
//        fcho.setInitialDirectory(new File(go));
//        fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("KADYSOFT Files", new String[] { "*.ks" }));
//        fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
//        
//        fcho.setTitle("Kady Choose");
//        File f = fcho.showOpenDialog((Window)null);
//        String pathy = f.getAbsolutePath().toString();
//        BufferedReader buf = new BufferedReader(new FileReader(pathy));
//        String line;
//        while ((line = buf.readLine()) != null)
//          this.textarea.appendText(line + "\n"); 
//        buf.close();
//        this.buttonspane.setVisible(true);
//        this.actionname.setDisable(false);
//        this.time.setDisable(false);
//        this.control.setDisable(false);
//        this.temprature.setDisable(false);
//        this.liters.setDisable(false);
//        this.amount.setDisable(false);
//        this.units.setDisable(false);
//        this.chemical.setDisable(false);
//        this.chemicalsign.setDisable(false);
//        this.textarea.setDisable(false);
//        this.textarea.setEditable(true);
//        this.view.setVisible(true);
//        this.view.getEngine().loadContent(this.textarea.getText());
//        this.model.setDisable(true);
//        this.stage.setDisable(true);
//        this.editmenu.setVisible(true);
//      } 
//    } else {
//      this.textarea.setVisible(true);
//      this.textarea.clear();
//      this.view.getEngine().load("");
//      FileChooser fcho = new FileChooser();
//      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("KADYSOFT Files", new String[] { "*.ks" }));
//      fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Html Files", new String[] { "*.html" }));
//      fcho.setTitle("Kady Choose");
//      File f = fcho.showOpenDialog((Window)null);
//      String pathy = f.getAbsolutePath().toString();
//      BufferedReader buf = new BufferedReader(new FileReader(pathy));
//      String line;
//      while ((line = buf.readLine()) != null)
//        this.textarea.appendText(line + "\n"); 
//      buf.close();
//      this.buttonspane.setVisible(true);
//      this.actionname.setDisable(false);
//      this.time.setDisable(false);
//      this.control.setDisable(false);
//      this.temprature.setDisable(false);
//      this.liters.setDisable(false);
//      this.amount.setDisable(false);
//      this.units.setDisable(false);
//      this.chemical.setDisable(false);
//      this.chemicalsign.setDisable(false);
//      this.textarea.setDisable(false);
//      this.textarea.setEditable(true);
//      this.view.setVisible(true);
//      this.view.getEngine().loadContent(this.textarea.getText());
//      this.editmenu.setVisible(true);
//    } 
  }
  
 
  
 
  @FXML
    void recipecontentsearchaction(ActionEvent event) {

        
        FileSearchApp fsa=new FileSearchApp();
        fsa.start(new Stage());
        
    }

    
 
 
    
  public void initialize(URL url, ResourceBundle rb) {
      
      

      
      try {
            String fontPath = getValueByKey("lib\\setto.cfg", "Fonts"); // غيّر المسار حسب مكان الخط عندك
            javafx.scene.text.Font cairoSemiBold = javafx.scene.text.Font.loadFont(new FileInputStream(fontPath), 15);
        } catch (FileNotFoundException ex) {
          
        }
    
      
      filemenu.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("file_2.png"))));
      viewmenu.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("view_1.png"))));
      editrecipemenu.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("editr.png"))));
      helpmenu.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("help_1.png"))));
      addstepmenu.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("addstep_1.png"))));
      toolsmenu.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("tool.png"))));
      reports.setGraphic(new ImageView(new Image(getClass().getResourceAsStream("report_1.png"))));
      

        
//        BufferedReader dfds=new BufferedReader  (new FileReader ("lib\\Website.cfg"));
//        String webbbb=dfds.readLine(); 
//        website.getEngine().setJavaScriptEnabled(true);
//        website.getEngine().load(webbbb);
//        //website.getEngine().load("https://www.tcgarments.com/");
//        //website.getEngine().load("https://www.taypa.com.tr/");   


website.getEngine().setJavaScriptEnabled(true);
File htmlFile = new File("lib/receta.html");
if (htmlFile.exists()) {
    String urlo = htmlFile.toURI().toString();
    website.getEngine().load(urlo);
}


//        SwingUtilities.invokeLater(() -> {
//            MainFrame1.open();
//        });


     // editedit.setGraphic(hohoho);
      
      
      //HEHEHE Fuck You.
      
      //Read, set vars (Static) then read from edit every time.
      
      /////////////////////////////////////////////////////////////////////
      
      
        try {
            // Read all lines from the file
            List<String> lines = Files.readAllLines(Paths.get(NewDir.file_dirr + "\\Cont.kady"));
            // Process each line and store in the Map
            for (String line : lines) {
                // Split the line into name and status
                String[] parts = line.split("=");
                if (parts.length == 2) {
                    String name = parts[0].trim();
                    String status = parts[1].trim();
                    nameStatusMap.put(name, status);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
      
//      try {
//      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Cont.kady"));
//      String line;
//      while ((line = buf.readLine()) != null) {
//          
//      } 
//      buf.close();
//      } catch (FileNotFoundException fileNotFoundException) {
//      } catch (IOException iOException) {}
      
      /////////////////////////////////////////////////////////////////////
      
//    filemenu.setGraphic(new ImageView (new Image(getClass().getResourceAsStream("file.png"))));
//    editmenu.setGraphic(new ImageView (new Image(getClass().getResourceAsStream("edit.png"))));
//    viewmenu.setGraphic(new ImageView (new Image(getClass().getResourceAsStream("view.png"))));
//    editrecipemenu.setGraphic(new ImageView (new Image(getClass().getResourceAsStream("editrecipe.png"))));
//    toolsmenu.setGraphic(new ImageView (new Image(getClass().getResourceAsStream("tools.png"))));
//    addstepmenu.setGraphic(new ImageView (new Image(getClass().getResourceAsStream("addstep.png"))));
//    reports.setGraphic(new ImageView (new Image(getClass().getResourceAsStream("report.png"))));
//    helpmenu.setGraphic(new ImageView (new Image(getClass().getResourceAsStream("help.png"))));
     
//    
//     final HourService hservice = new HourService();
//        hservice.setCalendarInstance(Calendar.getInstance());
//        hservice.setOnSucceeded(new EventHandler<WorkerStateEvent>() { // Anonymous
//
//            @Override
//            public void handle(WorkerStateEvent t) {   
//                hservice.restart();
//            }
//        });
//        hservice.start();
//    
      
    Toolkit tool = Toolkit.getDefaultToolkit();
    if (!tool.getLockingKeyState(20)) {
      tool.setLockingKeyState(20, true);
    } else {
      tool.setLockingKeyState(20, true);
    } 
    this.conn = db.java_db();
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String timeString = sdf.format(d);
    String value1 = dateString;
   // this.units.getItems().addAll(new String[] { "KG", "GR", "GARDAL", " " });
  //  this.stage.getItems().addAll(new String[] { "DEVELOPMENT", "PRODUCTION", "PILOT", "BLANKET", "SHRINK" });
  
  
  File gdfg=new File ("lib\\setto.cfg");
  gdfg.deleteOnExit();
  
  
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
//                protected Date call()
//                {
//                    int secondsdelay = 14400;
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
//////////////////////////////////////////////////////////////////////////////////
