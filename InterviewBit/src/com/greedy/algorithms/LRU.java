/**
 * 
 */
package com.greedy.algorithms;

import java.util.LinkedHashMap;

/**
 * @author rahul
 *
 */
public class LRU {

	/**
	 * @param args
	 */

	static int[] cache;
	static int size = 0;

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 2, 3, 2, 3, 1, 2 };
		int k = 2;

		System.out.println(pageFaults(arr, k));

		LinkedHashMap<Integer, Integer> map = new LinkedHashMap<Integer, Integer>();

	}

	public static int pageFaults(int[] arr, int cacheSize) {

		int miss = 0;
		int element = 0;

		if (arr.length <= cacheSize)
			return 0;

		cache = new int[cacheSize];
		for (int i = 0; i < arr.length; i++) {

			element = arr[i];

			if (!inCache(element)) {
				miss++;

				addInCache(i, arr);
			}

			for (int j = 0; j < cache.length; j++) {
				System.out.print(cache[j] + " ");
			}

			System.out.println("");
		}

		return miss;

	}

	private static void addInCache(int index, int[] arr) {

		if (size < cache.length) {
			cache[size++] = arr[index];
			return;
		}

		int newIndex = getPosition(index, arr);

		cache[newIndex] = arr[index];

	}

	private static int getPosition(int index, int[] arr) {

		int candidate = 0;
		int maxIndex = 0;
		int prevIndex = Integer.MAX_VALUE;

		int result = Integer.MAX_VALUE;
		boolean flag = false;

		for (int i = 0; i < size; i++) {

			candidate = cache[i];
			flag = false;

			for (int j = 0; j < index; j++) {
				if (candidate == arr[j]) {
					flag = true;
					maxIndex = j;
				}
			}

			if (!flag)
				return i;

			if (maxIndex < prevIndex) {
				prevIndex = maxIndex;
				result = i;

			}

		}
		return result;
	}

	private static boolean inCache(int element) {

		for (int i = 0; i < size; i++) {
			if (element == cache[i]) {
				return true;
			}
		}

		return false;
	}

}
