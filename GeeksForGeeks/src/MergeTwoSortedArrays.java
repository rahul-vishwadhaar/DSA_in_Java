import java.util.Scanner;

public class MergeTwoSortedArrays {
	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		int inputs = in.nextInt();
		int input1[] = null;
		int input2[] = null;
		int result[] = null;
		int size1 = -1;
		int size2 = -1;
		int index = 0;
		int num = 0;
		int count = 0;
		int index1 = 0;
		int index2 = 0;

		while (inputs-- > 0) {

			input1 = null;
			input2 = null;
			size1 = -1;
			size2 = -1;
			index = 0;

			size1 = in.nextInt();
			size2 = in.nextInt();

			input1 = new int[size1];
			input2 = new int[size2];
			result = new int[size1 + size2];

			for (index = 0; index < size1; index++) {
				input1[index] = in.nextInt();
			}

			for (index = 0; index < size2; index++) {
				input2[index] = in.nextInt();
			}

			while (count < (size1 + size2)) {

				if (index1 == size1) {
					num = input2[index2];
					index2++;
					count++;

					continue;
				}

				if (index2 == size2) {
					num = input1[index1];
					index1++;
					count++;

					continue;
				}

				if (input1[index1] > input2[index2]) {
					num = input1[index1];
					index1++;
					count++;
				} else if (input1[index1] == input2[index2]) {
					num = input1[index1];
					index1++;
					count++;
				} else {
					num = input2[index2];
					index2++;
					count++;
				}

				result[count - 1] = num;

			}

			for (index = 0; index < count; index++) {
				System.out.print(result[index] + " ");
			}

		}
		in.close();
	}
}
