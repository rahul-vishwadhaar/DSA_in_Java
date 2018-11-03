package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class Sum_3 {

	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<Integer>();

		int[] input = { -5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9,
				5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3 };

		a.add(-1);
		a.add(2);
		a.add(-3);
		a.add(-4);
		a.add(-5);
		a.add(-6);
		a.add(-7);
		a.add(1);
		a.add(2);
		a.add(3);

		int target = -1;

		// System.out.println(threeSumClosest(a, target));

		int[] input2 = { 4, 7, -4, 2, 2, 2, 3, -5, -3, 9, -4, 9, -7, 7, -1, 9, 9, 4, 1, -4, -2, 3, -3, -5, 4, -7, 7, 9,
				-4, 4, -8 };

		target = -3;
		System.out.println(threeSumClosest(input2, target));
	}

	public static int threeSumClosest(ArrayList<Integer> a, int b) {
		int result = Integer.MAX_VALUE;
		int candidate = 0;
		int diff = Integer.MAX_VALUE;

		int[] input = new int[a.size()];

		for (int i = 0; i < a.size(); i++) {
			input[i] = a.get(i);
		}

		Arrays.sort(input);

		input = removeDuplicates(input);

		for (int i = 0; i < input.length - 2; i++) {
			candidate = input[i] + input[i + 1] + input[i + 2];
			// System.out.println("candidate " + i + " : " + candidate);
			if ((Math.abs(candidate - b) < diff)) {
				result = candidate;
				diff = Math.abs(candidate - b);
			} else {
				break;
			}
		}

		return result;
	}

	public static int threeSumClosest(int[] input, int b) {
		int result = Integer.MAX_VALUE;
		int candidate = 0;
		int diff = Integer.MAX_VALUE;

		Arrays.sort(input);

		input = removeDuplicates(input);

		for (int i = 0; i < input.length - 2; i++) {
			candidate = input[i] + input[i + 1] + input[i + 2];
			System.out.println("candidate " + i + " : " + candidate + " Diff : " + diff);
			if ((Math.abs(candidate - b) <= diff)) {
				result = candidate;
				diff = Math.abs(candidate - b);
			} else {
				break;
			}

		}

		return result;
	}

	private static int[] removeDuplicates(int[] input) {

		int[] result = new int[input.length];
		int prev = Integer.MAX_VALUE;
		int j = 0;

		for (int i = 0; i < input.length; i++) {
			if (prev == input[i]) {
				continue;
			}

			result[j] = input[i];
			j++;
			prev = input[i];

		}

		return result;
	}

}
