
public class StudentCollection {
	
	// PROPERTY
	Student[] student = new Student[5];
	String[] names = {"Ann", "Brenda", "Charles", "Don", "Eddy"};
	
	// CONSTRUCTOR
	public StudentCollection() {
		for(int i = 0; i < 5; i++)
			student[i] = new Student(names[i], (int)(Math.random() * 100));
	}

	@Override
	public String toString() {
		String result = "Student Collection \n";
		int i = 0;
		while( i < student.length && student[i] != null) {
			result += "\tstudent " + (i+1) + " ==> " + student[i].toString();
			i++;
		}
			
		return result;
	}
	
}
