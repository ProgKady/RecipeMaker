package kadysoft.kady;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
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
import java.io.Reader;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.geometry.Pos;
import javafx.util.Duration;
import javax.imageio.ImageIO;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import org.cef.CefApp;
import org.cef.CefClient;
import org.cef.CefSettings;
import org.cef.browser.CefBrowser;
import org.cef.browser.CefFrame;
import org.cef.browser.CefMessageRouter;
import org.cef.callback.CefQueryCallback;
import org.cef.handler.CefMessageRouterHandlerAdapter;
import org.controlsfx.control.Notifications;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Helper_Editor {
    private static CefApp cefApp;
    private static CefClient client;
    private static CefBrowser browser;
    private static JLabel titleLabel, statusLabel;
    private static JButton btnRefresh, btnDevTools, btnSave, btnClear,historyyy,editanother;
    private static JCheckBox chkJS, chkZoom, signme, fixche;
    //private static JTextArea logArea;
    private static JTextArea code;

    public static Connection conn;
    public static ResultSet rs;
    public static PreparedStatement pst;
    public static String link,user,recipe,model,stage,nomo;
    public static String filePath;
    public static PrintWriter pw;
    public static JTextField find;
    
    public static String lproduct,rproduct,tempraturee,ftank,etank,cdosage,timer_temprature,oldtimemin,oldtimehour,oldtimemin2,oldtimehour2,msg;
    public static String passy,passyy;
    public static double loadstone,loadstone2;
    public static double removestone,removestone2;
    public static double cleaningstone,cleaningstone2;
    public static double extraction,extraction2;
    public static double loadremovestone,loadremovestone2;
    public static double loadremoveproduct,loadremoveproduct2,loadremoveproductall;
    public static double tempraturetime,tempraturetime2,tempraturetimeall;
    public static double chemicaldosage,chemicaldosage2,chemicaldosageall;
    public static double fillemptytank,fillemptytank2,fillemptytankall;
    public static double gdf1,gdf2,gmf1,gmf2,summo,pcsnum,onegar;
    public static double stonabathth,stonabaththh;
    public static Elements domy;
    public static int bosbos,shoty;
    public static String datevalue,filenammm,modeloo,roraa,oldtotalcost,oldpcs,oldonegarmentcost;
    public static String findo,pecoco;
    public static double gmff1,gmff2;
    public static String bosboss,procccc,stageoo;
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
    public static String originalltextt;
    public static String historyyfileepathh;
    public static String stonny,finall;
    public static double sto,sumz,ally;
    
     
    
    
    public Helper_Editor() {
        initializeJCEFAndUI();
    }
    
    public static void varss() {
    conn = db.java_db();
    link = RecipeMakerController_1.lonkk;
    user = RecipeMakerController_1.theuser;
    recipe = RecipeMakerController_1.funkifi;

    Path path = Paths.get(link);
    stage = path.getName(2).toString();
    model = path.getName(3).toString();
    nomo = path.getFileName().toString();
    stageoo = RecipeMakerController_1.stageoo;
    originalltextt = RecipeMakerController_1.originalContent;
    historyyfileepathh = RecipeMakerController_1.historyFilePath;

    // ←←← التعديل المهم هنا
    if (statusLabel != null) {
        statusLabel.setText(recipe + " Is Editing By " + user);
    } else {
        // لو لسه null، هنحطها في متغير مؤقت أو ننتظر الـ UI
        System.out.println("StatusLabel not initialized yet: " + recipe + " - " + user);
    }
}
    
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> initializeJCEFAndUI());
    }
    

    private static void initializeJCEFAndUI() {
        UIManager.put("OptionPane.messageFont", new Font("Segoe UI", Font.PLAIN, 14));
        UIManager.put("TextField.font", new Font("Segoe UI", Font.PLAIN, 13));
        
        try {

            File baseDir = new File(Helper_Editor.class.getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile();
            File libDir = new File(baseDir, "bin/lib/win64");
            if (!libDir.exists()) {
                JOptionPane.showMessageDialog(null, "مجلد bin/lib/win64 غير موجود بجانب البرنامج!");
                return;
            }
            System.setProperty("java.library.path", libDir.getAbsolutePath());
            try {
                java.lang.reflect.Field field = ClassLoader.class.getDeclaredField("sys_paths");
                field.setAccessible(true);
                field.set(null, null);
            } catch (Exception ignored) {}
            CefApp.startup(new String[]{});
            CefSettings settings = new CefSettings();
            settings.windowless_rendering_enabled = false;
            cefApp = CefApp.getInstance(settings);
            client = cefApp.createClient();

            CefMessageRouter msgRouter = CefMessageRouter.create();
            msgRouter.addHandler(new CefMessageRouterHandlerAdapter() {
                @Override
                public boolean onQuery(CefBrowser browser, CefFrame frame, long queryId, String request, boolean persistent, CefQueryCallback callback) {
                    saveToFile(request);
                    callback.success("");
                    return true;
                }
            }, true);
            client.addMessageRouter(msgRouter);

            File htmlFile = new File(NewDir.file_dirrrr + "\\Editor\\kadysoft.html");
            String url = htmlFile.exists() ? htmlFile.toURI().toString() : "about:blank";
            browser = client.createBrowser(url, false, false);
            browser.createImmediately();

            showModernUI();
            //varss ();

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "خطأ في التشغيل:\n" + e.getMessage());
        }
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private static void showModernUI() {
        final JFrame frame = new JFrame("Kadysoft Editor - JCEF");
    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);   // ← غيرناها
    frame.setSize(1400, 920);
    frame.setMinimumSize(new Dimension(1100, 700));
    frame.getContentPane().setBackground(new Color(30, 30, 35));

        // --- الترويسة العلوية (Top Bar) ---
        JPanel topBar = new JPanel(new BorderLayout());
        topBar.setBackground(new Color(40, 40, 48));
        topBar.setPreferredSize(new Dimension(0, 60));
        topBar.setBorder(new EmptyBorder(12, 20, 12, 20));

        titleLabel = new JLabel("Kadysoft HTML Editor");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setForeground(Color.WHITE);
        topBar.add(titleLabel, BorderLayout.WEST);

        // --- اللوحة السفلية (Controls & Logs) ---
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(35, 35, 42));
        bottomPanel.setPreferredSize(new Dimension(0, 180));

        JPanel controlsPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 15, 12));
        controlsPanel.setBackground(new Color(35, 35, 42));
        controlsPanel.setBorder(new EmptyBorder(5, 15, 5, 15));
        
        find=new JTextField ();
        find.setVisible(false);

        statusLabel = new JLabel("جاهز | kadysoft.html مفتوح");
        statusLabel.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        statusLabel.setForeground(new Color(0, 220, 120));
        controlsPanel.add(statusLabel);

        // الأزرار المحدثة
        btnRefresh = createStyledButton("Refresh Page", new Color(100, 200, 255));
        historyyy = createStyledButton("View History", new Color(0, 122, 255));
        btnDevTools = createStyledButton("Dev Tools", new Color(255, 140, 0));
        btnSave = createStyledButton("Save", new Color(40, 167, 69));
        btnClear = createStyledButton("مسح السجل", new Color(220, 53, 69));
        editanother = createStyledButton("Edit Another", new Color(0, 122, 255));

        controlsPanel.add(btnRefresh);
        controlsPanel.add(historyyy);
        controlsPanel.add(btnDevTools);
        controlsPanel.add(btnSave);
        //controlsPanel.add(btnClear);

        // الخيارات (Checkboxes)
        chkJS = createStyledCheckBox("JavaScript", true);
        chkZoom = createStyledCheckBox("Zoom 150%", false);
        signme = createStyledCheckBox("Sign Me", true);
        signme.setSelected(true);
        fixche = createStyledCheckBox("Fix Chemicals", false);
        fixche.setSelected(true);
        controlsPanel.add(chkJS);
        controlsPanel.add(chkZoom);
        controlsPanel.add(signme);
        controlsPanel.add(fixche);
        controlsPanel.add(find);
        controlsPanel.add(editanother);

        // السجل (Log Area)
        code = new JTextArea();
        code.setBackground(new Color(20, 20, 25));
        code.setForeground(new Color(200, 200, 200));
        code.setFont(new Font("Consolas", Font.PLAIN, 13));
        code.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(code);
        scrollPane.setBorder(BorderFactory.createLineBorder(new Color(50, 50, 60)));

        bottomPanel.add(controlsPanel, BorderLayout.NORTH);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);

        // تجميع الواجهة
        frame.add(topBar, BorderLayout.NORTH);
        frame.add(browser.getUIComponent(), BorderLayout.CENTER);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        frame.addWindowListener(new java.awt.event.WindowAdapter() {
        @Override
        public void windowClosing(java.awt.event.WindowEvent e) {
            // تنظيف JCEF قبل الإغلاق
            if (browser != null) {
                browser.close(true);
            }
            if (client != null) {
                client.dispose();
            }
            if (cefApp != null) {
                cefApp.dispose();
            }
            // لا نستخدم System.exit(0) هنا
            frame.dispose();   // فقط نغلق النافذة
        }
    });

        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
        varss();
        
SwingUtilities.invokeLater(() -> {
browser.getUIComponent().revalidate();
browser.getUIComponent().repaint();
});
        
        
        
        
        appendLog("✅ النظام جاهز للاستخدام");
    }
    
    
    
    
    
    
    
    
    
    

    
    
    
    
    
    
    
    private static JButton createStyledButton(String text, Color color) {
        final JButton btn = new JButton(text);
        btn.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder(9, 18, 9, 18));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent evt) { btn.setBackground(color.darker()); }
            public void mouseExited(MouseEvent evt) { btn.setBackground(color); }
        });

        btn.addActionListener(e -> {
            if (text.contains("Refresh")) {
                browser.reload();
                appendLog("🔄 تم تحديث الصفحة");
            } else if (text.contains("Dev Tools")) {
                browser.openDevTools();
                appendLog("🛠 تم فتح أدوات المطور");
            } else if (text.contains("Save")) {
                requestContentFromJS();
            } else if (text.contains("مسح")) {
                code.setText("");
                appendLog("تم مسح السجل");
            }
            else if (text.contains("History")) {
    SwingUtilities.invokeLater(() -> new Helper_Editor().viewHistory());
}
            else if (text.contains("Another")) {
                openRecipeFile();
                refreshEditor();
            }
        });
        return btn;
    }

    
    
    
    
    
    private static JCheckBox createStyledCheckBox(String text, boolean selected) {
        JCheckBox chk = new JCheckBox(text, selected);
        chk.setForeground(Color.WHITE);
        chk.setBackground(new Color(35, 35, 42));
        chk.addActionListener(e -> {
            if (text.contains("Zoom")) browser.setZoomLevel(chk.isSelected() ? 1.5 : 0.0);
            appendLog("☑ " + text + " -> " + (chk.isSelected() ? "مفعل" : "معطل"));
        });
        return chk;
    }


    
    
    
    
    private static void requestContentFromJS() {
        if (browser == null) return;
        appendLog("🔄 جاري استخراج المحتوى من txtBody...");

        String jsCode = 
            "var content = '';" +
            "try {" +
            "   if (typeof tinymce !== 'undefined') {" +
            "       var editor = tinymce.get('txtBody') || tinymce.activeEditor;" +
            "       if (editor) { content = editor.getContent(); }" +
            "   } else {" +
            "       var el = document.getElementById('txtBody');" +
            "       content = el ? el.value : 'Element txtBody not found!';" +
            "   }" +
            "} catch(e) { content = 'Error: ' + e.message; }" +
            "window.cefQuery({ request: content });"; // إرسال النتيجة إلى الجافا عبر الـ Router
        
        browser.executeJavaScript(jsCode, "", 0);
    }

    
    
    
    
    
    
   
    
    
    private static void refreshEditor() {
    appendLog("🔄 جاري تحديث الريسيبي من الملف...");

    SwingUtilities.invokeLater(() -> {
        try {
            // 1. تحديث المتغيرات
            varss();

            // 2. قراءة الملف بطريقة Java 8
            String newContent = readFileWithJava8(link);

            // 3. تحميل المحتوى في المتصفح
            if (browser != null) {
                // طريقة آمنة وسريعة لـ TinyMCE
                String jsCode = 
                    "if (typeof tinymce !== 'undefined') {" +
                    "    var editor = tinymce.get('txtBody') || tinymce.activeEditor;" +
                    "    if (editor) {" +
                    "        editor.setContent(`" + escapeForJS(newContent) + "`);" +
                    "    }" +
                    "} else {" +
                    "    var el = document.getElementById('txtBody');" +
                    "    if (el) el.value = `" + escapeForJS(newContent) + "`;" +
                    "}";

                browser.executeJavaScript(jsCode, "", 0);

                // تحديث إضافي (احتياطي)
                browser.reload();
            }

            // 4. تحديث الـ Status
            if (statusLabel != null) {
                statusLabel.setText(recipe + " Is Editing By " + user);
            }

            appendLog("✅ تم تحديث الريسيبي بنجاح: " + nomo);

        } catch (Exception ex) {
            ex.printStackTrace();
            appendLog("❌ فشل التحديث: " + ex.getMessage());
            JOptionPane.showMessageDialog(null, 
                "حدث خطأ أثناء تحديث الملف:\n" + ex.getMessage(), 
                "خطأ في الريفريش", JOptionPane.ERROR_MESSAGE);
        }
    });
}



    
    
    
    
    // قراءة ملف بطريقة Java 8
private static String readFileWithJava8(String filePath) throws IOException {
    StringBuilder sb = new StringBuilder();
    try (BufferedReader br = new BufferedReader(
            new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
        
        String line;
        while ((line = br.readLine()) != null) {
            sb.append(line).append("\n");
        }
    }
    return sb.toString();
}

// هروب النصوص للـ JavaScript (مهم جداً)
private static String escapeForJS(String str) {
    if (str == null) return "";
    return str
            .replace("\\", "\\\\")
            .replace("`", "\\`")
            .replace("$", "\\$")
            .replace("\n", "\\n")
            .replace("\r", "\\r")
            .replace("\t", "\\t");
}










private static void openRecipeFile() {
    
    JFileChooser fcho = new JFileChooser();
    String go = NewDir.file_dir;
    
    fcho.setCurrentDirectory(new File(go));
    fcho.setDialogTitle("Kady Choose");
    
    // إضافة فلاتر الملفات
    fcho.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
            "Kadysoft Files (*.ks)", "ks"));
    
    fcho.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
            "HTML Files (*.html)", "html"));
    
    int result = fcho.showOpenDialog(null);   // null = بدون نافذة أب
    
    if (result != JFileChooser.APPROVE_OPTION) {
        return; // المستخدم ضغط Cancel
    }
    
    File f = fcho.getSelectedFile();
    if (f == null) return;

    try {
        String thename = f.getName().replace(".ks", "").replace(".html", "");
        String pathy = f.getAbsolutePath();
        
        // حفظ المسارات والأسماء
        link = pathy;
        funkifi = thename;
        
        

        // استخراج Stage
        String[] pathParts = pathy.split("\\\\");
        stageoo = pathParts.length >= 3 ? pathParts[pathParts.length - 3] : "Unknown";

        // استخراج Model
        String didd1 = NewDir.file_dir + "\\PRODUCTION\\";
        String didd2 = "\\" + f.getName();
        String didd3 = NewDir.file_dir + "\\PILOT\\";
        
        String modelooo = pathy.replace(didd1, "")
                              .replace(didd3, "")
                              .replace(didd2, "");
        
        
    recipe = thename;
    Path path = Paths.get(link);
    stage = path.getName(2).toString();
    model = path.getName(3).toString();
    nomo = path.getFileName().toString();
    stageoo = stage;
        
        

        // ====================== فك التشفير وتحميل المحتوى ======================
        code.setText("");
        
        try (BufferedReader bi = new BufferedReader(
                new InputStreamReader(new FileInputStream(pathy), "UTF-8"))) {
            
            String lo;
            while ((lo = bi.readLine()) != null) {
                code.append("\n" + lo
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
                    .replace("&NBSP;","")
                );
            }
        }

        // حفظ المحتوى الأصلي ومسار الـ History
        if (pathy != null) {
            historyyfileepathh = NewDir.file_dirrrr + "\\Recipes_History\\" + 
                             modelooo + "." + thename + ".history.json";
            
            originalltextt = code.getText();   // حفظ النص بعد فك التشفير
        }

        // ====================== إنشاء ملف kadysoft.html ======================
        createKadysoftHtmlFile(pathy, modelooo);

        appendLog("✅ تم فتح الريسيبي بنجاح: " + thename);
        
        // تحديث الـ status إذا كان موجود
        if (statusLabel != null) {
            statusLabel.setText(funkifi + " Is Editing By " + user);
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, 
            "حدث خطأ أثناء فتح الملف:\n" + ex.getMessage(), 
            "خطأ", JOptionPane.ERROR_MESSAGE);
    }
}





private static void createKadysoftHtmlFile(String originalPath, String modelooo) throws IOException {
    
    try (BufferedReader buf = new BufferedReader(
            new InputStreamReader(new FileInputStream(originalPath), "UTF-8"));
         
         PrintWriter pw = new PrintWriter(
            new OutputStreamWriter(
                new FileOutputStream(NewDir.file_dirrrr + "\\Editor\\kadysoft.html"), "UTF-8"))) {

        // ==================== الهيدر ====================
        
        
    pw.append("<!DOCTYPE html>\n" +
"<html lang=\"ar\">\n" +
"<head>\n" +
"    <meta charset=\"utf-8\" />\n" +
"    <title></title>\n" +
"<style>\n" +
"        body {\n" +
"            user-select: none;\n" +
"            -webkit-user-select: none;\n" +
"            -moz-user-select: none;\n" +
"            -ms-user-select: none;\n" +
"        }\n" +
"</style>\n" +
"\n" +
"<script>\n" +
"document.addEventListener('dragstart', function(event) {\n" +
"    event.preventDefault();\n" +
"});\n" +
"document.addEventListener('drop', function(event) {\n" +
"    event.preventDefault();\n" +
"});\n" +
"document.addEventListener('contextmenu', function(event) {\n" +
"    event.preventDefault();\n" +
"});\n" +
"</script>\n" +
"\n" +
"<script>\n" +
"window.addEventListener(`contextmenu`, (e) => {\n" +
"    e.preventDefault();\n" +
"});\n" +
"</script>\n" +
"\n" +
"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css\" />\n" +
"<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css\" />\n" +
"<link rel=\"stylesheet\" href=\"https://cdn.bookingtimes.com/Styles/bootstrap-dialog.min.css\" />\n" +
"<link rel=\"stylesheet\" href=\"https://cdn.bookingtimes.com/Styles/bootstrap-tour.min.css\" />\n" +
"<link href=\"https://cdn.bookingtimes.com/Common/LoadCSS.ashx?k=874288&amp;v=185.346\" rel=\"stylesheet\" type=\"text/css\">\n" +
"<link href=\"https://cdn.bookingtimes.com/Common/LoadCSS.ashx?k=874288&amp;v=185.346&amp;g=1\" rel=\"stylesheet\" type=\"text/css\">\n" +
"\n" +
"<script src=\"https://ajax.googleapis.com/ajax/libs/jquery/2.2.4/jquery.min.js\" type=\"text/javascript\"></script>\n" +
"<script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js\" type=\"text/javascript\"></script>\n" +
"<script src=\"https://cdn.bookingtimes.com/Scripts/jquery.slicknav.min.js\" type=\"text/javascript\"></script>\n" +
"<script src=\"https://cdn.bookingtimes.com/Scripts/bootstrap-tour.min.js\" type=\"text/javascript\"></script>\n" +
"\n" +
"<script src=\"./Scripts/tiny_mce/tinymce.min.js\" type=\"text/javascript\"></script>\n" +
"\n" +
"<style>\n" +
"#menuContainer {\n" +
"    background-color: black;\n" +
"}\n" +
"</style>\n" +
"\n" +
"<script>\n" +
"$(document).ready(function () {\n" +
"    $(\".modal\").on('shown', function () {\n" +
"        $(this).find(\"[autofocus]:first\").focus();\n" +
"    });\n" +
"    $('.modal').on('hidden.bs.modal', function () {\n" +
"        imageSelected(0, 0);\n" +
"    })\n" +
"});\n" +
"\n" +
"\n" +
"// ======================================\n" +
"// COPY / PASTE BRIDGE\n" +
"// ======================================\n" +
"function setupCopyPasteBridge() {\n" +
"\n" +
"  // Custom Copy\n" +
"  document.addEventListener('copy', function (e) {\n" +
"    const content = tinyMCE.activeEditor.selection.getContent({ format: 'html' });\n" +
"    if (typeof appClipboard !== 'undefined') {\n" +
"      appClipboard.setClipboardText(content);\n" +
"      e.preventDefault();\n" +
"    }\n" +
"  });\n" +
"\n" +
"  // Custom Paste\n" +
"  document.addEventListener('paste', function (e) {\n" +
"    if (typeof appClipboard !== 'undefined') {\n" +
"      const html = appClipboard.getClipboardText();\n" +
"      tinyMCE.activeEditor.execCommand('mceInsertContent', false, html);\n" +
"      e.preventDefault();\n" +
"    }\n" +
"  });\n" +
"}\n" +
"\n" +
"</script>\n" +
"\n" +
"<script>\n" +
"// =====================================================\n" +
"// TINYMCE INIT\n" +
"// =====================================================\n" +
"tinyMCE.init({\n" +
"    mode: \"specific_textareas\",\n" +
"    editor_selector: \"mceEditor\",\n" +
"    cleanup: false,\n" +
"    plugins: \"link,code,insertdatetime,preview,paste,table,visualblocks,fullscreen,image,emoticons,textcolor,colorpicker,lists,charmap,hr,print,autosave,charmap,codesample,colorpicker,fullpage,save,searchreplace,image,imagetools,help\",\n" +
"\n" +
"    menu: {\n" +
"        file: { title: 'File', items: 'print save | autosave charmap codesample | colorpicker fullpage searchreplace image imagetools' },\n" +
"        edit: { title: 'Edit', items: 'undo redo | cut copy paste pastetext selectall | searchreplace' },\n" +
"        format: { title: 'Format', items: 'strikethrough superscript subscript | removeformat' },\n" +
"        view: { title: 'View', items: 'visualblocks visualaid | preview fullscreen | code' },\n" +
"        table: { title: 'Table', items: 'inserttable tableprops deletetable | cell row column' },\n" +
"        about: { title: 'About', items: 'help' }\n" +
"    },\n" +
"\n" +
"    images_dataimg_filter: function (img) {\n" +
"        return img.hasAttribute('internal-blob');\n" +
"    },\n" +
"\n" +
"    toolbar1: \"formatselect , fontsizeselect | bold italic underline | outdent indent | bullist numlist | alignleft aligncenter alignright | forecolor backcolor | inserttable tableprops deletetable | cell row column | table save print imagetools image noneditable fullpage fullscreen code autosave bbcode emoticons emotions | preview \",\n" +
"\n" +
"    style_formats: [\n" +
"        { title: 'h1', block: 'h1' },\n" +
"        { title: 'h2', block: 'h2' },\n" +
"        { title: 'h3', block: 'h3' },\n" +
"        { title: 'h4', block: 'h4' },\n" +
"        { title: 'h5', block: 'h5' }\n" +
"    ],\n" +
"\n" +
"    visualblocks_default_state: false,\n" +
"    end_container_on_empty_block: true,\n" +
"    resize: 'both',\n" +
"    browser_spellcheck: true,\n" +
"    paste_text_sticky: true,\n" +
"    paste_data_images: true,\n" +
"    inline_styles: true,\n" +
"    schema: 'html5',\n" +
"\n" +
"    valid_children: \"+body[style|meta],+a[*],+input[*],+a[div|p|span],+input[div|p|span]\",\n" +
"    extended_valid_elements: \"div[*],iframe[*],a[*],p[*],img[*],input[*],script[*],meta[*]\",\n" +
"    allow_html_in_named_anchor: true,\n" +
"    remove_script_host: false,\n" +
"    convert_urls: false,\n" +
"    branding: false,\n" +
"    encoding: \"UTF-8\",\n" +
"\n" +
"    block_formats: 'Paragraph=p;Heading 2=h2;Heading 3=h3;Heading 4=h4;Heading 5=h5;Heading 6=h6;Address=address;Pre=pre',\n" +
"\n" +
"    init_instance_callback: function () {\n" +
"        if (typeof tinyMCE_Init == \"function\") { tinyMCE_Init(); }\n" +
"    },\n" +
"\n" +
"    setup: function (editor) {\n" +
"\n" +
"        setupCopyPasteBridge();\n" +
"\n" +
"        // ===============================\n" +
"        // إزالة p داخل الجدول\n" +
"        // ===============================\n" +
"        editor.on(\"BeforeSetContent\", function (e) {\n" +
"            if (e.content && e.content.includes(\"<tr\")) {\n" +
"                e.content = e.content.replace(/<p>/g, \"\").replace(/<\\/p>/g, \"\");\n" +
"            }\n" +
"        });\n" +
"\n" +
"\n" +
"        // ============================================================\n" +
"        // 🔥🔥 FORMAT PAINTER (copy/paste formatting like Excel)\n" +
"        // ============================================================\n" +
"        let copiedFormat = null;\n" +
"\n" +
"        // COPY format: Ctrl + Shift + F\n" +
"        editor.addShortcut('ctrl+shift+f', 'Copy Cell Format', function () {\n" +
"            let cell = editor.selection.getNode();\n" +
"            if (cell.nodeName !== \"TD\" && cell.nodeName !== \"TH\") {\n" +
"                alert(\"Please select a table cell to copy formatting.\");\n" +
"                return;\n" +
"            }\n" +
"            copiedFormat = cell.getAttribute(\"style\");\n" +
"            alert(\"Format Copied ✔\");\n" +
"        });\n" +
"\n" +
"        // PASTE format: Ctrl + Shift + V\n" +
"        editor.addShortcut('ctrl+shift+v', 'Paste Cell Format', function () {\n" +
"            if (!copiedFormat) {\n" +
"                alert(\"No format copied yet.\");\n" +
"                return;\n" +
"            }\n" +
"\n" +
"            let selectedCells = editor.selection.getSelectedBlocks();\n" +
"\n" +
"            if (selectedCells.length === 0) {\n" +
"                let node = editor.selection.getNode();\n" +
"                if (node.nodeName === \"TD\" || node.nodeName === \"TH\") {\n" +
"                    selectedCells = [node];\n" +
"                }\n" +
"            }\n" +
"\n" +
"            selectedCells.forEach(c => {\n" +
"                if (c.nodeName === \"TD\" || c.nodeName === \"TH\") {\n" +
"                    c.setAttribute(\"style\", copiedFormat);\n" +
"                }\n" +
"            });\n" +
"\n" +
"            alert(\"Format Applied ✔\");\n" +
"        });\n" +
"\n" +
"\n" +
"        // ============================================================\n" +
"        // تلوين الخلية (Ctrl + Shift + C)\n" +
"        // ============================================================\n" +
"        editor.addShortcut('ctrl+shift+c', 'Change Table Cell Color', function() {\n" +
"            var selectedNode = editor.selection.getNode();\n" +
"            if (selectedNode.nodeName === 'TD' || selectedNode.nodeName === 'TH' || selectedNode.nodeName === 'TR') {\n" +
"                selectedNode.style.backgroundColor = 'yellow';\n" +
"            } else {\n" +
"                alert('Please select a table cell to change its color.');\n" +
"            }\n" +
"        });\n" +
"\n" +
"    }\n" +
"});\n" +
"</script>\n" +
"\n" +
"</head>\n" +
"\n" +
"<body>\n" +
"<center>\n" +
"    <div class=\"col-sm-9\">\n" +
"        <textarea rows=\"2\" cols=\"20\" id=\"txtBody\" class=\"mceEditor\" autocomplete=\"off\" style=\"height: 800px; width: 100%;\" aria-hidden=\"true\">"+
"			\n" +
"			\n" +
"			");

        // ==================== كتابة محتوى الريسيبي ====================
        String line;
        while ((line = buf.readLine()) != null) {
            pw.append(line
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
                .replace("&NBSP;","")
                .replace("<HTML ","<HTML CONTENTEDITABLE ")
                .replace(" WIDTH=\"300\" HEIGHT=\"90\" ALT=\"DEVELOPED BY KADYSOFT LTD (AHMED ELKADY).\" STYLE=\"BORDER-COLOR:BLACK;BORDER-WIDTH:10PX;\">","")
                .replace("<B>MR_MUHAMMET SIGNATURE: </B><IMG SRC=\"FILE://Z:\\MODELS\\MR_MUHAMMET.PNG\"","")
                .replace("<B ID=\"SIGNNAME\">MR_MUHAMMET SIGNATURE: </B>","")
                .replace("<IMG ID=\"SIGNIMAGE\" SRC=\"FILE://Z:\\MODELS\\MR_MUHAMMET.PNG\"","")
                + "\n");
        }

        pw.append("\n</textarea>\n</div>\n</center>\n</body>\n</html>");
    }
}










    
    
    
    
    private static void saveToFile(String content) {
        SwingUtilities.invokeLater(() -> {
            if (content == null || content.isEmpty()) {
                appendLog("⚠️ المحتوى فارغ، لم يتم الحفظ.");
                return;
            }
            
            
            
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Save Action Goes Here.
        int option = JOptionPane.showConfirmDialog(
        null,
        "Add Time To Recipe Or Not ...",
        "Add Time?",
        JOptionPane.OK_CANCEL_OPTION,
        JOptionPane.INFORMATION_MESSAGE
);
if (option == JOptionPane.OK_OPTION) {
   try {
       String thecodee=content;
       //Get Time And Shots
       List<Integer> time = new ArrayList<>();
       List<Integer> timeSum = new ArrayList<>();
       List<String> shots = new ArrayList<>();
       int sum = 0, bathnum=0, firstshot=0, secondshot=0,thirdshot=0,forthshot=0;
       Document doc = Jsoup.parse(thecodee);
       for (Element table : doc.select("tbody")) {
           for (Element row : table.select("tr")) {
               Elements tds = row.select("td");
               if (tds.get(2).text().isEmpty()||tds.get(2).text().contains("/")||tds.get(2).text().contains("\\")||tds.get(2).text().contains("SPIN")||tds.get(2).text().contains("spin")||tds.get(2).text().contains("TIME")||tds.get(2).text().contains("time")||tds.get(2).text().matches("[a-zA-Z_]+")||tds.get(2).text().contains("PRODUCTION")||tds.get(2).text().contains("RECIPE")||tds.get(2).text().contains("RECIPI")||tds.get(2).text().contains("DATE")||tds.get(2).text().contains("WASH")) {}
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
       
       /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       
       //Get Temp
       try {
           BufferedReader buf = new BufferedReader(new FileReader(NewDir.file_dirr + "\\Timer_Temp.kady"));
           timer_temprature=buf.readLine();
           buf.close();
       } catch (FileNotFoundException fileNotFoundException) {
       } catch (IOException iOException) {}
       
       int temp=0;
       int temp2=0;
       int temp3=0;
       String timer_tempra=timer_temprature;
       int timer_temp=Integer.parseInt(timer_tempra);
       
       Document docy = Jsoup.parse(thecodee);
       
       for (Element table : docy.select("table")) {
           for (Element row : table.select("tr")) {
               Elements tds = row.select("td");
               if (tds.get(3).text().contains("/")||tds.get(3).text().contains("\\")||tds.get(3).text().isEmpty()||tds.get(3).text().contains("TEMP")||tds.get(3).text().contains("OPERATOR")||tds.get(3).text().contains("temp")||tds.get(3).text().contains("operator")) {}
               else {
                   
                   String tempo=tds.get(3).text();
                   
                   if (tempo.contains("EXTRACT")) {
                       
                       String pattern = "[a-zA-Z_ _&_.]+";
                       tempo = tempo.replaceAll(pattern, "");
                       if (tempo.matches("[0-9]+")) {
                           int cvd2=Integer.parseInt(tempo);
                           if (cvd2>timer_temp) {
                               temp2+=1;
                           }
                           else {
                           }}break;
                   }
                   
                   else {
                       
                       String pattern = "[a-zA-Z_ _&_.]+";
                       tempo = tempo.replaceAll(pattern, "");
                       if (tempo.matches("[0-9]+")) {
                           int cvd=Integer.parseInt(tempo);
                           if (cvd>timer_temp) {
                               temp+=1;
                           }else {}}
                       
                   }}}}
       
       int tempall=0;
       Document docc = Jsoup.parse(thecodee);
       for (Element table : docc.select("table")) {
           for (Element row : table.select("tr")) {
               Elements tds = row.select("td");
               if (tds.get(3).text().contains("/")||tds.get(3).text().contains("\\")||tds.get(3).text().isEmpty()||tds.get(3).text().contains("TEMP")||tds.get(3).text().contains("OPERATOR")||tds.get(3).text().contains("temp")||tds.get(3).text().contains("operator")) {}
               else {
                   String tempo=tds.get(3).text();
                   String pattern = "[a-zA-Z_ _&_.]+";
                   tempo = tempo.replaceAll(pattern, "");
                   if (tempo.matches("[0-9]+")) {
                       int cvd=Integer.parseInt(tempo);
                       if (cvd>timer_temp) {
                           tempall+=1;}
                       else {}}else {}}}}
       
       
       /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       
       //Get Stone Bath
       
       int stonebathh=0;
       Document doccc = Jsoup.parse(thecodee);
       for (Element table : docc.select("table")) {
           for (Element row : table.select("tr")) {
               Elements tds = row.select("td");
               if (tds.get(7).text().isEmpty()||tds.get(7).text().contains("/")||tds.get(7).text().contains("\\")||tds.get(7).text().contains("CHEMICAL")||tds.get(7).text().contains("chemical")||tds.get(7).text().matches("[0-9_-]+")) {}
               else {
                   String erw=tds.get(7).text().toString();
                   if (erw.contains("STONE")||erw.contains("STON")||erw.contains("BOOL")||erw.contains("FOAM")||erw.contains("BOLL"))  {
                       stonebathh+=1;
                   }else {}}}}
       
       
       /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       
       //Get Water Bath
       
       
       
       
       int waterbath=0;
       int waterbath2=0;
       Document docu = Jsoup.parse(thecodee);
       
       for (Element table : docu.select("table")) {
           for (Element row : table.select("tr")) {
               Elements tds = row.select("td");
               
               if (tds.get(4).text().contains("'")||tds.get(4).text().contains("DRYER")||tds.get(4).text().contains("LITER")||tds.get(4).text().matches("[a-zA-Z_]+")) {}
               else {
                   
                   String tempo=tds.get(3).text();
                   
                   if (tempo.contains("EXTRACT")) {
                       if (tds.get(4).text().matches("[0-9]+")) {
                           int cvd2=Integer.parseInt(tds.get(4).text());
                           waterbath2+=1;
                           
                       }
                       
                       break;
                       
                   }
                   
                   
                   else {
                       
                       if (tds.get(4).text().matches("[0-9]+")) {
                           int cvd=Integer.parseInt(tds.get(4).text());
                           
                           waterbath+=1;
                           
                       }
                       
                   }
                   
               }}}
       
       
       
       
       int waterbathall=0;
       Document dock = Jsoup.parse(thecodee);
       
       for (Element table : dock.select("table")) {
           for (Element row : table.select("tr")) {
               Elements tds = row.select("td");
               if (tds.get(4).text().isEmpty()||tds.get(4).text().contains("'")||tds.get(4).text().contains("DRYER")||tds.get(4).text().contains("LITER")||tds.get(4).text().matches("[a-zA-Z_]+")) {}
               else {
                   String erw=tds.get(4).text().toString();
                   waterbathall+=1;
               }}}
       
       
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
       
       int tempp=temp;
       int tempp2=tempall-temp;
       int temppall=tempall;
       
       int waterbathx=waterbath;
       int waterbath2x=waterbathall-waterbath;
       int waterbathallx=waterbathall;
       
       int stonebathhh=stonebathh;
       
       loadremoveproduct=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
       tempraturetime=tempp*Double.parseDouble(tempratureee);
       chemicaldosage=Double.parseDouble(cdosagee);
       fillemptytank=waterbathx*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
       
       loadremoveproduct2=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
       tempraturetime2=tempp2*Double.parseDouble(tempratureee);
       chemicaldosage2=Double.parseDouble(cdosagee);
       fillemptytank2=waterbath2x*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
       
       loadremoveproductall=Double.parseDouble(lproductt)+Double.parseDouble(rproductt);
       tempraturetimeall=temppall*Double.parseDouble(tempratureee);
       chemicaldosageall=Double.parseDouble(cdosagee);
       fillemptytankall=waterbathallx*(Double.parseDouble(ftankk)+Double.parseDouble(etankk));
       
       //Alert for Bath Here
       
       
       
       if (bathnumm==1) {
           
           
           JTextField fss = new JTextField("");
           fss.setPreferredSize(new Dimension(300, 30));
           fss.setFont(new Font("Segoe UI", Font.BOLD, 13));
           JTextField fsss = new JTextField("0");
           fsss.setPreferredSize(new Dimension(300, 30));
           fsss.setFont(new Font("Segoe UI", Font.BOLD, 13));
           JLabel lbl1 = new JLabel("Write Stone Baths Number");
           lbl1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
           JLabel lbl2 = new JLabel("Additional Time");
           lbl2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
           JPanel panel = new JPanel();
           panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
           panel.add(lbl1);
           panel.add(Box.createVerticalStrut(5));
           panel.add(fss);
           panel.add(Box.createVerticalStrut(10));
           panel.add(lbl2);
           panel.add(Box.createVerticalStrut(5));
           panel.add(fsss);
           
           int option2 = JOptionPane.showConfirmDialog(
                   null,
                   panel,
                   "Stone Bath?",
                   JOptionPane.OK_CANCEL_OPTION,
                   JOptionPane.INFORMATION_MESSAGE
           );
           
           if (option2 == JOptionPane.OK_OPTION) {
               
               passy = fss.getText();
               stonabathth = 0;
               try {
                   stonabathth = Double.parseDouble(passy);
               } catch (Exception e) {
                   stonabathth = 0;
               }
               
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
               
               
               gmff1=Double.parseDouble(fsss.getText());
               
               
               ////////////////////////////////////////////////////////////////////////////////////
           }
           
           if (option == JOptionPane.CANCEL_OPTION) {
               JOptionPane.showMessageDialog(
                       null,
                       "Operation Cancelled, Something was wrong.",
                       "Cancel!",
                       JOptionPane.INFORMATION_MESSAGE
               );
               
           } else {
           }
       }
       else if (bathnumm==2) {
           JTextField fss = new JTextField("");
           fss.setPreferredSize(new Dimension(300, 30));
           fss.setFont(new Font("Segoe UI", Font.BOLD, 13));
           JTextField fsssy = new JTextField("0");
           fsssy.setPreferredSize(new Dimension(300, 30));
           fsssy.setFont(new Font("Segoe UI", Font.BOLD, 13));
           JLabel lbl1 = new JLabel("Write Stone Baths Number");
           lbl1.setFont(new Font("Segoe UI", Font.PLAIN, 13));
           JLabel lbl2 = new JLabel("Additional Time");
           lbl2.setFont(new Font("Segoe UI", Font.PLAIN, 13));
           JLabel header = new JLabel(
                   "We found stone or foam " + stonebathhh + " times. for the first shot."
           );
           header.setFont(new Font("Segoe UI", Font.BOLD, 13));
           JLabel contento = new JLabel(
                   "Hello, Please tell me: Stone Baths Number?"
           );
           contento.setFont(new Font("Segoe UI", Font.PLAIN, 12));
           JPanel panel = new JPanel();
           panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
           panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
           panel.add(header);
           panel.add(Box.createVerticalStrut(10));
           panel.add(contento);
           panel.add(Box.createVerticalStrut(10));
           panel.add(lbl1);
           panel.add(fss);
           panel.add(Box.createVerticalStrut(10));
           panel.add(lbl2);
           panel.add(fsssy);
           int option3 = JOptionPane.showConfirmDialog(
                   null,
                   panel,
                   "Stone Bath?",
                   JOptionPane.OK_CANCEL_OPTION,
                   JOptionPane.INFORMATION_MESSAGE
           );
           if (option3 == JOptionPane.OK_OPTION) {
               passy = fss.getText();
               stonabathth = 0;
               try {
                   stonabathth = Double.parseDouble(passy);
               } catch (Exception e) {
                   stonabathth = 0;
               }
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
               
               
               gmff1=Double.parseDouble(fsssy.getText());
               
               
               ////////////////////////////////////////////////////////////////////////////////////
           }
           
           else {
               JOptionPane.showMessageDialog(
                       null,
                       "Operation Cancelled, Something was wrong.",
                       "Cancel!",
                       JOptionPane.INFORMATION_MESSAGE
               );
           }
           
           ///////////yrtyrty///////////
           
           JTextField fsss = new JTextField("");
           fsss.setPreferredSize(new Dimension(300, 30));
           fsss.setFont(new Font("Segoe UI", Font.BOLD, 13));
           JTextField fssss = new JTextField("0");
           fssss.setPreferredSize(new Dimension(300, 30));
           fssss.setFont(new Font("Segoe UI", Font.BOLD, 13));
           JLabel headerq = new JLabel(
                   "We found stone or foam " + stonebathhh + " times. for the second shot."
           );
           headerq.setFont(new Font("Segoe UI", Font.BOLD, 13));
           JLabel contentq = new JLabel(
                   "Hello, Please tell me: Stone Baths Number?"
           );
           contentq.setFont(new Font("Segoe UI", Font.PLAIN, 12));
           JLabel lbl1q = new JLabel("Write Stone Baths Number");
           lbl1q.setFont(new Font("Segoe UI", Font.PLAIN, 13));
           JLabel lbl2q = new JLabel("Additional Time");
           lbl2q.setFont(new Font("Segoe UI", Font.PLAIN, 13));
           JPanel panelq = new JPanel();
           panelq.setLayout(new BoxLayout(panelq, BoxLayout.Y_AXIS));
           panelq.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
           panelq.add(headerq);
           panelq.add(Box.createVerticalStrut(10));
           panelq.add(contentq);
           panelq.add(Box.createVerticalStrut(10));
           panelq.add(lbl1q);
           panelq.add(fsss);
           panelq.add(Box.createVerticalStrut(10));
           panelq.add(lbl2q);
           panelq.add(fssss);
           int option4 = JOptionPane.showConfirmDialog(
                   null,
                   panelq,
                   "Stone Bath?",
                   JOptionPane.OK_CANCEL_OPTION,
                   JOptionPane.INFORMATION_MESSAGE
           );
           
           if (option4 == JOptionPane.OK_OPTION) {
               passyy = fsss.getText();
               stonabaththh = 0;
               try {
                   stonabaththh = Double.parseDouble(passyy);
               } catch (Exception e) {
                   stonabaththh = 0;
               }
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


gmff2=Double.parseDouble(fssss.getText()); 


////////////////////////////////////////////////////////////////////////////////////
           }
           else {
               JOptionPane.showMessageDialog(
                       null,
                       "Operation Cancelled, Something was wrong.",
                       "Cancel!",
                       JOptionPane.INFORMATION_MESSAGE
               );
           }
       }
       
       /////////////////////////////////////////////Starting//////////////////////////////////////////////////////////
       
       
       if (bathnumm==1) {
           gmf1=stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank;
           gmf1=gmf1+gmff1;
           double number1 = gmf1;
           String formatted1 = String.format("%.1f", number1);
           gmf1=Double.parseDouble(formatted1);
           
           gdf1=(stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank)/60.0;
           
           double number11 = gdf1;
           String formatted11 = String.format("%.1f", number11);
           gdf1=Double.parseDouble(formatted11);
           
           //Write to recipe here //////////////////////////////////////////////////////////
           
           Document report = Jsoup.parse(thecodee);
           domy = report.children();
           domy.select("tbody").append("<tr>\n" +
                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                   "<td style=\"width: 11.1111%; background-color: #f6ff00; border-color: #ff0000; text-align: center;\"><b>Recipe Time :</b> <u><b>"+Double.toString((gmf1))+"</b></u> <b>Mins.</b></td>\n" +
                           "<td style=\"width: 11.1111%; background-color: #f6ff00; border-color: #ff0000; text-align: center;\"><u><b>"+Double.toString((gdf1))+"</b></u> <b>Hours.</b></td>\n" +
                                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                                   "</tr>");
           
           
           /////////////////////////////////////////////////////////////////////////////////
           
       }
       
       else if (bathnumm==2) {
           
           gmf1=stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank;
           gmf1=gmf1+gmff1;
           double number1 = gmf1;
           String formatted1 = String.format("%.1f", number1);
           gmf1=Double.parseDouble(formatted1);
           
           gdf1=(stonabathth+firstshott+loadremoveproduct+loadremovestone+tempraturetime+extraction+chemicaldosage+fillemptytank)/60.0;
           
           double number11 = gdf1;
           String formatted11 = String.format("%.1f", number11);
           gdf1=Double.parseDouble(formatted11);
           
           gmf2=stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2;
           gmf2=gmf2+gmff2;
           double number2 = gmf2;
           String formatted2 = String.format("%.1f", number2);
           gmf2=Double.parseDouble(formatted2);
           
           gdf2=(stonabaththh+secondshott+loadremoveproduct2+loadremovestone2+tempraturetime2+extraction2+chemicaldosage2+fillemptytank2)/60.0;
           
           double number22 = gdf2;
           String formatted22 = String.format("%.1f", number22);
           gdf2=Double.parseDouble(formatted22);
           
           
           //Write to recipe here //////////////////////////////////////////////////////////
           
           Document report = Jsoup.parse(thecodee);
           domy = report.children();
           domy.select("tbody").append("<tr>\n" +
                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                   "<td style=\"width: 11.1111%; background-color: #f6ff00; border-color: #ff0000; text-align: center;\"><b>First Shot :</b> <u><b>"+Double.toString((gmf1))+"</b></u> <b>Mins.</b></td>\n" +
                           "<td style=\"width: 11.1111%; background-color: #f6ff00; border-color: #ff0000; text-align: center;\"><u><b>"+Double.toString((gdf1))+"</b></u> <b>Hours.</b></td>\n" +
                                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                                   "</tr>"
                                   + "<tr>\n" +
                                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                                   "<td style=\"width: 11.1111%; background-color: #f6ff00; border-color: #ff0000; text-align: center;\"><b>Second Shot :</b> <u><b>"+Double.toString((gmf2))+"</b></u> <b>Mins.</b></td>\n" +
                                           "<td style=\"width: 11.1111%; background-color: #f6ff00; border-color: #ff0000; text-align: center;\"><u><b>"+Double.toString((gdf2))+"</b></u> <b>Hours.</b></td>\n" +
                                                   "<td style=\"width: 11.1111%;\">&nbsp;</td>\n" +
                                                   "</tr>");
           
           
           /////////////////////////////////////////////////////////////////////////////////
           
           
           
       }
       
       
       else {
           
           //Noti
           
           JWindow toast = new JWindow();
           JPanel panel = new JPanel();
           panel.setBackground(new Color(220, 53, 69)); // red error
           panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
           JLabel label = new JLabel("Operation Cancelled, We don't have 3 shots in one recipe.");
           label.setForeground(Color.WHITE);
           label.setFont(new Font("Segoe UI", Font.BOLD, 13));
           panel.add(label);
           toast.add(panel);
           toast.pack();
           toast.setLocationRelativeTo(null);
           toast.setVisible(true);
           new Timer(5000, e -> toast.dispose()).start();
           
           Document report = Jsoup.parse(thecodee);
           domy = report.children();
           
           
       }
       
       
       
       /////////////////////////////////////////////Ending////////////////////////////////////////////////////////////
       
       
       /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
       
       if (signme.isSelected()==true) {
           
           /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
           
           
           if (fixche.isSelected()==true) {
               
               
               try{
                   
                   String codee = domy.toString();
                   if (!codee.contains("TABLE")) {
                       
                       
                       JWindow toast = new JWindow();
                       JPanel panel = new JPanel();
                       panel.setBackground(new Color(220, 53, 69)); // red error
                       panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
                       JLabel label = new JLabel("Recipe Error, Maybe not a recipe, Open a recipe first!.");
                       label.setForeground(Color.WHITE);
                       label.setFont(new Font("Segoe UI", Font.BOLD, 13));
                       panel.add(label);
                       toast.add(panel);
                       toast.pack();
                       toast.setLocationRelativeTo(null);
                       toast.setVisible(true);
                       new Timer(5000, e -> toast.dispose()).start();
                       
                   }
                   else {
                       Document docj = Jsoup.parse(codee);
                       for (Element table : docj.select("TABLE")) {
                           for (Element row : table.select("TR")) {
                               Elements tds = row.select("TD");
                               if (tds.get(7).text().isEmpty()) {
                               }
                               else {
                                   ///////////////////////////////////////////////////////////////
                                   String string=tds.get(7).text();
                                   BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Chemical_Dictionary.kady"));
                                   String line;
                                   String linebeforeequal;
                                   String lineafterequal;
                                   while ((line=buf.readLine())!=null) {
                                       
                                       
                                       linebeforeequal=line.substring(0,line.indexOf("=")-0);
                                       lineafterequal=line.substring(line.indexOf("=") + 1 , line.length());
                                       if (string.equals(lineafterequal)) {
//System.out.println(string+" = "+linebeforeequal);
String formattedText = "<b style='display:block; text-align:center;'>" + linebeforeequal + "</b>";
tds.get(8).html(formattedText); // Use .html() instead of .text()     
//tds.get(8).text(linebeforeequal);
//System.out.println(tds.get(8).text());
break;

                                       }
                                       else {
                                           
                                       }
                                       
                                   }
                                   buf.close();
                                   
                               }
                               
                           }}
                       roraa=docj.toString();
                   }
                   //////////////////////////////////////////////////////////////////////////////
                   org.jsoup.nodes.Document doct = Jsoup.parse(roraa);
                   for (Element table : doct.select("TABLE")) {
                       for (Element row : table.select("TR")) {
                           Elements tds = row.select("TD");
                           if (tds.get(8).text().isEmpty()) {
                           }
                           else {
                               String string=tds.get(8).text();
                               BufferedReader bufi=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Lot_Numbers.kady"));
                               String line;
                               String linebeforeequal;//Chemical Name
                               String lineafterequal;//Lot Numbers
                               boolean found = false;
                               while ((line=bufi.readLine())!=null) {
                                   linebeforeequal=line.substring(0,line.indexOf("="));//Chemical Name
                                   lineafterequal=line.substring(line.indexOf("=") + 1);//Lot Numbers
                                   if (string.equalsIgnoreCase(linebeforeequal)) {
                                       System.out.println(linebeforeequal);
                                       String formattedText = "<b style='display:block; text-align:center;'>" + lineafterequal + "</b>";
                                       tds.get(9).html(formattedText); // Use .html() instead of .text()     
//tds.get(9).text(lineafterequal);
found = true;                    
break;
                                   }
                               }
                               bufi.close();}}}
                   roraa=doct.toString();
                   
               }catch (Exception m) {}
               
//////////////////////////////////////////////////////////////////////////////


/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         
org.jsoup.nodes.Document doctp = Jsoup.parse(roraa);

// مر على كل جدول
for (Element table : doctp.select("table")) {
    for (Element row : table.select("tr")) {
        Elements tds = row.select("td");

        // اتأكد إن فيه على الأقل 11 عمود (0 → 10)
        if (tds.size() > 10) {
            String target = tds.get(8).text().trim();

            if (!target.isEmpty()) {
                Path mapPath = Paths.get(NewDir.file_dirrrr, "Recipe_Indexes", "Chemical_Translation.kady");

                try (BufferedReader bufi = Files.newBufferedReader(mapPath, StandardCharsets.UTF_8)) {
                    String line;
                    boolean found = false;

                    while ((line = bufi.readLine()) != null) {
                        // اتأكد إن السطر فيه =
                        if (!line.contains("=")) continue;

                        String linebeforeequal = line.substring(0, line.indexOf("=")).trim();
                        String lineafterequal = line.substring(line.indexOf("=") + 1).trim();

                        if (target.equalsIgnoreCase(linebeforeequal)) {
                            System.out.println("Matched: " + linebeforeequal);

                            String formattedText =
                                    "<b style='display:block; text-align:center;'>" +
                                    lineafterequal +
                                    "</b>";
                            
                            // استبدل العمود رقم 10 بالنص الجديد
                            tds.get(10).html(formattedText);

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("No match for: " + target);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

roraa = doctp.toString();



/////////////////////////////////////////////////////////////////////////////////////////////////////////////////



           }
           
           else {
               
               //Continue..........
               roraa=domy.toString();
           }
           
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//String codee=code.getText();
String pathtosignature="file://"+NewDir.file_dirrrrr+"\\Mr_Muhammet.png";
String modely=model;
JFileChooser dialog = new JFileChooser();
dialog.setCurrentDirectory(
        new File(NewDir.file_dir + "\\" + stage + "\\" + model)
);
dialog.setSelectedFile(new File(recipe + ".ks"));
// filters
dialog.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
        "Kadysoft Files", "ks"
));
dialog.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
        "HTML Files", "html"
));
int result = dialog.showSaveDialog(null);
if (result == JFileChooser.APPROVE_OPTION) {
    File dialogResult = dialog.getSelectedFile();
    filePath = dialogResult.getAbsolutePath();
}         


try {
    
    OutputStream instream=new FileOutputStream(filePath);
    pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
    pw.println("<!DOCTYPE html>\n<html lang=\"ar\">\n<head>\n<title>Kadysoft</title>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<style>td {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}\ntable {\nheight:5px;\nmax-width:100%;\nheight:100%;\nwhite-space:nowrap;\n}\ntr {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}"
            + ""
            + ""
            
            + ""
            + "/* Centered Watermark */\n" +
            "    .watermark {\n" +
            "      position: fixed;\n" +
            "      top: 50%;\n" +
            "      left: 50%;\n" +
            "      transform: translate(-50%, -50%) rotate(-45deg);\n" +
            "      background-image: url('logo.png'); /* Replace with the path to T & C Garments logo */\n" +
            "      background-repeat: no-repeat;\n" +
            "      background-size: contain;\n" +
            "      width: 300px;\n" +
            "      height: 200px;\n" +
            "      opacity: 0.3;\n" +
            "      pointer-events: none;\n" +
            "      z-index: 1000;\n" +
            "    }\n" +
            "    /* Repeated Watermark */\n" +
            "    .watermark-repeated {\n" +
            "      position: fixed;\n" +
            "      top: 0;\n" +
            "      left: 0;\n" +
            "      width: 100%;\n" +
            "      height: 100%;\n" +
            "      background-image: url('logo.png'); /* Replace with the path to T & C Garments logo */\n" +
            "      background-repeat: repeat;\n" +
            "      background-size: 300px 200px;\n" +
            "      opacity: 0.2;\n" +
            "      pointer-events: none;\n" +
            "      z-index: 1000;\n" +
            "    }"
            + ""
            + "</STYLE></HEAD>\n" +
            "<BODY><CENTER>\n"
            + "<div class=\"watermark\"></div>"
            
            
            + ""
            + "\n\n");
    pw.println("<!-- Creating Recipe From Kadysoft Ltd.-->\n\n");
    pw.println(roraa);
    pw.println("\n\n</center>\n</body>\n</html>");
    pw.println("<b id=\"signname\">Mr_Muhammet Signature: "+"</b><img id=\"signimage\" src=\""+pathtosignature+"\" width=\"300\" height=\"90\" alt=\"Developed By Kadysoft Ltd (Ahmed Elkady).\" style=\"border-color:black;border-width:10px;\">");
    if (roraa.contains("background-image:")) {
        
    }
    else {
        pw.println("\n\n<style>\n" +
                "body {\n" +
                "  background-image: url(\""+modely+".bmp\");\n" +
                        "  background-position: center;\n" +
                        "  height: 170px;\n" +
                        "background-position-x:550px;"+
                        "  background-repeat: no-repeat;\n" +
                        "  background-size: 120px 90px;\n" +
                        "}\n" +
                        "</style>");
    }
    pw.close();
    
    
    ///////////////////////////////////////////////////
    code.setText("");
    InputStream inputinstream=new FileInputStream(filePath);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    String lo;
    while ((lo=bi.readLine())!=null) {
        
        code.append("\n"+lo
                .replace("A","ﬦ")
                .replace("B","ﬧ")
                .replace("C","ﬨ")
                .replace("D","﬩")
                .replace("E","שׁ")
                .replace("F","שׂ")
                .replace("G","שּׁ")
                .replace("H","שּׂ")
                .replace("I","אַ")
                .replace("J","אָ")
                .replace("K","אּ")
                .replace("L","בּ")
                .replace("M","גּ")
                .replace("N","דּ")
                .replace("O","הּ")
                .replace("P","וּ")
                .replace("Q","זּ")
                .replace("R","טּ")
                .replace("S","יּ")
                .replace("T","ךּ")
                .replace("U","כּ")
                .replace("V","לּ")
                .replace("W","מּ")
                .replace("X","נּ")
                .replace("Y","סּ")
                .replace("Z","ףּ")
                
                .replace("0","פּ")
                .replace("1","צּ")
                .replace("2","קּ")
                .replace("3","רּ")
                .replace("4","שּ")
                .replace("5","תּ")
                .replace("6","וֹ")
                .replace("7","בֿ")
                .replace("8","כֿ")
                .replace("9","פֿ")
                
                .replace("a","ﬦ")
                .replace("b","ﬧ")
                .replace("c","ﬨ")
                .replace("d","﬩")
                .replace("e","שׁ")
                .replace("f","שׂ")
                .replace("g","שּׁ")
                .replace("h","שּׂ")
                .replace("i","אַ")
                .replace("j","אָ")
                .replace("k","אּ")
                .replace("l","בּ")
                .replace("m","גּ")
                .replace("n","דּ")
                .replace("o","הּ")
                .replace("p","וּ")
                .replace("q","זּ")
                .replace("r","טּ")
                .replace("s","יּ")
                .replace("t","ךּ")
                .replace("u","כּ")
                .replace("v","לּ")
                .replace("w","מּ")
                .replace("x","נּ")
                .replace("y","סּ")
                .replace("z","ףּ")
        );
        
        
    }
    bi.close();
    String gf=code.getText();
    OutputStream instreamm=new FileOutputStream(filePath);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    //PrintWriter pw=new PrintWriter (new FileWriter (pathy));
    pw.println(gf);
    pw.close();
    
JWindow toast = new JWindow();
JPanel panel = new JPanel();
panel.setBackground(new Color(220, 53, 69)); // red error
panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
JLabel label = new JLabel("Successful, We have encrypted the recipe successfully.");
label.setForeground(Color.WHITE);
label.setFont(new Font("Segoe UI", Font.BOLD, 13));
panel.add(label);
toast.add(panel);
toast.pack();
toast.setLocationRelativeTo(null);
toast.setVisible(true);
new Timer(5000, e -> toast.dispose()).start();
    
    
   
    code.setText("");
    
}catch (Exception ds) {}

//////////////////////////////////////////////////

//////////////////////////////////////////////////
//Desktop desk = Desktop.getDesktop();
//desk.open(new File (filePath));
JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(btnSave);
//topFrame.dispose();

///////////////////////////////////////////////////

//////////////////////////////////////////////////

       }
       
       
       else {
           
           
           /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
           
           
           if (fixche.isSelected()==true) {
               
               try {
                   
                   
                   String codee = domy.toString();
                   if (!codee.contains("TABLE")) {
                       
                       JWindow toast = new JWindow();
                       JPanel panel = new JPanel();
                       panel.setBackground(new Color(220, 53, 69)); // red error
                       panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
                       JLabel label = new JLabel("Recipe Error, Maybe not a recipe, Open a recipe first!.");
                       label.setForeground(Color.WHITE);
                       label.setFont(new Font("Segoe UI", Font.BOLD, 13));
                       panel.add(label);
                       toast.add(panel);
                       toast.pack();
                       toast.setLocationRelativeTo(null);
                       toast.setVisible(true);
                       new Timer(5000, e -> toast.dispose()).start();
                   }
                   else {
                       Document docj = Jsoup.parse(codee);
                       for (Element table : docj.select("TABLE")) {
                           for (Element row : table.select("TR")) {
                               Elements tds = row.select("TD");
                               if (tds.get(7).text().isEmpty()) {
                               }
                               else {
                                   ///////////////////////////////////////////////////////////////
                                   String string=tds.get(7).text();
                                   BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Chemical_Dictionary.kady"));
                                   String line;
                                   String linebeforeequal;
                                   String lineafterequal;
                                   while ((line=buf.readLine())!=null) {
                                       linebeforeequal=line.substring(0,line.indexOf("=")-0);
                                       lineafterequal=line.substring(line.indexOf("=") + 1 , line.length());
                                       if (string.equals(lineafterequal)) {
//System.out.println(string+" = "+linebeforeequal);
String formattedText = "<b style='display:block; text-align:center;'>" + linebeforeequal + "</b>";
tds.get(8).html(formattedText); // Use .html() instead of .text()     
//tds.get(8).text(linebeforeequal);
//System.out.println(tds.get(8).text());
break;

                                       }
                                       else {
                                           
                                       }
                                       
                                   }
                                   
                                   buf.close();
                                   
                               }
                               
                           }}
                       roraa=docj.toString();
                   }
                   
////////////////////////////////////////////////////////////////////////////// 
org.jsoup.nodes.Document doct = Jsoup.parse(roraa);
for (Element table : doct.select("TABLE")) {
    for (Element row : table.select("TR")) {
        Elements tds = row.select("TD");
        if (tds.get(8).text().isEmpty()) {
        }
        else {
            String string=tds.get(8).text();
            BufferedReader bufi=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Lot_Numbers.kady"));
            String line;
            String linebeforeequal;//Chemical Name
            String lineafterequal;//Lot Numbers
            boolean found = false;
            while ((line=bufi.readLine())!=null) {
                linebeforeequal=line.substring(0,line.indexOf("="));//Chemical Name
                lineafterequal=line.substring(line.indexOf("=") + 1);//Lot Numbers
                if (string.equalsIgnoreCase(linebeforeequal)) {
                    System.out.println(linebeforeequal);
                    String formattedText = "<b style='display:block; text-align:center;'>" + lineafterequal + "</b>";
                    tds.get(9).html(formattedText); // Use .html() instead of .text()     
//tds.get(9).text(lineafterequal);
found = true;                    
break;
                }
            }
            bufi.close();}}}
roraa=doct.toString();      
//////////////////////////////////////////////////////////////////////////////

               }catch (Exception ssa) {}
               
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
org.jsoup.nodes.Document doctp = Jsoup.parse(roraa);
// مر على كل جدول
for (Element table : doctp.select("table")) {
    for (Element row : table.select("tr")) {
        Elements tds = row.select("td");
        // اتأكد إن فيه على الأقل 11 عمود (0 → 10)
        if (tds.size() > 10) {
            String target = tds.get(8).text().trim();
            if (!target.isEmpty()) {
                Path mapPath = Paths.get(NewDir.file_dirrrr, "Recipe_Indexes", "Chemical_Translation.kady");
                try (BufferedReader bufi = Files.newBufferedReader(mapPath, StandardCharsets.UTF_8)) {
                    String line;
                    boolean found = false;
                    while ((line = bufi.readLine()) != null) {
                        // اتأكد إن السطر فيه =
                        if (!line.contains("=")) continue;
                        String linebeforeequal = line.substring(0, line.indexOf("=")).trim();
                        String lineafterequal = line.substring(line.indexOf("=") + 1).trim();
                        if (target.equalsIgnoreCase(linebeforeequal)) {
                            System.out.println("Matched: " + linebeforeequal);
                            String formattedText =
                                    "<b style='display:block; text-align:center;'>" +
                                    lineafterequal +
                                    "</b>";
                            // استبدل العمود رقم 10 بالنص الجديد
                            tds.get(10).html(formattedText);
                            found = true;
                            break;
                        }
                    }
                    if (!found) {
                        System.out.println("No match for: " + target);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
roraa = doctp.toString();

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////




           }
           
           else {
               
               //Continue..........
               roraa=domy.toString();
           }
           
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////




//String codee=code.getText();
String pathtosignature="file://"+NewDir.file_dirrrrr+"\\Mr_Moharam.png";
String modely=model;


JFileChooser dialog = new JFileChooser();
dialog.setCurrentDirectory(
        new File(NewDir.file_dir + "\\" + stage + "\\" + model)
);
dialog.setSelectedFile(new File(recipe + ".ks"));
// filters
dialog.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
        "Kadysoft Files", "ks"
));
dialog.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
        "HTML Files", "html"
));
int result = dialog.showSaveDialog(null);
if (result == JFileChooser.APPROVE_OPTION) {
    File dialogResult = dialog.getSelectedFile();
    filePath = dialogResult.getAbsolutePath();
}

try {
    
    OutputStream instream=new FileOutputStream(filePath);
    pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
    pw.println("<!DOCTYPE html>\n<html lang=\"ar\">\n<head>\n<title>Kadysoft</title>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<style>td {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}\ntable {\nheight:5px;\nmax-width:100%;\nheight:100%;\nwhite-space:nowrap;\n}\ntr {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}"
            + ""
            + ""
            
            + ""
            + "/* Centered Watermark */\n" +
            "    .watermark {\n" +
            "      position: fixed;\n" +
            "      top: 50%;\n" +
            "      left: 50%;\n" +
            "      transform: translate(-50%, -50%) rotate(-45deg);\n" +
            "      background-image: url('logo.png'); /* Replace with the path to T & C Garments logo */\n" +
            "      background-repeat: no-repeat;\n" +
            "      background-size: contain;\n" +
            "      width: 300px;\n" +
            "      height: 200px;\n" +
            "      opacity: 0.3;\n" +
            "      pointer-events: none;\n" +
            "      z-index: 1000;\n" +
            "    }\n" +
            "    /* Repeated Watermark */\n" +
            "    .watermark-repeated {\n" +
            "      position: fixed;\n" +
            "      top: 0;\n" +
            "      left: 0;\n" +
            "      width: 100%;\n" +
            "      height: 100%;\n" +
            "      background-image: url('logo.png'); /* Replace with the path to T & C Garments logo */\n" +
            "      background-repeat: repeat;\n" +
            "      background-size: 300px 200px;\n" +
            "      opacity: 0.2;\n" +
            "      pointer-events: none;\n" +
            "      z-index: 1000;\n" +
            "    }"
            + ""
            + "</STYLE></HEAD>\n" +
            "<BODY><CENTER>\n"
            + "<div class=\"watermark\"></div>"
            
            
            + ""
            + "\n\n");
    pw.println("<!-- Creating Recipe From Kadysoft Ltd.-->\n\n");
    pw.println(roraa);
    pw.println("\n\n</center>\n</body>\n</html>");
    //pw.println("<b>Mr_Moharam Signature: "+"</b><img src=\""+pathtosignature+"\" width=\"300\" height=\"90\" alt=\"Developed By Kadysoft Ltd (Ahmed Elkady).\" style=\"border-color:black;border-width:10px;\">");
    
    if (roraa.contains("background-image:")) {
        
    }
    else {
        pw.println("\n\n<style>\n" +
                "body {\n" +
                "  background-image: url(\""+modely+".bmp\");\n" +
                        "  background-position: center;\n" +
                        "  height: 170px;\n" +
                        "background-position-x:550px;"+
                        "  background-repeat: no-repeat;\n" +
                        "  background-size: 120px 90px;\n" +
                        "}\n" +
                        "</style>");
    }
    pw.close();
    
    
    ///////////////////////////////////////////////////
    code.setText("");
    InputStream inputinstream=new FileInputStream(filePath);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    //BufferedReader bi=new BufferedReader (new FileReader (pathy));
    String lo;
    while ((lo=bi.readLine())!=null) {
        
        code.append("\n"+lo
                .replace("A","ﬦ")
                .replace("B","ﬧ")
                .replace("C","ﬨ")
                .replace("D","﬩")
                .replace("E","שׁ")
                .replace("F","שׂ")
                .replace("G","שּׁ")
                .replace("H","שּׂ")
                .replace("I","אַ")
                .replace("J","אָ")
                .replace("K","אּ")
                .replace("L","בּ")
                .replace("M","גּ")
                .replace("N","דּ")
                .replace("O","הּ")
                .replace("P","וּ")
                .replace("Q","זּ")
                .replace("R","טּ")
                .replace("S","יּ")
                .replace("T","ךּ")
                .replace("U","כּ")
                .replace("V","לּ")
                .replace("W","מּ")
                .replace("X","נּ")
                .replace("Y","סּ")
                .replace("Z","ףּ")
                
                .replace("0","פּ")
                .replace("1","צּ")
                .replace("2","קּ")
                .replace("3","רּ")
                .replace("4","שּ")
                .replace("5","תּ")
                .replace("6","וֹ")
                .replace("7","בֿ")
                .replace("8","כֿ")
                .replace("9","פֿ")
                
                .replace("a","ﬦ")
                .replace("b","ﬧ")
                .replace("c","ﬨ")
                .replace("d","﬩")
                .replace("e","שׁ")
                .replace("f","שׂ")
                .replace("g","שּׁ")
                .replace("h","שּׂ")
                .replace("i","אַ")
                .replace("j","אָ")
                .replace("k","אּ")
                .replace("l","בּ")
                .replace("m","גּ")
                .replace("n","דּ")
                .replace("o","הּ")
                .replace("p","וּ")
                .replace("q","זּ")
                .replace("r","טּ")
                .replace("s","יּ")
                .replace("t","ךּ")
                .replace("u","כּ")
                .replace("v","לּ")
                .replace("w","מּ")
                .replace("x","נּ")
                .replace("y","סּ")
                .replace("z","ףּ")
        );
        
        
    }
    bi.close();
    String gf=code.getText();
    OutputStream instreamm=new FileOutputStream(filePath);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    //PrintWriter pw=new PrintWriter (new FileWriter (pathy));
    pw.println(gf);
    pw.close();
    
    
    JWindow toast = new JWindow();
JPanel panel = new JPanel();
panel.setBackground(new Color(220, 53, 69)); // red error
panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
JLabel label = new JLabel("Successful, We have encrypted the recipe successfully.");
label.setForeground(Color.WHITE);
label.setFont(new Font("Segoe UI", Font.BOLD, 13));
panel.add(label);
toast.add(panel);
toast.pack();
toast.setLocationRelativeTo(null);
toast.setVisible(true);
new Timer(5000, e -> toast.dispose()).start();
    
    
    code.setText("");
    
}catch (Exception ssa) {}
//////////////////////////////////////////////////



//Desktop desk = Desktop.getDesktop();
//desk.open(new File (filePath));
JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(btnSave);
//topFrame.dispose();                        

///////////////////////////////////////////////////

///////////////////////////////////////////////////
       }
       
       
       //////////////////////////////////////////////////////////////////////////////////////////////////////////
       
       
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
       datevalue = timeString2;                                                          //Date
       modeloo=model;                 //Model
       filenammm=recipe;
       
       
       shoty=1;
       
       
       try {
           
           String sql0 = "select * from Timer where Name like '" + filenammm + "' and Model like '" + modeloo + "' ";
           pst = conn.prepareStatement(sql0);
           rs = pst.executeQuery();
           
           
           if (rs.next()) {
               
               //Update
               
               find.setText("found");
               
               ///////
               
           }
           
           ///////////////////////////////////////////////////////////////////////////////////
           
           
           else {
               
               //Insert
               
               find.setText("not_found");
               
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
       
       
       
       
       
       String fifi=find.getText();
       
       
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
                   
                   
                   
                   String sqlm = "select * from Timer where Name=?";
                   pst = conn.prepareStatement(sqlm);
                   pst.setString(1, filenammm);
                   rs = pst.executeQuery();
                   
                   String add1 = rs.getString("Time_In_Min");
                   oldtimemin=add1;  //OLD TIME IN MINUTES.
                   
                   String add2 = rs.getString("Time_In_Hour");
                   oldtimehour=add2;  //OLD TIME IN HOUR.
                   
                   String sqlp= "update Timer set Date='"+datevalue+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"', Total_Min='"+(mi1)+"', Total_Hour='"+(ti1)+"' where Name='"+filenammm+"' and Shot='"+ti3+"' ";
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
                   
                   
                   String sqlm = "select * from Timer where Name=? and Shot=?";
                   pst = conn.prepareStatement(sqlm);
                   pst.setString(1, filenammm);
                   pst.setString(2, ti3);
                   rs = pst.executeQuery();
                   
                   String add1 = rs.getString("Time_In_Min");
                   oldtimemin=add1;  //OLD TIME IN MINUTES.
                   
                   String add2 = rs.getString("Time_In_Hour");
                   oldtimehour=add2;  //OLD TIME IN HOUR.
                   
                   //   pst.execute();
                   
                   
                   String sqlp= "update Timer set Date='"+datevalue+"', Time_In_Min='"+oldtimemin+"', Time_In_Hour='"+oldtimehour+"', Time_In_Min_Updated='"+mi1+"', Time_In_Hour_Updated='"+ti1+"', Total_Min='"+(Double.toString(gmf1+gmf2))+"', Total_Hour='"+(Double.toString(gdf1+gdf2))+"'  where Name='"+filenammm+"' and Shot='"+ti3+"' ";
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
                   
                   
                   String sqlm = "select * from Timer where Name=? and Shot=?";
                   pst = conn.prepareStatement(sqlm);
                   pst.setString(1, filenammm);
                   pst.setString(2, ti4);
                   rs = pst.executeQuery();
                   
                   String add1 = rs.getString("Time_In_Min");
                   oldtimemin2=add1;  //OLD TIME IN MINUTES.
                   
                   String add2 = rs.getString("Time_In_Hour");
                   oldtimehour2=add2;  //OLD TIME IN HOUR.
                   
                   // pst.execute();
                   
                   
                   String sqlp= "update Timer set Date='"+datevalue+"', Time_In_Min='"+oldtimemin2+"', Time_In_Hour='"+oldtimehour2+"', Time_In_Min_Updated='"+mi2+"', Time_In_Hour_Updated='"+ti2+"', Total_Min='"+(Double.toString(gmf1+gmf2))+"', Total_Hour='"+(Double.toString(gdf1+gdf2))+"'  where Name='"+filenammm+"' and Shot='"+ti4+"' ";
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
                   
                   String reg = "insert into Timer (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated, Total_Min, Total_Hour) values (?,?,?,?,?,?,?,?,?,?)";
                   pst = conn.prepareStatement(reg);
                   pst.setString(1,datevalue);
                   pst.setString(2,modeloo);
                   pst.setString(3,filenammm);
                   pst.setString(4,Integer.toString(shoty));
                   pst.setString(5,Double.toString(gmf1));
                   pst.setString(6,Double.toString(gdf1));
                   pst.setString(7,"Hasnot_Updated_Yet");
                   pst.setString(8,"Hasnot_Updated_Yet");
                   pst.setString(9,Double.toString(gmf1));
                   pst.setString(10,Double.toString(gdf1));
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
                   
                   String reg = "insert into Timer (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated, Total_Min, Total_Hour) values (?,?,?,?,?,?,?,?,?,?)";
                   pst = conn.prepareStatement(reg);
                   pst.setString(1,datevalue);
                   pst.setString(2,modeloo);
                   pst.setString(3,filenammm);
                   pst.setString(4,Integer.toString(shoty));
                   pst.setString(5,Double.toString(gmf1));
                   pst.setString(6,Double.toString(gdf1));
                   pst.setString(7,"Hasnot_Updated_Yet");
                   pst.setString(8,"Hasnot_Updated_Yet");
                   pst.setString(9,Double.toString(gmf1+gmf2));
                   pst.setString(10,Double.toString(gdf1+gdf2));
                   pst.execute();
                   
                   
                   
                   
//          pst.setString(9,Double.toString(gmf1+gmf2));
//          pst.setString(10,Double.toString(gdf1+gdf2));
//          
//          , Total_Min='"+(mi1+mi2)+"', Total_Hour='"+(ti1+ti2)+"'


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
                   
                   String reg = "insert into Timer (Date, Model, Name, Shot, Time_In_Min, Time_In_Hour, Time_In_Min_Updated, Time_In_Hour_Updated, Total_Min, Total_Hour) values (?,?,?,?,?,?,?,?,?,?)";
                   pst = conn.prepareStatement(reg);
                   pst.setString(1,datevalue);
                   pst.setString(2,modeloo);
                   pst.setString(3,filenammm);
                   pst.setString(4,Integer.toString(shoty+1));
                   pst.setString(5,Double.toString(gmf2));
                   pst.setString(6,Double.toString(gdf2));
                   pst.setString(7,"Hasnot_Updated_Yet");
                   pst.setString(8,"Hasnot_Updated_Yet");
                   pst.setString(9,Double.toString(gmf1+gmf2));
                   pst.setString(10,Double.toString(gdf1+gdf2));
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
       
       
       
///////////////////////////////Calculate Cost/////////////////////////////////////////////////////////////

try{
    
    InputStream inputinstream=new FileInputStream(filePath);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    String lo;
    code.setText("");
    while ((lo=bi.readLine())!=null) {
        code.append("\n"+lo
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
    String gf=code.getText();
    OutputStream instreamm=new FileOutputStream(System.getProperty("user.home")+"\\r.ks");
    PrintWriter pwe = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    pwe.println(gf);
    pwe.close();
    
}catch(Exception sdd){}
///////////////////////////////////////////////////////////////////////////////////////////////////////////   
List<Double> pri = new ArrayList<>();
List<Double> qua = new ArrayList<>();
List<Double> dil = new ArrayList<>();
List<String> nom = new ArrayList<>();
String except=null;
////////////////////////////////////////////////

//Document docj = Jsoup.parse(roraa);

File inputFile = new File(System.getProperty("user.home")+"\\r.ks"); //
org.jsoup.nodes.Document docj = Jsoup.parse(inputFile, "UTF-8");
for (Element table : docj.select("TABLE")) {
    for (Element row : table.select("TR")) {
        Elements tds = row.select("TD");
        if (tds.get(8).text().isEmpty()||tds.get(8).text().contains("OLD STONE")) {
        }
        else {
            try {
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
                        String itaam = linebeforeequal;
                        nom.add(itaam);
                        break;
                    }
//else {
//except=except+"\n"+tds.get(8).text();
//}
                }
                buf.close();
            }catch(Exception sdd){}
        }
        
//////////////////////KG//////////////////////////
String skip=tds.get(8).text();
if (skip.equals("OLD STONE")) {   
}
else {
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
        String sky=tds.get(8).text();
        if (sky.equals("FOAM")) {
            double am=4.0/5.0;
            qua.add(am);
        }
        else {
            double am=Double.parseDouble(tds.get(5).text().replace(",","."))*12;
            qua.add(am);
        }
    }
    else {
        double number2 = Double.parseDouble(tds.get(5).text());
        qua.add(number2);
    }
}
//////////////////////////////////////////////
if (tds.get(8).text().isEmpty()||tds.get(8).text().contains("/")||tds.get(8).text().contains("\\")||tds.get(8).text().contains("CHEMICAL")||tds.get(8).text().contains("chemical")||tds.get(8).text().matches("[0-9_-]+")||tds.get(8).text().contains("TIME")||tds.get(8).text().contains("HOURS")||tds.get(8).text().contains("MINS")||tds.get(8).text().contains("SHOT")||tds.get(8).text().contains("OLD STONE")) {    
}
else {
    try {
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
    }catch(Exception sdd){}
}
///////////////////////////////////////////////
    }}
if (qua.size()!=pri.size()||qua.size()!=dil.size()) {
    
    
    JWindow toast = new JWindow();
JPanel panel = new JPanel();
panel.setBackground(new Color(220, 53, 69)); // red error
panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
JLabel label = new JLabel("Fatal Error!, We found that all chemicals names weren't set.\nWe suggest to fix chemicals again.");
label.setForeground(Color.WHITE);
label.setFont(new Font("Segoe UI", Font.BOLD, 13));
panel.add(label);
toast.add(panel);
toast.pack();
toast.setLocationRelativeTo(null);
toast.setVisible(true);
new Timer(5000, e -> toast.dispose()).start();
    
  
}
else {
//Show alert to write pcs.    
List<Double> result = new ArrayList<>();
for (int i = 0; i < qua.size(); i++) {
    result.add((qua.get(i) / dil.get(i))* pri.get(i));
}

summo = 0.0;
for (double number : result) {
    summo += number;
}
////////////////////////////////////////////////////////////////////////////////////////////

// Parse the HTML file
Document docv = Jsoup.parse(inputFile, "UTF-8");
// Find all table rows
Elements rows = docv.select("tr");
boolean pcsFound = false;
for (Element row : rows) {
    Elements cells = row.select("td");
    for (int i = 0; i < cells.size(); i++) {
        if ("PCS".equalsIgnoreCase(cells.get(i).text().trim())) {
            if (i + 1 < cells.size()) {
                String nextValue = cells.get(i + 1).text().trim();
                System.out.println("Next value after PCS: " + nextValue);
                pecoco=nextValue;
            } else {
                System.out.println("PCS found but no next cell.");
                pecoco="120";
            }
            pcsFound = true;
            break;
        }
        
        else if (cells.get(i).text().trim().contains("PCS")) {
            if (i + 1 < cells.size()) {
                String nextValue = cells.get(i + 1).text().trim();
                System.out.println("Next value after PCS: " + nextValue);
                pecoco=nextValue;
            } else {
                System.out.println("PCS found but no next cell.");
                pecoco="120";
            }
            pcsFound = true;
            break;
        }
        
    }
    
    if (pcsFound) break;
}

if (!pcsFound) {
    System.out.println("PCS not found");
    pecoco="";
}
/////////////////////////////////////////////////////////////////////////////////////////////

JTextField grr = new JTextField(pecoco);
grr.setPreferredSize(new Dimension(300, 25));
grr.setFont(new Font("Segoe UI", Font.BOLD, 15));
JPanel panel = new JPanel();
panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
JLabel label = new JLabel("Add PCS Number ...");
label.setFont(new Font("Segoe UI", Font.PLAIN, 13));
panel.add(label);
panel.add(Box.createVerticalStrut(5));
panel.add(grr);
JOptionPane.showMessageDialog(
        null,
        panel,
        "PCS Number?",
        JOptionPane.INFORMATION_MESSAGE
);

pcsnum=Double.parseDouble(grr.getText());
onegar=summo/pcsnum;
//Save To DB Here.

try {
    String sql0 = "select * from Cost where Name like '" + filenammm + "' and Model like '" + modeloo + "' ";
    pst = conn.prepareStatement(sql0);
    rs = pst.executeQuery();
    if (rs.next()) {                        
//Update
findo="found";
    }
    else {
//Insert
findo="not_found";
    }        
}catch (Exception exception) {
} 
finally {
    try {
        rs.close();
        pst.close();
    } catch (Exception exception) {}
}
if (findo.equals("found")) {
    try {
        String sqlm = "select * from Cost where Name=? and Model=?";
        pst = conn.prepareStatement(sqlm);
        pst.setString(1, filenammm);
        pst.setString(2, modeloo);
        rs = pst.executeQuery();
        String addd1 = rs.getString("Total_Cost_Old");
        oldtotalcost=addd1;
        String addd2 = rs.getString("PCS_Old");
        oldpcs=addd2;
        String addd3 = rs.getString("One_Garment_Old");
        oldonegarmentcost=addd3;
        
        String sqlp= "update Cost set Date='"+datevalue+"', Total_Cost_Old='"+oldtotalcost+"', PCS_Old='"+oldpcs+"', One_Garment_Old='"+oldonegarmentcost+"', Total_Cost_New='"+Double.toString(summo)+"', PCS_New='"+Double.toString(pcsnum)+"', One_Garment_New='"+Double.toString(onegar)+"' where Name='"+filenammm+"' and Model='"+modeloo+"'";
        pst=conn.prepareStatement(sqlp);
        pst.execute();
    }
    catch (Exception exception) {
    }
    finally {
        try {
            rs.close();
            pst.close();
            
            JWindow toast = new JWindow();
            JPanel panelf = new JPanel();
            panelf.setBackground(new Color(220, 53, 69)); // red error
            panelf.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            JLabel labelf = new JLabel("Successful, We have updated the cost successfully.");
            labelf.setForeground(Color.WHITE);
            labelf.setFont(new Font("Segoe UI", Font.BOLD, 13));
            panelf.add(labelf);
            toast.add(panelf);
            toast.pack();
            toast.setLocationRelativeTo(null);
            toast.setVisible(true);
            new Timer(5000, e -> toast.dispose()).start();
            
        } catch (Exception exception) {}
    }                               
}
else if (findo.equals("not_found")) {
    try {
        String reg = "insert into Cost (Date, Model, Name, Total_Cost_Old, PCS_Old, One_Garment_Old, Total_Cost_New, PCS_New, One_Garment_New) values (?,?,?,?,?,?,?,?,?)";
        pst = conn.prepareStatement(reg);
        pst.setString(1,datevalue);
        pst.setString(2,modeloo);
        pst.setString(3,filenammm);
        
        pst.setString(4,Double.toString(summo));
        pst.setString(5,Double.toString(pcsnum));
        pst.setString(6,Double.toString(onegar));
        
        pst.setString(7,"Hasnot_Updated_Yet");
        pst.setString(8,"Hasnot_Updated_Yet");
        pst.setString(9,"Hasnot_Updated_Yet");
        
        pst.execute();
    }
    catch (Exception exception) {
    }
    finally {
        try {
            rs.close();
            pst.close();
            
            JWindow toast = new JWindow();
            JPanel panelf = new JPanel();
            panelf.setBackground(new Color(220, 53, 69)); // red error
            panelf.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
            JLabel labelf = new JLabel("Successful, We have inserted the new cost successfully.");
            labelf.setForeground(Color.WHITE);
            labelf.setFont(new Font("Segoe UI", Font.BOLD, 13));
            panelf.add(labelf);
            toast.add(panelf);
            toast.pack();
            toast.setLocationRelativeTo(null);
            toast.setVisible(true);
            new Timer(5000, e -> toast.dispose()).start();
            
        } catch (Exception exception) {}
    }                               
}
else{}



//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
// CODE GOES HERE - ابدأ من هنا
// 2. باقي الكود اللي عندك (تنظيف الملف، Jsoup، إلخ) ...

Document docm = Jsoup.parse(inputFile, "UTF-8");

// ====================== استخراج PCS والشوتات ======================
SwingUtilities.invokeLater(() -> {
    try {
        Helper_Editor tempEditor = new Helper_Editor();

        String pcsStr = tempEditor.extractPCS(docm);
        double pcs = tempEditor.parsePCS(pcsStr);
        List<Shot> shotsy = tempEditor.extractShotsAndCosts(docm);

        appendLog("✅ تم استخراج " + shotsy.size() + " شوت و " + pcs + " قطعة");

        if (shotsy.isEmpty()) {
            showNotification("تحذير", "لم يتم العثور على كيماويات صالحة في: " + filenammm, true);
            return;   // نخرج من الـ lambda
        }

        // 3. حساب التكاليف
        double totalCost = 0.0;
        List<Double> shotCosts = new ArrayList<>();

        System.out.println("عدد الشوتات المكتشفة: " + shotsy.size());

        for (int i = 0; i < shotsy.size(); i++) {
            Shot shot = shotsy.get(i);
            double cost = shot.calculateCost();

            System.out.printf("شوت %d → تكلفة: %.4f (عدد الكيماويات: %d)%n",
                    (i + 1), cost, shot.quantities.size());

            shotCosts.add(cost);
            totalCost += cost;
        }

        double oneGarmentCost = pcs > 0 ? totalCost / pcs : 0.0;

        // 4. تحضير القيم للداتابيز
        String lastUpdate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        String shotsCount = String.valueOf(shotsy.size());
        String fsCost = shotsy.size() >= 1 ? String.format("%.4f", shotCosts.get(0)) : "0.0000";
        String ssCost = shotsy.size() >= 2 ? String.format("%.4f", shotCosts.get(1)) : "undefined";
        String tsCost = shotsy.size() >= 3 ? String.format("%.4f", shotCosts.get(2)) : "undefined";
        String fosCost = shotsy.size() >= 4 ? String.format("%.4f", shotCosts.get(3)) : "undefined";
        String totalCostStr = String.format("%.4f", totalCost);
        String oneGarmentStr = String.format("%.6f", oneGarmentCost);

        // 5. التحقق من وجود السجل + Update / Insert
        boolean recordExists = tempEditor.checkIfRecordExists(filenammm, modeloo, stageoo);

        if (recordExists) {
            // ================ UPDATE ================
            try (PreparedStatement pstUpdate = conn.prepareStatement(
                    "UPDATE Cost_By_Shot SET " +
                    "Last_Update = ?, Shots = ?, FSCost = ?, SSCost = ?, TSCost = ?, FOSCost = ?, " +
                    "Total_Cost = ?, PCS = ?, One_Garment_Cost = ? " +
                    "WHERE Wash_Name = ? AND Model = ? AND Stage = ?")) {

                pstUpdate.setString(1, lastUpdate);
                pstUpdate.setString(2, shotsCount);
                pstUpdate.setString(3, fsCost);
                pstUpdate.setString(4, ssCost);
                pstUpdate.setString(5, tsCost);
                pstUpdate.setString(6, fosCost);
                pstUpdate.setString(7, totalCostStr);
                pstUpdate.setString(8, pcsStr);
                pstUpdate.setString(9, oneGarmentStr);
                pstUpdate.setString(10, filenammm);
                pstUpdate.setString(11, modeloo);
                pstUpdate.setString(12, stageoo);

                pstUpdate.executeUpdate();

                appendLog("🔄 تم تحديث السجل في Cost_By_Shot");
                showNotification("تم التحديث", "تم تحديث تكلفة الريسيبي: " + filenammm, false);

            } catch (Exception dsd) {
                dsd.printStackTrace();
                appendLog("❌ خطأ أثناء التحديث: " + dsd.getMessage());
            }

        } else {
            // ================ INSERT ================
            try (PreparedStatement pstInsert = conn.prepareStatement(
                    "INSERT INTO Cost_By_Shot (" +
                    "Last_Update, Stage, Model, Wash_Name, Shots, FSCost, SSCost, TSCost, FOSCost, " +
                    "Total_Cost, PCS, One_Garment_Cost) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

                pstInsert.setString(1, lastUpdate);
                pstInsert.setString(2, stageoo);
                pstInsert.setString(3, modeloo);
                pstInsert.setString(4, filenammm);
                pstInsert.setString(5, shotsCount);
                pstInsert.setString(6, fsCost);
                pstInsert.setString(7, ssCost);
                pstInsert.setString(8, tsCost);
                pstInsert.setString(9, fosCost);
                pstInsert.setString(10, totalCostStr);
                pstInsert.setString(11, pcsStr);
                pstInsert.setString(12, oneGarmentStr);

                pstInsert.executeUpdate();

                appendLog("📝 تم إضافة سجل جديد في Cost_By_Shot");
                showNotification("تم الإدراج", "تم إضافة تكلفة الريسيبي الجديد: " + filenammm, false);

            } catch (Exception dsd) {
                dsd.printStackTrace();
                appendLog("❌ خطأ أثناء الإدراج: " + dsd.getMessage());
            }
        }

    } catch (Exception ex) {
        ex.printStackTrace();
        appendLog("❌ خطأ في استخراج بيانات الـ PCS والشوتات: " + ex.getMessage());
    }
});

//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////



JPanel panely = new JPanel();
panely.setLayout(new BoxLayout(panely, BoxLayout.Y_AXIS));
panely.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
JLabel header = new JLabel("Cost Result");
header.setFont(new Font("Segoe UI", Font.BOLD, 14));
JLabel contenty = new JLabel(
        "Here is the result of chemicals costs for one garment : " + onegar + " $."
);
contenty.setFont(new Font("Segoe UI", Font.PLAIN, 13));
panely.add(header);
panely.add(Box.createVerticalStrut(10));
panely.add(contenty);
Object[] options = {"Report", "Cancel"};
int resulty = JOptionPane.showOptionDialog(
        null,
        panely,
        "Result",
        JOptionPane.DEFAULT_OPTION,
        JOptionPane.INFORMATION_MESSAGE,
        null,
        options,
        options[0]
);
if (resulty == 0) {  
//Create Report.  (PDF)
////////////////////////////Start Report//////////////////////////////
Date currentDate = GregorianCalendar.getInstance().getTime();
DateFormat df = DateFormat.getDateInstance();
String dateString = df.format(currentDate);
Date d = new Date();
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
String timeString = sdf.format(d);
String value0 = timeString;
String value00 = value0.replace("/", "_");
String repname = "Chemical_Report_Of_"+filenammm;
String reppath = System.getProperty("user.home") + "\\Desktop";

JFileChooser dialog = new JFileChooser();
dialog.setCurrentDirectory(
        new File(reppath)
);
dialog.setSelectedFile(new File(recipe + ".ks"));
// filters
dialog.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
        "PDF Files", "pdf"
));

int resulti = dialog.showSaveDialog(null);
if (resulti == JFileChooser.APPROVE_OPTION) {
    File dialogResult = dialog.getSelectedFile();
    String filePath = dialogResult.getAbsolutePath();
}


try {
    com.itextpdf.text.Document myDocument = new com.itextpdf.text.Document();
    PdfWriter myWriter = PdfWriter.getInstance(myDocument, new FileOutputStream(filePath));
    PdfPTable table = new PdfPTable(5);
    table.size();
    //table.setHorizontalAlignment(1);
    myDocument.open();
    float[] columnWidths = { 15.0F, 15.0F,15.0F,15.0F,15.0F };
    table.setWidths(columnWidths);
    table.setWidthPercentage(100.0F);
    myDocument.add((com.itextpdf.text.Element)new Paragraph("Cost Report For "+filenammm+" Recipe. ", FontFactory.getFont("Times-Bold", 12.0F, 1)));
    myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------------------------------------------------------------------"));
    table.addCell(new PdfPCell((Phrase)new Paragraph("Name", FontFactory.getFont("Times-Roman", 10.0F, 1))));
    table.addCell(new PdfPCell((Phrase)new Paragraph("Quantity", FontFactory.getFont("Times-Roman", 10.0F, 1))));
    table.addCell(new PdfPCell((Phrase)new Paragraph("Dilution", FontFactory.getFont("Times-Roman", 10.0F, 1))));
    table.addCell(new PdfPCell((Phrase)new Paragraph("Price", FontFactory.getFont("Times-Roman", 10.0F, 1))));
    table.addCell(new PdfPCell((Phrase)new Paragraph("Total", FontFactory.getFont("Times-Roman", 10.0F, 1))));
    int no=0;
    int stageno=1;
    while (no<qua.size()) {
        table.addCell(new PdfPCell((Phrase)new Paragraph(nom.get(no), FontFactory.getFont("Times-Roman", 8.0F, 0))));
        table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(qua.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
        table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(dil.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
        table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString(pri.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
        table.addCell(new PdfPCell((Phrase)new Paragraph(Double.toString((qua.get(no)/dil.get(no))*pri.get(no)), FontFactory.getFont("Times-Roman", 8.0F, 0))));
        no++;
    }
    myDocument.add((com.itextpdf.text.Element)table);
    myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------"));
    myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost (New) :    "+Double.toString(summo)+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
    myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments (New) :    "+Double.toString(pcsnum)+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
    myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs (New) :    "+Double.toString(onegar)+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
    myDocument.add((com.itextpdf.text.Element)new Paragraph("--------------------------------------------------------------------------------------------"));
    myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Cost (Old) :    "+oldtotalcost+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
    myDocument.add((com.itextpdf.text.Element)new Paragraph("Total Of Garments (Old) :    "+oldpcs+"          PCS.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
    myDocument.add((com.itextpdf.text.Element)new Paragraph("One Garment Costs (Old) :    "+oldonegarmentcost+"          $.", FontFactory.getFont("Times-Bold", 10.0F, 1)));
    myDocument.add((com.itextpdf.text.Element)new Paragraph("-------------------------------"));
    myDocument.setPageSize(PageSize.A4.rotate());
    myDocument.close();
    
    JWindow toast = new JWindow();
    JPanel panelg = new JPanel();
    panelg.setBackground(new Color(220, 53, 69)); // red error
    panelg.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
    JLabel labelg = new JLabel("Info, Report was generated successfully");
    labelg.setForeground(Color.WHITE);
    labelg.setFont(new Font("Segoe UI", Font.BOLD, 13));
    panelg.add(labelg);
    toast.add(panelg);
    toast.pack();
    toast.setLocationRelativeTo(null);
    toast.setVisible(true);
    new Timer(5000, e -> toast.dispose()).start();
    
} catch (Exception e) {
} finally {
    try {
    } catch (Exception e) {
    }
}

try { 
    
    Desktop de = Desktop.getDesktop();
    de.open(new File(reppath + "\\" + repname + ".pdf"));
    
} catch (Exception jd) {}

////////////////////////////End Report////////////////////////////////
} 
else {}
}   

////////////////////Send Mails Here///////////////////////////////////////////////////////////////////////

try {
    
    
    new Thread(new Runnable() {
        @Override
        public void run() {
            
            String from,password,to,sub,suby;
            from="ahmedelkadyteeest@gmail.com";
            password="lgrj esca tdtz froo";
            //to=it;
            sub="Recipe Editor (RECETA).";
            suby="Recipe Editor (RECETA) Powered By Kadysoft Ltd - All Rights Reserved. Ahmed Elkady - CEO.";
            
            if (bosbos==1) {
                
                if (user.contains("Ahmed Elkady")||user.contains("KADINIO")) {
                    
                    msg="Date: "+datevalue+"\nCustomer - Recipe_Name: "+modeloo+" - "+filenammm+"\nEditor_Name: "+user+"   ***- Free Editor At Anytime, Ask For Help On Whatsapp At: +201555266002. -***"+"\nShots: 1\nOld_Time: "+oldtimehour+"   Hours."+"\nNew_Time: "+gdf1+"   Hours."+
                            
                            "\n-------------------------------------------------"
                            + "\nHere is All Info About Cost:"
                            + "\n---------------NEW----------------"
                            + "\n"
                            + "\nTotal Of Cost (New) :    "+Double.toString(summo)+"          $."
                            + "\nTotal Of Garments (New) :    "+Double.toString(pcsnum)+"          PCS."
                            + "\nOne Garment Costs (New) :    "+Double.toString(onegar)+"          $."
                            + "\n---------------OLD----------------"
                            + "\n"
                            + "\nTotal Of Cost (Old) :    "+oldtotalcost+"          $."
                            + "\nTotal Of Garments (Old) :    "+oldpcs+"          PCS."
                            + "\nOne Garment Costs (Old) :    "+oldonegarmentcost+"          $."
                            + "\n-------------------------------------------------"+
                            
                            "\n\n\n"+suby+"\n\n\n"+
                            
                            "▒█░▄▀ ░█▀▀█ ▒█▀▀▄ ▒█░░▒█ ▒█▀▀▀█ ▒█▀▀▀█ ▒█▀▀▀ ▀▀█▀▀ 　 ▒█░░░ ▀▀█▀▀ ▒█▀▀▄ \n" +
                            "▒█▀▄░ ▒█▄▄█ ▒█░▒█ ▒█▄▄▄█ ░▀▀▀▄▄ ▒█░░▒█ ▒█▀▀▀ ░▒█░░ 　 ▒█░░░ ░▒█░░ ▒█░▒█ \n" +
                            "▒█░▒█ ▒█░▒█ ▒█▄▄▀ ░░▒█░░ ▒█▄▄▄█ ▒█▄▄▄█ ▒█░░░ ░▒█░░ 　 ▒█▄▄█ ░▒█░░ ▒█▄▄▀";
                    
                }
                
                
                else {
                    msg="Date: "+datevalue+"\nCustomer - Recipe_Name: "+modeloo+" - "+filenammm+"\nEditor_Name: "+user+"\nShots: 1\nOld_Time: "+oldtimehour+"   Hours."+"\nNew_Time: "+gdf1+"   Hours."+
                            
                            "\n-------------------------------------------------"
                            + "\nHere is All Info About Cost:"
                            + "\n---------------NEW----------------"
                            + "\n"
                            + "\nTotal Of Cost (New) :    "+Double.toString(summo)+"          $."
                            + "\nTotal Of Garments (New) :    "+Double.toString(pcsnum)+"          PCS."
                            + "\nOne Garment Costs (New) :    "+Double.toString(onegar)+"          $."
                            + "\n---------------OLD----------------"
                            + "\n"
                            + "\nTotal Of Cost (Old) :    "+oldtotalcost+"          $."
                            + "\nTotal Of Garments (Old) :    "+oldpcs+"          PCS."
                            + "\nOne Garment Costs (Old) :    "+oldonegarmentcost+"          $."
                            + "\n-------------------------------------------------"+
                            
                            "\n\n\n"+suby+"\n\n\n"+
                            "▒█░▄▀ ░█▀▀█ ▒█▀▀▄ ▒█░░▒█ ▒█▀▀▀█ ▒█▀▀▀█ ▒█▀▀▀ ▀▀█▀▀ 　 ▒█░░░ ▀▀█▀▀ ▒█▀▀▄ \n" +
                            "▒█▀▄░ ▒█▄▄█ ▒█░▒█ ▒█▄▄▄█ ░▀▀▀▄▄ ▒█░░▒█ ▒█▀▀▀ ░▒█░░ 　 ▒█░░░ ░▒█░░ ▒█░▒█ \n" +
                            "▒█░▒█ ▒█░▒█ ▒█▄▄▀ ░░▒█░░ ▒█▄▄▄█ ▒█▄▄▄█ ▒█░░░ ░▒█░░ 　 ▒█▄▄█ ░▒█░░ ▒█▄▄▀";
                }
                
                
            }
            
            if (bosbos==2) {
                
                
                if (user.contains("Ahmed Elkady")||user.contains("KADINIO")) {
                    
                    msg="Date: "+datevalue+"\nCustomer - Recipe_Name: "+modeloo+" - "+filenammm+"\nEditor_Name: "+user+"   ***- Free Editor At Anytime, Ask For Help On Whatsapp At: +201555266002. -***"+"\nShots: 2\nOld_Time_First_Shot: "+oldtimehour+"   Hours."+"\nOld_Time_Second_Shot: "+oldtimehour2+"   Hours."+"\nNew_Time_First_Shot: "+gdf1+"   Hours."+"\nNew_Time_Second_Shot: "+gdf2+"   Hours."+
                            
                            
                            "\n-------------------------------------------------"
                            + "\nHere is All Info About Cost:"
                            + "\n---------------NEW----------------"
                            + "\n"
                            + "\nTotal Of Cost (New) :    "+Double.toString(summo)+"          $."
                            + "\nTotal Of Garments (New) :    "+Double.toString(pcsnum)+"          PCS."
                            + "\nOne Garment Costs (New) :    "+Double.toString(onegar)+"          $."
                            + "\n---------------OLD----------------"
                            + "\n"
                            + "\nTotal Of Cost (Old) :    "+oldtotalcost+"          $."
                            + "\nTotal Of Garments (Old) :    "+oldpcs+"          PCS."
                            + "\nOne Garment Costs (Old) :    "+oldonegarmentcost+"          $."
                            + "\n-------------------------------------------------"+
                            
                            
                            "\n\n\n"+suby+"\n\n\n"+
                            "▒█░▄▀ ░█▀▀█ ▒█▀▀▄ ▒█░░▒█ ▒█▀▀▀█ ▒█▀▀▀█ ▒█▀▀▀ ▀▀█▀▀ 　 ▒█░░░ ▀▀█▀▀ ▒█▀▀▄ \n" +
                            "▒█▀▄░ ▒█▄▄█ ▒█░▒█ ▒█▄▄▄█ ░▀▀▀▄▄ ▒█░░▒█ ▒█▀▀▀ ░▒█░░ 　 ▒█░░░ ░▒█░░ ▒█░▒█ \n" +
                            "▒█░▒█ ▒█░▒█ ▒█▄▄▀ ░░▒█░░ ▒█▄▄▄█ ▒█▄▄▄█ ▒█░░░ ░▒█░░ 　 ▒█▄▄█ ░▒█░░ ▒█▄▄▀";
                    
                }
                
                else {
                    msg="Date: "+datevalue+"\nCustomer - Recipe_Name: "+modeloo+" - "+filenammm+"\nEditor_Name: "+user+"\nShots: 2\nOld_Time_First_Shot: "+oldtimehour+"   Hours."+"\nOld_Time_Second_Shot: "+oldtimehour2+"   Hours."+"\nNew_Time_First_Shot: "+gdf1+"   Hours."+"\nNew_Time_Second_Shot: "+gdf2+"   Hours."+
                            
                            
                            "\n-------------------------------------------------"
                            + "\nHere is All Info About Cost:"
                            + "\n---------------NEW----------------"
                            + "\n"
                            + "\nTotal Of Cost (New) :    "+Double.toString(summo)+"          $."
                            + "\nTotal Of Garments (New) :    "+Double.toString(pcsnum)+"          PCS."
                            + "\nOne Garment Costs (New) :    "+Double.toString(onegar)+"          $."
                            + "\n---------------OLD----------------"
                            + "\n"
                            + "\nTotal Of Cost (Old) :    "+oldtotalcost+"          $."
                            + "\nTotal Of Garments (Old) :    "+oldpcs+"          PCS."
                            + "\nOne Garment Costs (Old) :    "+oldonegarmentcost+"          $."
                            + "\n-------------------------------------------------"+
                            
                            
                            "\n\n\n"+suby+"\n\n\n"+
                            "▒█░▄▀ ░█▀▀█ ▒█▀▀▄ ▒█░░▒█ ▒█▀▀▀█ ▒█▀▀▀█ ▒█▀▀▀ ▀▀█▀▀ 　 ▒█░░░ ▀▀█▀▀ ▒█▀▀▄ \n" +
                            "▒█▀▄░ ▒█▄▄█ ▒█░▒█ ▒█▄▄▄█ ░▀▀▀▄▄ ▒█░░▒█ ▒█▀▀▀ ░▒█░░ 　 ▒█░░░ ░▒█░░ ▒█░▒█ \n" +
                            "▒█░▒█ ▒█░▒█ ▒█▄▄▀ ░░▒█░░ ▒█▄▄▄█ ▒█▄▄▄█ ▒█░░░ ░▒█░░ 　 ▒█▄▄█ ░▒█░░ ▒█▄▄▀";
                    
                }
                
            }
            
            
            
            Properties props = new Properties();
            props.put("mail.smtp.host", "smtp.gmail.com");
            props.put("mail.smtp.socketFactory.port", "465");
            props.put("mail.smtp.socketFactory.class",
                    "javax.net.ssl.SSLSocketFactory");
            props.put("mail.smtp.auth", "true");
            props.put("mail.smtp.port", "465");
            Session session = Session.getDefaultInstance(props,
                    new javax.mail.Authenticator() {
                        protected PasswordAuthentication getPasswordAuthentication() {
                            return new PasswordAuthentication(from,password);
                        }
                    });
            try {
                MimeMessage message = new MimeMessage(session);
                
                //For mailing by the old method just uncomment codes and comment current method then go straight.
                
                String[] mailToId={"kemal.duman@tcgarments.com","muhammet.eraslan@tcgarments.com","eyup.karakoyun@tcgarments.com","ahmed.nassif@tcgarments.com","hany.emeira@tcgarments.com"/*,"chemical.store@tcgarments.com"*/,"rainforest.tc@tcgarments.com","yilmaz.bozkir@tcgarments.com","ahmed.elkady@tcgarments.com"};
                for(int i=0;i<mailToId.length;i++){
                    message.addRecipients(Message.RecipientType.TO, mailToId[i]);
                }
                
                //message.addRecipient(Message.RecipientType.TO,new InternetAddress(it));
                message.setSubject(sub);
                //message.setText(msg, "text/plain; charset=UTF-8");
                message.setContent(msg, "text/plain; charset=UTF-8");
                Transport.send(message);
                System.out.println("Successful");
            } catch (MessagingException e) {throw new RuntimeException(e);}
            
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
try {
    String sqla = "INSERT INTO Notifications (Recipient, Sender, Message, Delivered) VALUES (?, ?, ?, 0)";
    pst = conn.prepareStatement(sqla);
    pst.setString(1, "Recipe_Maker");
    pst.setString(2, "Ahmed Elkady");
    pst.setString(3, "We have updated "+filenammm+" successfully in "+datevalue+" of "+modeloo+" model.");
    pst.executeUpdate();
}
catch (Exception e) {
} finally {
    try {
        rs.close();
        pst.close();
    } catch (Exception exception) {}}  
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        }
    }).start();
    
    
}

catch (Exception m) {
    
}



//////////////////////////////////////////////////////////////////////////////////////////


///////////////////////////////////////////////////////////////////////////////////////////////////////////
   } catch (IOException ex) {
                    Logger.getLogger(Helper_Editor.class.getName()).log(Level.SEVERE, null, ex);
      }
      }



















      else if (option == JOptionPane.CANCEL_OPTION) {

   ///////////////////////////////////////Everything Will Go Here///////////////////////////////////////////////////

   String thecodee=content;

   if (signme.isSelected()==true) {
       
       
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   if (fixche.isSelected()==true) {
       
      String codee = thecodee;
      if (!codee.contains("TABLE")) {
          
         JWindow toast = new JWindow();
JPanel panel = new JPanel();
panel.setBackground(new Color(220, 53, 69)); // red error
panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
JLabel label = new JLabel("Recipe Error, Maybe not a recipe, Open a recipe first!.");
label.setForeground(Color.WHITE);
label.setFont(new Font("Segoe UI", Font.BOLD, 13));
panel.add(label);
toast.add(panel);
toast.pack();
toast.setLocationRelativeTo(null);
toast.setVisible(true);
new Timer(5000, e -> toast.dispose()).start();
          

        }
        else {
            Document docj = Jsoup.parse(codee);
        for (Element table : docj.select("TABLE")) {
        for (Element row : table.select("TR")) {
            Elements tds = row.select("TD");
            if (tds.get(7).text().isEmpty()) {   
            }
            else {
                
      try {          
             ///////////////////////////////////////////////////////////////
String string=tds.get(7).text();
BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Chemical_Dictionary.kady"));
String line;
String linebeforeequal;
String lineafterequal;
while ((line=buf.readLine())!=null) {
linebeforeequal=line.substring(0,line.indexOf("=")-0);
lineafterequal=line.substring(line.indexOf("=") + 1 , line.length());
if (string.equals(lineafterequal)) {
//System.out.println(string+" = "+linebeforeequal);
String formattedText = "<b style='display:block; text-align:center;'>" + linebeforeequal + "</b>";
tds.get(8).html(formattedText); // Use .html() instead of .text()     
//tds.get(8).text(linebeforeequal);
//System.out.println(tds.get(8).text());
break;

    }
    else {
        
    }
    
}
buf.close();

      } catch (Exception hds) {}
    
            }   
         
        }}
       roraa=docj.toString();
        }
       
      
      ////////////////////////////////////////////////////////////////////////////// 
org.jsoup.nodes.Document doct = Jsoup.parse(roraa);
for (Element table : doct.select("TABLE")) {
for (Element row : table.select("TR")) {
Elements tds = row.select("TD");
if (tds.get(8).text().isEmpty()) {   
}
else {
   
  try {
    
String string=tds.get(8).text();
BufferedReader bufi=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Lot_Numbers.kady"));
String line;
String linebeforeequal;//Chemical Name
String lineafterequal;//Lot Numbers
boolean found = false;         
while ((line=bufi.readLine())!=null) {
linebeforeequal=line.substring(0,line.indexOf("="));//Chemical Name
lineafterequal=line.substring(line.indexOf("=") + 1);//Lot Numbers
if (string.equalsIgnoreCase(linebeforeequal)) {
System.out.println(linebeforeequal);
String formattedText = "<b style='display:block; text-align:center;'>" + lineafterequal + "</b>";
tds.get(9).html(formattedText); // Use .html() instead of .text()     
//tds.get(9).text(lineafterequal);
found = true;                    
break;
    }   
}
bufi.close();
} catch (Exception hds) {}

}}}
roraa=doct.toString();      
//////////////////////////////////////////////////////////////////////////////
      
org.jsoup.nodes.Document doctp = Jsoup.parse(roraa);

// مر على كل جدول
for (Element table : doctp.select("table")) {
    for (Element row : table.select("tr")) {
        Elements tds = row.select("td");

        // اتأكد إن فيه على الأقل 11 عمود (0 → 10)
        if (tds.size() > 10) {
            String target = tds.get(8).text().trim();

            if (!target.isEmpty()) {
                Path mapPath = Paths.get(NewDir.file_dirrrr, "Recipe_Indexes", "Chemical_Translation.kady");

                try (BufferedReader bufi = Files.newBufferedReader(mapPath, StandardCharsets.UTF_8)) {
                    String line;
                    boolean found = false;

                    while ((line = bufi.readLine()) != null) {
                        // اتأكد إن السطر فيه =
                        if (!line.contains("=")) continue;

                        String linebeforeequal = line.substring(0, line.indexOf("=")).trim();
                        String lineafterequal = line.substring(line.indexOf("=") + 1).trim();

                        if (target.equalsIgnoreCase(linebeforeequal)) {
                            System.out.println("Matched: " + linebeforeequal);

                            String formattedText =
                                    "<b style='display:block; text-align:center;'>" +
                                            lineafterequal +
                                            "</b>";

                            // استبدل العمود رقم 10 بالنص الجديد
                            tds.get(10).html(formattedText);

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("No match for: " + target);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

roraa = doctp.toString();

   }
   
   else {
       
       //Continue..........
       roraa=code.getText();
   }
    
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
            //String codee=code.getText();
            String pathtosignature="file://"+NewDir.file_dirrrrr+"\\Mr_Muhammet.png";
            String modely=model;
            
            
JFileChooser dialog = new JFileChooser();
dialog.setCurrentDirectory(
        new File(NewDir.file_dir + "\\" + stage + "\\" + model)
);
dialog.setSelectedFile(new File(recipe + ".ks"));
// filters
dialog.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
        "Kadysoft Files", "ks"
));
dialog.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
        "HTML Files", "html"
));
int result = dialog.showSaveDialog(null);
if (result == JFileChooser.APPROVE_OPTION) {
    File dialogResult = dialog.getSelectedFile();
    filePath = dialogResult.getAbsolutePath();
}
            
            
            try {
            
            OutputStream instream=new FileOutputStream(filePath);
            pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
            pw.println("<!DOCTYPE html>\n<html lang=\"ar\">\n<head>\n<title>Kadysoft</title>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<style>td {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}\ntable {\nheight:5px;\nmax-width:100%;\nheight:100%;\nwhite-space:nowrap;\n}\ntr {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}"
                    + ""
                    + ""
                    
                        + ""
                + "/* Centered Watermark */\n" +
"    .watermark {\n" +
"      position: fixed;\n" +
"      top: 50%;\n" +
"      left: 50%;\n" +
"      transform: translate(-50%, -50%) rotate(-45deg);\n" +
"      background-image: url('logo.png'); /* Replace with the path to T & C Garments logo */\n" +
"      background-repeat: no-repeat;\n" +
"      background-size: contain;\n" +
"      width: 300px;\n" +
"      height: 200px;\n" +
"      opacity: 0.3;\n" +
"      pointer-events: none;\n" +
"      z-index: 1000;\n" +
"    }\n" +
"    /* Repeated Watermark */\n" +
"    .watermark-repeated {\n" +
"      position: fixed;\n" +
"      top: 0;\n" +
"      left: 0;\n" +
"      width: 100%;\n" +
"      height: 100%;\n" +
"      background-image: url('logo.png'); /* Replace with the path to T & C Garments logo */\n" +
"      background-repeat: repeat;\n" +
"      background-size: 300px 200px;\n" +
"      opacity: 0.2;\n" +
"      pointer-events: none;\n" +
"      z-index: 1000;\n" +
"    }"
                + ""
                + "</STYLE></HEAD>\n" +
"<BODY><CENTER>\n"
+ "<div class=\"watermark\"></div>" 
                
                    
                    + ""
                    + "\n\n");
            pw.println("<!-- Creating Recipe From Kadysoft Ltd.-->\n\n");
            pw.println(roraa);
            pw.println("\n\n</center>\n</body>\n</html>");
            pw.println("<b id=\"signname\">Mr_Muhammet Signature: "+"</b><img id=\"signimage\" src=\""+pathtosignature+"\" width=\"300\" height=\"90\" alt=\"Developed By Kadysoft Ltd (Ahmed Elkady).\" style=\"border-color:black;border-width:10px;\">");   
      
            if (roraa.contains("background-image:")) {
                
            }
            else {
                pw.println("\n\n<style>\n" +
"body {\n" +
"  background-image: url(\""+modely+".bmp\");\n" +
"  background-position: center;\n" +
"  height: 170px;\n" +
"background-position-x:550px;"+
"  background-repeat: no-repeat;\n" +
"  background-size: 120px 90px;\n" +
"}\n" +
"</style>");             
          }
            pw.close();
            
           } catch (Exception hds) {} 
            
    /////////////////////////////////////////////////// 
    code.setText("");
    
    try {
    
    InputStream inputinstream=new FileInputStream(filePath);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    //BufferedReader bi=new BufferedReader (new FileReader (pathy));
    String lo;
    while ((lo=bi.readLine())!=null) {
        
        code.append("\n"+lo
       .replace("A","ﬦ")
       .replace("B","ﬧ")
       .replace("C","ﬨ")
       .replace("D","﬩")
       .replace("E","שׁ")    
       .replace("F","שׂ")        
       .replace("G","שּׁ")         
       .replace("H","שּׂ")         
       .replace("I","אַ")         
       .replace("J","אָ")         
       .replace("K","אּ")         
       .replace("L","בּ")         
       .replace("M","גּ")         
       .replace("N","דּ")         
       .replace("O","הּ")         
       .replace("P","וּ")         
       .replace("Q","זּ")         
       .replace("R","טּ")         
       .replace("S","יּ")         
       .replace("T","ךּ")         
       .replace("U","כּ")         
       .replace("V","לּ")
       .replace("W","מּ")         
       .replace("X","נּ")         
       .replace("Y","סּ")         
       .replace("Z","ףּ")
                
       .replace("0","פּ")         
       .replace("1","צּ")         
       .replace("2","קּ")         
       .replace("3","רּ")         
       .replace("4","שּ")         
       .replace("5","תּ")         
       .replace("6","וֹ")         
       .replace("7","בֿ")         
       .replace("8","כֿ")
       .replace("9","פֿ")
                
       .replace("a","ﬦ")
       .replace("b","ﬧ")
       .replace("c","ﬨ")
       .replace("d","﬩")
       .replace("e","שׁ")    
       .replace("f","שׂ")        
       .replace("g","שּׁ")         
       .replace("h","שּׂ")         
       .replace("i","אַ")         
       .replace("j","אָ")         
       .replace("k","אּ")         
       .replace("l","בּ")         
       .replace("m","גּ")         
       .replace("n","דּ")         
       .replace("o","הּ")         
       .replace("p","וּ")         
       .replace("q","זּ")         
       .replace("r","טּ")         
       .replace("s","יּ")         
       .replace("t","ךּ")         
       .replace("u","כּ")         
       .replace("v","לּ")
       .replace("w","מּ")         
       .replace("x","נּ")         
       .replace("y","סּ")         
       .replace("z","ףּ")                
      ); 


    }
    bi.close();
    String gf=code.getText();
    OutputStream instreamm=new FileOutputStream(filePath);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    //PrintWriter pw=new PrintWriter (new FileWriter (pathy));
    pw.println(gf);
    pw.close();
    
             JWindow toast = new JWindow();
JPanel panel = new JPanel();
panel.setBackground(new Color(220, 53, 69)); // red error
panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
JLabel label = new JLabel("Successful, We have encrypted the recipe successfully.");
label.setForeground(Color.WHITE);
label.setFont(new Font("Segoe UI", Font.BOLD, 13));
panel.add(label);
toast.add(panel);
toast.pack();
toast.setLocationRelativeTo(null);
toast.setVisible(true);
new Timer(5000, e -> toast.dispose()).start();
       
    
 
    
    code.setText("");

    } catch (Exception hds) {}
    
       //////////////////////////////////////////////////
            
            
            //Desktop desk = Desktop.getDesktop();
            //desk.open(new File (filePath));
            JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(btnSave);
            //topFrame.dispose();
   
       /////////////////////////////////////////////////// 
   
       //////////////////////////////////////////////////
       
   }
   
   
   else {
       
       
       
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
   
   if (fixche.isSelected()==true) {
       
       String codee = code.getText();
      if (!codee.contains("TABLE")) {
          
JWindow toast = new JWindow();
JPanel panel = new JPanel();
panel.setBackground(new Color(220, 53, 69)); // red error
panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
JLabel label = new JLabel("Recipe Error, Maybe not a recipe, Open a recipe first!.");
label.setForeground(Color.WHITE);
label.setFont(new Font("Segoe UI", Font.BOLD, 13));
panel.add(label);
toast.add(panel);
toast.pack();
toast.setLocationRelativeTo(null);
toast.setVisible(true);
new Timer(5000, e -> toast.dispose()).start();
      
        }
        else {
            Document docj = Jsoup.parse(codee);
        for (Element table : docj.select("TABLE")) {
        for (Element row : table.select("TR")) {
            Elements tds = row.select("TD");
            if (tds.get(7).text().isEmpty()) {   
            }
            else {  
             ///////////////////////////////////////////////////////////////
             
             try {
             
String string=tds.get(7).text();
BufferedReader buf=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Chemical_Dictionary.kady"));
String line;
String linebeforeequal;
String lineafterequal;
while ((line=buf.readLine())!=null) {
linebeforeequal=line.substring(0,line.indexOf("=")-0);
lineafterequal=line.substring(line.indexOf("=") + 1 , line.length());
if (string.equals(lineafterequal)) {
//System.out.println(string+" = "+linebeforeequal);
String formattedText = "<b style='display:block; text-align:center;'>" + linebeforeequal + "</b>";
tds.get(8).html(formattedText); // Use .html() instead of .text()     
//tds.get(8).text(linebeforeequal);
//System.out.println(tds.get(8).text());
break;

    }
    else {
        
    }
    
}
buf.close();

             } catch (Exception dfgf) {}
    
            }   
         
        }}
       roraa=docj.toString();
        }
      
      
      ////////////////////////////////////////////////////////////////////////////// 
org.jsoup.nodes.Document doct = Jsoup.parse(roraa);
for (Element table : doct.select("TABLE")) {
for (Element row : table.select("TR")) {
Elements tds = row.select("TD");
if (tds.get(8).text().isEmpty()) {   
}
else { 
    
    try {
    
String string=tds.get(8).text();
BufferedReader bufi=new BufferedReader (new FileReader (NewDir.file_dirrrr + "\\Recipe_Indexes\\Lot_Numbers.kady"));
String line;
String linebeforeequal;//Chemical Name
String lineafterequal;//Lot Numbers
boolean found = false;         
while ((line=bufi.readLine())!=null) {
linebeforeequal=line.substring(0,line.indexOf("="));//Chemical Name
lineafterequal=line.substring(line.indexOf("=") + 1);//Lot Numbers
if (string.equalsIgnoreCase(linebeforeequal)) {
System.out.println(linebeforeequal);
String formattedText = "<b style='display:block; text-align:center;'>" + lineafterequal + "</b>";
tds.get(9).html(formattedText); // Use .html() instead of .text()     
//tds.get(9).text(lineafterequal);
found = true;                    
break;
    }   
}
bufi.close();

} catch (Exception dfgf) {}

}}}
roraa=doct.toString();      
//////////////////////////////////////////////////////////////////////////////
    

/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
      
org.jsoup.nodes.Document doctp = Jsoup.parse(roraa);

// مر على كل جدول
for (Element table : doctp.select("table")) {
    for (Element row : table.select("tr")) {
        Elements tds = row.select("td");

        // اتأكد إن فيه على الأقل 11 عمود (0 → 10)
        if (tds.size() > 10) {
            String target = tds.get(8).text().trim();

            if (!target.isEmpty()) {
                Path mapPath = Paths.get(NewDir.file_dirrrr, "Recipe_Indexes", "Chemical_Translation.kady");

                try (BufferedReader bufi = Files.newBufferedReader(mapPath, StandardCharsets.UTF_8)) {
                    String line;
                    boolean found = false;

                    while ((line = bufi.readLine()) != null) {
                        // اتأكد إن السطر فيه =
                        if (!line.contains("=")) continue;

                        String linebeforeequal = line.substring(0, line.indexOf("=")).trim();
                        String lineafterequal = line.substring(line.indexOf("=") + 1).trim();

                        if (target.equalsIgnoreCase(linebeforeequal)) {
                            System.out.println("Matched: " + linebeforeequal);

                            String formattedText =
                                    "<b style='display:block; text-align:center;'>" +
                                            lineafterequal +
                                            "</b>";

                            // استبدل العمود رقم 10 بالنص الجديد
                            tds.get(10).html(formattedText);

                            found = true;
                            break;
                        }
                    }

                    if (!found) {
                        System.out.println("No match for: " + target);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

roraa = doctp.toString();
 
       
       
 /////////////////////////////////////////////////////////////////////////////////////////////////////////////////

       
   }
   
   else {
       
       //Continue..........
       roraa=code.getText();
   }
    
   /////////////////////////////////////////////////////////////////////////////////////////////////////////////////
   
      
       
       
       
            //String codee=code.getText();
            String pathtosignature="file://"+NewDir.file_dirrrrr+"\\Mr_Moharam.png";
            String modely=model;
   
JFileChooser dialog = new JFileChooser();
dialog.setCurrentDirectory(
        new File(NewDir.file_dir + "\\" + stage + "\\" + model)
);
dialog.setSelectedFile(new File(recipe + ".ks"));
// filters
dialog.setFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
        "Kadysoft Files", "ks"
));
dialog.addChoosableFileFilter(new javax.swing.filechooser.FileNameExtensionFilter(
        "HTML Files", "html"
));
int result = dialog.showSaveDialog(null);
if (result == JFileChooser.APPROVE_OPTION) {
    File dialogResult = dialog.getSelectedFile();
    filePath = dialogResult.getAbsolutePath();
}

try {

            OutputStream instream=new FileOutputStream(filePath);
            pw = new PrintWriter(new OutputStreamWriter (instream,"UTF-8"));
            pw.println("<!DOCTYPE html>\n<html lang=\"ar\">\n<head>\n<title>Kadysoft</title>\n<meta charset=\"UTF-8\">\n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n<style>td {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}\ntable {\nheight:5px;\nmax-width:100%;\nheight:100%;\nwhite-space:nowrap;\n}\ntr {\nheight:5px;\nmax-width:100%;\nwhite-space:nowrap;\n}"
                    + ""
                    + ""
                    
                        + ""
                + "/* Centered Watermark */\n" +
"    .watermark {\n" +
"      position: fixed;\n" +
"      top: 50%;\n" +
"      left: 50%;\n" +
"      transform: translate(-50%, -50%) rotate(-45deg);\n" +
"      background-image: url('logo.png'); /* Replace with the path to T & C Garments logo */\n" +
"      background-repeat: no-repeat;\n" +
"      background-size: contain;\n" +
"      width: 300px;\n" +
"      height: 200px;\n" +
"      opacity: 0.3;\n" +
"      pointer-events: none;\n" +
"      z-index: 1000;\n" +
"    }\n" +
"    /* Repeated Watermark */\n" +
"    .watermark-repeated {\n" +
"      position: fixed;\n" +
"      top: 0;\n" +
"      left: 0;\n" +
"      width: 100%;\n" +
"      height: 100%;\n" +
"      background-image: url('logo.png'); /* Replace with the path to T & C Garments logo */\n" +
"      background-repeat: repeat;\n" +
"      background-size: 300px 200px;\n" +
"      opacity: 0.2;\n" +
"      pointer-events: none;\n" +
"      z-index: 1000;\n" +
"    }"
                + ""
                + "</STYLE></HEAD>\n" +
"<BODY><CENTER>\n"
+ "<div class=\"watermark\"></div>" 
                
                    
                    
                    + ""
                    + ""
                    + "\n\n");
            pw.println("<!-- Creating Recipe From Kadysoft Ltd.-->\n\n");
            pw.println(roraa);
            pw.println("\n\n</center>\n</body>\n</html>");
            //pw.println("<b>Mr_Moharam Signature: "+"</b><img src=\""+pathtosignature+"\" width=\"300\" height=\"90\" alt=\"Developed By Kadysoft Ltd (Ahmed Elkady).\" style=\"border-color:black;border-width:10px;\">");   
      
            if (roraa.contains("background-image:")) {
                
            }
            else {
                pw.println("\n\n<style>\n" +
"body {\n" +
"  background-image: url(\""+modely+".bmp\");\n" +
"  background-position: center;\n" +
"  height: 170px;\n" +
"background-position-x:550px;"+
"  background-repeat: no-repeat;\n" +
"  background-size: 120px 90px;\n" +
"}\n" +
"</style>");             
          }
            pw.close();
            
            
               /////////////////////////////////////////////////// 
   code.setText("");
    InputStream inputinstream=new FileInputStream(filePath);
    BufferedReader bi=new BufferedReader (new InputStreamReader (inputinstream,"UTF-8"));
    //BufferedReader bi=new BufferedReader (new FileReader (pathy));
    String lo;
    while ((lo=bi.readLine())!=null) {
        
        code.append("\n"+lo
       .replace("A","ﬦ")
       .replace("B","ﬧ")
       .replace("C","ﬨ")
       .replace("D","﬩")
       .replace("E","שׁ")    
       .replace("F","שׂ")        
       .replace("G","שּׁ")         
       .replace("H","שּׂ")         
       .replace("I","אַ")         
       .replace("J","אָ")         
       .replace("K","אּ")         
       .replace("L","בּ")         
       .replace("M","גּ")         
       .replace("N","דּ")         
       .replace("O","הּ")         
       .replace("P","וּ")         
       .replace("Q","זּ")         
       .replace("R","טּ")         
       .replace("S","יּ")         
       .replace("T","ךּ")         
       .replace("U","כּ")         
       .replace("V","לּ")
       .replace("W","מּ")         
       .replace("X","נּ")         
       .replace("Y","סּ")         
       .replace("Z","ףּ")
                
       .replace("0","פּ")         
       .replace("1","צּ")         
       .replace("2","קּ")         
       .replace("3","רּ")         
       .replace("4","שּ")         
       .replace("5","תּ")         
       .replace("6","וֹ")         
       .replace("7","בֿ")         
       .replace("8","כֿ")
       .replace("9","פֿ")
                
       .replace("a","ﬦ")
       .replace("b","ﬧ")
       .replace("c","ﬨ")
       .replace("d","﬩")
       .replace("e","שׁ")    
       .replace("f","שׂ")        
       .replace("g","שּׁ")         
       .replace("h","שּׂ")         
       .replace("i","אַ")         
       .replace("j","אָ")         
       .replace("k","אּ")         
       .replace("l","בּ")         
       .replace("m","גּ")         
       .replace("n","דּ")         
       .replace("o","הּ")         
       .replace("p","וּ")         
       .replace("q","זּ")         
       .replace("r","טּ")         
       .replace("s","יּ")         
       .replace("t","ךּ")         
       .replace("u","כּ")         
       .replace("v","לּ")
       .replace("w","מּ")         
       .replace("x","נּ")         
       .replace("y","סּ")         
       .replace("z","ףּ")                
      ); 


    }
    bi.close();
    String gf=code.getText();
    OutputStream instreamm=new FileOutputStream(filePath);
    PrintWriter pw = new PrintWriter(new OutputStreamWriter (instreamm,"UTF-8"));
    //PrintWriter pw=new PrintWriter (new FileWriter (pathy));
    pw.println(gf);
    pw.close();
    
             JWindow toast = new JWindow();
JPanel panel = new JPanel();
panel.setBackground(new Color(220, 53, 69)); // red error
panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
JLabel label = new JLabel("Successful, We have encrypted the recipe successfully.");
label.setForeground(Color.WHITE);
label.setFont(new Font("Segoe UI", Font.BOLD, 13));
panel.add(label);
toast.add(panel);
toast.pack();
toast.setLocationRelativeTo(null);
toast.setVisible(true);
new Timer(5000, e -> toast.dispose()).start();
       
    //code.setText("");

} catch (Exception dg) {}
            
            //Desktop desk = Desktop.getDesktop();
            //desk.open(new File (filePath));
            
JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(btnSave);
//topFrame.dispose();
   
       /////////////////////////////////////////////////// 
   
       ///////////////////////////////////////////////////
   }
   
   
   
   ///////////////////////////////////////////////////////////////////////////////////////////////////////////
   
       
  ////////////////////Send Mails Here///////////////////////////////////////////////////////////////////////
   
   
    //////////////////////////////////////////////////////////////////////////////////////////
        
      Date currentDate1 = GregorianCalendar.getInstance().getTime();
      DateFormat df1 = DateFormat.getDateInstance();
      String dateString1 = df1.format(currentDate1);
      Date d1 = new Date();
      SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
      String timeString1 = sdf1.format(d1);
      SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
      String timeString2 = sdf2.format(d1);
      datevalue = timeString2;                                                          //Date
      
      modeloo=model;                 //Model
      
      filenammm=filePath.replace(NewDir.file_dir,"").replace("\\PRODUCTION","").replace("\\"+modeloo+"\\","").replace(".ks","").replace(".html","");
      
        
      try {  
        
        
    new Thread(new Runnable() {
    @Override
    public void run() {
        
        
        
//    ObservableList<String> ite=list.getItems();
//    
//    for  (String it : ite) {
//        
//        
        
    
          String from,password,to,sub,suby;
          from="ahmedelkadyteeest@gmail.com";
          password="lgrj esca tdtz froo";
          //to=it;
          sub="Recipe Editor (RECETA).";
          suby="Recipe Editor (RECETA) Powered By Kadysoft Ltd - All Rights Reserved. Ahmed Elkady - CEO.";
          
          if (stage.equals("PILOT")) {
              
                msg="Date: "+datevalue+"\nCustomer - Recipe_Name: "+modeloo+" - "+nomo.replace(".ks","")+"\nEditor_Name: "+user+"\nThis Recipe Is Maybe A Pilot Recipe (Pilots Can Be Edited By '"+user+"' Only).\n\n\n"+suby+"\n\n\n██╗░░██╗░█████╗░██████╗░██╗░░░██╗░██████╗░█████╗░███████╗████████╗\n" +
"▒█░▄▀ ░█▀▀█ ▒█▀▀▄ ▒█░░▒█ ▒█▀▀▀█ ▒█▀▀▀█ ▒█▀▀▀ ▀▀█▀▀ 　 ▒█░░░ ▀▀█▀▀ ▒█▀▀▄ \n" +
"▒█▀▄░ ▒█▄▄█ ▒█░▒█ ▒█▄▄▄█ ░▀▀▀▄▄ ▒█░░▒█ ▒█▀▀▀ ░▒█░░ 　 ▒█░░░ ░▒█░░ ▒█░▒█ \n" +
"▒█░▒█ ▒█░▒█ ▒█▄▄▀ ░░▒█░░ ▒█▄▄▄█ ▒█▄▄▄█ ▒█░░░ ░▒█░░ 　 ▒█▄▄█ ░▒█░░ ▒█▄▄▀";
         
              
          }
          
          else if (stage.equals("BLANKET")) {
              
                msg="Date: "+datevalue+"\nCustomer - Recipe_Name: "+modeloo+" - "+nomo.replace(".ks","")+"\nEditor_Name: "+user+"\nThis Recipe Is Maybe A Blanket Recipe (Blankets Can Be Edited By '"+user+"' Only).\n\n\n"+suby+"\n\n\n██╗░░██╗░█████╗░██████╗░██╗░░░██╗░██████╗░█████╗░███████╗████████╗\n" +
"▒█░▄▀ ░█▀▀█ ▒█▀▀▄ ▒█░░▒█ ▒█▀▀▀█ ▒█▀▀▀█ ▒█▀▀▀ ▀▀█▀▀ 　 ▒█░░░ ▀▀█▀▀ ▒█▀▀▄ \n" +
"▒█▀▄░ ▒█▄▄█ ▒█░▒█ ▒█▄▄▄█ ░▀▀▀▄▄ ▒█░░▒█ ▒█▀▀▀ ░▒█░░ 　 ▒█░░░ ░▒█░░ ▒█░▒█ \n" +
"▒█░▒█ ▒█░▒█ ▒█▄▄▀ ░░▒█░░ ▒█▄▄▄█ ▒█▄▄▄█ ▒█░░░ ░▒█░░ 　 ▒█▄▄█ ░▒█░░ ▒█▄▄▀";
         
              
          }
          
          else {
              
                msg="Date: "+datevalue+"\nCustomer - Recipe_Name: "+modeloo+" - "+nomo.replace(".ks","")+"\nEditor_Name: "+user+"\nShots: This Recipe Maybe Contains 3 or 4 or 5 or 6 Shots ('RANDOM BATH') Or More Than 2 Shots. Ask ('KADINIO') to calculate it for you.\nHe created a new method to calculate from 1 to 6 shots.\nFor more information ask KADINIO or see time reports.\n\nOr tell 'KADINIO' if you have a problem with it.\nWe are working on new features to make it easy to control, if you like it support me.\n\n\n"+suby+"\n\n\n██╗░░██╗░█████╗░██████╗░██╗░░░██╗░██████╗░█████╗░███████╗████████╗\n" +
"▒█░▄▀ ░█▀▀█ ▒█▀▀▄ ▒█░░▒█ ▒█▀▀▀█ ▒█▀▀▀█ ▒█▀▀▀ ▀▀█▀▀ 　 ▒█░░░ ▀▀█▀▀ ▒█▀▀▄ \n" +
"▒█▀▄░ ▒█▄▄█ ▒█░▒█ ▒█▄▄▄█ ░▀▀▀▄▄ ▒█░░▒█ ▒█▀▀▀ ░▒█░░ 　 ▒█░░░ ░▒█░░ ▒█░▒█ \n" +
"▒█░▒█ ▒█░▒█ ▒█▄▄▀ ░░▒█░░ ▒█▄▄▄█ ▒█▄▄▄█ ▒█░░░ ░▒█░░ 　 ▒█▄▄█ ░▒█░░ ▒█▄▄▀";
         
              
          }
          
          
          Properties props = new Properties();    
          props.put("mail.smtp.host", "smtp.gmail.com");    
          props.put("mail.smtp.socketFactory.port", "465");    
          props.put("mail.smtp.socketFactory.class",    
          "javax.net.ssl.SSLSocketFactory");    
          props.put("mail.smtp.auth", "true");    
          props.put("mail.smtp.port", "465");    
          Session session = Session.getDefaultInstance(props,    
          new javax.mail.Authenticator() {    
          protected PasswordAuthentication getPasswordAuthentication() {    
          return new PasswordAuthentication(from,password);  
          }    
          });       
          try {    
          MimeMessage message = new MimeMessage(session);  
          
          
          //For mailing by the old method just uncomment codes and comment current method then go straight. 
          
          String[] mailToId={"kemal.duman@tcgarments.com","muhammet.eraslan@tcgarments.com","eyup.karakoyun@tcgarments.com","ahmed.nassif@tcgarments.com","hany.emeira@tcgarments.com"/*,"chemical.store@tcgarments.com"*/,"rainforest.tc@tcgarments.com","yilmaz.bozkir@tcgarments.com","ahmed.elkady@tcgarments.com"};
          for(int i=0;i<mailToId.length;i++){
           message.addRecipients(Message.RecipientType.TO, mailToId[i]);
          }
          
          //message.addRecipient(Message.RecipientType.TO,new InternetAddress(it));    
          message.setSubject(sub);
          //message.setText(msg,"html", "utf-8"); 
          message.setContent(msg, "text/plain; charset=UTF-8");
          Transport.send(message);  
          System.out.println("Successful");
          } catch (MessagingException e) {throw new RuntimeException(e);} 
        
        
        
//    }
//    
//        try {
//            Thread.sleep(300);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(SaverController.class.getName()).log(Level.SEVERE, null, ex);
//        }
        
        
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////
         try {
         String sqla = "INSERT INTO notifications (Recipient, Sender, Message, Delivered) VALUES (?, ?, ?, 0)";
          pst = conn.prepareStatement(sqla);
          pst.setString(1, "Recipe_Maker");
          pst.setString(2, "Ahmed Elkady");
          pst.setString(3, "We have updated "+filenammm+" successfully in "+datevalue+" of "+modeloo+" model.");
          pst.executeUpdate();
          }
          catch (Exception e) {
          } finally {
          try {
          rs.close();
          pst.close();
          } catch (Exception exception) {}}  
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        
          }
}).start();
    
      
      }
      
      catch (Exception m) {
        
      }
    
    
    
        //////////////////////////////////////////////////////////////////////////////////////////
   
  
  //////////////////////////////////////////////////
            
            
   
          
          ////////////////////////////////////////////////////////////////////////////////////////////////////
          
          
          
          
      
      }
      
      
      
      else {}
        
   


      
      ///////////////////////////////////////////////////////////////////////////try here
        
      
        //////////////////////////////////////////////

                           
        
       String proco=null;
       int bathnumzzzz=0;
       String moduu,commentt;
       
       String ston,fom,hypo,enzym,moon,dryr1,dryr2,dryr3;
       
       ston="No";
       fom="No";
       hypo="No";
       enzym="No";
       moon="No";
       dryr1="No";
       dryr2="No";
       dryr3="No";
       
       List<String> shots = new ArrayList<>();
    
       int bathnum=0;
       
        int dss=1;
                            org.jsoup.nodes.Document docy = Jsoup.parse(code.getText());
                            for (Element table : docy.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            
                            
                            
                            
                            
                            if (tds.get(7).text().contains("stone")||tds.get(7).text().contains("Stone")||tds.get(7).text().contains("STONE")||tds.get(7).text().contains("STON")||tds.get(7).text().contains("ston")) {
                                
                                ston="STONE";
                                stonn=ston;
                                
                            }
                            
                             else {
                                
                             //   stonn="-";
                               
                                stonn=ston;
                            }
                            
                            if (tds.get(7).text().contains("foam")||tds.get(7).text().contains("Foam")||tds.get(7).text().contains("FOAM")||tds.get(7).text().contains("BOOL")||tds.get(7).text().contains("BOOL فوم")||tds.get(7).text().contains("FOM")||tds.get(7).text().contains("fom")) {
                                
                                fom="FOAM";
                                fomm=fom;
                                
                            }
                            
                             else {
                                
                               
                             //   fomm="-";
                               
                                fomm=fom;
                            }
                            
                            if (tds.get(7).text().contains("BLEACH")||tds.get(7).text().contains("HYPO")) {
                                
                                hypo="BLEACH";
                                hypoo=hypo;
                                
                            }
                            
                             else {
                                
                              
                             //   hypoo="-";
                              hypoo=hypo;
                                 
                                
                            }
                            
                            if (tds.get(7).text().contains("ENZYME")||tds.get(7).text().contains("ENZYM")||tds.get(7).text().contains("ACUDELL")||tds.get(7).text().contains("NSY")) {
                                
                                enzym="ENZYME";
                                enzymm=enzym;
                                
                            }
                            
                             else {
                                
                               
                             //   enzymm="-";
                                enzymm=enzym;
                                
                            }
                             
                            if (tds.get(3).text().contains("MOON WASH")||tds.get(3).text().contains("MOON")||tds.get(3).text().contains("Moon Wash")||tds.get(3).text().contains("MON WASH")||tds.get(7).text().contains("PERMENGANATE")||tds.get(7).text().contains("PERMENGANAT")||tds.get(7).text().contains("PERMANGANATE")||tds.get(7).text().contains("PERMANGANAT")||tds.get(8).text().contains("POTASSIUM PERMANGANATE")||tds.get(8).text().contains("NOVA TEKS MOON")||tds.get(7).text().contains("PERMANGANAT TO2U")) {
                                
                                moon="MOON WASH";
                                moonn=moon;
                                
                            }
                                   
                          
                            else {
                                
                                
                              //  moonn="-";
                                 moonn=moon;
                            }
                              
                            String dalil=tds.get(3).text();
                            if (dalil.contains("EXTRACT")||dalil.contains("extract")||dalil.contains("Extract")||dalil.contains("EXTRA")||dalil.contains("EXTRACTION")||dalil.contains("extraction")) {
                            shots.add(dalil);}
                            else {
                            
                            
                            
                            }
                            
                           

                           }}
                            
                            
                          bathnum=shots.size();
                          if (shots.size()==1) {
                          dryr1="DRYER 1";
                          dryr11=dryr1;
                          dryr22="No";
                          dryr33="No";
                          }
                          else if (shots.size()==2) {
                          dryr1="DRYER 1";
                          dryr2="DRYER 2";
                          dryr11=dryr1;
                          dryr22=dryr2;
                          dryr33="No";
                          }
                          else if (shots.size()==3) {
                          dryr1="DRYER 1";
                          dryr2="DRYER 2";
                          dryr3="DRYER 3";
                          dryr11=dryr1;
                          dryr22=dryr2;
                          dryr33=dryr3;
                          }
                          else {
                          dryr1="No";
                          dryr2="No";
                          dryr3="No";
                          dryr11=dryr1;
                          dryr22=dryr2;
                          dryr33=dryr3;
                          }
                            
     // Save To DB Here
    Date currentDate1l = GregorianCalendar.getInstance().getTime();
    DateFormat df1l = DateFormat.getDateInstance();
    String dateString1l = df1l.format(currentDate1l);
    Date d1l = new Date();
    SimpleDateFormat sdf1l = new SimpleDateFormat("HH:mm:ss");
    String timeString1l = sdf1l.format(d1l);
    SimpleDateFormat sdf2l = new SimpleDateFormat("yyyy-MM-dd");
    String dateString2l = sdf2l.format(d1l);

    String fann = "";
    
    try {
        String sql0 = "select * from Recipe_Types where WashName = ? and Model = ?";
        pst = conn.prepareStatement(sql0);
        pst.setString(1, filenammm);
        pst.setString(2, modeloo);
        rs = pst.executeQuery();                    
        
        if (rs.next()) {                        
            fann = "found";   
        } else {
            fann = "not_found";   
        }
        
    } catch (Exception exception) {
        exception.printStackTrace(); // Handle exceptions properly
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();     
        } catch (Exception exception) {
            exception.printStackTrace(); // Handle exceptions properly
        }
    }

    if (fann.equals("found")) {
        try {
            
            
            
            String sqlp = "update Recipe_Types set Date = ?, Model = ?, WashName = ?, Rinse = ?, Stone = ?, Foam = ?, Bleach = ?, Enzyme = ?, MoonWash = ?, Dryer_1 = ?, Dryer_2 = ?, Dryer_3 = ? where WashName = ? and Model = ?";
            pst = conn.prepareStatement(sqlp);
            pst.setString(1, dateString2l);
            pst.setString(2, modeloo);
            pst.setString(3, filenammm);
            pst.setString(4, "RINSE");
            pst.setString(5, stonn);
            pst.setString(6, fomm);
            pst.setString(7, hypoo);
            pst.setString(8, enzymm);
            pst.setString(9, moonn);
            pst.setString(10, dryr11);
            pst.setString(11, dryr22);
            pst.setString(12, dryr33);
            pst.setString(13, filenammm); // WHERE clause parameters
            pst.setString(14, modeloo);
            pst.execute();
           
             JWindow toast = new JWindow();
JPanel panel = new JPanel();
panel.setBackground(new Color(220, 53, 69)); // red error
panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
JLabel label = new JLabel("Successful, We have updated the types successfully.");
label.setForeground(Color.WHITE);
label.setFont(new Font("Segoe UI", Font.BOLD, 13));
panel.add(label);
toast.add(panel);
toast.pack();
toast.setLocationRelativeTo(null);
toast.setVisible(true);
new Timer(5000, e -> toast.dispose()).start();
       
            
           
        } catch (Exception exception) {
            exception.printStackTrace(); // Handle exceptions properly
        } finally {
            try {
                if (pst != null) pst.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    } else if (fann.equals("not_found")) {
        try { 
            
            
            
              String reg = "insert into Recipe_Types (Date, Model, WashName, Rinse, Stone, Foam, Bleach, Enzyme, MoonWash, Dryer_1, Dryer_2, Dryer_3) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            pst = conn.prepareStatement(reg);
            pst.setString(1, dateString2l);
            pst.setString(2, modeloo);
            pst.setString(3, filenammm);
            
            pst.setString(4, "RINSE");
            pst.setString(5, stonn);
            pst.setString(6, fomm);
            pst.setString(7, hypoo);
            pst.setString(8, enzymm);
            pst.setString(9, moonn);
            pst.setString(10, dryr11);
            pst.setString(11, dryr22);
            pst.setString(12, dryr33);
            
            pst.execute(); 
            
            
             JWindow toast = new JWindow();
JPanel panel = new JPanel();
panel.setBackground(new Color(220, 53, 69)); // red error
panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
JLabel label = new JLabel("Successful, We have inserted the new type successfully.");
label.setForeground(Color.WHITE);
label.setFont(new Font("Segoe UI", Font.BOLD, 13));
panel.add(label);
toast.add(panel);
toast.pack();
toast.setLocationRelativeTo(null);
toast.setVisible(true);
new Timer(5000, e -> toast.dispose()).start();
       
            
            
            
        } catch (Exception exception) {
            exception.printStackTrace(); // Handle exceptions properly
        } finally {
            try {
                if (pst != null) pst.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
    
    
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
      
       String stages=null;
       int bathnumzzz=0;
       String modu,comment;
    
        int ds=1;
                            org.jsoup.nodes.Document docyi = Jsoup.parse(code.getText());
                            for (Element table : docyi.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            if (tds.get(3).text().contains("/")||tds.get(3).text().contains("\\")||tds.get(3).text().isEmpty()||tds.get(3).text().contains("TEMP")||tds.get(3).text().contains("OPERATOR")||tds.get(3).text().contains("temp")||tds.get(3).text().contains("operator")/*||tds.get(3).text().contains("extract")||tds.get(3).text().contains("EXTRACT")||tds.get(3).text().contains("extraction")||tds.get(3).text().contains("EXTRACTION")*/||tds.get(3).text().matches("[0-9]+")||tds.get(3).text().contains("REMOV")||tds.get(3).text().contains("REMOVE")||tds.get(3).text().contains("BATH")||tds.get(3).text().contains("SAME")||tds.get(3).text().contains("PATH")||tds.get(3).text().contains("SAM")||tds.get(3).text().contains("RPM")||tds.get(3).text().contains("KG")||tds.get(3).text().contains("PCS")||tds.get(3).text().contains("DRAIN")||tds.get(3).text().contains("RIMOV")||tds.get(3).text().contains("RIMOVE")) {}
                            else {
                            String tempo=tds.get(3).text();
                            if (tempo.contains("EXTRACT")||tempo.contains("Extract")||tempo.contains("extract")) {
                               
                                stages=stages+"\n"+"WASHING "+Integer.toString(ds++);
                                
                            }
                            
                            else {
                                
                                stages=stages+"\n"+tempo;
                                
                            }
                            }
                            

                           }}
             
        String arabicRegex = "[\\u0600-\\u06FF]+";
        Pattern pattern = Pattern.compile(arabicRegex);
        
        Matcher matcher = pattern.matcher(stages + "");
        String modifiedLine = matcher.replaceAll("\n");
        String lone = modifiedLine.replace("null", "\n");
        
        StringBuilder result = new StringBuilder();
        String[] lines = lone.split("\n");
        int nonEmptyCount = 0;
        // Count non-empty lines to handle the last one differently
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                nonEmptyCount++;
            }
        }
        
        int currentNonEmpty = 0;
        for (String line : lines) {
            if (!line.trim().isEmpty()) {
                currentNonEmpty++;
                result.append(line);
                // Append " - " only if it's not the last non-empty line
                if (currentNonEmpty < nonEmptyCount) {
                    result.append(" - ");
                }
            }
        }                                   
                            
      procccc=result.toString();         
        
        // Save To DB Here

    String fannn = "";
    
    try {
        String sql0 = "select * from Recipe_Processes where WashName = ? and Model = ?";
        pst = conn.prepareStatement(sql0);
        pst.setString(1, filenammm);
        pst.setString(2, modeloo);
        rs = pst.executeQuery();                    
        
        if (rs.next()) {                        
            fannn = "found";   
        } else {
            fannn = "not_found";   
        }
        
    } catch (Exception exception) {
        exception.printStackTrace(); // Handle exceptions properly
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();     
        } catch (Exception exception) {
            exception.printStackTrace(); // Handle exceptions properly
        }
    }

    if (fannn.equals("found")) {
        try {
            String sqlp = "update Recipe_Processes set Date = ?, Model = ?, WashName = ?, Processes = ? where WashName = ? and Model = ?";
            pst = conn.prepareStatement(sqlp);
            pst.setString(1, dateString2l);
            pst.setString(2, modeloo);
            pst.setString(3, filenammm);
            pst.setString(4, procccc);
            pst.setString(5, filenammm); // WHERE clause parameters
            pst.setString(6, modeloo);
            pst.execute();
            
JWindow toast = new JWindow();
JPanel panel = new JPanel();
panel.setBackground(new Color(220, 53, 69)); // red error
panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
JLabel label = new JLabel("Successful, We have updated the processes successfully.");
label.setForeground(Color.WHITE);
label.setFont(new Font("Segoe UI", Font.BOLD, 13));
panel.add(label);
toast.add(panel);
toast.pack();
toast.setLocationRelativeTo(null);
toast.setVisible(true);
new Timer(5000, e -> toast.dispose()).start();

        } catch (Exception exception) {
            exception.printStackTrace(); // Handle exceptions properly
        } finally {
            try {
                if (pst != null) pst.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    } else if (fannn.equals("not_found")) {
        try {                            
            String reg = "insert into Recipe_Processes (Date, Model, WashName, Processes) values (?, ?, ?, ?)";
            pst = conn.prepareStatement(reg);
            pst.setString(1, dateString2l);
            pst.setString(2, modeloo);
            pst.setString(3, filenammm);
            pst.setString(4, procccc);
            pst.execute(); 
            
            JWindow toast = new JWindow();
JPanel panel = new JPanel();
panel.setBackground(new Color(220, 53, 69)); // red error
panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
JLabel label = new JLabel("Successful, We have inserted the new processes successfully.");
label.setForeground(Color.WHITE);
label.setFont(new Font("Segoe UI", Font.BOLD, 13));
panel.add(label);
toast.add(panel);
toast.pack();
toast.setLocationRelativeTo(null);
toast.setVisible(true);
new Timer(5000, e -> toast.dispose()).start();

            
        } catch (Exception exception) {
            exception.printStackTrace(); // Handle exceptions properly
        } finally {
            try {
                if (pst != null) pst.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
        
    
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    
   //Add Here//
   
   
   ///////////////////////ooooooooooooooooooooooo////////////////////////////////////////////////////   
                      
sumz=0.0;
ally=0.0;

                            org.jsoup.nodes.Document docyp = Jsoup.parse(code.getText());
                            for (Element table : docyp.select("table")) {
                            for (Element row : table.select("tr")) {
                            Elements tds = row.select("td");
                            
                            
                            if (tds.get(7).text().contains("new stone")||tds.get(7).text().contains("New Stone")||tds.get(7).text().contains("NEW STONE")||tds.get(7).text().contains("NEW STON")||tds.get(7).text().contains("new ston")||tds.get(7).text().contains("now ston")||tds.get(7).text().contains("now stone")||tds.get(7).text().contains("NOW STON")||tds.get(7).text().contains("NOW STONE")) {
                                
                                 
                                stonny=tds.get(5).text().toString();
                                sto=Double.parseDouble(stonny);
                                sumz=sumz+sto;
                                
                            }
                            
                             else {
                               
                                sumz=sumz;
                                
                            }
                            
                            ally=(sumz/2)*25;
                            finall=Double.toString(ally);
                            
                           }}
                       
                            
    // Save To DB Here
    Date currentDate1 = GregorianCalendar.getInstance().getTime();
    DateFormat df1 = DateFormat.getDateInstance();
    String dateString1 = df1.format(currentDate1);
    Date d1 = new Date();
    SimpleDateFormat sdf1 = new SimpleDateFormat("HH:mm:ss");
    String timeString1 = sdf1.format(d1);
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    String dateString2 = sdf2.format(d1);

    String fannm = "";
    
    try {
        String sql0 = "select * from GetterStone where Name = ? and Model = ?";
        pst = conn.prepareStatement(sql0);
        pst.setString(1, filenammm);
        pst.setString(2, modeloo);
        rs = pst.executeQuery();                    
        
        if (rs.next()) {                        
            fannm = "found";   
        } else {
            fannm = "not_found";   
        }
        
    } catch (Exception exception) {
        exception.printStackTrace(); // Handle exceptions properly
    } finally {
        try {
            if (rs != null) rs.close();
            if (pst != null) pst.close();     
        } catch (Exception exception) {
            exception.printStackTrace(); // Handle exceptions properly
        }
    }
    
    

    if (fannm.equals("found")) {
        try {
            String sqlp = "update GetterStone set Date = ?, Model = ?, Name = ?, Stone = ? where Name = ? and Model = ?";
            pst = conn.prepareStatement(sqlp);
            pst.setString(1, dateString2);
            pst.setString(2, modeloo);
            pst.setString(3, filenammm);
            pst.setString(4, finall);
            pst.setString(5, filenammm); // WHERE clause parameters
            pst.setString(6, modeloo);
            pst.execute();
            
            JWindow toast = new JWindow();
JPanel panel = new JPanel();
panel.setBackground(new Color(220, 53, 69)); // red error
panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
JLabel label = new JLabel("Successful, We have updated the stone successfully.");
label.setForeground(Color.WHITE);
label.setFont(new Font("Segoe UI", Font.BOLD, 13));
panel.add(label);
toast.add(panel);
toast.pack();
toast.setLocationRelativeTo(null);
toast.setVisible(true);
new Timer(5000, e -> toast.dispose()).start();

            
        } catch (Exception exception) {
            exception.printStackTrace(); // Handle exceptions properly
        } finally {
            try {
                if (pst != null) pst.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    } else if (fannm.equals("not_found")) {
        try {                            
            String reg = "insert into GetterStone (Date, Model, Name, Stone) values (?, ?, ?, ?)";
            pst = conn.prepareStatement(reg);
            pst.setString(1, dateString2);
            pst.setString(2, modeloo);
            pst.setString(3, filenammm);
            pst.setString(4, finall);
            pst.execute(); 
            
            JWindow toast = new JWindow();
JPanel panel = new JPanel();
panel.setBackground(new Color(220, 53, 69)); // red error
panel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
JLabel label = new JLabel("Successful, We have inserted the stone successfully.");
label.setForeground(Color.WHITE);
label.setFont(new Font("Segoe UI", Font.BOLD, 13));
panel.add(label);
toast.add(panel);
toast.pack();
toast.setLocationRelativeTo(null);
toast.setVisible(true);
new Timer(5000, e -> toast.dispose()).start();

            
        } catch (Exception exception) {
            exception.printStackTrace(); // Handle exceptions properly
        } finally {
            try {
                if (pst != null) pst.close();
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
 
    // ====================== حفظ التغييرات في History ======================
SwingUtilities.invokeLater(() -> {
    try {
        String oldContent = originalltextt != null ? originalltextt : "";
        String newContent = code.getText();
        // استدعاء الدوال من خلال instance
        Helper_Editor editorInstance = new Helper_Editor();
        List<Map<String, Object>> changes = editorInstance.computeChanges(oldContent, newContent);
        if (!changes.isEmpty()) {
            editorInstance.saveToHistory(changes);
            appendLog("📜 تم حفظ " + changes.size() + " تغيير في History");
        } else {
            appendLog("ℹ️ لا يوجد تغييرات جديدة للحفظ في History");
        }
    } catch (Exception ex) {
        ex.printStackTrace();
        appendLog("⚠️ خطأ أثناء حفظ التاريخ: " + ex.getMessage());
    }
});
    
code.setText("");



SwingUtilities.invokeLater(() -> {
    try {
        //////////////////////////////////////////End Save////////////////////////////////////////

        // تنظيف الكود القديم
        code.setText("");
        // قراءة الملف وفك التشفير
        InputStream inputinstream = new FileInputStream(link);
        BufferedReader bi = new BufferedReader(new InputStreamReader(inputinstream, "UTF-8"));
        String lo;
        while ((lo = bi.readLine()) != null) {
            code.append("\n" + lo
                    .replace("ﬦ", "A").replace("ﬧ", "B").replace("ﬨ", "C").replace("﬩", "D").replace("שׁ", "E")
                    .replace("שׂ", "F").replace("שּׁ", "G").replace("שּׂ", "H").replace("אַ", "I").replace("אָ", "J")
                    .replace("אּ", "K").replace("בּ", "L").replace("גּ", "M").replace("דּ", "N").replace("הּ", "O")
                    .replace("וּ", "P").replace("זּ", "Q").replace("טּ", "R").replace("יּ", "S").replace("ךּ", "T")
                    .replace("כּ", "U").replace("לּ", "V").replace("מּ", "W").replace("נּ", "X").replace("סּ", "Y")
                    .replace("ףּ", "Z").replace("פּ", "0").replace("צּ", "1").replace("קּ", "2").replace("רּ", "3")
                    .replace("שּ", "4").replace("תּ", "5").replace("וֹ", "6").replace("בֿ", "7").replace("כֿ", "8")
                    .replace("פֿ", "9").replace("&NBSP;", ""));
        }
        bi.close();

        // كتابة الملف بعد فك التشفير
        String gf = code.getText();
        try (PrintWriter pwe = new PrintWriter(new OutputStreamWriter(new FileOutputStream(link), "UTF-8"))) {
            pwe.println(gf);
        }
        code.setText("");

        // إعداد بيانات QR
        Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String dateString = sdf.format(d);
        String programmerName = "Ahmed Elkady.";
        String companyName = "Kadysoft Ltd.";
        String factoryName = "T&C Garments.";
        String recipeName = recipe + ".";
        String clientName = model + ".";
        int qty = Integer.parseInt(pecoco);
        String lastEditorName = user + ".";
        String date = dateString + ".";
        String repolink = "https://progkady.github.io/RecipesStore/";
        double pcsCost = onegar;

        String qrText = "★ Recipe Details ★\n" +
                "-------------------------\n" +
                "• Programmer : " + programmerName + "\n" +
                "• Developer : " + companyName + "\n" +
                "• Factory : " + factoryName + "\n" +
                "• Recipe : " + recipeName + "\n" +
                "• Customer : " + clientName + "\n" +
                "• Quantity : " + qty + "\n" +
                "• Editor Name : " + lastEditorName + "\n" +
                "• Last Update : " + date + "\n" +
                "• Pcs Cost : " + pcsCost + " $\n\n" +
                "• Recipes Link : " + repolink + "\n" +
                "Thanks For Using Receta From Kadysoft Ltd. ❤";

        // إنشاء QR بحجم كبير وواضح
        int qrSize = 250;
        BufferedImage qrImage = createPrintableQR(qrText, qrSize);
        String qrBase64 = imageToBase64Png(qrImage);

        // قراءة HTML الأصلي
        String htmlContent = readFile(link);
        Document doc = Jsoup.parse(htmlContent);
        doc.outputSettings().syntax(Document.OutputSettings.Syntax.html);
        doc.outputSettings().charset("UTF-8");

        Element table = doc.select("table#EXTABLE").first();
        if (table == null) {
            System.out.println("خطأ: الجدول #EXTABLE مش موجود!");
            return;
        }

        // الحصول على الصفوف
        Elements rows = table.select("tbody > tr");
        int mergeRows = Math.min(7, rows.size()); // دمج 7 صفوف
        int qrColumnIndex = 8; // العمود رقم 9 (index 8)

        // الصف الأول
        Element firstRow = rows.get(0);
        Elements cells = firstRow.select("td");
        if (cells.size() <= qrColumnIndex) {
            System.out.println("العمود رقم 9 مش موجود في الصف الأول!");
            return;
        }

        // خلية QR Code
        Element qrCell = cells.get(qrColumnIndex);

        // فحص وجود QR CODE قديم
        Element oldQrImg = qrCell.selectFirst("img[src^=data:image]");

        // HTML الخاص بالـ QR الجديد (مع الـ alt الطويل)
        String qrHtml =
    "<img src=\"data:image/png;base64," + qrBase64 + "\" " +
    "alt=\"★ Recipe Details ★&#10;" +
    "-------------------------&#10;" +
    "• Programmer : " + programmerName + "&#10;" +
    "• Developer : " + companyName + "&#10;" +
    "• Factory : " + factoryName + "&#10;" +
    "• Recipe : " + recipeName + "&#10;" +
    "• Customer : " + clientName + "&#10;" +
    "• Quantity : " + qty + "&#10;" +
    "• Editor Name : " + lastEditorName + "&#10;" +
    "• Last Update : " + date + "&#10;" +
    "• Pcs Cost : " + pcsCost + " $&#10;&#10;" +
    "• Recipes Link : " + repolink + "&#10;" +
    "Thanks For Using Receta From Kadysoft Ltd. ❤\" " +
    "style=\"width:" + qrSize + "px !important; height:" + qrSize + "px !important; " +
    "max-width:none !important; max-height:none !important; border:10px solid white; " +
    "box-shadow:0 0 0 4pt black;\"/>";

        // استبدال أو إضافة QR
        if (oldQrImg != null) {
            // موجود QR قديم → نستبدل الـ HTML فقط
            qrCell.html(qrHtml);
        } else {
            // مفيش QR → نضيف الـ rowspan والستايل والـ HTML
            qrCell.attr("rowspan", String.valueOf(mergeRows))
                  .attr("style", "border: 3px double #000; padding: 10px; background: #ffffff; " +
                                 "text-align: center; vertical-align: middle;")
                  .html(qrHtml);
        }

        // === التعديل المهم هنا ===
        // إزالة الخلية من الصفوف الأخرى باستخدام :nth-child(9) بدل الـ index
        for (int i = 1; i < mergeRows; i++) {
            Element row = rows.get(i);
            Element cellToRemove = row.selectFirst("td:nth-child(9)");
            if (cellToRemove != null) {
                cellToRemove.remove();
            }
        }

        // حفظ HTML بعد دمج QR
        writeFile(link, doc.outerHtml());
        code.setText("");

        // إعادة تشفير الملف
        InputStream inputinstreamn = new FileInputStream(link);
        BufferedReader bin = new BufferedReader(new InputStreamReader(inputinstreamn, "UTF-8"));
        String lon;
        while ((lon = bin.readLine()) != null) {
            if (lon.contains("data:image") || lon.contains("base64,")) {
                code.append("\n" + lon);
                continue;
            }
            String converted = lon
                    .replace("A","ﬦ").replace("B","ﬧ").replace("C","ﬨ").replace("D","﬩").replace("E","שׁ")
                    .replace("F","שׂ").replace("G","שּׁ").replace("H","שּׂ").replace("I","אַ").replace("J","אָ")
                    .replace("K","אּ").replace("L","בּ").replace("M","גּ").replace("N","דּ").replace("O","הּ")
                    .replace("P","וּ").replace("Q","זּ").replace("R","טּ").replace("S","יּ").replace("T","ךּ")
                    .replace("U","כּ").replace("V","לּ").replace("W","מּ").replace("X","נּ").replace("Y","סּ")
                    .replace("Z","ףּ")
                    .replace("0","פּ").replace("1","צּ").replace("2","קּ").replace("3","רּ").replace("4","שּ")
                    .replace("5","תּ").replace("6","וֹ").replace("7","בֿ").replace("8","כֿ").replace("9","פֿ")
                    .replace("a","ﬦ").replace("b","ﬧ").replace("c","ﬨ").replace("d","﬩").replace("e","שׁ")
                    .replace("f","שׂ").replace("g","שּׁ").replace("h","שּׂ").replace("i","אַ").replace("j","אָ")
                    .replace("k","אּ").replace("l","בּ").replace("m","גּ").replace("n","דּ").replace("o","הּ")
                    .replace("p","וּ").replace("q","זּ").replace("r","טּ").replace("s","יּ").replace("t","ךּ")
                    .replace("u","כּ").replace("v","לּ").replace("w","מּ").replace("x","נּ").replace("y","סּ")
                    .replace("z","ףּ");
            code.append("\n" + converted);
        }
        bin.close();

        try (PrintWriter pwn = new PrintWriter(new OutputStreamWriter(new FileOutputStream(link), "UTF-8"))) {
            pwn.println(code.getText());
        }
        code.setText("");

        // Git operations
        Git.gitCommands();


    } catch (Exception r) {
       r.printStackTrace();
        appendLog("❌ خطأ في الـ post-save: " + r.getMessage());
    }
});
            
            /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
           

//            JFileChooser chooser = new JFileChooser("D:/Editor");
//            chooser.setSelectedFile(new File("kadysoft_saved.html"));
//            
//            if (chooser.showSaveDialog(null) == JFileChooser.APPROVE_OPTION) {
//                File file = chooser.getSelectedFile();
//                try (FileWriter writer = new FileWriter(file)) {
//                    writer.write(content);
//                    appendLog("✅ تم الحفظ بنجاح: " + file.getAbsolutePath());
//                    statusLabel.setText("آخر حفظ: " + file.getName());
//                    JOptionPane.showMessageDialog(null, "تم حفظ الكود المستخرج بنجاح!");
//                } catch (IOException ex) {
//                    appendLog("❌ فشل الحفظ: " + ex.getMessage());
//                }
//            }
        });
    }

    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    private static void runCommand(String command, String workingDir) throws Exception {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
        builder.directory(new java.io.File(workingDir));
        builder.redirectErrorStream(true);
        Process process = builder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
        process.waitFor();
    }
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
    private static String imageToBase64Png(BufferedImage image) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(image, "PNG", baos);
        return Base64.getEncoder().encodeToString(baos.toByteArray());
    }
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
    private static void writeFile(String path, String content) throws IOException {
        PrintWriter pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF-8"));
        pw.print(content);
        pw.close();
        pw.close();
    }
    private List<Map<String, Object>> computeChanges(String oldContent, String newContent) {
        List<Map<String, Object>> changes = new ArrayList<>();
        Document oldDoc = Jsoup.parse(oldContent);
        Document newDoc = Jsoup.parse(newContent);
        Elements oldTables = oldDoc.select("table");
        Elements newTables = newDoc.select("table");
        int minTables = Math.min(oldTables.size(), newTables.size());
        for (int t = 0; t < minTables; t++) {
            Element oldTable = oldTables.get(t);
            Element newTable = newTables.get(t);
            Elements oldRows = oldTable.select("tr");
            Elements newRows = newTable.select("tr");
            int minRows = Math.min(oldRows.size(), newRows.size());
            for (int i = 0; i < minRows; i++) {
                Elements oldCells = oldRows.get(i).select("td, th");
                Elements newCells = newRows.get(i).select("td, th");
                int minCells = Math.min(oldCells.size(), newCells.size());
                for (int j = 0; j < minCells; j++) {
                    String oldVal = oldCells.get(j).text().trim();
                    String newVal = newCells.get(j).text().trim();
                    if (!Objects.equals(oldVal, newVal)) {
                        Map<String, Object> change = new HashMap<>();
                        change.put("type", "cell-change");
                        change.put("table", t + 1);
                        change.put("row", i + 1);
                        change.put("column", j + 1);
                        change.put("oldValue", oldVal);
                        change.put("newValue", newVal);
                        changes.add(change);
                    }
                }
                if (oldCells.size() != newCells.size()) {
                    Map<String, Object> change = new HashMap<>();
                    change.put("type", "cell-count-change");
                    change.put("table", t + 1);
                    change.put("row", i + 1);
                    change.put("oldCount", oldCells.size());
                    change.put("newCount", newCells.size());
                    changes.add(change);
                }
            }
            if (oldRows.size() != newRows.size()) {
                Map<String, Object> change = new HashMap<>();
                change.put("type", "row-count-change");
                change.put("table", t + 1);
                change.put("oldCount", oldRows.size());
                change.put("newCount", newRows.size());
                changes.add(change);
            }
        }
        com.github.difflib.patch.Patch<String> patch = com.github.difflib.DiffUtils.diff(
                Arrays.asList(oldContent.split("\n")),
                Arrays.asList(newContent.split("\n"))
        );
        patch.getDeltas().forEach(delta -> {
            Map<String, Object> change = new HashMap<>();
            change.put("type", "text-change");
            change.put("oldValue", delta.getSource().toString());
            change.put("newValue", delta.getTarget().toString());
            changes.add(change);
        });

        return changes;
    }
    private void saveToHistory(List<Map<String, Object>> detailedChanges) {
        List<Map<String, Object>> history = loadHistory();
        Map<String, Object> entry = new HashMap<>();
        entry.put("timestamp", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
        entry.put("changes", detailedChanges);
        history.add(entry);
        try (FileWriter writer = new FileWriter(historyyfileepathh)) {
            new Gson().toJson(history, writer);
        } catch (IOException ex) {
            
        }
    }
    private List<Map<String, Object>> loadHistory() {
        if (historyyfileepathh == null || !new File(historyyfileepathh).exists()) return new ArrayList<>();
        try (Reader reader = new FileReader(historyyfileepathh)) {
            return new Gson().fromJson(reader, new TypeToken<List<Map<String, Object>>>() {}.getType());
        } catch (IOException ex) {
            return new ArrayList<>();
        }
    }
private void viewHistory() {
    if (historyyfileepathh == null) {
        return;
    }
    List<Map<String, Object>> history = loadHistory();
    if (history.isEmpty()) {
        return;
    }
JFrame historyStage = new JFrame("Recipe Editing History");
JComboBox<String> historySelector = new JComboBox<>();
for (Map<String, Object> entry : history) {
    historySelector.addItem((String) entry.get("timestamp"));
}
DefaultTableModel model = new DefaultTableModel(
    new String[]{"Type", "Table", "Row", "Column", "Old Value", "New Value"}, 0
) {
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }
};
JTable table = new JTable(model);
table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
table.setFillsViewportHeight(true);

// إنشاء Renderer للقيم القديمة (خلفية فاتحة حمراء + نص أحمر غامق)
ColoredCellRenderer oldRenderer = new ColoredCellRenderer(
    new Color(0xFFDDDD),    // خلفية فاتحة حمراء
    new Color(0xA00000)     // نص أحمر غامق
);

// إنشاء Renderer للقيم الجديدة (خلفية فاتحة خضراء + نص أخضر غامق)
ColoredCellRenderer newRenderer = new ColoredCellRenderer(
    new Color(0xDDFFDD),    // خلفية فاتحة خضراء
    new Color(0x006600)     // نص أخضر غامق
);

// تطبيق الـ Renderer على الأعمدة
table.getColumn("Old Value").setCellRenderer(oldRenderer);
table.getColumn("New Value").setCellRenderer(newRenderer);

JScrollPane scrollPane = new JScrollPane(table);
JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
mainPanel.add(historySelector, BorderLayout.NORTH);
mainPanel.add(scrollPane, BorderLayout.CENTER);
historySelector.addActionListener(e -> {
    String ts = (String) historySelector.getSelectedItem();
    if (ts == null) return;
    model.setRowCount(0);
    for (Map<String, Object> entry : history) {
        if (entry.get("timestamp").equals(ts)) {
            List<Map<String, Object>> changes = (List<Map<String, Object>>) entry.get("changes");
            for (Map<String, Object> change : changes) {
                String rowVal = String.valueOf(change.getOrDefault("row", "")).trim();
                String colVal = String.valueOf(change.getOrDefault("column", "")).trim();
                if (!rowVal.isEmpty() && !colVal.isEmpty()) {
                    model.addRow(new Object[]{
                        change.get("type"),
                        change.getOrDefault("table", ""),
                        change.getOrDefault("row", ""),
                        change.getOrDefault("column", ""),
                        change.getOrDefault("oldValue", ""),
                        change.getOrDefault("newValue", "")
                    });
                }
            }
            break;
        }
    }
});
if (historySelector.getItemCount() > 0) {
    historySelector.setSelectedIndex(0);
}
historyStage.setContentPane(mainPanel);
historyStage.setSize(900, 500);
historyStage.setExtendedState(JFrame.MAXIMIZED_BOTH);   // maximized
historyStage.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
historyStage.setLocationRelativeTo(null);
historyStage.setVisible(true);  
}


    private static void appendLog(String message) {
        SwingUtilities.invokeLater(() -> {
            code.append("[" + java.time.LocalTime.now().withNano(0) + "] " + message + "\n");
            code.setCaretPosition(code.getDocument().getLength());
        });
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
    private static void showNotification(String title, String text, boolean error) {
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
    private String cleanSpecialCharacters(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
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
    
    
    private static class Shot {
    List<String> chemicals = new ArrayList<>();
    List<Double> quantities = new ArrayList<>();
    List<Double> prices = new ArrayList<>();
    List<Double> dilutions = new ArrayList<>();

    double calculateCost() {
        double total = 0.0;
        for (int i = 0; i < quantities.size(); i++) {
            double dil = dilutions.get(i) > 0 ? dilutions.get(i) : 1.0;
            total += (quantities.get(i) / dil) * prices.get(i);
        }
        return total;
    }
}
}