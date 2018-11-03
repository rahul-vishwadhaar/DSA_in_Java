import java.util.Arrays;
import java.util.HashMap;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class IntegerToRoman {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(convertIntegerToRoman(0));
		System.out.println(convertIntegerToRoman(123));
		System.out.println(convertIntegerToRoman(3999));
		System.out.println(convertIntegerToRoman(14));
		System.out.println(convertIntegerToRoman(0));
		

	}

	private static String convertIntegerToRoman(int num) {
		StringBuilder sb = new StringBuilder();

		int index = -1;
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 40, 50, 90, 100,
				400, 500, 900, 1000 };

		HashMap<Integer, String> symbols = new HashMap<Integer, String>();

		symbols.put(1, "I");
		symbols.put(2, "II");
		symbols.put(3, "III");
		symbols.put(4, "IV");
		symbols.put(5, "V");
		symbols.put(6, "VI");
		symbols.put(7, "VII");
		symbols.put(8, "VIII");
		symbols.put(9, "IX");
		symbols.put(10, "X");
		symbols.put(40, "XL");
		symbols.put(50, "L");
		symbols.put(90, "XC");
		symbols.put(100, "C");
		symbols.put(400, "CD");
		symbols.put(500, "D");
		symbols.put(900, "CM");
		symbols.put(1000, "M");

		while (num > 0) {
			if(num > 1000)
				index = 17;
			else
				index = binarySearch(arr, num, 0, arr.length);

			if (arr[index] > num) {
				index--;
			}
			try {
				sb.append(symbols.get(arr[index]));
			} catch (Exception e) {
				return null;
			}

			num -= arr[index];
		}
		return sb.toString();
	}

	private static int binarySearch(int[] arr, int num, int start, int end) {

		if (start >= end)
			return start;

		int mid = (start + end) / 2;

		if (arr[mid] == num)
			return mid;

		if (arr[mid] < num)
			return binarySearch(arr, num, mid + 1, end);
		return binarySearch(arr, num, start, mid - 1);

	}
}
