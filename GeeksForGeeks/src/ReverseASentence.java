import java.util.Scanner;

class ReverseASentence {

	public static void main(String args[]) {

		int inputs = -1;
		Scanner in = new Scanner(System.in);
		String sentence = null;
		String[] tokens = new String[100];
		inputs = in.nextInt();
		StringBuilder sb = new StringBuilder();
		int index = -1;
		char currentChar;
		while (inputs-- > 0) {
			sb.setLength(0);
			index = 0;
			sentence = in.next();

			for (int i = 0; i < sentence.length(); i++) {
				currentChar = sentence.charAt(i);

				if (currentChar == '.') {
					if (sb.length() != 0) {
						tokens[index] = sb.toString();
						index++;
						tokens[index] = ".";
						index++;
						sb.setLength(0);
					}
				} else {
					sb.append(currentChar);
				}
			}

			tokens[index] = sb.toString();

			while (index > -1) {
				System.out.print(tokens[index]);
				index--;
			}
		}

		in.close();
	}
}