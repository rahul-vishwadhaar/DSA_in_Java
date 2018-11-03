package com.concurrency.executor;

import java.util.concurrent.CountDownLatch;

public class MyThread implements Runnable {

	String name;
	CountDownLatch cdl;

	MyThread(CountDownLatch cdl, String n) {
		this.cdl = cdl;
		name = n;

		new Thread(this);
	}

	public void run() {
		for (int i = 0; i < 5; i++) {
			System.out.println(name + ": " + i);
			cdl.countDown();
		}
	}

}
