/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class LengthOfLastWord {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("Hello World"));
		System.out.println(lengthOfLastWord("hello"));
		System.out.println(lengthOfLastWord("Hello World "));

	}

	private static int lengthOfLastWord(String input) {
		int length = 0;
		int stringLength = input.length();

		for (int i = stringLength - 1; i > -1; i--) {

			if (input.charAt(i) == ' ') {
				if (length == 0) {
					continue;
				} else {
					break;
				}
			}
			length++;
		}

		return length;

	}

}
