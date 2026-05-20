package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.*;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
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

public class CostMultipleController_Shot implements Initializable {

    @FXML private JFXTextArea list, rora;
    @FXML private Text text;
    @FXML private JFXButton fix;

    private Connection conn = null;
    private ResultSet rs = null;
    private PreparedStatement pst = null;

    private static final String DATE_FORMAT = "yyyy-MM-dd";
    private static final String TIME_FORMAT = "HH:mm:ss";

    @FXML
    void fixaction(ActionEvent event) {
        String[] files = list.getText().split("\n");
        for (String filePath : files) {
            if (filePath.trim().isEmpty()) continue;

            File originalFile = new File(filePath.trim());
            if (!originalFile.exists()) {
                showNotification("خطأ", "الملف غير موجود: " + originalFile.getName(), true);
                continue;
            }

            String[] pathParts = filePath.split("\\\\");
            String washName = pathParts[pathParts.length - 1].replaceAll("\\.ks$|\\.html$", "");
            String model = pathParts.length >= 2 ? pathParts[pathParts.length - 2] : "Unknown";
            String stage = pathParts.length >= 3 ? pathParts[pathParts.length - 3] : "Unknown";

            try {
                // 1. تنظيف الملف
                String cleanedContent = cleanSpecialCharacters(originalFile);
                File tempFile = new File(System.getProperty("user.home") + "\\r_temp.ks");
                try (PrintWriter writer = new PrintWriter(new OutputStreamWriter(
                        new FileOutputStream(tempFile), "UTF-8"))) {
                    writer.print(cleanedContent);
                }

                // 2. قراءة بـ Jsoup
                Document doc = Jsoup.parse(tempFile, "UTF-8");

                // استخراج عدد الـ PCS
                String pcsStr = extractPCS(doc);
                double pcs = parsePCS(pcsStr);

                // استخراج الشوتات والتكاليف
                List<Shot> shots = extractShotsAndCosts(doc);

                if (shots.isEmpty()) {
                    showNotification("تحذير", "لم يتم العثور على كيماويات صالحة في: " + washName, true);
                    continue;
                }

                // حساب التكاليف
                double totalCost = 0.0;
                List<Double> shotCosts = new ArrayList<>();
                for (Shot shot : shots) {
                    double cost = shot.calculateCost();
                    shotCosts.add(cost);
                    totalCost += cost;
                }

                double oneGarmentCost = pcs > 0 ? totalCost / pcs : 0.0;

                // تحضير القيم للـ DB
                String lastUpdate = new SimpleDateFormat(DATE_FORMAT).format(new Date());
                String shotsCount = String.valueOf(shots.size());

                // FSCost = First Shot Cost, SSCost = Second, إلخ...
                String fsCost = shots.size() >= 1 ? String.format("%.4f", shotCosts.get(0)) : "0.0000";
                String ssCost = shots.size() >= 2 ? String.format("%.4f", shotCosts.get(1)) : "undefined";
                String tsCost = shots.size() >= 3 ? String.format("%.4f", shotCosts.get(2)) : "undefined";
                String fosCost = shots.size() >= 4 ? String.format("%.4f", shotCosts.get(3)) : "undefined";

                String totalCostStr = String.format("%.4f", totalCost);
                String oneGarmentStr = String.format("%.6f", oneGarmentCost);

                // التحقق من الوجود
                boolean recordExists = checkIfRecordExists(washName, model, stage);

                if (recordExists) {
                    // Update
                    String sqlUpdate = "UPDATE Cost_By_Shot SET " +
                            "Last_Update = ?, " +
                            "Shots = ?, " +
                            "FSCost = ?, " +
                            "SSCost = ?, " +
                            "TSCost = ?, " +
                            "FOSCost = ?, " +
                            "Total_Cost = ?, " +
                            "PCS = ?, " +
                            "One_Garment_Cost = ? " +
                            "WHERE Wash_Name = ? AND Model = ? AND Stage = ?";

                    pst = conn.prepareStatement(sqlUpdate);
                    pst.setString(1, lastUpdate);
                    pst.setString(2, shotsCount);
                    pst.setString(3, fsCost);
                    pst.setString(4, ssCost);
                    pst.setString(5, tsCost);
                    pst.setString(6, fosCost);
                    pst.setString(7, totalCostStr);
                    pst.setString(8, pcsStr);
                    pst.setString(9, oneGarmentStr);
                    pst.setString(10, washName);
                    pst.setString(11, model);
                    pst.setString(12, stage);

                    pst.executeUpdate();
                    showNotification("تم التحديث", "تم تحديث تكلفة الريسيبي: " + washName, false);

                } else {
                    // Insert
                    String sqlInsert = "INSERT INTO Cost_By_Shot (" +
                            "Last_Update, Stage, Model, Wash_Name, Shots, FSCost, SSCost, TSCost, FOSCost, " +
                            "Total_Cost, PCS, One_Garment_Cost) " +
                            "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    pst = conn.prepareStatement(sqlInsert);
                    pst.setString(1, lastUpdate);
                    pst.setString(2, stage);
                    pst.setString(3, model);
                    pst.setString(4, washName);
                    pst.setString(5, shotsCount);
                    pst.setString(6, fsCost);
                    pst.setString(7, ssCost);
                    pst.setString(8, tsCost);
                    pst.setString(9, fosCost);
                    pst.setString(10, totalCostStr);
                    pst.setString(11, pcsStr);
                    pst.setString(12, oneGarmentStr);

                    pst.executeUpdate();
                    showNotification("تم الإدراج", "تم إضافة تكلفة الريسيبي الجديد: " + washName, false);
                }

            } catch (Exception e) {
                e.printStackTrace();
                showNotification("خطأ", "حدث خطأ أثناء معالجة: " + washName + "\n" + e.getMessage(), true);
            } finally {
                closeResources();
            }
        }

        list.clear();
        text.setVisible(true);
    }

    // استخراج عدد الـ PCS من الجدول
    private String extractPCS(Document doc) {
        Elements rows = doc.select("tr");
        for (Element row : rows) {
            Elements cells = row.select("td");
            for (int i = 0; i < cells.size(); i++) {
                String text = cells.get(i).text().trim();
                if (text.equalsIgnoreCase("PCS") || text.contains("PCS")) {
                    if (i + 1 < cells.size()) {
                        String val = cells.get(i + 1).text().trim();
                        return val.isEmpty() ? "120" : val;
                    }
                }
            }
        }
        return "120";
    }

    private double parsePCS(String pcsStr) {
        try {
            return Double.parseDouble(pcsStr.replace(",", "."));
        } catch (Exception e) {
            return 120.0;
        }
    }

    // استخراج الشوتات والتكاليف
    private List<Shot> extractShotsAndCosts(Document doc) {
        List<Shot> shots = new ArrayList<>();
        Shot currentShot = new Shot();

        for (Element table : doc.select("table")) {
            for (Element row : table.select("tr")) {
                Elements cells = row.select("td");
                if (cells.size() < 9) continue;

                String action = cells.get(3).text().trim().toUpperCase();
                String amountStr = cells.get(5).text().trim();
                String unit = cells.get(6).text().trim().toUpperCase();
                String chemical = cells.get(8).text().trim();

                if (action.contains("EXTRACT") || action.contains("EXTRACTION") || action.contains("EXTRA")) {
                    if (!currentShot.quantities.isEmpty()) {
                        shots.add(currentShot);
                    }
                    currentShot = new Shot();
                    continue;
                }

                if (amountStr.isEmpty() || amountStr.contains("/") || amountStr.contains("\\") ||
                    amountStr.contains("AMT") || amountStr.contains("DATE") || amountStr.contains("WASH") ||
                    chemical.isEmpty() || chemical.contains("CHEMICAL") || chemical.contains("TIME") ||
                    chemical.contains("OLD STONE") || chemical.matches("[0-9_-]+")) {
                    continue;
                }

                double quantity = parseQuantity(amountStr, unit, chemical);
                if (quantity <= 0) continue;

                double price = getPrice(chemical);
                if (price <= 0) continue;

                double dilution = getDilution(chemical);

                currentShot.chemicals.add(chemical);
                currentShot.quantities.add(quantity);
                currentShot.prices.add(price);
                currentShot.dilutions.add(dilution);
            }
        }

        if (!currentShot.quantities.isEmpty()) {
            shots.add(currentShot);
        }

        return shots;
    }

    private boolean checkIfRecordExists(String washName, String model, String stage) throws Exception {
        String sql = "SELECT * FROM Cost_By_Shot WHERE Wash_Name = ? AND Model = ? AND Stage = ?";
        pst = conn.prepareStatement(sql);
        pst.setString(1, washName);
        pst.setString(2, model);
        pst.setString(3, stage);
        rs = pst.executeQuery();
        boolean exists = rs.next();
        closeResourcesQuietly();
        return exists;
    }

    private void showNotification(String title, String text, boolean error) {
        Notifications noti = Notifications.create()
                .title(title)
                .text(text)
                .hideAfter(Duration.seconds(4))
                .position(Pos.CENTER);
        if (error) {
            noti.showError();
        } else {
            noti.showInformation();
        }
    }

    private void closeResources() {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();
        } catch (Exception ignored) {}
    }

    private void closeResourcesQuietly() {
        closeResources();
    }

    // ──────────────────────────────────────────────
    // الدوال المساعدة (نفس السابقة مع تحسينات)
    // ──────────────────────────────────────────────

    private String cleanSpecialCharacters(File file) throws IOException, Exception {
        
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
        //return;
    }
    String result = KeyDecoder.extractData(longKey.trim());
    if (file == null) {
        Notifications noti = Notifications.create();
        noti.title("Fatal Error!");
        noti.text("Choose file first!");
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(4));
        noti.showError();
        //return;
    }
    String input = file.getAbsolutePath();
    String nameofit=file.getName();
    String tempOutput = System.getProperty("user.home")+"\\"+nameofit;
 
    FileDecryptor.decrypt(input, tempOutput, result);
    File tempy = new File(tempOutput);
    
    ////////////////////////////////////////////////////////////
        
        
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(tempy), "UTF-8"))) {
            String line;
            while ((line = br.readLine()) != null) {
                line = line
                        .replace("ﬦ","A").replace("ﬧ","B").replace("ﬨ","C").replace("﬩","D")
                        .replace("שׁ","E").replace("שׂ","F").replace("שּׁ","G").replace("שּׂ","H")
                        .replace("אַ","I").replace("אָ","J").replace("אּ","K").replace("בּ","L")
                        .replace("גּ","M").replace("דּ","N").replace("הּ","O").replace("וּ","P")
                        .replace("זּ","Q").replace("טּ","R").replace("יּ","S").replace("ךּ","T")
                        .replace("כּ","U").replace("לּ","V").replace("מּ","W").replace("נּ","X")
                        .replace("סּ","Y").replace("ףּ","Z")
                        .replace("פּ","0").replace("צּ","1").replace("קּ","2").replace("רּ","3")
                        .replace("שּ","4").replace("תּ","5").replace("וֹ","6").replace("בֿ","7")
                        .replace("כֿ","8").replace("פֿ","9")
                        .replace("&NBSP;"," ").replace("&nbsp;"," ").replace("&NBSP", " ");
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }

    private double parseQuantity(String amountStr, String unit, String chemical) {
        try {
            double value = Double.parseDouble(amountStr.replace(",", "."));
            String u = unit.toUpperCase();
            if (u.contains("GR")) return value / 1000.0;
            if (u.contains("GARDAL") || u.contains("GARDEL")) {
                return chemical.equalsIgnoreCase("FOAM") ? 4.0 / 5.0 : value * 12.0;
            }
            return value;
        } catch (Exception e) {
            return 0.0;
        }
    }

    private double getPrice(String chemical) {
        if (chemical == null || chemical.trim().isEmpty()) return 0.0;
        try (BufferedReader br = new BufferedReader(new FileReader(NewDir.file_dirrrr + "\\Recipe_Indexes\\Prices.kady"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("=$")) {
                    String[] parts = line.split("=\\$", 2);
                    if (parts.length == 2 && parts[0].trim().equals(chemical)) {
                        return Double.parseDouble(parts[1].trim());
                    }
                }
            }
        } catch (Exception ignored) {}
        return 0.0;
    }

    private double getDilution(String chemical) {
        if (chemical == null || chemical.trim().isEmpty()) return 1.0;
        try (BufferedReader br = new BufferedReader(new FileReader(NewDir.file_dirrrr + "\\Recipe_Indexes\\Dilution.kady"))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.contains("=")) {
                    String[] parts = line.split("=", 2);
                    if (parts.length == 2 && parts[0].trim().equals(chemical)) {
                        return Double.parseDouble(parts[1].trim());
                    }
                }
            }
        } catch (Exception ignored) {}
        return 1.0;
    }

    @FXML
    void dragdropaction(DragEvent event) {
        text.setVisible(false);
        list.clear();
        list.appendText(event.getDragboard().getFiles().stream()
                .map(File::getAbsolutePath)
                .collect(Collectors.joining("\n")));
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
        this.conn = db.java_db();
    }
}

// كلاس Shot داخلي
class Shot {
    List<String> chemicals = new ArrayList<>();
    List<Double> quantities = new ArrayList<>();
    List<Double> prices = new ArrayList<>();
    List<Double> dilutions = new ArrayList<>();

    double calculateCost() {
        double total = 0.0;
        for (int i = 0; i < quantities.size(); i++) {
            total += (quantities.get(i) / dilutions.get(i)) * prices.get(i);
        }
        return total;
    }
}