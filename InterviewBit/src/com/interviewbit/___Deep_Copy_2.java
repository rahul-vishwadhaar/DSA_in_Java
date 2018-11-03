package com.interviewbit;

import java.util.ArrayList;
import java.util.HashMap;

public class ___Deep_Copy_2 {

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
			if (head.random != null)
				System.out.println(head.random.label);
			else
				System.out.println(0);

			head = head.next;
		}

	}

	public static RandomListNode copyRandomList(RandomListNode head) {

		ArrayList<Integer> list = new ArrayList<Integer>();
		HashMap<Integer, RandomListNode> map = new HashMap<Integer, RandomListNode>();

		RandomListNode current = null;
		RandomListNode headNew = null;
		RandomListNode currentNew = null;

		int len = 0;

		current = head;

		while (current != null) {

			if (headNew == null) {
				headNew = new RandomListNode(current.label);
				currentNew = headNew;
				map.put(current.label, currentNew);
			} else {
				currentNew.next = new RandomListNode(current.label);
				currentNew = currentNew.next;
				map.put(current.label, currentNew);
			}
			len++;
			current = current.next;
		}

		current = head;
		currentNew = headNew;

		map.put(-1, new RandomListNode(0));

		while (current != null) {

			if (current.random == null) {
				currentNew.random = null;
			} else {
				currentNew.random = map.get(current.random.label);
			}

			current = current.next;
			currentNew = currentNew.next;

		}
		return headNew;
	}

}
