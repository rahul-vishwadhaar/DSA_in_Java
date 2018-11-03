import java.util.Scanner;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class KadaneAlgo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = null;// new int[] { -1, -2, -3, -4 };
		int inputs = 0;
		int size = -1;
		Scanner in = new Scanner(System.in);

		/*
		 * inputs = in.nextInt(); while (inputs-- > 0) { size = in.nextInt();
		 * arr = new int[size];
		 * 
		 * for (int i = 0; i < size; i++) {
		 * 
		 * arr[i] = in.nextInt(); } System.out.println(findSum(arr)); }
		 */

		arr = new int[] { -39, -69, -18, -45 };

		System.out.println(findSum(arr));
		in.close();
	}

	private static int findSum(int[] arr) {

		int len = arr.length;
		int sum = 0;
		int maxSum = arr[0];

		for (int i = 1; i < arr.length; i++) {

			sum = sum + arr[i];

			if (sum < arr[i])
				sum = arr[i];

			if (sum >= maxSum) {
				maxSum = sum;
			}

		}

		/*
		 * int max_so_far = 0, max_ending_here = 0;
		 * 
		 * for (int i = 0; i < size; i++) { max_ending_here = max_ending_here +
		 * a[i]; if (max_ending_here < 0) max_ending_here = 0; if (max_so_far <
		 * max_ending_here) max_so_far = max_ending_here; } return max_so_far;
		 */
		return maxSum;
	}

}
