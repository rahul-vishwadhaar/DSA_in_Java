/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class atoi {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	//	System.out.println(atoi(" 7V U 0 T7165  0128862 089 39 5"));
	//	System.out.println(atoi("-   92704"));
	//	System.out.println(atoi("9270   4   "));
	//	System.out.println(atoi("51214V78262 8070067M75"));

	//	System.out.println(atoi(" V515V 5793K 627"));

	//	System.out.println(atoi("    -4   6"));

	//	System.out.println(atoi("-54332872018247709407 4 54"));
		System.out.println(atoi("-54332872018247709407 4 54"));
		
		System.out.println(atoi("+ 3611156"));
		
		System.out.println(atoi(" +7"));

	}

	private static int atoi(String input) {
		long result = 0;
		int digit;
		int start = 0;
		boolean isNegative = false;
		for (int i = 0; i < input.length(); i++) {

			if (start == 0 && (input.charAt(i)) == '-') {
				isNegative = true;
				start++;
				continue;
			}
			
			if (start == 0 && (input.charAt(i)) == '+') {
				isNegative = false;
				start++;
				continue;
			}

			if (Character.isLetter(input.charAt(i))) {
				break;
			}
			digit = Character.getNumericValue(input.charAt(i));

			if ((digit > -1) && (digit < 10)) {

				if (result * 10 > Integer.MAX_VALUE) {
					if (isNegative)
						result = Integer.MIN_VALUE;
					else
						result = Integer.MAX_VALUE;
					break;
				}
				result = result * 10 + digit;
				start++;
			} else if (start > 0) {
				break;
			}

		}

		if (result == Integer.MIN_VALUE)
			return (int) result;
		if (result < 0)
			return Integer.MAX_VALUE;

		return isNegative ? (int) -result : (int) result;
	}
}
