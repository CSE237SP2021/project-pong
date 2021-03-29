package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import app.Paddle;

public class PaddleTest {

    @Test
    // check to see that the y value of paddle properly updates
    public void testUpdate() {
        Paddle p = new Paddle(0, 0, 5, 5, 1);
        p.setYV(10);
        int expectedUpdate = 10;
        p.update();
        assertEquals(expectedUpdate, p.y);
    }    
}
