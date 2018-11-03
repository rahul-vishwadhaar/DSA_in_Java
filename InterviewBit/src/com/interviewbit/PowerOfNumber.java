/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class PowerOfNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int a = 1024000001;
		// 13530466

		boolean result = isPowerOfNumber(a);

		System.out.println(result);

	}

	private static boolean isPowerOfNumber(int a) {

		int A = 0;
		int P = 1;
		boolean result = false;
		double num;

		if (a == 0)
			return true;

		if (a == 1)
			return true;

		int max = (int) Math.sqrt(a);

		if (Math.pow(max, 2) == a)
			return true;

		for (A = 2; A < max; A++) {
			P = 1;

			while (true) {

				num = Math.pow(A, P);

				if (num == a) {

					result = true;
					break;

				} else if (num > a) {
					break;
				}

				if (result)
					break;

				P++;
			}
		}

		return result;
	}

}
