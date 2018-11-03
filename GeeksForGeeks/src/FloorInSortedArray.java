import java.util.Scanner;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class FloorInSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int inputs = 0;
		int size = 0;

		int num = 0;
		int[] arr = null;

		Scanner in = new Scanner(System.in);

		inputs = in.nextInt();

		while (inputs-- > 0) {

			size = in.nextInt();
			num = in.nextInt();
			arr = new int[size];

			for (int i = 0; i < size; i++) {
				arr[i] = in.nextInt();
			}

			System.out.println(findFloor(arr, num));
		}

		in.close();

	}

	private static int findFloor(int[] arr, int num) {

		if (num < arr[0])
			return -1;

		if (num > arr[arr.length - 1])
			return arr.length - 1;

		return binarySearch(arr, 0, arr.length - 1, num);
	}

	private static int binarySearch(int[] arr, int start, int end, int num) {

		if (start == end)
			return start;

		int mid = (start + end) / 2;

		if (arr[mid] == num) {

			if ((mid < end) && (arr[mid + 1] == num))
				return binarySearch(arr, mid + 1, end, num);

			return mid;
		}

		if (arr[mid] < num)
			return binarySearch(arr, mid+1, end, num);

		return binarySearch(arr, start, mid, num);
	}

}
