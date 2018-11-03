/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;

/**
 * @author rahul
 *
 */
public class FlipBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String input = "010";

		flip(input);
	}

	public static ArrayList<Integer> flip(String A) {

		char[] input = A.toCharArray();

		int[] inputRev = new int[input.length];

		for (int i = 0; i < input.length; i++) {

			if (input[i] == '0') {
				inputRev[i] = -1;
			} else {
				inputRev[i] = 0;
			}
		}

		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
		int end = 0;
		int start = 0;
		int prevStart = 0;

		for (int i = 0; i < inputRev.length; i++) {
			max_ending_here = max_ending_here + inputRev[i];
			if (max_so_far < max_ending_here) {
				end = i;
				start = prevStart;
				max_so_far = max_ending_here;
				prevStart = i + 1;
			}
			/*
			 * if (max_ending_here < 0) max_ending_here = 0;
			 */
		}
		System.out.println(max_so_far + " Start " + start + " End " + end);

		return null;
	}
}
