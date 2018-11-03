/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class RemoveKthNode {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LLNode head = new LLNode(1);

		head.next = new LLNode(2);
		head.next.next = new LLNode(3);
		head.next.next.next = new LLNode(4);
		head.next.next.next.next = new LLNode(5);
		head.next.next.next.next.next = new LLNode(6);
		head.next.next.next.next.next.next = new LLNode(7);

		head = removeKthNode(head, 7);

		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

	}

	private static LLNode removeKthNode(LLNode head, int k) {
		LLNode current = head;
		LLNode prev = null;
		int i = 0;
		while (current != null) {

			if ((++i % k) == 0) {

				if (prev == null) {
					head = current;
					current = head.next;
				} else {
					prev.next = current.next;
					current = current.next;
				}
			} else {
				prev = current;
				current = current.next;
			}
		}

		return head;
	}
}
