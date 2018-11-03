import java.util.ArrayList;

public class ConnectNodeAtSameLevel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	private static Node connect(Node root) {

		ArrayList<Node> queue = new ArrayList<Node>();
		int len = 1;
		int width = len;
		Node tempNode = null;

		if (root == null)
			return null;

		queue.add(root);

		while (!queue.isEmpty()) {

			tempNode = queue.get(0);
			queue.remove(0);

			if (len == 0) {
				//tempNode.nextRight = null;
				len = queue.size();

			} else {
				//tempNode.nextRight = queue.get(0);
			}

			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}

			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
			len--;
		}

		return root;

	}

}
