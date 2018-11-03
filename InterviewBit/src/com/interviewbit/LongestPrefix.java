package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestPrefix {

	public static void main(String[] args) {

		String[] atr = { "a", "abcd", "abcdfgh" };

		ArrayList<String> a = new ArrayList<String>(Arrays.asList(atr));

		System.out.println(longestCommonPrefix(a));

	}

	public static String longestCommonPrefix(ArrayList<String> a) {

		StringBuffer sb = new StringBuffer();
		boolean flag = true;
		int index = 0;
		char ch = 0;

		while (flag) {

			if (index >= a.get(0).length()) {
				flag = false;
				break;
			}

			ch = a.get(0).charAt(index);

			for (String str : a) {
				if (index >= str.length()) {
					flag = false;
				} else if (ch != str.charAt(index)) {
					flag = false;
				}
			}

			if (flag == false) {
				break;
			}

			sb.append(ch);
			index++;
		}

		return sb.toString();
	}

}
