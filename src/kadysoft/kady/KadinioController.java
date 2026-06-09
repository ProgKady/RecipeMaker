
package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.stage.DirectoryChooser;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class KadinioController implements Initializable {


    @FXML
    private JFXButton browse,delete;

    @FXML
    private JFXTextField path;

    @FXML
    private JFXListView<String> list,list1;

    @FXML
    private JFXCheckBox addall;

    @FXML
    private JFXTextField command;

    @FXML
    private JFXButton execute;
    
    public static File commandpath,f1;
    
     @FXML
    private JFXTextField fullpath;

    @FXML
    private JFXTextArea batch;

    
    
    
    @FXML
    void browseaction(ActionEvent event) {

        DirectoryChooser dc=new DirectoryChooser ();
        File filo=dc.showDialog(null);
        String pathh=filo.getAbsolutePath();
        path.setText(pathh);
        list.getItems().clear();
        list1.getItems().clear();
        
        f1=new File (pathh+"\\PCs");
        File filsy[]=f1.listFiles();
        if (filsy != null) {
        for (File file : filsy) {
            if (file.getName().equals("ADD HERE PCS NAMES FOR INSTALLING.txt") || file.getName().equals("REPLACE ME WITH PC NAME.kady")) {}
            else {
                list.getItems().add(file.getName());
            }
          }
        }
        
        commandpath=new File (pathh+"\\Java\\bin");
        File filsy2[]=commandpath.listFiles();
        if (filsy2 != null) {
        for (File file : filsy2) {
            if (file.getName().endsWith(".cod")) {
                list1.getItems().add(file.getAbsolutePath());
            }
          }
        }
 
    }

    
    
    
    @FXML
    void executeaction(ActionEvent event) throws IOException {

        String commando=command.getText().toLowerCase();
        
        if (addall.isSelected()) {
            
            //Take All
            int i=0;
            list.getSelectionModel().select(i);
            while (i<list.getItems().size()) {
                list.getSelectionModel().select(i);
                String itemtoadd=list.getSelectionModel().getSelectedItem().toString().replace(".kady","");
                File filetoadd=new File (commandpath+"\\"+itemtoadd+"_"+commando+".cod");
                if (!filetoadd.exists()) {
                filetoadd.createNewFile();
                if (commando.isEmpty()) {
                    PrintWriter pw=new PrintWriter (new FileWriter (filetoadd));
                    pw.print(batch.getText());
                    pw.close();
                }
                if (commando.equals("cftsp")) {
                    String fullpathth=fullpath.getText();
                    String bigvommand=batch.getText();
                    PrintWriter pw=new PrintWriter (new FileWriter (filetoadd));
                    pw.println(fullpathth);
                    pw.print(bigvommand);
                    pw.close();
                }
                }
                i++;
            }
            
            
        }
        
        else {
            
            //Take Selected From List
            String itemtoadd=list.getSelectionModel().getSelectedItem().toString().replace(".kady","");
            list.getSelectionModel().clearSelection();
            File filetoadd=new File (commandpath+"\\"+itemtoadd+"_"+commando+".cod");
            if (!filetoadd.exists()) {
                filetoadd.createNewFile();
                if (commando.isEmpty()) {
                    PrintWriter pw=new PrintWriter (new FileWriter (filetoadd));
                    pw.print(batch.getText());
                    pw.close();
                }
                if (commando.equals("cftsp")) {
                    String fullpathth=fullpath.getText();
                    String bigvommand=batch.getText();
                    PrintWriter pw=new PrintWriter (new FileWriter (filetoadd));
                    pw.println(fullpathth);
                    pw.print(bigvommand);
                    pw.close();
                }
                
                return;
            }
            
        }
        
        
    }
    
    
    @FXML
    void deleteaction(ActionEvent event) {
        
        String itemtodelete=list1.getSelectionModel().getSelectedItem().toString();
        File filetodelete=new File (itemtodelete);
        filetodelete.delete();
        //Refresh Items
        list1.getItems().clear();
        commandpath=new File (path.getText()+"\\Java\\bin");
        File filsy2[]=commandpath.listFiles();
        if (filsy2 != null) {
        for (File file : filsy2) {
            if (file.getName().endsWith(".cod")) {
                list1.getItems().add(file.getAbsolutePath());
            }
          }
        }
        
    }
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        
    }    
    
}
