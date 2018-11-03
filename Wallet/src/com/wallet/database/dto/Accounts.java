/**
 * 
 */
package com.wallet.database.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author rahul kumar
 * 
 */
@Entity
public class Accounts {

	@Id
	private int AccountId;
	private double Balance;
	private int UserId;
	private int balance;

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(int balance) {
		this.balance = balance;
	}

	/**
	 * @return the accountId
	 */
	public int getAccountId() {
		return AccountId;
	}

	/**
	 * @param accountId
	 *            the accountId to set
	 */
	public void setAccountId(int accountId) {
		AccountId = accountId;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return Balance;
	}

	/**
	 * @param balance
	 *            the balance to set
	 */
	public void setBalance(double balance) {
		Balance = balance;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return UserId;
	}

	/**
	 * @param userId
	 *            the userId to set
	 */
	public void setUserId(int userId) {
		UserId = userId;
	}
}
