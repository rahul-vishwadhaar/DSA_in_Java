package com.producer.consumer;

public class Consumer implements Runnable {

	Q q;

	Consumer(Q q) {
		this.q = q;
		new Thread(this).start();
	}

	public void run() {

		for (int i = 0; i < 20; i++) {
			q.get();
		}

	}

}
