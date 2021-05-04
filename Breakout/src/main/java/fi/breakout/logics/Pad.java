/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.breakout.logics;

import javafx.animation.TranslateTransition;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyEvent;
import javafx.util.Duration;
/**
 * Alustaa kuvaava luokka
 * @author Oskari
 */
public class Pad {
    private Rectangle pad;
    private Point2D moving;
    
    public Pad() {
        createPad();
    }
    /**
     * Metodi luo uuden alustan ja asettaa sen sijainnin ja koon 
     */
    public void createPad() {
        this.pad = new Rectangle();
        pad.setX(270);
        pad.setY(390);
        pad.setHeight(10);
        pad.setWidth(60);
        pad.setFill(Color.GREEN);
    }
   
    /**
     * Metodi palauttaa alustan.
     * @return alusta
     */
    public Rectangle getPad() {
        return pad;
    }
    /**
     * Metodi palauttaa alustan x-koordinaatin muutoksen alkuperäiseen nähden.
     * @return x-koordinaatin muutos
     */
    public double getX() {
        return pad.getTranslateX();
    }
    
    /**
     * Metodi palauttaa alustan leveyden
     * @return alustan leveys
     */
    public double getSize() {
        return pad.getWidth();
    }
    
    /**
     * Metodi liikuttaa alustaa vaakatasossa ja estää sitä ajautumasta ruudun ulkopuolelle. 
     * @param direction Määrittää alustan liikkeen suunnan
     * 
     */
    public void move(int direction) {
        pad.setTranslateX(pad.getTranslateX() + direction * 4);
        if (pad.getTranslateX() < -270) {
            pad.setTranslateX(-270);
        } 
        if (pad.getTranslateX() > 270) {
            pad.setTranslateX(270);
        }
    }
}
    