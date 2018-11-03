/**
 * 
 */
package com.fcs.database.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author rahul kumar
 * 
 */
@Entity
public class UserAuthentication {

	@Id
	String userId;// Varchar Not null, Primary Key Java Hash Code
	long password;// Varchar, CRC32

	/**
	 * @return the userId
	 */
	public String getUserId() {
		return userId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(String userId) {
		this.userId = userId;
	}

	/**
	 * @return the password
	 */
	public long getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(long password) {
		this.password = password;
	}
}
