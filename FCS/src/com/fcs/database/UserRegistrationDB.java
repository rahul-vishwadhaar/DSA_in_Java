/**
 * 
 */
package com.fcs.database;

import com.fcs.database.dto.UserInfo;

/**
 * @author rahul kumar
 * 
 */
public class UserRegistrationDB {

	private Exception lastException = null;

	public boolean init() {
		if (!DBConfiguration.init()) {
			setLastException(new Exception("DB Error"));
			return false;
		}

		return true;
	}

	public boolean registerNewUser(UserInfo user) {
		return true;

	}

	public Exception getLastException() {
		return lastException;
	}

	private void setLastException(Exception lastException) {
		this.lastException = lastException;
	}

}
