/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class LeafAtSameLevel {

	/**
	 * @param args
	 */
	static int maxLevel = -1;

	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);

		root.left.left = new Node(4);
		root.left.right = new Node(4);
		
		root.right.right = new Node(5);
//	/	root.right.right.right = new Node(7);
		System.out.println(isSameLevel(root, 0));
	}

	private static boolean isSameLevel(Node root, int count) {
		count++;

		if (root == null) {
			return true;
		}

		if ((root.left == null) && (root.right == null)) {
			System.out.println(count);
			if (maxLevel == -1) {
				maxLevel = count;
				return true;
			} else if (maxLevel == count) {
				return true;
			} else {
				return false;
			}
		} else {

			return (isSameLevel(root.left, count)) ? isSameLevel(root.right,
					count) : false;
		}
	}

}
