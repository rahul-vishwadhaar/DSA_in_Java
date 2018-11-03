/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class MaxContigiousSumArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

		System.out.println(maxSubArray(arr));
	}

	public static int maxSubArray(int[] a) {
		int size = a.length;
		int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
		int end = 0;
		int prevStart = 0;
		int start = 0;

		for (int i = 0; i < size; i++) {
			max_ending_here = max_ending_here + a[i];
			if (max_so_far < max_ending_here) {
				max_so_far = max_ending_here;
				if (end - i <= 1) {
					end = i;
				} else {
					prevStart = end + 1;
					end = i;
				}
			}
			if (max_ending_here < 0)
				max_ending_here = 0;
				prevStart = start;
				start = i + 1;
		}
		System.out.println("End " + end + " Start " + prevStart);

		return max_so_far;
	}

}
