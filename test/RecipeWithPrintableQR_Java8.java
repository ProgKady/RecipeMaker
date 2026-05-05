import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class RecipeWithPrintableQR_Java8 {

    public static void main(String[] args) throws Exception {

        
        //Deccrypt Here ...
        
        String inputFile  = "ALEX_BLUE.ks";           // ملفك الأصلي
        String outputFile = "وصفة_إنتاج_مع_QR_للطباعة.html";   // الملف الجديد
        
        
        String programmerName = "Ahmed Elkady";
        String companyName = "Kadysoft Ltd";
        String factoryName = "T&C Garments";
        String recipeName  = "BANKS";
        String clientName  = "VF";
        int qty            = 120;
        String lastEditorName = "KADINIO";
        String date        = "08/12/2025";
        double pcsCost     = 1.5;
        // النص اللي هيظهر لما يتمسح الـ QR
        String qrText = "★ Recipe Details ★\n" +
"               -------------------------\n" +
"               • Programmer : " + programmerName + "\n" +
"               • Developer : " + companyName + "\n" +
"               • Factory : " + factoryName + "\n" +
"               • Recipe : " + recipeName + "\n" +
"               • Customer : " + clientName + "\n" +
"               • Quantity : " + qty + "\n" +
"               • Editor Name : " + lastEditorName + "\n" +
"               • Last Update : " + date + "\n" +
"               • Pcs Cost : " + pcsCost + "\n" +
"               \n" +
"               Thanks For Using Receta From Kadysoft Ltd. ❤";
        // إنشاء QR مثالي للطباعة (أبيض وأسود + إطار أنيق)
        BufferedImage qrImage = createPrintableQR(qrText, 250);
        String qrBase64 = imageToBase64Png(qrImage);
        // قراءة ملف الـ HTML الأصلي
        String htmlContent = readFile(inputFile);
        Document doc = Jsoup.parse(htmlContent);
        doc.outputSettings().syntax(Document.OutputSettings.Syntax.html);
        doc.outputSettings().charset("UTF-8");
        Element table = doc.select("table#EXTABLE").first();
        if (table == null) {
            System.out.println("خطأ: الجدول #EXTABLE مش موجود!");
            return;
        }
        Elements rows = table.select("tbody > tr");
        int mergeRows = Math.min(8, rows.size()); // أول 8 صفوف
        int qrColumnIndex = 8; // العمود رقم 9 (نبدأ من 0)
        Element firstRow = rows.get(0);
        Elements cells = firstRow.select("td");
        if (cells.size() <= qrColumnIndex) {
            System.out.println("العمود رقم 9 مش موجود في الصف الأول!");
            return;
        }
        // استبدال الخلية في العمود 9 بالـ QR الجميل
//        Element qrCell = cells.get(qrColumnIndex);
//        qrCell.attr("rowspan", String.valueOf(mergeRows))
//              .attr("style", "border: 3px double #000; padding: 15px; background: #ffffff; " +
//                             "text-align: center; vertical-align: middle;")
//              .html(
//                "<div style=\"background: white; padding: 15px; border: 2px solid black; border-radius: 15px; " +
//                "box-shadow: 0 4px 15px rgba(0,0,0,0.2); display: inline-block;\">" +
//                "  <img src=\"data:image/png;base64," + qrBase64 + "\" " +
//                "       alt=\"QR Code - وصفة إنتاج\" " +
//                "       style=\"width: 250px; height: 250px; border: 10px solid white; " +
//                "              box-shadow: 0 0 0 4pt black;\"/>" +
//                "  <br><br>" +
//                "  <div style=\"font-weight: bold; font-size: 16pt; color: black; margin-top: 10px;\">" +
//                "    Scan Me" +
//                "  </div>" +
//                "  <div style=\"font-size: 12pt; color: #333; margin-top: 5px;\">" +
//                "     Powered By Kadysoft Ltd." +
//                "  </div>" +
//                "</div>"
//              );
        
        
        
        Element qrCell = cells.get(qrColumnIndex);
        qrCell.attr("rowspan", String.valueOf(mergeRows))
              .attr("style", "border: 3px double #000; padding: 15px; background: #ffffff; " +
                             "text-align: center; vertical-align: middle;")
              .html(
                "" +
                "" +
                "  <img src=\"data:image/png;base64," + qrBase64 + "\" " +
                "       alt=\"QR Code - وصفة إنتاج\" " +
                "       style=\"width: 250px; height: 250px; border: 10px solid white; " +
                "              box-shadow: 0 0 0 4pt black;\"/>" +
                "  <br><br>" +
                "  <div style=\"font-weight: bold; font-size: 16pt; color: black; margin-top: 10px;\">" +
                "    Scan Me Now" +
                "  </div>" +
                "" +
                "" +
                "" +
                ""
              );
        
        
        
        
        // حذف الخلية من باقي الصفوف (1 إلى 7)
        for (int i = 1; i < mergeRows; i++) {
            Element row = rows.get(i);
            Elements rowCells = row.select("td");
            if (rowCells.size() > qrColumnIndex) {
                rowCells.get(qrColumnIndex).remove();
            }
        }
        // حفظ الملف الجديد
        writeFile(outputFile, doc.outerHtml());
        //System.out.println("تم بنجاح يا باشا!");
        //System.out.println("QR Code جميل جدًا ومثالي للطباعة (أبيض وأسود + ألوان)");
        //System.out.println("مدمج في العمود رقم 9 على أول " + mergeRows + " صفوف");
        //System.out.println("الملف الجديد: " + outputFile);
    }
    // دالة إنشاء QR مثالي للطباعة (أبيض وأسود + إطار أنيق)
    private static BufferedImage createPrintableQR(String text, int size) throws WriterException {
        Map<EncodeHintType, Object> hints = new HashMap<>();
        hints.put(EncodeHintType.CHARACTER_SET, "UTF-8");
        hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.H); // أعلى تصحيح خطأ
        hints.put(EncodeHintType.MARGIN, 4); // هامش كبير للطباعة
        BitMatrix matrix = new MultiFormatWriter().encode(text, BarcodeFormat.QR_CODE, size, size, hints);
        int width = matrix.getWidth();
        int height = matrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
        Graphics2D g = image.createGraphics();
        // خلفية بيضاء نقية
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, width, height);
        // نقاط QR سوداء قوية
        g.setColor(Color.BLACK);
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (matrix.get(x, y)) {
                    g.fillRect(x, y, 1, 1);
                }
            }
        }
        g.dispose();
        return image;
    }
    // تحويل الصورة إلى Base64
    private static String imageToBase64Png(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "PNG", baos);
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }
    // قراءة ملف (Java 8)
    private static String readFile(String path) throws IOException {
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
        br.close();
        return sb.toString();
    }
    // كتابة ملف (Java 8)
    private static void writeFile(String path, String content) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
        pw.print(content);
        pw.close();
        pw.close();
    }
    
    
    
    
    
    //Encrypt Here.............
    
    
    
}