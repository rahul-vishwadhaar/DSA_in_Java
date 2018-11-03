package com.test;

import java.util.Scanner;

public class Profile implements Runnable {
	public static void main(String[] args) {
		Thread t = new Thread();
		t.start();

		Scanner in = new Scanner(System.in);

	}

	public void run() {
		System.out.println("test");
	}

}
