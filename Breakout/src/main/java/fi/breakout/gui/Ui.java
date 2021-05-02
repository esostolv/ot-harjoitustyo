/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fi.breakout.gui;

import fi.breakout.logics.Ball;
import fi.breakout.logics.Pad;
import fi.breakout.logics.Wall;
import javafx.geometry.Pos;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Luokka luo graafisen käyttöliittymän, jossa on valikko, josta käyttäjä voi
 * valita, mitä tekee, ja pelata peliä. 
 */
public class Ui extends Application {
    
    /**
     * Metodi luo uuden valikon ja asettaa sen window-stageen. 
     * @param window
     * @throws Exception 
     */
    @Override
    public void start(Stage window) throws Exception {
        Scene menu = menu(window);
        window.setTitle("BREAKOUT");
        window.setScene(menu);
        window.show();
    }
    
    /**
     * Metodi luo uuden olion peliä varten ja alustaa pelin: luo pallon, alustan ja 
     * tiilet. 
     * 
     * @return scene, jossa käyttäjä voi pelata peliä.
     */
    public Scene play() {
        Pane board = new Pane();
        board.setPrefSize(600, 400);
        
        Ball b = new Ball();
        board.getChildren().add(b.getBall());
        Pad p = new Pad();
        board.getChildren().add(p.getPad());
        for (int i = 0; i < 12; i++) {
            for (int j = 0; j < 3; j++) {
                board.getChildren().add(new Wall(i * 50, j * 20, 20, 50).getWall());
            }
        }
        Scene game = new Scene(board);
        return game;
    }
    /**
     * Metodi alustaa uuden valikon pelin etusivulle. Valikosta käyttäjä pääsee aloittamaan
     * uuden pelin, tarkastelemaan aiempia tuloksia, lukemaan ohjeet ja sulkemaan sovelluksen.
     * 
     * @param window  Luo uuden Stge-olion. 
     * @return 
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
    

    
    public void launch() {
        launch(Ui.class);
    }
}
