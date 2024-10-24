package nganha.demobanhang;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.sql.*;
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
  @FXML
  private TextField txtTenSP;
  @FXML
  private TextField txtGiaSP;
  @FXML
  private TextField txtMoTa;

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
    dsSanPhamObservable.clear();
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

  // Xử lý sự kiện khi nhấn nút "Thêm Sản Phẩm"
  public void handleAddProduct() {
    String tenSP = txtTenSP.getText();
    String giaSPStr = txtGiaSP.getText();
    String moTa = txtMoTa.getText();

    // Kiểm tra các trường không được để trống
    if (tenSP.isEmpty() || giaSPStr.isEmpty() || moTa.isEmpty()) {
      showAlert("Lỗi", "Vui lòng nhập đầy đủ thông tin sản phẩm.");
      return;
    }

    // Chuyển đổi giá trị giá sản phẩm từ String sang float
    float giaSP;
    try {
      giaSP = Float.parseFloat(giaSPStr);
    } catch (NumberFormatException e) {
      showAlert("Lỗi", "Giá sản phẩm phải là một số.");
      return;
    }

    try {
      Class.forName("com.mysql.jdbc.Driver");
      String strConn = "jdbc:mysql://localhost:3306/demobanhang";
      Connection conn = DriverManager.getConnection(strConn, "root", "");

      // Thêm sản phẩm vào cơ sở dữ liệu
      String sqlInsert = "INSERT INTO SanPham (tenSP, giaSP, moTa) VALUES (?, ?, ?)";
      PreparedStatement lenh = conn.prepareStatement(sqlInsert);
      lenh.setString(1, tenSP);
      lenh.setFloat(2, giaSP);
      lenh.setString(3, moTa);
      lenh.executeUpdate();

      // Sau khi thêm, tải lại dữ liệu
      loadDataFromDatabase();

      conn.close();

      // Thông báo thành công
      showAlert("Thành công", "Sản phẩm đã được thêm thành công!");

      // Xóa các trường nhập liệu sau khi thêm thành công
      txtTenSP.clear();
      txtGiaSP.clear();
      txtMoTa.clear();

    } catch (Exception e) {
      e.printStackTrace();
      showAlert("Lỗi", "Có lỗi xảy ra khi thêm sản phẩm.");
    }
  }

  // Hiển thị cảnh báo
  private void showAlert(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }

}

