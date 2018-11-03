package com.interviewbit;

public class ColumnNumberToExcel {

	public static void main(String[] args) {

		for (int i = 0; i < 1000; i++) {
			System.out.println(i +" : " +getColumn(i));
		}

	}

	private static String getColumn(int a) {

		char[] chars = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
				'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

		StringBuilder sb = new StringBuilder();
		int rem = 0;

		while (a > 0) {

			rem = a % 26;

			if (rem == 0) {
				rem = 26;
				a = a - 26;
			}
			sb.append(chars[rem - 1]);
			a = a / 26;

		}

		return sb.reverse().toString();
	}

}
