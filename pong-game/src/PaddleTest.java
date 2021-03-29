import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PaddleTest {

    @Test
    // check to see that the y value of paddle properly updates
    public void testUpdate() {
        Paddle p = new Paddle(0, 0, 5, 5, 1);
        p.yV = 10;
        int expectedUpdate = 10;
        p.update();
        assertEquals(expectedUpdate, p.y);
    }    
}
