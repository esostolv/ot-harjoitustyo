/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logics.test;

import fi.breakout.logics.Pad;
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
public class PadTest {
    
    @Test
    public void padMovesToLeft() {
        Pad pad = new Pad();
        pad.move(-1);
        assertEquals(-4, pad.getX(), 0.1);
    }
    
    @Test
    public void padMovesToRight() {
        Pad pad = new Pad();
        pad.move(1);
        assertEquals(4, pad.getX(), 0.1);
    }
    
    @Test
    public void padDoesntGoOutsideLeft() {
        Pad pad = new Pad();
        for (int i = 0; i < 70; i++) {
            pad.move(-1);
        }
        assertEquals(-270, pad.getX(), 0.1);
    }
    
    @Test
    public void padDoesntGoOutsideRight() {
        Pad pad = new Pad();
        for (int i = 0; i < 70; i++) {
            pad.move(1);
        }
        assertEquals(270, pad.getX(), 0.1);
    }
    
    @Test
    public void sizeOfPadIsCorrect() {
        Pad pad = new Pad();
        assertEquals(60, pad.getSize(), 0.1);
    }
}