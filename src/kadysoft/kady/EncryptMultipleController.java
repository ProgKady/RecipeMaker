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
public class EncryptMultipleController implements Initializable {

    
    
    @FXML
    private JFXTextArea list,rora;

    @FXML
    private Text text;
    
    
    @FXML
    private JFXButton fix;
    
    
    
    @FXML
    void fixaction(ActionEvent event) throws FileNotFoundException, IOException{

 
        String[] filess=list.getText().split("\n");
        for (String namo :filess) {
            
            rora.clear();
    InputStream inputinstream=new FileInputStream(namo);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));       
    String lo;
    while ((lo = bi.readLine()) != null) {
    if (lo.contains("data:image") || lo.contains("base64,")) {
        rora.appendText("\n" + lo);
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
    rora.appendText("\n" + converted);
}
    bi.close();
    String gf=rora.getText();
    OutputStream instreamm=new FileOutputStream(namo);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
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
