package com.interviewbit;

public class SortedArrayToBST2 {

	public static void main(String args) {

	}

	public static TreeNode sortedListToBST(ListNode a) {

		int index = 0;
		int size = 0;
		ListNode temp = a;

		while (temp != null) {
			size++;
			temp = temp.next;
		}
		int[] arr = new int[size];

		while (a != null) {
			arr[index++] = a.val;
			a = a.next;
		}

		TreeNode root = createTree(arr, 0, arr.length - 1);

		return root;

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
