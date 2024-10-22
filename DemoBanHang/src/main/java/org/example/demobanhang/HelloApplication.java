package org.example.demobanhang;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.*;

public class HelloApplication  {
  //extends Application
//  @Override
//  public void start(Stage stage) throws IOException {
//    FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
//    Scene scene = new Scene(fxmlLoader.load(), 320, 240);
//    stage.setTitle("Hello!");
//    stage.setScene(scene);
//    stage.show();
//  }

  public static void main(String[] args) throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.jdbc.Driver");
    String strConn = "jdbc:mysql://localhost:3306/demobanhang";
    Connection conn = DriverManager.getConnection(strConn, "root", "");
//    System.out.println("hahaa");
    //select
    String sqlSelect = "select * from SanPham";
    Statement lenh = conn.createStatement();
    ResultSet ketQua = lenh.executeQuery(sqlSelect);
    //Hiện kết quả
    while (ketQua.next()){
      int id = ketQua.getInt(1);
      String tenSP = ketQua.getString(2);
      float giaSP = ketQua.getFloat(3);
      String moTa = ketQua.getString(4);
      System.out.println(id + " | " + tenSP + " | "  + giaSP + " | "  + moTa + " | " );
    }
   // launch();
  }
}