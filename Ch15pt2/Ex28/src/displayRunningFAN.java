/*
Project: Chapter 15 Java II Programming Exercise 28
Name: Christian Meissner
Date: 1/9/20
Purpose: display a running fan with pause, resume, and reverse buttons to alter the fans rotation
*/

// importing application, the scene and stage, the panes and hbox to add to the scene, shapes and colors for the design of the fan, 
// and then animation timeline + duration
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.paint.Color;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.util.Duration;
import javafx.scene.control.Button;


public class displayRunningFAN extends Application {
    boolean spinningClockwise = true;
    @Override
    
    public void start(Stage primaryStage) {
        
        // creating constant variables for the height and width of the pane then center point and radius of circle
        final double width = 500.00;
        final double height = 500.00;
        final double centerX = width /2;
        final double centerY = height /2;
        final double radius = 200.00;
        
        // iniating each pane needed and the blades of the fan
        Pane pane = new Pane();
        HBox controlPane = new HBox();
        BorderPane bPane = new BorderPane();
        Arc[] blades = new Arc[4];
        
        bPane.setCenter(pane);
        bPane.setTop(controlPane);
        
        // iniating the circle setting its color and stroke
        Circle circle = new Circle(centerX, centerY, radius);
        circle.setFill(Color.TRANSPARENT);
        circle.setStroke(Color.BLACK);
        
        // for loop to set up the multiple blades and their positions
        for(int i = 0, f = 0; i < 4; i++, f += 90) {
            Arc arc = new Arc(centerX, centerY, radius - 10, radius - 10, f, 45);
            arc.setType(ArcType.ROUND);
            arc.setFill(Color.SPRINGGREEN);
            arc.setStroke(Color.LIME);
            blades[i] = arc;
            pane.getChildren().add(arc);
        }
        
        pane.getChildren().addAll(circle);
        
        // setting up the buttons
        Button pause = new Button("Pause");
        Button resume = new Button("Resume");
        Button reverse = new Button("Reverse");
        
        controlPane.getChildren().addAll(pause, resume, reverse);
        
        
        // animation even handler
        EventHandler<ActionEvent> spin = e -> {
            double inc = spinningClockwise ? 1 : -1;
            for (int i = 0; i < blades.length; i++) {
                double startAngle = blades[i].getStartAngle();
                blades[i].setStartAngle(startAngle + inc);
            }
        };
        
        // setting speed of the spin on the fan
        KeyFrame keyframe = new KeyFrame(Duration.millis(.1), spin);
        
        // iniating the timeline of the animation and its duration to be never ending then starting it
        Timeline timeline = new Timeline(keyframe);
        timeline.setCycleCount(Timeline.INDEFINITE);
        timeline.play();
        
        // button event handlers
        pause.setOnAction(e -> timeline.pause());
        resume.setOnAction(e -> timeline.play());
        reverse.setOnAction(e -> spinningClockwise =! spinningClockwise);
        
        // adding the scene and setting the stage
        Scene scene = new Scene(bPane, width, height);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise15_28");
        primaryStage.show();
    }
    
    // launching the application
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
