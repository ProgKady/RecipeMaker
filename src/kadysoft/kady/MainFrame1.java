package kadysoft.kady;

import java.awt.Component;
import java.io.File;
import org.cef.CefApp;
import org.cef.CefClient;
import org.cef.CefSettings;
import org.cef.browser.CefBrowser;

public class MainFrame1 {

    private static MainFrame1 instance;

    private CefApp cefApp;
    private CefClient client;
    private CefBrowser browser;

    public static synchronized MainFrame1 getInstance() {

        if (instance == null) {
            instance = new MainFrame1();
        }

        return instance;
    }

    private MainFrame1() {

        initialize();
    }

    private void initialize() {

        try {

            System.setProperty("jcef.force_sandbox", "0");

            File libDir = new File("bin/lib/win64");

            System.setProperty(
                    "java.library.path",
                    libDir.getAbsolutePath()
            );

            try {

                java.lang.reflect.Field field =
                        ClassLoader.class.getDeclaredField("sys_paths");

                field.setAccessible(true);

                field.set(null, null);

            } catch (Exception e) {
                e.printStackTrace();
            }

            File helper =
                    new File(libDir, "jcef_helper.exe");

            CefSettings settings = new CefSettings();

            settings.windowless_rendering_enabled = false;

            settings.browser_subprocess_path =
                    helper.getAbsolutePath();

            settings.cache_path =
                    new File("cache").getAbsolutePath();

            cefApp = CefApp.getInstance(settings);

            client = cefApp.createClient();

            // الصفحة
            File html =
                    new File("lib/receta.html");

            String url = html.toURI().toString();

            System.out.println(url);

            browser = client.createBrowser(
                    url,
                    false,
                    false
            );

            // مهم جدًا
            browser.createImmediately();

            System.out.println("✅ JCEF READY");

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

    public Component getBrowserComponent() {

        return browser.getUIComponent();
    }
}