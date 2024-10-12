package com.example.fxbai2_bmi;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BMIApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws IOException {
        // Tạo một FXMLLoader và nạp tệp FXML
        FXMLLoader loader = new FXMLLoader(BMIApplication.class.getResource("bmi-view.fxml")); // Tạo FXMLLoader
        Parent root = loader.load(); // Nạp file FXML và lưu vào biến root

        primaryStage.setTitle("Ứng dụng Tính BMI");
        primaryStage.setScene(new Scene(root)); // Sử dụng root để tạo Scene
        primaryStage.show(); // Hiển thị Stage
    }
    public static void main(String[] args) {
        launch(args);
    }
}
