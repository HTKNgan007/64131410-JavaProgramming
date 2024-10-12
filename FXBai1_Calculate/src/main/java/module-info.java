module com.example.fxbai1_calculate {
  requires javafx.controls;
  requires javafx.fxml;


  opens com.example.fxbai1_calculate to javafx.fxml;
  exports com.example.fxbai1_calculate;
}