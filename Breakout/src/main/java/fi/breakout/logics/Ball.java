/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.breakout.logics;

import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

/**
 *
 * @author Oskari
 */
public class Ball {
    private Circle ball;
    public Ball() {
        createBall();
    }
    
    public void createBall() {
        this.ball = new Circle();
        ball.setTranslateX(300.0);
        ball.setTranslateY(392.5);
        ball.setRadius(5.0);
        ball.setFill(Color.GREEN);
    }
    
    public Circle getBall() {
        return ball;
    }
    
    public int getRadius() {
        return 5;
    }
}
