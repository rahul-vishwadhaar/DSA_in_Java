/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class MergeTwoSorteList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static LLNode MergeLists(LLNode headA, LLNode headB) {
		LLNode head = null;
		LLNode currentNode = null;

		while ((headA != null) || (headB != null)) {

			if (headA == null) {

				if (head == null) {
					head = new LLNode(headB.data);
					currentNode = head;
				} else {
					currentNode.next = new LLNode(headB.data);
					currentNode = currentNode.next;

				}
				headB = headB.next;
			} else if (headB == null) {
				if (head == null) {
					head = new LLNode(headA.data);
					currentNode = head;
				} else {
					currentNode.next = new LLNode(headA.data);
					currentNode = currentNode.next;

				}
				headA = headB.next;

			} else if (headA.data < headB.data) {

				if (head == null) {
					head = new LLNode(headA.data);
					currentNode = head;
				} else {
					currentNode.next = new LLNode(headA.data);
					currentNode = currentNode.next;

				}
				headA = headB.next;
			} else {

				if (head == null) {
					head = new LLNode(headB.data);
					currentNode = head;
				} else {
					currentNode.next = new LLNode(headB.data);
					currentNode = currentNode.next;

				}
				headB = headB.next;
			}
		}

		return head;
	}
}
