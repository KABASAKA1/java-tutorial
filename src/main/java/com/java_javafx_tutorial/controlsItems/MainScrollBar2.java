package com.java_javafx_tutorial.controlsItems;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainScrollBar2 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Text text = new Text(20,20,"BZ214 Visual Programming");
        ScrollBar sbHorizantal = new ScrollBar();
        ScrollBar sbVertical = new ScrollBar();
        sbVertical.setOrientation(Orientation.VERTICAL);
        sbHorizantal.setOrientation(Orientation.HORIZONTAL);

        Pane paneText = new Pane( );
        paneText.getChildren().addAll(text);
        BorderPane pane = new BorderPane();
        pane.setPrefSize(600, 400);
        pane.setMinSize(300, 200);
        pane.setCenter(paneText);
        pane.setBottom(sbHorizantal);
        pane.setRight(sbVertical);

        sbHorizantal.valueProperty().addListener(ov -> {
            text.setX(sbHorizantal.getValue() * paneText.getWidth() / sbHorizantal.getMax() );
        });
        sbVertical.valueProperty().addListener(ov -> {
            text.setY(sbVertical.getValue() * paneText.getHeight() / sbVertical.getMax() );
        });

        BorderPane root = new BorderPane();
        root.getChildren().add(pane);
        Scene scene = new Scene(root , 350 , 250);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
