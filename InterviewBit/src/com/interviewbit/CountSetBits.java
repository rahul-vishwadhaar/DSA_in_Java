/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class CountSetBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int numSetBits(long a) {

		int count = 0;
		while (a > 0) {
			count += a & 1;
			a >>= 1;
		}
		return count;

	}
}
