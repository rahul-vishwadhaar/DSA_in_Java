import java.util.Scanner;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class MinimumNotes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int numOfInputs = in.nextInt();
		int salary = 0;
		int notes = 0;

		while (numOfInputs-- > 0) {
			salary = in.nextInt();
			notes = in.nextInt();

			while (notes > 0) {

				if (salary >= 1000) {
					salary -= 1000;

				} else if (salary >= 500) {
					salary -= 500;

				} else if (salary >= 100) {
					salary -= 100;

				} else if (salary >= 50) {
					salary -= 50;

				} else if (salary >= 20) {
					salary -= 20;

				} else if (salary >= 10) {
					salary -= 10;

				} else if (salary >= 5) {
					salary -= 5;

				} else if (salary >= 2) {
					salary -= 2;

				} else if (salary >= 1) {
					salary -= 1;

				}

				notes--;
			}

			System.out.println(salary);
		}

		in.close();
	}

}
