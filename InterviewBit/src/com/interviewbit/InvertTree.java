/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class InvertTree {

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

		TreeNode newRoot = invertTree(root);

		System.out.println(newRoot);
	}

	public static TreeNode invertTree(TreeNode root) {

		if (root == null) {
			return null;
		}

		TreeNode node = new TreeNode(root.val);

		node.left = invertTree(root.right);
		node.right = invertTree(root.left);

		return node;
	}

}
