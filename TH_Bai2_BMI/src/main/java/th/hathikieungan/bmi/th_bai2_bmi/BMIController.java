package th.hathikieungan.bmi.th_bai2_bmi;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BMIController {
  @FXML
  private TextField txtHeight;

  @FXML
  private TextField txtWeight;

  @FXML
  private Label lblResult;

  @FXML
  private CheckBox chkAsian;

  // Hàm tính toán BMI và hiển thị kết quả
  @FXML
  private void calculateBMI() {
    if (txtHeight == null || txtWeight == null) {
      System.out.println("TextField không được nạp đúng");
      return;
    }
    try {
      double height = Double.parseDouble(txtHeight.getText());
      double weight = Double.parseDouble(txtWeight.getText());

      // Tính chỉ số BMI
      double bmi = weight / (height * height);

      // Lấy giá trị checkbox (Kiểm tra có phải là người châu Á không)
      boolean isAsian = chkAsian.isSelected();

      String category = evaluateBMI((float) bmi, isAsian);

      // Hiển thị kết quả
      lblResult.setText(String.format("BMI: %.2f (%s)", bmi, category));
    } catch (NumberFormatException e) {
      lblResult.setText("Vui lòng nhập giá trị hợp lệ!");
    }
  }

  // Phương thức để phân loại BMI theo tiêu chuẩn
  public String evaluateBMI(float bmi, boolean isAsia) {
    if (isAsia) {
      if (bmi < 17.50) return "Gầy";
      else if (bmi < 23.00) return "Bình thường";
      else if (bmi < 28.00) return "Thừa cân";
      else return "Béo phì";
    } else {
      if (bmi < 18.50) return "Gầy";
      else if (bmi < 25.00) return "Bình thường";
      else if (bmi < 30.00) return "Thừa cân";
      else return "Béo phì";
    }
  }
}
