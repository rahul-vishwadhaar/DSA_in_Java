import java.util.Scanner;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class MaxValueEasy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int numOfInputs = 0;

		int size = -1;
		int index = -1;
		int[] arr = null;
		int max = 0;
		int min = 99999;
		int diff = 0;

		Scanner in = new Scanner(System.in);

		numOfInputs = in.nextInt();
		while (numOfInputs-- > 0) {
			index = 0;
			max = -1;
			min = 99999;
			diff = 0;
			size = in.nextInt();

			for (index = 0; index < size; index++) {

				diff = in.nextInt() - index;
				if (diff > max)
					max = diff;

				if (diff < min)
					min = diff;
			}

			System.out.println(max - min);
		}

		in.close();

	}

}
