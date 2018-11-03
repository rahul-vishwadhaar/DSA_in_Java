package com.concurrency.callable;

import java.util.concurrent.Callable;

public class Hypot implements Callable<Double> {

	private double side1;
	private double side2;

	public Hypot(double side1, double side2) {

		this.side1 = side1;
		this.side2 = side2;
		// TODO Auto-generated constructor stub
	}

	public Double call() throws Exception {

		return Math.sqrt((side1 * side1) + (side2 * side2));
	}

}
