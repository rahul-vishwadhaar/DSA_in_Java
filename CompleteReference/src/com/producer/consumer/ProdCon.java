/**
 * 
 */
package com.producer.consumer;

/**
 * @author rahul kumar
 * 
 */
public class ProdCon {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Q q = new Q();

		new Consumer(q);
		new Producer(q);

	}

}
