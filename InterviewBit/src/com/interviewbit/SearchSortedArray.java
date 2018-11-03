/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author rahul
 *
 */
public class SearchSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<Integer>();

		arr.add(4);
		arr.add(1);

		arr.add(2);

		arr.add(3);

		Integer[] a = { 101, 103, 106, 109, 158, 164, 182, 187, 202, 205, 2, 3, 32, 57, 69, 74, 81, 99, 100 };
		System.out.println(search(Arrays.asList(a), 202));

	}

	public static int search(final List<Integer> a, int b) {

		int key = b;
		int n = a.size();

		int pivot = findPivot(a, 0, n - 1);

		// If we didn't find a pivot, then
		// array is not rotated at all
		if (pivot == -1)
			return binarySearch(a, 0, n - 1, key);

		// If we found a pivot, then first
		// compare with pivot and then
		// search in two subarrays around pivot
		if (a.get(pivot) == key)
			return pivot;
		if (a.get(0) <= key)
			return binarySearch(a, 0, pivot - 1, key);
		return binarySearch(a, pivot + 1, n - 1, key);

	}

	static int binarySearch(List<Integer> a, int low, int high, int key) {
		if (high < low)
			return -1;

		/* low + (high - low)/2; */
		int mid = (low + high) / 2;
		if (key == a.get(mid))
			return mid;
		if (key > a.get(mid))
			return binarySearch(a, (mid + 1), high, key);
		return binarySearch(a, low, (mid - 1), key);
	}

	static int findPivot(List<Integer> a, int low, int high) {
		// base cases
		if (high < low)
			return -1;
		if (high == low)
			return low;

		/* low + (high - low)/2; */
		int mid = (low + high) / 2;
		if (mid < high && a.get(mid) > a.get(mid + 1))
			return mid;
		if (mid > low && a.get(mid) < a.get(mid - 1))
			return (mid - 1);
		if (a.get(low) >= a.get(mid))
			return findPivot(a, low, mid - 1);
		return findPivot(a, mid + 1, high);
	}

}
