import java.util.Scanner;

public class IsMultipleOf3 {

	public static void main(String args[]) {

		int numInput = 0;
		String num;
		char[] numChar;
		int oddCount = 0;
		int evenCount = 0;
		Scanner in = new Scanner(System.in);

		numInput = in.nextInt();

		while (numInput-- > 0) {
			num = in.next();
			oddCount = 0;
			evenCount = 0;
			
			System.out.println(Long.parseLong(num,2));
			System.out.println(Long.parseLong(num,2)%3);
			numChar = num.toCharArray();

			for (int i = numChar.length - 1; i > -1; i--) {
				if (numChar[i] == '1')
					oddCount++;

				i--;

				if ((i > -1) && (numChar[i] == '1'))
					evenCount++;

			}
			System.out.println(isMultipleOf3(Math.abs(evenCount - oddCount)));
		}
		in.close();
	}

	private static int isMultipleOf3(int num) {

		int countOdd = 0;
		int countEven = 0;

		if (num < 0)
			num = -num;

		if (num == 0)
			return 0;

		if (num == 1)
			return 1;

		while (num != 0) {
			if ((num & 1) == 1) {
				countOdd++;
			}
			num = num >> 1;
			if ((num & 1) == 1) {
				countEven++;
			}
			num = num >> 1;
		}

		return isMultipleOf3(Math.abs(countOdd - countEven));
	}
}
