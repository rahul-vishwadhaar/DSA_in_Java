/**
 * 
 */
package com.fcs.utils;

/**
 * @author rahul kumar
 * 
 */
public class Logger {

	private static int logLevel = 0;

	public static void setLogLevel(int level) {

		logLevel = level;
	}

	public static void info(String input) {
		if (logLevel > 0) {
			System.out.println("INFO : " + input);
		}
	}

	public static void debug(String input) {
		if (logLevel > 1) {
			System.out.println("DEBUG : " + input);
		}
	}

	public static void error(String input) {
		System.out.println("ERROR : " + input);
	}

	public static void error(Exception e) {
		System.out.println("ERROR : " + e.getMessage());
		e.printStackTrace();
	}

}
