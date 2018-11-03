import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class MaximizeTheArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int[] arr1 = null;
		int[] arr2 = null;
		int len = 0;

		int inputs = in.nextInt();

		while (inputs-- > 0) {
			len = in.nextInt();

			arr1 = new int[len];
			arr2 = new int[len];

			for (int i = 0; i < len; i++) {
				arr1[i] = in.nextInt();
			}

			for (int i = 0; i < len; i++) {
				arr2[i] = in.nextInt();
			}

			Arrays.sort(arr1);
			Arrays.sort(arr2);

			arr2 = merge(arr1, arr2);

			for (int i = 0; i < len; i++) {
				System.out.println(arr2[i]);
			}
		}
	}

	private static int[] merge(int[] arr1, int[] arr2) {
		int len = arr1.length;
		int[] arr = new int[arr1.length];
		int index = 0;
		int index1 = 0;
		int index2 = 0;

		while (len-- > 0) {

			if (arr1[index1] == arr[index2]) {
				arr[index] = arr1[index];
				index++;
				index1++;
				index2++;
			} else if (arr2[index2] > arr1[index1]) {
				arr[index] = arr[index2];
				index++;
				index2++;
			} else {
				arr[index] = arr1[index1];
				index++;
				index1++;
			}
		}
		return arr;
	}

}
