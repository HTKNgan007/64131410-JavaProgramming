package th.hathikieungan.flashquiz.th_bai4_flashquiz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class FlashQuizController {
  // Các nút câu hỏi
  @FXML
  private Button buttonCau1, buttonCau2, buttonCau3, buttonCau4, buttonCau5,
      buttonCau6, buttonCau7, buttonCau8, buttonCau9, buttonCau10;

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

  // Các Text fields cho câu hỏi và phương án
  @FXML
  private Text questionText;
  @FXML
  private ImageView questionImage;  // Hiển thị hình ảnh câu hỏi nếu có

  @FXML
  private Label Score;

  private double currentScore = 0.0; // Điểm hiện tại
  private String correctAnswer; // Phương án đúng cho câu hỏi hiện tại


  // Xử lý sự kiện khi chọn nút câu hỏi
  @FXML
  private void handleQuestionClick(ActionEvent event) {
    Button clickedButton = (Button) event.getSource();
    int questionId = Integer.parseInt(clickedButton.getText().replaceAll("\\D", "")); // Extract number from button text
    // Cập nhật câu hỏi và các phương án dựa trên dữ liệu từ DB
    loadQuestionFromDatabase(questionId);
    // Reset trạng thái các nút trả lời
    resetAnswerButtons();

    // Đổi màu nút trước đó về mặc định
    if (selectedQuestionButton != null) {
      selectedQuestionButton.setStyle("-fx-background-color: #ddaa66;");
    }

    // Đổi màu nút hiện tại
    clickedButton.setStyle("-fx-background-color: " + QUESTION_SELECTED_COLOR + ";");
    selectedQuestionButton = clickedButton;
  }

  private void resetAnswerButtons() {
    Button[] answerButtons = {buttonPhuongAnA, buttonPhuongAnB, buttonPhuongAnC, buttonPhuongAnD};
    for (Button button : answerButtons) {
      button.setDisable(false); // Kích hoạt lại nút
      button.setStyle("-fx-background-color: " + DEFAULT_COLOR + ";"); // Đặt lại màu sắc mặc định
    }
    selectedAnswerButton = null; // Reset lựa chọn trả lời
    selectedOptionButton = null; // Reset lựa chọn phương án
  }

  // Xử lý sự kiện khi chọn phương án trả lời
  @FXML
  private void handleAnswerClick(ActionEvent event) {
    // Nếu đã chọn phương án, không làm gì cả
    if (selectedAnswerButton != null) {
      return;
    }

    Button clickedButton = (Button) event.getSource();
    String selectedAnswer = clickedButton.getText();

    // Kiểm tra câu trả lời đúng hay sai
    if (selectedAnswer.equals(correctAnswer)) {
      // Đúng -> Chuyển màu xanh
      clickedButton.setStyle("-fx-background-color: #4CAF50;"); // Xanh
      currentScore += 1.0; // Cộng điểm
    } else {
      // Sai -> Chuyển màu đỏ
      clickedButton.setStyle("-fx-background-color: #F44336;"); // Đỏ
      currentScore -= 0.2; // Trừ điểm
    }
    // Cập nhật điểm hiển thị
    updateScoreDisplay();
    // Lưu nút đã chọn
    selectedAnswerButton = clickedButton;
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

  // Hiển thị điểm trên giao diện
  private void updateScoreDisplay() {
    Score.setText(String.format("%.1f", currentScore));
  }

  // Tải câu hỏi từ cơ sở dữ liệu
  private void loadQuestionFromDatabase(int questionId) {
    try {
      // Sử dụng DatabaseConnection để lấy dữ liệu
      Question question = DatabaseConnection.getQuestionData(questionId);

      if (question != null) {
        // Reset các nút trả lời trước khi hiển thị câu hỏi mới
        resetAnswerButtons();
        // Cập nhật UI
        questionText.setText(question.getQuestionText());
        buttonPhuongAnA.setText(question.getOptionA());
        buttonPhuongAnB.setText(question.getOptionB());
        buttonPhuongAnC.setText(question.getOptionC());
        buttonPhuongAnD.setText(question.getOptionD());

        // Xử lý đường dẫn ảnh
        if (question.getImage() != null && !question.getImage().isEmpty()) {
          // Đường dẫn ảnh
          String imagePath = question.getImage();
          // Nếu cần đường dẫn đầy đủ, bổ sung thêm tiền tố nếu lưu đường dẫn tương đối
          if (!imagePath.startsWith("/")) {
            imagePath = "/Users/hathikieungan/Desktop/screenshot/" + imagePath; // Cập nhật base path
          }
          Image image = new Image("file:" + imagePath);
          questionImage.setImage(image); // Hiển thị ảnh trong ImageView
        }else {
          // Nếu không có ảnh, đặt giá trị null
          questionImage.setImage(null);
        }
        correctAnswer = question.getCorrectAnswer(); // Lưu phương án đúng
      }

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Khởi tạo
  public void initialize() {
    // Gán sự kiện cho các nút câu hỏi
    Button[] questionButtons = {buttonCau1, buttonCau2, buttonCau3, buttonCau4, buttonCau5,
        buttonCau6, buttonCau7, buttonCau8, buttonCau9, buttonCau10};
    for (Button questionButton : questionButtons) {
      questionButton.setOnAction(this::handleQuestionClick);
    }
    // Gán sự kiện cho các nút câu trả lời
    Button[] answerButtons = {buttonPhuongAnA, buttonPhuongAnB, buttonPhuongAnC, buttonPhuongAnD};
    for (Button answerButton : answerButtons) {
      answerButton.setOnAction(this::handleAnswerClick);
      answerButton.setStyle("-fx-background-color: " + DEFAULT_COLOR + ";");
    }

    updateScoreDisplay();
  }
}
