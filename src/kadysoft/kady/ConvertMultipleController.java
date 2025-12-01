package kadysoft.kady;



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import java.awt.Desktop;
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
import java.math.BigDecimal;
import java.net.URL;
import java.nio.file.Files;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class ConvertMultipleController implements Initializable {

    
    
    @FXML
    private JFXTextArea list,rora;
    @FXML
    private Text text;
    @FXML
    private JFXButton fix;
    
  
  
  public static String find,oldtotalcost,oldpcs,oldonegarmentcost;

  
    
  @FXML
void fixaction(ActionEvent event) {
    
    
    String[] filess = list.getText().split("\n");

    for (String filePath : filess) {
        if (filePath.trim().isEmpty()) continue;

        File originalFile = new File(filePath);
        if (!originalFile.exists()) continue;

        String fileName = originalFile.getName();
        String parentDir = originalFile.getParent();

        // Remove .ks or .html from name
        String baseName = fileName.replaceFirst("\\.ks$", "").replaceFirst("\\.html$", "");

        // Create new .xls file in same path
        File xlsFile = new File(parentDir, baseName + ".xls");

        try {
            String content = new String(Files.readAllBytes(originalFile.toPath()), "UTF-8");

            try (PrintWriter out = new PrintWriter(xlsFile, "UTF-8")) {
                out.println(content);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Clear the list and show confirmation text
    list.clear();
    text.setVisible(true);
    
    Notifications noti = Notifications.create();
      noti.title("Successful");
      noti.text("Successful Converting!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showInformation();
    
    
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
