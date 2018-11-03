/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rahul
 *
 */
public class MaximumUnsortedSubArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] A = { 1, 2, 3, 5, 6, 13, 15, 16, 20, 13, 13, 15, 17, 17, 17, 17, 17, 19, 19 };

		List<Integer> a = Arrays.asList(A);

		ArrayList<Integer> input = new ArrayList<Integer>();

		input.addAll(a);

		input = subUnsort(input);
		System.out.println(input);

	}

	public static ArrayList<Integer> subUnsort(ArrayList<Integer> A) {

		ArrayList<Integer> result = new ArrayList<Integer>();
		int prev = -1;
		int current = 0;
		int end = -1;
		int start = -1;
		int min = 0;

		for (int i = 0; i < A.size(); i++) {

			current = A.get(i);

			if (prev <= current) {
				prev = current;
			} else {
				end = i;
				if (start == -1) {
					start = end;
					min = A.get(start);
					prev = current;
				}
			}
		}

		if (start == end) {
			result.add(-1);
		} else {

			System.out.println(A.get(start));
			System.out.println(A.get(end));

			result.add(start);
			result.add(end);
		}
		return result;

	}

}
