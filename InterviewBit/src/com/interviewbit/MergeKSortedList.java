/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;

/**
 * @author rahul
 *
 */
public class MergeKSortedList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		a.next.next = new ListNode(3);

		ListNode b = new ListNode(1);
		b.next = new ListNode(2);
		b.next.next = new ListNode(3);

		ListNode c = new ListNode(1);
		c.next = new ListNode(2);
		c.next.next = new ListNode(3);

		ArrayList<ListNode> arr = new ArrayList<ListNode>();

		arr.add(a);
		arr.add(b);
		arr.add(c);

		ListNode root = mergeKLists(arr);

		while (root != null) {
			System.out.println(root.val);
			root = root.next;
		}
	}

	public static ListNode mergeKLists(ArrayList<ListNode> a) {

		if (a.size() == 1)
			return a.get(0);

		int index = 1;

		ListNode root = a.get(0);
		while (index < a.size()) {
			root = merge(root, a.get(index));
			index++;
		}
		return root;

	}

	public static ListNode merge(ListNode a, ListNode b) {

		ListNode root = null;
		ListNode current = null;

		while ((a != null) || (b != null)) {

			if (a == null) {
				if (root == null) {
					current = b;
					root = current;
				} else {
					current.next = b;
					current = current.next;
				}
				b = b.next;

			} else if (b == null) {
				if (root == null) {
					current = a;
					root = current;
				} else {
					current.next = a;
					current = current.next;
				}
				a = a.next;

			} else if (a.val < b.val) {
				if (root == null) {
					current = a;
					root = current;
				} else {
					current.next = a;
					current = current.next;
				}
				a = a.next;

			} else {
				if (root == null) {
					current = b;
					root = current;
				} else {
					current.next = b;
					current = current.next;
				}
				b = b.next;
			}
		}
		return root;
	}

}
