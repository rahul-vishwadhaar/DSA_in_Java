/**
 * 
 */
package com.codechef.palindrome;

import java.util.Scanner;

public class Palindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int noOfTestCases = -1;
		int inputNumber = 0;
		Scanner in = new Scanner(System.in);
		String input;
		String reverseInput;
		noOfTestCases = in.nextInt();

		while (noOfTestCases > 0) {
			inputNumber = 0;
			inputNumber = in.nextInt();
			input = String.valueOf(inputNumber);
			reverseInput = new StringBuffer(input).reverse().toString();

			if (input.equalsIgnoreCase(reverseInput))
				System.out.println("wins");
			else
				System.out.println("losses");
			noOfTestCases--;
		}
		in.close();

	}

}
