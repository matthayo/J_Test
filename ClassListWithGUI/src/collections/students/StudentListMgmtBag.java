package collections.students;

public class StudentListMgmtBag implements Cloneable {

	private String name;
	Student[] student;
	private int numberOfStudents = 0;
	private int studentArrayIndex = 0;


	public StudentListMgmtBag() {
		
		student = new Student[10];

		for(int index = 0; index < student.length; index++) {
			student[index] = new Student("Null", "Null");
		}
	}

//	public StudentListMgmtBag(int initialListCapacity) {
//
//		if(initialListCapacity < 0)
//			throw new IllegalArgumentException("Array Capacity cannot be " + initialListCapacity);
//
//		student = new Student[initialListCapacity];
//
//		for(int index = 0; index < student.length; index++) {
//			student[index] = new Student("Null", "Null");
//		}
//	}

	public String getName(){
		return name;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void addStudent(String firstName, String lastName, double gpa) throws CloneNotSupportedException {

		if(numberOfStudents == student.length) {
			ensureCapacity((numberOfStudents * 2) + 1);
		}

		student[studentArrayIndex].setStudentId();
		student[studentArrayIndex].setFirstName(firstName);
		student[studentArrayIndex].setLastName(lastName);
		student[studentArrayIndex].setEmail();
		student[studentArrayIndex].setGpa(gpa);

		studentArrayIndex++;
		numberOfStudents++;
	}
	public boolean editStudent(
			String studentId,
			String firstName,
			String lastName,
			String email,
			float gpa) {

		boolean editted = false;
		int index = -1;

		if(numberOfStudents > 0) {
			index = findStudent(studentId);

			if(index > 0)
				editted = true;

		}
		if(firstName != null)
			student[index].setFirstName(firstName);

		if(lastName != null)
			student[index].setLastName(lastName);

		if(email != null)
			student[index].setEmail(email);

		if(gpa != student[index].getGpa() || gpa != 0)
			student[index].setGpa(gpa);

		return editted;
	}

	public boolean removeStudent(String studentId) {

		boolean removed = false;
		int index = -1;

		if(numberOfStudents > 0) {		
			index = findStudent(studentId);

			if(index >= 0) {
				student[index] = student[studentArrayIndex - 1];

				studentArrayIndex--;
				numberOfStudents--;
				removed = true;
			}
		}

		return removed;
	}

	public int findStudent(String studentId) {
		int index;

		for(index = 0; index < numberOfStudents; index++) {
			if(studentId.equals(student[index].getStudentId()))
				return index;

		}
		return -1;
	}

	public int getCapacity() {
		return student.length;
	}

	public int getSize() {
		return numberOfStudents;
	}

	public void printStudentsList() {

		System.out.printf("\t|STUDENT_ID\t|FIRST_NAME %1$-15s\t|LAST_NAME %1$-15s\t|EMAIL %1$-50s\t|SEMESTER_YEAR %1$-15s\t|GPA\n\r", "");
		for(int index = 0; index < numberOfStudents; index++) {

			System.out.printf((index + 1) + ":\t|"
					+ student[index].getStudentId() + "\t|"
					+ student[index].getFirstName() + "%1$-20s\t|"
					+ student[index].getLastName() + "%1$-20s\t|"
					+ student[index].getEmail() + "%1$-30s\t|"
					+ student[index].getSemesterYear() + "%1$-20s\t|"
					+ student[index].getGpa(), "");
			System.out.println();
		}

	}

	public void printStudent(String studentId) {

		int index = findStudent(studentId);
		if(index >= 0) {
			System.out.printf("\t|STUDENT_ID\t|FIRST_NAME %1$-15s\t|LAST_NAME %1$-15s\t|EMAIL %1$-50s\t|SEMESTER_YEAR %1$-15s\t|GPA\n\r", "");

			System.out.printf((index + 1) + ":\t|"
					+ student[index].getStudentId() + "\t|"
					+ student[index].getFirstName() + "%1$-20s\t|"
					+ student[index].getLastName() + "%1$-20s\t|"
					+ student[index].getEmail() + "%1$-30s\t|"
					+ student[index].getSemesterYear() + "%1$-20s\t|"
					+ student[index].getGpa(), "");
			System.out.println();
		}
		else
			System.out.println("Student with index #: " + studentId + " Not found!");
	}


	public void ensureCapacity(int largerCapacity){
		Student[] largerListBag;

		if(student.length < largerCapacity) {
			largerListBag = new Student[largerCapacity];
			for(int index = 0; index < largerListBag.length; index++) {
				largerListBag[index] = new Student();
			}

			System.arraycopy(student, 0, largerListBag, 0, numberOfStudents);

			student = largerListBag;
		}
	}

	public StudentListMgmtBag clone() {	
		StudentListMgmtBag newStudentList;

		try {
			newStudentList = (StudentListMgmtBag)super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException("This class does not implement Clonable");
		}

		newStudentList.student = student.clone();

		return newStudentList;
	}
}
