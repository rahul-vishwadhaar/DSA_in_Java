package com.producer.consumer;

public class WaterTankMonitor {

	private Watertank tank = null;

	public WaterTankMonitor(Watertank tank) {

		this.tank = tank;
	}

	public void empty() throws InterruptedException {

		while (tank.isEmpty()) {
			synchronized (this) {
				wait();
			}
		}

		tank.setEmpty(true);
		System.out.println("Empty");
		
		Thread.sleep(100);

		try {
			notifyAll();
		} catch (Exception e) {

		}

	}

	public void fill() throws InterruptedException {

		while (!tank.isEmpty()) {
			synchronized (this) {
				wait();
			}

		}

		tank.setEmpty(false);
		System.out.println("fill");
		
		Thread.sleep(10);

		try {
			notifyAll();
		} catch (Exception e) {
		}
	}

}
