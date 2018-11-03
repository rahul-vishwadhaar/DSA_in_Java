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
public class LRU {

	private HashMap<Integer, Integer> cache;

	private ArrayList<Integer> queue;
	private int size = 0;
	private int cacheSize = 0;

	public LRU(int capacity) {
		this.cacheSize = capacity;
		cache = new HashMap<Integer, Integer>();
		queue = new ArrayList<Integer>();

	}

	public int get(int key) {

		if (cache.containsKey(key)) {
			rearrangeQueue(key);
			return cache.get(key);
		}

		return -1;
	}

	public void set(int key, int value) {

		if (cache.containsKey(key)) {
			cache.put(key, value);
			rearrangeQueue(key);
			return;
		}

		if (size < cacheSize) {
			cache.put(key, value);
			size++;
			addToQueue(key, false);
			return;
		}

		cache.put(key, value);
		addToQueue(key, true);
		return;

	}

	private void rearrangeQueue(int page) {

		for (int i = 0; i < queue.size(); i++) {
			if (queue.get(i) == page) {
				queue.remove(i);
			}
		}

		queue.add(0, page);

	}

	private void addToQueue(int page, boolean flag) {

		queue.add(0, page);

		if (flag) {
			cache.remove(queue.get(queue.size() - 1));
			queue.remove(queue.size() - 1);

		}
	}

}
