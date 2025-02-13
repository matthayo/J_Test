import java.util.*;

public class Driver {

	final static int MAX = 20;
	public static void main(String[] args) {
		int[] numbers = generateRandNumbers();

		for(int i = 0; i < MAX; i++)
			System.out.print(numbers[i] + ", ");
		System.out.println();
		
		int index = guesses(numbers);
		
		display(numbers, index);
	}
	
	public static int guesses(int[] numbers) {
		
		int index = -1;
		
		Scanner input = new Scanner(System.in);
		String response = "n";

		int upper = MAX - 1;
		int lower = 0;
		int mid = (int)((upper + lower) / 2);
		
		System.out.println();
		System.out.println("Choose a random number between 0 and 100.");
		System.out.println();
		System.out.println("Enter \"Y\" for Yes or \"N\" for No to the following questions.");

		while(upper > lower) {
			System.out.println("============");
			
			System.out.print("Is your number bigger than " + numbers[mid] + ": ");
			response = input.nextLine();

			if(response.equalsIgnoreCase("y")) {
				lower = mid + 1;
			} else {
				upper = mid;
			}
			
			mid = search(numbers, lower, upper);
			
			System.out.print("Is your number = " + numbers[mid] + ": ");
			response = input.nextLine();
			
			if(response.equalsIgnoreCase("y")) {
				index = mid;
				break;
			}
		}
		
		input.close();
		
		return index;
		
	}

	public static int[] generateRandNumbers() {
		int[] numbers = new int[MAX];

		for(int i = 0; i < MAX; i++) {
			numbers[i] = (int)(Math.random() * 100);
		}
		Arrays.sort(numbers);
		return numbers;		
	}

	public static int search(int[] numbers, int lower, int upper) {
		if(upper < lower)
			return -1;
		else 
			return (int)((upper + lower) / 2);
	}
	
	public static void display(int[] numbers, int index) {
		System.out.println("\n===============================================================================\n");
		
		if(index != -1)
			System.out.println("GREAT! Your number was found at position: " + (index + 1) + ".");
		else
			System.out.println("SORRY! Your number is not in the collection.");
		
		System.out.println("\n===============================================================================\n");
		
		System.out.println("Here is the Collection: ");
		
		for(int i = 0; i < MAX; i++)
			System.out.print(numbers[i] + ", ");
	}
}
