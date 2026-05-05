


package kadysoft.kady;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.ObservableList;
import org.controlsfx.control.Notifications;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author ahmed.elkady
 */
public class testchemicals {
  
public static void main(String[] args) throws IOException {
        
    
     
    
List<Double> pri = new ArrayList<>();
List<Double> qua = new ArrayList<>();
List<Double> dil = new ArrayList<>();
////////////////////////////////////////////////
File inputFile = new File("8307_400.ks"); //
Document docj = Jsoup.parse(inputFile, "UTF-8"); //
//Document docj = Jsoup.parse(codee);
for (Element table : docj.select("TABLE")) {
for (Element row : table.select("TR")) {
Elements tds = row.select("TD");
if (tds.get(8).text().isEmpty()) {   
}
else {  
String string=tds.get(8).text();
BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Prices.kady"));
String line;
String linebeforeequal;
String lineafterequal;
while ((line=buf.readLine())!=null) {       
linebeforeequal=line.substring(0,line.indexOf("=$")-0);  //Item
lineafterequal=line.substring(line.indexOf("=$") + 2 , line.length());  //Price
if (string.equals(linebeforeequal)) {
double number1 = Double.parseDouble(lineafterequal);
pri.add(number1);    
break;
}
else {}
}
buf.close();
}          
//////////////////////KG//////////////////////////  
if (tds.get(5).text().isEmpty()||tds.get(5).text().contains("/")||tds.get(5).text().contains("\\")||tds.get(5).text().contains("OPERATPR")||tds.get(5).text().contains("OPERATOR")||tds.get(5).text().contains("AMOUNT")||tds.get(5).text().contains("AMT")||tds.get(5).text().contains("-")||tds.get(5).text().contains("DATE")||tds.get(5).text().contains("WASH")||tds.get(5).text().contains("WASH NAME")) {}
else if (tds.get(6).text().contains("GR")||tds.get(6).text().contains("Gr")||tds.get(6).text().contains("gr")) {
double am=(Double.parseDouble(tds.get(5).text().replace(",","."))/1000);
String amm=Double.toString(am);
if (amm.contains("E")) { 
BigDecimal bd = new BigDecimal(amm);
double val = bd.doubleValue();
qua.add(val);   
}
else {
qua.add(am);
}
}
else if (tds.get(6).text().contains("GARDAL")||tds.get(6).text().contains("GARDEL")
||tds.get(6).text().contains("Gardal")||tds.get(6).text().contains("Gardel")||tds.get(6).text().contains("gardal")||tds.get(6).text().contains("gardel")) {
double am=Double.parseDouble(tds.get(5).text().replace(",","."))*12;
qua.add(am);   
}
else {
double number2 = Double.parseDouble(tds.get(5).text());
qua.add(number2);
}
//////////////////////////////////////////////
if (tds.get(8).text().isEmpty()||tds.get(8).text().contains("/")||tds.get(8).text().contains("\\")||tds.get(8).text().contains("CHEMICAL")||tds.get(8).text().contains("chemical")||tds.get(8).text().matches("[0-9_-]+")||tds.get(8).text().contains("TIME")||tds.get(8).text().contains("HOURS")||tds.get(8).text().contains("MINS")||tds.get(8).text().contains("SHOT")) {    
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
dil.add(number3);
found = true;
break;
}
}
if (!found) {
double number3 = Double.parseDouble("1.0");
dil.add(number3);
}
buf.close();
}
///////////////////////////////////////////////
}}    
if (qua.size()!=pri.size()||qua.size()!=dil.size()) { 
System.out.println("Maybe chemicals errors");   
}
else {
//Show alert to write pcs.    
List<Double> result = new ArrayList<>();
for (int i = 0; i < qua.size(); i++) {
result.add(qua.get(i) * dil.get(i)* pri.get(i));
}
double sum = 0.0;
for (double number : result) {
sum += number;
}
System.out.println(sum/120);
}






    }
    
}
