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
 * The class creates a new pad and sets its location.
 * @author Oskari
 */
public class Pad {
    private Rectangle pad;
    private Point2D moving;
    
    public Pad() {
        createPad();
    }
    /**
     * The method creates a new pad: creates a rectangle, sets its size and location and
     * sets its colour to green. 
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
     * The method returns the pad object.
     * @return 
     */
    public Rectangle getPad() {
        return pad;
    }
    
    public double getX() {
        return pad.getTranslateX();
    }
    
    /**
     * The method returns the width of the pad.
     * @return 
     */
    public double getSize() {
        return pad.getWidth();
    }
    
    /**
     * The method moves pad horizontally.
     * @param direction determines the direction of pad (+1 direction right, -1 direction left)
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
    