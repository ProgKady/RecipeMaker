
package kadysoft.kady;
import com.jfoenix.controls.JFXButton;
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
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;



/**
 * FXML Controller class
 *
 * @author KADY
 */


public class EncryptController implements Initializable {

   
    @FXML
    private JFXButton decrypt;

    @FXML
    private JFXTextField recipe;
    
    @FXML
    private JFXTextField filename;

    @FXML
    private TextArea area;

    @FXML
    private JFXTextField destination;

    @FXML
    void decryptaction(ActionEvent event) throws IOException {

        String recipepath=recipe.getText();
        //String destinationpath=destination.getText();
        //String filoname=filename.getText();
        
        
        File oldFile = new File(recipepath);
        String parentDir = oldFile.getParent();
        String fileNameWithoutExtension = oldFile.getName().substring(0, oldFile.getName().lastIndexOf('.'));
        String newFileName = fileNameWithoutExtension + ".kadysoft";
        File newFile = new File(parentDir, newFileName);
        boolean success = oldFile.renameTo(newFile);
        if (success) {
        Notifications noti = Notifications.create();
        noti.title("Sccessful!");
        noti.text("File Encrypted successfully.");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(3));
        noti.showInformation();
        } else {
        
      Notifications noti = Notifications.create();
      noti.title("Fatal Error!");
      noti.text("Failed to encrypt file.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showError();
        }
        
        
        
//        //Reading only
//        
//      try {
//      InputStream inputinstream=new FileInputStream(recipepath);
//      BufferedReader buf=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
//      String line;
//      while ((line = buf.readLine()) != null) {
//        area.appendText(line);
//      } 
//      buf.close();
//    } 
//    catch (FileNotFoundException fileNotFoundException) {
//    
//    }
//      
//      //GetText
//      
//      String newcode=area.getText();
//      
//      OutputStream instream=new FileOutputStream(destinationpath+"\\"+filoname+".kadysoft");
//      PrintWriter pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
//      pw.println(newcode);
//      pw.close();
//      
//      //Delete Kadysoft File
//      
//      File del=new File (recipepath);
//      del.delete();
//      
//    //  Desktop desk = Desktop.getDesktop();
//    //  desk.open(new File(destinationpath+"\\"+filoname+".html"));



      Stage jk = (Stage)this.area.getScene().getWindow();
      jk.close();
        
    }
    
    @FXML
    void desaction(MouseEvent event) {

//    destination.clear();
//    DirectoryChooser dialog = new DirectoryChooser();
//    dialog.setInitialDirectory(new File (NewDir.file_dir));
//    dialog.setTitle("Kadysoft Ltd.");
//    File dialogResult = dialog.showDialog(null);
//    String filePath = dialogResult.getAbsolutePath().toString();
//    destination.setText(filePath);
        
    }

    @FXML
    void recaction(MouseEvent event) {
    
    recipe.clear();
    FileChooser dialog = new FileChooser();
    dialog.setInitialDirectory(new File (NewDir.file_dir));
    //dialog.setInitialFileName("Kadysoft Ltd.");
    dialog.setTitle("Kadysoft Ltd.");
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
    File dialogResult = dialog.showOpenDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();
    recipe.setText(filePath);
    //String filenamee= dialogResult.getName().replace(".ks","").replace(".html","");
    //filename.setText(filenamee);
    
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        
        
        
    }    
    
}
