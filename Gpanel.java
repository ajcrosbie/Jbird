import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

public class Gpanel extends JPanel implements ActionListener {
    static final int SCREEN_WIDTH = 1000;
    static final int SCREEN_HEIGHT = 500;
    static final int PADDLE_HEIGHT = 100;
    static final int PADDLE_WIDTH = 20;
    static final int BALL_SIZE = 15;
    static final int UNIT_SIZE = 25;
    static final int DELAY = 20;
    static final int GAME_UNITS = (SCREEN_HEIGHT * SCREEN_WIDTH) / UNIT_SIZE;
    Bird bird;
    Timer timer;
    Random random = new Random();
    ArrayList<Pipe> pipes = new ArrayList<Pipe>();
    public boolean running = true;

    Gpanel() {
        this.setPreferredSize(new Dimension(SCREEN_WIDTH, SCREEN_HEIGHT));
        this.setBackground(Color.black);
        this.setFocusable(true);
        this.addKeyListener(new MyKeyAdapter());
        start1();
    }

    public void start1() {
        bird = new Bird(250, 100);
        addPipes(true);
        timer = new Timer(DELAY, this);
        timer.start();
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        draw(g);
    }

    public void draw(Graphics g) {
        g.setColor(Color.YELLOW);
        g.drawOval(bird.x, bird.y, bird.size, bird.size);
        g.fillOval(bird.x, bird.y, bird.size, bird.size);

        g.setColor(Color.GREEN);
        for (Pipe i : pipes) {
            g.drawRect(i.x, i.y, i.width, i.height);
            g.fillRect(i.x, i.y, i.width, i.height);
        }
        // g.drawRect(paddle.x, paddle.y, PADDLE_WIDTH, PADDLE_HEIGHT);
        // g.fillRect(paddle.x, paddle.y, PADDLE_WIDTH, PADDLE_HEIGHT);
        // g.drawRect(paddle1.x, paddle1.y, PADDLE_WIDTH, PADDLE_HEIGHT);
        // g.fillRect(paddle1.x, paddle1.y, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    public void addPipes(boolean v) {
        if (v) {
            int h = random.nextInt(100);
            pipes.add(new Pipe(h, 0, SCREEN_WIDTH));
            pipes.add(new Pipe(SCREEN_HEIGHT, SCREEN_HEIGHT - h - 100, SCREEN_WIDTH));
        } else if (pipes.get(pipes.size() - 1).x == 250) {
            int h = random.nextInt(100);
            pipes.add(new Pipe(h, 0, SCREEN_WIDTH));
            pipes.add(new Pipe(SCREEN_HEIGHT, SCREEN_HEIGHT - h - 100, SCREEN_WIDTH));
        }
    }

    public void removePipes() {
        if (pipes.get(0).x < -100) {
            pipes.remove(0);
            pipes.remove(0);
        }
    }

    public void dead() {
        running = false;
        System.out.println("you died ");

    }

    public void collisions() {
        for (Pipe i : pipes) {
            // System.out.println(i.x);
            if (bird.y + bird.size > i.y) {
                // System.out.println("h");
                if (bird.y < i.y + i.height) {
                    // System.out.println("i");
                    if (bird.x + bird.size > i.x) {
                        // System.out.println("t");
                        if (bird.x < i.x + i.width) {
                            dead();
                            break;
                        }
                    }
                }
            }
        }
    }

    public void move() {
        bird.move();
        for (Pipe i : pipes) {
            i.move();
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (running) {
            collisions();
            move();
            addPipes(false);
            removePipes();
        }
        repaint();
    }

    public class MyKeyAdapter extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                bird.bounce();
            }
        }

    }
}
