
public class IntNode {
	// PROPERTIES
	private int data;
	private IntNode link;
	
	// CONSTRUCTOR
	public IntNode(int initialValue, IntNode initialLink) {
		this.data = initialValue;
		this.link = initialLink;
	}
	
	// METHODS
	// Getter and setters
	public int getData() {
		return this.data;
	}
	
	public void setData(int value) {
		this.data = value;
	}
	
	public IntNode getLink() {
		return this.link;
	}
	
	public void setLink(IntNode link) {
		this.link = link;
	}
	
	// Add node
	public void addNodeAfter(int value) {
		this.link = new IntNode(value, this.link);
	}
	
	// Remove node
	public void removeNodeAfter() {
		this.link = this.link.link;
	}

	// **************
	
	// Methods that work with the entire list and not just a single node.
	
	// Search list for a target value
	public static IntNode listSearch(IntNode head, int target) {
		IntNode cursor;
		
		for(cursor = head; cursor != null; cursor = cursor.link) {
			if (target == cursor.data) {
				return cursor;
			}
		}
		return null;
	}
	
	// Find position on a node with value "target" 
	
	
	// Get length of Linked list
	public static int listLength(IntNode head) {
		IntNode cursor;
		int result = 0;
		
		for(cursor = head; cursor != null; cursor = cursor.link) {
			result++;
		}
		
		return result;
	}
	
	// Print all values in the list
	public static String printList(IntNode head) {
		IntNode cursor;
		
		String list = "Head -> | ";
		
		for(cursor = head; cursor != null; cursor = cursor.link) {
			list = list + cursor.data + " | -> | ";
		}
		return list + "NULL";
	}

	public static int listToInt(IntNode list) {

	     int powOfTen = 1;

	     int sum = 0 ;

	     for (IntNode cursor = list; cursor != null; cursor = cursor.getLink()) {

	          sum += (cursor.getData() * powOfTen);

	           powOfTen *= 10;

	     }

	      return sum;

	}
}
