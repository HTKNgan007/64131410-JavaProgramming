module th.hathikieungan.th5_hashmap.th5_hashmap {
  requires javafx.controls;
  requires javafx.fxml;

  requires org.kordamp.bootstrapfx.core;

  opens th.hathikieungan.th5_hashmap.th5_hashmap to javafx.fxml;
  exports th.hathikieungan.th5_hashmap.th5_hashmap;
}