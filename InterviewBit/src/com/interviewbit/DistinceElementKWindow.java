/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author rahul
 *
 */
public class DistinceElementKWindow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Integer[] arr = { 1, 2, 1, 3, 4, 3 };
		int[] arr1 = { 1, 2, 1, 3, 4, 3 };
		ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(arr));

		System.out.println("Sizes " + count2(a, 2));

	}

	public static ArrayList<Integer> getCount(ArrayList<Integer> A, int B) {

		ArrayList<Integer> res = new ArrayList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();

		if (B > A.size())
			return res;

		for (int i = 0; i < B; i++) {

			if (set.contains(A.get(i))) {
			} else {
				set.add(A.get(i));
			}
		}

		res.add(set.size());

		int index = 1;
		while (index < A.size() - B + 1) {

			set.remove(A.get(index - 1));

			for (int i = index; i < index + B; i++) {

				if (set.contains(A.get(i))) {

				} else {
					set.add(A.get(i));
				}
			}

			res.add(set.size());
			index++;
		}

		return res;
	}

	public static ArrayList<Integer> getCount1(ArrayList<Integer> A, int B) {

		ArrayList<Integer> res = new ArrayList<Integer>();
		HashSet<Integer> set = new HashSet<Integer>();

		if (B > A.size())
			return res;

		B = 1;

		for (int i = 0; i < A.size(); i++) {

			if ((i - B) < 0) {
				set.add(A.get(i));
			} else {

				res.add(set.size());

				set.remove(A.get(i - B));
				set.add(A.get(i - 1));
				set.add(A.get(i - 2));
				set.add(A.get(i));

			}
		}
		res.add(set.size());
		return res;
	}

	public static ArrayList<Integer> count2(ArrayList<Integer> A, int B) {

		ArrayList<Integer> res = new ArrayList<Integer>();
		// Creates an empty hashMap hM
		HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();

		// initialize distinct element count for
		// current window
		int dist_count = 0;

		// Traverse the first window and store count
		// of every element in hash map
		for (int i = 0; i < B; i++) {
			if (hM.get(A.get(i)) == null) {
				hM.put(A.get(i), 1);
				dist_count++;
			} else {
				int count = hM.get(A.get(i));
				hM.put(A.get(i), count + 1);
			}
		}

		System.out.println(dist_count);

		// Traverse through the remaining array
		for (int i = B; i < A.size(); i++) {

			// Remove first element of previous window
			// If there was only one occurrence, then
			// reduce distinct count.
			if (hM.get(A.get(i - B)) == 1) {
				hM.remove(A.get(i - B));
				dist_count--;
			} else // reduce count of the removed element
			{
				int count = hM.get(A.get(i - B));
				hM.put(A.get(i - B), count - 1);
			}

			// Add new element of current window
			// If this element appears first time,
			// increment distinct element count
			if (hM.get(A.get(i)) == null) {
				hM.put(A.get(i), 1);
				dist_count++;
			} else // Increment distinct element count
			{
				int count = hM.get(A.get(i));
				hM.put(A.get(i), count + 1);
			}

			// Print count of current window
			res.add(dist_count);
		}

		return res;
	}

}
