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
public class IntersectionOfSortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Integer[] arr1 = { 1, 3, 8, 10, 13, 13, 16, 16, 16, 18, 21, 23, 24, 31, 31, 31, 33, 35, 35, 37, 37, 38, 40, 41, 43, 47, 47, 48, 48, 52, 52, 53, 53, 55, 56, 60, 60, 61, 61, 63, 63, 64, 66, 67, 67, 68, 69, 71, 80, 80, 80, 80, 80, 80, 81, 85, 87, 87, 88, 89, 90, 94, 95, 97, 98, 98, 100, 101 };

		List<Integer> temp = Arrays.asList(arr1);
		ArrayList<Integer> a = new ArrayList<Integer>();

		a.addAll(temp);

		Integer[] arr2 = { 5, 7, 14, 14, 25, 28, 28, 34, 35, 38, 38, 39, 46, 53, 65, 67, 69, 70, 78, 82, 94, 94, 98 };

		List<Integer> temp1 = Arrays.asList(arr2);
		ArrayList<Integer> b = new ArrayList<Integer>();

		a.addAll(temp);
		b.addAll(temp1);

		System.out.println(intersect(a, b));

	}

	public static ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {

		ArrayList<Integer> res = new ArrayList<Integer>();

		int size = (a.size() > b.size()) ? a.size() : b.size();
		int indexA = 0;
		int indexB = 0;

		for (int i = 0; i < size; i++) {

			
			if(indexA >= a.size()){
				break;
			}
			
			if(indexB >= b.size()){
				break;
			}
			
			if (a.get(indexA).equals(b.get(indexB))) {
				res.add(a.get(indexA));
				indexA++;
				indexB++;
//				continue;
			}else if (a.get(indexA) < b.get(indexB)) {
				indexA++;
//				continue;
			}else {
				indexB++;
//				continue;
			}
			
			

		}

		return res;

	}

}
