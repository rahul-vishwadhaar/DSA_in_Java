package producerCosumerCorrect;

public class ConsumerC implements Runnable {

	Q q = null;

	ConsumerC(Q q) {
		this.q = q;
		Thread t = new Thread(this, "Consumer");
		t.start();
		System.out.println("Consumer start");
	}

	public void run() {

		while (true) {
			System.out.println(q.getN());
		}

	}

}
