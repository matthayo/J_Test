import java.util.Scanner;

public class Driver {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);

       
       System.out.print(" Please enter an integer: ");
       int N = scanner.nextInt();

       int sum = 0;

       
       for (int i = 1; i <= N; i++) {
           
           if (i % 2 != 0) {
               sum += i;
           }
       }

       
       System.out.println("The sum of odd integers from 1 to " + N + " is: " + sum);

       scanner.close();
   }
}