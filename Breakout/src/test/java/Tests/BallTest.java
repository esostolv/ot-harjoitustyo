/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

import fi.breakout.logics.Ball;
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
    public void radiusOfBallIsCorrect() {
        Ball ball = new Ball();
        assertEquals(5, ball.getRadius());
    }
    
    @Test
    public void locationOfBallIsCorrect() {
        Ball ball = new Ball();
        assertEquals(0, ball.getY(), 0.1);
    }
    
    @Test
    public void ballMovesCorrect() {
        
    }
}
