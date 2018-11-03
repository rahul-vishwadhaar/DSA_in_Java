/**
 * 
 */
package com.codechef.copsandtheif;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

/**
 * @author rahul kumar
 * 
 */
public class CopsAndThiefRandom {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int noOfTestCases = -1;
		Scanner in = new Scanner(System.in);
		int[] houses = new int[100];
		int noOfCops = -1;
		int rate = 0;
		int time = 0;
		int house = 0;
		int range = 0;
		int upperLimit = 0;
		int lowerLimit = 0;
		int result = 0;

		Random rand = new Random();

		noOfTestCases = rand.nextInt(10000);
		System.out.println("TestCases : " + noOfTestCases);
		int index = 0;
		while (noOfTestCases > 0) {
			System.out.println("Test Case : " + index + 1);
			result = 0;
			Arrays.fill(houses, 0);
			noOfCops = rand.nextInt(10);// in.nextInt();
			rate = rand.nextInt(10);// in.nextInt();
			time = rand.nextInt(10);// in.nextInt();

			System.out.println("Cops " + noOfCops + " rate: " + rate
					+ " time: " + time + " ");
			range = rate * time;

			while (noOfCops > 0) {
				house = rand.nextInt(99);// in.nextInt();
				// house--;
				System.out.print(house + " ");
				houses[house] = 1;

				if ((house + range) >= 100)
					upperLimit = 99;
				else
					upperLimit = house + range;

				if ((house - range) <= 0)
					lowerLimit = 0;
				else
					lowerLimit = (house - range);
				Arrays.fill(houses, lowerLimit, upperLimit + 1, 1);

				noOfCops--;
			}

			for (int i = 0; i < 100; i++) {
				if (houses[i] == 0)
					result++;
			}

			System.out.println("Result :" + result);
			noOfTestCases--;
		}
		in.close();
	}

}
