package com.example.groupworkgame;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Game extends Application {

    Player player = new Player(false,0, 0, false);
    boolean up;

    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(Game.class.getResource("game-scene.fxml"));


        Parent root = fxmlLoader.load();
        GameController controller = fxmlLoader.getController();
        Scene scene = new Scene(root);
        stage.setFullScreen(false);


        //minor issue with input registration but will sort it in class

        scene.setOnMousePressed(mouseEvent -> player.setUp(mouseEvent.isPrimaryButtonDown()));
        scene.setOnMouseReleased(mouseEvent -> player.setUp(false));
        scene.setOnMousePressed(mouseEvent -> up = mouseEvent.isPrimaryButtonDown());
        scene.setOnMousePressed(mouseEvent -> up = false);


        stage.setScene(scene);
        stage.show();




        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {


                if(!player.isDead){
                    updatePlayerPos(player.isUp(), player.getVelY(), player.getRotY());
                }



            }




            private void updatePlayerPos(boolean up, float velY, float rotY) {

                if(controller.y - 2*velY >= 0 && controller.y - 2*velY < 1020){
                    if (up && velY + 0.30 < 12) velY += 0.30;
                    if (!up && velY - 0.17 > -10) velY -= 0.17;
                    rotY = 4*-velY;
                }
                if (controller.y - 2*velY < 0){
                    velY = 0;

                }
                if (controller.y - 2*velY > 1020){
                    velY = 0 ;
                }

                //check collisions here

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



