import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle{

	int side;
	int yV;
	int deltaY = 10;
	
	Paddle(int x, int y, int width, int height, int side){
		super(x, y, width, height);
		this.side = side;
	}
	
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

	public void update() {
		y += yV;
	}

	public void drawPaddle(Graphics g) {
		g.setColor(Color.white);
		g.fillRect(x, y, width, height);
	}
}