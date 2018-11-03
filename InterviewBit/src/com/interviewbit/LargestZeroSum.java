/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author rahul
 *
 */
public class LargestZeroSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// Integer[] arr = { 1, 2, -3, 3 };
		Integer[] arr = { 0, 2, -4, 7, -10 };

		List<Integer> a = Arrays.asList(arr);

		ArrayList<Integer> a1 = new ArrayList<Integer>();
		a1.addAll(a);

		System.out.println(maxLenght(a1));
	}

	private static ArrayList<Integer> maxLenght(ArrayList<Integer> a) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		ArrayList<Integer> result = new ArrayList<Integer>();

		int len = -1;
		int maxlen = 0;
		int sum = 0;
		int start = 0;
		int end = 0;

		boolean flag = false;

		map.put(0, -1);

		for (int i = 0; i < a.size(); i++) {
			len = 0;
			sum += a.get(i);

			/*
			 * if (sum == 0) { len = i; } else
			 */if (map.containsKey(sum)) {
				len = i - map.get(sum);
			} else {
				map.put(sum, i);
			}
			// System.out.print(arr[i] + " ");

			/*
			 * if (len == i) { maxlen = len; start = 0; end = i; flag = true;
			 * 
			 * } else
			 */ if (len > maxlen) {
				maxlen = len;
				start = map.get(sum);
				end = i;
				flag = false;
			}
		}

		if (flag)
			start--;
		for (int i = start + 1; i <= end; i++) {
			result.add(a.get(i));
		}
		return result;
	}

}
