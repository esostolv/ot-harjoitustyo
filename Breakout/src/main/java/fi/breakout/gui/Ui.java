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
 * The class creates a graphical ui with a menu and different scenes.  
 */
public class Ui extends Application {
    private Breakout breakout;
    /**
     * The method creates a new menu and sets stage "window" 
     * @param window
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
     * The method creates a new scene, in which the game can be played. 
     * 
     * @return a scene in which the game is played
     */
   
    /**
     * The method creates a new menu on the first scene of the application. 
     * 
     * @param window  Creates a new stage.  
     * @return a new menu
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
        newGame.setOnAction((event) -> window.setScene(breakout.play()));
        stop.setOnAction((event) -> System.exit(0));
        Scene scene = new Scene(menu);
        return scene;
    }
    


    
    public void launch() {
        launch(Ui.class);
    }
}
