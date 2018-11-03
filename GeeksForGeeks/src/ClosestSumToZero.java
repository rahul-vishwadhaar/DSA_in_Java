import java.util.*;
import java.lang.*;
import java.io.*;

public class ClosestSumToZero {

	public static void main(String[] args) {
		int inputs = -1;
		int[] arrInput = null;
		int len = -1;
		int[] arrMerged = null;

		Scanner in = new Scanner(System.in);

		inputs = in.nextInt();

		while (inputs-- > 0) {

			len = in.nextInt();

			arrInput = new int[len];

			for (int index = 0; index < len; index++) {
				arrInput[index] = in.nextInt();
			}

			arrMerged = mergeSort(arrInput, 0, len - 1);

			int minDiff = 0;
			int minIndex = 0;
			int maxIndex = 0;
			int sum = 0;

			for (int index = 0; index < len - 1; index++) {
				sum = Math.abs(arrMerged[index + 1] + arrMerged[index]);

				if (minDiff == 0) {
					minDiff = sum;
					minIndex = index;
					maxIndex = index + 1;
				} else if ((sum) < minDiff) {
					minDiff = sum;
					minIndex = index;
					maxIndex = index + 1;
				}

			}

			System.out.println(arrMerged[minIndex] + " " + arrMerged[maxIndex]);
		}
	}

	private static int[] mergeSort(int[] arr, int start, int end) {

		if (start == end)
			return new int[] { arr[start] };
		;

		int mid = (start + end) / 2;

		int[] arrA = mergeSort(arr, start, mid);

		int[] arrB = mergeSort(arr, mid + 1, end);

		return merge(arrA, arrB);

	}

	private static int[] merge(int[] arrA, int[] arrB) {

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
			}

		}
		return result;
	}

}
