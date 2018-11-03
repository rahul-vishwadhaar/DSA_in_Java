/**
 * 
 */
package com.producer.consumer;

import java.util.concurrent.Semaphore;

/**
 * @author rahul kumar
 * 
 */
public class Q {

	int n;

	static Semaphore semCon = new Semaphore(0);
	static Semaphore semProd = new Semaphore(1);

	void get() {

		try {
			semCon.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();

		}

		System.out.println("got : " + n);
		semProd.release();
	}

	void put(int n) {
		try {
			semProd.acquire();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		this.n = n;

		System.out.println("Put :" + n);

		semCon.release();
	}
}
