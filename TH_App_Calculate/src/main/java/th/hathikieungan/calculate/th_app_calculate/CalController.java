package th.hathikieungan.calculate.th_app_calculate;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class CalController {
  @FXML
  private TextField soA; // Tương tự EditText trong Android
  @FXML
  private TextField soB;
  @FXML
  private Label ketQua; // Tương tự TextView trong Android

  @FXML
  private Button nutTinhToan; // Nút tính toán

  @FXML
  private RadioButton radioButtonAdd, radioButtonSubtract, radioButtonMultiply, radioButtonDivide;
  private ToggleGroup radioGroupPhepToan;

  @FXML
  public void initialize() {
    // Tạo ToggleGroup
    radioGroupPhepToan = new ToggleGroup();

    // Gán ToggleGroup cho các RadioButton
    radioButtonAdd.setToggleGroup(radioGroupPhepToan);
    radioButtonSubtract.setToggleGroup(radioGroupPhepToan);
    radioButtonMultiply.setToggleGroup(radioGroupPhepToan);
    radioButtonDivide.setToggleGroup(radioGroupPhepToan);

    // Đặt sự kiện cho nút "Tính toán"
    nutTinhToan.setOnAction(event -> tinhToan());
  }

  private void tinhToan() {
    String chuoiSoA = soA.getText();
    String chuoiSoB = soB.getText();

    if (chuoiSoA.isEmpty() || chuoiSoB.isEmpty()) {
      ketQua.setText("Vui lòng nhập đủ 2 số!");
      return;
    }

    try {
      double giaTriA = Double.parseDouble(chuoiSoA);
      double giaTriB = Double.parseDouble(chuoiSoB);

      // Xác định phép toán được chọn
      Toggle selectedToggle = radioGroupPhepToan.getSelectedToggle();
      if (selectedToggle == null) {
        ketQua.setText("Vui lòng chọn phép toán!");
        return;
      }

      RadioButton selectedRadioButton = (RadioButton) selectedToggle;
      String phepToan = selectedRadioButton.getText();

      // Tính toán và hiển thị kết quả
      double ketQuaTinhToan = thucHienTinhToan(giaTriA, giaTriB, phepToan);
      ketQua.setText("Kết quả: " + ketQuaTinhToan);
    } catch (NumberFormatException e) {
      ketQua.setText("Số nhập vào không hợp lệ!");
    } catch (ArithmeticException e) {
      ketQua.setText(e.getMessage());
    } catch (IllegalArgumentException e) {
      ketQua.setText("Phép toán không hợp lệ!");
    }
  }

  private double thucHienTinhToan(double a, double b, String phepToan) throws ArithmeticException {
    switch (phepToan) {
      case "Cộng":
        return a + b;
      case "Trừ":
        return a - b;
      case "Nhân": // Sử dụng ký tự "×" cho phép nhân
        return a * b;
      case "Chia": // Sử dụng ký tự "÷" cho phép chia
        if (b == 0) {
          throw new ArithmeticException("Không thể chia cho 0!");
        }
        return a / b;
      default:
        throw new IllegalArgumentException("Phép toán không hợp lệ!");
    }
  }
}

