import javax.swing.*;
import java.awt.*;

class Main {
  public static void main(String[] args) {

    JFrame f = new JFrame("hi");
    GamePanel p = new GamePanel();

    f.setVisible(true);
    f.setSize(1000, 1000);
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    f.add(p, BorderLayout.CENTER);

  }
}
