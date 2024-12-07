package th.hathikieungan.flashquiz.th_bai4_flashquiz;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainFlashQuiz extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(MainFlashQuiz.class.getResource("FlashQuiz-view.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.initStyle(StageStyle.UNDECORATED);
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}
