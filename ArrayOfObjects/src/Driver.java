
public class Driver {
	
	public static void main (String[] args) {
		
		Course course01 = new Course();
		Course course02 = new Course("CSCI 1082", 30);
		
		System.out.println(course02.toString());
	}
}
