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
public class FixMultipleController implements Initializable {

    
    
    @FXML
    private JFXTextArea list,rora;

    @FXML
    private Text text;
    
    
    @FXML
    private JFXButton fix;
    
    
    
//    public static int levenshteinDistance(String a, String b) {
//    int[][] dp = new int[a.length() + 1][b.length() + 1];
//
//    for (int i = 0; i <= a.length(); i++) {
//        for (int j = 0; j <= b.length(); j++) {
//            if (i == 0) {
//                dp[i][j] = j;
//            } else if (j == 0) {
//                dp[i][j] = i;
//            } else {
//                dp[i][j] = Math.min(
//                    Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1),
//                    dp[i - 1][j - 1] + (a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1)
//                );
//            }
//        }
//    }
//    return dp[a.length()][b.length()];
//}
    
    @FXML
    void fixaction(ActionEvent event) throws FileNotFoundException, IOException{

 
        String[] filess=list.getText().split("\n");
        
        for (String namo :filess) {
            
         rora.clear();
    
    InputStream inputinstream=new FileInputStream(namo);
    BufferedReader bufy=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    
    //BufferedReader bufy=new BufferedReader (new FileReader (pathy));
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
//      Notifications noti = Notifications.create();
//      noti.title("Recipe Error");
//      noti.text("Maybe not a recipe, Open a recipe first!.");
//      noti.hideAfter(Duration.seconds(3));
//      noti.position(Pos.CENTER);
//      noti.showError();    
        }
        else {
            org.jsoup.nodes.Document doc = Jsoup.parse(code);
        for (Element table : doc.select("TABLE")) {
        for (Element row : table.select("TR")) {
            Elements tds = row.select("TD");
            if (tds.get(7).text().isEmpty()) {   
            }
            else {  
             ///////////////////////////////////////////////////////////////
String string=tds.get(7).text();
BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Chemical_Dictionary.kady"));
String line;
String linebeforeequal;
String lineafterequal;
while ((line=buf.readLine())!=null) {
linebeforeequal=line.substring(0,line.indexOf("=")-0);
lineafterequal=line.substring(line.indexOf("=") + 1 , line.length());
if (string.equals(lineafterequal)) {
//System.out.println(string+" = "+linebeforeequal);
String formattedText = "<b style='display:block; text-align:center;'>" + linebeforeequal + "</b>";
tds.get(8).html(formattedText); // Use .html() instead of .text()                            
//tds.get(8).text(linebeforeequal);
//System.out.println(tds.get(8).text());
break;

    }
    else {
        
    }
    
}
buf.close();

             ///////////////////////////////////////////////////////////////
               
            }   
         
         
        }}
       rora.setText(doc.toString());
        }
        


//
//String code = rora.getText();
//    
//    if (!code.contains("TABLE")) {
////        Notifications noti = Notifications.create();
////        noti.title("Recipe Error");
////        noti.text("Maybe not a recipe, Open a recipe first!.");
////        noti.hideAfter(Duration.seconds(3));
////        noti.position(Pos.CENTER);
////        noti.showError();
//    } else {
//        org.jsoup.nodes.Document doc = Jsoup.parse(code);
//
//        for (Element table : doc.select("TABLE")) {
//            for (Element row : table.select("TR")) {
//                Elements tds = row.select("TD");
//
//                if (!tds.get(7).text().isEmpty()) {
//                    String string = tds.get(7).text();
//                    BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirrrr + "\\Recipe_Indexes\\Chemical_Dictionary.kady"));
//                    String line;
//                    String linebeforeequal = null;
//                    String lineafterequal;
//                    String bestMatch = null;
//                    int minDistance = Integer.MAX_VALUE; // أقرب تشابه
//
//                    while ((line = buf.readLine()) != null) {
//                        linebeforeequal = line.substring(0, line.indexOf("="));
//                        lineafterequal = line.substring(line.indexOf("=") + 1);
//
//                        if (string.equalsIgnoreCase(lineafterequal)) {
//                            bestMatch = linebeforeequal;
//                            break;
//                        } else {
//                            int distance = levenshteinDistance(string, lineafterequal);
//                            if (distance < minDistance) {
//                                minDistance = distance;
//                                bestMatch = linebeforeequal;
//                            }
//                        }
//                    }
//                    buf.close();
//
//                    if (bestMatch != null) {
//                        String formattedText = "<b style='display:block; text-align:center;'>" + bestMatch + "</b>";
//                        tds.get(8).html(formattedText);
//                    }
//                }
//            }
//        }
//        rora.setText(doc.toString());
//    }



//    ////////////////////////////////////////////////////////////////////////////    
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
      noti.text("We updated everything successfully!.\nRecipe will open now.");
      noti.hideAfter(Duration.seconds(5));
      noti.position(Pos.CENTER);
      noti.showInformation();
          
                
                
        }
    
        list.clear();
        
        
        
        
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
