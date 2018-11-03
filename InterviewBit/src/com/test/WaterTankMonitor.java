package com.test;

public class WaterTankMonitor {

	private WaterTank tank;

	public WaterTankMonitor(WaterTank tank) {
		this.tank = tank;
	}

	public void empty() {

		while (tank.isEmpty()) {

			synchronized (this) {

				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		tank.setEmpty(true);
		System.out.println("Empty");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		synchronized (this) {
			notifyAll();
		}

	}

	public void fill() {

		while (!tank.isEmpty()) {

			synchronized (this) {

				try {
					wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		tank.setEmpty(false);
		System.out.println("fill");

	/*	try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
*/
		synchronized (this) {
			notifyAll();
		}
	}

}
