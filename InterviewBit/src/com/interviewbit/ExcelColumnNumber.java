/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class ExcelColumnNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(titleToNumber("AAA"));

	}

	public static int titleToNumber(String a) {

		int result = 0;
		char[] chars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		char[] input = a.toCharArray();
		char current;

		for (int i = input.length; i > 0; i--) {
			current = input[i - 1];

			for (int j = 0; j < chars.length; j++) {

				if (current == chars[j]) {
					result = (int) (result + (j + 1) * Math.pow(26.0, input.length - i));
				}
			}

		}
		return result;
	}

}
