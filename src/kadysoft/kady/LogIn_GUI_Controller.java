package kadysoft.kady;

import com.gluonhq.charm.glisten.animation.HingeTransition;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.TextInputDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

public class LogIn_GUI_Controller  implements Initializable {
  @FXML
  private ResourceBundle resources;
  
  @FXML
  private URL location;
  
  @FXML
  private ComboBox positionbox;
  
  @FXML
  private ImageView shoort;
  
  @FXML
  private JFXTextField namefield;
  
  
  
  public static String windowsversion,MachineID,diroo;
  
  @FXML
  private JFXPasswordField passwordfield;
  
  @FXML
  private JFXButton loginbtn;
  
  HingeTransition pt4;
  
  Connection conn = null;
  
  ResultSet rs = null;
  
  PreparedStatement pst = null;
  
  @FXML
  void enternamekeypressed(KeyEvent event) {
    KeyCode keycode = event.getCode();
    if (keycode == KeyCode.ENTER)
      this.passwordfield.requestFocus(); 
  }
  
  @FXML
  void enterpasswordkeypressed(KeyEvent event) {
    KeyCode keycode = event.getCode();
    if (keycode == KeyCode.ENTER)
      this.loginbtn.fire(); 
  }
  
  
  
  
  
 @FXML
void loginbtnaction(ActionEvent event) {

    try {

        //////////////////////////////////////////////////////
        // التحقق من الحقول الفارغة
        //////////////////////////////////////////////////////

        if (namefield.getText().trim().isEmpty()) {

            showAlert(
                    "LogIn Error",
                    "Username Field is empty."
            );

            return;
        }

        if (passwordfield.getText().trim().isEmpty()) {

            showAlert(
                    "LogIn Error",
                    "Password Field is empty."
            );

            return;
        }

        if (positionbox.getSelectionModel().getSelectedItem() == null) {

            showAlert(
                    "LogIn Error",
                    "Please Select Position."
            );

            return;
        }

        //////////////////////////////////////////////////////
        // بيانات المستخدم
        //////////////////////////////////////////////////////

        String username =
                namefield.getText().trim();

        String password =
                passwordfield.getText();

        String position =
                positionbox.getSelectionModel()
                        .getSelectedItem()
                        .toString();

        //////////////////////////////////////////////////////
        // SQL
        //////////////////////////////////////////////////////

        String sql =
                "SELECT ID,Name,Password,TOTP_SECRET " +
                "FROM Users " +
                "WHERE Position=? AND Name=?";

        pst = conn.prepareStatement(sql);

        pst.setString(1, position);

        pst.setString(2, username);

        rs = pst.executeQuery();

        //////////////////////////////////////////////////////
        // المستخدم غير موجود
        //////////////////////////////////////////////////////

        if (!rs.next()) {

            showAlert(
                    "LogIn Error",
                    "Username Not Found."
            );

            clearFields();

            return;
        }

        //////////////////////////////////////////////////////
        // جلب Password Hash
        //////////////////////////////////////////////////////

        String storedHash =
                rs.getString("Password");

        //////////////////////////////////////////////////////
        // تنظيف الهاش
        //////////////////////////////////////////////////////

        if (storedHash != null) {

            storedHash = storedHash.trim();
        }

        //////////////////////////////////////////////////////
        // التأكد من وجود Hash
        //////////////////////////////////////////////////////

        if (storedHash == null ||
                storedHash.isEmpty()) {

            showAlert(
                    "HASH ERROR",
                    "Password Hash Is NULL Or Empty."
            );

            return;
        }

        //////////////////////////////////////////////////////
        // التأكد من طول الهاش
        //////////////////////////////////////////////////////

        if (storedHash.length() != 60) {

            showAlert(
                    "HASH LENGTH ERROR",
                    "BCrypt Hash Must Be 60 Characters."
            );

            return;
        }

        //////////////////////////////////////////////////////
        // التحقق من الباسورد
        //////////////////////////////////////////////////////

        boolean passwordCorrect =
                org.mindrot.jbcrypt.BCrypt
                        .checkpw(
                                password,
                                storedHash
                        );

        //////////////////////////////////////////////////////
        // الباسورد خطأ
        //////////////////////////////////////////////////////

        if (!passwordCorrect) {

            showAlert(
                    "LogIn Error",
                    "Password Incorrect."
            );

            clearFields();

            return;
        }

        //////////////////////////////////////////////////////
        // جلب Secret
        //////////////////////////////////////////////////////

        String secret =
                rs.getString("TOTP_SECRET");

        //////////////////////////////////////////////////////
        // تنظيف الـ Secret
        //////////////////////////////////////////////////////

        if (secret != null) {

            secret = secret.trim();
        }

        //////////////////////////////////////////////////////
        // التأكد من وجود Secret
        //////////////////////////////////////////////////////

        if (secret == null ||
                secret.isEmpty()) {

            showAlert(
                    "2FA ERROR",
                    "TOTP Secret Is Empty."
            );

            return;
        }

        //////////////////////////////////////////////////////
        // نافذة إدخال كود 2FA
        //////////////////////////////////////////////////////

        TextInputDialog dialog =
                new TextInputDialog();

        dialog.setTitle("2FA Authentication");

        dialog.setHeaderText(
                "Enter Authentication Code"
        );

        dialog.setContentText("Code:");

        //////////////////////////////////////////////////////
        // إضافة ثيم Cupertino
        //////////////////////////////////////////////////////

        DialogPane dialogPane =
                dialog.getDialogPane();

        dialogPane.getStylesheets().add(
                getClass()
                .getResource("cupertino-dark.css")
                .toExternalForm()
        );

        dialogPane.getStyleClass().add(
                "cupertino-dialog"
        );

        //////////////////////////////////////////////////////
        // أيقونة
        //////////////////////////////////////////////////////

        Stage stage =
                (Stage) dialogPane
                        .getScene()
                        .getWindow();

        stage.getIcons().add(
                new Image(
                        getClass()
                        .getResourceAsStream(
                                "kadysoft.png"
                        )
                )
        );

        //////////////////////////////////////////////////////
        // إظهار النافذة
        //////////////////////////////////////////////////////

        Optional<String> result =
                dialog.showAndWait();

        //////////////////////////////////////////////////////
        // المستخدم أغلق النافذة
        //////////////////////////////////////////////////////

        if (!result.isPresent()) {

            return;
        }

        //////////////////////////////////////////////////////
        // الكود المدخل
        //////////////////////////////////////////////////////

        String enteredCode =
                result.get().trim();

        //////////////////////////////////////////////////////
        // التحقق من كود 2FA
        //////////////////////////////////////////////////////

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

        //////////////////////////////////////////////////////
        // الكود خطأ
        //////////////////////////////////////////////////////

        if (!codeValid) {

            showAlert(
                    "2FA Error",
                    "Authentication Code Incorrect."
            );

            return;
        }

        //////////////////////////////////////////////////////
        // تسجيل Audit
        //////////////////////////////////////////////////////

        saveAudit(position);

        //////////////////////////////////////////////////////
        // فتح البرنامج
        //////////////////////////////////////////////////////

        openRecipeMaker();
    }

    //////////////////////////////////////////////////////
    // ERROR HANDLER
    //////////////////////////////////////////////////////

    catch (Exception e) {

        e.printStackTrace();

        String fullError =

                "ERROR TYPE:\n\n" +

                e.getClass().getName() +

                "\n\nMESSAGE:\n\n" +

                e.getMessage();

        showAlert(
                "SYSTEM ERROR",
                fullError
        );
    }

    //////////////////////////////////////////////////////
    // FINALLY
    //////////////////////////////////////////////////////

    finally {

        try {

            if (rs != null) {

                rs.close();
            }

            if (pst != null) {

                pst.close();
            }

        }

        catch (Exception ex) {

            showAlert(
                    "CLOSE ERROR",
                    ex.getMessage()
            );
        }
    }
}










private void showAlert(
        String title,
        String message
) {

    Alert alert =
            new Alert(Alert.AlertType.ERROR);

    //////////////////////////////////////////////////////
    // العنوان
    //////////////////////////////////////////////////////

    alert.setTitle(title);

    alert.setHeaderText(title);

    alert.setContentText(message);

    //////////////////////////////////////////////////////
    // الشكل
    //////////////////////////////////////////////////////

    alert.setResizable(true);

    DialogPane dialogPane =
            alert.getDialogPane();

    //////////////////////////////////////////////////////
    // ثيم Cupertino
    //////////////////////////////////////////////////////

    dialogPane.getStylesheets().add(
            getClass()
            .getResource("cupertino-light.css")
            .toExternalForm()
    );

    //////////////////////////////////////////////////////
    // تحسين الشكل
    //////////////////////////////////////////////////////

    dialogPane.setPrefWidth(420);

    dialogPane.setPrefHeight(220);

    dialogPane.getStyleClass().add(
            "cupertino-dialog"
    );

    //////////////////////////////////////////////////////
    // أيقونة
    //////////////////////////////////////////////////////

    Stage stage =
            (Stage) dialogPane
                    .getScene()
                    .getWindow();

    stage.getIcons().add(
            new Image(
                    getClass()
                    .getResourceAsStream(
                            "kadysoft.png"
                    )
            )
    );

    //////////////////////////////////////////////////////
    // إظهار
    //////////////////////////////////////////////////////

    alert.showAndWait();
}




private void clearFields() {

    namefield.clear();
    passwordfield.clear();
    namefield.requestFocus();
}


private void openRecipeMaker()
    throws Exception {
    Stage current =
            (Stage) loginbtn
                    .getScene()
                    .getWindow();
    current.close();
    Stage stg = new Stage();
    Parent root =
            FXMLLoader.load(
                    getClass().getResource(
                            "RecipeMaker_1.fxml"
                    )
            );
    Scene sce = new Scene(root);
    sce.getStylesheets()
            .add("table-cell-color-example.css");
    stg.setTitle(
            "Recipe Maker Controller"
    );
    stg.setScene(sce);
    stg.setMaximized(true);
    stg.getIcons().add(
            new Image(
                    Main.class.getResourceAsStream(
                            "washing.png"
                    )
            )
    );

    stg.show();
}
  
  
  
private void saveAudit(String user) {

    try {
        String machineID =
                getMachineSerial();
        String sql =
                "INSERT INTO Audit " +
                "(Date,User,PC_MAC,Status) " +
                "VALUES (?,?,?,?)";
        pst = conn.prepareStatement(sql);
        pst.setString(
                1,
                new SimpleDateFormat("dd/MM/yyyy")
                        .format(new Date())
        );
        pst.setString(2, user);
        pst.setString(3, machineID);
        pst.setString(
                4,
                user + " Logged In"
        );
        pst.execute();
    }

    catch (Exception e) {
        e.printStackTrace();
    }
}

  
 private String getMachineSerial() {

    try {
        String command =
                "wmic bios get serialnumber";
        Process process =
                Runtime.getRuntime()
                        .exec(command);
        BufferedReader reader =
                new BufferedReader(
                        new InputStreamReader(
                                process.getInputStream()
                        )
                );
        String line;
        StringBuilder output =
                new StringBuilder();
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
        }
        return output.toString()
                .replace("SerialNumber", "")
                .trim();
    }

    catch (Exception e) {
        return "UNKNOWN";
    }
} 




//  @FXML
//  void loginbtnaction(ActionEvent event) {
//      
//    if (this.namefield.getText().equals("")) {
//      Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
//      ImageView imgview = new ImageView();
//      imgview.setImage(img);
//      Notifications noti = Notifications.create();
//      noti.title("LogIn Error");
//      noti.text("Username Field is empty.");
//      noti.hideAfter(Duration.minutes(1.0D));
//      noti.graphic(imgview);
//      noti.position(Pos.CENTER);
//      noti.show();
//    } else if (this.passwordfield.getText().equals("")) {
//      Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
//      ImageView imgview = new ImageView();
//      imgview.setImage(img);
//      Notifications noti = Notifications.create();
//      noti.title("LogIn Error");
//      noti.text("Password Field is empty.");
//      noti.hideAfter(Duration.minutes(1.0D));
//      noti.graphic(imgview);
//      noti.position(Pos.CENTER);
//      noti.show();
//    } else {
//        
//        
//      String sql = "select ID,Position,Name,Password from Users Where (Position =? and Name =? and Password =?)";
//      try {
//        int count = 0;
//        this.pst = this.conn.prepareStatement(sql);
//        this.pst.setString(1, this.positionbox.getSelectionModel().getSelectedItem().toString());
//        this.pst.setString(2, this.namefield.getText());
//        this.pst.setString(3, this.passwordfield.getText());
//        this.rs = this.pst.executeQuery();
//        while (this.rs.next()) {
//          int id = this.rs.getInt(1);
//          count++;
//        } 
//        String access = this.positionbox.getSelectionModel().getSelectedItem().toString();
//        
//        if (access == "Recipe_Maker")
//          if (count == 1) {
//            Alert al = new Alert(Alert.AlertType.INFORMATION);
//            al.setTitle("Log In Information");
//            al.setHeaderText("LogIn Successful");
//            al.setContentText("Sucessful Login, Developed by Kadysoft Ltd.");
//            al.setResizable(false);
//            Stage jk = (Stage)this.loginbtn.getScene().getWindow();
//            jk.close();
//            Stage stg = new Stage();
//            Parent root = FXMLLoader.<Parent>load(getClass().getResource("RecipeMaker_1.fxml"));
//            Scene sce = new Scene(root);
//            sce.getStylesheets().add("table-cell-color-example.css");
//            stg.setTitle("Recipe Maker Controller For Production");
//            stg.centerOnScreen();
//            stg.setResizable(true);
//            stg.setMaximized(true);
//            stg.setScene(sce);
//            stg.centerOnScreen();
//            stg.getIcons().add(new Image(Main.class.getResourceAsStream("washing.png")));
//            stg.show();
//            jk.close();
//
//    ////////////////////////////////////Audit/////////////////////////////////////
//    Date currentDate = GregorianCalendar.getInstance().getTime();
//    DateFormat df = DateFormat.getDateInstance();
//    String dateString = df.format(currentDate);
//    Date d = new Date();
//    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//    String timeString = sdf.format(d);
//    String value1 = timeString;
//    ////////////////Machine ID////////////////
//          String batchcode="@echo off\n" +
//"for /f \"tokens=3\" %%a in ('reg query \"HKLM\\SOFTWARE\\Microsoft\\Windows NT\\CurrentVersion\" /v CurrentBuild') do (\n" +
//"    if %%a geq 22000 (\n" +
//"        echo Windows 11\n" +
//"    ) else (\n" +
//"        echo Windows 10\n" +
//"    )\n" +
//")\n" +
//"";
//          String pathofbat=System.getProperty("user.home")+"\\kadinio.bat";
//          File fafa=new File (pathofbat);
//          fafa.deleteOnExit();
//          PrintWriter paq=new PrintWriter (new FileWriter (fafa));
//          paq.println(batchcode);
//          paq.close();
//          
//            try {
//            ProcessBuilder processBuilder = new ProcessBuilder(pathofbat);
//            Process process = processBuilder.start();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
//            String line;
//            while ((line = reader.readLine()) != null) {
//            //System.out.println(line);
//            windowsversion=line;
//            }
//            int exitCode = process.waitFor();
//            //System.out.println("Batch file executed with exit code: " + exitCode);
//            } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//            }
// 
//            if (windowsversion.equals("Windows 10")) {
//                
//                //Windows10
//                
//              String command="wmic bios get serialnumber";
//              StringBuffer output=new StringBuffer();
//                  Process SerNumProcess=Runtime.getRuntime().exec(command);
//                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
//                   String linee="";
//                   while ((linee=sNumReader.readLine())!=null) {
//                   output.append(linee+"\n");
//                   }
//                   MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
//
//            }
//            
//            else if (windowsversion.equals("Windows 11")) {
//                
//                //Windows11
//                
//              String command="powershell Get-CimInstance -ClassName Win32_BIOS | Select-Object SerialNumber";
//              StringBuffer output=new StringBuffer();
//                  Process SerNumProcess=Runtime.getRuntime().exec(command);
//                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
//                   String linee="";
//                   while ((linee=sNumReader.readLine())!=null) {
//                   output.append(linee+"\n");
//                   }
//                   MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim().replace("SerialNumber","").replace("------------","").replace("\n","");
//
//            }
//            
//            else {
//                
//                //Windows7 or less like windows 10
//                
//              String command="wmic bios get serialnumber";
//              StringBuffer output=new StringBuffer();
//                  Process SerNumProcess=Runtime.getRuntime().exec(command);
//                   BufferedReader  sNumReader=new BufferedReader(new InputStreamReader(SerNumProcess.getInputStream()));
//                   String linee="";
//                   while ((linee=sNumReader.readLine())!=null) {
//                   output.append(linee+"\n");
//                   }
//                   MachineID=output.toString().substring(output.indexOf("\n"),output.length()).trim();
//
//            }
//
//          try {
//          String sqla = "insert into Audit (Date,User,PC_MAC,Status) values (?,?,?,?) ";
//          this.pst = this.conn.prepareStatement(sqla);
//          this.pst.setString(1, value1);
//          this.pst.setString(2, "Recipe_Maker");
//          this.pst.setString(3, MachineID);
//          this.pst.setString(4, "Recipe_Maker Logged In");
//          this.pst.execute();
//              }
//              catch (Exception e) {
//        } finally {
//          try {
//            this.rs.close();
//            this.pst.close();
//          } catch (Exception exception) {}
//        }  
//
//          } else if (count > 1) {
//            Alert al = new Alert(Alert.AlertType.ERROR);
//            al.setTitle("Log In Information");
//            al.setHeaderText("LogIn Error");
//            al.setContentText("Duplicate Username or Password Access denied");
//            al.setResizable(false);
//            al.showAndWait();
//          } else {
//            Image img = new Image(getClass().getResourceAsStream("kadysoft.png"));
//            ImageView imgview = new ImageView();
//            imgview.setImage(img);
//            Notifications noti = Notifications.create();
//            noti.title("LogIn Error");
//            noti.text("Username and Password aren't correct.");
//            noti.hideAfter(Duration.minutes(1.0D));
//            noti.graphic(imgview);
//            noti.position(Pos.CENTER);
//            noti.show();
//            this.namefield.setText("");
//            this.passwordfield.setText("");
//            this.namefield.requestFocus();
//          }  
//      } catch (Exception e) {
//        JOptionPane.showMessageDialog(null, e);
//      } finally {
//        try {
//          this.rs.close();
//          this.pst.close();
//        } catch (Exception exception) {}
//      }
//
//    }}
  
  
  
  
  
  
  
  
  
    @FXML
  
  void settoaction (MouseEvent ds) throws IOException {

      //Alert for password

      JFXPasswordField fss=new JFXPasswordField ();
      fss.setPromptText("Write Admin Password For Settings ...");
      fss.setMinSize(300, 30);
      fss.setLabelFloat(true);
      fss.setStyle("-fx-font-weight:bold;");
      fss.setEditable(true);
      Alert alerto = new Alert(Alert.AlertType.WARNING);
      alerto.setTitle("Admin Password");
      alerto.setHeaderText("Please be careful, this info is important.");
      alerto.setContentText("Hello, Please tell me: Password?.");
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
              
              //////////Code Here.......
              
              if (passy.equals("KS710")) {
                  
              Notifications noti = Notifications.create();
              noti.title("Great!");
              noti.text("Admin Opened.");
              noti.position(Pos.CENTER);
              noti.hideAfter(Duration.seconds(3));
              noti.showInformation();
         
    Stage stg = new Stage();//CreateNewUser
    Parent root = FXMLLoader.<Parent>load(getClass().getResource("Settings.fxml"));
    Scene sce = new Scene(root);
    stg.setTitle("Settings");
    stg.centerOnScreen();
    stg.setResizable(true);
    stg.setScene(sce);
    stg.setMaximized(true);
    stg.getIcons().add(new Image(Main.class.getResourceAsStream("washing.png")));
    stg.show();
    Stage jk = (Stage)this.loginbtn.getScene().getWindow();
    jk.setIconified(true);   
              }
              
              else {
              Notifications noti = Notifications.create();
              noti.title("Fatal Error!");
              noti.text("We Can't continue, Password is incorrect.");
              noti.position(Pos.CENTER);
              noti.hideAfter(Duration.seconds(3));
              noti.showError();
              }
              
              
          }
           
    }
      
      else if (optiono.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {}
   
  }

  public void initialize(URL url, ResourceBundle rb) {
      
            try {
            String path = Main.class.getProtectionDomain()
            .getCodeSource().getLocation().toURI().getPath();
            String decodedPath = URLDecoder.decode(path, StandardCharsets.UTF_8.name());
            File file = new File(decodedPath);
            String dir = file.isFile() ? file.getParent() : file.getPath();
            diroo=dir;
            if (dir.length() > 2 && dir.charAt(1) == ':') {
                String driveLetter = dir.substring(0, 2);  
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
      
      String fileURL = "https://raw.githubusercontent.com/ProgKady/Receta_Settings_Libs/master/setto.cfg";
      String saveDir = diroo+"\\lib";
      downloadFile(fileURL, saveDir);
      namefield.requestFocus();

    Toolkit tool = Toolkit.getDefaultToolkit();
    tool.setLockingKeyState(20, true); 
    this.positionbox.getItems().addAll(new Object[] { "Recipe_Maker" }); // For Me Only.
    //this.positionbox.getItems().addAll(new Object[] { "Recipe_Maker", "Developer", "Viewer" }); // For Me Only.
    //this.positionbox.getItems().addAll(new Object[] { "Developer", "Admin", "Recipe_Maker", "Viewer" }); // For Me Only.
    //this.positionbox.getItems().addAll(new Object[] { "Recipe_Maker", "Viewer" }); // For Anyone.
    //this.positionbox.getItems().addAll(new Object[] { "Viewer" }); // For BARCODE.
    //this.positionbox.getItems().addAll(new Object[] { "Admin" }); // For MR MOHAMED.
    this.positionbox.getSelectionModel().select(0);
    this.conn = db.java_db();
    this.namefield.requestFocus(); 
  }
  

  private static void downloadFile(String fileURL, String saveDir) {
        try {
            URL url = new URL(fileURL);
            URLConnection connection = url.openConnection();
            // إنشاء الفولدر لو مش موجود
            File directory = new File(saveDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }
            String fileName = fileURL.substring(fileURL.lastIndexOf("/") + 1);
            File outputFile = new File(directory, fileName);
            try (InputStream in = connection.getInputStream();
                 FileOutputStream out = new FileOutputStream(outputFile)) {
                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }
            System.out.println("تم تحميل الملف بنجاح:");
            System.out.println(outputFile.getAbsolutePath());
        } catch (Exception e) {
            System.err.println("حدث خطأ أثناء التحميل");
            e.printStackTrace();
        }
    }

  
}