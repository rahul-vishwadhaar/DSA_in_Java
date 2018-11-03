/**
 * 
 */
package com.fcs.sampledata;

import com.fcs.database.UserDataDB;
import com.fcs.database.dto.UserInfo;
import com.fcs.modal.Summary;

/**
 * @author rahul kumar
 * 
 */
public class SampleUserDataFromDB extends UserDataDB {

	private int sessionId = -1;
	private UserInfo userInfo = null;
	private Summary summary = null;

	public SampleUserDataFromDB(int sessionId, String userId) throws Exception {
		super(sessionId, userId);

		this.setSessionId(sessionId);
		init();
	}

	private void init() {

		userInfo = new UserInfo();
		summary = new Summary();
	}

	/**
	 * @return the userInfo
	 */
	public UserInfo getPersonalInfo() {
		return userInfo;
	}

	/**
	 * @return the summary
	 */
	@Override
	public Summary getSummary() {
		return summary;
	}

	public int getSessionId() {
		return sessionId;
	}

	private void setSessionId(int sessionId) {
		this.sessionId = sessionId;
	}

}
