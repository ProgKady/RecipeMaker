

/*
// Saver App For Recipe System.
*/


package kadysoft.kady;

import com.github.difflib.DiffUtils;
import com.github.difflib.patch.Patch;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
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
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.imageio.ImageIO;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import org.controlsfx.control.Notifications;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * FXML Controller class
 *
 * @author KADY
 */
public class SaverController implements Initializable {

    @FXML
    private Label editedby;
    
    @FXML
    private JFXListView<String> list;
    
    @FXML
    private JFXButton save,sendmaill;
    
    @FXML
    private JFXTextArea code;
    
    @FXML
    private JFXTextField find;
    
    @FXML
    private ComboBox<String> modell;
    
    @FXML
    private JFXCheckBox signme,fixche;
    

    static String filePath;
    PrintWriter pw;
    
  Connection conn = null;
  
  ResultSet rs = null;
  
  PreparedStatement pst = null;
  
  
  @FXML
  private Label lonk,lonk1;
  
    
    
    public static String lproduct,rproduct,tempraturee,ftank,etank,cdosage,timer_temprature,oldtimemin,oldtimehour,oldtimemin2,oldtimehour2,msg;
    
    public static String passy,passyy;
    
    public static double loadstone,loadstone2;
    public static double removestone,removestone2;
    public static double cleaningstone,cleaningstone2;
    public static double extraction,extraction2;
    public static double loadremovestone,loadremovestone2;
    public static double loadremoveproduct,loadremoveproduct2,loadremoveproductall;
    public static double tempraturetime,tempraturetime2,tempraturetimeall;
    public static double chemicaldosage,chemicaldosage2,chemicaldosageall;
    public static double fillemptytank,fillemptytank2,fillemptytankall;
    public static double gdf1,gdf2,gmf1,gmf2,summo,pcsnum,onegar;
    
    public static double stonabathth,stonabaththh;
    
    public static Elements domy;
    
    public static int bosbos,shoty;
    
    public static String datevalue,filenammm,modeloo,roraa,oldtotalcost,oldpcs,oldonegarmentcost;
    
    public static String findo,pecoco;
    
    public static double gmff1,gmff2;
    
    
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
      
       public static String stonny,finall;
   public static double sto,sumz,ally;
    
    public static String originalltextt;
      public static String historyyfileepathh;
    
    
    @FXML
    void sendmailaction(ActionEvent event) {
        
        
        

        //Show Alert /////////////////////////////////////////////
        JFXTextArea fr=new JFXTextArea ();
        fr.setMinSize(50, 50);
        fr.setVisible(false);
        
        JFXTextField path=new JFXTextField ();
        path.setStyle("-fx-font-weight:bold;-fx-font-size:13;");
        path.setLabelFloat(true);
        path.setMinWidth(350);
        path.setEditable(false);
        path.setPromptText("Original One Path ...");
        path.setText(lonk.getText());
        path.setOnMouseClicked(s -> {    
//            FileChooser fcho = new FileChooser();
//            String go = NewDir.file_dir;
//            fcho.setInitialDirectory(new File(go));
//            fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
//            fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Html Files", new String[] { "*.html" }));
//            fcho.setTitle("Kady Choose");
//            File f = fcho.showOpenDialog((Window)null);
//            String pathy = f.getAbsolutePath().toString();
//            path.setText("Congratulations you choosed one...");
//            ///Decrypt////////////////////////////////////
//           try { 
//            fr.clear();
//    InputStream inputinstream=new FileInputStream(pathy);
//    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
//    String lo;
//    while ((lo=bi.readLine())!=null) {
//        fr.appendText("\n"+lo
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
        //////////////////////////////////////////////
        });
        
        
        
    try { 
    fr.clear();
    InputStream inputinstream=new FileInputStream(path.getText());
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    String lo;
    while ((lo=bi.readLine())!=null) {
    fr.appendText("\n"+lo
       /*.replace("ﬦ","A")
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
       .replace("&NBSP;","")*/               
    ); 
    }
    bi.close();
    }catch (Exception g) {}
    ////////////////////////////////////////////
  
        
        ComboBox combo1=new ComboBox ();
        combo1.setPromptText("Editor Name...");
        combo1.setStyle("-fx-font-weight:bold;-fx-background-radius:3em;");
        combo1.setMinSize(350, 35);
        combo1.getSelectionModel().select(lonk1.getText());
        combo1.setOnShown(act -> {
            
            
      combo1.getItems().clear();
      try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Users.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
      combo1.getItems().addAll(new String[] { line });
      } 
      buf.close();
      } catch (FileNotFoundException fileNotFoundException) {
      } catch (IOException iOException) {}
    
    
        });
        
        
        
        ComboBox combo2=new ComboBox ();
        combo2.setPromptText("To Whom...");
        combo2.setStyle("-fx-font-weight:bold;-fx-background-radius:3em;");
        combo2.setMinSize(350, 35);
        combo2.setOnShown(act -> {
            
            
      combo2.getItems().clear();
      try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Mails.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
      combo2.getItems().addAll(new String[] { line });
      } 
      buf.close();
      } catch (FileNotFoundException fileNotFoundException) {
      } catch (IOException iOException) {}
            
            
        });
        
        
        
        JFXButton browse=new JFXButton ("Send");
        browse.setStyle("-fx-font-weight:bold;-fx-font-size:13;-fx-background-color:#1e81b0;-fx-background-radius:3em;-fx-text-fill:white;");
        browse.setOnAction(ac -> {
            /////Send Mail//////////////////////////////////////////////////////
            //Save the files then send
            File bn1=new File (System.getProperty("user.home")+"\\Mailed_Recipes");
            if (!bn1.exists()) {
                bn1.mkdir();
            }
            else {
                
            }
            
            
            try {
                File bn2=new File (bn1+"\\Original_Recipe.ks");
                File bn3=new File (bn1+"\\Edited_Recipe.ks");
                bn2.createNewFile();
                bn3.createNewFile();
                bn2.deleteOnExit();
                bn3.deleteOnExit();
                
                String gf1=fr.getText();
                OutputStream instreamm1=new FileOutputStream(bn2);
                PrintWriter pwe1 = new PrintWriter(new OutputStreamWriter (instreamm1,"UTF-8"));
                pwe1.println(gf1);
                pwe1.close();
                
                //Encrypt First
                
                String gf2=code.getText();
                OutputStream instreamm2=new FileOutputStream(bn3);
                PrintWriter pwe2 = new PrintWriter(new OutputStreamWriter (instreamm2,"UTF-8"));
                pwe2.println(gf2.replace("A","ﬦ")
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
       .replace("z","ףּ")         );
        pwe2.close();        
        Thread.sleep(100);
                
                /////////////////////////////////////////////Sending Mail................/////////////////////////////////////////////
                 
      String to = combo2.getSelectionModel().getSelectedItem().toString();
      String from = "ahmedelkadyteeest@gmail.com";
      final String username = "ahmedelkadyteeest@gmail.com";
      final String password = "lgrj esca tdtz froo";
      String filename1 = System.getProperty("user.home")+"\\Mailed_Recipes\\Original_Recipe.ks";
      String filename2 = System.getProperty("user.home")+"\\Mailed_Recipes\\Edited_Recipe.ks";

      
         String host = "smtp.gmail.com";
         Properties properties = System.getProperties();
         properties.put("mail.smtp.host", host);
         properties.put("mail.smtp.port", "465");
         properties.put("mail.smtp.ssl.enable", "true");
         properties.put("mail.smtp.auth", "true");
         Session session = Session.getInstance(properties,
         new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
         return new PasswordAuthentication(username, password);
         }});
         Message message = new MimeMessage(session);
         message.setFrom(new InternetAddress(from));
         message.setRecipients(Message.RecipientType.TO,
         InternetAddress.parse(to));
         message.setSubject("Washing Recipe For T&C Garments - Powered By Kadysoft Ltd. By Developer Ahmed Elkady, Whatsapp: +201555266002");
         BodyPart messageBodyPart1 = new MimeBodyPart();
         BodyPart messageBodyPart2 = new MimeBodyPart();
         messageBodyPart1.setText("The Editor is: "+combo1.getSelectionModel().getSelectedItem().toString()); //Add Editor Name Here
         messageBodyPart2.setText("Production Recipe has been edited.\nPowered By Kadysoft Ltd. CEO - Ahmed Elkady");
         Multipart multipart = new MimeMultipart();
         multipart.addBodyPart(messageBodyPart1);
         multipart.addBodyPart(messageBodyPart2);
         messageBodyPart1 = new MimeBodyPart();
         messageBodyPart2 = new MimeBodyPart();
         DataSource source1 = new FileDataSource(filename1);
         DataSource source2 = new FileDataSource(filename2);
         messageBodyPart1.setDataHandler(new DataHandler(source1));
         messageBodyPart2.setDataHandler(new DataHandler(source2));
         messageBodyPart1.setFileName(filename1);
         messageBodyPart2.setFileName(filename2);
         multipart.addBodyPart(messageBodyPart1);
         multipart.addBodyPart(messageBodyPart2);
         message.setContent(multipart);
         Transport.send(message);
               
             Notifications noti = Notifications.create();
             noti.title("Successful");
             noti.text("Recipes Were Sent Successfully....");
             noti.hideAfter(Duration.seconds(3));
             noti.position(Pos.CENTER);
             noti.showInformation();
                
                
                //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                
            } catch (IOException ex) {
                Logger.getLogger(SaverController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (InterruptedException ex) {
                Logger.getLogger(SaverController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (AddressException ex) {
                Logger.getLogger(SaverController.class.getName()).log(Level.SEVERE, null, ex);
            } catch (MessagingException ex) {
                Logger.getLogger(SaverController.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            ////////////////////////////////////////////////////////////////////
        });
        
        VBox vvv=new VBox ();
        vvv.setAlignment(Pos.CENTER);
        vvv.setSpacing(20);
        vvv.setMinSize(400, 120);
        vvv.getChildren().addAll(path,combo1,combo2,browse,fr);
        
        Alert aloo = new Alert(Alert.AlertType.INFORMATION);
        aloo.setTitle("Send Recipe To Mail ...");
        aloo.setHeaderText("To Whom...");
        aloo.setGraphic((Node)vvv);
        aloo.setResizable(false);
        aloo.setOnCloseRequest(ff -> {
            aloo.close();
        });
//        DialogPane dialogPane = aloo.getDialogPane();
//        dialogPane.getStylesheets().add(
//      getClass().getResource("primer-light.css").toExternalForm());

        DialogPane dialogPane = aloo.getDialogPane();
        dialogPane.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());

        aloo.showAndWait();
        
        
        
        //////////////////////////////////////////////////////////
        
        
        
        
    }
    
    
    
    
    @FXML
    void shift1action(ActionEvent event) {

//      if (signme.isSelected()==false) {
//      signme.setSelected(true);
//      //Noti
//      Notifications noti = Notifications.create();
//      noti.title("Fatal Error!");
//      noti.text("It must be selected.");
//      noti.position(Pos.CENTER);
//      noti.showError();
//      }
        
    }
    
    
    
    
    
    @FXML
    void areaclick(MouseEvent event) {

        code.clear();
        code.appendText(  
             "<style>\n" +
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
         );
        code.paste();
        
    }
    
    
    @FXML
    void modellrel(Event event) {

         this.modell.getItems().clear();
    try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Models.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        this.modell.getItems().addAll(new String[] { line });
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
        
        
    }
    
    
    @FXML
    void modellhide(Event event) {

        save.setDisable(false);
        
        
    }

    
 
    
    
    @FXML
    void saveaction(ActionEvent event) throws FileNotFoundException, IOException, WriterException {
        
        
      
      
        
        
/*
        //Getting File Link
        String filelink="Z:\\Recipe_System\\Editor\\index.html";  // It will Change For Every User   (NOTES).
        
        BufferedReader buf = new BufferedReader(new FileReader(filelink));
        String line = null;
        while ((line = buf.readLine()) != null) {
       
          
          System.out.println();
          
        } 
        buf.close();
      */  
       ////////////////////////////////////////////////// 
   /*     
    File file = new File("Z:\\Recipe_System\\Editor\\index.html");
    Scanner scanner = null;
    String line = "";

    // access file
    try {
        scanner = new Scanner(file);
    } catch (FileNotFoundException e) {
        System.out.println("File not found.");
        return; // don't continue if the file is not found
    }

    // if more lines in file, go to next line
    Boolean started = false;
    
            FileChooser dialog = new FileChooser();
            dialog.setInitialDirectory(new File("Z:\\Recipe_System\\Recipes"));
            dialog.setInitialFileName("Ahmed_Elkady_Kadysoft_Ltd");
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
            File dialogResult = dialog.showSaveDialog(null);
            filePath = dialogResult.getAbsolutePath().toString();
            pw = new PrintWriter(new BufferedWriter(new FileWriter(filePath)));
    
    while (scanner.hasNext()) {
        line = scanner.nextLine();

        if (line.equals("</tbody></table></center>\n" +
"</body></html>")) {
            started = false;
            // if you also immediately want to go out of the loop,
            // un-comment the following line:
            // break;
        }

        
            
        
        if (started) // tag in the txt to locate position
        {
            
            
            
            pw.println(line);
            
           
            
          //  System.out.println(line);
            
        }

        if (line.equals("<html lang=\"en-US\" contenteditable=\"\"><head>")) {
            started = true;
        }
    }
    scanner.close();
    pw.close();
    // Desktop
    
    Desktop desk = Desktop.getDesktop();
    desk.open(new File (filePath));
    
      Stage jk = (Stage)this.save.getScene().getWindow();
      jk.close();
       */
   
   
   //sendmaill.fire();
   
   
      
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Add Time?");
      alert.setHeaderText("Add Time To Recipe Or Not ...");
      alert.setContentText("Please Click 'OK' To Add Time To Recipe Or Click 'Cancel' To Continue Without Time.");
      DialogPane dialogPane = alert.getDialogPane();
      dialogPane.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> option = alert.showAndWait();
      if (option.get() == null) {
          
      } else if (option.get() == ButtonType.OK) {
      
          ////////////////////////////////////////////////////////////////////////////////////////////////////
         
             
   ///////////////////////////////////////Everything Will Go Here///////////////////////////////////////////////////
   
   String thecodee=code.getText();
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Get Time And Shots
   
   List<Integer> time = new ArrayList<>();
   List<Integer> timeSum = new ArrayList<>();
   List<String> shots = new ArrayList<>();
   int sum = 0, bathnum=0, firstshot=0, secondshot=0,thirdshot=0,forthshot=0;
   
   Document doc = Jsoup.parse(thecodee);
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
                          
//                          else if (shots.size()==3) {
//                          firstshot=timeSum.get(0);
//                          secondshot=timeSum.get(1)-timeSum.get(0);
//                          thirdshot=timeSum.get(2)-timeSum.get(1);
//                          }
//                          else if (shots.size()==4) {
//                          firstshot=timeSum.get(0);
//                          secondshot=timeSum.get(1)-timeSum.get(0);
//                          thirdshot=timeSum.get(2)-timeSum.get(1);
//                          forthshot=timeSum.get(3)-timeSum.get(2);
//                          }
                          
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
                            
                            Document docy = Jsoup.parse(thecodee);
                            
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
                            Document docc = Jsoup.parse(thecodee);
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
                            Document doccc = Jsoup.parse(thecodee);
                            for (Element table : docc.select("table")) {
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
                            Document docu = Jsoup.parse(thecodee);
                           
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
                            Document dock = Jsoup.parse(thecodee);
                            
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
        
      JFXTextField fss=new JFXTextField ("");
      fss.setPromptText("Write Stone Baths Number");
      fss.setMinSize(300, 30);
      fss.setLabelFloat(true);
      fss.setStyle("-fx-font-weight:bold;");
      fss.setEditable(true);
      
      JFXTextField fsss=new JFXTextField ("0");
      fsss.setPromptText("Addtional Time");
      fsss.setMinSize(300, 30);
      fsss.setLabelFloat(true);
      fsss.setStyle("-fx-font-weight:bold;");
      fsss.setEditable(true);
      
      VBox fewe=new VBox ();
      fewe.setSpacing(10);
      fewe.getChildren().addAll(fss,fsss);
      
      Alert alerto = new Alert(Alert.AlertType.INFORMATION);
      alerto.setTitle("Stone Bath?");
      alerto.setHeaderText("We found stone or foam "+stonebathhh+" times. but 1 shot.");
      alerto.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alerto.setGraphic(fewe);
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
          
          
        gmff1=Double.parseDouble(fsss.getText());
      
          
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
      
      JFXTextField fsssy=new JFXTextField ("0");
      fsssy.setPromptText("Addtional Time");
      fsssy.setMinSize(300, 30);
      fsssy.setLabelFloat(true);
      fsssy.setStyle("-fx-font-weight:bold;");
      fsssy.setEditable(true);
      
      VBox fewe=new VBox ();
      fewe.setSpacing(10);
      fewe.getChildren().addAll(fss,fsssy);
      
      Alert alerto = new Alert(Alert.AlertType.INFORMATION);
      alerto.setTitle("Stone Bath?");
      alerto.setHeaderText("We found stone or foam "+stonebathhh+" times. for the first shot.");
      alerto.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alerto.setGraphic(fewe);
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
          
          gmff1=Double.parseDouble(fsssy.getText());
      
          
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
      
      JFXTextField fssss=new JFXTextField ("0");
      fssss.setPromptText("Addtional Time");
      fssss.setMinSize(300, 30);
      fssss.setLabelFloat(true);
      fssss.setStyle("-fx-font-weight:bold;");
      fssss.setEditable(true);
      
      VBox fewer=new VBox ();
      fewer.setSpacing(10);
      fewer.getChildren().addAll(fsss,fssss);
      
      
      Alert alertoo = new Alert(Alert.AlertType.INFORMATION);
      alertoo.setTitle("Stone Bath?");
      alertoo.setHeaderText("We found stone or foam "+stonebathhh+" times. for the second shot.");
      alertoo.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alertoo.setGraphic(fewer);
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
          
          gmff2=Double.parseDouble(fssss.getText());
      
          
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
        gmf1=gmf1+gmff1;
        
        double number1 = gmf1;
        String formatted1 = String.format("%.1f", number1);
        gmf1=Double.parseDouble(formatted1);
        
        gdf1=(stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank)/60.0;
        
        double number11 = gdf1;
        String formatted11 = String.format("%.1f", number11);
        gdf1=Double.parseDouble(formatted11);
        
        //Write to recipe here //////////////////////////////////////////////////////////
        
Document report = Jsoup.parse(thecodee);
domy = report.children();
domy.select("tbody").append("<tr>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%; background-color: #f6ff00; border-color: #ff0000; text-align: center;\"><b>Recipe Time :</b> <u><b>"+Double.toString((gmf1))+"</b></u> <b>Mins.</b></td>\n" +
"<td style=\"width: 11.1111%; background-color: #f6ff00; border-color: #ff0000; text-align: center;\"><u><b>"+Double.toString((gdf1))+"</b></u> <b>Hours.</b></td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +        
"</tr>");

        
        /////////////////////////////////////////////////////////////////////////////////
        
    }
    
    else if (bathnumm==2) {
        
        gmf1=stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank;
        gmf1=gmf1+gmff1;
        
        double number1 = gmf1;
        String formatted1 = String.format("%.1f", number1);
        gmf1=Double.parseDouble(formatted1);
        
        gdf1=(stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank)/60.0;
        
        double number11 = gdf1;
        String formatted11 = String.format("%.1f", number11);
        gdf1=Double.parseDouble(formatted11);
        
        
        
        
        
        gmf2=stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2;
        gmf2=gmf2+gmff2;
        
        double number2 = gmf2;
        String formatted2 = String.format("%.1f", number2);
        gmf2=Double.parseDouble(formatted2);
        
        gdf2=(stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2)/60.0;
        
        double number22 = gdf2;
        String formatted22 = String.format("%.1f", number22);
        gdf2=Double.parseDouble(formatted22);
        
        
          //Write to recipe here //////////////////////////////////////////////////////////
        
Document report = Jsoup.parse(thecodee);
domy = report.children();
domy.select("tbody").append("<tr>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%; background-color: #f6ff00; border-color: #ff0000; text-align: center;\"><b>First Shot :</b> <u><b>"+Double.toString((gmf1))+"</b></u> <b>Mins.</b></td>\n" +
"<td style=\"width: 11.1111%; background-color: #f6ff00; border-color: #ff0000; text-align: center;\"><u><b>"+Double.toString((gdf1))+"</b></u> <b>Hours.</b></td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +        
"</tr>"
        + "<tr>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
"<td style=\"width: 11.1111%; background-color: #f6ff00; border-color: #ff0000; text-align: center;\"><b>Second Shot :</b> <u><b>"+Double.toString((gmf2))+"</b></u> <b>Mins.</b></td>\n" +
"<td style=\"width: 11.1111%; background-color: #f6ff00; border-color: #ff0000; text-align: center;\"><u><b>"+Double.toString((gdf2))+"</b></u> <b>Hours.</b></td>\n" +
"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +        
"</tr>");

        
        /////////////////////////////////////////////////////////////////////////////////
        
        
        
    }
    
    
    else {
        
        //Noti
        
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, We don't have 3 shots in one recipe.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showError();
    }
    
    
    
    /////////////////////////////////////////////Ending////////////////////////////////////////////////////////////
   
   
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   if (signme.isSelected()==true) {
       
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   if (fixche.isSelected()==true) {
       
       String codee = domy.toString();
      if (!codee.contains("TABLE")) {
      Notifications noti = Notifications.create();
      noti.title("Recipe Error");
      noti.text("Maybe not a recipe, Open a recipe first!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showError();    
        }
        else {
            Document docj = Jsoup.parse(codee);
        for (Element table : docj.select("TABLE")) {
        for (Element row : table.select("TR")) {
            Elements tds = row.select("TD");
            if (tds.get(7).text().isEmpty()) {   
            }
            else {  
             ///////////////////////////////////////////////////////////////
String string=tds.get(7).text();
BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Chemical_Dictionary.kady"));
String line;
String linebeforeequal;
String lineafterequal;
while ((line=buf.readLine())!=null) {
    
    
linebeforeequal=line.substring(0,line.indexOf("=")-0);
lineafterequal=line.substring(line.indexOf("=") + 1 , line.length());
if (string.equals(lineafterequal)) {
//System.out.println(string+" = "+linebeforeequal);
String formattedText = "<b style='display:block; text-align:center;'>" + linebeforeequal + "</b>";
tds.get(8).html(formattedText); // Use .html() instead of .text()     
//tds.get(8).text(linebeforeequal);
//System.out.println(tds.get(8).text());
break;

    }
    else {
        
    }
    
}
buf.close();
    
            }   
         
        }}
       roraa=docj.toString();
        }
      
      
        ////////////////////////////////////////////////////////////////////////////// 
org.jsoup.nodes.Document doct = Jsoup.parse(roraa);
for (Element table : doct.select("TABLE")) {
for (Element row : table.select("TR")) {
Elements tds = row.select("TD");
if (tds.get(8).text().isEmpty()) {   
}
else {  
String string=tds.get(8).text();
BufferedReader bufi=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Lot_Numbers.kady"));
String line;
String linebeforeequal;//Chemical Name
String lineafterequal;//Lot Numbers
boolean found = false;         
while ((line=bufi.readLine())!=null) {
linebeforeequal=line.substring(0,line.indexOf("="));//Chemical Name
lineafterequal=line.substring(line.indexOf("=") + 1);//Lot Numbers
if (string.equalsIgnoreCase(linebeforeequal)) {
System.out.println(linebeforeequal);
String formattedText = "<b style='display:block; text-align:center;'>" + lineafterequal + "</b>";
tds.get(9).html(formattedText); // Use .html() instead of .text()     
//tds.get(9).text(lineafterequal);
found = true;                    
break;
    }   
}
bufi.close();}}}
roraa=doct.toString();      
//////////////////////////////////////////////////////////////////////////////
   
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         
org.jsoup.nodes.Document doctp = Jsoup.parse(roraa);

// مر على كل جدول
for (Element table : doctp.select("table")) {
    for (Element row : table.select("tr")) {
        Elements tds = row.select("td");

        // اتأكد إن فيه على الأقل 11 عمود (0 → 10)
        if (tds.size() > 10) {
            String target = tds.get(8).text().trim();

            if (!target.isEmpty()) {
                Path mapPath = Paths.get(NewDir.file_dirrrr, "Recipe_Indexes", "Chemical_Translation.kady");

                try (BufferedReader bufi = Files.newBufferedReader(mapPath, StandardCharsets.UTF_8)) {
                    String line;
                    boolean found = false;

                    while ((line = bufi.readLine()) != null) {
                        // اتأكد إن السطر فيه =
                        if (!line.contains("=")) continue;

                        String linebeforeequal = line.substring(0, line.indexOf("=")).trim();
                        String lineafterequal = line.substring(line.indexOf("=") + 1).trim();

                        if (target.equalsIgnoreCase(linebeforeequal)) {
                            System.out.println("Matched: " + linebeforeequal);

                            String formattedText =
                                    "<b style='display:block; text-align:center;'>" +
                                            lineafterequal +
                                            "</b>";

                            // استبدل العمود رقم 10 بالنص الجديد
                            tds.get(10).html(formattedText);

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("No match for: " + target);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

roraa = doctp.toString();

       
       
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////



   }
   
   else {
       
       //Continue..........
       roraa=domy.toString();
   }
    
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
      
       
       
       
            //String codee=code.getText();
            String pathtosignature="file://"+NewDir.file_dirrrrr+"\\Mr_Muhammet.png";
            String modely=modell.getSelectionModel().getSelectedItem().toString();
            FileChooser dialog = new FileChooser();
            dialog.setInitialDirectory(new File(NewDir.file_dir));
            dialog.setInitialFileName("Ahmed_Elkady_Kadysoft_Ltd");
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
            File dialogResult = dialog.showSaveDialog(null);
            filePath = dialogResult.getAbsolutePath().toString();
            OutputStream instream=new FileOutputStream(filePath);
            pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
            pw.println("<!DOCTYPE html>\n<html lang=\"ar\">\n<head>\n<title>Kadysoft</title>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<style>td {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}\ntable {\nheight:5px;\nmax-width:100%;\nheight:100%;\nwhite-space:nowrap;\n}\ntr {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}"
                    + ""
                    + ""
                    
                        + ""
                + "/* Centered Watermark */\n" +
"    .watermark {\n" +
"      position: fixed;\n" +
"      top: 50%;\n" +
"      left: 50%;\n" +
"      transform: translate(-50%, -50%) rotate(-45deg);\n" +
"      background-image: url('logo.png'); /* Replace with the path to T & C Garments logo */\n" +
"      background-repeat: no-repeat;\n" +
"      background-size: contain;\n" +
"      width: 300px;\n" +
"      height: 200px;\n" +
"      opacity: 0.3;\n" +
"      pointer-events: none;\n" +
"      z-index: 1000;\n" +
"    }\n" +
"    /* Repeated Watermark */\n" +
"    .watermark-repeated {\n" +
"      position: fixed;\n" +
"      top: 0;\n" +
"      left: 0;\n" +
"      width: 100%;\n" +
"      height: 100%;\n" +
"      background-image: url('logo.png'); /* Replace with the path to T & C Garments logo */\n" +
"      background-repeat: repeat;\n" +
"      background-size: 300px 200px;\n" +
"      opacity: 0.2;\n" +
"      pointer-events: none;\n" +
"      z-index: 1000;\n" +
"    }"
                + ""
                + "</STYLE></HEAD>\n" +
"<BODY><CENTER>\n"
+ "<div class=\"watermark\"></div>" 
                
                    
                    + ""
                    + "\n\n");
            pw.println("<!-- Creating Recipe From Kadysoft Ltd.-->\n\n");
            pw.println(roraa);
            pw.println("\n\n</center>\n</body>\n</html>");
            pw.println("<b id=\"signname\">Mr_Muhammet Signature: "+"</b><img id=\"signimage\" src=\""+pathtosignature+"\" width=\"300\" height=\"90\" alt=\"Developed By Kadysoft Ltd (Ahmed Elkady).\" style=\"border-color:black;border-width:10px;\">");   
      
            if (roraa.contains("background-image:")) {
                
            }
            else {
                pw.println("\n\n<style>\n" +
"body {\n" +
"  background-image: url(\""+modely+".bmp\");\n" +
"  background-position: center;\n" +
"  height: 170px;\n" +
"background-position-x:550px;"+
"  background-repeat: no-repeat;\n" +
"  background-size: 120px 90px;\n" +
"}\n" +
"</style>");             
          }
            pw.close();
            
            
       /////////////////////////////////////////////////// 
    code.clear();
    InputStream inputinstream=new FileInputStream(filePath);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    //BufferedReader bi=new BufferedReader (new FileReader (pathy));
    String lo;
    while ((lo=bi.readLine())!=null) {
        
        code.appendText("\n"+lo
       .replace("A","ﬦ")
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
       .replace("z","ףּ")                
      ); 


    }
    bi.close();
    String gf=code.getText();
    OutputStream instreamm=new FileOutputStream(filePath);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    //PrintWriter pw=new PrintWriter (new FileWriter (pathy));
    pw.println(gf);
    pw.close();
    Notifications noti = Notifications.create();
    noti.title("Successful");
    noti.text("We have encrypted the recipe successfully.");
    noti.hideAfter(Duration.seconds(3));
    noti.position(Pos.CENTER);
    noti.showInformation();
    code.clear();

       //////////////////////////////////////////////////
        
       //////////////////////////////////////////////////
            //Desktop desk = Desktop.getDesktop();
            //desk.open(new File (filePath));
            Stage jk = (Stage)this.save.getScene().getWindow();
            jk.close();
   
       /////////////////////////////////////////////////// 
   
       //////////////////////////////////////////////////
       
   }
   
   
   else {
       
       
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   if (fixche.isSelected()==true) {
       
       String codee = domy.toString();
      if (!codee.contains("TABLE")) {
      Notifications noti = Notifications.create();
      noti.title("Recipe Error");
      noti.text("Maybe not a recipe, Open a recipe first!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showError();    
        }
        else {
            Document docj = Jsoup.parse(codee);
        for (Element table : docj.select("TABLE")) {
        for (Element row : table.select("TR")) {
            Elements tds = row.select("TD");
            if (tds.get(7).text().isEmpty()) {   
            }
            else {  
             ///////////////////////////////////////////////////////////////
String string=tds.get(7).text();
BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Chemical_Dictionary.kady"));
String line;
String linebeforeequal;
String lineafterequal;
while ((line=buf.readLine())!=null) {
linebeforeequal=line.substring(0,line.indexOf("=")-0);
lineafterequal=line.substring(line.indexOf("=") + 1 , line.length());
if (string.equals(lineafterequal)) {
//System.out.println(string+" = "+linebeforeequal);
String formattedText = "<b style='display:block; text-align:center;'>" + linebeforeequal + "</b>";
tds.get(8).html(formattedText); // Use .html() instead of .text()     
//tds.get(8).text(linebeforeequal);
//System.out.println(tds.get(8).text());
break;

    }
    else {
        
    }
    
}

buf.close();
    
            }   
         
        }}
       roraa=docj.toString();
        }
        
////////////////////////////////////////////////////////////////////////////// 
org.jsoup.nodes.Document doct = Jsoup.parse(roraa);
for (Element table : doct.select("TABLE")) {
for (Element row : table.select("TR")) {
Elements tds = row.select("TD");
if (tds.get(8).text().isEmpty()) {   
}
else {  
String string=tds.get(8).text();
BufferedReader bufi=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Lot_Numbers.kady"));
String line;
String linebeforeequal;//Chemical Name
String lineafterequal;//Lot Numbers
boolean found = false;         
while ((line=bufi.readLine())!=null) {
linebeforeequal=line.substring(0,line.indexOf("="));//Chemical Name
lineafterequal=line.substring(line.indexOf("=") + 1);//Lot Numbers
if (string.equalsIgnoreCase(linebeforeequal)) {
System.out.println(linebeforeequal);
String formattedText = "<b style='display:block; text-align:center;'>" + lineafterequal + "</b>";
tds.get(9).html(formattedText); // Use .html() instead of .text()     
//tds.get(9).text(lineafterequal);
found = true;                    
break;
    }   
}
bufi.close();}}}
roraa=doct.toString();      
//////////////////////////////////////////////////////////////////////////////
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         
org.jsoup.nodes.Document doctp = Jsoup.parse(roraa);

// مر على كل جدول
for (Element table : doctp.select("table")) {
    for (Element row : table.select("tr")) {
        Elements tds = row.select("td");

        // اتأكد إن فيه على الأقل 11 عمود (0 → 10)
        if (tds.size() > 10) {
            String target = tds.get(8).text().trim();

            if (!target.isEmpty()) {
                Path mapPath = Paths.get(NewDir.file_dirrrr, "Recipe_Indexes", "Chemical_Translation.kady");

                try (BufferedReader bufi = Files.newBufferedReader(mapPath, StandardCharsets.UTF_8)) {
                    String line;
                    boolean found = false;

                    while ((line = bufi.readLine()) != null) {
                        // اتأكد إن السطر فيه =
                        if (!line.contains("=")) continue;

                        String linebeforeequal = line.substring(0, line.indexOf("=")).trim();
                        String lineafterequal = line.substring(line.indexOf("=") + 1).trim();

                        if (target.equalsIgnoreCase(linebeforeequal)) {
                            System.out.println("Matched: " + linebeforeequal);

                            String formattedText =
                                    "<b style='display:block; text-align:center;'>" +
                                            lineafterequal +
                                            "</b>";

                            // استبدل العمود رقم 10 بالنص الجديد
                            tds.get(10).html(formattedText);

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("No match for: " + target);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

roraa = doctp.toString();

       
       
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////



   }
   
   else {
       
       //Continue..........
       roraa=domy.toString();
   }
    
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
      
       
       
            //String codee=code.getText();
            String pathtosignature="file://"+NewDir.file_dirrrrr+"\\Mr_Moharam.png";
            String modely=modell.getSelectionModel().getSelectedItem().toString();
            FileChooser dialog = new FileChooser();
            dialog.setInitialDirectory(new File(NewDir.file_dir));
            dialog.setInitialFileName("Ahmed_Elkady_Kadysoft_Ltd");
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
            File dialogResult = dialog.showSaveDialog(null);
            filePath = dialogResult.getAbsolutePath().toString();
            OutputStream instream=new FileOutputStream(filePath);
            pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
            pw.println("<!DOCTYPE html>\n<html lang=\"ar\">\n<head>\n<title>Kadysoft</title>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<style>td {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}\ntable {\nheight:5px;\nmax-width:100%;\nheight:100%;\nwhite-space:nowrap;\n}\ntr {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}"
                    + ""
                    + ""
                    
                        + ""
                + "/* Centered Watermark */\n" +
"    .watermark {\n" +
"      position: fixed;\n" +
"      top: 50%;\n" +
"      left: 50%;\n" +
"      transform: translate(-50%, -50%) rotate(-45deg);\n" +
"      background-image: url('logo.png'); /* Replace with the path to T & C Garments logo */\n" +
"      background-repeat: no-repeat;\n" +
"      background-size: contain;\n" +
"      width: 300px;\n" +
"      height: 200px;\n" +
"      opacity: 0.3;\n" +
"      pointer-events: none;\n" +
"      z-index: 1000;\n" +
"    }\n" +
"    /* Repeated Watermark */\n" +
"    .watermark-repeated {\n" +
"      position: fixed;\n" +
"      top: 0;\n" +
"      left: 0;\n" +
"      width: 100%;\n" +
"      height: 100%;\n" +
"      background-image: url('logo.png'); /* Replace with the path to T & C Garments logo */\n" +
"      background-repeat: repeat;\n" +
"      background-size: 300px 200px;\n" +
"      opacity: 0.2;\n" +
"      pointer-events: none;\n" +
"      z-index: 1000;\n" +
"    }"
                + ""
                + "</STYLE></HEAD>\n" +
"<BODY><CENTER>\n"
+ "<div class=\"watermark\"></div>" 
                
                    
                    + ""
                    + "\n\n");
            pw.println("<!-- Creating Recipe From Kadysoft Ltd.-->\n\n");
            pw.println(roraa);
            pw.println("\n\n</center>\n</body>\n</html>");
            //pw.println("<b>Mr_Moharam Signature: "+"</b><img src=\""+pathtosignature+"\" width=\"300\" height=\"90\" alt=\"Developed By Kadysoft Ltd (Ahmed Elkady).\" style=\"border-color:black;border-width:10px;\">");   
      
            if (roraa.contains("background-image:")) {
                
            }
            else {
                pw.println("\n\n<style>\n" +
"body {\n" +
"  background-image: url(\""+modely+".bmp\");\n" +
"  background-position: center;\n" +
"  height: 170px;\n" +
"background-position-x:550px;"+
"  background-repeat: no-repeat;\n" +
"  background-size: 120px 90px;\n" +
"}\n" +
"</style>");             
          }
            pw.close();
            
            
               /////////////////////////////////////////////////// 
   code.clear();
    InputStream inputinstream=new FileInputStream(filePath);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    //BufferedReader bi=new BufferedReader (new FileReader (pathy));
    String lo;
    while ((lo=bi.readLine())!=null) {
        
        code.appendText("\n"+lo
       .replace("A","ﬦ")
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
       .replace("z","ףּ")                
      ); 


    }
    bi.close();
    String gf=code.getText();
    OutputStream instreamm=new FileOutputStream(filePath);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    //PrintWriter pw=new PrintWriter (new FileWriter (pathy));
    pw.println(gf);
    pw.close();
    Notifications noti = Notifications.create();
    noti.title("Successful");
    noti.text("We have encrypted the recipe successfully.");
    noti.hideAfter(Duration.seconds(3));
    noti.position(Pos.CENTER);
    noti.showInformation();
    code.clear();


       //////////////////////////////////////////////////
            
            
            
            //Desktop desk = Desktop.getDesktop();
            //desk.open(new File (filePath));
            Stage jk = (Stage)this.save.getScene().getWindow();
            jk.close();
   
       /////////////////////////////////////////////////// 
   
       ///////////////////////////////////////////////////
   }
   
   
  //////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
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
      datevalue = timeString2;                                                          //Date
      
      modeloo=modell.getSelectionModel().getSelectedItem().toString();                 //Model
      
      filenammm=filePath.replace(NewDir.file_dir,"").replace("\\PRODUCTION","").replace("\\"+modeloo+"\\","").replace(".ks","").replace(".html","");
      
      shoty=1;
      

       try {
           
                    String sql0 = "select * from Timer where Name like '" + filenammm + "' and Model like '" + modeloo + "' ";
                    pst = conn.prepareStatement(sql0);
                    rs = pst.executeQuery();

                    
                    if (rs.next()) {
                        
                       //Update
                       
                       find.setText("found");
                       
                   ///////    
                       
                    }
                    
    ///////////////////////////////////////////////////////////////////////////////////                
                    
                    
                    else {
                        
                       //Insert
                       
                   find.setText("not_found");
                  
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
     
       
       
       
       
     String fifi=find.getText();
     
     
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
      pst.setString(1, filenammm);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
      
             
                                     
                String sqlp= "update Timer set Date='"+datevalue+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"', Total_Min='"+(mi1)+"', Total_Hour='"+(ti1)+"' where Name='"+filenammm+"' and Shot='"+ti3+"' ";
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
      pst.setString(1, filenammm);
      pst.setString(2, ti3);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
   //   pst.execute();
                            
         
                String sqlp= "update Timer set Date='"+datevalue+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"', Total_Min='"+(Double.toString(gmf1+gmf2))+"', Total_Hour='"+(Double.toString(gdf1+gdf2))+"'  where Name='"+filenammm+"' and Shot='"+ti3+"' ";
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
                                     
          
                String sqlp= "update Timer set Date='"+datevalue+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+ti2+"', Total_Min='"+(Double.toString(gmf1+gmf2))+"', Total_Hour='"+(Double.toString(gdf1+gdf2))+"'  where Name='"+filenammm+"' and Shot='"+ti4+"' ";
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
          pst.setString(1,datevalue);
          pst.setString(2,modeloo);
          pst.setString(3,filenammm);
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
          pst.setString(1,datevalue);
          pst.setString(2,modeloo);
          pst.setString(3,filenammm);
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
          pst.setString(1,datevalue);
          pst.setString(2,modeloo);
          pst.setString(3,filenammm);
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
       
       
       
///////////////////////////////Calculate Cost/////////////////////////////////////////////////////////////   
       
InputStream inputinstream=new FileInputStream(filePath);
BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
String lo;
code.clear();
while ((lo=bi.readLine())!=null) {        
code.appendText("\n"+lo
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
String gf=code.getText();
OutputStream instreamm=new FileOutputStream(System.getProperty("user.home")+"\\r.ks");
PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
pwe.println(gf);
pwe.close();


///////////////////////////////////////////////////////////////////////////////////////////////////////////   
List<Double> pri = new ArrayList<>();
List<Double> qua = new ArrayList<>();
List<Double> dil = new ArrayList<>();
List<String> nom = new ArrayList<>();
String except=null;
////////////////////////////////////////////////
//Document docj = Jsoup.parse(roraa);
File inputFile = new File(System.getProperty("user.home")+"\\r.ks"); //
org.jsoup.nodes.Document docj = Jsoup.parse(inputFile, "UTF-8"); //
for (Element table : docj.select("TABLE")) {
for (Element row : table.select("TR")) {
Elements tds = row.select("TD");
if (tds.get(8).text().isEmpty()||tds.get(8).text().contains("OLD STONE")) {   
}
else {  
String string=tds.get(8).text();
BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Prices.kady"));
String line;
String linebeforeequal;
String lineafterequal;
while ((line=buf.readLine())!=null) {       
linebeforeequal=line.substring(0,line.indexOf("=$")-0);  //Item
lineafterequal=line.substring(line.indexOf("=$") + 2 , line.length());  //Price
if (string.equals(linebeforeequal)) {
double number1 = Double.parseDouble(lineafterequal);
pri.add(number1);
String itaam = linebeforeequal;
nom.add(itaam); 
break;
}
//else {
//except=except+"\n"+tds.get(8).text();
//}
}
buf.close();
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
noti.hideAfter(Duration.seconds(5));
noti.showError();
}
else {
//Show alert to write pcs.    
List<Double> result = new ArrayList<>();
for (int i = 0; i < qua.size(); i++) {
result.add((qua.get(i) / dil.get(i))* pri.get(i));
}
summo = 0.0;
for (double number : result) {
summo += number;
}
////////////////////////////////////////////////////////////////////////////////////////////
            // Parse the HTML file
            Document docv = Jsoup.parse(inputFile, "UTF-8");
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
DialogPane dialogPanej = aloo.getDialogPane();
dialogPanej.getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
aloo.showAndWait();
pcsnum=Double.parseDouble(grr.getText());
onegar=summo/pcsnum;
//Save To DB Here.
try {
String sql0 = "select * from Cost where Name like '" + filenammm + "' and Model like '" + modeloo + "' ";
pst = conn.prepareStatement(sql0);
rs = pst.executeQuery();                    
if (rs.next()) {                        
//Update
findo="found";   
}                    
else {
//Insert
findo="not_found";   
}        
}catch (Exception exception) {
} 
finally {
try {
rs.close();
pst.close();     
} catch (Exception exception) {}
}
if (findo.equals("found")) {
try {    
String sqlm = "select * from Cost where Name=? and Model=?";
pst = conn.prepareStatement(sqlm);
pst.setString(1, filenammm);
pst.setString(2, modeloo);
rs = pst.executeQuery();      
String addd1 = rs.getString("Total_Cost_Old");
oldtotalcost=addd1;
String addd2 = rs.getString("PCS_Old");
oldpcs=addd2;      
String addd3 = rs.getString("One_Garment_Old");
oldonegarmentcost=addd3;

String sqlp= "update Cost set Date='"+datevalue+"', Total_Cost_Old='"+oldtotalcost+"', PCS_Old='"+oldpcs+"', One_Garment_Old='"+oldonegarmentcost+"', Total_Cost_New='"+Double.toString(summo)+"', PCS_New='"+Double.toString(pcsnum)+"', One_Garment_New='"+Double.toString(onegar)+"' where Name='"+filenammm+"' and Model='"+modeloo+"'";
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
else if (findo.equals("not_found")) {
try {                            
String reg = "insert into Cost (Date, Model, Name, Total_Cost_Old, PCS_Old, One_Garment_Old, Total_Cost_New, PCS_New, One_Garment_New) values (?,?,?,?,?,?,?,?,?)";
pst = conn.prepareStatement(reg);
pst.setString(1,datevalue);
pst.setString(2,modeloo);
pst.setString(3,filenammm);

pst.setString(4,Double.toString(summo));
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
Alert alertio = new Alert(Alert.AlertType.CONFIRMATION);
alertio.setTitle("Result");
alertio.setHeaderText("Cost Result");
alertio.setContentText("Here is the result of chemicals costs for one garment  :   "+Double.toString(onegar)+"   $.");
ButtonType buttonTypeOne = new ButtonType("Report");
ButtonType buttonTypeCancel = new ButtonType("Cancel");
alertio.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
DialogPane dialogPaneii = alertio.getDialogPane();
dialogPaneii.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> results = alertio.showAndWait();
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
    String repname = "Chemical_Report_Of_"+filenammm;
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
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Cost Report For "+filenammm+" Recipe. ", FontFactory.getFont("Times-Bold", 12.0F, 1)));
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
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost (New) :    "+Double.toString(summo)+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
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

       
       
  ////////////////////////////////////////////////////////////////////////////////////////////////////////// 
      
  ////////////////////Send Mails Here///////////////////////////////////////////////////////////////////////
   
   
    //////////////////////////////////////////////////////////////////////////////////////////
        
    
        
      try {  
        
        
    new Thread(new Runnable() {
    @Override
    public void run() {
        
        
        
//    ObservableList<String> ite=list.getItems();
//    
//    for  (String it : ite) {
//        
//        
       
    
          String from,password,to,sub,suby;
          from="ahmedelkadyteeest@gmail.com";
          password="lgrj esca tdtz froo";
          //to=it;
          sub="Recipe Editor (RECETA).";
          suby="Recipe Editor (RECETA) Powered By Kadysoft Ltd - All Rights Reserved. Ahmed Elkady - CEO.";
          
           if (bosbos==1) {
               
               if (lonk1.getText().contains("Ahmed Elkady")||lonk1.getText().contains("KADINIO")) {
                   
                msg="Date: "+datevalue+"\nCustomer - Recipe_Name: "+modeloo+" - "+filenammm+"\nEditor_Name: "+lonk1.getText()+"   ***- Free Editor At Anytime, Ask For Help On Whatsapp At: +201555266002. -***"+"\nShots: 1\nOld_Time: "+oldtimehour+"   Hours."+"\nNew_Time: "+gdf1+"   Hours."+
                        
                        "\n-------------------------------------------------"
                        + "\nHere is All Info About Cost:"
                        + "\n---------------NEW----------------"
                        + "\n"
                        + "\nTotal Of Cost (New) :    "+Double.toString(summo)+"          $."
                        + "\nTotal Of Garments (New) :    "+Double.toString(pcsnum)+"          PCS."
                        + "\nOne Garment Costs (New) :    "+Double.toString(onegar)+"          $."
                        + "\n---------------OLD----------------"
                        + "\n"
                        + "\nTotal Of Cost (Old) :    "+oldtotalcost+"          $."
                        + "\nTotal Of Garments (Old) :    "+oldpcs+"          PCS."
                        + "\nOne Garment Costs (Old) :    "+oldonegarmentcost+"          $."
                        + "\n-------------------------------------------------"+
                        
                        "\n\n\n"+suby+"\n\n\n"
                        + "                  ██╗░░██╗░█████╗░██████╗░██╗░░░██╗░██████╗░█████╗░███████╗████████╗\n" +
                                            "██║░██╔╝██╔══██╗██╔══██╗╚██╗░██╔╝██╔════╝██╔══██╗██╔════╝╚══██╔══╝\n" +
                                            "█████═╝░███████║██║░░██║░╚████╔╝░╚█████╗░██║░░██║█████╗░░░░░██║░░░\n" +
                                            "██╔═██╗░██╔══██║██║░░██║░░╚██╔╝░░░╚═══██╗██║░░██║██╔══╝░░░░░██║░░░\n" +
                                            "██║░╚██╗██║░░██║██████╔╝░░░██║░░░██████╔╝╚█████╔╝██║░░░░░░░░██║░░░\n" +
                                            "╚═╝░░╚═╝╚═╝░░╚═╝╚═════╝░░░░╚═╝░░░╚═════╝░░╚════╝░╚═╝░░░░░░░░╚═╝░░░";
               }
               
               else {
                msg="Date: "+datevalue+"\nCustomer - Recipe_Name: "+modeloo+" - "+filenammm+"\nEditor_Name: "+lonk1.getText()+"\nShots: 1\nOld_Time: "+oldtimehour+"   Hours."+"\nNew_Time: "+gdf1+"   Hours."+
                        
                       "\n-------------------------------------------------"
                        + "\nHere is All Info About Cost:"
                        + "\n---------------NEW----------------"
                        + "\n"
                        + "\nTotal Of Cost (New) :    "+Double.toString(summo)+"          $."
                        + "\nTotal Of Garments (New) :    "+Double.toString(pcsnum)+"          PCS."
                        + "\nOne Garment Costs (New) :    "+Double.toString(onegar)+"          $."
                        + "\n---------------OLD----------------"
                        + "\n"
                        + "\nTotal Of Cost (Old) :    "+oldtotalcost+"          $."
                        + "\nTotal Of Garments (Old) :    "+oldpcs+"          PCS."
                        + "\nOne Garment Costs (Old) :    "+oldonegarmentcost+"          $."
                        + "\n-------------------------------------------------"+
                        
                        "\n\n\n"+suby+"\n\n\n"
                        + "                  ██╗░░██╗░█████╗░██████╗░██╗░░░██╗░██████╗░█████╗░███████╗████████╗\n" +
                                            "██║░██╔╝██╔══██╗██╔══██╗╚██╗░██╔╝██╔════╝██╔══██╗██╔════╝╚══██╔══╝\n" +
                                            "█████═╝░███████║██║░░██║░╚████╔╝░╚█████╗░██║░░██║█████╗░░░░░██║░░░\n" +
                                            "██╔═██╗░██╔══██║██║░░██║░░╚██╔╝░░░╚═══██╗██║░░██║██╔══╝░░░░░██║░░░\n" +
                                            "██║░╚██╗██║░░██║██████╔╝░░░██║░░░██████╔╝╚█████╔╝██║░░░░░░░░██║░░░\n" +
                                            "╚═╝░░╚═╝╚═╝░░╚═╝╚═════╝░░░░╚═╝░░░╚═════╝░░╚════╝░╚═╝░░░░░░░░╚═╝░░░";
               }
               
              
           }
           
           if (bosbos==2) {
               
               
                if (lonk1.getText().contains("Ahmed Elkady")||lonk1.getText().contains("KADINIO")) {
                   
                msg="Date: "+datevalue+"\nCustomer - Recipe_Name: "+modeloo+" - "+filenammm+"\nEditor_Name: "+lonk1.getText()+"   ***- Free Editor At Anytime, Ask For Help On Whatsapp At: +201555266002. -***"+"\nShots: 2\nOld_Time_First_Shot: "+oldtimehour+"   Hours."+"\nOld_Time_Second_Shot: "+oldtimehour2+"   Hours."+"\nNew_Time_First_Shot: "+gdf1+"   Hours."+"\nNew_Time_Second_Shot: "+gdf2+"   Hours."+
                        
                        
                        "\n-------------------------------------------------"
                        + "\nHere is All Info About Cost:"
                        + "\n---------------NEW----------------"
                        + "\n"
                        + "\nTotal Of Cost (New) :    "+Double.toString(summo)+"          $."
                        + "\nTotal Of Garments (New) :    "+Double.toString(pcsnum)+"          PCS."
                        + "\nOne Garment Costs (New) :    "+Double.toString(onegar)+"          $."
                        + "\n---------------OLD----------------"
                        + "\n"
                        + "\nTotal Of Cost (Old) :    "+oldtotalcost+"          $."
                        + "\nTotal Of Garments (Old) :    "+oldpcs+"          PCS."
                        + "\nOne Garment Costs (Old) :    "+oldonegarmentcost+"          $."
                        + "\n-------------------------------------------------"+
                        
                        
                        "\n\n\n"+suby+"\n\n\n██╗░░██╗░█████╗░██████╗░██╗░░░██╗░██████╗░█████╗░███████╗████████╗\n" +
"██║░██╔╝██╔══██╗██╔══██╗╚██╗░██╔╝██╔════╝██╔══██╗██╔════╝╚══██╔══╝\n" +
"█████═╝░███████║██║░░██║░╚████╔╝░╚█████╗░██║░░██║█████╗░░░░░██║░░░\n" +
"██╔═██╗░██╔══██║██║░░██║░░╚██╔╝░░░╚═══██╗██║░░██║██╔══╝░░░░░██║░░░\n" +
"██║░╚██╗██║░░██║██████╔╝░░░██║░░░██████╔╝╚█████╔╝██║░░░░░░░░██║░░░\n" +
"╚═╝░░╚═╝╚═╝░░╚═╝╚═════╝░░░░╚═╝░░░╚═════╝░░╚════╝░╚═╝░░░░░░░░╚═╝░░░";
           
               }
               
               else {
                msg="Date: "+datevalue+"\nCustomer - Recipe_Name: "+modeloo+" - "+filenammm+"\nEditor_Name: "+lonk1.getText()+"\nShots: 2\nOld_Time_First_Shot: "+oldtimehour+"   Hours."+"\nOld_Time_Second_Shot: "+oldtimehour2+"   Hours."+"\nNew_Time_First_Shot: "+gdf1+"   Hours."+"\nNew_Time_Second_Shot: "+gdf2+"   Hours."+
                        
                        
                        "\n-------------------------------------------------"
                        + "\nHere is All Info About Cost:"
                        + "\n---------------NEW----------------"
                        + "\n"
                        + "\nTotal Of Cost (New) :    "+Double.toString(summo)+"          $."
                        + "\nTotal Of Garments (New) :    "+Double.toString(pcsnum)+"          PCS."
                        + "\nOne Garment Costs (New) :    "+Double.toString(onegar)+"          $."
                        + "\n---------------OLD----------------"
                        + "\n"
                        + "\nTotal Of Cost (Old) :    "+oldtotalcost+"          $."
                        + "\nTotal Of Garments (Old) :    "+oldpcs+"          PCS."
                        + "\nOne Garment Costs (Old) :    "+oldonegarmentcost+"          $."
                        + "\n-------------------------------------------------"+
                        
                        
                        "\n\n\n"+suby+"\n\n\n██╗░░██╗░█████╗░██████╗░██╗░░░██╗░██████╗░█████╗░███████╗████████╗\n" +
"██║░██╔╝██╔══██╗██╔══██╗╚██╗░██╔╝██╔════╝██╔══██╗██╔════╝╚══██╔══╝\n" +
"█████═╝░███████║██║░░██║░╚████╔╝░╚█████╗░██║░░██║█████╗░░░░░██║░░░\n" +
"██╔═██╗░██╔══██║██║░░██║░░╚██╔╝░░░╚═══██╗██║░░██║██╔══╝░░░░░██║░░░\n" +
"██║░╚██╗██║░░██║██████╔╝░░░██║░░░██████╔╝╚█████╔╝██║░░░░░░░░██║░░░\n" +
"╚═╝░░╚═╝╚═╝░░╚═╝╚═════╝░░░░╚═╝░░░╚═════╝░░╚════╝░╚═╝░░░░░░░░╚═╝░░░";
           
               }
               
              }
          
          
        
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
          "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          Session session = Session.getDefaultInstance(props,    
          new javax.mail.Authenticator() {    
          protected PasswordAuthentication getPasswordAuthentication() {    
          return new PasswordAuthentication(from,password);  
          }    
          });       
          try {    
          MimeMessage message = new MimeMessage(session);
          
          
          //For mailing by the old method just uncomment codes and comment current method then go straight. 
          
          String[] mailToId={"kemal.duman@tcgarments.com","muhammet.eraslan@tcgarments.com","eyup.karakoyun@tcgarments.com","ahmed.nassif@tcgarments.com","hany.emeira@tcgarments.com"/*,"chemical.store@tcgarments.com"*/,"rainforest.tc@tcgarments.com","ahmed.elkady@tcgarments.com"};
          for(int i=0;i<mailToId.length;i++){
           message.addRecipients(Message.RecipientType.TO, mailToId[i]);
          }
          
          //message.addRecipient(Message.RecipientType.TO,new InternetAddress(it));    
          message.setSubject(sub);    
          //message.setText(msg, "text/plain; charset=UTF-8");
          message.setContent(msg, "text/plain; charset=UTF-8");
          Transport.send(message);  
          System.out.println("Successful");
          } catch (MessagingException e) {throw new RuntimeException(e);} 
        
        
//        
//    }
//    
//        try {
//            Thread.sleep(300);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(SaverController.class.getName()).log(Level.SEVERE, null, ex);
//        }
      
      
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         try {
         String sqla = "INSERT INTO Notifications (Recipient, Sender, Message, Delivered) VALUES (?, ?, ?, 0)";
          pst = conn.prepareStatement(sqla);
          pst.setString(1, "Recipe_Maker");
          pst.setString(2, "Ahmed Elkady");
          pst.setString(3, "We have updated "+filenammm+" successfully in "+datevalue+" of "+modeloo+" model.");
          pst.executeUpdate();
          }
          catch (Exception e) {
          } finally {
          try {
          rs.close();
          pst.close();
          } catch (Exception exception) {}}  
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
          }
}).start();
    
      
      }
      
      catch (Exception m) {
        
      }
    
    
    
        //////////////////////////////////////////////////////////////////////////////////////////
   
        
  ///////////////////////////////////////////////////////////////////////////////////////////////////////////
      }
      else if (option.get() == ButtonType.CANCEL) {
          
          ////////////////////////////////////////////////////////////////////////////////////////////////////
          
             
   ///////////////////////////////////////Everything Will Go Here///////////////////////////////////////////////////
   
   String thecodee=code.getText();
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   if (signme.isSelected()==true) {
       
       
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   if (fixche.isSelected()==true) {
       
       String codee = code.getText();
      if (!codee.contains("TABLE")) {
      Notifications noti = Notifications.create();
      noti.title("Recipe Error");
      noti.text("Maybe not a recipe, Open a recipe first!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showError();    
        }
        else {
            Document docj = Jsoup.parse(codee);
        for (Element table : docj.select("TABLE")) {
        for (Element row : table.select("TR")) {
            Elements tds = row.select("TD");
            if (tds.get(7).text().isEmpty()) {   
            }
            else {  
             ///////////////////////////////////////////////////////////////
String string=tds.get(7).text();
BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Chemical_Dictionary.kady"));
String line;
String linebeforeequal;
String lineafterequal;
while ((line=buf.readLine())!=null) {
linebeforeequal=line.substring(0,line.indexOf("=")-0);
lineafterequal=line.substring(line.indexOf("=") + 1 , line.length());
if (string.equals(lineafterequal)) {
//System.out.println(string+" = "+linebeforeequal);
String formattedText = "<b style='display:block; text-align:center;'>" + linebeforeequal + "</b>";
tds.get(8).html(formattedText); // Use .html() instead of .text()     
//tds.get(8).text(linebeforeequal);
//System.out.println(tds.get(8).text());
break;

    }
    else {
        
    }
    
}
buf.close();
    
            }   
         
        }}
       roraa=docj.toString();
        }
       
      
      ////////////////////////////////////////////////////////////////////////////// 
org.jsoup.nodes.Document doct = Jsoup.parse(roraa);
for (Element table : doct.select("TABLE")) {
for (Element row : table.select("TR")) {
Elements tds = row.select("TD");
if (tds.get(8).text().isEmpty()) {   
}
else {  
String string=tds.get(8).text();
BufferedReader bufi=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Lot_Numbers.kady"));
String line;
String linebeforeequal;//Chemical Name
String lineafterequal;//Lot Numbers
boolean found = false;         
while ((line=bufi.readLine())!=null) {
linebeforeequal=line.substring(0,line.indexOf("="));//Chemical Name
lineafterequal=line.substring(line.indexOf("=") + 1);//Lot Numbers
if (string.equalsIgnoreCase(linebeforeequal)) {
System.out.println(linebeforeequal);
String formattedText = "<b style='display:block; text-align:center;'>" + lineafterequal + "</b>";
tds.get(9).html(formattedText); // Use .html() instead of .text()     
//tds.get(9).text(lineafterequal);
found = true;                    
break;
    }   
}
bufi.close();}}}
roraa=doct.toString();      
//////////////////////////////////////////////////////////////////////////////
      
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         
org.jsoup.nodes.Document doctp = Jsoup.parse(roraa);

// مر على كل جدول
for (Element table : doctp.select("table")) {
    for (Element row : table.select("tr")) {
        Elements tds = row.select("td");

        // اتأكد إن فيه على الأقل 11 عمود (0 → 10)
        if (tds.size() > 10) {
            String target = tds.get(8).text().trim();

            if (!target.isEmpty()) {
                Path mapPath = Paths.get(NewDir.file_dirrrr, "Recipe_Indexes", "Chemical_Translation.kady");

                try (BufferedReader bufi = Files.newBufferedReader(mapPath, StandardCharsets.UTF_8)) {
                    String line;
                    boolean found = false;

                    while ((line = bufi.readLine()) != null) {
                        // اتأكد إن السطر فيه =
                        if (!line.contains("=")) continue;

                        String linebeforeequal = line.substring(0, line.indexOf("=")).trim();
                        String lineafterequal = line.substring(line.indexOf("=") + 1).trim();

                        if (target.equalsIgnoreCase(linebeforeequal)) {
                            System.out.println("Matched: " + linebeforeequal);

                            String formattedText =
                                    "<b style='display:block; text-align:center;'>" +
                                            lineafterequal +
                                            "</b>";

                            // استبدل العمود رقم 10 بالنص الجديد
                            tds.get(10).html(formattedText);

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("No match for: " + target);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

roraa = doctp.toString();

       
       
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


       
   }
   
   else {
       
       //Continue..........
       roraa=code.getText();
   }
    
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
            //String codee=code.getText();
            String pathtosignature="file://"+NewDir.file_dirrrrr+"\\Mr_Muhammet.png";
            String modely=modell.getSelectionModel().getSelectedItem().toString();
            FileChooser dialog = new FileChooser();
            dialog.setInitialDirectory(new File(NewDir.file_dir));
            dialog.setInitialFileName("Ahmed_Elkady_Kadysoft_Ltd");
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
            File dialogResult = dialog.showSaveDialog(null);
            filePath = dialogResult.getAbsolutePath().toString();
            OutputStream instream=new FileOutputStream(filePath);
            pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
            pw.println("<!DOCTYPE html>\n<html lang=\"ar\">\n<head>\n<title>Kadysoft</title>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<style>td {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}\ntable {\nheight:5px;\nmax-width:100%;\nheight:100%;\nwhite-space:nowrap;\n}\ntr {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}"
                    + ""
                    + ""
                    
                        + ""
                + "/* Centered Watermark */\n" +
"    .watermark {\n" +
"      position: fixed;\n" +
"      top: 50%;\n" +
"      left: 50%;\n" +
"      transform: translate(-50%, -50%) rotate(-45deg);\n" +
"      background-image: url('logo.png'); /* Replace with the path to T & C Garments logo */\n" +
"      background-repeat: no-repeat;\n" +
"      background-size: contain;\n" +
"      width: 300px;\n" +
"      height: 200px;\n" +
"      opacity: 0.3;\n" +
"      pointer-events: none;\n" +
"      z-index: 1000;\n" +
"    }\n" +
"    /* Repeated Watermark */\n" +
"    .watermark-repeated {\n" +
"      position: fixed;\n" +
"      top: 0;\n" +
"      left: 0;\n" +
"      width: 100%;\n" +
"      height: 100%;\n" +
"      background-image: url('logo.png'); /* Replace with the path to T & C Garments logo */\n" +
"      background-repeat: repeat;\n" +
"      background-size: 300px 200px;\n" +
"      opacity: 0.2;\n" +
"      pointer-events: none;\n" +
"      z-index: 1000;\n" +
"    }"
                + ""
                + "</STYLE></HEAD>\n" +
"<BODY><CENTER>\n"
+ "<div class=\"watermark\"></div>" 
                
                    
                    + ""
                    + "\n\n");
            pw.println("<!-- Creating Recipe From Kadysoft Ltd.-->\n\n");
            pw.println(roraa);
            pw.println("\n\n</center>\n</body>\n</html>");
            pw.println("<b id=\"signname\">Mr_Muhammet Signature: "+"</b><img id=\"signimage\" src=\""+pathtosignature+"\" width=\"300\" height=\"90\" alt=\"Developed By Kadysoft Ltd (Ahmed Elkady).\" style=\"border-color:black;border-width:10px;\">");   
      
            if (roraa.contains("background-image:")) {
                
            }
            else {
                pw.println("\n\n<style>\n" +
"body {\n" +
"  background-image: url(\""+modely+".bmp\");\n" +
"  background-position: center;\n" +
"  height: 170px;\n" +
"background-position-x:550px;"+
"  background-repeat: no-repeat;\n" +
"  background-size: 120px 90px;\n" +
"}\n" +
"</style>");             
          }
            pw.close();
            
            
    /////////////////////////////////////////////////// 
    code.clear();
    InputStream inputinstream=new FileInputStream(filePath);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    //BufferedReader bi=new BufferedReader (new FileReader (pathy));
    String lo;
    while ((lo=bi.readLine())!=null) {
        
        code.appendText("\n"+lo
       .replace("A","ﬦ")
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
       .replace("z","ףּ")                
      ); 


    }
    bi.close();
    String gf=code.getText();
    OutputStream instreamm=new FileOutputStream(filePath);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    //PrintWriter pw=new PrintWriter (new FileWriter (pathy));
    pw.println(gf);
    pw.close();
    Notifications noti = Notifications.create();
    noti.title("Successful");
    noti.text("We have encrypted the recipe successfully.");
    noti.hideAfter(Duration.seconds(3));
    noti.position(Pos.CENTER);
    noti.showInformation();
    code.clear();

       //////////////////////////////////////////////////
            
            
            //Desktop desk = Desktop.getDesktop();
            //desk.open(new File (filePath));
            Stage jk = (Stage)this.save.getScene().getWindow();
            jk.close();
   
       /////////////////////////////////////////////////// 
   
       //////////////////////////////////////////////////
       
   }
   
   
   else {
       
       
       
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   if (fixche.isSelected()==true) {
       
       String codee = code.getText();
      if (!codee.contains("TABLE")) {
      Notifications noti = Notifications.create();
      noti.title("Recipe Error");
      noti.text("Maybe not a recipe, Open a recipe first!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showError();    
        }
        else {
            Document docj = Jsoup.parse(codee);
        for (Element table : docj.select("TABLE")) {
        for (Element row : table.select("TR")) {
            Elements tds = row.select("TD");
            if (tds.get(7).text().isEmpty()) {   
            }
            else {  
             ///////////////////////////////////////////////////////////////
String string=tds.get(7).text();
BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Chemical_Dictionary.kady"));
String line;
String linebeforeequal;
String lineafterequal;
while ((line=buf.readLine())!=null) {
linebeforeequal=line.substring(0,line.indexOf("=")-0);
lineafterequal=line.substring(line.indexOf("=") + 1 , line.length());
if (string.equals(lineafterequal)) {
//System.out.println(string+" = "+linebeforeequal);
String formattedText = "<b style='display:block; text-align:center;'>" + linebeforeequal + "</b>";
tds.get(8).html(formattedText); // Use .html() instead of .text()     
//tds.get(8).text(linebeforeequal);
//System.out.println(tds.get(8).text());
break;

    }
    else {
        
    }
    
}
buf.close();
    
            }   
         
        }}
       roraa=docj.toString();
        }
      
      
      ////////////////////////////////////////////////////////////////////////////// 
org.jsoup.nodes.Document doct = Jsoup.parse(roraa);
for (Element table : doct.select("TABLE")) {
for (Element row : table.select("TR")) {
Elements tds = row.select("TD");
if (tds.get(8).text().isEmpty()) {   
}
else {  
String string=tds.get(8).text();
BufferedReader bufi=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Lot_Numbers.kady"));
String line;
String linebeforeequal;//Chemical Name
String lineafterequal;//Lot Numbers
boolean found = false;         
while ((line=bufi.readLine())!=null) {
linebeforeequal=line.substring(0,line.indexOf("="));//Chemical Name
lineafterequal=line.substring(line.indexOf("=") + 1);//Lot Numbers
if (string.equalsIgnoreCase(linebeforeequal)) {
System.out.println(linebeforeequal);
String formattedText = "<b style='display:block; text-align:center;'>" + lineafterequal + "</b>";
tds.get(9).html(formattedText); // Use .html() instead of .text()     
//tds.get(9).text(lineafterequal);
found = true;                    
break;
    }   
}
bufi.close();}}}
roraa=doct.toString();      
//////////////////////////////////////////////////////////////////////////////
      
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         
org.jsoup.nodes.Document doctp = Jsoup.parse(roraa);

// مر على كل جدول
for (Element table : doctp.select("table")) {
    for (Element row : table.select("tr")) {
        Elements tds = row.select("td");

        // اتأكد إن فيه على الأقل 11 عمود (0 → 10)
        if (tds.size() > 10) {
            String target = tds.get(8).text().trim();

            if (!target.isEmpty()) {
                Path mapPath = Paths.get(NewDir.file_dirrrr, "Recipe_Indexes", "Chemical_Translation.kady");

                try (BufferedReader bufi = Files.newBufferedReader(mapPath, StandardCharsets.UTF_8)) {
                    String line;
                    boolean found = false;

                    while ((line = bufi.readLine()) != null) {
                        // اتأكد إن السطر فيه =
                        if (!line.contains("=")) continue;

                        String linebeforeequal = line.substring(0, line.indexOf("=")).trim();
                        String lineafterequal = line.substring(line.indexOf("=") + 1).trim();

                        if (target.equalsIgnoreCase(linebeforeequal)) {
                            System.out.println("Matched: " + linebeforeequal);

                            String formattedText =
                                    "<b style='display:block; text-align:center;'>" +
                                            lineafterequal +
                                            "</b>";

                            // استبدل العمود رقم 10 بالنص الجديد
                            tds.get(10).html(formattedText);

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("No match for: " + target);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

roraa = doctp.toString();

       
       
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


       
   }
   
   else {
       
       //Continue..........
       roraa=code.getText();
   }
    
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
      
       
       
       
            //String codee=code.getText();
            String pathtosignature="file://"+NewDir.file_dirrrrr+"\\Mr_Moharam.png";
            String modely=modell.getSelectionModel().getSelectedItem().toString();
            FileChooser dialog = new FileChooser();
            dialog.setInitialDirectory(new File(NewDir.file_dir));
            dialog.setInitialFileName("Ahmed_Elkady_Kadysoft_Ltd");
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
            File dialogResult = dialog.showSaveDialog(null);
            filePath = dialogResult.getAbsolutePath().toString();
            OutputStream instream=new FileOutputStream(filePath);
            pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
            pw.println("<!DOCTYPE html>\n<html lang=\"ar\">\n<head>\n<title>Kadysoft</title>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<style>td {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}\ntable {\nheight:5px;\nmax-width:100%;\nheight:100%;\nwhite-space:nowrap;\n}\ntr {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}"
                    + ""
                    + ""
                    
                        + ""
                + "/* Centered Watermark */\n" +
"    .watermark {\n" +
"      position: fixed;\n" +
"      top: 50%;\n" +
"      left: 50%;\n" +
"      transform: translate(-50%, -50%) rotate(-45deg);\n" +
"      background-image: url('logo.png'); /* Replace with the path to T & C Garments logo */\n" +
"      background-repeat: no-repeat;\n" +
"      background-size: contain;\n" +
"      width: 300px;\n" +
"      height: 200px;\n" +
"      opacity: 0.3;\n" +
"      pointer-events: none;\n" +
"      z-index: 1000;\n" +
"    }\n" +
"    /* Repeated Watermark */\n" +
"    .watermark-repeated {\n" +
"      position: fixed;\n" +
"      top: 0;\n" +
"      left: 0;\n" +
"      width: 100%;\n" +
"      height: 100%;\n" +
"      background-image: url('logo.png'); /* Replace with the path to T & C Garments logo */\n" +
"      background-repeat: repeat;\n" +
"      background-size: 300px 200px;\n" +
"      opacity: 0.2;\n" +
"      pointer-events: none;\n" +
"      z-index: 1000;\n" +
"    }"
                + ""
                + "</STYLE></HEAD>\n" +
"<BODY><CENTER>\n"
+ "<div class=\"watermark\"></div>" 
                
                    
                    
                    + ""
                    + ""
                    + "\n\n");
            pw.println("<!-- Creating Recipe From Kadysoft Ltd.-->\n\n");
            pw.println(roraa);
            pw.println("\n\n</center>\n</body>\n</html>");
            //pw.println("<b>Mr_Moharam Signature: "+"</b><img src=\""+pathtosignature+"\" width=\"300\" height=\"90\" alt=\"Developed By Kadysoft Ltd (Ahmed Elkady).\" style=\"border-color:black;border-width:10px;\">");   
      
            if (roraa.contains("background-image:")) {
                
            }
            else {
                pw.println("\n\n<style>\n" +
"body {\n" +
"  background-image: url(\""+modely+".bmp\");\n" +
"  background-position: center;\n" +
"  height: 170px;\n" +
"background-position-x:550px;"+
"  background-repeat: no-repeat;\n" +
"  background-size: 120px 90px;\n" +
"}\n" +
"</style>");             
          }
            pw.close();
            
            
               /////////////////////////////////////////////////// 
   code.clear();
    InputStream inputinstream=new FileInputStream(filePath);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    //BufferedReader bi=new BufferedReader (new FileReader (pathy));
    String lo;
    while ((lo=bi.readLine())!=null) {
        
        code.appendText("\n"+lo
       .replace("A","ﬦ")
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
       .replace("z","ףּ")                
      ); 


    }
    bi.close();
    String gf=code.getText();
    OutputStream instreamm=new FileOutputStream(filePath);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    //PrintWriter pw=new PrintWriter (new FileWriter (pathy));
    pw.println(gf);
    pw.close();
    Notifications noti = Notifications.create();
    noti.title("Successful");
    noti.text("We have encrypted the recipe successfully.");
    noti.hideAfter(Duration.seconds(3));
    noti.position(Pos.CENTER);
    noti.showInformation();
    //code.clear();


            
            //Desktop desk = Desktop.getDesktop();
            //desk.open(new File (filePath));
            Stage jk = (Stage)this.save.getScene().getWindow();
            jk.close();
   
       /////////////////////////////////////////////////// 
   
       ///////////////////////////////////////////////////
   }
   
   
   
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////
   
       
  ////////////////////Send Mails Here///////////////////////////////////////////////////////////////////////
   
   
    //////////////////////////////////////////////////////////////////////////////////////////
        
      Date currentDate1 = GregorianCalendar.getInstance().getTime();
      DateFormat df1 = DateFormat.getDateInstance();
      String dateString1 = df1.format(currentDate1);
      Date d1 = new Date();
      SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
      String timeString1 = sdf1.format(d1);
      SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
      String timeString2 = sdf2.format(d1);
      datevalue = timeString2;                                                          //Date
      
      modeloo=modell.getSelectionModel().getSelectedItem().toString();                 //Model
      
      filenammm=filePath.replace(NewDir.file_dir,"").replace("\\PRODUCTION","").replace("\\"+modeloo+"\\","").replace(".ks","").replace(".html","");
      
        
      try {  
        
        
    new Thread(new Runnable() {
    @Override
    public void run() {
        
        
        
//    ObservableList<String> ite=list.getItems();
//    
//    for  (String it : ite) {
//        
//        
        
    
          String from,password,to,sub,suby;
          from="ahmedelkadyteeest@gmail.com";
          password="lgrj esca tdtz froo";
          //to=it;
          sub="Recipe Editor (RECETA).";
          suby="Recipe Editor (RECETA) Powered By Kadysoft Ltd - All Rights Reserved. Ahmed Elkady - CEO.";
          
          if (filenammm.contains("PILOT")) {
              
                msg="Date: "+datevalue+"\nCustomer - Recipe_Name: "+modeloo+" - "+filenammm.replace("PILOT","PILOT---")+"\nEditor_Name: "+lonk1.getText()+"\nThis Recipe Is Maybe A Pilot Recipe (Pilots Can Be Edited By '"+lonk1.getText()+"' Only).\n\n\n"+suby+"\n\n\n██╗░░██╗░█████╗░██████╗░██╗░░░██╗░██████╗░█████╗░███████╗████████╗\n" +
"██║░██╔╝██╔══██╗██╔══██╗╚██╗░██╔╝██╔════╝██╔══██╗██╔════╝╚══██╔══╝\n" +
"█████═╝░███████║██║░░██║░╚████╔╝░╚█████╗░██║░░██║█████╗░░░░░██║░░░\n" +
"██╔═██╗░██╔══██║██║░░██║░░╚██╔╝░░░╚═══██╗██║░░██║██╔══╝░░░░░██║░░░\n" +
"██║░╚██╗██║░░██║██████╔╝░░░██║░░░██████╔╝╚█████╔╝██║░░░░░░░░██║░░░\n" +
"╚═╝░░╚═╝╚═╝░░╚═╝╚═════╝░░░░╚═╝░░░╚═════╝░░╚════╝░╚═╝░░░░░░░░╚═╝░░░";
         
              
          }
          
          else if (filenammm.contains("BLANKET")) {
              
                msg="Date: "+datevalue+"\nCustomer - Recipe_Name: "+modeloo+" - "+filenammm.replace("BLANKET","BLANKET---")+"\nEditor_Name: "+lonk1.getText()+"\nThis Recipe Is Maybe A Blanket Recipe (Blankets Can Be Edited By '"+lonk1.getText()+"' Only).\n\n\n"+suby+"\n\n\n██╗░░██╗░█████╗░██████╗░██╗░░░██╗░██████╗░█████╗░███████╗████████╗\n" +
"██║░██╔╝██╔══██╗██╔══██╗╚██╗░██╔╝██╔════╝██╔══██╗██╔════╝╚══██╔══╝\n" +
"█████═╝░███████║██║░░██║░╚████╔╝░╚█████╗░██║░░██║█████╗░░░░░██║░░░\n" +
"██╔═██╗░██╔══██║██║░░██║░░╚██╔╝░░░╚═══██╗██║░░██║██╔══╝░░░░░██║░░░\n" +
"██║░╚██╗██║░░██║██████╔╝░░░██║░░░██████╔╝╚█████╔╝██║░░░░░░░░██║░░░\n" +
"╚═╝░░╚═╝╚═╝░░╚═╝╚═════╝░░░░╚═╝░░░╚═════╝░░╚════╝░╚═╝░░░░░░░░╚═╝░░░";
         
              
          }
          
          else {
              
                msg="Date: "+datevalue+"\nCustomer - Recipe_Name: "+modeloo+" - "+filenammm+"\nEditor_Name: "+lonk1.getText()+"\nShots: This Recipe Maybe Contains 3 or 4 or 5 or 6 Shots ('RANDOM BATH') Or More Than 2 Shots. Ask ('KADINIO') to calculate it for you.\nHe created a new method to calculate from 1 to 6 shots.\nFor more information ask KADINIO or see time reports.\n\nOr tell 'KADINIO' if you have a problem with it.\nWe are working on new features to make it easy to control, if you like it support me.\n\n\n"+suby+"\n\n\n██╗░░██╗░█████╗░██████╗░██╗░░░██╗░██████╗░█████╗░███████╗████████╗\n" +
"██║░██╔╝██╔══██╗██╔══██╗╚██╗░██╔╝██╔════╝██╔══██╗██╔════╝╚══██╔══╝\n" +
"█████═╝░███████║██║░░██║░╚████╔╝░╚█████╗░██║░░██║█████╗░░░░░██║░░░\n" +
"██╔═██╗░██╔══██║██║░░██║░░╚██╔╝░░░╚═══██╗██║░░██║██╔══╝░░░░░██║░░░\n" +
"██║░╚██╗██║░░██║██████╔╝░░░██║░░░██████╔╝╚█████╔╝██║░░░░░░░░██║░░░\n" +
"╚═╝░░╚═╝╚═╝░░╚═╝╚═════╝░░░░╚═╝░░░╚═════╝░░╚════╝░╚═╝░░░░░░░░╚═╝░░░";
         
              
          }
          
          
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
          "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          Session session = Session.getDefaultInstance(props,    
          new javax.mail.Authenticator() {    
          protected PasswordAuthentication getPasswordAuthentication() {    
          return new PasswordAuthentication(from,password);  
          }    
          });       
          try {    
          MimeMessage message = new MimeMessage(session);  
          
          
          //For mailing by the old method just uncomment codes and comment current method then go straight. 
          
          String[] mailToId={"kemal.duman@tcgarments.com","muhammet.eraslan@tcgarments.com","eyup.karakoyun@tcgarments.com","ahmed.nassif@tcgarments.com","hany.emeira@tcgarments.com"/*,"chemical.store@tcgarments.com"*/,"rainforest.tc@tcgarments.com","ahmed.elkady@tcgarments.com"};
          for(int i=0;i<mailToId.length;i++){
           message.addRecipients(Message.RecipientType.TO, mailToId[i]);
          }
          
          //message.addRecipient(Message.RecipientType.TO,new InternetAddress(it));    
          message.setSubject(sub);
          //message.setText(msg,"html", "utf-8"); 
          message.setContent(msg, "text/plain; charset=UTF-8");
          Transport.send(message);  
          System.out.println("Successful");
          } catch (MessagingException e) {throw new RuntimeException(e);} 
        
        
        
//    }
//    
//        try {
//            Thread.sleep(300);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(SaverController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         try {
         String sqla = "INSERT INTO notifications (Recipient, Sender, Message, Delivered) VALUES (?, ?, ?, 0)";
          pst = conn.prepareStatement(sqla);
          pst.setString(1, "Recipe_Maker");
          pst.setString(2, "Ahmed Elkady");
          pst.setString(3, "We have updated "+filenammm+" successfully in "+datevalue+" of "+modeloo+" model.");
          pst.executeUpdate();
          }
          catch (Exception e) {
          } finally {
          try {
          rs.close();
          pst.close();
          } catch (Exception exception) {}}  
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        
          }
}).start();
    
      
      }
      
      catch (Exception m) {
        
      }
    
    
    
        //////////////////////////////////////////////////////////////////////////////////////////
   
  
  //////////////////////////////////////////////////
            
            
   
          
          ////////////////////////////////////////////////////////////////////////////////////////////////////
          
          
          
          
      
      }
      
      
      
      else {}
      
      
      ///////////////////////////////////////////////////////////////////////////try here
        
      
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
                            org.jsoup.nodes.Document docy = Jsoup.parse(code.getText());
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
                            
     // Save To DB Here
    Date currentDate1l = GregorianCalendar.getInstance().getTime();
    DateFormat df1l = DateFormat.getDateInstance();
    String dateString1l = df1l.format(currentDate1l);
    Date d1l = new Date();
    SimpleDateFormat sdf1l = new SimpleDateFormat("HH:mm:ss");
    String timeString1l = sdf1l.format(d1l);
    SimpleDateFormat sdf2l = new SimpleDateFormat("yyyy-MM-dd");
    String dateString2l = sdf2l.format(d1l);

    String fann = "";
    
    try {
        String sql0 = "select * from Recipe_Types where WashName = ? and Model = ?";
        pst = conn.prepareStatement(sql0);
        pst.setString(1, filenammm);
        pst.setString(2, modeloo);
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
            pst.setString(1, dateString2l);
            pst.setString(2, modeloo);
            pst.setString(3, filenammm);
            pst.setString(4, "RINSE");
            pst.setString(5, stonn);
            pst.setString(6, fomm);
            pst.setString(7, hypoo);
            pst.setString(8, enzymm);
            pst.setString(9, moonn);
            pst.setString(10, dryr11);
            pst.setString(11, dryr22);
            pst.setString(12, dryr33);
            pst.setString(13, filenammm); // WHERE clause parameters
            pst.setString(14, modeloo);
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
            pst.setString(1, dateString2l);
            pst.setString(2, modeloo);
            pst.setString(3, filenammm);
            
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
    
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
      
       String stages=null;
       int bathnumzzz=0;
       String modu,comment;
    
        int ds=1;
                            org.jsoup.nodes.Document docyi = Jsoup.parse(code.getText());
                            for (Element table : docyi.select("table")) {
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
        
        // Save To DB Here

    String fannn = "";
    
    try {
        String sql0 = "select * from Recipe_Processes where WashName = ? and Model = ?";
        pst = conn.prepareStatement(sql0);
        pst.setString(1, filenammm);
        pst.setString(2, modeloo);
        rs = pst.executeQuery();                    
        
        if (rs.next()) {                        
            fannn = "found";   
        } else {
            fannn = "not_found";   
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

    if (fannn.equals("found")) {
        try {
            String sqlp = "update Recipe_Processes set Date = ?, Model = ?, WashName = ?, Processes = ? where WashName = ? and Model = ?";
            pst = conn.prepareStatement(sqlp);
            pst.setString(1, dateString2l);
            pst.setString(2, modeloo);
            pst.setString(3, filenammm);
            pst.setString(4, procccc);
            pst.setString(5, filenammm); // WHERE clause parameters
            pst.setString(6, modeloo);
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
    } else if (fannn.equals("not_found")) {
        try {                            
            String reg = "insert into Recipe_Processes (Date, Model, WashName, Processes) values (?, ?, ?, ?)";
            pst = conn.prepareStatement(reg);
            pst.setString(1, dateString2l);
            pst.setString(2, modeloo);
            pst.setString(3, filenammm);
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
        
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
   //Add Here//
///////////////////////ooooooooooooooooooooooo////////////////////////////////////////////////////   
                      
sumz=0.0;
ally=0.0;

                            org.jsoup.nodes.Document docyp = Jsoup.parse(code.getText());
                            for (Element table : docyp.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            
                            
                            if (tds.get(7).text().contains("new stone")||tds.get(7).text().contains("New Stone")||tds.get(7).text().contains("NEW STONE")||tds.get(7).text().contains("NEW STON")||tds.get(7).text().contains("new ston")||tds.get(7).text().contains("now ston")||tds.get(7).text().contains("now stone")||tds.get(7).text().contains("NOW STON")||tds.get(7).text().contains("NOW STONE")) {
                                
                                 
                                stonny=tds.get(5).text().toString();
                                sto=Double.parseDouble(stonny);
                                sumz=sumz+sto;
                                
                            }
                            
                             else {
                               
                                sumz=sumz;
                                
                            }
                            
                            ally=(sumz/2)*25;
                            finall=Double.toString(ally);
                            
                           }}
                       
                            
    // Save To DB Here
    Date currentDate1 = GregorianCalendar.getInstance().getTime();
    DateFormat df1 = DateFormat.getDateInstance();
    String dateString1 = df1.format(currentDate1);
    Date d1 = new Date();
    SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
    String timeString1 = sdf1.format(d1);
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    String dateString2 = sdf2.format(d1);

    String fannm = "";
    
    try {
        String sql0 = "select * from GetterStone where Name = ? and Model = ?";
        pst = conn.prepareStatement(sql0);
        pst.setString(1, filenammm);
        pst.setString(2, modeloo);
        rs = pst.executeQuery();                    
        
        if (rs.next()) {                        
            fannm = "found";   
        } else {
            fannm = "not_found";   
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
    
    

    if (fannm.equals("found")) {
        try {
            String sqlp = "update GetterStone set Date = ?, Model = ?, Name = ?, Stone = ? where Name = ? and Model = ?";
            pst = conn.prepareStatement(sqlp);
            pst.setString(1, dateString2);
            pst.setString(2, modeloo);
            pst.setString(3, filenammm);
            pst.setString(4, finall);
            pst.setString(5, filenammm); // WHERE clause parameters
            pst.setString(6, modeloo);
            pst.execute();
            
            Notifications noti = Notifications.create();
            noti.title("Successful");
            noti.text("We have updated the stone successfully.");
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
    } else if (fannm.equals("not_found")) {
        try {                            
            String reg = "insert into GetterStone (Date, Model, Name, Stone) values (?, ?, ?, ?)";
            pst = conn.prepareStatement(reg);
            pst.setString(1, dateString2);
            pst.setString(2, modeloo);
            pst.setString(3, filenammm);
            pst.setString(4, finall);
            pst.execute(); 
            
            Notifications noti = Notifications.create();
            noti.title("Successful");
            noti.text("We have inserted the new stone successfully.");
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
    
    
    
      
// النص القديم قبل التعديل – لو عندك نسخة محفوظة منه
String oldContent = originalltextt; // أو حمّله من آخر نسخة محفوظة مثلاً
// النص الجديد بعد التعديل
String newContent = code.getText();
// احسب التغييرات الفعلية بين النصين
List<Map<String, Object>> changes = computeChanges(oldContent, newContent);
// لو مفيش تغييرات، ما تحفظش حاجة
if (!changes.isEmpty()) {
    saveToHistory(changes);
}
code.clear();
    
    


Platform.runLater( () -> {

    try {

 // تنظيف الكود القديم
code.clear();

// قراءة الملف وفك التشفير
InputStream inputinstream = new FileInputStream(lonk.getText());
BufferedReader bi = new BufferedReader(new InputStreamReader(inputinstream, "UTF-8"));
String lo;
while ((lo = bi.readLine()) != null) {
    code.appendText("\n" + lo
            .replace("ﬦ", "A").replace("ﬧ", "B").replace("ﬨ", "C").replace("﬩", "D").replace("שׁ", "E")
            .replace("שׂ", "F").replace("שּׁ", "G").replace("שּׂ", "H").replace("אַ", "I").replace("אָ", "J")
            .replace("אּ", "K").replace("בּ", "L").replace("גּ", "M").replace("דּ", "N").replace("הּ", "O")
            .replace("וּ", "P").replace("זּ", "Q").replace("טּ", "R").replace("יּ", "S").replace("ךּ", "T")
            .replace("כּ", "U").replace("לּ", "V").replace("מּ", "W").replace("נּ", "X").replace("סּ", "Y")
            .replace("ףּ", "Z").replace("פּ", "0").replace("צּ", "1").replace("קּ", "2").replace("רּ", "3")
            .replace("שּ", "4").replace("תּ", "5").replace("וֹ", "6").replace("בֿ", "7").replace("כֿ", "8")
            .replace("פֿ", "9").replace("&NBSP;", ""));
}
bi.close();

// كتابة الملف بعد فك التشفير
String gf = code.getText();
try (PrintWriter pwe = new PrintWriter(new OutputStreamWriter(new FileOutputStream(lonk.getText()), "UTF-8"))) {
    pwe.println(gf);
}
code.clear();

// إعداد بيانات QR
Date d = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
String dateString = sdf.format(d);

String programmerName = "Ahmed Elkady.";
String companyName = "Kadysoft Ltd.";
String factoryName = "T&C Garments.";
String recipeName = filenammm + ".";
String clientName = modeloo + ".";
int qty = Integer.parseInt(pecoco);
String lastEditorName = lonk1.getText() + ".";
String date = dateString + ".";
String repolink = "https://progkady.github.io/RecipeBrowser/";
double pcsCost = onegar;

String qrText = "★ Recipe Details ★\n" +
        "-------------------------\n" +
        "• Programmer : " + programmerName + "\n" +
        "• Developer : " + companyName + "\n" +
        "• Factory : " + factoryName + "\n" +
        "• Recipe : " + recipeName + "\n" +
        "• Customer : " + clientName + "\n" +
        "• Quantity : " + qty + "\n" +
        "• Editor Name : " + lastEditorName + "\n" +
        "• Last Update : " + date + "\n" +
        "• Pcs Cost : " + pcsCost + " $\n\n" +
        "• Recipes Link : " + repolink + "\n" +
        "Thanks For Using Receta From Kadysoft Ltd. ❤";

// إنشاء QR بحجم كبير وواضح
int qrSize = 250; // حجم QR بالبكسل
BufferedImage qrImage = createPrintableQR(qrText, qrSize);
String qrBase64 = imageToBase64Png(qrImage);

// قراءة HTML الأصلي
String htmlContent = readFile(lonk.getText());
Document doc = Jsoup.parse(htmlContent);
doc.outputSettings().syntax(Document.OutputSettings.Syntax.html);
doc.outputSettings().charset("UTF-8");

Element table = doc.select("table#EXTABLE").first();
if (table == null) {
    System.out.println("خطأ: الجدول #EXTABLE مش موجود!");
    return;
}


// --- الحصول على الصفوف ---
Elements rows = table.select("tbody > tr");
int mergeRows = Math.min(7, rows.size()); // دمج 7 صفوف
int qrColumnIndex = 8; // العمود رقم 9

// --- الصف الأول ---
Element firstRow = rows.get(0);
Elements cells = firstRow.select("td");

if (cells.size() <= qrColumnIndex) {
    System.out.println("العمود رقم 9 مش موجود في الصف الأول!");
    return;
}

// --- خلية QR Code ---
Element qrCell = cells.get(qrColumnIndex);

// --- (1) فحص وجود QR CODE قديم ---
Element oldQrImg = qrCell.selectFirst("img[src^=data:image]");

// --- (2) HTML الخاص بالـ QR الجديد ---
String qrHtml =
        "<img src=\"data:image/png;base64," + qrBase64 + "\" " +
        "alt=\"QR CODE, POWERED BY KADYSOFT LTD.\" " +
        "style=\"width:" + qrSize + "px !important; height:" + qrSize + "px !important; " +
        "max-width:none !important; max-height:none !important; border:10px solid white; " +
        "box-shadow:0 0 0 4pt black;\"/>";

// --- (3) استبدال QR الموجود لو موجود ---
if (oldQrImg != null) {
    // يستبدل الـ HTML فقط بدون تغيير الـ rowspan أو الستايل
    qrCell.html(qrHtml);
} else {
    // --- (4) إضافة QR جديد لو مفيش ---
    qrCell.attr("rowspan", String.valueOf(mergeRows))
          .attr("style", "border: 3px double #000; padding: 10px; background: #ffffff; " +
                         "text-align: center; vertical-align: middle;")
          .html(qrHtml);
}



//Elements rows = table.select("tbody > tr");
//int mergeRows = Math.min(7, rows.size()); // دمج أول 8 صفوف
//int qrColumnIndex = 8; // العمود رقم 9
//
//Element firstRow = rows.get(0);
//Elements cells = firstRow.select("td");
//if (cells.size() <= qrColumnIndex) {
//    System.out.println("العمود رقم 9 مش موجود في الصف الأول!");
//    return;
//}
//
//// إدراج QR في العمود 9 مع CSS مناسب للطباعة
//Element qrCell = cells.get(qrColumnIndex);
//qrCell.attr("rowspan", String.valueOf(mergeRows))
//      .attr("style", "border: 3px double #000; padding: 10px; background: #ffffff; " +
//                     "text-align: center; vertical-align: middle;")
//      .html(
//        "<img src=\"data:image/png;base64," + qrBase64 + "\" " +
//        "alt=\"QR CODE, POWERED BY KADYSOFT LTD.\" " +
//        "style=\"width:" + qrSize + "px !important; height:" + qrSize + "px !important; " +
//        "max-width:none !important; max-height:none !important; border:10px solid white; " +
//        "box-shadow:0 0 0 4pt black;\"/>" +
//        "<br><br>" +
//        "<div style=\"font-weight: bold; font-size: 16pt; color: black; margin-top: 10px;\">" +
//        "Scan Me Now</div>"
//      );

// إزالة الخلية من الصفوف الأخرى
for (int i = 1; i < mergeRows; i++) {
    Element row = rows.get(i);
    Elements rowCells = row.select("td");
    if (rowCells.size() > qrColumnIndex) {
        rowCells.get(qrColumnIndex).remove();
    }
}

// حفظ HTML بعد دمج QR
writeFile(lonk.getText(), doc.outerHtml());
code.clear();

// إعادة تشفير الملف
InputStream inputinstreamn = new FileInputStream(lonk.getText());
BufferedReader bin = new BufferedReader(new InputStreamReader(inputinstreamn, "UTF-8"));
String lon;
while ((lon = bin.readLine()) != null) {
    if (lon.contains("data:image") || lon.contains("base64,")) {
        code.appendText("\n" + lon);
        continue;
    }
    String converted = lon
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
    code.appendText("\n" + converted);
}
bin.close();

try (PrintWriter pwn = new PrintWriter(new OutputStreamWriter(new FileOutputStream(lonk.getText()), "UTF-8"))) {
    pwn.println(code.getText());
}
code.clear();

    
    
    //Encrypt Here.............
       
       
    try {
            // المسار المطلوب تنفيذه فيه أوامر Git
            String repoPath = "X:\\Recipe_System\\Recipes";

            // تشغيل الأوامر بالترتيب
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
    
    }
catch (Exception r) {
    
}
        
    });
   
/////////////////////////////////llllllllllllllllllll/////////////////////////////////////////////
    }
    
    
    
    private static void runCommand(String command, String workingDir) throws Exception {
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
    
    
    // دالة إنشاء QR مثالي للطباعة (أبيض وأسود + إطار أنيق)
    private static BufferedImage createPrintableQR(String text, int size) throws WriterException {
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H); // أعلى تصحيح خطأ
        hints.put(EncodeHintType.MARGIN, 4); // هامش كبير للطباعة
        BitMatrix matrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, size, size, hints);
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
        Graphics2D g = image.createGraphics();
        // خلفية بيضاء نقية
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        // نقاط QR سوداء قوية
        g.setColor(Color.BLACK);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (matrix.get(x, y)) {
                    g.fillRect(x, y, 1, 1);
                }
            }
        }
        g.dispose();
        return image;
    }
    // تحويل الصورة إلى Base64
    private static String imageToBase64Png(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "PNG", baos);
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }
    // قراءة ملف (Java 8)
    private static String readFile(String path) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        br.close();
        return sb.toString();
    }
    // كتابة ملف (Java 8)
    private static void writeFile(String path, String content) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
        pw.print(content);
        pw.close();
        pw.close();
    }
    
    
      
    
  ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
    
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

        try (FileWriter writer = new FileWriter(historyyfileepathh)) {
            new Gson().toJson(history, writer);
        } catch (IOException ex) {
            
        }
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
    
    
    
   
    
    
    
    
    @FXML
    void historyaction(ActionEvent event)  {
        
        viewHistory();
        
    }
     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////// 

    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        conn = db.java_db();
        
        String lonkkk=RecipeMakerController_1.lonkk;
        lonk.setText(lonkkk);
        
        String theuserr=RecipeMakerController_1.theuser;
        lonk1.setText(theuserr);
        
        String funkifi=RecipeMakerController_1.funkifi;
        
        editedby.setText(funkifi+" By "+theuserr);
        
        
        originalltextt=RecipeMakerController_1.originalContent;
        //System.out.println(originalltextt);
        historyyfileepathh=RecipeMakerController_1.historyFilePath;
        
         list.getItems().clear();
   
    try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Mails.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        
      list.getItems().addAll(line);
         
      } 
      buf.close();
    } 
    catch (FileNotFoundException fileNotFoundException) {
    
    }
    catch (IOException iOException) {}
    
    
    //////////////////////////////////////////////////
    
        
        
    }    
    
}
