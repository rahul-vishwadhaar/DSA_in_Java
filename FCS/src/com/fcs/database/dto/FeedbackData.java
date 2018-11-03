/**
 * 
 */
package com.fcs.database.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author rahul kumar
 * 
 */
@Entity
public class FeedbackData {

	@Id
	@GeneratedValue
	int entryIndex; // Auto Increment
	String forUser;
	String fromUser;
	String feedbackData;

	public FeedbackData(String forUser, String fromUser, String feedbackData) {

		this.forUser = forUser;
		this.fromUser = fromUser;
		this.feedbackData = feedbackData;
	}

	public FeedbackData() {

	}

	/**
	 * @return the forUser
	 */
	public String getForUser() {
		return forUser;
	}

	/**
	 * @param forUser
	 *            the forUser to set
	 */
	public void setForUser(String forUser) {
		this.forUser = forUser;
	}

	/**
	 * @return the fromUser
	 */
	public String getFromUser() {
		return fromUser;
	}

	/**
	 * @param fromUser
	 *            the fromUser to set
	 */
	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	/**
	 * @return the feedbackfeedbackData
	 */
	public String getfeedbackData() {
		return feedbackData;
	}

	/**
	 * @param feedbackfeedbackData
	 *            the feedbackfeedbackData to set
	 */
	public void setfeedbackData(String feedbackData) {
		this.feedbackData = feedbackData;
	}

	public String toString() {

		return "For User :" + forUser + " From : " + fromUser + " Data : "
				+ feedbackData;
	}

	public int getentryIndex() {
		return entryIndex;
	}

	public void setentryIndex(int entryIndex) {
		this.entryIndex = entryIndex;
	}

}
