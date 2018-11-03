/**
 * 
 */
package com.producer.consumer;

/**
 * @author rahul
 *
 */
public class Main_1 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Watertank tank = new Watertank();

		WaterTankMonitor monitor = new WaterTankMonitor(tank);

		Producer producer = new Producer(monitor);
		Consumer consumer = new Consumer(monitor);

	}

}
