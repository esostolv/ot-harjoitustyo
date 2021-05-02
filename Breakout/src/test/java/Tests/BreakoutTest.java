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
        assertEquals(pad.getSize(), 50);
    }
    
    @Test
    public void heightOfWallIsCorrect() {
        Wall wall = new Wall(0, 0, 20, 50);
        assertEquals(wall.getHeight(), 20);
    }
    
    @Test
    public void widthOfWallIsCorrect() {
        Wall wall = new Wall(0, 0, 20, 50);
        assertEquals(wall.getWidth(), 50);
    }
    
    @Test
    public void radiusOfBallIsCorrect() {
        Ball ball = new Ball();
        assertEquals(ball.getRadius(), 5);
    }
    
  

}
