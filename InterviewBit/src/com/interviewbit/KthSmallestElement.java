/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class KthSmallestElement {

	/**
	 * @param args
	 */
	static int count = 0;
	static int result = 0;

	public static void main(String[] args) {

		TreeNode root = new TreeNode(4);

		root.left = new TreeNode(2);
		root.right = new TreeNode(5);

		root.left.left = new TreeNode(1);
		// root.left.right = new TreeNode(5);

		System.out.println(kthsmallest(root, 2));
	}

	public static int kthsmallest(TreeNode root, int k) {

		count = k;
		inOrder(root);

		return result;
	}

	private static void inOrder(TreeNode root) {

		if (root == null)
			return;

		if (count < 0)
			return;

		inOrder(root.left);

		count--;
		if (count == 0)
			result = root.val;

		inOrder(root.right);

	}

}
