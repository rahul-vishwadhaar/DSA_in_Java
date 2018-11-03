import java.util.Scanner;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class BuldingsSunLight {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int inputs = 0;
		int num = 0;
		int count = 0;
		int maxHeight = -1;
		int current = 0;

		Scanner in = new Scanner(System.in);

		inputs = in.nextInt();

		while (inputs-- > 0) {
			maxHeight = -1;
			num = in.nextInt();
			count = 0;

			while (num-- > 0) {
				current = in.nextInt();
				if (current >= maxHeight) {
					count++;
					maxHeight = current;
				}
			}

			System.out.println(count);
		}

		in.close();

	}

}
