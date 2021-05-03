/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.breakout.logics;

import java.util.HashMap;
import java.util.Map;
import javafx.animation.AnimationTimer;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;

/**
 *
 * @author Oskari
 */
public class Breakout {
    private Ball ball;
    private Pad pad;
    private Timeline timeline;
    
    public Breakout() {
        this.ball = ball;
        this.pad = pad;
    }
    public Scene play() {
        Pane board = new Pane();
        board.setPrefSize(600, 400);
        
        Ball ball = new Ball();
        board.getChildren().add(ball.getBall());
        Pad pad = new Pad();
        board.getChildren().add(pad.getPad());
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                board.getChildren().add(new Wall(i * 50, j * 20, 20, 50).getWall());
            }
        }
        
        Scene game = new Scene(board);
        Map<KeyCode, Boolean> pressedButtons = new HashMap<>();
        game.setOnKeyPressed(event -> {
            pressedButtons.put(event.getCode(), Boolean.TRUE);
        });
        game.setOnKeyReleased(event-> {
            pressedButtons.put(event.getCode(), Boolean.FALSE);
        });
        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (pressedButtons.getOrDefault(KeyCode.LEFT, false)) {
                    pad.move(-1);
                }
                if (pressedButtons.getOrDefault(KeyCode.RIGHT, false)) {
                    pad.move(1);
                }
                ball.move(1, -1);
            }
        }.start();
        return game;
        
    }
    
    public void round() {
        //ball.move();
        //pad.move();
        
    }
    /**
     * Tarkistaa, onko pallo pudonnut alustan alapuolelle.
     * @return true, jos pallon keskipiste on alempana kuin alusta
     *         false, jos pallon keskipiste on alustan tasolla tai korkeammalla. 
     */
    
    public boolean fall() {
        if ((ball.getY()) < 12.5) {
            return true;
        }
        return false; 
    }
}
