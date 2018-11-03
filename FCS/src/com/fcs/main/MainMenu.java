package com.fcs.main;

import com.fcs.intf.NewUser;
import com.fcs.intf.ReturningUser;
import com.fcs.intf.UserTypeIntf;
import com.fcs.utils.IOUtils;

public class MainMenu {

	private UserTypeIntf userType = null;

	public void printMenu() {

		while (true) {
			boolean validInput = false;
			System.out.println("1. New User\n2. Returning User");
			int result = IOUtils.getInt();
			switch (result) {
			case 1:
				userType = new NewUser();
				validInput = true;
				break;
			case 2:
				userType = new ReturningUser();
				validInput = true;
				break;
			case 3:
				System.exit(1);
				break;
			default:
				validInput = false;

			}

			if (validInput)
				break;
		}

	}

	public UserTypeIntf getUser() {
		return userType;
	}

	public void close() {
		userType = null;
	}

	public boolean init() {
		printMenu();
		userType.printScreen();
		return userType.next();
	}

	public String getUserId() {
		return userType.getUserId();
	}
}
