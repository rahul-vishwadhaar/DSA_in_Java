import java.util.Scanner;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class LongestEvenLength {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int noOfInputs = 0;
		Scanner in = new Scanner(System.in);
		String input = null;

		noOfInputs = in.nextInt();
		while (noOfInputs-- > 0) {

			input = in.next();

			System.out.println(getLength(input));

		}

		in.close();

	}

	private static int getLength(String input) {

		int result = 0;

		char[] inputArr = input.toCharArray();

		for (int i = 0; i < inputArr.length-1; i++) {
			System.out.println(inputArr[i]);
		}
		return result;
	}

}
