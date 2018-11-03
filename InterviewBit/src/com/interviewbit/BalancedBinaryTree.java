/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;

/**
 * @author rahul
 *
 */
public class BalancedBinaryTree {

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.right.right = new TreeNode(6);

		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(8);

		System.out.println(isBalanced(root));

	}

	public static int isBalanced(TreeNode a) {

		int level = 0;
		int len = 0;
		int expLength = 0;
		int diff = 0;

		TreeNode tempNode = null;

		ArrayList<TreeNode> queue = new ArrayList<TreeNode>();

		if (a == null) {
			return 0;
		}

		queue.add(a);

		while (!queue.isEmpty()) {

			if (len == 0) {

				len = queue.size();
				expLength = (int) Math.pow(2, level);

				level++;
				if (expLength - len > 1)
					diff++;

				if (diff > 1) {
					return 0;
				}

			}

			tempNode = queue.get(0);
			queue.remove(0);
			len--;

			if (tempNode.left != null)
				queue.add(tempNode.left);

			if (tempNode.right != null)
				queue.add(tempNode.right);

		}

		return 1;
	}

}
