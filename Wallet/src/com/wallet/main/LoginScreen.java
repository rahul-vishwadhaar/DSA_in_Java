/**
 * 
 */
package com.wallet.main;

import com.wallet.utils.IOHandler;

/**
 * @author rahul kumar
 * 
 */
public class LoginScreen {

	IOHandler input = null;
	String userName = null;
	String password = null;

	public void init() {
		if (input == null) {
			input = new IOHandler();
		}
	}

	public boolean validateUser(String userName, String password) {

		String pass = null;

		String result = ValidatePassword(pass);

		switch (result) {
		case Constants.INVALID_USER: {
			System.out.println("Invalid User");
			return false;

		}
		case Constants.VALID_USER: {
			System.out.println("Valid User");
			return true;

		}

		default: {

		}

		}
		return false;

	}

	private String ValidatePassword(String pass) {
		// TODO Auto-generated method stub
		return null;
	}

	public void display() {

		System.out.println("Enter User Name :");
		userName = input.getString();
		System.out.println("Enter Password :");
		password = input.getPassword();

	}

	public boolean validate() {

		boolean isUserValid = validateUser(userName, password);
		return isUserValid;
	}

	public boolean checkIfNewUser() {

		System.out.println("1. New User\n2. Returning User");

		int result = input.getInputInteger();

		if (result == 1)
			return true;
		else
			return false;
	}

	public void registerUser() {
		// TODO Auto-generated method stub
		
	}

}
