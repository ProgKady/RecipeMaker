package kadysoft.kady;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import javafx.application.Platform;
import javafx.geometry.Pos;
import org.controlsfx.control.Notifications;

public class Git {

    public static void gitCommands() {
        new Thread(() -> {
            try {
                String repoPath = NewDir.file_dir;
                
                System.out.println("Git Operations Started in: " + repoPath);

                // 1. Add
                runCommand("git add .", repoPath);
                
                // 2. Commit فقط لو فيه تغييرات
                boolean hasChanges = runCommandWithResult("git status --porcelain", repoPath);
                
                if (hasChanges) {
                    runCommand("git commit -m \"Update some data - " + new java.util.Date() + "\"", repoPath);
                    runCommand("git push origin master", repoPath);   // حددنا الـ branch
                    
                    Platform.runLater(() -> showNotification("✔ Git Push Completed Successfully!", "success"));
                } else {
                    Platform.runLater(() -> showNotification("ℹ No changes to commit", "info"));
                }

            } catch (Exception e) {
                e.printStackTrace();
                Platform.runLater(() -> showNotification("✖ Git Error: " + e.getMessage(), "error"));
            }
        }).start();
    }

    private static void runCommand(String command, String workingDir) throws Exception {
        System.out.println("Running: " + command);
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
        builder.directory(new java.io.File(workingDir));
        builder.redirectErrorStream(true);
        
        Process process = builder.start();
        printProcessOutput(process);
        process.waitFor();
    }

    private static boolean runCommandWithResult(String command, String workingDir) throws Exception {
        ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", command);
        builder.directory(new java.io.File(workingDir));
        builder.redirectErrorStream(true);
        
        Process process = builder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        boolean hasOutput = false;
        
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
            if (!line.trim().isEmpty()) hasOutput = true;
        }
        process.waitFor();
        return hasOutput;
    }

    private static void printProcessOutput(Process process) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }

    private static void showNotification(String text, String type) {
        Notifications noti = Notifications.create();
        noti.title(type.equals("success") ? "Git Success" : "Git Info");
        noti.text(text);
        noti.position(Pos.CENTER);
        
        if (type.equals("success")) noti.showInformation();
        else if (type.equals("error")) noti.showError();
        else noti.showWarning();
    }
}