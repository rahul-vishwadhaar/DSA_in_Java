/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class MergeTwoSortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode root1 = new ListNode(1);

		root1.next = new ListNode(2);
		root1.next.next = new ListNode(3);

		ListNode root2 = new ListNode(4);

		root2.next = new ListNode(5);
		root2.next.next = new ListNode(6);

		root1 = mergeTwoLists(root1, root2);

		while (root1 != null) {
			System.out.println(root1.val);
			root1 = root1.next;
		}

	}

	public static ListNode mergeTwoLists(ListNode a, ListNode b) {

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
