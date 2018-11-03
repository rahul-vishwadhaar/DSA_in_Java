/**
 * 
 */
package com.concurrency.utilities.cyclicBarrier;

import java.util.concurrent.CyclicBarrier;

/**
 * @author rahul kumar
 * 
 */
public class CyclicBarrierDemo {

	public static void main(String[] args) {
		
		CyclicBarrier cb = new CyclicBarrier(3, new BarAction());
		
		System.out.println("Starting");
		
		new MyThread(cb ,"A");
		new MyThread(cb ,"B");
		new MyThread(cb ,"C");
		
		
		new MyThread(cb ,"A");
		new MyThread(cb ,"B");
		new MyThread(cb ,"C");
	}
}
