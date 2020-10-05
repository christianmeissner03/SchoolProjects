/*
Project: Chapter 15 Java II Programming Exercise 9
Name: Christian Meissner
Date: 1/7/20
Purpose: Draw lines using the arrow keys. line starts in center of pane then draws up, down, left, or right using key presses
 */

// importing application its stage and scene then the polyline and color to change it
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Polyline;
import javafx.scene.paint.Color;



public class arrowkeysLine extends Application{
    
    @Override
    
    public void start(Stage primaryStage) {
        // final variables for the width and height of line and its positions
        final double width = 1000.00;
        final double height = 1000.00;
        
        // creating the pane
        Pane pane = new Pane();
        
        // creating an array for the positioning of the line
        double[] position = {width /2, height / 2};
        
        // creating the line setting its color then initiating its start position
        Polyline line = new Polyline();
        line.setStroke(Color.LIME);
        line.getPoints().addAll(position[0], position[1]);
       
        
        // setting up the keypress event
        line.setOnKeyPressed(e -> {
            // variables for position and length
            double x = 0;
            double y = 0;
            double length = 0;
            // switch case statement to see which arrow key is pressed then moving it in the correct direction
            switch (e.getCode()) {
                case DOWN: line.getPoints().addAll(position[0], position[1] += 10);
                    break;
                case UP:  line.getPoints().addAll(position[0], position[1] -= 10);
                    break;
                case RIGHT: line.getPoints().addAll(position[0] += 10, position[1]);
                    break;
                case LEFT: line.getPoints().addAll(position[0] -= 10, position[1]);
                    break;    
            }
            
        });
        
        // adding the line to the pane
        pane.getChildren().add(line);
        // setting the scene size, stage title and scene then showing the title
        Scene scene = new Scene(pane, 750.00, 750.00);
        primaryStage.setTitle("Exercise15_09");
        primaryStage.setScene(scene);
        primaryStage.show();
        line.requestFocus();
    }
    
    // launching the application in main method
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
