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
public class __Array3Pointers {

	
	
	/*You are given 3 arrays A, B and C. All 3 of the arrays are sorted.

	Find i, j, k such that :
	max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i])) is minimized.
	Return the minimum max(abs(A[i] - B[j]), abs(B[j] - C[k]), abs(C[k] - A[i]))
*/	
	public static void main(String[] args) {

		Integer[] arr1 = { 1, 4, 10 };
		List<Integer> temp1 = Arrays.asList(arr1);
		ArrayList<Integer> a = new ArrayList<Integer>();

		a.addAll(temp1);

		Integer[] arr2 = { 2, 15, 20 };
		List<Integer> temp2 = Arrays.asList(arr2);
		ArrayList<Integer> b = new ArrayList<Integer>();

		b.addAll(temp2);

		Integer[] arr3 = { 10, 12 };
		List<Integer> temp3 = Arrays.asList(arr3);
		ArrayList<Integer> c = new ArrayList<Integer>();

		c.addAll(temp3);

		System.out.println(minimize(a, b, c));
	}

	public static int minimize1(final List<Integer> a, final List<Integer> b, final List<Integer> c) {

		int c1 = 0;
		int c2 = 0;
		int c3 = 0;
		int candidate = 0;

		int res = Integer.MAX_VALUE;

		for (int i = 0; i < a.size(); i++) {

			for (int j = 0; j < b.size(); j++) {

				for (int k = 0; k < c.size(); k++) {

					c1 = Math.abs(a.get(i) - b.get(j));
					c2 = Math.abs(b.get(j) - c.get(k));
					c3 = Math.abs(c.get(k) - a.get(i));

					candidate = Math.max(c1, Math.max(c2, c3));

					res = Math.min(res, candidate);

				}
			}
		}
		return res;
	}

	public static int minimize(final List<Integer> a, final List<Integer> b, final List<Integer> c) {

		int index1 = 0;
		int index2 = 0;
		int index3 = 0;

		int num1 = 0;
		int num2 = 0;
		int num3 = 0;

		int min = 0;
		int res = Integer.MAX_VALUE;

		while (true) {

			if (index1 == a.size()) {
				break;
			}

			if (index2 == b.size()) {
				break;
			}

			if (index3 == c.size()) {
				break;
			}

			num1 = a.get(index1);
			num2 = b.get(index2);
			num3 = c.get(index3);

			min = Math.max(num1, Math.max(num2, num3)) - Math.min(num1, Math.min(num2, num3));

			res = Math.min(res, min);

			min = Math.min(num1, Math.min(num2, num3));

			if (min == num1) {
				index1++;
			} else if (min == num2) {
				index2++;
			} else {
				index3++;
			}

		}

		return res;
	}

}
