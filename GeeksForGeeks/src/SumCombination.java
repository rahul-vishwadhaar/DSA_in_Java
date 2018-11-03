import java.util.Arrays;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class SumCombination {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = new int[] { 10, 1, 2, 7, 6, 1, 5 };

		int maxSum = 8;

		System.out.println(printSumCombinations(arr, maxSum));
	}

	private static int printSumCombinations(int[] arr, int maxSum) {

		Arrays.sort(arr); // nlogn
		int sum = 0;
		int count = 0;
		for (int i = 0; i < arr.length; i++) {

			if (arr[i] > maxSum)
				break;

			sum = arr[i];
			for (int j = i; j < arr.length; j++) {

				if (sum > maxSum)
					break;
				else if (sum == maxSum) {
					count++;
					break;
				} else
					sum += arr[j];
			}
		}

		return count;
	}

}
