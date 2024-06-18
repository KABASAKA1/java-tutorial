package com.java_javafx_tutorial.event_handle.listener;

public class MainListener {
    public static void main(String[] args) {
        MyModel model = new MyModel();
        model.nameProperty().addListener((observable, oldValue, newValue) -> {
            System.out.println("name changed from " + oldValue + " to " + newValue);
        });
        model.setName("John Doe");
        model.setName("Ahmet Sara");
    }
}
