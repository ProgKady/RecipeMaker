package kadysoft.kady;

import org.cef.CefApp;
import org.cef.CefClient;
import org.cef.CefSettings;
import org.cef.browser.CefBrowser;
import org.cef.browser.CefFrame;
import org.cef.browser.CefMessageRouter;
import org.cef.callback.CefQueryCallback;
import org.cef.handler.CefMessageRouterHandlerAdapter;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class MainFrame {

    private static MainFrame instance;

    private CefApp cefApp;
    private CefClient client;
    private CefBrowser browser;

    private JFrame frame;

    private volatile boolean ready = false;

    // ======================
    // SINGLETON OPEN METHOD
    // ======================
    public static void open() {
        if (instance == null) {
            instance = new MainFrame();
        } else {
            instance.show();
        }
    }

    // ======================
    // CONSTRUCTOR (مرة واحدة فقط)
    // ======================
    private MainFrame() {
        initializeJCEF();
        SwingUtilities.invokeLater(this::createUI);
    }

    // ======================
    // INIT JCEF (مرة واحدة فقط)
    // ======================
    private void initializeJCEF() {
        try {

            File baseDir = new File(
                    Helper_Editor.class.getProtectionDomain()
                            .getCodeSource()
                            .getLocation()
                            .toURI()
            ).getParentFile();

            File libDir = new File(baseDir, "bin/lib/win64");
            System.setProperty("java.library.path", libDir.getAbsolutePath());

            try {
                java.lang.reflect.Field field =
                        ClassLoader.class.getDeclaredField("sys_paths");
                field.setAccessible(true);
                field.set(null, null);
            } catch (Exception ignored) {}

            CefApp.startup(new String[]{});

            CefSettings settings = new CefSettings();
            settings.windowless_rendering_enabled = false;
            settings.cache_path = "cache";

            cefApp = CefApp.getInstance(settings);
            client = cefApp.createClient();

            CefMessageRouter router = CefMessageRouter.create();
            router.addHandler(new CefMessageRouterHandlerAdapter() {
                @Override
                public boolean onQuery(CefBrowser browser,
                                       CefFrame frame,
                                       long queryId,
                                       String request,
                                       boolean persistent,
                                       CefQueryCallback callback) {
                    callback.success("");
                    return true;
                }
            }, true);

            client.addMessageRouter(router);

            File htmlFile = new File(NewDir.file_dirrrr + "\\Editor\\kadysoft.html");
            String url = htmlFile.exists()
                    ? htmlFile.toURI().toString()
                    : "about:blank";

            browser = client.createBrowser(url, false, false);

            ready = true;

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // ======================
    // UI CREATION
    // ======================
    private void createUI() {

        frame = new JFrame("Kadysoft Editor");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(1400, 900);
        frame.setLayout(new BorderLayout());

        JLabel loading = new JLabel("Loading...", SwingConstants.CENTER);
        frame.add(loading, BorderLayout.CENTER);

        Timer timer = new Timer(100, e -> {
            if (ready && browser != null) {
                ((Timer) e.getSource()).stop();

                frame.remove(loading);
                frame.add(browser.getUIComponent(), BorderLayout.CENTER);

                frame.revalidate();
                frame.repaint();
            }
        });

        timer.start();

        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

    // ======================
    // SHOW WINDOW AGAIN
    // ======================
    public void show() {
        if (frame != null) {
            frame.setVisible(true);
            frame.toFront();
        }
    }

    // ======================
    // OPTIONAL: Reload page
    // ======================
    public void reload() {
        if (browser != null) {
            browser.reload();
        }
    }
}