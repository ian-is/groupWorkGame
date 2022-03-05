package com.example.groupworkgame;


import javafx.fxml.FXML;
import javafx.scene.image.ImageView;


public class HelloController {
    @FXML
    private ImageView playerSprite;
    private double y;


    public void movePlayer(float velY) {
        playerSprite.setY(y -= velY);
        playerSprite.setRotate(4*-velY);


    }

}


