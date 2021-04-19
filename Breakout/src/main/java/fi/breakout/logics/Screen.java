
package fi.breakout.logics;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Screen extends Application {
    private Pane board;
    private Wall[] wall;
    
    
    @Override
    public void start(Stage window) {
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
        Scene scene = new Scene(board);
        window.setTitle("BREAKOUT");
        window.setScene(scene);
        window.show();
    }
    
    public void launch() {
        launch(Screen.class);
    }
    
    public void draw() {
        
    }

}
