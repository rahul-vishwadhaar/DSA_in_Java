package com.mutithreading.producer_consumer;

public class Consumer extends Thread {

	WaterTankMonitor monitor = null;

	public Consumer(WaterTankMonitor monitor) {

		this.monitor = monitor;
		this.start();
	}

	public void run() {

		for (int i = 0; i < 5; i++) {
			try {
				monitor.empty();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
