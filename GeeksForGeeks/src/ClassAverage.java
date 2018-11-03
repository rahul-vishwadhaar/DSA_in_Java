import java.util.Scanner;

public class ClassAverage {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int numOfInputs = in.nextInt();
		int size = 0;
		int index = 0;
		int sum = 0;
		int num = 0;
		int prevFibIndex = 1;
		int nextFibIndex = 1;

		while (numOfInputs-- > 0) {
			index = 0;
			prevFibIndex = 1;
			nextFibIndex = 1;
			sum =0;
			size = in.nextInt();

			for (index = 1; index <= size; index++) {
				num = in.nextInt();
				if (index == nextFibIndex) {
					// System.out.println(index);
					num = (num * index) % 100;
					nextFibIndex = index + prevFibIndex;
					prevFibIndex = index;
				}
				// System.out.println(num);
				sum = sum + num;
			}

			System.out.println(sum / size);
		}

		in.close();

	}

}
