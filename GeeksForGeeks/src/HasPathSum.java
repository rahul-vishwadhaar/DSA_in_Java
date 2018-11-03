public class HasPathSum {
	int count = 0;

	boolean hasPathSum(Node node, int sum) {
		sum = sum - node.data;

		if (sum == 0) {
			if ((node.left == null) && (node.right == null)) {
				count++;
				return true;
			}
		}

		hasPathSum(node.right, sum);
		hasPathSum(node.left, sum);

		if (count > 0)
			return true;
		else
			return false;
	}

}
