package com.concurrency.callable;

import java.util.concurrent.Callable;

public class Factorial implements Callable<Integer> {

	int stop;

	public Factorial(int stop) {
		this.stop = stop;
	}

	public Integer call() throws Exception {
		int fact = 1;

		for (int i = 1; i < stop; i++) {
			fact = fact * i;
		}
		return fact;
	}

}
