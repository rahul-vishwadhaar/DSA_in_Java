/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class PalindromicString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str = "race a car";
		System.out.println(isPalindrome(str));
	}

	public static int isPalindrome(String a) {

		char[] input = a.toLowerCase().toCharArray();
		char[] newInput = new char[a.length()];
		int index = 0;

		for (int i = 0; i < input.length; i++) {

			if (Character.isLetter(input[i]) || Character.isDigit(input[i])) {
				newInput[index] = input[i];
				index++;
			}
		}

		for (int i = 0; i < input.length; i++) {
			if (Character.isLetter(input[i])) {
				if (newInput[--index] != input[i])
					return 0;
			}
		}

		return 1;
	}
}
