import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class Inversions {

	/**
	 * @param args
	 */
	static long inversions = 0;

	public static void main(String[] args) {

		int[] arr = new int[100000];
		int index = 0;
		InputStream inStream = null;
		File file = new File("C:/Users/rahul kumar/Desktop/IntegerArray.txt");
		Scanner in = null;
		try {
			in = new Scanner(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		while (in.hasNext()) {
			arr[index] = Integer.parseInt(in.nextLine());
			index++;
		}

		findNoOfInversion(arr, 0, arr.length - 1);

		System.out.println(inversions);

	}

	private static int[] findNoOfInversion(int[] arr, int start, int end) {

		if (start == end)
			return new int[] { arr[start] };
		;

		int mid = (start + end) / 2;

		int[] arrA = findNoOfInversion(arr, start, mid);

		int[] arrB = findNoOfInversion(arr, mid + 1, end);

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
				inversions = inversions + (lenA - indexA);
			}

		}
		return result;
	}

}
