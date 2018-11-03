/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class NthElementSpiralMatrix {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] A = new int[4][7];

		A[0] = new int[] { 916, 794, 336, 387, 493, 650, 422 };
		A[1] = new int[] { 363, 28, 691, 60, 764, 927, 541 };
		A[2] = new int[] { 427, 173, 737, 212, 369, 568, 430 };
		A[3] = new int[] { 783, 531, 863, 124, 68, 136, 930 };
		System.out.println(getNthElement(A, 4, 7, 7));

	}

	private static int getNthElement(int[][] A, int n, int m, int k) {

		int row = (k-1) / m;
		int col = (k-1) % m;

		System.out.println("Row :" + row + " Col : " + col);
		if (row % 2 == 0) {
			return A[row][col];
		} else {
			return A[row][m - col - 1];
		}
	}

}
