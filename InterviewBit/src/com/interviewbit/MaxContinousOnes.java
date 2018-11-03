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
public class MaxContinousOnes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] arr1 = { 1, 1, 0, 1, 1, 0, 0, 1, 1, 1 };

		List<Integer> temp = Arrays.asList(arr1);
		ArrayList<Integer> a = new ArrayList<Integer>();

		a.addAll(temp);

		System.out.println(a);
		System.out.println(maxone(a, 0));
	}

	public static ArrayList<Integer> maxone(ArrayList<Integer> a, int b) {

		
		int maxDiff = 0;

		ArrayList<Integer> res = new ArrayList<Integer>();

		int wL = 0;
		int wR = -1;
		int maxR = 0;
		int minL = 0;

		int zeroes = 0;

		for (int i = 0; i < a.size(); i++) {

			if (a.get(i) == 1) {
				wR++;
			} else if (a.get(i) == 0) {

				if (zeroes < b) {
					zeroes++;
					wR++;
				} else {

					while (!(zeroes < b)) {

						if (a.get(wL) == 0) {
							zeroes--;
						}
						wL++;

					}
					zeroes++;
					wR++;
				}

			}

			if (maxDiff < (wR - wL)) {

				maxDiff = wR - wL;
				minL = wL;
				maxR = wR;
			}

//			System.out.println("Left Index : " + minL + "---- Right Index : " + maxR);
		}

		for (int i = minL; i <= maxR; i++) {
			res.add(i);
		}
		return res;
	}

}
