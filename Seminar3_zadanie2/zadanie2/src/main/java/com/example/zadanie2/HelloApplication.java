package com.example.zadanie2;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(
                HelloApplication.class.getResource("hello-view.fxml")
        );

        Pane pane = loader.load();

        Scene scene = new Scene(pane, 600, 400);

        stage.setTitle("Robot");
        stage.setScene(scene);
        stage.show();

        pane.requestFocus();
    }

    public static void main(String[] args) {
        launch(args);
    }
}