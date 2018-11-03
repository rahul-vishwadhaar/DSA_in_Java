package com.dp.algorithms;

public class knapsack_0_1 {

	public static void main(String[] args) {

		int[] arr = { 2, 2, 3 };
		int W = 6;

		System.out.println(getMax(arr, W));

	}

	public static int getMax(int[] arr, int W) {

		int rows = arr.length + 1;

		int[][] space = new int[rows][W+1];

		int max = -1;

		int currWeight = 0;

		for (int i = 1; i < arr.length+1; i++) {
			currWeight = arr[i-1];

			for (int j = 1; j < W+1; j++) {

				if (j < currWeight) {
					space[i][j] = space[i - 1][j];
				} else {
					space[i][j] = Math.max(space[i - 1][j], currWeight + space[i - 1][j - currWeight]);
				}
				
				if(space[i][j] > max){
					max = space[i][j];
				}
			}
		}

		return max;
	}

}
