import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Gpanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 1000;
    static final int SCREEN_HEIGHT = 500;
    static final int PADDLE_HEIGHT = 100;
    static final int PADDLE_WIDTH = 20;
    static final int BALL_SIZE = 15;
    static final int UNIT_SIZE = 25;
    static final int DELAY = 40;
    static final int GAME_UNITS = (SCREEN_HEIGHT * SCREEN_WIDTH) / UNIT_SIZE;
    public static boolean running = true;

    public void actionPerformed(ActionEvent e) {
        // if (running) {
        // collisions();
        // }
        // repaint();
    }
}
