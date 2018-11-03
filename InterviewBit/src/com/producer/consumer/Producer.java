package com.producer.consumer;

public class Producer extends Thread {

	WaterTankMonitor monitor = null;

	public Producer(WaterTankMonitor monitor) {

		this.monitor = monitor;

		this.start();

	}

	public void run() {

		for (int i = 0; i < 5; i++) {
			try {
				monitor.fill();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
