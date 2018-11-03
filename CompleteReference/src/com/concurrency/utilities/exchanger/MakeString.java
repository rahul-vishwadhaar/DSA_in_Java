package com.concurrency.utilities.exchanger;

import java.util.concurrent.Exchanger;

public class MakeString implements Runnable {

	Exchanger<String> ex;
	String str;

	MakeString(Exchanger<String> ex) {
		this.ex = ex;
		str = new String();

		new Thread(this).start();
	}

	public void run() {

		char ch = 'a';

		for (int i = 0; i < 3; i++) {

			for (int j = 0; j < 5; j++) {
				str += ch++;
			}

			try {
				str = ex.exchange(str);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
