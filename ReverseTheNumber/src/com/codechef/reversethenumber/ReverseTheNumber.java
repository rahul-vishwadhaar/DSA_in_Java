package com.codechef.reversethenumber;

import java.util.Scanner;

public class ReverseTheNumber {

	public static void main(String[] args) {
		int noOfCases = -1;
		long num = -1;
		int digit = -1;
		int reverse = -1;
		Scanner in = new Scanner(System.in);

		noOfCases = in.nextInt();

		while (noOfCases > 0) {
			num = in.nextLong();
			reverse = 0;
			while (num > 0) {
				digit = (int) (num % 10);
				num = num / 10;
				reverse = reverse * 10 + digit;
			}

			System.out.println(reverse);
			noOfCases--;
		}
		in.close();
	}

}
