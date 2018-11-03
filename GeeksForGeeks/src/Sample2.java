/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class Sample2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		LLNode head = new LLNode(1);
		head.next = new LLNode(2);
		head.next.next = new LLNode(3);
		head.next.next.next = new LLNode(4);

		head = reverseInRange(head, 1, 2);

		while (head != null) {
			System.out.println(head.data);
			head = head.next;
		}

	}

	private static LLNode reverseInRange(LLNode head, int start, int end) {

		if (start == end)
			return head;
		end -= start;
		LLNode startNode = null;
		LLNode endNode = null;
		LLNode tempHead = head;
		start--;

		while (start-- > 0) {
			startNode = tempHead;
			tempHead = tempHead.next;
		}

		LLNode prevNode = tempHead;
		endNode = prevNode;
		LLNode currentNode = tempHead.next;

		if (currentNode == null)
			return head;

		LLNode nextNode = null;//currentNode.next;
		while ((end-- > 0) && (currentNode != null)) {
			nextNode = currentNode.next;
			currentNode.next = prevNode;
			prevNode = currentNode;
			currentNode = nextNode;
		}
		
		endNode.next = currentNode;
		if(startNode != null) {
			startNode.next = prevNode;
			
		}else {
			head = prevNode;
		}
		return head;

	}
}
