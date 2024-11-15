module nganha.vehinh2 {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.kordamp.bootstrapfx.core;

  opens nganha.vehinh2 to javafx.fxml;
  exports nganha.vehinh2;
}