module com.example.demoapp {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.demoapp to javafx.fxml;
    exports com.example.demoapp;
}