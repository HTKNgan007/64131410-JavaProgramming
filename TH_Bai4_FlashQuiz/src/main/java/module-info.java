module th.hathikieungan.flashquiz.th_bai4_flashquiz {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.kordamp.bootstrapfx.core;
  requires java.sql;

  opens th.hathikieungan.flashquiz.th_bai4_flashquiz to javafx.fxml;
  exports th.hathikieungan.flashquiz.th_bai4_flashquiz;
}