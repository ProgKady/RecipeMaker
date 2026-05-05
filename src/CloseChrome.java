import java.io.IOException;

public class CloseChrome {
    public static void main(String[] args) {
        String os = System.getProperty("os.name").toLowerCase();
        String command = "";

        if (os.contains("win")) {
            command = "taskkill /F /IM chrome.exe";
        } else if (os.contains("mac")) {
            command = "pkill -f Chrome";
        } else if (os.contains("nix") || os.contains("nux") || os.contains("aix")) {
            command = "pkill -f chrome";
        }

        try {
            Runtime.getRuntime().exec(command);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
