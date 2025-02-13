//JAVAFX Help: http://www.java2s.com

package collections.students;

import java.text.DecimalFormat;

import javafx.application.Application;
//import javafx.collections.FXCollections;
//import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MainClass extends Application {
	
	@SuppressWarnings("rawtypes")
	private static TableView displayTable = new TableView();
	private static int collectionCounter = 0;
	private static int currentListIndex;
	private static final int MAX_LIST_SIZE = 10;
	private static StudentListMgmtBag[] studentListCollection = new StudentListMgmtBag[MAX_LIST_SIZE];
	private static StudentListMgmtBag currentStudentList;
	private static Hyperlink[] hplStudentListNames = new Hyperlink[MAX_LIST_SIZE];
	private Label lblWarning = new Label();
	
	public void start(Stage primaryStage) {

		BorderPane bpPrimaryLayout = new BorderPane();

		// TOP ==> Primary BorderPane

		// Adding title to the top of the Border Pane
		Text title = new Text("CLASSLIST USING ARRAYBAG COLLECTION");
		title.setFont(Font.font("Georgia", FontWeight.BOLD, 25));
		title.setFill(Color.DIMGREY);

		BorderPane.setMargin(title, new Insets(15, 15, 15, 15));
		BorderPane.setAlignment(title, Pos.TOP_CENTER);
		bpPrimaryLayout.setTop(title);

		// LEFT ==> Primary BorderPane
		
		//Add New List Section

		GridPane gpNewListComponents = new GridPane();
		gpNewListComponents.setAlignment(Pos.CENTER);
		gpNewListComponents.setHgap(10);
		gpNewListComponents.setVgap(10);
		gpNewListComponents.setPadding(new Insets(20, 20, 20, 20));

		//Adding New List
		
		//Title
		Text txtCreateNewList = new Text("Create New List");
		txtCreateNewList.setFont(Font.font("Georgia", FontWeight.BOLD, 15));
		txtCreateNewList.setFill(Color.DIMGREY);
		gpNewListComponents.add(txtCreateNewList, 0, 0, 2, 1);
		
		Label lbCreateNewList = new Label("New List");
		gpNewListComponents.add(lbCreateNewList, 0, 1);
		
		TextField txfNewListName = new TextField();
		gpNewListComponents.add(txfNewListName, 1, 1);
		
		Button btnCreateNewList = new Button("Create");
		gpNewListComponents.add(btnCreateNewList, 2, 1);

		//Add/Edit Section
		
		// Setting up the Grid Pane and adding to the LEFT of the Primary Layout
		GridPane gpAddEditComponents = new GridPane();
		gpAddEditComponents.setAlignment(Pos.CENTER);
		gpAddEditComponents.setHgap(10);
		gpAddEditComponents.setVgap(10);
		gpAddEditComponents.setPadding(new Insets(20, 20, 20, 20));
		
		gpAddEditComponents.setDisable(true);


		//Title of this section
		Text addEditTitle = new Text("Add/Edit");
		addEditTitle.setFont(Font.font("Georgia", FontWeight.BOLD, 15));
		addEditTitle.setFill(Color.DIMGREY);
		gpAddEditComponents.add(addEditTitle, 0, 0);
		
		Label lblCurrentList = new Label();
		lblCurrentList.setFont(Font.font("Arial", FontWeight.BOLD, 15));
		lblCurrentList.setTextFill(Color.GREEN);
		gpAddEditComponents.add(lblCurrentList, 1, 0, 2, 1);

		// Creating Labels Text Fields and Buttons

		Label lblFirstName = new Label("First Name: ");
		gpAddEditComponents.add(lblFirstName, 0, 1);

		TextField txfFirstName = new TextField();
		gpAddEditComponents.add(txfFirstName, 1, 1, 2, 1);

		Label lblLastName = new Label("Last Name: ");
		gpAddEditComponents.add(lblLastName, 0, 2);

		TextField txfLastName = new TextField();
		gpAddEditComponents.add(txfLastName, 1, 2, 2, 1);

		Label lblSemester = new Label("Semester: ");
		gpAddEditComponents.add(lblSemester, 0, 3);

		TextField txfSemester = new TextField();
		txfSemester.setDisable(true);
		gpAddEditComponents.add(txfSemester, 1, 3, 2, 1);

		Label lblCourse = new Label("Course: ");
		gpAddEditComponents.add(lblCourse, 0, 4);

		TextField txfCourse = new TextField();
		gpAddEditComponents.add(txfCourse, 1, 4, 2, 1);

		Label lblGpa = new Label("GPA: ");
		gpAddEditComponents.add(lblGpa, 0, 5);

		TextField txfGpa = new TextField();
		txfGpa.setDisable(true);
		gpAddEditComponents.add(txfGpa, 1, 5, 2, 1);

		Button btnAddSubmit = new Button("Submit");
		btnAddSubmit.setMinSize(80, 30);
		gpAddEditComponents.add(btnAddSubmit, 0, 6);
		
		Button btnAddCancel = new Button("Cancel");
		btnAddCancel.setMinSize(80, 30);
		gpAddEditComponents.add(btnAddCancel, 1, 6);
		
		Button btnAddReset = new Button("Reset");
		btnAddReset.setMinSize(80, 30);
		gpAddEditComponents.add(btnAddReset, 2, 6);
		
//		gpAddEditComponents.add(lblWarning, 0, 7, 3, 2);
		
		VBox vbBorderPaneLeft = new VBox(gpNewListComponents, gpAddEditComponents, lblWarning);
		
		BorderPane.setMargin(vbBorderPaneLeft, new Insets(15, 15, 15, 15));
		BorderPane.setAlignment(vbBorderPaneLeft, Pos.TOP_CENTER);
		bpPrimaryLayout.setLeft(vbBorderPaneLeft);
		
		//	CENTER ==> Primary BorderPane
		
		GridPane gpCloneComponents = new GridPane();
		gpCloneComponents.setAlignment(Pos.TOP_LEFT);
		gpCloneComponents.setHgap(10);
		gpCloneComponents.setVgap(10);
		gpCloneComponents.setPadding(new Insets(20, 20, 20, 20));
		
		
		// Adding title to the top of the Border Pane
		Text txtCloneTitle = new Text("Clone");
		txtCloneTitle.setFont(Font.font("Georgia", FontWeight.BOLD, 15));
		txtCloneTitle.setFill(Color.DIMGREY);
		gpCloneComponents.add(txtCloneTitle, 0, 0, 2, 1);
		
		Label lbCloneFrom = new Label("From:");
		gpCloneComponents.add(lbCloneFrom, 0, 1);
		
		ChoiceBox<String> cbxCloneFrom = new ChoiceBox<String>();
		gpCloneComponents.add(cbxCloneFrom, 1, 1, 2, 1);
		
		Label lbCloneTo = new Label("To:");
		gpCloneComponents.add(lbCloneTo, 0, 2);
		
		ChoiceBox<String> cbxCloneTo = new ChoiceBox<String>();
		gpCloneComponents.add(cbxCloneTo, 1, 2, 2, 1);
		
		Button btnClone = new Button("Clone");
		gpCloneComponents.add(btnClone, 2, 3);
		
		//Placing gpCloneComponents onto PrimaryLayout.
		bpPrimaryLayout.setCenter(gpCloneComponents);
		
		
		//	RIGHT ==> Primary BorderPane
		
		GridPane gpDisplayList = new GridPane();
		gpDisplayList.setAlignment(Pos.TOP_LEFT);
		gpDisplayList.setHgap(10);
		gpDisplayList.setVgap(10);
		gpDisplayList.setPadding(new Insets(20, 20, 20, 20));
		
		
		// Adding title to the top of the Border Pane
		Text txtDisplayListTitle = new Text("Available Collections");
		txtDisplayListTitle.setFont(Font.font("Georgia", FontWeight.BOLD, 15));
		txtDisplayListTitle.setFill(Color.DIMGREY);
		gpDisplayList.add(txtDisplayListTitle, 0, 0, 2, 1);
		
		
		
		//Placing gpDisplayList onto PrimaryLayout.
		bpPrimaryLayout.setRight(gpDisplayList);
		
		//	BOTTOM  ==> Primary BorderPane
		
		displayTable =  displayAllStudents();
		bpPrimaryLayout.setBottom(displayTable);
		
		//	EVENT-HANDLING
		
		//Create button ==> Create new instance of ArrayBag and add it to the list
		//					of Available Collections.
		
		btnCreateNewList.setOnAction(e -> {
			
			lblWarning.setText("");

			try {
				if(txfNewListName.getText() != "" &&
						!txfNewListName.getText().trim().equals("") && 
						collectionCounter < MAX_LIST_SIZE){
					studentListCollection[collectionCounter] = createNewListObject();
					studentListCollection[collectionCounter].setName(txfNewListName.getText());
					hplStudentListNames[collectionCounter] = new Hyperlink((collectionCounter + 1)+ ": " + txfNewListName.getText());
					lblCurrentList.setText(txfNewListName.getText());
					
					gpAddEditComponents.setDisable(false);
					displayAvailableLists(gpDisplayList);
					
					collectionCounter++;
				}
				else if (collectionCounter >= MAX_LIST_SIZE){
					lblWarning.setWrapText(true);
					lblWarning.setTextFill(Color.RED);
					lblWarning.setFont(Font.font("Arial", FontWeight.BOLD, 12));
					lblWarning.setText("New Class not created ==> Maximum size of list exceeded!");
				}
				else{
					lblWarning.setWrapText(true);
					lblWarning.setTextFill(Color.RED);
					lblWarning.setFont(Font.font("Arial", FontWeight.BOLD, 12));
					lblWarning.setText("New Class not created ==> Class Name is NULL!");
				}
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		});
		
		btnCreateNewList.setOnMouseReleased(e -> {
			txfNewListName.clear();
		});
		
		btnAddSubmit.setOnAction(e -> {
			lblWarning.setText("");
			
			if(!lblCurrentList.getText().trim().equals("") && lblCurrentList.getText() != null){
				currentStudentList = currentObject(lblCurrentList.getText());

				try {
					if(!txfFirstName.getText().trim().equals("") &&
							txfFirstName.getText() != null &&
							!txfLastName.getText().trim().equals("") &&
							txfLastName.getText() != null &&
							!txfCourse.getText().trim().equals("") &&
							txfCourse.getText() != null){
					currentStudentList.addStudent(txfFirstName.getText(),
							txfLastName.getText(), generateGpa());
					}
					else{
						lblWarning.setWrapText(true);
						lblWarning.setTextFill(Color.RED);
						lblWarning.setFont(Font.font("Arial", FontWeight.BOLD, 12));
						lblWarning.setText("FirstName or LastName or Course field(s) is/are empty");
					}
				} catch (CloneNotSupportedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lblWarning.setText("New Student Added: " + currentStudentList.student[currentListIndex].getFirstName());
				
				txfSemester.setText(currentStudentList.student[currentListIndex].getSemesterYear());
				txfGpa.setText(Double.toString(currentStudentList.student[currentListIndex].getGpa()));
			}
			else{
				lblWarning.setWrapText(true);
				lblWarning.setTextFill(Color.RED);
				lblWarning.setFont(Font.font("Arial", FontWeight.BOLD, 12));
				lblWarning.setText("A Student cannot be added into a vacuum!");
			}
		});
		
		btnAddSubmit.setOnMouseReleased(e -> {
			
			btnAddSubmit.setDisable(true);
		});
		
		btnAddCancel.setOnAction(e -> {
			lblWarning.setText("");
			
			txfFirstName.setText("");
			txfLastName.setText("");
			txfSemester.setText("");
			txfCourse.setText("");
			txfGpa.setText("");
			
			btnAddSubmit.setDisable(false);
		});
		
		btnAddReset.setOnAction(e -> {
			lblWarning.setText("");
			
			txfFirstName.setText("");
			txfLastName.setText("");
			txfSemester.setText("");
			txfCourse.setText("");
			txfGpa.setText("");
			
			lblCurrentList.setText("");
			
			btnAddSubmit.setDisable(false);
		});
		
		//Selecting a List to edit
//		HyperLink hplLink = 
		
		//	SCENE
		
		// Preparing the Scene and adding it to Stage
		Scene primaryScene = new Scene(bpPrimaryLayout, 800, 700);
		primaryStage.setScene(primaryScene);

		// 	STAGE
		
		// Preparing the Stage
		primaryStage.setTitle("Class List");
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
	
	//Create a new Instance of StudentBag
	public static StudentListMgmtBag createNewListObject() throws Exception {
		String className = "collections.students.StudentListMgmtBag";
		Class<?> aListRaw = Class.forName(className);
		StudentListMgmtBag aList = (StudentListMgmtBag) aListRaw.newInstance();
		return aList;
				
	}
	
	//Display List on Available Collection column
	public static void displayAvailableLists (GridPane gpDisplayList){
			gpDisplayList.add(hplStudentListNames[collectionCounter], 0, collectionCounter + 1, 2, 1);
	}
	
	//Determining the current Object
	public static StudentListMgmtBag currentObject(String currentListName){
		
		int i;
		for( i = 0; i < MAX_LIST_SIZE; i++){
			if(studentListCollection[i].getName().equals(currentListName)){
				currentListIndex = i;
				break;
			}
		}
		
		return studentListCollection[i];
	}
	
	/**
	 * Calculates a GPA 
	 * @return GPA between 3.0 to 4.0
	 */
	private double generateGpa() {
		double gpa = Math.random()*10;
		
		if (gpa > 8.0)
			gpa -= 6.0;
		else if (gpa > 6.0)
			gpa -= 4.0;
		else if (gpa > 4.0)
			gpa -= 2.0;
		else if (gpa < 2.0)
			gpa += 1.0;
		
		if (gpa < 2.0)
			gpa += 1.0;
		
		DecimalFormat decimalFormat = new DecimalFormat("0.0");
		return gpa = Double.parseDouble(decimalFormat.format(gpa));
		
	}
	
	//This method print all data contained in the student/faculty array object
		@SuppressWarnings({ "unchecked", "rawtypes" })
		private static TableView displayAllStudents(){

			//TABLEVIEW
			
			//Creating the table
			TableView tvDisplayTable = new TableView();
			tvDisplayTable.setEditable(true);
			
			//Creating and adding columns
			TableColumn tcStudentIdCol = new TableColumn("Student ID");
			TableColumn tcFirstNameCol = new TableColumn("First Name");
			TableColumn tcLastNameCol = new TableColumn("Last Name");
			TableColumn tcEmailCol = new TableColumn("Email");
			TableColumn tcSemesterYearCol = new TableColumn("Sementer-Year");
			TableColumn tcGpaCol = new TableColumn("GPA");
			
			//Creating an Observable to fill the TableView

			tcStudentIdCol.setCellValueFactory(
					new PropertyValueFactory<Student, String>("studentId")
					);
			tcFirstNameCol.setCellValueFactory(
					new PropertyValueFactory<Student, String>("firstName")
					);
			tcLastNameCol.setCellValueFactory(
					new PropertyValueFactory<Student, String>("lastName")
					);
			tcEmailCol.setCellValueFactory(
					new PropertyValueFactory<Student, String>("email")
					);
			tcSemesterYearCol.setCellValueFactory(
					new PropertyValueFactory<Student, String>("semesterYear")
					);
			tcGpaCol.setCellValueFactory(
					new PropertyValueFactory<Student, String>("gpa")
					);

//			ArrayList<Student> studentArrayList = new ArrayList<Student>(Arrays.asList(student));
//			ObservableList<Student> studentList = FXCollections.observableArrayList(studentArrayList);
//			tvDisplayTable.setItems(studentList);
//			tvDisplayTable.getColumns().addAll(tcStudentIdCol, tcFirstNameCol, tcLastNameCol, tcEmailCol, tcSemesterYearCol, tcGpaCol);
			return tvDisplayTable;
		}
		//End of displayAllStudent method
		
		
}
