import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class PathAnimationDemo extends Application{

	@Override
	public void start(Stage primaryStage) {
		// Create a pane
		Pane pane = new Pane();
		
		Rectangle rectangle = new Rectangle(0, 0, 25, 50);
		rectangle.setFill(Color.ORANGE);
		
		
		Circle circle = new Circle(250, 200, 100);
		circle.setFill(Color.WHITE);
		circle.setStroke(Color.BLACK);
		
		
		pane.getChildren().add(rectangle);
		pane.getChildren().add(circle);
		
		// Create a path transition
		PathTransition pathTrans = new PathTransition();
		
		pathTrans.setDuration(Duration.millis(4000));
		pathTrans.setPath(circle);
		pathTrans.setNode(rectangle);
		
		pathTrans.setOrientation(
				PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT
				);
		pathTrans.setCycleCount(Timeline.INDEFINITE);
		pathTrans.setAutoReverse(true);
		pathTrans.play(); // <= Starts the animation
		
		// Set controls
		circle.setOnMousePressed(e -> pathTrans.pause());
		circle.setOnMouseReleased(e -> pathTrans.play());
		
		Scene primaryScene = new Scene(pane, 500, 500);
		primaryStage.setTitle("Animation Demo");
		primaryStage.setScene(primaryScene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		Application.launch(args);
	}

}
