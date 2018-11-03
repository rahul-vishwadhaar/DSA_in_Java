package com.test;

public class Producer extends Thread {

	WaterTankMonitor monitor = null;

	public Producer(WaterTankMonitor monitor) {
		this.monitor = monitor;
		this.start();
	}

	public void run() {

		for (int i = 0; i < 5; i++) {

			monitor.fill();
		}
	}
}
