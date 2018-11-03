/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;

/**
 * @author rahul
 *
 */
public class MergeSortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<Integer>();
		ArrayList<Integer> b = new ArrayList<Integer>();

		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);

		b.add(1);
		b.add(2);
//		b.add(3);
//		b.add(4);

		merge(a, b);

		for (Integer num : a) {
			System.out.println(num);
		}

	}

	public static void merge(ArrayList<Integer> a, ArrayList<Integer> b) {

		int size1 = a.size();
		int size2 = b.size();
		int count = size1+size2;
		int index1 = 0;
		int index2 = 0;
		int insert = 0;

		ArrayList<Integer> result = new ArrayList<Integer>();

		while (count-- > 0) {

			if (index1 == size1) {
				a.add(b.get(index2));
				index2++;
			} else if (index2 == size2) {
				result.add(a.get(index1));
				index1++;
			} else if (a.get(index1) < b.get(index2)) {
				index1++;
			} else {
				a.add(index1, b.get(index2));
				index1++;
				size1++;
				index2++;
			}
		}

	}
}
