package com.java_javafx_tutorial.controlsItems;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.scene.media.Media;

import java.net.URL;


public class MainMedia extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        URL mediaUrl = getClass().getResource("/com/java_javafx_tutorial/media.mp4");
        if (mediaUrl == null) {
            System.err.println("Medya dosyası bulunamadı!");
            return;
        }

        String url = "/com/java_javafx_tutorial/media.mp4";
        Media media = new Media(mediaUrl.toString());
        MediaPlayer mediaPlayer = new MediaPlayer(media);
        MediaView mediaView = new MediaView(mediaPlayer);

        Button btnPlay = new Button("Play");
        btnPlay.setOnAction(e -> mediaPlayer.play());
        Button btnPause = new Button("Pause");
        btnPause.setOnAction(e -> mediaPlayer.pause());
        HBox hbox = new HBox();
        hbox.getChildren().addAll(btnPlay, btnPause);

        BorderPane root = new BorderPane();
        root.setCenter(mediaView);
        root.setBottom(hbox);

        Scene scene = new Scene(root , 800,600);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
