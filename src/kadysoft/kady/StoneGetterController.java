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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
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
public class StoneGetterController implements Initializable {

    
    
    @FXML
    private JFXTextArea list,rora;

    @FXML
    private Text text;
    
    
    @FXML
    private JFXButton fix;
    
    Connection conn = null;
  
  ResultSet rs = null;
  
  PreparedStatement pst = null;
  
   public static String stonny,finall;
   public static double sto,sumz,ally;
     
      
      
    
    
    
    @FXML
    void fixaction(ActionEvent event) throws FileNotFoundException, IOException{
        


 
        String[] filess=list.getText().split("\n");
        for (String namo :filess) {
            
            
            
                    
sumz=0.0;
ally=0.0;
            
      String[] pathParts = namo.split("\\\\");   
      String recipenami=pathParts[5].replaceAll(".ks", "").replaceAll(".html", "");
      String dirpathe = namo;
      String modelooo=pathParts[4];
            
                  try {
                      
                      
    rora.clear();
    InputStream inputinstream=new FileInputStream(dirpathe);
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
        }catch (Exception g) {}
        //////////////////////////////////////////////

             

                            org.jsoup.nodes.Document docy = Jsoup.parse(rora.getText());
                            for (Element table : docy.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            
                            
                            if (tds.get(7).text().contains("new stone")||tds.get(7).text().contains("New Stone")||tds.get(7).text().contains("NEW STONE")||tds.get(7).text().contains("NEW STON")||tds.get(7).text().contains("new ston")||tds.get(7).text().contains("now ston")||tds.get(7).text().contains("now stone")||tds.get(7).text().contains("NOW STON")||tds.get(7).text().contains("NOW STONE")) {
                                
                                 
                                stonny=tds.get(5).text().toString();
                                sto=Double.parseDouble(stonny);
                                sumz=sumz+sto;
                                
                            }
                            
                             else {
                               
                                sumz=sumz;
                                
                            }
                            
                            ally=(sumz/2)*25;
                            finall=Double.toString(ally);
                            
                           }}
                       
                            
    // Save To DB Here
    Date currentDate1 = GregorianCalendar.getInstance().getTime();
    DateFormat df1 = DateFormat.getDateInstance();
    String dateString1 = df1.format(currentDate1);
    Date d1 = new Date();
    SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
    String timeString1 = sdf1.format(d1);
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    String dateString2 = sdf2.format(d1);

    String fann = "";
    
    try {
        String sql0 = "select * from GetterStone where Name = ? and Model = ?";
        pst = conn.prepareStatement(sql0);
        pst.setString(1, recipenami);
        pst.setString(2, modelooo);
        rs = pst.executeQuery();                    
        
        if (rs.next()) {                        
            fann = "found";   
        } else {
            fann = "not_found";   
        }
        
    } catch (Exception exception) {
        exception.printStackTrace(); // Handle exceptions properly
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();     
        } catch (Exception exception) {
            exception.printStackTrace(); // Handle exceptions properly
        }
    }
    
    

    if (fann.equals("found")) {
        try {
            String sqlp = "update GetterStone set Date = ?, Model = ?, Name = ?, Stone = ? where Name = ? and Model = ?";
            pst = conn.prepareStatement(sqlp);
            pst.setString(1, dateString2);
            pst.setString(2, modelooo);
            pst.setString(3, recipenami);
            pst.setString(4, finall);
            pst.setString(5, recipenami); // WHERE clause parameters
            pst.setString(6, modelooo);
            pst.execute();
            
            Notifications noti = Notifications.create();
            noti.title("Successful");
            noti.text("We have updated the stone successfully.");
            noti.hideAfter(Duration.seconds(3));
            noti.position(Pos.CENTER);
            noti.showInformation();
            
        } catch (Exception exception) {
            exception.printStackTrace(); // Handle exceptions properly
        } finally {
            try {
                if (pst != null) pst.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    } else if (fann.equals("not_found")) {
        try {                            
            String reg = "insert into GetterStone (Date, Model, Name, Stone) values (?, ?, ?, ?)";
            pst = conn.prepareStatement(reg);
            pst.setString(1, dateString2);
            pst.setString(2, modelooo);
            pst.setString(3, recipenami);
            pst.setString(4, finall);
            pst.execute(); 
            
            Notifications noti = Notifications.create();
            noti.title("Successful");
            noti.text("We have inserted the new stone successfully.");
            noti.hideAfter(Duration.seconds(3));
            noti.position(Pos.CENTER);
            noti.showInformation();
            
        } catch (Exception exception) {
            exception.printStackTrace(); // Handle exceptions properly
        } finally {
            try {
                if (pst != null) pst.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
//}
      
            
        //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    
            
            
        }
        
        
        list.clear();
        text.setVisible(true);
            
        
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
        
        this.conn = db.java_db();
    }    
    
}
