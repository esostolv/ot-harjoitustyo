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
    private Wall[][] wall;
    private int xDir;
    private int yDir;
    private int broken;
    
    /**
     * Metodi alustaa uuden pelin ja luo pallon ja alustan.
     */
    public Breakout(Pane pane) {
        this.ball = new Ball();
        this.pad = new Pad();
        this.xDir = 1;
        this.yDir = -1;
        this.wall = new Wall[12][3];
        createWall(pane);
        this.broken = 0;
        
    }
    /**
     * Metodi asettaa pallon vaakasuuntaisen kulkusuunnan
     * @param x vaakasuuntainen kulkusuunta: -1 vasen, 1 oikea
     */
    public void setxDir(int x) {
        this.xDir = x;
    }
    
    /**
     * Metodi asettaa pallon pystysuuntaisen kulkusuunnan
     * @param x vaakasuuntainen kulkusuunta: -1 ylös, 1 alas
     */
    public void setyDir(int y) {
        this.yDir = y;
    }
    
    /**
     * Palauttaa pallon vaakasuuntaisen kulkusuunnan
     * @return this.xDir pallon vaakasuuntainen kulkusuunta
     */
    public int getxDir() {
        return this.xDir;
    }
    
    /**
     * Palauttaa pallon pystysuuntaisen kulkusuunnan
     * @return this.xDir pallon pystysuuntainen kulkusuunta
     */
    public int getyDir() {
        return this.yDir;
    }
    
    /**
     * Palauttaa pallon
     * @return this.ball pallo
     */
    public Ball getBall() {
        return this.ball;
    }
    
    /**
     * Palauttaa alustan
     * @return this.pad alusta
     */
    public Pad getPad() {
        return this.pad;
    }
    
    /**
     * Metodi luo uuden 12*3-kokoisen seinän ja luo listan seinän tiilten tilasta.
     */
    public void createWall(Pane pane) {
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                this.wall[i][j] = new Wall(i * 50, j * 20, 20, 50);
                pane.getChildren().add(this.wall[i][j].getWall());
                //pane.getChildren().remove(this.wall[i][j].getWall());
                //pane.getChildren().clear();
            }
        }
    }
    
    /**
     * Tarkistaa, onko pallo pudonnut alustan alapuolelle.
     * @return true, jos pallon keskipiste on alempana kuin alusta
     *         false, jos pallon keskipiste on alustan tasolla tai korkeammalla. 
     */
    
    public boolean fall() {
        if (ball.getY() > 5) {
            if (ball.getX() < pad.getX() + 30 && ball.getX() > pad.getX() - 30) {
                if (ball.getX() >= pad.getX()) {
                    setxDir(1);
                    setyDir(-1);
                    return false; 
                }
                setxDir(-1);
                setyDir(-1);
                return false; 
            }
            return true;
        } else {
            return false;
        }
    }
    /**
     * Metodi laskee ensin, kuinka monennen tiilen kohdalla pallo on vaakasuunnassa ja 
     * tarkistaa sen jälkeen, osuuko pallo tiileen. Jos pallo osuu ehjään tiileen, tiili
     * poistetaan ruudulta, merkitään hajonneeksi ja pallo lähtee alaspäin. 
     * @param pane Pane-olio, jolta tiili mahdollisesti poistetaan. 
     */    
    public void checkCollision(Pane pane) {
        if (ball.getY() < -325) {
            int x = (int) ball.getX() + 300;
            int i = (x - (x % 50)) / 50;
            if (i == 12) {
                i = 11;
            }
            for (int j = 2; j >= 0; j--) {
                if (ball.getY() - 5 >= -385 + j * 20 && ball.getY() - 5 < -365 + j * 20 
                        && this.wall[i][j].getStatus() == true) {
                    pane.getChildren().remove(this.wall[i][j].getWall());
                    this.wall[i][j].setToFalse();
                    setyDir(1);
                    broken += 1;
                }
            }
        }
    }
    
    /**
     * Palauttaa listan tiilistä
     * @return this.wall lista tiilistä
     */
    public Wall[][] getWall() {
        return this.wall;
    }
    
    /**
     * Palauttaa tiedon, kuinka moni tiili on rikottu
     * @return this.broken rikottujen tiilten määrä 
     */
    public int getBroken() {
        return this.broken;
    }
    
}

    
