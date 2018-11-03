/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class ListCycle {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);

		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node4;

		ListNode result = detectCycle(head);

		if (result == null) {
			System.out.println("Null");
		} else {
			System.out.println(result.val);
		}
	}

	public static ListNode detectCycle(ListNode a) {

		ListNode singleNode = a;
		ListNode doubleNode = a;
		ListNode head2 = null;

		while (true) {

			if (singleNode == null) {
				return null;
			}
			singleNode = singleNode.next;

			if (doubleNode == null) {
				return null;
			}

			doubleNode = doubleNode.next;

			if (doubleNode == null) {
				return null;
			}

			doubleNode = doubleNode.next;

			if (singleNode == doubleNode) {
				head2 = singleNode;
				break;
			}
		}

		return head2;
	}

}
