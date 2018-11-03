package com.test;

public class Consumer extends Thread {

	private WaterTankMonitor monitor = null;

	public Consumer(WaterTankMonitor monitor) {

		this.monitor = monitor;
		this.start();
	}

	public void run() {

		for (int i = 0; i < 5; i++) {
			monitor.empty();
		}
	}
}
