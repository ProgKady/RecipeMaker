
package kadysoft.kady;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.FontFactory;
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
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
import javafx.scene.layout.HBox;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Window;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
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

public static List<Double> pri2;
public static List<Double> qua2;
public static List<Double> dil2;
public static List<String> nom2;

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
void reportoaction(ActionEvent event)  throws IOException{  //Original
  

    if (newwebview.isVisible()) {
        
        
        
//Create Report.  (PDF)
    ////////////////////////////Start Report//////////////////////////////
    
    sum1=status.getText();
    pcsnum1=pcs.getText();
    onegar1=result.getText();
    
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String timeString = sdf.format(d);
    String value0 = timeString;
    String value00 = value0.replace("/", "_");
    String repname = "Chemical_Report_Of_"+recipenami+"";
    String reppath = System.getProperty("user.home") + "\\Desktop";
    FileChooser dialog = new FileChooser();
    dialog.setInitialDirectory(new File(reppath));
    dialog.setInitialFileName(repname);
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", new String[] { "*.pdf" }));
    File dialogResult = dialog.showSaveDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();
    try {
      com.itextpdf.text.Document myDocument = new com.itextpdf.text.Document();
      PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
      PdfPTable table = new PdfPTable(5);
      table.size();
      //table.setHorizontalAlignment(1);
      myDocument.open();
      float[] columnWidths = { 15.0F, 15.0F,15.0F,15.0F,15.0F };
      table.setWidths(columnWidths);
      table.setWidthPercentage(100.0F);
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Cost Report For "+recipenami+" Recipe. "+"", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------------------------------------------------------------------"));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Name", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Quantity", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Dilution", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Price", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Total", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      int no=0;
      int stageno=1;
      while (no<qua1.size()) {                                                                                                                
      table.addCell(new PdfPCell((Phrase)new Paragraph(nom1.get(no), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(qua1.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(dil1.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(pri1.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString((qua1.get(no)/dil1.get(no))*pri1.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      no++;
      } 
      myDocument.add((com.itextpdf.text.Element)table);
      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------"));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost :    "+sum1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments :    "+pcsnum1+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs :    "+onegar1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
      myDocument.setPageSize(PageSize.A4.rotate());
      myDocument.close();
      Alert alooo = new Alert(Alert.AlertType.CONFIRMATION);
      alooo.setTitle("Info");
      alooo.setHeaderText("Info!");
      alooo.setContentText("Report was generated successfully");
      alooo.setResizable(true);
      DialogPane dialogPaneu = alooo.getDialogPane();
      dialogPaneu.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
      alooo.showAndWait();
    } catch (Exception e) {
    } finally {
      try {
      } catch (Exception e) {
      } 
    } 
    Desktop de = Desktop.getDesktop();
    de.open(new File(reppath + "\\" + repname + ".pdf"));
    ////////////////////////////End Report////////////////////////////////

        
        
    }
    
    
    
    
    else {
        
        
//Create Report.  (PDF)
    ////////////////////////////Start Report//////////////////////////////
    
    sum1=status.getText();
    pcsnum1=pcs.getText();
    onegar1=result.getText();
    
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String timeString = sdf.format(d);
    String value0 = timeString;
    String value00 = value0.replace("/", "_");
    String repname = "Chemical_Report_Of_"+recipenami+"_Original_One";
    String reppath = System.getProperty("user.home") + "\\Desktop";
    FileChooser dialog = new FileChooser();
    dialog.setInitialDirectory(new File(reppath));
    dialog.setInitialFileName(repname);
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", new String[] { "*.pdf" }));
    File dialogResult = dialog.showSaveDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();
    try {
      com.itextpdf.text.Document myDocument = new com.itextpdf.text.Document();
      PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
      PdfPTable table = new PdfPTable(5);
      table.size();
      //table.setHorizontalAlignment(1);
      myDocument.open();
      float[] columnWidths = { 15.0F, 15.0F,15.0F,15.0F,15.0F };
      table.setWidths(columnWidths);
      table.setWidthPercentage(100.0F);
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Cost Report For "+recipenami+" Recipe. "+"  Original One.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------------------------------------------------------------------"));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Name", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Quantity", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Dilution", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Price", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Total", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      int no=0;
      int stageno=1;
      while (no<qua1.size()) {                                                                                                                
      table.addCell(new PdfPCell((Phrase)new Paragraph(nom1.get(no), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(qua1.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(dil1.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(pri1.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString((qua1.get(no)/dil1.get(no))*pri1.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      no++;
      } 
      myDocument.add((com.itextpdf.text.Element)table);
      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------"));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost :    "+sum1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments :    "+pcsnum1+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs :    "+onegar1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
      myDocument.setPageSize(PageSize.A4.rotate());
      myDocument.close();
      Alert alooo = new Alert(Alert.AlertType.CONFIRMATION);
      alooo.setTitle("Info");
      alooo.setHeaderText("Info!");
      alooo.setContentText("Report was generated successfully");
      alooo.setResizable(true);
      DialogPane dialogPaneu = alooo.getDialogPane();
      dialogPaneu.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
      alooo.showAndWait();
    } catch (Exception e) {
    } finally {
      try {
      } catch (Exception e) {
      } 
    } 
    Desktop de = Desktop.getDesktop();
    de.open(new File(reppath + "\\" + repname + ".pdf"));
    ////////////////////////////End Report////////////////////////////////

        
        
        
    }
    
    
   
    
    
    
}






@FXML
void reporteaction(ActionEvent event)  throws IOException{ //Edited
  
    
    
    if (newwebview.isVisible()==true) {
        
        
        
//Create Report.  (PDF)
    ////////////////////////////Start Report//////////////////////////////
    
    sum2=status2.getText();
    pcsnum2=pcs.getText();
    onegar2=result2.getText();
    
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String timeString = sdf.format(d);
    String value0 = timeString;
    String value00 = value0.replace("/", "_");
    String repname = "Chemical_Report_Of_"+recipenami1+"";
    String reppath = System.getProperty("user.home") + "\\Desktop";
    FileChooser dialog = new FileChooser();
    dialog.setInitialDirectory(new File(reppath));
    dialog.setInitialFileName(repname);
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", new String[] { "*.pdf" }));
    File dialogResult = dialog.showSaveDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();
    try {
      com.itextpdf.text.Document myDocument = new com.itextpdf.text.Document();
      PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
      PdfPTable table = new PdfPTable(5);
      table.size();
      //table.setHorizontalAlignment(1);
      myDocument.open();
      float[] columnWidths = { 15.0F, 15.0F,15.0F,15.0F,15.0F };
      table.setWidths(columnWidths);
      table.setWidthPercentage(100.0F);
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Cost Report For "+recipenami1+" Recipe. "+"", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------------------------------------------------------------------"));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Name", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Quantity", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Dilution", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Price", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Total", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      int no=0;
      int stageno=1;
      while (no<qua2.size()) {                                                                                                                
      table.addCell(new PdfPCell((Phrase)new Paragraph(nom2.get(no), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(qua2.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(dil2.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(pri2.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString((qua2.get(no)/dil2.get(no))*pri2.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      no++;
      } 
      myDocument.add((com.itextpdf.text.Element)table);
      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------"));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost :    "+sum2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments :    "+pcsnum2+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs :    "+onegar2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
      myDocument.setPageSize(PageSize.A4.rotate());
      myDocument.close();
      Alert alooo = new Alert(Alert.AlertType.CONFIRMATION);
      alooo.setTitle("Info");
      alooo.setHeaderText("Info!");
      alooo.setContentText("Report was generated successfully");
      alooo.setResizable(true);
      DialogPane dialogPaneu = alooo.getDialogPane();
      dialogPaneu.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
      alooo.showAndWait();
    } catch (Exception e) {
    } finally {
      try {
      } catch (Exception e) {
      } 
    } 
    Desktop de = Desktop.getDesktop();
    de.open(new File(reppath + "\\" + repname + ".pdf"));
    ////////////////////////////End Report////////////////////////////////

    
        
        
    }
    
    
    
    else {
        
        
       
//Create Report.  (PDF)
    ////////////////////////////Start Report//////////////////////////////
    
    sum2=status2.getText();
    pcsnum2=pcs.getText();
    onegar2=result2.getText();
    
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String timeString = sdf.format(d);
    String value0 = timeString;
    String value00 = value0.replace("/", "_");
    String repname = "Chemical_Report_Of_"+recipenami+"_Edited_One";
    String reppath = System.getProperty("user.home") + "\\Desktop";
    FileChooser dialog = new FileChooser();
    dialog.setInitialDirectory(new File(reppath));
    dialog.setInitialFileName(repname);
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", new String[] { "*.pdf" }));
    File dialogResult = dialog.showSaveDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();
    try {
      com.itextpdf.text.Document myDocument = new com.itextpdf.text.Document();
      PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
      PdfPTable table = new PdfPTable(5);
      table.size();
      //table.setHorizontalAlignment(1);
      myDocument.open();
      float[] columnWidths = { 15.0F, 15.0F,15.0F,15.0F,15.0F };
      table.setWidths(columnWidths);
      table.setWidthPercentage(100.0F);
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Cost Report For "+recipenami+" Recipe. "+"  Edited One.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------------------------------------------------------------------"));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Name", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Quantity", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Dilution", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Price", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table.addCell(new PdfPCell((Phrase)new Paragraph("Total", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      int no=0;
      int stageno=1;
      while (no<qua2.size()) {                                                                                                                
      table.addCell(new PdfPCell((Phrase)new Paragraph(nom2.get(no), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(qua2.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(dil2.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(pri2.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString((qua2.get(no)/dil2.get(no))*pri2.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      no++;
      } 
      myDocument.add((com.itextpdf.text.Element)table);
      myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------"));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost :    "+sum2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments :    "+pcsnum2+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs :    "+onegar2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
      myDocument.setPageSize(PageSize.A4.rotate());
      myDocument.close();
      Alert alooo = new Alert(Alert.AlertType.CONFIRMATION);
      alooo.setTitle("Info");
      alooo.setHeaderText("Info!");
      alooo.setContentText("Report was generated successfully");
      alooo.setResizable(true);
      DialogPane dialogPaneu = alooo.getDialogPane();
      dialogPaneu.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
      alooo.showAndWait();
    } catch (Exception e) {
    } finally {
      try {
      } catch (Exception e) {
      } 
    } 
    Desktop de = Desktop.getDesktop();
    de.open(new File(reppath + "\\" + repname + ".pdf"));
    ////////////////////////////End Report////////////////////////////////

     
        
    }
    

    
}





@FXML
void reportallaction(ActionEvent event)  throws IOException{

    
    if (newwebview.isVisible()==true) {
        
      
//Create Report.  (PDF)
    ////////////////////////////Start Report//////////////////////////////
    
    sum1=status.getText();
    pcsnum1=pcs.getText();
    onegar1=result.getText();
    
    sum2=status2.getText();
    pcsnum2=pcs.getText();
    onegar2=result2.getText();
    
    
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String timeString = sdf.format(d);
    String value0 = timeString;
    String value00 = value0.replace("/", "_");
    String repname = "Chemical_Report_Of_"+"ALL";
    String reppath = System.getProperty("user.home") + "\\Desktop";
    FileChooser dialog = new FileChooser();
    dialog.setInitialDirectory(new File(reppath));
    dialog.setInitialFileName(repname);
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", new String[] { "*.pdf" }));
    File dialogResult = dialog.showSaveDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();
    try {
      com.itextpdf.text.Document myDocument = new com.itextpdf.text.Document();
      //myDocument.setPageSize(PageSize.A4.rotate());
      PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
      myDocument.open();
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Cost Report For "+recipenami+" Recipe. "+"_ALL.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺"));
      PdfPTable table1 = new PdfPTable(5);
      table1.size();
      //table1.setWidthPercentage(45);
      float[] columnWidths1 = { 15.0F, 15.0F,15.0F,15.0F,15.0F };
      table1.setWidths(columnWidths1);
      table1.setWidthPercentage(100);
      myDocument.add((com.itextpdf.text.Element)new Paragraph("First Recipe", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      table1.addCell(new PdfPCell((Phrase)new Paragraph("Name", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table1.addCell(new PdfPCell((Phrase)new Paragraph("Quantity", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table1.addCell(new PdfPCell((Phrase)new Paragraph("Dilution", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table1.addCell(new PdfPCell((Phrase)new Paragraph("Price", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table1.addCell(new PdfPCell((Phrase)new Paragraph("Total", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      int no1=0;
      int stagen1o=1;
      while (no1<qua1.size()) {                                                                                                                
      table1.addCell(new PdfPCell((Phrase)new Paragraph(nom1.get(no1), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table1.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(qua1.get(no1)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table1.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(dil1.get(no1)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table1.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(pri1.get(no1)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table1.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString((qua1.get(no1)/dil1.get(no1))*pri1.get(no1)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      no1++;
      }
      
      
      
      myDocument.add((com.itextpdf.text.Element)table1);
      
      //myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost :    "+sum1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments :    "+pcsnum1+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs :    "+onegar1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
      //myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Second Recipe", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      
    
      
      
      
      //int rowsTable1 = 5; 
      
      PdfPTable table2 = new PdfPTable(5);
      table2.size();
      //table2.setWidthPercentage(45);
      float[] columnWidths2 = { 15.0F, 15.0F,15.0F,15.0F,15.0F };
      table2.setWidths(columnWidths2);
      table2.setWidthPercentage(100.0F);
      
      table2.addCell(new PdfPCell((Phrase)new Paragraph("Name", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table2.addCell(new PdfPCell((Phrase)new Paragraph("Quantity", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table2.addCell(new PdfPCell((Phrase)new Paragraph("Dilution", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table2.addCell(new PdfPCell((Phrase)new Paragraph("Price", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table2.addCell(new PdfPCell((Phrase)new Paragraph("Total", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      int no2=0;
      int stageno=1;
      while (no2<qua2.size()) {                                                                                                                
      table2.addCell(new PdfPCell((Phrase)new Paragraph(nom2.get(no2), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table2.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(qua2.get(no2)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table2.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(dil2.get(no2)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table2.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(pri2.get(no2)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table2.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString((qua2.get(no2)/dil2.get(no2))*pri2.get(no2)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      no2++;
      }
      
      //int rowsTable2 = 3;
      
        
      
      myDocument.add((com.itextpdf.text.Element)table2);
   
      myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
      //myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost :    "+sum2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments :    "+pcsnum2+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs :    "+onegar2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      //myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
//      
//            PdfPTable parentTable = new PdfPTable(3); // Parent table with 3 columns (table1, VS, table2)
//            parentTable.setWidthPercentage(100); // Full width of the page
//            parentTable.getDefaultCell().setBorder(0);
//
//            // Add the first table to the parent table
//            PdfPCell table1Cell = new PdfPCell(table1);
//            table1Cell.setBorder(Rectangle.NO_BORDER);
//            parentTable.addCell(table1Cell);
//
//            // Corrected "VS" cell creation
//PdfPCell vsCell = new PdfPCell(new Phrase("VS", FontFactory.getFont("Times-Bold", 20, BaseColor.RED)));
//vsCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//vsCell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE); // Corrected line
//vsCell.setBorder(Rectangle.NO_BORDER);
//parentTable.addCell(vsCell);
//
//
//            // Add the second table to the parent table
//            PdfPCell table2Cell = new PdfPCell(table2);
//            table2Cell.setBorder(Rectangle.NO_BORDER);
//            parentTable.addCell(table2Cell);
      
      
//      PdfPTable parentTable = new PdfPTable(2); // Parent table with 2 columns
//      parentTable.setWidthPercentage(100); // Full width of the page
//      parentTable.getDefaultCell().setBorder(0);
//      parentTable.addCell(table1); // Add first table
//      parentTable.addCell(table2); // Add second table
      
     // myDocument.add((com.itextpdf.text.Element)parentTable);

//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------"));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost (Original) :    "+sum1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments (Original) :    "+pcsnum1+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs (Original) :    "+onegar1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost (Edited) :    "+sum2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments (Edited) :    "+pcsnum2+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs (Edited) :    "+onegar2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//      
      if (Double.parseDouble(sum1)>Double.parseDouble(sum2)) {
          
      double vx=Double.parseDouble(sum1)-Double.parseDouble(sum2);
      String formatted1 = String.format("%.2f", vx);
      double vxo=Double.parseDouble(formatted1);
      
      double vxxx=Double.parseDouble(onegar1)-Double.parseDouble(onegar2);
      String formatted2 = String.format("%.2f", vxxx);
      double vxxxo=Double.parseDouble(formatted2);
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (All) Is :    "+vxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (One Garment) Is :    "+vxxxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
      
      //myDocument.add((com.itextpdf.text.Element)new Paragraph("💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧"));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("We Prefer To Use Second Recipe Because It Has A Low Cost.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
          
      }
      else if (Double.parseDouble(sum2)>Double.parseDouble(sum1)) {
          
      double vx=Double.parseDouble(sum2)-Double.parseDouble(sum1); 
      String formatted1 = String.format("%.2f", vx);
      double vxo=Double.parseDouble(formatted1);
      
      double vxxx=Double.parseDouble(onegar2)-Double.parseDouble(onegar1);
      String formatted2 = String.format("%.2f", vxxx);
      double vxxxo=Double.parseDouble(formatted2);
          
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (All) Is :    "+vxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (One Garment) Is :    "+vxxxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
      
      
      
      
      //myDocument.add((com.itextpdf.text.Element)new Paragraph("🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂"));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("We Prefer To Use First Recipe Because It Has A Low Cost.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
          
      }
      else if (Double.parseDouble(sum1)==Double.parseDouble(sum2)) {
          
      double vx=Double.parseDouble(sum2)-Double.parseDouble(sum1);
      String formatted1 = String.format("%.2f", vx);
      double vxo=Double.parseDouble(formatted1);
      
      double vxxx=Double.parseDouble(onegar2)-Double.parseDouble(onegar1);
      String formatted2 = String.format("%.2f", vxxx);
      double vxxxo=Double.parseDouble(formatted2);
          
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (All) Is :    "+vxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥"));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (One Garment) Is :    "+vxxxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
      
      //myDocument.add((com.itextpdf.text.Element)new Paragraph("⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡"));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("We Found That First And Second Have The Same Cost, So Feel Free To Use Anyone Of Them.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      
      //myDocument.add((com.itextpdf.text.Element)new Paragraph("✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔"));
          
      }
      
      
      
      
      //myDocument.setPageSize(PageSize.A4.rotate());
      myDocument.close();
      Alert alooo = new Alert(Alert.AlertType.CONFIRMATION);
      alooo.setTitle("Info");
      alooo.setHeaderText("Info!");
      alooo.setContentText("Report was generated successfully");
      alooo.setResizable(true);
      DialogPane dialogPaneu = alooo.getDialogPane();
      dialogPaneu.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
      alooo.showAndWait();
    } catch (Exception e) {
    } finally {
      try {
      } catch (Exception e) {
      } 
    } 
    Desktop de = Desktop.getDesktop();
    de.open(new File(reppath + "\\" + repname + ".pdf"));
    ////////////////////////////End Report////////////////////////////////

    
    
      
        
        
    }
    
    /////////////////////////////////////End 1 Start 2////////////////////////////////////
    
    else {
        
        
        
//Create Report.  (PDF)
    ////////////////////////////Start Report//////////////////////////////
    
    sum1=status.getText();
    pcsnum1=pcs.getText();
    onegar1=result.getText();
    
    sum2=status2.getText();
    pcsnum2=pcs.getText();
    onegar2=result2.getText();
    
    
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String timeString = sdf.format(d);
    String value0 = timeString;
    String value00 = value0.replace("/", "_");
    String repname = "Chemical_Report_Of_"+"ALL";
    String reppath = System.getProperty("user.home") + "\\Desktop";
    FileChooser dialog = new FileChooser();
    dialog.setInitialDirectory(new File(reppath));
    dialog.setInitialFileName(repname);
    dialog.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF Files", new String[] { "*.pdf" }));
    File dialogResult = dialog.showSaveDialog(null);
    String filePath = dialogResult.getAbsolutePath().toString();
    try {
      com.itextpdf.text.Document myDocument = new com.itextpdf.text.Document();
      //myDocument.setPageSize(PageSize.A4.rotate());
      PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
      myDocument.open();
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Cost Report For "+recipenami+" Recipe. "+"_ALL.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺🌺"));
      PdfPTable table1 = new PdfPTable(5);
      table1.size();
      //table1.setWidthPercentage(45);
      float[] columnWidths1 = { 15.0F, 15.0F,15.0F,15.0F,15.0F };
      table1.setWidths(columnWidths1);
      table1.setWidthPercentage(100);
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Original Recipe", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      table1.addCell(new PdfPCell((Phrase)new Paragraph("Name", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table1.addCell(new PdfPCell((Phrase)new Paragraph("Quantity", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table1.addCell(new PdfPCell((Phrase)new Paragraph("Dilution", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table1.addCell(new PdfPCell((Phrase)new Paragraph("Price", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table1.addCell(new PdfPCell((Phrase)new Paragraph("Total", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      int no1=0;
      int stagen1o=1;
      while (no1<qua1.size()) {                                                                                                                
      table1.addCell(new PdfPCell((Phrase)new Paragraph(nom1.get(no1), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table1.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(qua1.get(no1)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table1.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(dil1.get(no1)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table1.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(pri1.get(no1)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table1.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString((qua1.get(no1)/dil1.get(no1))*pri1.get(no1)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      no1++;
      }
      
      
      
      myDocument.add((com.itextpdf.text.Element)table1);
      
      //myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost (Original) :    "+sum1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments (Original) :    "+pcsnum1+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs (Original) :    "+onegar1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
      //myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Edited Recipe", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      
    
      
      
      
      //int rowsTable1 = 5; 
      
      PdfPTable table2 = new PdfPTable(5);
      table2.size();
      //table2.setWidthPercentage(45);
      float[] columnWidths2 = { 15.0F, 15.0F,15.0F,15.0F,15.0F };
      table2.setWidths(columnWidths2);
      table2.setWidthPercentage(100.0F);
      
      table2.addCell(new PdfPCell((Phrase)new Paragraph("Name", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table2.addCell(new PdfPCell((Phrase)new Paragraph("Quantity", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table2.addCell(new PdfPCell((Phrase)new Paragraph("Dilution", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table2.addCell(new PdfPCell((Phrase)new Paragraph("Price", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      table2.addCell(new PdfPCell((Phrase)new Paragraph("Total", FontFactory.getFont("Times-Roman", 10.0F, 1))));
      int no2=0;
      int stageno=1;
      while (no2<qua2.size()) {                                                                                                                
      table2.addCell(new PdfPCell((Phrase)new Paragraph(nom2.get(no2), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table2.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(qua2.get(no2)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table2.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(dil2.get(no2)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table2.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(pri2.get(no2)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      table2.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString((qua2.get(no2)/dil2.get(no2))*pri2.get(no2)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
      no2++;
      }
      
      //int rowsTable2 = 3;
      
        
      
      myDocument.add((com.itextpdf.text.Element)table2);
   
      myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
      //myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost (Edited) :    "+sum2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments (Edited) :    "+pcsnum2+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs (Edited) :    "+onegar2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      //myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
      myDocument.add((com.itextpdf.text.Element)new Paragraph("🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀🍀"));
//      
//            PdfPTable parentTable = new PdfPTable(3); // Parent table with 3 columns (table1, VS, table2)
//            parentTable.setWidthPercentage(100); // Full width of the page
//            parentTable.getDefaultCell().setBorder(0);
//
//            // Add the first table to the parent table
//            PdfPCell table1Cell = new PdfPCell(table1);
//            table1Cell.setBorder(Rectangle.NO_BORDER);
//            parentTable.addCell(table1Cell);
//
//            // Corrected "VS" cell creation
//PdfPCell vsCell = new PdfPCell(new Phrase("VS", FontFactory.getFont("Times-Bold", 20, BaseColor.RED)));
//vsCell.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);
//vsCell.setVerticalAlignment(PdfPCell.ALIGN_MIDDLE); // Corrected line
//vsCell.setBorder(Rectangle.NO_BORDER);
//parentTable.addCell(vsCell);
//
//
//            // Add the second table to the parent table
//            PdfPCell table2Cell = new PdfPCell(table2);
//            table2Cell.setBorder(Rectangle.NO_BORDER);
//            parentTable.addCell(table2Cell);
      
      
//      PdfPTable parentTable = new PdfPTable(2); // Parent table with 2 columns
//      parentTable.setWidthPercentage(100); // Full width of the page
//      parentTable.getDefaultCell().setBorder(0);
//      parentTable.addCell(table1); // Add first table
//      parentTable.addCell(table2); // Add second table
      
     // myDocument.add((com.itextpdf.text.Element)parentTable);

//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------"));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost (Original) :    "+sum1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments (Original) :    "+pcsnum1+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs (Original) :    "+onegar1+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost (Edited) :    "+sum2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments (Edited) :    "+pcsnum2+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs (Edited) :    "+onegar2+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
//      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
//      
      if (Double.parseDouble(sum1)>Double.parseDouble(sum2)) {
          
      double vx=Double.parseDouble(sum1)-Double.parseDouble(sum2);
      String formatted1 = String.format("%.2f", vx);
      double vxo=Double.parseDouble(formatted1);
      
      double vxxx=Double.parseDouble(onegar1)-Double.parseDouble(onegar2);
      String formatted2 = String.format("%.2f", vxxx);
      double vxxxo=Double.parseDouble(formatted2);
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (All) Is :    "+vxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (One Garment) Is :    "+vxxxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
      
      //myDocument.add((com.itextpdf.text.Element)new Paragraph("💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧💧"));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("We Prefer To Use Edited Recipe Because It Has A Low Cost.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
          
      }
      else if (Double.parseDouble(sum2)>Double.parseDouble(sum1)) {
          
      double vx=Double.parseDouble(sum2)-Double.parseDouble(sum1); 
      String formatted1 = String.format("%.2f", vx);
      double vxo=Double.parseDouble(formatted1);
      
      double vxxx=Double.parseDouble(onegar2)-Double.parseDouble(onegar1);
      String formatted2 = String.format("%.2f", vxxx);
      double vxxxo=Double.parseDouble(formatted2);
          
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (All) Is :    "+vxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (One Garment) Is :    "+vxxxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
      
      
      
      
      //myDocument.add((com.itextpdf.text.Element)new Paragraph("🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂🍂"));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("We Prefer To Use Original Recipe Because It Has A Low Cost.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
          
      }
      else if (Double.parseDouble(sum1)==Double.parseDouble(sum2)) {
          
      double vx=Double.parseDouble(sum2)-Double.parseDouble(sum1);
      String formatted1 = String.format("%.2f", vx);
      double vxo=Double.parseDouble(formatted1);
      
      double vxxx=Double.parseDouble(onegar2)-Double.parseDouble(onegar1);
      String formatted2 = String.format("%.2f", vxxx);
      double vxxxo=Double.parseDouble(formatted2);
          
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (All) Is :    "+vxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥🔥"));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("Difference Between 2 Costs (One Garment) Is :    "+vxxxo+"          $.", FontFactory.getFont("Times-Bold", 12.0F, 1)));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
      
      //myDocument.add((com.itextpdf.text.Element)new Paragraph("⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡⚡"));
      
      myDocument.add((com.itextpdf.text.Element)new Paragraph("We Found That Original And Edited Have The Same Cost, So Feel Free To Use Anyone Of Them.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
      
      //myDocument.add((com.itextpdf.text.Element)new Paragraph("✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔✔"));
          
      }
      
      
      
      
      //myDocument.setPageSize(PageSize.A4.rotate());
      myDocument.close();
      Alert alooo = new Alert(Alert.AlertType.CONFIRMATION);
      alooo.setTitle("Info");
      alooo.setHeaderText("Info!");
      alooo.setContentText("Report was generated successfully");
      alooo.setResizable(true);
      DialogPane dialogPaneu = alooo.getDialogPane();
      dialogPaneu.getStylesheets().add(
      getClass().getResource("cupertino-light.css").toExternalForm());
      alooo.showAndWait();
    } catch (Exception e) {
    } finally {
      try {
      } catch (Exception e) {
      } 
    } 
    Desktop de = Desktop.getDesktop();
    de.open(new File(reppath + "\\" + repname + ".pdf"));
    ////////////////////////////End Report////////////////////////////////

    
    
    
        
        
        
    }
    
    //////////////////////End All//////////////////////////////////////////
    
}
    
    
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
void browseaction(ActionEvent event)  throws IOException{
    
    
    
    
    

        
FileChooser fcho = new FileChooser();
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
fcho.setTitle("Kady Choose");
File f = fcho.showOpenDialog((Window)null);
recipenami=f.getName().replace(".ks","").replace(".html","");
String recipepathy = f.getAbsolutePath().toString();
recipelink.setText(recipepathy);  

//Read File Here//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
InputStream inputinstream=new FileInputStream(recipepathy);
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

//Read File Here//////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////////////////////////////////////////////////////////////////////////////////////
InputStream inputinstreami=new FileInputStream(recipepathyi);
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
    void refreshaction(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException, IOException {

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
       
//Re Read File Recipe.       
InputStream inputinstream=new FileInputStream(rRe);
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
