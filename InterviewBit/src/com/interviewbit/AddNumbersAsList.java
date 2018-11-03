/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class AddNumbersAsList {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		ListNode a = new ListNode(9);
		a.next = new ListNode(9);
		a.next.next = new ListNode(9);

		ListNode b = new ListNode(4);
		// b.next = new ListNode(2);
		// b.next.next = new ListNode(3);

		a = addTwoNumbers(a, b);

		while (a != null) {

			System.out.println(a.val);
			a = a.next;
		}

	}

	public static ListNode addTwoNumbers(ListNode a, ListNode b) {

		int num1 = 0;
		int num2 = 0;
		int carry = 0;
		int index = 0;
		int sum = 0;

		ListNode result = null;
		ListNode current = null;

		StringBuilder sb = new StringBuilder();

		while ((a != null) || (b != null)) {

			num1 = 0;
			num2 = 0;

			if (a != null) {
				num1 = a.val;
				a = a.next;
			}

			if (b != null) {
				num2 = b.val;
				b = b.next;
			}

			sum = num1 + num2 + carry;
			carry = sum / 10;
			sum = sum % 10;

			if (result == null) {
				result = new ListNode(sum);
				current = result;
			} else {
				current.next = new ListNode(sum);
				current = current.next;
			}

		}

		if (carry > 0)
			current.next = new ListNode(carry);

		return result;
	}

}
