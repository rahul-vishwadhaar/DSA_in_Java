/**
 * 
 */

/**
 * @author rahul kumar
 * 
 */

import java.util.*;

public class FlatteningOfLinkedList {

	/**
	 * @param args
	 */

	public class Node {

		int data;
		Node right;
		Node down;

		Node(int data) {
			this.data = data;
			right = down = null;
		}
	}

	public static void main(String[] args) {

		FlatteningOfLinkedList thisObj = new FlatteningOfLinkedList();
		Node head = thisObj.new Node(5);

		head.down = thisObj.new Node(7);
		head.down.down = thisObj.new Node(8);
		head.down.down.down = thisObj.new Node(30);

		head.right = thisObj.new Node(10);
		head.right.down = thisObj.new Node(20);

		head.right.right = thisObj.new Node(19);
		head.right.right.down = thisObj.new Node(22);
		head.right.right.down.down = thisObj.new Node(50);

		head.right.right.right = thisObj.new Node(20);
		head.right.right.right.down = thisObj.new Node(35);
		head.right.right.right.down.down = thisObj.new Node(40);
		head.right.right.right.down.down.down = thisObj.new Node(45);

		Node currentHead = head;
		Node nextHead = head.right;

		while (nextHead != null) {

			currentHead = merge(currentHead, nextHead);
			nextHead = nextHead.right;
		}

		while (currentHead != null) {
			System.out.println(currentHead.data);
			currentHead = currentHead.down;
		}

	}

	private static Node merge(Node currentHead, Node nextHead) {
		Node head = null;
		Node temp = null;
		Node currentNode = null;
		FlatteningOfLinkedList thisObj = new FlatteningOfLinkedList();

		while ((currentHead != null) || (nextHead != null)) {

			if (currentHead == null) {

				temp = thisObj.new Node(nextHead.data);
				nextHead = nextHead.down;

			} else if (nextHead == null) {
				temp = thisObj.new Node(currentHead.data);
				currentHead = currentHead.down;

			} else {

				if (currentHead.data < nextHead.data) {
					temp = thisObj.new Node(currentHead.data);
					currentHead = currentHead.down;
				} else {
					temp = thisObj.new Node(nextHead.data);
					nextHead = nextHead.down;
				}

			}

			if (head == null) {
				head = temp;
				currentNode = temp;
			} else {
				currentNode.down = temp;
				currentNode = currentNode.down;

			}

		}
		return head;
	}

}
