package controllers;

import domain.Direction;
import domain.Game;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;
import javafx.scene.text.Text;
import javafx.event.ActionEvent;

public class appController {

    private Game game;

    private Timeline gameLoop;

    @FXML
    private Button downBtn;

    @FXML
    private Button leftBtn;

    @FXML
    private GridPane map;

    @FXML
    private AnchorPane mainPanel;

    @FXML
    private Button rightBtn;

    @FXML
    private Label scoreLabel;

    @FXML
    private Button upBtn;

    @FXML
    void initialize() {
        this.game = new Game(); // Usamos un constructor modificado que no ejecuta el hilo en consola
        setupGameLoop();
        setupKeyControls();

    }
    private void setupKeyControls() {
        mainPanel.setFocusTraversable(true);
        mainPanel.requestFocus(); // Para asegurarse de que reciba los eventos

        mainPanel.setOnKeyPressed(event -> {
            System.out.println("Tecla presionada: " + event.getCode());

            switch (event.getCode()) {
                case W, UP -> game.changeDirection(Direction.UP);
                case S, DOWN -> game.changeDirection(Direction.DOWN);
                case A, LEFT -> game.changeDirection(Direction.LEFT);
                case D, RIGHT -> game.changeDirection(Direction.RIGHT);
                default ->  {}
            }
        });

    }

    private void setupGameLoop() {
        gameLoop = new Timeline(new KeyFrame(Duration.millis(400), e -> {
            game.update();
            updateMap();
            scoreLabel.setText("Puntuación: " + game.getScore());

            if (game.isGameOver()) {
                gameLoop.stop();
                scoreLabel.setText("¡Game Over! Puntuación final: " + game.getScore());
            }
        }));
        gameLoop.setCycleCount(Timeline.INDEFINITE);
        gameLoop.play();
    }

    @FXML
    void down() {
        game.changeDirection(Direction.DOWN);
    }

    @FXML
    void left() {
        game.changeDirection(Direction.LEFT);
    }

    @FXML
    void right() {
        game.changeDirection(Direction.RIGHT);
    }

    @FXML
    void up() {
        game.changeDirection(Direction.UP);
    }

    private void updateMap() {
        map.getChildren().clear();
        String[][] mapArray = game.getGameBoard().getMap();

        for (int y = 0; y < mapArray[0].length; y++) {
            for (int x = 0; x < mapArray.length; x++) {
                Label label = new Label();
                if (mapArray[x][y] == null) {
                    label.setText("-");
                } else if (mapArray[x][y].equals("snake")) {
                    label.setText("■");
                } else if (mapArray[x][y].equals("apple")) {
                    label.setText("○");
                }
                map.add(label, x, y);
            }
        }
    }
}
