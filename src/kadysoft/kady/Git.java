
package kadysoft.kady;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import javafx.application.Platform;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;

/**
 *
 * @author ahmed.elkady
 */
public class Git {
    
    
    public static void gitCommands ()   {
        
        Platform.runLater( () -> {
        
        try {
            // المسار المطلوب تنفيذه فيه أوامر Git
            String repoPath = "X:\\Recipe_System\\Recipes";
            // تشغيل الأوامر بالترتيب
            runCommand("git add .", repoPath);
            runCommand("git commit -m \"Update some data\"", repoPath);
            runCommand("git push", repoPath);

        Notifications noti = Notifications.create();
        noti.title("Successful");
        noti.text("✔ Git operations completed successfully!");
        noti.position(Pos.CENTER);
        noti.show();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        });
        
    }
    
    
    public static void runCommand(String command, String workingDir) throws Exception {
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
    
    
    
    
    
}
