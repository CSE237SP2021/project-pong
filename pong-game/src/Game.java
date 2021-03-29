import java.awt.*;
import java.util.*;
import javax.swing.*;

public class Game extends JPanel implements Runnable{

    final int WIDTH = 700;
    final int HEIGHT = 500;
    
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

    }
    
    public void paint(Graphics g) {

    }

    public void update(Graphics g) {

    }

    public void run() {
        
    }
    
}
