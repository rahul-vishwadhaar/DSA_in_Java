import java.util.HashMap;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class LargestSubArrayWithZeroSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] arr = new int[] { 15, -2, 2, -8, 1, 7, 10, 23 };

		System.out.println(maxLen(arr));
	}

	static int maxLen(int arr[]) {
		int len = arr.length;
		int maxLen = 0;
		int sum = 0;
		int index;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < len; i++) {

			sum += arr[i];

			if (map.get(sum) != null) {
				index = map.get(sum);
				maxLen = (maxLen > (i - index)) ? maxLen : (i - index);
			} else {
				map.put(sum, i);
			}

		}

		if (sum == 0)
			return len;
		return maxLen;

	}

}
