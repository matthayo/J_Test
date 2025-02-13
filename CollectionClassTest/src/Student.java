
public class Student {
	// PROPERTIES
		String name;
		int id;
		
		public Student(String name, int id) {
			super();
			this.name = name;
			this.id = id;
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
			return String.format("%s: %-10s %-3s: %2d\n", "Name", this.name, "ID", this.id);
		}
}
