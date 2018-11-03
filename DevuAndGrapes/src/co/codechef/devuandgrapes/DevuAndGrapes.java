package co.codechef.devuandgrapes;

import java.util.Scanner;

public class DevuAndGrapes {

	public static void main(String args[]) {
		int noOfTestCases = -1;
		long noOfBuckets = -1;
		long gcd = -1;
		long result = 0;
		long diff = 0;
		int countOfOranges = 0;

		Scanner in = new Scanner(System.in);

		noOfTestCases = in.nextInt();

		while (noOfTestCases > 0) {
			noOfBuckets = 0;
			result = 0;
			noOfBuckets = in.nextInt();
			gcd = in.nextLong();

			for (int index = 0; index < noOfBuckets; index++) {
				countOfOranges = in.nextInt();
				if ((countOfOranges / gcd) == 0)
					continue;
				else {
					diff = countOfOranges % gcd;
					if (countOfOranges < gcd)
						result = result + gcd - diff;
					else
						result = result + Math.min(diff, gcd - diff);
				}
			}
			System.out.println(result);
			noOfTestCases--;
		}

		in.close();

	}
}