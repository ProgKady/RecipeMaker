
package kadysoft.kady;

import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import io.github.palexdev.materialfx.controls.MFXCheckbox;
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
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import org.apache.poi.ss.usermodel.CellStyle;
import static org.apache.poi.ss.usermodel.CellType.BLANK;
import static org.apache.poi.ss.usermodel.CellType.FORMULA;
import static org.apache.poi.ss.usermodel.CellType.NUMERIC;
import static org.apache.poi.ss.usermodel.CellType.STRING;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import static org.apache.poi.ss.usermodel.HorizontalAlignment.CENTER;
import static org.apache.poi.ss.usermodel.HorizontalAlignment.LEFT;
import static org.apache.poi.ss.usermodel.HorizontalAlignment.RIGHT;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.controlsfx.control.Notifications;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.List;
import java.util.ArrayList;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class ExcelFastModeController implements Initializable {

   
    @FXML
    private JFXTextField excelfile;

    @FXML
    private ComboBox<String> model;

    @FXML
    private MFXCheckbox sign;

    @FXML
    private JFXTextArea code;

    @FXML
    private WebView preview;

    @FXML
    private JFXTextField name;
    
    public static String htt;

  Connection conn = null;
  
  ResultSet rs = null;
  
  PreparedStatement pst = null;
  
    public static String lproduct,rproduct,tempraturee,ftank,etank,cdosage,timer_temprature,oldtimemin,oldtimehour,oldtimemin2,oldtimehour2,msg,oldtimemin3,oldtimehour3,oldtimemin4,oldtimehour4,oldtimemin5,oldtimehour5,oldtimemin6,oldtimehour6;
    public static String passy,passyy,wifi;
    public static double loadstone,loadstone2;
    public static double removestone,removestone2;
    public static double cleaningstone,cleaningstone2;
    public static double extraction,extraction2;
    public static double loadremovestone,loadremovestone2;
    public static double loadremoveproduct,loadremoveproduct2,loadremoveproductall;
    public static double tempraturetime,tempraturetime2,tempraturetimeall;
    public static double chemicaldosage,chemicaldosage2,chemicaldosageall;
    public static double fillemptytank,fillemptytank2,fillemptytankall;
    public static double loadstone3,loadstone4,loadstone5,loadstone6;
    public static double removestone3,removestone4,removestone5,removestone6;
    public static double cleaningstone3,cleaningstone4,cleaningstone5,cleaningstone6;
    public static double extraction3,extraction4,extraction5,extraction6;
    public static double loadremovestone3,loadremovestone4,loadremovestone5,loadremovestone6;
    public static double loadremoveproduct1,loadremoveproduct3,loadremoveproduct4,loadremoveproduct5,loadremoveproduct6;
    public static double tempraturetime1,tempraturetime3,tempraturetime4,tempraturetime5,tempraturetime6;
    public static double chemicaldosage1,chemicaldosage3,chemicaldosage4,chemicaldosage5,chemicaldosage6;
    public static double fillemptytank1,fillemptytank3,fillemptytank4,fillemptytank5,fillemptytank6;
    public static double gdf1,gdf2,gdf3,gdf4,gdf5,gdf6,gmf1,gmf2,gmf3,gmf4,gmf5,gmf6;
    public static double stonabathth,stonabaththh;
    public static Elements domyy;
    public static int bosbos,shoty;
    
  //////////////////////////////////////////////
  public static String bosboss,procccc;
  
  public static String funkifi;
  
      public static String stonn;
      public static String fomm;
      public static String hypoo;
      public static String enzymm;
      public static String moonn;
      public static String dryr11;
      public static String dryr22;
      public static String dryr33;
      public static String dryr44;
      public static String dryr55;
      public static String dryr66;
      
      public static String stonny,finall;
      public static double sto,sumz,ally;
      
    
    
    
    
    @FXML
    void browseaction(ActionEvent event) {
            

        code.clear();
        FileChooser fcho=new FileChooser ();
        fcho.setTitle("");
        fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Excel Files", "*.xlsx"));
        fcho.setInitialDirectory(new File (NewDir.file_di));
        File ff=fcho.showOpenDialog(null);
        String patt=ff.getAbsolutePath();
        String nnn=ff.getName().replace(".xlsx","").replace("-","_").replace(".","_").replace(" ","_").replace("  ","_");
        excelfile.setText(patt);
        name.setText(nnn);
        
        if (ff != null) {
        try (FileInputStream fis = new FileInputStream(ff);
        Workbook workbook = new XSSFWorkbook(fis)) {
        Sheet sheet = workbook.getSheetAt(0);
        String htmlTable = convertExcelToHtml(sheet);
        code.appendText("<!DOCTYPE HTML>\n" + 
"<HTML LANG=\"AR\">\n" +
"<HEAD>\n" +
"<TITLE>KADYSOFT</TITLE>\n" +
"<META CHARSET=\"UTF-8\">\n" +
"<META NAME=\"VIEWPORT\" CONTENT=\"WIDTH=DEVICE-WIDTH, INITIAL-SCALE=1.0\">\n" +
"<STYLE>TD {\n" +
"HEIGHT:5PX;\n" +
"MAX-WIDTH:100%;\n" +
"WHITE-SPACE:NOWRAP;\n" +
"}\n" +
"TABLE {\n" +
"HEIGHT:5PX;\n" +
"MAX-WIDTH:100%;\n" +
"HEIGHT:100%;\n" +
"WHITE-SPACE:NOWRAP;\n" +
"}\n" +
"TR {\n" +
"HEIGHT:5PX;\n" +
"MAX-WIDTH:100%;\n" +
"WHITE-SPACE:NOWRAP;\n" +
"}"
                + ""
                
                
                 + ""
                + "/* Centered Watermark */\n" +
"    .watermark {\n" +
"      position: fixed;\n" +
"      top: 50%;\n" +
"      left: 50%;\n" +
"      transform: translate(-50%, -50%) rotate(-45deg);\n" +
"      background-image: url('logo.png'); /* Replace with the path to T & C Garments logo */\n" +
"      background-repeat: no-repeat;\n" +
"      background-size: contain;\n" +
"      width: 300px;\n" +
"      height: 200px;\n" +
"      opacity: 0.3;\n" +
"      pointer-events: none;\n" +
"      z-index: 1000;\n" +
"    }\n" +
"    /* Repeated Watermark */\n" +
"    .watermark-repeated {\n" +
"      position: fixed;\n" +
"      top: 0;\n" +
"      left: 0;\n" +
"      width: 100%;\n" +
"      height: 100%;\n" +
"      background-image: url('logo.png'); /* Replace with the path to T & C Garments logo */\n" +
"      background-repeat: repeat;\n" +
"      background-size: 300px 200px;\n" +
"      opacity: 0.2;\n" +
"      pointer-events: none;\n" +
"      z-index: 1000;\n" +
"    }"
                + ""
                + "</STYLE></HEAD>\n" +
"<BODY><CENTER>\n"
+ "<div class=\"watermark\"></div>" +
                
                
                
"\n" +
"\n" +
"<!-- CREATING RECIPE FROM KADYSOFT LTD.-->\n" +
"\n" +
"\n" +
"<STYLE>\n" +
"        BODY {\n" +
"            USER-SELECT: NONE;\n" +
"            -WEBKIT-USER-SELECT: NONE;\n" +
"            -MOZ-USER-SELECT: NONE;\n" +
"            -MS-USER-SELECT: NONE;\n" +
"        }\n" +
"    </STYLE><SCRIPT>\n" +
"        DOCUMENT.ADDEVENTLISTENER('DRAGSTART', FUNCTION(EVENT) {\n" +
"            EVENT.PREVENTDEFAULT();\n" +
"        });\n" +
"\n" +
"        DOCUMENT.ADDEVENTLISTENER('DROP', FUNCTION(EVENT) {\n" +
"            EVENT.PREVENTDEFAULT();\n" +
"        });\n" +
"\n" +
"        DOCUMENT.ADDEVENTLISTENER('CONTEXTMENU', FUNCTION(EVENT) {\n" +
"            EVENT.PREVENTDEFAULT();\n" +
"        });\n" +
"    </SCRIPT><SCRIPT>\n" +
"  \n" +
"  WINDOW.ADDEVENTLISTENER(`CONTEXTMENU`, (E) => {\n" +
"    E.PREVENTDEFAULT();\n" +
"});\n" +
"  \n" +
"  </SCRIPT>\n" +
"<META CHARSET=\"UTF-8\"/>\n" +
"<META NAME=\"VIEWPORT\" CONTENT=\"WIDTH=DEVICE-WIDTH, USER-SCALABLE=NO, INITIAL-SCALE=1.0, MAXIMUM-SCALE=1.0, MINIMUM-SCALE=1.0\"/>\n" +
"		<META HTTP-EQUIV=\"X-UA-COMPATIBLE\" CONTENT=\"IE=EDGE\" /><SCRIPT>\n" +
"            \n" +
"            DOCUMENT.ADDEVENTLISTENER('KEYDOWN', EVENT => {\n" +
"  CONSOLE.LOG(`USER PRESSED: ${EVENT.KEY}`);\n" +
"  EVENT.PREVENTDEFAULT();\n" +
"  RETURN FALSE;\n" +
"});\n" +
"            \n" +
"            </SCRIPT><SCRIPT>\n" +
"        DOCUMENT.ADDEVENTLISTENER('KEYDOWN', FUNCTION (EVENT) {\n" +
"            // DISABLE SPECIFIC KEYS OR KEY COMBINATIONS\n" +
"            EVENT.PREVENTDEFAULT();\n" +
"        });\n" +
"    </SCRIPT>");
        code.appendText(htmlTable);
        code.appendText("</CENTER>\n" +
"</BODY>\n" +
"</HTML>");
        
        htt=code.getText();
        
        
        
        //////////////////////Fix Here///////////////////////////////
        
      String coder = code.getText();
      if (!coder.contains("TABLE")) {
      Notifications noti = Notifications.create();
      noti.title("Recipe Error");
      noti.text("Maybe not a recipe, Open a recipe first!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showError();    
        }
        else {
            org.jsoup.nodes.Document doc = Jsoup.parse(coder);
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
    
            }   
         
        }}
       code.setText(doc.toString());
        }
        
///////////////////////////////////////////////////////////////

String codeu = code.getText();
      if (!codeu.contains("TABLE")) {
      Notifications noti = Notifications.create();
      noti.title("Recipe Error");
      noti.text("Maybe not a recipe, Open a recipe first!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showError();    
        }
        else {
            org.jsoup.nodes.Document doc = Jsoup.parse(codeu);
        for (Element table : doc.select("TABLE")) {
        for (Element row : table.select("TR")) {
            Elements tds = row.select("TD");
            if (tds.get(8).text().isEmpty()) {   
            }
            
           
            else {  
             ///////////////////////////////////////////////////////////////
String string=tds.get(8).text();
BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Lot_Numbers.kady"));
String line;
String linebeforeequal;//Chemical Name
String lineafterequal;//Lot Numbers
boolean found = false;         
while ((line=buf.readLine())!=null) {
linebeforeequal=line.substring(0,line.indexOf("="));//Chemical Name
lineafterequal=line.substring(line.indexOf("=") + 1);//Lot Numbers

if (string.equalsIgnoreCase(linebeforeequal)) {
System.out.println(linebeforeequal);
String formattedText = "<b style='display:block; text-align:center;'>" + lineafterequal + "</b>";
tds.get(9).html(formattedText); // Use .html() instead of .text()     
//tds.get(9).text(lineafterequal);
//System.out.println(lineafterequal);
found = true;                    
break;

    }
  
    
}
buf.close();

             ///////////////////////////////////////////////////////////////
               
            }   
         
         
        }}
       code.setText(doc.toString());
        }
        
      
      
          
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
String roraa = code.getText();         
org.jsoup.nodes.Document doctp = Jsoup.parse(roraa);
// مر على كل جدول
for (Element table : doctp.select("table")) {
    for (Element row : table.select("tr")) {
        Elements tds = row.select("td");
        // اتأكد إن فيه على الأقل 11 عمود (0 → 10)
        if (tds.size() > 10) {
            String target = tds.get(8).text().trim();
            if (!target.isEmpty()) {
                Path mapPath = Paths.get(NewDir.file_dirrrr, "Recipe_Indexes", "Chemical_Translation.kady");
                try (BufferedReader bufi = Files.newBufferedReader(mapPath, StandardCharsets.UTF_8)) {
                    String line;
                    boolean found = false;
                    while ((line = bufi.readLine()) != null) {
                        // اتأكد إن السطر فيه =
                        if (!line.contains("=")) continue;
                        String linebeforeequal = line.substring(0, line.indexOf("=")).trim();
                        String lineafterequal = line.substring(line.indexOf("=") + 1).trim();
                        if (target.equalsIgnoreCase(linebeforeequal)) {
                            System.out.println("Matched: " + linebeforeequal);
                            String formattedText =
                                    "<b style='display:block; text-align:center;'>" +
                                            lineafterequal +
                                            "</b>";
                            // استبدل العمود رقم 10 بالنص الجديد
                            tds.get(10).html(formattedText);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("No match for: " + target);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
//roraa = doctp.toString();
code.setText(doctp.toString());          
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////


      
      
      
      
    ////////////////////////////////////////////////////////////////////////////
        


        preview.getEngine().loadContent(code.getText());
        
        //System.out.println(code.getText());
        
        } catch (IOException e) {
        code.setText("Error reading Excel file: " + e.getMessage());
        }}
        
    }
    
    private String convertExcelToHtml(Sheet sheet) {
    StringBuilder htmlBuilder = new StringBuilder();
    htmlBuilder.append("<TABLE ID='EXTABLE' BORDER='1' STYLE='BORDER-COLLAPSE:COLLAPSE;'>\n");

    for (Row row : sheet) {
        if (row == null) continue;
        htmlBuilder.append("  <TR>\n");
        Iterator<org.apache.poi.ss.usermodel.Cell> cellIterator = row.cellIterator();
        while (cellIterator.hasNext()) {
            org.apache.poi.ss.usermodel.Cell cell = cellIterator.next();
            if (cell == null) continue;

            CellStyle style = cell.getCellStyle();
            Workbook workbook = sheet.getWorkbook();
            Font font = workbook.getFontAt(style.getFontIndexAsInt());

            String bgColor = getColorFromStyle(style);
            String textColor = getColorFromFont(font);
            String alignment = getAlignmentFromStyle(style);
            String fontStyle = getFontStyles(font);
            String cellValue = getCellValue(cell);

            htmlBuilder.append(String.format(
                    "    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:%s; COLOR:%s; %s %s'>%s</TD>\n",
                    bgColor, textColor, alignment, fontStyle, cellValue
            ));
        }
        htmlBuilder.append("  </TR>\n");
    }
    htmlBuilder.append("</TABLE>");
    return htmlBuilder.toString();
}

   private String getColorFromStyle(CellStyle style) {
        if (style instanceof XSSFCellStyle) {
            XSSFColor xssfColor = ((XSSFCellStyle) style).getFillForegroundColorColor();
            if (xssfColor != null && xssfColor.getARGBHex() != null) {
                return "#" + xssfColor.getARGBHex().substring(2);
            }
        }
        return "#ffffff";
    }

    private String getColorFromFont(Font font) {
        if (font instanceof XSSFFont) {
            XSSFFont xssfFont = (XSSFFont) font;
            if (xssfFont.getXSSFColor() != null && xssfFont.getXSSFColor().getARGBHex() != null) {
                return "#" + xssfFont.getXSSFColor().getARGBHex().substring(2);
            }
        }
        return "#000000";
    }

    private String getAlignmentFromStyle(CellStyle style) {
        HorizontalAlignment alignment = style.getAlignment();
        if (alignment != null) {
            switch (alignment) {
                case CENTER: return "text-align:center;";
                case LEFT:   return "text-align:left;";
                case RIGHT:  return "text-align:right;";
            }
        }
        return "";
    }

    private String getFontStyles(Font font) {
        StringBuilder fontStyle = new StringBuilder();
        if (font.getBold()) fontStyle.append("font-weight:bold;");
        fontStyle.append("font-size:").append(font.getFontHeightInPoints()).append("pt;");
        return fontStyle.toString();
    }

    private String getCellValue(org.apache.poi.ss.usermodel.Cell cell) {
       
        
        if (cell == null) return "";

    // Use getCellType() from Apache POI 5.x
    switch (cell.getCellType()) {
        case STRING:  
            return cell.getStringCellValue();
        case NUMERIC: 
            if (DateUtil.isCellDateFormatted(cell)) {
                // Format date values properly
                return new SimpleDateFormat("dd/MM/yyyy").format(cell.getDateCellValue());
            }
            double numericValue = cell.getNumericCellValue();
            return (numericValue % 1 == 0) ? String.valueOf((int) numericValue) : String.valueOf(numericValue);
        case FORMULA: 
            try {
                double formulaValue = cell.getNumericCellValue();
                return (formulaValue % 1 == 0) ? String.valueOf((int) formulaValue) : String.valueOf(formulaValue);
            } catch (Exception e) {
                return cell.getCellFormula();
            }
        case BLANK:   
            return "";
        default:      
            return "";
    }
        
        
    }

    
    
    @FXML
    void convertaction(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException, IOException {
     
        
        
        
        String llink=NewDir.file_dir+"\\PILOT\\"+model.getSelectionModel().getSelectedItem().toString();
        
        
        
        

        FileChooser fchoo=new FileChooser ();
        fchoo.setTitle("");
        fchoo.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", "*.ks"));
        fchoo.setInitialFileName(name.getText());
        fchoo.setInitialDirectory(new File (llink));
        File fff=fchoo.showSaveDialog(null);
        String pattt=fff.getAbsolutePath();
        String allcode=code.getText()
       .replace("A","ﬦ")
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
       .replace("z","ףּ"); 
        
    OutputStream instreamm=new FileOutputStream(pattt);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    //PrintWriter pw=new PrintWriter (new FileWriter (pathy));
    pw.println("<style>\n" +
"        body {\n" +
"            user-select: none;\n" +
"            -webkit-user-select: none;\n" +
"            -moz-user-select: none;\n" +
"            -ms-user-select: none;\n" +
"        }\n" +
"    </style>"
            
          +"<script>\n" +
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
             + ""
            + "\n<meta charset=\"UTF-8\"/>\n<meta name=\"viewport\" content=\"width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0\"/>\n\t\t<meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\" />"
            + ""
            + "<script>\n" +
"            \n" +
"            document.addEventListener('keydown', event => {\n" +
"  console.log(`User pressed: ${event.key}`);\n" +
"  event.preventDefault();\n" +
"  return false;\n" +
"});\n" +
"            \n" +
"            </script>"
            
       +"<script>\n" +
"        document.addEventListener('keydown', function (event) {\n" +
"            // Disable specific keys or key combinations\n" +
"            event.preventDefault();\n" +
"        });\n" +
"    </script>"+allcode);
    pw.close();
    Notifications noti = Notifications.create();
    noti.title("Successful");
    noti.text("We have created the recipe successfully.");
    noti.hideAfter(Duration.seconds(3));
    noti.position(Pos.CENTER);
    noti.showInformation();
    
    code.clear();
    preview.getEngine().loadContent("");
    //name.clear();
    excelfile.clear();
    sign.setSelected(false);
    //model.getSelectionModel().clearSelection();
    
    //////////////////////////////////////////////////////////////PILOT START////////////////////////////////////////////////////////
    
    
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   

 //SHow recipr first here..........



String modelooo=model.getSelectionModel().getSelectedItem().toString();
//////////////////////////////////////////////////////////////////////////////////////////////////////////
InputStream inputinstream=new FileInputStream(pattt);
BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
String lo;
code.clear();
while ((lo=bi.readLine())!=null) {        
code.appendText("\n"+lo
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
String gf=code.getText();
OutputStream instreammu=new FileOutputStream(System.getProperty("user.home")+"\\r.ks");
PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreammu,"UTF-8"));
pwe.println(gf);
pwe.close();


   //Get Time And Shots
   
   List<Integer> time = new ArrayList<>();
   List<Integer> timeSum = new ArrayList<>();
   List<String> shots = new ArrayList<>();
   int sum = 0, bathnum=0, firstshot=0, secondshot=0,thirdshot=0,forthshot=0;
   
   File inputFile = new File(System.getProperty("user.home")+"\\r.ks"); //
   org.jsoup.nodes.Document doc = Jsoup.parse(inputFile, "UTF-8"); //
   for (Element table : doc.select("tbody")) {
   for (Element row : table.select("tr")) {
   Elements tds = row.select("td");
   if (tds.get(2).text().isEmpty()||tds.get(2).text().contains("/")||tds.get(2).text().contains("\\")||tds.get(2).text().contains("SPIN")||tds.get(2).text().contains("spin")||tds.get(2).text().contains("TIME")||tds.get(2).text().contains("time")||tds.get(2).text().matches("[a-zA-Z_]+")||tds.get(2).text().contains("PRODUCTION")||tds.get(2).text().contains("RECIPE")||tds.get(2).text().contains("RECIPI")||tds.get(2).text().contains("DATE")||tds.get(2).text().contains("WASH")) {}
   else {
   String stringg=tds.get(2).text().replace(" CONT","").replace(" CONG","").replace("CONG","").replace(" cont","").replace(" CNTRL","").replace(" control","").replace(" CONTROL","").replace(" con","").replace(" CON","").replace(" CNTRL","").replace(" KONTROL","").replace("CONT","").replace("cont","").replace("CNTRL","").replace("control","").replace("CONTROL","").replace("con","").replace("CON","").replace("CNTRL","").replace("KONTROL","");
   
   if (stringg.contains("+")) {
   String sum1 = stringg;
   String[] numbers1 = sum1.split("\\+");
   int total1 = 0;
   for (String numStr1 : numbers1) {
   total1 += Integer.parseInt(numStr1);
   }
   time.add(total1);
   }
   
   else {
   int ioo=Integer.parseInt(stringg);
   time.add(ioo);     
   }
   }
                              
                            String dalil=tds.get(3).text();
                            if (dalil.contains("EXTRACT")||dalil.contains("extract")||dalil.contains("Extract")||dalil.contains("EXTRA")||dalil.contains("EXTRACTION")||dalil.contains("extraction")) {
                            for (int i = 0; i < time.size(); i++)
                            sum += time.get(i);
                            timeSum.add(sum);
                            time.clear();
                            shots.add(dalil);}else {
                            
                        
                            
                            }}}
                          bathnum=shots.size();
                          if (shots.size()==1) {
                          firstshot=timeSum.get(0);}
                          else if (shots.size()==2) {
                          firstshot=timeSum.get(0);
                          secondshot=timeSum.get(1)-timeSum.get(0);}
                          else {
                          
                       
                          
                          }
                          
                          

                          
   
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Get Temp
   
   try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Timer_Temp.kady"));
      
      timer_temprature=buf.readLine();
      
      buf.close();
      } catch (FileNotFoundException fileNotFoundException) {
      } catch (IOException iOException) {}
   
                            int temp=0;
                            int temp2=0;
                            int temp3=0;
                            String timer_tempra=timer_temprature;
                            int timer_temp=Integer.parseInt(timer_tempra);
                            
                          
                            org.jsoup.nodes.Document docy = Jsoup.parse(inputFile, "UTF-8"); //      
                            for (Element table : docy.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(3).text().contains("/")||tds.get(3).text().contains("\\")||tds.get(3).text().isEmpty()||tds.get(3).text().contains("TEMP")||tds.get(3).text().contains("OPERATOR")||tds.get(3).text().contains("temp")||tds.get(3).text().contains("operator")) {}
                            else {
                                
                            String tempo=tds.get(3).text();
                            
                            if (tempo.contains("EXTRACT")) {
                                
                                String pattern = "[a-zA-Z_ _&_.]+";
                                tempo = tempo.replaceAll(pattern, "");
                                if (tempo.matches("[0-9]+")) {
                                int cvd2=Integer.parseInt(tempo); 
                                if (cvd2>timer_temp) { 
                                temp2+=1;
                                }
                                else {
                                }}break;
                             }
                            
                            else {
                           
                                String pattern = "[a-zA-Z_ _&_.]+";  
                                tempo = tempo.replaceAll(pattern, "");
                                if (tempo.matches("[0-9]+")) {
                                int cvd=Integer.parseInt(tempo); 
                                if (cvd>timer_temp) { 
                                temp+=1;
                                }else {}}
                                
                            }}}}
                            
                            int tempall=0;
                            org.jsoup.nodes.Document docc = Jsoup.parse(inputFile, "UTF-8"); // 
                            for (Element table : docc.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(3).text().contains("/")||tds.get(3).text().contains("\\")||tds.get(3).text().isEmpty()||tds.get(3).text().contains("TEMP")||tds.get(3).text().contains("OPERATOR")||tds.get(3).text().contains("temp")||tds.get(3).text().contains("operator")) {}
                            else {
                                String tempo=tds.get(3).text();
                                String pattern = "[a-zA-Z_ _&_.]+";
                                tempo = tempo.replaceAll(pattern, "");
                                if (tempo.matches("[0-9]+")) {
                                int cvd=Integer.parseInt(tempo); 
                                if (cvd>timer_temp) { 
                                tempall+=1;}
                                else {}}else {}}}}
                            
                            
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Get Stone Bath   
   
                            int stonebathh=0;
                            org.jsoup.nodes.Document doccc = Jsoup.parse(inputFile, "UTF-8"); // 
                            for (Element table : doccc.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(7).text().isEmpty()||tds.get(7).text().contains("/")||tds.get(7).text().contains("\\")||tds.get(7).text().contains("CHEMICAL")||tds.get(7).text().contains("chemical")||tds.get(7).text().matches("[0-9_-]+")) {}
                            else {
                            String erw=tds.get(7).text().toString();
                            if (erw.contains("STONE")||erw.contains("STON")||erw.contains("BOOL")||erw.contains("FOAM")||erw.contains("BOLL"))  {
                            stonebathh+=1;  
                            }else {}}}}
   
                            
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //Get Water Bath  
    
    
                            
        
                            int waterbath=0;
                            int waterbath2=0;
                            org.jsoup.nodes.Document docu = Jsoup.parse(inputFile, "UTF-8"); // 
                            for (Element table : docu.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            
                            if (tds.get(4).text().contains("'")||tds.get(4).text().contains("DRYER")||tds.get(4).text().contains("LITER")||tds.get(4).text().matches("[a-zA-Z_]+")) {}
                            else {
                                
                            String tempo=tds.get(3).text();
                            
                            if (tempo.contains("EXTRACT")) {
                                if (tds.get(4).text().matches("[0-9]+")) {
                                int cvd2=Integer.parseInt(tds.get(4).text()); 
                                waterbath2+=1;
                                
                                }
                                
                                break;
                                
                            }
                            
                            
                            else {
                           
                                if (tds.get(4).text().matches("[0-9]+")) {
                                int cvd=Integer.parseInt(tds.get(4).text()); 
                               
                                waterbath+=1;
                                
                                }
                                
                            }
                            
                           }}}
                            
        
        
        
                            int waterbathall=0;
                            org.jsoup.nodes.Document dock = Jsoup.parse(inputFile, "UTF-8"); // 
                            for (Element table : dock.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(4).text().isEmpty()||tds.get(4).text().contains("'")||tds.get(4).text().contains("DRYER")||tds.get(4).text().contains("LITER")||tds.get(4).text().matches("[a-zA-Z_]+")) {}
                            else { 
                            String erw=tds.get(4).text().toString();
                            waterbathall+=1;
                            }}}
        
                            
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Read Vars From File  
   
    try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Timer.kady"));
      
      lproduct=buf.readLine().replace("Load_Product=","");
      rproduct=buf.readLine().replace("Remove_Product=","");
      tempraturee=buf.readLine().replace("Temprature=","");
      ftank=buf.readLine().replace("Fill_Tank=","");
      etank=buf.readLine().replace("Empty_Tank=","");
      cdosage =buf.readLine().replace("Chemical_Dosage=","");
      
      buf.close();
      } catch (FileNotFoundException fileNotFoundException) {
      } catch (IOException iOException) {}
   
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    String lproductt=lproduct;
    String rproductt=rproduct;
    String tempratureee=tempraturee;
    String ftankk=ftank;
    String etankk=etank;
    String cdosagee=cdosage;
    
    int bathnumm=bathnum;
    
    bosbos=bathnum;
    
    double firstshott=firstshot;
    double secondshott=secondshot;
    
    int tempp=temp;
    int tempp2=tempall-temp;
    int temppall=tempall;
    
    int waterbathx=waterbath;
    int waterbath2x=waterbathall-waterbath;
    int waterbathallx=waterbathall;
    
    int stonebathhh=stonebathh;
    
    loadremoveproduct=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
    tempraturetime=tempp*Double.parseDouble(tempratureee);
    chemicaldosage=Double.parseDouble(cdosagee);
    fillemptytank=waterbathx*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
    
    loadremoveproduct2=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
    tempraturetime2=tempp2*Double.parseDouble(tempratureee);
    chemicaldosage2=Double.parseDouble(cdosagee);
    fillemptytank2=waterbath2x*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
    
    loadremoveproductall=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
    tempraturetimeall=temppall*Double.parseDouble(tempratureee);
    chemicaldosageall=Double.parseDouble(cdosagee);
    fillemptytankall=waterbathallx*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
    
    //Alert for Bath Here
    
    
    
    if (bathnumm==1) {
        
      JFXTextField fss=new JFXTextField ("");
      fss.setPromptText("Write Stone Baths Number");
      fss.setMinSize(300, 30);
      fss.setLabelFloat(true);
      fss.setStyle("-fx-font-weight:bold;");
      fss.setEditable(true);
      Alert alerto = new Alert(Alert.AlertType.INFORMATION);
      alerto.setTitle("Stone Bath?");
      alerto.setHeaderText("We found stone or foam "+stonebathhh+" times. but 1 shot.");
      alerto.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alerto.setGraphic(fss);
      alerto.setResizable(false);
      DialogPane dialogPaneo = alerto.getDialogPane();
      dialogPaneo.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optiono = alerto.showAndWait();
      passy=fss.getText();
      stonabathth=Double.parseDouble(passy);
      if (optiono.get() == null) {} 
      else if (optiono.get() == ButtonType.OK) {
          
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabathth==0) {
          loadstone=0;
          removestone=0;
          cleaningstone=0;
          extraction=0;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
      }
      else if (stonabathth==1){
          
          loadstone=5.5;
          removestone=4.15;
          cleaningstone=15;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
      }
      
      
      else if (stonabathth==2){
          
          
          loadstone=16.5;
          removestone=8.3;
          cleaningstone=20;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
          
      }
      
      
      else {
          double v=stonabathth;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone=v2;
          removestone=v1;
          cleaningstone=0;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
      
      else if (optiono.get() == ButtonType.CANCEL) {
      Notifications noti3 = Notifications.create();
      noti3.title("Cancel!");
      noti3.text("Operation Cancelled, Something was wrong.");
      noti3.position(Pos.CENTER);
      noti3.hideAfter(Duration.seconds(3));
      noti3.showInformation();
      } else {
         
      }
        
    }
    
    else if (bathnumm==2) {
        
      JFXTextField fss=new JFXTextField ("");
      fss.setPromptText("Write Stone Baths Number");
      fss.setMinSize(300, 30);
      fss.setLabelFloat(true);
      fss.setStyle("-fx-font-weight:bold;");
      fss.setEditable(true);
      Alert alerto = new Alert(Alert.AlertType.INFORMATION);
      alerto.setTitle("Stone Bath?");
      alerto.setHeaderText("We found stone or foam "+stonebathhh+" times. for the first shot.");
      alerto.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alerto.setGraphic(fss);
      alerto.setResizable(false);
      DialogPane dialogPaneo = alerto.getDialogPane();
      dialogPaneo.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optiono = alerto.showAndWait();
      passy=fss.getText();
      stonabathth=Double.parseDouble(passy);
      if (optiono.get() == null) {} 
      else if (optiono.get() == ButtonType.OK) {
          
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabathth==0) {
          loadstone=0;
          removestone=0;
          cleaningstone=0;
          extraction=0;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
      }
      else if (stonabathth==1){
          
          loadstone=5.5;
          removestone=4.15;
          cleaningstone=15;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
      }
      
      
      else if (stonabathth==2){
          
          
          loadstone=16.5;
          removestone=8.3;
          cleaningstone=20;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
          
      }
      
      
      else {
          double v=stonabathth;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone=v2;
          removestone=v1;
          cleaningstone=0;
          extraction=20;
          double dos3=loadstone+removestone;
          loadremovestone=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
      
      else if (optiono.get() == ButtonType.CANCEL) {
      Notifications noti1 = Notifications.create();
      noti1.title("Cancel!");
      noti1.text("Operation Cancelled, Something was wrong.");
      noti1.position(Pos.CENTER);
      noti1.hideAfter(Duration.seconds(3));
      noti1.showInformation();
      } else {
         
      }
      
      ///////////yrtyrty///////////
      
      JFXTextField fsss=new JFXTextField ("");
      fsss.setPromptText("Write Stone Baths Number");
      fsss.setMinSize(300, 30);
      fsss.setLabelFloat(true);
      fsss.setStyle("-fx-font-weight:bold;");
      fsss.setEditable(true);
      Alert alertoo = new Alert(Alert.AlertType.INFORMATION);
      alertoo.setTitle("Stone Bath?");
      alertoo.setHeaderText("We found stone or foam "+stonebathhh+" times. for the second shot.");
      alertoo.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alertoo.setGraphic(fsss);
      alertoo.setResizable(false);
      DialogPane dialogPaneoo = alertoo.getDialogPane();
      dialogPaneoo.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optionoio = alertoo.showAndWait();
      passyy=fsss.getText();
      stonabaththh=Double.parseDouble(passyy);
      if (optionoio.get() == null) {} 
      else if (optionoio.get() == ButtonType.OK) {
         
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabaththh==0) {
          loadstone2=0;
          removestone2=0;
          cleaningstone2=0;
          extraction2=0;
          double dos3=loadstone2+removestone2;
          loadremovestone2=dos3;
          
      }
      else if (stonabaththh==1){
          
          loadstone2=5.5;
          removestone2=4.15;
          cleaningstone2=15;
          extraction2=20;
          double dos3=loadstone2+removestone2;
          loadremovestone2=dos3;
          
      }
      
      
      else if (stonabaththh==2){
          
          
          loadstone2=16.5;
          removestone2=8.3;
          cleaningstone2=20;
          extraction2=20;
          double dos3=loadstone2+removestone2;
          loadremovestone2=dos3;
          
          
      }
      
      
      else {
          double v=stonabaththh;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone2=v2;
          removestone2=v1;
          cleaningstone2=0;
          extraction2=20;
          double dos3=loadstone2+removestone2;
          loadremovestone2=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
      
      else if (optionoio.get() == ButtonType.CANCEL) {
      Notifications noti2 = Notifications.create();
      noti2.title("Cancel!");
      noti2.text("Operation Cancelled, Something was wrong.");
      noti2.position(Pos.CENTER);
      noti2.hideAfter(Duration.seconds(3));
      noti2.showInformation();
      } else {
         
      }
      
        
    }
    
     
    
    
    /////////////////////////////////////////////Starting//////////////////////////////////////////////////////////
    
    
    if (bathnumm==1) {
        
        gmf1=stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank;
        
        gdf1=(stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank)/60.0;
        
        //Write to recipe here //////////////////////////////////////////////////////////
        
Alert aloo = new Alert(Alert.AlertType.INFORMATION);
aloo.setTitle("Show Time");
aloo.setResizable(false);
aloo.setHeaderText("Here is time for "+name.getText()+" of "+modelooo+" Customer.");
aloo.setContentText("This Recipe Was One Shot:\nTime In Minutes=   "+gmf1+"."+"\nTime In Hours=   "+gdf1+".");
DialogPane dialogPanej = aloo.getDialogPane();
dialogPanej.getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
aloo.showAndWait();
        
      /////////////////////////////////////////////////////////////////////////////////////////
      
//      
//Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//alert.setTitle("Save To DB");
//alert.setHeaderText("Time Result");
//alert.setContentText("Here Is The result of Time For "+recipenami+" Recipe.");
//ButtonType buttonTypeOne = new ButtonType("Save To DB");
//ButtonType buttonTypeCancel = new ButtonType("Cancel");
//alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
//DialogPane dialogPanei = alert.getDialogPane();
//dialogPanei.getStylesheets().add(getClass().getResource("primer-dark.css").toExternalForm());
//Optional<ButtonType> results = alert.showAndWait();
//if (results.isPresent() && results.get() == buttonTypeOne) {
//Save To DB.

  
      
      //////////////////////////////////////////////////
  //Here Will Write To DB...........................
  
      
      Date currentDate1 = GregorianCalendar.getInstance().getTime();
      DateFormat df1 = DateFormat.getDateInstance();
      String dateString1 = df1.format(currentDate1);
      Date d1 = new Date();
      SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
      String timeString1 = sdf1.format(d1);
      SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
      String timeString2 = sdf2.format(d1);
      String datevaluey = timeString2;                                                          //Date
      
      shoty=1;
      

       try {
           
                    String sql0 = "select * from Timer_Pilot where Name like '" + name.getText() + "' and Model like '" + modelooo + "' ";
                    pst = conn.prepareStatement(sql0);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                    //Update
                       
                       wifi="found";
                       
                   ///////    
                       
                    }
                    
    ///////////////////////////////////////////////////////////////////////////////////                
                    
                    
                    else {
                        
                       //Insert
                       
                   wifi="not_found";
                  
      //////////////////////////////////////////                  
                        

                    }
      
                    
    }
        
        catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    } 
     
       
       
       
       
     String fifi=wifi;
     
     
     if (fifi.equals("found")) {
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
                             
                          if (bosbos==1) {
                              
                           String ti1,ti2;
                           String ti3,ti4;
                           ti4=Integer.toString(shoty+1);
                           ti3=Integer.toString(shoty);
                           ti1=Double.toString(gdf1);
                           ti2=Double.toString(gdf2);
                           String mi1=Double.toString(gmf1);
                           String mi2=Double.toString(gmf2);
                           
                                 try {
       
                                     
                                                 
     // String sqlm = "select * from Timer_Pilot where Name=?";
     // pst = conn.prepareStatement(sqlm);
     // pst.setString(1, recipenami);
     // rs = pst.executeQuery();
      
     // String add1 = rs.getString("Time_In_Min");
     // oldtimemin=add1;  //OLD TIME IN MINUTES.
      
     // String add2 = rs.getString("Time_In_Hour");
     // oldtimehour=add2;  //OLD TIME IN HOUR.
      
      
             
                                     
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+ti1+"' where Name='"+name.getText()+"' and Shot='"+ti3+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();
                                     
     
                
                
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti4 = Notifications.create();
      noti4.title("Update!");
      noti4.text("We Updated Record Successfully!");
      noti4.position(Pos.CENTER);
      noti4.hideAfter(Duration.seconds(3));
      noti4.showInformation();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
                       if (bosbos==2) {
                           
                               
                           String ti1,ti2;
                           String ti3,ti4;
                           ti4=Integer.toString(shoty+1);
                           ti3=Integer.toString(shoty);
                           ti1=Double.toString(gdf1);
                           ti2=Double.toString(gdf2);
                           String mi1=Double.toString(gmf1);
                           String mi2=Double.toString(gmf2);
                           
                           
                              try {
                                  
                                  
//      String sqlm = "select * from Timer_Pilot where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, ti3);
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour=add2;  //OLD TIME IN HOUR.
      
   //   pst.execute();
                            
         
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+ti1+"' where Name='"+name.getText()+"' and Shot='"+ti3+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();    
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti5 = Notifications.create();
      noti5.title("Update!");
      noti5.text("We Updated Record 1 Successfully!");
      noti5.position(Pos.CENTER);
      noti5.hideAfter(Duration.seconds(3));
      noti5.showInformation();
        
      
      } catch (Exception exception) {}
    }    
                           
                              
                                 try {
                            
                                    
//      String sqlm = "select * from Timer where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, filenammm);
//      pst.setString(2, ti4);
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin2=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour2=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi2+"', Time_In_Hour='"+ti2+"' where Name='"+name.getText()+"' and Shot='"+ti4+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();         
                                     
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti6 = Notifications.create();
      noti6.title("Update!");
      noti6.text("We Updated Record 2 Successfully!");
      noti6.position(Pos.CENTER);
      noti6.hideAfter(Duration.seconds(3));
      noti6.showInformation();
        
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
         


         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
     }
       
       
     else if (fifi.equals("not_found")) {
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
         
                       if (bosbos==1) {
                           
                           
                                 try {
                            
          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,name.getText());
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti7 = Notifications.create();
      noti7.title("Insert!");
      noti7.text("We Inserted Record Successfully!");
      noti7.position(Pos.CENTER);
      noti7.hideAfter(Duration.seconds(3));
      noti7.showInformation();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
                       if (bosbos==2) {
                           
                              try {
                            
          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,name.getText());
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti5 = Notifications.create();
      noti5.title("Insert!");
      noti5.text("We Inserted Record 1 Successfully!");
      noti5.position(Pos.CENTER);
      noti5.hideAfter(Duration.seconds(3));
      noti5.showInformation();
      
      } catch (Exception exception) {}
    }    
                           
                              
                                 try {
                            
          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,name.getText());
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti1 = Notifications.create();
      noti1.title("Insert!");
      noti1.text("We Inserted Record 2 Successfully!");
      noti1.position(Pos.CENTER);
      noti1.hideAfter(Duration.seconds(3));
      noti1.showInformation();
        
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
        
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
     }
       
     
     else {}
       
       
      
      
      
      
      
      
      
      
      
      ////////////////////////////////END DB////////////////////////////////////////////////////
        
      

//} 
//else {}
      
      
      
    
      
    }
    
    else if (bathnumm==2) {
        
        gmf1=stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank;
        
        gdf1=(stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank)/60.0;
        
        gmf2=stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2;
        
        gdf2=(stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2)/60.0;
        
        
          //Write to recipe here //////////////////////////////////////////////////////////
          
          
          
Alert aloo = new Alert(Alert.AlertType.INFORMATION);
aloo.setTitle("Show Time");
aloo.setResizable(false);
aloo.setHeaderText("Here is time for "+name.getText()+" of "+modelooo+" Customer.");
aloo.setContentText("This Recipe Was Two Shots:\nFirst Shot Info:\nTime In Minutes=   "+gmf1+"."+"\nTime In Hours=   "+gdf1+".\n\n"+"Second Shot Info:\nTime In Minutes=   "+gmf2+"."+"\nTime In Hours=   "+gdf2+".\n\n");
DialogPane dialogPanej = aloo.getDialogPane();
dialogPanej.getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
aloo.showAndWait();
       
        /////////////////////////////////////////////////////////////////////////////////
        
        
//Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
//alert.setTitle("Save To DB");
//alert.setHeaderText("Time Result");
//alert.setContentText("Here Is The result of Time For "+recipenami+" Recipe.");
//ButtonType buttonTypeOne = new ButtonType("Save To DB");
//ButtonType buttonTypeCancel = new ButtonType("Cancel");
//alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
//DialogPane dialogPanei = alert.getDialogPane();
//dialogPanei.getStylesheets().add(getClass().getResource("primer-dark.css").toExternalForm());
//Optional<ButtonType> results = alert.showAndWait();
//if (results.isPresent() && results.get() == buttonTypeOne) {
////Save To DB.

          
      //////////////////////////////////////////////////
  //Here Will Write To DB...........................
  
      
      Date currentDate1 = GregorianCalendar.getInstance().getTime();
      DateFormat df1 = DateFormat.getDateInstance();
      String dateString1 = df1.format(currentDate1);
      Date d1 = new Date();
      SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
      String timeString1 = sdf1.format(d1);
      SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
      String timeString2 = sdf2.format(d1);
      String datevaluey = timeString2;                                                          //Date
      
      shoty=1;
      

       try {
           
                    String sql0 = "select * from Timer_Pilot where Name like '" + name.getText() + "' and Model like '" + modelooo + "' ";
                    pst = conn.prepareStatement(sql0);
                    rs = pst.executeQuery();
                    if (rs.next()) {
                    //Update
                       
                       wifi="found";
                       
                   ///////    
                       
                    }
                    
    ///////////////////////////////////////////////////////////////////////////////////                
                    
                    
                    else {
                        
                       //Insert
                       
                   wifi="not_found";
                  
      //////////////////////////////////////////                  
                        

                    }
      
                    
    }
        
        catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    } 
     
       
       
       
       
     String fifi=wifi;
     
     
     if (fifi.equals("found")) {
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
                             
                          if (bosbos==1) {
                              
                           String ti1,ti2;
                           String ti3,ti4;
                           ti4=Integer.toString(shoty+1);
                           ti3=Integer.toString(shoty);
                           ti1=Double.toString(gdf1);
                           ti2=Double.toString(gdf2);
                           String mi1=Double.toString(gmf1);
                           String mi2=Double.toString(gmf2);
                           
                                 try {
       
                                     
                                                 
//      String sqlm = "select * from Timer where Name=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour=add2;  //OLD TIME IN HOUR.
      
      
             
                                     
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+ti1+"' where Name='"+name.getText()+"' and Shot='"+ti3+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();
                                     
     
                
                
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
                       if (bosbos==2) {
                           
                               
                           String ti1,ti2;
                           String ti3,ti4;
                           ti4=Integer.toString(shoty+1);
                           ti3=Integer.toString(shoty);
                           ti1=Double.toString(gdf1);
                           ti2=Double.toString(gdf2);
                           String mi1=Double.toString(gmf1);
                           String mi2=Double.toString(gmf2);
                           
                           
                              try {
                                  
                                  
//      String sqlm = "select * from Timer where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, ti3);
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour=add2;  //OLD TIME IN HOUR.
      
   //   pst.execute();
                            
         
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+ti1+"' where Name='"+name.getText()+"' and Shot='"+ti3+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();    
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                              
                                 try {
                            
                                    
//      String sqlm = "select * from Timer where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, filenammm);
//      pst.setString(2, ti4);
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin2=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour2=add2;  //OLD TIME IN HOUR.
//      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi2+"', Time_In_Hour='"+ti2+"' where Name='"+name.getText()+"' and Shot='"+ti4+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();         
                                     
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
         


         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
     }
       
       
     else if (fifi.equals("not_found")) {
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
         
                       if (bosbos==1) {
                           
                           
                                 try {
                            
          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,name.getText());
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
                       if (bosbos==2) {
                           
                              try {
                            
          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,name.getText());
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                              
                                 try {
                            
          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,name.getText());
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
        
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
     }
       
     
     else {}
       
       
      
      ////////////////////////////////END DB////////////////////////////////////////////////////
       

//} 
//else {}
        
        
  
        //////////////////////////////////////////////////////////////////////////////////
        
    }
    
    
    else {
        
        //Noti
        
      Notifications noti7 = Notifications.create();
      noti7.title("Cancel!");
      noti7.text("Operation Cancelled, We don't have 3 shots in one recipe.\nWe are working on this feature");
      noti7.position(Pos.CENTER);
      noti7.hideAfter(Duration.seconds(3));
      noti7.showError();
    }
    
    
    /////////////////////////////////////////////Ending////////////////////////////////////////////////////////////
   
   
    ///////////////////////////////////Fuck End//////////////////////////////////////////////////////////////////////////////////////////
    
    
                        
sumz=0.0;
ally=0.0;          
String recipenami=name.getText();
          
      

                            org.jsoup.nodes.Document docyi = Jsoup.parse(code.getText());
                            for (Element table : docyi.select("table")) {
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
            
            Notifications notii = Notifications.create();
            notii.title("Successful");
            notii.text("We have updated the stone successfully.");
            notii.hideAfter(Duration.seconds(3));
            notii.position(Pos.CENTER);
            notii.showInformation();
            
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
            
            Notifications notii = Notifications.create();
            notii.title("Successful");
            notii.text("We have inserted the new stone successfully.");
            notii.hideAfter(Duration.seconds(3));
            notii.position(Pos.CENTER);
            notii.showInformation();
            
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
    
    
    
    //////////////////////////////////////////////////////////////PILOT END//////////////////////////////////////////////////////////
    
  
    
    //////////////////Add DB OR No//////////////////
    
    
              
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("DataBase Alert");
alert.setHeaderText("Add To DataBase");
alert.setContentText("Choose one option to continue: ");
ButtonType buttonTypeOne = new ButtonType("Add To DB");
ButtonType buttonTypeCancel = new ButtonType("Cancel");
alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
DialogPane dialogPanei = alert.getDialogPane();
dialogPanei.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> results = alert.showAndWait();
if (results.isPresent() && results.get() == buttonTypeOne) {
    
     String dfgfd=model.getSelectionModel().getSelectedItem().toString();
     String reern=name.getText();
     //pattt
     
     
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String timeString = sdf.format(d);
    String value0 = timeString;
     
    try {
      String sql = "insert into Development (Date,Stage,Model,Name,Path,Type,Revised_Date) values (?,?,?,?,?,?,?)";
      pst = conn.prepareStatement(sql);
      pst.setString(1, value0);
      pst.setString(2, "DEVELOPMENT");
      pst.setString(3, dfgfd);
      pst.setString(4, reern);
      pst.setString(5, pattt);
      pst.setString(6, "Pending");
      pst.setString(7, "Not_Revised");
      pst.execute();
    } catch (Exception e) {
      //JOptionPane.showMessageDialog(null, e);
      Notifications notiu = Notifications.create();
      notiu.title("Fatal Error!");
      notiu.text(e.toString());
      notiu.position(Pos.CENTER);
      notiu.hideAfter(Duration.seconds(3));
      notiu.showError();
    } finally {
      try {
        rs.close();
        pst.close();
      } catch (Exception exception) {}
    }    
    
    
    ////////////////////////////////////////////////  
    
}


else {
    
    
    
}
    
    
    Git.gitCommands();
     
        
    }

    
    
    @FXML
    void modelhide(Event event) throws FileNotFoundException, IOException {

String ccc=code.getText();


  //////////////////////Fix Here///////////////////////////////
        
      
      if (!ccc.contains("TABLE")) {
      Notifications noti = Notifications.create();
      noti.title("Recipe Error");
      noti.text("Maybe not a recipe, Open a recipe first!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showError();    
        }
        else {
            org.jsoup.nodes.Document doc = Jsoup.parse(ccc);
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
    
            }   
         
        }}
       code.setText(doc.toString());
        }
        
///////////////////////////////////////////////////////////////
String hlk=code.getText();

      if (!hlk.contains("TABLE")) {
      Notifications noti = Notifications.create();
      noti.title("Recipe Error");
      noti.text("Maybe not a recipe, Open a recipe first!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showError();    
        }
        else {
            org.jsoup.nodes.Document doc = Jsoup.parse(hlk);
        for (Element table : doc.select("TABLE")) {
        for (Element row : table.select("TR")) {
            Elements tds = row.select("TD");
            if (tds.get(8).text().isEmpty()) {   
            }
            
           
            else {  
             ///////////////////////////////////////////////////////////////
String string=tds.get(8).text();
BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Lot_Numbers.kady"));
String line;
String linebeforeequal;//Chemical Name
String lineafterequal;//Lot Numbers
boolean found = false;         
while ((line=buf.readLine())!=null) {
linebeforeequal=line.substring(0,line.indexOf("="));//Chemical Name
lineafterequal=line.substring(line.indexOf("=") + 1);//Lot Numbers

if (string.equalsIgnoreCase(linebeforeequal)) {
System.out.println(linebeforeequal);
String formattedText = "<b style='display:block; text-align:center;'>" + lineafterequal + "</b>";
tds.get(9).html(formattedText); // Use .html() instead of .text()     
//tds.get(9).text(lineafterequal);
//System.out.println(lineafterequal);
found = true;                    
break;

    }
  
    
}
buf.close();

             ///////////////////////////////////////////////////////////////
               
            }   
         
         
        }}
       code.setText(doc.toString());
        }
        
      
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
String roraa = code.getText();         
org.jsoup.nodes.Document doctp = Jsoup.parse(roraa);
// مر على كل جدول
for (Element table : doctp.select("table")) {
    for (Element row : table.select("tr")) {
        Elements tds = row.select("td");
        // اتأكد إن فيه على الأقل 11 عمود (0 → 10)
        if (tds.size() > 10) {
            String target = tds.get(8).text().trim();
            if (!target.isEmpty()) {
                Path mapPath = Paths.get(NewDir.file_dirrrr, "Recipe_Indexes", "Chemical_Translation.kady");
                try (BufferedReader bufi = Files.newBufferedReader(mapPath, StandardCharsets.UTF_8)) {
                    String line;
                    boolean found = false;
                    while ((line = bufi.readLine()) != null) {
                        // اتأكد إن السطر فيه =
                        if (!line.contains("=")) continue;
                        String linebeforeequal = line.substring(0, line.indexOf("=")).trim();
                        String lineafterequal = line.substring(line.indexOf("=") + 1).trim();
                        if (target.equalsIgnoreCase(linebeforeequal)) {
                            System.out.println("Matched: " + linebeforeequal);
                            String formattedText =
                                    "<b style='display:block; text-align:center;'>" +
                                            lineafterequal +
                                            "</b>";
                            // استبدل العمود رقم 10 بالنص الجديد
                            tds.get(10).html(formattedText);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("No match for: " + target);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
//roraa = doctp.toString();
code.setText(doctp.toString());          
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

      
      
    ////////////////////////////////////////////////////////////////////////////
        
String sdf=code.getText();


String newccc=sdf+"<STYLE>\n" +
"BODY {\n" +
"BACKGROUND-IMAGE: URL(\""+model.getSelectionModel().getSelectedItem().toString().toUpperCase()+".BMP\");\n" +
"BACKGROUND-POSITION: CENTER;\n" +
"HEIGHT: 170PX;\n" +
"BACKGROUND-POSITION-X:550PX;  BACKGROUND-REPEAT: NO-REPEAT;\n" +
"BACKGROUND-SIZE: 120PX 90PX;\n" +
"}\n" +
"</STYLE>";
        
        code.clear();
        
        code.setText(newccc);
        
        preview.getEngine().loadContent(code.getText());
        
        //System.out.println(code.getText());
                
    }

    
    
    
    
    @FXML
    void modelshow(Event event) {

        this.model.getItems().clear();
    try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Models.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
        this.model.getItems().addAll(new String[] { line });
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
        
        
        
    }

    
    
    
    
    @FXML
    void signaction(ActionEvent event) throws FileNotFoundException, IOException {

        
        if (sign.isSelected()==true) {
            
        String ddd=htt;
        
        
          //////////////////////Fix Here///////////////////////////////
        
      
      if (!ddd.contains("TABLE")) {
      Notifications noti = Notifications.create();
      noti.title("Recipe Error");
      noti.text("Maybe not a recipe, Open a recipe first!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showError();    
        }
        else {
            org.jsoup.nodes.Document doc = Jsoup.parse(ddd);
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
    
            }   
         
        }}
       code.setText(doc.toString());
        }
        
///////////////////////////////////////////////////////////////
String xcs=code.getText();

      if (!xcs.contains("TABLE")) {
      Notifications noti = Notifications.create();
      noti.title("Recipe Error");
      noti.text("Maybe not a recipe, Open a recipe first!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showError();    
        }
        else {
            org.jsoup.nodes.Document doc = Jsoup.parse(xcs);
        for (Element table : doc.select("TABLE")) {
        for (Element row : table.select("TR")) {
            Elements tds = row.select("TD");
            if (tds.get(8).text().isEmpty()) {   
            }
            
           
            else {  
             ///////////////////////////////////////////////////////////////
String string=tds.get(8).text();
BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Lot_Numbers.kady"));
String line;
String linebeforeequal;//Chemical Name
String lineafterequal;//Lot Numbers
boolean found = false;         
while ((line=buf.readLine())!=null) {
linebeforeequal=line.substring(0,line.indexOf("="));//Chemical Name
lineafterequal=line.substring(line.indexOf("=") + 1);//Lot Numbers

if (string.equalsIgnoreCase(linebeforeequal)) {
System.out.println(linebeforeequal);
String formattedText = "<b style='display:block; text-align:center;'>" + lineafterequal + "</b>";
tds.get(9).html(formattedText); // Use .html() instead of .text()     
//tds.get(9).text(lineafterequal);
//System.out.println(lineafterequal);
found = true;                    
break;

    }
  
    
}
buf.close();

             ///////////////////////////////////////////////////////////////
               
            }   
         
         
        }}
       code.setText(doc.toString());
        }
        
      
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
String roraa = code.getText();         
org.jsoup.nodes.Document doctp = Jsoup.parse(roraa);
// مر على كل جدول
for (Element table : doctp.select("table")) {
    for (Element row : table.select("tr")) {
        Elements tds = row.select("td");
        // اتأكد إن فيه على الأقل 11 عمود (0 → 10)
        if (tds.size() > 10) {
            String target = tds.get(8).text().trim();
            if (!target.isEmpty()) {
                Path mapPath = Paths.get(NewDir.file_dirrrr, "Recipe_Indexes", "Chemical_Translation.kady");
                try (BufferedReader bufi = Files.newBufferedReader(mapPath, StandardCharsets.UTF_8)) {
                    String line;
                    boolean found = false;
                    while ((line = bufi.readLine()) != null) {
                        // اتأكد إن السطر فيه =
                        if (!line.contains("=")) continue;
                        String linebeforeequal = line.substring(0, line.indexOf("=")).trim();
                        String lineafterequal = line.substring(line.indexOf("=") + 1).trim();
                        if (target.equalsIgnoreCase(linebeforeequal)) {
                            System.out.println("Matched: " + linebeforeequal);
                            String formattedText =
                                    "<b style='display:block; text-align:center;'>" +
                                            lineafterequal +
                                            "</b>";
                            // استبدل العمود رقم 10 بالنص الجديد
                            tds.get(10).html(formattedText);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("No match for: " + target);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
//roraa = doctp.toString();
code.setText(doctp.toString());          
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

      
      
      
      String lpo=code.getText();
    ////////////////////////////////////////////////////////////////////////////
        
       
        
        String newddd=lpo+"<B ID=\"SIGNNAME\">MR_MUHAMMET SIGNATURE: </B><IMG ID=\"SIGNIMAGE\" SRC=\"FILE://Z:\\MODELS\\MR_MUHAMMET.PNG\" WIDTH=\"300\" HEIGHT=\"90\" ALT=\"DEVELOPED BY KADYSOFT LTD (AHMED ELKADY).\" STYLE=\"BORDER-COLOR:BLACK;BORDER-WIDTH:10PX;\">";
        
        code.clear();
        
        code.setText(newddd);
        
        preview.getEngine().loadContent(code.getText());
            
        }
        
        
        else {
            
        String ddd=htt;
        
        
                  //////////////////////Fix Here///////////////////////////////
        
      
      if (!ddd.contains("TABLE")) {
      Notifications noti = Notifications.create();
      noti.title("Recipe Error");
      noti.text("Maybe not a recipe, Open a recipe first!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showError();    
        }
        else {
            org.jsoup.nodes.Document doc = Jsoup.parse(ddd);
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
    
            }   
         
        }}
       code.setText(doc.toString());
        }
        
///////////////////////////////////////////////////////////////
String xcs=code.getText();

      if (!xcs.contains("TABLE")) {
      Notifications noti = Notifications.create();
      noti.title("Recipe Error");
      noti.text("Maybe not a recipe, Open a recipe first!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showError();    
        }
        else {
            org.jsoup.nodes.Document doc = Jsoup.parse(xcs);
        for (Element table : doc.select("TABLE")) {
        for (Element row : table.select("TR")) {
            Elements tds = row.select("TD");
            if (tds.get(8).text().isEmpty()) {   
            }
            
           
            else {  
             ///////////////////////////////////////////////////////////////
String string=tds.get(8).text();
BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Lot_Numbers.kady"));
String line;
String linebeforeequal;//Chemical Name
String lineafterequal;//Lot Numbers
boolean found = false;         
while ((line=buf.readLine())!=null) {
linebeforeequal=line.substring(0,line.indexOf("="));//Chemical Name
lineafterequal=line.substring(line.indexOf("=") + 1);//Lot Numbers

if (string.equalsIgnoreCase(linebeforeequal)) {
System.out.println(linebeforeequal);
String formattedText = "<b style='display:block; text-align:center;'>" + lineafterequal + "</b>";
tds.get(9).html(formattedText); // Use .html() instead of .text()     
//tds.get(9).text(lineafterequal);
//System.out.println(lineafterequal);
found = true;                    
break;

    }
  
    
}
buf.close();

             ///////////////////////////////////////////////////////////////
               
            }   
         
         
        }}
       code.setText(doc.toString());
        }
        
      
      /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
String roraa = code.getText();         
org.jsoup.nodes.Document doctp = Jsoup.parse(roraa);
// مر على كل جدول
for (Element table : doctp.select("table")) {
    for (Element row : table.select("tr")) {
        Elements tds = row.select("td");
        // اتأكد إن فيه على الأقل 11 عمود (0 → 10)
        if (tds.size() > 10) {
            String target = tds.get(8).text().trim();
            if (!target.isEmpty()) {
                Path mapPath = Paths.get(NewDir.file_dirrrr, "Recipe_Indexes", "Chemical_Translation.kady");
                try (BufferedReader bufi = Files.newBufferedReader(mapPath, StandardCharsets.UTF_8)) {
                    String line;
                    boolean found = false;
                    while ((line = bufi.readLine()) != null) {
                        // اتأكد إن السطر فيه =
                        if (!line.contains("=")) continue;
                        String linebeforeequal = line.substring(0, line.indexOf("=")).trim();
                        String lineafterequal = line.substring(line.indexOf("=") + 1).trim();
                        if (target.equalsIgnoreCase(linebeforeequal)) {
                            System.out.println("Matched: " + linebeforeequal);
                            String formattedText =
                                    "<b style='display:block; text-align:center;'>" +
                                            lineafterequal +
                                            "</b>";
                            // استبدل العمود رقم 10 بالنص الجديد
                            tds.get(10).html(formattedText);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("No match for: " + target);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
//roraa = doctp.toString();
code.setText(doctp.toString());          
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

      
      
      
      String lpo=code.getText();
    ////////////////////////////////////////////////////////////////////////////
        
       
        
        
        String newddd=lpo+"";
        
        code.clear();
        
        code.setText(newddd);
        
        preview.getEngine().loadContent(code.getText());
            
        }
        
        
    }
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        conn = db.java_db();
        
    }    
    
}
