/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class CoPrimeDivisor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {// TODO Auto-generated method stub

		System.out.println(cpFact(30, 12));
	}

	public static int cpFact(int A, int B) {

		int count = 1;

		for (int i = A; i >= 1; i = A / count) {

			if(A%count != 0){
				count++;
				continue;
			}
			if (gcd(i, B) == 1)
				return i;

			count++;
		}

		return 1;
	}

	static int gcd(int a, int b) {
		// Everything divides 0
		if (a == 0 || b == 0)
			return 0;

		// base case
		if (a == b)
			return a;

		// a is greater
		if (a > b)
			return gcd(a - b, b);
		return gcd(a, b - a);
	}

}
