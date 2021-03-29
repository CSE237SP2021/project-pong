import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Game extends JPanel implements Runnable{

    final int WIDTH = 850;
    final int HEIGHT = 600;
    
    final Dimension DIMENSION = new Dimension(WIDTH, HEIGHT);
    final int BALL_WIDTH = 8;
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

    public void drawNewPaddle() {
        int paddle1X = 0;
        int paddle2X = WIDTH - PADDLE_WIDTH;
        int paddleY = HEIGHT / 2;
        int [] side = new int [] {1, 2};
        player1 = new Paddle(paddle1X, paddleY, PADDLE_WIDTH, PADDLE_HEIGHT, side[0]);
        player2 = new Paddle(paddle2X, paddleY, PADDLE_WIDTH, PADDLE_HEIGHT, side[1]);

    }

    public void drawNewBall() {
        int ballX = (WIDTH / 2) - BALL_WIDTH;
        rand = new Random();
        int ballY = rand.nextInt(HEIGHT - (BALL_WIDTH * 2));
        ball = new Ball(ballX, ballY, BALL_WIDTH * 2, BALL_WIDTH * 2);

    }

    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    /**
     * 
     * @param g is the graphics unit that is drawn on to display our paddles and ball and scoreboard
     */
    public void draw(Graphics g) {
        player1.drawPaddle(g);
        player2.drawPaddle(g);
        ball.drawBall(g); 
        score.drawScore(g);
    }

    public void update() {
        player1.update();
        player2.update();
        ball.update();
    }

    public void collisions() {
        if (ball.y <= 0) {
            ball.setYV(-ball.yV);
        }
        if (ball.y >= HEIGHT - (BALL_WIDTH * 2)) {
            ball.setYV(-ball.yV);
        }

        if (ball.intersects(player1)) {
            ball.setXV(-(ball.xV));
        }
        if (ball.intersects(player2)) {
            ball.setXV(-(ball.xV));
        }

        if (player1.y <= 0) {
            player1.y = 0;
        }
        if (player1.y >= HEIGHT-PADDLE_HEIGHT) {
            player1.y = HEIGHT-PADDLE_HEIGHT;
        } 
        if (player2.y <= 0) {
            player2.y = 0;
        }
        if (player2.y >= HEIGHT-PADDLE_HEIGHT) {
            player2.y = HEIGHT-PADDLE_HEIGHT;
        } 

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
        public void keyPressed(KeyEvent e) {
            player1.keyPressed(e);
            player2.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            player1.keyReleased(e);
            player2.keyReleased(e);
        }
    }
    
}
