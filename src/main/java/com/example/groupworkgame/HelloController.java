package com.example.groupworkgame;


import javafx.fxml.FXML;
import javafx.scene.shape.Circle;
import javafx.scene.image.ImageView;



public class HelloController {
    @FXML
    private Circle myCircle;
    @FXML
    private ImageView playerSprite;
    private double y;


//    public void displayImage(){
//        myCircle.setImage(playerShip);
//    }


    public void movePlayer(float velY) {
        myCircle.setCenterY(y -= velY);
    }

}


