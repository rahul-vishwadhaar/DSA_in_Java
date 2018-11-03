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
public class SortColours {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
         Integer[] arr = {0,0,0,1,1,0,0,1,1,1,1,0,0,1,1,1,2,2,2,2,0,1,2,2};
		 
		 
		 List<Integer> temp = Arrays.asList(arr);
		 ArrayList<Integer> a = new ArrayList<Integer>();
		 
		 a.addAll(temp);
		 
		 System.out.println(a);
		 sortColors(a);
		 
//		 System.out.println(a);

	}

	public static void sortColors(ArrayList<Integer> a) {

		int count0 = 0;
		int count1 = 0;
		int count2 = 0;

		for (Integer num : a) {

			if (num == 0) {
				count0++;
			}

			if (num == 1) {
				count1++;
			}

			if (num == 2) {
				count2++;
			}

		}

		int size = a.size();

		a.clear();

		for (int i = 0; i < size; i++) {

			if (count0 > 0) {
				a.add(0);
				count0--;
				continue;
			}

			if (count1 > 0) {
				a.add(1);
				count1--;
				continue;
			}

			if (count2 > 0) {
				a.add(2);
				count2--;
				continue;
			}
		}
		
		System.out.println(a);

	}

}
