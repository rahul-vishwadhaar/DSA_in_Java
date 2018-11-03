/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author rahul
 *
 */
public class MagicianAndChocoloates {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int A = 10;
		Integer[] a = { 2147483647, 2000000014, 2147483647 };
		ArrayList<Integer> arr = new ArrayList<Integer>(Arrays.asList(a));

		System.out.println(nchoc(A, arr));
	}

	public static int nchoc(int A, ArrayList<Integer> B) {

		long choc = 0;
		int current = 0;
		int value = 0;
		int chocolates = 0;

		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();

		for (Integer num : B) {

			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}

		while (A-- > 0) {

	//		System.out.println(current  + " " + map);
			current = map.lastKey();
			value = map.get(current);

			if (value == 1) {
				map.remove(current);
			} else {
				map.put(current, value - 1);
			}

			
			choc +=current;
			choc %=1000000007;
		
			current /= 2;

			if (map.containsKey(current)) {
				map.put(current, map.get(current) + 1);
			} else {
				map.put(current, 1);
			}
		}

//		System.out.println(choc);
		chocolates=(int) choc;
		return chocolates;
	}

}
