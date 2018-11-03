/**
 * 
 */

/**
 * @author rahul kumar
 *
 */
import java.util.Scanner;

class ConsecutiveOnes {
	public static void main(String[] args) {

		int inputs = 0;
		int len = 0;

		Scanner in = new Scanner(System.in);

		inputs = in.nextInt();

		while (inputs-- > 0) {
			len = in.nextInt();
			System.out.println(fib(len + 2));
		}

		in.close();
	}

	private static long fib(int n) {

		long a1 = 0;
		long a2 = 1;
		long sum = 0;

		if (n == 0) {
			return a1;
		}

		if (n == 1) {
			return a2;
		}

		n = n - 1;

		while (n-- > 0) {
			sum = (a2 + a1) % (1000000007);
			a1 = (a2) % (1000000007);
			a2 = sum % (1000000007);
		}

		return sum;
	}
}