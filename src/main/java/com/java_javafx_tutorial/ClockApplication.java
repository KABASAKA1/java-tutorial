package com.java_javafx_tutorial;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClockApplication extends Application {
    @Override
    public void start(Stage stage) throws Exception {

        Clock clock = new Clock();
        Scene scene = new Scene(clock);
        stage.setScene(scene);
        stage.setWidth(500);
        stage.setHeight(500);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
