

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SnakeGame extends Application {

    private static final int BLOCK_SIZE = 25;
    private static final int WIDTH = 20;
    private static final int HEIGHT = 20;
    private static final int SCENE_WIDTH = WIDTH * BLOCK_SIZE;
    private static final int SCENE_HEIGHT = HEIGHT * BLOCK_SIZE;

    private Direction direction = Direction.RIGHT;
    private boolean gameOver = false;

    private List<Point> snake = new ArrayList<>();
    private Point food;

    private enum Direction { UP, DOWN, LEFT, RIGHT }

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas(SCENE_WIDTH, SCENE_HEIGHT);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(150), e -> run(gc)));
        timeline.setCycleCount(Timeline.INDEFINITE);

        Scene scene = new Scene(new StackPane(canvas));
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP && direction != Direction.DOWN) direction = Direction.UP;
            if (e.getCode() == KeyCode.DOWN && direction != Direction.UP) direction = Direction.DOWN;
            if (e.getCode() == KeyCode.LEFT && direction != Direction.RIGHT) direction = Direction.LEFT;
            if (e.getCode() == KeyCode.RIGHT && direction != Direction.LEFT) direction = Direction.RIGHT;
        });

        resetGame();
        stage.setScene(scene);
        stage.setTitle("Snake Game");
        stage.show();
        timeline.play();
    }

    private void run(GraphicsContext gc) {
        if (gameOver) {
            gc.setFill(Color.RED);
            gc.fillText("Game Over", SCENE_WIDTH / 2 - 30, SCENE_HEIGHT / 2);
            return;
        }

        // Move the snake
        Point head = snake.get(0);
        Point newPoint = null;

        switch (direction) {
            case UP:
                newPoint = new Point(head.x, head.y - 1);
                break;
            case DOWN:
                newPoint = new Point(head.x, head.y + 1);
                break;
            case LEFT:
                newPoint = new Point(head.x - 1, head.y);
                break;
            case RIGHT:
                newPoint = new Point(head.x + 1, head.y);
                break;
        }

        // Check for game over conditions
        if (newPoint.x < 0 || newPoint.y < 0 || newPoint.x >= WIDTH || newPoint.y >= HEIGHT || snake.contains(newPoint)) {
            gameOver = true;
            return;
        }

        // Move snake and grow if food is eaten
        snake.add(0, newPoint);
        if (newPoint.equals(food)) {
            food = spawnFood();
        } else {
            snake.remove(snake.size() - 1);
        }

        // Draw everything
        gc.setFill(Color.BLACK);
        gc.fillRect(0, 0, SCENE_WIDTH, SCENE_HEIGHT);

        gc.setFill(Color.GREEN);
        for (Point p : snake) {
            gc.fillRect(p.x * BLOCK_SIZE, p.y * BLOCK_SIZE, BLOCK_SIZE - 1, BLOCK_SIZE - 1);
        }

        gc.setFill(Color.RED);
        gc.fillRect(food.x * BLOCK_SIZE, food.y * BLOCK_SIZE, BLOCK_SIZE - 1, BLOCK_SIZE - 1);
    }

    private void resetGame() {
        snake.clear();
        snake.add(new Point(WIDTH / 2, HEIGHT / 2));
        direction = Direction.RIGHT;
        food = spawnFood();
        gameOver = false;
    }

    private Point spawnFood() {
        Random rand = new Random();
        Point foodPoint;
        do {
            foodPoint = new Point(rand.nextInt(WIDTH), rand.nextInt(HEIGHT));
        } while (snake.contains(foodPoint));
        return foodPoint;
    }

    private static class Point {
        int x, y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Point point = (Point) o;
            return x == point.x && y == point.y;
        }
    }
}
