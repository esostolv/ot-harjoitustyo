/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.breakout;

import javafx.scene.shape.Rectangle;

/**
 *
 * @author Oskari
 */
public class Pad {
    private Rectangle pad;
    public Pad() {
        createPad();
    }
    
    public void createPad() {
        this.pad = new Rectangle();
        pad.setX(275);
        pad.setY(395);
        pad.setHeight(10);
        pad.setWidth(50);
    }
    
    public Rectangle getPad() {
        return pad;
    }
}
