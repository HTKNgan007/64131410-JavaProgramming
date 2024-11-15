package nganha.vehinh2;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

public class VeHinhApp extends Application {

  @Override
  public void start(javafx.stage.Stage primaryStage) {
    // Tạo một Pane để chứa các hình vẽ
    Pane pane = new Pane();

    // Vẽ hình tròn lớn (viền thân)
    Circle body = new Circle(155, 235, 65); // (x, y, bán kính)
    body.setStroke(Color.BLACK);
    body.setStrokeWidth(5);
    body.setFill(null);

    // Vẽ hình tròn nhỏ (chân nhân vật)
    Circle leftLeg = new Circle(110, 290, 20);
    leftLeg.setStroke(Color.BLACK);
    leftLeg.setStrokeWidth(5);
    leftLeg.setFill(Color.WHITE);

    Circle rightLeg = new Circle(200, 290, 20);
    rightLeg.setStroke(Color.BLACK);
    rightLeg.setStrokeWidth(5);
    rightLeg.setFill(Color.WHITE);

    // Vẽ tam giác lớn (phần đầu nhân vật)
    Polygon head = new Polygon();
    head.getPoints().addAll(
        155.0, 50.0,  // Đỉnh tam giác
        305.0, 200.0, // Góc phải
        5.0, 200.0    // Góc trái
    );
    head.setFill(Color.WHITE);
    head.setStroke(Color.BLACK);
    head.setStrokeWidth(5);

    // Vẽ tai trái
    Polygon leftEar = new Polygon();
    leftEar.getPoints().addAll(
        115.0, 90.0, // Đáy trái
        115.0, 40.0, // Đỉnh tai
        145.0, 60.0  // Đáy phải
    );
    leftEar.setFill(null);
    leftEar.setStroke(Color.BLACK);
    leftEar.setStrokeWidth(5);

    // Vẽ tai phải
    Polygon rightEar = new Polygon();
    rightEar.getPoints().addAll(
        165.0, 60.0,  // Đáy trái
        195.0, 40.0,  // Đỉnh tai
        195.0, 90.0   // Đáy phải
    );
    rightEar.setFill(null);
    rightEar.setStroke(Color.BLACK);
    rightEar.setStrokeWidth(5);

    // Vẽ mũi (tam giác nhỏ bên trong đầu)
    Polygon nose = new Polygon();
    nose.getPoints().addAll(
        160.0, 170.0, // Đỉnh mũi
        185.0, 140.0, // Góc phải
        135.0, 140.0  // Góc trái
    );
    nose.setFill(null);
    nose.setStroke(Color.RED);
    nose.setStrokeWidth(3);

    // Vẽ các đường cong trong chân
    Arc leftLegArc1 = new Arc(95, 288, 17, 17, 90, 120);
    leftLegArc1.setFill(null);
    leftLegArc1.setStroke(Color.RED);
    leftLegArc1.setStrokeWidth(3);
    leftLegArc1.setType(ArcType.OPEN);

    Arc leftLegArc2 = new Arc(98, 290, 17, 17, -80, 120);
    leftLegArc2.setFill(null);
    leftLegArc2.setStroke(Color.RED);
    leftLegArc2.setStrokeWidth(3);
    leftLegArc2.setType(ArcType.OPEN);

    Arc rightLegArc1 = new Arc(190, 292, 17, 17, 120, 120);
    rightLegArc1.setFill(null);
    rightLegArc1.setStroke(Color.RED);
    rightLegArc1.setStrokeWidth(3);
    rightLegArc1.setType(ArcType.OPEN);

    Arc rightLegArc2 = new Arc(195, 292, 17, 17, -45, 120);
    rightLegArc2.setFill(null);
    rightLegArc2.setStroke(Color.RED);
    rightLegArc2.setStrokeWidth(3);
    rightLegArc2.setType(ArcType.OPEN);

    // Thêm tất cả các hình vào Pane
    pane.getChildren().addAll(
        body, leftLeg, rightLeg, head,
        leftEar, rightEar, nose,
        leftLegArc1, leftLegArc2, rightLegArc1, rightLegArc2
    );

    // Tạo Scene và hiển thị cửa sổ
    Scene scene = new Scene(pane, 310, 350);
    primaryStage.setTitle("Simple Drawing in JavaFX");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
