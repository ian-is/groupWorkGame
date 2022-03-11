package com.example.groupworkgame;


import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;

public class GameController {
    @FXML
    private ImageView playerSprite;
    public double y = 200;

    public int playerWidth = 100;
    public int playerHeight = 100;
    public int playerX = 900;
    public double playerY = y;

    public void movePlayer(float velY, float rotY) {
        y-=velY;
        playerSprite.setY(y);
        playerSprite.setRotate(rotY);

    }





}


