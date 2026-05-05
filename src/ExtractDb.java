import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class ExtractDb {

    public static void main(String[] args) {
        try {
            // قراءة الـ base64 من ملف خارجي
            String base64 = readFileToString("C:\\Users\\Ahmed.ElKady\\Desktop\\database_base64.txt").trim();
            
            byte[] dbBytes = Base64.getDecoder().decode(base64);

            String outputPath = "C:\\Users\\Ahmed.ElKady\\Desktop\\my_database.db";

            try (FileOutputStream fos = new FileOutputStream(outputPath)) {
                fos.write(dbBytes);
            }

            System.out.println("تم حفظ قاعدة البيانات بنجاح!");
            System.out.println("الملف: " + outputPath);

        } catch (Exception e) {
            System.err.println("حصل خطأ:");
            e.printStackTrace();
        }
    }

    private static String readFileToString(String filePath) throws IOException {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
        }
        return content.toString();
    }
}