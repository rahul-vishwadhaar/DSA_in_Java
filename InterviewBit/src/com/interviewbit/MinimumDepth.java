/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class MinimumDepth {

	/**
	 * @param args
	 * 
	 */
	static int minDepth = Integer.MAX_VALUE;

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);

		// root.left = new TreeNode(2);
		// root.right = new TreeNode(3);

		// root.left.left = new TreeNode(4);
		// root.left.right = new TreeNode(5);

		System.out.println(minDepth(root));

		// System.out.println(minDepth);
	}

	static int min = Integer.MAX_VALUE;

	public static int minDepth(TreeNode a) {

		getMinDepth(a, 0);

		return min;
	}

	public static void getMinDepth(TreeNode a, int currentDepth) {

		if (a == null)
			return;

		currentDepth++;
		if ((a.left == null) && (a.right == null)) {

			if ((currentDepth > 0) && (currentDepth < min))
				min = currentDepth;

			return;
		}

		getMinDepth(a.left, currentDepth);
		getMinDepth(a.right, currentDepth);

	}
}