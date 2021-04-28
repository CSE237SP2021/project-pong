package app;

import java.awt.*;

/**
 * Score class is responsible for displaying and storing the value of the scores of each of the players.
 */
public class Score {

    static int WIDTH;
    static int HEIGHT;
    static int player1Score = 0;
    static int player2Score = 0;

    public Score (int WIDTH, int HEIGHT) {
        Score.WIDTH = WIDTH;
        Score.HEIGHT = HEIGHT;
    }

    /**
     * 
     * @param g used to render a line as well as a string which shows the TENS and ONES place score for both of the players.
     */
    public void drawScore(Graphics g) {
        g.setColor(Color.green);
        g.drawLine((int)(WIDTH * 0.5), 0, (int)(WIDTH * 0.5), HEIGHT);
        g.drawString(String.valueOf(player1Score/10) + String.valueOf(player1Score%10), (int)(WIDTH * 0.5) -  40, 50);
        g.drawString(String.valueOf(player2Score/10) + String.valueOf(player2Score%10), (int)(WIDTH * 0.5) +  40, 50);
    }

    /**
     * updates the score based on which side scored
     * @param playerScore side that scored
     */
    public void updateScore(int playerScore){
        if(playerScore == 1){
            player2Score++;
        }
        if(playerScore == 2){
            player1Score++;
        }
    }

    /**
     * resets the score if player wants to restart a new game
     */
    public void resetScore(){
        player1Score = 0;
        player2Score = 0;
    }

    public int getScoreOne() {
        return player1Score;
    }
    
    public int getScoreTwo() {
        return player2Score;
    }
    
}
