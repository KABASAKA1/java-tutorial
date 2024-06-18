package com.java_javafx_tutorial;

import javafx.application.Platform;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.time.LocalDateTime;

public class Clock extends Pane {
    private int sec;
    private int hour;
    private int min;

    private Circle circle;
    private double centreX , centreY , radius;
    Line secline , hourline , minline ;


    public int getSec() {
        return sec;
    }

    public void setSec(int sec) {
        this.sec = sec;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public Clock() {
        setCurrentTime();
        start();

    }

    public void start() {
        setCircle();

        Thread myThread = new Thread(() -> {
            while (true){
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    System.out.println(e.getMessage());
                }
                Platform.runLater(() -> {
                   setTimeLine();
                });
            }
        });
        myThread.start();

    }

    public void setCurrentTime(){
        LocalDateTime now = LocalDateTime.now();
        sec = now.getSecond();
        hour = now.getHour();
        min = now.getMinute();
    }

    public void setCircle(){
        centreX = getWidth()/2;
        centreY = getHeight()/2;
        radius = Math.min(getHeight(), getWidth())*0.5*0.8;
        circle = new Circle(centreX, centreY, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(5);

        getChildren().clear();
        getChildren().add(circle);
    }

    public void setTimeLine(){
        double secL=radius*0.9;
        double secTheta=(2.0*Math.PI/60.0)*sec;
        double secX=centreX+secL*Math.sin(secTheta);
        double secY=centreY+secL*Math.cos(secTheta);
        secline = new Line(centreX,centreY,secX,secY);
        secline.setStroke(Color.RED);
        secline.setStrokeWidth(1.0);

        double minL=radius*0.7;
        double minTheta=(2.0*Math.PI/60.0)*(min+sec/60);
        double minX=centreX+minL*Math.sin(minTheta);
        double minY=centreY+minL*Math.cos(minTheta);
        minline = new Line(centreX,centreY,minX,minY);
        minline.setStroke(Color.CADETBLUE);
        minline.setStrokeWidth(3.0);

        double hourL=radius*0.5;
        double hourTheta=(2.0*Math.PI/12)*(min/60 +sec/3600);
        double hourX=centreX+hourL*Math.sin(hourTheta);
        double hourY=centreY+hourL*Math.cos(hourTheta);
        hourline = new Line(centreX,centreY,hourX,hourY);
        minline.setStroke(Color.RED);
        minline.setStrokeWidth(7.0);

        getChildren().remove(secline);
        getChildren().remove(hourline);
        getChildren().remove(minline);
        getChildren().addAll(secline,hourline,minline);
    }

    public void paintClock(){
        double centreX = getWidth()/2;
        double centreY = getHeight()/2;
        double radius = Math.min(getHeight(), getWidth())*0.5*0.8;
        circle = new Circle(centreX, centreY, radius);
        circle.setFill(Color.WHITE);
        circle.setStroke(Color.BLACK);
        circle.setStrokeWidth(5);

        double secL=radius*0.9;
        double secTheta=(2.0*Math.PI/60.0)*sec;
        double secX=centreX+secL*Math.sin(secTheta);
        double secY=centreY+secL*Math.cos(secTheta);
        Line secline = new Line(centreX,centreY,secX,secY);
        secline.setStroke(Color.RED);
        secline.setStrokeWidth(1.0);

        double minL=radius*0.7;
        double minTheta=(2.0*Math.PI/60.0)*(min+sec/60);
        double minX=centreX+minL*Math.sin(minTheta);
        double minY=centreY+minL*Math.cos(minTheta);
        Line minline = new Line(centreX,centreY,minX,minY);
        minline.setStroke(Color.CADETBLUE);
        minline.setStrokeWidth(3.0);


        double hourL=radius*0.5;
        double hourTheta=(2.0*Math.PI/12)*(min/60 +sec/3600);
        double hourX=centreX+hourL*Math.sin(hourTheta);
        double hourY=centreY+hourL*Math.cos(hourTheta);
        Line hourline = new Line(centreX,centreY,hourX,hourY);
        minline.setStroke(Color.RED);
        minline.setStrokeWidth(7.0);

        getChildren().clear();
        getChildren().addAll(circle ,secline,minline,hourline);

    }
    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        start();
    }
    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        start();
    }
    

}
















