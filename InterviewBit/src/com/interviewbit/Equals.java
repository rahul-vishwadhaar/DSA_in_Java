/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * @author rahul
 *
 */
public class Equals {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] A = {3, 4, 7, 1, 2, 9, 8 };

		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(A));

		ArrayList<Integer> res1 = new ArrayList<Integer>();
		res1.add(0);
		res1.add(21);
		res1.add(4);
		res1.add(5);

		ArrayList<Integer> res2 = new ArrayList<Integer>();
		res2.add(0);
		res2.add(1);
		res2.add(3);
		res2.add(22);

		// System.out.println(compare(res2,res1));

		System.out.println(equal(a));
	}

	public static ArrayList<Integer> equal(ArrayList<Integer> a) {
		ArrayList<Integer> result = null;
		HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		ArrayList<Integer> current = new ArrayList<Integer>();

		int sum = 0;

		for (int i = 0; i < a.size(); i++) {

			for (int j = i + 1; j < a.size(); j++) {

				sum = a.get(i) + a.get(j);

				if (map.containsKey(sum)) {
					temp = map.get(sum);

					if (temp.get(0) == i)
						continue;

					if (temp.get(1) == i)
						continue;
					
					if (temp.get(1) == j)
						continue;

					current = new ArrayList<Integer>();
					current.add(temp.get(0));
					current.add(temp.get(1));
					current.add(i);
					current.add(j);

					if (compare(current, result) == -1) {
						result = current;

					}

				} else {
					temp = new ArrayList<Integer>();
					temp.add(i);
					temp.add(j);
					map.put(sum, temp);
				}
			}
		}

		return result;

	}

	public static int compare(ArrayList<Integer> res1, ArrayList<Integer> res2) {

		if (res2 == null)
			return -1;

		if (res2.get(0) > res1.get(0))
			return -1;

		if (res1.get(0) > res2.get(0))
			return 1;

		if (res2.get(1) > res1.get(1))
			return -1;

		if (res1.get(1) > res2.get(1))
			return 1;

		if (res2.get(2) > res1.get(2))
			return -1;

		if (res1.get(2) > res2.get(2))
			return 1;

		if (res2.get(3) > res1.get(3))
			return -1;

		if (res1.get(3) > res2.get(3))
			return 1;

		return 1;
	}

}
