/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class MedianOfTwoSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr1 = new int[] { 1, 3, 5, 7, 9 };
		int[] arr2 = new int[] { 2, 4, 6, 8 };

		System.out.println(median(arr1, arr2));

	}

	private static double median(int[] arr1, int[] arr2) {
		return getMedian(arr1, 0, arr1.length - 1, arr2);
	}

	private static double getMedian(int[] arr1, int start, int end, int[] arr2) {

		int i = (start + end) / 2;
		int j;

		j = (arr1.length + arr2.length) / 2 - i;

		if ((arr2[j] <= arr1[i]) && (arr1[i] <= arr2[j + 1])) {
			return arr1[i];
		} else if (arr1[i] < arr2[j]) {
			start = i;
		} else {
			end = i;
		}

		return getMedian(arr1, start, end, arr2);
	}

}
