package nganha.thigk.thigk1_64131410;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MainApp extends Application {

  public static void main(String[] args) {
    launch(args);
  }

      @Override
      public void start(Stage stage) throws IOException {
          FXMLLoader fxmlLoader = new FXMLLoader(MainApp.class.getResource("BMI-view.fxml"));
          Scene scene = new Scene(fxmlLoader.load());
          stage.setTitle("BMI");
          stage.setScene(scene);
          stage.show();
      }
}
