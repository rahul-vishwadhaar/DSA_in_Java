/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;

/**
 * @author rahul
 *
 */
public class MaxUnsorted {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Integer> subUnsort(ArrayList<Integer> A) {

		ArrayList<Integer> result = new ArrayList<Integer>();

		int start = -1;
		int end = -1;

		for (int i = 1; i < A.size(); i++) {

			if (A.get(i) > A.get(i - 1)) {
				if (start != -1)
					start = i - 1;

				end = i - 1;
			}
		}

		if (start == end) {
			result.add(-1);
		} else {

			result.add(start);
			result.add(end);
		}
		return result;

	}

}
