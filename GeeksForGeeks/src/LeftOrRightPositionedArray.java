import java.util.HashMap;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class LeftOrRightPositionedArray {

	/**
	 * @param args
	 */

	private static HashMap<Integer, Integer> map = null;

	public static void main(String[] args) {

		/*
		 * int[] arr = new int[] { 1, 6, 5, 4, 3, 2, 1 };
		 * 
		 * System.out.println(getResult(arr));
		 * 
		 * arr = new int[] { 1, 3, 3, 2 };
		 * 
		 * System.out.println(getResult(arr));
		 */

		Scanner in = new Scanner(System.in);
		int[] arr = null;
		int inputs = in.nextInt();
		int len = -1;
		while (inputs-- > 0) {
			len = in.nextInt();

			arr = new int[len];

			for (int i = 0; i < len; i++) {
				arr[i] = in.nextInt();
			}

			System.out.println(getResult(arr));
		}

		in.close();
	}

	public static int getResult(int[] arr) {
		int result = 0;
		int len = arr.length;
		int value = 1;
		map = new HashMap<Integer, Integer>();

		for (int i = 0; i < len; i++) {
			value = 1;
			if (map.containsKey(arr[i])) {
				value += map.get(arr[i]);
			}
			map.put(arr[i], value);
		}

		for (int i = 0; i < len; i++) {
			if (map.containsKey(i)) {
				updateMap(i);
			} else if (map.containsKey(len - i - 1)) {
				updateMap(len - i - 1);
			} else {
				result = 0;
				break;
			}
			result = 1;
		}

		return result;
	}

	public static void updateMap(int i) {
		int value = 0;
		if ((value = map.get(i)) == 1) {
			map.remove(i);
		} else {
			value--;
			map.replace(i, value);
		}

	}
}
