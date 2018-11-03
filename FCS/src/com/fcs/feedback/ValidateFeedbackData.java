package com.fcs.feedback;

import com.fcs.database.dto.FeedbackData;

public class ValidateFeedbackData {

	private String forUser;
	private String fromUser;
	private int[] feedback;

	public FeedbackData build() {

		FeedbackData feed = null;

		String feedBackData = convertIntArrToString(feedback);

		if (validate(forUser, fromUser, feedBackData))
			feed = new FeedbackData(forUser, fromUser, feedBackData);

		return feed;
	}

	public void setFeedbackData(int[] feedback) {
		this.feedback = feedback;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public void setForUser(String forUser) {
		this.forUser = forUser;
	}

	public boolean validate(String forUser, String fromUser, String feedbackData) {
		if ((forUser == null) || (fromUser == null) || (feedbackData == null))
			return false;

		if (forUser.isEmpty() || fromUser.isEmpty() || feedbackData.isEmpty())
			return false;

		return true;

	}

	private String convertIntArrToString(int[] feedback) {

		StringBuilder sb = new StringBuilder();
		for (int index = 0; index < feedback.length; index++) {
			sb.append(feedback[index]);
		}
		return sb.toString();
	}
}
