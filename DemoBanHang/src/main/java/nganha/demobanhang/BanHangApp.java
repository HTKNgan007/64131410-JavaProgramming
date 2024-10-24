package nganha.demobanhang;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.sql.*;

import static javafx.application.Application.launch;

public class BanHangApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/nganha/demobanhang/banhangdm-view.fxml"));
        primaryStage.setTitle("Quản lý Sản Phẩm");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
//    public static void main(String[] args) throws ClassNotFoundException, SQLException {
//        Class.forName("com.mysql.jdbc.Driver");
//        String strConn = "jdbc:mysql://localhost:3306/demobanhang";
//        Connection conn = DriverManager.getConnection(strConn, "root", "");
//        //select
//        String sqlSelect = "select * from SanPham";
//        Statement lenh = conn.createStatement();
//        ResultSet ketQua = lenh.executeQuery(sqlSelect);
//        //Hiện kết quả
//        while (ketQua.next()){
//            int id = ketQua.getInt(1);
//            String tenSP = ketQua.getString(2);
//            float giaSP = ketQua.getFloat(3);
//            String moTa = ketQua.getString(4);
//            System.out.println(id + " | " + tenSP + " | "  + giaSP + " | "  + moTa + " | " );
//        }
//    }
}
