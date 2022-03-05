package com.example.groupworkgame;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;


public class HelloApplication extends Application {

    boolean up;
    float velY;


    @Override
    public void start(Stage stage) throws IOException {


        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = fxmlLoader.load();
        HelloController controller = fxmlLoader.getController();
        Scene scene = new Scene(root);
        stage.setFullScreen(true);

        scene.setOnMousePressed(mouseEvent -> up = mouseEvent.isPrimaryButtonDown());

        scene.setOnMouseReleased(mouseEvent -> up = false);

        stage.setScene(scene);
        stage.show();


        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (up && velY + 0.25 < 12) velY += 0.30;
                if (!up && velY - 0.17 > -10) velY -= 0.17;

                controller.movePlayer(velY);


            }


        };
        timer.start();
    }


    public static void main(String[] args) {
        launch();
    }
}



