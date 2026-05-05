//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import java.io.*;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.text.DateFormat;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
//public class SHOTSANDCOST {
//    
//    public static String pecoco,find;
//    Connection conn = null;
//    ResultSet rs = null;
//    PreparedStatement pst = null;
//    
//
//    static class Shot {
//      
//        List<String> chemicals = new ArrayList<>();
//        List<Double> quantities = new ArrayList<>();
//        List<Double> prices = new ArrayList<>();
//        List<Double> dilutions = new ArrayList<>();
//        
//        double calculateCost() {
//            double total = 0.0;
//            for (int i = 0; i < quantities.size(); i++) {
//                total += (quantities.get(i) / dilutions.get(i)) * prices.get(i);
//            }
//            return total;
//        }
//
//        void printDetails(int shotIndex, double pcs) {
//            double shotCost = calculateCost();
//            double perGarment = pcs > 0 ? shotCost / pcs : 0;
//
//            System.out.println("\nشوت :"+ shotIndex);
//            System.out.println("   التكلفة الكلية للشوت     :"+ shotCost);
//            System.out.println("   تكلفة الغارمنت الواحد    :"+ perGarment);
////            System.out.println("   ┌──────────────────────────────────────────────┐");
////
////            if (chemicals.isEmpty()) {
////                System.out.println("   │          لا توجد كيماويات في هذا الشوت          │");
////            } else {
////                for (int i = 0; i < chemicals.size(); i++) {
////                    System.out.printf("   │ %-20s │ Qty: %8.4f │ P: %6.4f │ D: %5.2f │%n",
////                            chemicals.get(i),
////                            quantities.get(i),
////                            prices.get(i),
////                            dilutions.get(i));
////                }
////            }
////            System.out.println("   └──────────────────────────────────────────────┘");
//        }
//    }
//
//    public static void main(String[] args) {
//        //conn = db.java_db();
//        try {
//            File originalFile = new File("C:\\Users\\Ahmed.ElKady\\Desktop\\ddd\\CAROLINE_WASH_781032.ks");
//            if (!originalFile.exists()) {
//                System.out.println("الملف غير موجود: " + originalFile.getAbsolutePath());
//                return;
//            }
//
//            // 1. تنظيف الملف مرة واحدة
//            String cleanedContent = cleanSpecialCharacters(originalFile);
//            File cleanedFile = new File("C:\\Users\\Ahmed.ElKady\\Desktop\\ddd\\CAROLINE_WASH_781032.ks");
//
//            try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(
//                    new FileOutputStream(cleanedFile), "UTF-8"))) {
//                writer.print(cleanedContent);
//            }
//
//            // 2. قراءة الملف المنظف
//            Document doc = Jsoup.parse(cleanedFile, "UTF-8");
//
//            List<Shot> shots = new ArrayList<>();
//            Shot currentShot = new Shot();  // نبدأ بشوت أول مباشرة
//
//            for (Element table : doc.select("table")) {
//                for (Element row : table.select("tr")) {
//                    Elements cells = row.select("td");
//                    if (cells.size() < 9) continue;
//
//                    String action = cells.get(3).text().trim();
//                    String amountStr = cells.get(5).text().trim();
//                    String unit = cells.get(6).text().trim().toUpperCase();
//                    String chemical = cells.get(8).text().trim();
//
//                    String actionUpper = action.toUpperCase();
//
//                    // إذا وجدنا EXTRACT → ننهي الشوت الحالي ونبدأ واحد جديد
//                    if (actionUpper.contains("EXTRACT") ||
//                        actionUpper.contains("EXTRACTION") ||
//                        actionUpper.contains("EXTRA")) {
//
//                        // حفظ الشوت الحالي إذا فيه بيانات
//                        if (!currentShot.quantities.isEmpty()) {
//                            shots.add(currentShot);
//                        }
//
//                        // بدء شوت جديد
//                        currentShot = new Shot();
//                        //currentShot.name = action.trim();
//                        continue;
//                    }
//
//                    // تخطي صفوف غير صالحة للكيماويات
//                    if (amountStr.isEmpty() || amountStr.contains("/") || amountStr.contains("\\") ||
//                        amountStr.contains("AMT") || amountStr.contains("DATE") || amountStr.contains("WASH") ||
//                        chemical.isEmpty() || chemical.contains("CHEMICAL") || chemical.contains("TIME") ||
//                        chemical.contains("OLD STONE") || chemical.matches("[0-9_-]+")) {
//                        continue;
//                    }
//
//                    // معالجة الكمية
//                    double quantity = parseQuantity(amountStr, unit, chemical);
//                    if (quantity <= 0) continue;
//
//                    double price = getPrice(chemical);
//                    if (price <= 0) continue;
//
//                    double dilution = getDilution(chemical);
//
//                    // إضافة للشوت الحالي
//                    currentShot.chemicals.add(chemical);
//                    currentShot.quantities.add(quantity);
//                    currentShot.prices.add(price);
//                    currentShot.dilutions.add(dilution);
//                }
//            }
//
//            
//            ////////////////////////////////////////////////////////////////////////////////////////////
//
//            // Find all table rows
//            Elements rows = doc.select("tr");
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
//            
//            
//            // حفظ آخر شوت إذا فيه بيانات
//            if (!currentShot.quantities.isEmpty()) {
//                shots.add(currentShot);
//            }
//
//            System.out.println(shots.size() +"   Shots");
//
//            if (shots.isEmpty()) {
//                System.out.println("لم يتم العثور على أي كيماويات صالحة في الريسيبي");
//                return;
//            }
//
//            double grandTotal = 0.0;
//            double pcs = Double.parseDouble(pecoco);
//
//            for (int i = 0; i < shots.size(); i++) {
//                shots.get(i).printDetails(i + 1, pcs);
//                grandTotal += shots.get(i).calculateCost();
//            }
//
//            
//            System.out.println("إجمالي تكلفة الريسيبي كاملاً     : "+ grandTotal);
//            System.out.println("تكلفة الغارمنت الواحد (كل الشوتات): "+ grandTotal / pcs);
//            
//
//        } catch (Exception e) {
//            System.err.println("حدث خطأ: " + e.getMessage());
//            e.printStackTrace();
//        }
//    }
//
//
////Save To DB Here.
//Date currentDate1 = GregorianCalendar.getInstance().getTime();
//DateFormat df1 = DateFormat.getDateInstance();
//String dateString1 = df1.format(currentDate1);
//Date d1 = new Date();
//SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
//String timeString1 = sdf1.format(d1);
//SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
//String dateString2 = sdf2.format(d1);
//String alldaty=dateString2+" \\ "+timeString1;
//try {
//String sql0 = "select * from Cost where Name like '" + recipenami + "' and Model like '" + modelooo + "' ";
//pst = conn.prepareStatement(sql0);
//rs = pst.executeQuery();                    
//if (rs.next()) {                        
////Update
//find="found";   
//}                    
//else {
////Insert
//find="not_found";   
//}        
//}catch (Exception exception) {
//} 
//finally {
//try {
//rs.close();
//pst.close();     
//} catch (Exception exception) {}
//}
//if (find.equals("found")) {
//try {
//String sqlm = "select * from Cost where Name=? and Model=?";
//pst = conn.prepareStatement(sqlm);
//pst.setString(1, recipenami);
//pst.setString(2, modelooo);
//rs = pst.executeQuery();      
//String addd1 = rs.getString("Total_Cost_Old");
//oldtotalcost=addd1;
//String addd2 = rs.getString("PCS_Old");
//oldpcs=addd2;      
//String addd3 = rs.getString("One_Garment_Old");
//oldonegarmentcost=addd3;
//
//String sqlp= "update Cost set Date='"+dateString2+"', Total_Cost_Old='"+oldtotalcost+"', PCS_Old='"+oldpcs+"', One_Garment_Old='"+oldonegarmentcost+"', Total_Cost_New='"+Double.toString(sum)+"', PCS_New='"+Double.toString(pcsnum)+"', One_Garment_New='"+Double.toString(onegar)+"' where Name='"+recipenami+"'";
//pst=conn.prepareStatement(sqlp);
//pst.execute();
//}                        
//catch (Exception exception) {
//} 
//finally {
//try {
//rs.close();
//pst.close();
//Notifications noti = Notifications.create();
//noti.title("Successful");
//noti.text("We have updated the cost successfully.");
//noti.hideAfter(Duration.seconds(3));
//noti.position(Pos.CENTER);
//noti.showInformation();
//} catch (Exception exception) {}
//}                               
//}
//else if (find.equals("not_found")) {
//try {                            
//String reg = "insert into Cost (Date, Model, Name, Total_Cost_Old, PCS_Old, One_Garment_Old, Total_Cost_New, PCS_New, One_Garment_New) values (?,?,?,?,?,?,?,?,?)";
//pst = conn.prepareStatement(reg);
//pst.setString(1,dateString2);
//pst.setString(2,modelooo);
//pst.setString(3,recipenami);
//
//pst.setString(4,Double.toString(sum));
//pst.setString(5,Double.toString(pcsnum));
//pst.setString(6,Double.toString(onegar));
//
//pst.setString(7,"Hasnot_Updated_Yet");
//pst.setString(8,"Hasnot_Updated_Yet");
//pst.setString(9,"Hasnot_Updated_Yet");
//
//pst.execute(); 
//}                                            
//catch (Exception exception) {
//} 
//finally {
//try {
//rs.close();
//pst.close();
//Notifications noti = Notifications.create();
//noti.title("Successful");
//noti.text("We have inserted the new cost successfully.");
//noti.hideAfter(Duration.seconds(3));
//noti.position(Pos.CENTER);
//noti.showInformation();
//} catch (Exception exception) {}
//}                               
//}
//else{}
//    
//
//
//
//
//
//
//
//
//
//
//
//    
////    private static String cleanSpecialCharacters(File file) throws IOException {
////        StringBuilder sb = new StringBuilder();
////        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
////            String line;
////            while ((line = br.readLine()) != null) {
////                line = line
////                        .replace("ﬦ","A").replace("ﬧ","B").replace("ﬨ","C").replace("﬩","D")
////                        .replace("שׁ","E").replace("שׂ","F").replace("שּׁ","G").replace("שּׂ","H")
////                        .replace("אַ","I").replace("אָ","J").replace("אּ","K").replace("בּ","L")
////                        .replace("גּ","M").replace("דּ","N").replace("הּ","O").replace("וּ","P")
////                        .replace("זּ","Q").replace("טּ","R").replace("יּ","S").replace("ךּ","T")
////                        .replace("כּ","U").replace("לּ","V").replace("מּ","W").replace("נּ","X")
////                        .replace("סּ","Y").replace("ףּ","Z")
////                        .replace("פּ","0").replace("צּ","1").replace("קּ","2").replace("רּ","3")
////                        .replace("שּ","4").replace("תּ","5").replace("וֹ","6").replace("בֿ","7")
////                        .replace("כֿ","8").replace("פֿ","9")
////                        .replace("&NBSP;","").replace("&nbsp;","").replace("&NBSP", "");
////                sb.append(line).append("\n");
////            }
////        }
////        return sb.toString();
////    }
////
////    private static double parseQuantity(String amountStr, String unit, String chemical) {
////        try {
////            double value = Double.parseDouble(amountStr.replace(",", "."));
////            String u = unit.toUpperCase();
////            if (u.contains("GR")) return value / 1000.0;
////            if (u.contains("GARDAL") || u.contains("GARDEL")) {
////                if (chemical.equalsIgnoreCase("FOAM")) return 4.0 / 5.0;
////                return value * 12.0;
////            }
////            return value;
////        } catch (Exception e) {
////            return 0.0;
////        }
////    }
////
////    private static double getPrice(String chemical) {
////        if (chemical == null || chemical.trim().isEmpty()) return 0.0;
////        try (BufferedReader br = new BufferedReader(new FileReader("X:\\Recipe_System\\Recipe_Indexes\\Prices.kady"))) {
////            String line;
////            while ((line = br.readLine()) != null) {
////                if (line.contains("=$")) {
////                    String[] parts = line.split("=\\$", 2);
////                    if (parts.length == 2 && parts[0].trim().equals(chemical)) {
////                        return Double.parseDouble(parts[1].trim());
////                    }
////                }
////            }
////        } catch (Exception ignored) {}
////        return 0.0;
////    }
////
////    private static double getDilution(String chemical) {
////        if (chemical == null || chemical.trim().isEmpty()) return 1.0;
////        try (BufferedReader br = new BufferedReader(new FileReader("X:\\Recipe_System\\Recipe_Indexes\\Dilution.kady"))) {
////            String line;
////            while ((line = br.readLine()) != null) {
////                if (line.contains("=")) {
////                    String[] parts = line.split("=", 2);
////                    if (parts.length == 2 && parts[0].trim().equals(chemical)) {
////                        return Double.parseDouble(parts[1].trim());
////                    }
////                }
////            }
////        } catch (Exception ignored) {}
////        return 1.0;
////    }
//    
//    
//    
//    
//}