import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
        System.out.println("How many integers will be added:");
        int num = input.nextInt();
        int list[] = new int[num];
        for (int i = 0; i < list.length; i++) {
            System.out.println("Enter an integer:");
            list[i] = input.nextInt();
        }
        int sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum += list[i];
        }
        System.out.println();
        System.out.println("The sum is " + sum);
	}
}
