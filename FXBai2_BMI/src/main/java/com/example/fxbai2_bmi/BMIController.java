package com.example.fxbai2_bmi;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BMIController {
  @FXML
  private TextField txtHeight;

  @FXML
  private TextField txtWeight;

  @FXML
  private Label lblResult;

  // Hàm tính toán BMI và hiển thị kết quả
  @FXML
  private void calculateBMI() {
    if (txtHeight == null || txtWeight == null) {
      System.out.println("TextField không được nạp đúng");
      return;
    }
    try {
      // Lấy giá trị từ TextField và chuyển đổi sang số thực
      double height = Double.parseDouble(txtHeight.getText());
      double weight = Double.parseDouble(txtWeight.getText());

      // Tính chỉ số BMI
      double bmi = weight / (height * height);

      // Phân loại theo BMI
      String category;
      if (bmi < 18.5) {
        category = "Thiếu cân";
      } else if (bmi >= 18.5 && bmi < 24.9) {
        category = "Bình thường";
      } else if (bmi >= 25 && bmi < 29.9) {
        category = "Thừa cân";
      } else {
        category = "Béo phì";
      }

      // Hiển thị kết quả
      lblResult.setText(String.format("BMI: %.2f (%s)", bmi, category));
    } catch (NumberFormatException e) {
      lblResult.setText("Vui lòng nhập giá trị hợp lệ!");
    }
  }
}
