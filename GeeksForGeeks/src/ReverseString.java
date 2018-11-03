import java.util.ArrayList;

public class ReverseString {

	public static void main(String[] args) {

		System.out.println(reverseWords3(" ankrqzzcel  dyaiug y rkicv t"));

		System.out
				.println(reverseWords3("iwfcqq igjgip myq sn  dqmy qfho sswz  ouhsuhf kxorifrhubk jsx ulc  osdt fwbpudnbrozzifml"));

		System.out
		.println(reverseWords3(" j  "));
	}

	public static String reverseWords3(String a) {

	//	System.out.println("Before :" + a.length());
		String result = null;

		StringBuilder sb = new StringBuilder();
		ArrayList<String> stack = new ArrayList<String>();

		char[] input = a.toCharArray();
		boolean flag = false;

		for (int i = 0; i < input.length; i++) {

			if (input[i] == ' ') {

				if (flag) {
					stack.add(0, sb.toString());
					sb.setLength(0);
					flag = false;
				} else {
					continue;
				}
			} else {

				sb.append(input[i]);
				flag = true;
			}
		}

		if (flag) {
			stack.add(0, sb.toString());
			sb.setLength(0);
		}

		for (int i = 0; i < stack.size() - 1; i++) {
			sb.append(stack.get(i) + " ");
		}

		sb.append(stack.get(stack.size() - 1));

		result = sb.toString();

	//	System.out.println("After :" + result.length());

		return result;
	}

	public static String reverseWords(String a) {

		String result = null;
		char[] input = a.toCharArray();
		int spaceCount = 0;
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < input.length; i++) {

			if ((result == null) && (input[i] == ' '))
				continue;

			if (input[i] == ' ') {

				spaceCount++;
				// System.out.println(sb.toString());

				if (spaceCount == 2) {
					spaceCount = 0;
					continue;
				}

				if (result == null) {

					result = sb.toString();
				} else
					result = sb.toString() + " " + result;
				sb.setLength(0);
			} else {
				spaceCount = 0;
				sb.append(input[i]);
			}
		}

		// System.out.println(sb.toString());
		if (result == null)
			result = sb.toString();
		else
			result = sb.toString() + " " + result;
		return (result);

	}

	public static String reverseWords2(String a) {

		String[] input = a.split(" ");
		String result = null;

		for (int i = input.length - 1; i > 0; i--) {
			// System.out.println(input[i].trim());

			if (input[i].isEmpty())
				continue;

			if (result == null)
				result = input[i].trim() + " ";
			else
				result = result + input[i].trim() + " ";
		}

		if (result == null)
			return input[0].trim();

		if (input[0].isEmpty())
			return result;

		return result + input[0].trim();
	}
}
