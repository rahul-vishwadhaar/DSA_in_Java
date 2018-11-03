package com.fcs.feedback;

public class DisplayFeedBackData {
	private String userId;
	private Exception lastException = null;
	private FeedBackDataContainer feedback = null;

	public DisplayFeedBackData(String userId) {
		this.userId = userId;
	}

	public boolean init() {

		if (feedback == null) {
			return populateFeedBackData();
		}

		return true;
	}

	private boolean populateFeedBackData() {

		feedback = new FeedBackDataContainer(userId);

		if (!feedback.initDataFromDB()) {
			setLastException(feedback.getLastException());
			return false;
		}

		return true;
	}

	public void printData() {
		// TODO Auto-generated method stub

	}

	public String getUserId() {
		return userId;
	}

	public Exception getLastException() {
		return lastException;
	}

	public void setLastException(Exception lastException) {
		this.lastException = lastException;
	}

}
