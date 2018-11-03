/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;

/**
 * @author rahul
 *
 */
public class Seats {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String s = "x.x.xx.x.xxx.......x..x.xxx..x.xxx";

	//	 s = "..xx.x";

		System.out.println(minDisplacements(s));

	}

	public static int minDisplacements(String a) {

		char[] input = a.toCharArray();

		int maxStart = 0;
		int maxEnd = 0;
		int displacement = 0;

		ArrayList<Integer> location = getStartEndPoints(a);

		if (location == null) {
			return 0;
		}
		maxStart = location.get(0);
		maxEnd = location.get(1);

		if (maxEnd - maxStart == input.length - 1) {
			return 0;
		}

		for (int i = maxStart - 1; i >= 0; i--) {

			if (input[i] == 'x') {

				while (input[maxStart] != '.') {
					maxStart--;
				}
				input[maxStart] = 'x';
				input[i] = '.';

				// System.out.println("displacment " + (maxStart - i));
				displacement += (maxStart - i);
//				System.out.println(new String(input));
			}

		}

		System.out.println("Displacement + " + displacement);
		for (int i = maxEnd + 1; i < input.length; i++) {

			if (input[i] == 'x') {

				while (input[maxEnd] != '.') {
					maxEnd++;
				}
				input[maxEnd] = 'x';
				input[i] = '.';
				// System.out.println("displacment " + (i - maxEnd));
				displacement += (i - maxEnd);
				// System.out.println(new String(input));
			}

		}
		
		System.out.println("Displacement + " + displacement);

		/*
		 * for (int i = 0; i < input.length; i++) {
		 * 
		 * System.out.print(input[i] + " "); }
		 */

		return displacement;

	}

	private static ArrayList<Integer> getStartEndPoints(String a) {

		char[] input = a.toCharArray();

		boolean flag = false;
		int end = 0;
		int start = 0;

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		for (int i = 0; i < input.length; i++) {

			if (input[i] == 'x') {
				if (flag == true) {
					end++;
				} else {
					start = end = i;
					flag = true;
				}

			} else {

				if (flag == true) {

					ArrayList<Integer> temp = new ArrayList<Integer>();
					temp.add(start);
					temp.add(end);
					res.add(temp);

				}

				flag = false;

			}
		}

		if ((flag == true)) {
			ArrayList<Integer> temp = new ArrayList<Integer>();
			temp.add(start);
			temp.add(end);
			res.add(temp);
		}
		
//		System.out.println(res);

		if (res.size() == 0)
			return null;

		return res.get((res.size() / 2));

	}
}
