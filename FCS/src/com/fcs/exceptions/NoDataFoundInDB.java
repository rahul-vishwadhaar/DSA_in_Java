/**
 * 
 */
package com.fcs.exceptions;

/**
 * @author rahul kumar
 * 
 */
public class NoDataFoundInDB extends Exception {

	public NoDataFoundInDB() {

	}

	/**
	 * @param arg0
	 */
	public NoDataFoundInDB(String arg0) {
		super(arg0);

	}

	/**
	 * @param arg0
	 */
	public NoDataFoundInDB(Throwable arg0) {
		super(arg0);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 */
	public NoDataFoundInDB(String arg0, Throwable arg1) {
		super(arg0, arg1);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public NoDataFoundInDB(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		// TODO Auto-generated constructor stub
	}

}
