
public class Customer {
	// PROPERTIES
	private String customerId;
	private static int idCounter = 0;
	
	// CONSTRUCTOR
	public Customer() {
		// Creating a user id with padded 0's e.g., 00000003, 00000082 etc.
		this.customerId = String.format("%09d", ++idCounter);
	}
	
	public String getId() {
		return this.customerId;
	}
	
	public String toString() {
		return this.customerId;
	}
}
