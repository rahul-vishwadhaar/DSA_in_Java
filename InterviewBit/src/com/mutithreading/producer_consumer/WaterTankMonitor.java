/**
 * 
 */
package com.mutithreading.producer_consumer;

/**
 * @author rahul
 *
 */
public class WaterTankMonitor {

	private WaterTank tank = null;

	public WaterTankMonitor(WaterTank tank) {

		this.tank = tank;
	}

	public void empty() throws InterruptedException {

		while (tank.isEmpty()) {

			synchronized (this) {

//				System.out.println("Waiting for filled tank");
				wait();

			}
		}

		tank.setEmpty(true);
		System.out.println("empty");

		synchronized (this) {
			notifyAll();
		}
	}

	public void fill() throws InterruptedException {

		while (!tank.isEmpty()) {

			synchronized (this) {
//				System.out.println("Waiting for empty tank");
				wait();
			}
		}

		tank.setEmpty(false);
		System.out.println("Tank Filled");

		synchronized (this) {
			notifyAll();

		}

	}
}
