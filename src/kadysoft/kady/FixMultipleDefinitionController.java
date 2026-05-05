package kadysoft.kady;



import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXTextArea;
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
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Locale;
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
import javafx.scene.input.DragEvent;
import javafx.scene.input.TransferMode;
import javafx.scene.text.Text;
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
public class FixMultipleDefinitionController implements Initializable {

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
    BufferedReader bufy=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    String liin;
    while ((liin=bufy.readLine())!=null) {
        rora.appendText(liin.replace("ﬦ","A")
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
       .replace("&NBSP;","") +"\n");
    }
    bufy.close();
    String code = rora.getText();
    
      if (!code.contains("TABLE")) {  
        }
      
      
        else {
            org.jsoup.nodes.Document doc = Jsoup.parse(code,"UTF-8");
        for (Element table : doc.select("TABLE")) {
            
            // Apply dotted border style to the table
                table.attr("style", "border-collapse: collapse; border: 1px dotted black;");
                // Select all rows
                Elements rows = table.select("tr");
                for (Element row : rows) {
                    Elements cells = row.select("td, th");
                    for (Element cell : cells) {
                        // Apply dotted border style to each cell
                        String existingStyle = cell.attr("style");
                        cell.attr("style", existingStyle + "border:1px dotted black; padding:4px;");
                        // Check text for highlighting
                        String text = cell.text().trim().toLowerCase();
                        if (text.equals("chemical lot number")|| text.equals("chemicals lot number")|| text.equals("chemicals lot numbers") || text.contains("lot")) {
                            cell.attr("style", cell.attr("style") + " background-color:yellow;");
                        }
                    }
                    if (!cells.isEmpty()) {
                        // Get last cell (before the one we add)
                        Element lastCell = cells.get(cells.size() - 2);
                        String text = lastCell.text().trim();
                        
                        // Create new cell
                        Element newCell = row.appendElement("td");
                        // Apply dotted border style
                        newCell.attr("style", "border:1px dotted black; padding:4px;");
                        // Fill new cell based on last cell
                        if (text.isEmpty()) { 
                           newCell.text(""); // leave empty
                        }
     else {
    ///////////////////////////////////////////////////////////////
    String string = (text == null ? "" : text.trim()).replace("\uFEFF", ""); // sanitize input

    Path mapPath = Paths.get(NewDir.file_dirrrr, "Recipe_Indexes", "Chemical_Translation.kady");
    boolean found = false;

    try (BufferedReader buf = Files.newBufferedReader(mapPath, StandardCharsets.UTF_8)) {
        String line;
        while ((line = buf.readLine()) != null) {
            if (line.trim().isEmpty()) continue;               // skip empty lines
            line = line.replace("\uFEFF", "").trim();         // remove BOM + trim

            int eq = line.indexOf('=');
            if (eq < 0) continue;                             // skip malformed lines

            String linebeforeequal = line.substring(0, eq).trim();
            String lineafterequal  = line.substring(eq + 1).trim();

            // match mapping key (case-insensitive)
            if (linebeforeequal.equalsIgnoreCase(string)) {
                // put translated text into the new cell
                newCell.text(lineafterequal);
                newCell.attr("style", newCell.attr("style") + " text-align:center; font-weight:bold;");

                // check BOTH the key and the translated value for LOT/CHEMICAL keywords
                String keyUp = linebeforeequal.toUpperCase(Locale.ROOT);
                String valUp = lineafterequal.toUpperCase(Locale.ROOT);

                if ( keyUp.contains("LOT") || keyUp.contains("CHEMICAL")
                  || valUp.contains("LOT") || valUp.contains("CHEMICAL")
                  || valUp.equals("CHEMICAL LOT NUMBER")
                  || valUp.equals("CHEMICALS LOT NUMBER")
                  || valUp.equals("CHEMICALS LOT NUMBERS")
                  || valUp.equals("CHEMICAL LOT NUMBERS") ) {

                    // overwrite with the fixed text and highlight the SAME cell
                    newCell.text("CHEMICAL DEFINITIONS");
                    newCell.attr("style", newCell.attr("style") + " background-color:yellow;");
                }

                found = true;
                break;
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    // if not found in mapping file, but the original text itself has "lot"/"chemical"
    if (!found) {
        String sUp = string.toUpperCase(Locale.ROOT);
        if (sUp.contains("LOT") || sUp.contains("CHEMICAL")) {
            newCell.text("CHEMICAL DEFINITIONS");
            newCell.attr("style", newCell.attr("style") + " background-color:yellow; text-align:center; font-weight:bold;");
        } else {
            // fallback: leave empty or keep original behavior
            newCell.text("");
        }
    }
    ///////////////////////////////////////////////////////////////
}

  
                        // Highlight if matches condition
                        String newText = newCell.text().toLowerCase();
                        if (newText.equals("chemical") || newText.contains("lot")) {
                            newCell.attr("style", newCell.attr("style") + " background-color:yellow;");
                        }
                    }
                } 
        }
        rora.setText(doc.toString());
      }
    ////////////////////////////////////////////////////////////////////////////    
    String newrecipecode=rora.getText();
    OutputStream instreamm=new FileOutputStream(namo);
    PrintWriter pwwc = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    //PrintWriter pwwc=new PrintWriter (new FileWriter (pathy));
    pwwc.println(newrecipecode.replace("A","ﬦ")
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
       .replace("z","ףּ"));
      pwwc.close();
      Notifications noti = Notifications.create();
      noti.title("Successful Operation");
      noti.text("We translated everything successfully!.");
      noti.hideAfter(Duration.seconds(5));
      noti.position(Pos.CENTER);
      noti.showInformation();     
        }
        list.clear(); 
        
        
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
