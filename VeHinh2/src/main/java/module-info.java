module nganha.vehinh2 {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.kordamp.bootstrapfx.core;
  requires java.desktop;

  opens nganha.vehinh2 to javafx.fxml;
  exports nganha.vehinh2;

  opens nganha.vehinh3 to javafx.fxml;
  exports nganha.vehinh3;
}