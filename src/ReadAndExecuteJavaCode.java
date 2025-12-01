import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.*;
import javax.tools.*;

public class ReadAndExecuteJavaCode {
    public static void main(String[] args) {
        String urlString = "https://example.com/path/to/your/code.java"; // Replace with actual URL
        String localFilePath = "DownloadedCode.java";

        try {
            // Step 1: Read file from URL
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String inputLine;
                StringBuilder content = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    content.append(inputLine).append("\n");
                }
                in.close();

                // Step 2: Save file locally
                Files.write(Paths.get(localFilePath), content.toString().getBytes());
                System.out.println("File downloaded and saved as: " + localFilePath);

                // Step 3: Compile the downloaded code
                JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
                int compilationResult = compiler.run(null, null, null, localFilePath);

                if (compilationResult == 0) {
                    System.out.println("Compilation successful!");

                    // Step 4: Load and execute the compiled class
                    File file = new File("."); // Current directory
                    URL[] urls = {file.toURI().toURL()};
                    URLClassLoader classLoader = new URLClassLoader(urls);
                    Class<?> clazz = classLoader.loadClass("DownloadedCode"); // Assuming class name matches file name
                    clazz.getDeclaredMethod("main", String[].class).invoke(null, (Object) new String[]{});
                } else {
                    System.out.println("Compilation failed.");
                }
            } else {
                System.out.println("Failed to connect to the URL. Response code: " + responseCode);
            }
            connection.disconnect();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}