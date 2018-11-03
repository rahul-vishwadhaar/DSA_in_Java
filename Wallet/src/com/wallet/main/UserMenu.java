/**
 * 
 */
package com.wallet.main;

import java.util.List;

import com.wallet.database.DBConfiguration;
import com.wallet.database.dto.Accounts;
import com.wallet.exceptions.DBException;
import com.wallet.intf.Menu;
import com.wallet.utils.IOHandler;

/**
 * @author rahul kumar
 * 
 */
public class UserMenu implements Menu {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wallet.intf.Menu#printMenu()
	 */
	private DBConfiguration bean = null;
	private String userId = null;
	private int noOfAccounts = -1;
	private List<Accounts> accountDetails = null;

	public UserMenu(DBConfiguration bean, String UserId) {
		this.bean = bean;
		this.userId = UserId;

	}

	@Override
	public void printMenu() {
		System.out.println("1. Show Accounts\n2.Create New Account\n");
		int input = IOHandler.getInputInteger();

		boolean isInputValid = false;
		while (!isInputValid) {
			switch (input) {
			case 1:
				printAccountInfo();
				isInputValid = true;
				break;
			case 2:
				isInputValid = true;
				break;
			default: {
				System.out.println("Invalid Input...try Again");
				isInputValid = false;
			}
			}
		}

	}

	private void printAccountInfo() {
		if (noOfAccounts == 0) {
			System.out.println("No accounts to display");
		} else {
			int index = 1;
			for (Accounts accnt : accountDetails) {
				System.out.println(index + " Account No : "
						+ String.valueOf(accnt.getAccountId()) + "Balance : "
						+ accnt.getBalance());
				index++;
			}
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.wallet.intf.Menu#init()
	 */
	@Override
	public void init() {
		// TODO Auto-generated method stub
		getAccountDetails();
		printMenu();

	}

	private boolean getAccountDetails() {
		try {
			accountDetails = bean.getAccountDetails(userId);

			if (accountDetails == null) {
				noOfAccounts = 0;
			} else {
				noOfAccounts = accountDetails.size();
			}
			return true;
		} catch (DBException e) {
			e.printStackTrace();
			return false;
		}

	}

	@Override
	public void close() {
		bean = null;
		accountDetails = null;
	}

}
