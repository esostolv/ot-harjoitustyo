/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.breakout.logics;

/**
 *
 * @author Oskari
 */
public class Breakout {
    private Ball ball;
    private Pad pad;
    
    public Breakout(Ball ball, Pad Pad) {
        this.ball = ball;
        this.pad = pad;
    }
    
    public void round() {
        //ball.move();
        //pad.move();
        
    }
    /**
     * Tarkistaa, onko pallo pudonnut alustan alapuolelle.
     * @return true, jos pallon keskipiste on alempana kuin alusta
     *         false, jos pallon keskipiste on alustan tasolla tai korkeammalla. 
     */
    
    public boolean fall() {
        if ((ball.getY()) < 12.5) {
            return true;
        }
        return false; 
    }
}
