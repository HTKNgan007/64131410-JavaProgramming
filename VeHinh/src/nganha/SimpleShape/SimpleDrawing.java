package nganha.SimpleShape;

import javax.swing.*;
import java.awt.*;

//Vẽ hình bằng Swing GUI
public class SimpleDrawing extends JPanel {
  @Override
  protected void paintComponent(Graphics g) {
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;
    g2d.setStroke(new BasicStroke(5)); // Độ dày nét vẽ
    g2d.setColor(Color.BLACK);
    // Viền cho thân (hình tròn lớn)
    g2d.drawOval(90, 170, 130, 130);

    // Vẽ lớp nền của hình tròn nhỏ (chân nhân vật)
    g2d.setColor(Color.WHITE);
    g2d.fillOval(90, 270, 40, 40); // Chân trái
    g2d.fillOval(180, 270, 40, 40); // Chân phải

    // Vẽ lớp nền tam giác lớn (phần đầu của nhân vật)
    g2d.setColor(Color.WHITE); // Màu nền để che phần thân bên dưới
    int[] xPoints = {155, 305, 5}; // Tọa độ x của các đỉnh tam giác
    int[] yPoints = {50, 200, 200}; // Tọa độ y của các đỉnh tam giác
    g2d.fillPolygon(xPoints, yPoints, 3); // Nền của đầu

    // Vẽ lớp nền của hai tai nhỏ
    g2d.setColor(Color.BLACK); // Tai có màu đen
    // Tai trái
    int[] ear1X = {115, 115, 145};
    int[] ear1Y = {90, 40, 60};
    g2d.drawPolygon(ear1X, ear1Y, 3);
    // Tai phải
    int[] ear2X = {165, 195, 195};
    int[] ear2Y = {60, 40, 90};
    g2d.drawPolygon(ear2X, ear2Y, 3);

    // Vẽ lại các viền của từng hình để đảm bảo hiển thị rõ ràng
    g2d.setColor(Color.BLACK); // Đặt lại màu đen cho viền
    g2d.setStroke(new BasicStroke(5)); // Đặt lại độ dày nét vẽ cho viền

    // Viền cho tam giác đầu
    g2d.drawPolygon(xPoints, yPoints, 3);
    // Viền cho chân trái
    g2d.drawOval(90, 270, 40, 40);
    // Viền cho chân phải
    g2d.drawOval(180, 270, 40, 40);

    // Đổi lại màu đỏ cho các nét
    g2d.setColor(Color.RED);
    // Vẽ tam giác ngược ở giữa tam giác lớn (mũi nhân vật)
    g2d.drawPolygon(new int[]{160, 185, 135}, new int[]{170, 140, 140}, 3);
    // Vẽ các đường cong nhỏ trong chân
    g2d.setStroke(new BasicStroke(3));
    // Đường cong trong chân trái
    g2d.drawArc(95, 288, 17, 17, 90, 120);
    g2d.drawArc(98, 290, 17, 17, -80, 120);
    // Đường cong trong chân phải
    g2d.drawArc(190, 292, 17, 17, 120, 120);
    g2d.drawArc(195, 292, 17, 17, -45, 120);

  }
}
