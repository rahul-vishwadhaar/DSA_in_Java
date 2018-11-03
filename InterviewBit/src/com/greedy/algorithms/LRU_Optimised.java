package com.greedy.algorithms;

import java.util.ArrayList;
import java.util.HashSet;

public class LRU_Optimised {

	private static HashSet<Integer> cache = new HashSet<Integer>();
	private static ArrayList<Integer> queue = new ArrayList<Integer>();
	private static int size = 0;
	private static int cacheSize = 0;

	public static void main(String[] args) {
		int[] arr = { 1, 2, 1, 2, 3, 2, 3, 1, 2 };
		int k = 2;
		int pageFaults = 0;

		init(k);

		for (int i = 0; i < arr.length; i++) {
			pageFaults += accessPage(arr[i]);

			System.out.println("Cache :" + cache);
			System.out.println("Queue : " + queue);
		}

		System.out.println(pageFaults);
	}

	private static void init(int k) {
		cacheSize = k;

	}

	public static int accessPage(int page) {

		if (cache.contains(page)) {
			rearrangeQueue(page);
			return 0;
		}

		if (size < cacheSize) {
			cache.add(page);
			size++;
			addToQueue(page, false);
			return 1;
		}

		addToQueue(page, true);
		return 1;

	}

	private static void rearrangeQueue(int page) {

		for (int i = 0; i < queue.size(); i++) {
			if (queue.get(i) == page) {
				queue.remove(i);
			}
		}

//		cache.add(page);
		queue.add(0, page);

	}

	private static void addToQueue(int page, boolean flag) {

		queue.add(0, page);
		cache.add(page);

		if (flag) {
			cache.remove(queue.get(queue.size() - 1));
			queue.remove(queue.size() - 1);

		}
	}

}
