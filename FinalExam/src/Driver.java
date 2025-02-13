import java.io.*;
import java.util.Scanner;
public class Driver {
	public static void main(String[] args) {
		int[] numbers = new int[5];
		numberInput(numbers);
		orderPrint(numbers);
		reverseOrderPrint(numbers);
	}

	static int[] numberInput(int[] n) {
		Scanner scan = new Scanner(System.in);
		for(int i = 0; i < 5; i++) {
			n[i] = scan.nextInt();   
		}
		scan.close();
		return n;
	}

	static void orderPrint(int[] n) {
		for(int i = 0; i < n.length; i++) {
			System.out.print(n[i]);   
		}
	}

	static void reverseOrderPrint(int[] n) {
		for(int i = 1; i <= n.length; i++) {
			System.out.print(n[n.length - i]);   
		}
	}
}
