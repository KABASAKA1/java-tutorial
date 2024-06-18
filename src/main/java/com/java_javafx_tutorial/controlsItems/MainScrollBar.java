package com.java_javafx_tutorial.controlsItems;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainScrollBar extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        VBox content = new VBox();
        for ( int i = 0; i < 100; i++ ) {
            content.getChildren().add(new Text(" Line "+ i));
        }
        ScrollPane scrollPane = new ScrollPane(content);
        scrollPane.setFitToHeight(true);

        ScrollBar scrollBar = new ScrollBar();
        scrollBar.setOrientation(Orientation.VERTICAL);
        scrollBar.setMin(0);
        scrollBar.setMax(content.getBoundsInLocal().getHeight());
        scrollBar.valueProperty().addListener((observable, oldValue, newValue) -> {
            scrollPane.setVvalue(newValue.doubleValue() / scrollBar.getMax());
        });
        scrollPane.vvalueProperty().addListener((observable, oldValue, newValue) -> {
            scrollBar.setValue(newValue.doubleValue() / scrollBar.getMax());
        });

        VBox vbox = new VBox(scrollPane , scrollBar);
        Scene scene = new Scene(vbox , 800 , 600);
        stage.setScene(scene);
        stage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
