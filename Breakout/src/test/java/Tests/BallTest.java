/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import fi.breakout.logics.Ball;
import fi.breakout.logics.Breakout;
import javafx.scene.layout.Pane;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Oskari
 */
public class BallTest {
    
    @Test
    public void locationOfBallIsCorrect() {
        Ball ball = new Ball();
        assertEquals(0, ball.getY(), 0.1);
    }
    
    @Test
    public void ballMovesCorrect() {
        Breakout breakout = new Breakout(new Pane());
        Ball ball = new Ball();
        for (int i = 0; i < 10; i++) {
            ball.move(breakout, 1, -1);
        }
        assertEquals(10, ball.getX(), 0.1);
        assertEquals(-10, ball.getY(), 0.1);
    }
    
    @Test 
    public void ballDoesntGoOutsideRight() {
        Breakout breakout = new Breakout(new Pane());
        Ball ball = new Ball();
        for (int i = 0; i < 305; i++) {
            ball.move(breakout, 1, 0);
        }
        assertEquals(300, ball.getX(), 0.1);
        assertEquals(0, ball.getY(), 0.1);
    }
    
    @Test 
    public void ballDoesntGoOutsideLeft() {
        Breakout breakout = new Breakout(new Pane());
        Ball ball = new Ball();
        for (int i = 0; i < 305; i++) {
            ball.move(breakout, -1, 0);
        }
        assertEquals(-300, ball.getX(), 0.1);
        assertEquals(0, ball.getY(), 0.1);
    }
    
    @Test 
    public void ballDoesntGoOutsideUp() {
        Breakout breakout = new Breakout(new Pane());
        for (int i = 0; i < 3; i++) {
            breakout.getWall()[6][i].setToFalse();
            breakout.getWall()[5][i].setToFalse();
        }
        Ball ball = new Ball();
        for (int i = 0; i < 79; i++) {
            ball.move(breakout, 0, -5);
        }
        assertEquals(0, ball.getX(), 0.1);
        assertEquals(-385, ball.getY(), 0.1);
    }

}
