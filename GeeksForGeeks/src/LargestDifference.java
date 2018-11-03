/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class LargestDifference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = new int[] { 2, 3, 10, 6, 4, 8, 1 };

		// arr[] = {};
		findLargestDifference(arr);

	}

	private static void findLargestDifference(int[] arr) {

		int index = -1;

		// int minElement = arr[0];
		int maxDifference = 0;
		int minIndex = 0;
		int maxIndex = 0;
		int mi1nIndex =0;

		for (index = 1; index < arr.length; index++) {

			if ( arr[index] - arr[minIndex]  > maxDifference) {
				maxDifference = arr[index] - arr[minIndex] ;
				mi1nIndex = minIndex;
				maxIndex = index;
			}
			if (arr[minIndex] > arr[index]) {
				minIndex = index;
			}
		}

		System.out.println("Min Index " + mi1nIndex + " Max Index " + maxIndex
				+ " MaxDiff " + maxDifference);
	}

}
