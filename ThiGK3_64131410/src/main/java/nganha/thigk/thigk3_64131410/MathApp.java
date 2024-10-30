package nganha.thigk.thigk3_64131410;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MathApp extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MathApp.class.getResource("math-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("MathQuiz");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}