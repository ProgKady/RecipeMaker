

/*
// Saver App For Recipe System.
*/


package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
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

/**
 * FXML Controller class
 *
 * @author KADY
 */
public class SaverController_1 implements Initializable {

    
    Connection conn = null;
  
    ResultSet rs = null;
  
    PreparedStatement pst = null;
    
    @FXML
    private JFXButton save;
    
    @FXML
    private JFXTextArea code;
    
    static String filePath;
    PrintWriter pw;
       
    @FXML
    private JFXTextField date;

    @FXML
    private ComboBox<String> stage;

    @FXML
    private JFXTextField washname;

    @FXML
    private ComboBox<String> model;
    
    @FXML
    private JFXCheckBox signme;
    
    
    
    
    
    @FXML
    void sendmailaction(ActionEvent event) {

        //Show Alert /////////////////////////////////////////////
        
        
        //Show Alert /////////////////////////////////////////////
        JFXTextArea fr=new JFXTextArea ();
        fr.setMinSize(50, 50);
        fr.setVisible(false);
        
        JFXTextField path=new JFXTextField ();
        path.setStyle("-fx-font-weight:bold;-fx-font-size:13;");
        path.setLabelFloat(true);
        path.setMinWidth(350);
        path.setEditable(false);
        path.setPromptText("Pilot Path ...");
        path.setOnMouseClicked(s -> {
            FileChooser fcho = new FileChooser();
            String go = NewDir.file_dir;
            fcho.setInitialDirectory(new File(go));
            fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", new String[] { "*.xlsx" }));
            fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", new String[] { "*.xls" }));
            fcho.setTitle("Kady Choose");
            File f = fcho.showOpenDialog((Window)null);
            String pathy = f.getAbsolutePath().toString();
            path.setText(pathy);
        });
        
        
        ComboBox combo1=new ComboBox ();
        combo1.setPromptText("Editor Name...");
        combo1.setStyle("-fx-font-weight:bold;-fx-background-radius:3em;");
        combo1.setMinSize(350, 35);
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
                
                File bn3=new File (bn1+"\\Created_Recipe_From_Pilot_To_Production.html");
                bn3.createNewFile();
                bn3.deleteOnExit();
                
                
                String gf2=code.getText();
                OutputStream instreamm2=new FileOutputStream(bn3);
                PrintWriter pwe2 = new PrintWriter(new OutputStreamWriter (instreamm2,"UTF-8"));
                pwe2.println(gf2);
                pwe2.close();
                
                Thread.sleep(500);
                
                /////////////////////////////////////////////Sending Mail................/////////////////////////////////////////////
                 
      String to = combo2.getSelectionModel().getSelectedItem().toString();
      String from = "ahmedelkadyteeest@gmail.com";
      final String username = "ahmedelkadyteeest@gmail.com";
      final String password = "lgrj esca tdtz froo";
      String filename1 = path.getText();
      String filename2 = System.getProperty("user.home")+"\\Mailed_Recipes\\Created_Recipe_From_Pilot_To_Production.html";

      
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
         messageBodyPart2.setText("Converted Recipe From Pilot To Production.\nPowered By Kadysoft Ltd. CEO - Ahmed Elkady");
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
        DialogPane dialogPane = aloo.getDialogPane();
        dialogPane.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
        aloo.showAndWait();
        
        
        
        //////////////////////////////////////////////////////////
        
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
    void modelaction(Event event) {

        this.model.getItems().clear();
    try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Models.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        this.model.getItems().addAll(new String[] { line });
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
        
    }

    
    @FXML
    void saveaction(ActionEvent event) throws FileNotFoundException, IOException {
        
        
      Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
      alert.setTitle("Write To DB?");
      alert.setHeaderText("Write Recipe To Database Or Not ...");
      alert.setContentText("Please Click 'OK' To Write This Recipe To Database Or Click 'Cancel' To Continue Without Writing.");
      DialogPane dialogPane = alert.getDialogPane();
      dialogPane.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> option = alert.showAndWait();
      if (option.get() == null) {
          
      } else if (option.get() == ButtonType.OK) {
          
          
        
   
        if (signme.isSelected()==true) {
            
            
            String codee=code.getText();
            String pathtosignature="file://"+NewDir.file_dirrrrr+"\\Mr_Muhammet.png";
            String modelname = this.model.getSelectionModel().getSelectedItem();
            String stagename = this.stage.getSelectionModel().getSelectedItem();
            String washnamee=washname.getText().replace(" ","_");
            String datee=date.getText();
            String pathe = NewDir.file_dir;
            File directory = new File(pathe + "\\" + stagename + "\\" + modelname);
            directory.mkdirs();
            FileChooser dialog = new FileChooser();
            dialog.setInitialDirectory(directory);
            dialog.setInitialFileName(washnamee);
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
            File dialogResult = dialog.showSaveDialog(null);
            filePath = dialogResult.getAbsolutePath().toString();
            OutputStream instream=new FileOutputStream(filePath);
            pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
            pw.println("<!DOCTYPE html>\n<html lang=\"ar\">\n<head>\n<title>Kadysoft</title>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<style>td {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}\ntable {\nheight:5px;\nmax-width:100%;\nheight:100%;\nwhite-space:nowrap;\n}\ntr {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}</style></head>\n<body><center>\n\n");
            pw.println("<!-- Creating Recipe From Kadysoft Ltd.-->\n\n");
            pw.println(codee);
            pw.println("\n\n</center>\n</body>\n</html>");
            pw.println("<b id=\"signname\">Mr_Muhammet Signature: "+"</b><img id=\"signimage\" src=\""+pathtosignature+"\" width=\"300\" height=\"90\" alt=\"Developed By Kadysoft Ltd (Ahmed Elkady).\" style=\"border-color:black;border-width:10px;\">");   
      
             if (codee.contains("background-image:")) {
                
            }
            else {
                pw.println("\n\n<style>\n" +
"body {\n" +
"  background-image: url(\""+modelname+".bmp\");\n" +
"  background-position: center;\n" +
"  height: 170px;\n" +
"background-position-x:550px;"+
"  background-repeat: no-repeat;\n" +
"  background-size: 120px 90px;\n" +
"}\n" +
"</style>");             
          }
            pw.close();
            
            //////////////////////////////////////////////We will add save to db here , don't forget.
            
            String pathl=pathe + "\\" + stagename + "\\" + modelname+"\\"+washnamee+".ks";
            
     try {
      String sql = "insert into Creation (Date,Stage,Model,Name,Path,Type,Revised_Date) values (?,?,?,?,?,?,?)";
      this.pst = this.conn.prepareStatement(sql);
      this.pst.setString(1, datee);
      this.pst.setString(2, stagename);
      this.pst.setString(3, modelname);
      this.pst.setString(4, washnamee);
      this.pst.setString(5, pathl);
      this.pst.setString(6, "Pending");
      this.pst.setString(7, "Not_Revised");
      this.pst.execute();
    } catch (Exception e) {
     
    } finally {
      try {
        this.rs.close();
        this.pst.close();
      } catch (Exception exception) {}
    }
    
     
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
            
     
     
     
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         try {
         String sqla = "INSERT INTO notifications (Recipient, Sender, Message, Delivered) VALUES (?, ?, ?, 0)";
          pst = conn.prepareStatement(sqla);
          pst.setString(1, "Recipe_Maker");
          pst.setString(2, "Ahmed Elkady");
          pst.setString(3, "We have created "+washnamee+" successfully in "+datee+" of "+modelname+" model.");
          pst.executeUpdate();
          }
          catch (Exception e) {
          } finally {
          try {
          rs.close();
          pst.close();
          } catch (Exception exception) {}}  
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
     
     
            //Desktop desk = Desktop.getDesktop();
            //desk.open(new File (filePath));
            Stage jk = (Stage)this.save.getScene().getWindow();
            jk.close();
    
            
       ///////////////////////////////////////////////////
            
        }
        
        else {
            
            
            String codee=code.getText();
            String pathtosignature="file://"+NewDir.file_dirrrrr+"\\Mr_Moharam.png";
            String modelname = this.model.getSelectionModel().getSelectedItem();
            String stagename = this.stage.getSelectionModel().getSelectedItem();
            String washnamee=washname.getText().replace(" ","_");
            String datee=date.getText();
            String pathe = NewDir.file_dir;
            File directory = new File(pathe + "\\" + stagename + "\\" + modelname);
            directory.mkdirs();
            FileChooser dialog = new FileChooser();
            dialog.setInitialDirectory(directory);
            dialog.setInitialFileName(washnamee);
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
            File dialogResult = dialog.showSaveDialog(null);
            filePath = dialogResult.getAbsolutePath().toString();
            OutputStream instream=new FileOutputStream(filePath);
            pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
            pw.println("<!DOCTYPE html>\n<html lang=\"ar\">\n<head>\n<title>Kadysoft</title>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<style>td {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}\ntable {\nheight:5px;\nmax-width:100%;\nheight:100%;\nwhite-space:nowrap;\n}\ntr {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}</style></head>\n<body><center>\n\n");
            pw.println("<!-- Creating Recipe From Kadysoft Ltd.-->\n\n");
            pw.println(codee);
            pw.println("\n\n</center>\n</body>\n</html>");
            //pw.println("<b>Mr_Moharam Signature: "+"</b><img src=\""+pathtosignature+"\" width=\"300\" height=\"90\" alt=\"Developed By Kadysoft Ltd (Ahmed Elkady).\" style=\"border-color:black;border-width:10px;\">");   
      
             if (codee.contains("background-image:")) {
                
            }
            else {
                pw.println("\n\n<style>\n" +
"body {\n" +
"  background-image: url(\""+modelname+".bmp\");\n" +
"  background-position: center;\n" +
"  height: 170px;\n" +
"background-position-x:550px;"+
"  background-repeat: no-repeat;\n" +
"  background-size: 120px 90px;\n" +
"}\n" +
"</style>");             
          }
            pw.close();
            
            //////////////////////////////////////////////We will add save to db here , don't forget.
            
            String pathl=pathe + "\\" + stagename + "\\" + modelname+"\\"+washnamee+".ks";
            
     try {
      String sql = "insert into Creation (Date,Stage,Model,Name,Path,Type,Revised_Date) values (?,?,?,?,?,?,?)";
      this.pst = this.conn.prepareStatement(sql);
      this.pst.setString(1, datee);
      this.pst.setString(2, stagename);
      this.pst.setString(3, modelname);
      this.pst.setString(4, washnamee);
      this.pst.setString(5, pathl);
      this.pst.setString(6, "Pending");
      this.pst.setString(7, "Not_Revised");
      this.pst.execute();
    } catch (Exception e) {
     
    } finally {
      try {
        this.rs.close();
        this.pst.close();
      } catch (Exception exception) {}
    }
    
     
     
     
     
         
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
            
     
     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         try {
         String sqla = "INSERT INTO notifications (Recipient, Sender, Message, Delivered) VALUES (?, ?, ?, 0)";
          pst = conn.prepareStatement(sqla);
          pst.setString(1, "Recipe_Maker");
          pst.setString(2, "Ahmed Elkady");
          pst.setString(3, "We have created "+washnamee+" successfully in "+datee+" of "+modelname+" model.");
          pst.executeUpdate();
          }
          catch (Exception e) {
          } finally {
          try {
          rs.close();
          pst.close();
          } catch (Exception exception) {}}  
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
     
     
     
            //Desktop desk = Desktop.getDesktop();
            //desk.open(new File (filePath));
            Stage jk = (Stage)this.save.getScene().getWindow();
            jk.close();
    
            
       ///////////////////////////////////////////////////
            
        }
        
          
      }
      
      else if (option.get() == ButtonType.CANCEL) {
          
          
        
   
        if (signme.isSelected()==true) {
            
            
            String codee=code.getText();
            String pathtosignature="file://"+NewDir.file_dirrrrr+"\\Mr_Muhammet.png";
            String modelname = this.model.getSelectionModel().getSelectedItem();
            String stagename = this.stage.getSelectionModel().getSelectedItem();
            String washnamee=washname.getText().replace(" ","_");
            String datee=date.getText();
            String pathe = NewDir.file_dir;
            File directory = new File(pathe + "\\" + stagename + "\\" + modelname);
            directory.mkdirs();
            FileChooser dialog = new FileChooser();
            dialog.setInitialDirectory(directory);
            dialog.setInitialFileName(washnamee);
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
            File dialogResult = dialog.showSaveDialog(null);
            filePath = dialogResult.getAbsolutePath().toString();
            OutputStream instream=new FileOutputStream(filePath);
            pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
            pw.println("<!DOCTYPE html>\n<html lang=\"ar\">\n<head>\n<title>Kadysoft</title>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<style>td {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}\ntable {\nheight:5px;\nmax-width:100%;\nheight:100%;\nwhite-space:nowrap;\n}\ntr {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}</style></head>\n<body><center>\n\n");
            pw.println("<!-- Creating Recipe From Kadysoft Ltd.-->\n\n");
            pw.println(codee);
            pw.println("\n\n</center>\n</body>\n</html>");
            pw.println("<b id=\"signname\">Mr_Muhammet Signature: "+"</b><img id=\"signimage\" src=\""+pathtosignature+"\" width=\"300\" height=\"90\" alt=\"Developed By Kadysoft Ltd (Ahmed Elkady).\" style=\"border-color:black;border-width:10px;\">");   
      
             if (codee.contains("background-image:")) {
                
            }
            else {
                pw.println("\n\n<style>\n" +
"body {\n" +
"  background-image: url(\""+modelname+".bmp\");\n" +
"  background-position: center;\n" +
"  height: 170px;\n" +
"background-position-x:550px;"+
"  background-repeat: no-repeat;\n" +
"  background-size: 120px 90px;\n" +
"}\n" +
"</style>");             
          }
            pw.close();
            
            //////////////////////////////////////////////We will add save to db here , don't forget.
            
//            String pathl=pathe + "\\" + stagename + "\\" + modelname+"\\"+washnamee+".ks";
//            
//     try {
//      String sql = "insert into Creation (Date,Stage,Model,Name,Path,Type,Revised_Date) values (?,?,?,?,?,?,?)";
//      this.pst = this.conn.prepareStatement(sql);
//      this.pst.setString(1, datee);
//      this.pst.setString(2, stagename);
//      this.pst.setString(3, modelname);
//      this.pst.setString(4, washnamee);
//      this.pst.setString(5, pathl);
//      this.pst.setString(6, "Pending");
//      this.pst.setString(7, "Not_Revised");
//      this.pst.execute();
//    } catch (Exception e) {
//     
//    } finally {
//      try {
//        this.rs.close();
//        this.pst.close();
//      } catch (Exception exception) {}
//    }
//    
     
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
            
     
     
     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         try {
         String sqla = "INSERT INTO notifications (Recipient, Sender, Message, Delivered) VALUES (?, ?, ?, 0)";
          pst = conn.prepareStatement(sqla);
          pst.setString(1, "Recipe_Maker");
          pst.setString(2, "Ahmed Elkady");
          pst.setString(3, "We have created "+washnamee+" successfully in "+datee+" of "+modelname+" model.");
          pst.executeUpdate();
          }
          catch (Exception e) {
          } finally {
          try {
          rs.close();
          pst.close();
          } catch (Exception exception) {}}  
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
     
     
     
            //Desktop desk = Desktop.getDesktop();
            //desk.open(new File (filePath));
            Stage jk = (Stage)this.save.getScene().getWindow();
            jk.close();
    
            
       ///////////////////////////////////////////////////
            
        }
        
        else {
            
            
            String codee=code.getText();
            String pathtosignature="file://"+NewDir.file_dirrrrr+"\\Mr_Moharam.png";
            String modelname = this.model.getSelectionModel().getSelectedItem();
            String stagename = this.stage.getSelectionModel().getSelectedItem();
            String washnamee=washname.getText().replace(" ","_");
            String datee=date.getText();
            String pathe = NewDir.file_dir;
            File directory = new File(pathe + "\\" + stagename + "\\" + modelname);
            directory.mkdirs();
            FileChooser dialog = new FileChooser();
            dialog.setInitialDirectory(directory);
            dialog.setInitialFileName(washnamee);
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
            dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
            File dialogResult = dialog.showSaveDialog(null);
            filePath = dialogResult.getAbsolutePath().toString();
            OutputStream instream=new FileOutputStream(filePath);
            pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
            pw.println("<!DOCTYPE html>\n<html lang=\"ar\">\n<head>\n<title>Kadysoft</title>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<style>td {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}\ntable {\nheight:5px;\nmax-width:100%;\nheight:100%;\nwhite-space:nowrap;\n}\ntr {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}</style></head>\n<body><center>\n\n");
            pw.println("<!-- Creating Recipe From Kadysoft Ltd.-->\n\n");
            pw.println(codee);
            pw.println("\n\n</center>\n</body>\n</html>");
            //pw.println("<b>Mr_Moharam Signature: "+"</b><img src=\""+pathtosignature+"\" width=\"300\" height=\"90\" alt=\"Developed By Kadysoft Ltd (Ahmed Elkady).\" style=\"border-color:black;border-width:10px;\">");   
      
             if (codee.contains("background-image:")) {
                
            }
            else {
                pw.println("\n\n<style>\n" +
"body {\n" +
"  background-image: url(\""+modelname+".bmp\");\n" +
"  background-position: center;\n" +
"  height: 170px;\n" +
"background-position-x:550px;"+
"  background-repeat: no-repeat;\n" +
"  background-size: 120px 90px;\n" +
"}\n" +
"</style>");             
          }
            pw.close();
            
            //////////////////////////////////////////////We will add save to db here , don't forget.
//            
//            String pathl=pathe + "\\" + stagename + "\\" + modelname+"\\"+washnamee+".ks";
//            
//     try {
//      String sql = "insert into Creation (Date,Stage,Model,Name,Path,Type,Revised_Date) values (?,?,?,?,?,?,?)";
//      this.pst = this.conn.prepareStatement(sql);
//      this.pst.setString(1, datee);
//      this.pst.setString(2, stagename);
//      this.pst.setString(3, modelname);
//      this.pst.setString(4, washnamee);
//      this.pst.setString(5, pathl);
//      this.pst.setString(6, "Pending");
//      this.pst.setString(7, "Not_Revised");
//      this.pst.execute();
//    } catch (Exception e) {
//     
//    } finally {
//      try {
//        this.rs.close();
//        this.pst.close();
//      } catch (Exception exception) {}
//    }
//    
//     
     
     
     
         
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
            
     
     
     /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         try {
         String sqla = "INSERT INTO notifications (Recipient, Sender, Message, Delivered) VALUES (?, ?, ?, 0)";
          pst = conn.prepareStatement(sqla);
          pst.setString(1, "Recipe_Maker");
          pst.setString(2, "Ahmed Elkady");
          pst.setString(3, "We have created "+washnamee+" successfully in "+datee+" of "+modelname+" model.");
          pst.executeUpdate();
          }
          catch (Exception e) {
          } finally {
          try {
          rs.close();
          pst.close();
          } catch (Exception exception) {}}  
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     
     
     
            //Desktop desk = Desktop.getDesktop();
            //desk.open(new File (filePath));
            Stage jk = (Stage)this.save.getScene().getWindow();
            jk.close();
    
            
       ///////////////////////////////////////////////////
            
        }
        
          
      }
      
      else {
          
          
          
      }
        
        
        
         
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        
    conn = db.java_db(); 
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String timeString = sdf.format(d);
    String value1 = dateString;
    this.date.setText(timeString);
    stage.getItems().addAll(new String[] { "DEVELOPMENT", "PRODUCTION", "PILOT", "BLANKET", "SHRINK" });
    
    
    
    }    
    
}
