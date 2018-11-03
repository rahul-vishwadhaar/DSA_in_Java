/**
 * 
 */
package com.fcs.feedback;

import com.fcs.utils.IOUtils;

/**
 * @author rahul kumar
 * 
 */
public class FeedBackMenu {

	/**
	 * 
	 */

	private String userID;

	public FeedBackMenu(String userId) {
		this.userID = userId;

	}

	public void init() {

		int input = 0;
		boolean inputFlag = false;
		FeedBackDataContainer feed = null;

		while (true) {

			IOUtils.println("1. New Feedback");
			IOUtils.println("2. Edit Feedback");

			try {
				input = IOUtils.getInt();
			} catch (Exception e) {
				input = -1;
			}

			if (input == 1) {
				inputFlag = true;
				feed = new FeedBackDataContainer(userID);
				feed.init();
			} else if (input == 2) {
				IOUtils.println("Enter  Id");
				feed = new FeedBackDataContainer(userID, IOUtils.getString());
				inputFlag = true;
			}

			if (inputFlag)
				break;
		}
	}
}
