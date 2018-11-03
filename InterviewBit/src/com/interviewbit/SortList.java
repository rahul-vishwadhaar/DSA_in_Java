/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class SortList {

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

	public static ListNode sortList(ListNode a) {

		ListNode root = null;
		ListNode current = null;
		ListNode prev = null;

		while (a != null) {

			ListNode newNode = new ListNode(a.val);
			if (root == null) {

				root = newNode;
				current = root;

			} else {

				prev = root;
				current = root;
				while (current != null) {

					if (current.val > a.val) {

						if (current == root) {

							newNode.next = current;
							root = newNode;

							break;

						} else {
							prev.next = newNode;
							newNode.next = current;
							break;
						}

					}
					prev = current;
					current = current.next;

				}

				if (current == null) {
					prev.next = newNode;
				}

			}

			a = a.next;

		}
		return root;
	}

}
