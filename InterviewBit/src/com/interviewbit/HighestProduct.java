/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author rahul
 *
 */
public class HighestProduct {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] arr = { -3,-2,-1, 0};

		List<Integer> intList = Arrays.asList(arr);
		ArrayList<Integer> a = new ArrayList<Integer>();
		a.addAll(intList);

		System.out.println(highestProduct(a));
	}

	public static int highestProduct(ArrayList<Integer> a) {
		int product = 1;

		if (a.size() <= 3) {

			for (Integer num : a) {
				product *= num;
			}

			return product;
		}

		Collections.sort(a);

		if (a.get(a.size() - 1) <= 0) {

			for (int i = a.size() - 3; i < a.size(); i++) {
				product *= a.get(i);
			}
			return product;
		}

		if (a.get(0) >= 0) {

			for (int i = 0; i < 3; i++) {
				product *= a.get(i);
			}

			return product;
		}

		int product1 = a.get(a.size() - 1) * a.get(a.size() - 2) * a.get(a.size() - 3);
		int product2 = a.get(0) * a.get(1) * a.get(a.size() - 1);

		product = product1 > product2 ? product1 : product2;

		return product;
	}

}
