import java.util.ArrayList;

/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */
public class OddEvenLevelDifference {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Node root = new Node(1);
		root.left = new Node(3);
		root.right = new Node(2);

		System.out.println(getLevelDifference(root));

		root = new Node(10);
		root.left = new Node(20);
		root.right = new Node(30);

		root.left.left = new Node(40);
		root.left.right = new Node(60);

		System.out.println(getLevelDifference(root));
	}

	static int getLevelDifference(Node root) {
		int sum = 0;
		int len = 0;
		boolean flag = true;
		int levelSum = 0;
		Node tempNode = null;

		if (root == null)
			return sum;

		ArrayList<Node> queue = new ArrayList<Node>();
		queue.add(root);

		len = queue.size();

		while (!queue.isEmpty()) {

			if (len == 0) {
				if (flag) {
					sum += levelSum;
				} else {
					sum -= levelSum;
				}

				flag = !flag;
				levelSum = 0;
				
				len = queue.size();
			}

			tempNode = queue.get(0);
			queue.remove(0);

			if (tempNode.left != null)
				queue.add(tempNode.left);

			if (tempNode.right != null)
				queue.add(tempNode.right);
			levelSum += tempNode.data;
			len--;

		}

		if (flag) {
			sum += levelSum;
		} else {
			sum -= levelSum;
		}

		return sum;

	}

}
