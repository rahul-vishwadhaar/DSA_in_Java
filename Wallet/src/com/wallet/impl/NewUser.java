package com.wallet.impl;

import com.wallet.database.DBConfiguration;
import com.wallet.database.dto.Users;
import com.wallet.exceptions.DBException;
import com.wallet.intf.UserType;
import com.wallet.main.MainMenu;
import com.wallet.utils.IOHandler;

public class NewUser implements UserType {

	Users user = null;
	DBConfiguration bean = null;
	IOHandler input = null;

	public NewUser(DBConfiguration bean) {
		this.bean = bean;
		user = new Users();
		input = new IOHandler();
	}

	@Override
	public void printScreen() {
		System.out.println("New User Registration");
		System.out.println("Enter your First Name\n");
		user.setFirstName(IOHandler.getString());
		System.out.println("Enter your Last Name\n");
		user.setLastName(IOHandler.getString());
		System.out.println("Enter your Contact Number\n");
		user.setContactNumber(IOHandler.getLong());
		System.out.println("Enter your Email Id\n");
		user.setEmailId(IOHandler.getString());
		System.out.println("Enter new password\n");
		user.setPassword(IOHandler.getString());

	}

	public boolean registerUser() {
		boolean status = false;
		try {
			bean.save(user);
			status = true;
		} catch (DBException e) {
			e.printStackTrace();
			System.out.println("New User Registration Failed");
			status = false;
		}
		user = null;
		return status;

	}

	@Override
	public void finalise() {
		user = null;

	}

	@Override
	public void next() {
		registerUser();
		MainMenu main = new MainMenu(bean);
		main.init();
	}

}
