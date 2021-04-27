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
 *
 * @author Oskari
 */
public class Ui extends Application {
    @Override
    public void start(Stage window) throws Exception {
        //GridPane layout = new GridPane();
        Scene menu = menu(window);
        window.setTitle("BREAKOUT");
        window.setScene(menu);
        window.show();
    }
    
    
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
    
    public Scene menu(Stage window) {
        Label title = new Label("BREAKOUT");
        Button newGame = new Button("Uusi peli");
        Button stats = new Button("Tilastot");
        Button instructions = new Button("Ohjeet");
        
        GridPane menu = new GridPane();
        
        menu.add(title, 0, 0);
        menu.add(newGame, 0, 1);
        menu.add(stats, 0, 2);
        menu.add(instructions, 0, 3);
        menu.setPrefSize(600, 400);
        menu.setAlignment(Pos.CENTER);
        newGame.setOnAction((event) -> window.setScene(play()));
        Scene scene = new Scene(menu);
        return scene;
    }
    

    
    public void launch() {
        launch(Ui.class);
    }
}
