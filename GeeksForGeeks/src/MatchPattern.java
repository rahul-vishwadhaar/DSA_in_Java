import java.io.ObjectInputStream.GetField;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class MatchPattern {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(matchPattern("abbccccccdd", "foo"));
		System.out.println(matchPattern("abb", "foo"));
	}

	private static boolean matchPattern(String input, String pattern) {

		if (getPattern(input).equalsIgnoreCase(getPattern(pattern)))
			return true;
		else
			return false;
	}

	private static String getPattern(String input) {

		char[] inputCh = input.toCharArray();
		char ch = inputCh[0];
		String str = "1";
		int digit = 1;

		for (int i = 1; i < inputCh.length; i++) {
			if (ch != inputCh[i]) {
				ch = inputCh[i];
				digit++;
			}
			str = str + digit;
		}
		return str;
	}

}
