/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rahul
 *
 */
public class MajorityElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = { 3, 3, 4, 2, 4, 4, 2, 4, 4 };

		List<Integer> a = new ArrayList<Integer>();

		a.add(3);
		a.add(3);
		a.add(4);
		a.add(2);
		a.add(4);
		a.add(4);
		a.add(2);
		a.add(4);
		a.add(4);
		System.out.println(majorityElement(a));

	}

	public static int majorityElement(final List<Integer> a) {

		if (a.isEmpty())
			return -1;

		int candidate = getCandidate(a);
		int count = 0;

		for (int i = 0; i < a.size(); i++) {
			if (candidate == a.get(i))
				count++;
		}

		if (count > a.size() / 2)
			return candidate;

		return -1;
	}

	public static int getCandidate(List<Integer> a) {

		int candiate = a.get(0);
		int count = 1;

		for (int i = 1; i < a.size(); i++) {
			if (a.get(i) == candiate) {
				count++;
			} else {
				count--;
			}

			if (count == 0) {
				candiate = a.get(i);
				count = 1;
			}
		}
		return candiate;
	}

}
