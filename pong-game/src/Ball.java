import java.util.*;
import java.awt.*;


public class Ball extends Rectangle{
    
    int initV = 2; //Initial velocity
	Random rand; //Random number
	int Vx; //Initial X velocity
	int Vy; //Initial Y velocity
	
	Ball(int x, int y, int width, int height){ //ball constructor
		super(x,y,width,height); 
		rand = new Random();
		int randVx = rand.nextInt(2);
        int randVy = rand.nextInt(2);

		if(randVx == 0){
            randVx--;
        }
		
		if(randVy == 0){
            randVy--;
        }

        setVx(randVx*initV);
		setVy(randVy*initV);
		
	}
	
	public void drawBall(Graphics g) { //Draws ball
        g.fillOval(x, y, height, width);
		g.setColor(Color.white);
	}

    public void move() {
		x += Vx;
		y += Vy;
	}

	public void setVx(int randVx) { //Sets x velocity of ball
		Vx = randVx;
	}
	public void setVy(int randVy) { //Sets y velocity of ball
		Vy = randVy;
	}


}