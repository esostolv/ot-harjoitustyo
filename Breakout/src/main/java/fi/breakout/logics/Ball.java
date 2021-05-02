
package fi.breakout.logics;

import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;

/**
 * Tämä metodi luo pallon ja asettaa sen sijainnin. 
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
        ball.setCenterY(385);
        ball.setRadius(5.0);
        ball.setFill(Color.GREEN);
    }
    
    public double getY() {
        return ball.getCenterY();
    }
    
    public Circle getBall() {
        return ball;
    }
    
    public int getRadius() {
        return 5;
    }
}
