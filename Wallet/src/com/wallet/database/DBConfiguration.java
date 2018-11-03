/**
 * 
 */
package com.wallet.database;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.wallet.database.dto.Accounts;
import com.wallet.exceptions.DBException;

/**
 * @author rahul kumar
 * 
 */
public class DBConfiguration {

	private static SessionFactory sessionFactory = null;

	public boolean init() {
		boolean status = false;
		try {
			if (sessionFactory == null) {
				sessionFactory = new Configuration().configure()
						.buildSessionFactory();
				status = true;
			}
		} catch (Exception e) {
			status = false;
		}
		return status;
	}

	public <T> void save(T t) throws DBException {
		try {
			Session session = sessionFactory.openSession();

			session.beginTransaction();

			session.save(t);

			session.getTransaction().commit();

			session.close();
		} catch (Exception e) {
			throw new DBException();
		}

	}

	public List<Accounts> getAccountDetails(String userId) throws DBException {
		try {
			Session session = sessionFactory.openSession();

			session.beginTransaction();

			session.getTransaction().commit();

			session.close();
		} catch (Exception e) {
			throw new DBException();
		}
		return null;

	}

	public String getPassword(String userId) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * public static void main(String args[]) { Accounts account = new
	 * Accounts();
	 * 
	 * account.setAccountId(1); account.setBalance(100); account.setUserId(1);
	 * 
	 * Transactions transaction = new Transactions();
	 * 
	 * transaction.setAccountId(1); transaction.setAmount(10.00);
	 * transaction.setType("Debit");
	 * 
	 * DBConfiguration db = new DBConfiguration(); db.init();
	 * 
	 * db.save(account); db.save(transaction);
	 * 
	 * }
	 */

	private void executeQuery() {

	}

	public void close() {
		sessionFactory.close();
	}
}
