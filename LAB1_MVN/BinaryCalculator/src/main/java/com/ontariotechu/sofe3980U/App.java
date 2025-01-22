package com.ontariotechu.sofe3980U;

import java.util.Scanner;

/**
 * Main application for Binary operations.
 *
 */
public class App {
	/**
	 * Main program: The entry point of the program. The local time will be printed first,
	 * then it will create two binary variables, perform operations (Add, OR, AND, Multiply),
	 * and print the results.
	 *
	 * @param args: not used
	 */
	public static void main(String[] args) {

		// User input for binary numbers
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter the first binary number: ");
		String input1 = scanner.nextLine();
		System.out.print("Enter the second binary number: ");
		String input2 = scanner.nextLine();

		// Create Binary objects
		Binary binary1 = new Binary(input1);
		System.out.println("First binary number is: " + binary1.getValue());
		Binary binary2 = new Binary(input2);
		System.out.println("Second binary number is: " + binary2.getValue());

		// Perform addition
		Binary sum = Binary.add(binary1, binary2);
		System.out.println("Their summation is: " + sum.getValue());

		// Perform OR operation
		Binary orResult = Binary.OR(binary1, binary2);
		System.out.println("The OR result is: " + orResult.getValue());

		// Perform AND operation
		Binary andResult = Binary.AND(binary1, binary2);
		System.out.println("The AND result is: " + andResult.getValue());

		// Perform multiplication
		Binary multiplyResult = Binary.Multiply(binary1, binary2);
		System.out.println("The multiplication result is: " + multiplyResult.getValue());

		// Close the scanner
		scanner.close();
	}
}
