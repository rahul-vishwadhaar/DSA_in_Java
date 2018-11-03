public class SortedCircularLinkedList {

	void sortedInsert(LLNode head_ref, int data) {
		LLNode head = head_ref;
		LLNode prev = null;
		boolean flag = false;

		if (head == null)
			return;

		if (data < head.data) {
			head = addAtBeggining(head, data);
			return;
		}

		while (head_ref != head) {
			if (data < head.data) {
				flag = true;
				addNode(prev, data);
			}
			prev = head;
			head = head.next;
		}

		if (!flag)
			addNode(prev, data);

	}

	private LLNode addAtBeggining(LLNode head, int data) {
		LLNode newNode = new LLNode(data);

		newNode.next = head;
		return head = newNode;
	}

	private void addNode(LLNode prev, int data) {
		LLNode newNode = new LLNode(data);

		newNode.next = prev.next;
		prev.next = newNode.next;
	}

}
