package com.interviewbit;

import java.util.ArrayList;
import java.util.Collections;

public class FindMinXOR {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int findMinXor(ArrayList<Integer> A) {

		Collections.sort(A);

		int current = 0;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < A.size() - 1; i++) {

			current = A.get(i) ^ A.get(i + 1);

			if (current < min)
				min = current;
		}

		return min;
	}

}
