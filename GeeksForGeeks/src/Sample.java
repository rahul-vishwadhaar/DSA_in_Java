class Sample {

	public static void main(String args[]) {

		// System.out.print(method(1397));
		// method1();

		int[][] array = { 
						{ 1, 0, 0, 1, 0, 0, 1, 0 },
						{ 1, 0, 1, 0, 0, 1, 1, 1 },
						{ 1, 1, 1, 1, 0, 0, 1, 1 }
						};

		System.out.println(getCount(array));
	}

	public static int method(int n) {
		int result = 0;
		n <<= 1;

		while (n > 0) {
			System.out.println((n / 2) % 2);
			result += (n / 2) % 2;
		}
		return result;
	}

	public static void method1() {
		int result = 0;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				result += i + j;
			}
		}

		String a = null;
		String b = "xyz";
		String c = a + b;
		System.out.println(c);
		System.out.println(result);
	}

	public static int getCount(int[][] arr) {

		int maxValue = 0;

		int[] temp = null;
		int[] prev = null;
		int count1 = 0;
		int count2 = 0;

		for (int row = 0; row < arr.length; row++) {
			temp = arr[row];
			for (int i = 0; i < temp.length; i++) {

				if (temp[i] == 0) {
					count1++;
				} else {
					maxValue = (count1 > maxValue) ? count1 : maxValue;
					count1 = 0;
				}

				if (row == 0) {
					prev = temp;
				} else {
					prev[i] = prev[i] | temp[i];

					if (prev[i] == 0) {
						count2++;
					} else {
						count2 *= (row + 1);
						maxValue = (count2 > maxValue) ? count2 : maxValue;
						count2 = 0;
					}
				}

			}
		}

		return maxValue;
	}
}