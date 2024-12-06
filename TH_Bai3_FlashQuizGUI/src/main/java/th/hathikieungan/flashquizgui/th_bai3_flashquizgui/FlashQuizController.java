package th.hathikieungan.flashquizgui.th_bai3_flashquizgui;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.event.ActionEvent;

public class FlashQuizController {
  // Các nút câu hỏi
  @FXML
  private Button buttonCau1, buttonCau2, buttonCau3, buttonCau4, buttonCau5,
      buttonCau6, buttonCau7, buttonCau8, buttonCau9, buttonCau10;

  // Các nút câu trả lời
  @FXML
  private Button buttonA, buttonB, buttonC, buttonD;

  // Các nút phương án
  @FXML
  private Button buttonPhuongAnA, buttonPhuongAnB, buttonPhuongAnC, buttonPhuongAnD;

  // Nút đang được chọn
  private Button selectedQuestionButton = null;
  private Button selectedAnswerButton = null;
  private Button selectedOptionButton = null;

  // Màu sắc mặc định
  private final String DEFAULT_COLOR = "#0097a7";
  private final String SELECTED_COLOR = "#4CAF50";
  private final String QUESTION_SELECTED_COLOR = "#ff0000"; // Màu đỏ cho câu hỏi được chọn

  // Xử lý sự kiện khi chọn nút câu hỏi
  @FXML
  private void handleQuestionClick(ActionEvent event) {
    Button clickedButton = (Button) event.getSource();

    // Đổi màu nút trước đó về mặc định
    if (selectedQuestionButton != null) {
      selectedQuestionButton.setStyle("-fx-background-color: #ddaa66;");
    }

    // Đổi màu nút hiện tại
    clickedButton.setStyle("-fx-background-color: " + QUESTION_SELECTED_COLOR + ";");
    selectedQuestionButton = clickedButton;
  }

  // Xử lý khi nhấn vào nút câu trả lời (A, B, C, D)
  @FXML
  private void handleAnswerClick(ActionEvent event) {
    Button clickedButton = (Button) event.getSource();

    // Reset màu cho nút trả lời trước đó và nút phương án trước đó
    if (selectedAnswerButton != null) {
      resetButtonColor(selectedAnswerButton, selectedOptionButton);
    }

    // Liên kết nút trả lời và nút phương án
    if (clickedButton == buttonA) {
      updateButtonColors(buttonA, buttonPhuongAnA);
    } else if (clickedButton == buttonB) {
      updateButtonColors(buttonB, buttonPhuongAnB);
    } else if (clickedButton == buttonC) {
      updateButtonColors(buttonC, buttonPhuongAnC);
    } else if (clickedButton == buttonD) {
      updateButtonColors(buttonD, buttonPhuongAnD);
    }
  }

  // Xử lý khi nhấn vào nút phương án (Phương án A, B, C, D)
  @FXML
  private void handleOptionClick(ActionEvent event) {
    Button clickedButton = (Button) event.getSource();

    // Reset màu cho nút trả lời trước đó và nút phương án trước đó
    if (selectedOptionButton != null) {
      resetButtonColor(selectedAnswerButton, selectedOptionButton);
    }

    // Liên kết nút phương án và nút trả lời
    if (clickedButton == buttonPhuongAnA) {
      updateButtonColors(buttonA, buttonPhuongAnA);
    } else if (clickedButton == buttonPhuongAnB) {
      updateButtonColors(buttonB, buttonPhuongAnB);
    } else if (clickedButton == buttonPhuongAnC) {
      updateButtonColors(buttonC, buttonPhuongAnC);
    } else if (clickedButton == buttonPhuongAnD) {
      updateButtonColors(buttonD, buttonPhuongAnD);
    }
  }

  // Cập nhật màu sắc cho nút trả lời và nút phương án
  private void updateButtonColors(Button answerButton, Button optionButton) {
    answerButton.setStyle("-fx-background-color: " + SELECTED_COLOR + ";");
    optionButton.setStyle("-fx-background-color: " + SELECTED_COLOR + ";");

    // Lưu lại trạng thái nút được chọn
    selectedAnswerButton = answerButton;
    selectedOptionButton = optionButton;
  }

  // Reset màu sắc về mặc định
  private void resetButtonColor(Button answerButton, Button optionButton) {
    if (answerButton != null) {
      answerButton.setStyle("-fx-background-color: " + DEFAULT_COLOR + ";");
    }
    if (optionButton != null) {
      optionButton.setStyle("-fx-background-color: " + DEFAULT_COLOR + ";");
    }
  }

  // Khởi tạo
  public void initialize() {
    // Gán sự kiện cho các nút câu hỏi
    Button[] questionButtons = {buttonCau1, buttonCau2, buttonCau3, buttonCau4, buttonCau5,
        buttonCau6, buttonCau7, buttonCau8, buttonCau9, buttonCau10};

    for (Button questionButton : questionButtons) {
      questionButton.setOnAction(this::handleQuestionClick);
      questionButton.setStyle("-fx-background-color: #ddaa66;");
    }

    // Gán sự kiện cho các nút trả lời
    Button[] answerButtons = {buttonA, buttonB, buttonC, buttonD};
    for (Button answerButton : answerButtons) {
      answerButton.setOnAction(this::handleAnswerClick);
      answerButton.setStyle("-fx-background-color: " + DEFAULT_COLOR + ";");
    }

    // Gán sự kiện cho các nút phương án
    Button[] optionButtons = {buttonPhuongAnA, buttonPhuongAnB, buttonPhuongAnC, buttonPhuongAnD};
    for (Button optionButton : optionButtons) {
      optionButton.setOnAction(this::handleOptionClick);
      optionButton.setStyle("-fx-background-color: " + DEFAULT_COLOR + ";");
    }
  }
}
