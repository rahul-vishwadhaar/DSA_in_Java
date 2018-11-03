package com.fcs.database;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.fcs.database.dto.FeedbackData;

public class FeedBackDataDB {

	private Exception lastException = null;

	public boolean init() {
		if (!DBConfiguration.init()) {
			setLastException(new Exception("DB Error"));
			return false;
		}
		return true;
	}

	public boolean saveFeedBackDatainDB(FeedbackData feedBack) {

		try {
			Session session = DBConfiguration.getSession();

			session.beginTransaction();

			session.save(feedBack);

			session.getTransaction().commit();

			session.close();
		} catch (Exception e) {
			setLastException(e);
			return false;
		}

		return true;
	}

	public List<FeedbackData> getFeedBackDatainDB(String userId) {

		List<FeedbackData> feedbackDataList = null;
		try {
			Session session = DBConfiguration.getSession();

			session.beginTransaction();

			SQLQuery query = session.createSQLQuery(
					"select * from feedbackdata where forUser=:n").addEntity(
					FeedbackData.class);

			query.setParameter("n", userId);
			feedbackDataList = (List<FeedbackData>) query.list();

			session.close();
		} catch (Exception e) {
			setLastException(e);
		}

		return feedbackDataList;
	}

	public Exception getLastException() {
		return lastException;
	}

	private void setLastException(Exception lastException) {
		this.lastException = lastException;
	}
}
