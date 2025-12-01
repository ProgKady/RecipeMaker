package kadysoft.kady;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Optional;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.controlsfx.control.Notifications;
//
//kadinio

public class Main extends Application {
    
     public static String diro;
    
   public void start(Stage stage) throws Exception {
      Parent root = (Parent)FXMLLoader.load(this.getClass().getResource("LogIn_GUI.fxml"));
      Scene scene = new Scene(root);
      stage.setTitle("Recipe Maker By Kadysoft Ltd.");
      stage.centerOnScreen();
      stage.setResizable(false);
      stage.centerOnScreen();
      stage.setScene(scene);
      stage.getIcons().add(new Image(Main.class.getResourceAsStream("washing.png")));
      //Platform.setImplicitExit(false);

//stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
//    @Override
//    public void handle(WindowEvent event) {
//        event.consume();
//    }
//});
      stage.show();
      
  
      
       //////////////////////////Add All Codes Here////////////////////////////////////////////////////////////////////////////////////////////////////////
    //Read first and compare then write
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String timeString = sdf.format(d);
    String value1 = timeString;
    
    
      try {
            String path = Main.class.getProtectionDomain()
            .getCodeSource().getLocation().toURI().getPath();

            String decodedPath = URLDecoder.decode(path, StandardCharsets.UTF_8.name());
            File file = new File(decodedPath);
            String dir = file.isFile() ? file.getParent() : file.getPath();

            
           diro=dir;

            if (dir.length() > 2 && dir.charAt(1) == ':') {
                String driveLetter = dir.substring(0, 2);
                
                
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    

    File ff=new File (diro+"\\lib\\java.cfg");
    
    //File ff=new File (System.getProperty("user.home")+"\\AppData\\Roaming\\.store_cfg");
    
    
    if (ff.exists()) {
        //Read then compare if equals 30 or more show alert and exit, if less don't do anything.
      BufferedReader buff=new BufferedReader(new FileReader(ff));
      String line;
      line=buff.readLine();
      buff.close();
      LocalDate d1 = LocalDate.parse(line, DateTimeFormatter.ISO_LOCAL_DATE);
      LocalDate d2 = LocalDate.parse(value1, DateTimeFormatter.ISO_LOCAL_DATE);
      Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());
      long diffDays = diff.toDays();
      
      if (diffDays>=30) {
          //Show Alert to register or close.
          ///////////////////////////////////////////////////////////////////////////////////////////////////
          
          Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
          alert.setTitle("Session Expired");
          alert.setResizable(false);
          DialogPane dialogPaneef = alert.getDialogPane();
          dialogPaneef.getStylesheets().add(
        getClass().getResource("cupertino-light.css").toExternalForm());
          Label l1=new Label("Sorry, your expiration date has been ended.");
          l1.setEffect(new DropShadow());
          //l1.setStyle("-fx-background-color:white;-fx-font-weight:bold;-fx-font-size:15;-fx-background-radius:3em;");
          
          Label l2=new Label("Please, register to continue.");
          l2.setEffect(new DropShadow());
          //l2.setStyle("-fx-background-color:white;-fx-font-weight:bold;-fx-font-size:15;-fx-background-radius:3em;");
          
          Label l3=new Label("Or click 'OK' or 'EXIT' to exit and cancel the operation.");
          l3.setEffect(new DropShadow());
          //l3.setStyle("-fx-background-color:white;-fx-font-weight:bold;-fx-font-size:15;-fx-background-radius:3em;");
          
          Hyperlink hy=new Hyperlink ("Register");
          hy.setEffect(new DropShadow());
          //hy.setStyle("-fx-background-color:lightblue;-fx-font-weight:bold;-fx-font-size:12;-fx-background-radius:3em;");
         
          JFXPasswordField jfx=new JFXPasswordField ();
          jfx.setAlignment(Pos.CENTER);
          jfx.setLabelFloat(true);
          jfx.setPromptText("Enter Serial Key!!!.");
          jfx.setMinSize(300, 30);
          jfx.setStyle("-fx-background-color:lightblue;-fx-font-weight:bold;-fx-font-size:15;");
          jfx.setEffect(new DropShadow());
          
          VBox pane=new VBox();
          pane.getChildren().addAll(l1,l2,l3);
          pane.setSpacing(20);
          
          
          alert.setGraphic(pane);
          
          Optional<ButtonType> option = alert.showAndWait();

      if (option.get() == null) {
         stage.close();
      } else if (option.get() == ButtonType.OK) {
      ///////////////////////////
      
      alert.close();
      stage.close();
      
      ///////////////////////////
      }
      else if (option.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, nothing will happen.");
      noti.position(Pos.CENTER);
      noti.showInformation();
      stage.close();
      }
      else {
         
      }
         
          ///////////////////////////////////////////////////////////////////////////////////////////////////
          
      }
      
      else {
          // Do Nothing
      }
    }
    else {
        //Write date for the first time.
        ff.createNewFile();
        PrintWriter pw=new PrintWriter (new FileWriter (ff));
        pw.print("2023-10-20");
        pw.close();
    }
      
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
      
      
      
      
   }

   public static void main(String[] args) {
      launch(args);
      
      
      
      
      
      
      
      
      
      
      
   }
}
