import java.util.Scanner;

public class Driver {
	 public static void main(String[] args) {
	       int[] numbers = new int[5];
	       
	       readData(numbers);
	       
	       System.out.println("Integers in the order they were read:");
	       displayInOrder(numbers);
	       
	       System.out.println("Integers in reverse order:");
	       displayInReverseOrder(numbers);
	   }
	   
	   public static void readData(int[] array) {
	       Scanner scanner = new Scanner(System.in);
	       
	       System.out.println("Enter five integer values:");
	       for (int i = 0; i < array.length; i++) {
	           array[i] = scanner.nextInt();
	       }
	   }
	   
	   public static void displayInOrder(int[] array) {
	       for (int number : array) {
	           System.out.print(number + " ");
	       }
	       System.out.println();
	   }
	   
	   public static void displayInReverseOrder(int[] array) {
	       for (int i = array.length - 1; i >= 0; i--) {
	           System.out.print(array[i] + " ");
	       }
	       System.out.println();
	   }
}