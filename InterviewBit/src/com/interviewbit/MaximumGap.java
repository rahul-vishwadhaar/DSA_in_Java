package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

public class MaximumGap {

	public static void main(String[] args) {

		Integer[] A = { 100, 100 };

		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(A));

		System.out.println(maximumGap(a));

	}

	public static int maximumGap(final List<Integer> a) {

		TreeSet<Integer> set = new TreeSet<Integer>();

		if (a.size() < 2)
			return 0;

		Integer diff = 0;
		Integer diff1 = 0;
		Integer diff2 = 0;
		Integer maxDiff = 0;

		for (Integer num : a) {
			diff1 = 0;
			diff2 = 0;

			if (set.floor(num) != null)
				diff1 = num - set.floor(num);

			if (set.ceiling(num) != null)
				diff2 = num - set.ceiling(num);

			diff = diff1 > diff2 ? diff1 : diff2;

			if (diff > maxDiff) {
				maxDiff = diff;
			}

			set.add(num);
		}

		return maxDiff;
	}
}
