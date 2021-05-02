/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.breakout.logics;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.geometry.Point2D;
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
        pad.setTranslateX(275);
        pad.setTranslateY(395);
        pad.setHeight(10);
        pad.setWidth(50);
        pad.setFill(Color.GREEN);
        this.moving = new Point2D(0, 0);
    }
    
    public Rectangle getPad() {
        return pad;
    }
    
    public int getSize() {
        return 50;
    }
    
    public void move() {
        this.pad.setTranslateX(this.pad.getTranslateX());
    }
    
    
}
    