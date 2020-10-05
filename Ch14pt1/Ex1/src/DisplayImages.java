/*
Project: Chapter 14 Java I Programming Exercise 1
Name: Christian Meissner
Date: 8/21/2019
Purpose: Display 4 flag images on a gridpane
 */


// importing javafx stage, scenes, geometry(Postion and insets), and application
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class DisplayImages extends Application {
    @Override
    public void start(Stage primaryStage) {
        //create a pane to hold the images
        GridPane pane = new GridPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(5, 5, 5, 5));
        pane.setHgap(5);
        pane.setVgap(5);
        
        // importing the US flag image setting its postion and size
        Image USimage = new Image("US.png");
        ImageView imageView = new ImageView();
        imageView.setX(50);
        imageView.setX(50);
        imageView.setFitHeight(100);
        imageView.setFitWidth(50);
        pane.add(new ImageView(USimage), 0, 0);
        
        // importing the UK flag image setting its postion and size
        Image UKimage = new Image("UK.png");
        ImageView imageView2 = new ImageView();
        imageView2.setX(50);
        imageView2.setY(50);
        imageView2.setFitHeight(150);
        imageView2.setFitWidth(50);
        pane.add(new ImageView(UKimage), 1, 0);
        
        // importing the Canada flag image setting its postion and size
        Image CAimage = new Image("CA.png");
        ImageView imageView3 = new ImageView();
        imageView3.setX(50);
        imageView3.setY(50);
        imageView3.setFitHeight(100);
        imageView3.setFitWidth(50);
        pane.add(new ImageView(CAimage), 0 , 1);
        
        // importing the China flag image setting its postion and size
        Image CHINAimage = new Image("CHINA.png");
        ImageView imageView4 = new ImageView();
        imageView4.setX(50);
        imageView4.setY(50);
        imageView4.setFitHeight(150);
        imageView4.setFitWidth(50);;
        pane.add(new ImageView(CHINAimage), 1, 1);
        
        
        
        //Creates the scene and places it in the stage
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Exercise14_01"); // stage title
        primaryStage.setScene(scene); // placing scene in the stage
        primaryStage.show(); // displaying the stage
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
}
