/**
 * 
 */
package com.wallet.main;

import com.wallet.database.DBConfiguration;
import com.wallet.impl.NewUser;
import com.wallet.impl.ReturningUser;
import com.wallet.intf.Menu;
import com.wallet.intf.UserType;
import com.wallet.utils.IOHandler;

/**
 * @author vishwadx
 * 
 */
public class MainMenu implements Menu {

	private UserType usrType = null;
	private DBConfiguration bean = null;

	public MainMenu(DBConfiguration bean) {
		this.bean = bean;

	}

	@Override
	public void printMenu() {

		while (true) {
			boolean validInput = false;
			System.out.println("1. New User\n2. Returning User");
			int result = IOHandler.getInputInteger();
			switch (result) {
			case 1:
				usrType = new NewUser(bean);
				validInput = true;
				break;
			case 2:
				usrType = new ReturningUser(bean);
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

	public UserType getUserType() {
		return usrType;
	}

	@Override
	public void close() {
		usrType = null;
	}

	@Override
	public void init() {
		printMenu();
		UserType user ;//= getUserType();
		user = usrType;
		close();
		user.printScreen();
		user.next();
	}

}
