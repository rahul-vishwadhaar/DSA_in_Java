/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class BinaryTreeToDLL {

	/**
	 * @param args
	 */
	static DLLNode head = null;
	static DLLNode current = null;

	public static void main(String[] args) {
		Node root = new Node(4);

		root.left = new Node(2);
		root.right = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(3);

		printInorder(root);

		while (head.next != null) {
			System.out.println(head.data);
			head = head.next;
		}

		while (head != null) {
			System.out.println(head.data);
			head = head.prev;
		}
	}

	private static void binaryToDLL(Node root) {

		printInorder(root);
	}

	private static void printInorder(Node root) {

		if (root == null)
			return;
		printInorder(root.left);

		DLLNode temp = new DLLNode(root.data);
		// System.out.println(root.data);
		if (head == null) {
			head = temp;
			current = temp;
		} else {
			current.next = temp;
			temp.prev = current;
			current = current.next;
		}

		printInorder(root.right);

	}

}
