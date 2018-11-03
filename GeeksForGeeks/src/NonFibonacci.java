import java.io.ObjectInputStream.GetField;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class NonFibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int inputs = 0;

		while (inputs < 20) {
			System.out.println(getNonFib(++inputs)); // in.nextInt()));
		}

		in.close();
	}

	private static int getNonFib(int num) {

		int a0 = 0;
		int a1 = 1;
		int a2 = 0;
		while (num > 0) {

			a2 = a1 + a0;

			if (a2 - a1 > 1) {
				num = num - (a2 - a1) + 1;
			}

			if (num == 0) {
				return (a2 - 1);
			} else if (num < 0) {
				return (a2 + num - 1);
			}

			a0 = a1;
			a1 = a2;

		}

		return -1;
	}

}
