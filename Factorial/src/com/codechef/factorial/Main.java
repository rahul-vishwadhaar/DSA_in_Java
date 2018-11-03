/**
 * 
 */
package com.codechef.factorial;

import java.util.Scanner;

/**
 * @author rahul kumar
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		long count = -1;
		long num = -1;

		long numOfZeros = -1;

		count = in.nextLong();

		while (count > 0) {
			num = in.nextLong();

			numOfZeros = getNosOfZeroes(num);
			System.out.println(numOfZeros);
			count--;
		}

	}

	private static long getNosOfFive(long num) {

		long index = 1;
		long numOfFives = 0;

		while (true) {
			long count = (long) (num / (Math.pow(5, index)));
			if (count == 0) {
				return numOfFives;
			} else
				numOfFives = numOfFives + count;

			index++;
		}

	}

	private static long getNosOfTwo(long num) {
		long index = 1;
		long numOfTwos = 0;

		while (true) {
			long count = (long) (num / (Math.pow(2, index)));
			if (count == 0) {
				return numOfTwos;
			} else
				numOfTwos = numOfTwos + count;

			index++;
		}
	}

	private static long getNosOfZeroes(long num) {
		// TODO Auto-generated method stub
		long nosOfTwos = -1;
		long noOfFives = -1;

		nosOfTwos = getNosOfTwo(num);
		noOfFives = getNosOfFive(num);

		return noOfFives < nosOfTwos ? noOfFives : nosOfTwos;
	}

}
