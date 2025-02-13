import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class ImageDemo extends Application {
	
	public void start(Stage primaryStage) {
		Pane primaryPane = new Pane();
		
		Image image = new Image("https://www.century.edu/live/resource/image/sites/default/files/century_logo.rev.1662748133.jpg");
		ImageView imageView = new ImageView(image);
		
		primaryPane.setLayoutX(200);
		primaryPane.setLayoutY(150);
		
		primaryPane.getChildren().add(imageView);
		
		Scene primaryScene = new Scene(primaryPane, 500, 500);
		primaryStage.setTitle("Image Demo");
		primaryStage.setScene(primaryScene);
		primaryStage.show();
		
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
