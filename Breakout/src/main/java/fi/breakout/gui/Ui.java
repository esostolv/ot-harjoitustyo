/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.breakout.gui;

import fi.breakout.logics.Ball;
import fi.breakout.logics.Breakout;
import fi.breakout.logics.Pad;
import fi.breakout.logics.Wall;
import java.util.HashMap;
import java.util.Map;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Käyttöliittymää kuvaava luokka  
 */
public class Ui extends Application {
    private Breakout breakout;
    /**
     * Metodi luo uuden käyttöliittymän ja avaa valikon.
     * @param window luo uuden stagen
     * @throws Exception 
     */

    @Override
    public void start(Stage window) throws Exception {
        Scene menu = menu(window);
        this.breakout = new Breakout();
        window.setTitle("BREAKOUT");
        window.setScene(menu);
        window.show();
    }
    
    /**
     * Metodi luo scenen, jossa peli pelataan. Metodi piirtää ruudulle pelin tapahtumat. 
     * 
     * @return game scene, jossa peli tapahtuu
     */
    public Scene play() {
        Pane board = new Pane();
        board.setPrefSize(600, 400);
        Breakout breakout = new Breakout();
        board.getChildren().add(breakout.getBall().getBall());
        board.getChildren().add(breakout.getPad().getPad());
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
                    breakout.getPad().move(-1);
                }
                if (pressedButtons.getOrDefault(KeyCode.RIGHT, false)) {
                    breakout.getPad().move(1);
                }
                breakout.getBall().move(breakout, breakout.getxDir(), breakout.getyDir());
                if (breakout.fall() == true) {
                    stop();
                }
            }
        }.start();
        return game;
    }
    /**
     * Metodi luo uuden valikon. 
     * 
     * @param window  luo uuden stagen. 
     * @return scene  uusi valikko
     */
    public Scene menu(Stage window) {
        Label title = new Label("BREAKOUT");
        Button newGame = new Button("Uusi peli");
        Button stats = new Button("Tilastot");
        Button instructions = new Button("Ohjeet");
        Button stop = new Button("Lopeta");
        GridPane menu = new GridPane();
        
        menu.add(title, 0, 0);
        menu.add(newGame, 0, 1);
        menu.add(stats, 0, 2);
        menu.add(instructions, 0, 3);
        menu.add(stop, 0, 4);
        menu.setPrefSize(600, 400);
        menu.setAlignment(Pos.CENTER);
        newGame.setOnAction((event) -> window.setScene(play()));
        stop.setOnAction((event) -> System.exit(0));
        Scene scene = new Scene(menu);
        return scene;
    }
    

    /**
     * Metodi käynnistää käyttöliittymän
     */
    
    public void launch() {
        launch(Ui.class);
    }
}
