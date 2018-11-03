import java.util.Scanner;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class CollectingTrees {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int inputs = 0;
		int num = 0;
		int count = 0;

		Scanner in = new Scanner(System.in);

		inputs = in.nextInt();

		while (inputs-- > 0) {

			num = in.nextInt();
			count = 0;
			while (num != 0) {
				if (num % 2 == 1) {
					count++;
				}
				num /= 2;
			}

			System.out.println(count);
		}
		in.close();
	}

}
