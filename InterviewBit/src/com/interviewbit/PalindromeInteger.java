package com.interviewbit;

public class PalindromeInteger {

	public static void main(String[] args) {
		int a = -2147447412;
		System.out.println(isPalindrome(a));
	}

	public static boolean isPalindrome(int a) {

		if (a < 0)
			return false;

		a = Math.abs(a);

		String str = String.valueOf(a);

		StringBuilder sb = new StringBuilder();

		sb.append(str);

		if (sb.reverse().toString().equalsIgnoreCase(str))
			return true;

		return false;

	}

}
