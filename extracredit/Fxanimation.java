package fxanimation;

import java.util.Random;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Polygon;
import javafx.scene.paint.Color;
import javafx.animation.RotateTransition;
import javafx.animation.FadeTransition;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;


public class Fxanimation extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        Random rand = new Random();
        
        AnchorPane root = new AnchorPane();
        
        Label instruction = new Label("Click the spinning square.");
        instruction.setLayoutX(0.0);
        instruction.setLayoutY(0.0);
        
        Polygon square = new Polygon();
        square.getPoints().addAll(new Double[]{
            0.0,0.0,
            100.0,0.0,
            100.0,100.0,
            0.0,100.0
        });
        square.setFill(new Color(rand.nextDouble(),rand.nextDouble(),rand.nextDouble(),1.0));
        square.setLayoutX(100);
        square.setLayoutY(100);
        
        FadeTransition fade = new FadeTransition();
        fade.setDuration(Duration.seconds(1));
        fade.setNode(square);
        
        square.setOnMouseReleased(event -> {
            fade.setFromValue(1.0);
            fade.setToValue(0.0);
            fade.setOnFinished(event1 -> {
                int x=rand.nextInt(401) + 100;
                int y=rand.nextInt(201) + 100;
                square.setLayoutX(x);
                square.setLayoutY(y);
                square.setFill(new Color(rand.nextDouble(),rand.nextDouble(),rand.nextDouble(),1.0));
                fade.setFromValue(0.0);
                fade.setToValue(1.0);
                fade.setOnFinished(null);
                fade.play();
            });
            fade.play();
        });
        
        RotateTransition rotate = new RotateTransition();
        rotate.setDuration(Duration.seconds(3.0));
        rotate.setNode(square);
        rotate.setCycleCount(1);
        rotate.setAutoReverse(false);
        rotate.setByAngle(360);
        rotate.setOnFinished(event -> {
            rotate.play();
        });
        rotate.play();
        
        root.getChildren().addAll(square,instruction);
        Scene scene = new Scene(root, 600, 400);
        
        primaryStage.setTitle("JavaFX Animation");
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
