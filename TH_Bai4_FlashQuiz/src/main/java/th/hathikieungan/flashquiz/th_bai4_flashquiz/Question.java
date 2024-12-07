package th.hathikieungan.flashquiz.th_bai4_flashquiz;

public class Question {
    private int id;
    private String questionText;
    private String image;  // Để lưu trữ tên hoặc đường dẫn hình ảnh
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctAnswer;  // Lưu trữ phương án đúng

    // Constructor
    public Question(int id, String questionText, String image,
                    String optionA, String optionB,
                    String optionC, String optionD, String correctAnswer) {
      this.id = id;
      this.questionText = questionText;
      this.image = image;
      this.optionA = optionA;
      this.optionB = optionB;
      this.optionC = optionC;
      this.optionD = optionD;
      this.correctAnswer = correctAnswer;
    }

    // Getters and Setters
    public int getId() {
      return id;
    }

    public void setId(int id) {
      this.id = id;
    }

    public String getQuestionText() {
      return questionText;
    }

    public void setQuestionText(String questionText) {
      this.questionText = questionText;
    }

    public String getImage() {
      return image;
    }

    public void setImage(String image) {
      this.image = image;
    }

    public String getOptionA() {
      return optionA;
    }

    public void setOptionA(String optionA) {
      this.optionA = optionA;
    }

    public String getOptionB() {
      return optionB;
    }

    public void setOptionB(String optionB) {
      this.optionB = optionB;
    }

    public String getOptionC() {
      return optionC;
    }

    public void setOptionC(String optionC) {
      this.optionC = optionC;
    }

    public String getOptionD() {
      return optionD;
    }

    public void setOptionD(String optionD) {
      this.optionD = optionD;
    }

    public String getCorrectAnswer() {
      return correctAnswer;
    }

    public void setCorrectAnswer(String correctAnswer) {
      this.correctAnswer = correctAnswer;
    }
}
