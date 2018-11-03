/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class BinaryGap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] input = { 1,0,1,0,1,0,1};

		System.out.println(getBinaryGaps(input));
	}

	public static int getBinaryGaps(int[] input) {

		int gaps = 0;

		boolean hadOne = false;
		boolean hadZeros = false;

		for (int i = 0; i < input.length; i++) {

			if (input[i] == 1) {

				if ((hadOne) && (hadZeros)) {
					gaps++;
					hadZeros = false;

				}
			}

			if (input[i] == 1) {
				hadOne = true;
			}

			if ((input[i] == 0) && (hadOne)) {
				hadZeros = true;
			}

		}

		return gaps;

	}

}
