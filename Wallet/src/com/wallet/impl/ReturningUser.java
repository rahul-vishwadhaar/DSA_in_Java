/**
 * 
 */
package com.wallet.impl;

import com.wallet.database.DBConfiguration;
import com.wallet.intf.UserType;
import com.wallet.main.UserMenu;
import com.wallet.utils.ErrorUser;
import com.wallet.utils.IOHandler;

/**
 * @author vishwadx
 * 
 */

public class ReturningUser implements UserType {

	/**
	 * 
	 */
	DBConfiguration bean = null;
	ErrorUser errorCode = null;

	public ReturningUser(DBConfiguration bean) {
		this.bean = bean;
	}

	@Override
	public void printScreen() {
		String userId = null;
		String password = null;
		System.out.println("Returning User");
		System.out.println("Enter email Id\n");
		userId = IOHandler.getString();
		System.out.println("Enter Password\n");
		password = IOHandler.getPassword();

		if (validateUser(userId, password)) {

			UserMenu userMenu = new UserMenu(bean, userId);
			userMenu.init();
			userMenu.printMenu();
		} else {
			System.out.println(this.getErrorCode().toString());
			this.next();
		}

	}

	private boolean validateUser(String userId, String password) {

		String passwordDB = null;
		passwordDB = bean.getPassword(userId);

		if (passwordDB == null) {
			errorCode = ErrorUser.ERROR_INVALID_USER;
			return false;
		} else if (!passwordDB.equals(password)) {
			errorCode = ErrorUser.ERROR_INVALID_PASSWORD;
			return false;
		} else {
			return true;
		}
	}

	@Override
	public void finalise() {
		bean = null;

	}

	@Override
	public void next() {
		printScreen();

	}

	/**
	 * @return the errorCode
	 */
	public ErrorUser getErrorCode() {
		return errorCode;
	}

}
