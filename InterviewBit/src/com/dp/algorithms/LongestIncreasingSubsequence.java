/**
 * 
 */
package com.dp.algorithms;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rahul
 *
 */
public class LongestIncreasingSubsequence {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<Integer> input = new ArrayList<>();

		input.add(1);
		input.add(11);
		input.add(2);
		input.add(10);
		input.add(4);
		input.add(5);
		input.add(2);
		input.add(1);

		System.out.println(longestIncreasingSubsequence(input));
	}

	public static int longestIncreasingSubsequence(List<Integer> input) {

		int[] lis = new int[input.size()];
		int index = 0;
		int current = 0;
		int[] searchArray = new int[input.size()];
		int length = 0;
		int max = 0;

		lis[0] = 1;
		searchArray[0] = input.get(0);

		for (int i = 1; i < input.size(); i++) {
			current = input.get(i);

			if (current < searchArray[length]) {

				index = binSearch(searchArray, 0, length, current);
				searchArray[index] = current;
				lis[i] = index + 1;

			} else {

				searchArray[++length] = current;
				lis[i] = length + 1;
			}

		}

		for (int i = 0; i < lis.length; i++) {

			current = lis[i];

			max = (max > current) ? max : current;
		}

		return max;
	}

	private static int binSearch(int[] a, int low, int high, int x) {
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (a[mid] < x) {
				low = mid + 1;
			} else if (a[mid] > x) {
				high = mid;
			} else {
				return mid;
			}
		}

		return low;
	}

}
