import java.util.*;
import java.awt.*;


public class Ball extends Rectangle{
    
    int initV = 2; //Initial velocity
	Random rand; //Random number
	int xV; //Initial X velocity
	int yV; //Initial Y velocity
	
	Ball(int x, int y, int width, int height){ //ball constructor
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
	
	public void drawBall(Graphics g) { //Draws ball
        g.fillOval(x, y, height, width);
		g.setColor(Color.white);
	}

    public void update() {
		x += xV;
		y += yV;
	}

	public void setXV(int randXV) { //Sets x velocity of ball
		xV = randXV;
	}
	public void setYV(int randYV) { //Sets y velocity of ball
		yV = randYV;
	}


}