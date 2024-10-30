package nganha.thigk.thigk2_64131410;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddController {
  @FXML
  private TextField txtTenHS;

  @FXML
  private TextField txtLop;

  @FXML
  private TextField txtNganh;

  private MainController mainController;

  public void setMainController(MainController mainController) {
    this.mainController = mainController;
  }

  @FXML
  private void saveStudent() {
    String tenHS = txtTenHS.getText();
    String lop = txtLop.getText();
    String nganh = txtNganh.getText();

    HocSinh hocSinh = new HocSinh(0, tenHS, lop, nganh);
    mainController.addStudentToList(hocSinh);

    Stage stage = (Stage) txtTenHS.getScene().getWindow();
    stage.close();
  }

  @FXML
  private void cancel() {
    Stage stage = (Stage) txtTenHS.getScene().getWindow();
    stage.close();
  }
}
