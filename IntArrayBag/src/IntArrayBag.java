import java.util.Arrays;

public class IntArrayBag {

	// PROPERTIES
	private int[] data;
	private int manyItems;
	
	// CONSTRUCTORS
	public IntArrayBag() {
		int initialCapacity = 10;
		this.data = new int[initialCapacity];
		this.manyItems = 0;
	}
	
	public IntArrayBag(int initialCapacity) {
		this.data = new int[initialCapacity];
		this.manyItems = 0;
	}
	
	// METHODS
	
	// Getter
	public int getNumberOfItems() {
		return this.manyItems;
	}
	
	public int getCapacity() {
		return this.data.length;
	}
	
	// Add
	public void add(int element) {
		
		if(this.manyItems == this.data.length) {
			ensureCapacity((this.manyItems + 1) * 2);
		}
		
		this.data[this.manyItems] = element;
		this.manyItems++;
	}
	
	// Remove
	public void remove(int target) {
		for(int i = 0; i < this.manyItems; i++) {
			if (target == this.data[i]) {
				this.data[i] = this.data[this.manyItems - 1];
				this.manyItems--;
			}
		}
	}
	
	// Search
	public boolean search(int target) {
		boolean result = false;
		for(int i = 0; i < this.manyItems; i++) {
			if(target == this.data[i]) {
				return true;
			}
		}
		return result;
	}
	// Extend array capacity
	public void ensureCapacity(int minCapacity) {
		int[] biggerArray;
		
		if(minCapacity > this.manyItems) {
			biggerArray = new int[minCapacity];
			biggerArray = Arrays.copyOf(this.data, minCapacity);
			this.data = biggerArray;
		}
	}
	
	
	// print 
	public String toString() {
		String result = "{ ";
		
		for(int i = 0; i < this.manyItems; i++) {
			result = result + this.data[i] + ", ";
		}
		
		result = result + "}";
		
		return result;
	}
}
