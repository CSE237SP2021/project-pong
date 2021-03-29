import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class GameTest {

    @Test
    // check to see if ball were to go below or equal to zero that it would change velocity to bounce
    public void testBallCollisionTop() {
        Game g = new Game();
        g.ball.y = -15;
        g.ball.yV = 10;
        g.collisions();
        int expectedYV = -10;
        assertEquals(expectedYV, g.ball.yV);
    }

    @Test
    // test to see if the ball collides with paddle
    public void testBallCollisionPaddle() {
        Game g = new Game();
        g.ball.x = 10;
        g.player1.x = 10;
        g.ball.xV = -5;
        g.collisions();
        int expectedXV = 5;
        assertEquals(expectedXV, g.ball.xV);
    }

    @Test
    // Test to see if paddle will collide at the edge of the screen.
    public void testPaddleCollision() {
        Game g = new Game();
        g.player1.y = -5;
        g.collisions();
        int expectedY = 0;
        assertEquals(expectedY, g.player1.y);
    }
}
