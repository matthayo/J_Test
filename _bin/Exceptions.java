import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Exceptions {
	public static void main(String[] args) {

		try {
			// Create a file object. Use the File class 
			File fileObj = new File("../FileIO/outFile.txt");

			// Write to file. Use the PrintWriter class
			PrintWriter output = new PrintWriter(fileObj);
			
			int[] arr = new int[10];
			int counter = 0;
			int temp;
			
			// Creating some random value to store in file
			while(counter < 10) {
				temp = (int)(Math.random() * 1000);
				if(temp < 300)
					continue;
				else
					arr[counter++] = temp; 
			}
			
			// Write to the file using PrintWriter output stream.
			for(int val : arr)
				output.println(val);
			
			// Close the output file object to release the file lock
			output.close();
				
			
			// Reading from file. Use the Scanner class
			Scanner input = new Scanner(fileObj);
			
			// Read from file using Scanner input stream.
			while(input.hasNext())
				System.out.println(input.nextInt());
			
			// Close the input file object to release the file lock.
			input.close();
			
		} catch (IOException ex) { // Handle Exception.
			 ex.printStackTrace();
//			System.out.println("ERROR TRACE: " + ex.toString());
		}
		
		System.out.println("END OF PROGRAM!");

	}
}
