
package kadysoft.kady;

import io.github.palexdev.materialfx.controls.MFXButton;
import io.github.palexdev.materialfx.controls.MFXTextField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
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
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class CreateFastModeController implements Initializable {

    Connection conn = null;
  
    ResultSet rs = null;
  
    PreparedStatement pst = null;
   
    @FXML
    private MFXTextField date;

    @FXML
    private MFXButton refresh;

    @FXML
    private ComboBox<String> model;

    @FXML
    private WebView webview;

    @FXML
    private MFXTextField pcs;

    @FXML
    private MFXTextField name;

    @FXML
    private MFXTextField kg;

    @FXML
    private ComboBox<String> stage;

    @FXML
    private MFXButton save;
    
    String code;
    
    String link;

    
    
    
    @FXML
    void modelaction(Event event) {

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
    void refreshaction(ActionEvent event) throws IOException {

        String datee=date.getText();
        String modell=model.getSelectionModel().getSelectedItem().toString().toUpperCase();
        String namee=name.getText().toUpperCase().replace(" ","_");
        String stagee=stage.getSelectionModel().getSelectedItem().toString().toUpperCase();
        String pcss=pcs.getText();
        String kgg=kg.getText();
        
        String template="<!DOCTYPE HTML>\n" +
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
"}/* Centered Watermark */\n" +
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
"    }</STYLE></HEAD>\n" +
"<BODY><CENTER>\n" +
"<div class=\"watermark\"></div>\n" +
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
"    </SCRIPT><TABLE ID='EXTABLE' BORDER='1' STYLE='BORDER-COLLAPSE:COLLAPSE;'>\n" +
"  <TR>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +                
"  </TR>\n" +
"  <TR>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFF00; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>_STAGE_</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFF00; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFF00; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFF00; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFF00; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#ffffff; COLOR:#000000; text-align:left; font-weight:bold;font-size:12pt;'>DATE:</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>_DATE_</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +                
"  </TR>\n" +
"  <TR>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:left; font-weight:bold;font-size:12pt;'>CUST  :</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>_MODEL_</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:left; font-weight:bold;font-size:12pt;'>WASH NAME :</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>_NAME_</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +                
"  </TR>\n" +
"  <TR>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:left; font-weight:bold;font-size:12pt;'>PO NO :</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:left; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +                
"  </TR>\n" +
"  <TR>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:left; font-weight:bold;font-size:12pt;'>PO AMOUNT :</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>KG :</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>_KG_</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +                
"  </TR>\n" +
"  <TR>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:left; font-weight:bold;font-size:12pt;'>FABRIC NAME  :</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +                
"  </TR>\n" +
"  <TR>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:left; font-weight:bold;font-size:12pt;'>MACHINE NO :</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>OPERATOR</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>SPINING NO</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>OPERATOR</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>DRYER NO </TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>OPERATOR</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>PCS :</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>_PCS_</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +                
"  </TR>\n" +
"  <TR>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +                
"  </TR>\n" +
"  <TR>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFF00; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>COMMENTS</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFF00; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>ACTION NAME</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFF00; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>TIME(MIN)</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFF00; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>TEMP</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFF00; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>LITER'S</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFF00; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>AMT</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFF00; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>UNIT'S</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFF00; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>CHEMICAL</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFF00; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>CHEMICAL NAME</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFF00; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>CHEMICAL LOT NUMBER</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFF00; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>CHEMICAL DEFINITIONS</TD>\n" +                
"  </TR>\n" +
"  <TR>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-size:12pt;'></TD>\n" +
"  </TR>\n" +
"  <TR>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +                
"  </TR>\n" +
"  <TR>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>DESIZE</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>5</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>20</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>500</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>500</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>GR</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>DISPERSE</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +                
"  </TR>\n" +
"   <TR>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"  </TR>\n" +
"  <TR>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>RINSE</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>2</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>20</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'>500</TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"  </TR>\n" +
"  <TR>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"  </TR>\n" +
"  <TR>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"  </TR>\n" +
"  <TR>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"  </TR>\n" +
"  <TR>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"  </TR>\n" +
"  <TR>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"  </TR>\n" +
"  <TR>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"  </TR>\n" +
"  <tr>\n" +
"<td style=\"border-style: DOTTED; background-color: #ffffff; color: #000000; text-align: CENTER; font-weight: BOLD; font-size: 12PT;\">&nbsp;</td>\n" +
"<td style=\"border-style: DOTTED; background-color: #ffffff; color: #000000; text-align: CENTER; font-weight: BOLD; font-size: 12PT;\">&nbsp;</td>\n" +
"<td style=\"border-style: DOTTED; background-color: #ffffff; color: #000000; text-align: CENTER; font-weight: BOLD; font-size: 12PT;\">&nbsp;</td>\n" +
"<td style=\"border-style: DOTTED; background-color: #ffff00; color: #000000; text-align: CENTER; font-weight: BOLD; font-size: 12PT;\">EXTRACT &amp; DRYER</td>\n" +
"<td style=\"border-style: DOTTED; background-color: #ffffff; color: #000000; text-align: CENTER; font-weight: BOLD; font-size: 12PT;\">&nbsp;</td>\n" +
"<td style=\"border-style: DOTTED; background-color: #ffffff; color: #000000; text-align: CENTER; font-weight: BOLD; font-size: 12PT;\">&nbsp;</td>\n" +
"<td style=\"border-style: DOTTED; background-color: #ffffff; color: #000000; text-align: CENTER; font-weight: BOLD; font-size: 12PT;\">&nbsp;</td>\n" +
"<td style=\"border-style: DOTTED; background-color: #ffffff; color: #000000; text-align: CENTER; font-weight: BOLD; font-size: 12PT;\">&nbsp;</td>\n" +
"<td style=\"border-style: DOTTED; background-color: #ffffff; color: #000000; text-align: CENTER; font-weight: BOLD; font-size: 12PT;\">&nbsp;</td>\n" +
"<td style=\"border-style: DOTTED; background-color: #ffffff; color: #000000; text-align: CENTER; font-weight: BOLD; font-size: 12PT;\">&nbsp;</td>\n" +
"<td style=\"border-style: DOTTED; background-color: #ffffff; color: #000000; text-align: CENTER; font-weight: BOLD; font-size: 12PT;\">&nbsp;</td>\n" +                
"</tr>\n" +
"  <TR>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"    <TD STYLE=' BORDER-STYLE: DOTTED; BACKGROUND-COLOR:#FFFFFF; COLOR:#000000; text-align:center; font-weight:bold;font-size:12pt;'></TD>\n" +
"  </TR>\n" +
"</TABLE></CENTER>\n" +
"</BODY>\n" +
"</HTML><B ID=\"SIGNNAME\">MR_MUHAMMET SIGNATURE: </B><IMG ID=\"SIGNIMAGE\" SRC=\"FILE://Z:\\MODELS\\MR_MUHAMMET.PNG\" WIDTH=\"300\" HEIGHT=\"90\" ALT=\"DEVELOPED BY KADYSOFT LTD (AHMED ELKADY).\" STYLE=\"BORDER-COLOR:BLACK;BORDER-WIDTH:10PX;\"><STYLE>\n" +
"BODY {\n" +
"BACKGROUND-IMAGE: URL(\"_MODEL_.BMP\");\n" +
"BACKGROUND-POSITION: CENTER;\n" +
"HEIGHT: 170PX;\n" +
"BACKGROUND-POSITION-X:550PX;  BACKGROUND-REPEAT: NO-REPEAT;\n" +
"BACKGROUND-SIZE: 120PX 90PX;\n" +
"}\n" +
"</STYLE>";
        
        //System.out.println(template);
        
        code=template.replace("_DATE_",datee).replace("_MODEL_",modell).replace("_NAME_",namee).replace("_STAGE_",stagee+" RECIPE").replace("_PCS_",pcss).replace("_KG_",kgg);
        
        webview.getEngine().loadContent("");
        
        webview.getEngine().loadContent(code);
        
        String kkk=NewDir.file_dir+"\\"+stagee+"\\"+modell;
        
        File sa=new File (kkk);
        sa.mkdir();
        
        link=NewDir.file_dir+"\\"+stagee+"\\"+modell+"\\"+namee+".ks";
        File hds=new File(link);
        hds.createNewFile();
        
        //System.out.println(link);
        
      
        
    }

    
    
    
    @FXML
    void saveaction(ActionEvent event) throws IOException {

        //Save Here
        
        File file=new File (link);
        file.createNewFile();
        
        String allcode=code
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
        
    OutputStream instreamm=new FileOutputStream(file);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    pw.println(allcode);
    pw.close();
    Notifications noti = Notifications.create();
    noti.title("Successful");
    noti.text("We have created the recipe successfully.");
    noti.hideAfter(Duration.seconds(3));
    noti.position(Pos.CENTER);
    noti.showInformation();
    
    
//////////////////////////////////////////////////////////////////


        
        String stageeo=stage.getSelectionModel().getSelectedItem().toString().toUpperCase();
        
        if (stageeo.equals("PRODUCTION")) {
            
               
Alert alertd = new Alert(Alert.AlertType.CONFIRMATION);
alertd.setTitle("Save To DB");
alertd.setHeaderText("Processes Result");
alertd.setContentText("What do you want to do?");
ButtonType buttonTypeOned = new ButtonType("Save To DB");
ButtonType buttonTypeCanceld = new ButtonType("Cancel");
alertd.getButtonTypes().setAll(buttonTypeOned, buttonTypeCanceld);
DialogPane dialogPaneid = alertd.getDialogPane();
dialogPaneid.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> resultsd = alertd.showAndWait();
if (resultsd.isPresent() && resultsd.get() == buttonTypeOned) {
    // Save To DB Here
    
    String stg = this.stage.getSelectionModel().getSelectedItem();
    String mod = this.model.getSelectionModel().getSelectedItem();
    String washn = this.name.getText().replace(" ", "_");
    String pathu1 = NewDir.file_dir;
    String pathu2 = pathu1 + "\\" + stg + "\\" + mod + "\\" + washn + ".ks";
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String timeString = sdf.format(d);
    String value0 = timeString;
    String value1 = dateString;
    try {
      String sql = "insert into Creation (Date,Stage,Model,Name,Path,Type,Revised_Date) values (?,?,?,?,?,?,?)";
      this.pst = this.conn.prepareStatement(sql);
      this.pst.setString(1, value0);
      this.pst.setString(2, stg);
      this.pst.setString(3, mod);
      this.pst.setString(4, washn);
      this.pst.setString(5, pathu2);
      this.pst.setString(6, "Pending");
      this.pst.setString(7, "Not_Revised");
      this.pst.execute();
    } catch (Exception e) {
      
    } finally {
      try {
        this.rs.close();
        this.pst.close();
      } catch (Exception exception) {}
    }
    
}

else {}
    //////////////////////////////////////////////////////////////////
        
            
            
        }
        
       else if (stageeo.equals("DEVELOPMENT")) {
            
               
Alert alertd = new Alert(Alert.AlertType.CONFIRMATION);
alertd.setTitle("Save To DB");
alertd.setHeaderText("Processes Result");
alertd.setContentText("What do you want to do?");
ButtonType buttonTypeOned = new ButtonType("Save To DB");
ButtonType buttonTypeCanceld = new ButtonType("Cancel");
alertd.getButtonTypes().setAll(buttonTypeOned, buttonTypeCanceld);
DialogPane dialogPaneid = alertd.getDialogPane();
dialogPaneid.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> resultsd = alertd.showAndWait();
if (resultsd.isPresent() && resultsd.get() == buttonTypeOned) {
    // Save To DB Here
    
    String stg = this.stage.getSelectionModel().getSelectedItem();
    String mod = this.model.getSelectionModel().getSelectedItem();
    String washn = this.name.getText().replace(" ", "_");
    String pathu1 = NewDir.file_dir;
    String pathu2 = pathu1 + "\\" + stg + "\\" + mod + "\\" + washn + ".ks";
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String timeString = sdf.format(d);
    String value0 = timeString;
    String value1 = dateString;
    try {
      String sql = "insert into Development (Date,Stage,Model,Name,Path,Type,Revised_Date) values (?,?,?,?,?,?,?)";
      this.pst = this.conn.prepareStatement(sql);
      this.pst.setString(1, value0);
      this.pst.setString(2, stg);
      this.pst.setString(3, mod);
      this.pst.setString(4, washn);
      this.pst.setString(5, pathu2);
      this.pst.setString(6, "Pending");
      this.pst.setString(7, "Not_Revised");
      this.pst.execute();
    } catch (Exception e) {
      
    } finally {
      try {
        this.rs.close();
        this.pst.close();
      } catch (Exception exception) {}
    }
    
}

else {}
    //////////////////////////////////////////////////////////////////
        
            
            
        }
        
        else {
            
            
            
            
            
        }
        
        
        
        
        
        
    }

    
    
    
    
    @FXML
    void stageaction(Event event) {

        
    stage.getItems().clear();
    try {
      BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Stages.kady"));
      String line;
      while ((line = buf.readLine()) != null) {
    stage.getItems().addAll(new String[] { line });
      } 
      buf.close();
    } catch (FileNotFoundException fileNotFoundException) {
    
    } catch (IOException iOException) {}
        
        
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    conn = db.java_db();
    
    Date currentDate = GregorianCalendar.getInstance().getTime();
    DateFormat df = DateFormat.getDateInstance();
    String dateString = df.format(currentDate);
    Date d = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    String timeString = sdf.format(d);
    String value1 = dateString;
    date.setText(timeString);
        
        
    }    
    
}
