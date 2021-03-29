import java.awt.*;

public class Score {

    static int WIDTH;
    static int HEIGHT;
    static int player1;
    static int player2;

    Score (int WIDTH, int HEIGHT) {
        Score.WIDTH = WIDTH;
        Score.HEIGHT = HEIGHT;
    }

    public void drawScore(Graphics g) {
        g.setColor(Color.green);
        g.drawLine((int)(WIDTH * 0.5), 0, (int)(WIDTH * 0.5), HEIGHT);
        g.drawString(String.valueOf(player1/10) + String.valueOf(player1%10), (int)(WIDTH * 0.5) -  40, 50);
        g.drawString(String.valueOf(player2/10) + String.valueOf(player2%10), (int)(WIDTH * 0.5) +  40, 50);
    }
    
}
