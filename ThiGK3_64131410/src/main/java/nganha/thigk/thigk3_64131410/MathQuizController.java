package nganha.thigk.thigk3_64131410;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.util.Duration;

import java.util.*;


public class MathQuizController {
  @FXML
  private TextField soA; // TextField cho số A
  @FXML
  private TextField soB; // TextField cho số B
  @FXML
  private TextField phepToan; // TextField cho phép toán (+, -, *, /, div, mod)

  @FXML
  private Label timerLabel; // Hiển thị thời gian
  @FXML
  private Label pointLabel; // Hiển thị điểm

  @FXML
  private Button option1Button;
  @FXML
  private Button option2Button;
  @FXML
  private Button option3Button;
  @FXML
  private Button option4Button;

  private int correctAnswer; // Đáp án đúng
  private int score = 0; // Điểm của người chơi
  private int timeLeft = 5; // Thời gian đếm ngược (5 giây mỗi câu hỏi)
  private Timeline timeline;
  private boolean isAnswered = false;

  @FXML
  public void initialize() {
    pointLabel.setText("Điểm: 0");
    generateQuiz(); // Sinh câu hỏi ban đầu
  }

  // Hàm sinh câu hỏi ngẫu nhiên
  private void generateQuiz() {
    Random rand = new Random();
    int a = rand.nextInt(100) + 1; // Sinh số A ngẫu nhiên từ 1 đến 100
    int b = rand.nextInt(100) + 1; // Sinh số B ngẫu nhiên từ 1 đến 100

    soA.setText(String.valueOf(a));
    soB.setText(String.valueOf(b));

    String[] operations = {"+", "-", "*", "/", "div", "mod"};
    String operation = operations[rand.nextInt(operations.length)];
    phepToan.setText(operation);

    switch (operation) {
      case "+" -> correctAnswer = a + b;
      case "-" -> correctAnswer = a - b;
      case "*" -> correctAnswer = a * b;
      case "/" -> correctAnswer = b != 0 ? a / b : 0;
      case "div" -> correctAnswer = b != 0 ? a / b : 0;
      case "mod" -> correctAnswer = b != 0 ? a % b : 0;
    }

    // Sinh các lựa chọn trả lời
    ArrayList<Integer> options = new ArrayList<>();
    options.add(correctAnswer);
    while (options.size() < 4) {
      int wrongAnswer = correctAnswer + rand.nextInt(10) - 5; // Tạo sai số từ -5 đến +5
      if (!options.contains(wrongAnswer)) {
        options.add(wrongAnswer);
      }
    }
    Collections.shuffle(options); // Trộn ngẫu nhiên các đáp án

    // Gán đáp án vào các nút
    option1Button.setText(String.valueOf(options.get(0)));
    option2Button.setText(String.valueOf(options.get(1)));
    option3Button.setText(String.valueOf(options.get(2)));
    option4Button.setText(String.valueOf(options.get(3)));

    // Reset lại màu của các nút
    resetButtonStyles();
    isAnswered = false;
    // Khởi động lại bộ đếm thời gian
    startTimer();
  }

  // Hàm xử lý khi người dùng chọn một đáp án
  @FXML
  private void handleAnswer(javafx.event.ActionEvent event) {
    if (isAnswered) return; // Nếu đã trả lời, không cho chọn lại
    Button selectedButton = (Button) event.getSource();
    int selectedAnswer = Integer.parseInt(selectedButton.getText());

    // Kiểm tra xem người dùng chọn đúng hay sai và đổi màu nút
    if (selectedAnswer == correctAnswer) {
      selectedButton.setStyle("-fx-background-color: green;");
      score += 1;
      pointLabel.setText("Điểm: " + score);
    } else {
      selectedButton.setStyle("-fx-background-color: red;");
    }
    isAnswered = true;
    stopTimer();
    //Tự động chuyển sang câu hỏi mới sau 1 giây
    Timeline delayTimeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> generateQuiz()));
    delayTimeline.setCycleCount(1);
    delayTimeline.play();
  }

  // Hàm bắt đầu bộ đếm thời gian
  private void startTimer() {
    timeLeft = 5;
    timerLabel.setText(String.valueOf(timeLeft));

    if (timeline != null) {
      timeline.stop();
    }

    timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> {
      timeLeft--;
      timerLabel.setText(String.valueOf(timeLeft));

      if (timeLeft <= 0) {
        stopTimer();
        generateQuiz();
      }
    }));

    timeline.setCycleCount(Timeline.INDEFINITE);
    timeline.play();
  }

  // Hàm dừng bộ đếm thời gian
  private void stopTimer() {
    if (timeline != null) {
      timeline.stop();
      timeline = null;
    }
  }

  // Hàm reset lại màu sắc các nút
  private void resetButtonStyles() {
    option1Button.setStyle("-fx-background-color: #add8e6;");
    option2Button.setStyle("-fx-background-color: #add8e6;");
    option3Button.setStyle("-fx-background-color: #add8e6;");
    option4Button.setStyle("-fx-background-color: #add8e6;");
  }

  // Hàm sinh câu hỏi khi nhấn nút "Gen Quiz"
  @FXML
  private void generateQuizOnButtonClick() {
    stopTimer();
    generateQuiz();
  }
}
