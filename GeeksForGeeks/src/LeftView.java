import java.util.ArrayList;

/**
 * 
 */

/**
 * @author rahul kumar
 *
 */
public class LeftView {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	

	void leftView(Node root)
    {
		int nodeCount = 0;
	
		ArrayList<Node> queue = new ArrayList<Node>();
		Node currentNode = null;

		if (root == null)
			return;

		queue.add(root);

		System.out.print(root.data + " ");
		while (queue.size() != 0) {

			if (nodeCount == 0) {
				nodeCount = queue.size();
				System.out.println(queue.get(0).data + " ");
			}

			currentNode = queue.get(0);
			queue.remove(0);
			nodeCount--;

			if (currentNode.left != null) {
				queue.add(currentNode.left);
			}
			if (currentNode.right != null) {
				queue.add(currentNode.right);
			}
		}
	}
}
