import java.util.Scanner;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class NthFibonacciNumber {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int numOfInputs = -1;
		int num = -1;
		int a2 = 0;
		int a1 = 1;
		int a0 = 0;
		Scanner in = new Scanner(System.in);

		numOfInputs = in.nextInt();

		while (numOfInputs-- > 0) {
			num = in.nextInt();
			a2 = 0;
			a1 = 1;
			a0 = 0;
			if (num == 0)
				System.out.println(a0);
			else if (num == 1)
				System.out.println(a1);
			else {
				for (int i = 0; i < num - 1; i++) {
					a2 = (a1 + a0)%10;
					a0 = a1;
					a1 = a2;
					System.out.print(a2 + " ");
				}

				System.out.println(a2 % 10);
			}
		}

		in.close();

	}

}
