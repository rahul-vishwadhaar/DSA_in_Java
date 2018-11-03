/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;

/**
 * @author rahul
 *
 */
public class MultiplyStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str1 = String.valueOf(9999);
		String str2 = String.valueOf(9999);

		System.out.println(multiplyStrings(str1, str2));

	}

	public static String multiplyStrings(String a, String b) {
		StringBuilder sb = new StringBuilder();
		ArrayList<Integer> arr = new ArrayList<Integer>();

		int[] input1 = new int[a.length()];
		int[] input2 = new int[b.length()];

		int num = 0;

		for (int i = 0; i < a.length(); i++) {
			input1[i] = a.charAt(a.length() - i - 1) - 48;
		}

		for (int i = 0; i < b.length(); i++) {
			input2[i] = b.charAt(b.length() - i - 1) - 48;
		}

		int carry = 0;
		int current = 0;
		int[] temp;
		for (int i = 0; i < input2.length; i++) {
			num = input2[i];
			carry = 0;
			temp = new int[input1.length + 1];
			for (int j = 0; j < input1.length; j++) {

				current = num * input1[j];
				current += carry;

				carry = current / 10;
				current = current % 10;

				temp[j] = current;

				// System.out.print(current + " ");
			}

			temp[temp.length - 1] = carry;

			// System.out.println(" ");
			int carry2 = 0;
			for (int k = 0; k < temp.length; k++) {

				if ((k + i) < arr.size()) {
					num = arr.get(k + i) + temp[k] + carry2;
					carry2 = num / 10;
					num = num % 10;

					arr.set(k + i, num);
				} else {
					arr.add(temp[k] + carry2);
					carry2 = 0;
				}
			}

		}

		boolean flag = false;
		for (int i = arr.size(); i > 0; i--) {

			if (!flag) {
				if (arr.get(i - 1) == 0)
					continue;
				else
					flag = true;
			}

			sb.append(arr.get(i - 1));
		}

		if (!flag)
			return "0";

		return sb.toString();
	}

}
