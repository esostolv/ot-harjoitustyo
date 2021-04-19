/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.breakout.logics;
import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Color;
/**
 *
 * @author Oskari
 */
public class Wall {
    private boolean broken;
    private Rectangle wall;
    private int height;
    private int width;

    
    public Wall(int x, int y, int h, int w) {
        createWall(x, y, h, w);
        this.height = h;
        this.width = w;
    }
    
    public void createWall(int x, int y, int h, int w) {
        this.wall = new Rectangle();
        wall.setX(x);
        wall.setY(y);
        wall.setHeight(h);
        wall.setWidth(w);
        wall.setFill(Color.BLUE);
        wall.setStroke(Color.WHITE);
    }
    
    public Rectangle getWall() {
        return wall;
    }
    
    public int getHeight() {
        return height;
    }
    
    public int getWidth() {
        return width;
    }

}
