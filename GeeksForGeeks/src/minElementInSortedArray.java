import java.util.Scanner;

public class minElementInSortedArray {
	public static void main(String[] args) {

		int inputs = -1;
		int len = -1;
		int[] arr = null;
		int index = 0;
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

			pivot = findPivot(arr, 0, len - 1);

			if (pivot == -1) {
				System.out.println(arr[0]);
			} else {
				System.out.println(arr[pivot + 1]);
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
}
