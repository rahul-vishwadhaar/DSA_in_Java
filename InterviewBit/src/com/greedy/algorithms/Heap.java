package com.greedy.algorithms;

public class Heap {

	private int[] heap;
	private int length;

	Heap(int length) {
		this.length = length;

	}

	public int getMin() {

		int min = -1;

		if (length > 0) {
			min = heap[0];
			heap[0] = heap[length];
			heapify(0);

		}

		return min;
	}

	private void heapify(int i) {

		if((2*i < length) || (2*i +1 < length)){
			heapify(i+1);
		}else{
			return;
		}
		
		
	}

	public void add(int k) {

		if (heap == null) {
			heap = new int[length];
		}

		if (heap.length == length - 1)
			return;

		heap[length] = k;
		length++;

		heapify(0);

	}

}
