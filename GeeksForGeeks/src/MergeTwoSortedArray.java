import java.util.Scanner;

class MergeTwoSortedArray {
	public static void main(String[] args) {

		int inputs = 0;
		int arr1Size = 0;
		int arr2Size = 0;
		int index = 0;
		int[] arr1 = null;
		int[] arr2 = null;
		int[] result = null;
		Scanner in = new Scanner(System.in);

		inputs = in.nextInt();

		while (inputs-- > 0) {

			result = null;
			arr1Size = in.nextInt();
			arr2Size = in.nextInt();
			index = 0;
			arr1 = new int[arr1Size];
			arr2 = new int[arr2Size];

			while (arr1Size-- > 0) {
				arr1[index] = in.nextInt();
				index++;
			}

			index = 0;

			while (arr2Size-- > 0) {
				arr2[index] = in.nextInt();
				index++;
			}

			result = mergeArray(arr1, arr2);

			for (index = 0; index < result.length; index++) {
				System.out.print(result[index] + " ");
			}

		}
	}

	private static int[] mergeArray(int[] arr1, int[] arr2) {

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
			} else if (arr1[index1] > arr2[index2]) {
				result[index] = arr1[index1];
				index1++;
			} else {
				result[index] = arr2[index2];
				index2++;
			}
			index++;
		}
		return result;
	}

}