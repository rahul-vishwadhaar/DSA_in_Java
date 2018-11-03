import java.util.ArrayList;
import java.util.Scanner;

class ReverseAString {
	public static void main(String[] args) {

		int inputs = 0;
		String inputString;
		ArrayList<String> stack = new ArrayList<String>();
		int indexStart = 0;
		int indexEnd = 0;
		int len = 0;

		Scanner in = new Scanner(System.in);

		inputs = in.nextInt();

		while (inputs-- > 0) {

			inputString = in.next();
			len = inputString.length();

			indexStart = indexEnd = 0;

			while (len-- > 0) {

				if (inputString.charAt(indexEnd) == '.') {
					stack.add(inputString.substring(indexStart, indexEnd));
					indexStart = ++indexEnd;
					stack.add(".");
				} else {
					indexEnd++;
				}

			}

			stack.add(inputString.substring(indexStart, indexEnd));

			len = stack.size();
			while (len-- > 0) {
				System.out.print(stack.get(len));
				stack.remove(len);
			}

			System.out.println(" ");
		}

		in.close();
	}
}