/**
 * 
 */
package com.dp.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author rahul
 *
 */
public class LongestAP {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<>();

		int[] arr = { 9, 4, 19, 6, 200, 8 };

		/// int[] arr = {539608799, 807581, 94300192, 1445230, 67576925
		/// ,897779169, 2082879, 258990871 ,512161549 ,509240462, 966839397,
		/// 2720528};

		for (int i = 0; i < arr.length; i++) {
			input.add(arr[i]);
		}

		/*
		 * input.add(1); input.add(3); input.add(5); input.add(6); input.add(7);
		 * input.add(9);
		 */
		System.out.println(solve(input));

	}

	public static int solve(final List<Integer> A) {
		int n = A.size();
		if (n <= 2)
			return n;
		Collections.sort(A);
		int dp[][] = new int[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][n - 1] = 2;
		}
		int max = 0;
		for (int i = n - 2; i >= 0; i--) {
			int j = i - 1;
			int k = i + 1;
			while (j >= 0 && k < n) {
				if (A.get(j) + A.get(k) < 2 * A.get(i))
					k++;
				else if (A.get(j) + A.get(k) > 2 * A.get(i)) {
					dp[j][i] = 2;
					j--;
				} else {
					dp[j][i] = dp[i][k] + 1;
					max = Math.max(max, dp[j][i]);
					j--;
					k++;
				}
			}
			if (k == n) {
				while (j >= 0) {
					dp[j][i] = 2;
					j--;
				}
			}
		}
		return max;
	}

	private static int lookBackward(int start, int diff, int[] arr) {
		int nextNum = start - diff;
		int index = 0;
		int length = 0;

		while (true) {

			index = Arrays.binarySearch(arr, nextNum);

			if (index < 0) {

				break;
			}

			length++;
			nextNum = arr[index] - diff;

		}
		return length;
	}

	private static int lookForward(int start, int diff, int[] arr) {

		int nextNum = start + diff;
		int index = 0;
		int length = 0;

		while (true) {

			index = Arrays.binarySearch(arr, nextNum);

			if (index < 0) {

				break;
			}

			length++;
			nextNum = arr[index] + diff;

		}
		return length;
	}

}
