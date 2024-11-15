package nganha.vehinh3;

import javafx.scene.input.MouseEvent;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;


//Thêm tính năng
public class VeHinhApp extends Application {

    private Pane drawingPane; // Khu vực để vẽ hình

    @Override
    public void start(Stage primaryStage) {
        // Tạo một Pane để chứa các hình vẽ
        drawingPane = new Pane();
        drawingPane.setPrefSize(310, 350);

        // Tạo các nút để chọn vẽ hình
        Button btnDrawCharacter = new Button("Vẽ nhân vật");
        Button btnClear = new Button("Xóa tất cả");

        // Xử lý sự kiện khi nhấn nút "Vẽ nhân vật"
        btnDrawCharacter.setOnAction(e -> drawCharacter());

        // Xử lý sự kiện khi nhấn nút "Xóa tất cả"
        btnClear.setOnAction(e -> clearDrawingPane());

        // Thêm sự kiện nhấn chuột để vẽ hình tại vị trí con trỏ chuột
        drawingPane.setOnMouseClicked(this::drawCharacterAtMouse);

        /// Bố trí các thành phần giao diện: AnchorPane để giữ button và drawingPane
        AnchorPane root = new AnchorPane();

        // Tạo một VBox chứa các button
        VBox buttonBox = new VBox(10, btnDrawCharacter, btnClear);

        // Thêm các button vào StackPane
        root.getChildren().addAll(drawingPane, buttonBox);

        // Tạo Scene và hiển thị cửa sổ
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setTitle("Simple Drawing with Controls");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Hàm để vẽ nhân vật ở vị trí mặc định
    private void drawCharacter() {
        drawCharacterAt(155, 235);
    }

    // Hàm để vẽ nhân vật tại vị trí được chỉ định
    private void drawCharacterAt(double centerX, double centerY) {
        double offsetX = centerX - 155;
        double offsetY = centerY - 235;

        // Vẽ hình tròn lớn (viền thân)
        Circle body = new Circle(centerX, centerY, 65);
        body.setStroke(Color.BLACK);
        body.setStrokeWidth(5);
        body.setFill(null);

        // Vẽ hình tròn nhỏ (chân nhân vật)
        Circle leftLeg = new Circle(centerX - 45, centerY + 55, 20);
        leftLeg.setStroke(Color.BLACK);
        leftLeg.setStrokeWidth(5);
        leftLeg.setFill(Color.WHITE);

        Circle rightLeg = new Circle(centerX + 45, centerY + 55, 20);
        rightLeg.setStroke(Color.BLACK);
        rightLeg.setStrokeWidth(5);
        rightLeg.setFill(Color.WHITE);

        // Vẽ tam giác lớn (phần đầu nhân vật)
        Polygon head = new Polygon();
        head.getPoints().addAll(
            centerX, centerY - 185,  // Đỉnh tam giác
            centerX + 150, centerY - 35, // Góc phải
            centerX - 150, centerY - 35  // Góc trái
        );
        head.setFill(Color.WHITE);
        head.setStroke(Color.BLACK);
        head.setStrokeWidth(5);

        // Vẽ tai trái
        Polygon leftEar = new Polygon();
        leftEar.getPoints().addAll(
            centerX - 40, centerY - 145, // Đáy trái
            centerX - 40, centerY - 195, // Đỉnh tai
            centerX - 10, centerY - 175  // Đáy phải
        );
        leftEar.setFill(null);
        leftEar.setStroke(Color.BLACK);
        leftEar.setStrokeWidth(5);

        // Vẽ tai phải
        Polygon rightEar = new Polygon();
        rightEar.getPoints().addAll(
            centerX + 10, centerY - 175,  // Đáy trái
            centerX + 40, centerY - 195,  // Đỉnh tai
            centerX + 40, centerY - 145   // Đáy phải
        );
        rightEar.setFill(null);
        rightEar.setStroke(Color.BLACK);
        rightEar.setStrokeWidth(5);

        // Vẽ mũi (tam giác nhỏ bên trong đầu)
        Polygon nose = new Polygon();
        nose.getPoints().addAll(
            centerX + 5, centerY - 65,  // Đỉnh mũi
            centerX + 30, centerY - 95, // Góc phải
            centerX - 30, centerY - 95  // Góc trái
        );
        nose.setFill(null);
        nose.setStroke(Color.RED);
        nose.setStrokeWidth(3);

        // Vẽ các đường cong trong chân
        Arc leftLegArc1 = new Arc(centerX - 45, centerY + 62, 10, 10, 90, 120);
        leftLegArc1.setFill(null);
        leftLegArc1.setStroke(Color.RED);
        leftLegArc1.setStrokeWidth(3);
        leftLegArc1.setType(ArcType.OPEN);

        Arc leftLegArc2 = new Arc(centerX - 43, centerY + 62, 10, 10, -80, 120);
        leftLegArc2.setFill(null);
        leftLegArc2.setStroke(Color.RED);
        leftLegArc2.setStrokeWidth(3);
        leftLegArc2.setType(ArcType.OPEN);

        Arc rightLegArc1 = new Arc(centerX + 45, centerY + 62, 10, 10, 120, 120);
        rightLegArc1.setFill(null);
        rightLegArc1.setStroke(Color.RED);
        rightLegArc1.setStrokeWidth(3);
        rightLegArc1.setType(ArcType.OPEN);

        Arc rightLegArc2 = new Arc(centerX + 47, centerY + 62, 10, 10, -45, 120);
        rightLegArc2.setFill(null);
        rightLegArc2.setStroke(Color.RED);
        rightLegArc2.setStrokeWidth(3);
        rightLegArc2.setType(ArcType.OPEN);

        // Thêm các phần của nhân vật vào Pane
        drawingPane.getChildren().addAll(
            body, leftLeg, rightLeg, head,
            leftEar, rightEar, nose,
            leftLegArc1, leftLegArc2, rightLegArc1, rightLegArc2
        );
    }

    // Hàm xử lý sự kiện nhấn chuột để vẽ hình
    private void drawCharacterAtMouse(MouseEvent event) {
        drawCharacterAt(event.getX(), event.getY());
    }

    // Hàm để xóa tất cả các hình vẽ trong drawingPane
    private void clearDrawingPane() {
        drawingPane.getChildren().clear();
    }

    public static void main(String[] args) {
        launch(args);
    }
}