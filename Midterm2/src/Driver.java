import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Driver {

	public static void main (String args[]) {

		//ask for file name from user
		System.out.print("Enter file name: ");
		//User input
		File file = new File(new Scanner(System.in).next());

		//check if the file is present or not
		if (!file.exists()) {
			System.out.println(file + " doesn't exist");
			System.exit(1);
		}
		String buffer = "";
		int[] letterCount = new int[26];
		//try and catch method
		try (Scanner input = new Scanner(file)) {

			while (input.hasNext()) {
				buffer = input.nextLine();
				for (char ch : buffer.toCharArray()) {
					// change all characters to uppercase
					ch = Character.toUpperCase(ch);
					//check each characters
					if (isLetter(ch)) {
						letterCount[ch - 'A']++;
					}
				}
			}
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
		//print the occurrence in output
		for (int i = 0; i < letterCount.length; i++) {
			System.out.println((char)(i + 'A') + " occurrence = " + letterCount[i]);
		}
	}
	//method to check if the input is a letter or not
	private static boolean isLetter(char ch) {
		return (ch >= 'A' && ch <= 'Z'); // return true

	}
}


