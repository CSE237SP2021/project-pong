package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import app.Game;
import app.Ball;
import app.Paddle;
import app.Score;

public class GameTest {

    @Test
    // check to see if ball were to go below or equal to zero that it would change velocity to bounce
    public void testBallCollisionTop() {
        Game g = new Game();
        Ball b = g.getBall();
        b.y = -15;
        b.setYV(10);
        g.collisions();
        int expectedYV = -10;
        assertEquals(expectedYV, b.getYV());
    }

    @Test
    // test to see if the ball collides with paddle
    public void testBallCollisionPaddle() {
        Game g = new Game();
        Ball b = g.getBall();
        Paddle p1 = g.getPlayer1();
        b.x = 10;
        b.y = 10;
        p1.x = 10;
        p1.y = 10;
        b.setXV(-5);
        g.collisions();
        int expectedXV = 5;
        assertEquals(expectedXV, b.getXV());
    }

    @Test
    // Test to see if paddle will collide at the edge of the screen.
    public void testPaddleCollision() {
        Game g = new Game();
        Paddle p1 = g.getPlayer1();
        p1.y = -5;
        g.collisions();
        int expectedY = 0;
        assertEquals(expectedY, p1.y);
    }

    @Test
    
    public void testScoring() {

        Game g = new Game();
        Ball b = g.getBall();
        Score score = new Score(850, 600);
        b.x = -1;
        g.scoring();
        int expectedValue = score.getScoreTwo();
        assertEquals(expectedValue, 1);
        
    }
}
