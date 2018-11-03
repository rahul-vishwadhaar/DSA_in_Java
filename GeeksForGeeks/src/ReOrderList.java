/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class ReOrderList {

	/**
	 * @param args
	 */

	static LLNode currentNode = null;

	public static void main(String[] args) {

		LLNode head1 = null;

		head1 = new LLNode(1);
		head1.next = new LLNode(2);
		head1.next.next = new LLNode(3);
		head1.next.next.next = new LLNode(4);
		head1.next.next.next.next = new LLNode(5);
		head1.next.next.next.next.next = new LLNode(6);

		currentNode = head1;

		reorderlist(head1);

		while (head1 != null) {
			System.out.println(head1.data);
			head1 = head1.next;
		}
	}

	static boolean reorderlist(LLNode head) {
		if (head == null)
			return true;

		if (!reorderlist(head.next))
			return false;

		if (currentNode == null)
			return false;
		if (currentNode == head) {
			currentNode.next = null;
			return false;
		}

		if (currentNode.next == currentNode) {
			currentNode.next = null;
			return false;
		}

		LLNode nextNode = currentNode.next;
		head.next = nextNode;
		currentNode.next = head;
		currentNode = nextNode;

		return true;
	}
}
