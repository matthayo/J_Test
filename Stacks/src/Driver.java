import java.util.EmptyStackException;

public class Driver {

	public static void main(String[] args) {

		LinkedList intStack = new LinkedList();

		for(int i = 0; i < 10; i++) {
			intStack.addAtEnd((int)(Math.random() * 100));
		}

	}
}
