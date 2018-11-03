/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class PrintPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		printPattern(15);

	}
	

	private static void printPattern(int n) {
		System.out.print(n + " ");

		if (n <= 0)
			return;
		else
			printPattern(n - 5);

		System.out.print(n + " ");
	}
}
