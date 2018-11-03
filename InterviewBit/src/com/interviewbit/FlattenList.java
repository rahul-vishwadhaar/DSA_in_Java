package com.interviewbit;

public class FlattenList {

	private static TreeNode current = null;
	private static TreeNode result = null;

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(5);
		root.right.right = new TreeNode(6);

		root = flatten(root);

		while (root != null) {
			System.out.println(root.val);
			root = root.right;
		}
		System.out.println("End");

	}

	public static TreeNode flatten(TreeNode a) {

		preOrder(a);

		return result;

	}

	public static void preOrder(TreeNode root) {

		if (root == null)
			return;

		insert(root.val);

		preOrder(root.left);
		preOrder(root.right);

	}

	private static void insert(int val) {

		// System.out.println(val);
		if (result == null) {
			result = new TreeNode(val);
			current = result;
		} else {

			current.right = new TreeNode(val);
			current = current.right;
		}

	}
}
