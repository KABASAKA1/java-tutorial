package com.java_javafx_tutorial.event_handle;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class EventMain extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        Button button = new Button("outter class solution");
        Button button2 = new Button("anonymouse class solution");
        Label label = new Label();
        label.setText("vbeamzm  poabpamşl mmşab");
        label.setFont(Font.font(25));
        ClickEvent clickEvent=new ClickEvent(label);
        button.setOnAction(clickEvent);
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                double r=Math.random();
                double g=Math.random();
                double b=Math.random();
                Color color=Color.color(r,g,b);
                label.setTextFill(color);
            }
        });
        Button button3 = new Button("lambda expression solution");
        button3.setOnAction(actionEvent ->{
            double r=Math.random();
            double g=Math.random();
            double b=Math.random();
            Color color=Color.color(r,g,b);
            label.setTextFill(color);
        } );

        Button button4 = new Button("math expression solution");
//        button4.setOnAction();


        VBox root = new VBox();
        root.setSpacing(10);
        root.setAlignment(Pos.CENTER);
        root.getChildren().add(button);
        root.getChildren().add(label);
        root.getChildren().add(button2);
        root.getChildren().add(button3);
        Scene scene = new Scene(root,500,500);

        stage.setScene(scene);
        stage.show();
    }
}
