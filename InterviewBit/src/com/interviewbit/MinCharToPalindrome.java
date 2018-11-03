/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class MinCharToPalindrome {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str = "BC";
		System.out.println(solve(str));
	}

	public static int solve(String A) {

		char[] input = A.toCharArray();
		char[] inputrev = new char[A.length()];
		boolean insideLoop = false;

		boolean flag = true;
		int count = 0;

		for (int i = input.length; i > 0; i--) {
			inputrev[inputrev.length - i] = input[i - 1];
		}

		// Sliding window approach
		while (true) {

			insideLoop = false;
			flag = true;
			for (int i = 0; i < input.length - count; i++) {

				insideLoop = true;
				if (input[i] != inputrev[i + count]) {
					flag = false;
					break;
				}

			}

			if (flag)
				break;

			if (!insideLoop)
				break;

			count++;
		}

		return count;
	}

}
