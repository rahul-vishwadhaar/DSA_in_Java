package com.concurrency.executor;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SimpleExecutor {

	public static void main(String... args) {
		CountDownLatch cdl1 = new CountDownLatch(5);
		CountDownLatch cdl2 = new CountDownLatch(5);
		CountDownLatch cdl3 = new CountDownLatch(5);
		CountDownLatch cdl4 = new CountDownLatch(5);
		CountDownLatch cdl5 = new CountDownLatch(5);

		ExecutorService es = Executors.newFixedThreadPool(2);

		System.out.println("Starting");

		es.execute(new MyThread(cdl1, "A"));
		es.execute(new MyThread(cdl2, "B"));
		es.execute(new MyThread(cdl3, "C"));
		es.execute(new MyThread(cdl4, "D"));
		es.execute(new MyThread(cdl5, "E"));

		try {
			cdl1.await();
			cdl2.await();
			cdl3.await();
			cdl4.await();
			cdl5.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		es.shutdown();
		System.out.println("Done");
	}

}
