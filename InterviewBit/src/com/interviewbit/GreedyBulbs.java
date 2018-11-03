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
public class GreedyBulbs {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] arr = { 1, 0, 0, 0 ,1};

		List<Integer> intList = Arrays.asList(arr);
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.addAll(intList);

		System.out.println(noOfSwitched(a));

	}

	public static int noOfSwitched(ArrayList<Integer> a) {
		int count = 0;
		int current = 0;

		for (Integer num : a) {

			if (num == current) {
				count++;
				current = (current + 1) % 2;
			}
		}

		return count;
	}

}
