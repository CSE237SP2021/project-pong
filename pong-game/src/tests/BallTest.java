package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import app.Ball;

public class BallTest {

    @Test
    // check to see if the ball coordinate is updated correctly
    public void testUpdate() {
        Ball b = new Ball(0, 0, 0 ,0);
        b.setYV(10);
        b.move();
        int expectedY = 10;
        assertEquals(expectedY, b.y);
    }
    
    @Test
    // test to see if the next x velocity is set correctly
    public void testSetXV(){
        Ball b = new Ball(0, 0, 0 ,0);
        b.setXV(7);
        int expectedXV = 7;
        assertEquals(expectedXV, b.getXV());
    }

    @Test
    // test to see if the next y velocity is set correctly
    
    public void testSetYV(){
        Ball b = new Ball(0, 0, 0 ,0);
        b.setYV(12);
        int expectedYV = 12;
        assertEquals(expectedYV, b.getYV());
    }
}
