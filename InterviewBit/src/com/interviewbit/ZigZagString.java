package com.interviewbit;

import java.util.ArrayList;

public class ZigZagString {

	/**
	 * 
	 * @param args
	 * 
	 */

	public static void main(String[] args) {

		String input = "PAYPALISHIRING";

		System.out.println(zigzagString(input, 3));

		/*
		 * 
		 * 1 5 9 2 4 6 8 3 7
		 * 
		 */ }

	private static String zigzagString(String a, int n) {

		StringBuilder res = new StringBuilder();
		ArrayList<StringBuilder> arr = new ArrayList<StringBuilder>();

		if (n == 1)
			return a;

		for (int i = 0; i < a.length(); i++) {

			arr.add(new StringBuilder());

		}

		int index = -1;

		boolean flag = true;

		for (int i = 0; i < a.length(); i++) {

			if (flag) {

				index++;

				if (index == n - 1) {

					flag = false;

					// index = n;

				}

			} else {

				index--;

				if (index == 0)

					flag = true;

			}

			arr.get(index).append(a.charAt(i));

		}

		for (StringBuilder sb : arr) {

			res.append(sb.toString());

		}

		return res.toString();

	}

}