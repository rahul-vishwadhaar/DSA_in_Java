package com.fcs.main;


public class Main {/*

	public static void main(String[] args) {

		boolean auth = false;
		int maxAttempts = 3;

		try {
			DBConfiguration.init();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Authentication authentication = new Authentication();

		authentication.init();

		while (maxAttempts-- > 0) {
			if (authentication.validate()) {
				auth = true;
				break;
			} else {
				IOUtils.println(FCSMessages.WRONG_PASSWORD);
			}
		}

		if (!auth) {
			IOUtils.println(FCSMessages.MAX_ATTEMPT_LIMIT_REACHED);
			exitThread();
		}

		Session session = new Session(authentication.getUserName());

		session.init();

		exitThread();
	}

	private static void exitThread() {
		System.exit(0);
	}

*/}
