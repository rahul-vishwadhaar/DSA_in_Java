/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;
import java.util.List;

/**
 * @author rahul
 *
 */
public class SortedArrayToBST {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		final List<Integer> a = new ArrayList<Integer>();
		int index = 0;
		// a.add(1);
		// a.add(2);
		// a.add(3);
		// a.add(4);

		int[] arr = new int[a.size()];

		for (Integer num : a) {
			arr[index++] = num;
		}
		a.toArray();

		TreeNode root = createTree(arr, 0, arr.length - 1);

		inorder(root);
	}

	private static void inorder(TreeNode root) {
		if (root == null)
			return;

		inorder(root.left);
		System.out.println(root.val);
		inorder(root.right);

	}

	public static TreeNode createTree(int[] arr, int start, int end) {

		TreeNode root;

		if (start > end)
			return null;

		int mid = (start + end) / 2;

		root = new TreeNode(arr[mid]);

		root.left = createTree(arr, start, mid - 1);
		root.right = createTree(arr, mid + 1, end);

		return root;

	}
}
