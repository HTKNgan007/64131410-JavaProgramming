package th.hathikieungan.flashquiz.th_bai4_flashquiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
  private static final String URL = "jdbc:mysql://localhost:3306/FlashQuiz";
  private static final String USER = "root";
  private static final String PASSWORD = "";
  private static Connection connection;

  // Kết nối với cơ sở dữ liệu
  public static Connection connect() throws Exception {
    if (connection == null || connection.isClosed()) {
      connection = DriverManager.getConnection(URL, USER, PASSWORD);
    }
    return connection;
  }

  // Lấy câu hỏi từ cơ sở dữ liệu và trả về đối tượng Question
  public static Question getQuestionData(int questionId) throws Exception {
    Connection con = connect();
    Statement stmt = con.createStatement();
    String query = "SELECT * FROM CauHoi WHERE id = " + questionId;
    ResultSet resultSet = stmt.executeQuery(query);

    if (resultSet.next()) {
      int id = resultSet.getInt("id");
      String questionText = resultSet.getString("CauHoi");
      String image = resultSet.getString("Hinh");
      String optionA = resultSet.getString("PA1");
      String optionB = resultSet.getString("PA2");
      String optionC = resultSet.getString("PA3");
      String optionD = resultSet.getString("PA4");
      String correctAnswer = resultSet.getString("PADung");

      return new Question(id, questionText, image, optionA, optionB, optionC, optionD, correctAnswer);
    }
    return null; // Nếu không tìm thấy câu hỏi
  }
}
