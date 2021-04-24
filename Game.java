import javax.swing.*;

public class Game {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.add(new Gpanel());
        frame.setTitle("pong");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public Gpanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        start();
    }
}