/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

/**
 * @author rahul
 *
 */
public class Anagrams_2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<String> input = new ArrayList<String>();

		input.add("cat");
		input.add("dog");
		input.add("god");
		input.add("tca");
		input.add("cat");

		System.out.println(anagrams(input));

	}

	public static ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();

		HashMap<String, ArrayList<Integer>> map = new HashMap<String, ArrayList<Integer>>();

		char[] arr = null;
		int index = 1;
		String st;
		ArrayList<Integer> temp = null;
		for (String str : a) {
			temp = null;
			arr = str.toCharArray();
			Arrays.sort(arr);

			st = String.valueOf(arr);
			if (map.containsKey(st)) {
				temp = map.get(st);
				temp.add(index);
			} else {
				temp = new ArrayList<Integer>();
				temp.add(index);

			}
			map.put(st, temp);
			
			index++;
		}

		result.addAll(map.values());

		return result;

	}
}
