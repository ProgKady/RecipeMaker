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
public class CostMultipleController implements Initializable {

    
    
    @FXML
    private JFXTextArea list,rora;

    @FXML
    private Text text;
    
    
    @FXML
    private JFXButton fix;
    
    Connection conn = null;
  
  ResultSet rs = null;
  
  PreparedStatement pst = null;
  
  
  public static String find,oldtotalcost,oldpcs,oldonegarmentcost;

  
    
    @FXML
    void fixaction(ActionEvent event) throws FileNotFoundException, IOException{

 
        String[] filess=list.getText().split("\n");
        for (String namo :filess) {
            
      String[] pathParts = namo.split("\\\\");   
      String recipenami=pathParts[5].replaceAll(".ks", "").replaceAll(".html", "");
      String dirpathe = namo;
      String modelooo=pathParts[4];
            
              
      ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
//////////////////////////////////////////////////////////////////////////////////////////////////////////
InputStream inputinstream=new FileInputStream(dirpathe);
BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
String lo;
rora.clear();
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
OutputStream instreamm=new FileOutputStream(System.getProperty("user.home")+"\\r.ks");
PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
pwe.println(gf);
pwe.close();
///////////////////////////////////////////////////////////////////////////////////////////////////////////   
List<Double> pri = new ArrayList<>();
List<Double> qua = new ArrayList<>();
List<Double> dil = new ArrayList<>();
List<String> nom = new ArrayList<>();

////////////////////////////////////////////////
File inputFile = new File(System.getProperty("user.home")+"\\r.ks"); //
org.jsoup.nodes.Document docj = Jsoup.parse(inputFile, "UTF-8"); //
//Document docj = Jsoup.parse(codee);
for (Element table : docj.select("TABLE")) {
for (Element row : table.select("TR")) {
Elements tds = row.select("TD");
if (tds.get(8).text().isEmpty()||tds.get(8).text().contains("OLD STONE")) {   
}
else { 
String string = tds.get(8).text();
BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirrrr + "\\Recipe_Indexes\\Prices.kady"));
String line;
String linebeforeequal;
String lineafterequal;
boolean found = false;
while ((line = buf.readLine()) != null) {
linebeforeequal = line.substring(0, line.indexOf("=$"));  // Item
lineafterequal = line.substring(line.indexOf("=$") + 2);  // Price
if (string.equals(linebeforeequal)) {
double number1 = Double.parseDouble(lineafterequal);
pri.add(number1);
String itaam = linebeforeequal;
nom.add(itaam);
found = true;
break;
}
}
// If the item wasn't found in the file, add it to the except variable
//if (!found) {
//except = except + "\n" + tds.get(7).text();
//}
buf.close();   
//String string=tds.get(8).text();
//BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Prices.kady"));
//String line;
//String linebeforeequal;
//String lineafterequal;
//while ((line=buf.readLine())!=null) {       
//linebeforeequal=line.substring(0,line.indexOf("=$")-0);  //Item
//lineafterequal=line.substring(line.indexOf("=$") + 2 , line.length());  //Price
//if (string.equals(linebeforeequal)) {
//double number1 = Double.parseDouble(lineafterequal);
//pri.add(number1);
//String itaam = linebeforeequal;
//nom.add(itaam);
//break;
//}
//else {
//except=except+"\n"+tds.get(7).text();    
//}
//}
//buf.close();



}          
//////////////////////KG//////////////////////////
String skip=tds.get(8).text();
if (skip.equals("OLD STONE")) {   
}
else {
if (tds.get(5).text().isEmpty()||tds.get(5).text().contains("/")||tds.get(5).text().contains("\\")||tds.get(5).text().contains("OPERATPR")||tds.get(5).text().contains("OPERATOR")||tds.get(5).text().contains("AMOUNT")||tds.get(5).text().contains("AMT")||tds.get(5).text().contains("-")||tds.get(5).text().contains("DATE")||tds.get(5).text().contains("WASH")||tds.get(5).text().contains("WASH NAME")) {}
else if (tds.get(6).text().contains("GR")||tds.get(6).text().contains("Gr")||tds.get(6).text().contains("gr")) {
double am=(Double.parseDouble(tds.get(5).text().replace(",","."))/1000);
String amm=Double.toString(am);
if (amm.contains("E")) { 
BigDecimal bd = new BigDecimal(amm);
double val = bd.doubleValue();
qua.add(val);   
}
else {
qua.add(am);
}
}

else if (tds.get(6).text().contains("GARDAL")||tds.get(6).text().contains("GARDEL")
||tds.get(6).text().contains("Gardal")||tds.get(6).text().contains("Gardel")||tds.get(6).text().contains("gardal")||tds.get(6).text().contains("gardel")) {
String sky=tds.get(8).text();
if (sky.equals("FOAM")) {
double am=4.0/5.0;
qua.add(am);   
}
else {
double am=Double.parseDouble(tds.get(5).text().replace(",","."))*12;
qua.add(am);    
}
}
else {
double number2 = Double.parseDouble(tds.get(5).text());
qua.add(number2);
}    
}
//////////////////////////////////////////////
if (tds.get(8).text().isEmpty()||tds.get(8).text().contains("/")||tds.get(8).text().contains("\\")||tds.get(8).text().contains("CHEMICAL")||tds.get(8).text().contains("chemical")||tds.get(8).text().matches("[0-9_-]+")||tds.get(8).text().contains("TIME")||tds.get(8).text().contains("HOURS")||tds.get(8).text().contains("MINS")||tds.get(8).text().contains("SHOT")||tds.get(8).text().contains("OLD STONE")) {    
}
else {  
String string = tds.get(8).text();
BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirrrr + "\\Recipe_Indexes\\Dilution.kady"));
String line;
boolean found = false;
while ((line = buf.readLine()) != null) {
String linebeforeequal = line.substring(0, line.indexOf("=")).trim();  // Item
String lineafterequal = line.substring(line.indexOf("=") + 1).trim();  // Dilution
if (string.equals(linebeforeequal)) {
double number3 = Double.parseDouble(lineafterequal);
dil.add(number3);
found = true;
break;
}
}
if (!found) {
double number3 = Double.parseDouble("1.0");
dil.add(number3);
}
buf.close();
}
///////////////////////////////////////////////
}}    
if (qua.size()!=pri.size()||qua.size()!=dil.size()) { 
Notifications noti = Notifications.create();
noti.title("Fatal Error!");
noti.text("We found that all chemicals names weren't set.\nWe suggest to fix chemicals again.");
noti.position(Pos.CENTER);
noti.hideAfter(Duration.seconds(10));
noti.showError();
}
else {
//Show alert to write pcs.    
List<Double> result = new ArrayList<>();
for (int i = 0; i < qua.size(); i++) {
result.add((qua.get(i) / dil.get(i))* pri.get(i));
}
double sum = 0.0;
for (double number : result) {
sum += number;
}

//JFXTextField grr = new JFXTextField("120");
//grr.setStyle("-fx-font-size:15;-fx-font-weight:bold;");
//grr.setLabelFloat(true);
//grr.setPromptText("Add PCS Number ...");
//grr.setMinSize(300.0D, 25.0D);
//Alert aloo = new Alert(Alert.AlertType.INFORMATION);
//aloo.setTitle("PCS Number?");
//aloo.setGraphic((Node)grr);
//aloo.setResizable(false);
//DialogPane dialogPane = aloo.getDialogPane();
//dialogPane.getStylesheets().add(
//getClass().getResource("primer-dark.css").toExternalForm());
//aloo.showAndWait();
//double pcsnum=Double.parseDouble(grr.getText());
double pcsnum=Double.parseDouble("120");
double onegar=sum/pcsnum;

//Alert alertd = new Alert(Alert.AlertType.CONFIRMATION);
//alertd.setTitle("Save To DB");
//alertd.setHeaderText("Cost Result");
//alertd.setContentText("Here Is The result of Cost For "+recipenami+" Recipe.");
//ButtonType buttonTypeOned = new ButtonType("Save To DB");
//ButtonType buttonTypeCanceld = new ButtonType("Cancel");
//alertd.getButtonTypes().setAll(buttonTypeOned, buttonTypeCanceld);
//DialogPane dialogPaneid = alertd.getDialogPane();
//dialogPaneid.getStylesheets().add(getClass().getResource("primer-dark.css").toExternalForm());
//Optional<ButtonType> resultsd = alertd.showAndWait();
//if (resultsd.isPresent() && resultsd.get() == buttonTypeOned) {
    //Save To DB Here.
Date currentDate1 = GregorianCalendar.getInstance().getTime();
DateFormat df1 = DateFormat.getDateInstance();
String dateString1 = df1.format(currentDate1);
Date d1 = new Date();
SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
String timeString1 = sdf1.format(d1);
SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
String dateString2 = sdf2.format(d1);
String alldaty=dateString2+" \\ "+timeString1;
try {
String sql0 = "select * from Cost where Name like '" + recipenami + "' and Model like '" + modelooo + "' ";
pst = conn.prepareStatement(sql0);
rs = pst.executeQuery();                    
if (rs.next()) {                        
//Update
find="found";   
}                    
else {
//Insert
find="not_found";   
}        
}catch (Exception exception) {
} 
finally {
try {
rs.close();
pst.close();     
} catch (Exception exception) {}
}
if (find.equals("found")) {
try {
String sqlm = "select * from Cost where Name=? and Model=?";
pst = conn.prepareStatement(sqlm);
pst.setString(1, recipenami);
pst.setString(2, modelooo);
rs = pst.executeQuery();      
String addd1 = rs.getString("Total_Cost_Old");
oldtotalcost=addd1;
String addd2 = rs.getString("PCS_Old");
oldpcs=addd2;      
String addd3 = rs.getString("One_Garment_Old");
oldonegarmentcost=addd3;

String sqlp= "update Cost set Date='"+dateString2+"', Total_Cost_Old='"+oldtotalcost+"', PCS_Old='"+oldpcs+"', One_Garment_Old='"+oldonegarmentcost+"', Total_Cost_New='"+Double.toString(sum)+"', PCS_New='"+Double.toString(pcsnum)+"', One_Garment_New='"+Double.toString(onegar)+"' where Name='"+recipenami+"'";
pst=conn.prepareStatement(sqlp);
pst.execute();
}                        
catch (Exception exception) {
} 
finally {
try {
rs.close();
pst.close();
Notifications noti = Notifications.create();
noti.title("Successful");
noti.text("We have updated the cost successfully.");
noti.hideAfter(Duration.seconds(3));
noti.position(Pos.CENTER);
noti.showInformation();
} catch (Exception exception) {}
}                               
}
else if (find.equals("not_found")) {
try {                            
String reg = "insert into Cost (Date, Model, Name, Total_Cost_Old, PCS_Old, One_Garment_Old, Total_Cost_New, PCS_New, One_Garment_New) values (?,?,?,?,?,?,?,?,?)";
pst = conn.prepareStatement(reg);
pst.setString(1,dateString2);
pst.setString(2,modelooo);
pst.setString(3,recipenami);

pst.setString(4,Double.toString(sum));
pst.setString(5,Double.toString(pcsnum));
pst.setString(6,Double.toString(onegar));

pst.setString(7,"Hasnot_Updated_Yet");
pst.setString(8,"Hasnot_Updated_Yet");
pst.setString(9,"Hasnot_Updated_Yet");

pst.execute(); 
}                                            
catch (Exception exception) {
} 
finally {
try {
rs.close();
pst.close();
Notifications noti = Notifications.create();
noti.title("Successful");
noti.text("We have inserted the new cost successfully.");
noti.hideAfter(Duration.seconds(3));
noti.position(Pos.CENTER);
noti.showInformation();
} catch (Exception exception) {}
}                               
}
else{}


//}


}   
            
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
