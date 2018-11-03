/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class ImplementStrStr {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		// System.out.println(strstr("GeeksForGeeks", " Fr"));
		System.out
				.println(strstr(
						"lrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmcoq",
						"hnwnkuewhsqmgbbuqcljjivswmdkqtbxixmvtrrbljptnsn"));
	}

	private static int strstr(String str, String target) {
		int position = -1;

		char[] strArr = str.toCharArray();
		char[] targetArr = target.toCharArray();
		boolean flag = true;

		int lenStr = str.length();
		int lenTarget = target.length();

		for (int i = 0; i < lenStr - lenTarget; i++) {

			if (strArr[i] == targetArr[0]) {
				flag = true;

				for (int j = i; j < i + lenTarget; j++) {
					if (strArr[j] != targetArr[j - i]) {
						flag = false;
						break;
					}
				}
				if (flag) {
					position = i;
					break;
				}

			}
		}
		return position;
	}

}
