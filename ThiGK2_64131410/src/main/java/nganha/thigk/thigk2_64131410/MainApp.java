package nganha.thigk.thigk2_64131410;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {

  private static Stage primaryStage;
  @Override
  public void start(Stage stage) throws Exception {
    //
    primaryStage = stage;
    showLoginScene();
  }
  //
  public static void showLoginScene() throws Exception {
    Parent root = FXMLLoader.load(MainApp.class.getResource("login-view.fxml"));
    primaryStage.setTitle("Đăng nhập");
    primaryStage.setScene(new Scene(root));
    primaryStage.show();
  }
  // Phương thức hiển thị màn hình chính
  public static void showMainScene() throws Exception {
    Parent root1 = FXMLLoader.load(MainApp.class.getResource("main-view.fxml"));
    primaryStage.setTitle("Màn Hình Chính");
    primaryStage.setScene(new Scene(root1));
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
