
public class IntLinkedQueue {

	// PROPERTIES
	private IntNode front;
	private IntNode rear;
	private int manyNodes;
	
	
	// CONSTRUCTOR
	public IntLinkedQueue() {
		this.front = null;
		this.rear = null;
		this.manyNodes = 0;
	}
	
	
	// METHODS
	
	// Add
	public void add(int item) {
		if(this.manyNodes == 0) {
			this.front = new IntNode(item, null);
			this.rear = this.front;
		} else {
			this.rear.addNodeAfter(item);
			this.rear = this.rear.getLink();
		}
		this.manyNodes++;
	}
	
	public int remove() {
		int result;
		
		if(this.manyNodes == 0) {
			System.out.println("Queue is empty");
			return -1;
		}
		
		result = this.front.getData();
		this.front = this.front.getLink();
		this.manyNodes--;
		
		if(this.manyNodes ==  0)
			this.rear = null;
		
		return result;
	}
	
	public boolean isEmpty(){
		return (this.manyNodes == 0);
	}
	
	public String toString() {
		IntNode cursor;
		
		String list = "Front -> | ";
		
		for(cursor = this.front; cursor != null; cursor = cursor.getLink()) {
			list = list + cursor.getData() + " | -> | ";
		}
		return list + "NULL";
	}
}
