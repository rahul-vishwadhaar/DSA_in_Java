/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class convertToRoman {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		convertToRoman(11);
	}

	static void convertToRoman(int n) {

		String[] arr = new String[] { "I", "II", "III", "IV", "V", "VI", "VII",
				"VIII", "IX", "X" };

		int rem = 0;
		while (n > 0) {
			rem = n % 10;

			if (rem == 0)
				rem = 10;
			System.out.print(arr[rem - 1]);

			n = n - rem;
		}

	}

}
