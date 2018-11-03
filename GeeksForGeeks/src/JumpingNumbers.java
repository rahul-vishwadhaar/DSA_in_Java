import java.util.LinkedList;
import java.util.Scanner;

public class JumpingNumbers {

	public static void main(String args[]) {

		Scanner in = new Scanner(System.in);
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int num = in.nextInt();

		if (num <= 10) {

			for (int i = 0; i <= num; i++) {
				System.out.print(i + " ");
			}
			in.close();
			return;
		}

		for (int i = 0; i <= 9; i++) {
			queue.addLast(i);
		}

		while (!queue.isEmpty()) {

			int currentNum = queue.pollFirst();

			if (currentNum <= num) {
				int last_dig = 0;
				if (currentNum < 10)
					last_dig = currentNum;
				else
					last_dig = num % 10;

				// If last digit is 0, append next digit only
				if (last_dig == 0)
					queue.addLast((currentNum * 10) + (last_dig + 1));

				// If last digit is 9, append previous digit only
				else if (last_dig == 9)
					queue.addLast((currentNum * 10) + (last_dig - 1));

				// If last digit is neighter 0 nor 9, append both
				// previous and next digits
				else {
					queue.addLast((currentNum * 10) + (last_dig - 1));
					queue.addLast((currentNum * 10) + (last_dig + 1));
				}

				System.out.print(currentNum + " ");
			}

		}

	}
}
