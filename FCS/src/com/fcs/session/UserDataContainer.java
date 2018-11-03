/**
 * 
 */
package com.fcs.session;

import com.fcs.database.UserDataDB;
import com.fcs.database.dto.UserInfo;
import com.fcs.feedback.DisplayFeedBackData;
import com.fcs.feedback.FeedBackMenu;
import com.fcs.modal.Summary;
import com.fcs.utils.IOUtils;
import com.fcs.utils.Logger;

/**
 * @author rahul
 * 
 */
public class UserDataContainer {

	private int sessionId = 0;
	private String userId;
	private UserDataDB userDataBean = null;
	private DisplayFeedBackData display = null;

	public UserDataContainer(int sessionId, String userId) {
		this.sessionId = sessionId;
		this.userId = userId;
	}

	public void init() {

		try {
			userDataBean = new UserDataDB(sessionId, "1234");
			display = new DisplayFeedBackData(userId);
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	public void printSummary() {
		Logger.debug("UserDataContainer : printStatus");

		String userId = null;
		Summary summary = null;
		try {
			userId = userDataBean.getPersonalInfo().getUserId();
			summary = userDataBean.getSummary();
		} catch (Exception e) {
			Logger.error(e);
		}

		IOUtils.println("**********************************************");
		IOUtils.println("                 SUMMARY");
		IOUtils.println("**********************************************");

		if (summary != null) {
			IOUtils.println("Total Number of Reviews    : "
					+ summary.getNumberOfReview());
			IOUtils.println("Last Review updated on     : "
					+ summary.getLastReviewUpdate());
			IOUtils.println("Total No. of Reviews Shared: "
					+ summary.getNoOfReviewsShared());
			IOUtils.println("Last Review Shared         : "
					+ summary.getLastReviewShared());
			IOUtils.println("Favourable Reviews         : "
					+ summary.getFavorableReview());
		} else {
			IOUtils.println("No data for user " + userId);
		}
	}

	public void printDetailedData() {
		Logger.debug("UserDataContainer : displayData");
		if (!display.init()) {
			display.getLastException().printStackTrace();
			return;
		}

		display.printData();

		return;

	}

	public void enterData() {
		FeedBackMenu newFeed = new FeedBackMenu(this.userId);
		newFeed.init();
	}

	public void printPersonalInfo() {

		UserInfo userInfo = null;
		try {
			userInfo = userDataBean.getPersonalInfo();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		IOUtils.println("**********************************************");
		IOUtils.println("           " + "Personal Information");
		IOUtils.println("**********************************************");

		IOUtils.println("First Name     : " + userInfo.getFirstName());
		IOUtils.println("Middle Name    : " + userInfo.getMiddleName());
		IOUtils.println("Last Name      : " + userInfo.getLastName());
		IOUtils.println("Contact Number : " + userInfo.getContactNumber());
		IOUtils.println("Organisation   : " + userInfo.getOrganization());
	}
}
