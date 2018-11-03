package com.fcs.main;

import com.fcs.Constants.FCSMessages;
import com.fcs.database.DBConfiguration;
import com.fcs.session.Session;
import com.fcs.utils.IOUtils;

public class FCSConsoleClient {

	/**
	 * @param args
	 */

	public static void main(String[] args) {

		int maxAttempts = 3;
		boolean auth = false;

	//	init();
		MainMenu mainMenu = new MainMenu();
		while (maxAttempts-- > 0) {
			if (mainMenu.init()) {
				auth = true;
				break;
			}
		}

		if (!auth) {
			IOUtils.println(FCSMessages.MAX_ATTEMPT_LIMIT_REACHED);
			exitThread();
		}

		Session session = new Session(mainMenu.getUserId());

		session.init();

		exitThread();
	}

	private static void exitThread() {
		System.exit(0);
	}

	private static void init() {
		try {
			DBConfiguration.init();
		} catch (Exception e) {
			System.out.println("Database Iniitialization Failed");
			System.exit(1);
		}

	}

}
