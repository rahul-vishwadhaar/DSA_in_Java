/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class GasStation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static int getStartingGasStation(int[] gas, int[] cost) {

		int prevS = 0;
		int current = 0;
		int minIndex = 0;

		int[] s = new int[gas.length];

		int min = Integer.MAX_VALUE;

		for (int i = 0; i < gas.length; i++) {

			current = gas[i] - cost[i];
			s[i] = current + prevS;
			prevS = current;

			if (s[i] < min) {
				min = s[i];
				minIndex = i;
			}
		}

		if (s[gas.length - 1] < 0) {
			return -1;
		}

		if (s[gas.length - 1] == 0) {
			return 1;
		}

		return minIndex + 1;

	}

}
