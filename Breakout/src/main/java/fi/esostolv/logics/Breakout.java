/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.esostolv.logics;

/**
 *
 * @author Oskari
 */
public class Breakout {
    public Breakout() {
        startGame();
    }
    
    public void startGame() {
        Screen s = new Screen();
        s.launch();
        
        
    }
}
