/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.breakout.logics;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyEvent;
/**
 *
 * @author Oskari
 */
public class Pad {
    private Rectangle pad;
    private Point2D moving;
    
    public Pad() {
        createPad();
    }
    
    public void createPad() {
        this.pad = new Rectangle();
        pad.setX(270);
        pad.setY(390);
        pad.setHeight(10);
        pad.setWidth(60);
        pad.setFill(Color.GREEN);
        this.moving = new Point2D(0, 0);
    }
   
    public Rectangle getPad() {
        return pad;
    }
    
    public double getSize() {
        return pad.getWidth();
    }
    
    public void move() {
        if (pad.getX() <= 25) {
            pad.setX(25);
        }
        if (pad.getX() >= 575) {
            pad.setX(375);
        }
        
    }
    
    
    
}
    