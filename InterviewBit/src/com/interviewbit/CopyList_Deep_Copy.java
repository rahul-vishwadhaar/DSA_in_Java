/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author rahul
 *
 */
public class CopyList_Deep_Copy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RandomListNode head = new RandomListNode(1);
		head.random = new RandomListNode(0);

		head.next = new RandomListNode(2);
		head.next.random = null;

		head.next.next = new RandomListNode(3);
		head.next.next.random = new RandomListNode(2);

		head = copyRandomList(head);

		while (head != null) {
			System.out.println(head.label);
			System.out.println(head.random.label);

			head = head.next;
		}

	}

	public static RandomListNode copyRandomList(RandomListNode head) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		RandomListNode current = null;

		int len = 0;

		current = head;

		while (current != null) {

			map.put(len, current.label);

			current = current.next;
			len++;
		}

		int index = 0;
		current = head;

		RandomListNode newHead = null;
		RandomListNode currentNew = null;

		while (current != null) {

			if (newHead == null) {
				newHead = new RandomListNode(current.label);
				currentNew = newHead;
			} else {
				currentNew.next = new RandomListNode(current.label);
				currentNew = currentNew.next;
			}

			if (current.random == null) {
				currentNew.random = new RandomListNode(0);
			} else {
				index = current.random.label;

				if (index == len) {
					currentNew.random = new RandomListNode(0);
				} else {

					index %= len;
					currentNew.random = new RandomListNode(map.get(index));
				}
			}

			current = current.next;
			// currentNew = currentNew.next;

		}

		return newHead;

	}
}
