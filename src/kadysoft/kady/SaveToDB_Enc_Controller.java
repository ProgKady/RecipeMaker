
package kadysoft.kady;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ResourceBundle;
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

public class SaveToDB_Enc_Controller implements Initializable {

    @FXML
    private JFXTextArea list;
    @FXML
    private Text text;
    @FXML
    private JFXButton fix;

    @FXML
    void fixaction(ActionEvent event) {
        String[] files = list.getText().trim().split("\n");
        
        if (files.length == 0 || (files.length == 1 && files[0].isEmpty())) {
            showNotification("خطأ", "لا يوجد ملفات للتشفير!", true);
            return;
        }

        int success = 0;
        int failed = 0;

        for (String filePath : files) {
            filePath = filePath.trim();
            if (filePath.isEmpty()) continue;

            File file = new File(filePath);
            if (!file.exists() || !file.isFile()) {
                System.out.println("ملف غير موجود: " + filePath);
                failed++;
                continue;
            }

            try {
                // =================== عمل Backup ===================
                createBackup(file);

                // =================== تشفير الملف ===================
                String tempOutput = file.getAbsolutePath() + ".tmp";

                // قراءة الباسورد من java.dat
                String longKey;
                try (BufferedReader reader = new BufferedReader(new FileReader("lib\\java.dat"))) {
                    longKey = reader.readLine();
                }

                if (longKey == null || longKey.trim().isEmpty()) {
                    showNotification("خطأ", "ملف java.dat فارغ!", true);
                    return;
                }

                String password = KeyDecoder.extractData(longKey.trim());

                FileEncryptor.encrypt(file.getAbsolutePath(), tempOutput, password);

                // استبدال الملف الأصلي
                File original = new File(file.getAbsolutePath());
                File temp = new File(tempOutput);

                if (original.exists()) {
                    original.delete();
                }

                if (temp.renameTo(original)) {
                    success++;
                    System.out.println("✅ Encrypted: " + file.getName());
                } else {
                    failed++;
                    System.out.println("❌ Failed to replace: " + file.getName());
                }

            } catch (Exception ex) {
                failed++;
                ex.printStackTrace();
                System.out.println("❌ Encryption Failed: " + file.getName());
            }
        }

        // تنظيف التكست اريا
        list.clear();

        // إشعار نهائي
        showNotification("تم الانتهاء",
                "✅ تم تشفير بنجاح: " + success + "\n" +
                "❌ فشل: " + failed + "\n\n" +
                "تم حفظ الباك اب في مجلد Backup",
                false);
    }

    // دالة عمل الباك اب
    private void createBackup(File originalFile) {
        try {
            File backupFolder = new File("D:\\All_Recipessss\\Backup");
            if (!backupFolder.exists()) {
                backupFolder.mkdirs();
            }

            String backupFileName = originalFile.getName() + ".bak";
            File backupFile = new File(backupFolder, backupFileName);

            Files.copy(originalFile.toPath(), backupFile.toPath(), 
                      StandardCopyOption.REPLACE_EXISTING);

            System.out.println("✅ Backup created/updated: " + backupFile.getAbsolutePath());
        } catch (Exception ex) {
            System.out.println("⚠️ Warning: Failed to create backup for " + originalFile.getName());
            ex.printStackTrace();
        }
    }

    private void showNotification(String title, String text, boolean isError) {
        Notifications noti = Notifications.create();
        noti.title(title);
        noti.text(text);
        noti.position(Pos.CENTER);
        noti.hideAfter(Duration.seconds(5));

        if (isError) {
            noti.showError();
        } else {
            noti.showInformation();
        }
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
    }
}