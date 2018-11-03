/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class ReverseLLRecursion {

	/**
	 * @param args
	 */

	static ListNode head = null;

	public static void main(String[] args) {

		ListNode root = new ListNode(1);

		root.next = new ListNode(2);
		root.next.next = new ListNode(3);
	//	root.next.next.next = new ListNode(9);
	//	root.next.next.next.next = new ListNode(7);
	//	root.next.next.next.next.next = new ListNode(6);

		reverseList(root);
		root.next = null;

		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}

	}

	public static ListNode reverseList(ListNode a) {

		if (a.next == null) {
			head = a;
			return a;
		}

		ListNode next = a.next;

		reverseList(next).next = a;

		return a;
	}

}
