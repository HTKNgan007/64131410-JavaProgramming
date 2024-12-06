module th.hathikieungan.bmi.th_bai2_bmi {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.kordamp.bootstrapfx.core;

  opens th.hathikieungan.bmi.th_bai2_bmi to javafx.fxml;
  exports th.hathikieungan.bmi.th_bai2_bmi;
}