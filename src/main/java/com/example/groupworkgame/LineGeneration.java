package com.example.groupworkgame;

import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Screen;

public class LineGeneration {

    static public Group allPaths() {
        Group path1 = firstLines();
        Path path2 = randomLineGen();
        Path path3 = randomLineGen2();
        Group group = new Group(path1, path2, path3);
        return group;
    }

    static private Group firstLines() {

        Path path = new Path();
        path.setStrokeWidth(3);
        Path path2 = new Path();
        path2.setStrokeWidth(3);
        int r = randomBoolean();
        double screenHeight = findScreenHeight();
        MoveTo moveTo = new MoveTo(0, screenHeight / 3);
        MoveTo moveTo2 = new MoveTo(0, screenHeight - (screenHeight / 3));
        LineTo line0 = new LineTo(1600, screenHeight / 3);
        LineTo line1 = new LineTo(1600, screenHeight - (screenHeight) / 3);
        path.getElements().add(moveTo);
        path.getElements().add(line0);
        path2.getElements().add(moveTo2);
        path2.getElements().add(line1);
        LineTo line3 = new LineTo();
        LineTo line4 = new LineTo();

        if (r == 1) {
            line3.setY(screenHeight / 5);
            line3.setX(3200);
            line4.setY(screenHeight / 2);
            line4.setX(3200);
        } else if (r == 2) {

            line3.setY(screenHeight / 2);
            line3.setX(3200);
            line4.setY(screenHeight - (screenHeight / 5));
            line4.setX(3200);
        } else {
            line3.setY(screenHeight / 2.5);
            line3.setX(3200);
            line4.setY(screenHeight - (screenHeight / 2.5));
            line4.setX(3200);
        }
        path.getElements().add(line3);
        path2.getElements().add(line4);
        Group pathGroup = new Group(path, path2);
        return pathGroup;
    }

   static private Path randomLineGen() {
        Path path = new Path();
        path.setStrokeWidth(3);
        double screenHeight = findScreenHeight();
        MoveTo moveTo = new MoveTo(300, screenHeight - (screenHeight / 3));
        path.getElements().add(moveTo);
        int x = 300;
        for (int i = 0; i < 500; i++) {
            double p = perlinNoiseGeneration();
            LineTo line1 = new LineTo(x, (screenHeight - (p * screenHeight)));
            double p2 = perlinNoiseGeneration();
            LineTo line2 = new LineTo(x, screenHeight - (p2 * screenHeight));
            path.getElements().addAll(line1, line2);
            x = x + 100;
        }
        return path;

    }

   static private Path randomLineGen2() {
        Path path = new Path();
        path.setStrokeWidth(3);
        double screenHeight = findScreenHeight();
        MoveTo moveTo = new MoveTo(300, screenHeight / 3);
        path.getElements().add(moveTo);
        int x = 300;
        for (int i = 0; i < 500; i++) {
            double p = perlinNoiseGeneration();
            LineTo line1 = new LineTo(x, p * screenHeight);
            double p2 = perlinNoiseGeneration();
            LineTo line2 = new LineTo(x, p2 * screenHeight);
            path.getElements().addAll(line1, line2);
            x = x + 100;
        }
        return path;

    }

   static private int randomBoolean() {
        double low = 1;
        int high = 4;
        int randomNum = (int) ((Math.random() * (high - low)) + low);
        return randomNum;

    }

    static public double randomNum() {
        double low = 3.001;
        int high = 4;
        double randomNum = (Math.random() * (high - low)) + low;
        return randomNum;
    }

   static private double perlinNoiseGeneration() {
        double randomNum = randomNum();
        double p = PerlinNoise.noise(randomNum, 42, 7);
        return p;
    }


   static private double findScreenHeight() {
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double screenHeight = screenBounds.getHeight();
        return screenHeight;

    }

   static private double findScreenWidth() {
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double screenWidth = screenBounds.getWidth();
        return screenWidth;
    }


}
