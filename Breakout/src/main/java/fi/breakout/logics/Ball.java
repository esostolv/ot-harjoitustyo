/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.esostolv.logics;

import javafx.scene.shape.Circle;

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
        ball.setCenterX(300.0);
        ball.setCenterY(392.5);
        ball.setRadius(5.0);
    }
    
    public Circle getBall() {
        return ball;
    }
}
