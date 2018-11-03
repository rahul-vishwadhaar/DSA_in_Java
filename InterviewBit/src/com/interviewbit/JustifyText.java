/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author rahul
 *
 */
public class JustifyText {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] arr = { "am", "fasgoprn", "lvqsrjylg", "rzuslwan", "xlaui", "tnzegzuzn", "kuiwdc", "fofjkkkm",
				"ssqjig", "tcmejefj", "uixgzm", "lyuxeaxsg", "iqiyip", "msv", "uurcazjc", "earsrvrq", "qlq",
				"lxrtzkjpg", "jkxymjus", "mvornwza", "zty", "q", "nsecqphjy" };

		int len = 14;

		ArrayList<String> arrList = new ArrayList<String>();

		arrList.addAll(Arrays.asList(arr));

		for (String str : fullJustify(arrList, len)) {
			System.out.println(str + "Length " + str.length());
		}

	}

	public static ArrayList<String> fullJustify(ArrayList<String> a, int b) {

		ArrayList<String> result = new ArrayList<String>();
		ArrayList<String> temp = new ArrayList<String>();

		if (a.size() == 0)
			return result;

		int index = 0;
		int len = 0;
		int spaces = 0;
		int rem = 0;

		String str;

		len = b;

		while (index < a.size()) {

			if (len - a.get(index).length() >= 0) {
				temp.add(a.get(index));

				len -= a.get(index).length();
				len--;
				index++;
			} else {

				if ((temp.size() == 1)) {
					str = getString(temp, 0, 0, b);
					// System.out.println(str + " Length :" + str.length());

				} else {

					spaces = (len + 1) / (temp.size() - 1);
					rem = (len + 1) % (temp.size() - 1);
					str = getString(temp, spaces, rem, b);
				}
				temp = new ArrayList<String>();
				result.add(str);
				len = b;

			}

		}

		str = getString(temp, 0, 0, b);

		result.add(str);
		return result;
	}

	private static String getString(ArrayList<String> temp, int spaces, int rem, int maxLen) {

		StringBuilder sb = new StringBuilder();
		int i = 0;
		int maxSpace = 0;
		int index = 0;

		for (index = 0; index < temp.size() - 1; index++) {
			i = 0;
			sb.append(temp.get(index));
			maxSpace = spaces;
			if (rem > 0) {
				maxSpace = spaces + 1;
				rem--;
			}
			while (i < maxSpace + 1) {
				sb.append(" ");
				i++;
			}

		}

		sb.append(temp.get(index));

		while (sb.toString().length() < maxLen) {

			sb.append(" ");

		}

		return sb.toString();
	}
}
