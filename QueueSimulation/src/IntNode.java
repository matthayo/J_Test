
public class IntNode {

	// PROPERTIES
	private int data;
	private IntNode link;

	// CONSTRUCTOR
	public IntNode(int initialData, IntNode initialLink) {
		this.data = initialData;
		this.link = initialLink;
	}

	// METHODS
	// Getters
	public int getData() {
		return this.data;
	}

	public IntNode getLink() {
		return this.link;
	}

	// Adding a node
	public void addNodeAfter(int item) {
		this.link = new IntNode(item, this.link);
	}

	// Remove a node
	public void removeNodeAfter() {
		this.link = this.link.link;
	}

	// Find position on a node in the list
	public static IntNode listPosition(IntNode head, int position) {

		IntNode cursor; 
		if(position <= 0) {
			throw new IllegalArgumentException("Position is not positive!");
		}

		cursor = head;

		for(int i = 1; (i < position) && (cursor != null); i++) {
			cursor = cursor.link;
		}

		return cursor;
	}
	// Search a value store in the list
	public static IntNode listSearch(IntNode head, int target) {

		IntNode cursor;

		for (cursor = head; cursor != null; cursor = cursor.link) {
			if (target == cursor.data) {
				return cursor;
			}
		}
		return null;
	}
	
	// Length of the list
	public static int listLength(IntNode head)
	{
		IntNode cursor;
		int answer;

		answer = 0;
		for (cursor = head; cursor != null; cursor = cursor.link)
			answer++;

		return answer;
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
}
