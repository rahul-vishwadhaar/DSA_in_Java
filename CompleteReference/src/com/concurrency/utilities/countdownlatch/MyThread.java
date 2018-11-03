package com.concurrency.utilities.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class MyThread implements Runnable {

	CountDownLatch latch;

	MyThread(CountDownLatch cdl) {
		this.latch = cdl;

		new Thread(this).start();
	}

	public void run() {

		for (int i = 0; i < 5; i++) {
			System.out.println(i);

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			latch.countDown();
		}
	}

}
