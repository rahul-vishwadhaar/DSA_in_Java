/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author rahul
 *
 */
public class __AssignMiceToHoles {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Integer[] arrA = { 1, 2, 1, 4 };
		Integer[] arrB = { 1, 2, 1, 4 };

		List<Integer> listA = Arrays.asList(arrA);
		List<Integer> listB = Arrays.asList(arrB);

		ArrayList<Integer> a = new ArrayList<Integer>(listA);

		ArrayList<Integer> b = new ArrayList<Integer>(listB);

		System.out.println(getMaxTime(a, b));
	}

	private static int getMaxTime(ArrayList<Integer> a, ArrayList<Integer> b) {

		if (a.size() != b.size()) {
			return -1;
		}

		if (a.size() == 0) {
			return 0;
		}

		int diff = 0;
		int maxDiff = 0;

		Collections.sort(a);
		Collections.sort(b);

		for (int i = 0; i < a.size(); i++) {

			diff = b.get(i) - a.get(i);

			if (diff > maxDiff) {
				maxDiff = diff;
			}
		}
		return maxDiff;
	}

}
