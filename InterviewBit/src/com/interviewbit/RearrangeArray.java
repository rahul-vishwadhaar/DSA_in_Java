/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;

/**
 * @author rahul
 *
 */
public class RearrangeArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> input = new ArrayList<Integer>();
		input.add(4);
		input.add(0);
		input.add(2);
		input.add(1);
		input.add(3);

		arrange(input);
		System.out.println(input);

	}

	public static void arrange(ArrayList<Integer> a) {

		int n = a.size();

		// First step: Increase all values by (arr[arr[i]]%n)*n
		for (int i = 0; i < n; i++)
			a.set(i, a.get(i) + (a.get(a.get(i)) % n) * n);

		// Second Step: Divide all values by n
		for (int i = 0; i < n; i++)
			a.set(i, a.get(i) / n);
	}

}
