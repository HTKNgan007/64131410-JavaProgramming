module org.example.carofx {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.kordamp.bootstrapfx.core;

  opens org.example.carofx to javafx.fxml;
  exports org.example.carofx;
}