package kadysoft.kady;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;

public class ClipboardBridge {

    public void setClipboardText(String html) {
        ClipboardContent content = new ClipboardContent();
        content.putString(html);  // For plain text
        content.putHtml(html);    // For rich HTML
        Clipboard.getSystemClipboard().setContent(content);
    }

    public String getClipboardText() {
        Clipboard clipboard = Clipboard.getSystemClipboard();
        if (clipboard.hasHtml()) {
            return clipboard.getHtml();
        } else if (clipboard.hasString()) {
            return clipboard.getString();
        }
        return "";
    }
}
