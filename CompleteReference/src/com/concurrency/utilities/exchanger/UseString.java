package com.concurrency.utilities.exchanger;

import java.util.concurrent.Exchanger;

public class UseString implements Runnable {
	Exchanger<String> ex;

	UseString(Exchanger<String> ex) {
		this.ex = ex;

		new Thread(this).start();
	}

	public void run() {
		String str;
		for (int i = 0; i < 3; i++) {
			try {
				str = ex.exchange(new String());
				System.out.println("Received String :" + str);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}
}
