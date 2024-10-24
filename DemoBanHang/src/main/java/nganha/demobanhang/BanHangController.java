package nganha.demobanhang;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class BanHangController {
  @FXML
  private TableView<SanPham> tableSanPham;
  @FXML
  private TableColumn<SanPham, Integer> colID;
  @FXML
  private TableColumn<SanPham, String> colTenSP;
  @FXML
  private TableColumn<SanPham, Float> colGiaSP;
  @FXML
  private TableColumn<SanPham, String> colMoTa;

  private ObservableList<SanPham> dsSanPhamObservable;

  // Khởi tạo controller
  public void initialize() {
    colID.setCellValueFactory(new PropertyValueFactory<>("id"));
    colTenSP.setCellValueFactory(new PropertyValueFactory<>("tenSP"));
    colGiaSP.setCellValueFactory(new PropertyValueFactory<>("giaSP"));
    colMoTa.setCellValueFactory(new PropertyValueFactory<>("moTa"));

    dsSanPhamObservable = FXCollections.observableArrayList();
    tableSanPham.setItems(dsSanPhamObservable);

    // Tải dữ liệu từ cơ sở dữ liệu
    loadDataFromDatabase();
  }

  // Tải dữ liệu từ cơ sở dữ liệu
  public void loadDataFromDatabase() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      String strConn = "jdbc:mysql://localhost:3306/demobanhang";
      Connection conn = DriverManager.getConnection(strConn, "root", "");

      String sqlSelect = "SELECT * FROM SanPham";
      Statement lenh = conn.createStatement();
      ResultSet ketQua = lenh.executeQuery(sqlSelect);

      // Đưa dữ liệu vào ObservableList
      while (ketQua.next()) {
        int id = ketQua.getInt(1);
        String tenSP = ketQua.getString(2);
        float giaSP = ketQua.getFloat(3);
        String moTa = ketQua.getString(4);

        dsSanPhamObservable.add(new SanPham(id, tenSP, giaSP, moTa));
      }

      conn.close();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Xử lý sự kiện nút "Thêm Sản Phẩm"
  public void handleAddProduct() {
    try {
      Class.forName("com.mysql.jdbc.Driver");
      String strConn = "jdbc:mysql://localhost:3306/demobanhang";
      Connection conn = DriverManager.getConnection(strConn, "root", "");

      // Ví dụ thêm sản phẩm mới vào cơ sở dữ liệu
      String sqlInsert = "INSERT INTO SanPham (tenSP, giaSP, moTa) VALUES ('Sản phẩm mới', 10000, 'Mô tả mới')";
      Statement lenh = conn.createStatement();
      lenh.executeUpdate(sqlInsert);

      // Sau khi thêm, tải lại dữ liệu
      loadDataFromDatabase();

      conn.close();

      // Thông báo thành công
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle("Thông báo");
      alert.setHeaderText(null);
      alert.setContentText("Sản phẩm đã được thêm thành công!");
      alert.showAndWait();

    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

