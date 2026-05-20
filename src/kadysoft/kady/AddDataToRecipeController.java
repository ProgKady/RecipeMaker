/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
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
import java.net.URI;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class AddDataToRecipeController implements Initializable {

    
    @FXML
    private WebView webview;

    @FXML
    private JFXButton push;

    @FXML
    private JFXButton pull;
    
    public static String roroname;

    @FXML
    void pullaction(ActionEvent event) {

        
           
        String code = (String)this.webview.getEngine().executeScript("document.documentElement.outerHTML");
        System.out.println(code);
        
        
    }
    
    
    
    ////////////////////////////////////////////////////////////////////////////////////////////////////////   
        public static String getValueByKey(String filePath, String key) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (!line.contains("=")) {
                    continue;
                }
                String[] parts = line.split("=", 2);
                String currentKey = parts[0].trim();
                if (currentKey.equals(key)) {
                    return parts[1].trim();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null; 
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////// 
    
    
    
    @FXML
void pushaction(ActionEvent event) throws FileNotFoundException, IOException, Exception {

    FileChooser fcho = new FileChooser();
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", "*.ks"));
    fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Html Files", "*.html"));
    fcho.setTitle("Kady Choose");
    File f = fcho.showOpenDialog(null);

    if (f == null) return;
    
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
    String result = KeyDecoder.extractData(longKey.trim());
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
    String nameofit=f.getName();
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
 
    FileDecryptor.decrypt(input, tempOutput, result);
    File temp = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////

    roroname = f.getName().replaceAll(".ks", "");
    String pathy = f.getAbsolutePath();

    InputStream inputinstream = new FileInputStream(tempOutput);
    BufferedReader buf = new BufferedReader(new InputStreamReader(inputinstream, "UTF-8"));

    OutputStream instreamm = new FileOutputStream(getValueByKey("lib\\setto.cfg", "Secondry_Editor"));
    PrintWriter pw = new PrintWriter(new OutputStreamWriter(instreamm, "UTF-8"));

    pw.append("<!DOCTYPE html>\n" +
              "<html lang=\"ar\">\n" +
              "<head>\n" +
              "  <meta charset=\"utf-8\">\n" +
              "  <meta name=\"viewport\" content=\"width=device-width, height=device-height, initial-scale=1.0, maximum-scale=1.0\" />\n" +
              "  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.4.0/css/font-awesome.min.css\">\n" +
              "  <link rel=\"stylesheet\" href=\"../../css/froala_editor.css\">\n" +
              "  <link rel=\"stylesheet\" href=\"../../css/froala_style.css\">\n" +
              "  <link rel=\"stylesheet\" href=\"../../css/plugins/code_view.css\"> <!-- ضروري لـ Code View -->\n" +
              "  <link rel=\"stylesheet\" href=\"../../css/plugins/draggable.css\">\n" +
              "  <link rel=\"stylesheet\" href=\"../../css/plugins/colors.css\">\n" +
              "  <link rel=\"stylesheet\" href=\"../../css/plugins/emoticons.css\">\n" +
              "  <link rel=\"stylesheet\" href=\"../../css/plugins/image_manager.css\">\n" +
              "  <link rel=\"stylesheet\" href=\"../../css/plugins/image.css\">\n" +
              "  <link rel=\"stylesheet\" href=\"../../css/plugins/line_breaker.css\">\n" +
              "  <link rel=\"stylesheet\" href=\"../../css/plugins/table.css\">\n" +
              "  <link rel=\"stylesheet\" href=\"../../css/plugins/char_counter.css\">\n" +
              "  <link rel=\"stylesheet\" href=\"../../css/plugins/video.css\">\n" +
              "  <link rel=\"stylesheet\" href=\"../../css/plugins/fullscreen.css\">\n" +
              "  <link rel=\"stylesheet\" href=\"../../css/plugins/file.css\">\n" +
              "  <link rel=\"stylesheet\" href=\"../../css/plugins/quick_insert.css\">\n" +
              "  <link rel=\"stylesheet\" href=\"../../css/plugins/help.css\">\n" +
              "  <link rel=\"stylesheet\" href=\"../../css/third_party/spell_checker.css\">\n" +
              "  <link rel=\"stylesheet\" href=\"../../css/plugins/special_characters.css\">\n" +
              "  <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.css\">\n" +
              "\n" +
              "  <style>\n" +
              "    body { text-align: center; }\n" +
              "    div#editor { width: 90%; max-width: 1200px; margin: auto; text-align: left; }\n" +  // وسّعت الـ editor شوية
              "    .ss { background-color: red; }\n" +
              "    /* تحسين عرض الكود في Code View */\n" +
              "    .fr-code-view pre { font-size: 16px !important; line-height: 1.6 !important; }\n" +
              "    .fr-code-view .CodeMirror { height: 600px !important; } /* ارتفاع كبير للكود */\n" +
              "  </style>\n" +
              "</head>\n" +
              "<body>\n" +
              "  <div id=\"editor\">\n" +
              "    <div id='edit' style=\"margin-top: 30px;\">\n");

    String line;
    while ((line = buf.readLine()) != null) {
        pw.append(line.replace("ﬦ","A")
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
                       .replace("&NBSP;","") + "\n");
    }

    pw.append("    </div>\n" +
              "  </div>\n" +
              "\n" +
              "  <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/codemirror.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/codemirror/5.3.0/mode/xml/xml.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"https://cdnjs.cloudflare.com/ajax/libs/dompurify/2.2.7/purify.min.js\"></script>\n" +
              "\n" +
              "  <script type=\"text/javascript\" src=\"../../js/froala_editor.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/align.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/char_counter.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/code_beautifier.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/code_view.min.js\"></script> <!-- ضروري لـ Code View -->\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/colors.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/draggable.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/emoticons.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/entities.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/file.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/font_size.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/font_family.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/fullscreen.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/image.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/image_manager.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/line_breaker.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/inline_style.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/link.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/lists.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/paragraph_format.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/paragraph_style.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/quick_insert.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/quote.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/table.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/url.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/video.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/help.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/third_party/spell_checker.min.js\"></script>\n" +
              "  <script type=\"text/javascript\" src=\"../../js/plugins/special_characters.min.js\"></script>\n" +
              "\n" +
              "  <script>\n" +
              "    (function () {\n" +
              "      new FroalaEditor(\"#edit\", {\n" +
              "        // تفعيل Code View مع إعدادات محسنة\n" +
              "        codeMirror: true,\n" +
              "        codeMirrorOptions: {\n" +
              "          indentWithTabs: true,\n" +
              "          lineNumbers: true,\n" +
              "          lineWrapping: true,\n" +
              "          mode: 'text/html',\n" +
              "          tabSize: 2\n" +
              "        },\n" +
              "        // أزرار تبقى فعالة حتى في Code View\n" +
              "        codeViewKeepActiveButtons: ['bold', 'italic', 'underline'],\n" +
              "        // ارتفاع أكبر للـ Code View (بدل الافتراضي الصغير)\n" +
              "        heightMin: 500,\n" +
              "        heightMax: 800\n" +
              "      });\n" +
              "    })();\n" +
              "  </script>\n" +
              "</body>\n" +
              "</html>");

    pw.close();
    buf.close();
    
    ////////////////////////////////////////////////////////////////
    if (temp.exists()) {
        temp.delete();
    }
    ////////////////////////////////////////////////////////////////
    
    Desktop ffsd=Desktop.getDesktop();
    ffsd.open(new File (getValueByKey("lib\\setto.cfg", "Secondry_Editor")));

    URI uri = Paths.get(getValueByKey("lib\\setto.cfg", "Secondry_Editor")).toAbsolutePath().toUri();
    webview.getEngine().load(uri.toString());
}
    
    
    
    
    
    

    
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
