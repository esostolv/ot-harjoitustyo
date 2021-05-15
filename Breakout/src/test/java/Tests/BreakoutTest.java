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
public class BreakoutTest {
      
    @Test
    public void fallReturnsFalseWhenBallHitsPadRight() {
        Breakout breakout = new Breakout(new Pane());
        for (int i = 0; i < 6; i++) {
            breakout.getBall().move(breakout, 1, 1);
        }
        assertFalse(breakout.fall());
    }
    
    @Test 
    public void fallReturnsFalseWhenBallHitsPadLeft() {
        Breakout breakout = new Breakout(new Pane());
        breakout.getBall().move(breakout, -5, 0);
        for (int i = 0; i < 6; i++) {
            breakout.getBall().move(breakout, 0, -1);
        }
        for (int i = 0; i < 15; i++) {
            breakout.getBall().move(breakout, 0, 1);
        }
        assertFalse(breakout.fall());
    }
    
    @Test
    public void fallReturnsFalseWhenBallOnAir() {
        Breakout breakout = new Breakout(new Pane());
        breakout.getBall().move(breakout, -2, 0);
        for (int i = 0; i < 6; i++) {
            breakout.getBall().move(breakout, 0, -1);
        }
        assertFalse(breakout.fall());
    }
    
    @Test
    public void fallReturnsTrueWhenBallFallsTooLow() {
        Breakout breakout = new Breakout(new Pane());
        for (int i = 0; i < 15; i++) {
            breakout.getBall().move(breakout, 2, -1);
        }
        for (int i = 0; i < 40; i++) {
            breakout.getBall().move(breakout, 0, 1);
        }
        assertTrue(breakout.fall());
    }
    @Test
    public void collisionHappensOnRow2() {
        Breakout breakout = new Breakout(new Pane());
        breakout.getBall().move(breakout, 3, 0);
        breakout.getBall().move(breakout, 0, -326);
        breakout.checkCollision(new Pane());
        assertFalse(breakout.getWall()[6][2].getStatus());
    }
    
    @Test
    public void collisionHappensOnRow1() {
        Breakout breakout = new Breakout(new Pane());
        breakout.getWall()[6][2].setToFalse();
        breakout.getBall().move(breakout, 3, 0);
        breakout.getBall().move(breakout, 0, -346);
        breakout.checkCollision(new Pane());
        assertFalse(breakout.getWall()[6][1].getStatus());
    }
    
    @Test
    public void collisionHappensOnRow0() {
        Breakout breakout = new Breakout(new Pane());
        breakout.getWall()[6][2].setToFalse();
        breakout.getWall()[6][1].setToFalse();
        breakout.getBall().move(breakout, 3, 0);
        breakout.getBall().move(breakout, 0, -366);
        breakout.checkCollision(new Pane());
        assertFalse(breakout.getWall()[6][0].getStatus());
    }
    
    @Test
    public void noCollisionWhenBallDoesntHitABrick() {
        Breakout breakout = new Breakout(new Pane());
        breakout.getBall().move(breakout, 3, 0);
        breakout.checkCollision(new Pane());
        assertTrue(breakout.getWall()[7][2].getStatus());
    }
}
