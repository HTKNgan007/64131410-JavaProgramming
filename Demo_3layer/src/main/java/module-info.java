module nganha.demo_3layer {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.kordamp.bootstrapfx.core;
  requires java.sql;
  opens nganha.demo_3layer to javafx.fxml;
  exports nganha.demo_3layer;
  exports nganha.demo_3layer.Controller;
  opens nganha.demo_3layer.Controller to javafx.fxml;

}


