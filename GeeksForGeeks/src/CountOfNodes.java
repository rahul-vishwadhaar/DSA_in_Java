import java.io.ObjectInputStream.GetField;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class CountOfNodes {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node(10);

		root.left = new Node(5);
		root.left.left = new Node(1);
		root.left.right = new Node(40);

		root.right = new Node(50);
		root.right.right = new Node(100);

		System.out.println(getCountOfNode(root, 5, 45));
	}

	private static int getCountOfNode(Node root, int low, int high) {
		int count = 0;
		if (root == null)
			return 0;

		if (low < root.data)
			count += getCountOfNode(root.left, low, high);

		if ((low <= root.data) && (high >= root.data))
			count++;
		
		if (high >= root.data)
			count += getCountOfNode(root.right, low, high);

		return count;// Your code here
	}

}
