package org.example.carofx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
  private boolean xTurn = true;  // Biến xác định lượt chơi (true = X, false = O)
  private Button[][] buttons;    // Ma trận chứa các nút của lưới caro
  private boolean gameWon = false;

  @FXML
  private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9;

  @FXML
  private Label statusLabel;

  @FXML
  public void initialize() {
    buttons = new Button[][] {
        { btn1, btn2, btn3 },
        { btn4, btn5, btn6 },
        { btn7, btn8, btn9 }
    };
  }

  // Xử lý sự kiện khi người chơi nhấn vào các nút
  @FXML
  public void handleButtonAction(javafx.event.ActionEvent event) {
    Button clickedButton = (Button) event.getSource();

    if (!gameWon && clickedButton.getText().isEmpty()) {
      if (xTurn) {
        clickedButton.setText("X");
        statusLabel.setText("Player O's Turn");
      } else {
        clickedButton.setText("O");
        statusLabel.setText("Player X's Turn");
      }
      xTurn = !xTurn;
      checkWinner();
    }
  }

  // Kiểm tra người chiến thắng
  private void checkWinner() {
    // Duyệt qua các hàng, cột và đường chéo để kiểm tra
    for (int i = 0; i < 3; i++) {
      if (checkThree(buttons[i][0], buttons[i][1], buttons[i][2])) {
        announceWinner(buttons[i][0].getText());
        return;
      }
      if (checkThree(buttons[0][i], buttons[1][i], buttons[2][i])) {
        announceWinner(buttons[0][i].getText());
        return;
      }
    }
    if (checkThree(buttons[0][0], buttons[1][1], buttons[2][2])) {
      announceWinner(buttons[0][0].getText());
    } else if (checkThree(buttons[0][2], buttons[1][1], buttons[2][0])) {
      announceWinner(buttons[0][2].getText());
    } else if (isBoardFull()) {
      statusLabel.setText("It's a draw!");
    }
  }

  private boolean checkThree(Button b1, Button b2, Button b3) {
    return !b1.getText().isEmpty() && b1.getText().equals(b2.getText()) && b1.getText().equals(b3.getText());
  }

  private void announceWinner(String winner) {
    statusLabel.setText(winner + " wins!");
    gameWon = true;
  }

  private boolean isBoardFull() {
    for (Button[] row : buttons) {
      for (Button button : row) {
        if (button.getText().isEmpty()) {
          return false;
        }
      }
    }
    return true;
  }

  // Reset game
  @FXML
  public void resetGame() {
    for (Button[] row : buttons) {
      for (Button button : row) {
        button.setText("");
      }
    }
    xTurn = true;
    gameWon = false;
    statusLabel.setText("Player X's Turn");
  }
}