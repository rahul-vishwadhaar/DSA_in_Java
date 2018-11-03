package com.mutithreading.producer_consumer;

public class Main_2 {

	public static void main(String[] args) {

		WaterTank tank = new WaterTank();

		WaterTankMonitor monitor = new WaterTankMonitor(tank);

		Producer producer = new Producer(monitor);
		Consumer consumer = new Consumer(monitor);

	}

}
