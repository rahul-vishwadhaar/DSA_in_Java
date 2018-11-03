import java.util.ArrayList;
import java.util.HashSet;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class CycleInAGraph {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = root.right;

		System.out.println("Is Cyclic : " + isCyclic(root));
	}

	public static boolean isCyclic(Node root) {
		boolean result = false;

		HashSet<Integer> nodes = new HashSet<Integer>();

		ArrayList<Node> stack = new ArrayList<Node>();

		if (root == null)
			return true;

		stack.add(root);

		while (!stack.isEmpty()) {

			Node tempNode = stack.get(stack.size() - 1);
			stack.remove(stack.size() - 1);

			if (nodes.contains(tempNode.data)) {
				result = true;
				break;
			}

			nodes.add(tempNode.data);

			if (tempNode.left != null)
				stack.add(tempNode.left);

			if (tempNode.right != null)
				stack.add(tempNode.right);
		}

		return result;

	}

}
