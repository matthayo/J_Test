import java.util.EmptyStackException;

public class LinkedStack  {
	// PROPERTIES
	private IntNode top;
	
	// CONSTRUCTOR
	public LinkedStack() {
		this.top = null;
	}
	
	//METHODS
	// push()
	public void push(int item) {
		top = new IntNode(item, top);
	}
	
	// pop()
	public int pop() {
		int result;
		if(this.top == null) {
			throw new EmptyStackException();
		}
		result = this.top.getData();
		top = top.getLink();
		return result;
	}
	
	// peek()
	public int peek() {
		if(this.top == null) {
			throw new EmptyStackException();
		}
		return this.top.getData();
	}
	
	// isEmpty()
	public boolean isEmpty() {
		return (this.top == null);
	}
	
	// size()
	public int size() {
		return IntNode.listLength(top);
	}
	
	// Display items displayItems
	public String toString() {
		IntNode cursor;
		String result = "Top => ";
		for(cursor = this.top; cursor != null; cursor = cursor.getLink()) {
			result += cursor.getData() + " => ";
		}
		
		return result + " NULL";
	}
}
















