/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class TrailingZeroes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(trailingZeroes(5));

	}

	public static int trailingZeroes(int a) {

		int count = 0;

		for (int i = 5; a / i >= 1; i *= 5) {

			count += a / i;
		}

		return count;
	}

}
