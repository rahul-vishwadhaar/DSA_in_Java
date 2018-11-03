/**
 * 
 */
package com.fcs.utils;

import java.io.Console;
import java.util.Scanner;

/**
 * @author rahul kumar
 * 
 */
public class IOUtils {

	private static Scanner in;
	private static Console console;
	static {
		in = new Scanner(System.in);
		console = System.console();
	}

	public static String getString() {
		return in.next();
	}

	public static char[] getPassword() {
		if (console != null) {
			console.flush();
			return console.readPassword();
		} else {
			return in.next().toCharArray();
		}

	}

	public static void println(String input) {
		System.out.println(input);
	}

	public static void print(String input) {
		System.out.print(input);
	}

	public static int getInt() {
		return in.nextInt();
	}

	public static String getLine() {
		in.reset();
		return in.nextLine();

	}

	public static long getLong() {
		return in.nextLong();
	}

}
