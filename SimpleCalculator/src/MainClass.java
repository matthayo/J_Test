import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainClass extends Application {

	private static TextField txfValues = new TextField();
	
	public void start(Stage primaryStage) {
		
//STEP THREE - Part A: Prepare the primary Layout to be place on the Scene.
		GridPane gpPrimaryLayout = new GridPane();
//		gpPrimaryLayout.setGridLinesVisible(true); // for debugging only
		
		gpPrimaryLayout.setAlignment(Pos.CENTER);
		gpPrimaryLayout.setHgap(10);
		gpPrimaryLayout.setVgap(10);
		gpPrimaryLayout.setPadding(new Insets(10, 10, 10, 10));
		
//STEP FOUR: Adding controls
		
		//Title text
		Text txtTitle = new Text("Simple Calculator");
		txtTitle.setFont(Font.font("Georgia", FontWeight.BOLD, 20));
		txtTitle.setFill(Color.DIMGREY);
		
		//Setting Title to Pane
		
		//ROW 0
		gpPrimaryLayout.add(txtTitle, 0, 0, 4, 1);
		
		
		//Adding TextField
		
		//ROW 1
		//Placing TextField on Layout.
		txfValues.setFont(Font.font("Georgia", FontWeight.BOLD, 15));
		gpPrimaryLayout.add(txfValues, 0, 1, 4, 1);
		
		//Adding Buttons
			
		//ROW 2
		Button btnInt01 = new Button("1");
		btnInt01.setMaxSize(50, 50);
		btnInt01.setMinSize(50, 50);
		gpPrimaryLayout.add(btnInt01, 0, 2);
		
		Button btnInt02 = new Button("2");
		btnInt02.setMaxSize(50, 50);
		btnInt02.setMinSize(50, 50);
		gpPrimaryLayout.add(btnInt02, 1, 2);
		
		Button btnInt03 = new Button("3");
		btnInt03.setMaxSize(50, 50);
		btnInt03.setMinSize(50, 50);
		gpPrimaryLayout.add(btnInt03, 2, 2);
		
		Button btnAddition = new Button("+");
		btnAddition.setMaxSize(50, 50);
		btnAddition.setMinSize(50, 50);
		gpPrimaryLayout.add(btnAddition, 3, 2);
		
		
		//ROW 3
		Button btnInt04 = new Button("4");
		btnInt04.setMaxSize(50, 50);
		btnInt04.setMinSize(50, 50);
		gpPrimaryLayout.add(btnInt04, 0, 3);
		
		Button btnInt05 = new Button("5");
		btnInt05.setMaxSize(50, 50);
		btnInt05.setMinSize(50, 50);
		gpPrimaryLayout.add(btnInt05, 1, 3);
		
		Button btnInt06 = new Button("6");
		btnInt06.setMaxSize(50, 50);
		btnInt06.setMinSize(50, 50);
		gpPrimaryLayout.add(btnInt06, 2, 3);
		
		Button btnSubtraction = new Button("-");
		btnSubtraction.setMaxSize(50, 50);
		btnSubtraction.setMinSize(50, 50);
		gpPrimaryLayout.add(btnSubtraction, 3, 3);
		
		
		//ROW 4
		Button btnInt07 = new Button("7");
		btnInt07.setMaxSize(50, 50);
		btnInt07.setMinSize(50, 50);
		gpPrimaryLayout.add(btnInt07, 0, 4);
		
		Button btnInt08 = new Button("8");
		btnInt08.setMaxSize(50, 50);
		btnInt08.setMinSize(50, 50);
		gpPrimaryLayout.add(btnInt08, 1, 4);
		
		Button btnInt09 = new Button("9");
		btnInt09.setMaxSize(50, 50);
		btnInt09.setMinSize(50, 50);
		gpPrimaryLayout.add(btnInt09, 2, 4);
		
		Button btnMultiplication = new Button("*");
		btnMultiplication.setMaxSize(50, 50);
		btnMultiplication.setMinSize(50, 50);
		gpPrimaryLayout.add(btnMultiplication, 3, 4);
		
		
		//ROW 5
		Button btnClear = new Button("CLR");
		btnClear.setMaxSize(50, 50);
		btnClear.setMinSize(50, 50);
		gpPrimaryLayout.add(btnClear, 0, 5);
		
		Button btnInt00 = new Button("0");
		btnInt00.setMaxSize(50, 50);
		btnInt00.setMinSize(50, 50);
		gpPrimaryLayout.add(btnInt00, 1, 5);
		
		Button btnEquals = new Button("=");
		btnEquals.setMaxSize(50, 50);
		btnEquals.setMinSize(50, 50);
		gpPrimaryLayout.add(btnEquals, 2, 5);
		
		Button btnDivision = new Button("/");
		btnDivision.setMaxSize(50, 50);
		btnDivision.setMinSize(50, 50);
		gpPrimaryLayout.add(btnDivision, 3, 5);
		
		
		//ROW 6
		Button btnClose = new Button("Close");
		btnClose.setMaxSize(110, 50);
		btnClose.setMinSize(110, 50);
		gpPrimaryLayout.add(btnClose, 2, 6, 2, 1);
		
//STEP FIVE: Event-handling.
		
		//Numerical values
		
		btnInt01.setOnAction(e -> {
			setTextOnTxfValues(txfValues.getText() + "" + btnInt01.getText());
		});
		
		btnInt02.setOnAction(e -> {
			setTextOnTxfValues(txfValues.getText() + "" + btnInt02.getText());
		});
		
		btnInt03.setOnAction(e -> {
			setTextOnTxfValues(txfValues.getText() + "" + btnInt03.getText());
		});
		
		btnInt04.setOnAction(e -> {
			setTextOnTxfValues(txfValues.getText() + "" + btnInt04.getText());
		});
		
		btnInt05.setOnAction(e -> {
			setTextOnTxfValues(txfValues.getText() + "" + btnInt05.getText());
		});
		
		btnInt06.setOnAction(e -> {
			setTextOnTxfValues(txfValues.getText() + "" + btnInt06.getText());
		});
		
		btnInt07.setOnAction(e -> {
			setTextOnTxfValues(txfValues.getText() + "" + btnInt07.getText());
		});
		
		btnInt08.setOnAction(e -> {
			setTextOnTxfValues(txfValues.getText() + "" + btnInt08.getText());
		});
		
		btnInt09.setOnAction(e -> {
			setTextOnTxfValues(txfValues.getText() + "" + btnInt09.getText());
		});
		
		btnInt00.setOnAction(e -> {
			setTextOnTxfValues(txfValues.getText() + "" + btnInt00.getText());
		});
		
		//Symbol
		
		btnAddition.setOnAction(e -> {
			setTextOnTxfValues(txfValues.getText() + " " + btnAddition.getText() + " ");
		});
		
		btnSubtraction.setOnAction(e -> {
			setTextOnTxfValues(txfValues.getText() + " " + btnSubtraction.getText() + " ");
		});
		
		btnMultiplication.setOnAction(e -> {
			setTextOnTxfValues(txfValues.getText() + " " + btnMultiplication.getText() + " ");
		});
		
		btnDivision.setOnAction(e -> {
			setTextOnTxfValues(txfValues.getText() + " " + btnDivision.getText() + " ");
		});
		
		//Evaluating 
		btnEquals.setOnAction(e -> {
			try {
				calculate();
			} catch (ScriptException ex) {
				txfValues.setText("Invalid Calculation");
			}catch (Exception ex) {
				txfValues.setText("Invalid Calculation");
			}
		});
		
		//Clear values
		btnClear.setOnAction(e ->{
			txfValues.clear();
		});
		
		//Close program
		btnClose.setOnAction(e -> {
			primaryStage.close();
		});
		
		
//STEP THREE - Part B: Prepare the Scene and play it on Stage
		Scene primaryScene = new Scene(gpPrimaryLayout, 350, 400);
		primaryStage.setScene(primaryScene);
		
//STEP ONE: Prepare the Stage
		primaryStage.setTitle("Calculator");
		primaryStage.show();
	}
	
	
	public static void calculate() throws ScriptException, Exception {
		ScriptEngineManager scriptManager = new ScriptEngineManager();
		ScriptEngine scriptEngine = scriptManager.getEngineByName("JavaScript");
		
		String answer = scriptEngine.eval(txfValues.getText()).toString();
		
		txfValues.setText(answer);
		
	}
	public static void setTextOnTxfValues(String values) {
		txfValues.setText(values);
	}

	public static void main(String[] args) {
		
		//STEP TWO: Launch the Application
		launch(args);
	}
}
