import java.text.DecimalFormat;
import java.util.Scanner;

public class Driver {
   public static void main(String[] args) {
      double amountDeposit;
      double ratePercentage;
      int rateYears;
      double futureMoney;
      int compounding = 4;

      Scanner input = new Scanner(System.in);

      System.out.println("This program calculates Compound Interest. "
      + "Please provide the following information:");

      System.out.print("Amount to deposit: ");

      amountDeposit = input.nextDouble();

      System.out.print("Annual interest rate (in percentages): ");

      ratePercentage = input.nextDouble() / 100;

      System.out.print("Time in years: ");

      rateYears = input.nextInt();
      futureMoney = amountDeposit * Math.pow((1+ (ratePercentage/compounding)),(compounding * rateYears));

      DecimalFormat decimalFormat = new DecimalFormat("#,###.00");

      System.out.println();
      System.out.printf("Principal amount %10s \n", decimalFormat.format(amountDeposit));
      System.out.printf("Interest rate %12.1f%s \n", (ratePercentage*100),"%");
      System.out.printf("Time in years %13d \n", rateYears);
      System.out.printf("Future value %14s \n", decimalFormat.format(futureMoney));

   }

}