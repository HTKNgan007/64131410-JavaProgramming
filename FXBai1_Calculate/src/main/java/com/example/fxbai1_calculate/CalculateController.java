package com.example.fxbai1_calculate;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CalculateController {
  @FXML
  private TextField inputA;

  @FXML
  private TextField inputB;

  @FXML
  private Label lblResult;

  @FXML
  private void calculateSum() {
    try {
      // Lấy giá trị từ các TextField và chuyển đổi sang số nguyên
      int a = Integer.parseInt(inputA.getText());
      int b = Integer.parseInt(inputB.getText());

      // Tính tổng
      int sum = a + b;

      // Hiển thị kết quả
      lblResult.setText("Kết quả: " + sum);
    } catch (NumberFormatException e) {
      // Nếu nhập sai định dạng, hiển thị thông báo lỗi
      lblResult.setText("Vui lòng nhập số hợp lệ!");
    }
  }
}
