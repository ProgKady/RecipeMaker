
package kadysoft.kady;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Image;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXTextArea;
import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.awt.Desktop;
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
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.util.Duration;
import javax.swing.JOptionPane;
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
public class CompareCostController implements Initializable {

    
    
    @FXML
    private MFXButton browse;
    
    @FXML
    private MFXPasswordField admintf;

    @FXML
    private MFXTextField pcs;

    @FXML
    private MFXTextField recipelink,recipelink1;

    @FXML
    private WebView webview;
    
     @FXML
    private JFXTextArea lili,lili1,lili2,lili3,lili4;
     
     
     @FXML
    private Label status,status2;

    @FXML
    private MFXButton calculate,reporto,reporte,reportall,addrow;


    @FXML
    private MFXButton refresh,calnew,clearall,updatecostt;


    @FXML
    private Label result,result2;

    public static String recipenami,recipenami1;
    
public static List<Double> pri1;
public static List<Double> qua1;
public static List<Double> dil1;
public static List<String> nom1;
public static List<String> unito1;

public static List<Double> pri2;
public static List<Double> qua2;
public static List<Double> dil2;
public static List<String> nom2;
public static List<String> unito2;

public static List<Double> pri3;
public static List<Double> qua3;
public static List<Double> dil3;
public static List<String> nom3;

public static List<Double> pri4;
public static List<Double> qua4;
public static List<Double> dil4;
public static List<String> nom4;

public static String sum1,sum2,sum3,pcsnum1,pcsnum2,pcsnum3,onegar1,onegar2,onegar3;

//@FXML
//    private HBox controlpanel;

    @FXML
    private ScrollPane newscrollbar,scrollbar;

    @FXML
    private WebView newwebview;

private WebView selectedWebView = null;
    
    


@FXML
    void updatecosttaction(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException, IOException, InterruptedException {
        
        
        if (newwebview.isVisible()==true)  {
            
            updatecostt.setDisable(false);
            
           ////////////////////////////////////////////////////Action Here Only
            
                  
            
      String code = (String)this.webview.getEngine().executeScript("document.documentElement.outerHTML");
      
      lili.clear();
      
      if (!code.contains("table")) {
      Notifications noti = Notifications.create();
      noti.title("Recipe Error");
      noti.text("Maybe not a recipe, Open a recipe first!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showError();    
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
tds.get(8).text(linebeforeequal);
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
       lili.setText(doc.toString());
        }
        
      
      
    ////////////////////////////////////////////////////////////////////////////    
    String newrecipecode=lili.getText();
    OutputStream instreamm=new FileOutputStream(System.getProperty("user.home")+"\\uppo.ks");
    PrintWriter pwwc = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    //PrintWriter pwwc=new PrintWriter (new FileWriter (pathy));
    pwwc.println(newrecipecode);
    pwwc.close();
    lili.clear();
 
    
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    
    InputStream inputinstream=new FileInputStream(System.getProperty("user.home")+"\\uppo.ks");
    BufferedReader bufy=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    
    //BufferedReader bufy=new BufferedReader (new FileReader (pathy));
    String liin;
    while ((liin=bufy.readLine())!=null) {
        lili.appendText(liin.replace("ﬦ","A")
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
    String codei = lili.getText().replace("<HTML ","<HTML CONTENTEDITABLE ").replace("-WEBKIT-USER-SELECT:","").replace("-MOZ-USER-SELECT:","").replace("-MS-USER-SELECT:","").replace("DOCUMENT.ADDEVENTLISTENER","").replace("USER-SELECT:","").replace("EVENT.PREVENTDEFAULT();","").replace("E.PREVENTDEFAULT();","").replace("<html ","<html contenteditable ").replace("-webkit-user-select:","").replace("-moz-user-select:","").replace("-ms-user-select:","").replace("document.addeventlistener","").replace("user-select:","").replace("event.preventdefault();","").replace("e.preventdefault();","").replace("<html ","<html contenteditable ").replace("-webkit-user-select:","").replace("-moz-user-select:","").replace("-ms-user-select:","").replace("document.addEventListener","").replace("user-select:","").replace("event.preventDefault();","").replace("e.preventDefault();","");
      if (!codei.contains("TABLE")) {
      Notifications noti = Notifications.create();
      noti.title("Recipe Error");
      noti.text("Maybe not a recipe, Open a recipe first!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showError();    
        }
        else {
            org.jsoup.nodes.Document doc = Jsoup.parse(codei);
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
tds.get(8).text(linebeforeequal);
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
       lili.setText(doc.toString());
        }
        
    ////////////////////////////////////////////////////////////////////////////    
    String newrecipecodei=lili.getText();
    
    OutputStream instreammo=new FileOutputStream(System.getProperty("user.home")+"\\uppo.ks");
    PrintWriter pwwcc = new PrintWriter(new OutputStreamWriter (instreammo,"UTF-8"));
    
    //PrintWriter pwwc=new PrintWriter (new FileWriter (pathy));
    pwwcc.println(newrecipecode.replace("A","ﬦ")
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
       pwwcc.close();
       
       Thread.sleep(2000);
    
       
     //////////////////////////////////////////////////////////////////////////////////////////////////////////
InputStream inputinstreamc=new FileInputStream(System.getProperty("user.home")+"\\uppo.ks");
BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstreamc,"UTF-8"));
String lo;
lili.clear();

lili.appendText(      
            
             "<script>\n" +
"        document.addEventListener('dragstart', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"\n" +
"        document.addEventListener('drop', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"\n" +
"        document.addEventListener('contextmenu', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"    </script>"  
            
            + "<script>\n" +
"  \n" +
"  window.addEventListener(`contextmenu`, (e) => {\n" +
"    e.preventDefault();\n" +
"});\n" +
"  \n" +
"  </script>"
                   
                     + "<script>\n" +
"        document.addEventListener('keydown', function (event) {\n" +
"            // Check if Ctrl + C is pressed\n" +
"            if (event.ctrlKey && event.key === 'c') {\n" +
"                event.preventDefault();  // Prevent the default action (copy)\n" +
"            }\n" +
"        });\n" +
"    </script>"
            
          
      
         );



while ((lo=bi.readLine())!=null) {       
lili.appendText("\n"+lo
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
String gf=lili.getText();
OutputStream instreammw=new FileOutputStream(System.getProperty("user.home")+"\\upppo.ks");
PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreammw,"UTF-8"));
pwe.println(gf);
pwe.close();  
       
       
///////////////////////////////////////////////////////////////////////////////////////////////////////////   
pri1 = new ArrayList<>();
qua1 = new ArrayList<>();
dil1 = new ArrayList<>();
nom1 = new ArrayList<>();
unito1 = new ArrayList<>();

////////////////////////////////////////////////
File inputFile = new File(System.getProperty("user.home")+"\\upppo.ks"); //
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
pri1.add(number1);
String itaam = linebeforeequal;
nom1.add(itaam);
unito1.add(tds.get(6).text());
found = true;
break;
}
}
buf.close();   
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
qua1.add(val);   
}
else {
qua1.add(am);
}
}

else if (tds.get(6).text().contains("GARDAL")||tds.get(6).text().contains("GARDEL")
||tds.get(6).text().contains("Gardal")||tds.get(6).text().contains("Gardel")||tds.get(6).text().contains("gardal")||tds.get(6).text().contains("gardel")) {
String sky=tds.get(8).text();
if (sky.equals("FOAM")) {
double am=4.0/5.0;
qua1.add(am);   
}
else {
double am=Double.parseDouble(tds.get(5).text().replace(",","."))*12;
qua1.add(am);    
}
}
else {
double number2 = Double.parseDouble(tds.get(5).text());
qua1.add(number2);
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
dil1.add(number3);
found = true;
break;
}
}
if (!found) {
double number3 = Double.parseDouble("1.0");
dil1.add(number3);
}
buf.close();
}
///////////////////////////////////////////////
}}    
if (qua1.size()!=pri1.size()||qua1.size()!=dil1.size()) { 

    //Write Here About Status in red Color
    status.setText("Error-Fix Chemicals");
    status.setStyle("-fx-text-fill:red;");
    
}
else {
//Show alert to write pcs.    
List<Double> resulti = new ArrayList<>();
for (int i = 0; i < qua1.size(); i++) {
resulti.add((qua1.get(i) / dil1.get(i))* pri1.get(i));
}
double sum = 0.0;
for (double number : resulti) {
sum += number;
}

double number1 = sum;
String formatted1 = String.format("%.1f", number1);
sum=Double.parseDouble(formatted1);

status.setText(Double.toString(sum));
status.setStyle("-fx-text-fill:black;");

//Note make this in calculate button
double sam4=Double.parseDouble(status.getText());
double pcsnum4=Double.parseDouble(pcs.getText());
double onegar4=sam4/pcsnum4;

double number11 = onegar4;
String formatted11 = String.format("%.2f", number11);
onegar4=Double.parseDouble(formatted11);



result.setText(Double.toString(onegar4));
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////  

    }

            
           ////////////////////////////////////////////////////End All Here 
            
        }
        
        
        else {
            
            updatecostt.setDisable(true);
            
            
            
        }
        
        
        
        
    }





    
  //  @FXML
  //  void browsenewaction(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException, IOException {

//         
//        
//FileChooser fcho = new FileChooser();
//fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
//fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
//fcho.setTitle("Kady Choose");
//File f = fcho.showOpenDialog((Window)null);
//recipenami1=f.getName().replace(".ks","").replace(".html","");
//String recipepathy = f.getAbsolutePath().toString();
//recipelink1.setText(recipepathy);  
//
////Read File Here//////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//InputStream inputinstream=new FileInputStream(recipepathy);
//BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
//String lo;
//lili3.clear();
//
////lili.appendText(      
////            
////             "<script>\n" +
////"        document.addEventListener('dragstart', function(event) {\n" +
////"            event.preventDefault();\n" +
////"        });\n" +
////"\n" +
////"        document.addEventListener('drop', function(event) {\n" +
////"            event.preventDefault();\n" +
////"        });\n" +
////"\n" +
////"        document.addEventListener('contextmenu', function(event) {\n" +
////"            event.preventDefault();\n" +
////"        });\n" +
////"    </script>"  
////            
////            + "<script>\n" +
////"  \n" +
////"  window.addEventListener(`contextmenu`, (e) => {\n" +
////"    e.preventDefault();\n" +
////"});\n" +
////"  \n" +
////"  </script>"
////           
////            + "<script>\n" +
////"        document.addEventListener('keydown', function (event) {\n" +
////"            // Check if Ctrl + C is pressed\n" +
////"            if (event.ctrlKey && event.key === 'c') {\n" +
////"                event.preventDefault();  // Prevent the default action (copy)\n" +
////"            }\n" +
////"        });\n" +
////"    </script>"
////        
////        
////            
////         );
//
//
//
//while ((lo=bi.readLine())!=null) {        
//lili3.appendText("\n"+lo
//.replace("ﬦ","A")
//.replace("ﬧ","B")
//.replace("ﬨ","C")
//.replace("﬩","D")
//.replace("שׁ","E")    
//.replace("שׂ","F")        
//.replace("שּׁ","G")         
//.replace("שּׂ","H")         
//.replace("אַ","I")         
//.replace("אָ","J")         
//.replace("אּ","K")         
//.replace("בּ","L")         
//.replace("גּ","M")         
//.replace("דּ","N")         
//.replace("הּ","O")         
//.replace("וּ","P")         
//.replace("זּ","Q")         
//.replace("טּ","R")         
//.replace("יּ","S")         
//.replace("ךּ","T")         
//.replace("כּ","U")         
//.replace("לּ","V")
//.replace("מּ","W")         
//.replace("נּ","X")         
//.replace("סּ","Y")         
//.replace("ףּ","Z")         
//.replace("פּ","0")         
//.replace("צּ","1")         
//.replace("קּ","2")         
//.replace("רּ","3")         
//.replace("שּ","4")         
//.replace("תּ","5")         
//.replace("וֹ","6")         
//.replace("בֿ","7")         
//.replace("כֿ","8")
//.replace("פֿ","9")
//.replace("&NBSP;","")                       
//); 
//}
//bi.close();
//String gf=lili3.getText().replace("<HTML ","<HTML CONTENTEDITABLE ").replace("-WEBKIT-USER-SELECT:","").replace("-MOZ-USER-SELECT:","").replace("-MS-USER-SELECT:","").replace("DOCUMENT.ADDEVENTLISTENER","").replace("USER-SELECT:","").replace("EVENT.PREVENTDEFAULT();","").replace("E.PREVENTDEFAULT();","").replace("<html ","<html contenteditable ").replace("-webkit-user-select:","").replace("-moz-user-select:","").replace("-ms-user-select:","").replace("document.addeventlistener","").replace("user-select:","").replace("event.preventdefault();","").replace("e.preventdefault();","").replace("<html ","<html contenteditable ").replace("-webkit-user-select:","").replace("-moz-user-select:","").replace("-ms-user-select:","").replace("document.addEventListener","").replace("user-select:","").replace("event.preventDefault();","").replace("e.preventDefault();","");
//
//
//
/////////////Read Here/////////
//
//String coco=gf.replaceAll("<HTML", "<HTML CONTENTEDITABLE");
//newwebview.getEngine().loadContent(coco);
//
///////////////////////////////
//
//OutputStream instreamm=new FileOutputStream(System.getProperty("user.home")+"\\ruy.ks");
//PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
//pwe.println(gf);
//pwe.close();
//
//
//
/////////////////////////////////////////////////////////////////////////////////////////////////////////////   
//pri4 = new ArrayList<>();
//qua4= new ArrayList<>();
//dil4 = new ArrayList<>();
//nom4 = new ArrayList<>();
//
//////////////////////////////////////////////////
//File inputFile = new File(System.getProperty("user.home")+"\\ruy.ks"); //
//org.jsoup.nodes.Document docj = Jsoup.parse(inputFile, "UTF-8"); //
////Document docj = Jsoup.parse(codee);
//for (Element table : docj.select("TABLE")) {
//for (Element row : table.select("TR")) {
//Elements tds = row.select("TD");
//if (tds.get(8).text().isEmpty()||tds.get(8).text().contains("OLD STONE")) {   
//}
//else { 
//String string = tds.get(8).text();
//BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirrrr + "\\Recipe_Indexes\\Prices.kady"));
//String line;
//String linebeforeequal;
//String lineafterequal;
//boolean found = false;
//while ((line = buf.readLine()) != null) {
//linebeforeequal = line.substring(0, line.indexOf("=$"));  // Item
//lineafterequal = line.substring(line.indexOf("=$") + 2);  // Price
//if (string.equals(linebeforeequal)) {
//double number1 = Double.parseDouble(lineafterequal);
//pri4.add(number1);
//String itaam = linebeforeequal;
//nom4.add(itaam);
//found = true;
//break;
//}
//}
//buf.close();   
//}          
////////////////////////KG//////////////////////////
//String skip=tds.get(8).text();
//if (skip.equals("OLD STONE")) {   
//}
//else {
//if (tds.get(5).text().isEmpty()||tds.get(5).text().contains("/")||tds.get(5).text().contains("\\")||tds.get(5).text().contains("OPERATPR")||tds.get(5).text().contains("OPERATOR")||tds.get(5).text().contains("AMOUNT")||tds.get(5).text().contains("AMT")||tds.get(5).text().contains("-")||tds.get(5).text().contains("DATE")||tds.get(5).text().contains("WASH")||tds.get(5).text().contains("WASH NAME")) {}
//else if (tds.get(6).text().contains("GR")||tds.get(6).text().contains("Gr")||tds.get(6).text().contains("gr")) {
//double am=(Double.parseDouble(tds.get(5).text().replace(",","."))/1000);
//String amm=Double.toString(am);
//if (amm.contains("E")) { 
//BigDecimal bd = new BigDecimal(amm);
//double val = bd.doubleValue();
//qua4.add(val);   
//}
//else {
//qua4.add(am);
//}
//}
//
//else if (tds.get(6).text().contains("GARDAL")||tds.get(6).text().contains("GARDEL")
//||tds.get(6).text().contains("Gardal")||tds.get(6).text().contains("Gardel")||tds.get(6).text().contains("gardal")||tds.get(6).text().contains("gardel")) {
//String sky=tds.get(8).text();
//if (sky.equals("FOAM")) {
//double am=4.0/5.0;
//qua4.add(am);   
//}
//else {
//double am=Double.parseDouble(tds.get(5).text().replace(",","."))*12;
//qua4.add(am);    
//}
//}
//else {
//double number2 = Double.parseDouble(tds.get(5).text());
//qua4.add(number2);
//}    
//}
////////////////////////////////////////////////
//if (tds.get(8).text().isEmpty()||tds.get(8).text().contains("/")||tds.get(8).text().contains("\\")||tds.get(8).text().contains("CHEMICAL")||tds.get(8).text().contains("chemical")||tds.get(8).text().matches("[0-9_-]+")||tds.get(8).text().contains("TIME")||tds.get(8).text().contains("HOURS")||tds.get(8).text().contains("MINS")||tds.get(8).text().contains("SHOT")||tds.get(8).text().contains("OLD STONE")) {    
//}
//else {  
//String string = tds.get(8).text();
//BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirrrr + "\\Recipe_Indexes\\Dilution.kady"));
//String line;
//boolean found = false;
//while ((line = buf.readLine()) != null) {
//String linebeforeequal = line.substring(0, line.indexOf("=")).trim();  // Item
//String lineafterequal = line.substring(line.indexOf("=") + 1).trim();  // Dilution
//if (string.equals(linebeforeequal)) {
//double number3 = Double.parseDouble(lineafterequal);
//dil4.add(number3);
//found = true;
//break;
//}
//}
//if (!found) {
//double number3 = Double.parseDouble("1.0");
//dil4.add(number3);
//}
//buf.close();
//}
/////////////////////////////////////////////////
//}}    
//if (qua4.size()!=pri4.size()||qua4.size()!=dil4.size()) { 
//
//    //Write Here About Status in red Color
//    status2.setText("Error-Fix Chemicals");
//    status2.setStyle("-fx-text-fill:red;");
//    //refresh.setDisable(false);
//    
//}
//else {
////Show alert to write pcs.    
//List<Double> result = new ArrayList<>();
//for (int i = 0; i < qua4.size(); i++) {
//result.add((qua4.get(i) / dil4.get(i))* pri4.get(i));
//}
//double sum = 0.0;
//for (double number : result) {
//sum += number;
//}
//
//
//double number1 = sum;
//String formatted1 = String.format("%.1f", number1);
//sum=Double.parseDouble(formatted1);
//
//status2.setText(Double.toString(sum));
//status2.setStyle("-fx-text-fill:black;");
////refresh.setDisable(false);
//calculate.setDisable(false);
//calnew.setDisable(false);
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////  
//
//    }
//
//    
//
//updatecostt.setDisable(false);
//

        
  //  }

    
    
    
//    @FXML
//    void loadoldaction(ActionEvent event) {
//
//        
//        //controlpanel.setVisible(false);
//        newscrollbar.setVisible(false);
//        scrollbar.setMinSize(1223, 730);
//        webview.setMinSize(1223, 730);
//        newwebview.setVisible(false);
//        
//        
//    }
    
    
    
    
    
    
    

    @FXML
    void admintfaction(KeyEvent event) {

        
        
        
    }





@FXML
void addrowaction(ActionEvent event)  throws IOException{
    
    
     if (selectedWebView == null) {
        System.out.println("No WebView selected!");
        return;
    }
     
     
     else {
         
           
    String codeyy = (String)this.selectedWebView.getEngine().executeScript("document.documentElement.outerHTML");
    Document docyy = Jsoup.parse(codeyy);
    Elements rowsyy = docyy.select("table tr");
    int lastIndexyy = rowsyy.size() - 1;
    Element specificRowyy = docyy.select("tr").get(lastIndexyy);
    Element newRowyy = new Element("tr");
    newRowyy.append("<td style=\"width: 121.484px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 121.484px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 121.484px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 121.484px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 121.484px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 121.484px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 121.484px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 121.484px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 215.891px; border-style: dotted;\">&nbsp;</td>\n" +
"<td style=\"width: 215.891px; border-style: dotted;\">&nbsp;</td>\n" +            
"<td style=\"width: 240.234px; border-style: dotted;\">&nbsp;</td>");
   specificRowyy.after(newRowyy);
   String cxxxz=docyy.toString();
   selectedWebView.getEngine().loadContent(cxxxz); 
         
         
     }
    
  
   
}


   
   
   
   @FXML
void reportoaction(ActionEvent event) throws IOException {

    // تحديد اسم الوصفة والمسار حسب الحالة
    String recipeName = recipenami;
    String reportTypeSuffix = newwebview.isVisible() ? "" : "_Original_One";
    String titleSuffix = newwebview.isVisible() ? "" : " Original One.";

    //////////////////////////// Start Report //////////////////////////////
    Date currentDate = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String dateString = sdf.format(currentDate);
    String fileDate = dateString.replace("/", "_");
    String repname = "Chemical_Report_Of_" + recipeName + reportTypeSuffix;
    String reppath = System.getProperty("user.home") + "\\Desktop";

    FileChooser dialog = new FileChooser();
    dialog.setInitialDirectory(new File(reppath));
    dialog.setInitialFileName(repname);
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
    File dialogResult = dialog.showSaveDialog(null);

    if (dialogResult == null) return;

    String filePath = dialogResult.getAbsolutePath();

    // استخراج القيم للملخص
    String totalCost = status.getText();
    String totalGarments = pcs.getText();
    String costPerGarment = result.getText();

    try {
        com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A4.rotate(), 30, 30, 20, 30);
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        BaseColor primaryColor = new BaseColor(0, 102, 204);
        BaseColor headerColor = new BaseColor(0, 83, 166);
        BaseColor lightRow = new BaseColor(240, 248, 255);
        BaseColor textGray = new BaseColor(80, 80, 80);

        // لوجو صغير
        try {
            Image logo = Image.getInstance( NewDir.file_dirrrr+"\\Recipe_Indexes\\tandc.png");
            logo.scaleToFit(130, 130);
            logo.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            document.add(logo);
        } catch (Exception ignored) {}

        // العنوان الرئيسي
        Paragraph title = new Paragraph("Chemical Cost Report", FontFactory.getFont(FontFactory.TIMES_BOLD, 20, primaryColor));
        title.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        title.setSpacingAfter(6);
        document.add(title);

        Paragraph subtitle = new Paragraph("Recipe: " + recipeName + titleSuffix, FontFactory.getFont(FontFactory.TIMES_BOLD, 16, textGray));
        subtitle.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        subtitle.setSpacingAfter(8);
        document.add(subtitle);

        Paragraph datePara = new Paragraph("Report Date: " + dateString, FontFactory.getFont(FontFactory.TIMES_ROMAN, 11));
        datePara.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        datePara.setSpacingAfter(12);
        document.add(datePara);

        // جدول الكيماويات
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(95);
        table.setWidths(new float[]{20f, 20f, 20f, 20f, 20f});
        table.setSpacingAfter(10);

        Font headerFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 11, BaseColor.WHITE);
        Font bodyFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);

        String[] headers = {"Name", "Quantity", "Dilution", "Price", "Total"};
        for (String h : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(h, headerFont));
            cell.setBackgroundColor(headerColor);
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            cell.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
            cell.setPadding(6);
            table.addCell(cell);
        }

        int rowIndex = 0;
        for (int i = 0; i < qua1.size(); i++) {
            BaseColor rowColor = (rowIndex % 2 == 0) ? lightRow : BaseColor.WHITE;
            rowIndex++;

            // Name
            PdfPCell nameCell = new PdfPCell(new Phrase(nom1.get(i), bodyFont));
            nameCell.setBackgroundColor(rowColor);
            nameCell.setPadding(6);
            table.addCell(nameCell);

            // Quantity
            PdfPCell qtyCell = new PdfPCell(new Phrase(String.valueOf(qua1.get(i)), bodyFont));
            qtyCell.setBackgroundColor(rowColor);
            qtyCell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            qtyCell.setPadding(6);
            table.addCell(qtyCell);

            // Dilution
            PdfPCell dilCell = new PdfPCell(new Phrase(String.valueOf(dil1.get(i)), bodyFont));
            dilCell.setBackgroundColor(rowColor);
            dilCell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            dilCell.setPadding(6);
            table.addCell(dilCell);

            // Price
            PdfPCell priceCell = new PdfPCell(new Phrase(String.valueOf(pri1.get(i)), bodyFont));
            priceCell.setBackgroundColor(rowColor);
            priceCell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            priceCell.setPadding(6);
            table.addCell(priceCell);

            // Total
            double total = (qua1.get(i) / dil1.get(i)) * pri1.get(i);
            PdfPCell totalCell = new PdfPCell(new Phrase(String.format("%.2f", total), bodyFont));
            totalCell.setBackgroundColor(rowColor);
            totalCell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            totalCell.setPadding(6);
            table.addCell(totalCell);
        }
        document.add(table);

        // قسم الملخص
        PdfPTable summaryTable = new PdfPTable(2);
        summaryTable.setWidthPercentage(85);
        summaryTable.setWidths(new float[]{60f, 40f});
        summaryTable.setSpacingAfter(10);

        Font labelFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 11, primaryColor);
        Font valueFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 12, headerColor);

        String[][] summaryData = {
                {"Total Cost", totalCost + " $"},
                {"Total Garments", totalGarments + " PCS"},
                {"Cost Per Garment", costPerGarment + " $"}
        };

        for (String[] row : summaryData) {
            PdfPCell labelCell = new PdfPCell(new Phrase(row[0], labelFont));
            labelCell.setBackgroundColor(new BaseColor(250, 250, 250));
            labelCell.setPadding(8);
            labelCell.setBorder(Rectangle.NO_BORDER);
            summaryTable.addCell(labelCell);

            PdfPCell valueCell = new PdfPCell(new Phrase(row[1], valueFont));
            valueCell.setBackgroundColor(new BaseColor(230, 240, 255));
            valueCell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            valueCell.setPadding(8);
            valueCell.setBorder(Rectangle.NO_BORDER);
            summaryTable.addCell(valueCell);
        }
        document.add(summaryTable);

        // ملاحظات اختيارية
        JFXTextArea notesArea = new JFXTextArea();
        notesArea.setPromptText("اكتب ملاحظات إضافية (اختياري)...");
        notesArea.setMinSize(500, 150);

        Alert notesAlert = new Alert(Alert.AlertType.CONFIRMATION);
        notesAlert.setTitle("إضافة ملاحظات؟");
        notesAlert.setHeaderText(null);
        notesAlert.setGraphic(notesArea);
        notesAlert.getDialogPane().getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
        notesAlert.showAndWait();

        String notes = notesArea.getText().trim();
        if (!notes.isEmpty()) {
            Paragraph notesTitle = new Paragraph("Notes:", FontFactory.getFont(FontFactory.TIMES_BOLD, 11, primaryColor));
            notesTitle.setSpacingAfter(4);
            document.add(notesTitle);

            Paragraph notesPara = new Paragraph(notes, FontFactory.getFont(FontFactory.COURIER, 10, textGray));
            notesPara.setSpacingAfter(10);
            document.add(notesPara);
        }

        // تذييل
        Paragraph footer = new Paragraph("Generated on " + dateString, FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, BaseColor.LIGHT_GRAY));
        footer.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        document.add(footer);

        document.close();

        // رسالة نجاح
        Alert success = new Alert(Alert.AlertType.INFORMATION);
        success.setTitle("تم بنجاح");
        success.setHeaderText("تم إنشاء تقرير التكلفة");
        success.setContentText("التقرير محفوظ على سطح المكتب.");
        success.getDialogPane().getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
        success.showAndWait();

        // فتح الملف
        Desktop.getDesktop().open(new File(filePath));

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "خطأ في إنشاء التقرير: " + e.getMessage());
    }
    //////////////////////////// End Report //////////////////////////////
}
   
   
//@FXML
//void reportoaction(ActionEvent event)  throws IOException{  //Original
//  
//
//    if (newwebview.isVisible()) {
//        
//        
//        
////Create Report.  (PDF)
//    ////////////////////////////Start Report//////////////////////////////
//    
//    sum1=status.getText();
//    pcsnum1=pcs.getText();
//    onegar1=result.getText();
//    
//    Date currentDate = GregorianCalendar.getInstance().getTime();
//    DateFormat df = DateFormat.getDateInstance();
//    String dateString = df.format(currentDate);
//    Date d = new Date();
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    String timeString = sdf.format(d);
//    String value0 = timeString;
//    String value00 = value0.replace("/", "_");
//    String repname = "Chemical_Report_Of_"+recipenami+"";
//    String reppath = System.getProperty("user.home") + "\\Desktop";
//    FileChooser dialog = new FileChooser();
//    dialog.setInitialDirectory(new File(reppath));
//    dialog.setInitialFileName(repname);
//    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", new String[] { "*.pdf" }));
//    File dialogResult = dialog.showSaveDialog(null);
//    String filePath = dialogResult.getAbsolutePath().toString();
//    try {
//      com.itextpdf.text.Document myDocument = new com.itextpdf.text.Document();
//      PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
//      PdfPTable table = new PdfPTable(5);
//      table.size();
//      //table.setHorizontalAlignment(1);
//      myDocument.open();
//      float[] columnWidths = { 15.0F, 15.0F,15.0F,15.0F,15.0F };
//      table.setWidths(columnWidths);
//      table.setWidthPercentage(100.0F);
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Cost Report For "+recipenami+" Recipe. "+"", FontFactory.getFont("Times-Bold", 12.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------------------------------------------------------------------"));
//      table.addCell(new PdfPCell((Phrase)new Paragraph("Name", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph("Quantity", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph("Dilution", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph("Price", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph("Total", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      int no=0;
//      int stageno=1;
//      while (no<qua1.size()) {                                                                                                                
//      table.addCell(new PdfPCell((Phrase)new Paragraph(nom1.get(no), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(qua1.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(dil1.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(pri1.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString((qua1.get(no)/dil1.get(no))*pri1.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      no++;
//      } 
//      myDocument.add((com.itextpdf.text.Element)table);
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------"));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost :    "+sum1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments :    "+pcsnum1+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs :    "+onegar1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//      myDocument.setPageSize(PageSize.A4.rotate());
//      myDocument.close();
//      Alert alooo = new Alert(Alert.AlertType.CONFIRMATION);
//      alooo.setTitle("Info");
//      alooo.setHeaderText("Info!");
//      alooo.setContentText("Report was generated successfully");
//      alooo.setResizable(true);
//      DialogPane dialogPaneu = alooo.getDialogPane();
//      dialogPaneu.getStylesheets().add(
//      getClass().getResource("cupertino-light.css").toExternalForm());
//      alooo.showAndWait();
//    } catch (Exception e) {
//    } finally {
//      try {
//      } catch (Exception e) {
//      } 
//    } 
//    Desktop de = Desktop.getDesktop();
//    de.open(new File(reppath + "\\" + repname + ".pdf"));
//    ////////////////////////////End Report////////////////////////////////
//
//        
//        
//    }
//    
//    
//    
//    
//    else {
//        
//        
////Create Report.  (PDF)
//    ////////////////////////////Start Report//////////////////////////////
//    
//    sum1=status.getText();
//    pcsnum1=pcs.getText();
//    onegar1=result.getText();
//    
//    Date currentDate = GregorianCalendar.getInstance().getTime();
//    DateFormat df = DateFormat.getDateInstance();
//    String dateString = df.format(currentDate);
//    Date d = new Date();
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    String timeString = sdf.format(d);
//    String value0 = timeString;
//    String value00 = value0.replace("/", "_");
//    String repname = "Chemical_Report_Of_"+recipenami+"_Original_One";
//    String reppath = System.getProperty("user.home") + "\\Desktop";
//    FileChooser dialog = new FileChooser();
//    dialog.setInitialDirectory(new File(reppath));
//    dialog.setInitialFileName(repname);
//    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", new String[] { "*.pdf" }));
//    File dialogResult = dialog.showSaveDialog(null);
//    String filePath = dialogResult.getAbsolutePath().toString();
//    try {
//      com.itextpdf.text.Document myDocument = new com.itextpdf.text.Document();
//      PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
//      PdfPTable table = new PdfPTable(5);
//      table.size();
//      //table.setHorizontalAlignment(1);
//      myDocument.open();
//      float[] columnWidths = { 15.0F, 15.0F,15.0F,15.0F,15.0F };
//      table.setWidths(columnWidths);
//      table.setWidthPercentage(100.0F);
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Cost Report For "+recipenami+" Recipe. "+"  Original One.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------------------------------------------------------------------"));
//      table.addCell(new PdfPCell((Phrase)new Paragraph("Name", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph("Quantity", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph("Dilution", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph("Price", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph("Total", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      int no=0;
//      int stageno=1;
//      while (no<qua1.size()) {                                                                                                                
//      table.addCell(new PdfPCell((Phrase)new Paragraph(nom1.get(no), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(qua1.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(dil1.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(pri1.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString((qua1.get(no)/dil1.get(no))*pri1.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      no++;
//      } 
//      myDocument.add((com.itextpdf.text.Element)table);
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------"));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost :    "+sum1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments :    "+pcsnum1+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs :    "+onegar1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//      myDocument.setPageSize(PageSize.A4.rotate());
//      myDocument.close();
//      Alert alooo = new Alert(Alert.AlertType.CONFIRMATION);
//      alooo.setTitle("Info");
//      alooo.setHeaderText("Info!");
//      alooo.setContentText("Report was generated successfully");
//      alooo.setResizable(true);
//      DialogPane dialogPaneu = alooo.getDialogPane();
//      dialogPaneu.getStylesheets().add(
//      getClass().getResource("cupertino-light.css").toExternalForm());
//      alooo.showAndWait();
//    } catch (Exception e) {
//    } finally {
//      try {
//      } catch (Exception e) {
//      } 
//    } 
//    Desktop de = Desktop.getDesktop();
//    de.open(new File(reppath + "\\" + repname + ".pdf"));
//    ////////////////////////////End Report////////////////////////////////
//
//        
//        
//        
//    }
//    
//    
//   
//    
//    
//    
//}




@FXML
void reporteaction(ActionEvent event) throws IOException {

    // تحديد اسم الوصفة والمسار حسب الحالة
    String recipeName = newwebview.isVisible() ? recipenami1 : recipenami;
    String reportTypeSuffix = newwebview.isVisible() ? "" : "_Edited_One";
    String titleSuffix = newwebview.isVisible() ? "" : " Edited One.";

    //////////////////////////// Start Report //////////////////////////////
    Date currentDate = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String dateString = sdf.format(currentDate);
    String fileDate = dateString.replace("/", "_");
    String repname = "Chemical_Report_Of_" + recipeName + reportTypeSuffix;
    String reppath = System.getProperty("user.home") + "\\Desktop";

    FileChooser dialog = new FileChooser();
    dialog.setInitialDirectory(new File(reppath));
    dialog.setInitialFileName(repname);
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
    File dialogResult = dialog.showSaveDialog(null);

    if (dialogResult == null) return;

    String filePath = dialogResult.getAbsolutePath();

    // استخراج قيم الملخص
    String totalCost = status2.getText();
    String totalGarments = pcs.getText();
    String costPerGarment = result2.getText();

    try {
        com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A4.rotate(), 30, 30, 20, 30);
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        BaseColor primaryColor = new BaseColor(0, 102, 204);
        BaseColor headerColor = new BaseColor(0, 83, 166);
        BaseColor lightRow = new BaseColor(240, 248, 255);
        BaseColor textGray = new BaseColor(80, 80, 80);

        // لوجو صغير
        try {
            Image logo = Image.getInstance(NewDir.file_dirrrr+"\\Recipe_Indexes\\tandc.png");
            logo.scaleToFit(130, 130);
            logo.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            document.add(logo);
        } catch (Exception ignored) {}

        // العنوان الرئيسي
        Paragraph title = new Paragraph("Chemical Cost Report", FontFactory.getFont(FontFactory.TIMES_BOLD, 20, primaryColor));
        title.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        title.setSpacingAfter(6);
        document.add(title);

        Paragraph subtitle = new Paragraph("Recipe: " + recipeName + titleSuffix, FontFactory.getFont(FontFactory.TIMES_BOLD, 16, textGray));
        subtitle.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        subtitle.setSpacingAfter(8);
        document.add(subtitle);

        Paragraph datePara = new Paragraph("Report Date: " + dateString, FontFactory.getFont(FontFactory.TIMES_ROMAN, 11));
        datePara.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        datePara.setSpacingAfter(12);
        document.add(datePara);

        // جدول الكيماويات
        PdfPTable table = new PdfPTable(5);
        table.setWidthPercentage(95);
        table.setWidths(new float[]{20f, 20f, 20f, 20f, 20f});
        table.setSpacingAfter(10);

        Font headerFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 11, BaseColor.WHITE);
        Font bodyFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);

        String[] headers = {"Name", "Quantity", "Dilution", "Price", "Total"};
        for (String h : headers) {
            PdfPCell cell = new PdfPCell(new Phrase(h, headerFont));
            cell.setBackgroundColor(headerColor);
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            cell.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
            cell.setPadding(6);
            table.addCell(cell);
        }

        int rowIndex = 0;
        for (int i = 0; i < qua2.size(); i++) {
            BaseColor rowColor = (rowIndex % 2 == 0) ? lightRow : BaseColor.WHITE;
            rowIndex++;

            // Name
            PdfPCell nameCell = new PdfPCell(new Phrase(nom2.get(i), bodyFont));
            nameCell.setBackgroundColor(rowColor);
            nameCell.setPadding(6);
            table.addCell(nameCell);

            // Quantity
            PdfPCell qtyCell = new PdfPCell(new Phrase(String.valueOf(qua2.get(i)), bodyFont));
            qtyCell.setBackgroundColor(rowColor);
            qtyCell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            qtyCell.setPadding(6);
            table.addCell(qtyCell);

            // Dilution
            PdfPCell dilCell = new PdfPCell(new Phrase(String.valueOf(dil2.get(i)), bodyFont));
            dilCell.setBackgroundColor(rowColor);
            dilCell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            dilCell.setPadding(6);
            table.addCell(dilCell);

            // Price
            PdfPCell priceCell = new PdfPCell(new Phrase(String.valueOf(pri2.get(i)), bodyFont));
            priceCell.setBackgroundColor(rowColor);
            priceCell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            priceCell.setPadding(6);
            table.addCell(priceCell);

            // Total
            double total = (qua2.get(i) / dil2.get(i)) * pri2.get(i);
            PdfPCell totalCell = new PdfPCell(new Phrase(String.format("%.2f", total), bodyFont));
            totalCell.setBackgroundColor(rowColor);
            totalCell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            totalCell.setPadding(6);
            table.addCell(totalCell);
        }
        document.add(table);

        // قسم الملخص
        PdfPTable summaryTable = new PdfPTable(2);
        summaryTable.setWidthPercentage(85);
        summaryTable.setWidths(new float[]{60f, 40f});
        summaryTable.setSpacingAfter(10);

        Font labelFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 11, primaryColor);
        Font valueFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 12, headerColor);

        String[][] summaryData = {
                {"Total Cost", totalCost + " $"},
                {"Total Garments", totalGarments + " PCS"},
                {"Cost Per Garment", costPerGarment + " $"}
        };

        for (String[] row : summaryData) {
            PdfPCell labelCell = new PdfPCell(new Phrase(row[0], labelFont));
            labelCell.setBackgroundColor(new BaseColor(250, 250, 250));
            labelCell.setPadding(8);
            labelCell.setBorder(Rectangle.NO_BORDER);
            summaryTable.addCell(labelCell);

            PdfPCell valueCell = new PdfPCell(new Phrase(row[1], valueFont));
            valueCell.setBackgroundColor(new BaseColor(230, 240, 255));
            valueCell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            valueCell.setPadding(8);
            valueCell.setBorder(Rectangle.NO_BORDER);
            summaryTable.addCell(valueCell);
        }
        document.add(summaryTable);

        // ملاحظات اختيارية
        JFXTextArea notesArea = new JFXTextArea();
        notesArea.setPromptText("اكتب ملاحظات إضافية (اختياري)...");
        notesArea.setMinSize(500, 150);

        Alert notesAlert = new Alert(Alert.AlertType.CONFIRMATION);
        notesAlert.setTitle("إضافة ملاحظات؟");
        notesAlert.setHeaderText(null);
        notesAlert.setGraphic(notesArea);
        notesAlert.getDialogPane().getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
        notesAlert.showAndWait();

        String notes = notesArea.getText().trim();
        if (!notes.isEmpty()) {
            Paragraph notesTitle = new Paragraph("Notes:", FontFactory.getFont(FontFactory.TIMES_BOLD, 11, primaryColor));
            notesTitle.setSpacingAfter(4);
            document.add(notesTitle);

            Paragraph notesPara = new Paragraph(notes, FontFactory.getFont(FontFactory.COURIER, 10, textGray));
            notesPara.setSpacingAfter(10);
            document.add(notesPara);
        }

        // تذييل
        Paragraph footer = new Paragraph("Generated on " + dateString, FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, BaseColor.LIGHT_GRAY));
        footer.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        document.add(footer);

        document.close();

        // رسالة نجاح
        Alert success = new Alert(Alert.AlertType.INFORMATION);
        success.setTitle("تم بنجاح");
        success.setHeaderText("تم إنشاء تقرير التكلفة");
        success.setContentText("التقرير محفوظ على سطح المكتب.");
        success.getDialogPane().getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
        success.showAndWait();

        // فتح الملف تلقائيًا
        Desktop.getDesktop().open(new File(filePath));

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "خطأ في إنشاء التقرير: " + e.getMessage());
    }
    //////////////////////////// End Report //////////////////////////////
}





//
//@FXML
//void reporteaction(ActionEvent event)  throws IOException{ //Edited
//  
//    
//    
//    if (newwebview.isVisible()==true) {
//        
//        
//        
////Create Report.  (PDF)
//    ////////////////////////////Start Report//////////////////////////////
//    
//    sum2=status2.getText();
//    pcsnum2=pcs.getText();
//    onegar2=result2.getText();
//    
//    Date currentDate = GregorianCalendar.getInstance().getTime();
//    DateFormat df = DateFormat.getDateInstance();
//    String dateString = df.format(currentDate);
//    Date d = new Date();
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    String timeString = sdf.format(d);
//    String value0 = timeString;
//    String value00 = value0.replace("/", "_");
//    String repname = "Chemical_Report_Of_"+recipenami1+"";
//    String reppath = System.getProperty("user.home") + "\\Desktop";
//    FileChooser dialog = new FileChooser();
//    dialog.setInitialDirectory(new File(reppath));
//    dialog.setInitialFileName(repname);
//    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", new String[] { "*.pdf" }));
//    File dialogResult = dialog.showSaveDialog(null);
//    String filePath = dialogResult.getAbsolutePath().toString();
//    try {
//      com.itextpdf.text.Document myDocument = new com.itextpdf.text.Document();
//      PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
//      PdfPTable table = new PdfPTable(5);
//      table.size();
//      //table.setHorizontalAlignment(1);
//      myDocument.open();
//      float[] columnWidths = { 15.0F, 15.0F,15.0F,15.0F,15.0F };
//      table.setWidths(columnWidths);
//      table.setWidthPercentage(100.0F);
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Cost Report For "+recipenami1+" Recipe. "+"", FontFactory.getFont("Times-Bold", 12.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------------------------------------------------------------------"));
//      table.addCell(new PdfPCell((Phrase)new Paragraph("Name", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph("Quantity", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph("Dilution", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph("Price", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph("Total", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      int no=0;
//      int stageno=1;
//      while (no<qua2.size()) {                                                                                                                
//      table.addCell(new PdfPCell((Phrase)new Paragraph(nom2.get(no), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(qua2.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(dil2.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(pri2.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString((qua2.get(no)/dil2.get(no))*pri2.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      no++;
//      } 
//      myDocument.add((com.itextpdf.text.Element)table);
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------"));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost :    "+sum2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments :    "+pcsnum2+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs :    "+onegar2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//      myDocument.setPageSize(PageSize.A4.rotate());
//      myDocument.close();
//      Alert alooo = new Alert(Alert.AlertType.CONFIRMATION);
//      alooo.setTitle("Info");
//      alooo.setHeaderText("Info!");
//      alooo.setContentText("Report was generated successfully");
//      alooo.setResizable(true);
//      DialogPane dialogPaneu = alooo.getDialogPane();
//      dialogPaneu.getStylesheets().add(
//      getClass().getResource("cupertino-light.css").toExternalForm());
//      alooo.showAndWait();
//    } catch (Exception e) {
//    } finally {
//      try {
//      } catch (Exception e) {
//      } 
//    } 
//    Desktop de = Desktop.getDesktop();
//    de.open(new File(reppath + "\\" + repname + ".pdf"));
//    ////////////////////////////End Report////////////////////////////////
//
//    
//        
//        
//    }
//    
//    
//    
//    else {
//        
//        
//       
////Create Report.  (PDF)
//    ////////////////////////////Start Report//////////////////////////////
//    
//    sum2=status2.getText();
//    pcsnum2=pcs.getText();
//    onegar2=result2.getText();
//    
//    Date currentDate = GregorianCalendar.getInstance().getTime();
//    DateFormat df = DateFormat.getDateInstance();
//    String dateString = df.format(currentDate);
//    Date d = new Date();
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    String timeString = sdf.format(d);
//    String value0 = timeString;
//    String value00 = value0.replace("/", "_");
//    String repname = "Chemical_Report_Of_"+recipenami+"_Edited_One";
//    String reppath = System.getProperty("user.home") + "\\Desktop";
//    FileChooser dialog = new FileChooser();
//    dialog.setInitialDirectory(new File(reppath));
//    dialog.setInitialFileName(repname);
//    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", new String[] { "*.pdf" }));
//    File dialogResult = dialog.showSaveDialog(null);
//    String filePath = dialogResult.getAbsolutePath().toString();
//    try {
//      com.itextpdf.text.Document myDocument = new com.itextpdf.text.Document();
//      PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
//      PdfPTable table = new PdfPTable(5);
//      table.size();
//      //table.setHorizontalAlignment(1);
//      myDocument.open();
//      float[] columnWidths = { 15.0F, 15.0F,15.0F,15.0F,15.0F };
//      table.setWidths(columnWidths);
//      table.setWidthPercentage(100.0F);
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Cost Report For "+recipenami+" Recipe. "+"  Edited One.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------------------------------------------------------------------"));
//      table.addCell(new PdfPCell((Phrase)new Paragraph("Name", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph("Quantity", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph("Dilution", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph("Price", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph("Total", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      int no=0;
//      int stageno=1;
//      while (no<qua2.size()) {                                                                                                                
//      table.addCell(new PdfPCell((Phrase)new Paragraph(nom2.get(no), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(qua2.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(dil2.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(pri2.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString((qua2.get(no)/dil2.get(no))*pri2.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      no++;
//      } 
//      myDocument.add((com.itextpdf.text.Element)table);
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------"));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost :    "+sum2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments :    "+pcsnum2+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs :    "+onegar2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//      myDocument.setPageSize(PageSize.A4.rotate());
//      myDocument.close();
//      Alert alooo = new Alert(Alert.AlertType.CONFIRMATION);
//      alooo.setTitle("Info");
//      alooo.setHeaderText("Info!");
//      alooo.setContentText("Report was generated successfully");
//      alooo.setResizable(true);
//      DialogPane dialogPaneu = alooo.getDialogPane();
//      dialogPaneu.getStylesheets().add(
//      getClass().getResource("cupertino-light.css").toExternalForm());
//      alooo.showAndWait();
//    } catch (Exception e) {
//    } finally {
//      try {
//      } catch (Exception e) {
//      } 
//    } 
//    Desktop de = Desktop.getDesktop();
//    de.open(new File(reppath + "\\" + repname + ".pdf"));
//    ////////////////////////////End Report////////////////////////////////
//
//     
//        
//    }
//    
//
//    
//}







@FXML
void reportallaction(ActionEvent event) throws IOException {

    if (newwebview.isVisible()) {
        // حالة أولى: First Recipe vs Second Recipe
        generateComparisonReport("First Recipe", "Second Recipe", "We Prefer To Use Second Recipe Because It Has A Low Cost.");
    } else {
        // حالة تانية: Original Recipe vs Edited Recipe
        generateComparisonReport("Original Recipe", "Edited Recipe", "We Prefer To Use Edited Recipe Because It Has A Low Cost.");
    }
}

// دالة مساعدة عشان نكررش الكود (نفس الكود في الحالتين، بس الأسماء والتوصية بتتغير)
private void generateComparisonReport(String title1, String title2, String preferEditedMessage) throws IOException {

    // البيانات الأساسية
    String sum1 = status.getText();
    String pcsnum1 = pcs.getText();
    String onegar1 = result.getText();

    String sum2 = status2.getText();
    String pcsnum2 = pcs.getText();
    String onegar2 = result2.getText();

    Date currentDate = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String dateString = sdf.format(currentDate);
    String fileDate = dateString.replace("/", "_");
    String repname = "Chemical_Comparison_Report_" + fileDate;
    String reppath = System.getProperty("user.home") + "\\Desktop";

    FileChooser dialog = new FileChooser();
    dialog.setInitialDirectory(new File(reppath));
    dialog.setInitialFileName(repname);
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", "*.pdf"));
    File dialogResult = dialog.showSaveDialog(null);
    if (dialogResult == null) return;

    String filePath = dialogResult.getAbsolutePath();

    try {
        com.itextpdf.text.Document document = new com.itextpdf.text.Document(PageSize.A4, 35, 35, 30, 40); // Portrait مع هوامش مدروسة
        PdfWriter.getInstance(document, new FileOutputStream(filePath));
        document.open();

        // الألوان الفخمة
        BaseColor primary = new BaseColor(0, 102, 204);
        BaseColor headerBg = new BaseColor(0, 83, 166);
        BaseColor lightRow = new BaseColor(240, 248, 255);
        BaseColor accent = new BaseColor(0, 150, 136);
        BaseColor gray = new BaseColor(80, 80, 80);

        // لوجو
        try {
            Image logo = Image.getInstance(NewDir.file_dirrrr+"\\Recipe_Indexes\\tandc.png");
            logo.scaleToFit(140, 140);
            logo.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            document.add(logo);
        } catch (Exception ignored) {}

        // عنوان رئيسي
        Paragraph mainTitle = new Paragraph("Cost Comparison Report", FontFactory.getFont(FontFactory.TIMES_BOLD, 22, primary));
        mainTitle.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        mainTitle.setSpacingAfter(8);
        document.add(mainTitle);

        //First
        
        Paragraph subTitle = new Paragraph("Recipe: " + recipenami, FontFactory.getFont(FontFactory.TIMES_BOLD, 16, gray));
        subTitle.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        subTitle.setSpacingAfter(10);
        
        //Second
        
        Paragraph subTitle2 = new Paragraph("Recipe: " + recipenami1, FontFactory.getFont(FontFactory.TIMES_BOLD, 16, gray));
        subTitle2.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        subTitle2.setSpacingAfter(10);
        
        //&&
        
        Paragraph subTitle3 = new Paragraph("&&", FontFactory.getFont(FontFactory.TIMES_BOLD, 20, gray));
        subTitle3.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        subTitle3.setSpacingAfter(10);
        
        if (newwebview.isVisible()) {
        // حالة أولى: First Recipe vs Second Recipe
        document.add(subTitle);
        document.add(subTitle3);
        document.add(subTitle2);
        } else {
        // حالة تانية: Original Recipe vs Edited Recipe
        document.add(subTitle);
        }
        
        

        Paragraph datePara = new Paragraph("Generated on: " + dateString, FontFactory.getFont(FontFactory.TIMES_ROMAN, 11));
        datePara.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        datePara.setSpacingAfter(15);
        document.add(datePara);

        Font headerFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 11, BaseColor.WHITE);
        Font bodyFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);
        Font boldFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 10);

        // جدول الوصفة الأولى
        document.add(new Paragraph(title1, FontFactory.getFont(FontFactory.TIMES_BOLD, 16, primary)));
        PdfPTable table1 = createRecipeTable(headerFont, bodyFont, boldFont, lightRow, headerBg);
        fillRecipeTable(table1, nom1, qua1, dil1, pri1);
        document.add(table1);

        // ملخص الوصفة الأولى
        addRecipeSummary(document, "Total Cost", sum1 + " $", "Garments", pcsnum1 + " PCS", "Cost Per Garment", onegar1 + " $");

        // جدول الوصفة التانية
        document.add(new Paragraph(title2, FontFactory.getFont(FontFactory.TIMES_BOLD, 16, primary)));
        document.add(new Paragraph(" ", FontFactory.getFont(FontFactory.TIMES_ROMAN, 6))); // مسافة صغيرة
        PdfPTable table2 = createRecipeTable(headerFont, bodyFont, boldFont, lightRow, headerBg);
        fillRecipeTable(table2, nom2, qua2, dil2, pri2);
        document.add(table2);

        // ملخص الوصفة التانية
        addRecipeSummary(document, "Total Cost", sum2 + " $", "Garments", pcsnum2 + " PCS", "Cost Per Garment", onegar2 + " $");

        // المقارنة والتوصية
        double total1 = Double.parseDouble(sum1);
        double total2 = Double.parseDouble(sum2);
        double per1 = Double.parseDouble(onegar1);
        double per2 = Double.parseDouble(onegar2);

        double diffTotal = Math.abs(total1 - total2);
        double diffPer = Math.abs(per1 - per2);
        String formattedTotal = String.format("%.2f", diffTotal);
        String formattedPer = String.format("%.2f", diffPer);

        document.add(new Paragraph("\n"));
        document.add(new Paragraph("Comparison Summary", FontFactory.getFont(FontFactory.TIMES_BOLD, 16, primary)));
        document.add(new Paragraph("Difference in Total Cost: " + formattedTotal + " $", FontFactory.getFont(FontFactory.TIMES_BOLD, 12, accent)));
        document.add(new Paragraph("Difference Per Garment: " + formattedPer + " $", FontFactory.getFont(FontFactory.TIMES_BOLD, 12, accent)));

        String recommendation;
        if (total1 > total2) {
            recommendation = preferEditedMessage;
        } else if (total2 > total1) {
            recommendation = "We Prefer To Use " + title1 + " Because It Has A Low Cost.";
        } else {
            recommendation = "Both recipes have the same cost. Feel free to use either.";
        }

        Paragraph rec = new Paragraph(recommendation, FontFactory.getFont(FontFactory.TIMES_BOLD, 13, new BaseColor(0, 128, 0)));
        rec.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        rec.setSpacingBefore(15);
        rec.setSpacingAfter(20);
        document.add(rec);

        
        if (newwebview.isVisible()) {
        } else {
        // حالة تانية: Original Recipe vs Edited Recipe
        // جدول التغييرات في الأسماء
        addChangesTable(document, nom1, nom2);
        addChangesTablei(document, qua1, qua2);
        addChangesTable(document, unito1, unito2);
        
        }
        
        

        // تذييل
        Paragraph footer = new Paragraph("Powered By Kadysoft • Generated automatically on " + dateString, 
                FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, BaseColor.LIGHT_GRAY));
        footer.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        footer.setSpacingBefore(20);
        document.add(footer);

        document.close();

        // رسالة النجاح
        Alert success = new Alert(Alert.AlertType.INFORMATION);
        success.setTitle("تم بنجاح");
        success.setHeaderText("تم إنشاء تقرير المقارنة!");
        success.setContentText("تم حفظ التقرير على سطح المكتب.");
        success.getDialogPane().getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
        success.showAndWait();

        Desktop.getDesktop().open(new File(filePath));

    } catch (Exception e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(null, "حدث خطأ أثناء إنشاء التقرير:\n" + e.getMessage());
    }
}

// دالة لإنشاء جدول وصفة موحد
private PdfPTable createRecipeTable(Font headerFont, Font bodyFont, Font boldFont, BaseColor lightRow, BaseColor headerBg) throws DocumentException {
    PdfPTable table = new PdfPTable(5);
    table.setWidthPercentage(100);
    table.setWidths(new float[]{10f, 18f, 18f, 18f, 18f});
    table.setSpacingAfter(12);

    String[] headers = {"Name", "Quantity", "Dilution", "Price", "Total"};
    for (String h : headers) {
        PdfPCell cell = new PdfPCell(new Phrase(h, headerFont));
        cell.setBackgroundColor(headerBg);
        cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        cell.setPadding(7);
        table.addCell(cell);
    }
    return table;
}

// ملء الجدول
private void fillRecipeTable(PdfPTable table, java.util.List<String> names, java.util.List<Double> qua, 
                             java.util.List<Double> dil, java.util.List<Double> pri) {
    Font bodyFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 9);
    Font boldFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 9);
    BaseColor lightRow = new BaseColor(240, 248, 255);

    for (int i = 0; i < names.size(); i++) {
        BaseColor rowColor = (i % 2 == 0) ? lightRow : BaseColor.WHITE;

        table.addCell(createCell(names.get(i), bodyFont, rowColor, com.itextpdf.text.Element.ALIGN_LEFT));
        table.addCell(createCell(String.valueOf(qua.get(i)), bodyFont, rowColor, com.itextpdf.text.Element.ALIGN_CENTER));
        table.addCell(createCell(String.valueOf(dil.get(i)), bodyFont, rowColor, com.itextpdf.text.Element.ALIGN_CENTER));
        table.addCell(createCell(String.valueOf(pri.get(i)), bodyFont, rowColor, com.itextpdf.text.Element.ALIGN_CENTER));
        double total = (qua.get(i) / dil.get(i)) * pri.get(i);
        table.addCell(createCell(String.format("%.2f", total), boldFont, rowColor, com.itextpdf.text.Element.ALIGN_CENTER));
    }
}

// خلية مساعدة
private PdfPCell createCell(String text, Font font, BaseColor bg, int alignment) {
    PdfPCell cell = new PdfPCell(new Phrase(text, font));
    cell.setBackgroundColor(bg);
    cell.setHorizontalAlignment(alignment);
    cell.setPadding(6);
    return cell;
}

// ملخص الوصفة (كروت)
private void addRecipeSummary(com.itextpdf.text.Document doc, String l1, String v1, String l2, String v2, String l3, String v3) throws DocumentException {
    PdfPTable summary = new PdfPTable(3);
    summary.setWidthPercentage(90);
    summary.setWidths(new float[]{33f, 34f, 33f});
    summary.setSpacingBefore(8);
    summary.setSpacingAfter(15);

    Font labelFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 10, new BaseColor(0, 102, 204));
    Font valueFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 13, new BaseColor(0, 150, 136));

    String[][] data = {{l1, l2, l3}, {v1, v2, v3}};
    for (int i = 0; i < 3; i++) {
        PdfPCell label = new PdfPCell(new Phrase(data[0][i], labelFont));
        label.setBackgroundColor(new BaseColor(245, 245, 245));
        label.setPadding(10);
        label.setBorder(Rectangle.NO_BORDER);
        label.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        summary.addCell(label);

        PdfPCell value = new PdfPCell(new Phrase(data[1][i], valueFont));
        value.setBackgroundColor(new BaseColor(230, 240, 255));
        value.setPadding(10);
        value.setBorder(Rectangle.NO_BORDER);
        value.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        summary.addCell(value);
    }
    doc.add(summary);
}




private void addChangesTablei(com.itextpdf.text.Document doc,
                             List<Double> oldList,
                             List<Double> newList) throws DocumentException {

    doc.add(new Paragraph("\n"));
    Paragraph changesTitle = new Paragraph(
            "Summary of Changes in the Recipe",
            FontFactory.getFont(FontFactory.TIMES_BOLD, 16, new BaseColor(0, 102, 204))
    );
    changesTitle.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
    changesTitle.setSpacingAfter(10);
    doc.add(changesTitle);

    // ======== ALL LISTS AS DOUBLE ========
    List<Double[]> modificationsList = new ArrayList<>();
    List<Double> additionsList = new ArrayList<>();
    List<Double> removalsList = new ArrayList<>();

    // Longest Common Subsequence
    List<Double> lcs = longestCommonSubsequenceee(oldList, newList);

    int oldIdx = 0, newIdx = 0, lcsIdx = 0;

    while (oldIdx < oldList.size() || newIdx < newList.size()) {

        Double lcsItem = (lcsIdx < lcs.size()) ? lcs.get(lcsIdx) : null;
        Double oldItem = (oldIdx < oldList.size()) ? oldList.get(oldIdx) : null;
        Double newItem = (newIdx < newList.size()) ? newList.get(newIdx) : null;

        if (oldItem != null && oldItem.equals(lcsItem)
                && newItem != null && newItem.equals(lcsItem)) {

            oldIdx++;
            newIdx++;
            lcsIdx++;

        } else {
            boolean oldMatchesNext = oldItem != null && lcsItem != null && oldItem.equals(lcsItem);
            boolean newMatchesNext = newItem != null && lcsItem != null && newItem.equals(lcsItem);

            if (!oldMatchesNext && !newMatchesNext) {
                // modified
                if (oldItem != null && newItem != null) {
                    modificationsList.add(new Double[]{oldItem, newItem});
                    oldIdx++;
                    newIdx++;
                } else if (oldItem != null) {
                    removalsList.add(oldItem);
                    oldIdx++;
                } else if (newItem != null) {
                    additionsList.add(newItem);
                    newIdx++;
                }
            } else if (!oldMatchesNext) {
                removalsList.add(oldItem);
                oldIdx++;
            } else if (!newMatchesNext) {
                additionsList.add(newItem);
                newIdx++;
            }
        }
    }

    boolean hasAnyChange =
            !modificationsList.isEmpty()
                    || !additionsList.isEmpty()
                    || !removalsList.isEmpty();

    if (!hasAnyChange) {
        Paragraph noChange = new Paragraph(
                "No changes found.",
                FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, Font.ITALIC, BaseColor.GRAY)
        );
        noChange.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        noChange.setSpacingAfter(20);
        doc.add(noChange);
        return;
    }

    Font hFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 11, BaseColor.WHITE);
    Font bFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);
    BaseColor hBg = new BaseColor(0, 102, 204);
    BaseColor altRow = new BaseColor(240, 248, 255);

    // ================= MODIFIED =================
    if (!modificationsList.isEmpty()) {
        Paragraph modTitle = new Paragraph(
                "Modified Values",
                FontFactory.getFont(FontFactory.TIMES_BOLD, 14, new BaseColor(0, 102, 204))
        );
        modTitle.setSpacingBefore(10);
        modTitle.setSpacingAfter(5);
        doc.add(modTitle);

        PdfPTable changesTable = new PdfPTable(3);
        changesTable.setWidthPercentage(85);
        changesTable.setWidths(new float[]{10f, 45f, 45f});

        String[] heads = {"#", "Original Value", "Changed To"};
        for (String head : heads) {
            PdfPCell cell = new PdfPCell(new Phrase(head, hFont));
            cell.setBackgroundColor(hBg);
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            cell.setPadding(8);
            changesTable.addCell(cell);
        }

        int idx = 1;
        for (Double[] change : modificationsList) {
            BaseColor rowBg = (idx % 2 == 0) ? altRow : BaseColor.WHITE;

            changesTable.addCell(
                    createCelli(String.valueOf(idx++), bFont, rowBg,
                            com.itextpdf.text.Element.ALIGN_CENTER));

            changesTable.addCell(
                    createCelli(String.valueOf(change[0]), bFont, rowBg,
                            com.itextpdf.text.Element.ALIGN_LEFT));

            changesTable.addCell(
                    createCelli(String.valueOf(change[1]), bFont, rowBg,
                            com.itextpdf.text.Element.ALIGN_LEFT));
        }

        doc.add(changesTable);
        doc.add(new Paragraph("\n"));
    }

    // ================= ADDED =================
    if (!additionsList.isEmpty()) {
        Paragraph addTitle = new Paragraph(
                "Added Content",
                FontFactory.getFont(FontFactory.TIMES_BOLD, 14, new BaseColor(0, 153, 0))
        );
        addTitle.setSpacingBefore(10);
        addTitle.setSpacingAfter(5);
        doc.add(addTitle);

        PdfPTable addTable = new PdfPTable(2);
        addTable.setWidthPercentage(85);
        addTable.setWidths(new float[]{10f, 90f});

        addTable.addCell(createHeaderCell("#", hFont, hBg));
        addTable.addCell(createHeaderCell("Added Value", hFont, hBg));

        int idx = 1;
        for (Double added : additionsList) {
            BaseColor rowBg = (idx % 2 == 0) ? altRow : BaseColor.WHITE;

            addTable.addCell(
                    createCelli(String.valueOf(idx++), bFont, rowBg,
                            com.itextpdf.text.Element.ALIGN_CENTER));

            addTable.addCell(
                    createCelli(String.valueOf(added), bFont, rowBg,
                            com.itextpdf.text.Element.ALIGN_LEFT));
        }

        doc.add(addTable);
        doc.add(new Paragraph("\n"));
    }

    // ================= REMOVED =================
    if (!removalsList.isEmpty()) {
        Paragraph remTitle = new Paragraph(
                "Removed Content",
                FontFactory.getFont(FontFactory.TIMES_BOLD, 14, new BaseColor(204, 0, 0))
        );
        remTitle.setSpacingBefore(10);
        remTitle.setSpacingAfter(5);
        doc.add(remTitle);

        PdfPTable remTable = new PdfPTable(2);
        remTable.setWidthPercentage(85);
        remTable.setWidths(new float[]{10f, 90f});

        remTable.addCell(createHeaderCell("#", hFont, hBg));
        remTable.addCell(createHeaderCell("Removed Value", hFont, hBg));

        int idx = 1;
        for (Double removed : removalsList) {
            BaseColor rowBg = (idx % 2 == 0) ? altRow : BaseColor.WHITE;

            remTable.addCell(
                    createCelli(String.valueOf(idx++), bFont, rowBg,
                            com.itextpdf.text.Element.ALIGN_CENTER));

            remTable.addCell(
                    createCelli(String.valueOf(removed), bFont, rowBg,
                            com.itextpdf.text.Element.ALIGN_LEFT));
        }

        doc.add(remTable);
    }

    doc.add(new Paragraph(
            "--------------------------------------------------------------------------------------------",
            FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, BaseColor.LIGHT_GRAY)
    ));
}



private void addChangesTable(com.itextpdf.text.Document doc, List<String> oldList, List<String> newList) throws DocumentException {
    doc.add(new Paragraph("\n"));
    Paragraph changesTitle = new Paragraph("Summary of Changes in the Recipe",
            FontFactory.getFont(FontFactory.TIMES_BOLD, 16, new BaseColor(0, 102, 204)));
    changesTitle.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
    changesTitle.setSpacingAfter(10);
    doc.add(changesTitle);

    List<String[]> modificationsList = new ArrayList<>();
    List<String> additionsList = new ArrayList<>();
    List<String> removalsList = new ArrayList<>();

    // Longest Common Subsequence لتحديد العناصر المشتركة
    List<String> lcs = longestCommonSubsequence(oldList, newList);

    int oldIdx = 0, newIdx = 0, lcsIdx = 0;

    while (oldIdx < oldList.size() || newIdx < newList.size()) {
        String lcsItem = (lcsIdx < lcs.size()) ? lcs.get(lcsIdx) : null;
        String oldItem = (oldIdx < oldList.size()) ? oldList.get(oldIdx) : null;
        String newItem = (newIdx < newList.size()) ? newList.get(newIdx) : null;

        if (oldItem != null && oldItem.equals(lcsItem) && newItem != null && newItem.equals(lcsItem)) {
            // عنصر مشترك، لا تغيير
            oldIdx++;
            newIdx++;
            lcsIdx++;
        } else {
            boolean oldMatchesNext = (oldItem != null && lcsItem != null && oldItem.equals(lcsItem));
            boolean newMatchesNext = (newItem != null && lcsItem != null && newItem.equals(lcsItem));

            if (!oldMatchesNext && !newMatchesNext) {
                // تم تعديل العنصر
                if (oldItem != null && newItem != null) {
                    modificationsList.add(new String[]{oldItem, newItem});
                    oldIdx++;
                    newIdx++;
                } else if (oldItem != null) { // حذف
                    removalsList.add(oldItem);
                    oldIdx++;
                } else if (newItem != null) { // إضافة
                    additionsList.add(newItem);
                    newIdx++;
                }
            } else if (!oldMatchesNext) {
                // حذف
                removalsList.add(oldItem);
                oldIdx++;
            } else if (!newMatchesNext) {
                // إضافة
                additionsList.add(newItem);
                newIdx++;
            }
        }
    }

    // إنشاء الجداول
    boolean hasAnyChange = !modificationsList.isEmpty() || !additionsList.isEmpty() || !removalsList.isEmpty();

    if (!hasAnyChange) {
        Paragraph noChange = new Paragraph("No changes found.",
                FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, Font.ITALIC, BaseColor.GRAY));
        noChange.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
        noChange.setSpacingAfter(20);
        doc.add(noChange);
        return;
    }

    Font hFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 11, BaseColor.WHITE);
    Font bFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);
    BaseColor hBg = new BaseColor(0, 102, 204);
    BaseColor altRow = new BaseColor(240, 248, 255);

    // 1. جدول التعديلات
    if (!modificationsList.isEmpty()) {
        Paragraph modTitle = new Paragraph("Modified Values",
                FontFactory.getFont(FontFactory.TIMES_BOLD, 14, new BaseColor(0, 102, 204)));
        modTitle.setSpacingBefore(10);
        modTitle.setSpacingAfter(5);
        doc.add(modTitle);
        PdfPTable changesTable = new PdfPTable(3);
        changesTable.setWidthPercentage(85);
        changesTable.setWidths(new float[]{10f, 45f, 45f});
        String[] heads = {"#", "Original Name", "Changed To"};
        for (String head : heads) {
            PdfPCell cell = new PdfPCell(new Phrase(head, hFont));
            cell.setBackgroundColor(hBg);
            cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
            cell.setPadding(8);
            changesTable.addCell(cell);
        }
        int idx = 1;
        for (String[] change : modificationsList) {
            BaseColor rowBg = (idx % 2 == 0) ? altRow : BaseColor.WHITE;
            changesTable.addCell(createCelli(String.valueOf(idx++), bFont, rowBg, com.itextpdf.text.Element.ALIGN_CENTER));
            changesTable.addCell(createCelli(change[0], bFont, rowBg, com.itextpdf.text.Element.ALIGN_LEFT));
            changesTable.addCell(createCelli(change[1], bFont, rowBg, com.itextpdf.text.Element.ALIGN_LEFT));
        }
        doc.add(changesTable);
        doc.add(new Paragraph("\n"));
    }

    // 2. جدول الإضافات
    if (!additionsList.isEmpty()) {
        Paragraph addTitle = new Paragraph("Added Content",
                FontFactory.getFont(FontFactory.TIMES_BOLD, 14, new BaseColor(0, 153, 0)));
        addTitle.setSpacingBefore(10);
        addTitle.setSpacingAfter(5);
        doc.add(addTitle);
        PdfPTable addTable = new PdfPTable(2);
        addTable.setWidthPercentage(85);
        addTable.setWidths(new float[]{10f, 90f});
        addTable.addCell(createHeaderCell("#", hFont, hBg));
        addTable.addCell(createHeaderCell("Added Name", hFont, hBg));
        int idx = 1;
        for (String added : additionsList) {
            BaseColor rowBg = (idx % 2 == 0) ? altRow : BaseColor.WHITE;
            addTable.addCell(createCelli(String.valueOf(idx++), bFont, rowBg, com.itextpdf.text.Element.ALIGN_CENTER));
            addTable.addCell(createCelli(added, bFont, rowBg, com.itextpdf.text.Element.ALIGN_LEFT));
        }
        doc.add(addTable);
        doc.add(new Paragraph("\n"));
    }

    // 3. جدول الحذف
    if (!removalsList.isEmpty()) {
        Paragraph remTitle = new Paragraph("Removed Content",
                FontFactory.getFont(FontFactory.TIMES_BOLD, 14, new BaseColor(204, 0, 0)));
        remTitle.setSpacingBefore(10);
        remTitle.setSpacingAfter(5);
        doc.add(remTitle);
        PdfPTable remTable = new PdfPTable(2);
        remTable.setWidthPercentage(85);
        remTable.setWidths(new float[]{10f, 90f});
        remTable.addCell(createHeaderCell("#", hFont, hBg));
        remTable.addCell(createHeaderCell("Removed Name", hFont, hBg));
        int idx = 1;
        for (String removed : removalsList) {
            BaseColor rowBg = (idx % 2 == 0) ? altRow : BaseColor.WHITE;
            remTable.addCell(createCelli(String.valueOf(idx++), bFont, rowBg, com.itextpdf.text.Element.ALIGN_CENTER));
            remTable.addCell(createCelli(removed, bFont, rowBg, com.itextpdf.text.Element.ALIGN_LEFT));
        }
        doc.add(remTable);
    }

    doc.add(new Paragraph("--------------------------------------------------------------------------------------------",
            FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, BaseColor.LIGHT_GRAY)));
}

// دوال مساعدة
private PdfPCell createCelli(String text, Font font, BaseColor bg, int align) {
    PdfPCell cell = new PdfPCell(new Phrase(text, font));
    cell.setBackgroundColor(bg);
    cell.setHorizontalAlignment(align);
    cell.setPadding(6);
    return cell;
}

private PdfPCell createHeaderCell(String text, Font font, BaseColor bg) {
    PdfPCell cell = new PdfPCell(new Phrase(text, font));
    cell.setBackgroundColor(bg);
    cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
    cell.setPadding(8);
    return cell;
}

// خوارزمية LCS
private List<String> longestCommonSubsequence(List<String> a, List<String> b) {
    int n = a.size(), m = b.size();
    int[][] dp = new int[n + 1][m + 1];

    for (int i = n - 1; i >= 0; i--) {
        for (int j = m - 1; j >= 0; j--) {
            if (a.get(i).equals(b.get(j))) dp[i][j] = 1 + dp[i + 1][j + 1];
            else dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
        }
    }

    List<String> lcs = new ArrayList<>();
    int i = 0, j = 0;
    while (i < n && j < m) {
        if (a.get(i).equals(b.get(j))) {
            lcs.add(a.get(i));
            i++;
            j++;
        } else if (dp[i + 1][j] >= dp[i][j + 1]) i++;
        else j++;
    }
    return lcs;
}



private List<Double> longestCommonSubsequenceee(List<Double> a, List<Double> b) {

    if (a == null || b == null) {
        return new ArrayList<>();
    }

    int n = a.size();
    int m = b.size();

    int[][] dp = new int[n + 1][m + 1];

    // حساب الـ LCS length
    for (int i = n - 1; i >= 0; i--) {
        for (int j = m - 1; j >= 0; j--) {

            Double ai = a.get(i);
            Double bj = b.get(j);

            if (ai != null && ai.equals(bj)) {
                dp[i][j] = 1 + dp[i + 1][j + 1];
            } else {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
            }
        }
    }

    // استخراج الـ LCS
    List<Double> lcs = new ArrayList<>();
    int i = 0, j = 0;

    while (i < n && j < m) {

        Double ai = a.get(i);
        Double bj = b.get(j);

        if (ai != null && ai.equals(bj)) {
            lcs.add(ai);
            i++;
            j++;
        } else if (dp[i + 1][j] >= dp[i][j + 1]) {
            i++;
        } else {
            j++;
        }
    }

    return lcs;
}




//
//// جدول التغييرات المحدث (يتعامل مع التغييرات + الإضافات + الحذف)
//private void addChangesTable(com.itextpdf.text.Document doc, java.util.List<String> nom1, java.util.List<String> nom2) throws DocumentException {
//    doc.add(new Paragraph("\n"));
//    Paragraph changesTitle = new Paragraph("Summary of Changes in Chemicals",
//            FontFactory.getFont(FontFactory.TIMES_BOLD, 16, new BaseColor(0, 102, 204)));
//    changesTitle.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
//    changesTitle.setSpacingAfter(10);
//    doc.add(changesTitle);
//
//    java.util.List<String[]> modificationsList = new ArrayList<>(); // التغييرات في الأسماء
//    java.util.List<String> additionsList = new ArrayList<>();       // الإضافات الجديدة
//    java.util.List<String> removalsList = new ArrayList<>();        // الحذف
//
//    int minSize = Math.min(nom1.size(), nom2.size());
//
//    // كشف التغييرات في العناصر المشتركة (نفس الموقع)
//    for (int i = 0; i < minSize; i++) {
//        String oldName = nom1.get(i);
//        String newName = nom2.get(i);
//        if (!oldName.equals(newName)) {
//            modificationsList.add(new String[]{oldName, newName});
//        }
//    }
//
//    // الإضافات: العناصر الزيادة في القائمة الجديدة
//    if (nom2.size() > nom1.size()) {
//        for (int i = minSize; i < nom2.size(); i++) {
//            additionsList.add(nom2.get(i));
//        }
//    }
//
//    // الحذف: العناصر الزيادة في القائمة القديمة
//    if (nom1.size() > nom2.size()) {
//        for (int i = minSize; i < nom1.size(); i++) {
//            removalsList.add(nom1.get(i));
//        }
//    }
//
//    boolean hasAnyChange = !modificationsList.isEmpty() || !additionsList.isEmpty() || !removalsList.isEmpty();
//
//    if (!hasAnyChange) {
//        Paragraph noChange = new Paragraph("No changes in chemical names.",
//                FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, Font.ITALIC, BaseColor.GRAY));
//        noChange.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
//        noChange.setSpacingAfter(20);
//        doc.add(noChange);
//    } else {
//        Font hFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 11, BaseColor.WHITE);
//        Font bFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 10);
//        BaseColor hBg = new BaseColor(0, 102, 204);
//        BaseColor altRow = new BaseColor(240, 248, 255);
//
//        // 1. جدول التعديلات (Modified)
//        if (!modificationsList.isEmpty()) {
//            Paragraph modTitle = new Paragraph("Modified Chemicals",
//                    FontFactory.getFont(FontFactory.TIMES_BOLD, 14, new BaseColor(0, 102, 204)));
//            modTitle.setSpacingBefore(10);
//            modTitle.setSpacingAfter(5);
//            doc.add(modTitle);
//
//            PdfPTable changesTable = new PdfPTable(3);
//            changesTable.setWidthPercentage(85);
//            changesTable.setWidths(new float[]{10f, 45f, 45f});
//
//            String[] heads = {"#", "Original Name", "Changed To"};
//            for (String head : heads) {
//                PdfPCell cell = new PdfPCell(new Phrase(head, hFont));
//                cell.setBackgroundColor(hBg);
//                cell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
//                cell.setPadding(8);
//                changesTable.addCell(cell);
//            }
//
//            int idx = 1;
//            for (String[] change : modificationsList) {
//                BaseColor rowBg = (idx % 2 == 0) ? altRow : BaseColor.WHITE;
//                changesTable.addCell(createCell(String.valueOf(idx++), bFont, rowBg, com.itextpdf.text.Element.ALIGN_CENTER));
//                changesTable.addCell(createCell(change[0], bFont, rowBg, com.itextpdf.text.Element.ALIGN_LEFT));
//                changesTable.addCell(createCell(change[1], bFont, rowBg, com.itextpdf.text.Element.ALIGN_LEFT));
//            }
//            doc.add(changesTable);
//            doc.add(new Paragraph("\n"));
//        }
//
//        // 2. جدول الإضافات (Added)
//        if (!additionsList.isEmpty()) {
//            Paragraph addTitle = new Paragraph("Added Chemicals",
//                    FontFactory.getFont(FontFactory.TIMES_BOLD, 14, new BaseColor(0, 153, 0))); // لون أخضر
//            addTitle.setSpacingBefore(10);
//            addTitle.setSpacingAfter(5);
//            doc.add(addTitle);
//
//            PdfPTable addTable = new PdfPTable(2);
//            addTable.setWidthPercentage(85);
//            addTable.setWidths(new float[]{10f, 90f});
//
//            PdfPCell headNum = new PdfPCell(new Phrase("#", hFont));
//            headNum.setBackgroundColor(hBg);
//            headNum.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
//            headNum.setPadding(8);
//            addTable.addCell(headNum);
//
//            PdfPCell headName = new PdfPCell(new Phrase("Added Name", hFont));
//            headName.setBackgroundColor(hBg);
//            headName.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
//            headName.setPadding(8);
//            addTable.addCell(headName);
//
//            int idx = 1;
//            for (String added : additionsList) {
//                BaseColor rowBg = (idx % 2 == 0) ? altRow : BaseColor.WHITE;
//                addTable.addCell(createCell(String.valueOf(idx++), bFont, rowBg, com.itextpdf.text.Element.ALIGN_CENTER));
//                addTable.addCell(createCell(added, bFont, rowBg, com.itextpdf.text.Element.ALIGN_LEFT));
//            }
//            doc.add(addTable);
//            doc.add(new Paragraph("\n"));
//        }
//
//        // 3. جدول الحذف (Removed)
//        if (!removalsList.isEmpty()) {
//            Paragraph remTitle = new Paragraph("Removed Chemicals",
//                    FontFactory.getFont(FontFactory.TIMES_BOLD, 14, new BaseColor(204, 0, 0))); // لون أحمر
//            remTitle.setSpacingBefore(10);
//            remTitle.setSpacingAfter(5);
//            doc.add(remTitle);
//
//            PdfPTable remTable = new PdfPTable(2);
//            remTable.setWidthPercentage(85);
//            remTable.setWidths(new float[]{10f, 90f});
//
//            PdfPCell headNum = new PdfPCell(new Phrase("#", hFont));
//            headNum.setBackgroundColor(hBg);
//            headNum.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
//            headNum.setPadding(8);
//            remTable.addCell(headNum);
//
//            PdfPCell headName = new PdfPCell(new Phrase("Removed Name", hFont));
//            headName.setBackgroundColor(hBg);
//            headName.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
//            headName.setPadding(8);
//            remTable.addCell(headName);
//
//            int idx = 1;
//            for (String removed : removalsList) {
//                BaseColor rowBg = (idx % 2 == 0) ? altRow : BaseColor.WHITE;
//                remTable.addCell(createCell(String.valueOf(idx++), bFont, rowBg, com.itextpdf.text.Element.ALIGN_CENTER));
//                remTable.addCell(createCell(removed, bFont, rowBg, com.itextpdf.text.Element.ALIGN_LEFT));
//            }
//            doc.add(remTable);
//        }
//    }
//
//    doc.add(new Paragraph("--------------------------------------------------------------------------------------------",
//            FontFactory.getFont(FontFactory.TIMES_ROMAN, 9, BaseColor.LIGHT_GRAY)));
//}











//
//@FXML
//void reportallaction(ActionEvent event)  throws IOException{
//
//    
//    if (newwebview.isVisible()==true) {
//        
//      
////Create Report.  (PDF)
//    ////////////////////////////Start Report//////////////////////////////
//    
//    sum1=status.getText();
//    pcsnum1=pcs.getText();
//    onegar1=result.getText();
//    
//    sum2=status2.getText();
//    pcsnum2=pcs.getText();
//    onegar2=result2.getText();
//    
//    
//    Date currentDate = GregorianCalendar.getInstance().getTime();
//    DateFormat df = DateFormat.getDateInstance();
//    String dateString = df.format(currentDate);
//    Date d = new Date();
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    String timeString = sdf.format(d);
//    String value0 = timeString;
//    String value00 = value0.replace("/", "_");
//    String repname = "Chemical_Report_Of_"+"ALL";
//    String reppath = System.getProperty("user.home") + "\\Desktop";
//    FileChooser dialog = new FileChooser();
//    dialog.setInitialDirectory(new File(reppath));
//    dialog.setInitialFileName(repname);
//    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", new String[] { "*.pdf" }));
//    File dialogResult = dialog.showSaveDialog(null);
//    String filePath = dialogResult.getAbsolutePath().toString();
//    try {
//      com.itextpdf.text.Document myDocument = new com.itextpdf.text.Document();
//      //myDocument.setPageSize(PageSize.A4.rotate());
//      PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
//      myDocument.open();
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Cost Report For "+recipenami+" Recipe. "+"_ALL.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺"));
//      PdfPTable table1 = new PdfPTable(5);
//      table1.size();
//      //table1.setWidthPercentage(45);
//      float[] columnWidths1 = { 15.0F, 15.0F,15.0F,15.0F,15.0F };
//      table1.setWidths(columnWidths1);
//      table1.setWidthPercentage(100);
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("First Recipe", FontFactory.getFont("Times-Bold", 12.0F, 1)));
//      table1.addCell(new PdfPCell((Phrase)new Paragraph("Name", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table1.addCell(new PdfPCell((Phrase)new Paragraph("Quantity", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table1.addCell(new PdfPCell((Phrase)new Paragraph("Dilution", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table1.addCell(new PdfPCell((Phrase)new Paragraph("Price", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table1.addCell(new PdfPCell((Phrase)new Paragraph("Total", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      int no1=0;
//      int stagen1o=1;
//      while (no1<qua1.size()) {                                                                                                                
//      table1.addCell(new PdfPCell((Phrase)new Paragraph(nom1.get(no1), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table1.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(qua1.get(no1)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table1.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(dil1.get(no1)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table1.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(pri1.get(no1)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table1.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString((qua1.get(no1)/dil1.get(no1))*pri1.get(no1)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      no1++;
//      }
//      
//      
//      
//      myDocument.add((com.itextpdf.text.Element)table1);
//      
//      //myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost :    "+sum1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments :    "+pcsnum1+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs :    "+onegar1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
//      //myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Second Recipe", FontFactory.getFont("Times-Bold", 12.0F, 1)));
//      
//    
//      
//      
//      
//      //int rowsTable1 = 5; 
//      
//      PdfPTable table2 = new PdfPTable(5);
//      table2.size();
//      //table2.setWidthPercentage(45);
//      float[] columnWidths2 = { 15.0F, 15.0F,15.0F,15.0F,15.0F };
//      table2.setWidths(columnWidths2);
//      table2.setWidthPercentage(100.0F);
//      
//      table2.addCell(new PdfPCell((Phrase)new Paragraph("Name", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table2.addCell(new PdfPCell((Phrase)new Paragraph("Quantity", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table2.addCell(new PdfPCell((Phrase)new Paragraph("Dilution", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table2.addCell(new PdfPCell((Phrase)new Paragraph("Price", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table2.addCell(new PdfPCell((Phrase)new Paragraph("Total", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      int no2=0;
//      int stageno=1;
//      while (no2<qua2.size()) {                                                                                                                
//      table2.addCell(new PdfPCell((Phrase)new Paragraph(nom2.get(no2), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table2.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(qua2.get(no2)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table2.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(dil2.get(no2)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table2.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(pri2.get(no2)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table2.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString((qua2.get(no2)/dil2.get(no2))*pri2.get(no2)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      no2++;
//      }
//      
//      //int rowsTable2 = 3;
//      
//        
//      
//      myDocument.add((com.itextpdf.text.Element)table2);
//   
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
//      //myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost :    "+sum2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments :    "+pcsnum2+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs :    "+onegar2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      //myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
////      
////            PdfPTable parentTable = new PdfPTable(3); // Parent table with 3 columns (table1, VS, table2)
////            parentTable.setWidthPercentage(100); // Full width of the page
////            parentTable.getDefaultCell().setBorder(0);
////
////            // Add the first table to the parent table
////            PdfPCell table1Cell = new PdfPCell(table1);
////            table1Cell.setBorder(Rectangle.NO_BORDER);
////            parentTable.addCell(table1Cell);
////
////            // Corrected "VS" cell creation
////PdfPCell vsCell = new PdfPCell(new Phrase("VS", FontFactory.getFont("Times-Bold", 20, BaseColor.RED)));
////vsCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
////vsCell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE); // Corrected line
////vsCell.setBorder(Rectangle.NO_BORDER);
////parentTable.addCell(vsCell);
////
////
////            // Add the second table to the parent table
////            PdfPCell table2Cell = new PdfPCell(table2);
////            table2Cell.setBorder(Rectangle.NO_BORDER);
////            parentTable.addCell(table2Cell);
//      
//      
////      PdfPTable parentTable = new PdfPTable(2); // Parent table with 2 columns
////      parentTable.setWidthPercentage(100); // Full width of the page
////      parentTable.getDefaultCell().setBorder(0);
////      parentTable.addCell(table1); // Add first table
////      parentTable.addCell(table2); // Add second table
//      
//     // myDocument.add((com.itextpdf.text.Element)parentTable);
//
////      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------"));
////      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost (Original) :    "+sum1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
////      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments (Original) :    "+pcsnum1+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
////      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs (Original) :    "+onegar1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
////      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
////      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
////      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost (Edited) :    "+sum2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
////      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments (Edited) :    "+pcsnum2+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
////      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs (Edited) :    "+onegar2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
////      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
////      
//      if (Double.parseDouble(sum1)>Double.parseDouble(sum2)) {
//          
//      double vx=Double.parseDouble(sum1)-Double.parseDouble(sum2);
//      String formatted1 = String.format("%.2f", vx);
//      double vxo=Double.parseDouble(formatted1);
//      
//      double vxxx=Double.parseDouble(onegar1)-Double.parseDouble(onegar2);
//      String formatted2 = String.format("%.2f", vxxx);
//      double vxxxo=Double.parseDouble(formatted2);
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (All) Is :    "+vxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (One Garment) Is :    "+vxxxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//      
//      //myDocument.add((com.itextpdf.text.Element)new Paragraph("💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧"));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("We Prefer To Use Second Recipe Because It Has A Low Cost.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//          
//      }
//      else if (Double.parseDouble(sum2)>Double.parseDouble(sum1)) {
//          
//      double vx=Double.parseDouble(sum2)-Double.parseDouble(sum1); 
//      String formatted1 = String.format("%.2f", vx);
//      double vxo=Double.parseDouble(formatted1);
//      
//      double vxxx=Double.parseDouble(onegar2)-Double.parseDouble(onegar1);
//      String formatted2 = String.format("%.2f", vxxx);
//      double vxxxo=Double.parseDouble(formatted2);
//          
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (All) Is :    "+vxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (One Garment) Is :    "+vxxxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//      
//      
//      
//      
//      //myDocument.add((com.itextpdf.text.Element)new Paragraph("🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂"));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("We Prefer To Use First Recipe Because It Has A Low Cost.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//          
//      }
//      else if (Double.parseDouble(sum1)==Double.parseDouble(sum2)) {
//          
//      double vx=Double.parseDouble(sum2)-Double.parseDouble(sum1);
//      String formatted1 = String.format("%.2f", vx);
//      double vxo=Double.parseDouble(formatted1);
//      
//      double vxxx=Double.parseDouble(onegar2)-Double.parseDouble(onegar1);
//      String formatted2 = String.format("%.2f", vxxx);
//      double vxxxo=Double.parseDouble(formatted2);
//          
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (All) Is :    "+vxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥"));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (One Garment) Is :    "+vxxxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//      
//      //myDocument.add((com.itextpdf.text.Element)new Paragraph("⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡"));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("We Found That First And Second Have The Same Cost, So Feel Free To Use Anyone Of Them.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      
//      //myDocument.add((com.itextpdf.text.Element)new Paragraph("✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔"));
//          
//      }
//      
//      
//      
//      
//      //myDocument.setPageSize(PageSize.A4.rotate());
//      myDocument.close();
//      Alert alooo = new Alert(Alert.AlertType.CONFIRMATION);
//      alooo.setTitle("Info");
//      alooo.setHeaderText("Info!");
//      alooo.setContentText("Report was generated successfully");
//      alooo.setResizable(true);
//      DialogPane dialogPaneu = alooo.getDialogPane();
//      dialogPaneu.getStylesheets().add(
//      getClass().getResource("cupertino-light.css").toExternalForm());
//      alooo.showAndWait();
//    } catch (Exception e) {
//    } finally {
//      try {
//      } catch (Exception e) {
//      } 
//    } 
//    Desktop de = Desktop.getDesktop();
//    de.open(new File(reppath + "\\" + repname + ".pdf"));
//    ////////////////////////////End Report////////////////////////////////
//
//    
//    
//      
//        
//        
//    }
//    
//    /////////////////////////////////////End 1 Start 2////////////////////////////////////
//    
//    else {
//        
//        
//        
////Create Report.  (PDF)
//    ////////////////////////////Start Report//////////////////////////////
//    
//    sum1=status.getText();
//    pcsnum1=pcs.getText();
//    onegar1=result.getText();
//    
//    sum2=status2.getText();
//    pcsnum2=pcs.getText();
//    onegar2=result2.getText();
//    
//    
//    Date currentDate = GregorianCalendar.getInstance().getTime();
//    DateFormat df = DateFormat.getDateInstance();
//    String dateString = df.format(currentDate);
//    Date d = new Date();
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//    String timeString = sdf.format(d);
//    String value0 = timeString;
//    String value00 = value0.replace("/", "_");
//    String repname = "Chemical_Report_Of_"+"ALL";
//    String reppath = System.getProperty("user.home") + "\\Desktop";
//    FileChooser dialog = new FileChooser();
//    dialog.setInitialDirectory(new File(reppath));
//    dialog.setInitialFileName(repname);
//    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", new String[] { "*.pdf" }));
//    File dialogResult = dialog.showSaveDialog(null);
//    String filePath = dialogResult.getAbsolutePath().toString();
//    try {
//      com.itextpdf.text.Document myDocument = new com.itextpdf.text.Document();
//      //myDocument.setPageSize(PageSize.A4.rotate());
//      PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
//      myDocument.open();
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Cost Report For "+recipenami+" Recipe. "+"_ALL.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺"));
//      PdfPTable table1 = new PdfPTable(5);
//      table1.size();
//      //table1.setWidthPercentage(45);
//      float[] columnWidths1 = { 15.0F, 15.0F,15.0F,15.0F,15.0F };
//      table1.setWidths(columnWidths1);
//      table1.setWidthPercentage(100);
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Original Recipe", FontFactory.getFont("Times-Bold", 12.0F, 1)));
//      table1.addCell(new PdfPCell((Phrase)new Paragraph("Name", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table1.addCell(new PdfPCell((Phrase)new Paragraph("Quantity", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table1.addCell(new PdfPCell((Phrase)new Paragraph("Dilution", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table1.addCell(new PdfPCell((Phrase)new Paragraph("Price", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table1.addCell(new PdfPCell((Phrase)new Paragraph("Total", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      int no1=0;
//      int stagen1o=1;
//      while (no1<qua1.size()) {                                                                                                                
//      table1.addCell(new PdfPCell((Phrase)new Paragraph(nom1.get(no1), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table1.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(qua1.get(no1)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table1.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(dil1.get(no1)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table1.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(pri1.get(no1)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table1.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString((qua1.get(no1)/dil1.get(no1))*pri1.get(no1)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      no1++;
//      }
//      
//      
//      
//      myDocument.add((com.itextpdf.text.Element)table1);
//      
//      //myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost (Original) :    "+sum1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments (Original) :    "+pcsnum1+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs (Original) :    "+onegar1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
//      //myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Edited Recipe", FontFactory.getFont("Times-Bold", 12.0F, 1)));
//      
//    
//      
//      
//      
//      //int rowsTable1 = 5; 
//      
//      PdfPTable table2 = new PdfPTable(5);
//      table2.size();
//      //table2.setWidthPercentage(45);
//      float[] columnWidths2 = { 15.0F, 15.0F,15.0F,15.0F,15.0F };
//      table2.setWidths(columnWidths2);
//      table2.setWidthPercentage(100.0F);
//      
//      table2.addCell(new PdfPCell((Phrase)new Paragraph("Name", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table2.addCell(new PdfPCell((Phrase)new Paragraph("Quantity", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table2.addCell(new PdfPCell((Phrase)new Paragraph("Dilution", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table2.addCell(new PdfPCell((Phrase)new Paragraph("Price", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      table2.addCell(new PdfPCell((Phrase)new Paragraph("Total", FontFactory.getFont("Times-Roman", 10.0F, 1))));
//      int no2=0;
//      int stageno=1;
//      while (no2<qua2.size()) {                                                                                                                
//      table2.addCell(new PdfPCell((Phrase)new Paragraph(nom2.get(no2), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table2.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(qua2.get(no2)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table2.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(dil2.get(no2)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table2.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(pri2.get(no2)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      table2.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString((qua2.get(no2)/dil2.get(no2))*pri2.get(no2)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
//      no2++;
//      }
//      
//      //int rowsTable2 = 3;
//      
//        
//      
//      myDocument.add((com.itextpdf.text.Element)table2);
//   
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
//      //myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost (Edited) :    "+sum2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments (Edited) :    "+pcsnum2+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs (Edited) :    "+onegar2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      //myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
////      
////            PdfPTable parentTable = new PdfPTable(3); // Parent table with 3 columns (table1, VS, table2)
////            parentTable.setWidthPercentage(100); // Full width of the page
////            parentTable.getDefaultCell().setBorder(0);
////
////            // Add the first table to the parent table
////            PdfPCell table1Cell = new PdfPCell(table1);
////            table1Cell.setBorder(Rectangle.NO_BORDER);
////            parentTable.addCell(table1Cell);
////
////            // Corrected "VS" cell creation
////PdfPCell vsCell = new PdfPCell(new Phrase("VS", FontFactory.getFont("Times-Bold", 20, BaseColor.RED)));
////vsCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
////vsCell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE); // Corrected line
////vsCell.setBorder(Rectangle.NO_BORDER);
////parentTable.addCell(vsCell);
////
////
////            // Add the second table to the parent table
////            PdfPCell table2Cell = new PdfPCell(table2);
////            table2Cell.setBorder(Rectangle.NO_BORDER);
////            parentTable.addCell(table2Cell);
//      
//      
////      PdfPTable parentTable = new PdfPTable(2); // Parent table with 2 columns
////      parentTable.setWidthPercentage(100); // Full width of the page
////      parentTable.getDefaultCell().setBorder(0);
////      parentTable.addCell(table1); // Add first table
////      parentTable.addCell(table2); // Add second table
//      
//     // myDocument.add((com.itextpdf.text.Element)parentTable);
//
////      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------"));
////      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost (Original) :    "+sum1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
////      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments (Original) :    "+pcsnum1+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
////      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs (Original) :    "+onegar1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
////      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
////      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
////      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost (Edited) :    "+sum2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
////      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments (Edited) :    "+pcsnum2+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
////      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs (Edited) :    "+onegar2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
////      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
////      
//      if (Double.parseDouble(sum1)>Double.parseDouble(sum2)) {
//          
//      double vx=Double.parseDouble(sum1)-Double.parseDouble(sum2);
//      String formatted1 = String.format("%.2f", vx);
//      double vxo=Double.parseDouble(formatted1);
//      
//      double vxxx=Double.parseDouble(onegar1)-Double.parseDouble(onegar2);
//      String formatted2 = String.format("%.2f", vxxx);
//      double vxxxo=Double.parseDouble(formatted2);
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (All) Is :    "+vxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (One Garment) Is :    "+vxxxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//      
//      //myDocument.add((com.itextpdf.text.Element)new Paragraph("💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧"));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("We Prefer To Use Edited Recipe Because It Has A Low Cost.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//          
//      }
//      else if (Double.parseDouble(sum2)>Double.parseDouble(sum1)) {
//          
//      double vx=Double.parseDouble(sum2)-Double.parseDouble(sum1); 
//      String formatted1 = String.format("%.2f", vx);
//      double vxo=Double.parseDouble(formatted1);
//      
//      double vxxx=Double.parseDouble(onegar2)-Double.parseDouble(onegar1);
//      String formatted2 = String.format("%.2f", vxxx);
//      double vxxxo=Double.parseDouble(formatted2);
//          
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (All) Is :    "+vxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (One Garment) Is :    "+vxxxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//      
//      
//      
//      
//      //myDocument.add((com.itextpdf.text.Element)new Paragraph("🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂"));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("We Prefer To Use Original Recipe Because It Has A Low Cost.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//          
//      }
//      else if (Double.parseDouble(sum1)==Double.parseDouble(sum2)) {
//          
//      double vx=Double.parseDouble(sum2)-Double.parseDouble(sum1);
//      String formatted1 = String.format("%.2f", vx);
//      double vxo=Double.parseDouble(formatted1);
//      
//      double vxxx=Double.parseDouble(onegar2)-Double.parseDouble(onegar1);
//      String formatted2 = String.format("%.2f", vxxx);
//      double vxxxo=Double.parseDouble(formatted2);
//          
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (All) Is :    "+vxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥"));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (One Garment) Is :    "+vxxxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//      
//      //myDocument.add((com.itextpdf.text.Element)new Paragraph("⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡"));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("We Found That Original And Edited Have The Same Cost, So Feel Free To Use Anyone Of Them.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));      
//
//      //myDocument.add((com.itextpdf.text.Element)new Paragraph("✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔"));
//          
//      }
//      
//         
//      
//     //////////// Changes Table - Modern & Professional ////////////
//
//myDocument.add(new Paragraph("\n")); // مسافة قبل الجدول
//
//// عنوان القسم
//Paragraph changesTitle = new Paragraph("Summary Of Changes In Chemicals", 
//    FontFactory.getFont(FontFactory.TIMES_BOLD, 16, new BaseColor(0, 102, 204))); // لون أزرق غامق
//changesTitle.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
//changesTitle.setSpacingBefore(20);
//changesTitle.setSpacingAfter(15);
//myDocument.add(changesTitle);
//
//// بناء قائمة التغييرات
//java.util.List<String[]> changesList = new ArrayList<>();
//int minSize = Math.min(nom1.size(), nom2.size());
//
//for (int i = 0; i < minSize; i++) {
//    String namee1 = nom1.get(i);
//    String namee2 = nom2.get(i);
//    
//    if (!namee1.equals(namee2)) {
//        changesList.add(new String[]{namee1, namee2});
//    }
//}
//
//// لو مفيش تغييرات
//if (changesList.isEmpty()) {
//    Paragraph noChanges = new Paragraph("No chemical names were changed.", 
//        FontFactory.getFont(FontFactory.TIMES_ROMAN, 12, Font.ITALIC, BaseColor.GRAY));
//    noChanges.setAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
//    noChanges.setSpacingBefore(10);
//    noChanges.setSpacingAfter(20);
//    myDocument.add(noChanges);
//} else {
//    // إنشاء الجدول بـ 3 أعمدة: رقم، الاسم القديم، الاسم الجديد
//    PdfPTable changesTable = new PdfPTable(3);
//    changesTable.setWidthPercentage(90);
//    changesTable.setSpacingBefore(10);
//    changesTable.setSpacingAfter(20);
//    
//    float[] columnWidths = {10f, 45f, 45f}; // نسب الأعمدة
//    changesTable.setWidths(columnWidths);
//    
//    // إعدادات الخلايا
//    Font headerFont = FontFactory.getFont(FontFactory.TIMES_BOLD, 12, BaseColor.WHITE);
//    Font bodyFont = FontFactory.getFont(FontFactory.TIMES_ROMAN, 11, BaseColor.BLACK);
//    
//    BaseColor headerColor = new BaseColor(0, 102, 204); // أزرق غامق
//    BaseColor lightRow = new BaseColor(240, 248, 255); // خلفية فاتحة للصفوف (زي alternate rows)
//    
//    // الهيدر
//    String[] headers = {"#", "Original Name", "Changed To"};
//    for (String header : headers) {
//        PdfPCell headerCell = new PdfPCell(new Phrase(header, headerFont));
//        headerCell.setBackgroundColor(headerColor);
//        headerCell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
//        headerCell.setVerticalAlignment(com.itextpdf.text.Element.ALIGN_MIDDLE);
//        headerCell.setPadding(10);
//        changesTable.addCell(headerCell);
//    }
//    
//    // الصفوف
//    int index = 1;
//    for (String[] change : changesList) {
//        BaseColor rowColor = (index % 2 == 0) ? lightRow : BaseColor.WHITE;
//        
//        // الرقم
//        PdfPCell numCell = new PdfPCell(new Phrase(String.valueOf(index), bodyFont));
//        numCell.setBackgroundColor(rowColor);
//        numCell.setHorizontalAlignment(com.itextpdf.text.Element.ALIGN_CENTER);
//        numCell.setPadding(8);
//        changesTable.addCell(numCell);
//        
//        // الاسم القديم
//        PdfPCell oldCell = new PdfPCell(new Phrase(change[0], bodyFont));
//        oldCell.setBackgroundColor(rowColor);
//        oldCell.setPadding(8);
//        changesTable.addCell(oldCell);
//        
//        // الاسم الجديد
//        PdfPCell newCell = new PdfPCell(new Phrase(change[1], bodyFont));
//        newCell.setBackgroundColor(rowColor);
//        newCell.setPadding(8);
//        changesTable.addCell(newCell);
//        
//        index++;
//    }
//    
//    // إضافة الجدول للـ PDF
//    myDocument.add(changesTable);
//}
//
//// خط فاصل أنيق في النهاية
//myDocument.add(new Paragraph("--------------------------------------------------------------------------------------------", 
//    FontFactory.getFont(FontFactory.TIMES_ROMAN, 10, BaseColor.LIGHT_GRAY)));
//myDocument.add(new Paragraph("\n"));
//
//      
//      //myDocument.setPageSize(PageSize.A4.rotate());
//      myDocument.close();
//      Alert alooo = new Alert(Alert.AlertType.CONFIRMATION);
//      alooo.setTitle("Info");
//      alooo.setHeaderText("Info!");
//      alooo.setContentText("Report was generated successfully");
//      alooo.setResizable(true);
//      DialogPane dialogPaneu = alooo.getDialogPane();
//      dialogPaneu.getStylesheets().add(
//      getClass().getResource("cupertino-light.css").toExternalForm());
//      alooo.showAndWait();
//    } catch (Exception e) {
//    } finally {
//      try {
//      } catch (Exception e) {
//      } 
//    } 
//    Desktop de = Desktop.getDesktop();
//    de.open(new File(reppath + "\\" + repname + ".pdf"));
//    ////////////////////////////End Report////////////////////////////////
//
//    
//    
//    
//        
//        
//        
//    }
//    
//    //////////////////////End All//////////////////////////////////////////
//    
//}
//    
    
    @FXML
void clearallaction(ActionEvent event)  throws IOException{
    
    recipelink.clear();
    status.setText("Chemical Cost");
    result.setText("Result");
    status2.setText("Chemical Cost");
    result2.setText("Result");
    lili1.clear();
    lili.clear();
    lili2.clear();
    webview.getEngine().loadContent("");
    newwebview.getEngine().loadContent("");
    
    refresh.setDisable(true);
    calculate.setDisable(true);
    calnew.setDisable(true);
    
}



    
@FXML
void browseaction(ActionEvent event)  throws IOException, Exception{
    
    
    
    
    

        
FileChooser fcho = new FileChooser();
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
fcho.setTitle("Kady Choose");
File f = fcho.showOpenDialog((Window)null);
recipenami=f.getName().replace(".ks","").replace(".html","");
String recipepathy = f.getAbsolutePath().toString();
recipelink.setText(recipepathy);  


//Read File Here//////////////////////////////////////////////////////////////////////////////////////////////////


  ////////////////////////////////////////////////////////////

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
    String resultp = KeyDecoder.extractData(longKey.trim());
    if (f == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = f.getAbsolutePath();
    String nameofit=recipenami;
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
 
    FileDecryptor.decrypt(input, tempOutput, resultp);
    File temp = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////


//////////////////////////////////////////////////////////////////////////////////////////////////////////
InputStream inputinstream=new FileInputStream(temp);
BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
String lo;


lili.clear();

//lili.appendText(      
//            
//             "<script>\n" +
//"        document.addEventListener('dragstart', function(event) {\n" +
//"            event.preventDefault();\n" +
//"        });\n" +
//"\n" +
//"        document.addEventListener('drop', function(event) {\n" +
//"            event.preventDefault();\n" +
//"        });\n" +
//"\n" +
//"        document.addEventListener('contextmenu', function(event) {\n" +
//"            event.preventDefault();\n" +
//"        });\n" +
//"    </script>"  
//            
//            + "<script>\n" +
//"  \n" +
//"  window.addEventListener(`contextmenu`, (e) => {\n" +
//"    e.preventDefault();\n" +
//"});\n" +
//"  \n" +
//"  </script>"
//           
//            + "<script>\n" +
//"        document.addEventListener('keydown', function (event) {\n" +
//"            // Check if Ctrl + C is pressed\n" +
//"            if (event.ctrlKey && event.key === 'c') {\n" +
//"                event.preventDefault();  // Prevent the default action (copy)\n" +
//"            }\n" +
//"        });\n" +
//"    </script>"
//        
//        
//            
//         );



while ((lo=bi.readLine())!=null) {        
lili.appendText("\n"+lo
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
String gf=lili.getText().replace("<HTML ","<HTML CONTENTEDITABLE ").replace("-WEBKIT-USER-SELECT:","").replace("-MOZ-USER-SELECT:","").replace("-MS-USER-SELECT:","").replace("DOCUMENT.ADDEVENTLISTENER","").replace("USER-SELECT:","").replace("EVENT.PREVENTDEFAULT();","").replace("E.PREVENTDEFAULT();","").replace("<html ","<html contenteditable ").replace("-webkit-user-select:","").replace("-moz-user-select:","").replace("-ms-user-select:","").replace("document.addeventlistener","").replace("user-select:","").replace("event.preventdefault();","").replace("e.preventdefault();","").replace("<html ","<html contenteditable ").replace("-webkit-user-select:","").replace("-moz-user-select:","").replace("-ms-user-select:","").replace("document.addEventListener","").replace("user-select:","").replace("event.preventDefault();","").replace("e.preventDefault();","");



///////////Read Here/////////

String coco=gf.replaceAll("<HTML", "<HTML CONTENTEDITABLE");
webview.getEngine().loadContent(coco);

/////////////////////////////

OutputStream instreamm=new FileOutputStream(System.getProperty("user.home")+"\\ru.ks");
PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
pwe.println(gf);
pwe.close();



///////////////////////////////////////////////////////////////////////////////////////////////////////////   
pri1 = new ArrayList<>();
qua1= new ArrayList<>();
dil1 = new ArrayList<>();
nom1 = new ArrayList<>();
unito1 = new ArrayList<>();

////////////////////////////////////////////////
File inputFile = new File(System.getProperty("user.home")+"\\ru.ks"); //
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
pri1.add(number1);
String itaam = linebeforeequal;
nom1.add(itaam);
unito1.add(tds.get(6).text());
found = true;
break;
}
}
buf.close();   
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
qua1.add(val);   
}
else {
qua1.add(am);
}
}

else if (tds.get(6).text().contains("GARDAL")||tds.get(6).text().contains("GARDEL")
||tds.get(6).text().contains("Gardal")||tds.get(6).text().contains("Gardel")||tds.get(6).text().contains("gardal")||tds.get(6).text().contains("gardel")) {
String sky=tds.get(8).text();
if (sky.equals("FOAM")) {
double am=4.0/5.0;
qua1.add(am);   
}
else {
double am=Double.parseDouble(tds.get(5).text().replace(",","."))*12;
qua1.add(am);    
}
}
else {
double number2 = Double.parseDouble(tds.get(5).text());
qua1.add(number2);
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
dil1.add(number3);
found = true;
break;
}
}
if (!found) {
double number3 = Double.parseDouble("1.0");
dil1.add(number3);
}
buf.close();
}
///////////////////////////////////////////////
}}    
if (qua1.size()!=pri1.size()||qua1.size()!=dil1.size()) { 

    //Write Here About Status in red Color
    status.setText("Error-Fix Chemicals");
    status.setStyle("-fx-text-fill:red;");
    refresh.setDisable(false);
    
}
else {
//Show alert to write pcs.    
List<Double> result = new ArrayList<>();
for (int i = 0; i < qua1.size(); i++) {
result.add((qua1.get(i) / dil1.get(i))* pri1.get(i));
}
double sum = 0.0;
for (double number : result) {
sum += number;
}

double number1 = sum;
String formatted1 = String.format("%.2f", number1);
sum=Double.parseDouble(formatted1);

status.setText(Double.toString(sum));
status.setStyle("-fx-text-fill:black;");
refresh.setDisable(false);
calculate.setDisable(false);
calnew.setDisable(false);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////  




    }


	
    ////////////////////////////////////////////////////////////////
    if (temp.exists()) {
        temp.delete();
    }
    ////////////////////////////////////////////////////////////////


//Show alert here

Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("");
alert.setHeaderText("");
alert.setContentText("");
ButtonType buttonTypeOne = new ButtonType("Load");
ButtonType buttonTypeCancel = new ButtonType("Browse");
alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
DialogPane dialogPanei = alert.getDialogPane();
dialogPanei.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> results = alert.showAndWait();
if (results.isPresent() && results.get() == buttonTypeOne) {

    //Load
    
        //controlpanel.setVisible(false);
        newscrollbar.setVisible(false);
        scrollbar.setMinSize(1223, 730);
        webview.setMinSize(1223, 730);
        newwebview.setVisible(false);

}


else if (results.isPresent() && results.get() == buttonTypeCancel)  {
    
    //Browse
    
             
        
FileChooser fchio = new FileChooser();
fchio.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
fchio.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
fchio.setTitle("Kady Choose");
File iif = fchio.showOpenDialog((Window)null);
recipenami1=iif.getName().replace(".ks","").replace(".html","");
String recipepathyi = iif.getAbsolutePath().toString();
recipelink1.setText(recipepathyi);  


    ////////////////////////////////////////////////////////////

    String longKeyo;
    try (BufferedReader cxsd = new BufferedReader(new FileReader("lib\\java.dat"))) {
        longKeyo = cxsd.readLine();
    }
    if (longKeyo == null || longKeyo.trim().isEmpty()) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("java.dat is empty!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String resultf = KeyDecoder.extractData(longKeyo.trim());
    if (iif == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String inputp = iif.getAbsolutePath();
    String nameofitp=recipenami1;
    String tempOutputp = System.getProperty("user.home")+"\\"+nameofitp;
    FileDecryptor.decrypt(inputp, tempOutputp, resultf);
    File tempi = new File(tempOutputp);
    
    ////////////////////////////////////////////////////////////

//Read File Here//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
InputStream inputinstreami=new FileInputStream(tempi);
BufferedReader bii=new BufferedReader (new InputStreamReader (inputinstreami,"UTF-8"));
String loi;
lili3.clear();

//lili.appendText(      
//            
//             "<script>\n" +
//"        document.addEventListener('dragstart', function(event) {\n" +
//"            event.preventDefault();\n" +
//"        });\n" +
//"\n" +
//"        document.addEventListener('drop', function(event) {\n" +
//"            event.preventDefault();\n" +
//"        });\n" +
//"\n" +
//"        document.addEventListener('contextmenu', function(event) {\n" +
//"            event.preventDefault();\n" +
//"        });\n" +
//"    </script>"  
//            
//            + "<script>\n" +
//"  \n" +
//"  window.addEventListener(`contextmenu`, (e) => {\n" +
//"    e.preventDefault();\n" +
//"});\n" +
//"  \n" +
//"  </script>"
//           
//            + "<script>\n" +
//"        document.addEventListener('keydown', function (event) {\n" +
//"            // Check if Ctrl + C is pressed\n" +
//"            if (event.ctrlKey && event.key === 'c') {\n" +
//"                event.preventDefault();  // Prevent the default action (copy)\n" +
//"            }\n" +
//"        });\n" +
//"    </script>"
//        
//        
//            
//         );



while ((loi=bii.readLine())!=null) {     
lili3.appendText("\n"+loi
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
bii.close();
String gfi=lili3.getText().replace("<HTML ","<HTML CONTENTEDITABLE ").replace("-WEBKIT-USER-SELECT:","").replace("-MOZ-USER-SELECT:","").replace("-MS-USER-SELECT:","").replace("DOCUMENT.ADDEVENTLISTENER","").replace("USER-SELECT:","").replace("EVENT.PREVENTDEFAULT();","").replace("E.PREVENTDEFAULT();","").replace("<html ","<html contenteditable ").replace("-webkit-user-select:","").replace("-moz-user-select:","").replace("-ms-user-select:","").replace("document.addeventlistener","").replace("user-select:","").replace("event.preventdefault();","").replace("e.preventdefault();","").replace("<html ","<html contenteditable ").replace("-webkit-user-select:","").replace("-moz-user-select:","").replace("-ms-user-select:","").replace("document.addEventListener","").replace("user-select:","").replace("event.preventDefault();","").replace("e.preventDefault();","");



///////////Read Here/////////

String cocoi=gfi.replaceAll("<HTML", "<HTML CONTENTEDITABLE");
newwebview.getEngine().loadContent(cocoi);

/////////////////////////////

OutputStream instreammi=new FileOutputStream(System.getProperty("user.home")+"\\ruy.ks");
PrintWriter pwei = new PrintWriter(new OutputStreamWriter (instreammi,"UTF-8"));
pwei.println(gfi);
pwei.close();



///////////////////////////////////////////////////////////////////////////////////////////////////////////   
pri4 = new ArrayList<>();
qua4= new ArrayList<>();
dil4 = new ArrayList<>();
nom4 = new ArrayList<>();

////////////////////////////////////////////////
File inputFilei = new File(System.getProperty("user.home")+"\\ruy.ks"); //
org.jsoup.nodes.Document docji = Jsoup.parse(inputFilei, "UTF-8"); //
//Document docj = Jsoup.parse(codee);
for (Element table : docji.select("TABLE")) {
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
pri4.add(number1);
String itaam = linebeforeequal;
nom4.add(itaam);
found = true;
break;
}
}
buf.close();   
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
qua4.add(val);   
}
else {
qua4.add(am);
}
}

else if (tds.get(6).text().contains("GARDAL")||tds.get(6).text().contains("GARDEL")
||tds.get(6).text().contains("Gardal")||tds.get(6).text().contains("Gardel")||tds.get(6).text().contains("gardal")||tds.get(6).text().contains("gardel")) {
String sky=tds.get(8).text();
if (sky.equals("FOAM")) {
double am=4.0/5.0;
qua4.add(am);   
}
else {
double am=Double.parseDouble(tds.get(5).text().replace(",","."))*12;
qua4.add(am);    
}
}
else {
double number2 = Double.parseDouble(tds.get(5).text());
qua4.add(number2);
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
dil4.add(number3);
found = true;
break;
}
}
if (!found) {
double number3 = Double.parseDouble("1.0");
dil4.add(number3);
}
buf.close();
}
///////////////////////////////////////////////
}}    
if (qua4.size()!=pri4.size()||qua4.size()!=dil4.size()) { 

    //Write Here About Status in red Color
    status2.setText("Error-Fix Chemicals");
    status2.setStyle("-fx-text-fill:red;");
    //refresh.setDisable(false);
    
}
else {
//Show alert to write pcs.    
List<Double> result = new ArrayList<>();
for (int i = 0; i < qua4.size(); i++) {
result.add((qua4.get(i) / dil4.get(i))* pri4.get(i));
}
double sum = 0.0;
for (double number : result) {
sum += number;
}


double number1 = sum;
String formatted1 = String.format("%.2f", number1);
sum=Double.parseDouble(formatted1);

status2.setText(Double.toString(sum));
status2.setStyle("-fx-text-fill:black;");
//refresh.setDisable(false);
calculate.setDisable(false);
calnew.setDisable(false);
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////  

    }

    

updatecostt.setDisable(false);

	
    ////////////////////////////////////////////////////////////////
    if (tempi.exists()) {
        tempi.delete();
    }
    ////////////////////////////////////////////////////////////////
    
}

else {}



}




   @FXML
   void calculateaction(ActionEvent event) {

//Note make this in calculate button
double sam=Double.parseDouble(status.getText());
double pcsnum=Double.parseDouble(pcs.getText());
double onegar=sam/pcsnum;

double number1 = onegar;
String formatted1 = String.format("%.2f", number1);
onegar=Double.parseDouble(formatted1);

result.setText(Double.toString(onegar));
        
    }

    
    
    
    @FXML
    void refreshaction(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException, IOException, Exception {

   String rRe=recipelink.getText();
   
   if (rRe.isEmpty()||!rRe.contains(".ks")) {
       
       //Noti
Notifications noti = Notifications.create();
noti.title("Fatal Error!");
noti.text("Choose Recipe First or maybe link to recipe is wrong (Not In Kadysoft Mode)!");
noti.position(Pos.CENTER);
noti.hideAfter(Duration.seconds(5));
noti.showError();
       
   }
   
   else {
       
       
       
           ////////////////////////////////////////////////////////////

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
    String resultb = KeyDecoder.extractData(longKey.trim());
    if (rRe == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = rRe;
    String nameofit=Paths.get(rRe).getFileName().toString();
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
 
    FileDecryptor.decrypt(input, tempOutput, resultb);
    File temp = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////
       
       
//Re Read File Recipe.       
InputStream inputinstream=new FileInputStream(temp);
BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
String lo;
lili1.clear();

//
//lili.appendText(      
//            
//             "<script>\n" +
//"        document.addEventListener('dragstart', function(event) {\n" +
//"            event.preventDefault();\n" +
//"        });\n" +
//"\n" +
//"        document.addEventListener('drop', function(event) {\n" +
//"            event.preventDefault();\n" +
//"        });\n" +
//"\n" +
//"        document.addEventListener('contextmenu', function(event) {\n" +
//"            event.preventDefault();\n" +
//"        });\n" +
//"    </script>"  
//            
//            + "<script>\n" +
//"  \n" +
//"  window.addEventListener(`contextmenu`, (e) => {\n" +
//"    e.preventDefault();\n" +
//"});\n" +
//"  \n" +
//"  </script>"
//            
//            + "<script>\n" +
//"        document.addEventListener('keydown', function (event) {\n" +
//"            // Check if Ctrl + C is pressed\n" +
//"            if (event.ctrlKey && event.key === 'c') {\n" +
//"                event.preventDefault();  // Prevent the default action (copy)\n" +
//"            }\n" +
//"        });\n" +
//"    </script>"
//            
//         );


while ((lo=bi.readLine())!=null) {        
lili1.appendText("\n"+lo
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
String gf1=lili1.getText().replace("<HTML ","<HTML CONTENTEDITABLE ").replace("-WEBKIT-USER-SELECT:","").replace("-MOZ-USER-SELECT:","").replace("-MS-USER-SELECT:","").replace("DOCUMENT.ADDEVENTLISTENER","").replace("USER-SELECT:","").replace("EVENT.PREVENTDEFAULT();","").replace("E.PREVENTDEFAULT();","").replace("<html ","<html contenteditable ").replace("-webkit-user-select:","").replace("-moz-user-select:","").replace("-ms-user-select:","").replace("document.addeventlistener","").replace("user-select:","").replace("event.preventdefault();","").replace("e.preventdefault();","").replace("<html ","<html contenteditable ").replace("-webkit-user-select:","").replace("-moz-user-select:","").replace("-ms-user-select:","").replace("document.addEventListener","").replace("user-select:","").replace("event.preventDefault();","").replace("e.preventDefault();","");


///////////Read Here/////////

String coco1=gf1.replaceAll("<HTML", "<HTML CONTENTEDITABLE");
webview.getEngine().loadContent(coco1);
result.setText("Result");


///////////////////////////////////////////////////////////////////////////////////////////////////////////   
pri3 = new ArrayList<>();
qua3 = new ArrayList<>();
dil3 = new ArrayList<>();
nom3 = new ArrayList<>();

////////////////////////////////////////////////
File inputFile = new File(System.getProperty("user.home")+"\\ru.ks"); //
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
pri3.add(number1);
String itaam = linebeforeequal;
nom3.add(itaam);
found = true;
break;
}
}
buf.close();   
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
qua3.add(val);   
}
else {
qua3.add(am);
}
}

else if (tds.get(6).text().contains("GARDAL")||tds.get(6).text().contains("GARDEL")
||tds.get(6).text().contains("Gardal")||tds.get(6).text().contains("Gardel")||tds.get(6).text().contains("gardal")||tds.get(6).text().contains("gardel")) {
String sky=tds.get(8).text();
if (sky.equals("FOAM")) {
double am=4/5;
qua3.add(am);   
}
else {
double am=Double.parseDouble(tds.get(5).text().replace(",","."))*12;
qua3.add(am);    
}
}
else {
double number2 = Double.parseDouble(tds.get(5).text());
qua3.add(number2);
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
dil3.add(number3);
found = true;
break;
}
}
if (!found) {
double number3 = Double.parseDouble("1.0");
dil3.add(number3);
}
buf.close();
}
///////////////////////////////////////////////
}}    
if (qua3.size()!=pri3.size()||qua3.size()!=dil3.size()) { 

    //Write Here About Status in red Color
    status.setText("Error-Fix Chemicals");
    status.setStyle("-fx-text-fill:red;");
    
}
else {
//Show alert to write pcs.    
List<Double> result = new ArrayList<>();
for (int i = 0; i < qua3.size(); i++) {
result.add((qua3.get(i) / dil3.get(i))* pri3.get(i));
}
double sum = 0.0;
for (double number : result) {
sum += number;
}

double number1 = sum;
String formatted1 = String.format("%.2f", number1);
sum=Double.parseDouble(formatted1);

status.setText(Double.toString(sum));
status.setStyle("-fx-text-fill:black;");
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////  

    }

Notifications noti = Notifications.create();
noti.title("Refresh!");
noti.text("Successfully Refreshed The Recipe.!");
noti.position(Pos.CENTER);
noti.hideAfter(Duration.seconds(3));
noti.showInformation();

   }
          
    }
    
    
    
    
    
   
    
    
    
   @FXML
   void calnewaction(ActionEvent event) throws FileNotFoundException, IOException, InterruptedException {

       
       if (newwebview.isVisible()==true) {
           
          //lili4
           
          
            
      String code = (String)this.newwebview.getEngine().executeScript("document.documentElement.outerHTML");
      
      lili2.clear();
      
      if (!code.contains("table")) {
      Notifications noti = Notifications.create();
      noti.title("Recipe Error");
      noti.text("Maybe not a recipe, Open a recipe first!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showError();    
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
tds.get(8).text(linebeforeequal);
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
       lili2.setText(doc.toString());
        }
        
      
      
    ////////////////////////////////////////////////////////////////////////////    
    String newrecipecode=lili2.getText();
    OutputStream instreamm=new FileOutputStream(System.getProperty("user.home")+"\\upp.ks");
    PrintWriter pwwc = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    //PrintWriter pwwc=new PrintWriter (new FileWriter (pathy));
    pwwc.println(newrecipecode);
    pwwc.close();
    lili2.clear();
 
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    
    InputStream inputinstream=new FileInputStream(System.getProperty("user.home")+"\\upp.ks");
    BufferedReader bufy=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    
    //BufferedReader bufy=new BufferedReader (new FileReader (pathy));
    String liin;
    while ((liin=bufy.readLine())!=null) {
        lili2.appendText(liin.replace("ﬦ","A")
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
    String codei = lili2.getText().replace("<HTML ","<HTML CONTENTEDITABLE ").replace("-WEBKIT-USER-SELECT:","").replace("-MOZ-USER-SELECT:","").replace("-MS-USER-SELECT:","").replace("DOCUMENT.ADDEVENTLISTENER","").replace("USER-SELECT:","").replace("EVENT.PREVENTDEFAULT();","").replace("E.PREVENTDEFAULT();","").replace("<html ","<html contenteditable ").replace("-webkit-user-select:","").replace("-moz-user-select:","").replace("-ms-user-select:","").replace("document.addeventlistener","").replace("user-select:","").replace("event.preventdefault();","").replace("e.preventdefault();","").replace("<html ","<html contenteditable ").replace("-webkit-user-select:","").replace("-moz-user-select:","").replace("-ms-user-select:","").replace("document.addEventListener","").replace("user-select:","").replace("event.preventDefault();","").replace("e.preventDefault();","");
      if (!codei.contains("TABLE")) {
      Notifications noti = Notifications.create();
      noti.title("Recipe Error");
      noti.text("Maybe not a recipe, Open a recipe first!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showError();    
        }
        else {
            org.jsoup.nodes.Document doc = Jsoup.parse(codei);
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
tds.get(8).text(linebeforeequal);
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
       lili2.setText(doc.toString());
        }
        
    ////////////////////////////////////////////////////////////////////////////    
    String newrecipecodei=lili2.getText();
    
    OutputStream instreammo=new FileOutputStream(System.getProperty("user.home")+"\\upp.ks");
    PrintWriter pwwcc = new PrintWriter(new OutputStreamWriter (instreammo,"UTF-8"));
    
    //PrintWriter pwwc=new PrintWriter (new FileWriter (pathy));
    pwwcc.println(newrecipecode.replace("A","ﬦ")
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
       pwwcc.close();
       
       Thread.sleep(2000);
    
       
     //////////////////////////////////////////////////////////////////////////////////////////////////////////
InputStream inputinstreamc=new FileInputStream(System.getProperty("user.home")+"\\upp.ks");
BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstreamc,"UTF-8"));
String lo;
lili1.clear();

lili1.appendText(      
            
             "<script>\n" +
"        document.addEventListener('dragstart', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"\n" +
"        document.addEventListener('drop', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"\n" +
"        document.addEventListener('contextmenu', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"    </script>"  
            
            + "<script>\n" +
"  \n" +
"  window.addEventListener(`contextmenu`, (e) => {\n" +
"    e.preventDefault();\n" +
"});\n" +
"  \n" +
"  </script>"
                   
                     + "<script>\n" +
"        document.addEventListener('keydown', function (event) {\n" +
"            // Check if Ctrl + C is pressed\n" +
"            if (event.ctrlKey && event.key === 'c') {\n" +
"                event.preventDefault();  // Prevent the default action (copy)\n" +
"            }\n" +
"        });\n" +
"    </script>"
            
          
      
         );



while ((lo=bi.readLine())!=null) {      
lili1.appendText("\n"+lo
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
String gf=lili1.getText();
OutputStream instreammw=new FileOutputStream(System.getProperty("user.home")+"\\uppp.ks");
PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreammw,"UTF-8"));
pwe.println(gf);
pwe.close();  
       
       
///////////////////////////////////////////////////////////////////////////////////////////////////////////   
pri2 = new ArrayList<>();
qua2 = new ArrayList<>();
dil2 = new ArrayList<>();
nom2 = new ArrayList<>();
unito2 = new ArrayList<>();

////////////////////////////////////////////////
File inputFile = new File(System.getProperty("user.home")+"\\uppp.ks"); //
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
pri2.add(number1);
String itaam = linebeforeequal;
nom2.add(itaam);
unito2.add(tds.get(6).text());
found = true;
break;
}
}
buf.close();   
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
qua2.add(val);   
}
else {
qua2.add(am);
}
}

else if (tds.get(6).text().contains("GARDAL")||tds.get(6).text().contains("GARDEL")
||tds.get(6).text().contains("Gardal")||tds.get(6).text().contains("Gardel")||tds.get(6).text().contains("gardal")||tds.get(6).text().contains("gardel")) {
String sky=tds.get(8).text();
if (sky.equals("FOAM")) {
double am=4.0/5.0;
qua2.add(am);   
}
else {
double am=Double.parseDouble(tds.get(5).text().replace(",","."))*12;
qua2.add(am);    
}
}
else {
double number2 = Double.parseDouble(tds.get(5).text());
qua2.add(number2);
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
dil2.add(number3);
found = true;
break;
}
}
if (!found) {
double number3 = Double.parseDouble("1.0");
dil2.add(number3);
}
buf.close();
}
///////////////////////////////////////////////
}}    
if (qua2.size()!=pri2.size()||qua2.size()!=dil2.size()) { 

    //Write Here About Status in red Color
    status2.setText("Error-Fix Chemicals");
    status2.setStyle("-fx-text-fill:red;");
    
}
else {
//Show alert to write pcs.    
List<Double> result = new ArrayList<>();
for (int i = 0; i < qua2.size(); i++) {
result.add((qua2.get(i) / dil2.get(i))* pri2.get(i));
}
double sum = 0.0;
for (double number : result) {
sum += number;
}

double number1 = sum;
String formatted1 = String.format("%.2f", number1);
sum=Double.parseDouble(formatted1);

status2.setText(Double.toString(sum));
status2.setStyle("-fx-text-fill:black;");

//Note make this in calculate button
double sam4=Double.parseDouble(status2.getText());
double pcsnum4=Double.parseDouble(pcs.getText());
double onegar4=sam4/pcsnum4;

double number11 = onegar4;
String formatted11 = String.format("%.2f", number11);
onegar4=Double.parseDouble(formatted11);

result2.setText(Double.toString(onegar4));
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////  

    }


          
          
           
          ////////////////////End lili4 
       }
       
       
     //
       else {
    
   // if (!newwebview.isVisible()) {
           
           //lili2
           
           
             
      String code = (String)this.webview.getEngine().executeScript("document.documentElement.outerHTML");
      
      System.out.println(code);
      
      lili2.clear();
      
      if (!code.contains("TABLE")) {
      Notifications noti = Notifications.create();
      noti.title("Recipe Error");
      noti.text("Maybe not a recipe, Open a recipe first!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showError();    
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
tds.get(8).text(linebeforeequal);
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
       lili2.setText(doc.toString());
        }
        
      
      
    ////////////////////////////////////////////////////////////////////////////    
    String newrecipecode=lili2.getText();
    OutputStream instreamm=new FileOutputStream(System.getProperty("user.home")+"\\upp.ks");
    PrintWriter pwwc = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    //PrintWriter pwwc=new PrintWriter (new FileWriter (pathy));
    pwwc.println(newrecipecode);
    pwwc.close();
    lili2.clear();
 
    ///////////////////////////////////////////////////////////////////////////////////////////////////////
    
    InputStream inputinstream=new FileInputStream(System.getProperty("user.home")+"\\upp.ks");
    BufferedReader bufy=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    
    //BufferedReader bufy=new BufferedReader (new FileReader (pathy));
    String liin;
    while ((liin=bufy.readLine())!=null) {
        lili2.appendText(liin.replace("ﬦ","A")
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
    String codei = lili2.getText().replace("<HTML ","<HTML CONTENTEDITABLE ");;
      if (!codei.contains("TABLE")) {
      Notifications noti = Notifications.create();
      noti.title("Recipe Error");
      noti.text("Maybe not a recipe, Open a recipe first!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showError();    
        }
        else {
            org.jsoup.nodes.Document doc = Jsoup.parse(codei);
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
tds.get(8).text(linebeforeequal);
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
       lili2.setText(doc.toString());
        }
        
    ////////////////////////////////////////////////////////////////////////////    
    String newrecipecodei=lili2.getText();
    
    OutputStream instreammo=new FileOutputStream(System.getProperty("user.home")+"\\upp.ks");
    PrintWriter pwwcc = new PrintWriter(new OutputStreamWriter (instreammo,"UTF-8"));
    
    //PrintWriter pwwc=new PrintWriter (new FileWriter (pathy));
    pwwcc.println(newrecipecode.replace("A","ﬦ")
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
       pwwcc.close();
       
       Thread.sleep(2000);
    
       
     //////////////////////////////////////////////////////////////////////////////////////////////////////////
InputStream inputinstreamc=new FileInputStream(System.getProperty("user.home")+"\\upp.ks");
BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstreamc,"UTF-8"));
String lo;
lili1.clear();

lili1.appendText(      
            
             "<script>\n" +
"        document.addEventListener('dragstart', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"\n" +
"        document.addEventListener('drop', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"\n" +
"        document.addEventListener('contextmenu', function(event) {\n" +
"            event.preventDefault();\n" +
"        });\n" +
"    </script>"  
            
            + "<script>\n" +
"  \n" +
"  window.addEventListener(`contextmenu`, (e) => {\n" +
"    e.preventDefault();\n" +
"});\n" +
"  \n" +
"  </script>"
                   
                     + "<script>\n" +
"        document.addEventListener('keydown', function (event) {\n" +
"            // Check if Ctrl + C is pressed\n" +
"            if (event.ctrlKey && event.key === 'c') {\n" +
"                event.preventDefault();  // Prevent the default action (copy)\n" +
"            }\n" +
"        });\n" +
"    </script>"
            
          
      
         );



while ((lo=bi.readLine())!=null) {     
lili1.appendText("\n"+lo
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
String gf=lili1.getText();
OutputStream instreammw=new FileOutputStream(System.getProperty("user.home")+"\\uppp.ks");
PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreammw,"UTF-8"));
pwe.println(gf);
pwe.close();  
       
       
///////////////////////////////////////////////////////////////////////////////////////////////////////////   
pri2 = new ArrayList<>();
qua2 = new ArrayList<>();
dil2 = new ArrayList<>();
nom2 = new ArrayList<>();
unito2 = new ArrayList<>();

////////////////////////////////////////////////
File inputFile = new File(System.getProperty("user.home")+"\\uppp.ks"); //
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
pri2.add(number1);
String itaam = linebeforeequal;
nom2.add(itaam);
unito2.add(tds.get(6).text());
found = true;
break;
}
}
buf.close();   
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
qua2.add(val);   
}
else {
qua2.add(am);
}
}

else if (tds.get(6).text().contains("GARDAL")||tds.get(6).text().contains("GARDEL")
||tds.get(6).text().contains("Gardal")||tds.get(6).text().contains("Gardel")||tds.get(6).text().contains("gardal")||tds.get(6).text().contains("gardel")) {
String sky=tds.get(8).text();
if (sky.equals("FOAM")) {
double am=4.0/5.0;
qua2.add(am);   
}
else {
double am=Double.parseDouble(tds.get(5).text().replace(",","."))*12;
qua2.add(am);    
}
}
else {
double number2 = Double.parseDouble(tds.get(5).text());
qua2.add(number2);
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
dil2.add(number3);
found = true;
break;
}
}
if (!found) {
double number3 = Double.parseDouble("1.0");
dil2.add(number3);
}
buf.close();
}
///////////////////////////////////////////////
}}    
if (qua2.size()!=pri2.size()||qua2.size()!=dil2.size()) { 

    //Write Here About Status in red Color
    status2.setText("Error-Fix Chemicals");
    status2.setStyle("-fx-text-fill:red;");
    
}
else {
//Show alert to write pcs.    
List<Double> result = new ArrayList<>();
for (int i = 0; i < qua2.size(); i++) {
result.add((qua2.get(i) / dil2.get(i))* pri2.get(i));
}
double sum = 0.0;
for (double number : result) {
sum += number;
}

double number1 = sum;
String formatted1 = String.format("%.2f", number1);
sum=Double.parseDouble(formatted1);

status2.setText(Double.toString(sum));
status2.setStyle("-fx-text-fill:black;");

//Note make this in calculate button
double sam4=Double.parseDouble(status2.getText());
double pcsnum4=Double.parseDouble(pcs.getText());
double onegar4=sam4/pcsnum4;

double number11 = onegar4;
String formatted11 = String.format("%.2f", number11);
onegar4=Double.parseDouble(formatted11);

result2.setText(Double.toString(onegar4));
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////  

    }


           
           
           
           ////////////////////End lili2
       }
       
     


    

    
    
 
      
       
       
   }
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    webview.setOnMouseClicked(e -> selectedWebView = webview);
    webview.setOnKeyPressed(e -> selectedWebView = webview);

    // Track focus for webView2
    newwebview.setOnMouseClicked(e -> selectedWebView = newwebview);
    newwebview.setOnKeyPressed(e -> selectedWebView = newwebview);
        
        
        
    }    
    
}
