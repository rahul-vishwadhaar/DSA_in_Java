/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class MaxDepth {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.left.left.left = new TreeNode(6);

		System.out.println(maxDepth(root));
	}

	public static int maxDepth(TreeNode a) {

		return preOrder(a, 0);
	}

	private static int preOrder(TreeNode a, int i) {

		if (a == null)
			return 0;

		if ((a.left == null) && (a.right == null)) {

			return i;
		}

		return Math.max(preOrder(a.left, i + 1), preOrder(a.right, i + 1));

	}

}
