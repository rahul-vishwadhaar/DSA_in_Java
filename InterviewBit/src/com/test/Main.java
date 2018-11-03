package com.test;

public class Main {

	public static void main(String[] args) {
		WaterTank tank = new WaterTank();

		WaterTankMonitor monitor = new WaterTankMonitor(tank);

		Producer producer = new Producer(monitor);
		Consumer consumer = new Consumer(monitor);

//		producer.start();
//		consumer.start();

	}

}
