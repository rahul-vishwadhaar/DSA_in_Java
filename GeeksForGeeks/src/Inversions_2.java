import java.util.*;
import java.lang.*;
import java.io.*;

class Inversions_2 {

	static int inversions = 0;

	public static void main(String[] args) {
		int inputs = 0;
		int[] arr = new int[] { 468, 335, 1, 170, 225, 479, 359, 463, 465, 206,
				146, 282, 328, 462, 492, 496, 443, 328, 437, 392, 105, 403,
				154, 293, 383, 422, 217, 219, 396, 448, 227, 272, 39, 370, 413,
				168, 300, 36, 395, 204, 312, 323 };
		int index = 0;
		int len = 0;

		// Scanner in = new Scanner(System.in);

		// inputs = in.nextInt();
		/*
		 * while (inputs-- > 0) { inversions = 0;
		 * 
		 * index = 0; len = in.nextInt();
		 * 
		 * arr = new int[len]; while (len-- > 0) { arr[index] = in.nextInt();
		 * index++; }
		 */

		mergeSort(arr, 0, arr.length - 1);
		System.out.println(inversions);
		
		inversions = 0;
		findNoOfInversion(arr, 0, arr.length-1);
		System.out.println(inversions);
		
		// }

		// in.close();
	}

	private static int[] mergeSort(int arr[], int start, int end) {
		int mid = 0;
		int[] arr1 = null;
		int[] arr2 = null;

		if (start >= end)
			return new int[] { arr[start] };

		mid = (start + end) / 2;

		arr1 = mergeSort(arr, start, mid);
		arr2 = mergeSort(arr, mid + 1, end);

		return merge(arr1, arr2);

	}

	private static int[] merge(int[] arr1, int[] arr2) {

		int len1 = arr1.length;
		int len2 = arr2.length;
		int index = 0;
		int index1 = 0;
		int index2 = 0;
		int[] result = new int[len1 + len2];

		while (index < (len1 + len2)) {
			if (index1 == len1) {
				result[index] = arr2[index2];
				index2++;
			} else if (index2 == len2) {
				result[index] = arr1[index1];
				index1++;
			} else if (arr1[index1] < arr2[index2]) {
				result[index] = arr1[index1];
				index1++;
			} else {
				result[index] = arr2[index2];
				index2++;
				inversions = inversions + (len1 - index1);
			}
			index++;
		}

		return result;
	}

	private static int[] findNoOfInversion(int[] arr, int start, int end) {

		if (start == end)
			return new int[] { arr[start] };
		;

		int mid = (start + end) / 2;

		int[] arrA = findNoOfInversion(arr, start, mid);

		int[] arrB = findNoOfInversion(arr, mid + 1, end);

		return merge1(arrA, arrB);

	}

	private static int[] merge1(int[] arrA, int[] arrB) {

		int lenA = arrA.length;
		int lenB = arrB.length;
		int[] result = new int[lenA + lenB];
		int indexA = 0;
		int indexB = 0;

		for (int i = 0; i < lenA + lenB; i++) {

			if (indexA == lenA) {
				result[i] = arrB[indexB];
				indexB++;
				continue;
			}

			if (indexB == lenB) {
				result[i] = arrA[indexA];
				indexA++;
				continue;
			}

			if (arrA[indexA] < arrB[indexB]) {
				result[i] = arrA[indexA];
				indexA++;
			} else {
				result[i] = arrB[indexB];
				indexB++;
				inversions = inversions + (lenA - indexA);
			}

		}
		return result;
	}

}