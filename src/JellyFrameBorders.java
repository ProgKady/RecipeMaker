

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

public class JellyFrameBorders extends Application {

    private double offsetX;
    private double offsetY;

    @Override
    public void start(Stage primaryStage) {
        // Outer container for the "jelly" frame effect
        StackPane frame = new StackPane();

        // Custom border for the frame
        Rectangle border = new Rectangle(400, 300);
        border.setArcWidth(30); // Rounded corners
        border.setArcHeight(30);
        border.setFill(Color.TRANSPARENT);
        border.setStroke(Color.LIGHTBLUE);
        border.setStrokeWidth(5);

        // Content area (inside the frame)
        Rectangle content = new Rectangle(380, 280, Color.LIGHTGRAY);
        content.setArcWidth(20);
        content.setArcHeight(20);

        frame.getChildren().addAll(border, content);

        Scene scene = new Scene(frame, 400, 300);
        primaryStage.initStyle(StageStyle.UNDECORATED); // No default OS borders
        primaryStage.setScene(scene);

        // Add drag functionality
        frame.setOnMousePressed(e -> {
            offsetX = e.getSceneX();
            offsetY = e.getSceneY();
        });

        frame.setOnMouseDragged(e -> {
            primaryStage.setX(e.getScreenX() - offsetX);
            primaryStage.setY(e.getScreenY() - offsetY);
            triggerJellyAnimation(border); // Trigger the jelly effect on drag
        });

        primaryStage.show();
    }

    private void triggerJellyAnimation(Rectangle border) {
        // Horizontal stretch and squash
        ScaleTransition scaleX = new ScaleTransition(Duration.millis(200), border);
        scaleX.setFromX(1.0);
        scaleX.setToX(1.2);
        scaleX.setAutoReverse(true);

        // Vertical stretch and squash
        ScaleTransition scaleY = new ScaleTransition(Duration.millis(200), border);
        scaleY.setFromY(1.0);
        scaleY.setToY(0.8);
        scaleY.setAutoReverse(true);

        // Combine both transitions for a "jelly" effect
        ParallelTransition jellyEffect = new ParallelTransition(scaleX, scaleY);
        jellyEffect.setInterpolator(Interpolator.EASE_OUT);
        jellyEffect.play();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
