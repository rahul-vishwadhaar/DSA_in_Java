/**
 * 
 */
package com.interviewbit;

/**
 * @author rahul
 *
 */
public class LRUMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int capacity = 2;

		LRU lruCache = new LRU(capacity);

		/*
		 * S 2 1 S 1 1 S 2 3 S 4 1 G 1 G 2
		 */

		lruCache.set(2, 1);
		lruCache.set(1, 1);
		lruCache.set(2, 3);
		lruCache.set(4, 1);

	

	}

}
