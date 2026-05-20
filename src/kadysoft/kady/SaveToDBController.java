package kadysoft.kady;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.*;
import java.net.URL;
import java.security.SecureRandom;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Window;

public class SaveToDBController implements Initializable {

    // ================= Single File =================
    @FXML private JFXTextField s1;
    @FXML private JFXPasswordField s2;   // Old Long Key
    @FXML private JFXPasswordField s3;   // New Long Key

    // ================= Batch (Folder) =================
    @FXML private JFXTextField m1,m11;
    @FXML private JFXPasswordField m2;   // Old Long Key
    @FXML private JFXPasswordField m3;   // New Long Key

    // ================= Master Password Change =================
    @FXML private JFXTextField oldMasterKey;   // ← TextField مش PasswordField
    @FXML private JFXPasswordField newMasterKey;

    @FXML private JFXTextField codex;

    private File selectedFile;

    private static final String CHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final SecureRandom random = new SecureRandom();
    private static final String MASTER_KEY_FILE = "lib\\java.dat";

    // ================= FILE SELECTION =================
    @FXML
    void sb1action(ActionEvent event) {
        FileChooser fcho = new FileChooser();
        fcho.getExtensionFilters().add(new FileChooser.ExtensionFilter("KADYSOFT Files", "*.ks"));
        File f = fcho.showOpenDialog(null);
        if (f == null) return;
        selectedFile = f;
        s1.setText(f.getAbsolutePath());
    }

    // ================= SINGLE FILE PASSWORD CHANGE =================
    // ================= SINGLE FILE PASSWORD CHANGE =================
@FXML
void sb2action(ActionEvent event) {
    try {
        if (selectedFile == null) {
            showAlert("اختر ملف أولاً!");
            return;
        }

        String oldInput = s2.getText().trim();
        String newInput = s3.getText().trim();

        if (oldInput.isEmpty() || newInput.isEmpty()) {
            showAlert("الكود القديم والجديد مطلوبان!");
            return;
        }

        String oldPass = getPassword(oldInput);
        String newPass = getPassword(newInput);

        File temp = File.createTempFile("singlechange_", ".tmp");
        try {
            FileDecryptor.decrypt(selectedFile.getAbsolutePath(), temp.getAbsolutePath(), oldPass);
            FileEncryptor.encrypt(temp.getAbsolutePath(), selectedFile.getAbsolutePath(), newPass);
            showAlert("تم تغيير كلمة السر بنجاح للملف!");
        } finally {
            temp.delete();
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        showAlert("الكود القديم خاطئ أو الملف تالف");
    }
}

private String getPassword(String input) {
    input = input.trim();
    
    // لو الكود طويل (فيه -) → استخرج الـ7 حروف
    if (input.contains("-")) {
        return KeyDecoder.extractData(input);
    } 
    // لو دخل 7 حروف فقط → استخدمه مباشرة
    else {
        if (input.length() != 7) {
            throw new IllegalArgumentException("الباسورد يجب أن يكون 7 حروف أو كود كامل");
        }
        return input;
    }
}

    // ================= FOLDER SELECTION =================
    @FXML
    void mb1action(ActionEvent event) {
        DirectoryChooser chooser = new DirectoryChooser();
        File f = chooser.showDialog((Window) null);
        if (f == null) return;
        m1.setText(f.getAbsolutePath());
    }
    
    @FXML
    void mb11action(ActionEvent event) {
        DirectoryChooser chooser = new DirectoryChooser();
        File f = chooser.showDialog((Window) null);
        if (f == null) return;
        m11.setText(f.getAbsolutePath());
    }

    
    // ================= BATCH PASSWORD CHANGE (Multi Files) =================
@FXML
void mb2action(ActionEvent event) {
    try {
        File folder = new File(m1.getText().trim());
        
        if (!folder.exists() || !folder.isDirectory()) {
            showAlert("مجلد غير صالح! اختر فولدر صحيح");
            return;
        }

        String oldInput = m2.getText().trim();
        String newInput = m3.getText().trim();

        if (oldInput.isEmpty() || newInput.isEmpty()) {
            showAlert("الكود القديم والجديد مطلوبان!");
            return;
        }

        String oldPass = getPassword(oldInput);
        String newPass = getPassword(newInput);

        int success = 0, failed = 0;
        File[] files = folder.listFiles();

        if (files == null || files.length == 0) {
            showAlert("المجلد فارغ أو لا يحتوي على ملفات");
            return;
        }

        for (File file : files) {
            if (!file.isFile() || !file.getName().endsWith(".ks")) 
                continue;

            File temp = File.createTempFile("batch_", ".tmp");
            try {
                FileDecryptor.decrypt(file.getAbsolutePath(), temp.getAbsolutePath(), oldPass);
                FileEncryptor.encrypt(temp.getAbsolutePath(), file.getAbsolutePath(), newPass);
                success++;
                System.out.println("✅ Success: " + file.getName());
            } catch (Exception ex) {
                failed++;
                System.out.println("❌ Failed: " + file.getName());
            } finally {
                temp.delete();
            }
        }

        showAlert("تم الانتهاء!\n\n" +
                  "✅ ملفات تم تعديلها بنجاح: " + success + "\n" +
                  "❌ فشل: " + failed);

    } catch (Exception ex) {
        ex.printStackTrace();
        showAlert("حدث خطأ: " + ex.getMessage());
    }
}
    

    // ================= MASTER PASSWORD CHANGE =================
    @FXML
    void changeMasterPasswordAction(ActionEvent event) {
        try {
            String oldLongKey = oldMasterKey.getText().trim();
            String newLongKey = newMasterKey.getText().trim();

            if (oldLongKey.isEmpty() || newLongKey.isEmpty()) {
                showAlert("الكود القديم والجديد مطلوبان!");
                return;
            }

            String oldPass = KeyDecoder.extractData(oldLongKey);
            String newPass = KeyDecoder.extractData(newLongKey);

            // 1. التحقق من الكود القديم عن طريق قراءة الملف
            File datFile = new File(MASTER_KEY_FILE);
            if (!datFile.exists()) {
                showAlert("ملف java.dat غير موجود!");
                return;
            }

            BufferedReader reader = new BufferedReader(new FileReader(datFile));
            String currentKey = reader.readLine();
            reader.close();

            if (!oldLongKey.equals(currentKey)) {
                showAlert("الكود الرئيسي القديم غير صحيح!");
                return;
            }

            // 2. تحديث ملف java.dat بالكود الجديد
            BufferedWriter writer = new BufferedWriter(new FileWriter(datFile));
            writer.write(newLongKey);
            writer.close();

            // 3. عمل Migrate لكل الملفات في مجلد معين (أو حدد مجلد البرنامج)
            //File folderToMigrate = new File("."); // غيرها للمجلد اللي فيه الملفات المشفرة
            // مثال: File folderToMigrate = new File("Files");
            File folderToMigrate = new File(m11.getText().trim());

            int success = 0, failed = 0;
            File[] files = folderToMigrate.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (!file.isFile() || !file.getName().endsWith(".ks")) continue;

                    File temp = File.createTempFile("master_mig_", ".tmp");
                    try {
                        FileDecryptor.decrypt(file.getAbsolutePath(), temp.getAbsolutePath(), oldPass);
                        FileEncryptor.encrypt(temp.getAbsolutePath(), file.getAbsolutePath(), newPass);
                        success++;
                    } catch (Exception ex) {
                        failed++;
                    } finally {
                        temp.delete();
                    }
                }
            }

            showAlert("✅ تم تغيير الباسورد الرئيسي بنجاح!\n" +
                      "تم تحديث java.dat\n" +
                      "ملفات تم تحديثها: " + success + " | فشل: " + failed);

            // تنظيف الحقول
            oldMasterKey.clear();
            newMasterKey.clear();

        } catch (Exception ex) {
            ex.printStackTrace();
            showAlert("خطأ أثناء تغيير الباسورد الرئيسي: " + ex.getMessage());
        }
    }

    // ================= KEY GENERATOR =================
    @FXML
    void codexaction(ActionEvent event) {
        codex.setText(generateKey());
    }

    private void showAlert(String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("KadySoft");
        alert.setHeaderText(null);
        alert.setContentText(msg);
        alert.showAndWait();
    }

    public static String generateBlock(int len) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append(CHARS.charAt(random.nextInt(CHARS.length())));
        }
        return sb.toString();
    }

    public static String generateKey() {
        return generateBlock(5) + "-" + generateBlock(5) + "-" +
               generateBlock(5) + "-" + generateBlock(5) + "-" +
               generateBlock(5) + "-" + generateBlock(5) + "-" +
               generateBlock(5);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {}
}