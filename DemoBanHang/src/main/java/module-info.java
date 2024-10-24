module org.example.demobanhang {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.controlsfx.controls;
  requires org.kordamp.bootstrapfx.core;
  requires java.sql;

  opens nganha.demobanhang to javafx.fxml;
  exports nganha.demobanhang;
}