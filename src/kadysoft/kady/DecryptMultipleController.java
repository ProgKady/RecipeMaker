
package kadysoft.kady;



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Text;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class DecryptMultipleController implements Initializable {

    
    
    @FXML
    private JFXTextArea list,rora;

    @FXML
    private Text text;
    
    
    @FXML
    private JFXButton fix;
    
    
    
    @FXML
    void fixaction(ActionEvent event) throws FileNotFoundException, IOException, Exception{

 
        String[] filess=list.getText().split("\n");
        for (String namo :filess) {
            
            
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
    if (namo == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = namo;
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
            
            
            rora.clear();
    InputStream inputinstream=new FileInputStream(namo);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));       
    String lo;
    while ((lo=bi.readLine())!=null) {
        
        rora.appendText("\n"+lo
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
    String gf=rora.getText();
    OutputStream instreamm=new FileOutputStream(namo);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    pw.println(gf);
    pw.close();
    Notifications noti = Notifications.create();
    noti.title("Successful");
    noti.text("We have decrypted the recipe successfully.");
    noti.hideAfter(Duration.seconds(3));
    noti.position(Pos.CENTER);
    noti.showInformation();
    rora.clear();
  
            
        }
        
        
      list.clear(); 
      text.setVisible(true);
      

      
      Git.gitCommands();
      
        
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
