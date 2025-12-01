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
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Iterator;
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
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import static kadysoft.kady.ExcelFastModeController.htt;
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
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class ExcelConvertMultipleController implements Initializable {

    
    
    @FXML
    private JFXTextArea list,rora;
    
     @FXML
    private JFXTextField browsee;

    @FXML
    private Text text;
    
    
    @FXML
    private JFXButton fix;
    
      @FXML
    void browseeaction(ActionEvent event) throws FileNotFoundException, IOException{
        
        //Choose Directory
        
        DirectoryChooser dir=new DirectoryChooser ();
        File fd=dir.showDialog(null);
        String pas=fd.getAbsolutePath().toString();
        browsee.setText(pas);
        
    }
    
    
    
    
    @FXML
    void fixaction(ActionEvent event) throws FileNotFoundException, IOException{

 
        String[] filess=list.getText().split("\n");
        
        for (String namo :filess) {
            
        rora.clear();
        File ff=new File (namo);
        String patt=namo;
        Path path = Paths.get(patt);
        String fileName = path.getFileName().toString();
        String nnn=fileName.replace(".xlsx","").replace("-","_").replace(".","_").replace(" ","_").replace("  ","_");
        
        if (ff != null) {
        try (FileInputStream fis = new FileInputStream(ff);
        Workbook workbook = new XSSFWorkbook(fis)) {
        Sheet sheet = workbook.getSheetAt(0);
        String htmlTable = convertExcelToHtml(sheet);
        rora.appendText("<!DOCTYPE HTML>\n" + 
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
        rora.appendText(htmlTable);
        rora.appendText("</CENTER>\n" +
"</BODY>\n" +
"</HTML>");
        
       htt=rora.getText();
       //////////////////////Fix Here///////////////////////////////
        
      String coder = rora.getText();
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
       rora.setText(doc.toString());
        }
        
///////////////////////////////////////////////////////////////

      String codeu = rora.getText();
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
       rora.setText(doc.toString());
        }
      
      
      //Complete Here
      
        String llink=browsee.getText()+"\\Kadinioo";
        File sa=new File (llink);
        sa.mkdir();

        String full=llink+"\\"+nnn+".ks";
        File ds=new File (full);
        ds.createNewFile();
        
        String allcode=rora.getText()
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
        
    OutputStream instreamm=new FileOutputStream(full);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    //PrintWriter pw=new PrintWriter (new FileWriter (pathy));
    pw.println(allcode);
    pw.close();
    Notifications noti = Notifications.create();
    noti.title("Successful");
    noti.text("We have created the recipe successfully.");
    noti.hideAfter(Duration.seconds(3));
    noti.position(Pos.CENTER);
    noti.showInformation();
    
    rora.clear();
     
    ////////////////////////////////////////////////////////////////////////////
     
        } catch (IOException e) {
        
        }} 
        
         
    
      Notifications noti = Notifications.create();
      noti.title("Successful Operation");
      noti.text("We Converted Recipe successfully!.");
      noti.hideAfter(Duration.seconds(3));
      noti.position(Pos.CENTER);
      noti.showInformation();
          
                
                
        }
    
        list.clear();
        
        
        
        
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
       
        
        String user=System.getProperty("user.home")+"\\Desktop";
        browsee.setText(user);
        
        
        
    }    
    
}
