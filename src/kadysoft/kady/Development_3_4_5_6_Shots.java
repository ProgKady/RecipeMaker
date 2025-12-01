package kadysoft.kady;


import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXToggleButton;
import com.spire.doc.Document;
import com.spire.doc.Section;
import com.spire.doc.Table;
import com.spire.doc.TableCell;
import com.spire.doc.documents.HorizontalAlignment;
import com.spire.doc.documents.PageOrientation;
import com.spire.doc.documents.VerticalAlignment;
import com.spire.doc.fields.TextRange;
import com.spire.pdf.PdfDocument;
import com.spire.xls.CellRange;
import com.spire.xls.ExcelVersion;
import com.spire.xls.FileFormat;
import com.spire.xls.ViewMode;
import com.spire.xls.Workbook;
import com.spire.xls.Worksheet;
import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import static java.awt.image.BufferedImage.TYPE_INT_ARGB;
import java.io.BufferedReader;
import java.io.BufferedWriter;
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
import java.math.BigDecimal;
import java.net.URI;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.application.Platform;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.web.WebView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import static kadysoft.kady.SaverController.filenammm;
import static kadysoft.kady.SaverController.modeloo;
import net.sf.jasperreports.engine.JasperPrint;

import org.controlsfx.control.Notifications;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


/**
 *
 * @author ahmed.elkady
 */
public class Development_3_4_5_6_Shots {
    
    StringBuilder lili;
    
    
  Connection conn = null;
  
  ResultSet rs = null;
  
  PreparedStatement pst = null;
      
  int i = 1;
  
  public static String find,fann;
  
  public static String windowsversion,MachineID;
  
  
  
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
    
    
    public void dev_3_4_5_6_Shots () throws IOException {
        

        
        
conn = db.java_db();        
        
lili = new StringBuilder();        
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////   
FileChooser fcho = new FileChooser();
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("Kadysoft Files", new String[] { "*.ks" }));
fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("HTML Files", new String[] { "*.html" }));
fcho.setTitle("Kady Choose");
File f = fcho.showOpenDialog((Window)null);
String recipenami=f.getName().replace(".ks","").replace(".html","");
String recipepathy = f.getAbsolutePath().toString();

String didd1=NewDir.file_dir+"\\DEVELOPMENT\\";
String didd2="\\"+f.getName();

String modelooo=recipepathy.replace(didd1,"").replace(didd2,"");
//////////////////////////////////////////////////////////////////////////////////////////////////////////
InputStream inputinstream=new FileInputStream(recipepathy);
BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
String lo;


while ((lo=bi.readLine())!=null) {
    
    
lili.append("\n"+lo
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
String gf=lili.toString();
OutputStream instreamm=new FileOutputStream(System.getProperty("user.home")+"\\r.ks");
PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
pwe.println(gf);
pwe.close();




   //Get Time And Shots
   
   List<Integer> time = new ArrayList<>();
   List<Integer> timeSum = new ArrayList<>();
   List<String> shots = new ArrayList<>();
   int sum = 0, bathnum=0, firstshot=0, secondshot=0,thirdshot=0,forthshot=0,fifshot=0,sixshot=0;
   File inputFile = new File(System.getProperty("user.home")+"\\r.ks"); //
   org.jsoup.nodes.Document doc = Jsoup.parse(inputFile, "UTF-8"); //
   for (Element table : doc.select("tbody")) {
   for (Element row : table.select("tr")) {
   Elements tds = row.select("td");
   if (tds.get(2).text().contains(":")||tds.get(2).text().contains("-")||tds.get(2).text().contains("_")||    tds.get(2).text().contains("'")||tds.get(2).text().contains(".")||tds.get(2).text().equals("E")||tds.get(2).text().equals("e")||tds.get(2).text().isEmpty()||tds.get(2).text().contains("/")||tds.get(2).text().contains("\\")||tds.get(2).text().contains("\\\\")||tds.get(2).text().contains("SPIN")||tds.get(2).text().contains("spin")||tds.get(2).text().contains("TIME")||tds.get(2).text().contains("time")||tds.get(2).text().matches("[a-zA-Z_ _&_.]+")||tds.get(2).text().matches("^(?=.*[a-zA-Z])(?=.*\\d).*$")||tds.get(2).text().contains("PRODUCTION")||tds.get(2).text().contains("RECIPE")||tds.get(2).text().contains("RECIPI")||tds.get(2).text().contains("DATE")||tds.get(2).text().contains("WASH")) {}
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
        
// Calculate times for all detected shots
if (bathnum >= 1) {
    firstshot = timeSum.get(0);
    System.out.println(firstshot);
}
if (bathnum >= 2) {
    secondshot = timeSum.get(1) - timeSum.get(0);
    System.out.println(secondshot);
}
if (bathnum >= 3) {
    thirdshot = timeSum.get(2) - timeSum.get(1);
    System.out.println(thirdshot);
}
if (bathnum >= 4) {
    forthshot = timeSum.get(3) - timeSum.get(2);
    System.out.println(forthshot);
}
if (bathnum >= 5) {
    fifshot = timeSum.get(4) - timeSum.get(3);
    System.out.println(fifshot);
}
if (bathnum >= 6) {
    sixshot = timeSum.get(5) - timeSum.get(4);
    System.out.println(sixshot);
}

// Output results
//System.out.println("Number of shots: " + bathnum);
//System.out.println("First shot time: " + firstshot);
//System.out.println("Second shot time: " + secondshot);
//System.out.println("Third shot time: " + thirdshot);
//System.out.println("Fourth shot time: " + forthshot);  
                          

                          
   
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Get Temp
   int temp1 = 0, temp2 = 0, temp3 = 0, temp4 = 0,temp5 = 0,temp6 = 0; 
          try {
            
            // Reading timer temperature from file
            BufferedReader buf = new BufferedReader(new FileReader(System.getProperty("user.home") + "\\Timer_Temp.kady"));
            String timer_temprature = buf.readLine();
            buf.close();
            int timer_temp = Integer.parseInt(timer_temprature);
            // Parsing the input file
            File inputFiler = new File(System.getProperty("user.home") + "\\r.ks");
            org.jsoup.nodes.Document docr = Jsoup.parse(inputFiler, "UTF-8");
            List<Integer> tempCountsPerShot = new ArrayList<>();
            List<String> shotsr = new ArrayList<>();
            int overallTempCount = 0;
            // Process rows to calculate temperatures for each shot
            int currentShotTempCount = 0;
            for (Element table : docr.select("table")) {
                for (Element row : table.select("tr")) {
                    Elements tds = row.select("td");
                    // Skip invalid rows
//                    if (tds.get(3).text().isEmpty() || 
//                        tds.get(3).text().contains("/") || 
//                        tds.get(3).text().contains("\\") || 
//                        tds.get(3).text().contains("TEMP") || 
//                        tds.get(3).text().contains("temp") || 
//                        tds.get(3).text().contains("OPERATOR") || 
//                        tds.get(3).text().contains("operator")) {
//                        continue;
//                    }
                    
                    if (tds.get(3).text().contains("'")||tds.get(3).text().contains("OF")||tds.get(3).text().contains("of")||tds.get(3).text().matches("[a-zA-Z_ _&_.]+")||tds.get(3).text().matches("^(?=.*[a-zA-Z])(?=.*\\d).*$")||tds.get(3).text().contains("/")||tds.get(3).text().contains("\\")||tds.get(3).text().isEmpty()||tds.get(3).text().contains("TEMP")||tds.get(3).text().contains("OPERATOR")||tds.get(3).text().contains("temp")||tds.get(3).text().contains("operator")) {continue;}
                            
                    
                    String tempo = tds.get(3).text().replaceAll("[a-zA-Z_ _&_.]+", "");
                    if (tempo.matches("\\d+")) {
                        int temperature = Integer.parseInt(tempo);
                        if (temperature > timer_temp) {
                            currentShotTempCount++;
                            overallTempCount++;
                        }
                    }
                    // Identify the start of a new shot
                    if (tds.get(3).text().contains("EXTRACT") || tds.get(3).text().contains("extract")) {
                        shots.add(tds.get(3).text()); // Save shot information
                        tempCountsPerShot.add(currentShotTempCount); // Save count for the previous shot
                        currentShotTempCount = 0; // Reset for the next shot
                    }
                }
            }
            // Handle the last shot
            if (currentShotTempCount > 0) {
                tempCountsPerShot.add(currentShotTempCount);
            }
            // Output results
            //System.out.println("Total shots (bathnum): " + shots.size());
            //for (int i = 0; i < tempCountsPerShot.size(); i++) {
            //System.out.println("Shot " + (i + 1) + " - Temperatures > " + timer_temp + ": " + tempCountsPerShot.get(i));
            //}
            
            // Initialize the temp variables before the loop


// Iterate through tempCountsPerShot to assign values to temp, temp2, temp3, temp4
for (int i = 0; i < tempCountsPerShot.size(); i++) {
    // Get the count for the current shot
    int tempCount = tempCountsPerShot.get(i);
    
    // Assign values to temp, temp2, temp3, temp4 based on the index
    if (i == 0) {
        temp1 = tempCount; // First shot count goes to temp
    } else if (i == 1) {
        temp2 = tempCount; // Second shot count goes to temp2
    } else if (i == 2) {
        temp3 = tempCount; // Third shot count goes to temp3
    } else if (i == 3){
        temp4 = tempCount; // Any further shots, assign to temp4
    }
    else if (i == 4){
        temp5 = tempCount; // Any further shots, assign to temp4
    }
    else {
        temp6 = tempCount; // Any further shots, assign to temp4
    }
    
}

// Print the values of temp, temp2, temp3, temp4 after the loop finishes
//System.out.println("temp: " + temp);
//System.out.println("temp2: " + temp2);
//System.out.println("temp3: " + temp3);
//System.out.println("temp4: " + temp4);

            
            //System.out.println("Overall temperatures > " + timer_temp + ": " + overallTempCount);
            } catch (FileNotFoundException e) {
            //System.out.println("File not found: " + e.getMessage());
            } catch (IOException e) {
            //System.out.println("Error reading file: " + e.getMessage());
            } catch (NumberFormatException e) {
            //System.out.println("Invalid temperature value: " + e.getMessage());
            }
                            
                            
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   //Get Stone Bath   
   
                            int stonebathh=0;
                            org.jsoup.nodes.Document doccc = Jsoup.parse(inputFile, "UTF-8"); // 
                            for (Element table : doccc.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(7).text().contains("'")||tds.get(7).text().isEmpty()||tds.get(7).text().contains("/")||tds.get(7).text().contains("\\")||tds.get(7).text().contains("CHEMICALS")||tds.get(7).text().contains("chemicals")||tds.get(7).text().matches("[0-9_-]+")||tds.get(7).text().contains("CHEMICAL")||tds.get(7).text().contains("chemical")) {}
                            else {
                            String erw=tds.get(7).text().toString();
                            if (erw.contains("STONE")||erw.contains("STON")||erw.contains("BOOL")||erw.contains("FOAM")||erw.contains("BOLL")||erw.contains("BOAL")||erw.contains("KUPCS"))  {
                            stonebathh+=1;  
                            }else {}}}}
   
                            
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
    //Get Water Bath  
    
    
               int waterbath1 = 0, waterbath2 = 0, waterbath3 = 0, waterbath4 = 0,waterbath5 = 0,waterbath6 = 0;                
         try {
            // Reading the input file
            File inputFiless = new File(System.getProperty("user.home") + "\\r.ks"); // Your file path
            org.jsoup.nodes.Document docss = Jsoup.parse(inputFiless, "UTF-8");

            // Lists to track the number of water baths for each shot (before EXTRACT)
            List<Integer> waterBathCountsPerShot = new ArrayList<>();
            List<String> shotsss = new ArrayList<>();
            int overallWaterBathCount = 0;
            int currentWaterBathCount = 0; // Track occurrences of valid water baths

            // Iterate through tables and rows in the document
            for (Element table : docss.select("table")) {
                for (Element row : table.select("tr")) {
                    Elements tds = row.select("td");

                    // Skip rows that don't have enough data
                    if (tds.size() < 5) continue;

                    // Skip rows with invalid data in the 5th column
                    String waterbathText = tds.get(4).text();
//                    if (waterbathText.contains("'") || waterbathText.contains("DRYER") || 
//                        waterbathText.contains("LITER") || waterbathText.matches("[a-zA-Z_]+")) {
//                        continue; // Skip invalid rows
//                    }

if (tds.get(4).text().contains("'")||tds.get(4).text().equals("1")||tds.get(4).text().contains("'")||tds.get(4).text().contains("DRYER")||tds.get(4).text().contains("LITER")||tds.get(4).text().matches("[a-zA-Z_]+")||tds.get(4).text().contains("LITERS")) {continue;}
                    // If EXTRACT is found in the 4th column, it marks the start of a new bath
                    String tempo = tds.get(3).text();
                    if (tempo.contains("EXTRACT") || tempo.contains("extract")) {
                        if (currentWaterBathCount > 0) {
                            waterBathCountsPerShot.add(currentWaterBathCount); // Store the count for the previous bath
                            overallWaterBathCount += currentWaterBathCount; // Add to the overall count
                        }
                        shots.add(tempo); // Save shot information (EXTRACT)
                        currentWaterBathCount = 0; // Reset for the next batch
                    }

                    // If the row contains a valid value in the 5th column, count it as a valid bath occurrence
                    if (waterbathText.matches("[0-9]+")) {
                        currentWaterBathCount++; // Increment for each valid bath found
                    }
                }
            }

            // Handle the last shot (if there's any remaining count)
            if (currentWaterBathCount > 0) {
                waterBathCountsPerShot.add(currentWaterBathCount);
                overallWaterBathCount += currentWaterBathCount;
            }

            // Output results
//            System.out.println("Total shots (bathnum): " + shots.size());
//            for (int i = 0; i < waterBathCountsPerShot.size(); i++) {
//                System.out.println("Shot " + (i + 1) + " - Water Bath Occurrences: " + waterBathCountsPerShot.get(i));
//            }
//            
            
          

// Iterate through tempCountsPerShot to assign values to temp, temp2, temp3, temp4
for (int i = 0; i < waterBathCountsPerShot.size(); i++) {
    // Get the count for the current shot
    int tempCount = waterBathCountsPerShot.get(i);
    
    // Assign values to temp, temp2, temp3, temp4 based on the index
    if (i == 0) {
        waterbath1 = tempCount; // First shot count goes to temp
    } else if (i == 1) {
        waterbath2 = tempCount; // Second shot count goes to temp2
    } else if (i == 2) {
        waterbath3 = tempCount; // Third shot count goes to temp3
    } else if (i == 3){
        waterbath4 = tempCount; // Any further shots, assign to temp4
    }
    else if (i == 4){
        waterbath5 = tempCount; // Any further shots, assign to temp4
    }
    else {
        waterbath6 = tempCount; // Any further shots, assign to temp4
    }
}

// Print the values of temp, temp2, temp3, temp4 after the loop finishes
//System.out.println("temp: " + waterbath1);
//System.out.println("temp2: " + waterbath2);
//System.out.println("temp3: " + waterbath3);
//System.out.println("temp4: " + waterbath4);
            
            
            //System.out.println("Overall water bath occurrences: " + overallWaterBathCount);

        } catch (FileNotFoundException e) {
            //System.out.println("File not found: " + e.getMessage());
        } catch (IOException e) {
            //System.out.println("Error reading file: " + e.getMessage());
        } catch (NumberFormatException e) {
            //System.out.println("Invalid water bath value: " + e.getMessage());
        }
        
                            
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
    double thirdshott=thirdshot;
    double forthshott=forthshot;
    double fifshott=fifshot;
    double sixshott=sixshot;
    
    int tempp1=temp1;
    int tempp2=temp2;
    int tempp3=temp3;
    int tempp4=temp4;
    int tempp5=temp5;
    int tempp6=temp6;
    
    
    int waterbathh1=waterbath1;
    int waterbathh2=waterbath2;
    int waterbathh3=waterbath3;
    int waterbathh4=waterbath4;
    int waterbathh5=waterbath5;
    int waterbathh6=waterbath6;
    
    
    int stonebathhh=stonebathh;
    
    loadremoveproduct1=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
    tempraturetime1=tempp1*Double.parseDouble(tempratureee);
    chemicaldosage1=Double.parseDouble(cdosagee);
    fillemptytank1=waterbathh1*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
    
    loadremoveproduct2=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
    tempraturetime2=tempp2*Double.parseDouble(tempratureee);
    chemicaldosage2=Double.parseDouble(cdosagee);
    fillemptytank2=waterbathh2*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
    
    loadremoveproduct3=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
    tempraturetime3=tempp3*Double.parseDouble(tempratureee);
    chemicaldosage3=Double.parseDouble(cdosagee);
    fillemptytank3=waterbathh3*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
    
    loadremoveproduct4=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
    tempraturetime4=tempp4*Double.parseDouble(tempratureee);
    chemicaldosage4=Double.parseDouble(cdosagee);
    fillemptytank4=waterbathh4*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
    
    loadremoveproduct5=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
    tempraturetime5=tempp5*Double.parseDouble(tempratureee);
    chemicaldosage5=Double.parseDouble(cdosagee);
    fillemptytank5=waterbathh5*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
    
    loadremoveproduct6=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
    tempraturetime6=tempp6*Double.parseDouble(tempratureee);
    chemicaldosage6=Double.parseDouble(cdosagee);
    fillemptytank6=waterbathh6*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
    
//    loadremoveproductall=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
//    tempraturetimeall=temppall*Double.parseDouble(tempratureee);
//    chemicaldosageall=Double.parseDouble(cdosagee);
//    fillemptytankall=waterbathallx*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
    
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
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
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
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
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
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
        
    }
    
     
     
    else if (bathnumm==3) {
        
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
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
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
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
      
      //fdffdgfddf
      
      ///////////yrtyrty///////////
      
      JFXTextField fsssi=new JFXTextField ("");
      fsssi.setPromptText("Write Stone Baths Number");
      fsssi.setMinSize(300, 30);
      fsssi.setLabelFloat(true);
      fsssi.setStyle("-fx-font-weight:bold;");
      fsssi.setEditable(true);
      Alert alertooi = new Alert(Alert.AlertType.INFORMATION);
      alertooi.setTitle("Stone Bath?");
      alertooi.setHeaderText("We found stone or foam "+stonebathhh+" times. for the third shot.");
      alertooi.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alertooi.setGraphic(fsssi);
      alertooi.setResizable(false);
      DialogPane dialogPaneooi = alertooi.getDialogPane();
      dialogPaneooi.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optionoioi = alertooi.showAndWait();
      passyy=fsssi.getText();
      stonabaththh=Double.parseDouble(passyy);
      if (optionoioi.get() == null) {} 
      else if (optionoioi.get() == ButtonType.OK) {
         
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabaththh==0) {
          loadstone3=0;
          removestone3=0;
          cleaningstone3=0;
          extraction3=0;
          double dos3=loadstone3+removestone3;
          loadremovestone3=dos3;
          
      }
      else if (stonabaththh==1){
          
          loadstone3=5.5;
          removestone3=4.15;
          cleaningstone3=15;
          extraction3=20;
          double dos3=loadstone3+removestone3;
          loadremovestone3=dos3;
          
      }
      
      
      else if (stonabaththh==2){
          
          
          loadstone3=16.5;
          removestone3=8.3;
          cleaningstone3=20;
          extraction3=20;
          double dos3=loadstone3+removestone3;
          loadremovestone3=dos3;
          
          
      }
      
      
      else {
          double v=stonabaththh;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone3=v2;
          removestone3=v1;
          cleaningstone3=0;
          extraction3=20;
          double dos3=loadstone3+removestone3;
          loadremovestone3=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
      
      else if (optionoioi.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
      
      
      
      
        
    }
    
     
    else if (bathnumm==4) {
        
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
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
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
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
      
      ///////////yrtyrty///////////
      
      JFXTextField fsssi=new JFXTextField ("");
      fsssi.setPromptText("Write Stone Baths Number");
      fsssi.setMinSize(300, 30);
      fsssi.setLabelFloat(true);
      fsssi.setStyle("-fx-font-weight:bold;");
      fsssi.setEditable(true);
      Alert alertooi = new Alert(Alert.AlertType.INFORMATION);
      alertooi.setTitle("Stone Bath?");
      alertooi.setHeaderText("We found stone or foam "+stonebathhh+" times. for the third shot.");
      alertooi.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alertooi.setGraphic(fsssi);
      alertooi.setResizable(false);
      DialogPane dialogPaneooi = alertooi.getDialogPane();
      dialogPaneooi.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optionoioi = alertooi.showAndWait();
      passyy=fsssi.getText();
      stonabaththh=Double.parseDouble(passyy);
      if (optionoioi.get() == null) {} 
      else if (optionoioi.get() == ButtonType.OK) {
         
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabaththh==0) {
          loadstone3=0;
          removestone3=0;
          cleaningstone3=0;
          extraction3=0;
          double dos3=loadstone3+removestone4;
          loadremovestone3=dos3;
          
      }
      else if (stonabaththh==1){
          
          loadstone3=5.5;
          removestone3=4.15;
          cleaningstone3=15;
          extraction3=20;
          double dos3=loadstone3+removestone3;
          loadremovestone3=dos3;
          
      }
      
      
      else if (stonabaththh==2){
          
          
          loadstone3=16.5;
          removestone3=8.3;
          cleaningstone3=20;
          extraction3=20;
          double dos3=loadstone3+removestone3;
          loadremovestone3=dos3;
          
          
      }
      
      
      else {
          double v=stonabaththh;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone3=v2;
          removestone3=v1;
          cleaningstone3=0;
          extraction3=20;
          double dos3=loadstone3+removestone3;
          loadremovestone3=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
      
      else if (optionoioi.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
      
      
      
      
      ///////////yrtyrty///////////
      
      JFXTextField fsssp=new JFXTextField ("");
      fsssp.setPromptText("Write Stone Baths Number");
      fsssp.setMinSize(300, 30);
      fsssp.setLabelFloat(true);
      fsssp.setStyle("-fx-font-weight:bold;");
      fsssp.setEditable(true);
      Alert alertoop = new Alert(Alert.AlertType.INFORMATION);
      alertoop.setTitle("Stone Bath?");
      alertoop.setHeaderText("We found stone or foam "+stonebathhh+" times. for the forth shot.");
      alertoop.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alertoop.setGraphic(fsssp);
      alertoop.setResizable(false);
      DialogPane dialogPaneoop = alertoop.getDialogPane();
      dialogPaneoop.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optionoiop = alertoop.showAndWait();
      passyy=fsssp.getText();
      stonabaththh=Double.parseDouble(passyy);
      if (optionoiop.get() == null) {} 
      else if (optionoiop.get() == ButtonType.OK) {
         
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabaththh==0) {
          loadstone4=0;
          removestone4=0;
          cleaningstone4=0;
          extraction4=0;
          double dos3=loadstone4+removestone4;
          loadremovestone4=dos3;
          
      }
      else if (stonabaththh==1){
          
          loadstone4=5.5;
          removestone4=4.15;
          cleaningstone4=15;
          extraction4=20;
          double dos3=loadstone4+removestone4;
          loadremovestone4=dos3;
          
      }
      
      
      else if (stonabaththh==2){
          
          
          loadstone4=16.5;
          removestone4=8.3;
          cleaningstone4=20;
          extraction4=20;
          double dos3=loadstone4+removestone4;
          loadremovestone4=dos3;
          
          
      }
      
      
      else {
          double v=stonabaththh;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone4=v2;
          removestone4=v1;
          cleaningstone4=0;
          extraction4=20;
          double dos3=loadstone4+removestone4;
          loadremovestone4=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
      
      else if (optionoiop.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
      
        
    }
    
    
   
           
           
           else if (bathnumm==5) {
        
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
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
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
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
      
      ///////////yrtyrty///////////
      
      JFXTextField fsssi=new JFXTextField ("");
      fsssi.setPromptText("Write Stone Baths Number");
      fsssi.setMinSize(300, 30);
      fsssi.setLabelFloat(true);
      fsssi.setStyle("-fx-font-weight:bold;");
      fsssi.setEditable(true);
      Alert alertooi = new Alert(Alert.AlertType.INFORMATION);
      alertooi.setTitle("Stone Bath?");
      alertooi.setHeaderText("We found stone or foam "+stonebathhh+" times. for the third shot.");
      alertooi.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alertooi.setGraphic(fsssi);
      alertooi.setResizable(false);
      DialogPane dialogPaneooi = alertooi.getDialogPane();
      dialogPaneooi.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optionoioi = alertooi.showAndWait();
      passyy=fsssi.getText();
      stonabaththh=Double.parseDouble(passyy);
      if (optionoioi.get() == null) {} 
      else if (optionoioi.get() == ButtonType.OK) {
         
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabaththh==0) {
          loadstone3=0;
          removestone3=0;
          cleaningstone3=0;
          extraction3=0;
          double dos3=loadstone3+removestone4;
          loadremovestone3=dos3;
          
      }
      else if (stonabaththh==1){
          
          loadstone3=5.5;
          removestone3=4.15;
          cleaningstone3=15;
          extraction3=20;
          double dos3=loadstone3+removestone3;
          loadremovestone3=dos3;
          
      }
      
      
      else if (stonabaththh==2){
          
          
          loadstone3=16.5;
          removestone3=8.3;
          cleaningstone3=20;
          extraction3=20;
          double dos3=loadstone3+removestone3;
          loadremovestone3=dos3;
          
          
      }
      
      
      else {
          double v=stonabaththh;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone3=v2;
          removestone3=v1;
          cleaningstone3=0;
          extraction3=20;
          double dos3=loadstone3+removestone3;
          loadremovestone3=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
      
      else if (optionoioi.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
      
      
      
      
      ///////////yrtyrty///////////
      
      JFXTextField fsssp=new JFXTextField ("");
      fsssp.setPromptText("Write Stone Baths Number");
      fsssp.setMinSize(300, 30);
      fsssp.setLabelFloat(true);
      fsssp.setStyle("-fx-font-weight:bold;");
      fsssp.setEditable(true);
      Alert alertoop = new Alert(Alert.AlertType.INFORMATION);
      alertoop.setTitle("Stone Bath?");
      alertoop.setHeaderText("We found stone or foam "+stonebathhh+" times. for the forth shot.");
      alertoop.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alertoop.setGraphic(fsssp);
      alertoop.setResizable(false);
      DialogPane dialogPaneoop = alertoop.getDialogPane();
      dialogPaneoop.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optionoiop = alertoop.showAndWait();
      passyy=fsssp.getText();
      stonabaththh=Double.parseDouble(passyy);
      if (optionoiop.get() == null) {} 
      else if (optionoiop.get() == ButtonType.OK) {
         
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabaththh==0) {
          loadstone4=0;
          removestone4=0;
          cleaningstone4=0;
          extraction4=0;
          double dos3=loadstone4+removestone4;
          loadremovestone4=dos3;
          
      }
      else if (stonabaththh==1){
          
          loadstone4=5.5;
          removestone4=4.15;
          cleaningstone4=15;
          extraction4=20;
          double dos3=loadstone4+removestone4;
          loadremovestone4=dos3;
          
      }
      
      
      else if (stonabaththh==2){
          
          
          loadstone4=16.5;
          removestone4=8.3;
          cleaningstone4=20;
          extraction4=20;
          double dos3=loadstone4+removestone4;
          loadremovestone4=dos3;
          
          
      }
      
      
      else {
          double v=stonabaththh;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone4=v2;
          removestone4=v1;
          cleaningstone4=0;
          extraction4=20;
          double dos3=loadstone4+removestone4;
          loadremovestone4=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
                   
                   else if (optionoioi.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
         
                   
                   
      JFXTextField fssspp=new JFXTextField ("");
      fssspp.setPromptText("Write Stone Baths Number");
      fssspp.setMinSize(300, 30);
      fssspp.setLabelFloat(true);
      fssspp.setStyle("-fx-font-weight:bold;");
      fssspp.setEditable(true);
      Alert alertoopp = new Alert(Alert.AlertType.INFORMATION);
      alertoopp.setTitle("Stone Bath?");
      alertoopp.setHeaderText("We found stone or foam "+stonebathhh+" times. for the fifth shot.");
      alertoopp.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alertoopp.setGraphic(fssspp);
      alertoopp.setResizable(false);
      DialogPane dialogPaneoopp = alertoopp.getDialogPane();
      dialogPaneoopp.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optionoiopp = alertoopp.showAndWait();
      passyy=fssspp.getText();
      stonabaththh=Double.parseDouble(passyy);
      if (optionoiopp.get() == null) {} 
      else if (optionoiopp.get() == ButtonType.OK) {
         
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabaththh==0) {
          loadstone5=0;
          removestone5=0;
          cleaningstone5=0;
          extraction5=0;
          double dos3=loadstone5+removestone5;
          loadremovestone5=dos3;
          
      }
      else if (stonabaththh==1){
          
          loadstone5=5.5;
          removestone5=4.15;
          cleaningstone5=15;
          extraction5=20;
          double dos3=loadstone5+removestone5;
          loadremovestone5=dos3;
          
      }
      
      
      else if (stonabaththh==2){
          
          
          loadstone5=16.5;
          removestone5=8.3;
          cleaningstone5=20;
          extraction5=20;
          double dos3=loadstone5+removestone5;
          loadremovestone5=dos3;
          
          
      }
      
      
      else {
          double v=stonabaththh;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone5=v2;
          removestone5=v1;
          cleaningstone5=0;
          extraction5=20;
          double dos3=loadstone5+removestone5;
          loadremovestone5=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
                   
      
      else if (optionoiop.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
      
        
    }
    
           
           
           
                   
                   
                   
                   else if (bathnumm==6) {
        
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
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
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
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
      
      ///////////yrtyrty///////////
      
      JFXTextField fsssi=new JFXTextField ("");
      fsssi.setPromptText("Write Stone Baths Number");
      fsssi.setMinSize(300, 30);
      fsssi.setLabelFloat(true);
      fsssi.setStyle("-fx-font-weight:bold;");
      fsssi.setEditable(true);
      Alert alertooi = new Alert(Alert.AlertType.INFORMATION);
      alertooi.setTitle("Stone Bath?");
      alertooi.setHeaderText("We found stone or foam "+stonebathhh+" times. for the third shot.");
      alertooi.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alertooi.setGraphic(fsssi);
      alertooi.setResizable(false);
      DialogPane dialogPaneooi = alertooi.getDialogPane();
      dialogPaneooi.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optionoioi = alertooi.showAndWait();
      passyy=fsssi.getText();
      stonabaththh=Double.parseDouble(passyy);
      if (optionoioi.get() == null) {} 
      else if (optionoioi.get() == ButtonType.OK) {
         
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabaththh==0) {
          loadstone3=0;
          removestone3=0;
          cleaningstone3=0;
          extraction3=0;
          double dos3=loadstone3+removestone3;
          loadremovestone3=dos3;
          
      }
      else if (stonabaththh==1){
          
          loadstone3=5.5;
          removestone3=4.15;
          cleaningstone3=15;
          extraction3=20;
          double dos3=loadstone3+removestone3;
          loadremovestone3=dos3;
          
      }
      
      
      else if (stonabaththh==2){
          
          
          loadstone3=16.5;
          removestone3=8.3;
          cleaningstone3=20;
          extraction3=20;
          double dos3=loadstone3+removestone3;
          loadremovestone3=dos3;
          
          
      }
      
      
      else {
          double v=stonabaththh;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone3=v2;
          removestone3=v1;
          cleaningstone3=0;
          extraction3=20;
          double dos3=loadstone3+removestone3;
          loadremovestone3=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
      
      else if (optionoioi.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
      
      
      
      
      ///////////yrtyrty///////////
      
      JFXTextField fsssp=new JFXTextField ("");
      fsssp.setPromptText("Write Stone Baths Number");
      fsssp.setMinSize(300, 30);
      fsssp.setLabelFloat(true);
      fsssp.setStyle("-fx-font-weight:bold;");
      fsssp.setEditable(true);
      Alert alertoop = new Alert(Alert.AlertType.INFORMATION);
      alertoop.setTitle("Stone Bath?");
      alertoop.setHeaderText("We found stone or foam "+stonebathhh+" times. for the forth shot.");
      alertoop.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alertoop.setGraphic(fsssp);
      alertoop.setResizable(false);
      DialogPane dialogPaneoop = alertoop.getDialogPane();
      dialogPaneoop.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optionoiop = alertoop.showAndWait();
      passyy=fsssp.getText();
      stonabaththh=Double.parseDouble(passyy);
      if (optionoiop.get() == null) {} 
      else if (optionoiop.get() == ButtonType.OK) {
         
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabaththh==0) {
          loadstone4=0;
          removestone4=0;
          cleaningstone4=0;
          extraction4=0;
          double dos3=loadstone4+removestone4;
          loadremovestone4=dos3;
          
      }
      else if (stonabaththh==1){
          
          loadstone4=5.5;
          removestone4=4.15;
          cleaningstone4=15;
          extraction4=20;
          double dos3=loadstone4+removestone4;
          loadremovestone4=dos3;
          
      }
      
      
      else if (stonabaththh==2){
          
          
          loadstone4=16.5;
          removestone4=8.3;
          cleaningstone4=20;
          extraction4=20;
          double dos3=loadstone4+removestone4;
          loadremovestone4=dos3;
          
          
      }
      
      
      else {
          double v=stonabaththh;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone4=v2;
          removestone4=v1;
          cleaningstone4=0;
          extraction4=20;
          double dos3=loadstone4+removestone4;
          loadremovestone4=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
      
      else if (optionoiop.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
      
                   
                   
      JFXTextField fssspp=new JFXTextField ("");
      fssspp.setPromptText("Write Stone Baths Number");
      fssspp.setMinSize(300, 30);
      fssspp.setLabelFloat(true);
      fssspp.setStyle("-fx-font-weight:bold;");
      fssspp.setEditable(true);
      Alert alertoopp = new Alert(Alert.AlertType.INFORMATION);
      alertoopp.setTitle("Stone Bath?");
      alertoopp.setHeaderText("We found stone or foam "+stonebathhh+" times. for the fifth shot.");
      alertoopp.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alertoopp.setGraphic(fssspp);
      alertoopp.setResizable(false);
      DialogPane dialogPaneoopp = alertoopp.getDialogPane();
      dialogPaneoopp.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optionoiopp = alertoopp.showAndWait();
      passyy=fssspp.getText();
      stonabaththh=Double.parseDouble(passyy);
      if (optionoiopp.get() == null) {} 
      else if (optionoiopp.get() == ButtonType.OK) {
         
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabaththh==0) {
          loadstone5=0;
          removestone5=0;
          cleaningstone5=0;
          extraction5=0;
          double dos3=loadstone5+removestone5;
          loadremovestone5=dos3;
          
      }
      else if (stonabaththh==1){
          
          loadstone5=5.5;
          removestone5=4.15;
          cleaningstone5=15;
          extraction5=20;
          double dos3=loadstone5+removestone5;
          loadremovestone5=dos3;
          
      }
      
      
      else if (stonabaththh==2){
          
          
          loadstone5=16.5;
          removestone5=8.3;
          cleaningstone5=20;
          extraction5=20;
          double dos3=loadstone5+removestone5;
          loadremovestone5=dos3;
          
          
      }
      
      
      else {
          double v=stonabaththh;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone5=v2;
          removestone5=v1;
          cleaningstone5=0;
          extraction5=20;
          double dos3=loadstone5+removestone5;
          loadremovestone5=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
                   
      
      else if (optionoiopp.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
      
                   
                   
      JFXTextField fsssppp=new JFXTextField ("");
      fsssppp.setPromptText("Write Stone Baths Number");
      fsssppp.setMinSize(300, 30);
      fsssppp.setLabelFloat(true);
      fsssppp.setStyle("-fx-font-weight:bold;");
      fsssppp.setEditable(true);
      Alert alertooppp = new Alert(Alert.AlertType.INFORMATION);
      alertooppp.setTitle("Stone Bath?");
      alertooppp.setHeaderText("We found stone or foam "+stonebathhh+" times. for the sixth shot.");
      alertooppp.setContentText("Hello, Please tell me: Stone Baths Number?.");
      alertooppp.setGraphic(fsssppp);
      alertooppp.setResizable(false);
      DialogPane dialogPaneooppp = alertooppp.getDialogPane();
      dialogPaneooppp.getStylesheets().add(
    getClass().getResource("cupertino-light.css").toExternalForm());
      Optional<ButtonType> optionoioppp = alertooppp.showAndWait();
      passyy=fsssppp.getText();
      stonabaththh=Double.parseDouble(passyy);
      if (optionoioppp.get() == null) {} 
      else if (optionoioppp.get() == ButtonType.OK) {
         
          /////////////////////////////////Stone Bath////////////////////////////////////////
          
          if (stonabaththh==0) {
          loadstone6=0;
          removestone6=0;
          cleaningstone6=0;
          extraction6=0;
          double dos3=loadstone6+removestone6;
          loadremovestone6=dos3;
          
      }
      else if (stonabaththh==1){
          
          loadstone6=5.5;
          removestone6=4.15;
          cleaningstone6=15;
          extraction6=20;
          double dos3=loadstone6+removestone6;
          loadremovestone6=dos3;
          
      }
      
      
      else if (stonabaththh==2){
          
          
          loadstone6=16.5;
          removestone6=8.3;
          cleaningstone6=20;
          extraction6=20;
          double dos3=loadstone6+removestone6;
          loadremovestone6=dos3;
          
          
      }
      
      
      else {
          double v=stonabaththh;
          double v1=v*4.15;
          double v2=15+((v-1)*1.5);
          
          loadstone6=v2;
          removestone6=v1;
          cleaningstone6=0;
          extraction6=20;
          double dos3=loadstone6+removestone6;
          loadremovestone6=dos3;
          
          
      }
      
          
          ////////////////////////////////////////////////////////////////////////////////////
      }
                   
      
      else if (optionoioppp.get() == ButtonType.CANCEL) {
      Notifications noti = Notifications.create();
      noti.title("Cancel!");
      noti.text("Operation Cancelled, Something was wrong.");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      } else {
         
      }
      
      
      
      
        
    }
    
        
        gmf1=stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank;   
        
        gmf2=stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2;
        
        gmf3=stonabaththh+thirdshott+loadremoveproduct3+loadremovestone3+tempraturetime3+extraction3+chemicaldosage3+fillemptytank3;
        
        gmf4=stonabaththh+forthshott+loadremoveproduct4+loadremovestone4+tempraturetime4+extraction4+chemicaldosage4+fillemptytank4;
        
        gmf5=stonabaththh+fifshott+loadremoveproduct5+loadremovestone5+tempraturetime5+extraction5+chemicaldosage5+fillemptytank5;
         
        gmf6=stonabaththh+sixshott+loadremoveproduct6+loadremovestone6+tempraturetime6+extraction6+chemicaldosage6+fillemptytank6;
        
       
    
     System.out.println(gmf1);
     System.out.println(gmf2);
     System.out.println(gmf3);
     System.out.println(gmf4);
     System.out.println(gmf5);
     System.out.println(gmf6);
     
    
    
    
    
    /////////////////////////////////////////////Starting//////////////////////////////////////////////////////////
    
    
    if (bathnumm==1) {
        
        gmf1=stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank;
        
        gdf1=(stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank)/60.0;
        
        //Write to recipe here //////////////////////////////////////////////////////////
        
Alert aloo = new Alert(Alert.AlertType.INFORMATION);
aloo.setTitle("Show Time");
aloo.setResizable(false);
aloo.setHeaderText("Here is time for "+recipenami+" of "+modelooo+" Customer.");
aloo.setContentText("This Recipe Was One Shot:\nTime In Minutes=   "+gmf1+"."+"\nTime In Hours=   "+gdf1+".");
DialogPane dialogPanej = aloo.getDialogPane();
dialogPanej.getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
aloo.showAndWait();
        
      /////////////////////////////////////////////////////////////////////////////////////////
      
      
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Save To DB");
alert.setHeaderText("Time Result");
alert.setContentText("Here Is The result of Time For "+recipenami+" Recipe.");
ButtonType buttonTypeOne = new ButtonType("Save To DB");
ButtonType buttonTypeCancel = new ButtonType("Cancel");
alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
DialogPane dialogPanei = alert.getDialogPane();
dialogPanei.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> results = alert.showAndWait();
if (results.isPresent() && results.get() == buttonTypeOne) {
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
           
                    String sql0 = "select * from Development_Time_Two where Name like '" + recipenami + "' and Model like '" + modelooo + "' ";
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
       
                                     
                                                 
      String sqlm = "select * from Development_Time_Two where Name=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
      
             
                                     
                String sqlp= "update Development_Time_Two set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();
                                     
     
                
                
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti = Notifications.create();
      noti.title("Update!");
      noti.text("We Updated Record Successfully!");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      
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
                                  
                                  
      String sqlm = "select * from Development_Time_Two where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, ti3);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
   //   pst.execute();
                            
         
                String sqlp= "update Development_Time_Two set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"'  where Name='"+recipenami+"' and Shot='"+ti3+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();    
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti = Notifications.create();
      noti.title("Update!");
      noti.text("We Updated Record 1 Successfully!");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
        
      
      } catch (Exception exception) {}
    }    
                           
                              
                                 try {
                            
                                    
      String sqlm = "select * from Development_Time_Two where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, filenammm);
      pst.setString(2, ti4);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin2=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour2=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Development_Time_Two set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+ti2+"'  where Name='"+recipenami+"' and Shot='"+ti4+"' ";
                pst=conn.prepareStatement(sqlp);
                pst.execute();         
                                     
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti = Notifications.create();
      noti.title("Update!");
      noti.text("We Updated Record 2 Successfully!");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
        
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
         


         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
     }
       
       
     else if (fifi.equals("not_found")) {
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
         
                       if (bosbos==1) {
                           
                           
                                 try {
                            
          String reg = "insert into Development_Time_Two (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti = Notifications.create();
      noti.title("Insert!");
      noti.text("We Inserted Record Successfully!");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
                       if (bosbos==2) {
                           
                              try {
                            
          String reg = "insert into Development_Time_Two (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti = Notifications.create();
      noti.title("Insert!");
      noti.text("We Inserted Record 1 Successfully!");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
      
      } catch (Exception exception) {}
    }    
                           
                              
                                 try {
                            
          String reg = "insert into Development_Time_Two (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
          pst.execute();
                            
                            
                        }
                        
                     catch (Exception exception) {
    } 
        finally {
      try {
        rs.close();
        pst.close();
        
      Notifications noti = Notifications.create();
      noti.title("Insert!");
      noti.text("We Inserted Record 2 Successfully!");
      noti.position(Pos.CENTER);
      noti.hideAfter(Duration.seconds(3));
      noti.showInformation();
        
      
      } catch (Exception exception) {}
    }    
                           
                           
                           
                           
                       }
                       
        
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
     }
       
     
     else {}
       
       
      
      
      
      
      
      
      
      
      
      ////////////////////////////////END DB////////////////////////////////////////////////////
        
      

} 
else {}
      
      
      
    
      
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
aloo.setHeaderText("Here is time for "+recipenami+" of "+modelooo+" Customer.");
aloo.setContentText("This Recipe Was Two Shots:\nFirst Shot Info:\nTime In Minutes=   "+gmf1+"."+"\nTime In Hours=   "+gdf1+".\n\n"+"Second Shot Info:\nTime In Minutes=   "+gmf2+"."+"\nTime In Hours=   "+gdf2+".\n\n");
DialogPane dialogPanej = aloo.getDialogPane();
dialogPanej.getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
aloo.showAndWait();
       
        /////////////////////////////////////////////////////////////////////////////////
        
        
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Save To DB");
alert.setHeaderText("Time Result");
alert.setContentText("Here Is The result of Time For "+recipenami+" Recipe.");
ButtonType buttonTypeOne = new ButtonType("Save To DB");
ButtonType buttonTypeCancel = new ButtonType("Cancel");
alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
DialogPane dialogPanei = alert.getDialogPane();
dialogPanei.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> results = alert.showAndWait();
if (results.isPresent() && results.get() == buttonTypeOne) {
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
           
                    String sql0 = "select * from Development_Time_Two where Name like '" + recipenami + "' and Model like '" + modelooo + "' ";
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
       
                                     
                                                 
      String sqlm = "select * from Development_Time_Two where Name=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
      
             
                                     
                String sqlp= "update Development_Time_Two set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
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
                                  
                                  
      String sqlm = "select * from Development_Time_Two where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, ti3);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
   //   pst.execute();
                            
         
                String sqlp= "update Development_Time_Two set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"'  where Name='"+recipenami+"' and Shot='"+ti3+"' ";
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
                            
                                    
      String sqlm = "select * from Development_Time_Two where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, filenammm);
      pst.setString(2, ti4);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin2=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour2=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Development_Time_Two set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+ti2+"'  where Name='"+recipenami+"' and Shot='"+ti4+"' ";
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
                            
          String reg = "insert into Development_Time_Two (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Development_Time_Two (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Development_Time_Two (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
       

} 
else {}
        
        
  
        //////////////////////////////////////////////////////////////////////////////////
        
    }
    
     //Start       
            
         else if (bathnumm==3) {
        
        gmf1=stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank;
        
        gdf1=(stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank)/60.0;
        
        gmf2=stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2;
        
        gdf2=(stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2)/60.0;
        
        gmf3=stonabaththh+thirdshott+loadremoveproduct3+loadremovestone3+tempraturetime3+extraction3+chemicaldosage3+fillemptytank3;
        
        gdf3=(stonabaththh+thirdshott+loadremoveproduct3+loadremovestone3+tempraturetime3+extraction3+chemicaldosage3+fillemptytank3)/60.0;
        
        //gmf4=stonabaththh+forthshott+loadremoveproduct4+loadremovestone4+tempraturetime4+extraction4+chemicaldosage4+fillemptytank4;
        
        //gdf4=(stonabaththh+forthshott+loadremoveproduct4+loadremovestone4+tempraturetime4+extraction4+chemicaldosage4+fillemptytank4)/60.0;
        
        
//        
//          //Write to recipe here //////////////////////////////////////////////////////////
//        
//File inputFileu = new File(System.getProperty("user.home")+"\\r.ks"); //         
//org.jsoup.nodes.Document report = Jsoup.parse(inputFileu, "UTF-8"); //
//domyy = report.children();
//domyy.select("tbody").append("<tr>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%; background-color: #f6ff00; border-color: #ff0000; text-align: center;\"><b>First Shot :</b> <u><b>"+Double.toString((gmf1))+"</b></u> <b>Mins.</b></td>\n" +
//"<td style=\"width: 11.1111%; background-color: #f6ff00; border-color: #ff0000; text-align: center;\"><u><b>"+Double.toString((gdf1))+"</b></u> <b>Hours.</b></td>\n" +
//"</tr>"
//        + "<tr>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%; background-color: #f6ff00; border-color: #ff0000; text-align: center;\"><b>Second Shot :</b> <u><b>"+Double.toString((gmf2))+"</b></u> <b>Mins.</b></td>\n" +
//"<td style=\"width: 11.1111%; background-color: #f6ff00; border-color: #ff0000; text-align: center;\"><u><b>"+Double.toString((gdf2))+"</b></u> <b>Hours.</b></td>\n" +
//"</tr>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
//"<td style=\"width: 11.1111%; background-color: #f6ff00; border-color: #ff0000; text-align: center;\"><b>Third Shot :</b> <u><b>"+Double.toString((gmf3))+"</b></u> <b>Mins.</b></td>\n" +
//"<td style=\"width: 11.1111%; background-color: #f6ff00; border-color: #ff0000; text-align: center;\"><u><b>"+Double.toString((gdf3))+"</b></u> <b>Hours.</b></td>\n" +
//"</tr>");
//
// 
//      String codee = domyy.toString();
//      if (!codee.contains("TABLE")) {
//      Notifications noti = Notifications.create();
//      noti.title("Recipe Error");
//      noti.text("Maybe not a recipe, Open a recipe first!.");
//      noti.hideAfter(Duration.seconds(3));
//      noti.position(Pos.CENTER);
//      noti.showError();    
//        }
//        else {
//            org.jsoup.nodes.Document docj = Jsoup.parse(codee);
//        for (Element table : docj.select("TABLE")) {
//        for (Element row : table.select("TR")) {
//            Elements tds = row.select("TD");
//            if (tds.get(7).text().isEmpty()) {   
//            }
//            else {  
//             ///////////////////////////////////////////////////////////////
//String string=tds.get(7).text();
//BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Chemical_Dictionary.kady"));
//String line;
//String linebeforeequal;
//String lineafterequal;
//while ((line=buf.readLine())!=null) {
//    
//    
//linebeforeequal=line.substring(0,line.indexOf("=")-0);
//lineafterequal=line.substring(line.indexOf("=") + 1 , line.length());
//if (string.equals(lineafterequal)) {
////System.out.println(string+" = "+linebeforeequal);
//tds.get(8).text(linebeforeequal);
////System.out.println(tds.get(8).text());
//break;
//
//    }
//    else {
//        
//    }
//    
//}
//buf.close();
//    
//            }   
//         
//        }}
//       roraa=docj.toString();
//        }
//      
//      
//      PrintWriter ddsg=new PrintWriter (new FileWriter (System.getProperty("user.home")+"\\tttr.ks"));
//      ddsg.println();
//      ddsg.close();
//      
//    
//    lili.clear();
//    InputStream inputinstreamb=new FileInputStream(System.getProperty("user.home")+"\\tttr.ks");
//    BufferedReader bib=new BufferedReader (new InputStreamReader (inputinstreamb,"UTF-8"));
//    //BufferedReader bi=new BufferedReader (new FileReader (pathy));
//    String lob;
//    while ((lob=bi.readLine())!=null) {
//        
//        lili.appendText("\n"+lob
//       .replace("A","ﬦ")
//       .replace("B","ﬧ")
//       .replace("C","ﬨ")
//       .replace("D","﬩")
//       .replace("E","שׁ")    
//       .replace("F","שׂ")        
//       .replace("G","שּׁ")         
//       .replace("H","שּׂ")         
//       .replace("I","אַ")         
//       .replace("J","אָ")         
//       .replace("K","אּ")         
//       .replace("L","בּ")         
//       .replace("M","גּ")         
//       .replace("N","דּ")         
//       .replace("O","הּ")         
//       .replace("P","וּ")         
//       .replace("Q","זּ")         
//       .replace("R","טּ")         
//       .replace("S","יּ")         
//       .replace("T","ךּ")         
//       .replace("U","כּ")         
//       .replace("V","לּ")
//       .replace("W","מּ")         
//       .replace("X","נּ")         
//       .replace("Y","סּ")         
//       .replace("Z","ףּ")
//                
//       .replace("0","פּ")         
//       .replace("1","צּ")         
//       .replace("2","קּ")         
//       .replace("3","רּ")         
//       .replace("4","שּ")         
//       .replace("5","תּ")         
//       .replace("6","וֹ")         
//       .replace("7","בֿ")         
//       .replace("8","כֿ")
//       .replace("9","פֿ")
//                
//       .replace("a","ﬦ")
//       .replace("b","ﬧ")
//       .replace("c","ﬨ")
//       .replace("d","﬩")
//       .replace("e","שׁ")    
//       .replace("f","שׂ")        
//       .replace("g","שּׁ")         
//       .replace("h","שּׂ")         
//       .replace("i","אַ")         
//       .replace("j","אָ")         
//       .replace("k","אּ")         
//       .replace("l","בּ")         
//       .replace("m","גּ")         
//       .replace("n","דּ")         
//       .replace("o","הּ")         
//       .replace("p","וּ")         
//       .replace("q","זּ")         
//       .replace("r","טּ")         
//       .replace("s","יּ")         
//       .replace("t","ךּ")         
//       .replace("u","כּ")         
//       .replace("v","לּ")
//       .replace("w","מּ")         
//       .replace("x","נּ")         
//       .replace("y","סּ")         
//       .replace("z","ףּ")                
//      ); 
//
//
//    }
//    bib.close();
//    String gfb=lili.getText();
//    OutputStream instreammb=new FileOutputStream(recipepathy);
//    PrintWriter pwb = new PrintWriter(new OutputStreamWriter (instreammb,"UTF-8"));
//    //PrintWriter pw=new PrintWriter (new FileWriter (pathy));
//    pwb.println(gfb);
//    pwb.close();
//    Notifications noti = Notifications.create();
//    noti.title("Successful");
//    noti.text("We have encrypted the recipe successfully.");
//    noti.hideAfter(Duration.seconds(3));
//    noti.position(Pos.CENTER);
//    noti.showInformation();
//    lili.clear();              
//                 
        /////////////////////////////////////////////////////////////////////////////////
          
          
Alert aloo = new Alert(Alert.AlertType.INFORMATION);
aloo.setTitle("Show Time");
aloo.setResizable(false);
aloo.setHeaderText("Here is time for "+recipenami+" of "+modelooo+" Customer.");
aloo.setContentText("This Recipe Was Three Shots:\nFirst Shot Info:\nTime In Minutes=   "+gmf1+"."+"\nTime In Hours=   "+gdf1+".\n\n"+"Second Shot Info:\nTime In Minutes=   "+gmf2+"."+"\nTime In Hours=   "+gdf2+".\n\n"+"Third Shot Info:\nTime In Minutes=   "+gmf3+"."+"\nTime In Hours=   "+gdf3+".\n\n");
DialogPane dialogPanej = aloo.getDialogPane();
dialogPanej.getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
aloo.showAndWait();
       
        /////////////////////////////////////////////////////////////////////////////////
        
        
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Save To DB");
alert.setHeaderText("Time Result");
alert.setContentText("Here Is The result of Time For "+recipenami+" Recipe.");
ButtonType buttonTypeOne = new ButtonType("Save To DB");
ButtonType buttonTypeCancel = new ButtonType("Cancel");
alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
DialogPane dialogPanei = alert.getDialogPane();
dialogPanei.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> results = alert.showAndWait();
if (results.isPresent() && results.get() == buttonTypeOne) {
//Save To DB.

     

Alert alerth = new Alert(Alert.AlertType.CONFIRMATION);
alerth.setTitle("Save To DB");
alerth.setHeaderText("Time Result");
alerth.setContentText("Where do you wanna save the result of Time For "+recipenami+" Recipe.");
ButtonType buttonTypeOneh = new ButtonType("DEVELOPMENT");
ButtonType buttonTypeCancelh = new ButtonType("PILOT");
alerth.getButtonTypes().setAll(buttonTypeOneh, buttonTypeCancelh);
DialogPane dialogPaneih = alerth.getDialogPane();
dialogPaneih.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> resultsh = alerth.showAndWait();

if (resultsh.isPresent() && resultsh.get() == buttonTypeOneh) {
  
    //PRODUCTION
    
    

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
           
                    String sql0 = "select * from Development_Time_Three where Name like '" + recipenami + "' and Model like '" + modelooo + "' ";
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
       
                                     
                                                 
      String sqlm = "select * from Development_Time_Three where Name=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
      
             
                                     
                String sqlp= "update Development_Time_Three set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
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
                                  
                                  
      String sqlm = "select * from Development_Time_Three where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, ti3);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
   //   pst.execute();
                            
         
                String sqlp= "update Development_Time_Three set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"'  where Name='"+recipenami+"' and Shot='"+ti3+"' ";
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
                            
                                    
      String sqlm = "select * from Development_Time_Three where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, filenammm);
      pst.setString(2, ti4);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin2=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour2=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Development_Time_Three set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+ti2+"'  where Name='"+recipenami+"' and Shot='"+ti4+"' ";
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
                       
         
                       
                       
                          if (bosbos==3) {
                           
                               
                           String ti1,ti2;
                           String ti3,ti4,ti5,ti6;
                           ti4=Integer.toString(shoty+1);
                           ti5=Integer.toString(shoty+2);
                           ti3=Integer.toString(shoty);
                           ti1=Double.toString(gdf1);
                           ti2=Double.toString(gdf2);
                           ti6=Double.toString(gdf3);
                           
                           
                           String mi1=Double.toString(gmf1);
                           String mi2=Double.toString(gmf2);
                           String mi3=Double.toString(gmf3);
                           
                           
                              try {
                                  
                                  
      String sqlm = "select * from Development_Time_Three where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, ti3);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
   //   pst.execute();
                            
         
                String sqlp= "update Development_Time_Three set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"'  where Name='"+recipenami+"' and Shot='"+ti3+"' ";
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
                            
                                    
      String sqlm = "select * from Development_Time_Three where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, "2");
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin2=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour2=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Development_Time_Three set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+ti2+"'  where Name='"+recipenami+"' and Shot='"+"2"+"' ";
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
                            
                                    
      String sqlm = "select * from Development_Time_Three where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, "3");
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin3=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour3=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Development_Time_Three set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin3+"', Time_In_Hour='"+oldtimehour3+"', Time_In_Min_Updated='"+mi3+"', Time_In_Hour_Updated='"+ti6+"'  where Name='"+recipenami+"' and Shot='"+"3"+"' ";
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
                            
          String reg = "insert into Development_Time_Three (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Development_Time_Three (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Development_Time_Three (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                       
        
         
          if (bosbos==3) {
                           
                              try {
                            
          String reg = "insert into Development_Time_Three (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Development_Time_Three (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Development_Time_Three (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+2));
          pst.setString(5,Double.toString(gmf3));
          pst.setString(6,Double.toString(gdf3));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
    
    
}

else {

//PILOT



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
           
                    String sql0 = "select * from Timer_Pilot where Name like '" + recipenami + "' and Model like '" + modelooo.replace(NewDir.file_dir+"\\PILOT\\","") + "' ";
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
       
                                     
                                                 
//      String sqlm = "select * from Timer_Three_Shots where Name=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour=add2;  //OLD TIME IN HOUR.
      
      
             
                                     
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
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
                                  
                                  
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
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
//      
   //   pst.execute();
                            
         
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
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
                            
                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
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
                                     
          
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi2+"', Time_In_Hour='"+ti2+"' where Name='"+recipenami+"' and Shot='"+ti4+"' ";
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
                       
         
                       
                       
                          if (bosbos==3) {
                           
                               
                           String ti1,ti2;
                           String ti3,ti4,ti5,ti6;
                           ti4=Integer.toString(shoty+1);
                           ti5=Integer.toString(shoty+2);
                           ti3=Integer.toString(shoty);
                           ti1=Double.toString(gdf1);
                           ti2=Double.toString(gdf2);
                           ti6=Double.toString(gdf3);
                           
                           
                           String mi1=Double.toString(gmf1);
                           String mi2=Double.toString(gmf2);
                           String mi3=Double.toString(gmf3);
                           
                           
                              try {
                                  
                                  
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
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
                        
         
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
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
                            
                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "2");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin2=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour2=add2;  //OLD TIME IN HOUR.
//      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi2+"', Time_In_Hour='"+ti2+"' where Name='"+recipenami+"' and Shot='"+"2"+"' ";
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
                            
                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "3");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin3=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour3=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi3+"', Time_In_Hour='"+ti6+"' where Name='"+recipenami+"' and Shot='"+"3"+"' ";
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
                       
        
         
          if (bosbos==3) {
                           
                              try {
                            
          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+2));
          pst.setString(5,Double.toString(gmf3));
          pst.setString(6,Double.toString(gdf3));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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


}


       

} 
else {}
        
        
  
        //////////////////////////////////////////////////////////////////////////////////
        
    }
         
         
         
         
    
         
          else if (bathnumm==4) {
        
        gmf1=stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank;
        
        gdf1=(stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank)/60.0;
        
        gmf2=stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2;
        
        gdf2=(stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2)/60.0;
        
        gmf3=stonabaththh+thirdshott+loadremoveproduct3+loadremovestone3+tempraturetime3+extraction3+chemicaldosage3+fillemptytank3;
        
        gdf3=(stonabaththh+thirdshott+loadremoveproduct3+loadremovestone3+tempraturetime3+extraction3+chemicaldosage3+fillemptytank3)/60.0;
        
        gmf4=stonabaththh+forthshott+loadremoveproduct4+loadremovestone4+tempraturetime4+extraction4+chemicaldosage4+fillemptytank4;
        
        gdf4=(stonabaththh+forthshott+loadremoveproduct4+loadremovestone4+tempraturetime4+extraction4+chemicaldosage4+fillemptytank4)/60.0;
        
        
//        gmf1=stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank;
//        
//        gdf1=(stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank)/60.0;
//        
//        gmf2=stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2;
//        
//        gdf2=(stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2)/60.0;
//        
//        gmf3=stonabaththh+thirdshott+loadremoveproduct3+loadremovestone3+tempraturetime3+extraction3+chemicaldosage3+fillemptytank3;
//        
//        gdf3=(stonabaththh+thirdshott+loadremoveproduct3+loadremovestone3+tempraturetime3+extraction3+chemicaldosage3+fillemptytank3)/60.0;
//        
//        gmf4=stonabaththh+forthshott+loadremoveproduct4+loadremovestone4+tempraturetime4+extraction4+chemicaldosage4+fillemptytank4;
//        
//        gdf4=(stonabaththh+forthshott+loadremoveproduct4+loadremovestone4+tempraturetime4+extraction4+chemicaldosage4+fillemptytank4)/60.0;
//        
//        gmf5=stonabaththh+fifshott+loadremoveproduct5+loadremovestone5+tempraturetime5+extraction5+chemicaldosage5+fillemptytank5;
//               
//        gdf5=(stonabaththh+fifshott+loadremoveproduct5+loadremovestone5+tempraturetime5+extraction5+chemicaldosage5+fillemptytank5)/60.0;      
//         
//        gmf6=stonabaththh+sixshott+loadremoveproduct6+loadremovestone6+tempraturetime6+extraction6+chemicaldosage6+fillemptytank6;
//               
//        gdf6=(stonabaththh+sixshott+loadremoveproduct6+loadremovestone6+tempraturetime6+extraction6+chemicaldosage6+fillemptytank6)/60.0;
//        
        
          //Write to recipe here //////////////////////////////////////////////////////////
          
     
          
                    
Alert aloo = new Alert(Alert.AlertType.INFORMATION);
aloo.setTitle("Show Time");
aloo.setResizable(false);
aloo.setHeaderText("Here is time for "+recipenami+" of "+modelooo+" Customer.");
aloo.setContentText("This Recipe Was Four Shots:\nFirst Shot Info:\nTime In Minutes=   "+gmf1+"."+"\nTime In Hours=   "+gdf1+".\n\n"+"Second Shot Info:\nTime In Minutes=   "+gmf2+"."+"\nTime In Hours=   "+gdf2+".\n\n"+"Third Shot Info:\nTime In Minutes=   "+gmf3+"."+"\nTime In Hours=   "+gdf3+".\n\n"+"Fourth Shot Info:\nTime In Minutes=   "+gmf4+"."+"\nTime In Hours=   "+gdf4+".\n\n");
DialogPane dialogPanej = aloo.getDialogPane();
dialogPanej.getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
aloo.showAndWait();
       
        /////////////////////////////////////////////////////////////////////////////////
        
        
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Save To DB");
alert.setHeaderText("Time Result");
alert.setContentText("Here Is The result of Time For "+recipenami+" Recipe.");
ButtonType buttonTypeOne = new ButtonType("Save To DB");
ButtonType buttonTypeCancel = new ButtonType("Cancel");
alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
DialogPane dialogPanei = alert.getDialogPane();
dialogPanei.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> results = alert.showAndWait();
if (results.isPresent() && results.get() == buttonTypeOne) {
//Save To DB.

     

Alert alerth = new Alert(Alert.AlertType.CONFIRMATION);
alerth.setTitle("Save To DB");
alerth.setHeaderText("Time Result");
alerth.setContentText("Where do you wanna save the result of Time For "+recipenami+" Recipe.");
ButtonType buttonTypeOneh = new ButtonType("PRODUCTION");
ButtonType buttonTypeCancelh = new ButtonType("PILOT");
alerth.getButtonTypes().setAll(buttonTypeOneh, buttonTypeCancelh);
DialogPane dialogPaneih = alerth.getDialogPane();
dialogPaneih.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> resultsh = alerth.showAndWait();

if (resultsh.isPresent() && resultsh.get() == buttonTypeOneh) {
  
    //PRODUCTION
    
    

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
           
                    String sql0 = "select * from Timer_Three_Shots where Name like '" + recipenami + "' and Model like '" + modelooo + "' ";
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
       
                                     
                                                 
      String sqlm = "select * from Timer_Three_Shots where Name=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
      
             
                                     
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
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
                                  
                                  
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, ti3);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
   //   pst.execute();
                            
         
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"'  where Name='"+recipenami+"' and Shot='"+ti3+"' ";
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
                            
                                    
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, filenammm);
      pst.setString(2, ti4);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin2=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour2=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+ti2+"'  where Name='"+recipenami+"' and Shot='"+ti4+"' ";
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
                       
         
                       
                       
                          if (bosbos==3) {
                           
                               
                           String ti1,ti2;
                           String ti3,ti4,ti5,ti6;
                           ti4=Integer.toString(shoty+1);
                           ti5=Integer.toString(shoty+2);
                           ti3=Integer.toString(shoty);
                           ti1=Double.toString(gdf1);
                           ti2=Double.toString(gdf2);
                           ti6=Double.toString(gdf3);
                           
                           
                           String mi1=Double.toString(gmf1);
                           String mi2=Double.toString(gmf2);
                           String mi3=Double.toString(gmf3);
                           
                           
                              try {
                                  
                                  
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, ti3);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
   //   pst.execute();
                            
         
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"'  where Name='"+recipenami+"' and Shot='"+ti3+"' ";
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
                            
                                    
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, "2");
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin2=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour2=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+ti2+"'  where Name='"+recipenami+"' and Shot='"+"2"+"' ";
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
                            
                                    
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, "3");
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin3=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour3=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin3+"', Time_In_Hour='"+oldtimehour3+"', Time_In_Min_Updated='"+mi3+"', Time_In_Hour_Updated='"+ti6+"'  where Name='"+recipenami+"' and Shot='"+"3"+"' ";
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
                          
                          
                          if (bosbos==4) {
                           
                               
                           String mi1,mi2,mi3,mi4,mi5,mi6;
                           String si1,si2,si3,si4,si5,si6;
                           
                           si1=Integer.toString(shoty);
                           si2=Integer.toString(shoty+1);
                           si3=Integer.toString(shoty+2);
                           si4=Integer.toString(shoty+3);
                           //si5=Integer.toString(shoty+4);
                           //si6=Integer.toString(shoty+5);
                           
                           mi1=Double.toString(gmf1);
                           mi2=Double.toString(gmf2);
                           mi3=Double.toString(gmf3);
                           mi4=Double.toString(gmf4);
                           //mi5=Double.toString(gmf5);
                           //mi6=Double.toString(gmf6);
                           
                           String hi1=Double.toString(gdf1);
                           String hi2=Double.toString(gdf2);
                           String hi3=Double.toString(gdf3);
                           String hi4=Double.toString(gdf4);
                           //String hi5=Double.toString(gdf5);
                           //String hi6=Double.toString(gdf6);
                           
                           
                           
                              try {
                                  
                                  
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, si1);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
   //   pst.execute();
                            
         
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+hi1+"'  where Name='"+recipenami+"' and Shot='"+si1+"' ";
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
                            
                                    
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, "2");
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin2=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour2=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+hi2+"'  where Name='"+recipenami+"' and Shot='"+"2"+"' ";
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
                            
                                    
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, "3");
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin3=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour3=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin3+"', Time_In_Hour='"+oldtimehour3+"', Time_In_Min_Updated='"+mi3+"', Time_In_Hour_Updated='"+hi3+"'  where Name='"+recipenami+"' and Shot='"+"3"+"' ";
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
                            
                                    
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, "4");
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin4=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour4=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin4+"', Time_In_Hour='"+oldtimehour4+"', Time_In_Min_Updated='"+mi4+"', Time_In_Hour_Updated='"+hi4+"'  where Name='"+recipenami+"' and Shot='"+"4"+"' ";
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
                  
//                  
//                                       
//                  try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "5");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin5=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour5=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin5+"', Time_In_Hour='"+oldtimehour5+"', Time_In_Min_Updated='"+mi5+"', Time_In_Hour_Updated='"+hi5+"'  where Name='"+recipenami+"' and Shot='"+"5"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                  
//                                       
//                  try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "6");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin3=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour3=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin6+"', Time_In_Hour='"+oldtimehour6+"', Time_In_Min_Updated='"+mi6+"', Time_In_Hour_Updated='"+hi6+"'  where Name='"+recipenami+"' and Shot='"+"6"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                  
//                  
                  
                           
                       }
                          
//                          if (bosbos==5) {
//                           
//                               
//                           String mi1,mi2,mi3,mi4,mi5,mi6;
//                           String si1,si2,si3,si4,si5,si6;
//                           
//                           si1=Integer.toString(shoty);
//                           si2=Integer.toString(shoty+1);
//                           si3=Integer.toString(shoty+2);
//                           si4=Integer.toString(shoty+3);
//                           si5=Integer.toString(shoty+4);
//                           //si6=Integer.toString(shoty+5);
//                           
//                           mi1=Double.toString(gmf1);
//                           mi2=Double.toString(gmf2);
//                           mi3=Double.toString(gmf3);
//                           mi4=Double.toString(gmf4);
//                           mi5=Double.toString(gmf5);
//                           //mi6=Double.toString(gmf6);
//                           
//                           String hi1=Double.toString(gdf1);
//                           String hi2=Double.toString(gdf2);
//                           String hi3=Double.toString(gdf3);
//                           String hi4=Double.toString(gdf4);
//                           String hi5=Double.toString(gdf5);
//                           //String hi6=Double.toString(gdf6);
//                           
//                           
//                                try {
//                                  
//                                  
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, si1);
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour=add2;  //OLD TIME IN HOUR.
//      
//   //   pst.execute();
//                            
//         
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+hi1+"'  where Name='"+recipenami+"' and Shot='"+si1+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();    
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "2");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin2=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour2=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+hi2+"'  where Name='"+recipenami+"' and Shot='"+"2"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                         
//                                 
//                  try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "3");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin3=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour3=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin3+"', Time_In_Hour='"+oldtimehour3+"', Time_In_Min_Updated='"+mi3+"', Time_In_Hour_Updated='"+hi3+"'  where Name='"+recipenami+"' and Shot='"+"3"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                                 
//                       
//                  
//                                       
//                  try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "4");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin4=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour4=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin4+"', Time_In_Hour='"+oldtimehour4+"', Time_In_Min_Updated='"+mi4+"', Time_In_Hour_Updated='"+hi4+"'  where Name='"+recipenami+"' and Shot='"+"4"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                  
//                  
//                                       
//                  try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "5");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin5=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour5=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin5+"', Time_In_Hour='"+oldtimehour5+"', Time_In_Min_Updated='"+mi5+"', Time_In_Hour_Updated='"+hi5+"'  where Name='"+recipenami+"' and Shot='"+"5"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                  
////                                       
////                  try {
////                            
////                                    
////      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
////      pst = conn.prepareStatement(sqlm);
////      pst.setString(1, recipenami);
////      pst.setString(2, "6");
////      rs = pst.executeQuery();
////      
////      String add1 = rs.getString("Time_In_Min");
////      oldtimemin3=add1;  //OLD TIME IN MINUTES.
////      
////      String add2 = rs.getString("Time_In_Hour");
////      oldtimehour3=add2;  //OLD TIME IN HOUR.
////      
////     // pst.execute();
////                                     
////          
////                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin6+"', Time_In_Hour='"+oldtimehour6+"', Time_In_Min_Updated='"+mi6+"', Time_In_Hour_Updated='"+hi6+"'  where Name='"+recipenami+"' and Shot='"+"6"+"' ";
////                pst=conn.prepareStatement(sqlp);
////                pst.execute();         
////                                     
////                            
////                            
////                        }
////                        
////                     catch (Exception exception) {
////    } 
////        finally {
////      try {
////        rs.close();
////        pst.close();
////      
////      } catch (Exception exception) {}
////    }                     
////                  
////                  
//                  
//                                 
//                           
//                           
//                       }
//                          
                          
                          
//                          if (bosbos==6) {
//                           
//                               
//                           String mi1,mi2,mi3,mi4,mi5,mi6;
//                           String si1,si2,si3,si4,si5,si6;
//                           
//                           si1=Integer.toString(shoty);
//                           si2=Integer.toString(shoty+1);
//                           si3=Integer.toString(shoty+2);
//                           si4=Integer.toString(shoty+3);
//                           si5=Integer.toString(shoty+4);
//                           si6=Integer.toString(shoty+5);
//                           
//                           mi1=Double.toString(gmf1);
//                           mi2=Double.toString(gmf2);
//                           mi3=Double.toString(gmf3);
//                           mi4=Double.toString(gmf4);
//                           mi5=Double.toString(gmf5);
//                           mi6=Double.toString(gmf6);
//                           
//                           String hi1=Double.toString(gdf1);
//                           String hi2=Double.toString(gdf2);
//                           String hi3=Double.toString(gdf3);
//                           String hi4=Double.toString(gdf4);
//                           String hi5=Double.toString(gdf5);
//                           String hi6=Double.toString(gdf6);
//                           
//                           
//                        
//                                  try {
//                                  
//                                  
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, si1);
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour=add2;  //OLD TIME IN HOUR.
//      
//   //   pst.execute();
//                            
//         
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+hi1+"'  where Name='"+recipenami+"' and Shot='"+si1+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();    
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "2");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin2=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour2=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+hi2+"'  where Name='"+recipenami+"' and Shot='"+"2"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                         
//                                 
//                  try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "3");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin3=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour3=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin3+"', Time_In_Hour='"+oldtimehour3+"', Time_In_Min_Updated='"+mi3+"', Time_In_Hour_Updated='"+hi3+"'  where Name='"+recipenami+"' and Shot='"+"3"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                                 
//                       
//                  
//                                       
//                  try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "4");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin4=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour4=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin4+"', Time_In_Hour='"+oldtimehour4+"', Time_In_Min_Updated='"+mi4+"', Time_In_Hour_Updated='"+hi4+"'  where Name='"+recipenami+"' and Shot='"+"4"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                  
//                  
//                                       
//                  try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "5");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin5=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour5=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin5+"', Time_In_Hour='"+oldtimehour5+"', Time_In_Min_Updated='"+mi5+"', Time_In_Hour_Updated='"+hi5+"'  where Name='"+recipenami+"' and Shot='"+"5"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                  
//                                       
//                  try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "6");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin3=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour3=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin6+"', Time_In_Hour='"+oldtimehour6+"', Time_In_Min_Updated='"+mi6+"', Time_In_Hour_Updated='"+hi6+"'  where Name='"+recipenami+"' and Shot='"+"6"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                  
//                  
//                  
//                           
//                           
//                           
//                           
//                       }
//                       


         
         //////////////SROP////////////ppppppppppppppppppppp///////////////////////////////////////
     }
       
       
     else if (fifi.equals("not_found")) {
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
         
                       if (bosbos==1) {
                           
                           
                                 try {
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                       
        
         
          if (bosbos==3) {
                           
                              try {
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+2));
          pst.setString(5,Double.toString(gmf3));
          pst.setString(6,Double.toString(gdf3));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
          
          
          
           if (bosbos==4) {
                           
                              try {
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+2));
          pst.setString(5,Double.toString(gmf3));
          pst.setString(6,Double.toString(gdf3));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+3));
          pst.setString(5,Double.toString(gmf4));
          pst.setString(6,Double.toString(gdf4));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                                 
                                 
//                                 
//                                          try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+4));
//          pst.setString(5,Double.toString(gmf5));
//          pst.setString(6,Double.toString(gdf5));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }
//                                          
//                                          
//                                          
//                                                   try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+5));
//          pst.setString(5,Double.toString(gmf6));
//          pst.setString(6,Double.toString(gdf6));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }
//                                 
//                                 
                                 
                           
                       }
          
          
//           if (bosbos==5) {
//                           
//                              try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty));
//          pst.setString(5,Double.toString(gmf1));
//          pst.setString(6,Double.toString(gdf1));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+1));
//          pst.setString(5,Double.toString(gmf2));
//          pst.setString(6,Double.toString(gdf2));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                           
//                        try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+2));
//          pst.setString(5,Double.toString(gmf3));
//          pst.setString(6,Double.toString(gdf3));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                               
//                                try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+3));
//          pst.setString(5,Double.toString(gmf4));
//          pst.setString(6,Double.toString(gdf4));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }
//                                      
//                                 
//                                            
//                                          try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+4));
//          pst.setString(5,Double.toString(gmf5));
//          pst.setString(6,Double.toString(gdf5));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }
//                                          
//                                          
////                                          
////                                                   try {
////                            
////          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
////          pst = conn.prepareStatement(reg);
////          pst.setString(1,datevaluey);
////          pst.setString(2,modelooo);
////          pst.setString(3,recipenami);
////          pst.setString(4,Integer.toString(shoty+5));
////          pst.setString(5,Double.toString(gmf6));
////          pst.setString(6,Double.toString(gdf6));
////          pst.setString(7,"Hasnot_Updated_Yet");
////          pst.setString(8,"Hasnot_Updated_Yet");
////          pst.execute();
////                            
////                            
////                        }
////                        
////                     catch (Exception exception) {
////    } 
////        finally {
////      try {
////        rs.close();
////        pst.close();
////      
////      } catch (Exception exception) {}
////    }
////                                 
////                         
//                                 
//                           
//                       }
//           
//           
//            if (bosbos==6) {
//                           
//                              try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty));
//          pst.setString(5,Double.toString(gmf1));
//          pst.setString(6,Double.toString(gdf1));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+1));
//          pst.setString(5,Double.toString(gmf2));
//          pst.setString(6,Double.toString(gdf2));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                           
//                        try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+2));
//          pst.setString(5,Double.toString(gmf3));
//          pst.setString(6,Double.toString(gdf3));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                               
//                              try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+3));
//          pst.setString(5,Double.toString(gmf4));
//          pst.setString(6,Double.toString(gdf4));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }
//                                        
//                                 
//                                             
//                                          try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+4));
//          pst.setString(5,Double.toString(gmf5));
//          pst.setString(6,Double.toString(gdf5));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }
//                                          
//                                          
//                                          
//                                                   try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+5));
//          pst.setString(5,Double.toString(gmf6));
//          pst.setString(6,Double.toString(gdf6));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }
//                                 
//                        
//                                 
//                           
//                       }
//          
//          
          
         ///////////STOP///////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
     }
       
     
     else {}
       
       
      
      ////////////////////////////////END DB////////////////////////////////////////////////////
    
    
}

else {

//PILOT



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
           
                    String sql0 = "select * from Timer_Pilot where Name like '" + recipenami + "' and Model like '" + modelooo.replace(NewDir.file_dir+"\\PILOT\\","") + "' ";
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
       
                                     
                                                 
//      String sqlm = "select * from Timer_Three_Shots where Name=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour=add2;  //OLD TIME IN HOUR.
      
      
             
                                     
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
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
                                  
                                  
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
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
//      
   //   pst.execute();
                            
         
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
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
                            
                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
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
                                     
          
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi2+"', Time_In_Hour='"+ti2+"' where Name='"+recipenami+"' and Shot='"+ti4+"' ";
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
                       
         
                       
                       
                          if (bosbos==3) {
                           
                               
                           String ti1,ti2;
                           String ti3,ti4,ti5,ti6;
                           ti4=Integer.toString(shoty+1);
                           ti5=Integer.toString(shoty+2);
                           ti3=Integer.toString(shoty);
                           ti1=Double.toString(gdf1);
                           ti2=Double.toString(gdf2);
                           ti6=Double.toString(gdf3);
                           
                           
                           String mi1=Double.toString(gmf1);
                           String mi2=Double.toString(gmf2);
                           String mi3=Double.toString(gmf3);
                           
                           
                              try {
                                  
                                  
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
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
                            
         
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
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
                            
                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "2");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin2=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour2=add2;  //OLD TIME IN HOUR.
//      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi2+"', Time_In_Hour='"+ti2+"' where Name='"+recipenami+"' and Shot='"+"2"+"' ";
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
                            
                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "3");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin3=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour3=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi3+"', Time_In_Hour='"+ti6+"' where Name='"+recipenami+"' and Shot='"+"3"+"' ";
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
                      
                          
                          
                                if (bosbos==4) {
                           
                               
                           String mi1,mi2,mi3,mi4,mi5,mi6;
                           String si1,si2,si3,si4,si5,si6;
                           
                           si1=Integer.toString(shoty);
                           si2=Integer.toString(shoty+1);
                           si3=Integer.toString(shoty+2);
                           si4=Integer.toString(shoty+3);
                           //si5=Integer.toString(shoty+4);
                           //si6=Integer.toString(shoty+5);
                           
                           mi1=Double.toString(gmf1);
                           mi2=Double.toString(gmf2);
                           mi3=Double.toString(gmf3);
                           mi4=Double.toString(gmf4);
                           //mi5=Double.toString(gmf5);
                           //mi6=Double.toString(gmf6);
                           
                           String hi1=Double.toString(gdf1);
                           String hi2=Double.toString(gdf2);
                           String hi3=Double.toString(gdf3);
                           String hi4=Double.toString(gdf4);
                           //String hi5=Double.toString(gdf5);
                           //String hi6=Double.toString(gdf6);      
                           
                           
                              try {
                                  
                                  
      
         
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+hi1+"' where Name='"+recipenami+"' and Shot='"+si1+"' ";
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
                            
                                    

                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi2+"', Time_In_Hour='"+hi2+"' where Name='"+recipenami+"' and Shot='"+"2"+"' ";
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
                            
                                    
                                     
          
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi3+"', Time_In_Hour='"+hi3+"' where Name='"+recipenami+"' and Shot='"+"3"+"' ";
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
                            
                                    
                                     
          
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi4+"', Time_In_Hour='"+hi4+"' where Name='"+recipenami+"' and Shot='"+"4"+"' ";
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
                   
                   
//                    try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi5+"', Time_In_Hour='"+hi5+"' where Name='"+recipenami+"' and Shot='"+"5"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                    
//                     try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi6+"', Time_In_Hour='"+hi6+"' where Name='"+recipenami+"' and Shot='"+"6"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                                 
//                        
                     
                     
                     
                           
                       }
                                
                                
                                
                                  
//                                if (bosbos==5) {
//                           
//                               
//                           String mi1,mi2,mi3,mi4,mi5,mi6;
//                           String si1,si2,si3,si4,si5,si6;
//                           
//                           si1=Integer.toString(shoty);
//                           si2=Integer.toString(shoty+1);
//                           si3=Integer.toString(shoty+2);
//                           si4=Integer.toString(shoty+3);
//                           si5=Integer.toString(shoty+4);
//                           si6=Integer.toString(shoty+5);
//                           
//                           mi1=Double.toString(gmf1);
//                           mi2=Double.toString(gmf2);
//                           mi3=Double.toString(gmf3);
//                           mi4=Double.toString(gmf4);
//                           mi5=Double.toString(gmf5);
//                           mi6=Double.toString(gmf6);
//                           
//                           String hi1=Double.toString(gdf1);
//                           String hi2=Double.toString(gdf2);
//                           String hi3=Double.toString(gdf3);
//                           String hi4=Double.toString(gdf4);
//                           String hi5=Double.toString(gdf5);
//                           String hi6=Double.toString(gdf6);      
//                           
//                           
//                              try {
//                                  
//                                  
//      
//         
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+hi1+"' where Name='"+recipenami+"' and Shot='"+si1+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();    
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//                                    
//
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi2+"', Time_In_Hour='"+hi2+"' where Name='"+recipenami+"' and Shot='"+"2"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                         
//                                 
//                  try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi3+"', Time_In_Hour='"+hi3+"' where Name='"+recipenami+"' and Shot='"+"3"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                  
//                  
//                   try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi4+"', Time_In_Hour='"+hi4+"' where Name='"+recipenami+"' and Shot='"+"4"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                   
//                   
//                    try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi5+"', Time_In_Hour='"+hi5+"' where Name='"+recipenami+"' and Shot='"+"5"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
////                    
////                     try {
////                            
////                                    
////                                     
////          
////                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi6+"', Time_In_Hour='"+hi6+"' where Name='"+recipenami+"' and Shot='"+"6"+"' ";
////                pst=conn.prepareStatement(sqlp);
////                pst.execute();         
////                                     
////                            
////                            
////                        }
////                        
////                     catch (Exception exception) {
////    } 
////        finally {
////      try {
////        rs.close();
////        pst.close();
////      
////      } catch (Exception exception) {}
////    }                     
////                                 
////                        
//                     
//                     
//                     
//                           
//                       }
//                                
//                                
//                                  
//                                if (bosbos==6) {
//                           
//                               
//                           String mi1,mi2,mi3,mi4,mi5,mi6;
//                           String si1,si2,si3,si4,si5,si6;
//                           
//                           si1=Integer.toString(shoty);
//                           si2=Integer.toString(shoty+1);
//                           si3=Integer.toString(shoty+2);
//                           si4=Integer.toString(shoty+3);
//                           si5=Integer.toString(shoty+4);
//                           si6=Integer.toString(shoty+5);
//                           
//                           mi1=Double.toString(gmf1);
//                           mi2=Double.toString(gmf2);
//                           mi3=Double.toString(gmf3);
//                           mi4=Double.toString(gmf4);
//                           mi5=Double.toString(gmf5);
//                           mi6=Double.toString(gmf6);
//                           
//                           String hi1=Double.toString(gdf1);
//                           String hi2=Double.toString(gdf2);
//                           String hi3=Double.toString(gdf3);
//                           String hi4=Double.toString(gdf4);
//                           String hi5=Double.toString(gdf5);
//                           String hi6=Double.toString(gdf6);      
//                           
//                           
//                              try {
//                                  
//                                  
//      
//         
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+hi1+"' where Name='"+recipenami+"' and Shot='"+si1+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();    
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//                                    
//
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi2+"', Time_In_Hour='"+hi2+"' where Name='"+recipenami+"' and Shot='"+"2"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                         
//                                 
//                  try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi3+"', Time_In_Hour='"+hi3+"' where Name='"+recipenami+"' and Shot='"+"3"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                  
//                  
//                   try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi4+"', Time_In_Hour='"+hi4+"' where Name='"+recipenami+"' and Shot='"+"4"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                   
//                   
//                    try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi5+"', Time_In_Hour='"+hi5+"' where Name='"+recipenami+"' and Shot='"+"5"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                    
//                     try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi6+"', Time_In_Hour='"+hi6+"' where Name='"+recipenami+"' and Shot='"+"6"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                                 
//                        
//                     
//                     
//                     
//                           
//                       }
//                          
                          
//           String mi1,mi2,mi3,mi4,mi5,mi6;
//                           String si1,si2,si3,si4,si5,si6;
//                           
//                           si1=Integer.toString(shoty);
//                           si2=Integer.toString(shoty+1);
//                           si3=Integer.toString(shoty+2);
//                           si4=Integer.toString(shoty+3);
//                           si5=Integer.toString(shoty+4);
//                           si6=Integer.toString(shoty+5);
//                           
//                           mi1=Double.toString(gmf1);
//                           mi2=Double.toString(gmf2);
//                           mi3=Double.toString(gmf3);
//                           mi4=Double.toString(gmf4);
//                           mi5=Double.toString(gmf5);
//                           mi6=Double.toString(gmf6);
//                           
//                           String hi1=Double.toString(gdf1);
//                           String hi2=Double.toString(gdf2);
//                           String hi3=Double.toString(gdf3);
//                           String hi4=Double.toString(gdf4);
//                           String hi5=Double.toString(gdf5);
//                           String hi6=Double.toString(gdf6);               
                          
                       


         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
     }
       
       
     else if (fifi.equals("not_found")) {
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
         
                       if (bosbos==1) {
                           
                           
                                 try {
                            
          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
                       
        
         
          if (bosbos==3) {
                           
                              try {
                            
          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+2));
          pst.setString(5,Double.toString(gmf3));
          pst.setString(6,Double.toString(gdf3));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          
          
          
            if (bosbos==4) {
                           
                              try {
                            
          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+2));
          pst.setString(5,Double.toString(gmf3));
          pst.setString(6,Double.toString(gdf3));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+3));
          pst.setString(5,Double.toString(gmf4));
          pst.setString(6,Double.toString(gdf4));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+4));
          pst.setString(5,Double.toString(gmf5));
          pst.setString(6,Double.toString(gdf5));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+5));
          pst.setString(5,Double.toString(gmf6));
          pst.setString(6,Double.toString(gdf6));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
            
            
            
          
//            if (bosbos==5) {
//                           
//                              try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty));
//          pst.setString(5,Double.toString(gmf1));
//          pst.setString(6,Double.toString(gdf1));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+1));
//          pst.setString(5,Double.toString(gmf2));
//          pst.setString(6,Double.toString(gdf2));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                           
//                        try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+2));
//          pst.setString(5,Double.toString(gmf3));
//          pst.setString(6,Double.toString(gdf3));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                               
//                                 
//                   try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+3));
//          pst.setString(5,Double.toString(gmf4));
//          pst.setString(6,Double.toString(gdf4));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                   
//                   
//                   try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+4));
//          pst.setString(5,Double.toString(gmf5));
//          pst.setString(6,Double.toString(gdf5));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                   
//                   
//                   try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+5));
//          pst.setString(5,Double.toString(gmf6));
//          pst.setString(6,Double.toString(gdf6));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                                 
//                                 
//                           
//                       }
//            
//            
//            
//          
//            if (bosbos==6) {
//                           
//                              try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty));
//          pst.setString(5,Double.toString(gmf1));
//          pst.setString(6,Double.toString(gdf1));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+1));
//          pst.setString(5,Double.toString(gmf2));
//          pst.setString(6,Double.toString(gdf2));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                           
//                        try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+2));
//          pst.setString(5,Double.toString(gmf3));
//          pst.setString(6,Double.toString(gdf3));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                               
//                                 
//                   try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+3));
//          pst.setString(5,Double.toString(gmf4));
//          pst.setString(6,Double.toString(gdf4));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                   
//                   
//                   try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+4));
//          pst.setString(5,Double.toString(gmf5));
//          pst.setString(6,Double.toString(gdf5));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                   
//                   
//                   try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+5));
//          pst.setString(5,Double.toString(gmf6));
//          pst.setString(6,Double.toString(gdf6));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                                 
//                                 
//                           
//                       }
          
          
          
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
     }
       
     
     else {}
       
       
      
      ////////////////////////////////END DB////////////////////////////////////////////////////


}


       

} 
else {}
        
        
  
        //////////////////////////////////////////////////////////////////////////////////
        
        
                  
                  
                  
                  
                  
                 
                  
 

   }
        


      
        
                  
        
              
       else if (bathnumm==5) {
        
        gmf1=stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank;
        
        gdf1=(stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank)/60.0;
        
        gmf2=stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2;
        
        gdf2=(stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2)/60.0;
        
        gmf3=stonabaththh+thirdshott+loadremoveproduct3+loadremovestone3+tempraturetime3+extraction3+chemicaldosage3+fillemptytank3;
        
        gdf3=(stonabaththh+thirdshott+loadremoveproduct3+loadremovestone3+tempraturetime3+extraction3+chemicaldosage3+fillemptytank3)/60.0;
        
        gmf4=stonabaththh+forthshott+loadremoveproduct4+loadremovestone4+tempraturetime4+extraction4+chemicaldosage4+fillemptytank4;
        
        gdf4=(stonabaththh+forthshott+loadremoveproduct4+loadremovestone4+tempraturetime4+extraction4+chemicaldosage4+fillemptytank4)/60.0;
        
        gmf5=stonabaththh+fifshott+loadremoveproduct5+loadremovestone5+tempraturetime5+extraction5+chemicaldosage5+fillemptytank5;
               
        gdf5=(stonabaththh+fifshott+loadremoveproduct5+loadremovestone5+tempraturetime5+extraction5+chemicaldosage5+fillemptytank5)/60.0;      
         
        //gmf6=stonabaththh+sixshott+loadremoveproduct6+loadremovestone6+tempraturetime6+extraction6+chemicaldosage6+fillemptytank6;
               
        //gdf6=(stonabaththh+sixshott+loadremoveproduct6+loadremovestone6+tempraturetime6+extraction6+chemicaldosage6+fillemptytank6)/60.0;       
        
        
          //Write to recipe here //////////////////////////////////////////////////////////
          
     
          
                    
Alert aloo = new Alert(Alert.AlertType.INFORMATION);
aloo.setTitle("Show Time");
aloo.setResizable(false);
aloo.setHeaderText("Here is time for "+recipenami+" of "+modelooo+" Customer.");
aloo.setContentText("This Recipe Was Five Shots:\nFirst Shot Info:\nTime In Minutes=   "+gmf1+"."+"\nTime In Hours=   "+gdf1+".\n\n"+"Second Shot Info:\nTime In Minutes=   "+gmf2+"."+"\nTime In Hours=   "+gdf2+".\n\n"+"Third Shot Info:\nTime In Minutes=   "+gmf3+"."+"\nTime In Hours=   "+gdf3+".\n\n"+"Fourth Shot Info:\nTime In Minutes=   "+gmf4+"."+"\nTime In Hours=   "+gdf4+".\n\n"+"Fifth Shot Info:\nTime In Minutes=   "+gmf5+"."+"\nTime In Hours=   "+gdf5+".\n\n");
DialogPane dialogPanej = aloo.getDialogPane();
dialogPanej.getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
aloo.showAndWait();
       
        /////////////////////////////////////////////////////////////////////////////////
        
        
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Save To DB");
alert.setHeaderText("Time Result");
alert.setContentText("Here Is The result of Time For "+recipenami+" Recipe.");
ButtonType buttonTypeOne = new ButtonType("Save To DB");
ButtonType buttonTypeCancel = new ButtonType("Cancel");
alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
DialogPane dialogPanei = alert.getDialogPane();
dialogPanei.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> results = alert.showAndWait();
if (results.isPresent() && results.get() == buttonTypeOne) {
//Save To DB.

     

Alert alerth = new Alert(Alert.AlertType.CONFIRMATION);
alerth.setTitle("Save To DB");
alerth.setHeaderText("Time Result");
alerth.setContentText("Where do you wanna save the result of Time For "+recipenami+" Recipe.");
ButtonType buttonTypeOneh = new ButtonType("PRODUCTION");
ButtonType buttonTypeCancelh = new ButtonType("PILOT");
alerth.getButtonTypes().setAll(buttonTypeOneh, buttonTypeCancelh);
DialogPane dialogPaneih = alerth.getDialogPane();
dialogPaneih.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> resultsh = alerth.showAndWait();

if (resultsh.isPresent() && resultsh.get() == buttonTypeOneh) {
  
    //PRODUCTION
    
    

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
           
                    String sql0 = "select * from Timer_Three_Shots where Name like '" + recipenami + "' and Model like '" + modelooo + "' ";
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
       
                                     
                                                 
      String sqlm = "select * from Timer_Three_Shots where Name=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
      
             
                                     
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
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
                                  
                                  
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, ti3);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
   //   pst.execute();
                            
         
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"'  where Name='"+recipenami+"' and Shot='"+ti3+"' ";
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
                            
                                    
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, filenammm);
      pst.setString(2, ti4);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin2=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour2=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+ti2+"'  where Name='"+recipenami+"' and Shot='"+ti4+"' ";
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
                       
         
                       
                       
                          if (bosbos==3) {
                           
                               
                           String ti1,ti2;
                           String ti3,ti4,ti5,ti6;
                           ti4=Integer.toString(shoty+1);
                           ti5=Integer.toString(shoty+2);
                           ti3=Integer.toString(shoty);
                           ti1=Double.toString(gdf1);
                           ti2=Double.toString(gdf2);
                           ti6=Double.toString(gdf3);
                           
                           
                           String mi1=Double.toString(gmf1);
                           String mi2=Double.toString(gmf2);
                           String mi3=Double.toString(gmf3);
                           
                           
                              try {
                                  
                                  
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, ti3);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
   //   pst.execute();
                            
         
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"'  where Name='"+recipenami+"' and Shot='"+ti3+"' ";
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
                            
                                    
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, "2");
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin2=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour2=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+ti2+"'  where Name='"+recipenami+"' and Shot='"+"2"+"' ";
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
                            
                                    
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, "3");
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin3=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour3=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin3+"', Time_In_Hour='"+oldtimehour3+"', Time_In_Min_Updated='"+mi3+"', Time_In_Hour_Updated='"+ti6+"'  where Name='"+recipenami+"' and Shot='"+"3"+"' ";
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
                          
                          
                          if (bosbos==4) {
                           
                               
                           String mi1,mi2,mi3,mi4,mi5,mi6;
                           String si1,si2,si3,si4,si5,si6;
                           
                           si1=Integer.toString(shoty);
                           si2=Integer.toString(shoty+1);
                           si3=Integer.toString(shoty+2);
                           si4=Integer.toString(shoty+3);
                           //si5=Integer.toString(shoty+4);
                           //si6=Integer.toString(shoty+5);
                           
                           mi1=Double.toString(gmf1);
                           mi2=Double.toString(gmf2);
                           mi3=Double.toString(gmf3);
                           mi4=Double.toString(gmf4);
                           //mi5=Double.toString(gmf5);
                           //mi6=Double.toString(gmf6);
                           
                           String hi1=Double.toString(gdf1);
                           String hi2=Double.toString(gdf2);
                           String hi3=Double.toString(gdf3);
                           String hi4=Double.toString(gdf4);
                           //String hi5=Double.toString(gdf5);
                           //String hi6=Double.toString(gdf6);
                           
                           
                           
                              try {
                                  
                                  
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, si1);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
   //   pst.execute();
                            
         
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+hi1+"'  where Name='"+recipenami+"' and Shot='"+si1+"' ";
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
                            
                                    
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, "2");
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin2=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour2=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+hi2+"'  where Name='"+recipenami+"' and Shot='"+"2"+"' ";
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
                            
                                    
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, "3");
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin3=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour3=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin3+"', Time_In_Hour='"+oldtimehour3+"', Time_In_Min_Updated='"+mi3+"', Time_In_Hour_Updated='"+hi3+"'  where Name='"+recipenami+"' and Shot='"+"3"+"' ";
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
                            
                                    
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, "4");
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin4=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour4=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin4+"', Time_In_Hour='"+oldtimehour4+"', Time_In_Min_Updated='"+mi4+"', Time_In_Hour_Updated='"+hi4+"'  where Name='"+recipenami+"' and Shot='"+"4"+"' ";
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
                  
//                  
//                                       
//                  try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "5");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin5=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour5=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin5+"', Time_In_Hour='"+oldtimehour5+"', Time_In_Min_Updated='"+mi5+"', Time_In_Hour_Updated='"+hi5+"'  where Name='"+recipenami+"' and Shot='"+"5"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                  
//                                       
//                  try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "6");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin3=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour3=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin6+"', Time_In_Hour='"+oldtimehour6+"', Time_In_Min_Updated='"+mi6+"', Time_In_Hour_Updated='"+hi6+"'  where Name='"+recipenami+"' and Shot='"+"6"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                  
//                  
                  
                           
                       }
                          
                          if (bosbos==5) {
                           
                               
                           String mi1,mi2,mi3,mi4,mi5,mi6;
                           String si1,si2,si3,si4,si5,si6;
                           
                           si1=Integer.toString(shoty);
                           si2=Integer.toString(shoty+1);
                           si3=Integer.toString(shoty+2);
                           si4=Integer.toString(shoty+3);
                           si5=Integer.toString(shoty+4);
                           //si6=Integer.toString(shoty+5);
                           
                           mi1=Double.toString(gmf1);
                           mi2=Double.toString(gmf2);
                           mi3=Double.toString(gmf3);
                           mi4=Double.toString(gmf4);
                           mi5=Double.toString(gmf5);
                           //mi6=Double.toString(gmf6);
                           
                           String hi1=Double.toString(gdf1);
                           String hi2=Double.toString(gdf2);
                           String hi3=Double.toString(gdf3);
                           String hi4=Double.toString(gdf4);
                           String hi5=Double.toString(gdf5);
                           //String hi6=Double.toString(gdf6);
                           
                           
                                try {
                                  
                                  
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, si1);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
   //   pst.execute();
                            
         
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+hi1+"'  where Name='"+recipenami+"' and Shot='"+si1+"' ";
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
                            
                                    
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, "2");
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin2=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour2=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+hi2+"'  where Name='"+recipenami+"' and Shot='"+"2"+"' ";
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
                            
                                    
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, "3");
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin3=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour3=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin3+"', Time_In_Hour='"+oldtimehour3+"', Time_In_Min_Updated='"+mi3+"', Time_In_Hour_Updated='"+hi3+"'  where Name='"+recipenami+"' and Shot='"+"3"+"' ";
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
                            
                                    
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, "4");
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin4=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour4=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin4+"', Time_In_Hour='"+oldtimehour4+"', Time_In_Min_Updated='"+mi4+"', Time_In_Hour_Updated='"+hi4+"'  where Name='"+recipenami+"' and Shot='"+"4"+"' ";
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
                            
                                    
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, "5");
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin5=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour5=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin5+"', Time_In_Hour='"+oldtimehour5+"', Time_In_Min_Updated='"+mi5+"', Time_In_Hour_Updated='"+hi5+"'  where Name='"+recipenami+"' and Shot='"+"5"+"' ";
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
                  
//                                       
//                  try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "6");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin3=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour3=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin6+"', Time_In_Hour='"+oldtimehour6+"', Time_In_Min_Updated='"+mi6+"', Time_In_Hour_Updated='"+hi6+"'  where Name='"+recipenami+"' and Shot='"+"6"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                  
//                  
                  
                                 
                           
                           
                       }
                          
                          
//                          
//                          if (bosbos==6) {
//                           
//                               
//                           String mi1,mi2,mi3,mi4,mi5,mi6;
//                           String si1,si2,si3,si4,si5,si6;
//                           
//                           si1=Integer.toString(shoty);
//                           si2=Integer.toString(shoty+1);
//                           si3=Integer.toString(shoty+2);
//                           si4=Integer.toString(shoty+3);
//                           si5=Integer.toString(shoty+4);
//                           si6=Integer.toString(shoty+5);
//                           
//                           mi1=Double.toString(gmf1);
//                           mi2=Double.toString(gmf2);
//                           mi3=Double.toString(gmf3);
//                           mi4=Double.toString(gmf4);
//                           mi5=Double.toString(gmf5);
//                           mi6=Double.toString(gmf6);
//                           
//                           String hi1=Double.toString(gdf1);
//                           String hi2=Double.toString(gdf2);
//                           String hi3=Double.toString(gdf3);
//                           String hi4=Double.toString(gdf4);
//                           String hi5=Double.toString(gdf5);
//                           String hi6=Double.toString(gdf6);
//                           
//                           
//                        
//                                  try {
//                                  
//                                  
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, si1);
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour=add2;  //OLD TIME IN HOUR.
//      
//   //   pst.execute();
//                            
//         
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+hi1+"'  where Name='"+recipenami+"' and Shot='"+si1+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();    
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "2");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin2=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour2=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+hi2+"'  where Name='"+recipenami+"' and Shot='"+"2"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                         
//                                 
//                  try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "3");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin3=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour3=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin3+"', Time_In_Hour='"+oldtimehour3+"', Time_In_Min_Updated='"+mi3+"', Time_In_Hour_Updated='"+hi3+"'  where Name='"+recipenami+"' and Shot='"+"3"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                                 
//                       
//                  
//                                       
//                  try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "4");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin4=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour4=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin4+"', Time_In_Hour='"+oldtimehour4+"', Time_In_Min_Updated='"+mi4+"', Time_In_Hour_Updated='"+hi4+"'  where Name='"+recipenami+"' and Shot='"+"4"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                  
//                  
//                                       
//                  try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "5");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin5=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour5=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin5+"', Time_In_Hour='"+oldtimehour5+"', Time_In_Min_Updated='"+mi5+"', Time_In_Hour_Updated='"+hi5+"'  where Name='"+recipenami+"' and Shot='"+"5"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                  
//                                       
//                  try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "6");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin3=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour3=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin6+"', Time_In_Hour='"+oldtimehour6+"', Time_In_Min_Updated='"+mi6+"', Time_In_Hour_Updated='"+hi6+"'  where Name='"+recipenami+"' and Shot='"+"6"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                  
//                  
//                  
//                           
//                           
//                           
//                           
//                       }
                       


         
         //////////////SROP////////////ppppppppppppppppppppp///////////////////////////////////////
     }
       
       
     else if (fifi.equals("not_found")) {
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
         
                       if (bosbos==1) {
                           
                           
                                 try {
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                       
        
         
          if (bosbos==3) {
                           
                              try {
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+2));
          pst.setString(5,Double.toString(gmf3));
          pst.setString(6,Double.toString(gdf3));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
          
          
          
           if (bosbos==4) {
                           
                              try {
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+2));
          pst.setString(5,Double.toString(gmf3));
          pst.setString(6,Double.toString(gdf3));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+3));
          pst.setString(5,Double.toString(gmf4));
          pst.setString(6,Double.toString(gdf4));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                                 
                                 
//                                 
//                                          try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+4));
//          pst.setString(5,Double.toString(gmf5));
//          pst.setString(6,Double.toString(gdf5));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }
//                                          
//                                          
//                                          
//                                                   try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+5));
//          pst.setString(5,Double.toString(gmf6));
//          pst.setString(6,Double.toString(gdf6));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }
//                                 
//                                 
                                 
                           
                       }
          
          
           if (bosbos==5) {
                           
                              try {
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+2));
          pst.setString(5,Double.toString(gmf3));
          pst.setString(6,Double.toString(gdf3));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+3));
          pst.setString(5,Double.toString(gmf4));
          pst.setString(6,Double.toString(gdf4));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+4));
          pst.setString(5,Double.toString(gmf5));
          pst.setString(6,Double.toString(gdf5));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                                          
                                          
//                                          
//                                                   try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+5));
//          pst.setString(5,Double.toString(gmf6));
//          pst.setString(6,Double.toString(gdf6));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }
//                                 
//                         
                                 
                           
                       }
           
           
//            if (bosbos==6) {
//                           
//                              try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty));
//          pst.setString(5,Double.toString(gmf1));
//          pst.setString(6,Double.toString(gdf1));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+1));
//          pst.setString(5,Double.toString(gmf2));
//          pst.setString(6,Double.toString(gdf2));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                           
//                        try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+2));
//          pst.setString(5,Double.toString(gmf3));
//          pst.setString(6,Double.toString(gdf3));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                               
//                              try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+3));
//          pst.setString(5,Double.toString(gmf4));
//          pst.setString(6,Double.toString(gdf4));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }
//                                        
//                                 
//                                             
//                                          try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+4));
//          pst.setString(5,Double.toString(gmf5));
//          pst.setString(6,Double.toString(gdf5));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }
//                                          
//                                          
//                                          
//                                                   try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+5));
//          pst.setString(5,Double.toString(gmf6));
//          pst.setString(6,Double.toString(gdf6));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }
//                                 
//                        
//                                 
//                           
//                       }
          
          
          
         ///////////STOP///////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
     }
       
     
     else {}
       
       
      
      ////////////////////////////////END DB////////////////////////////////////////////////////
    
    
}

else {

//PILOT



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
           
                    String sql0 = "select * from Timer_Pilot where Name like '" + recipenami + "' and Model like '" + modelooo.replace(NewDir.file_dir+"\\PILOT\\","") + "' ";
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
       
                                     
                                                 
//      String sqlm = "select * from Timer_Three_Shots where Name=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour=add2;  //OLD TIME IN HOUR.
      
      
             
                                     
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
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
                                  
                                  
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
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
//      
   //   pst.execute();
                            
         
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
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
                            
                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
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
                                     
          
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi2+"', Time_In_Hour='"+ti2+"' where Name='"+recipenami+"' and Shot='"+ti4+"' ";
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
                       
         
                       
                       
                          if (bosbos==3) {
                           
                               
                           String ti1,ti2;
                           String ti3,ti4,ti5,ti6;
                           ti4=Integer.toString(shoty+1);
                           ti5=Integer.toString(shoty+2);
                           ti3=Integer.toString(shoty);
                           ti1=Double.toString(gdf1);
                           ti2=Double.toString(gdf2);
                           ti6=Double.toString(gdf3);
                           
                           
                           String mi1=Double.toString(gmf1);
                           String mi2=Double.toString(gmf2);
                           String mi3=Double.toString(gmf3);
                           
                           
                              try {
                                  
                                  
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
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
                            
         
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
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
                            
                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "2");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin2=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour2=add2;  //OLD TIME IN HOUR.
//      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi2+"', Time_In_Hour='"+ti2+"' where Name='"+recipenami+"' and Shot='"+"2"+"' ";
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
                            
                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "3");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin3=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour3=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi3+"', Time_In_Hour='"+ti6+"' where Name='"+recipenami+"' and Shot='"+"3"+"' ";
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
                      
                          
                          
                                if (bosbos==4) {
                           
                               
                           String mi1,mi2,mi3,mi4,mi5,mi6;
                           String si1,si2,si3,si4,si5,si6;
                           
                           si1=Integer.toString(shoty);
                           si2=Integer.toString(shoty+1);
                           si3=Integer.toString(shoty+2);
                           si4=Integer.toString(shoty+3);
                           //si5=Integer.toString(shoty+4);
                           //si6=Integer.toString(shoty+5);
                           
                           mi1=Double.toString(gmf1);
                           mi2=Double.toString(gmf2);
                           mi3=Double.toString(gmf3);
                           mi4=Double.toString(gmf4);
                           //mi5=Double.toString(gmf5);
                           //mi6=Double.toString(gmf6);
                           
                           String hi1=Double.toString(gdf1);
                           String hi2=Double.toString(gdf2);
                           String hi3=Double.toString(gdf3);
                           String hi4=Double.toString(gdf4);
                           //String hi5=Double.toString(gdf5);
                           //String hi6=Double.toString(gdf6);      
                           
                           
                              try {
                                  
                                  
      
         
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+hi1+"' where Name='"+recipenami+"' and Shot='"+si1+"' ";
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
                            
                                    

                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi2+"', Time_In_Hour='"+hi2+"' where Name='"+recipenami+"' and Shot='"+"2"+"' ";
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
                            
                                    
                                     
          
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi3+"', Time_In_Hour='"+hi3+"' where Name='"+recipenami+"' and Shot='"+"3"+"' ";
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
                            
                                    
                                     
          
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi4+"', Time_In_Hour='"+hi4+"' where Name='"+recipenami+"' and Shot='"+"4"+"' ";
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
                   
                   
//                    try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi5+"', Time_In_Hour='"+hi5+"' where Name='"+recipenami+"' and Shot='"+"5"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                    
//                     try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi6+"', Time_In_Hour='"+hi6+"' where Name='"+recipenami+"' and Shot='"+"6"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                                 
//                        
                     
                     
                     
                           
                       }
                                
                                
                                
                                  
                                if (bosbos==5) {
                           
                               
                           String mi1,mi2,mi3,mi4,mi5,mi6;
                           String si1,si2,si3,si4,si5,si6;
                           
                           si1=Integer.toString(shoty);
                           si2=Integer.toString(shoty+1);
                           si3=Integer.toString(shoty+2);
                           si4=Integer.toString(shoty+3);
                           si5=Integer.toString(shoty+4);
                           si6=Integer.toString(shoty+5);
                           
                           mi1=Double.toString(gmf1);
                           mi2=Double.toString(gmf2);
                           mi3=Double.toString(gmf3);
                           mi4=Double.toString(gmf4);
                           mi5=Double.toString(gmf5);
                           mi6=Double.toString(gmf6);
                           
                           String hi1=Double.toString(gdf1);
                           String hi2=Double.toString(gdf2);
                           String hi3=Double.toString(gdf3);
                           String hi4=Double.toString(gdf4);
                           String hi5=Double.toString(gdf5);
                           String hi6=Double.toString(gdf6);      
                           
                           
                              try {
                                  
                                  
      
         
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+hi1+"' where Name='"+recipenami+"' and Shot='"+si1+"' ";
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
                            
                                    

                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi2+"', Time_In_Hour='"+hi2+"' where Name='"+recipenami+"' and Shot='"+"2"+"' ";
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
                            
                                    
                                     
          
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi3+"', Time_In_Hour='"+hi3+"' where Name='"+recipenami+"' and Shot='"+"3"+"' ";
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
                            
                                    
                                     
          
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi4+"', Time_In_Hour='"+hi4+"' where Name='"+recipenami+"' and Shot='"+"4"+"' ";
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
                            
                                    
                                     
          
                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi5+"', Time_In_Hour='"+hi5+"' where Name='"+recipenami+"' and Shot='"+"5"+"' ";
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
//                    
//                     try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi6+"', Time_In_Hour='"+hi6+"' where Name='"+recipenami+"' and Shot='"+"6"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                                 
//                        
                     
                     
                     
                           
                       }
                                
                                
                                  
//                                if (bosbos==6) {
//                           
//                               
//                           String mi1,mi2,mi3,mi4,mi5,mi6;
//                           String si1,si2,si3,si4,si5,si6;
//                           
//                           si1=Integer.toString(shoty);
//                           si2=Integer.toString(shoty+1);
//                           si3=Integer.toString(shoty+2);
//                           si4=Integer.toString(shoty+3);
//                           si5=Integer.toString(shoty+4);
//                           si6=Integer.toString(shoty+5);
//                           
//                           mi1=Double.toString(gmf1);
//                           mi2=Double.toString(gmf2);
//                           mi3=Double.toString(gmf3);
//                           mi4=Double.toString(gmf4);
//                           mi5=Double.toString(gmf5);
//                           mi6=Double.toString(gmf6);
//                           
//                           String hi1=Double.toString(gdf1);
//                           String hi2=Double.toString(gdf2);
//                           String hi3=Double.toString(gdf3);
//                           String hi4=Double.toString(gdf4);
//                           String hi5=Double.toString(gdf5);
//                           String hi6=Double.toString(gdf6);      
//                           
//                           
//                              try {
//                                  
//                                  
//      
//         
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+hi1+"' where Name='"+recipenami+"' and Shot='"+si1+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();    
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//                                    
//
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi2+"', Time_In_Hour='"+hi2+"' where Name='"+recipenami+"' and Shot='"+"2"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                         
//                                 
//                  try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi3+"', Time_In_Hour='"+hi3+"' where Name='"+recipenami+"' and Shot='"+"3"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                  
//                  
//                   try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi4+"', Time_In_Hour='"+hi4+"' where Name='"+recipenami+"' and Shot='"+"4"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                   
//                   
//                    try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi5+"', Time_In_Hour='"+hi5+"' where Name='"+recipenami+"' and Shot='"+"5"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                    
//                     try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi6+"', Time_In_Hour='"+hi6+"' where Name='"+recipenami+"' and Shot='"+"6"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                                 
//                        
//                     
//                     
//                     
//                           
//                       }
                          
                          
//           String mi1,mi2,mi3,mi4,mi5,mi6;
//                           String si1,si2,si3,si4,si5,si6;
//                           
//                           si1=Integer.toString(shoty);
//                           si2=Integer.toString(shoty+1);
//                           si3=Integer.toString(shoty+2);
//                           si4=Integer.toString(shoty+3);
//                           si5=Integer.toString(shoty+4);
//                           si6=Integer.toString(shoty+5);
//                           
//                           mi1=Double.toString(gmf1);
//                           mi2=Double.toString(gmf2);
//                           mi3=Double.toString(gmf3);
//                           mi4=Double.toString(gmf4);
//                           mi5=Double.toString(gmf5);
//                           mi6=Double.toString(gmf6);
//                           
//                           String hi1=Double.toString(gdf1);
//                           String hi2=Double.toString(gdf2);
//                           String hi3=Double.toString(gdf3);
//                           String hi4=Double.toString(gdf4);
//                           String hi5=Double.toString(gdf5);
//                           String hi6=Double.toString(gdf6);               
                          
                       


         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
     }
       
       
     else if (fifi.equals("not_found")) {
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
         
                       if (bosbos==1) {
                           
                           
                                 try {
                            
          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
                       
        
         
          if (bosbos==3) {
                           
                              try {
                            
          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+2));
          pst.setString(5,Double.toString(gmf3));
          pst.setString(6,Double.toString(gdf3));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          
          
          
            if (bosbos==4) {
                           
                              try {
                            
          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+2));
          pst.setString(5,Double.toString(gmf3));
          pst.setString(6,Double.toString(gdf3));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+3));
          pst.setString(5,Double.toString(gmf4));
          pst.setString(6,Double.toString(gdf4));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+4));
          pst.setString(5,Double.toString(gmf5));
          pst.setString(6,Double.toString(gdf5));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+5));
          pst.setString(5,Double.toString(gmf6));
          pst.setString(6,Double.toString(gdf6));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
            
            
            
          
            if (bosbos==5) {
                           
                              try {
                            
          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+2));
          pst.setString(5,Double.toString(gmf3));
          pst.setString(6,Double.toString(gdf3));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+3));
          pst.setString(5,Double.toString(gmf4));
          pst.setString(6,Double.toString(gdf4));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+4));
          pst.setString(5,Double.toString(gmf5));
          pst.setString(6,Double.toString(gdf5));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+5));
          pst.setString(5,Double.toString(gmf6));
          pst.setString(6,Double.toString(gdf6));
          //pst.setString(7,"Hasnot_Updated_Yet");
          //pst.setString(8,"Hasnot_Updated_Yet");
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
            
            
            
          
//            if (bosbos==6) {
//                           
//                              try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty));
//          pst.setString(5,Double.toString(gmf1));
//          pst.setString(6,Double.toString(gdf1));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+1));
//          pst.setString(5,Double.toString(gmf2));
//          pst.setString(6,Double.toString(gdf2));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                           
//                        try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+2));
//          pst.setString(5,Double.toString(gmf3));
//          pst.setString(6,Double.toString(gdf3));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                               
//                                 
//                   try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+3));
//          pst.setString(5,Double.toString(gmf4));
//          pst.setString(6,Double.toString(gdf4));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                   
//                   
//                   try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+4));
//          pst.setString(5,Double.toString(gmf5));
//          pst.setString(6,Double.toString(gdf5));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                   
//                   
//                   try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+5));
//          pst.setString(5,Double.toString(gmf6));
//          pst.setString(6,Double.toString(gdf6));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                                 
//                                 
//                           
//                       }
          
          
          
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
     }
       
     
     else {}
       
       
      
      ////////////////////////////////END DB////////////////////////////////////////////////////


}


       

} 
else {}
        
        
  
        //////////////////////////////////////////////////////////////////////////////////
        
        
                  
                  
                  
                  
                  
                 
                  
     
    }
                         
                  
                  
        
              
        else if (bathnumm==6) {
        
        gmf1=stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank;
        
        gdf1=(stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank)/60.0;
        
        gmf2=stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2;
        
        gdf2=(stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2)/60.0;
        
        gmf3=stonabaththh+thirdshott+loadremoveproduct3+loadremovestone3+tempraturetime3+extraction3+chemicaldosage3+fillemptytank3;
        
        gdf3=(stonabaththh+thirdshott+loadremoveproduct3+loadremovestone3+tempraturetime3+extraction3+chemicaldosage3+fillemptytank3)/60.0;
        
        gmf4=stonabaththh+forthshott+loadremoveproduct4+loadremovestone4+tempraturetime4+extraction4+chemicaldosage4+fillemptytank4;
        
        gdf4=(stonabaththh+forthshott+loadremoveproduct4+loadremovestone4+tempraturetime4+extraction4+chemicaldosage4+fillemptytank4)/60.0;
        
        gmf5=stonabaththh+fifshott+loadremoveproduct5+loadremovestone5+tempraturetime5+extraction5+chemicaldosage5+fillemptytank5;
               
        gdf5=(stonabaththh+fifshott+loadremoveproduct5+loadremovestone5+tempraturetime5+extraction5+chemicaldosage5+fillemptytank5)/60.0;      
         
        gmf6=stonabaththh+sixshott+loadremoveproduct6+loadremovestone6+tempraturetime6+extraction6+chemicaldosage6+fillemptytank6;
               
        gdf6=(stonabaththh+sixshott+loadremoveproduct6+loadremovestone6+tempraturetime6+extraction6+chemicaldosage6+fillemptytank6)/60.0;   
        
        
          //Write to recipe here //////////////////////////////////////////////////////////
          
     
          
                    
Alert aloo = new Alert(Alert.AlertType.INFORMATION);
aloo.setTitle("Show Time");
aloo.setResizable(false);
aloo.setHeaderText("Here is time for "+recipenami+" of "+modelooo+" Customer.");
aloo.setContentText("This Recipe Was Six Shots:\nFirst Shot Info:\nTime In Minutes=   "+gmf1+"."+"\nTime In Hours=   "+gdf1+".\n\n"+"Second Shot Info:\nTime In Minutes=   "+gmf2+"."+"\nTime In Hours=   "+gdf2+".\n\n"+"Third Shot Info:\nTime In Minutes=   "+gmf3+"."+"\nTime In Hours=   "+gdf3+".\n\n"+"Fourth Shot Info:\nTime In Minutes=   "+gmf4+"."+"\nTime In Hours=   "+gdf4+".\n\n"+"Fifth Shot Info:\nTime In Minutes=   "+gmf5+"."+"\nTime In Hours=   "+gdf5+".\n\n"+"Sixth Shot Info:\nTime In Minutes=   "+gmf6+"."+"\nTime In Hours=   "+gdf6+".\n\n");
DialogPane dialogPanej = aloo.getDialogPane();
dialogPanej.getStylesheets().add(
getClass().getResource("cupertino-light.css").toExternalForm());
aloo.showAndWait();
       
        /////////////////////////////////////////////////////////////////////////////////
        
//        
Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
alert.setTitle("Save To DB");
alert.setHeaderText("Time Result");
alert.setContentText("Here Is The result of Time For "+recipenami+" Recipe.");
ButtonType buttonTypeOne = new ButtonType("Save To DB");
ButtonType buttonTypeCancel = new ButtonType("Cancel");
alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeCancel);
DialogPane dialogPanei = alert.getDialogPane();
dialogPanei.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> results = alert.showAndWait();
if (results.isPresent() && results.get() == buttonTypeOne) {
//Save To DB.

     

Alert alerth = new Alert(Alert.AlertType.CONFIRMATION);
alerth.setTitle("Save To DB");
alerth.setHeaderText("Time Result");
alerth.setContentText("Where do you wanna save the result of Time For "+recipenami+" Recipe.");
ButtonType buttonTypeOneh = new ButtonType("PRODUCTION");
//ButtonType buttonTypeCancelh = new ButtonType("Not Available");
alerth.getButtonTypes().setAll(buttonTypeOneh/*, buttonTypeCancelh*/);
DialogPane dialogPaneih = alerth.getDialogPane();
dialogPaneih.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
Optional<ButtonType> resultsh = alerth.showAndWait();

if (resultsh.isPresent() && resultsh.get() == buttonTypeOneh) {
  
    //PRODUCTION
    
    

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
           
                    String sql0 = "select * from Timer_Three_Shots where Name like '" + recipenami + "' and Model like '" + modelooo + "' ";
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
         
                             
//                          if (bosbos==1) {
//                              
//                           String ti1,ti2;
//                           String ti3,ti4;
//                           ti4=Integer.toString(shoty+1);
//                           ti3=Integer.toString(shoty);
//                           ti1=Double.toString(gdf1);
//                           ti2=Double.toString(gdf2);
//                           String mi1=Double.toString(gmf1);
//                           String mi2=Double.toString(gmf2);
//                           
//                                 try {
//       
//                                     
//                                                 
//      String sqlm = "select * from Timer_Three_Shots where Name=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour=add2;  //OLD TIME IN HOUR.
//      
//      
//             
//                                     
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();
//                                     
//     
//                
//                
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                           
//                           
//                           
//                       }
//                       
//                       if (bosbos==2) {
//                           
//                               
//                           String ti1,ti2;
//                           String ti3,ti4;
//                           ti4=Integer.toString(shoty+1);
//                           ti3=Integer.toString(shoty);
//                           ti1=Double.toString(gdf1);
//                           ti2=Double.toString(gdf2);
//                           String mi1=Double.toString(gmf1);
//                           String mi2=Double.toString(gmf2);
//                           
//                           
//                              try {
//                                  
//                                  
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
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
//      
//   //   pst.execute();
//                            
//         
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"'  where Name='"+recipenami+"' and Shot='"+ti3+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();    
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
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
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+ti2+"'  where Name='"+recipenami+"' and Shot='"+ti4+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                           
//                           
//                           
//                       }
//                       
//         
//                       
//                       
//                          if (bosbos==3) {
//                           
//                               
//                           String ti1,ti2;
//                           String ti3,ti4,ti5,ti6;
//                           ti4=Integer.toString(shoty+1);
//                           ti5=Integer.toString(shoty+2);
//                           ti3=Integer.toString(shoty);
//                           ti1=Double.toString(gdf1);
//                           ti2=Double.toString(gdf2);
//                           ti6=Double.toString(gdf3);
//                           
//                           
//                           String mi1=Double.toString(gmf1);
//                           String mi2=Double.toString(gmf2);
//                           String mi3=Double.toString(gmf3);
//                           
//                           
//                              try {
//                                  
//                                  
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
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
//      
//   //   pst.execute();
//                            
//         
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"'  where Name='"+recipenami+"' and Shot='"+ti3+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();    
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "2");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin2=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour2=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+ti2+"'  where Name='"+recipenami+"' and Shot='"+"2"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                         
//                                 
//                  try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "3");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin3=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour3=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin3+"', Time_In_Hour='"+oldtimehour3+"', Time_In_Min_Updated='"+mi3+"', Time_In_Hour_Updated='"+ti6+"'  where Name='"+recipenami+"' and Shot='"+"3"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                                 
//                           
//                           
//                       }
//                          
//                          
//                          if (bosbos==4) {
//                           
//                               
//                           String mi1,mi2,mi3,mi4,mi5,mi6;
//                           String si1,si2,si3,si4,si5,si6;
//                           
//                           si1=Integer.toString(shoty);
//                           si2=Integer.toString(shoty+1);
//                           si3=Integer.toString(shoty+2);
//                           si4=Integer.toString(shoty+3);
//                           //si5=Integer.toString(shoty+4);
//                           //si6=Integer.toString(shoty+5);
//                           
//                           mi1=Double.toString(gmf1);
//                           mi2=Double.toString(gmf2);
//                           mi3=Double.toString(gmf3);
//                           mi4=Double.toString(gmf4);
//                           //mi5=Double.toString(gmf5);
//                           //mi6=Double.toString(gmf6);
//                           
//                           String hi1=Double.toString(gdf1);
//                           String hi2=Double.toString(gdf2);
//                           String hi3=Double.toString(gdf3);
//                           String hi4=Double.toString(gdf4);
//                           //String hi5=Double.toString(gdf5);
//                           //String hi6=Double.toString(gdf6);
//                           
//                           
//                           
//                              try {
//                                  
//                                  
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, si1);
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour=add2;  //OLD TIME IN HOUR.
//      
//   //   pst.execute();
//                            
//         
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+hi1+"'  where Name='"+recipenami+"' and Shot='"+si1+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();    
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "2");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin2=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour2=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+hi2+"'  where Name='"+recipenami+"' and Shot='"+"2"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                         
//                                 
//                  try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "3");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin3=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour3=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin3+"', Time_In_Hour='"+oldtimehour3+"', Time_In_Min_Updated='"+mi3+"', Time_In_Hour_Updated='"+hi3+"'  where Name='"+recipenami+"' and Shot='"+"3"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                                 
//                       
//                  
//                                       
//                  try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "4");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin4=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour4=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin4+"', Time_In_Hour='"+oldtimehour4+"', Time_In_Min_Updated='"+mi4+"', Time_In_Hour_Updated='"+hi4+"'  where Name='"+recipenami+"' and Shot='"+"4"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                  
////                  
////                                       
////                  try {
////                            
////                                    
////      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
////      pst = conn.prepareStatement(sqlm);
////      pst.setString(1, recipenami);
////      pst.setString(2, "5");
////      rs = pst.executeQuery();
////      
////      String add1 = rs.getString("Time_In_Min");
////      oldtimemin5=add1;  //OLD TIME IN MINUTES.
////      
////      String add2 = rs.getString("Time_In_Hour");
////      oldtimehour5=add2;  //OLD TIME IN HOUR.
////      
////     // pst.execute();
////                                     
////          
////                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin5+"', Time_In_Hour='"+oldtimehour5+"', Time_In_Min_Updated='"+mi5+"', Time_In_Hour_Updated='"+hi5+"'  where Name='"+recipenami+"' and Shot='"+"5"+"' ";
////                pst=conn.prepareStatement(sqlp);
////                pst.execute();         
////                                     
////                            
////                            
////                        }
////                        
////                     catch (Exception exception) {
////    } 
////        finally {
////      try {
////        rs.close();
////        pst.close();
////      
////      } catch (Exception exception) {}
////    }                     
////                  
////                                       
////                  try {
////                            
////                                    
////      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
////      pst = conn.prepareStatement(sqlm);
////      pst.setString(1, recipenami);
////      pst.setString(2, "6");
////      rs = pst.executeQuery();
////      
////      String add1 = rs.getString("Time_In_Min");
////      oldtimemin3=add1;  //OLD TIME IN MINUTES.
////      
////      String add2 = rs.getString("Time_In_Hour");
////      oldtimehour3=add2;  //OLD TIME IN HOUR.
////      
////     // pst.execute();
////                                     
////          
////                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin6+"', Time_In_Hour='"+oldtimehour6+"', Time_In_Min_Updated='"+mi6+"', Time_In_Hour_Updated='"+hi6+"'  where Name='"+recipenami+"' and Shot='"+"6"+"' ";
////                pst=conn.prepareStatement(sqlp);
////                pst.execute();         
////                                     
////                            
////                            
////                        }
////                        
////                     catch (Exception exception) {
////    } 
////        finally {
////      try {
////        rs.close();
////        pst.close();
////      
////      } catch (Exception exception) {}
////    }                     
////                  
////                  
//                  
//                           
//                       }
//                          
//                          if (bosbos==5) {
//                           
//                               
//                           String mi1,mi2,mi3,mi4,mi5,mi6;
//                           String si1,si2,si3,si4,si5,si6;
//                           
//                           si1=Integer.toString(shoty);
//                           si2=Integer.toString(shoty+1);
//                           si3=Integer.toString(shoty+2);
//                           si4=Integer.toString(shoty+3);
//                           si5=Integer.toString(shoty+4);
//                           //si6=Integer.toString(shoty+5);
//                           
//                           mi1=Double.toString(gmf1);
//                           mi2=Double.toString(gmf2);
//                           mi3=Double.toString(gmf3);
//                           mi4=Double.toString(gmf4);
//                           mi5=Double.toString(gmf5);
//                           //mi6=Double.toString(gmf6);
//                           
//                           String hi1=Double.toString(gdf1);
//                           String hi2=Double.toString(gdf2);
//                           String hi3=Double.toString(gdf3);
//                           String hi4=Double.toString(gdf4);
//                           String hi5=Double.toString(gdf5);
//                           //String hi6=Double.toString(gdf6);
//                           
//                           
//                                try {
//                                  
//                                  
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, si1);
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour=add2;  //OLD TIME IN HOUR.
//      
//   //   pst.execute();
//                            
//         
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+hi1+"'  where Name='"+recipenami+"' and Shot='"+si1+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();    
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "2");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin2=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour2=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+hi2+"'  where Name='"+recipenami+"' and Shot='"+"2"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                         
//                                 
//                  try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "3");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin3=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour3=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin3+"', Time_In_Hour='"+oldtimehour3+"', Time_In_Min_Updated='"+mi3+"', Time_In_Hour_Updated='"+hi3+"'  where Name='"+recipenami+"' and Shot='"+"3"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                                 
//                       
//                  
//                                       
//                  try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "4");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin4=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour4=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin4+"', Time_In_Hour='"+oldtimehour4+"', Time_In_Min_Updated='"+mi4+"', Time_In_Hour_Updated='"+hi4+"'  where Name='"+recipenami+"' and Shot='"+"4"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                  
//                  
//                                       
//                  try {
//                            
//                                    
//      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
//      pst = conn.prepareStatement(sqlm);
//      pst.setString(1, recipenami);
//      pst.setString(2, "5");
//      rs = pst.executeQuery();
//      
//      String add1 = rs.getString("Time_In_Min");
//      oldtimemin5=add1;  //OLD TIME IN MINUTES.
//      
//      String add2 = rs.getString("Time_In_Hour");
//      oldtimehour5=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin5+"', Time_In_Hour='"+oldtimehour5+"', Time_In_Min_Updated='"+mi5+"', Time_In_Hour_Updated='"+hi5+"'  where Name='"+recipenami+"' and Shot='"+"5"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                  
////                                       
////                  try {
////                            
////                                    
////      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
////      pst = conn.prepareStatement(sqlm);
////      pst.setString(1, recipenami);
////      pst.setString(2, "6");
////      rs = pst.executeQuery();
////      
////      String add1 = rs.getString("Time_In_Min");
////      oldtimemin3=add1;  //OLD TIME IN MINUTES.
////      
////      String add2 = rs.getString("Time_In_Hour");
////      oldtimehour3=add2;  //OLD TIME IN HOUR.
////      
////     // pst.execute();
////                                     
////          
////                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin6+"', Time_In_Hour='"+oldtimehour6+"', Time_In_Min_Updated='"+mi6+"', Time_In_Hour_Updated='"+hi6+"'  where Name='"+recipenami+"' and Shot='"+"6"+"' ";
////                pst=conn.prepareStatement(sqlp);
////                pst.execute();         
////                                     
////                            
////                            
////                        }
////                        
////                     catch (Exception exception) {
////    } 
////        finally {
////      try {
////        rs.close();
////        pst.close();
////      
////      } catch (Exception exception) {}
////    }                     
////                  
////                  
//                  
//                                 
//                           
//                           
//                       }
//                          
//                          
                          
                        
                          
                          
                          
                          if (bosbos==6) {
                           
                               
                           String mi1,mi2,mi3,mi4,mi5,mi6;
                           String si1,si2,si3,si4,si5,si6;
                           
                           si1=Integer.toString(shoty);
                           si2=Integer.toString(shoty+1);
                           si3=Integer.toString(shoty+2);
                           si4=Integer.toString(shoty+3);
                           si5=Integer.toString(shoty+4);
                           si6=Integer.toString(shoty+5);
                           
                           mi1=Double.toString(gmf1);
                           mi2=Double.toString(gmf2);
                           mi3=Double.toString(gmf3);
                           mi4=Double.toString(gmf4);
                           mi5=Double.toString(gmf5);
                           mi6=Double.toString(gmf6);
                           
                           String hi1=Double.toString(gdf1);
                           String hi2=Double.toString(gdf2);
                           String hi3=Double.toString(gdf3);
                           String hi4=Double.toString(gdf4);
                           String hi5=Double.toString(gdf5);
                           String hi6=Double.toString(gdf6);
                           
                           
                        
                                  try {
                                  
                                  
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, si1);
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour=add2;  //OLD TIME IN HOUR.
      
   //   pst.execute();
                            
         
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+hi1+"'  where Name='"+recipenami+"' and Shot='"+si1+"' ";
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
                            
                                    
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, "2");
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin2=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour2=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+hi2+"'  where Name='"+recipenami+"' and Shot='"+"2"+"' ";
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
                            
                                    
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, "3");
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin3=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour3=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin3+"', Time_In_Hour='"+oldtimehour3+"', Time_In_Min_Updated='"+mi3+"', Time_In_Hour_Updated='"+hi3+"'  where Name='"+recipenami+"' and Shot='"+"3"+"' ";
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
                            
                                    
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, "4");
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin4=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour4=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin4+"', Time_In_Hour='"+oldtimehour4+"', Time_In_Min_Updated='"+mi4+"', Time_In_Hour_Updated='"+hi4+"'  where Name='"+recipenami+"' and Shot='"+"4"+"' ";
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
                            
                                    
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, "5");
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin5=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour5=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin5+"', Time_In_Hour='"+oldtimehour5+"', Time_In_Min_Updated='"+mi5+"', Time_In_Hour_Updated='"+hi5+"'  where Name='"+recipenami+"' and Shot='"+"5"+"' ";
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
                            
                                    
      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
      pst = conn.prepareStatement(sqlm);
      pst.setString(1, recipenami);
      pst.setString(2, "6");
      rs = pst.executeQuery();
      
      String add1 = rs.getString("Time_In_Min");
      oldtimemin3=add1;  //OLD TIME IN MINUTES.
      
      String add2 = rs.getString("Time_In_Hour");
      oldtimehour3=add2;  //OLD TIME IN HOUR.
      
     // pst.execute();
                                     
          
                String sqlp= "update Timer_Three_Shots set Date='"+datevaluey+"', Time_In_Min='"+oldtimemin6+"', Time_In_Hour='"+oldtimehour6+"', Time_In_Min_Updated='"+mi6+"', Time_In_Hour_Updated='"+hi6+"'  where Name='"+recipenami+"' and Shot='"+"6"+"' ";
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
                       


         
         //////////////SROP////////////ppppppppppppppppppppp///////////////////////////////////////
     }
       
       
     else if (fifi.equals("not_found")) {
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
         
//                       if (bosbos==1) {
//                           
//                           
//                                 try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty));
//          pst.setString(5,Double.toString(gmf1));
//          pst.setString(6,Double.toString(gdf1));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                           
//                           
//                           
//                       }
//                       
//                       if (bosbos==2) {
//                           
//                              try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty));
//          pst.setString(5,Double.toString(gmf1));
//          pst.setString(6,Double.toString(gdf1));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+1));
//          pst.setString(5,Double.toString(gmf2));
//          pst.setString(6,Double.toString(gdf2));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                           
//                           
//                           
//                       }
//                       
//        
//         
//          if (bosbos==3) {
//                           
//                              try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty));
//          pst.setString(5,Double.toString(gmf1));
//          pst.setString(6,Double.toString(gdf1));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+1));
//          pst.setString(5,Double.toString(gmf2));
//          pst.setString(6,Double.toString(gdf2));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                           
//                        try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+2));
//          pst.setString(5,Double.toString(gmf3));
//          pst.setString(6,Double.toString(gdf3));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                               
//                                 
//                                 
//                                 
//                                 
//                           
//                       }
//          
//          
//          
//           if (bosbos==4) {
//                           
//                              try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty));
//          pst.setString(5,Double.toString(gmf1));
//          pst.setString(6,Double.toString(gdf1));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+1));
//          pst.setString(5,Double.toString(gmf2));
//          pst.setString(6,Double.toString(gdf2));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                           
//                        try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+2));
//          pst.setString(5,Double.toString(gmf3));
//          pst.setString(6,Double.toString(gdf3));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                               
//                   
//                        
//                                 try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+3));
//          pst.setString(5,Double.toString(gmf4));
//          pst.setString(6,Double.toString(gdf4));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }
//                                 
//                                 
////                                 
////                                          try {
////                            
////          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
////          pst = conn.prepareStatement(reg);
////          pst.setString(1,datevaluey);
////          pst.setString(2,modelooo);
////          pst.setString(3,recipenami);
////          pst.setString(4,Integer.toString(shoty+4));
////          pst.setString(5,Double.toString(gmf5));
////          pst.setString(6,Double.toString(gdf5));
////          pst.setString(7,"Hasnot_Updated_Yet");
////          pst.setString(8,"Hasnot_Updated_Yet");
////          pst.execute();
////                            
////                            
////                        }
////                        
////                     catch (Exception exception) {
////    } 
////        finally {
////      try {
////        rs.close();
////        pst.close();
////      
////      } catch (Exception exception) {}
////    }
////                                          
////                                          
////                                          
////                                                   try {
////                            
////          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
////          pst = conn.prepareStatement(reg);
////          pst.setString(1,datevaluey);
////          pst.setString(2,modelooo);
////          pst.setString(3,recipenami);
////          pst.setString(4,Integer.toString(shoty+5));
////          pst.setString(5,Double.toString(gmf6));
////          pst.setString(6,Double.toString(gdf6));
////          pst.setString(7,"Hasnot_Updated_Yet");
////          pst.setString(8,"Hasnot_Updated_Yet");
////          pst.execute();
////                            
////                            
////                        }
////                        
////                     catch (Exception exception) {
////    } 
////        finally {
////      try {
////        rs.close();
////        pst.close();
////      
////      } catch (Exception exception) {}
////    }
////                                 
////                                 
//                                 
//                           
//                       }
//          
//          
//           if (bosbos==5) {
//                           
//                              try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty));
//          pst.setString(5,Double.toString(gmf1));
//          pst.setString(6,Double.toString(gdf1));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+1));
//          pst.setString(5,Double.toString(gmf2));
//          pst.setString(6,Double.toString(gdf2));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                           
//                        try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+2));
//          pst.setString(5,Double.toString(gmf3));
//          pst.setString(6,Double.toString(gdf3));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                               
//                                try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+3));
//          pst.setString(5,Double.toString(gmf4));
//          pst.setString(6,Double.toString(gdf4));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }
//                                      
//                                 
//                                            
//                                          try {
//                            
//          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo);
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+4));
//          pst.setString(5,Double.toString(gmf5));
//          pst.setString(6,Double.toString(gdf5));
//          pst.setString(7,"Hasnot_Updated_Yet");
//          pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }
//                                          
//                                          
////                                          
////                                                   try {
////                            
////          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
////          pst = conn.prepareStatement(reg);
////          pst.setString(1,datevaluey);
////          pst.setString(2,modelooo);
////          pst.setString(3,recipenami);
////          pst.setString(4,Integer.toString(shoty+5));
////          pst.setString(5,Double.toString(gmf6));
////          pst.setString(6,Double.toString(gdf6));
////          pst.setString(7,"Hasnot_Updated_Yet");
////          pst.setString(8,"Hasnot_Updated_Yet");
////          pst.execute();
////                            
////                            
////                        }
////                        
////                     catch (Exception exception) {
////    } 
////        finally {
////      try {
////        rs.close();
////        pst.close();
////      
////      } catch (Exception exception) {}
////    }
////                                 
////                         
//                                 
//                           
//                       }
           
           
            if (bosbos==6) {
                           
                              try {
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty));
          pst.setString(5,Double.toString(gmf1));
          pst.setString(6,Double.toString(gdf1));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+1));
          pst.setString(5,Double.toString(gmf2));
          pst.setString(6,Double.toString(gdf2));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+2));
          pst.setString(5,Double.toString(gmf3));
          pst.setString(6,Double.toString(gdf3));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+3));
          pst.setString(5,Double.toString(gmf4));
          pst.setString(6,Double.toString(gdf4));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+4));
          pst.setString(5,Double.toString(gmf5));
          pst.setString(6,Double.toString(gdf5));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
                            
          String reg = "insert into Timer_Three_Shots (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated) values (?,?,?,?,?,?,?,?)";
          pst = conn.prepareStatement(reg);
          pst.setString(1,datevaluey);
          pst.setString(2,modelooo);
          pst.setString(3,recipenami);
          pst.setString(4,Integer.toString(shoty+5));
          pst.setString(5,Double.toString(gmf6));
          pst.setString(6,Double.toString(gdf6));
          pst.setString(7,"Hasnot_Updated_Yet");
          pst.setString(8,"Hasnot_Updated_Yet");
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
          
          
          
         ///////////STOP///////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
     }
       
     
     else {}
       
       
      
      ////////////////////////////////END DB////////////////////////////////////////////////////
    
    
}

else {

//PILOT



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
           
                    String sql0 = "select * from Timer_Pilot where Name like '" + recipenami + "' and Model like '" + modelooo.replace(NewDir.file_dir+"\\PILOT\\","") + "' ";
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
         
                             
//                          if (bosbos==1) {
//                              
//                           String ti1,ti2;
//                           String ti3,ti4;
//                           ti4=Integer.toString(shoty+1);
//                           ti3=Integer.toString(shoty);
//                           ti1=Double.toString(gdf1);
//                           ti2=Double.toString(gdf2);
//                           String mi1=Double.toString(gmf1);
//                           String mi2=Double.toString(gmf2);
//                           
//                                 try {
//       
//                                     
//                                                 
////      String sqlm = "select * from Timer_Three_Shots where Name=?";
////      pst = conn.prepareStatement(sqlm);
////      pst.setString(1, recipenami);
////      rs = pst.executeQuery();
////      
////      String add1 = rs.getString("Time_In_Min");
////      oldtimemin=add1;  //OLD TIME IN MINUTES.
////      
////      String add2 = rs.getString("Time_In_Hour");
////      oldtimehour=add2;  //OLD TIME IN HOUR.
//      
//      
//             
//                                     
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();
//                                     
//     
//                
//                
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                           
//                           
//                           
//                       }
//                       
//                       if (bosbos==2) {
//                           
//                               
//                           String ti1,ti2;
//                           String ti3,ti4;
//                           ti4=Integer.toString(shoty+1);
//                           ti3=Integer.toString(shoty);
//                           ti1=Double.toString(gdf1);
//                           ti2=Double.toString(gdf2);
//                           String mi1=Double.toString(gmf1);
//                           String mi2=Double.toString(gmf2);
//                           
//                           
//                              try {
//                                  
//                                  
////      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
////      pst = conn.prepareStatement(sqlm);
////      pst.setString(1, recipenami);
////      pst.setString(2, ti3);
////      rs = pst.executeQuery();
////      
////      String add1 = rs.getString("Time_In_Min");
////      oldtimemin=add1;  //OLD TIME IN MINUTES.
////      
////      String add2 = rs.getString("Time_In_Hour");
////      oldtimehour=add2;  //OLD TIME IN HOUR.
////      
//   //   pst.execute();
//                            
//         
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();    
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//                                    
////      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
////      pst = conn.prepareStatement(sqlm);
////      pst.setString(1, filenammm);
////      pst.setString(2, ti4);
////      rs = pst.executeQuery();
////      
////      String add1 = rs.getString("Time_In_Min");
////      oldtimemin2=add1;  //OLD TIME IN MINUTES.
////      
////      String add2 = rs.getString("Time_In_Hour");
////      oldtimehour2=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi2+"', Time_In_Hour='"+ti2+"' where Name='"+recipenami+"' and Shot='"+ti4+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                           
//                           
//                           
//                       }
//                       
//         
//                       
//                       
//                          if (bosbos==3) {
//                           
//                               
//                           String ti1,ti2;
//                           String ti3,ti4,ti5,ti6;
//                           ti4=Integer.toString(shoty+1);
//                           ti5=Integer.toString(shoty+2);
//                           ti3=Integer.toString(shoty);
//                           ti1=Double.toString(gdf1);
//                           ti2=Double.toString(gdf2);
//                           ti6=Double.toString(gdf3);
//                           
//                           
//                           String mi1=Double.toString(gmf1);
//                           String mi2=Double.toString(gmf2);
//                           String mi3=Double.toString(gmf3);
//                           
//                           
//                              try {
//                                  
//                                  
////      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
////      pst = conn.prepareStatement(sqlm);
////      pst.setString(1, recipenami);
////      pst.setString(2, ti3);
////      rs = pst.executeQuery();
////      
////      String add1 = rs.getString("Time_In_Min");
////      oldtimemin=add1;  //OLD TIME IN MINUTES.
////      
////      String add2 = rs.getString("Time_In_Hour");
////      oldtimehour=add2;  //OLD TIME IN HOUR.
//      
//   //   pst.execute();
//                            
//         
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+ti1+"' where Name='"+recipenami+"' and Shot='"+ti3+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();    
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//                                    
////      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
////      pst = conn.prepareStatement(sqlm);
////      pst.setString(1, recipenami);
////      pst.setString(2, "2");
////      rs = pst.executeQuery();
////      
////      String add1 = rs.getString("Time_In_Min");
////      oldtimemin2=add1;  //OLD TIME IN MINUTES.
////      
////      String add2 = rs.getString("Time_In_Hour");
////      oldtimehour2=add2;  //OLD TIME IN HOUR.
////      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi2+"', Time_In_Hour='"+ti2+"' where Name='"+recipenami+"' and Shot='"+"2"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                         
//                                 
//                  try {
//                            
//                                    
////      String sqlm = "select * from Timer_Three_Shots where Name=? and Shot=?";
////      pst = conn.prepareStatement(sqlm);
////      pst.setString(1, recipenami);
////      pst.setString(2, "3");
////      rs = pst.executeQuery();
////      
////      String add1 = rs.getString("Time_In_Min");
////      oldtimemin3=add1;  //OLD TIME IN MINUTES.
////      
////      String add2 = rs.getString("Time_In_Hour");
////      oldtimehour3=add2;  //OLD TIME IN HOUR.
//      
//     // pst.execute();
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi3+"', Time_In_Hour='"+ti6+"' where Name='"+recipenami+"' and Shot='"+"3"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                                 
//                           
//                           
//                       }
//                      
//                          
//                          
//                                if (bosbos==4) {
//                           
//                               
//                           String mi1,mi2,mi3,mi4,mi5,mi6;
//                           String si1,si2,si3,si4,si5,si6;
//                           
//                           si1=Integer.toString(shoty);
//                           si2=Integer.toString(shoty+1);
//                           si3=Integer.toString(shoty+2);
//                           si4=Integer.toString(shoty+3);
//                           //si5=Integer.toString(shoty+4);
//                           //si6=Integer.toString(shoty+5);
//                           
//                           mi1=Double.toString(gmf1);
//                           mi2=Double.toString(gmf2);
//                           mi3=Double.toString(gmf3);
//                           mi4=Double.toString(gmf4);
//                           //mi5=Double.toString(gmf5);
//                           //mi6=Double.toString(gmf6);
//                           
//                           String hi1=Double.toString(gdf1);
//                           String hi2=Double.toString(gdf2);
//                           String hi3=Double.toString(gdf3);
//                           String hi4=Double.toString(gdf4);
//                           //String hi5=Double.toString(gdf5);
//                           //String hi6=Double.toString(gdf6);      
//                           
//                           
//                              try {
//                                  
//                                  
//      
//         
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+hi1+"' where Name='"+recipenami+"' and Shot='"+si1+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();    
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//                                    
//
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi2+"', Time_In_Hour='"+hi2+"' where Name='"+recipenami+"' and Shot='"+"2"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                         
//                                 
//                  try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi3+"', Time_In_Hour='"+hi3+"' where Name='"+recipenami+"' and Shot='"+"3"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                  
//                  
//                   try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi4+"', Time_In_Hour='"+hi4+"' where Name='"+recipenami+"' and Shot='"+"4"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                   
//                   
////                    try {
////                            
////                                    
////                                     
////          
////                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi5+"', Time_In_Hour='"+hi5+"' where Name='"+recipenami+"' and Shot='"+"5"+"' ";
////                pst=conn.prepareStatement(sqlp);
////                pst.execute();         
////                                     
////                            
////                            
////                        }
////                        
////                     catch (Exception exception) {
////    } 
////        finally {
////      try {
////        rs.close();
////        pst.close();
////      
////      } catch (Exception exception) {}
////    }                     
////                    
////                     try {
////                            
////                                    
////                                     
////          
////                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi6+"', Time_In_Hour='"+hi6+"' where Name='"+recipenami+"' and Shot='"+"6"+"' ";
////                pst=conn.prepareStatement(sqlp);
////                pst.execute();         
////                                     
////                            
////                            
////                        }
////                        
////                     catch (Exception exception) {
////    } 
////        finally {
////      try {
////        rs.close();
////        pst.close();
////      
////      } catch (Exception exception) {}
////    }                     
////                                 
////                        
//                     
//                     
//                     
//                           
//                       }
//                                
//                                
//                                
//                                  
//                                if (bosbos==5) {
//                           
//                               
//                           String mi1,mi2,mi3,mi4,mi5,mi6;
//                           String si1,si2,si3,si4,si5,si6;
//                           
//                           si1=Integer.toString(shoty);
//                           si2=Integer.toString(shoty+1);
//                           si3=Integer.toString(shoty+2);
//                           si4=Integer.toString(shoty+3);
//                           si5=Integer.toString(shoty+4);
//                           si6=Integer.toString(shoty+5);
//                           
//                           mi1=Double.toString(gmf1);
//                           mi2=Double.toString(gmf2);
//                           mi3=Double.toString(gmf3);
//                           mi4=Double.toString(gmf4);
//                           mi5=Double.toString(gmf5);
//                           mi6=Double.toString(gmf6);
//                           
//                           String hi1=Double.toString(gdf1);
//                           String hi2=Double.toString(gdf2);
//                           String hi3=Double.toString(gdf3);
//                           String hi4=Double.toString(gdf4);
//                           String hi5=Double.toString(gdf5);
//                           String hi6=Double.toString(gdf6);      
//                           
//                           
//                              try {
//                                  
//                                  
//      
//         
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+hi1+"' where Name='"+recipenami+"' and Shot='"+si1+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();    
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//                                    
//
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi2+"', Time_In_Hour='"+hi2+"' where Name='"+recipenami+"' and Shot='"+"2"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                         
//                                 
//                  try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi3+"', Time_In_Hour='"+hi3+"' where Name='"+recipenami+"' and Shot='"+"3"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                  
//                  
//                   try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi4+"', Time_In_Hour='"+hi4+"' where Name='"+recipenami+"' and Shot='"+"4"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                   
//                   
//                    try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi5+"', Time_In_Hour='"+hi5+"' where Name='"+recipenami+"' and Shot='"+"5"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
////                    
////                     try {
////                            
////                                    
////                                     
////          
////                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi6+"', Time_In_Hour='"+hi6+"' where Name='"+recipenami+"' and Shot='"+"6"+"' ";
////                pst=conn.prepareStatement(sqlp);
////                pst.execute();         
////                                     
////                            
////                            
////                        }
////                        
////                     catch (Exception exception) {
////    } 
////        finally {
////      try {
////        rs.close();
////        pst.close();
////      
////      } catch (Exception exception) {}
////    }                     
////                                 
////                        
//                     
//                     
//                     
//                           
//                       }
                                
                                
//                                  
//                                if (bosbos==6) {
//                           
//                               
//                           String mi1,mi2,mi3,mi4,mi5,mi6;
//                           String si1,si2,si3,si4,si5,si6;
//                           
//                           si1=Integer.toString(shoty);
//                           si2=Integer.toString(shoty+1);
//                           si3=Integer.toString(shoty+2);
//                           si4=Integer.toString(shoty+3);
//                           si5=Integer.toString(shoty+4);
//                           si6=Integer.toString(shoty+5);
//                           
//                           mi1=Double.toString(gmf1);
//                           mi2=Double.toString(gmf2);
//                           mi3=Double.toString(gmf3);
//                           mi4=Double.toString(gmf4);
//                           mi5=Double.toString(gmf5);
//                           mi6=Double.toString(gmf6);
//                           
//                           String hi1=Double.toString(gdf1);
//                           String hi2=Double.toString(gdf2);
//                           String hi3=Double.toString(gdf3);
//                           String hi4=Double.toString(gdf4);
//                           String hi5=Double.toString(gdf5);
//                           String hi6=Double.toString(gdf6);      
//                           
//                           
//                              try {
//                                  
//                                  
//      
//         
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi1+"', Time_In_Hour='"+hi1+"' where Name='"+recipenami+"' and Shot='"+si1+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();    
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//                                    
//
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi2+"', Time_In_Hour='"+hi2+"' where Name='"+recipenami+"' and Shot='"+"2"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                         
//                                 
//                  try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi3+"', Time_In_Hour='"+hi3+"' where Name='"+recipenami+"' and Shot='"+"3"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                  
//                  
//                   try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi4+"', Time_In_Hour='"+hi4+"' where Name='"+recipenami+"' and Shot='"+"4"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                   
//                   
//                    try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi5+"', Time_In_Hour='"+hi5+"' where Name='"+recipenami+"' and Shot='"+"5"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                    
//                     try {
//                            
//                                    
//                                     
//          
//                String sqlp= "update Timer_Pilot set Date='"+datevaluey+"', Time_In_Min='"+mi6+"', Time_In_Hour='"+hi6+"' where Name='"+recipenami+"' and Shot='"+"6"+"' ";
//                pst=conn.prepareStatement(sqlp);
//                pst.execute();         
//                                     
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }                     
//                                 
//                        
//                     
//                     
//                     
//                           
//                       }
                          
                          
//           String mi1,mi2,mi3,mi4,mi5,mi6;
//                           String si1,si2,si3,si4,si5,si6;
//                           
//                           si1=Integer.toString(shoty);
//                           si2=Integer.toString(shoty+1);
//                           si3=Integer.toString(shoty+2);
//                           si4=Integer.toString(shoty+3);
//                           si5=Integer.toString(shoty+4);
//                           si6=Integer.toString(shoty+5);
//                           
//                           mi1=Double.toString(gmf1);
//                           mi2=Double.toString(gmf2);
//                           mi3=Double.toString(gmf3);
//                           mi4=Double.toString(gmf4);
//                           mi5=Double.toString(gmf5);
//                           mi6=Double.toString(gmf6);
//                           
//                           String hi1=Double.toString(gdf1);
//                           String hi2=Double.toString(gdf2);
//                           String hi3=Double.toString(gdf3);
//                           String hi4=Double.toString(gdf4);
//                           String hi5=Double.toString(gdf5);
//                           String hi6=Double.toString(gdf6);               
                          
                       


         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
     }
       
       
     else if (fifi.equals("not_found")) {
         
         
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
         
//                       if (bosbos==1) {
//                           
//                           
//                                 try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty));
//          pst.setString(5,Double.toString(gmf1));
//          pst.setString(6,Double.toString(gdf1));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                           
//                           
//                           
//                       }
//                       
//                       if (bosbos==2) {
//                           
//                              try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty));
//          pst.setString(5,Double.toString(gmf1));
//          pst.setString(6,Double.toString(gdf1));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+1));
//          pst.setString(5,Double.toString(gmf2));
//          pst.setString(6,Double.toString(gdf2));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                           
//                           
//                           
//                       }
//                       
//        
//         
//          if (bosbos==3) {
//                           
//                              try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty));
//          pst.setString(5,Double.toString(gmf1));
//          pst.setString(6,Double.toString(gdf1));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+1));
//          pst.setString(5,Double.toString(gmf2));
//          pst.setString(6,Double.toString(gdf2));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                           
//                        try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+2));
//          pst.setString(5,Double.toString(gmf3));
//          pst.setString(6,Double.toString(gdf3));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                               
//                                 
//                                 
//                                 
//                                 
//                           
//                       }
//          
//          
//          
//            if (bosbos==4) {
//                           
//                              try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty));
//          pst.setString(5,Double.toString(gmf1));
//          pst.setString(6,Double.toString(gdf1));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+1));
//          pst.setString(5,Double.toString(gmf2));
//          pst.setString(6,Double.toString(gdf2));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                           
//                        try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+2));
//          pst.setString(5,Double.toString(gmf3));
//          pst.setString(6,Double.toString(gdf3));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                               
//                                 
//                   try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+3));
//          pst.setString(5,Double.toString(gmf4));
//          pst.setString(6,Double.toString(gdf4));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                   
//                   
//                   try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+4));
//          pst.setString(5,Double.toString(gmf5));
//          pst.setString(6,Double.toString(gdf5));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                   
//                   
//                   try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+5));
//          pst.setString(5,Double.toString(gmf6));
//          pst.setString(6,Double.toString(gdf6));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                                 
//                                 
//                           
//                       }
//            
//            
//            
//          
//            if (bosbos==5) {
//                           
//                              try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty));
//          pst.setString(5,Double.toString(gmf1));
//          pst.setString(6,Double.toString(gdf1));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+1));
//          pst.setString(5,Double.toString(gmf2));
//          pst.setString(6,Double.toString(gdf2));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                           
//                        try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+2));
//          pst.setString(5,Double.toString(gmf3));
//          pst.setString(6,Double.toString(gdf3));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                               
//                                 
//                   try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+3));
//          pst.setString(5,Double.toString(gmf4));
//          pst.setString(6,Double.toString(gdf4));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                   
//                   
//                   try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+4));
//          pst.setString(5,Double.toString(gmf5));
//          pst.setString(6,Double.toString(gdf5));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                   
//                   
//                   try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+5));
//          pst.setString(5,Double.toString(gmf6));
//          pst.setString(6,Double.toString(gdf6));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                                 
//                                 
//                           
//                       }
            
            
            
//          
//            if (bosbos==6) {
//                           
//                              try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty));
//          pst.setString(5,Double.toString(gmf1));
//          pst.setString(6,Double.toString(gdf1));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                              
//                                 try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+1));
//          pst.setString(5,Double.toString(gmf2));
//          pst.setString(6,Double.toString(gdf2));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                           
//                           
//                        try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+2));
//          pst.setString(5,Double.toString(gmf3));
//          pst.setString(6,Double.toString(gdf3));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                               
//                                 
//                   try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+3));
//          pst.setString(5,Double.toString(gmf4));
//          pst.setString(6,Double.toString(gdf4));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                   
//                   
//                   try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+4));
//          pst.setString(5,Double.toString(gmf5));
//          pst.setString(6,Double.toString(gdf5));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                   
//                   
//                   try {
//                            
//          String reg = "insert into Timer_Pilot (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour) values (?,?,?,?,?,?)";
//          pst = conn.prepareStatement(reg);
//          pst.setString(1,datevaluey);
//          pst.setString(2,modelooo.replace(NewDir.file_dir+"\\PILOT\\",""));
//          pst.setString(3,recipenami);
//          pst.setString(4,Integer.toString(shoty+5));
//          pst.setString(5,Double.toString(gmf6));
//          pst.setString(6,Double.toString(gdf6));
//          //pst.setString(7,"Hasnot_Updated_Yet");
//          //pst.setString(8,"Hasnot_Updated_Yet");
//          pst.execute();
//                            
//                            
//                        }
//                        
//                     catch (Exception exception) {
//    } 
//        finally {
//      try {
//        rs.close();
//        pst.close();
//      
//      } catch (Exception exception) {}
//    }    
//                                 
//                                 
//                           
//                       }
          
          
          
         //////////////////////////ppppppppppppppppppppp///////////////////////////////////////
         
         
     }
       
     
     else {}
       
       
      
      ////////////////////////////////END DB////////////////////////////////////////////////////


}


       

} 
else {}
        
        
  
        //////////////////////////////////////////////////////////////////////////////////
        
        
                  
                  
                  
                  
                  
                 
                  
     
    }
                        
              
    
        
            
    //End dodo       
    
    else {
        
        //Noti
        
//      Notifications noti = Notifications.create();
//      noti.title("Cancel!");
//      noti.text("Operation Cancelled, We don't have 3 shots in one recipe.\nWe are working on this feature");
//      noti.position(Pos.CENTER);
//      noti.hideAfter(Duration.seconds(3));
//      noti.showError();
    }
    
    
    /////////////////////////////////////////////Ending////////////////////////////////////////////////////////////
   
    




        
        
    }
    
    
    
    
}
