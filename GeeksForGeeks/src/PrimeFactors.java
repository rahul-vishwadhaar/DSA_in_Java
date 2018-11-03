import java.util.Scanner;

/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
 //imports for BufferedReader
 import java.io.BufferedReader;
 import java.io.InputStreamReader;
 */
//import for Scanner and other utility classes
import java.util.*;

class PrimeFactors {
	public static void main(String args[]) throws Exception {
		/*
		 * Read input from stdin and provide input before running Use either of
		 * these methods for input
		 * 
		 * //BufferedReader BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); String line = br.readLine(); int N =
		 * Integer.parseInt(line);
		 */
		// Scanner
		Scanner s = new Scanner(System.in);
		long N = s.nextInt();
		long input = 0;

		for (long i = 0; i < N; i++) {

			input = s.nextLong();
			System.out.println(getfx(input));

		}

		s.close();
	}

	private static long getfx(long input) {
		int count = 0;
		int divisor = 0;
		int n1 = 0;
		int n = 0;
		int sum = 0;

		long result = -1;
		while (true) {
			n1++;
			n = n1;
			sum = 0;
			count = 0;
			while (n % 2 == 0) {
				n = n / 2;
				count++;
			}

			sum += count;
			divisor = (count + 1);

			count = 0;
			for (int i = 3; i <= Math.sqrt(n); i = i + 2) {
				while (n % i == 0) {
					n = n / i;
					count++;
				}
			}

			sum += count;
			divisor += count;

			count = 0;
			// This condition is to handle the case whien n is a prime number
			// greater than 2
			if (n > 2) {
				count++;
			}

			sum += count;

			if ((sum == input) && (divisor - 1 == sum)) {
				result = n1;
				break;
			}
		}
		return result;
	}
}