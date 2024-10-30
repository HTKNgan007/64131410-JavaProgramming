package nganha.thigk.thigk2_64131410;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditController {
  @FXML
  private TextField txtTenHS;

  @FXML
  private TextField txtLop;

  @FXML
  private TextField txtNganh;

  private MainController mainController;
  private HocSinh student;

  public void setMainController(MainController mainController) {
    this.mainController = mainController;
  }

  public void setStudentData(HocSinh student) {
    this.student = student;
    txtTenHS.setText(student.getTenHS());
    txtLop.setText(student.getLop());
    txtNganh.setText(student.getNganh());
  }

  @FXML
  private void saveStudent() {
    student.setTenHS(txtTenHS.getText());
    student.setLop(txtLop.getText());
    student.setNganh(txtNganh.getText());

    mainController.updateStudentInList(student);

    Stage stage = (Stage) txtTenHS.getScene().getWindow();
    stage.close();
  }

  @FXML
  private void cancel() {
    Stage stage = (Stage) txtTenHS.getScene().getWindow();
    stage.close();
  }
}
