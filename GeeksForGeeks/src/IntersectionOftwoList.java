public class IntersectionOftwoList {

	public static void main(String[] args) {
		LLNode head1 = null;
		LLNode head2 = null;

		head1 = new LLNode(1);
		head1.next = new LLNode(2);
		head1.next.next = new LLNode(3);
		head1.next.next.next = new LLNode(4);
		head1.next.next.next.next = new LLNode(6);

		head2 = new LLNode(2);
		head2.next = new LLNode(4);
		head2.next.next = new LLNode(6);
		head2.next.next.next = new LLNode(8);
		head2.next.next.next.next = new LLNode(10);

		LLNode head3 = null;

		head3 = intersection(head1, head2);

		while (head3 != null) {
			System.out.println(head3.data);
			head3 = head3.next;
		}

	}

	private static LLNode intersection(LLNode node1, LLNode node2) {
		LLNode head = null;
		LLNode current = null;
		while ((node1 != null) && (node2 != null)) {

			if (node1.data == node2.data) {

				if (head == null) {
					head = addNode(node2.data);
					current = head;
				} else {
					current.next = addNode(node2.data);
					current = current.next;
				}
				node1 = node1.next;

				node2 = node2.next;

			} else if (node1.data < node2.data) {
				node1 = node1.next;
			} else
				node2 = node2.next;
		}

		return head;
	}

	private static LLNode addNode(int data) {
		LLNode current = null;
		if (current == null) {
			current = new LLNode(data);
		}
		return current;
	}
}
