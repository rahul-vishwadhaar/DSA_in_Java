public class DeleteRightNodes {

	static int count = 0;

	public static void main(String[] args) {

		LLNode head = new LLNode(10);
		head.next = new LLNode(20);
		head.next.next = new LLNode(30);
		head.next.next.next = new LLNode(40);
		head.next.next.next.next = new LLNode(50);
		head.next.next.next.next.next = new LLNode(60);

		head = compute(head);

		printLL(head);

		head = new LLNode(60);
		head.next = new LLNode(50);
		head.next.next = new LLNode(90);
		head.next.next.next = new LLNode(110);
		head.next.next.next.next = new LLNode(70);
		head.next.next.next.next.next = new LLNode(10);

		count = 1;

		while (count != 0) {
			head = compute(head);
		}

		printLL(head);
	}

	private static void printLL(LLNode head) {
		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
		System.out.println();
	}

	private static LLNode compute(LLNode head) {
		count = 0;
		LLNode currentNode = head;
		while (currentNode.next != null) {
			if (currentNode.data < currentNode.next.data) {
				count++;
				if (head == currentNode) {
					head.data = currentNode.next.data;
					head.next = currentNode.next.next;
					currentNode = head;
				} else {
					currentNode.data = currentNode.next.data;
					currentNode.next = currentNode.next.next;
				}
			} else {
				currentNode = currentNode.next;
			}

		}

		return head;

	}
}
