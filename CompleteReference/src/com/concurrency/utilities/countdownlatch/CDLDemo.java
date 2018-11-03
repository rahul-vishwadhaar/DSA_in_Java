package com.concurrency.utilities.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CDLDemo {

	public static void main(String[] args) {

		CountDownLatch cdl = new CountDownLatch(5);

		System.out.println("Starting");

		new MyThread(cdl);

		try {
			cdl.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Done");
	}

}
