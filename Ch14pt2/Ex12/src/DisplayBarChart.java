/*
Project: Chapter 14 Java I Programming Exercise 12
Name: Christian Meissner
Date: 8/26/2019
Purpose: Display the charts of the overall grade represented by projects, quizzes, midterm exams, and the final exam
 */

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.FontPosture;



public class DisplayBarChart extends Application {
    @Override
    public void start(Stage x) {
        
        // importing the first rectangle bar(Projects grade) for the graph then setting its position and color
        Rectangle projectBar = new Rectangle(10, 125, 120, 65);
        projectBar.setStroke(Color.BLACK);
        projectBar.setFill(Color.RED);
        
        // importing the text for the project bar then setting its position, text then setting its font(type, its posture, weight, and size)
        Text project = new Text(20, 118, "Project -- 20%");
        project.setFont(Font.font("Courier", FontWeight.BOLD,
                FontPosture.REGULAR, 15));
        
        
        // importing the second rectangle bar(Quiz's grade) for the graph then setting its position and color
        Rectangle quizBar = new Rectangle(150, 157, 120, 32.5);
        quizBar.setStroke(Color.BLACK);
        quizBar.setFill(Color.BLUE);
        
        // importing the text for the quiz bar then setting its position, text then setting its font(type, its posture, weight, and size)
        Text quiz = new Text(160, 145, "Quiz -- 10%");
        quiz.setFont(Font.font("Courier", FontWeight.BOLD,
                FontPosture.REGULAR, 15));
        
        // importing the third rectangle bar(midTerm's grade) for the graph then setting its position and color
        Rectangle midTermBAR = new Rectangle(290, 102, 120, 87.5);
        midTermBAR.setStroke(Color.BLACK);
        midTermBAR.setFill(Color.GREEN);
        
        // importing the text for the midTerm bar then setting its position, text then setting its font(type, its posture, weight, and size)
        Text midTerm = new Text(295, 95, "Midterm -- 30%");
        midTerm.setFont(Font.font("Courier", FontWeight.BOLD,
                FontPosture.REGULAR, 15));
        
        // importing the last rectangle bar(final's grade) for the graph then setting its position and color
        Rectangle finalBar = new Rectangle(430, 70, 120, 120);
        finalBar.setStroke(Color.BLACK);
        finalBar.setFill(Color.ORANGE);
        
        // importing the text for the final bar then setting its position, text then setting its font(type, its posture, weight, and size)
        Text Final = new Text(440, 65, "Final -- 40%");
        Final.setFont(Font.font("Courier", FontWeight.BOLD,
                FontPosture.REGULAR, 15));
        
        
        
        
        
        // creating the pane then adding each javafx item to it (rectangles and text)
        Pane pane = new Pane();
        pane.getChildren().add(projectBar);
        pane.getChildren().add(project);
        pane.getChildren().add(quizBar);
        pane.getChildren().add(quiz);
        pane.getChildren().add(midTermBAR);
        pane.getChildren().add(midTerm);
        pane.getChildren().add(finalBar);
        pane.getChildren().add(Final);
        
        
        // crating the scene adding the pane and setting its size then creating the title setting the scene and showing it
        Scene scene = new Scene(pane, 565, 200);
        x.setTitle("Exercise14_12");
        x.setScene(scene);
        x.show();
    
}
    
    // launching the args
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
