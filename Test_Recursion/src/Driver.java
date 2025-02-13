import java.text.DecimalFormat;

public class Driver {
	public static void main(String[] args) {
		
		long n = 25;
		long result = fact(n);
		
		DecimalFormat df = new DecimalFormat("#,###");
		
		System.out.println("Factorial of " + n + " = " + df.format(result));
		
	}
	
	public static long fact(long n) {
		if (n <= 0)
			return 1;
		else
			return n * fact(n - 1);
	}
}
