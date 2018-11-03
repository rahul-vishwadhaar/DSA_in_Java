/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;

/**
 * @author rahul
 *
 */
public class LevelOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);

		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);

		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);

		root.left.left.left = new TreeNode(8);

		System.out.println(levelOrder(root));
	}

	public static ArrayList<ArrayList<Integer>> levelOrder(TreeNode a) {

		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<TreeNode> queue = new ArrayList<>();

		ArrayList<Integer> temp = null;
		int len = 0;

		if (a == null)
			return result;

		queue.add(a);

		while (!queue.isEmpty()) {

			if (len == 0) {

				temp = new ArrayList<Integer>();
				for (TreeNode node : queue) {
					temp.add(node.val);
				}
				result.add(temp);
				len = queue.size();
			}

			TreeNode tempNode = queue.get(0);
			queue.remove(0);

			if (tempNode.left != null) {
				queue.add(tempNode.left);
			}
			if (tempNode.right != null) {
				queue.add(tempNode.right);
			}
			len--;
		}

		return result;
	}
}
