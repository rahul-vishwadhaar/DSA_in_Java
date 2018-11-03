/**
 * 
 */
package com.interviewbit;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * @author rahul kumar
 * 
 */
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * String s = "A";
		 * 
		 * System.out.println(s.toLowerCase());
		 * 
		 * System.out.println(s);
		 * 
		 * TreeMap<Integer, Integer> t = new TreeMap<Integer, Integer>();
		 * t.put(3, 3); t.put(1, 1); t.put(2, 2);
		 */

		int[] arr = { 1, 2, 4, 5 };
		int num = 4;

		System.out.println(exits(arr, num));
	}

	static double approx(double[][] pts) {

		double pi = 0;
		double x = 0;
		double y = 0;
		int len = 0;
		int count = 0;

		len = pts.length;

		for (int i = 0; i < pts.length; i++) {

			x = pts[i][0];
			y = pts[i][1];

			if (x * x + y * y <= 1) {
				count++;
			}

		}

		pi = 4 * (count / len);

		return pi;

	}

	static boolean exits(int[] ints, int num) {

		int index = Arrays.binarySearch(ints, num);

		return index >= 0;

	}
}
