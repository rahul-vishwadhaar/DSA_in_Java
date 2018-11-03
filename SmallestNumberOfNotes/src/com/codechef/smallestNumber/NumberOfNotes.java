package com.codechef.smallestNumber;

import java.util.Scanner;

public class NumberOfNotes {

	public static void main(String[] args) {

		int noOftestCases = -1;
		long input = -1;
		int noOfNotes = -1;

		Scanner in = new Scanner(System.in);

		noOftestCases = in.nextInt();

		while (noOftestCases > 0) {
			noOfNotes = 0;
			input = in.nextLong();
			noOfNotes = getMinimumNoOfNotes(input);
			System.out.println(noOfNotes);
			noOftestCases--;
		}
		in.close();
	}

	private static int getMinimumNoOfNotes(long input) {
		int note1 = 1;
		int note2 = 2;
		int note5 = 5;
		int note10 = 10;
		int note50 = 50;
		int note100 = 100;
		long noOfNotes = 0;

		noOfNotes = input / note100;
		input = input % note100;

		if (input == 0)
			return (int) noOfNotes;

		noOfNotes = noOfNotes + input / note50;
		input = input % note50;

		if (input == 0)
			return (int) noOfNotes;

		noOfNotes = noOfNotes + input / note10;
		input = input % note10;

		if (input == 0)
			return (int) noOfNotes;

		noOfNotes = noOfNotes + input / note5;
		input = input % note5;

		if (input == 0)
			return (int) noOfNotes;

		noOfNotes = noOfNotes + input / note2;
		input = input % note2;

		if (input == 0)
			return (int) noOfNotes;

		noOfNotes = noOfNotes + input / note1;

		return (int) noOfNotes;

	}

}
