package com.interviewbit;

public class LRU_Main {

	public static void main(String[] args) {

		LFU lfu = new LFU(4);

		lfu.set(1);
		lfu.set(2);
		lfu.set(3);
		lfu.set(4);
		lfu.set(1);
		lfu.set(1);
		lfu.set(1);
		lfu.set(2);
		lfu.set(5);
	}
}
