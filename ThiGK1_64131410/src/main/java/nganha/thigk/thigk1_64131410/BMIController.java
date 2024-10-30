package nganha.thigk.thigk1_64131410;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class BMIController {
  @FXML
  private TextField txtHeight;
  @FXML
  private TextField txtWeight;
  @FXML
  private TextField txtByte;
  @FXML
  private Label lblResult;
  @FXML
  private Label lblBitResult;

  private LinkedList<String> historyList = new LinkedList<>();
  private static final String LOG_FILE = "log.txt";

  @FXML
  public void initialize() {
    loadHistory();
  }

  // Hàm tính toán BMI và hiển thị kết quả
  @FXML
  private void calculateBMI() {
    try {
      double height = Double.parseDouble(txtHeight.getText());
      double weight = Double.parseDouble(txtWeight.getText());

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

      String result = String.format("BMI: %.2f (%s)", bmi, category);
      lblResult.setText(result);

      // Ghi lại lịch sử vào file
      logCalculation("BMI", result);
    } catch (NumberFormatException e) {
      lblResult.setText("Vui lòng nhập giá trị hợp lệ!");
    }
  }

  // Hàm chuyển đổi Byte sang Bit và hiển thị kết quả
  @FXML
  private void convertByteToBit() {
    try {
      int bytes = Integer.parseInt(txtByte.getText());
      int bits = bytes * 8;
      String result = String.format("%d Byte = %d Bit", bytes, bits);
      lblBitResult.setText(result);

      // Ghi lại lịch sử vào file
      logCalculation("Byte to Bit", result);
    } catch (NumberFormatException e) {
      lblBitResult.setText("Vui lòng nhập số Byte hợp lệ!");
    }
  }

  // Ghi lại lệnh tính toán vào file
  private void logCalculation(String type, String result) {
    String logEntry = type + ": " + result;
    historyList.addFirst(logEntry);
    if (historyList.size() > 10) {
      historyList.removeLast();
    }
    saveHistory();
  }

  // Lưu lịch sử vào file log.txt
  private void saveHistory() {
    try (FileWriter writer = new FileWriter(LOG_FILE)) {
      for (String entry : historyList) {
        writer.write(entry + "\n");
      }
    } catch (IOException e) {
      System.err.println("Lỗi khi ghi vào file log: " + e.getMessage());
    }
  }

  private void loadHistory() {
    try {
      List<String> lines = Files.readAllLines(Paths.get(LOG_FILE));
      for (int i = lines.size() - 1; i >= 0; i--) {
        historyList.addFirst(lines.get(i));
        if (historyList.size() > 10) {
          historyList.removeLast();
        }
      }
    } catch (IOException e) {
      System.err.println("Lỗi khi tải file log: " + e.getMessage());
    }
  }
}

