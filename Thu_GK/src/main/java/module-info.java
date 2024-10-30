module nganha.thugk.thu_gk {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.kordamp.bootstrapfx.core;
  requires java.sql;

  opens nganha.thugk.thu_gk to javafx.fxml;
  exports nganha.thugk.thu_gk;
}