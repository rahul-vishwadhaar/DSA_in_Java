import java.util.HashMap;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class RomanToInteger {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(convertRomanToInteger("IV"));
		System.out.println(convertRomanToInteger("V"));
		System.out.println(convertRomanToInteger("XL"));

		System.out.println(convertRomanToInteger(" "));
		System.out.println(convertRomanToInteger("AB"));
		System.out.println(convertRomanToInteger("a"));

	}

	public static int convertRomanToInteger(String input) {
		int sum = 0;
		int prev = -1;
		int current = -1;

		HashMap<Character, Integer> symbols = new HashMap<Character, Integer>();

		symbols.put('I', 1);
		symbols.put('V', 5);
		symbols.put('X', 10);
		symbols.put('L', 50);
		symbols.put('C', 100);
		symbols.put('D', 500);
		symbols.put('M', 1000);

		if (input.length() == 0)
				return sum;

		try {
			prev = symbols.get(input.charAt(0));
		} catch (Exception e) {
			return 0;

		}
		sum = prev;

		for (int i = 1; i < input.length(); i++) {
			current = symbols.get(input.charAt(i));
			if (prev < current) {
				sum = sum + current - 2 * prev;
			} else {
				sum += current;
			}

			prev = current;
		}

		return sum;
	}

}
