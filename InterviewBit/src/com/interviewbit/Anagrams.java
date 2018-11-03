/**
 * 
 */
package com.interviewbit;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author rahul
 *
 */
public class Anagrams {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean anagram(String a, String b) {

		boolean status = false;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char ch = 0;

		for (int i = 0; i < a.length(); i++) {
			ch = a.charAt(i);

			if (map.containsKey(ch)) {
				map.put(ch, map.get(ch) + 1);
			} else {
				map.put(ch, 1);
			}
		}

		int count = 0;
		for (int i = 0; i < b.length(); i++) {
			ch = a.charAt(i);

			if (map.containsKey(ch)) {

				count = map.get(ch);
				if (count > 1) {
					map.put(ch, count - 1);
				} else {
					map.remove(ch);
				}
			} else {
				return false;
			}
		}

		if (map.isEmpty())
			return true;

		return false;

	}

}
