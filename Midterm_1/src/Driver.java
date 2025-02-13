import java.util.Scanner;
public class Driver {
	public static void main (String[] args)
	{
		int number, i, oddSum = 0;
		Scanner input = new Scanner(System.in);

		System.out.print(" Please Enter any Number : ");
		number = input.nextInt();    

		for(i = 1; i <= number; i++)
		{
			if(i % 2 != 0)
			{
				oddSum = oddSum + i;
			}
		}
		System.out.println("\n The Sum of Odd Numbers up to " + number + "  =  " + oddSum);
	}
}