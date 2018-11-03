/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rahul
 *
 */
public class RemoveDuplicates {
	
	private static void foo(List<Integer> a) {
		a.add(1);
		a = null;
	}
	
	private static boolean equal (Integer a, Integer b) {
		return a == b;
	}
	
	private static void print(int a) {
		System.out.println(a);
	}
	
	private static Integer foo() {
		if (true) {
			return null;
		}
		return 0;
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
	//	System.out.println(equal(121, 121));
		System.out.println(equal(100, 100));
		print(foo());
		System.exit(0);
		
		
		
		final String s1 = "job";
		final String s2 = "seeker";
		final String s3 = s1.concat(s2);
		final String s4 = "jobseeker";
		System.out.println(s3 == s4);
		
		System.exit(0);

		ArrayList<Integer> a = new ArrayList<Integer>();
		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(4);
		a.add(5);
		a.add(6);
		a.add(7);
		// a.add(1);
		// a.add(2);

		System.out.println(removeDuplicates(a));

		System.out.println(a);

	}

	public static int removeDuplicates(ArrayList<Integer> a) {
		
		int newLength = 0;
		int prev = Integer.MAX_VALUE;

		Integer[] arr = a.toArray(new Integer[a.size()]);
		a.clear();

		for (int i = 0; i < arr.length; i++) {

			if (prev != arr[i]) {
				prev = arr[i];
				newLength++;
				a.add(arr[i]);
			}
		}

		return newLength;

	}

}
