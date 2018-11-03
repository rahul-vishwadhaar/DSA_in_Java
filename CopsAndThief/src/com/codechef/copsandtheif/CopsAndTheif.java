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
public class CopsAndTheif {

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

		noOfTestCases = in.nextInt();

		while (noOfTestCases > 0) {

			result = 0;
			Arrays.fill(houses, 0);
			noOfCops = in.nextInt();
			rate = in.nextInt();
			time = in.nextInt();

			range = rate * time;

			while (noOfCops > 0) {
				house = in.nextInt();
				System.out.print(house);
				house--;
				
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

			System.out.println(result);
			noOfTestCases--;
		}
		in.close();
	}

}
