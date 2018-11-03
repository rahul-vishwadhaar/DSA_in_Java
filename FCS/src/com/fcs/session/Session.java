/**
 * 
 */
package com.fcs.session;

import java.util.Date;

import com.fcs.utils.IOUtils;
import com.fcs.utils.Logger;

/**
 * @author rahul
 * 
 */
public class Session {

	private int sessionId = 0;
	private String userId = null;

	private UserDataContainer userData = null;
	private Date activeSince = null;

	public Session(String userId) {
		this.userId = userId;
		this.activeSince = new Date(System.currentTimeMillis());
	}

	public void init() {

		Logger.info("Session : init()");

		this.sessionId = userId.hashCode();

		userData = new UserDataContainer(sessionId, userId);

		userData.init();

		while (true) {
			if (!printMenu()) {
				break;
			}

			IOUtils.println("Press any key to continue");
			IOUtils.getString();
		}
	}

	private boolean printMenu() {
		int len = 10;
		int input = -1;

		Logger.info("Session : printMenu()");
		printSessionDetails();

		while (len-- > 10) {
			IOUtils.print("-");
		}

		IOUtils.println("  ");
		IOUtils.println("  ");
		IOUtils.println("-----------------------------------------------");
		IOUtils.println("               Main Menu");
		IOUtils.println("-----------------------------------------------");
		IOUtils.println("  ");

		len = 10;

		while (len-- > 10) {
			IOUtils.print("-");
		}

		IOUtils.println("1.....................Print Summary");
		IOUtils.println("2.....................Display Data");
		IOUtils.println("3.....................Enter Feedback");
		IOUtils.println("4.....................Personal Info");

		IOUtils.println("9.....................Exit");

		try {
			input = IOUtils.getInt();
		} catch (Exception e) {
			input = -1;
		}

		IOUtils.println("  ");

		if (input == 1) {
			userData.printSummary();
		} else if (input == 2) {
			userData.printDetailedData();
		} else if (input == 3) {
			userData.enterData();
		} else if (input == 4) {
			userData.printPersonalInfo();
		} else if (input == 9) {
			return false;
		} else {
			IOUtils.println("Invalid Entry");
		}

		IOUtils.println("  ");
		IOUtils.println("**********************************************");
		IOUtils.println("  ");

		return true;

	}

	public void printSessionDetails() {

		System.out.println("Session Id    :" + sessionId);
		System.out.println("Active Since  :" + activeSince.toString());
	}
}
