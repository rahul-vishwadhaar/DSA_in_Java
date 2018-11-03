public class List_0_1_2 {

	private void sortedList(LLNode head) {
		int[] count = new int[3];

		LLNode headRef = null;

		headRef = head;

		while (headRef != null) {
			count[headRef.data]++;
		}

		headRef = head;
		while (headRef != null) {
			int i = 0;

			if (count[i] == 0) {
				i++;
			}
			headRef.data = i;
			count[i]--;
		}
	}

}
