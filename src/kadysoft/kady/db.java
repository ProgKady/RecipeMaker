package kadysoft.kady;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.DriverManager;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javax.swing.JOptionPane;




public class db {
    
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
    
   Connection conn = null;
   public static Connection java_db() {
      try {
          
           
         String dbvalue = getValueByKey("lib\\setto.cfg", "DataBase");
          
         Class.forName("org.sqlite.JDBC");
         Connection conn = DriverManager.getConnection("jdbc:sqlite:"+dbvalue);
         return conn;
      } catch (Exception var1) {
         //JOptionPane.showMessageDialog((Component)null, var1);
         
        Alert alo = new Alert(Alert.AlertType.INFORMATION);
        alo.setTitle(var1.toString());
        alo.setResizable(false);
        alo.setHeaderText(var1.toString());
        alo.setContentText("Sorry we face a problem :\n"+"\""+var1.toString()+"\""+"\n\nPowered By Kadysoft Ltd - Ahmed Elkady.");
        //DialogPane dialogPane = alo.getDialogPane();
        //dialogPane.getStylesheets().add(
      //getClass().getResource("primer-dark.css").toExternalForm());
        alo.showAndWait();
         
         
         return null;
      }
   }
}
