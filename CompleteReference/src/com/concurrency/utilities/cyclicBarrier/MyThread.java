package com.concurrency.utilities.cyclicBarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyThread implements Runnable {

	CyclicBarrier cb;
	String name;

	MyThread(CyclicBarrier cb, String name) {
		this.cb = cb;
		this.name = name;
		new Thread(this).start();
	}

	public void run() {
		System.out.println(name);

		try {
			cb.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
