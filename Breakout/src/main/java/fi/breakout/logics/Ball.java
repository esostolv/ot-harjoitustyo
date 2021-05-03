
package fi.breakout.logics;

import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.animation.TranslateTransition; 
import javafx.util.Duration;

/**
 * This class creates a ball and sets its location. 
 * @author Oskari
 */
public class Ball {
    private Circle ball;
    private int dx;
    private int dy;
    
    public Ball() {
        createBall();
    }
    
    /**
     * The method creates a new ball and sets its center point and radius.
     */
    public void createBall() {
        this.ball = new Circle();
        ball.setCenterX(300.0);
        ball.setCenterY(385);
        ball.setRadius(5.0);
        ball.setFill(Color.GREEN);
        this.dx = 1;
        this.dy = 1;
    }
    
    /**
     * The metod returns the y-coordinate of the center of the ball.
     * @return the y-coordinate of the center of the ball
     */
    public double getY() {
        return ball.getCenterY();
    }
    
    /**
     * The method returns the ball object.
     * @return ball object 
     */
    public Circle getBall() {
        return ball;
    }
    
    /**
     * The method returns the radius of the ball.
     * @return the radius of the ball.
     */
    public int getRadius() {
        return 5;
    }
    
    public void move(int dirX, int dirY) {
        this.ball.setTranslateX(ball.getTranslateX() + dirX);
        this.ball.setTranslateY(ball.getTranslateY() + dirY);
        if (ball.getTranslateX() > 270) {
            this.ball.setTranslateX(ball.getTranslateX() - dirX);
        }
        if (ball.getTranslateX() < 270) {
            this.ball.setTranslateX(ball.getTranslateX() + dirX);
        }
    }
    
    
}
