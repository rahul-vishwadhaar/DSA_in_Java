/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;

/**
 * @author rahul
 *
 */
public class CheckSymmetryBinaryTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);

		root.left = new TreeNode(2);
		root.right = new TreeNode(2);

		// root.left.left = new TreeNode(1);
		// root.left.right = new TreeNode(5);

		System.out.println(isSymmetric(root));

	}

	public static int isSymmetric(TreeNode a) {

		TreeNode tempNode = null;
		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();
		int length = 0;
		if (a == null)
			return 0;

		queue.add(a);

		while (!queue.isEmpty()) {

			if (length == 0) {

				length = queue.size();
				if (!checkSymmetry(queue))
					return 0;
			}

			tempNode = queue.get(0);
			queue.remove(0);

			if (tempNode.left != null)
				queue.add(tempNode.left);

			if (tempNode.right != null)
				queue.add(tempNode.right);

			length--;

		}

		return 1;
	}

	private static boolean checkSymmetry(ArrayList<TreeNode> queue) {

		int len = queue.size();

		int mid = (queue.size() - 1) / 2;

		TreeNode node1 = null;
		TreeNode node2 = null;

		if (queue.size() == 1)
			return true;

		for (int i = 0; i <= mid; i++) {

			node1 = queue.get(i);
			node2 = queue.get(len - i - 1);

			if (node1.val != node2.val)
				return false;
		}
		return true;
	}

}
