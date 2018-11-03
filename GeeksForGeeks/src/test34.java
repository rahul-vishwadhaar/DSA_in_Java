import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class test34 {
	private int variableA = showOutput();
	static final int variableB = 20;

	private int showOutput() {
		return variableB;
	}

	public static void main(String[] args) {/*
											 * 
											 * Read input from stdin and provide
											 * input before running Use either
											 * of these methods for input
											 * 
											 * //BufferedReader BufferedReader
											 * br = new BufferedReader(new
											 * InputStreamReader(System.in));
											 * String line = br.readLine(); int
											 * N = Integer.parseInt(line);
											 * 
											 * // Scanner Scanner s = new
											 * Scanner(System.in); long N =
											 * s.nextInt(); long num = 0; long
											 * count = 0; for (long i = 0; i <
											 * N; i++) { count = 0; num =
											 * s.nextLong();
											 * 
											 * for (long j = 0; j <= num; j++) {
											 * for (long k = 0; k <= num; k++) {
											 * if ((j * k) == num) { if (gcd(j,
											 * k) == 1) { count++; } } else if
											 * (j * k > num) { break; }
											 * 
											 * } } System.out.println(count); }
											 * 
											 * //
											 * System.out.println("Hello World!"
											 * );
											 */

		List<Integer> arr = new ArrayList<Integer>();

		//9, 99, 999, 9999, 9998 
		arr.add(8);
		arr.add(89);
		

		System.out.println(largestNumber(arr));

	}

	private static long gcd(long a, long b) {

		
		
		
		long c;

		while (a != 0 && b != 0) {
			c = b;
			b = a % b;
			a = c;
		}

		return a + b;
	}

	public static String largestNumber(final List<Integer> newList) {

		List<Integer> a = new ArrayList<Integer>(newList);
		String x = null;
		String y = null;
		boolean flag = false;
		int temp1 = 0;
		int temp2 = 0;

		for (int i = 0; i < a.size(); i++) {
			flag = false;
			for (int j = 0; j < a.size() - 1; j++) {

				x = a.get(j).toString();
				y = a.get(j + 1).toString();

				if (Integer.parseInt(x + y) < Integer.parseInt(y + x)) {

					temp1 = a.get(j);
					temp2 = a.get(j + 1);
					// a.remove(j);
					a.set(j, temp2);
					// a.remove(j + 1);
					a.set(j + 1, temp1);
					flag = true;
				}

			}

			if (!flag)
				break;
		}
		StringBuffer sb = new StringBuffer();
		int sum = 0;
		for (int i = 0; i < a.size(); i++) {
			sum = sum+a.get(i);
			sb.append(a.get(i));
		}

		
		return (sum == 0) ? "0" : sb.toString();

	}
}