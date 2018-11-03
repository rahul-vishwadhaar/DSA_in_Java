/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class printKDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Node root = new Node(1);
		
		root.left = new Node(2);
		root.right = new Node(3);
		
		printKdistance(root, 1);
	}

	static void printKdistance(Node root, int k) {
		if (root == null)
			return;

		if (k < 0)
			return;

		printKdistance(root.left, k - 1);

		if (k == 0)
			System.out.print(root.data + " ");

		printKdistance(root.right, k - 1);

	}

}
