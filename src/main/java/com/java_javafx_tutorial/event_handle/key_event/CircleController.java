package com.java_javafx_tutorial.event_handle.key_event;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class CircleController extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        Circle circle = new Circle(100,100,25);
        circle.setFill(Color.BLUE);
        circle.setFocusTraversable(true);
        circle.setOnKeyPressed(keyEvent -> {
            switch (keyEvent.getCode()) {
                case UP : circle.setCenterY(circle.getCenterY()-10); break;
                case DOWN : circle.setCenterY(circle.getCenterY()+10); break;
                case LEFT : circle.setCenterX(circle.getCenterX()-10); break;
                case RIGHT : circle.setCenterX(circle.getCenterX()+10); break;
            }
        });

        root.getChildren().add(circle);
        Scene scene = new Scene(root ,500,500);
        stage.setScene(scene);
        stage.show();
    }
}
