
public class IntNode {
	
	private int data;
	private IntNode link;
	
	// Constructor
	public IntNode(int initialData, IntNode initialLink) {
		this.data = initialData;
		this.link = initialLink;
	}
	
	// METHODS
	// Getters & Setter
	public int getData() {
		return this.data;
	}
	
	public IntNode getLink() {
		return this.link;
	}
	
	public void setLink(IntNode link) {
		this.link = link;
	}
	
	// Add
	public void add(int item) {
		this.link = new IntNode(item, this.link);
	}
	
	// Remove
	public void remove() {
		this.link = this.link.link;
	}
	
	
	// Print list
	public String printList(IntNode head) {
		String result = "HEAD -> ";
		
		IntNode cursor = head;
		
		while(cursor != null) {
			result = result + cursor.data + " -> ";
			cursor = cursor.link;
		}
		
		return result + "NULL";
	}
}
