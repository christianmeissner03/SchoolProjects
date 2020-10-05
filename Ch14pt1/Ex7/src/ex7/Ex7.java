package ex7;

/*
Project: Chapter 14 Java I Programming Exercise 7
Name: Christian Meissner
Date: 8/22/2019
Purpose: Display random 0s and 1s in a texfield with JavaFX

 */


// importing the javafx stage, scenes, geometry(Position and insets), and the application
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.control.TextField;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;

public class Ex7 extends Application {
    @Override
    public void start(Stage x) {
        
        // setting the size of the pane
        BinaryPane pane = new BinaryPane(10);
        pane.setPadding(new Insets(10));
        pane.setVgap(5);
        pane.setHgap(5);
        
        // setting the pane title
        x.setTitle("Exercise14_07");
        
        // adding a scene to the pane and making it unresizable and then showing the pane
        Scene scene = new Scene(pane);
        x.setScene(scene);
        x.setResizable(false);
        x.show();
        
        
        
        
    }
    
    
    class BinaryPane extends GridPane {
        
        // taking the GridPane and adding rows and columns of textfields then assigning them the number 1 or 0 randomly
        BinaryPane(int n)  {
            for (int col = 0; col < n; col++) {
                for (int row= 0; row < n; row++) {
                    int r = (int)(Math.random() * 2);
                    String binary = (r == 0) ? "0" : "1";
                    TextField txtfield = new TextField(binary);
                    txtfield.setPrefColumnCount(1);
                    txtfield.setAlignment(Pos.CENTER);
                    txtfield.setEditable(false);
                    add(txtfield, col, row);
                }
            }
        
    }
        
    
}
    //launching the application
    public static void main(String[] args) {
        Application.launch(args);
    }
}
    

