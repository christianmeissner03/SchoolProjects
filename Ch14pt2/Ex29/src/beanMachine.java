/*
Project: Chapter 14 Java I Programming Exercise 29
Name: Christian Meissner
Date: 8/27/2019
Purpose: display a bean machine
 */

// importing the javafx application, scene, stage, panes, shapes(line and circle)

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;


public class beanMachine extends Application {
    @Override
    public void start(Stage z) {
        
         final double x = 300.00;
         final double y = 400.00;
        
        Pane pane = new Pane();
        
        // creating the line on the bottom of the beanmachine
        Line bottom = new Line(0, y, x, y);
        
        // creating the lines for the slots with a for loop then making them the correct length/width
        double xslotLines = 0;
        for (int i = 0; i < 9; i ++) {
            pane.getChildren().add(new Line(xslotLines, y, xslotLines, y / 5*4));
            xslotLines += x / 8;
        }
        
        // creating the left side line(and sizing it) that connect to the slanted line
        Line leftSide = new Line();
        leftSide.setStartX(300 / 2 - x / 16);
        leftSide.setStartY(0);
        leftSide.setEndX(x / 2 - x / 16);
        leftSide.setEndY(y / 9);
        
        // creating the right side line(and sizing it) that connect to the slanted line
        Line rightSide = new Line();
        rightSide.setStartX(300 / 2 + x / 16);
        rightSide.setStartY(0);
        rightSide.setEndX(300 / 2 + x / 16);
        rightSide.setEndY(400 / 9);
        
        
        // creating both slanted lines on the left and right and setting their length and position
        Line slantL = new Line(0, y / 5*4, leftSide.getEndX(), leftSide.getEndY());
        Line slantR = new Line(x, y / 5*4, rightSide.getEndX(), rightSide.getEndY());
        
        
        // creating the the dots/pins (making rows and columns with for loops)
        for (int row = 7, mod = 0; row >= 1; row --, mod++) {
            xslotLines = (x / 8) + (x / 16 * mod);
            double yslotLines = (y / 5 * 4) - (y / 9 * mod);
            for (int col = row; col >= 1; col--) {
                Circle circle = new Circle(xslotLines, yslotLines, y / 75);
                circle.setFill(Color.BLUE);
                xslotLines += x / 8;
                pane.getChildren().add(circle);
            }
            
            
        }
        
        
        
        
        // adding all lines to the pane
        pane.getChildren().add(bottom);
        pane.getChildren().add(leftSide);
        pane.getChildren().add(rightSide);
        pane.getChildren().add(slantL);
        pane.getChildren().add(slantR);
        
        
        
        // creating the scene with the pane in it with the correct size, adding the title, making it unresizable, then displaying the scene
        Scene scene = new Scene(pane);
        z.setTitle("Exercise14_29");
        z.setScene(scene);
        z.setResizable(false);
        z.show();
    }
    
    // launching the application arguments
    public static void main(String[] args) {
        Application.launch(args);
    }
}
