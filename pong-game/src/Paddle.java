import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle{

	int side;
	int move_distance = 10;
	
	Paddle(int x, int y, int width, int height, int side){
		super(x, y, width, height);
		this.side = side;
	}
	
	public void press(KeyEvent e) {
        if(this.side == 1){
            if(e.getKeyChar() == 'w') {
				moveUp();
			}
			if(e.getKeyChar() == 's') {
				moveDown();
			}
            break;
        }
        else{
            if(e.getKeyCode() == KeyEvent.VK_UP) {
				moveUp();
			}
			if(e.getKeyCode() == KeyEvent.VK_DOWN) {
				moveDown();
			}
            break;
        }
	}
    
	public void moveUp() {
		this.y = this.y + this.move_distance;
	}
    public void moveDown(){
        this.y = this.y - this.move_distance;
    }
}