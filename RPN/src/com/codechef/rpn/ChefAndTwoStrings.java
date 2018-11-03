/**
 * 
 */
package com.codechef.rpn;

import java.util.Scanner;

/**
 * @author rahul kumar
 * 
 */
public class ChefAndTwoStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in = new Scanner(System.in);
		int noOfTestCases = -1;
		String str1 = null;
		String str2 = null;
		int maxDiff = -1;
		int minDiff = -1;
		noOfTestCases = in.nextInt();

		while (noOfTestCases > 0) {
			minDiff = 0;
			maxDiff = 0;

			str1 = in.next();
			str2 = in.next();

			for (int i = 0; i < str1.length(); i++) {
				if (str1.charAt(i) == '?' || str2.charAt(i) == '?')
					maxDiff++;
				else if (str1.charAt(i) != str2.charAt(i)) {
					minDiff++;
					maxDiff++;
				}
			}

			System.out.println(minDiff + " " + maxDiff);

			noOfTestCases--;
		}
		in.close();
	}

}
