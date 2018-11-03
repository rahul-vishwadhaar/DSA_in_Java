import java.util.Scanner;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class ExcelSheet {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int num = 0;
		int inputs = in.nextInt();

		while (inputs-- > 0) {
			num = in.nextInt();
			System.out.println(getColoumn(num)); // in.nextInt()));
		}

		in.close();
	}

	private static String getColoumn(int num) {
		char init = 'A';
		int rem = 0;
		String result = "";
		while (num != 0) {
			init = 'A';
			rem = num % 26;

			if (rem == 0) {
				rem = 26;
				num = (num - 1) / 26;
			} else {
				num = num / 26;
			}
			while (rem-- > 1) {
				init++;
			}

			result = init + result;
		}
		return result;
	}

}
