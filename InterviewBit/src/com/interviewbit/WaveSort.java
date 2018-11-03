package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class WaveSort {

	public static void main(String[] args) {

		Integer[] a = { 1 ,2,3,4,5};
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(a));

		System.out.println(wave(arr));
	}

	public static ArrayList<Integer> wave(ArrayList<Integer> a) {

		int index = 0;
		Collections.sort(a);

		ArrayList<Integer> res = new ArrayList<Integer>();
		for (index = 0; index < a.size() - 1; index += 2) {

			res.add(a.get(index + 1));
			res.add(a.get(index));
		}

		if (res.size() < a.size()) {
			res.add(a.get(a.size() - 1));
		}
		return res;
	}

}
