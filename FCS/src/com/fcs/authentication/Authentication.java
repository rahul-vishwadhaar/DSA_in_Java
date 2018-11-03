/**
 * 
 */
package com.fcs.authentication;

import com.fcs.database.AuthenticationDB;
import com.fcs.utils.Logger;

/**
 * @author rahul
 * 
 */
public class Authentication {

	private Exception lastException = null;

	public boolean validate(String userName, char[] password) {
		Logger.info("Authentication : validate()");

		CRC32Helper crcHelper = new CRC32Helper();

		if ((userName == null) || (password == null))
			return false;

		long passLong = crcHelper.crc32FromString(password.toString());

		Logger.debug("UserName : " + userName);
		Logger.debug("Password :" + password.toString());

		// return validateFromDB(userName, passLong);
		return true;

	}

	private boolean validateFromDB(String userName, long passLong) {
		AuthenticationDB bean = new AuthenticationDB();

		if ((userName == null) || (passLong == -1))
			return false;

		if (!bean.init()) {
			setLastException(bean.getLastException());
			return false;
		}

		if (!bean.validate(userName, passLong)) {
			setLastException(bean.getLastException());
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

}
