package main;

import java.util.Scanner;

public class CodeChefSept2 {

	public static void main(String[] args) {
		int inputs = -1;
		String inputString = null;
		char[] inputArr = null;
		int index = 0;
		Scanner in = new Scanner(System.in);
		int len = 0;
		inputs = in.nextInt();
		boolean flag = false;
		char ch;

		while (inputs-- > 0) {
			inputString = in.next();
			inputArr = inputString.toCharArray();
			len = inputArr.length;
			flag = true;
			ch = 'a';
			for (index = 0; index < inputArr.length / 2+1; index++) {

				if ((inputArr[index] == '.')
						&& (inputArr[len - 1 - index] == '.')) {
					inputArr[index] = ch;
					inputArr[len - 1 - index] = ch++;

				} else if (inputArr[index] == '.') {
					inputArr[index] = inputArr[len - 1 - index];

				} else if (inputArr[len - 1 - index] == '.') {

					inputArr[len - 1 - index] = inputArr[index];

				} else if (inputArr[index] == inputArr[len - 1 - index]) {
					continue;
				} else {
					flag = false;
					break;
				}
			}

			if (flag == true)
				System.out.println(inputArr);
			else
				System.out.println(-1);
		}

		in.close();

	}

}
