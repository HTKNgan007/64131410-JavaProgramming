package nganha.thugk.thu_gk;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginController {
  @FXML
  private TextField usernameField;

  @FXML
  private PasswordField passwordField;

  @FXML
  private Button loginButton;

  // Method xử lý khi nhấn nút "Đăng nhập"
  @FXML
  private void handleLoginButtonAction() {
    String username = usernameField.getText();
    String password = passwordField.getText();

    if (authenticateUser(username, password)) {
      try {
        // Chuyển đến màn hình chính khi đăng nhập thành công
        MainApp.showMainScene();
      } catch (Exception e) {
        e.printStackTrace(); // Ghi lại lỗi nếu có
      }
    } else {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Đăng nhập thất bại");
      alert.setHeaderText(null);
      alert.setContentText("Tên đăng nhập hoặc mật khẩu không đúng.");
      alert.showAndWait();
    }
  }

  // Phương thức xác thực người dùng trong database
  private boolean authenticateUser(String username, String password) {
    // Kết nối database, kiểm tra thông tin
    try {
      String strConn = "jdbc:mysql://localhost:3306/demogk";
      Connection conn = DriverManager.getConnection(strConn, "root", "");
      String query = "SELECT * FROM user WHERE username = ? AND password = ?";
      PreparedStatement stmt = conn.prepareStatement(query);
      stmt.setString(1, username);
      stmt.setString(2, password);
      ResultSet rs = stmt.executeQuery();

      return rs.next(); // Trả về true nếu tìm thấy người dùng
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
  }
}
