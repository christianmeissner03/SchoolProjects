/*
Project: Chapter 15 Java II Programming Exercise 33
Name: Christian Meissner
Date: 1/9/20
Purpose: display a bean machine with an animation of ten balls dropping then the animation terminates 
 */




public class Exercise33 {
    // instance variables for the balls slots and paths it takes
    private int balls;
    private int slots;
    private boolean[][] paths;
    
    // constructor to initialize instances
    public Exercise33(int balls, int slots) {
        this.balls = balls;
        this.slots = slots;
        paths = generatePaths();
    }
    
    // return method to generate the path the ball takes when dropping
    private boolean[][] generatePaths() {
        // boolean 2D array for the route of the ball to the slots
        boolean[][] route = new boolean[balls][slots -1];
        
        // two for loops to generate the route
        for (int i = 0; i < route.length; i++) {
            for (int z = 0; z < route[i].length; z++) {
                route[i][z] = (int) (Math.random() * 2) == 1 ? true : false;
            }
            
        }
        return route;
        
    }
    
    // return method for paths
    public boolean[][] getPaths() {
        return paths;
    }
}
