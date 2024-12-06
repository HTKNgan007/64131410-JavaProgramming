module th.hathikieungan.flashquizgui.th_bai3_flashquizgui {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.kordamp.bootstrapfx.core;
  requires java.desktop;

  opens th.hathikieungan.flashquizgui.th_bai3_flashquizgui to javafx.fxml;
  exports th.hathikieungan.flashquizgui.th_bai3_flashquizgui;
}