import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

// FIRST THINGS FIRST: INHERIT "APPLICATION" CLASS
public class Driver extends Application {

	// STEP I: Define the start method
	public void start(Stage primaryStage) {
		
		
		// STEP III: Create components
		
		// Circle
		// Circle(double centerX, double centerY, double radius)
		
		// Body
		Circle circle1 = new Circle(200, 400, 80);
		circle1.setFill(Color.BEIGE);
		circle1.setStroke(Color.BLACK);
		Circle circle2 = new Circle(200, 320, 60);
		circle2.setFill(Color.BEIGE);
		circle2.setStroke(Color.BLACK);
		Circle circle3 = new Circle(200, 250, 40);
		circle3.setFill(Color.BEIGE);
		circle3.setStroke(Color.BLACK);
		
		// Face
		Circle circle4 = new Circle(180, 240, 5);
		circle4.setFill(Color.BLACK);
		circle4.setStroke(Color.BLACK);
		
		Circle circle5 = new Circle(220, 240, 5);
		circle5.setFill(Color.BLACK);
		circle5.setStroke(Color.BLACK);
		
		Circle circle6 = new Circle(200, 255, 2);
		circle6.setFill(Color.BLACK);
		circle6.setStroke(Color.BLACK);
		
		// Arc
		// Arc(centerX, centerY, radiusX, radiusY, startAngle, length)
		Arc mouth = new Arc(200, 220, 50, 50, -115, 50);
		mouth.setStroke(Color.BLACK);
		mouth.setType(ArcType.OPEN);
		
		// Rectangle
		Rectangle base = new Rectangle(75, 450, 250, 50);
		base.setFill(Color.AZURE);
		base.setStroke(Color.BLACK);
		
		
		
		// Line
		//Line(double startX, double startY, double endX, double endY)
		Line line1 = new Line(80, 250, 100, 280);
		Line line2 = new Line(80, 300, 100, 280);
		Line line3 = new Line(100, 280, 150, 300);
		Group lArm = new Group(line1, line2, line3);
		
		Line line4 = new Line(300, 260, 350, 240);
		Line line5 = new Line(300, 260, 350, 290);
		Line line6 = new Line(250, 300, 300, 260);
		Group rArm = new Group(line4, line5, line6);

		// Polygon
		
		Polygon ground = new Polygon();
		ground.getPoints().addAll(new Double[] {
				00.0, 500.0,
				50.0, 450.0, 
				150.0, 460.0,
				250.0, 420.0, 
				300.0, 480.0, 
				425.0, 500.0,
				
		});
		ground.setFill(Color.ALICEBLUE);
		ground.setStroke(Color.BLACK);
		ground.setSmooth(true);
		
		
		// Group
		Group gSnowman = new Group(base, circle1, circle2, lArm, rArm, circle3, circle4, circle5, circle6, mouth, ground);
		
		// STEP IV: Put Components on PANE
		Pane pane = new Pane(gSnowman);
				
		// STEP V: PANE on SCENE
		
		Scene scene = new Scene(pane, 400, 500);
		
		// STEP VI: SCENE on STAGE
		primaryStage.setScene(scene);
		primaryStage.setTitle("Snowman");
		primaryStage.show();
	}
	
	
	
	
	// STEP II: Define the main method\
	public static void main(String[] args) {
		launch(args);
	}
}