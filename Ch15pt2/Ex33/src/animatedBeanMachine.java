

// imports for the drawing of the bean machine and the animation
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.PathTransition;
import javafx.geometry.Point2D;


public class animatedBeanMachine extends Pane{
    // instance variables for making the machine work
    private int balls;
    private int slots;
    private int currentBall;
    private Exercise33 bMachine;
    private int[] slotRegistry;
    private double radius;
    private Line[] slotLines;
    private Line topLeft;
    private Line topRight;
    
    // constructor method to initialize the instances
    public animatedBeanMachine(int balls, int slots) {
        this.balls = balls;
        this.slots = slots;
        currentBall = 0;
        this.bMachine = new Exercise33(balls, slots);
        slotRegistry = new int[slots];
        radius = 10;
        this.slotLines = new Line[slots + 1];
        drawBMachine();
        startBMachine();
    }
    
    // method for the animation of the bean machine
    private void startBMachine() {
        // creating its KeyFrame with an event of dropping the current ball then adding it to its timeline
        KeyFrame kf = new KeyFrame(Duration.millis(1000), e -> dropBall(currentBall));
        Timeline tL = new Timeline(kf);
        // setting its cycle count to be the amount of balls dropping then playing the animation
        tL.setCycleCount(balls);
        tL.play();
    }
    
    // method to set up the balls dropping
    private void dropBall(int cBall) {
        // creating the path of the currentball up
        Polyline line = generatePolylinePath(bMachine.getPaths()[cBall]);
        // creating the ball then adding it to the pane
        Circle circle = new Circle(radius);
        circle.setFill(Color.SPRINGGREEN);
        getChildren().addAll(circle);
        // setting up its path transitions as it falls then setting its cycle count
        PathTransition pT = new PathTransition(Duration.millis(1000), line, circle);
        pT.setCycleCount(0);
        pT.play();
        currentBall++;
    }
    
    private Polyline generatePolylinePath(boolean[] path) {
        Polyline line = new Polyline();
        
        // drawing the path of the ball through the opening at the top
        double x = getMWidth() / 2;
        double y = 0;
        line.getPoints().addAll(x, y);
        y = getDiameter() * 2 + radius;
        line.getPoints().addAll(x, y);
        
        // draw path of ball through the machine
        Point2D pointAfterArc = new Point2D(0, 0);
        for (int i = 0; i < path.length; i++) {
            pointAfterArc = path[i] ? drawRightArc(line) : drawLeftArc(line);
            if (i < path.length - 1) {
                x = pointAfterArc.getX();
                y = pointAfterArc.getY();
                line.getPoints().addAll(x, y);
            }
        }
        
        // draw path of ball into slots
        
        x = pointAfterArc.getX();
        y = getMHeight() - radius - (getDiameter() * slotRegistry[getSlot(path)]);
        line.getPoints().addAll(x, y);
        registerSlotPath(path);
        
        return line;
    }
    
    private Point2D drawLeftArc(Polyline line) {
        double cX = line.getPoints().get(line.getPoints().size() - 2); // current x
        double cY = line.getPoints().get(line.getPoints().size() - 1); // current y
        double rX = cX; // center X of peg
        double rY = cY + getDiameter(); // cetner Y of peg
        
        for (int i = 270; i >= 180; i--) {
            double x = rX + getDiameter() * Math.cos(Math.toRadians(i));
            double y = rY + getDiameter() * Math.sin(Math.toRadians(i));
            line.getPoints().addAll(x, y);
            cX = x;
            cY = y;
        }
        
        return new Point2D(cX, cY);
    }
    
    private Point2D drawRightArc(Polyline line) {
        double cX = line.getPoints().get(line.getPoints().size() - 2); // current x
        double cY = line.getPoints().get(line.getPoints().size() - 1); // current y
        double rX = cX; // center X of peg
        double rY = cY + getDiameter(); // cetner Y of peg
        
        for (int i = 270; i <= 360; i++) {
            double x = rX + getDiameter() * Math.cos(Math.toRadians(i));
            double y = rY + getDiameter() * Math.sin(Math.toRadians(i));
            line.getPoints().addAll(x, y);
            cX = x;
            cY = y;
        }
        
        return new Point2D(cX, cY);
    }
    
    private void registerSlotPath(boolean[] path) {
        int rightCount = 0;
        
        for (int i = 0; i < path.length; i++) {
            if (path[i]) {
                rightCount++;
            }
        }
        
        slotRegistry[rightCount]++;
    }
    
    private int getSlot(boolean[] path) {
        int rightCount = 0;
        
        for(int i = 0; i < path.length; i++) {
            if (path[i]) {
                rightCount++;
            }
        }
        
        return rightCount;
    }
    
    private void drawBMachine() {
        drawBaseLine();
        drawSlots();
        drawTopLine();
        drawSideLine();
        drawPeg();
    }
    
    private void drawBaseLine() {
        Line line = new Line();
        line.setStartX(0);
        line.setStartY(getMHeight());
        line.setEndX(getMWidth());
        line.setEndY(getMHeight());
        getChildren().add(line);
    }
    
    private void drawSlots() {
        double xPos = 0;
        
        for (int i = 0; i < slotLines.length; i++) {
            Line line = new Line();
            line.setStartX(xPos);
            line.setStartY(getMHeight());
            line.setEndX(xPos);
            line.setEndY(getMHeight() - (balls * getDiameter()));
            
            slotLines[i] = line;
            getChildren().add(line);
            xPos += getDiameter() * 2;
        }
        
    }
    
    private void drawTopLine() {
        drawTopLeft();
        drawTopRight();
    }
    
    private void drawTopLeft() {
        Line line = new Line();
        line.setStartX(getMWidth() / 2 - getDiameter());
        line.setStartY(0);
        line.setEndX(line.getStartX());
        line.setEndY(getDiameter() * 2);
        topLeft = line;
        getChildren().add(line);
    }
    
    private void drawTopRight() {
        Line line = new Line();
        line.setStartX(getMWidth() / 2 + getDiameter());
        line.setStartY(0);
        line.setEndX(line.getStartX());
        line.setEndY(getDiameter() * 2);
        topRight = line;
        getChildren().add(line);
    }
    
    private void drawSideLine() {
        drawRightSide();
        drawLeftSide();
    }
    
    private void drawLeftSide() {
        Line line = new Line();
        line.setStartX(slotLines[0].getEndX());
        line.setStartY(slotLines[0].getEndY());
        line.setEndX(topLeft.getEndX());
        line.setEndY(topLeft.getEndY());
        getChildren().add(line);
    }
    
    private void drawRightSide() {
        Line line = new Line();
        line.setStartX(slotLines[slotLines.length - 1].getEndX());
        line.setStartY(slotLines[slotLines.length - 1].getEndY());
        line.setEndX(topRight.getEndX());
        line.setEndY(topRight.getEndY());
        getChildren().add(line);
    }
    
    private void drawPeg() {
        int row = slots - 1;
        for (int i = row, pad = 0; i > 0; i--, pad++) {
            for (int z = 0; z < i; z++) {
                double xPos = (getDiameter() *2) + (getDiameter() * pad) + (getDiameter() * 2 * z);
                double yPos = (getMHeight() - balls * getDiameter()) - (getDiameter() * 2 * pad);
                Circle peg = new Circle(radius);
                peg.setCenterX(xPos);
                peg.setCenterY(yPos);
                peg.setFill(Color.BLACK);
                peg.setStroke(Color.LIME);
                getChildren().add(peg);
            }
        }
    }
    
    private double getDiameter() {
        return radius * 2;
    }
    
    private double getMHeight() {
        return (balls * getDiameter() + radius) + ((slots - 1) * (getDiameter() * 2) - getDiameter()) + (getDiameter() * 2);
    }
    
    private double getMWidth() {
        return getDiameter() * 2 * slots;
    }
   
}
