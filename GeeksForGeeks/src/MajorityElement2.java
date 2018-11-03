public class MajorityElement2 {

	public static void main(String args[]) {
		int arr[] = new int[] { 1, 2, 4, 1, 2, 43, 634, 32, 1, 2, 2, 2,2,2 ,2,2,2};

		int candidate = findCandidate(arr);

		if (isMajority(candidate, arr))
			
			System.out.println(candidate + " true");
		else
			System.out.println(candidate + "false");

	}

	private static boolean isMajority(int candidate, int[] arr) {
		boolean result = false;
		int count = 0;

		for (int i = 0; i < arr.length; i++) {
			if (candidate == arr[i])
				count++;
		}

		if (count >= arr.length / 2)
			result = true;
		else
			result = false;

		return result;
	}

	private static int findCandidate(int[] arr) {
		int candidate = arr[0];
		int count = 1;

		for (int i = 1; i < arr.length; i++) {

			if (candidate == arr[i]) {
				count++;
			} else {
				count--;

				if (count == 0){
					candidate = arr[i];
					count = 1;
				}
			}
		}

		return candidate;
	}

}
