/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;

/**
 * @author rahul
 *
 */
public class PrimeSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public ArrayList<Integer> primesum(int a) {

		boolean flags[] = new boolean[a];
		int index = 2;
		int p = 0;

		while (index < a) {

			if (flags[index] == false) {
				p = index * 2;
				for (int i = p; i < a; i += index) {
					flags[i] = true;
				}

			}
			index++;
		}

		int num1 = 1;
		int num2 = 2;
		int sum = 3;

		int diff = a - sum;

		while (sum != a) {

			while (flags[num2] != true) {
				num2++;
			}

			sum = num1 + num2;
		}

		return null;
	}
}
