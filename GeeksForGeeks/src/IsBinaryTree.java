/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class IsBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node head = null;
		int result = 0;
		int data = -1;

		head = new Node(4);

		head.left = new Node(2);
		head.right = new Node(5);
		head.left.left = new Node(1);
		head.left.right = new Node(3);

		result = isBST(head);// , data);

		if (result > 0)
			System.out.println(false);
		else
			System.out.println(true);

	}

	public static int isBST(Node node, int data) {

		int result = 0;

		if (node == null)
			return result;

		result = result + isBST(node.left, data);
		if (result > 0)
			return result;

		if (data == -1)
			data = node.data;
		else if (data < node.data)
			data = node.data;
		else
			return result++;

		return result + isBST(node.right, data);

	}

	static int min = 0;

	static int isBST(Node root) {
		int result = 1;

		if (root == null)
			return 1;

		result = result & isBST(root.left);

		if (root.data > min) {
			min = root.data;
		} else {
			return 0;
		}

		result = result & isBST(root.right);

		return result;
	}

}
