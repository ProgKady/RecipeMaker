
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.python.util.PythonInterpreter;

public class JavaPythonJython extends Application {
    @Override
    public void start(Stage primaryStage) {
        Button runPythonButton = new Button("Open Python GUI");
        runPythonButton.setOnAction(e -> runPythonScript());

        VBox layout = new VBox(10, runPythonButton);
        Scene scene = new Scene(layout, 300, 200);

        primaryStage.setScene(scene);
        primaryStage.setTitle("JavaFX with Python (Jython)");
        primaryStage.show();
    }

    private void runPythonScript() {
        PythonInterpreter interpreter = new PythonInterpreter();
        String pythonCode = 
                "# Open the file in read mode\n" +
"with open(\"example.txt\", \"r\") as file:\n" +
"    for line in file:\n" +
"        print(line.strip())  # `strip()` removes any trailing newline or space";
            interpreter.exec(pythonCode);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

