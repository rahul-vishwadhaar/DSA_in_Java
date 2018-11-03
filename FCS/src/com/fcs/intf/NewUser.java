package com.fcs.intf;

import com.fcs.database.UserRegistrationDB;
import com.fcs.database.dto.UserInfo;
import com.fcs.utils.IOUtils;

public class NewUser implements UserTypeIntf {

	private UserInfo user = null;
	private UserRegistrationDB bean = null;
	private String userId;

	private Exception lastException = null;

	@Override
	public void printScreen() {
		user = new UserInfo();
		System.out.println("New User Registration");
		System.out.println("Enter your First Name\n");
		user.setFirstName(IOUtils.getString());
		System.out.println("Enter your Last Name\n");
		user.setLastName(IOUtils.getString());
		System.out.println("Enter your Contact Number\n");
		user.setContactNumber(IOUtils.getString());
		System.out.println("Enter your Email Id\n");
		user.setEmailId(IOUtils.getString());

		setUserId(user.getEmailId());
	}

	private boolean registerUser() {

		try {
			bean.registerNewUser(user);
			return true;
		} catch (Exception e) {
			setLastException(e);
			System.out.println("New User Registration Failed");
			return false;
		}

	}

	public void finalise() {
		user = null;

	}
	
	@Override
	public boolean next() {
		return registerUser();

	}

	public Exception getLastException() {
		return lastException;
	}

	public void setLastException(Exception lastException) {
		this.lastException = lastException;
	}

	@Override
	public String getUserId() {
		return userId;
	}

	private void setUserId(String userId) {
		this.userId = userId;
	}

}
