/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class RootLeafPathSum {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		int sum = 1;

		System.out.println(hasPathSum(root, sum));
	}

	public static int hasPathSum(TreeNode a, int b) {

		int depth = 0;
		return preOrder(a, 0, b, depth);

	}

	private static int preOrder(TreeNode a, int sum, int b, int depth) {

		int result = 0;
		if (a == null) {

			System.out.print(sum + " ");

			if ((sum == b) && (depth > 1)) {
				result = 1;
			} else {
				result = 0;
			}

		} else {
			depth++;

			if ((a.left == null) && (a.right == null)) {

				System.out.println(sum + a.val);
				if (sum + a.val == b)
					return 1;
				else
					return 0;
			}

			result = result | preOrder(a.left, sum + a.val, b, depth);
			if (result == 1)
				return result;
			result = result | preOrder(a.right, sum + a.val, b, depth);
		}
		return result;
	}

}
