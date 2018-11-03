/**
 * 
 */
package com.fcs.intf;

import com.fcs.authentication.Authentication;
import com.fcs.utils.IOUtils;

/**
 * @author vishwadx
 * 
 */

public class ReturningUser implements UserTypeIntf {

	/**
	 * 
	 */

	private Exception lastException = null;

	private String userId;
	private char[] password;

	public ReturningUser() {

		// printScreen();
	}

	@Override
	public void printScreen() {

		IOUtils.println("Returning User");
		IOUtils.println("Enter email Id\n");
		userId = IOUtils.getString();
		System.out.println("Enter Password\n");
		password = IOUtils.getPassword();

	}

	private boolean validateUser(String userId, char[] password) {

		Authentication auth = new Authentication();
		if (!auth.validate(userId, password)) {
			setLastException(auth.getLastException());
			return false;
		}
		return true;
	}

	@Override
	public boolean next() {
		if (!validateUser(userId, password)) {
			return false;
		}

		return true;
	}

	public Exception getLastException() {
		return lastException;
	}

	private void setLastException(Exception lastException) {
		this.lastException = lastException;
	}

	@Override
	public String getUserId() {
		// TODO Auto-generated method stub
		return userId;
	}

}
