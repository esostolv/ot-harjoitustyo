/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.breakout.logics;

import java.util.HashMap;
import java.util.Map;
import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

/**
 * Pelin mekaniikkaa ja tapahtumia kuvaava luokka
 * @author Oskari
 */
public class Breakout {
    private Ball ball;
    private Pad pad;
    private Timeline timeline;
    private boolean[][] wall;
    
    /**
     * Metodi alustaa uuden pelin ja luo pallon ja alustan.
     */
    public Breakout() {
        this.ball = new Ball();
        this.pad = new Pad();
    }
    
    public Ball getBall() {
        return this.ball;
    }
    
    public Pad getPad() {
        return this.pad;
    }
    
    /**
     * Metodi luo uuden 12*3-kokoisen seinän ja luo listan seinän tiilten tilasta.
     */
    public void createWall() {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                this.wall[i][j] = true;
            }
        }
    }
    
    /**
     * Metodi muuttaa tiilten kirjanpidossa valitun tiilen hajotetuksi.
     * @param i tiilen x-koordinaatti
     * @param j tiilen y-koordinaatti
     */
    public void removeBrick(int i, int j) {
        this.wall[i][j] = false; 
    }
    
    /**
     * Tarkistaa, onko pallo pudonnut alustan alapuolelle.
     * @return true, jos pallon keskipiste on alempana kuin alusta
     *         false, jos pallon keskipiste on alustan tasolla tai korkeammalla. 
     */
    
    public boolean fall() {
        if (ball.getY() > 5) {
            return true;
        } else {
            return false;
        }
    }
    
    /**
     * Metodi palauttaa tiedon, onko kysytty tiili hajonnut. 
     * @param i tiilen x-koordinaatti
     * @param j tiilen y-koordinaatti
     * @return 
     */
    public boolean getStatus(int i, int j) {
        return wall[i][j];
    }
    
}

    
