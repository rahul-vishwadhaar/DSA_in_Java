/**
 * 
 */
package com.dp.algorithms;

import java.util.HashSet;

/**
 * @author rahul
 *
 */
public class WaysToDecode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String input = "1111";

		System.out.println(numDecodings(input));

	}

	public static int numDecodings(String a) {

		int count = 0;
		int num1 = 0;
		int num2 = 0;
		int charIndex = 0;
		boolean flag = true;

		HashSet<Integer> set = new HashSet<Integer>();

		num1 = a.charAt(0) - 48;

		if (num1 == 0)
			return 0;

		if (a.length() == 1)
			return 1;

		for (int i = 1; i < a.length(); i++) {

			num1 = a.charAt(i - 1) - 48;
			num2 = a.charAt(i) - 48;

			if ((num2 == 0) && (num1 > 2)) {
				flag = false;
				break;
			} else if ((num2 == 0) && (num1 == 0)) {
				flag = false;
				break;
			} else {
				if (num2 == 0) {
					set.add(i - 1);
				}
			}

		}

		if (!flag) {
			return count;
		}

		count++;

		for (int i = 1; i < a.length(); i++) {

			num1 = a.charAt(i - 1) - 48;
			num2 = a.charAt(i) - 48;

			charIndex = (num1 * 10 + num2);

			if (charIndex % 10 == 0) {
				continue;
			}

			if (set.contains(i)) {
				continue;
			}

			if (num1 == 0) {
				continue;
			}

			if ((charIndex <= 26) && (charIndex > 0)) {
				count++;
			}

		}

		return count;
	}

}
