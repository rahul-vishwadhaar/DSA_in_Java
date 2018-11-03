import java.util.Scanner;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class NonDecreasingSeq {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int numOfInputs = -1;
		int len = 0;
		int[] arrRuns;
		Scanner in = new Scanner(System.in);

		numOfInputs = in.nextInt();

		while (numOfInputs-- > 0) {
			len = 0;
			len = in.nextInt();
			arrRuns = new int[len];
			for (int i = 0; i < len; i++) {
				arrRuns[i] = in.nextInt();
			}

			System.out.println(getMaxSubsequence(arrRuns, len));
		}

		in.close();
	}

	private static int getMaxSubsequence(int[] arrRuns, int len) {

		int max = -1;
		int count = 1;

		for (int i = 0; i < len - 1; i++) {
			if (arrRuns[i + 1] >= arrRuns[i])
				count++;
			else {
				if (count > max)
					max = count;
				count = 1;
			}
		}
		
		if (count > max)
			max = count;
		return max;

	}

}
