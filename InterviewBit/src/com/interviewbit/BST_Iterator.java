/**
 * 
 */
package com.interviewbit;

import java.util.ArrayList;

/**
 * @author rahul
 *
 */
public class BST_Iterator {

	ArrayList<Integer> treeList = null;
	TreeNode root = null;
	boolean flag = false;;

	public BST_Iterator(TreeNode root) {
		this.root = root;
		treeList = new ArrayList<Integer>();
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		init();

		if (treeList.isEmpty())
			return false;

		return true;
	}

	/** @return the next smallest number */
	public int next() {
		init();

		int num = treeList.get(0);
		treeList.remove(0);
		return num;
	}

	public void init() {
		if (flag)
			return;
		flag = true;

		inorder(root);
	}

	public void inorder(TreeNode root) {

		if (root == null)
			return;

		inorder(root.left);
		treeList.add(root.val);
		inorder(root.right);
	}

}
