/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class ReverseLLInGroups {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		LLNode head = new LLNode(1);
		head.next = new LLNode(2);
		head.next.next = new LLNode(3);
		head.next.next.next = new LLNode(4);
		head.next.next.next.next = new LLNode(5);

		head = reverse2(head, 7);

		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}

	static LLNode reverse(LLNode head, int k) {
		int count = k;

		if (head == null)
			return null;

		if (head.next == null)
			return head;

		LLNode currentNode = head;
		LLNode nextNode = null;
		LLNode prevNode = null;

		while ((count-- > 0) && (currentNode != null)) {

			nextNode = currentNode.next;
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
		}
		head.next = reverse(currentNode, k);

		return prevNode;
	}

	static LLNode reverse2(LLNode head, int k) {

		int count = k;

		LLNode currentNode = head;
		LLNode nextNode = null;
		LLNode prevNode = null;

		while ((count-- > 0) && (currentNode != null)) {

			nextNode = currentNode.next;
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
		}
		head.next = reverse(currentNode, k);

		return prevNode;
	}

}
