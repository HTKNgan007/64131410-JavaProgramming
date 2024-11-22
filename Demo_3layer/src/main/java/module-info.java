module nganha.demo_3layer {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.kordamp.bootstrapfx.core;

  opens nganha.demo_3layer to javafx.fxml;
  exports nganha.demo_3layer;
}