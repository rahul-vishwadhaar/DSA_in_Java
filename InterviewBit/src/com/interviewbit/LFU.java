package com.interviewbit;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.TreeSet;

public class LFU {

	private final int capacity;
	private int currentSize = 0;
	private TreeMap<Integer, Integer> cache = new TreeMap<Integer, Integer>();

	private ArrayList<TreeSet<Integer>> queue = new ArrayList<TreeSet<Integer>>();

	public LFU(int maxSize) {
		this.capacity = maxSize;

	}

	public int get(int num) {

		int frequency = cache.get(num) + 1;
		if (cache.containsKey(num)) {
			cache.put(num, frequency);

			rearrangeQueue(num, frequency);

			return 1;
		}

		return -1;
	}

	public void set(int num) {

		int key = 0;

		if (cache.containsKey(num)) {

			rearrangeQueue(num, cache.get(num) + 1);
			cache.put(num, cache.get(num) + 1);
			return;

		}

		if (currentSize < capacity) {
			currentSize++;

		} else {

			key = getMinKey();
			cache.remove(key);
		}

		cache.put(num, 1);
		rearrangeQueue(num, 1);

		System.out.println(cache);
	}

	private void rearrangeQueue(int num, int frequency) {

		if (frequency > 1) {
			queue.get((frequency - 1) - 1).remove(num);
		}

		if (queue.size() < frequency) {
			queue.add(new TreeSet<Integer>());
		}
		queue.get(frequency - 1).add(num);
		System.out.println(queue);
	}

	private int getMinKey() {

		int key = 0;
		for (TreeSet<Integer> set : queue) {
			if (set.size() > 0) {
				key = set.first();
				set.remove(key);
				break;
			}
		}

		return key;
	}

}
