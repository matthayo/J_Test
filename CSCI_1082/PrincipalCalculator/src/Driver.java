import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * A detailed description of the program in the Driver class.
 * 
 * @author     	Your Official Name
 * @contact    	youremail@century.edu
 * @since    	Date assignment was assigned
 * 
 * Institution: Century College
 * Course:     	CSCI 2082-<include section number>
 * 
 * Professor:   Mathew Nyamagwa
 *
 */
public class Driver {
	public static void main(String[] args) {
		// Variable declaration
		double futureValue;
		double principal;
		double rate;
		int time, compounding = 4;
		
		// Input
		Scanner input = new Scanner(System.in);
		
		System.out.println("This program calculates Compound Interest."
				+ "\nPlease provide the following information:");
		
		System.out.print("Amount to deposit: ");
		principal = input.nextDouble();
		
		System.out.print("Annual interest rate (in percentage): ");
		rate = input.nextDouble() / 100;
		
		System.out.print("Time in years: ");
		time = input.nextInt();
		
		// Computations
		futureValue = principal * Math.pow((1 + (rate/compounding)), (compounding * time));
		
		// Output
		DecimalFormat decimalFormat = new DecimalFormat("#,###.00");
		System.out.println();
		
		String sPrincipal = "$" + decimalFormat.format(principal);
		System.out.printf("Principal amount: %12s\n", sPrincipal);
		
		int iRate = (int)(rate * 100);
		System.out.printf("Interest rate: %14d%s\n", iRate, "%");
		
		System.out.printf("Time in years: %15d\n", time);
		
		String sFutureValue = "$" + decimalFormat.format(futureValue);
		System.out.printf("Future value: %16s\n", sFutureValue);
		
		input.close();
	}
}
