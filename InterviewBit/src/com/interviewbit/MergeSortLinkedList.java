/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class MergeSortLinkedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode root = new ListNode(1);

		root.next = new ListNode(4);
		root.next.next = new ListNode(2);
		root.next.next.next = new ListNode(9);
		root.next.next.next.next = new ListNode(7);
		root.next.next.next.next.next = new ListNode(6);

		root = sortList(root);

		while (root != null) {
			System.out.println(root.val);
			root = root.next;
		}

	}

	public static ListNode sortList(ListNode root) {

		ListNode mid = findMiddle(root);

		if (mid == null) {
			return root;
		}

		ListNode root1 = sortList(root);
		ListNode root2 = sortList(mid);

		return root = mergeTwoLists(root1, root2);
	}

	private static ListNode findMiddle(ListNode root) {

		ListNode slow = root;
		ListNode fast = root;
		ListNode prev = null;

		while (fast != null) {

			prev = slow;
			slow = slow.next;
			fast = fast.next;

			if (fast != null)
				fast = fast.next;
		}

		if (prev != null)
			prev.next = null;

		return slow;
	}

	private static ListNode mergeTwoLists(ListNode a, ListNode b) {

		ListNode current = null;
		ListNode root = null;

		while ((a != null) || (b != null)) {

			if (a == null) {
				if (root == null) {
					root = new ListNode(b.val);
					current = root;
				} else {
					current.next = new ListNode(b.val);
					current = current.next;
				}
				b = b.next;
			} else if (b == null) {
				if (root == null) {
					root = new ListNode(a.val);
					current = root;
				} else {
					current.next = new ListNode(a.val);
					current = current.next;
				}
				a = a.next;
			} else if (a.val < b.val) {
				if (root == null) {
					root = new ListNode(a.val);
					current = root;
				} else {
					current.next = new ListNode(a.val);
					current = current.next;
				}
				a = a.next;
			} else {
				if (root == null) {
					root = new ListNode(b.val);
					current = root;
				} else {
					current.next = new ListNode(b.val);
					current = current.next;
				}
				b = b.next;

			}

		}
		return root;

	}
}