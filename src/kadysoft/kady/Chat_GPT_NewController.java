
package kadysoft.kady;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.web.WebView;

/**
 * FXML Controller class
 *
 * @author ahmed.elkady
 */
public class Chat_GPT_NewController implements Initializable {

    
    @FXML
    private WebView webview;
    
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        webview.getEngine().load("https://gemini.google.com/app");

    }    
    
}
