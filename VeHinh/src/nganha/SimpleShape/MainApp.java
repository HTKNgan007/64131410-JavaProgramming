package nganha.SimpleShape;

import javax.swing.*;

public class MainApp {
  public static void main(String[] args) {
    JFrame frame = new JFrame("Simple Drawing");
    SimpleDrawing drawing = new SimpleDrawing();
    frame.add(drawing);
    frame.setSize(310, 400);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
