package com.interviewbit;

public class ReverseBit {

	public static void main(String[] args) {
		System.out.println(reverse(3));
		System.out.println(reverse(4));
		System.out.println(reverse(5));

	}

	public static long reverse(long a) {
		long result = 0;
		int count = 32;
		double num = 0;

	//	StringBuilder sb = new StringBuilder();

		while (a != 0) {
			count--;
	//		sb.append(a % 2);
			num = (double) (a % 2);
			result =  result + (long)(num * Math.pow(2.0 , count));
			a = a / 2;

		}

	//	while (count >= 0) {
	//		sb.append("0");
	//		count--;
	//	}

	//	System.out.println(sb.toString());

		return result;
	}
}
