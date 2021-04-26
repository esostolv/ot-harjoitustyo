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
        Pane board = new Pane();
        board.setPrefSize(600, 400);
        BorderPane layout = new BorderPane();
        Label title = new Label("BREAKOUT");
        Button newGame = new Button("Uusi peli");
        Button stats = new Button("Tilastot");
        
        GridPane menu = new GridPane();
        
        menu.add(title, 0, 0);
        menu.add(newGame, 0, 1);
        menu.add(stats, 0, 2);
        
        menu.setPrefSize(600, 400);
        menu.setAlignment(Pos.CENTER);
        
        Scene scene = new Scene(menu);
        window.setTitle("BREAKOUT");
        window.setScene(scene);
        window.show();
    }
    
    public void launch() {
        launch(Ui.class);
    }
}
