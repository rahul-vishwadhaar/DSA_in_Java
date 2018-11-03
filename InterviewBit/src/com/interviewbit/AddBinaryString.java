/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class AddBinaryString {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		String str1 = "1010110111001101101000";
		String str2 = "1000011011000000111100110";

		System.out.println(addBinary(str1, str2));
	}

	public static String addBinary(String a, String b) {

		StringBuffer sb = new StringBuffer();

		int len = (a.length() > b.length()) ? a.length() : b.length();
		int carry = 0;
		int index = 0;
		int result = 0;
		int a1 = 0;
		int b1 = 0;

		while (len-- > 0) {
			a1 = 0;
			b1 = 0;
			result = 0;

			if ((index < a.length()) && (index < b.length())) {

				a1 = a.charAt(a.length() - index - 1) - 48;
				b1 = b.charAt(b.length() - index - 1) - 48;
			} else if (index < a.length()) {

				a1 = a.charAt(a.length() - index - 1) - 48;

			} else {
				b1 = b.charAt(b.length() - index - 1) - 48;

			}

			if (a1 + b1 + carry == 3) {
				result = 1;
				carry = 1;

			} else if (a1 + b1 + carry == 2) {
				result = 0;
				carry = 1;
			} else if (a1 + b1 + carry == 1) {
				result = 1;
				carry = 0;
			} else {
				result = 0;
				carry = 0;
			}

			sb.append(result);
			index++;
		}
		if (carry == 1)
			sb.append(carry);

		return sb.reverse().toString();
	}

}
