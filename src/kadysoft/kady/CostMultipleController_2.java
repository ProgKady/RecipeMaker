//package kadysoft.kady;
//
//
//
//import com.jfoenix.controls.JFXButton;
//import com.jfoenix.controls.JFXListView;
//import com.jfoenix.controls.JFXTextArea;
//import com.jfoenix.controls.JFXTextField;
//import java.awt.Desktop;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//import java.io.OutputStream;
//import java.io.OutputStreamWriter;
//import java.io.PrintWriter;
//import java.math.BigDecimal;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.GregorianCalendar;
//import java.util.List;
//import java.util.Optional;
//import java.util.ResourceBundle;
//import java.util.Timer;
//import java.util.TimerTask;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.stream.Collectors;
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.geometry.Pos;
//import javafx.scene.Node;
//import javafx.scene.control.Alert;
//import javafx.scene.control.ButtonType;
//import javafx.scene.control.DialogPane;
//import javafx.scene.input.DragEvent;
//import javafx.scene.input.TransferMode;
//import javafx.scene.text.Text;
//import javafx.util.Duration;
//import org.controlsfx.control.Notifications;
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
///**
// * FXML Controller class
// *
// * @author ahmed.elkady
// */
//public class CostMultipleController_2 implements Initializable {
//
//    
//    
//    @FXML
//    private JFXTextArea list,rora;
//
//    @FXML
//    private Text text;
//    
//    
//  @FXML
//  private JFXButton fix;
//  
//  public static String pecoco;
//
//  
//    
//    @FXML
//    void fixaction(ActionEvent event) throws FileNotFoundException, IOException{
//
// 
//      String[] filess=list.getText().split("\n");
//      for (String namo :filess) {
//            
//      String[] pathParts = namo.split("\\\\");   
//      String recipenami=pathParts[5].replaceAll(".ks", "").replaceAll(".html", "");
//      String dirpathe = namo;
//      String modelooo=pathParts[4];
//                     
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
////////////////////////////////////////////////////////////////////////////////////////////////////////////
//InputStream inputinstream=new FileInputStream(dirpathe);
//BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
//String lo;
//rora.clear();
//while ((lo=bi.readLine())!=null) {        
//rora.appendText("\n"+lo
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
//String gf=rora.getText();
//OutputStream instreamm=new FileOutputStream(System.getProperty("user.home")+"\\r.ks");
//PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
//pwe.println(gf);
//pwe.close();
//
//
/////////////////////////////////////////////////////////////////////////////////////////////////////////////   
//////////////////////////////////////////////////////////////////////////////////////////////
//            // Parse the HTML file
//            Document docv = Jsoup.parse(System.getProperty("user.home")+"\\r.ks", "UTF-8");
//            // Find all table rows
//            Elements rows = docv.select("tr");
//            boolean pcsFound = false;
//            for (Element row : rows) {
//                Elements cells = row.select("td");
//                for (int i = 0; i < cells.size(); i++) {
//                    if ("PCS".equalsIgnoreCase(cells.get(i).text().trim())) {
//                        if (i + 1 < cells.size()) {
//                            String nextValue = cells.get(i + 1).text().trim();
//                            System.out.println("Next value after PCS: " + nextValue);
//                            pecoco=nextValue;
//                        } else {
//                            System.out.println("PCS found but no next cell.");
//                            pecoco="120";
//                        }
//                        pcsFound = true;
//                        break;
//                    }
//                    
//                    else if (cells.get(i).text().trim().contains("PCS")) {
//                        if (i + 1 < cells.size()) {
//                            String nextValue = cells.get(i + 1).text().trim();
//                            System.out.println("Next value after PCS: " + nextValue);
//                            pecoco=nextValue;
//                        } else {
//                            System.out.println("PCS found but no next cell.");
//                            pecoco="120";
//                        }
//                        pcsFound = true;
//                        break;
//                    }
//                    
//                }
//
//                if (pcsFound) break;
//            }
//
//            if (!pcsFound) {
//                System.out.println("PCS not found");
//                pecoco="";
//            }
///////////////////////////////////////////////////////////////////////////////////////////////
//
//}   
//             
//        
//        
//        list.clear();
//        text.setVisible(true);
//            
//        
//    }
//    
//    
//
//    @FXML
//    void dragdropaction(DragEvent event) {
//
//        text.setVisible(false);
//        list.clear();
//        list.appendText(event.getDragboard().getFiles().stream().map(File::getAbsolutePath).collect(Collectors.joining("\n")));
//        event.setDropCompleted(true);
//        
//    }
//
//    @FXML
//    void dragoveraction(DragEvent event) {
//
//        if (event.getDragboard().hasFiles()) {
//            event.acceptTransferModes(TransferMode.LINK);
//        }
//        
//    }
//    
//    
//    
//    @Override
//    public void initialize(URL url, ResourceBundle rb) {
//        
//      
//    }    
//    
//}




package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.awt.Desktop;
import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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
public class CostMultipleController_2 implements Initializable {

    @FXML
    private JFXTextArea list, rora;
    @FXML
    private Text text;

    @FXML
    private JFXButton fix;

    private List<RecipePCS> reportData = new ArrayList<>();
    
    String productionPath;
    String pilotPath;

    @FXML
    void fixaction(ActionEvent event) {
        String[] inputs = list.getText().trim().split("\n");
        reportData.clear();

        System.out.println("========================================");
        System.out.println("          بدء معالجة الملفات");
        System.out.println("========================================");

        for (String relativePath : inputs) {
            relativePath = relativePath.trim();
            if (relativePath.isEmpty()) continue;

            // تنظيف المسار النسبي
            String cleanPath = relativePath.replace("/", "\\"); // تحويل أي / إلى \
            
            // اسم الوصفة بدون امتداد
            String recipeName = new File(cleanPath).getName()
                    .replaceAll("\\.ks$", "").replaceAll("\\.html$", "");

            // بناء المسار الكامل في PRODUCTION
            
            if (cleanPath.contains("PRODUCTION")||cleanPath.contains("PILOT")) {
                
                productionPath=cleanPath;
                pilotPath=cleanPath;
            }
            
            else {
                
            productionPath = "X:\\Recipe_System\\Recipes\\PRODUCTION\\" + cleanPath;
            pilotPath = "X:\\Recipe_System\\Recipes\\PILOT\\" + cleanPath;
                
                
            }
            
            

            String finalPath = productionPath;
            File file = new File(productionPath);
            String location = "PRODUCTION";

            if (!file.exists()) {
                file = new File(pilotPath);
                finalPath = pilotPath;
                location = "PILOT";

                if (!file.exists()) {
                    System.out.println("الملف غير موجود في الاثنين: " + cleanPath);
                    reportData.add(new RecipePCS(recipeName, "غير موجود", "غير موجود"));
                    continue;
                }
            }

            System.out.println("جاري معالجة: " + cleanPath + " (" + location + ")");

            try {
                processAndDecryptFile(finalPath, recipeName);
                String pcsValue = extractPCS(recipeName);

                reportData.add(new RecipePCS(recipeName, pcsValue, location));
                System.out.println("→ " + recipeName + " | PCS: " + pcsValue);

            } catch (Exception e) {
                System.err.println("خطأ أثناء معالجة: " + recipeName);
                reportData.add(new RecipePCS(recipeName, "خطأ في القراءة", location));
                e.printStackTrace();
            }
        }

        // إنشاء وفتح تقرير HTML
        createHTMLReport();

        System.out.println("========================================");
        System.out.println("          انتهت عملية المعالجة");
        System.out.println("========================================");

        list.clear();
        text.setVisible(true);
    }

    // فك التشفير وحفظ الملف المؤقت
    private void processAndDecryptFile(String filePath, String recipeName) throws IOException, Exception {
        rora.clear();

        
        
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
    if (filePath == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        return;
    }
    String input = filePath;
    String nameofit=recipeName;
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
 
    FileDecryptor.decrypt(input, tempOutput, result);
    File temp = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////
        
        
        try (BufferedReader bi = new BufferedReader(new InputStreamReader(new FileInputStream(temp), "UTF-8"))) {
            String line;
            while ((line = bi.readLine()) != null) {
                String decrypted = line
                        .replace("ﬦ", "A").replace("ﬧ", "B").replace("ﬨ", "C").replace("﬩", "D")
                        .replace("שׁ", "E").replace("שׂ", "F").replace("שּׁ", "G").replace("שּׂ", "H")
                        .replace("אַ", "I").replace("אָ", "J").replace("אּ", "K").replace("בּ", "L")
                        .replace("גּ", "M").replace("דּ", "N").replace("הּ", "O").replace("וּ", "P")
                        .replace("זּ", "Q").replace("טּ", "R").replace("יּ", "S").replace("ךּ", "T")
                        .replace("כּ", "U").replace("לּ", "V").replace("מּ", "W").replace("נּ", "X")
                        .replace("סּ", "Y").replace("ףּ", "Z")
                        .replace("פּ", "0").replace("צּ", "1").replace("קּ", "2").replace("רּ", "3")
                        .replace("שּ", "4").replace("תּ", "5").replace("וֹ", "6").replace("בֿ", "7")
                        .replace("כֿ", "8").replace("פֿ", "9")
                        .replace("&NBSP;", "").replace("&nbsp;", "");

                rora.appendText(decrypted + "\n");
            }
        }

        // حفظ الملف المفكك
        String tempFile = System.getProperty("user.home") + "\\r.ks";
        try (PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(tempFile), "UTF-8"))) {
            pw.print(rora.getText());
        }
        
        
        	
	
    ////////////////////////////////////////////////////////////////
    if (temp.exists()) {
        temp.delete();
    }
    ////////////////////////////////////////////////////////////////
        
        
    }

    // استخراج رقم PCS
    private String extractPCS(String recipeName) {
        try {
            File tempFile = new File(System.getProperty("user.home") + "\\r.ks");
            Document doc = Jsoup.parse(tempFile, "UTF-8");

            for (Element row : doc.select("tr")) {
                Elements cells = row.select("td");
                for (int i = 0; i < cells.size(); i++) {
                    String cellText = cells.get(i).text().trim();
                    if (cellText.equalsIgnoreCase("PCS") || cellText.contains("PCS")) {
                        if (i + 1 < cells.size()) {
                            String value = cells.get(i + 1).text().trim();
                            return value.isEmpty() ? "غير موجود" : value;
                        }
                    }
                }
            }
            return "غير موجود";

        } catch (Exception e) {
            e.printStackTrace();
            return "خطأ في القراءة";
        }
    }

    // إنشاء تقرير HTML جميل
    private void createHTMLReport() {
        String reportPath = System.getProperty("user.home") + "\\Desktop\\PCS_Report.html";

        StringBuilder html = new StringBuilder();
        html.append("<!DOCTYPE html>\n<html lang='ar' dir='rtl'>\n<head>\n");
        html.append("<meta charset='UTF-8'>\n");
        html.append("<title>تقرير أرقام الـ PCS</title>\n");
        html.append("<style>\n");
        html.append("    body { font-family: 'Segoe UI', Arial, sans-serif; margin: 40px; background: #f4f6f9; }\n");
        html.append("    h1 { text-align: center; color: #2c3e50; }\n");
        html.append("    table { width: 100%; border-collapse: collapse; background: white; box-shadow: 0 2px 10px rgba(0,0,0,0.1); }\n");
        html.append("    th, td { padding: 14px; text-align: center; border: 1px solid #ddd; }\n");
        html.append("    th { background-color: #2980b9; color: white; }\n");
        html.append("    tr:nth-child(even) { background-color: #f8f9fa; }\n");
        html.append("    .not-found { color: #e74c3c; font-weight: bold; }\n");
        html.append("</style>\n</head>\n<body>\n");
        html.append("<h1>تقرير أرقام الـ PCS</h1>\n");
        html.append("<table>\n<tr><th>اسم الوصفة</th><th>رقم الـ PCS</th><th>الموقع</th></tr>\n");

        for (RecipePCS item : reportData) {
            String cssClass = (item.pcs.contains("غير موجود") || item.pcs.contains("خطأ")) ? "not-found" : "";
            html.append("<tr>")
                .append("<td>").append(item.recipeName).append("</td>")
                .append("<td class='").append(cssClass).append("'>").append(item.pcs).append("</td>")
                .append("<td>").append(item.location).append("</td>")
                .append("</tr>\n");
        }

        html.append("</table>\n");
        html.append("<p style='text-align:center; margin-top:30px; color:#7f8c8d;'>");
        html.append("تم إنشاء التقرير بتاريخ: ").append(java.time.LocalDateTime.now());
        html.append("</p>\n</body>\n</html>");

        try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(reportPath), "UTF-8"))) {
            writer.write(html.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }

        // فتح التقرير تلقائياً
        try {
            Desktop.getDesktop().browse(new File(reportPath).toURI());
            System.out.println("✅ تم حفظ وفتح التقرير بنجاح على سطح المكتب");
        } catch (Exception e) {
            System.out.println("تم حفظ التقرير: " + reportPath);
        }
    }

    // كلاس داخلي لحفظ البيانات
    private static class RecipePCS {
        String recipeName, pcs, location;

        RecipePCS(String recipeName, String pcs, String location) {
            this.recipeName = recipeName;
            this.pcs = pcs;
            this.location = location;
        }
    }

    // Drag & Drop Functions
    @FXML
    void dragdropaction(DragEvent event) {
        text.setVisible(false);
        list.clear();
        list.appendText(event.getDragboard().getFiles().stream()
                .map(File::getAbsolutePath)
                .collect(java.util.stream.Collectors.joining("\n")));
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
    }
}