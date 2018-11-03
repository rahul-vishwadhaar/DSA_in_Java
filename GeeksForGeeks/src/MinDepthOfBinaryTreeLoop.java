import java.util.ArrayList;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class MinDepthOfBinaryTreeLoop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node(1);

		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(5);

		System.out.println(minimumDepth(root));

	}

	private static int minimumDepth(Node root) {
		int depth = 0;
		int len = 0;
		ArrayList<Node> queue = new ArrayList<Node>();

		if (root == null)
			return 0;

		queue.add(root);
		len = queue.size();

		while (!queue.isEmpty()) {
			Node tempNode = null;
			if (len == 0) {
				depth++;
				len = queue.size();
			}

			tempNode = queue.get(0);
			queue.remove(0);

			if ((tempNode.left == null) && (tempNode.right == null))
				break;

			if (tempNode.left != null)
				queue.add(tempNode.left);

			if (tempNode.right != null)
				queue.add(tempNode.right);

			len--;
		}

		return depth;
	}
}
