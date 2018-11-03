/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class DeletionOfMiddleNode {

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

		System.out.println("Before deletion");
		LLNode temp;
		temp = head1;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println(" ");
		
		head1 = deleteMiddle(head1);

		System.out.println("After deletion");
		while (head1 != null) {
			System.out.print(head1.data + " ");
			head1 = head1.next;
		}

	}

	private static LLNode deleteMiddle(LLNode head) {
		LLNode node1 = head;
		LLNode node2 = head;
		LLNode delNode = null;

		while (node1.next != null) {
			node2 = node2.next;
			
			node1 = node1.next;
			if(node1.next != null)
				node1 = node1.next;
		}

		delNode = node2.next;
		node2.data = node2.next.data;
		node2.next = node2.next.next;

		delNode = null;

		return head;
	}

}
