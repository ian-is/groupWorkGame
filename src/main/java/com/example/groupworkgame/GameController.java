package com.example.groupworkgame;

import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class GameController {
    @FXML
    private ImageView background;
    @FXML
    private ImageView background2;
    @FXML
    private ImageView playerSprite;
    @FXML
    private AnchorPane screen;
    public double y;
    @FXML
    public ArrayList<ImageView> objects = new ArrayList<>();
    public ArrayList<ImageView> backgrounds = new ArrayList<>();

    public void initialiseObjects() {
        playerSprite.setX(900);
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).setX(-500);
        }
        background.setX(0);
        background2.setX(1919);
    }

    public void movePlayer(float velY, float rotY) {
        y -= velY;
        playerSprite.setY(y);
        playerSprite.setRotate(rotY);

    }

    public void moveObjects() {
        for (int i = 0; i < objects.size(); i++) {
            if (isOnScreen(objects.get(i), screen)) {
                objects.get(i).setX(objects.get(i).getX() - 5);
            }
        }
    }

    public void cycleBackground() {
        for (int i = 0; i < backgrounds.size(); i++) {
            if (!isOnScreen(backgrounds.get(i), screen)) {
                backgrounds.get(i).setX(1919);
            } else {
                backgrounds.get(i).setX(backgrounds.get(i).getX() - 5);
            }
        }
    }

    public void createTopLine() {
        for (int i = 0; i < objects.size(); i++) {
            if (!isOnScreen(objects.get(i), screen)) {
                objects.get(i).setX(1919);
                objects.get(i).setY(0);
                objects.get(i).setRotate(0);
                return;
            }
        }
    }

    public void createBottomLine() {
        for (int i = 0; i < objects.size(); i++) {
            if (!isOnScreen(objects.get(i), screen)) {
                objects.get(i).setX(1919);
                objects.get(i).setY(screen.getPrefHeight() - objects.get(i).getFitHeight());
                objects.get(i).setRotate(180);
                return;
            }
        }
    }

    public boolean checkCollisions() {
        for (int i = 0; i < objects.size(); i++) {
            if (isOnScreen(objects.get(i), screen)) {
                if (collidesWith(playerSprite, objects.get(i))) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean collidesWith(ImageView one, ImageView two) {
        return one.getX() < two.getX() + two.getFitWidth() &&
                one.getX() + one.getFitWidth() > two.getX() &&
                one.getY() < two.getY() + two.getFitHeight() &&
                one.getFitHeight() + one.getY() > two.getY();
    }

    public boolean isOnScreen(ImageView one, AnchorPane two) {
        return one.getX() < two.getPrefWidth() &&
                one.getX() + one.getFitWidth() > 0 &&
                one.getY() < two.getPrefHeight() &&
                one.getFitHeight() + one.getY() > 0;
    }

}


