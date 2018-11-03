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
public class Two_Sum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] arr = { -5, 1, 4, -7, 10, -7, 0, 7, 3, 0, -2, -5, -3, -6, 4, -7, -8, 0, 4, 9, 4, 1, -8, -6, -6, 0, -9,
				5, 3, -9, -5, -9, 6, 3, 8, -10, 1, -2, 2, 1, -9, 2, -3, 9, 9, -10, 0, -9, -2, 7, 0, -4, -3, 1, 6, -3 };
		int b = -1;

		System.out.println(twoSum(Arrays.asList(arr), b));

	}

	public static ArrayList<Integer> twoSum(final List<Integer> a, int b) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		ArrayList<Integer> res = new ArrayList<Integer>();
		int key = 0;
		int index1 = 0;
		int index2 = 0;

		int pIndex1 = -1;
		int pIndex2 = Integer.MAX_VALUE;

		for (Integer num : a) {

			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}

		int candidate = 0;

		for (Integer num : a) {

			key = b - num;

			if (map.containsKey(key)) {

				if ((key == num) && (map.get(key) == 1))
					continue;

				candidate = key;

				for (int i = index1 + 1; i < a.size(); i++) {
					if (a.get(i) == candidate) {
						index2 = i;

						if (index2 < pIndex2) {
							pIndex1 = index1;
							pIndex2 = index2;
							break;
						}
					}
				}

			}

			index1++;
		}

		if (pIndex1 == -1)
			return res;

		res.add(pIndex1 + 1);
		res.add(pIndex2 + 1);

		return res;
	}

}
