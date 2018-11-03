/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;

/**
 * @author rahul
 *
 */
public class FizzBuzz {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int N = -1;

		System.out.println(fizzBuzz(N));

	}

	public static ArrayList<String> fizzBuzz(int A) {

		ArrayList<String> result = new ArrayList<String>();

		for (int i = 1; i <= A; i++) {

			if (i % 15 == 0) {
				result.add(i - 1, "FizzBuzz");
			} else if (i % 3 == 0) {
				result.add(i - 1, "Fizz");

			} else if (i % 5 == 0) {
				result.add(i - 1, "Buzz");

			} else {
				result.add(i - 1, String.valueOf(i));
			}

		}
		return result;

	}

}
