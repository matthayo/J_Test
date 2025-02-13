import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class CompoundInterestGUI extends Application{
	private TextField tfPrincipal = new TextField();
	private TextField tfRate = new TextField();
	private TextField tfYears = new TextField();
	private TextField tfFutureValue = new TextField();
	private Button btnCalculate = new Button("Calculate");	
	
	public void start(Stage primaryStage) {
		
		GridPane primaryPane = new GridPane();
		
		// Layout components on GridPane
		primaryPane.add(new Label("Principal Amount:"), 0, 0);
		primaryPane.add(tfPrincipal, 1, 0);
		
		primaryPane.add(new Label("Annual Rate: "), 0, 1);
		primaryPane.add(tfRate, 1, 1);
		
		primaryPane.add(new Label("Number of Years: "), 0, 2);
		primaryPane.add(tfYears, 1, 2);
		
		primaryPane.add(new Label("Future Value: "), 0, 3);
		primaryPane.add(tfFutureValue, 1, 3);
		
		primaryPane.add(btnCalculate, 1, 4);
		
		// Beautify UI
		primaryPane.setHgap(5);
		primaryPane.setVgap(5);
		
		primaryPane.setAlignment(Pos.CENTER);
		
		tfPrincipal.setAlignment(Pos.BOTTOM_RIGHT);
		tfRate.setAlignment(Pos.BOTTOM_RIGHT);
		tfYears.setAlignment(Pos.BOTTOM_RIGHT);
		
		tfFutureValue.setAlignment(Pos.BOTTOM_RIGHT);
		tfFutureValue.setEditable(false);
		
		GridPane.setHalignment(btnCalculate, HPos.RIGHT);
		
		// Event handling
		btnCalculate.setOnAction(e -> compoundInterest());
		
		Scene primaryScene = new Scene(primaryPane, 300, 200);
		
		primaryStage.setScene(primaryScene);
		primaryStage.setTitle("Loan Calculator");
		primaryStage.show();
	}
	
	public void compoundInterest() {
		double futureValue;
		double principal = Double.parseDouble(tfPrincipal.getText());
		double rate = Double.parseDouble(tfRate.getText());
		int years = Integer.parseInt(tfYears.getText());
		int numberOfCompounding = 4;
		
		futureValue = principal * Math.pow( 1 + ((rate / 100) / numberOfCompounding), (numberOfCompounding * years) );
		
		tfFutureValue.setText(String.format("$%.2f", futureValue));
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
