import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.geometry.Insets;

public class beanMachine extends Application {
    @Override
    
    public void start(Stage primaryStage) {
        animatedBeanMachine bMachine = new animatedBeanMachine(8, 10);
        StackPane pane = new StackPane();
        pane.getChildren().add(bMachine);
        pane.setMargin(bMachine, new Insets(20));
        
        
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Exercise15_33");
        primaryStage.show();
    }
    
    public static void main(String[] args) {
        Application.launch(args);
    }
    
}
