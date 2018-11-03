/**
 * 
 */
package com.producer.consumer;

/**
 * @author rahul kumar
 * 
 */
public class Producer implements Runnable {
	Q q;

	Producer(Q q) {
		this.q = q;
		new Thread(this).start();
	}

	public void run() {
		for (int i = 0; i < 20; i++) {

			q.put(i);

		}

	}

}
