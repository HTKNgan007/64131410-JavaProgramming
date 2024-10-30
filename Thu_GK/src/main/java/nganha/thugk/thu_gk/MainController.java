package nganha.thugk.thu_gk;

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

public class MainController {

  @FXML
  private TableView<SanPham> productTable;

  @FXML
  private TableColumn<SanPham, Integer> colID;

  @FXML
  private TableColumn<SanPham, String> colTenSP;

  @FXML
  private TableColumn<SanPham, Float> colGiaSP;

  @FXML
  private TableColumn<SanPham, Integer> colMoTa;

  private ObservableList<SanPham> productList;

  public void initialize() {
    // Khởi tạo danh sách sản phẩm
    productList = FXCollections.observableArrayList();

    // Cài đặt các cột
    colID.setCellValueFactory(new PropertyValueFactory<>("id"));
    colTenSP.setCellValueFactory(new PropertyValueFactory<>("TenSP"));
    colGiaSP.setCellValueFactory(new PropertyValueFactory<>("GiaSP"));
    colMoTa.setCellValueFactory(new PropertyValueFactory<>("MoTa"));

    productList = FXCollections.observableArrayList();
    productTable.setItems(productList);

    // Tải dữ liệu từ cơ sở dữ liệu
    loadDataFromDatabase();
  }
  public void loadDataFromDatabase() {
    try {
//      Class.forName("com.mysql.jdbc.Driver");
      String strConn = "jdbc:mysql://localhost:3306/demogk";
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

        productList.add(new SanPham(id, tenSP, giaSP, moTa));
      }
      conn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }


  // Thao tác Thêm
  @FXML
  private void AddButton() {
    showAlert("Thêm sản phẩm thành công.");
  }

  // Thao tác Xóa
  @FXML
  private void DeleteButton() {
      showAlert("Xoá sản phẩm thành công");
  }

  // Thao tác Sửa
  @FXML
  private void EditButton() {
      showAlert("Sửa sản phẩm thành công");
  }

  private void showAlert(String message) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Thông báo");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }

}
