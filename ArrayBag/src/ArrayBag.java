import java.util.Arrays;

public class ArrayBag<T> {

	// PROPERTIES
	private T[] data;
	private int manyItems;
	
	// CONSTRUCTORS
	@SuppressWarnings("unchecked")
	public ArrayBag() {
		int initialCapacity = 10;
		this.data = (T[]) new Object[initialCapacity];
		this.manyItems = 0;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayBag(int initialCapacity) {
		this.data = (T[]) new Object[initialCapacity];
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
	public void add(T element) {
		
		if(this.manyItems == this.data.length) {
			ensureCapacity((this.manyItems + 1) * 2);
		}
		
		this.data[this.manyItems] = element;
		this.manyItems++;
	}
	
	// Remove
	public void remove(T target) {
		for(int i = 0; i < this.manyItems; i++) {
			if (target == this.data[i]) {
				this.data[i] = this.data[this.manyItems - 1];
				this.manyItems--;
			}
		}
	}
	
	// Search
	public boolean search(T target) {
		boolean result = false;
		for(int i = 0; i < this.manyItems; i++) {
			if(target == this.data[i]) {
				return true;
			}
		}
		return result;
	}
	// Extend array capacity
	@SuppressWarnings("unchecked")
	public void ensureCapacity(int minCapacity) {
		T[] biggerArray;
		
		if(minCapacity > this.manyItems) {
			biggerArray = (T[]) new Object[minCapacity];
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
