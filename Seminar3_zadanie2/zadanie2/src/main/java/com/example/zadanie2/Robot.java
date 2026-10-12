
package com.example.zadanie2;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Robot extends Group {

    public static final double WIDTH = 60;
    public static final double HEIGHT = 40;

    private final Rectangle telo;
    private final Rectangle prednaCast;

    public Robot() {
        telo = new Rectangle(WIDTH, HEIGHT);
        telo.setArcWidth(8);
        telo.setArcHeight(8);
        telo.setFill(Color.BLUE);

        prednaCast = new Rectangle(12, 12);
        prednaCast.setFill(Color.YELLOW);

        getChildren().addAll(telo, prednaCast);

        setSmer("D");
    }

    public void pohyb(double dx, double dy, String smer) {
        setLayoutX(getLayoutX() + dx);
        setLayoutY(getLayoutY() + dy);
        setSmer(smer);
    }

    public void setSmer(String smer) {
        switch (smer) {
            case "W":
                prednaCast.setX(24);
                prednaCast.setY(0);
                break;
            case "S":
                prednaCast.setX(24);
                prednaCast.setY(28);
                break;
            case "A":
                prednaCast.setX(0);
                prednaCast.setY(14);
                break;
            default:
                prednaCast.setX(48);
                prednaCast.setY(14);
                break;
        }
    }
}
