/**
 * 
 */
package com.fcs.database;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * @author rahul kumar
 * 
 */
public class DBConfiguration {

	private static SessionFactory sessionFactory = null;
	private static boolean init = false;

	public static boolean init() {

		if (init)
			return true;

		boolean status = false;
		try {
			if (sessionFactory == null) {

				sessionFactory = new Configuration().configure()
						.buildSessionFactory();

				status = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			status = false;
		}
		init = status;
		return status;
	}

	public <T> void save(T t) throws Exception {
		try {
			Session session = sessionFactory.openSession();

			session.beginTransaction();

			session.save(t);

			session.getTransaction().commit();

			session.close();
		} catch (Exception e) {
			throw new Exception();
		}

	}

	public static Session getSession() {
		return sessionFactory.openSession();
	}

	public void close() {
		sessionFactory.close();
	}
}
