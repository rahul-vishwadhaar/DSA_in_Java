package com.wallet.utils;

import java.io.Console;
import java.io.IOException;
import java.util.Scanner;

public class IOHandler {

	private static Scanner in = null;

	public static void init() {
		if (in == null)
			in = new Scanner(System.in);

	}

	public static int getInputInteger() {
		init();
		return in.nextInt();
	}

	public static String getPassword() {
		init();
		return in.next();
	}

	public static void closeInputReader() {
		in.close();

	}

	public static String getString() {
		init();
		String input = null;
		try {
			input = in.next();
		} catch (Exception e) {
			System.out.println("Invalid Input\n");
			input = in.next();
		}
		return input;
	}

	public static long getLong() {
		init();
		return in.nextLong();
	}

}
