/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class BST_Iterator_Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		TreeNode root = new TreeNode(5);

		root.left = new TreeNode(3);
		root.right = new TreeNode(7);

		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);

		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(8);

		BST_Iterator i = new BST_Iterator(root);

		while (i.hasNext())
			System.out.print(i.next());

	}

}
