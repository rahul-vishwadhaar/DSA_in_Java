/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class RemoveNElement {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ListNode a = new ListNode(1);
		a.next = new ListNode(2);
		a.next.next = new ListNode(3);
		a.next.next.next = new ListNode(4);

		a = removeNthFromEnd(a, 4);

		while (a != null) {
			System.out.println(a.val);
			a = a.next;
		}

	}

	public static ListNode removeNthFromEnd(ListNode a, int b) {

		ListNode head = a;
		int length = 0;

		if (b == 0)
			return a;

		while (head != null) {
			length++;
			head = head.next;
		}

		head = a;

		length = length - b;

		if (length <= 0) {
			a = a.next;
			return a;
		}

		while (length-- > 1) {
			head = head.next;
		}

		if (head.next != null)
			head.next = head.next.next;

		return a;
	}

}
