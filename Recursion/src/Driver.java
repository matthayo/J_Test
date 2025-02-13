import java.util.Scanner;

public class Driver {

	static int fact(int n) {
		if (n == 1 )
			return 1;
		return n * fact(n - 1);
	}
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		System.out.print("Enter an integer to calculate its Factorial : ");
		int n = input.nextInt();
		
		System.out.println();
		System.out.println("The Factorial of " + n + "! = " + fact(n));
		
		input.close();
	}
}
