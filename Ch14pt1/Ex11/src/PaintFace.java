/*
Project: Chapter 14 Java I Programming Exercise 11
Name: Christian Meissner
Date: 8/23
Purpose: Paint a Smiley Face into a Pane in JavaFX
 */

//importing all javafx stages, scenes(colors, shapes, and the pane), and application
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Polygon;


public class PaintFace extends Application{
    @Override
   
    public void start(Stage x) {
        
        //creating the head using a cirlce, setting its size, radius and color
        Circle head = new Circle();
        head.setCenterX(100);
        head.setCenterY(100);
        head.setRadius(90);
        head.setStroke(Color.BLACK);
        head.setFill(Color.WHITE);
        
        // creating both eyes with ellipses, setting their size, radius and color
        Ellipse eye1 = new Ellipse();
        eye1.setCenterX(60);
        eye1.setCenterY(75);
        eye1.setRadiusX(25);
        eye1.setRadiusY(15);
        eye1.setStroke(Color.BLACK);
        eye1.setFill(Color.WHITE);
        
        Ellipse eye2 = new Ellipse();
        eye2.setCenterX(140);
        eye2.setCenterY(75);
        eye2.setRadiusX(25);
        eye2.setRadiusY(15);
        eye2.setStroke(Color.BLACK);
        eye2.setFill(Color.WHITE);
        
        // creating pupils with circles, setting its size, radius and color
        Circle pupil1 = new Circle();
        pupil1.setCenterX(60);
        pupil1.setCenterY(75);
        pupil1.setRadius(10);
        pupil1.setStroke(Color.BLACK);
        pupil1.setFill(Color.BLACK);
        
        Circle pupil2 = new Circle();
        pupil2.setCenterX(140);
        pupil2.setCenterY(75);
        pupil2.setRadius(10);
        pupil2.setStroke(Color.BLACK);
        pupil2.setFill(Color.BLACK);
        
        
        // creating nose using polygon lines to form a triangle, assigning the color
        double factor = 5;
        double topX = 100;
        double topY = 100 - 100 / 5;
        double leftX = topY;
        double leftY = 100 + 100 / 5;
        double rightX = leftY;
        double rightY = leftY;
        Polygon nose = new Polygon(topX, topY, leftX, leftY, rightX, rightY);
        nose.setFill(Color.WHITE);
        nose.setStroke(Color.BLACK);
        
        
        // using an arc to form the mouth and then selecting the size, width, colors, and arctype
        Arc mouth = new Arc(100, 130, 50, 25, 180, 180);
        mouth.setStrokeWidth(2.5);
        mouth.setFill(Color.WHITE);
        mouth.setStroke(Color.BLACK);
        mouth.setType(ArcType.OPEN);
        
        
        // adding all shapes to the pane
        Pane pane = new Pane();
        pane.getChildren().add(head);
        pane.getChildren().add(eye1);
        pane.getChildren().add(eye2);
        pane.getChildren().add(pupil1);
        pane.getChildren().add(pupil2);
        pane.getChildren().add(mouth);
        pane.getChildren().add(nose);
        
        
        // setting the scene, title, then showing the scene
        Scene scene = new Scene(pane, 200, 200);
        x.setTitle("Exercise14_11");
        x.setScene(scene);
        x.show();
        
    }
    
    // launching args
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
