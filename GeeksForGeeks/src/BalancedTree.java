/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class BalancedTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Node node = new Node(1);

		node.left = new Node(2);
		node.right = new Node(3);

		node.left.left = new Node(3);
		node.left.left.left = new Node(3);

		isBalancedTree(node);
	}

	private static boolean isBalancedTree(Node root) {
		boolean result = false;

		System.out.println(postOrder(root, 0));

		return false;
	}

	private static int postOrder(Node root, int i) {

		
		if (root == null)
			return i;

		postOrder(root.left, i+1);
		postOrder(root.right, i+1);

		return i++;

	}
}
