/**
 * 
 */
package com.producer.consumer;

/**
 * @author rahul
 *
 */
public class Consumer extends Thread {

	WaterTankMonitor monitor = null;

	Consumer(WaterTankMonitor monitor) {
		this.monitor = monitor;
		this.start();
	}

	public void run() {

		for (int i = 0; i < 10; i++) {
			try {
				monitor.empty();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
