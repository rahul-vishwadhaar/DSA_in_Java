/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class CelebrityProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] input = new int[4][];

		input[0] = new int[] { 0, 1, 0, 1 };
		input[1] = new int[] { 0, 0, 0, 1 };
		input[2] = new int[] { 0, 1, 0, 1 };
		input[3] = new int[] { 0, 0, 0, 0 };

		getId(input, 4);

	}

	private static int getId(int[][] m, int n) {

		int[] result = new int[n];
		int index = 0;

		for (int i = 0; i < n - 1; i++) {
			if (m[i][i + 1] == 1) {
				result[i] = -1;
			} else {
				result[i + 1] = -1;
			}

		}

		for (int i = 0; i < n; i++) {
			System.out.println(result[i]);
		}
		return -1;
	}

}
