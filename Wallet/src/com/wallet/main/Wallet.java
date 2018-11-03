/**
 * 
 */
package com.wallet.main;

import com.wallet.database.DBConfiguration;
import com.wallet.utils.IOHandler;

/**
 * @author vishwadx
 * 
 */
public class Wallet {

	/**
	 * @param args
	 */
	private static DBConfiguration bean = null;

	public static void main(String[] args) {

//		init();
		MainMenu mainMenu = new MainMenu(bean);
		mainMenu.init();

	}

	private static void init() {
		boolean result = false;
		bean = new DBConfiguration();
		result = bean.init();

		if (!result) {
			System.out.println("Database Iniitialization Failed");
			System.exit(1);
		}
		IOHandler.init();

	}

}
