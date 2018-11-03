/**
 * 
 */
package com.fcs.sampledata;

import com.fcs.database.dto.UserInfo;

/**
 * @author rahul kumar
 * 
 */
public class SampleUserPersonalInfo extends UserInfo {

	private String firstName = "ABC";
	private String middleName = "MNO";
	private String lastName = "XYZ";
	private String organization = "ABC@123";
	private String contactNumber = "1234567899";

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @return the organization
	 */
	public String getOrganization() {
		return organization;
	}

	/**
	 * @return the contactNumber
	 */
	public String getContactNumber() {
		return contactNumber;
	}
}
