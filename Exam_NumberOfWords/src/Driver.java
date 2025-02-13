import java.io.File;

import java.io.IOException;

import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {

		File fileObj = new File("file.txt");

		try {

			readFile(fileObj);

		} catch (IOException ex) {

			System.out.println("An error has occurred. Please try again");

		}

	}

	public static void readFile(File fileObj) throws IOException {

		Scanner input = new Scanner(fileObj);

		int count = 0;

		String line;

		String[] words; //

		while (input.hasNext()) {

			line = input.nextLine();

			words = line.split(" ");

			for (int i = 0; i < words.length; i++) {

				String word = words[i];

				System.out.println(word);

				count++;

			}

		}

		input.close();

		System.out.println("This file has " + count + " words.");

	}

}