/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.breakout.gui;

import fi.breakout.database.Statistics;
import fi.breakout.logics.Ball;
import fi.breakout.logics.Breakout;
import fi.breakout.logics.Pad;
import fi.breakout.logics.Wall;
import java.io.File;
import java.io.FileInputStream;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.AnimationTimer;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Käyttöliittymää kuvaava luokka  
 */
public class Ui extends Application {
    private Breakout breakout;
    public Pane board;
    private Statistics stats;
    /**
     * Metodi luo uuden käyttöliittymän ja avaa valikon.
     * @param window luo uuden stagen
     * @throws Exception 
     */
    
 
    

    @Override
    public void start(Stage window) throws Exception {
        stats.createDatabase();
        Scene menu = menu(window);
        window.setTitle("BREAKOUT");
        window.setScene(menu);
        window.show();
    }
    
    /**
     * Metodi luo scenen, joka näytetään pelin päättymisen jälkeen. Sceneen ilmestyy
     * valikko, josta käyttäjä voi aloittaa uuden pelin, tallettaa tuloksensa tai palata
     * päävalikkoon.
     * @param window luo uuden stagen
     * @param result tieto, voittiko käyttäjä edellisen pelin
     * @return scene uusi valikko 
     */
    public Scene gameOver(Stage window, int result) {
        Label title = new Label();
        if (result == 0) {
            title = new Label("HÄVISIT PELIN");
        } if (result == 1) {
            title = new Label("VOITIT PELIN");
        }
        title.setTextFill(Color.BLUE);
        title.setFont(new Font("Arial", 20));
        Button newGame = new Button("Uusi peli");
        Button save = new Button("Talleta tulos");
        Button back = new Button("Päävalikkoon");
        GridPane gameOver = new GridPane();
        TextField name = new TextField();
        gameOver.add(title, 0, 0);
        gameOver.add(newGame, 0, 1);
        gameOver.add(save, 0, 2);
        gameOver.add(back, 0, 3);
        gameOver.setPrefSize(600, 400);
        gameOver.setAlignment(Pos.CENTER);
        newGame.setOnAction((event) -> window.setScene(play(window)));
        save.setOnAction((event)-> window.setScene(saveResult(window)));
        back.setOnAction((event) -> window.setScene(menu(window)));
        Scene scene = new Scene(gameOver);
        return scene;
    }
    
    /** 
     * Metodi luo scenen, jossa käyttäjä voi syöttää käyttäjänimensä, ja tallettaa
     * pelituloksensa tietokantaan.
     * 
     * @return scene
     */
    public Scene saveResult(Stage window) {
        Label title = new Label("Anna nimi");
        TextField name = new TextField();
        Button save = new Button("Tallenna");
        GridPane saveResult = new GridPane();
        saveResult.setPrefSize(600, 400);
        saveResult.setAlignment(Pos.CENTER);
        saveResult.add(title, 0, 0);
        saveResult.add(name, 0, 1);
        saveResult.add(save, 0, 2);
        //save.setOnAction((event) ->);
        Scene scene = new Scene(saveResult);
        return scene;
    }
    
    
    /**
     * Metodi luo scenen, jossa peli pelataan. Metodi piirtää ruudulle pelin tapahtumat. 
     * 
     * @return game scene, jossa peli tapahtuu
     */
    public Scene play(Stage window) {
        board = new Pane();
        board.setPrefSize(600, 400);
        Breakout breakout = new Breakout(board);
        board.getChildren().add(breakout.getBall().getBall());
        board.getChildren().add(breakout.getPad().getPad());
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
                breakout.checkCollision(board);
                if (breakout.fall() == true || breakout.getBroken() == 36) {
                    stop();
                    window.setScene(gameOver(window, 0));
                }
                if (breakout.getBroken() == 36) {
                    stop();
                    window.setScene(gameOver(window, 1));
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
        title.setTextFill(Color.BLUE);
        title.setFont(new Font("Arial", 20));
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
        newGame.setOnAction((event) -> window.setScene(play(window)));
        stop.setOnAction((event) -> System.exit(0));
        instructions.setOnAction((event) -> window.setScene(instructions(window)));
        Scene scene = new Scene(menu);
        return scene;
    }
    /**
     * Metodi luo uuden scenen, jossa on tekstinä pelin ohjeet.
     * @param window luo uuden stagen
     * @return scene uusi scene, jossa pelin ohjeet
     */
    public Scene instructions(Stage window) {
        Label title = new Label("OHJEET");
        Text text = new Text("Pelin tarkoituksena on tuhota ruudun yläreunassa "
                + "oleva tiiliseinä pallon avulla. \nPallon suuntaa ohjaillaan "
                + "ruudun alareunassa liikkuvan alustan avulla. \nPeli käynnistyy "
                + "heti, kun päävalikosta valitaan \"Uusi peli\". \nTällöin pallo "
                + "lähtee liikkumaan ylöspäin kohti tiiliseinää. \n Kun pallo osuu "
                + "tiileen, tiili tuhoutuu, ja pallon suunta muuttuu kohti alustaa.\n"
                + "Kun pallo osuu alustaan, pallo kimpoaa takaisin ylöspäin. \n"
                + "Pelaaja voi ohjailla alustaa sivusuunnassa nuolinäppäimillä. \n"
                + "Peli päättyy, kun kaikki tiilet on tuhottu tai kun pallo "
                + "putoaa alas alustan ohi. \n");
        Button back = new Button("Takaisin");
        GridPane instructions = new GridPane();
        instructions.add(title, 0, 0);
        instructions.add(text, 0, 1);
        instructions.add(back, 0, 2);
        instructions.setPrefSize(600, 400);
        instructions.setAlignment(Pos.CENTER);
        back.setOnAction((event) -> window.setScene(menu(window)));
        Scene scene = new Scene(instructions);
        return scene;
    }
    
    

    /**
     * Metodi käynnistää käyttöliittymän
     */
    
    public void launch() {
        launch(Ui.class);
    }
}
