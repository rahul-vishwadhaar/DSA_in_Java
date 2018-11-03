/**
 * 
 */

/**
 * @author rahul kumar
 *
 */

import java.util.*;
import java.lang.*;
import java.io.*;

public class JumpingNumbers_2 {

	public static void main(String[] args) {
		int inputs = 0;
		int num = 0;
		int result = 0;
		List<Integer> queue = new LinkedList<Integer>();

		Scanner in = new Scanner(System.in);

		inputs = in.nextInt();

		while (inputs-- > 0) {

			num = in.nextInt();

			if (num < 10) {

				for (int i = 0; i < num; i++) {
					System.out.print(i + " ");
				}

				return;
			}

			for (int i = 0; i < 10; i++) {
				queue.add(i);
			}

			while (!queue.isEmpty()) {

				result = queue.get(0);
				queue.remove(0);

				System.out.print(result + " ");

				if (result + 9 < num) {
					queue.add(result + 9);
				}

				if (result + 11 < num) {
					queue.add(result + 11);
				}
			}

		}
	}
}
