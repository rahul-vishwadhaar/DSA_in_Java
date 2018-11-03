/**
 * 
 */
package com.fcs.sampledata;

import java.util.Date;

import com.fcs.modal.Summary;

/**
 * @author rahul kumar
 * 
 */
public class SampleSummary extends Summary{

	private int totalNoOfReviews = 140;
	private Date lastReviewUpdate = new Date(System.currentTimeMillis());
	private int noOfReviewsShared = 64;
	private Date lastReviewShared = new Date(System.currentTimeMillis());
	private int favorableReview = 45;

	/**
	 * @return the totalNoOfReviews
	 */
	public int getNumberOfReview() {
		return totalNoOfReviews;
	}

	/**
	 * @return the lastReviewUpdate
	 */
	public Date getLastReviewUpdate() {
		return lastReviewUpdate;
	}

	/**
	 * @return the noOfReviewsShared
	 */
	public int getNoOfReviewsShared() {
		return noOfReviewsShared;
	}

	/**
	 * @return the lastReviewShared
	 */
	public Date getLastReviewShared() {
		return lastReviewShared;
	}

	/**
	 * @return the favorableReview
	 */
	public int getFavorableReview() {
		return favorableReview;
	}

}
