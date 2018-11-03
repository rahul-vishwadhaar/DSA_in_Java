/**
 * 
 */
package com.wallet.intf;

/**
 * @author rahul kumar
 * 
 */
public interface Menu {

	/*
	 * Prints the menu on screen
	 */
	void printMenu();

	/*
	 * Prequesite initialisations
	 */
	void init();

	/*
	 * Free resources
	 */
	void close();

}
