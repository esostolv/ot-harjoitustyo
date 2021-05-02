package Tests;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import fi.breakout.gui.Ui;
import fi.breakout.logics.Ball;
import fi.breakout.logics.Breakout;
import fi.breakout.logics.Pad;
import fi.breakout.logics.Wall;
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
public class BreakoutTest {
    
   
    
    @Test
    public void sizeOfPadIsCorrect() {
        Pad pad = new Pad();
        assertEquals(60, pad.getSize(), 0.1);
    }
    
    @Test
    public void heightOfWallIsCorrect() {
        Wall wall = new Wall(0, 0, 20, 50);
        assertEquals(20, wall.getHeight());
    }
    
    @Test
    public void widthOfWallIsCorrect() {
        Wall wall = new Wall(0, 0, 20, 50);
        assertEquals(50, wall.getWidth());
    }
    
    @Test
    public void radiusOfBallIsCorrect() {
        Ball ball = new Ball();
        assertEquals(5, ball.getRadius());
    }
    
    @Test
    public void locationOfBallIsCorrect() {
        Ball ball = new Ball();
        assertEquals(385, ball.getY(), 0.1);
    }
  

}
