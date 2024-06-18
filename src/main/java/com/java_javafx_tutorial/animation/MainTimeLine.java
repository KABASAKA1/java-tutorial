package com.java_javafx_tutorial.animation;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainTimeLine extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Rectangle rectangle = new Rectangle(50,50, Color.BLUE);  //dikdörtgen oluşturma

        //dikdörtgenin hareket etmesini sağlayacak KeyFrame'ler oluşturma
        KeyValue xValue = new KeyValue(rectangle.xProperty(), 400);
        KeyValue yValue = new KeyValue(rectangle.yProperty(), 400);
        KeyValue colorValue = new KeyValue(rectangle.fillProperty(), Color.RED);

        //KeyFrame'leri belirli bir süre için ayarlama
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(3), xValue, yValue, colorValue);

        //timeLine oluştur ve keyframe'i ekle
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(keyFrame);
        timeline.setCycleCount(Timeline.INDEFINITE);  //sonsuz döngü
        timeline.setAutoReverse(true);      //tersine dönme
        timeline.play();    //animasyonu başlatır

        Group root = new Group();
        root.getChildren().add(rectangle);
        Scene scene = new Scene(root , 400,400);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
