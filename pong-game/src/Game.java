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
        drawPaddle();
        drawBall();
        // score = new Score(WIDTH, HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new EVENTLISTENER());
        this.setPreferredSize(DIMENSION);

        thread = new Thread(this);
        thread.start();
    }
    
    public void paint(Graphics g) {

    }

    public void draw(Graphics g) {

    }

    public void drawPaddle() {

    }

    public void drawBall() {

    }

    public void update() {

    }

    public void collisions() {

    }

    public void run() {
        
    }

    public class EVENTLISTENER extends KeyAdapter {
        public void keyDown(KeyEvent e) {

        }

        public void keyUp(KeyEvent e) {

        }
    }
    
}
