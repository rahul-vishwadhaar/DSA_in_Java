package com.interviewbit;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class removeDuplicates2 {

	public static void main(String[] args) {
	
		 Integer[] arr = {0,0,0,0,0,1,1,1,1,1,1,1,2,2,2,2,2,2};
		 
		 
		 List<Integer> temp = Arrays.asList(arr);
		 ArrayList<Integer> a = new ArrayList<Integer>();
		 
		 a.addAll(temp);
		 
		 
		 System.out.println(removeDuplicates(a));
		 
		 System.out.println(a);
	}
	

	public static int removeDuplicates(ArrayList<Integer> a) {

		int prev = 0;
		int count = 0;

		Integer[] arr = new Integer[a.size()];
		
		for(int i =0; i< a.size() ;i++){
			arr[i] = a.get(i);
		}

		a.clear();

		a.add(arr[0]);
		prev = arr[0];
		count = 1;

		for (int i = 1; i < arr.length; i++) {

			if (arr[i] == prev) {
				count++;
			} else {
				count = 1;
			}

			if (count <= 2) {
				a.add(arr[i]);
			}
			prev = arr[i];

		}
		
		System.out.println(a);
		return a.size();

	}
}
