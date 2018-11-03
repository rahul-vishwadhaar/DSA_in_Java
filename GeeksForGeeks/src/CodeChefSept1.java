import java.util.Scanner;

class CodeChef {

	public static void main(String[] args) {
		int inputs = -1;
		String inputString;
		char[] input;
		int len = -1;
		int index;
		int sum = 0;

		Scanner in = new Scanner(System.in);

		inputs = in.nextInt();

		while (inputs-- > 0) {
			inputString = in.next();
			input = inputString.toCharArray();
			len = input.length;
			sum = 0;

			if (len == 0)
				continue;

			for (index = 0; index < len; index++) {
				if (input[index] == '1')
					sum++;
			}

			if ((sum == 1) || (sum == len - 1))
				System.out.println("Yes");
			else
				System.out.println("No");

		}
		in.close();
	}
}
