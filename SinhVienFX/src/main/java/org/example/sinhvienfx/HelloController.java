package org.example.sinhvienfx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.*;

public class HelloController {
    @FXML
    private TextField txtMSSV, txtHoTen, txtNamSinh;
    public TextArea txtKQ;
    private JSONArray studentList = new JSONArray();

    @FXML
    protected void addSV(ActionEvent event) {
        String MSSV = txtMSSV.getText();
        String HoTen = txtHoTen.getText();
        String NamSinh = txtNamSinh.getText();

        // Tạo đối tượng JSON
        JSONObject studentJson = new JSONObject();
        studentJson.put("MSSV", MSSV);
        studentJson.put("Tên", HoTen);
        studentJson.put("Năm sinh", NamSinh);

        // Thêm sinh viên vào danh sách JSON (JSONArray)
        studentList.add(studentJson);
        // Hiển thị thông tin sinh viên
        txtKQ.appendText(studentJson.toJSONString() + "\n");
        // Xóa nội dung trong các ô nhập liệu
        txtMSSV.clear();
        txtHoTen.clear();
        txtNamSinh.clear();
    }

    @FXML
    protected void Save(ActionEvent event) {
        // Đường dẫn đến file JSON mà bạn muốn lưu
        String filePath = "students.json"; // Bạn có thể thay đổi đường dẫn nếu cần
        try {
            // Tạo hoặc mở file để ghi
            FileWriter fileWriter = new FileWriter(filePath);
            // Ghi danh sách sinh viên (JSONArray) vào file
            fileWriter.write(studentList.toJSONString());
            // Đóng file sau khi ghi xong
            fileWriter.flush();
            fileWriter.close();
            // Hiển thị thông báo thành công
            System.out.println("Đã lưu nội dung vào file " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
            // Hiển thị thông báo lỗi nếu có
            System.err.println("Có lỗi xảy ra khi lưu file: " + e.getMessage());
        }
    }

    @FXML
    protected void Load(ActionEvent event) {
        // Đường dẫn tới file JSON
        String filePath = "students.json";  // Hoặc đổi thành "employees.json" nếu đúng file bạn cần

        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(filePath)) {
            // Đọc file JSON
            Object obj = jsonParser.parse(reader);
            JSONArray employeeList = (JSONArray) obj;

            // Cập nhật nội dung cho txtKQ
            txtKQ.setText(obj.toString());

        } catch (FileNotFoundException e) {
            txtKQ.setText("File không tồn tại: " + filePath);
            e.printStackTrace();
        } catch (IOException e) {
            txtKQ.setText("Lỗi đọc file: " + e.getMessage());
            e.printStackTrace();
        } catch (ParseException e) {
            txtKQ.setText("Lỗi phân tích cú pháp JSON: " + e.getMessage());
            e.printStackTrace();
        }
    }
}