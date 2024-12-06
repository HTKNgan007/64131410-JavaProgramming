package th.hathikieungan.flashquizgui.th_bai3_flashquizgui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;

public class FlashQuizController {
  // Các nút câu hỏi
  @FXML
  private Button buttonCau1;
  @FXML
  private Button buttonCau2;
  @FXML
  private Button buttonCau3;
  @FXML
  private Button buttonCau4;
  @FXML
  private Button buttonCau5;
  @FXML
  private Button buttonCau6;
  @FXML
  private Button buttonCau7;
  @FXML
  private Button buttonCau8;
  @FXML
  private Button buttonCau9;
  @FXML
  private Button buttonCau10;

  // Các nút câu trả lời
  @FXML
  private Button buttonA;
  @FXML
  private Button buttonB;
  @FXML
  private Button buttonC;
  @FXML
  private Button buttonD;

  @FXML
  private Button buttonPhuongAnA;
  @FXML
  private Button buttonPhuongAnB;
  @FXML
  private Button buttonPhuongAnC;
  @FXML
  private Button buttonPhuongAnD;

  // Nút câu hỏi được chọn
  private Button selectedQuestionButton = null;
  private Button selectedAnswerButton = null;

  // Xử lý sự kiện khi người dùng nhấn vào câu hỏi
  @FXML
  private void handleQuestionClick(ActionEvent event) {
    Button clickedButton = (Button) event.getSource();

    // Nếu đã chọn câu hỏi, đổi lại màu ban đầu
    if (selectedQuestionButton != null) {
      selectedQuestionButton.setStyle("-fx-background-color: #ddaa66; -fx-font-size: 18px;");
    }

    // Thay đổi màu cho câu hỏi được chọn
    clickedButton.setStyle("-fx-background-color: #ff0000; -fx-font-size: 18px;");
    selectedQuestionButton = clickedButton;
  }

  // Xử lý sự kiện khi người dùng chọn phương án trả lời
  @FXML
  private void handleAnswerClick(ActionEvent event) {
    Button clickedButton = (Button) event.getSource();

    // Nếu đã chọn câu trả lời, đổi lại màu ban đầu
    if (selectedAnswerButton != null) {
      selectedAnswerButton.setStyle("-fx-background-color: #0097a7; -fx-font-size: 40px;");
    }

    // Thay đổi màu cho phương án trả lời được chọn
    clickedButton.setStyle("-fx-background-color: #4CAF50; -fx-font-size: 40px;");
    selectedAnswerButton = clickedButton;

    // Kiểm tra xem nút nào được nhấn và gọi hành động tương ứng cho buttonPhuongAn
    if (clickedButton == buttonA) {
      // Kích hoạt buttonPhuongAnA
      buttonPhuongAnA.setStyle("-fx-background-color: #4CAF50; -fx-font-size: 40px;");
      selectedAnswerButton = buttonPhuongAnA; // Gán buttonPhuongAnA là nút được chọn
    } else if (clickedButton == buttonB) {
      // Kích hoạt buttonPhuongAnB
      buttonPhuongAnB.setStyle("-fx-background-color: #4CAF50; -fx-font-size: 40px;");
      selectedAnswerButton = buttonPhuongAnB;
    } else if (clickedButton == buttonC) {
      // Kích hoạt buttonPhuongAnC
      buttonPhuongAnC.setStyle("-fx-background-color: #4CAF50; -fx-font-size: 40px;");
      selectedAnswerButton = buttonPhuongAnC;
    } else if (clickedButton == buttonD) {
      // Kích hoạt buttonPhuongAnD
      buttonPhuongAnD.setStyle("-fx-background-color: #4CAF50; -fx-font-size: 40px;");
      selectedAnswerButton = buttonPhuongAnD;
    }
  }


  // Sự kiện khi người dùng chọn câu hỏi
  public void initialize() {
    // Gán sự kiện cho các câu hỏi
    buttonCau1.setOnAction(this::handleQuestionClick);
    buttonCau2.setOnAction(this::handleQuestionClick);
    buttonCau3.setOnAction(this::handleQuestionClick);
    buttonCau4.setOnAction(this::handleQuestionClick);
    buttonCau5.setOnAction(this::handleQuestionClick);
    buttonCau6.setOnAction(this::handleQuestionClick);
    buttonCau7.setOnAction(this::handleQuestionClick);
    buttonCau8.setOnAction(this::handleQuestionClick);
    buttonCau9.setOnAction(this::handleQuestionClick);
    buttonCau10.setOnAction(this::handleQuestionClick);

    // Gán sự kiện cho các phương án trả lời
    buttonA.setOnAction(this::handleAnswerClick);
    buttonB.setOnAction(this::handleAnswerClick);
    buttonC.setOnAction(this::handleAnswerClick);
    buttonD.setOnAction(this::handleAnswerClick);

    //
    buttonPhuongAnA.setOnAction(this::handleAnswerClick);
    buttonPhuongAnB.setOnAction(this::handleAnswerClick);
    buttonPhuongAnC.setOnAction(this::handleAnswerClick);
    buttonPhuongAnD.setOnAction(this::handleAnswerClick);

  }
}
