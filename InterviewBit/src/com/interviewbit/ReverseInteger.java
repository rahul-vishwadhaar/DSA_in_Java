/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class ReverseInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = Integer.MIN_VALUE;

		System.out.println(reverse(a));
	}

	public static int reverse(int a) {

		long result = 0;
		boolean isNegative = false;

		if (a < 0) {
			isNegative = true;
			a = Math.abs(a);
		}

		while (a > 0) {

			result = result * 10 + a % 10;
			a = a / 10;
		}

		if (result > Integer.MAX_VALUE)
			return 0;

		if (isNegative)
			result = result * (-1);

		if (result < Integer.MIN_VALUE)
			return 0;

		return (int) result;

	}

}
