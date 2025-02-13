import java.util.Scanner;

public class Driver {
	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		// WIDENING 
//		System.out.print("Enter an integer: ");
//		int num = input.nextInt();
		
//		Integer iNum =  num;
		
//		Object iNum2 = iNum;
		
//		String str1 = iNum2.toString();
		
//		System.out.println("Integer: " + iNum);
//		System.out.println("String: " + str1.charAt(2));
		
		//NARROWING
		System.out.print("Enter an String: ");
		String str = input.next();
		
		Integer iNum = null;
		
		int num = iNum.valueOf(str);
		
		System.out.println("String output: " + str);
		System.out.println("Integer output: " + num);
		
	}

}
