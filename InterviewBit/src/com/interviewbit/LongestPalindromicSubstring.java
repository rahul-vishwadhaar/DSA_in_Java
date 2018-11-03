/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class LongestPalindromicSubstring {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String a = "abcddcab";

		System.out.println(longestPalindrome(a));
	}

	public static String longestPalindrome(String a) {

		char[] input = a.toCharArray();
		int index = 0;
		int backI = 0;
		int frwdI = 0;

		boolean flag = true;

		while (index < input.length) {

			flag = true;
			backI = input.length - index - 1;

			for (frwdI = 0; frwdI < input.length - index; frwdI++) {

				if (input[frwdI] == input[backI]) {

				} else {
					flag = false;
					break;
				}

				backI--;

			}

			if (flag == true) {
				break;
			}
			index++;
		}

		if (index == a.length()-1)
			return "";
		return a.substring(index, input.length - index - 1);
	}

}
