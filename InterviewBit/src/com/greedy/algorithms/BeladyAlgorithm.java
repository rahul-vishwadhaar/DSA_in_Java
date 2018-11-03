/**
 * 
 */
package com.greedy.algorithms;

/**
 * @author rahul
 *
 */
public class BeladyAlgorithm {

	/**
	 * @param args
	 */
	static int[] cache;
	static int size = 0;

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 2, 3, 2, 3, 1, 2 };
		int k = 3;

		System.out.println(farthestFirst(arr, k));

	}

	public static int farthestFirst(int[] arr, int cacheSize) {

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
		int minIndex = 0;
		int result = 0;
		boolean flag = false;

		for (int i = 0; i < size; i++) {
			candidate = cache[i];
			flag = false;
			for (int j = index + 1; j < arr.length; j++) {
				if (arr[j] == candidate) {
					flag = true;
					if (j > minIndex) {
						minIndex = j;
						result = i;
					}
					break;
				}

				if (!flag) {
					return i;
				}
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
