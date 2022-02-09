package com.example.groupworkgame;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.shape.Circle;

public class HelloController {
    @FXML
    private Circle myCircle;
    private double x;
    private double y;

    public void move(KeyEvent e){
        switch(e.getCode()){
            case W:
                myCircle.setCenterY(y-=10);
                break;
            case A:
                myCircle.setCenterX(x-=10);
                break;
            case S:
                myCircle.setCenterY(y+=10);
                break;
            case D:
                myCircle.setCenterX(x+=10);
                break;
            default:
                break;

        }

    }
}
