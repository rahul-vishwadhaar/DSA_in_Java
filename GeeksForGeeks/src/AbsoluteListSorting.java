/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class AbsoluteListSorting {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LLNode head = new LLNode(1);
		head.next = new LLNode(2);
		head.next.next = new LLNode(-3);
		head.next.next.next = new LLNode(4);
		head.next.next.next.next = new LLNode(-5);

		head = sortedList(head);

		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}
	}

	static LLNode sortedList(LLNode head) {
		if (head == null)
			return null;

		LLNode current = head.next;
		LLNode prev = head;

		while (current != null) {

			if (current.data < 0) {
				prev.next = current.next;
				current.next = head;
				head = current;
				current = prev.next;
			} else {
				current = current.next;
				prev = prev.next;
			}
		}

		return head;
	}

}
