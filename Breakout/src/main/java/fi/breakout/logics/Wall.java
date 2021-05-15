/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.breakout.logics;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
/**
 * Tiiliä kuvaava luokka
 * @author Oskari
 */
public class Wall {
    private boolean[] listOfBricks;
    private Rectangle wall;
    private int height;
    private int width;
    private boolean status;

    /**
     * Konstruktori luo uuden tiilen
     * @param x tiilen x-koordinaatti
     * @param y tiilen y-koordinaatti
     * @param h tiilen korkeus
     * @param w tiilen leveys
     */
    public Wall(int x, int y, int h, int w) {
        createBrick(x, y, h, w);
        this.height = h;
        this.width = w;
        this.status = true;
    }
    
    /**
     * metodi luo uuden tiilen
     * @param x tiilen x-koordinaatti
     * @param y tiilen y-koordinaatti
     * @param h tiilen korkeus
     * @param w tiilen leveys
     */
    public void createBrick(int x, int y, int h, int w) {
        this.wall = new Rectangle();
        wall.setX(x);
        wall.setY(y);
        wall.setHeight(h);
        wall.setWidth(w);
        wall.setFill(Color.BLUE);
        wall.setStroke(Color.WHITE);
    }
    
    /**
     * palauttaa tiedon, onko tiili ehjä vai hajotettu
     * @return this.status tieto tiilen tilasta: true = ehjä, false = hajotettu
     */
    public boolean getStatus() {
        return this.status;
    }
    
    /**
     * Merkitsee tiilen hajotetuksi, eli asettaa tilaksi false.
     */
    public void setToFalse() {
        this.status = false;
    }
    
    /**
     * palauttaa seinäolion
     * @return wall seinäolio
     */
    public Rectangle getWall() {
        return wall;
    }
    
    

}
