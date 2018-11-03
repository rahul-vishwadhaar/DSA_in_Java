import java.util.ArrayList;
import java.util.List;

/*
 @author rahul kumar

 */
public class MedianTwoSortedArrays {

	/*
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Integer> a = new ArrayList<Integer>();

		a.add(-50);
		a.add(-41);
		a.add(-40);
		a.add(-19);
		a.add(5);
		a.add(21);
		a.add(28);

		ArrayList<Integer> b = new ArrayList<Integer>();

		b.add(-50);
		b.add(-21);
		b.add(-10);

		// System.out.println(median(a, b));

		a.clear();
		b.clear();
		b.add(-50);

		// System.out.println(median(a, b));

		a.clear();
		b.clear();

		// A : [ -40, -25, 5, 10, 14, 28, 29, 48 ]
		// B : [ -48, -31, -15, -6, 1, 8 ]
		a.add(-40);
		a.add(-25);
		a.add(5);
		a.add(10);
		a.add(14);
		a.add(28);
		a.add(29);
		a.add(48);

		b.add(-48);
		b.add(-31);
		b.add(-15);
		b.add(-6);
		b.add(1);
		b.add(-8);

		System.out.println(median(a, b));

		// A : [ -50, -47, -36, -35, 0, 13, 14, 16 ]
		// B : [ -31, 1, 9, 23, 30, 39 ]

		a.clear();
		b.clear();
		a.add(-50);
		a.add(-47);
		a.add(-36);
		a.add(-35);
		a.add(0);
		a.add(13);
		a.add(14);
		a.add(16);

		b.add(-31);
		b.add(1);
		b.add(9);
		b.add(23);
		b.add(30);
		b.add(39);

		// System.out.println(median(a, b));

	}

	public static double median(List<Integer> a, List<Integer> b) {

		int minA = 0;
		int maxA = a.size() - 1;

		int minB = 0;
		int maxB = b.size() - 1;

		int midA;
		int midB;

		double medianA = 0;
		double medianB = 0;
		if (a.size() < 2 || b.size() < 2) {
			return median2(a, b);
		}

		while ((maxA - minA != 1) && (maxB - minB != 1)) {

			medianA = 0;
			medianB = 0;

			midA = (maxA + minA) / 2;

			if ((maxA - minA) % 2 == 1) {

				medianA = (a.get(midA) + a.get(++midA)) / 2;
			} else {
				medianA = a.get(midA);
			}

			midB = (maxB + minB) / 2;

			if ((maxB - minB) % 2 == 1) {

				medianB = (b.get(midB) + b.get(++midB)) / 2;
			} else {
				medianB = b.get(midB);
			}

			if (medianA == medianB)
				return medianA;
			else if (medianA > medianB) {
				maxA = --midA;
				minB = midB;
			} else {
				minA = --midA;
				maxB = midB;
			}
		}

		return (Math.max(a.get(minA), b.get(minB)) + Math.min(a.get(maxA),
				b.get(maxB))) / 2;

	}

	private static double median2(List<Integer> a, List<Integer> b) {
		double median = -1;
		int len = a.size() + b.size();
		int mid1 = len / 2;
		int mid2 = -1;

		if (len % 2 == 0) {
			mid2 = mid1 - 1;
		}

		int indexA = 0;
		int indexB = 0;
		int num;

		for (int i = 0; i < len; i++) {

			if (indexA == a.size()) {
				num = b.get(indexB);
				indexB++;
			} else if (indexB == b.size()) {
				num = a.get(indexA);
				indexA++;

			} else if (a.get(indexA) < b.get(indexB)) {
				num = a.get(indexA);
				indexA++;
			} else {
				num = b.get(indexB);
				indexB++;
			}

			if (i == mid1) {
				if (median == -1) {
					median = num;
				} else {
					median = (median + num) / 2;
				}
				break;
			}

			if ((i != -1) && (i == mid2)) {
				median = num;

			}
		}
		return median;

	}

}
