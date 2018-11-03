/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class PairWiseSwap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LLNode head1 = null;

		head1 = new LLNode(1);
		head1.next = new LLNode(2);
		head1.next.next = new LLNode(3);
		head1.next.next.next = new LLNode(4);
		head1.next.next.next.next = new LLNode(6);
		head1.next.next.next.next.next = new LLNode(8);
		head1.next.next.next.next.next.next = new LLNode(9);

		pairWiseSwap(head1);
	}

	static void pairWiseSwap(LLNode head) {
		LLNode currentNode = head;
		int temp = 0;

		if (head == null)
			return;

		while ((currentNode != null) && (currentNode.next != null)) {

			temp = currentNode.next.data;
			currentNode.next.data = currentNode.data;
			currentNode.data = temp;
			currentNode = currentNode.next;
			currentNode = currentNode.next;

		}

		while (head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}

	}

}
