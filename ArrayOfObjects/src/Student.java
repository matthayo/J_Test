
public class Student {
	private String name;
	private static int id = 0;
	
	public Student() {
		this.name = "No Name";
		id = id++;
	}
	
	public Student(String name, int id) {
		super();
		this.name = name;
		id = id++;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Student [name=" + name + ", id=" + id + "]";
	}
	
	
}
