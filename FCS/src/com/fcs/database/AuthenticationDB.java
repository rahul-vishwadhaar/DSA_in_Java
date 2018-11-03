package com.fcs.database;

import java.util.List;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.fcs.database.dto.UserAuthentication;
import com.fcs.exceptions.IncorrectPasswordException;
import com.fcs.exceptions.NoUserException;

public class AuthenticationDB {

	private Exception lastException = null;

	public boolean init() {
		if (!DBConfiguration.init()) {
			setLastException(new Exception("DB Error"));
			return false;
		}

		return true;
	}

	public Exception getLastException() {
		return lastException;
	}

	private void setLastException(Exception lastException) {
		this.lastException = lastException;
	}

	public boolean validate(String userId, long passLong) {

		List<UserAuthentication> authList = null;
		boolean result = false;

		if (!init())
			return false;

		try {
			Session session = DBConfiguration.getSession();

			session.beginTransaction();

			SQLQuery query = session.createSQLQuery(
					"select password from auth where userid=:n").addEntity(
					UserAuthentication.class);

			query.setParameter("n", userId);
			authList = (List<UserAuthentication>) query.list();

			if ((authList == null) || (authList.isEmpty())) {
				lastException = new NoUserException();
				result = false;
			} else if (authList.get(0).getPassword() != passLong) {

				lastException = new IncorrectPasswordException();
				result = false;
			} else {
				result = true;
			}
			session.close();
		} catch (Exception e) {
			setLastException(e);
		}

		return result;

	}
}
