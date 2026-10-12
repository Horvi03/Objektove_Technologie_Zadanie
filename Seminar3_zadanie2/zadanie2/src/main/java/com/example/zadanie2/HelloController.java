
package com.example.zadanie2;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

public class HelloController {

    @FXML
    private Pane arena;

    private Robot robot;
    private boolean automaticky = false;

    private double dx = 2;
    private double dy = 1.5;

    private static final double RYCHLOST = 5;

    @FXML
    public void initialize() {
        robot = new Robot();

        robot.setLayoutX(100);
        robot.setLayoutY(100);

        arena.getChildren().add(robot);
        arena.setFocusTraversable(true);

        robot.setOnMouseClicked(event -> {
            automaticky = !automaticky;
            arena.requestFocus();
            event.consume();
        });

        arena.setOnKeyPressed(event -> {
            if (automaticky) {
                return;
            }

            KeyCode klaves = event.getCode();

            switch (klaves) {
                case W:
                    pohyb(0, -RYCHLOST, "W");
                    break;
                case S:
                    pohyb(0, RYCHLOST, "S");
                    break;
                case A:
                    pohyb(-RYCHLOST, 0, "A");
                    break;
                case D:
                    pohyb(RYCHLOST, 0, "D");
                    break;
                default:
                    break;
            }
        });

        automatickyPohyb();
    }

    private void pohyb(double x, double y, String smer) {
        robot.pohyb(x, y, smer);
        kontrolaHranic();
    }

    private void kontrolaHranic() {
        double maxX = Math.max(0, arena.getWidth() - Robot.WIDTH);
        double maxY = Math.max(0, arena.getHeight() - Robot.HEIGHT);

        robot.setLayoutX(Math.max(0,
                Math.min(robot.getLayoutX(), maxX)));

        robot.setLayoutY(Math.max(0,
                Math.min(robot.getLayoutY(), maxY)));
    }

    private void automatickyPohyb() {
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (!automaticky) {
                    return;
                }

                double povodneX = robot.getLayoutX();
                double povodneY = robot.getLayoutY();

                double x = povodneX + dx;
                double y = povodneY + dy;

                double maxX = Math.max(0, arena.getWidth() - Robot.WIDTH);
                double maxY = Math.max(0, arena.getHeight() - Robot.HEIGHT);

                if (x <= 0 || x >= maxX) {
                    dx = -dx;
                    x = Math.max(0, Math.min(x, maxX));
                }

                if (y <= 0 || y >= maxY) {
                    dy = -dy;
                    y = Math.max(0, Math.min(y, maxY));
                }

                String smer;

                if (Math.abs(dx) >= Math.abs(dy)) {
                    smer = dx < 0 ? "A" : "D";
                } else {
                    smer = dy < 0 ? "W" : "S";
                }

                robot.pohyb(
                        x - povodneX,
                        y - povodneY,
                        smer
                );
            }
        };

        timer.start();
    }
}
