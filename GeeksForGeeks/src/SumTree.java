/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class SumTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static Node sumTree(Node head) {

		int headValue = 0;
		headValue = createSumTree(head);
		head.data = headValue;
		return head;

	}

	private static int createSumTree(Node head) {

		int sum = 0;
		int returnValue = 0;

		if (head == null)
			return 0;

		sum = createSumTree(head.left);
		sum = sum + createSumTree(head.right);

		returnValue = head.data;
		head.data = sum;
		return returnValue;

	}

}
