import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class RelativeSorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int numOfInputs = 0;
		int lengthN = 0;
		int lengthM = 0;
		int[] arrN = null;
		int[] arrM = null;
		int index = 0;
		int indexM = 0;
		int key = -1;
		int temp = 0;
		Scanner in = new Scanner(System.in);

		numOfInputs = in.nextInt();

		while (numOfInputs-- > 0) {

			in.reset();
			lengthN = in.nextInt();
			lengthM = in.nextInt();
			indexM = 0;
			index = 0;

			arrN = new int[lengthN];
			arrM = new int[lengthM];

			while (index < lengthN) {
				arrN[index] = in.nextInt();
				index++;
			}

			index = 0;

			while (index < lengthM) {
				arrM[index] = in.nextInt();
				index++;
			}
			
			/***************************************************************************/

			index = 0;
			Arrays.sort(arrN, index, lengthN);
			while (indexM < lengthM) {

				key = arrM[indexM];

				for (int i = index; i < lengthN; i++) {

					if (key > arrN[i])
						continue;
					else if (key == arrN[i]) {
						temp = arrN[i];
						arrN[i] = arrN[index];
						arrN[index] = temp;
						index++;
					} else {
						break;
					}

				}
				indexM++;
				Arrays.sort(arrN, index, lengthN);
			}

			/******************************************/
			for (index = 0; index < arrN.length; index++) {
				System.out.print(arrN[index] + " ");
			}

			System.out.println(" ");
		}

		in.close();
	}

}
