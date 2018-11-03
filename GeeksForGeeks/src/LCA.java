public class LCA {

	public static void main(String... args) {

	}

	private static Node findLCA(Node node, int n1, int n2) {

		if (node == null)
			return null;

		if ((n1 == node.data) || (n2 == node.data)) {
			return node;
		}

		Node leftCA = findLCA(node.left, n1, n2);
		Node rightCA = findLCA(node.right, n1, n2);

		if ((leftCA != null) && (rightCA != null)) {
			return node;
		}

		return (leftCA == null) ? rightCA : leftCA;

	}
}
