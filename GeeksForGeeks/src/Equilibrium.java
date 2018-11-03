import java.util.Scanner;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class Equilibrium {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int testCases = in.nextInt();
		int size = 0;
		int[] arr = null;

		while (testCases-- > 0) {

			size = in.nextInt();
			arr = new int[size];

			for (int index = 0; index < size; index++) {
				arr[index] = in.nextInt();
			}

			System.out.println(findEquilibrium(arr));
		}

		in.close();
	}

	private static int findEquilibrium(int arr[]) {
		int index = -1;
		int i = 0;
		int len = arr.length;
		int sumI = 0;
		int sumLen = 0;
		int prevI = -1;
		int prevLen = -1;
		len--;

		if (i == len) {
			return i + 1;
		}
		while (i <= len) {

			if (i != prevI) {
				sumI += arr[i];
				prevI = i;

			}
			if (len != prevLen) {
				sumLen += arr[len];
				prevLen = len;
			}

			if ((sumI == sumLen) && (len - i == 2)) {
				index = i + 1;
				break;
			}

			if (sumI < sumLen) {
				i++;
			} else if (sumLen < sumI) {
				len--;
			} else {
				i++;
				len--;
			}

		}

		return (index == -1) ? index : index + 1;

	}
}
