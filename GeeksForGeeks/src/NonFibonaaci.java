import java.util.Scanner;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class NonFibonaaci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int numOfInputs = -1;
		int res = 0;

		Scanner in = new Scanner(System.in);

		numOfInputs = in.nextInt();

		while (numOfInputs-- > 0) {

			res = getNthNonFib(in.nextInt());
			System.out.println(res);
		}

		in.close();
		
		
	}

	private static int getNthNonFib(int n) {
		int a2 = 2;
		int a1 = 1;
		int a0 = 0;
		int res = 0;

		for (int i = 0; i < n;) {
			res++;

			if ((res == 0) || (res == 1)) {
				continue;
			} else if (res == a2) {
				a0 = a1;
				a1 = a2;
				a2 = a1 + a0;
			} else
				i++;
		}
		return res;
	}

}
