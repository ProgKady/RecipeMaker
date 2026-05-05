package kadysoft.kady;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class RecipeToTeleskopUI extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Recipe → Teleskop Converter");

        // HTML Input
        Label htmlLabel = new Label("Paste HTML Recipe Table:");
        TextArea htmlArea = new TextArea();
        htmlArea.setPromptText("Paste HTML table here...");
        htmlArea.setPrefRowCount(10);

        // Output Area
        Label outputLabel = new Label("Generated Teleskop Code:");
        TextArea outputArea = new TextArea();
        outputArea.setEditable(false);
        outputArea.setPrefRowCount(15);

        // Convert Button
        Button convertBtn = new Button("Convert");
        convertBtn.setOnAction(e -> {
            try {
                List<RecipeStep> steps = parseHtml(htmlArea.getText());
                String code = new TeleskopGenerator().generate(steps);
                outputArea.setText(code);
            } catch (Exception ex) {
                outputArea.setText("Error parsing HTML: " + ex.getMessage());
            }
        });

        // Layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(15));
        root.getChildren().addAll(htmlLabel, htmlArea, convertBtn, outputLabel, outputArea);

        // Scene with Cupertino Light Style
        Scene scene = new Scene(root, 750, 600);
        scene.getStylesheets().add(getClass().getResource("cupertino-light.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // ---------- Recipe Step Model ----------
    public static class RecipeStep {
        public String action;
        public int time;
        public int temp;
        public int liters;
        public String chemQty;
        public String chemUnit;
        public String chemName;
        public boolean isCont; // Flag for CONT in time

        public RecipeStep(String action, int time, int temp, int liters,
                          String chemQty, String chemUnit, String chemName, boolean isCont) {
            this.action = action;
            this.time = time;
            this.temp = temp;
            this.liters = liters;
            this.chemQty = chemQty;
            this.chemUnit = chemUnit;
            this.chemName = chemName;
            this.isCont = isCont;
        }
    }

    // ---------- HTML Parser using Jsoup ----------
    public static List<RecipeStep> parseHtml(String html) throws Exception {
        List<RecipeStep> steps = new ArrayList<>();
        Document doc = Jsoup.parse(html);
        Elements rows = doc.select("table tr");

        boolean started = false;

        for (Element row : rows) {
            Elements tds = row.select("td");
            if (tds.isEmpty()) continue;

            // تحويل كل الخلايا لنصوص نظيفة
            List<String> texts = new ArrayList<>();
            for (Element td : tds) {
                texts.add(td.text().trim().toUpperCase());
            }

            // 1. هل ده صف الـ header؟ (نتخطاه ونبدأ بعده)
            if (!started) {
                String rowText = String.join(" ", texts);
                if (rowText.contains("ACTION NAME") ||
                    rowText.contains("TEMP") ||
                    rowText.contains("TIME") ||
                    rowText.contains("LITRES") ||
                    rowText.contains("CHEMICAL")) {
                    started = true;
                    continue;
                }
                continue;
            }

            // 2. هل ده صف نهاية الجدول؟ (HOURS.)
            String rowTextAll = String.join(" ", texts);
            if (rowTextAll.contains("HOURS.") || rowTextAll.contains("HOURS") || rowTextAll.contains("TOTAL")) {
                break;
            }

            // 3. لازم يكون فيه عدد كافي من الأعمدة
            if (tds.size() < 5) continue;

            // 4. العمود الرابع (index 3) لازم يكون رقم أو فاضي → لو فيه حروف → نتخطى الصف
            String tempStr = tds.get(3).text().trim();
            if (!isNumericOrEmpty(tempStr)) {
                continue;
            }

            // استخراج البيانات
            String action   = tds.get(1).text().trim();           // Action Name
            String timeStr  = tds.get(2).text().trim();           // Time, may contain CONT
            boolean isCont = timeStr.toUpperCase().contains("CONT");
            int time        = parseIntSafe(timeStr.replaceAll("[^0-9]", "")); // Extract number from time
            int temp        = parseIntSafe(tempStr);              // Temp
            int liters      = parseIntSafe(tds.get(4).text());    // Litres

            String chemQty  = tds.size() > 5 ? tds.get(5).text().trim() : "";
            String chemUnit = tds.size() > 6 ? tds.get(6).text().trim() : "";
            String chemName = tds.size() > 7 ? tds.get(7).text().trim() : "";

            // لو الـ action فاضي أو " " → نتخطاه برضو
            if (action.isEmpty() || action.equals("-")) continue;

            steps.add(new RecipeStep(action, time, temp, liters, chemQty, chemUnit, chemName, isCont));
        }

        return steps;
    }

    private static int parseIntSafe(String s) {
        try { return Integer.parseInt(s.trim()); }
        catch (Exception e) { return 0; }
    }

    private static boolean isNumericOrEmpty(String s) {
        if (s == null || s.trim().isEmpty()) return true;
        try {
            Double.parseDouble(s.trim().replace(",", "."));
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    // ---------- Teleskop Generator ----------
    public static class TeleskopGenerator {
        private int phase = 0;

        public String generate(List<RecipeStep> steps) {
            StringBuilder sb = new StringBuilder();
            sb.append("-----HEADER-----\n");
            sb.append("ISIM=RECIPE_CONVERTED\n");
            sb.append("OLUSTURMATARIH=06.01.26\n");
            sb.append("OLUSTURMASAAT=09:05:00\n");
            sb.append("DEGISIKLIKTARIH=06.01.26\n");
            sb.append("DEGISIKLIKSAAT=09:05:00\n");
            sb.append("YAZAR=JAVA_UI\n");
            sb.append("YORUMLAR=Converted from HTML Recipe\n");
            sb.append("PROCESSCODE=0\n");
            sb.append("-----PROGRAM-----\n");
            sb.append("998\n");

            // Initial fill
            sb.append("1 F=1 P=0 IO= SP=500.00 1.00\n");
            sb.append("14 F=1 P=0 IO=[(1,0)][(2,0)][(2,15)][(4,2)][(4,3)][(2,15)][(2,15)] SP=45.00 45.00 0.00\n");

            boolean hasFilled = true;

            for (RecipeStep s : steps) {
                sb.append("; -------- ").append(s.action.toUpperCase()).append(" --------\n");

                // Fill if needed (only when liters change or specific actions)
                if (s.liters > 0 && !hasFilled) {
                    sb.append("1 F=1 P=").append(phase).append(" IO= SP=").append(s.liters).append(".00 1.00\n");
                    sb.append("14 F=1 P=").append(phase).append(" IO=[(1,0)][(2,0)][(2,15)][(4,2)][(4,3)][(2,15)][(2,15)] SP=45.00 45.00 0.00\n");
                    hasFilled = true;
                }

                // Heat if temp > 20
                if (s.temp > 20) {
                    sb.append("6 F=1 P=").append(phase).append(" IO= SP=").append(s.temp * 10).append(".00\n");
                }

                // Rotation with 22.00 or 0.00 based on time
                int rotationTime = s.time > 0 ? 22 : 0;
                sb.append("14 F=1 P=").append(phase).append(" IO=[(1,0)][(2,0)][(2,15)][(4,2)][(4,3)][(2,15)][(2,15)] SP=45.00 45.00 ").append(String.format("%02d.00", rotationTime)).append("\n");

                // For CONT, use sample (6 for heating or 21 for check)
                if (s.isCont) {
                    sb.append("21 F=1 P=").append(phase).append(" IO= SP=\n");
                    sb.append("14 F=1 P=").append(phase).append(" IO=[(1,0)][(2,0)][(2,15)][(4,2)][(4,3)][(2,15)][(2,15)] SP=45.00 45.00 22.00\n");
                }

                // Rinse logic: drain + rotation 0.00
                if (s.action.toLowerCase().contains("rinse")) {
                    sb.append("5 F=1 P=").append(phase).append(" IO= SP=120.00\n");
                    sb.append("14 F=1 P=").append(phase).append(" IO=[(1,0)][(2,0)][(2,15)][(4,2)][(4,3)][(2,15)][(2,15)] SP=45.00 45.00 0.00\n");
                    hasFilled = false; // Need fill next time
                }

                // Add 8 after enzyme or soda
                if (s.action.toLowerCase().contains("enzyme") || s.action.toLowerCase().contains("soda")) {
                    sb.append("8 F=1 P=").append(phase).append(" IO=[(1,0)][(4,1)] SP=45.00\n");
                    sb.append("14 F=1 P=").append(phase).append(" IO=[(1,0)][(2,0)][(2,15)][(4,2)][(4,3)][(2,15)][(2,15)] SP=45.00 45.00 0.00\n");
                }

                // Add 13 after certain steps like bleach or peroxide if needed
                if (s.action.toLowerCase().contains("bleach") || s.action.toLowerCase().contains("peroxide")) {
                    sb.append("13 F=1 P=").append(phase).append(" IO=[(4,9)] SP=300.00\n");
                    sb.append("14 F=1 P=").append(phase).append(" IO=[(1,0)][(2,0)][(2,15)][(4,2)][(4,3)][(2,15)][(2,15)] SP=45.00 45.00 22.00\n");
                }

                phase++;
            }

            // Hydro extraction at end
            sb.append("; -------- HYDRO EXTRACTION --------\n");
            sb.append("16 F=1 P=").append(phase).append(" IO= SP=120.00\n");
            sb.append("14 F=1 P=").append(phase).append(" IO=[(1,0)][(2,0)][(2,15)][(4,2)][(4,3)][(2,15)][(2,15)] SP=45.00 45.00 22.00\n");

            sb.append("999\n");
            sb.append("START_TAGS\n");
            sb.append("INTERVENTIONFREEPROGRAM=0\n");
            sb.append("END_TAGS\n");
            return sb.toString();
        }

        // Map chemical name to pump number (يمكنك تعديلها حسب ماكينتك)
        private int mapChemToPump(String chemName) {
            chemName = chemName.toLowerCase();
            switch (chemName) {
                case "royafix ff conc": return 1; // FIX
                case "acetic acid": return 2;
                case "soft anti ozon": return 3;
                case "softener": return 3;
                default: return 8; // أي كيماويات أخرى على Pump 8
            }
        }
    }
}