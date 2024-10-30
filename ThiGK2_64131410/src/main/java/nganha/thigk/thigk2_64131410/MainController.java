package nganha.thigk.thigk2_64131410;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainController {
  @FXML
  private TableView<HocSinh> studentTable;

  @FXML
  private TableColumn<HocSinh, Integer> colID;

  @FXML
  private TableColumn<HocSinh, String> colTenHS;

  @FXML
  private TableColumn<HocSinh, String> colLop;

  @FXML
  private TableColumn<HocSinh, String> colNganh;

  private ObservableList<HocSinh> studentList;

  public void initialize() {
    // Khởi tạo danh sách học sinh
    studentList = FXCollections.observableArrayList();

    // Cài đặt các cột
    colID.setCellValueFactory(new PropertyValueFactory<>("id"));
    colTenHS.setCellValueFactory(new PropertyValueFactory<>("tenHS"));
    colLop.setCellValueFactory(new PropertyValueFactory<>("lop"));
    colNganh.setCellValueFactory(new PropertyValueFactory<>("nganh"));

    studentTable.setItems(studentList);

    // Tải dữ liệu từ cơ sở dữ liệu
    loadDataFromDatabase();
  }

  public void loadDataFromDatabase() {
    try {
      String strConn = "jdbc:mysql://localhost:3306/thigk";
      Connection conn = DriverManager.getConnection(strConn, "root", "");

      String sqlSelect = "SELECT * FROM HocSinh";  // Cập nhật bảng thành `HocSinh`
      Statement statement = conn.createStatement();
      ResultSet resultSet = statement.executeQuery(sqlSelect);

      // Đưa dữ liệu vào ObservableList
      while (resultSet.next()) {
        int id = resultSet.getInt("id");
        String tenHS = resultSet.getString("tenHS");
        String lop = resultSet.getString("lop");
        String nganh = resultSet.getString("nganh");

        studentList.add(new HocSinh(id, tenHS, lop, nganh));
      }
      conn.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  // Thao tác Thêm
  @FXML
  private void AddButton() {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("add-view.fxml"));
      Parent root = loader.load();
      AddController addStudentController = loader.getController();
      addStudentController.setMainController(this);

      Stage stage = new Stage();
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.setTitle("Thêm Học Sinh");
      stage.setScene(new Scene(root));
      stage.showAndWait();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void addStudentToList(HocSinh hocSinh) {
    studentList.add(hocSinh);
  }

  // Thao tác Xóa
  @FXML
  private void DeleteButton() {
    HocSinh selectedStudent = studentTable.getSelectionModel().getSelectedItem();
    if (selectedStudent != null) {
      studentList.remove(selectedStudent);
      showAlert("Xóa học sinh thành công.");
    } else {
      showAlert("Vui lòng chọn học sinh để xóa.");
    }
  }

  // Thao tác Sửa
  @FXML
  private void EditButton() {
    HocSinh selectedStudent = studentTable.getSelectionModel().getSelectedItem();
    if (selectedStudent == null) {
      showAlert("Vui lòng chọn học sinh để sửa.");
      return;
    }
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("edit-view.fxml"));
      Parent root = loader.load();
      EditController editStudentController = loader.getController();
      editStudentController.setMainController(this);
      editStudentController.setStudentData(selectedStudent);

      Stage stage = new Stage();
      stage.initModality(Modality.APPLICATION_MODAL);
      stage.setTitle("Sửa Học Sinh");
      stage.setScene(new Scene(root));
      stage.showAndWait();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
  public void updateStudentInList(HocSinh updatedStudent) {
    int index = studentList.indexOf(updatedStudent);
    if (index >= 0) {
      studentList.set(index, updatedStudent);
    }
  }

  private void showAlert(String message) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Thông báo");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }

}
