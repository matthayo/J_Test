/**
 * Description: This program converts temperature from 
 * 				Fahrenheits to Celcius.
 * 
 * @author Mathew Nyamagwa
 * @since 09/07/2023
 * 
 * Institution: Century College
 * Course: 		CSCI 1082-01
 * 
 * Instructor: Mathew Nyamagwa
 *
 */

import java.util.*;

public class Driver {
	public static void main(String[] args) {
		
		// Variables and Constants
		final double FAHRENHEIT_100 = 100.0;
		final double FAHRENHEIT_180 = 180.0;
		final int FAHRENHEIT_32 = 32;
		
		double fahrenheit, celcius;
		
		// INPUT
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter the temperature in Fahrenheit: ");
		fahrenheit = input.nextDouble();
		
		
		// COMPUTATION
		
		celcius = (FAHRENHEIT_100 / FAHRENHEIT_180) * (fahrenheit - FAHRENHEIT_32);
		
		
		// OUTPUT
		
		System.out.printf("Fahrenheit temperature is: %14.1f\n", fahrenheit);
		System.out.printf("Celcius temperature is: %17.1f\n", celcius);
		
	}
}
