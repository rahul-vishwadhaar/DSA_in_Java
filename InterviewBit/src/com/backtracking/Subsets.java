package com.backtracking;

import java.util.ArrayList;

public class Subsets {

	public static void main(String args[]) {

		ArrayList<Integer> input = new ArrayList<Integer>();

		input.add(1);
		input.add(2);
		input.add(3);
		input.add(4);
		
		System.out.println(subsets(input));
	}

	public static ArrayList<ArrayList<Integer>> subsets(ArrayList<Integer> a) {

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		int len = a.size();
		int index = 0;
		int num = 0;

		for (int i = 0; i < Math.pow(2, len); i++) {

			ArrayList<Integer> input = new ArrayList<Integer>();
			num = i;
			index = 0;
			while (num != 0) {

				if (num % 2 == 1) {
					input.add(a.get(index));

				}
				num = num / 2;

				index++;
			}

			res.add(input);
		}

		return res;
	}
	
	
	public static ArrayList<ArrayList<Integer>> subsets2(ArrayList<Integer> a) {

		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();

		int len = a.size();
		int index = 0;
		int num = 0;

		for (int i = 0; i < Math.pow(2, len); i++) {

			ArrayList<Integer> input = new ArrayList<Integer>();
			num = i;
			index = 0;
			while (num != 0) {

				if (num % 2 == 1) {
					input.add(a.get(index));

				}
				num = num / 2;

				index++;
			}

			res.add(input);
		}

		return res;
	}

}
