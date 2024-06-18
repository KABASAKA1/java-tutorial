package com.java_javafx_tutorial.animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainTimeLine1 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //daire oluşturma
        Circle circle = new Circle(200,200,50, Color.BLUE);
        //dairenin büyümesini sağlayacak keyFrame'leri oluşturma
        KeyValue radiusValue = new KeyValue(circle.radiusProperty(),100);
        KeyValue colorValue = new KeyValue(circle.fillProperty(),Color.GREEN);
        //keyFrame'leri belirli bir süre için ayarlama
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(2) , radiusValue , colorValue);
        //timeLine oluşturma ve keyFrame ekleme
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE); //sonsuz döngü
        timeline.setAutoReverse(true);  //tersine dönme
        timeline.play();    //animasyonu başlatın

        Group root = new Group();
        root.getChildren().add(circle);
        Scene scene = new Scene(root ,400,500);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
