module com.java_javafx_tutorial {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.media;
    requires java.sql;


    opens com.java_javafx_tutorial to javafx.fxml;
    opens com.java_javafx_tutorial.event_handle to javafx.graphics;
    opens com.java_javafx_tutorial.event_handle.mouse_event to javafx.graphics;
    opens com.java_javafx_tutorial.event_handle.key_event to javafx.graphics;
    opens com.java_javafx_tutorial.textDers to javafx.graphics;
    opens com.java_javafx_tutorial.animation to javafx.graphics;
    exports com.java_javafx_tutorial;
    exports com.java_javafx_tutorial.login_ders;

    exports com.java_javafx_tutorial.database.course to javafx.graphics;
    exports com.java_javafx_tutorial.database.course.controller to javafx.fxml;
    opens com.java_javafx_tutorial.database.course.controller to javafx.fxml;
    opens com.java_javafx_tutorial.database.course.model to javafx.base;


    opens com.java_javafx_tutorial.login_ders to javafx.fxml;
    exports com.java_javafx_tutorial.controlsItems;
    opens com.java_javafx_tutorial.controlsItems to javafx.fxml;


}