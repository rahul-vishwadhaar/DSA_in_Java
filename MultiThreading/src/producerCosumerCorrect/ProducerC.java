package producerCosumerCorrect;

public class ProducerC implements Runnable {

	Q q;

	ProducerC(Q q) {
		this.q = q;
		new Thread(this, "Producer").start();

		System.out.println("Producer start");
	}

	public void run() {
		int i = 0;

		while (i < 10) {
			q.setN(i);
			i++;
		}
	}

}
