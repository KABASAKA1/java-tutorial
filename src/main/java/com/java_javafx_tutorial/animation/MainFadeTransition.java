package com.java_javafx_tutorial.animation;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;

public class MainFadeTransition extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button button = new Button("click to fade");

        FadeTransition fd = new FadeTransition();
        fd.setDuration(Duration.millis(1000));  // süreyi ayarlama
        fd.setNode(button);     // hangi düğüm üzerinde çalışacağını ayarlar
        fd.setFromValue(1.0);      //başlangıç opaklık değeri (1.0 = tamamen opak)
        fd.setToValue(0.0);         //bitiş opaklık değeri (0.0 = tamamen şeffaf)
        fd.setAutoReverse(true);  //geri dönerek tekrar etme
        fd.setCycleCount(2);        //bi müddet sonra şeffaflık bitiyo

        button.setOnAction(e -> {fd.play();
        });

        StackPane root = new StackPane();
        root.getChildren().add(button);
        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}





