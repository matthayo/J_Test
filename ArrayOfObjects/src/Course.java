
public class Course {
	private String courseName;
	private Student[] student;
	
	public Course () {
		int classSize = 10;
		this.student = new Student[classSize];
		
		this.courseName = "Not Declare";
		
		for(int i = 0; i < classSize; i++)
			student[i] = new Student();
	}
	
	public Course(String name, int classSize) {
		this.courseName = name;
		this.student = new Student[classSize];
		
		for(int i = 0; i < classSize; i++)
			this.student[i] = new Student();
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public Student[] getStudent() {
		return student;
	}

	public String toString() {
		String result = this.courseName + "\n";
		
		for(int i = 0; i < student.length; i++) {
			if(student[i] != null) {
				result += ("\t" + this.student[i].toString() + "\n");
			}
		}
		
		return result;
	}
	
	
	
}
