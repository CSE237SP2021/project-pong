package app;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

/**
 * The game class is used as the frame to draw and run our pong game off of. 
 * We utilize libraries recommended for creating a UI and that had plenty of 
 * walkthroughs for game creation.
 */
public class Game extends JPanel implements Runnable{

    final int WIDTH = 850;
    final int HEIGHT = 600;
    
    // Dimension of our game window
    final Dimension DIMENSION = new Dimension(WIDTH, HEIGHT);
    final int BALL_WIDTH = 8;
    final int PADDLE_WIDTH = 20;
    final int PADDLE_HEIGHT = 75;

    // Thread is what we use to "run" our game
    Thread thread;
    Image image;
    // Graphics is utilized for drawing what we want into our window like a canvas.
    private Graphics graphics;
    private Random rand;
    private Paddle player1;
    private Paddle player2;
    private Ball ball;
	private Score score;
    private Boolean multiplayer;


    public Game() {
        multiplayer = true;
        drawNewPaddles();
        drawNewBall();
        score = new Score(WIDTH, HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new EVENTLISTENER());
        this.setPreferredSize(DIMENSION);

        thread = new Thread(this);
        thread.start();
    }

    /**
     * drawNewPaddles creates the players paddles in the middle of the screen on each side
     * they are given an id to signify which side they belong to
     */
    public void drawNewPaddles() {
        int paddle1X = 0;
        int paddle2X = WIDTH - PADDLE_WIDTH;
        int paddleY = HEIGHT / 2;
        int [] side = new int [] {1, 2};
        player1 = new Paddle(paddle1X, paddleY, PADDLE_WIDTH, PADDLE_HEIGHT, side[0]);
        player2 = new Paddle(paddle2X, paddleY, PADDLE_WIDTH, PADDLE_HEIGHT, side[1]);

    }

    /**
     * drawNewBall creates a ball element in the center of the table that will go in a random direction
     */
    public void drawNewBall() {
        int ballX = (WIDTH / 2) - BALL_WIDTH;
        rand = new Random();
        int ballY = rand.nextInt(HEIGHT - (BALL_WIDTH * 2));
        ball = new Ball(ballX, ballY, BALL_WIDTH * 2, BALL_WIDTH * 2);

    }

    /**
     * @param g this is a window for us to paint on. We create an image with the dimensions of our game frame and utilize this for drawing things such as our paddles and ball and scoreboard.
     */
    public void paint(Graphics g) {
        image = createImage(getWidth(), getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    /**
     * @param g used for drawing components of our paddles and ball and score onto a canvas so to speak to be rendered for view.
     */
    public void draw(Graphics g) {
        player1.drawPaddle(g);
        player2.drawPaddle(g);
        ball.drawBall(g); 
        score.drawScore(g);
    }

    /**
     * update() will constantly be called to allow for movement to be more fluid in our delta timer set for the game.
     */
    public void update() {
        ball.move();
        if (multiplayer) {
            player1.move();
            player2.move();
        } else {
            player1.move();
            player2.moveAI(ball);
        }
    }

    /**
     * collisions() will handle checking to see if the ball touches the top or bottom frame. It is also responsible for checking if the ball interacts with a players' paddle. This is done through .intersects of the rectangle class.
     * 
     * We also check to see if the players' paddles are about to go off the screen and prevent that from happening.
     */
    public void collisions() {
        ball.onEdge(HEIGHT, BALL_WIDTH);

        ball.onPaddle(player1);
        ball.onPaddle(player2);

        player1.isOnEdge(HEIGHT, PADDLE_HEIGHT);
        player2.isOnEdge(HEIGHT, PADDLE_HEIGHT);

    }

    /**
     * scoring() will check if the ball goes off the screen on the right or left. If it does, update the score and reset the ball to the middle. 
     */
    public void scoring(){
        if (ball.x <= 0) {
            score.updateScore(1);
            drawNewBall();
        }
        if (ball.x >= WIDTH - (BALL_WIDTH * 2)) {
            score.updateScore(2);
            drawNewBall();
        }

    }
    /**
     * run() is part of our Thread. We utilize this for running our game engine. We use a delta timer to run the game which takes influence from minecraft in a way.
     */
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
                scoring();
                repaint();
                deltaTime--;
            }
        }
    }

    /**
     * EVENTLISTENER is used to check for keyboard input to send to our player paddles and decide if they should go up or down.
     */
    public class EVENTLISTENER extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            player1.keyPressed(e);
            if (multiplayer) {
                player2.keyPressed(e);
            }
        }

        public void keyReleased(KeyEvent e) {
            player1.keyReleased(e);
            if (multiplayer) {
                player2.keyReleased(e);
            }
        }
    }
    
    public Ball getBall(){
        return ball;
    }

    public Paddle getPlayer1() {
        return player1;
    }

    public Score getScore() {
        return score;
    } 

    public void setSinglePlayer() {
        multiplayer = false;
    }

    public void setMultiPlayer() {
        multiplayer = true;
    }
    
}
