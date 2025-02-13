package collections.students;

import java.time.Year;
import java.util.Calendar;

public class Student {
	
	private String studentId;
	private String firstName;
	private String lastName;
	private String email;
	private String semesterYear;
	private double gpa;
	
	//Statistics properties
	private static int numberOfStudentsEverRegistered = 0;
	
	
	//Constructors
	public Student() {
		this.firstName = "null";
		this.lastName = "null";
		this.setSemesterYear();
	}
	public Student(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.setSemesterYear();
	}
	
	//Public Methods
	
	//I: SETTERS
	/**
	 *
	 */
	public void setStudentId() {
		this.studentId = "00" + Year.now().getValue() + "01" + String.format("%03d", ++numberOfStudentsEverRegistered);
	}
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * 
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * 
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
	 * 
	 */
	public void setEmail() {
		this.email = this.firstName + "." + this.lastName + "@metrostate.edu";
	}
	
	/**
	 * 
	 */
	public void setSemesterYear () {
		
		int currentMonth = Calendar.getInstance().get(Calendar.MONTH);
		
		if( currentMonth > 7)
			semesterYear = (String) (Year.now().getValue() + "03"); 
		else if (currentMonth > 4)
			semesterYear = Year.now().getValue() + "01";
		else
			semesterYear = Year.now().getValue() + "05";
	}
	
	/**
	 * 
	 */
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	
	//GETTERS

	/**
	 * Accessor method for StudentID property.
	 * @return The requested student's ID.
	 */
	public String getStudentId() {
		return this.studentId;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	/**
	 * 
	 * @return
	 */
	public String getLastName() {
		return this.lastName;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getSemesterYear() {
		return this.semesterYear;
	}
	
	public double getGpa() {
		return this.gpa;
	}
	
	public static int getNumberOfStudentsEverRegistered() {
		return numberOfStudentsEverRegistered;
	}
}
