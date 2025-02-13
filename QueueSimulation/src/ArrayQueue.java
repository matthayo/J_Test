import java.util.Arrays;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class ArrayQueue<T>{
	// PROPERTIES
	private T[] data;
	private int front;
	private int rear;
	private int manyItems;

	// CONSTRUTORS
	// Empty Constructor
	public ArrayQueue() {
		final int INITIAL_VALUE = 10;
		this.data = (T[])new Object[INITIAL_VALUE];
		this.manyItems = 0;
	}

	public ArrayQueue(int initValue) {
		this.data = (T[])new Object[initValue];
		this.manyItems = 0;
	}

	//METHODS

	// Add item to queue
	public void add(T item) {
		if(this.manyItems == data.length) {
			ensureCapacity((this.manyItems * 2) + 1);
		}

		if(this.manyItems == 0) {
			this.front = 0;
			this.rear = 0;
		} else {
			rear = nextIndex(rear);
		}

		this.data[rear] = item;
		this.manyItems++;

	}

	private int nextIndex(int i) {
		if (++i == data.length) {
			return 0;
		} else {
			return i;
		}
	}

	// Remove item from queue
	public T remove() {
		T result;

		if(this.manyItems == 0)
			throw new NoSuchElementException("Queue underflow");

		result = data[front];
		front = nextIndex(front);
		this.manyItems--;
		return result;
	}

	// Double the size of ArrayBag 
	private void ensureCapacity(int minCapacity) {
		T[] biggerArray;

		if (data.length < minCapacity) {
			biggerArray = (T[])new Object[minCapacity];
			biggerArray = Arrays.copyOf(this.data, minCapacity);
			this.data = biggerArray;
		}
	}

	public int getCapacity() {
		return this.data.length;
	}

	public int size() {
		return this.manyItems;
	}

	public void trimToSize() {
		T[] trimmedArray;
		int n1, n2;

		if(this.data.length == this.manyItems)
			return;
		else if (this.manyItems == 0)
			this.data = (T[]) new Object[this.manyItems];
		else if (front <= rear) {
			trimmedArray = (T[])new Object[this.manyItems];
			trimmedArray = Arrays.copyOf(this.data, this.manyItems);
			this.data = trimmedArray;
		} else {
			trimmedArray =  (T[]) new Object[this.manyItems];
			n1 = this.data.length - front;
			n2 = this.rear + 1;
			System.arraycopy(this.data, front, trimmedArray, 0, n1);
			System.arraycopy(this.data, 0, trimmedArray, n1, n2);
			this.front = 0;
			this.rear = this.manyItems - 1;
			this.data = trimmedArray;
		}
	}

	// Display items in the stack
	public String toString() {
		String result = "{ ";
		
		if (this.front <= this.rear) {
			for(int i = this.front; i <= this.rear; i++) {
				result = result + this.data[i] + ", ";
			}
		} else {
			// Print Queue from front to rear.
//			for(int i = this.front; i < this.data.length; i++) {
//				result = result + this.data[i] + ", ";
//			}
//			for(int i = 0; i <= this.rear; i++) {
//				result = result + this.data[i] + ", ";
//			}
			
			// Print Queues as is ie. rear has circled around
			for(int i = 0; i < this.data.length; i++)
				result = result + this.data[i] + ", ";
		}
		
		result = result + "}";

		return result;
	}
}

