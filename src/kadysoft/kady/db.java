package kadysoft.kady;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import javafx.scene.control.Alert;
import javafx.scene.control.DialogPane;
import javax.swing.JOptionPane;

public class db {
   Connection conn = null;

   public static Connection java_db() {
      try {
         Class.forName("org.sqlite.JDBC");
         Connection conn = DriverManager.getConnection("jdbc:sqlite:X:\\Recipe_System\\Database\\Recipe_System_DB.db");
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
