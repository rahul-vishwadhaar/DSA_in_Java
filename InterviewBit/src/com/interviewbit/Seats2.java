/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;

/**
 * @author rahul
 *
 */
public class Seats2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s = "x.x.xx.x.xxx.......x..x.xxx..x.xxx";

		s = "..xx.x";

		s = ".....";
		System.out.println(getMinDisplacement(s));

	}

	public static int getMinDisplacement(String a) {

		int displacement = 0;

		char[] input = a.toCharArray();

		int median = getMedian(input);

		// System.out.println("Median : " + median);
		int position = 0;

		if (median == -1)
			return 0;

		position = median - 1;
		for (int i = median - 1; i >= 0; i--) {

			if (input[i] != 'x') {

			} else if (i == position) {
				position--;
			} else {

				input[position] = 'x';
				displacement = (displacement + (position - i)) % 10000003;
				position--;
				input[i] = '.';
				/*
				 * for (int in = 0; in < input.length; in++) {
				 * 
				 * System.out.print(input[in] + " "); }
				 * 
				 * System.out.println(" ");
				 */
			}

		}

		// System.out.println("Displacement + " + displacement);

		position = median + 1;
		for (int i = median + 1; i < input.length; i++) {

			if (input[i] != 'x') {

			} else if (i == position) {
				position++;
			} else {

				input[position] = 'x';
				displacement = (displacement + (i - position)) % 10000003;
				position++;
				input[i] = '.';

				/*
				 * for (int in = 0; in < input.length; in++) {
				 * 
				 * System.out.print(input[in] + " "); }
				 * 
				 * System.out.println("");
				 */ }
		}

		return displacement;

	}

	private static int getMedian(char[] input) {

		ArrayList<Integer> positions = new ArrayList<Integer>();

		for (int i = 0; i < input.length; i++) {

			if (input[i] == 'x') {
				positions.add(i);
			}
		}

		if (positions.size() == input.length)
			return -1;

		if (positions.size() == 0) {
			return -1;
		}

		return positions.get(positions.size() / 2);
	}
}
