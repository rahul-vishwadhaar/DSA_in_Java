/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;

/**
 * @author rahul
 *
 */
public class CheckBST {

	/**
	 * @param args
	 */

	static ArrayList<Integer> list = null;

	public static void main(String[] args) {
		TreeNode root = new TreeNode(4);

		root.left = new TreeNode(2);
		root.right = new TreeNode(5);

		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(5);

		System.out.println(isValidBST(root));

		TreeNode root2 = new TreeNode(3);

		root2.left = new TreeNode(2);
		root2.right = new TreeNode(4);

		root2.left.left = new TreeNode(4);
		root2.left.right = new TreeNode(5);

		System.out.println(isValidBST(root2));

		// 3 2 4 1 3

	}

	public static int isValidBST(TreeNode a) {

		list = new ArrayList<Integer>();
		inOrder(a);

		System.out.println(list);

		int num = list.get(0);
		for (int i = 1; i < list.size(); i++) {

			if (list.get(i) <= num)
				return 0;

			num = list.get(i);
		}
		return 1;
	}

	private static int checkBST(TreeNode a, int min, int max) {

		int result = 1;

		if (a == null)
			return 1;

		if (a.left != null) {

			System.out.println("Root  " + a.val + " Left " + a.left.val + " min " + min);

			if (!(a.left.val < a.val)) {
				System.out.println("_________");
				return 0;
			}

		}

		if ((a.right != null)) {

			System.out.println("Root " + a.val + " Right " + a.right.val + " max " + max);

			if (!((a.right.val > a.val) && (a.right.val < max))) {
				return 0;
			}
		}

		result = result & checkBST(a.left, a.val, Integer.MAX_VALUE);

		return (result == 0) ? result : checkBST(a.right, Integer.MIN_VALUE, a.val);
	}

	private static void inOrder(TreeNode root) {

		if (root == null)
			return;

		inOrder(root.left);
		list.add(root.val);
		inOrder(root.right);
	}

}
