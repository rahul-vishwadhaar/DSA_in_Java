import java.util.ArrayList;

public class PrintSpiral {

	public static void main(String... args) {

		Node node = new Node(1);

		node.left = new Node(2);
		node.right = new Node(3);

		printSpiral(node);
	}

	private static void printSpiral(Node node) {
		int nodeCount = 0;
		int level = 1;

		ArrayList<Node> queue = new ArrayList<Node>();
		Node currentNode = null;

		if (node == null)
			return;

		queue.add(node);

		while (queue.size() != 0) {

			if (nodeCount == 0) {

				nodeCount = queue.size();
				level = ~level;

				if (level < 0)
					printForward(0, nodeCount, queue);
				else
					printReverse(0, nodeCount, queue);

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

	private static void printForward(int start, int end, ArrayList<Node> queue) {

		int i = 0;

		for (i = start; i < end; i++) {
			System.out.print(queue.get(i).data + " ");
		}

	}

	private static void printReverse(int start, int end, ArrayList<Node> queue) {
		int i = 0;

		for (i = end; i > start; i--) {
			System.out.print(queue.get(i - 1).data + " ");
		}

	}

}
