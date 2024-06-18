package com.java_javafx_tutorial.event_handle.listener;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class MyModel {
    private StringProperty name = new SimpleStringProperty();

    public MyModel(){
        this.name = new SimpleStringProperty(this,"serkan","");
    }

    public String getName() {
        return name.get();
    }
    public StringProperty nameProperty() {
        return name;
    }
    public void setName(String name) {
        this.name.set(name);
    }
}
