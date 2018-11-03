package com.concurrency.callable;

import java.util.concurrent.Callable;

public class Sum implements Callable<Integer> {
	int stop;

	Sum(int s) {
		stop = s;
	}

	public Integer call() throws Exception {
		int sum = 0;

		for (int i = 0; i <= stop; i++) {
			sum += i;
		}
		return sum;
	}
}
