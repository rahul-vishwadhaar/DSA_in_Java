/**
 * 
 */
package com.fcs.database;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.fcs.database.dto.UserInfo;
import com.fcs.modal.Summary;

/**
 * @author rahul
 * 
 */
public class UserDataDB {

	private int sessionId = -1;
	private String userId = null;
	private UserInfo userInfo = null;
	private Summary summary = null;
	private Session bean = null;

	private Exception lastException;

	public UserDataDB(int sessionId, String userId) throws Exception {
		this.sessionId = sessionId;
		this.userId = userId;
		init();
	}

	private boolean init() throws Exception {
		if (!DBConfiguration.init()) {
			setLastException(new Exception("DB Error"));
			return false;
		}

		refresh();
		// saveSampleData();
		return true;
	}

	private boolean saveSampleData() {

		UserInfo userInfo = new UserInfo();
		userInfo.setUserId("1234");
		userInfo.setFirstName("ABC");
		userInfo.setMiddleName("MNO");
		userInfo.setFirstName("XYZ");
		userInfo.setOrganization("ABC@123");
		userInfo.setContactNumber("1234567899");

		try {
			Session session = DBConfiguration.getSession();

			session.beginTransaction();

			session.save(userInfo);

			session.getTransaction().commit();

			session.close();
		} catch (Exception e) {
			setLastException(e);
			return false;
		}

		return true;
	}

	private boolean refresh() throws Exception {

		bean = DBConfiguration.getSession();
		bean.beginTransaction();
		try {
			String queryStr = "select * from userinfo where userId=\"1234\"";
			SQLQuery query = bean.createSQLQuery(queryStr).addEntity(
					UserInfo.class);
			List<UserInfo> info1 = (List<UserInfo>) query.list();
			userInfo = info1.get(0);

		} catch (Exception e) {
			setLastException(e);
			bean.close();
			return false;
		}
		bean.close();
		return true;
	}

	/**
	 * @return the userInfo
	 * @throws Exception
	 */
	public UserInfo getPersonalInfo() throws Exception {

		if (userInfo == null)
			setLastException(new Exception("Database error"));

		return userInfo;
	}

	/**
	 * @return the summary
	 * @throws Exception
	 */

	public Summary getSummary() throws Exception {
		if (summary == null)
			setLastException(new Exception("Database error"));

		return summary;
	}

	public Exception getLastException() {
		return lastException;
	}

	private void setLastException(Exception lastException) {
		this.lastException = lastException;
	}
}