import java.util.Arrays;
import java.util.EmptyStackException;

@SuppressWarnings("unchecked")
public class ArrayStack {

	//PROPERTIES
	private int[] data;
	private int manyItems;
	
	// CONSTRUCTORS
	public ArrayStack() {
		final int INITIAL_VALUE = 10;
		this.data = new int[INITIAL_VALUE];
		this.manyItems = 0;
	}
	
	public ArrayStack(int initialCapacity) {
		if(initialCapacity < 0) {
			throw new IllegalArgumentException ("Initial Capacity should be a positive integer!");
		}
		this.data =  new int[initialCapacity];
		this.manyItems = 0;
	}
	// METHODS
	// Add items to stack
	public void push(int item) {
		if(this.manyItems == this.data.length) {
			ensureCapacity((this.manyItems * 2) + 1);
		}
		this.data[manyItems] = item;
		this.manyItems++;
		
	}
	
	// Remove items from stack
	public int pop() {
		if(this.manyItems == 0) {
			throw new EmptyStackException();
		}
		return this.data[--this.manyItems];
	}
	
	// Check item at the top of stack
	public int peek() {
		if(this.manyItems == 0) {
			throw new EmptyStackException();
		}
		return this.data[this.manyItems - 1];
	}
	
	// Check if stack is empty
	public boolean isEmpty() {
		return this.manyItems == 0;
	}
	
	// Check size of stack
	public int size() {
		return this.manyItems;
	}
	
	// Ensure there is capacity to store more items
	public void ensureCapacity(int newCapacity) {
		int[] biggerArray;
		
		if (data.length < newCapacity) {
			biggerArray = new int[newCapacity];
			biggerArray = Arrays.copyOf(this.data, newCapacity);
			this.data = biggerArray;
		}
	}
	
	// Get Capacity of the stack
	public int getCapacity() {
		return this.data.length;
	}
	
	// Display items in the stack
	public String toString() {
		String result = "{ ";
		
		for(int i = 0; i < this.manyItems; i++) {
			result = result + this.data[i] + ", ";
		}
		result = result + "}";
		
		return result;
	}
}
















									












