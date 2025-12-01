

package kadysoft.kady;

import com.jfoenix.controls.JFXTextArea;
import io.github.palexdev.materialfx.controls.MFXButton;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class BlockController implements Initializable {

   
    
    
    
     @FXML
    private ComboBox<String> user;

    @FXML
    private MFXButton blockbtn;
    
    @FXML
    private JFXTextArea myarea;

    
    
    
    @FXML
    void blockbtnaction(ActionEvent event) throws IOException {

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
        
        String ssyes=user.getSelectionModel().getSelectedItem().toString()+"="+"YES";
        String ssno=user.getSelectionModel().getSelectedItem().toString()+"="+"NO";
        
        String texttg=myarea.getText().replace(ssno,ssyes);
        PrintWriter pwg=new PrintWriter(new FileWriter (NewDir.file_dirr + "\\Cont.kady"));
        pwg.print(texttg);
        pwg.close();
        
        
        user.getSelectionModel().clearSelection();
        myarea.clear();
        
      //Noti
        
      Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("Successful Blocking!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showInformation();
        
      //////////////////////////////////////////////////////////////////////////////////////////////////////
        
        
    }
    

    
    
    
    @FXML
    void useraction(Event event) {

          user.getItems().clear();
         try {
             BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Users.kady"));
             String line;
             while ((line = buf.readLine()) != null) {
             user.getItems().addAll(new String[] { line });
          } 
          buf.close();
          } catch (FileNotFoundException fileNotFoundException) {
    
          } catch (IOException iOException) {}
        
        
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
        
        
        
        
    }    
    
}
