package com.java_javafx_tutorial.animation;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainPathTransition extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Circle circle = new Circle(150,150,100);    //daire oluştur
        circle.setFill(null);
        circle.setStroke(Color.BLACK);

        Rectangle rectangle = new Rectangle(20,20,Color.RED );  //hareket edecek dikdörtgen oluşturma

        PathTransition pathTransition = new PathTransition();       //Path transition oluşturma
        pathTransition.setDuration(Duration.seconds(4));  // süreyi ayarlama
        pathTransition.setPath(circle);     //hangi yolu izleyeceğini girme
        pathTransition.setNode(rectangle);      //hangi düğümün hareket edeceğini girme
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);     //düğümün yönünü dönme çapına göre sabit tutar
        pathTransition.setCycleCount(PathTransition.INDEFINITE);    //sonsuz döngüye sokar
        pathTransition.setAutoReverse(true);    //tersine çevirme
        pathTransition.play();  //animasyonu başlatır

        Group root = new Group();
        root.getChildren().addAll(circle, rectangle);
        Scene scene = new Scene(root , 300,300);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
