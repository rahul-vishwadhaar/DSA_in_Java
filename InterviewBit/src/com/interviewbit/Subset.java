package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subset {

	public static void main(String[] args) {

		Integer[] arr = { 1, 6, 2, 3, 4, 5 };

		ArrayList<Integer> input = new ArrayList<Integer>();

		List<Integer> l = Arrays.asList(arr);

		input.addAll(l);

		System.out.println(subsets(input));
	}

	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {

		int len = a.size();
		int i = 0;

		ArrayList<Integer> prev = new ArrayList<Integer>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		ArrayList<ArrayList<Integer>> subset = new ArrayList<ArrayList<Integer>>();

		int[] arr = new int[a.size()];

		for (Integer num : a) {
			arr[i] = num;
			i++;
		}

		Arrays.sort(arr);

		for (i = 0; i < len; i++) {
			prev = new ArrayList<Integer>();
			for (int j = i; j < len; j++) {
				result = new ArrayList<Integer>();

				result.addAll(prev);
				result.add(arr[j]);
				prev.add(arr[j]);
				subset.add(result);

			}
		}

		return subset;
	}

}
