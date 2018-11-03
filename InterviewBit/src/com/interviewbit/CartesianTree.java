/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;

/**
 * @author rahul
 *
 */
public class CartesianTree {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ArrayList<Integer> a = new ArrayList<Integer>();

		a.add(1);
		a.add(3);
		a.add(2);
		a.add(7);
		a.add(4);
		a.add(6);
		a.add(5);

		TreeNode root = buildTree(a);

		System.out.println("end");

		a = new ArrayList<Integer>();

		a.add(1);
		a.add(2);
		a.add(3);
		a.add(4);
		a.add(5);
		a.add(6);
		a.add(7);

		root = buildTree(a);
		System.out.println("end");

	}

	public static TreeNode buildTree(ArrayList<Integer> a) {

		TreeNode root = null;
		TreeNode newNode = null;
		for (Integer num : a) {

			newNode = new TreeNode(num);

			if (root == null) {
				root = newNode;
			} else if (num > root.val) {
				newNode.left = root;
				root = newNode;
			} else {

				insertIntoTree(root, newNode);
			}
		}

		return root;

	}

	private static void insertIntoTree(TreeNode root, TreeNode newNode) {

		TreeNode prevNode = null;

		while (root.right != null) {

			prevNode = root;
			root = root.right;

			if (root.val < newNode.val) {

				newNode.left = root;
				prevNode.right = newNode;
				return;
			}
		}

		root.right = newNode;

	}

}
