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
public class TypeMultipleController implements Initializable {

    
    
    @FXML
    private JFXTextArea list,rora;

    @FXML
    private Text text;
    
    
    @FXML
    private JFXButton fix;
    
    Connection conn = null;
  
  ResultSet rs = null;
  
  PreparedStatement pst = null;
  
  
   public static String stonn;
      public static String fomm;
      public static String hypoo;
      public static String enzymm;
      public static String moonn;
      public static String dryr11;
      public static String dryr22;
      public static String dryr33;
    
    
    
    @FXML
    void fixaction(ActionEvent event) throws FileNotFoundException, IOException{
        
        

 
        String[] filess=list.getText().split("\n");
        for (String namo :filess) {
            
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

                            
        
       String proco=null;
       int bathnumzzzz=0;
       String moduu,commentt;
       
       String ston,fom,hypo,enzym,moon,dryr1,dryr2,dryr3;
       
       ston="No";
       fom="No";
       hypo="No";
       enzym="No";
       moon="No";
       dryr1="No";
       dryr2="No";
       dryr3="No";
       
       List<String> shots = new ArrayList<>();
    
       int bathnum=0;
       
        int dss=1;
                            org.jsoup.nodes.Document docy = Jsoup.parse(rora.getText());
                            for (Element table : docy.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            
                            
                            
                            
                            
                            if (tds.get(7).text().contains("stone")||tds.get(7).text().contains("Stone")||tds.get(7).text().contains("STONE")||tds.get(7).text().contains("STON")||tds.get(7).text().contains("ston")) {
                                
                                ston="STONE";
                                stonn=ston;
                                
                            }
                            
                             else {
                                
                             //   stonn="-";
                               
                                stonn=ston;
                            }
                            
                            if (tds.get(7).text().contains("foam")||tds.get(7).text().contains("Foam")||tds.get(7).text().contains("FOAM")||tds.get(7).text().contains("BOOL")||tds.get(7).text().contains("BOOL فوم")||tds.get(7).text().contains("FOM")||tds.get(7).text().contains("fom")) {
                                
                                fom="FOAM";
                                fomm=fom;
                                
                            }
                            
                             else {
                                
                               
                             //   fomm="-";
                               
                                fomm=fom;
                            }
                            
                            if (tds.get(7).text().contains("BLEACH")||tds.get(7).text().contains("HYPO")) {
                                
                                hypo="BLEACH";
                                hypoo=hypo;
                                
                            }
                            
                             else {
                                
                              
                             //   hypoo="-";
                              hypoo=hypo;
                                 
                                
                            }
                            
                            if (tds.get(7).text().contains("ENZYME")||tds.get(7).text().contains("ENZYM")||tds.get(7).text().contains("ACUDELL")||tds.get(7).text().contains("NSY")) {
                                
                                enzym="ENZYME";
                                enzymm=enzym;
                                
                            }
                            
                             else {
                                
                               
                             //   enzymm="-";
                                enzymm=enzym;
                                
                            }
                             
                            if (tds.get(3).text().contains("MOON WASH")||tds.get(3).text().contains("MOON")||tds.get(3).text().contains("Moon Wash")||tds.get(3).text().contains("MON WASH")||tds.get(7).text().contains("PERMENGANATE")||tds.get(7).text().contains("PERMENGANAT")||tds.get(7).text().contains("PERMANGANATE")||tds.get(7).text().contains("PERMANGANAT")||tds.get(8).text().contains("POTASSIUM PERMANGANATE")||tds.get(8).text().contains("NOVA TEKS MOON")||tds.get(7).text().contains("PERMANGANAT TO2U")) {
                                
                                moon="MOON WASH";
                                moonn=moon;
                                
                            }
                                   
                          
                            else {
                                
                                
                              //  moonn="-";
                                 moonn=moon;
                            }
                              
                            String dalil=tds.get(3).text();
                            if (dalil.contains("EXTRACT")||dalil.contains("extract")||dalil.contains("Extract")||dalil.contains("EXTRA")||dalil.contains("EXTRACTION")||dalil.contains("extraction")) {
                            shots.add(dalil);}
                            else {
                            
                            
                            
                            }
                            
                           

                           }}
                            
                            
                          bathnum=shots.size();
                          if (shots.size()==1) {
                          dryr1="DRYER 1";
                          dryr11=dryr1;
                          dryr22="No";
                          dryr33="No";
                          }
                          else if (shots.size()==2) {
                          dryr1="DRYER 1";
                          dryr2="DRYER 2";
                          dryr11=dryr1;
                          dryr22=dryr2;
                          dryr33="No";
                          }
                          else if (shots.size()==3) {
                          dryr1="DRYER 1";
                          dryr2="DRYER 2";
                          dryr3="DRYER 3";
                          dryr11=dryr1;
                          dryr22=dryr2;
                          dryr33=dryr3;
                          }
                          else {
                          dryr1="No";
                          dryr2="No";
                          dryr3="No";
                          dryr11=dryr1;
                          dryr22=dryr2;
                          dryr33=dryr3;
                          }
                            
             
//            JFXTextArea kk=new JFXTextArea ();
//            kk.setStyle("-fx-font-weight:bold;");
//            kk.setEditable(true);
//            kk.setText("Stone: "+stonn+"\n"+"Foam: "+fomm+"\n"+"Bleach: "+hypoo+"\n"+"Enzyme: "+enzymm+"\n"+"Moon Wash: "+moonn+"\n"+"Dryer 1: "+dryr11+"\n"+"Dryer 2: "+dryr22+"\n"+"Dryer 3: "+dryr33+"\n");
//            Alert al=new Alert (Alert.AlertType.ERROR);
//            al.setTitle("Recipe Viewer");
//            al.setHeaderText("Here is your recipe Type: ");
//            al.setContentText("Please edit me if you found errors, iam not a human. Iam a computer\nMy developer is KADINIO.");
//            al.setResizable(false);
//            al.setGraphic(kk);
//            DialogPane dialogPane = al.getDialogPane();
//            dialogPane.getStylesheets().add(
//          getClass().getResource("primer-light.css").toExternalForm());
//            al.showAndWait();
            
           
            //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
//Alert alertd = new Alert(Alert.AlertType.CONFIRMATION);
//alertd.setTitle("Save To DB");
//alertd.setHeaderText("Processes Result");
//alertd.setContentText("Here Is The result of Type For " + recipenami + " Recipe.");
//ButtonType buttonTypeOned = new ButtonType("Save To DB");
//ButtonType buttonTypeCanceld = new ButtonType("Cancel");
//alertd.getButtonTypes().setAll(buttonTypeOned, buttonTypeCanceld);
//DialogPane dialogPaneid = alertd.getDialogPane();
//dialogPaneid.getStylesheets().add(getClass().getResource("primer-dark.css").toExternalForm());
//Optional<ButtonType> resultsd = alertd.showAndWait();
//if (resultsd.isPresent() && resultsd.get() == buttonTypeOned) {
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
        String sql0 = "select * from Recipe_Types where WashName = ? and Model = ?";
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
            String sqlp = "update Recipe_Types set Date = ?, Model = ?, WashName = ?, Rinse = ?, Stone = ?, Foam = ?, Bleach = ?, Enzyme = ?, MoonWash = ?, Dryer_1 = ?, Dryer_2 = ?, Dryer_3 = ? where WashName = ? and Model = ?";
            pst = conn.prepareStatement(sqlp);
            pst.setString(1, dateString2);
            pst.setString(2, modelooo);
            pst.setString(3, recipenami);
            
            pst.setString(4, "RINSE");
            pst.setString(5, stonn);
            pst.setString(6, fomm);
            pst.setString(7, hypoo);
            pst.setString(8, enzymm);
            pst.setString(9, moonn);
            pst.setString(10, dryr11);
            pst.setString(11, dryr22);
            pst.setString(12, dryr33);
            
            pst.setString(13, recipenami); // WHERE clause parameters
            pst.setString(14, modelooo);
            pst.execute();
            
            Notifications noti = Notifications.create();
            noti.title("Successful");
            noti.text("We have updated the types successfully.");
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
            String reg = "insert into Recipe_Types (Date, Model, WashName, Rinse, Stone, Foam, Bleach, Enzyme, MoonWash, Dryer_1, Dryer_2, Dryer_3) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = conn.prepareStatement(reg);
            pst.setString(1, dateString2);
            pst.setString(2, modelooo);
            pst.setString(3, recipenami);
            
            pst.setString(4, "RINSE");
            pst.setString(5, stonn);
            pst.setString(6, fomm);
            pst.setString(7, hypoo);
            pst.setString(8, enzymm);
            pst.setString(9, moonn);
            pst.setString(10, dryr11);
            pst.setString(11, dryr22);
            pst.setString(12, dryr33);
            
            pst.execute(); 
            
            Notifications noti = Notifications.create();
            noti.title("Successful");
            noti.text("We have inserted the new type successfully.");
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
