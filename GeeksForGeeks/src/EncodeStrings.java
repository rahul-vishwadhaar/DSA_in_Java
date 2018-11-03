/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class EncodeStrings {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(encode("aaaaaaaaaaaaaaaaaaaaaaaa"));

		System.out.println(encode("aaaabbbccc"));

		System.out.println(encode("abbbcdddd"));

		System.out.println(encode("wwwwaaadexxxxxx"));
	}

	private static String encode(String input) {
		StringBuffer result = new StringBuffer();

		char[] inputArray = input.toCharArray();
		int len = input.length();
		int count = 0;

		char ch = inputArray[0];
		count = 1;

		for (int i = 1; i < len; i++) {

			if (ch == inputArray[i]) {
				count++;
			} else {
				result.append(ch);
				result.append(count);
				ch = inputArray[i];
				count = 1;
			}
		}

		result.append(ch);
		result.append(count);
		return result.toString();
	}

}
