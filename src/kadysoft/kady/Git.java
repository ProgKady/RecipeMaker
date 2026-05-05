package kadysoft.kady;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import javafx.application.Platform;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;

public class Git {

    public static void gitCommands() {
        // ننشئ Thread جديد للخلفية
        new Thread(() -> {
            try {
                String repoPath = NewDir.file_dir;

                runCommand("git add .", repoPath);
                runCommand("git commit -m \"Update some data\"", repoPath);
                runCommand("git push", repoPath);

                // لما العمليات تخلص نرجع UI thread عشان نعرض الإشعار
                Platform.runLater(() -> {
                    Notifications noti = Notifications.create();
                    noti.title("Successful");
                    noti.text("✔ Git operations completed successfully!");
                    noti.position(Pos.CENTER);
                    noti.show();
                });

            } catch (Exception e) {
                e.printStackTrace();
                // لو في خطأ نقدر نعرضه برضه في UI
                Platform.runLater(() -> {
                    Notifications noti = Notifications.create();
                    noti.title("Error");
                    noti.text("✖ Git operations failed: " + e.getMessage());
                    noti.position(Pos.CENTER);
                    noti.show();
                });
            }
        }).start(); // نبدأ Thread
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