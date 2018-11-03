import java.util.Scanner;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class SearchRotatedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int inputs = -1;
		int len = -1;
		int[] arr = null;
		int index = 0;
		int key = 0;
		int pivot = 0;

		Scanner in = new Scanner(System.in);

		inputs = in.nextInt();

		while (inputs-- > 0) {
			len = in.nextInt();
			index = 0;
			arr = new int[len];

			while (index < len) {
				arr[index] = in.nextInt();
				index++;
			}

			key = in.nextInt();

			pivot = findPivot(arr, 0, len - 1);

			if (pivot == -1) {
				System.out.println(binarySearch(arr, 0, len - 1, key));
				return;
			}

			if (key == arr[pivot]) {
				System.out.println(pivot);
			} else if (key > arr[0]) {
				System.out.println(binarySearch(arr, 0, pivot, key));
			} else {
				System.out.println(binarySearch(arr, pivot + 1, len - 1, key));
			}
		}
		in.close();
	}

	private static int findPivot(int[] arr, int low, int high) {

		if (high < low)
			return -1;
		if (high == low)
			return low;

		int mid = (low + high) / 2; /* low + (high - low)/2; */
		if (mid < high && arr[mid] > arr[mid + 1])
			return mid;
		if (mid > low && arr[mid] < arr[mid - 1])
			return (mid - 1);
		if (arr[low] >= arr[mid])
			return findPivot(arr, low, mid - 1);
		else
			return findPivot(arr, mid + 1, high);

	}

	private static int binarySearch(int[] arr, int low, int high, int key) {
		int mid = -1;

		if (low > high)
			return -1;

		if (low == high)
			if (arr[low] == key)
				return low;
			else
				return -1;

		mid = (high + low) / 2;

		if (arr[mid] == key)
			return mid;

		if (arr[mid] < key)
			return binarySearch(arr, mid + 1, high, key);

		return binarySearch(arr, low, mid - 1, key);

	}

}
