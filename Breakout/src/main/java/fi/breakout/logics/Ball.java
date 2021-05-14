
package fi.breakout.logics;

import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.animation.TranslateTransition; 
import javafx.util.Duration;

/**
 * Palloa kuvaava luokka 
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
     * Metodi luo uuden pallon ja alustaa sen sijainnin ja koon
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
     * Metodi palauttaa pallon keskipisteen y-koordinaatin muutoksen alkuperäiseen nähden.
     * @return pallon y-koordinaatin muutos
     */
    public double getY() {
        return ball.getTranslateY();
    }
    
    /**
     * Metodi palauttaa pallon keskipisteen x-koordinaatin muutoksen alkuperäiseen nähden.
     * @return pallon x-koordinaatin muutos
     */
    public double getX() {
        return ball.getTranslateX();
    }
    /**
     * Metodi palauttaa pallon.
     * @return ball pallo 
     */
    public Circle getBall() {
        return ball;
    }
    
    /**
     * Metodi palauttaa pallon säteen
     * @return pallon säde
     */
    public int getRadius() {
        return 5;
    }
    
    /**
     * Metodi liikuttaa palloa annettujen parametrien mukaiseen suuntaan
     * @param dirX x-suunta
     * @param dirY y-suunta
     */
    public void move(Breakout breakout, int dirX, int dirY) {
        this.ball.setTranslateX(this.ball.getTranslateX() + dirX);
        this.ball.setTranslateY(this.ball.getTranslateY() + dirY);
        if (ball.getTranslateX() > 300) {
            this.ball.setTranslateX(this.ball.getTranslateX() - dirX);
            breakout.setxDir(-1);
        }
        if (ball.getTranslateX() < -300) {
            this.ball.setTranslateX(this.ball.getTranslateX() - dirX);
            breakout.setxDir(1);
        }
        if (ball.getTranslateY() < -385) {
            this.ball.setTranslateY(this.ball.getTranslateY() - dirY);
            breakout.setyDir(1);
        }
    }
    
    
    
    
}
