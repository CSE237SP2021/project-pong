package app;

import java.awt.*;
import java.awt.event.*;

/**
 * Paddle class is responsible for holding which side of the screen the paddle is on as well as the position and rate of change of the paddle.
 */
public class Paddle extends Rectangle{

	private int side;
	private int yV;
	private int deltaY = 10;
	
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
				yV = -deltaY;
			}
			if (e.getKeyCode() == KeyEvent.VK_S) {
				yV = deltaY;
			}
		}
		else {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				yV = -deltaY;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				yV = deltaY;
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
				yV = 0;
			}
			if (e.getKeyCode() == KeyEvent.VK_S) {
				yV = 0;
			}
		}
		else {
			if (e.getKeyCode() == KeyEvent.VK_UP) {
				yV = 0;
			}
			if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				yV = 0;
			}
		}
		
	}

	/**
	 * move() is used to change the position of the paddles.
	 */
	public void move() {
		y += yV;
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

	public int getYV(){
		return yV;
	}

	public void setYV(int i) {
		yV = i;
	}
}