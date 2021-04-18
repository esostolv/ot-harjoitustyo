/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.esostolv.logics;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Oskari
 */
public class Wall {
    private boolean broken;
    private Rectangle wall;
    
    public Wall(int x, int y) {
        createWall(x, y);
    }
    
    public void createWall(int x, int y) {
        this.wall = new Rectangle();
        wall.setX(x);
        wall.setY(y);
        wall.setHeight(20);
        wall.setWidth(50);
    }
    
    public Rectangle getWall() {
        return wall;
    }
}
