package app;

import java.awt.*;
import java.awt.event.*;

/**
 * Paddle class is responsible for holding which side of the screen the paddle is on as well as the position and rate of change of the paddle.
 */
public class Paddle extends Rectangle{

    private int side;
    private int yVelo;
    //deltaY is how far the paddle moves on every refresh of the game board, translates to speed
    private int deltaY = 10;

    //side is which side of the game the paddle is on, left or right
    public Paddle(int x, int y, int width, int height, int side){
        super(x, y, width, height);
        this.side = side;
    }
	
    /**
     * 
     * @param e is an event that is sent to our EVENTLISTENER class inside Game.java. We use this to check which key on the keyboard is pressed to interact with our paddle.
     */
    public void keyPressed(KeyEvent e) {
	if (side == 1) {
	    if (e.getKeyCode() == KeyEvent.VK_W) {
		yVelo = -deltaY;
	    }
	    if (e.getKeyCode() == KeyEvent.VK_S) {
		yVelo = deltaY;
	    }
	}
	else {
	    if (e.getKeyCode() == KeyEvent.VK_UP) {
		yVelo = -deltaY;
	    }
	    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		yVelo = deltaY;
	    }
	}
    }

    /**
     * keyReleased() is a function to gather which key was pressed and what direction the paddle should thus go.
     * 
     * @param e is an event that is sent to our EVENTLISTENER class inside Game.java. We use this to check which key on the keyboard is pressed to interact with our paddle.
     */
    public void keyReleased(KeyEvent e) {
	if (side == 1) {
	    if (e.getKeyCode() == KeyEvent.VK_W) {
		yVelo = 0;
	    }
	    if (e.getKeyCode() == KeyEvent.VK_S) {
		yVelo = 0;
	    }
	}
	else {
	    if (e.getKeyCode() == KeyEvent.VK_UP) {
		yVelo = 0;
	    }
	    if (e.getKeyCode() == KeyEvent.VK_DOWN) {
		yVelo = 0;
	    }
	}		
    }

    /**
     * move() is used to change the position of the paddles.
     */
    public void move() {
	y += yVelo;
    }

    /**
     * in single player, this function will move the AI paddle up or down based on if the ball is above or below the paddle's current position. 
     * @param b the ball used to play the game 
     */
    public void moveAI(Ball b) {
	if (y > b.y) {
	    y -= 3;
	} 
	else if (y < b.y) {
	    y += 3;
	} 
    }

    /**
     * checks if paddle is on the edge, keeps it from going off the screen
     * @param height height of the game container
     * @param paddle_height height of the paddle
     */
    public void isOnEdge(int height, int paddle_height){
	if (this.y <= 0){
	    this.y = 0;
	}

	if (this.y >= height - paddle_height - 25){
	    this.y = height - paddle_height - 25;
	}
    }

    /**
     * 
     * @param g Graphics is used to render a paddle onto the screen.
     */
    public void drawPaddle(Graphics g) {
	g.setColor(Color.white);
	g.fillRect(x, y, width, height);
    }

    public int getyVelo(){
	return yVelo;
    }

    public void setyVelo(int i) {
	yVelo = i;
    }

}
