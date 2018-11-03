import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class NextPermutation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int inputs = 1;
		int len = 6;
		int[] arr = null;

	//	inputs = in.nextInt();

		while (inputs-- > 0) {

			len = 13; //in.nextInt();
			arr = new int[] {62, 92, 96, 43, 28, 37, 92, 5, 3, 54, 93, 83, 22};
	//		for (int i = 0; i < len; i++) {
	//			arr[i] = in.nextInt();
	//		}
			
			arr = nextPermutation(arr);

			for (int i = 0; i < len; i++) {
				System.out.print(arr[i] + " ");
			}
		}

		in.close();

	}

	private static int[] nextPermutation(int[] arr) {

		int len = arr.length;
		int index = 0;
		int item = arr[len - 1];
		int temp = -1;

		for (index = len - 2; index > -1; index--) {

			if (arr[index] < item) {
				temp = arr[index];
				arr[index] = item;
				arr[len - 1] = temp;
				break;
			}
		}
System.out.println();
		Arrays.sort(arr, index + 1, len);
		return arr;
	}

}
