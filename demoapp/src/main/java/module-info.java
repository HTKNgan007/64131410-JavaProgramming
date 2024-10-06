module com.example.demoapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.demoapp to javafx.fxml;
    exports com.example.demoapp;
}