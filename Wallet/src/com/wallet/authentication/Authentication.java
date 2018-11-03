/**
 * 
 */
package com.wallet.authentication;

import com.wallet.database.DBConfiguration;

/**
 * @author rahul kumar
 * 
 */
public class Authentication {

	private DBConfiguration bean = null;

	public void validateUser() {

	}

	public void init() {
		try {
			bean = new DBConfiguration();
			bean.init();
		} catch (Exception e) {
			System.out.println("Error connecting DB");
			e.printStackTrace();
		}
	}

	public void close() {
		bean.close();
	}

}
