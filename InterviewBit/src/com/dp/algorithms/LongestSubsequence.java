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
public class LongestSubsequence {

	/**
	 * @param args
	 */
	static int size;

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

		System.out.println(longestSubsequenceLength(input));
	}

	public static int longestSubsequenceLength(final List<Integer> input) {
		if (input.isEmpty()) {
			return 0;
		} else if (input.size() == 1) {
			return 1;
		}

		size = input.size();

		int[] lis = lisArray(input);
		int[] lds = ldsArray(input);

		int max = 0;
		int sum;
		for (int i = 0; i < size; i++) { // O(n)
			sum = lis[i] + lds[size - i - 1] - 1;
			max = max > sum ? max : sum;
		}

		return max;
	}

	public static int binSearchIndex(int a[], int low, int high, int x) {
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

	public static int[] lisArray(List<Integer> input) { // O(n*logn) {
		int[] searchArray = new int[size];
		searchArray[0] = input.get(0);
		int length = 0;

		int[] lis = new int[size]; // array for LIS answers
		lis[0] = 1;

		for (int i = 1; i < size; i++) { // O(n) * O(logn)
			int x = input.get(i);
			if (x <= searchArray[length]) {
				int index = binSearchIndex(searchArray, 0, length, x);
				searchArray[index] = x;
				lis[i] = index + 1;
			} else {
				searchArray[++length] = x;
				lis[i] = length + 1;
			}
		}

		return lis;
	}

	public static int[] ldsArray(List<Integer> input) {
		ArrayList<Integer> reverse = new ArrayList<>();
		for (int i = 0; i < size; i++) {
			reverse.add(input.get(size - i - 1));
		}
		return lisArray(reverse);
	}

}
