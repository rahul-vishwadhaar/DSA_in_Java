import java.util.Scanner;
import java.util.Stack;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class ReverseString2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Stack<String> stack = new Stack<String>();
		Scanner in = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		String sentence = null;
		int top = -1;
		int inputs = 0;
		int len = 0;
		char currentChar;
		int index = 0;

		inputs = in.nextInt();

		while (inputs-- > 0) {

			// stack.clear();
			sentence = in.nextLine();
			len = sentence.length();
			index = 0;
			while (index < len) {
				

				currentChar = sentence.charAt(index);
				index++;

				if (currentChar != '.') {
					sb.append(currentChar);
				} else {
					stack.push(sb.toString());
					stack.push(".");
					sb.setLength(0);
				}

			}

			stack.push(sb.toString());
			sb.setLength(0);

			while (!stack.isEmpty()) {
				System.out.print(stack.pop());
			}

		}

	}

}
