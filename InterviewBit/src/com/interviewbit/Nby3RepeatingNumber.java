/**
 * 
 */
package com.interviewbit;

import java.util.Arrays;
import java.util.List;

/**
 * @author rahul
 *
 */
public class Nby3RepeatingNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Integer[] arr = { 1000662, 1000975, 1000662, 1000306, 1000662, 1000488, 1000662, 1000732, 1000397, 1000769,
				1000662, 1000731, 1000454 };

		// Arrays.sort(arr);

		System.out.println(repeatedNumber(Arrays.asList(arr)));

	}

	public static int repeatedNumber(final List<Integer> a) {

		int candidate[] = new int[3];

		int[] count = new int[3];

		int index = 0;

		for (int i = 0; i < a.size(); i++) {

			index = inCandidates(a.get(i), candidate);

			if (index != -1) {
				count[index]++;
				if (count[index] > a.size() / 3) {
					return candidate[index];
				}
				continue;
			}

			index = getMin(count);
			candidate[index] = a.get(i);
			count[index] = 1;
		}

		int candid = 0;
		int c = 0;
		for (int i = 0; i < candidate.length; i++) {
			candid = candidate[i];
			c = 0;

			for (Integer num : a) {

				if (num == candid) {
					c++;
				}

				if (c > a.size() / 3) {
					return num;
				}
			}

		}
		return -1;
	}

	private static int getMin(int[] count) {

		int min = count[0];
		int index = 0;

		for (int i = 1; i < count.length; i++) {
			if (min > count[i]) {
				min = count[i];
				index = i;
			}
		}
		return index;
	}

	private static int inCandidates(int num, int[] candidates) {

		if (num == candidates[0])
			return 0;

		if (num == candidates[1])
			return 1;

		if (num == candidates[2])
			return 2;

		return -1;

	}

}
