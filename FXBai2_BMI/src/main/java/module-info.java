module com.example.fxbai2_bmi {
  requires javafx.controls;
  requires javafx.fxml;


  opens com.example.fxbai2_bmi to javafx.fxml;
  exports com.example.fxbai2_bmi;
}