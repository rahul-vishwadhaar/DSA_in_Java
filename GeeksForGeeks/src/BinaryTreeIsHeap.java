/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class BinaryTreeIsHeap {

	/**
	 * @param args
	 */
	static int count = 0;

	public static void main(String[] args) {
		// 10 20 L 10 30 R 20 40 L 20 60 R

		Node root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);
		root.left.left = new Node(40);
		root.left.right = new Node(60);

		System.out.println(isMaxHeap(root));
	}

	private static boolean isMaxHeap(Node root) {

		boolean result = false;

		if (root == null)
			return false;

		result = checkTree(root, -1);

		return result;
	}

	private static boolean checkTree(Node root, int num) {
		int leaves = 0;

		if (root == null) {
			return true;
		}

		if (count > 1) {
			return false;
		}
		if (num != -1) {
			if (root.data > num) {
				return false;
			}
		}
		if (root.left != null) {
			leaves++;
		}

		if (root.right != null) {
			leaves++;
		}

		if (leaves == 1)
			count++;

		return (checkTree(root.left, root.data) ? checkTree(root.right,
				root.data) : false);

	}

}
