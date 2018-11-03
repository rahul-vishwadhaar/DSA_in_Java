/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class MorrisTraversal {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Node root = new Node(10);
		root.left = new Node(5);

		root.left.left = new Node(-2);
		root.left.right = new Node(6);

		root.left.left.right = new Node(2);
		
		root.left.right.right = new Node(8);

		root.left.left.right.left = new Node(-1);

		root.right = new Node(30);
		root.right.right = new Node(40);

		morrisInOrderTraversal(root);

	}

	private static void morrisInOrderTraversal(Node root) {

		Node current = root;

		while (current != null) {

			if (current.left == null) {
				System.out.println(current.data);
				current = current.right;
			} else {

				Node preDeccessor = findInOrderPredeccessor(current);

				if (preDeccessor.right == null) {
					preDeccessor.right = current;
					current = current.left;
				} else {
					preDeccessor.right = null;
					System.out.println(current.data);
					current = current.right;
				}
			}
		}
	}

	private static Node findInOrderPredeccessor(Node current) {
		Node node = current.left;

		while (node.right != null) {
			if(node.right == current)
				break;
			node = node.right;
		}
		return node;
	}
}
