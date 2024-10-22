module org.example.demobanhang {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.controlsfx.controls;
  requires org.kordamp.bootstrapfx.core;
  requires java.sql;

  opens org.example.demobanhang to javafx.fxml;
  exports org.example.demobanhang;
}