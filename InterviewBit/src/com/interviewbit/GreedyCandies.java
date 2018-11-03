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
public class GreedyCandies {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] arr = { 6,7,2,4,5 };

		List<Integer> intList = Arrays.asList(arr);
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.addAll(intList);

		System.out.println(maxCandies(a));

	}

	public static int maxCandies(ArrayList<Integer> a) {

		int maxCount = 0;

		for (Integer num : a) {
			if (maxCount == 0) {
				maxCount = num;
			} else if (maxCount < num) {
				continue;
			} else {

				maxCount = (maxCount + num) / 2;

			}
		}

		return maxCount;
	}

}
