import java.util.Scanner;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class FaultyKeyboard {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int inputs = 1;
		int num = 0;
		Scanner in = new Scanner(System.in);

		// inputs = in.nextInt();

		while (inputs-- > 0) {

			// num = in.nextInt();
			int i = 6464;
			 System.out.println(i + ":" + getMaxNum(i));

			for (i = 0; i <= 6464; i++) {
				System.out.println(i + ":" + getMaxNum(i));
			}
		}

		in.close();

	}

	private static int getMaxNum(int num) {
		int result = 0;

		if (num < 10) {
			result = num;
		} else if (num < 190) {
			result = 10 + (num - 10) / 2;
		} else if (num < 2890) {
			result = 100 + (num - 190) / 3;
		} else {
			result = 1000 + (num - 2890) / 4;
		}

		return result;
	}

}
