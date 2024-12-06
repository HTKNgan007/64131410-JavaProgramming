module th.hathikieungan.calculate.th_app_calculate {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.kordamp.bootstrapfx.core;

  opens th.hathikieungan.calculate.th_app_calculate to javafx.fxml;
  exports th.hathikieungan.calculate.th_app_calculate;
}