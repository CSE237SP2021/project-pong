package app;

import java.util.*;
import java.awt.*;

/**
 * Ball is a class which holds the velocity of the ball as well as its coordinates on the screen at the moment. 
 */
public class Ball extends Rectangle{
    
    //velo = velocity for clarity. 
    int initVelo = 4;
    Random rand;
    int xVelo;
    private int yVelo;
	
    public Ball(int x, int y, int width, int height){
	super(x,y,width,height);
	rand = new Random();
	int randXVelo = rand.nextInt(2);
        int randYVelo = rand.nextInt(2);

	if(randXVelo == 0){
            randXVelo--;
        }
		
	if(randYVelo == 0){
            randYVelo--;
        }

        setXVelo(randXVelo*initVelo);
	setYVelo(randYVelo*initVelo);
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
	x += xVelo;
	y += yVelo;
    }

    /**
     * checks if ball is on the edge of the screen, changes direction to make it bounce
     * @param height height of the game container
     * @param ball_width width of the ball
     */
    public void onEdge(int height, int ball_width){
	if (this.y <= 0) {
            this.yVelo = this.yVelo * -1;
        }
        if (this.y >= height - (ball_width * 2) - 25) {
            this.yVelo = this.yVelo * -1;
        }
    }

    /**
     * check if ball is on the player paddle, if so bounce off
     * @param player player paddle to bounce on
     */
    public void onPaddle(Paddle player){
	if (this.intersects(player)) {
            this.xVelo = this.xVelo * -1;
        }
    }

    public int getYVelo() {
	return yVelo;
    }

    public int getXVelo() {
	return xVelo;
    }

    public void setXVelo(int randXVelo) {
	xVelo = randXVelo;
    }

    public void setYVelo(int randYVelo) {
	yVelo = randYVelo;
    }

}
