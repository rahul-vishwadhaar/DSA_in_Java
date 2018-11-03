import org.omg.CORBA.OMGVMCID;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class MaxPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] A = new int[] { 12, 23, 28, 43, 44, 59, 60, 68, 70, 85, 88, 92,
				124, 125, 136, 168, 171, 173, 179, 199, 212, 230, 277, 282,
				306, 314, 316, 325, 328, 336, 337, 363, 365, 368, 369, 371,
				374, 387, 394, 414, 422, 422, 427, 430, 435, 457, 493, 506,
				527, 531, 538, 541, 546, 568, 583, 585, 650, 691, 730, 737,
				751, 764, 778, 783, 785, 789, 794, 803, 809, 815, 847, 858,
				863, 863, 874, 896, 916, 920, 926, 927, 930, 957, 981, 997 };
		;
		int[] B = new int[] { 13, 20, 32, 35, 61, 95, 98, 98, 118, 125, 150,
				194, 220, 227, 229, 246, 271, 281, 287, 302, 307, 318, 341,
				351, 354, 369, 369, 379, 380, 400, 404, 435, 441, 442, 445,
				452, 468, 482, 489, 493, 498, 501, 504, 529, 540, 556, 568,
				571, 587, 587, 602, 619, 620, 625, 652, 653, 676, 677, 684,
				690, 709, 710, 716, 724, 730, 733, 740, 755, 757, 765, 765,
				772, 796, 797, 830, 842, 847, 857, 866, 872, 903, 915, 922,
				928, 933, 966, 988 };

		System.out.println(maxPathSum(A, B));

	}

	static int maxPathSum(int ar1[], int ar2[]) {
		int sum = 0;
		int len1 = ar1.length;
		int len2 = ar2.length;
		int index1 = 0;
		int index2 = 0;
		int sumA = 0;
		int sumB = 0;

		while ((index1 < len1) || (index2 < len2)) {
			// System.out.println("Index1 =" + index1 + " Index2 = " + index2);
			// System.out.println("SumA =" + sumA + " SumB = " + sumB);
			if (index2 == len2) {
				sumA += ar1[index1];
				index1++;
			} else if (index1 == len1) {
				sumB += ar2[index2];
				index2++;
			} else if (ar1[index1] < ar2[index2]) {
				sumA += ar1[index1];
				index1++;
			} else if (ar2[index2] < ar1[index1]) {
				sumB += ar2[index2];
				index2++;
			} else {
				sum += ((sumA > sumB) ? sumA : sumB);
				sum += ar1[index1];
				sumA = 0;
				sumB = 0;
				index1++;
				index2++;
			}
		}

		return sum += ((sumA > sumB) ? sumA : sumB);
	}

}
