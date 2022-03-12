package com.example.groupworkgame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class Game extends Application {

    Player player = new Player(false, 0, 0, false);
    int counter;
    int score;


    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("game-scene.fxml"));

        Parent root = fxmlLoader.load();
        GameController controller = fxmlLoader.getController();
        Scene scene = new Scene(root);
        stage.setFullScreen(false);

        scene.setOnMousePressed(mouseEvent -> player.setUp(mouseEvent.isPrimaryButtonDown()));

        scene.setOnMouseReleased(mouseEvent -> player.setUp(false));

        stage.setScene(scene);

        for (int i = 0; i < root.getChildrenUnmodifiable().size(); i++) {
            if (root.getChildrenUnmodifiable().get(i).getId().contains("background")) {
                controller.backgrounds.add((ImageView) root.getChildrenUnmodifiable().get(i));
            }
        }

        for (int i = 0; i < root.getChildrenUnmodifiable().size(); i++) {
            if (root.getChildrenUnmodifiable().get(i).getId().contains("obj")) {
                controller.objects.add((ImageView) root.getChildrenUnmodifiable().get(i));
            }
        }

        controller.initialiseObjects();

        stage.show();


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (!player.isDead) {
                    if (counter % 5 == 0) {
                        score++;
                    }
                    switch (counter) {
                        case 50 -> controller.createTopLine();
                        case 100 -> {
                            controller.createBottomLine();
                            counter = 0;
                        }
                    }
                    counter++;
                    controller.cycleBackground();
                    controller.moveObjects();
                    updatePlayerPos(player.isUp(), player.getVelY(), player.getRotY());
                    if (controller.checkCollisions()) {
                        System.out.println("you got: " + score);
                        player.setDead(true);
                    }
                }
            }

            private void updatePlayerPos(boolean up, float velY, float rotY) {

                if (controller.y - 2 * velY >= 0 && controller.y - 2 * velY < 1020) {
                    if (up && velY + 0.30 < 12) velY += 0.30;
                    if (!up && velY - 0.17 > -10) velY -= 0.17;
                    rotY = 4 * -velY;
                }
                if (controller.y - 2 * velY < 0) {
                    velY = 0;

                }
                if (controller.y - 2 * velY > 1020) {
                    velY = 0;
                }
                controller.movePlayer(velY, rotY);
                player.setRotY(rotY);
                player.setVelY(velY);
            }
        };
        timer.start();
    }

    public static void main(String[] args) {
        launch();
    }
}