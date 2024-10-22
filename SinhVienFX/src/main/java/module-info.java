module org.example.sinhvienfx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
  requires json.simple;

  opens org.example.sinhvienfx to javafx.fxml;
    exports org.example.sinhvienfx;
}