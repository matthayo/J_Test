import java.util.EmptyStackException;

public class Driver {

	public static void main(String[] args) {

		ArrayStack intStack= new ArrayStack();
//		LinkedStack intStack = new LinkedStack();

		for(int i = 0; i < 10; i++) {
			intStack.push((int)(Math.random() * 100));
		}
		
		System.out.println("\n\n********** PUSH *************\n");
		System.out.println("ArrayBag: \t" + intStack.toString());
		System.out.println("Size: \t\t" + intStack.size());
		System.out.println("Capacity: \t" + intStack.getCapacity());

		// ********** POP *************
		System.out.println("\n\n********** POP *************\n");
		try {	
			System.out.println("Popped: \t" + intStack.pop());
		} catch (EmptyStackException ex) {
			System.out.println(ex);
		} catch (IllegalArgumentException ex) {
			System.out.println(ex);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println("ArrayBag: \t" + intStack.toString());
		System.out.println("Size: \t\t" + intStack.size());
		System.out.println("Capacity: \t" + intStack.getCapacity());

		// ********** PEEK *************
		System.out.println("\n\n********** PEEK *************\n");
		try {
			System.out.println("Peeked: \t" + intStack.peek());
		} catch (EmptyStackException ex) {
			System.out.println(ex);
		} catch (IllegalArgumentException ex) {
			System.out.println(ex);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println("ArrayBag: \t" + intStack.toString());
		System.out.println("Size: \t\t" + intStack.size());
		System.out.println("Capacity: \t" + intStack.getCapacity());

		// ********** POP & PUSH *************
		System.out.println("\n\n********** POP & PUSH *************\n");
		try {
			System.out.println("Popped: \t" + intStack.pop());
		} catch (EmptyStackException ex) {
			System.out.println(ex);
		} catch (IllegalArgumentException ex) {
			System.out.println(ex);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println("ArrayBag: \t" + intStack.toString());
		System.out.println("Size: \t\t" + intStack.size());
		System.out.println("Capacity: \t" + intStack.getCapacity());
		intStack.push(988);
		System.out.println("ArrayBag: \t" + intStack.toString());
		System.out.println("Size: \t\t" + intStack.size());
		System.out.println("Capacity: \t" + intStack.getCapacity());

		// ********** POP FROM EMPTY STACK *************
		System.out.println("\n\n********** POP FROM EMPTY STACK *************\n");
		System.out.println("ArrayBag: \t" + intStack.toString());
		int temp = intStack.size();
		try {
			for(int i = 0; i < temp; i++) {
				System.out.println("Popped: \t" + intStack.pop());
			}
			System.out.println("Popped: \t" + intStack.pop());
		} catch (EmptyStackException ex) {
			System.out.println(ex);
		} catch (IllegalArgumentException ex) {
			System.out.println(ex);
		} catch (Exception ex) {
			System.out.println(ex);
		}
		System.out.println("ArrayBag: \t" + intStack.toString());
		System.out.println("Size: \t\t" + intStack.size());
		System.out.println("Capacity: \t" + intStack.getCapacity());
	}
}
