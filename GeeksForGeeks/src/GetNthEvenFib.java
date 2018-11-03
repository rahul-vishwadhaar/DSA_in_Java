import java.util.Scanner;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class GetNthEvenFib {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int numOfInputs = -1;
		int num = -1;

		numOfInputs = in.nextInt();

		while (numOfInputs-- > 0) {

			num = in.nextInt();

			System.out.println(getNthFibNum(num));
		}

		in.close();
	}

	private static int getNthFibNum(int n) {

		int a0 = 1;
		int a1 = 1;
		int a2 = 0;

		while (n > 0) {
			a2 = a0 + a1;
			a0 = a1;
			a1 = a2;
			

			if (a2 % 2 == 0) {
				n--;
			}
		}

		return a2%1000000007;
	}
}
