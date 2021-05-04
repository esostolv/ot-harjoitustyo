/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests;

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
public class WallTest {
    
    public WallTest() {
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
}
