import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Game extends JPanel implements Runnable{

    final int WIDTH = 850;
    final int HEIGHT = 600;
    
    final Dimension DIMENSION = new Dimension(WIDTH, HEIGHT);
    final int BALL_DIAMETER = 15;
    final int PADDLE_WIDTH = 20;
    final int PADDLE_HEIGHT = 75;

    Thread thread;

    Image image;

    Graphics graphics;

    Random rand;

    Paddle player1;

    Paddle player2;

    Ball ball;

	Score score;


    Game() {
        drawNewPaddle();
        drawNewBall();
        score = new Score(WIDTH, HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new EVENTLISTENER());
        this.setPreferredSize(DIMENSION);

        thread = new Thread(this);
        thread.start();
    }
    
    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g) {
        score.drawScore(g);
    }

    public void drawNewPaddle() {

    }

    public void drawNewBall() {

    }

    public void update() {

    }

    public void collisions() {

    }

    public void run() {
        long prevTime = System.nanoTime();
        double tick = 60.0;
        double ns = 1000000000 / tick;
        double deltaTime = 0;
        while(true) {
            long now = System.nanoTime();
            deltaTime += (now - prevTime) / ns;
            prevTime = now;
            if (deltaTime >= 1) {
                update();
                collisions();
                repaint();
                deltaTime--;
            }
        }
    }

    public class EVENTLISTENER extends KeyAdapter {
        public void keyDown(KeyEvent e) {

        }

        public void keyUp(KeyEvent e) {

        }
    }
    
}
