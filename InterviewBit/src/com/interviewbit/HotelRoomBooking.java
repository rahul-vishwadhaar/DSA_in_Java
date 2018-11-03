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
public class HotelRoomBooking {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Integer[] A = { 1, 2, 3 };
		Integer[] B = { 2, 3, 4};
		int K = 1;

		// Integer[] A = { 9, 47, 17, 39, 35, 35, 20, 18, 15, 34, 11, 2, 45, 46,
		// 15, 33, 47, 47, 10, 11, 27 };
		// Integer[] B = { 32, 82, 39, 86, 81, 58, 64, 53, 40, 76, 40, 46, 63,
		// 88, 56, 52, 50, 72, 22, 19, 38 };
		// int K = 16;

		ArrayList<Integer> arrive = new ArrayList<Integer>(Arrays.asList(A));
		ArrayList<Integer> depart = new ArrayList<Integer>(Arrays.asList(B));

		System.out.println(hotel(arrive, depart, K));

	}

	public static boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {

		sort(arrive, depart);
		int startJ = 0;
		int endJ = 0;
		int count = 0;

		for (int j = 0; j < arrive.size(); j++) {

			count = 1;
			startJ = arrive.get(j);
			endJ = depart.get(j);

			for (int i = 0; i < j; i++) {
				if (depart.get(i) > startJ) {
					count++;
				}
			}

			if (count > K)
				return false;

		}

		return true;
	}

	// heapsort that keeps arrive:depart index in sync
	public static void sort(ArrayList<Integer> arrive, ArrayList<Integer> depart) {
		int n = arrive.size();

		// Build heap (rearrange array)
		for (int i = n / 2 - 1; i >= 0; i--) {
			heapify(arrive, depart, n, i);
		}

		// One by one extract an element from heap
		for (int i = n - 1; i >= 0; i--) {
			// Move current root to end
			int temp = arrive.get(0);
			arrive.set(0, arrive.get(i));
			arrive.set(i, temp);

			// maintain arrive:depart relationship
			int tempD = depart.get(0);
			depart.set(0, depart.get(i));
			depart.set(i, tempD);

			// call max heapify on the reduced heap
			heapify(arrive, depart, i, 0);
		}
	}

	// To heapify a subtree rooted with node i which is
	// an index in arr[]. n is size of heap
	static void heapify(ArrayList<Integer> arrive, ArrayList<Integer> depart, int n, int i) {
		int largest = i; // Initialize largest as root
		int l = 2 * i + 1; // left = 2*i + 1
		int r = 2 * i + 2; // right = 2*i + 2

		// If left child is larger than root
		if (l < n && arrive.get(l) > arrive.get(largest)) {
			largest = l;
		}

		// If right child is larger than largest so far
		if (r < n && arrive.get(r) > arrive.get(largest)) {
			largest = r;
		}

		// If largest is not root
		if (largest != i) {
			int swap = arrive.get(i);
			arrive.set(i, arrive.get(largest));
			arrive.set(largest, swap);

			// maintain arrive:depart relationship
			int swapD = depart.get(i);
			depart.set(i, depart.get(largest));
			depart.set(largest, swapD);

			// Recursively heapify the affected sub-tree
			heapify(arrive, depart, n, largest);
		}
	}

}
