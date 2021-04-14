package app;

import java.util.*;
import java.awt.*;

/**
 * Ball is a class which holds the velocity of the ball as well as its coordinates on the screen at the moment. 
 */
public class Ball extends Rectangle{
    
    int initV = 2; 
	Random rand; 
	int xV; 
	private int yV; 
	
	public Ball(int x, int y, int width, int height){ 
		super(x,y,width,height); 
		rand = new Random();
		int randXV = rand.nextInt(2);
        int randYV = rand.nextInt(2);

		if(randXV == 0){
            randXV--;
        }
		
		if(randYV == 0){
            randYV--;
        }

        setXV(randXV*initV);
		setYV(randYV*initV);
		
	}
	
	/**
	 * 
	 * @param g uses Graphics to draw the ball and render it onto the screen.
	 */
	public void drawBall(Graphics g) {
        g.fillOval(x, y, height, width);
		g.setColor(Color.white);
	}

	/**
	 * move() is used to allow for the movement of the ball to be more fluid as the delta timer of the game goes by.
	 */
    public void move() {
		x += xV;
		y += yV;
	}

	/**
	 * checks if ball is on the edge of the screen, changes direction to make it bounce
	 * @param height height of the game container
	 * @param ball_width width of the ball
	 */
	public void onEdge(int height, int ball_width){
		if (this.y <= 0) {
            this.yV = this.yV * -1;
        }
        if (this.y >= height - (ball_width * 2) - 25) {
            this.yV = this.yV * -1;
        }
	}

	/**
	 * check if ball is on the player paddle, if so bounce off
	 * @param player player paddle to bounce on
	 */
	public void onPaddle(Paddle player){
		if (this.intersects(player)) {
            this.xV = this.xV * -1;
        }
	}

	public int getYV() {
		return yV;
	}

	public int getXV() {
		return xV;
	}

	public void setXV(int randXV) { 
		xV = randXV;
	}
	public void setYV(int randYV) { 
		yV = randYV;
	}


}